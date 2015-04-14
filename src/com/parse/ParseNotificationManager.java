package com.parse;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseIntArray;
import java.util.concurrent.atomic.AtomicInteger;

class ParseNotificationManager
{
  public static final String TAG = "com.parse.ParseNotificationManager";
  private SparseIntArray iconIds = new SparseIntArray();
  private final Object lock = new Object();
  private final AtomicInteger notificationCount = new AtomicInteger(0);
  private volatile boolean shouldShowNotifications = true;
  
  public static ParseNotificationManager getInstance()
  {
    return ParseNotificationManager.Singleton.access$000();
  }
  
  public Notification createNotification(Context paramContext, String paramString1, String paramString2, Class<? extends Activity> paramClass, int paramInt, Bundle paramBundle)
  {
    Notification localNotification = null;
    if (!isValidIconId(paramContext, paramInt))
    {
      Parse.logE("com.parse.ParseNotificationManager", "Icon id " + paramInt + " is not a valid drawable. Trying to fall back to default app icon.");
      paramInt = ManifestInfo.getIconId();
    }
    if (paramInt == 0) {
      Parse.logE("com.parse.ParseNotificationManager", "Could not find a valid icon id for this app. This is required to create a Notification object to show in the status bar. Make sure that the <application> in in your Manifest.xml has a valid android:icon attribute.");
    }
    for (;;)
    {
      return localNotification;
      if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || (paramClass == null) || (paramInt == 0))
      {
        Parse.logE("com.parse.ParseNotificationManager", "Must specify non-null context, title, body, and activity class to show notification.");
      }
      else
      {
        long l = System.currentTimeMillis();
        ComponentName localComponentName = new ComponentName(paramContext, paramClass);
        Intent localIntent = new Intent();
        localIntent.setComponent(localComponentName);
        localIntent.setFlags(268435456);
        if (paramBundle != null) {
          localIntent.putExtras(paramBundle);
        }
        PendingIntent localPendingIntent = PendingIntent.getActivity(paramContext, (int)l, localIntent, 0);
        localNotification = new Notification(paramInt, paramString2, l);
        localNotification.flags = (0x10 | localNotification.flags);
        localNotification.defaults = (0xFFFFFFFF | localNotification.defaults);
        localNotification.setLatestEventInfo(paramContext, paramString1, paramString2, localPendingIntent);
      }
    }
  }
  
  public int getNotificationCount()
  {
    return this.notificationCount.get();
  }
  
  public boolean getShouldShowNotifications()
  {
    return this.shouldShowNotifications;
  }
  
  public boolean isValidIconId(Context paramContext, int paramInt)
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        i = this.iconIds.get(paramInt, -1);
        Resources localResources;
        Object localObject3;
        if (i == -1)
        {
          localResources = paramContext.getResources();
          localObject3 = null;
        }
        try
        {
          Drawable localDrawable = localResources.getDrawable(paramInt);
          localObject3 = localDrawable;
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          Object localObject4;
          boolean bool;
          continue;
        }
        localObject4 = this.lock;
        if (localObject3 == null) {
          i = 0;
        }
      }
      int i = 1;
      continue;
      bool = false;
    }
  }
  
  public void setShouldShowNotifications(boolean paramBoolean)
  {
    this.shouldShowNotifications = paramBoolean;
  }
  
  public void showNotification(Context paramContext, Notification paramNotification)
  {
    NotificationManager localNotificationManager;
    int i;
    if ((paramContext != null) && (paramNotification != null))
    {
      this.notificationCount.incrementAndGet();
      if ((this.shouldShowNotifications) && (paramContext != null) && (paramNotification != null))
      {
        localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
        i = (int)System.currentTimeMillis();
      }
    }
    try
    {
      localNotificationManager.notify(i, paramNotification);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        paramNotification.defaults = 5;
        localNotificationManager.notify(i, paramNotification);
      }
    }
  }
  
  public void showNotification(Context paramContext, String paramString1, String paramString2, Class<? extends Activity> paramClass, int paramInt, Bundle paramBundle)
  {
    showNotification(paramContext, createNotification(paramContext, paramString1, paramString2, paramClass, paramInt, paramBundle));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseNotificationManager
 * JD-Core Version:    0.7.0.1
 */