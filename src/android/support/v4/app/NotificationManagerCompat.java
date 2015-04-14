package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import java.util.HashSet;
import java.util.Set;

public class NotificationManagerCompat
{
  public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
  public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
  private static final NotificationManagerCompat.Impl IMPL;
  static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
  private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
  private static final int SIDE_CHANNEL_BIND_FLAGS = 0;
  private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
  private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
  private static final String TAG = "NotifManCompat";
  private static Set<String> sEnabledNotificationListenerPackages;
  private static String sEnabledNotificationListeners;
  private static final Object sEnabledNotificationListenersLock = new Object();
  private static final Object sLock;
  private static NotificationManagerCompat.SideChannelManager sSideChannelManager;
  private final Context mContext;
  private final NotificationManager mNotificationManager;
  
  static
  {
    sEnabledNotificationListenerPackages = new HashSet();
    sLock = new Object();
    if (Build.VERSION.SDK_INT >= 14) {
      IMPL = new NotificationManagerCompat.ImplIceCreamSandwich();
    }
    for (;;)
    {
      SIDE_CHANNEL_BIND_FLAGS = IMPL.getSideChannelBindFlags();
      return;
      if (Build.VERSION.SDK_INT >= 5) {
        IMPL = new NotificationManagerCompat.ImplEclair();
      } else {
        IMPL = new NotificationManagerCompat.ImplBase();
      }
    }
  }
  
  private NotificationManagerCompat(Context paramContext)
  {
    this.mContext = paramContext;
    this.mNotificationManager = ((NotificationManager)this.mContext.getSystemService("notification"));
  }
  
  public static NotificationManagerCompat from(Context paramContext)
  {
    return new NotificationManagerCompat(paramContext);
  }
  
  public static Set<String> getEnabledListenerPackages(Context paramContext)
  {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_notification_listeners");
    HashSet localHashSet;
    if ((str != null) && (!str.equals(sEnabledNotificationListeners)))
    {
      String[] arrayOfString = str.split(":");
      localHashSet = new HashSet(arrayOfString.length);
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        ComponentName localComponentName = ComponentName.unflattenFromString(arrayOfString[j]);
        if (localComponentName != null) {
          localHashSet.add(localComponentName.getPackageName());
        }
      }
    }
    synchronized (sEnabledNotificationListenersLock)
    {
      sEnabledNotificationListenerPackages = localHashSet;
      sEnabledNotificationListeners = str;
      return sEnabledNotificationListenerPackages;
    }
  }
  
  private void pushSideChannelQueue(NotificationManagerCompat.Task paramTask)
  {
    synchronized (sLock)
    {
      if (sSideChannelManager == null) {
        sSideChannelManager = new NotificationManagerCompat.SideChannelManager(this.mContext.getApplicationContext());
      }
      sSideChannelManager.queueTask(paramTask);
      return;
    }
  }
  
  private static boolean useSideChannelForNotification(Notification paramNotification)
  {
    Bundle localBundle = NotificationCompat.getExtras(paramNotification);
    if ((localBundle != null) && (localBundle.getBoolean("android.support.useSideChannel"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void cancel(int paramInt)
  {
    cancel(null, paramInt);
  }
  
  public void cancel(String paramString, int paramInt)
  {
    IMPL.cancelNotification(this.mNotificationManager, paramString, paramInt);
    if (Build.VERSION.SDK_INT <= 19) {
      pushSideChannelQueue(new NotificationManagerCompat.CancelTask(this.mContext.getPackageName(), paramInt, paramString));
    }
  }
  
  public void cancelAll()
  {
    this.mNotificationManager.cancelAll();
    if (Build.VERSION.SDK_INT <= 19) {
      pushSideChannelQueue(new NotificationManagerCompat.CancelTask(this.mContext.getPackageName()));
    }
  }
  
  public void notify(int paramInt, Notification paramNotification)
  {
    notify(null, paramInt, paramNotification);
  }
  
  public void notify(String paramString, int paramInt, Notification paramNotification)
  {
    if (useSideChannelForNotification(paramNotification))
    {
      pushSideChannelQueue(new NotificationManagerCompat.NotifyTask(this.mContext.getPackageName(), paramInt, paramString, paramNotification));
      IMPL.cancelNotification(this.mNotificationManager, paramString, paramInt);
    }
    for (;;)
    {
      return;
      IMPL.postNotification(this.mNotificationManager, paramString, paramInt, paramNotification);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationManagerCompat
 * JD-Core Version:    0.7.0.1
 */