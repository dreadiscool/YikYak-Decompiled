package android.support.v4.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.IBinder;

public abstract class NotificationCompatSideChannelService
  extends Service
{
  private void checkPermission(int paramInt, String paramString)
  {
    String[] arrayOfString = getPackageManager().getPackagesForUid(paramInt);
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++) {
      if (arrayOfString[j].equals(paramString)) {
        return;
      }
    }
    throw new SecurityException("NotificationSideChannelService: Uid " + paramInt + " is not authorized for package " + paramString);
  }
  
  public abstract void cancel(String paramString1, int paramInt, String paramString2);
  
  public abstract void cancelAll(String paramString);
  
  public abstract void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification);
  
  public IBinder onBind(Intent paramIntent)
  {
    Object localObject = null;
    if ((!paramIntent.getAction().equals("android.support.BIND_NOTIFICATION_SIDE_CHANNEL")) || (Build.VERSION.SDK_INT > 19)) {}
    for (;;)
    {
      return localObject;
      localObject = new NotificationCompatSideChannelService.NotificationSideChannelStub(this, null);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompatSideChannelService
 * JD-Core Version:    0.7.0.1
 */