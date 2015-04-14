package com.yik.yak.managers;

import ApplicationConfig;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat.Builder;
import com.parse.ParsePushBroadcastReceiver;
import com.yik.yak.YikYak;
import com.yik.yak.ui.activity.SplashScreen;

public class NotificationReceiver
  extends ParsePushBroadcastReceiver
{
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    SharedPreferences localSharedPreferences = ApplicationConfig.getSharedPreferences();
    boolean bool1 = localSharedPreferences.getBoolean("pushNotificationsEnabled", true);
    boolean bool2 = localSharedPreferences.getBoolean("audibleNotifications", true);
    if ((bool1) && (!paramString3.equals("reset_pin"))) {}
    try
    {
      int i = YikYak.incrementAndGetPendingNotifications();
      Intent localIntent2 = new Intent(paramContext, SplashScreen.class);
      localIntent2.setFlags(335544320);
      localIntent2.putExtra("action", 4000);
      localIntent2.putExtra("yakId", paramString1);
      localIntent2.putExtra("count", i);
      localIntent2.putExtra("key", paramString3);
      PendingIntent localPendingIntent2 = PendingIntent.getActivity(paramContext, 4004, localIntent2, 134217728);
      Object localObject;
      if (YikYak.getPendingNotifications() == 1) {
        localObject = paramString2;
      }
      for (;;)
      {
        NotificationCompat.Builder localBuilder2 = new NotificationCompat.Builder(paramContext);
        localBuilder2.setSmallIcon(2130837749);
        localBuilder2.setContentTitle("Yik Yak");
        localBuilder2.setContentText((CharSequence)localObject);
        localBuilder2.setNumber(i);
        localBuilder2.setAutoCancel(true);
        localBuilder2.setContentIntent(localPendingIntent2);
        if (bool2) {
          localBuilder2.setDefaults(7);
        }
        localNotificationManager.notify(1, localBuilder2.build());
        label224:
        if (paramString3.equals("reset_pin")) {}
        try
        {
          Intent localIntent1 = new Intent(paramContext, SplashScreen.class);
          localIntent1.setFlags(335544320);
          localIntent1.putExtra("action", 6005);
          PendingIntent localPendingIntent1 = PendingIntent.getActivity(paramContext, 4005, localIntent1, 1073741824);
          NotificationCompat.Builder localBuilder1 = new NotificationCompat.Builder(paramContext);
          localBuilder1.setSmallIcon(2130837749);
          localBuilder1.setContentTitle("Yik Yak");
          localBuilder1.setContentText(paramString2);
          localBuilder1.setNumber(1);
          localBuilder1.setAutoCancel(true);
          localBuilder1.setContentIntent(localPendingIntent1);
          if (bool2) {
            localBuilder1.setDefaults(7);
          }
          localNotificationManager.notify(1, localBuilder1.build());
          label357:
          return;
          String str = "You have " + String.valueOf(i) + " pending notifications.";
          localObject = str;
        }
        catch (Exception localException1)
        {
          break label357;
        }
      }
    }
    catch (Exception localException2)
    {
      break label224;
    }
  }
  
  public void onPushOpen(Context paramContext, Intent paramIntent) {}
  
  /* Error */
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: new 157	org/json/JSONObject
    //   3: dup
    //   4: aload_2
    //   5: invokevirtual 161	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   8: ldc 163
    //   10: invokevirtual 169	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13: invokespecial 172	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16: astore_3
    //   17: aload_0
    //   18: aload_1
    //   19: aload_3
    //   20: ldc 174
    //   22: invokevirtual 175	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: aload_3
    //   26: ldc 177
    //   28: invokevirtual 175	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: aload_3
    //   32: ldc 79
    //   34: invokevirtual 175	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokespecial 179	com/yik/yak/managers/NotificationReceiver:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   40: invokestatic 184	CU:b	()Z
    //   43: istore 5
    //   45: iload 5
    //   47: ifeq +16 -> 63
    //   50: aload_1
    //   51: new 54	android/content/Intent
    //   54: dup
    //   55: ldc 186
    //   57: invokespecial 187	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   60: invokevirtual 191	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   63: return
    //   64: astore 4
    //   66: goto -3 -> 63
    //   69: astore 6
    //   71: goto -8 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	NotificationReceiver
    //   0	74	1	paramContext	Context
    //   0	74	2	paramIntent	Intent
    //   16	16	3	localJSONObject	org.json.JSONObject
    //   64	1	4	localJSONException	org.json.JSONException
    //   43	3	5	bool	boolean
    //   69	1	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	45	64	org/json/JSONException
    //   50	63	64	org/json/JSONException
    //   50	63	69	java/lang/Exception
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.yik.yak.managers.NotificationReceiver

 * JD-Core Version:    0.7.0.1

 */