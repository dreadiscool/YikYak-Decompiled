package com.parse;

import android.app.Notification;

class NotificationCompat$NotificationCompatImplBase
  implements NotificationCompat.NotificationCompatImpl
{
  public Notification build(NotificationCompat.Builder paramBuilder)
  {
    Notification localNotification = paramBuilder.mNotification;
    localNotification.setLatestEventInfo(paramBuilder.mContext, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentIntent);
    if (paramBuilder.mPriority > 0) {
      localNotification.flags = (0x80 | localNotification.flags);
    }
    return localNotification;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.NotificationCompat.NotificationCompatImplBase
 * JD-Core Version:    0.7.0.1
 */