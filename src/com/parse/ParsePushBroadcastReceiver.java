package com.parse;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class ParsePushBroadcastReceiver
  extends BroadcastReceiver
{
  public static final String ACTION_PUSH_DELETE = "com.parse.push.intent.DELETE";
  public static final String ACTION_PUSH_OPEN = "com.parse.push.intent.OPEN";
  public static final String ACTION_PUSH_RECEIVE = "com.parse.push.intent.RECEIVE";
  public static final String KEY_PUSH_CHANNEL = "com.parse.Channel";
  public static final String KEY_PUSH_DATA = "com.parse.Data";
  public static final String PROPERTY_PUSH_ICON = "com.parse.push.notification_icon";
  protected static final int SMALL_NOTIFICATION_MAX_CHARACTER_LIMIT = 38;
  private static final String TAG = "com.parse.ParsePushReceiver";
  
  private JSONObject getPushData(Intent paramIntent)
  {
    try
    {
      localJSONObject = new JSONObject(paramIntent.getStringExtra("com.parse.Data"));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Parse.logE("com.parse.ParsePushReceiver", "Unexpected JSONException when receiving push data: ", localJSONException);
        JSONObject localJSONObject = null;
      }
    }
  }
  
  protected Class<? extends Activity> getActivity(Context paramContext, Intent paramIntent)
  {
    Object localObject = null;
    String str1 = Parse.applicationContext.getPackageName();
    Intent localIntent = Parse.applicationContext.getPackageManager().getLaunchIntentForPackage(str1);
    if (localIntent == null) {}
    for (;;)
    {
      return localObject;
      String str2 = localIntent.getComponent().getClassName();
      try
      {
        Class localClass = Class.forName(str2);
        localObject = localClass;
      }
      catch (ClassNotFoundException localClassNotFoundException) {}
    }
  }
  
  protected Bitmap getLargeIcon(Context paramContext, Intent paramIntent)
  {
    return null;
  }
  
  protected Notification getNotification(Context paramContext, Intent paramIntent)
  {
    JSONObject localJSONObject = getPushData(paramIntent);
    if ((localJSONObject == null) || ((!localJSONObject.has("alert")) && (!localJSONObject.has("title")))) {}
    NotificationCompat.Builder localBuilder;
    for (Notification localNotification = null;; localNotification = localBuilder.build())
    {
      return localNotification;
      String str1 = localJSONObject.optString("alert", "Notification received.");
      String str2 = localJSONObject.optString("title", ManifestInfo.getDisplayName());
      Bundle localBundle = paramIntent.getExtras();
      Random localRandom = new Random();
      int i = localRandom.nextInt();
      int j = localRandom.nextInt();
      String str3 = paramContext.getPackageName();
      Intent localIntent1 = new Intent("com.parse.push.intent.OPEN");
      localIntent1.putExtras(localBundle);
      localIntent1.setPackage(str3);
      Intent localIntent2 = new Intent("com.parse.push.intent.DELETE");
      localIntent2.putExtras(localBundle);
      localIntent2.setPackage(str3);
      PendingIntent localPendingIntent1 = PendingIntent.getBroadcast(paramContext, i, localIntent1, 134217728);
      PendingIntent localPendingIntent2 = PendingIntent.getBroadcast(paramContext, j, localIntent2, 134217728);
      localBuilder = new NotificationCompat.Builder(paramContext);
      localBuilder.setContentTitle(str2).setContentText(str1).setSmallIcon(getSmallIconId(paramContext, paramIntent)).setLargeIcon(getLargeIcon(paramContext, paramIntent)).setContentIntent(localPendingIntent1).setDeleteIntent(localPendingIntent2).setAutoCancel(true).setDefaults(-1);
      if ((str1 != null) && (str1.length() > 38)) {
        localBuilder.setStyle(new NotificationCompat.Builder.BigTextStyle().bigText(str1));
      }
    }
  }
  
  protected int getSmallIconId(Context paramContext, Intent paramIntent)
  {
    Bundle localBundle = ManifestInfo.getApplicationMetadata();
    int i = 0;
    if (localBundle != null) {
      i = localBundle.getInt("com.parse.push.notification_icon");
    }
    if (i != 0) {}
    for (;;)
    {
      return i;
      i = ManifestInfo.getIconId();
    }
  }
  
  protected void onPushDismiss(Context paramContext, Intent paramIntent) {}
  
  public void onPushOpen(Context paramContext, Intent paramIntent)
  {
    ParseAnalytics.trackAppOpened(paramIntent);
    Object localObject = null;
    try
    {
      String str = new JSONObject(paramIntent.getStringExtra("com.parse.Data")).optString("uri");
      localObject = str;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Class localClass;
        Parse.logE("com.parse.ParsePushReceiver", "Unexpected JSONException when receiving push data: ", localJSONException);
        continue;
        Intent localIntent = new Intent(paramContext, localClass);
        continue;
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        paramContext.startActivity(localIntent);
      }
    }
    localClass = getActivity(paramContext, paramIntent);
    if (localObject != null)
    {
      localIntent = new Intent("android.intent.action.VIEW", Uri.parse(localObject));
      localIntent.putExtras(paramIntent.getExtras());
      if (Build.VERSION.SDK_INT < 16) {
        break label112;
      }
      TaskStackBuilderHelper.startActivities(paramContext, localClass, localIntent);
    }
  }
  
  protected void onPushReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      localJSONObject = new JSONObject(paramIntent.getStringExtra("com.parse.Data"));
      if (localJSONObject != null)
      {
        str = localJSONObject.optString("action", null);
        if (str != null)
        {
          Bundle localBundle = paramIntent.getExtras();
          Intent localIntent = new Intent();
          localIntent.putExtras(localBundle);
          localIntent.setAction(str);
          localIntent.setPackage(paramContext.getPackageName());
          paramContext.sendBroadcast(localIntent);
        }
        Notification localNotification = getNotification(paramContext, paramIntent);
        if (localNotification != null) {
          ParseNotificationManager.getInstance().showNotification(paramContext, localNotification);
        }
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Parse.logE("com.parse.ParsePushReceiver", "Unexpected JSONException when receiving push data: ", localJSONException);
        JSONObject localJSONObject = null;
        continue;
        String str = null;
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ("com.parse.push.intent.RECEIVE".equals(str)) {
      onPushReceive(paramContext, paramIntent);
    }
    for (;;)
    {
      return;
      if ("com.parse.push.intent.DELETE".equals(str)) {
        onPushDismiss(paramContext, paramIntent);
      } else if ("com.parse.push.intent.OPEN".equals(str)) {
        onPushOpen(paramContext, paramIntent);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePushBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */