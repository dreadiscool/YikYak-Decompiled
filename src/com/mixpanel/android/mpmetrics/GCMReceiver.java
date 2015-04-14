package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import uJ;
import uv;
import uw;
import ux;
import vd;
import vf;

public class GCMReceiver
  extends BroadcastReceiver
{
  @TargetApi(9)
  private Notification a(Context paramContext, PendingIntent paramPendingIntent, ux paramux)
  {
    Notification localNotification = new Notification(paramux.a, paramux.c, System.currentTimeMillis());
    localNotification.flags = (0x10 | localNotification.flags);
    localNotification.setLatestEventInfo(paramContext, paramux.b, paramux.c, paramPendingIntent);
    return localNotification;
  }
  
  private Intent a(Context paramContext, String paramString)
  {
    if (paramString != null) {}
    for (Uri localUri = Uri.parse(paramString);; localUri = null)
    {
      if (localUri == null) {}
      for (Intent localIntent = a(paramContext);; localIntent = new Intent("android.intent.action.VIEW", localUri)) {
        return localIntent;
      }
    }
  }
  
  private void a(Context paramContext, Intent paramIntent)
  {
    String str = uJ.a(paramContext).q();
    if (str == null) {
      str = paramContext.getPackageName();
    }
    vf localvf = new vf(str, paramContext);
    Notification localNotification = b(paramContext.getApplicationContext(), paramIntent, localvf);
    if (localNotification != null) {
      ((NotificationManager)paramContext.getSystemService("notification")).notify(0, localNotification);
    }
  }
  
  private void a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("registration_id");
    if (paramIntent.getStringExtra("error") != null) {
      new StringBuilder().append("Error when registering for GCM: ").append(paramIntent.getStringExtra("error")).toString();
    }
    for (;;)
    {
      return;
      if (str != null)
      {
        if (uJ.a) {
          new StringBuilder().append("Registering GCM ID: ").append(str).toString();
        }
        MixpanelAPI.allInstances(new uv(this, str));
      }
      else if (paramIntent.getStringExtra("unregistered") != null)
      {
        MixpanelAPI.allInstances(new uw(this));
      }
    }
  }
  
  @TargetApi(11)
  private Notification b(Context paramContext, PendingIntent paramPendingIntent, ux paramux)
  {
    Notification localNotification = new Notification.Builder(paramContext).setSmallIcon(paramux.a).setTicker(paramux.c).setWhen(System.currentTimeMillis()).setContentTitle(paramux.b).setContentText(paramux.c).setContentIntent(paramPendingIntent).getNotification();
    localNotification.flags = (0x10 | localNotification.flags);
    return localNotification;
  }
  
  private Notification b(Context paramContext, Intent paramIntent, vd paramvd)
  {
    ux localux = a(paramContext, paramIntent, paramvd);
    Notification localNotification;
    if (localux == null) {
      localNotification = null;
    }
    for (;;)
    {
      return localNotification;
      if (uJ.a) {
        new StringBuilder().append("MP GCM notification received: ").append(localux.c).toString();
      }
      PendingIntent localPendingIntent = PendingIntent.getActivity(paramContext, 0, localux.d, 134217728);
      if (Build.VERSION.SDK_INT >= 16) {
        localNotification = c(paramContext, localPendingIntent, localux);
      } else if (Build.VERSION.SDK_INT >= 11) {
        localNotification = b(paramContext, localPendingIntent, localux);
      } else {
        localNotification = a(paramContext, localPendingIntent, localux);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  private Notification c(Context paramContext, PendingIntent paramPendingIntent, ux paramux)
  {
    Notification localNotification = new Notification.Builder(paramContext).setSmallIcon(paramux.a).setTicker(paramux.c).setWhen(System.currentTimeMillis()).setContentTitle(paramux.b).setContentText(paramux.c).setContentIntent(paramPendingIntent).setStyle(new Notification.BigTextStyle().bigText(paramux.c)).build();
    localNotification.flags = (0x10 | localNotification.flags);
    return localNotification;
  }
  
  Intent a(Context paramContext)
  {
    return paramContext.getPackageManager().getLaunchIntentForPackage(paramContext.getPackageName());
  }
  
  ux a(Context paramContext, Intent paramIntent, vd paramvd)
  {
    ux localux = null;
    PackageManager localPackageManager = paramContext.getPackageManager();
    String str1 = paramIntent.getStringExtra("mp_message");
    String str2 = paramIntent.getStringExtra("mp_icnm");
    String str3 = paramIntent.getStringExtra("mp_cta");
    Object localObject = paramIntent.getStringExtra("mp_title");
    if (str1 == null) {
      return localux;
    }
    if ((str2 != null) && (paramvd.a(str2))) {}
    for (int i = paramvd.b(str2);; i = -1)
    {
      try
      {
        ApplicationInfo localApplicationInfo2 = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
        localApplicationInfo1 = localApplicationInfo2;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          ApplicationInfo localApplicationInfo1 = null;
        }
      }
      if ((i == -1) && (localApplicationInfo1 != null)) {
        i = localApplicationInfo1.icon;
      }
      if (i == -1) {
        i = 17301651;
      }
      if ((localObject == null) && (localApplicationInfo1 != null)) {
        localObject = localPackageManager.getApplicationLabel(localApplicationInfo1);
      }
      if (localObject == null) {
        localObject = "A message for you";
      }
      localux = new ux(i, (CharSequence)localObject, str1, a(paramContext, str3), null);
      break;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ("com.google.android.c2dm.intent.REGISTRATION".equals(str)) {
      a(paramIntent);
    }
    for (;;)
    {
      return;
      if ("com.google.android.c2dm.intent.RECEIVE".equals(str)) {
        a(paramContext, paramIntent);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.GCMReceiver
 * JD-Core Version:    0.7.0.1
 */