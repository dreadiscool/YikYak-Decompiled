package android.support.v4.app;

import android.app.Notification;

class NotificationCompatSideChannelService$NotificationSideChannelStub
  extends INotificationSideChannel.Stub
{
  private NotificationCompatSideChannelService$NotificationSideChannelStub(NotificationCompatSideChannelService paramNotificationCompatSideChannelService) {}
  
  public void cancel(String paramString1, int paramInt, String paramString2)
  {
    NotificationCompatSideChannelService.access$100(this.this$0, getCallingUid(), paramString1);
    long l = clearCallingIdentity();
    try
    {
      this.this$0.cancel(paramString1, paramInt, paramString2);
      return;
    }
    finally
    {
      restoreCallingIdentity(l);
    }
  }
  
  public void cancelAll(String paramString)
  {
    NotificationCompatSideChannelService.access$100(this.this$0, getCallingUid(), paramString);
    long l = clearCallingIdentity();
    try
    {
      this.this$0.cancelAll(paramString);
      return;
    }
    finally
    {
      restoreCallingIdentity(l);
    }
  }
  
  public void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification)
  {
    NotificationCompatSideChannelService.access$100(this.this$0, getCallingUid(), paramString1);
    long l = clearCallingIdentity();
    try
    {
      this.this$0.notify(paramString1, paramInt, paramString2, paramNotification);
      return;
    }
    finally
    {
      restoreCallingIdentity(l);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompatSideChannelService.NotificationSideChannelStub
 * JD-Core Version:    0.7.0.1
 */