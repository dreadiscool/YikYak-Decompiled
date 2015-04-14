package com.squareup.picasso;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

class Dispatcher
{
  static final int AIRPLANE_MODE_CHANGE = 10;
  private static final int AIRPLANE_MODE_OFF = 0;
  private static final int AIRPLANE_MODE_ON = 1;
  private static final int BATCH_DELAY = 200;
  private static final String DISPATCHER_THREAD_NAME = "Dispatcher";
  static final int HUNTER_BATCH_COMPLETE = 8;
  static final int HUNTER_COMPLETE = 4;
  static final int HUNTER_DECODE_FAILED = 6;
  static final int HUNTER_DELAY_NEXT_BATCH = 7;
  static final int HUNTER_RETRY = 5;
  static final int NETWORK_STATE_CHANGE = 9;
  static final int REQUEST_CANCEL = 2;
  static final int REQUEST_GCED = 3;
  static final int REQUEST_SUBMIT = 1;
  private static final int RETRY_DELAY = 500;
  boolean airplaneMode;
  final List<BitmapHunter> batch;
  final Cache cache;
  final Context context;
  final Dispatcher.DispatcherThread dispatcherThread = new Dispatcher.DispatcherThread();
  final Downloader downloader;
  final Map<Object, Action> failedActions;
  final Handler handler;
  final Map<String, BitmapHunter> hunterMap;
  final Handler mainThreadHandler;
  final Dispatcher.NetworkBroadcastReceiver receiver;
  final boolean scansNetworkChanges;
  final ExecutorService service;
  final Stats stats;
  
  Dispatcher(Context paramContext, ExecutorService paramExecutorService, Handler paramHandler, Downloader paramDownloader, Cache paramCache, Stats paramStats)
  {
    this.dispatcherThread.start();
    this.context = paramContext;
    this.service = paramExecutorService;
    this.hunterMap = new LinkedHashMap();
    this.failedActions = new WeakHashMap();
    this.handler = new Dispatcher.DispatcherHandler(this.dispatcherThread.getLooper(), this);
    this.downloader = paramDownloader;
    this.mainThreadHandler = paramHandler;
    this.cache = paramCache;
    this.stats = paramStats;
    this.batch = new ArrayList(4);
    this.airplaneMode = Utils.isAirplaneModeOn(this.context);
    this.scansNetworkChanges = Utils.hasPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE");
    this.receiver = new Dispatcher.NetworkBroadcastReceiver(this);
    this.receiver.register();
  }
  
  private void batch(BitmapHunter paramBitmapHunter)
  {
    if (paramBitmapHunter.isCancelled()) {}
    for (;;)
    {
      return;
      this.batch.add(paramBitmapHunter);
      if (!this.handler.hasMessages(7)) {
        this.handler.sendEmptyMessageDelayed(7, 200L);
      }
    }
  }
  
  private void flushFailedActions()
  {
    if (!this.failedActions.isEmpty())
    {
      Iterator localIterator = this.failedActions.values().iterator();
      while (localIterator.hasNext())
      {
        Action localAction = (Action)localIterator.next();
        localIterator.remove();
        if (localAction.getPicasso().loggingEnabled) {
          Utils.log("Dispatcher", "replaying", localAction.getRequest().logId());
        }
        performSubmit(localAction);
      }
    }
  }
  
