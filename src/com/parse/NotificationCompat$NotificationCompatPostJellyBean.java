package com.parse;

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;

class NotificationCompat$NotificationCompatPostJellyBean
  implements NotificationCompat.NotificationCompatImpl
{
  private Notification.Builder postJellyBeanBuilder;
  
  public Notification build(NotificationCompat.Builder paramBuilder)
  {
    this.postJellyBeanBuilder = new Notification.Builder(paramBuilder.mContext);
    Notification.Builder localBuilder = this.postJellyBeanBuilder.setContentTitle(paramBuilder.mContentTitle).setContentText(paramBuilder.mContentText).setSmallIcon(paramBuilder.mNotification.icon, paramBuilder.mNotification.iconLevel).setContentIntent(paramBuilder.mContentIntent).setDeleteIntent(paramBuilder.mNotification.deleteIntent);
    if ((0x10 & paramBuilder.mNotification.flags) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localBuilder.setAutoCancel(bool).setLargeIcon(paramBuilder.mLargeIcon).setDefaults(paramBuilder.mNotification.defaults);
      if ((paramBuilder.mStyle != null) && ((paramBuilder.mStyle instanceof NotificationCompat.Builder.BigTextStyle)))
      {
        NotificationCompat.Builder.BigTextStyle localBigTextStyle = (NotificationCompat.Builder.BigTextStyle)paramBuilder.mStyle;
        Notification.BigTextStyle localBigTextStyle1 = new Notification.BigTextStyle(this.postJellyBeanBuilder).setBigContentTitle(localBigTextStyle.mBigContentTitle).bigText(localBigTextStyle.mBigText);
        if (localBigTextStyle.mSummaryTextSet) {
          localBigTextStyle1.setSummaryText(localBigTextStyle.mSummaryText);
        }
      }
      return this.postJellyBeanBuilder.build();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.NotificationCompat.NotificationCompatPostJellyBean
 * JD-Core Version:    0.7.0.1
 */