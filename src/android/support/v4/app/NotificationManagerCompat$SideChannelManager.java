package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class NotificationManagerCompat$SideChannelManager
  implements ServiceConnection, Handler.Callback
{
  private static final String KEY_BINDER = "binder";
  private static final int MSG_QUEUE_TASK = 0;
  private static final int MSG_RETRY_LISTENER_QUEUE = 3;
  private static final int MSG_SERVICE_CONNECTED = 1;
  private static final int MSG_SERVICE_DISCONNECTED = 2;
  private Set<String> mCachedEnabledPackages = new HashSet();
  private final Context mContext;
  private final Handler mHandler;
  private final HandlerThread mHandlerThread;
  private final Map<ComponentName, NotificationManagerCompat.SideChannelManager.ListenerRecord> mRecordMap = new HashMap();
  
  public NotificationManagerCompat$SideChannelManager(Context paramContext)
  {
    this.mContext = paramContext;
    this.mHandlerThread = new HandlerThread("NotificationManagerCompat");
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
  }
  
  private boolean ensureServiceBound(NotificationManagerCompat.SideChannelManager.ListenerRecord paramListenerRecord)
  {
    boolean bool;
    if (paramListenerRecord.bound)
    {
      bool = true;
      return bool;
    }
    Intent localIntent = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(paramListenerRecord.componentName);
    paramListenerRecord.bound = this.mContext.bindService(localIntent, this, NotificationManagerCompat.access$000());
    if (paramListenerRecord.bound) {
      paramListenerRecord.retryCount = 0;
    }
    for (;;)
    {
      bool = paramListenerRecord.bound;
      break;
      new StringBuilder().append("Unable to bind to listener ").append(paramListenerRecord.componentName).toString();
      this.mContext.unbindService(this);
    }
  }
  
  private void ensureServiceUnbound(NotificationManagerCompat.SideChannelManager.ListenerRecord paramListenerRecord)
  {
    if (paramListenerRecord.bound)
    {
      this.mContext.unbindService(this);
      paramListenerRecord.bound = false;
    }
    paramListenerRecord.service = null;
  }
  
  private void handleQueueTask(NotificationManagerCompat.Task paramTask)
  {
    updateListenerMap();
    Iterator localIterator = this.mRecordMap.values().iterator();
    while (localIterator.hasNext())
    {
      NotificationManagerCompat.SideChannelManager.ListenerRecord localListenerRecord = (NotificationManagerCompat.SideChannelManager.ListenerRecord)localIterator.next();
      localListenerRecord.taskQueue.add(paramTask);
      processListenerQueue(localListenerRecord);
    }
  }
  
  private void handleRetryListenerQueue(ComponentName paramComponentName)
  {
    NotificationManagerCompat.SideChannelManager.ListenerRecord localListenerRecord = (NotificationManagerCompat.SideChannelManager.ListenerRecord)this.mRecordMap.get(paramComponentName);
    if (localListenerRecord != null) {
      processListenerQueue(localListenerRecord);
    }
  }
  
  private void handleServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    NotificationManagerCompat.SideChannelManager.ListenerRecord localListenerRecord = (NotificationManagerCompat.SideChannelManager.ListenerRecord)this.mRecordMap.get(paramComponentName);
    if (localListenerRecord != null)
    {
      localListenerRecord.service = INotificationSideChannel.Stub.asInterface(paramIBinder);
      localListenerRecord.retryCount = 0;
      processListenerQueue(localListenerRecord);
    }
  }
  
  private void handleServiceDisconnected(ComponentName paramComponentName)
  {
    NotificationManagerCompat.SideChannelManager.ListenerRecord localListenerRecord = (NotificationManagerCompat.SideChannelManager.ListenerRecord)this.mRecordMap.get(paramComponentName);
    if (localListenerRecord != null) {
      ensureServiceUnbound(localListenerRecord);
    }
  }
  
  private void processListenerQueue(NotificationManagerCompat.SideChannelManager.ListenerRecord paramListenerRecord)
  {
    if (Log.isLoggable("NotifManCompat", 3)) {
      new StringBuilder().append("Processing component ").append(paramListenerRecord.componentName).append(", ").append(paramListenerRecord.taskQueue.size()).append(" queued tasks").toString();
    }
    if (paramListenerRecord.taskQueue.isEmpty()) {}
    for (;;)
    {
      return;
      if ((!ensureServiceBound(paramListenerRecord)) || (paramListenerRecord.service == null)) {
        scheduleListenerRetry(paramListenerRecord);
      }
      try
      {
        Object localObject;
        do
        {
          if (Log.isLoggable("NotifManCompat", 3)) {
            new StringBuilder().append("Sending task ").append(localObject).toString();
          }
          ((NotificationManagerCompat.Task)localObject).send(paramListenerRecord.service);
          paramListenerRecord.taskQueue.remove();
          localObject = (NotificationManagerCompat.Task)paramListenerRecord.taskQueue.peek();
        } while (localObject != null);
      }
      catch (DeadObjectException localDeadObjectException)
      {
        for (;;)
        {
          if (Log.isLoggable("NotifManCompat", 3)) {
            new StringBuilder().append("Remote service has died: ").append(paramListenerRecord.componentName).toString();
          }
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          new StringBuilder().append("RemoteException communicating with ").append(paramListenerRecord.componentName).toString();
        }
      }
      if (!paramListenerRecord.taskQueue.isEmpty()) {
        scheduleListenerRetry(paramListenerRecord);
      }
    }
  }
  
  private void scheduleListenerRetry(NotificationManagerCompat.SideChannelManager.ListenerRecord paramListenerRecord)
  {
    if (this.mHandler.hasMessages(3, paramListenerRecord.componentName)) {}
    for (;;)
    {
      return;
      paramListenerRecord.retryCount = (1 + paramListenerRecord.retryCount);
      if (paramListenerRecord.retryCount > 6)
      {
        new StringBuilder().append("Giving up on delivering ").append(paramListenerRecord.taskQueue.size()).append(" tasks to ").append(paramListenerRecord.componentName).append(" after ").append(paramListenerRecord.retryCount).append(" retries").toString();
        paramListenerRecord.taskQueue.clear();
      }
      else
      {
        int i = 1000 * (1 << -1 + paramListenerRecord.retryCount);
        if (Log.isLoggable("NotifManCompat", 3)) {
          new StringBuilder().append("Scheduling retry for ").append(i).append(" ms").toString();
        }
        Message localMessage = this.mHandler.obtainMessage(3, paramListenerRecord.componentName);
        this.mHandler.sendMessageDelayed(localMessage, i);
      }
    }
  }
  
  private void updateListenerMap()
  {
    Set localSet = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
    if (localSet.equals(this.mCachedEnabledPackages)) {}
    for (;;)
    {
      return;
      this.mCachedEnabledPackages = localSet;
      List localList = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
      HashSet localHashSet = new HashSet();
      Iterator localIterator1 = localList.iterator();
      while (localIterator1.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localIterator1.next();
        if (localSet.contains(localResolveInfo.serviceInfo.packageName))
        {
          ComponentName localComponentName2 = new ComponentName(localResolveInfo.serviceInfo.packageName, localResolveInfo.serviceInfo.name);
          if (localResolveInfo.serviceInfo.permission != null) {
            new StringBuilder().append("Permission present on component ").append(localComponentName2).append(", not adding listener record.").toString();
          } else {
            localHashSet.add(localComponentName2);
          }
        }
      }
      Iterator localIterator2 = localHashSet.iterator();
      while (localIterator2.hasNext())
      {
        ComponentName localComponentName1 = (ComponentName)localIterator2.next();
        if (!this.mRecordMap.containsKey(localComponentName1))
        {
          if (Log.isLoggable("NotifManCompat", 3)) {
            new StringBuilder().append("Adding listener record for ").append(localComponentName1).toString();
          }
          this.mRecordMap.put(localComponentName1, new NotificationManagerCompat.SideChannelManager.ListenerRecord(localComponentName1));
        }
      }
      Iterator localIterator3 = this.mRecordMap.entrySet().iterator();
      while (localIterator3.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator3.next();
        if (!localHashSet.contains(localEntry.getKey()))
        {
          if (Log.isLoggable("NotifManCompat", 3)) {
            new StringBuilder().append("Removing listener record for ").append(localEntry.getKey()).toString();
          }
          ensureServiceUnbound((NotificationManagerCompat.SideChannelManager.ListenerRecord)localEntry.getValue());
          localIterator3.remove();
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      handleQueueTask((NotificationManagerCompat.Task)paramMessage.obj);
      bool = true;
      continue;
      NotificationManagerCompat.ServiceConnectedEvent localServiceConnectedEvent = (NotificationManagerCompat.ServiceConnectedEvent)paramMessage.obj;
      handleServiceConnected(localServiceConnectedEvent.componentName, localServiceConnectedEvent.iBinder);
      bool = true;
      continue;
      handleServiceDisconnected((ComponentName)paramMessage.obj);
      bool = true;
      continue;
      handleRetryListenerQueue((ComponentName)paramMessage.obj);
      bool = true;
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (Log.isLoggable("NotifManCompat", 3)) {
      new StringBuilder().append("Connected to service ").append(paramComponentName).toString();
    }
    this.mHandler.obtainMessage(1, new NotificationManagerCompat.ServiceConnectedEvent(paramComponentName, paramIBinder)).sendToTarget();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (Log.isLoggable("NotifManCompat", 3)) {
      new StringBuilder().append("Disconnected from service ").append(paramComponentName).toString();
    }
    this.mHandler.obtainMessage(2, paramComponentName).sendToTarget();
  }
  
  public void queueTask(NotificationManagerCompat.Task paramTask)
  {
    this.mHandler.obtainMessage(0, paramTask).sendToTarget();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationManagerCompat.SideChannelManager
 * JD-Core Version:    0.7.0.1
 */