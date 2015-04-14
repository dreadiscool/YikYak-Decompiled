package com.parse;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;

public class NotificationCompat$Builder
{
  PendingIntent mContentIntent;
  CharSequence mContentText;
  CharSequence mContentTitle;
  Context mContext;
  Bitmap mLargeIcon;
  Notification mNotification = new Notification();
  int mPriority;
  NotificationCompat.Builder.Style mStyle;
  
  public NotificationCompat$Builder(Context paramContext)
  {
    this.mContext = paramContext;
    this.mNotification.when = System.currentTimeMillis();
    this.mNotification.audioStreamType = -1;
    this.mPriority = 0;
  }
  
  private void setFlag(int paramInt, boolean paramBoolean)
  {
    Notification localNotification2;
    if (paramBoolean) {
      localNotification2 = this.mNotification;
    }
    Notification localNotification1;
    for (localNotification2.flags = (paramInt | localNotification2.flags);; localNotification1.flags &= (paramInt ^ 0xFFFFFFFF))
    {
      return;
      localNotification1 = this.mNotification;
    }
  }
  
  public Notification build()
  {
    return NotificationCompat.access$000().build(this);
  }
  
  @Deprecated
  public Notification getNotification()
  {
    return NotificationCompat.access$000().build(this);
  }
  
  public Builder setAutoCancel(boolean paramBoolean)
  {
    setFlag(16, paramBoolean);
    return this;
  }
  
  public Builder setContentIntent(PendingIntent paramPendingIntent)
  {
    this.mContentIntent = paramPendingIntent;
    return this;
  }
  
  public Builder setContentText(CharSequence paramCharSequence)
  {
    this.mContentText = paramCharSequence;
    return this;
  }
  
  public Builder setContentTitle(CharSequence paramCharSequence)
  {
    this.mContentTitle = paramCharSequence;
    return this;
  }
  
  public Builder setDefaults(int paramInt)
  {
    this.mNotification.defaults = paramInt;
    if ((paramInt & 0x4) != 0)
    {
      Notification localNotification = this.mNotification;
      localNotification.flags = (0x1 | localNotification.flags);
    }
    return this;
  }
  
  public Builder setDeleteIntent(PendingIntent paramPendingIntent)
  {
    this.mNotification.deleteIntent = paramPendingIntent;
    return this;
  }
  
  public Builder setLargeIcon(Bitmap paramBitmap)
  {
    this.mLargeIcon = paramBitmap;
    return this;
  }
  
  public Builder setPriority(int paramInt)
  {
    this.mPriority = paramInt;
    return this;
  }
  
  public Builder setSmallIcon(int paramInt)
  {
    this.mNotification.icon = paramInt;
    return this;
  }
  
  public Builder setSmallIcon(int paramInt1, int paramInt2)
  {
    this.mNotification.icon = paramInt1;
    this.mNotification.iconLevel = paramInt2;
    return this;
  }
  
  public Builder setStyle(NotificationCompat.Builder.Style paramStyle)
  {
    if (this.mStyle != paramStyle)
    {
      this.mStyle = paramStyle;
      if (this.mStyle != null) {
        this.mStyle.setBuilder(this);
      }
    }
    return this;
  }
  
  public Builder setWhen(long paramLong)
  {
    this.mNotification.when = paramLong;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.NotificationCompat.Builder
 * JD-Core Version:    0.7.0.1
 */