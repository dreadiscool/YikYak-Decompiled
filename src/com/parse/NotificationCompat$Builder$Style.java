package com.parse;

import android.app.Notification;

public abstract class NotificationCompat$Builder$Style
{
  CharSequence mBigContentTitle;
  NotificationCompat.Builder mBuilder;
  CharSequence mSummaryText;
  boolean mSummaryTextSet = false;
  
  public Notification build()
  {
    Notification localNotification = null;
    if (this.mBuilder != null) {
      localNotification = this.mBuilder.build();
    }
    return localNotification;
  }
  
  public void setBuilder(NotificationCompat.Builder paramBuilder)
  {
    if (this.mBuilder != paramBuilder)
    {
      this.mBuilder = paramBuilder;
      if (this.mBuilder != null) {
        this.mBuilder.setStyle(this);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.NotificationCompat.Builder.Style
 * JD-Core Version:    0.7.0.1
 */