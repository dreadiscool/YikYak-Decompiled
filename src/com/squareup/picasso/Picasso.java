package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.RemoteViews;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class Picasso
{
  static final Handler HANDLER = new Picasso.1(Looper.getMainLooper());
  static final String TAG = "Picasso";
  static Picasso singleton = null;
  final Cache cache;
  private final Picasso.CleanupThread cleanupThread;
  final Context context;
  final Dispatcher dispatcher;
  boolean indicatorsEnabled;
  private final Picasso.Listener listener;
  volatile boolean loggingEnabled;
  final ReferenceQueue<Object> referenceQueue;
  private final Picasso.RequestTransformer requestTransformer;
  boolean shutdown;
  final Stats stats;
  final Map<Object, Action> targetToAction;
  final Map<ImageView, DeferredRequestCreator> targetToDeferredRequestCreator;
  
  Picasso(Context paramContext, Dispatcher paramDispatcher, Cache paramCache, Picasso.Listener paramListener, Picasso.RequestTransformer paramRequestTransformer, Stats paramStats, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.context = paramContext;
    this.dispatcher = paramDispatcher;
    this.cache = paramCache;
    this.listener = paramListener;
    this.requestTransformer = paramRequestTransformer;
    this.stats = paramStats;
    this.targetToAction = new WeakHashMap();
    this.targetToDeferredRequestCreator = new WeakHashMap();
    this.indicatorsEnabled = paramBoolean1;
    this.loggingEnabled = paramBoolean2;
    this.referenceQueue = new ReferenceQueue();
    this.cleanupThread = new Picasso.CleanupThread(this.referenceQueue, HANDLER);
    this.cleanupThread.start();
  }
  
  private void cancelExistingRequest(Object paramObject)
  {
    Utils.checkMain();
    Action localAction = (Action)this.targetToAction.remove(paramObject);
    if (localAction != null)
    {
      localAction.cancel();
      this.dispatcher.dispatchCancel(localAction);
    }
    if ((paramObject instanceof ImageView))
    {
      ImageView localImageView = (ImageView)paramObject;
      DeferredRequestCreator localDeferredRequestCreator = (DeferredRequestCreator)this.targetToDeferredRequestCreator.remove(localImageView);
      if (localDeferredRequestCreator != null) {
        localDeferredRequestCreator.cancel();
      }
    }
  }
  
  private void deliverAction(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom, Action paramAction)
  {
    if (paramAction.isCancelled()) {}
    for (;;)
    {
      return;
      if (!paramAction.willReplay()) {
        this.targetToAction.remove(paramAction.getTarget());
      }
      if (paramBitmap != null)
      {
        if (paramLoadedFrom == null) {
          throw new AssertionError("LoadedFrom cannot be null.");
        }
        paramAction.complete(paramBitmap, paramLoadedFrom);
        if (this.loggingEnabled) {
          Utils.log("Main", "completed", paramAction.request.logId(), "from " + paramLoadedFrom);
        }
      }
      else
      {
        paramAction.error();
        if (this.loggingEnabled) {
          Utils.log("Main", "errored", paramAction.request.logId());
        }
      }
    }
  }
  
  public static Picasso with(Context paramContext)
  {
    if (singleton == null) {}
    try
    {
      if (singleton == null) {
        singleton = new Picasso.Builder(paramContext).build();
      }
      return singleton;
    }
    finally {}
  }
  
  public boolean areIndicatorsEnabled()
  {
    return this.indicatorsEnabled;
  }
  
  public void cancelRequest(ImageView paramImageView)
  {
    cancelExistingRequest(paramImageView);
  }
  
  public void cancelRequest(RemoteViews paramRemoteViews, int paramInt)
  {
    cancelExistingRequest(new RemoteViewsAction.RemoteViewsTarget(paramRemoteViews, paramInt));
  }
  
  public void cancelRequest(Target paramTarget)
  {
    cancelExistingRequest(paramTarget);
  }
  
  void complete(BitmapHunter paramBitmapHunter)
  {
    int i = 1;
    Action localAction = paramBitmapHunter.getAction();
    List localList = paramBitmapHunter.getActions();
    int j;
    if ((localList != null) && (!localList.isEmpty()))
    {
      j = i;
      if ((localAction == null) && (j == 0)) {
        break label51;
      }
      label40:
      if (i != 0) {
        break label56;
      }
    }
    for (;;)
    {
      return;
      j = 0;
      break;
      label51:
      i = 0;
      break label40;
      label56:
      Uri localUri = paramBitmapHunter.getData().uri;
      Exception localException = paramBitmapHunter.getException();
      Bitmap localBitmap = paramBitmapHunter.getResult();
      Picasso.LoadedFrom localLoadedFrom = paramBitmapHunter.getLoadedFrom();
      if (localAction != null) {
        deliverAction(localBitmap, localLoadedFrom, localAction);
      }
      if (j != 0)
      {
        int k = localList.size();
        for (int m = 0; m < k; m++) {
          deliverAction(localBitmap, localLoadedFrom, (Action)localList.get(m));
        }
      }
      if ((this.listener != null) && (localException != null)) {
        this.listener.onImageLoadFailed(this, localUri, localException);
      }
    }
  }
  
  void defer(ImageView paramImageView, DeferredRequestCreator paramDeferredRequestCreator)
  {
    this.targetToDeferredRequestCreator.put(paramImageView, paramDeferredRequestCreator);
  }
  
  void enqueueAndSubmit(Action paramAction)
  {
    Object localObject = paramAction.getTarget();
    if (localObject != null)
    {
      cancelExistingRequest(localObject);
      this.targetToAction.put(localObject, paramAction);
    }
    submit(paramAction);
  }
  
  public StatsSnapshot getSnapshot()
  {
    return this.stats.createSnapshot();
  }
  
  @Deprecated
  public boolean isDebugging()
  {
    if ((areIndicatorsEnabled()) && (isLoggingEnabled())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isLoggingEnabled()
  {
    return this.loggingEnabled;
  }
  
  public RequestCreator load(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Resource ID must not be zero.");
    }
    return new RequestCreator(this, null, paramInt);
  }
  
  public RequestCreator load(Uri paramUri)
  {
    return new RequestCreator(this, paramUri, 0);
  }
  
  public RequestCreator load(File paramFile)
  {
    if (paramFile == null) {}
    for (RequestCreator localRequestCreator = new RequestCreator(this, null, 0);; localRequestCreator = load(Uri.fromFile(paramFile))) {
      return localRequestCreator;
    }
  }
  
  public RequestCreator load(String paramString)
  {
    if (paramString == null) {}
    for (RequestCreator localRequestCreator = new RequestCreator(this, null, 0);; localRequestCreator = load(Uri.parse(paramString)))
    {
      return localRequestCreator;
      if (paramString.trim().length() == 0) {
        throw new IllegalArgumentException("Path must not be empty.");
      }
    }
  }
  
  Bitmap quickMemoryCacheCheck(String paramString)
  {
    Bitmap localBitmap = this.cache.get(paramString);
    if (localBitmap != null) {
      this.stats.dispatchCacheHit();
    }
    for (;;)
    {
      return localBitmap;
      this.stats.dispatchCacheMiss();
    }
  }
  
  @Deprecated
  public void setDebugging(boolean paramBoolean)
  {
    setIndicatorsEnabled(paramBoolean);
  }
  
  public void setIndicatorsEnabled(boolean paramBoolean)
  {
    this.indicatorsEnabled = paramBoolean;
  }
  
  public void setLoggingEnabled(boolean paramBoolean)
  {
    this.loggingEnabled = paramBoolean;
  }
  
  public void shutdown()
  {
    if (this == singleton) {
      throw new UnsupportedOperationException("Default singleton instance cannot be shutdown.");
    }
    if (this.shutdown) {}
    for (;;)
    {
      return;
      this.cache.clear();
      this.cleanupThread.shutdown();
      this.stats.shutdown();
      this.dispatcher.shutdown();
      Iterator localIterator = this.targetToDeferredRequestCreator.values().iterator();
      while (localIterator.hasNext()) {
        ((DeferredRequestCreator)localIterator.next()).cancel();
      }
      this.targetToDeferredRequestCreator.clear();
      this.shutdown = true;
    }
  }
  
  void submit(Action paramAction)
  {
    this.dispatcher.dispatchSubmit(paramAction);
  }
  
  Request transformRequest(Request paramRequest)
  {
    Request localRequest = this.requestTransformer.transformRequest(paramRequest);
    if (localRequest == null) {
      throw new IllegalStateException("Request transformer " + this.requestTransformer.getClass().getCanonicalName() + " returned null for " + paramRequest);
    }
    return localRequest;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Picasso
 * JD-Core Version:    0.7.0.1
 */