  private void logBatch(List<BitmapHunter> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      if (((BitmapHunter)paramList.get(0)).getPicasso().loggingEnabled)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          BitmapHunter localBitmapHunter = (BitmapHunter)localIterator.next();
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append(", ");
          }
          localStringBuilder.append(Utils.getLogIdsForHunter(localBitmapHunter));
        }
        Utils.log("Dispatcher", "delivered", localStringBuilder.toString());
      }
    }
  }
  
  private void markForReplay(Action paramAction)
  {
    Object localObject = paramAction.getTarget();
    if (localObject != null)
    {
      paramAction.willReplay = true;
      this.failedActions.put(localObject, paramAction);
    }
  }
  
  private void markForReplay(BitmapHunter paramBitmapHunter)
  {
    Action localAction = paramBitmapHunter.getAction();
    if (localAction != null) {
      markForReplay(localAction);
    }
    List localList = paramBitmapHunter.getActions();
    if (localList != null)
    {
      int i = localList.size();
      for (int j = 0; j < i; j++) {
        markForReplay((Action)localList.get(j));
      }
    }
  }
  
  void dispatchAirplaneModeChange(boolean paramBoolean)
  {
    Handler localHandler1 = this.handler;
    Handler localHandler2 = this.handler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localHandler1.sendMessage(localHandler2.obtainMessage(10, i, 0));
      return;
    }
  }
  
  void dispatchCancel(Action paramAction)
  {
    this.handler.sendMessage(this.handler.obtainMessage(2, paramAction));
  }
  
  void dispatchComplete(BitmapHunter paramBitmapHunter)
  {
    this.handler.sendMessage(this.handler.obtainMessage(4, paramBitmapHunter));
  }
  
  void dispatchFailed(BitmapHunter paramBitmapHunter)
  {
    this.handler.sendMessage(this.handler.obtainMessage(6, paramBitmapHunter));
  }
  
  void dispatchNetworkStateChange(NetworkInfo paramNetworkInfo)
  {
    this.handler.sendMessage(this.handler.obtainMessage(9, paramNetworkInfo));
  }
  
  void dispatchRetry(BitmapHunter paramBitmapHunter)
  {
    this.handler.sendMessageDelayed(this.handler.obtainMessage(5, paramBitmapHunter), 500L);
  }
  
  void dispatchSubmit(Action paramAction)
  {
    this.handler.sendMessage(this.handler.obtainMessage(1, paramAction));
  }
  
  void performAirplaneModeChange(boolean paramBoolean)
  {
    this.airplaneMode = paramBoolean;
  }
  
  void performBatchComplete()
  {
    ArrayList localArrayList = new ArrayList(this.batch);
    this.batch.clear();
    this.mainThreadHandler.sendMessage(this.mainThreadHandler.obtainMessage(8, localArrayList));
    logBatch(localArrayList);
  }
  
  void performCancel(Action paramAction)
  {
    String str = paramAction.getKey();
    BitmapHunter localBitmapHunter = (BitmapHunter)this.hunterMap.get(str);
    if (localBitmapHunter != null)
    {
      localBitmapHunter.detach(paramAction);
      if (localBitmapHunter.cancel())
      {
        this.hunterMap.remove(str);
        if (paramAction.getPicasso().loggingEnabled) {
          Utils.log("Dispatcher", "canceled", paramAction.getRequest().logId());
        }
      }
    }
    Action localAction = (Action)this.failedActions.remove(paramAction.getTarget());
    if ((localAction != null) && (localAction.getPicasso().loggingEnabled)) {
      Utils.log("Dispatcher", "canceled", localAction.getRequest().logId(), "from replaying");
    }
  }
  
  void performComplete(BitmapHunter paramBitmapHunter)
  {
    if (!paramBitmapHunter.shouldSkipMemoryCache()) {
      this.cache.set(paramBitmapHunter.getKey(), paramBitmapHunter.getResult());
    }
    this.hunterMap.remove(paramBitmapHunter.getKey());
    batch(paramBitmapHunter);
    if (paramBitmapHunter.getPicasso().loggingEnabled) {
      Utils.log("Dispatcher", "batched", Utils.getLogIdsForHunter(paramBitmapHunter), "for completion");
    }
  }
  
  void performError(BitmapHunter paramBitmapHunter, boolean paramBoolean)
  {
    String str1;
    StringBuilder localStringBuilder;
    if (paramBitmapHunter.getPicasso().loggingEnabled)
    {
      str1 = Utils.getLogIdsForHunter(paramBitmapHunter);
      localStringBuilder = new StringBuilder().append("for error");
      if (!paramBoolean) {
        break label80;
      }
    }
    label80:
    for (String str2 = " (will replay)";; str2 = "")
    {
      Utils.log("Dispatcher", "batched", str1, str2);
      this.hunterMap.remove(paramBitmapHunter.getKey());
      batch(paramBitmapHunter);
      return;
    }
  }
  
  void performNetworkStateChange(NetworkInfo paramNetworkInfo)
  {
    if ((this.service instanceof PicassoExecutorService)) {
      ((PicassoExecutorService)this.service).adjustThreadCount(paramNetworkInfo);
    }
    if ((paramNetworkInfo != null) && (paramNetworkInfo.isConnected())) {
      flushFailedActions();
    }
  }
  
  void performRetry(BitmapHunter paramBitmapHunter)
  {
    boolean bool1 = true;
    if (paramBitmapHunter.isCancelled()) {}
    for (;;)
    {
      return;
      if (!this.service.isShutdown()) {
        break;
      }
      performError(paramBitmapHunter, false);
    }
    if (this.scansNetworkChanges) {}
    for (NetworkInfo localNetworkInfo = ((ConnectivityManager)Utils.getService(this.context, "connectivity")).getActiveNetworkInfo();; localNetworkInfo = null)
    {
      boolean bool2;
      label69:
      boolean bool4;
      if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
      {
        bool2 = bool1;
        boolean bool3 = paramBitmapHunter.shouldRetry(this.airplaneMode, localNetworkInfo);
        bool4 = paramBitmapHunter.supportsReplay();
        if (bool3) {
          break label132;
        }
        if ((!this.scansNetworkChanges) || (!bool4)) {
          break label127;
        }
      }
      for (;;)
      {
        performError(paramBitmapHunter, bool1);
        if (!bool1) {
          break;
        }
        markForReplay(paramBitmapHunter);
        break;
        bool2 = false;
        break label69;
        label127:
        bool1 = false;
      }
      label132:
      if ((!this.scansNetworkChanges) || (bool2))
      {
        if (paramBitmapHunter.getPicasso().loggingEnabled) {
          Utils.log("Dispatcher", "retrying", Utils.getLogIdsForHunter(paramBitmapHunter));
        }
        paramBitmapHunter.future = this.service.submit(paramBitmapHunter);
        break;
      }
      performError(paramBitmapHunter, bool4);
      if (!bool4) {
        break;
      }
      markForReplay(paramBitmapHunter);
      break;
    }
  }
  
  void performSubmit(Action paramAction)
  {
    BitmapHunter localBitmapHunter1 = (BitmapHunter)this.hunterMap.get(paramAction.getKey());
    if (localBitmapHunter1 != null) {
      localBitmapHunter1.attach(paramAction);
    }
    for (;;)
    {
      return;
      if (this.service.isShutdown())
      {
        if (paramAction.getPicasso().loggingEnabled) {
          Utils.log("Dispatcher", "ignored", paramAction.request.logId(), "because shut down");
        }
      }
      else
      {
        BitmapHunter localBitmapHunter2 = BitmapHunter.forRequest(this.context, paramAction.getPicasso(), this, this.cache, this.stats, paramAction, this.downloader);
        localBitmapHunter2.future = this.service.submit(localBitmapHunter2);
        this.hunterMap.put(paramAction.getKey(), localBitmapHunter2);
        this.failedActions.remove(paramAction.getTarget());
        if (paramAction.getPicasso().loggingEnabled) {
          Utils.log("Dispatcher", "enqueued", paramAction.request.logId());
        }
      }
    }
  }
  
  void shutdown()
  {
    this.service.shutdown();
    this.dispatcherThread.quit();
    this.receiver.unregister();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Dispatcher
 * JD-Core Version:    0.7.0.1
 */