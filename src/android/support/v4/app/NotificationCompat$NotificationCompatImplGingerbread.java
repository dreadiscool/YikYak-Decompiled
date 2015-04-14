package android.support.v4.app;

import android.app.Notification;

class NotificationCompat$NotificationCompatImplGingerbread
  extends NotificationCompat.NotificationCompatImplBase
{
  public Notification build(NotificationCompat.Builder paramBuilder)
  {
    Notification localNotification1 = paramBuilder.mNotification;
    localNotification1.setLatestEventInfo(paramBuilder.mContext, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentIntent);
    Notification localNotification2 = NotificationCompatGingerbread.add(localNotification1, paramBuilder.mContext, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent);
    if (paramBuilder.mPriority > 0) {
      localNotification2.flags = (0x80 | localNotification2.flags);
    }
    return localNotification2;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.NotificationCompatImplGingerbread
 * JD-Core Version:    0.7.0.1
 */