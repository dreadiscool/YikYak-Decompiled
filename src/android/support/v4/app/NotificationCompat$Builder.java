package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class NotificationCompat$Builder
{
  private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
  ArrayList<NotificationCompat.Action> mActions = new ArrayList();
  String mCategory;
  int mColor = 0;
  CharSequence mContentInfo;
  PendingIntent mContentIntent;
  CharSequence mContentText;
  CharSequence mContentTitle;
  Context mContext;
  Bundle mExtras;
  PendingIntent mFullScreenIntent;
  String mGroupKey;
  boolean mGroupSummary;
  Bitmap mLargeIcon;
  boolean mLocalOnly = false;
  Notification mNotification = new Notification();
  int mNumber;
  public ArrayList<String> mPeople;
  int mPriority;
  int mProgress;
  boolean mProgressIndeterminate;
  int mProgressMax;
  Notification mPublicVersion;
  boolean mShowWhen = true;
  String mSortKey;
  NotificationCompat.Style mStyle;
  CharSequence mSubText;
  RemoteViews mTickerView;
  boolean mUseChronometer;
  int mVisibility = 0;
  
  public NotificationCompat$Builder(Context paramContext)
  {
    this.mContext = paramContext;
    this.mNotification.when = System.currentTimeMillis();
    this.mNotification.audioStreamType = -1;
    this.mPriority = 0;
    this.mPeople = new ArrayList();
  }
  
  protected static CharSequence limitCharSequenceLength(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    for (;;)
    {
      return paramCharSequence;
      if (paramCharSequence.length() > 5120) {
        paramCharSequence = paramCharSequence.subSequence(0, 5120);
      }
    }
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
  
  public Builder addAction(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this.mActions.add(new NotificationCompat.Action(paramInt, paramCharSequence, paramPendingIntent));
    return this;
  }
  
  public Builder addAction(NotificationCompat.Action paramAction)
  {
    this.mActions.add(paramAction);
    return this;
  }
  
  public Builder addExtras(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (this.mExtras != null) {
        break label25;
      }
      this.mExtras = new Bundle(paramBundle);
    }
    for (;;)
    {
      return this;
      label25:
      this.mExtras.putAll(paramBundle);
    }
  }
  
  public Builder addPerson(String paramString)
  {
    this.mPeople.add(paramString);
    return this;
  }
  
  public Notification build()
  {
    return NotificationCompat.access$200().build(this);
  }
  
  public Builder extend(NotificationCompat.Extender paramExtender)
  {
    paramExtender.extend(this);
    return this;
  }
  
  public Bundle getExtras()
  {
    if (this.mExtras == null) {
      this.mExtras = new Bundle();
    }
    return this.mExtras;
  }
  
  @Deprecated
  public Notification getNotification()
  {
    return NotificationCompat.access$200().build(this);
  }
  
  public Builder setAutoCancel(boolean paramBoolean)
  {
    setFlag(16, paramBoolean);
    return this;
  }
  
  public Builder setCategory(String paramString)
  {
    this.mCategory = paramString;
    return this;
  }
  
  public Builder setColor(int paramInt)
  {
    this.mColor = paramInt;
    return this;
  }
  
  public Builder setContent(RemoteViews paramRemoteViews)
  {
    this.mNotification.contentView = paramRemoteViews;
    return this;
  }
  
  public Builder setContentInfo(CharSequence paramCharSequence)
  {
    this.mContentInfo = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public Builder setContentIntent(PendingIntent paramPendingIntent)
  {
    this.mContentIntent = paramPendingIntent;
    return this;
  }
  
  public Builder setContentText(CharSequence paramCharSequence)
  {
    this.mContentText = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public Builder setContentTitle(CharSequence paramCharSequence)
  {
    this.mContentTitle = limitCharSequenceLength(paramCharSequence);
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
  
  public Builder setExtras(Bundle paramBundle)
  {
    this.mExtras = paramBundle;
    return this;
  }
  
  public Builder setFullScreenIntent(PendingIntent paramPendingIntent, boolean paramBoolean)
  {
    this.mFullScreenIntent = paramPendingIntent;
    setFlag(128, paramBoolean);
    return this;
  }
  
  public Builder setGroup(String paramString)
  {
    this.mGroupKey = paramString;
    return this;
  }
  
  public Builder setGroupSummary(boolean paramBoolean)
  {
    this.mGroupSummary = paramBoolean;
    return this;
  }
  
  public Builder setLargeIcon(Bitmap paramBitmap)
  {
    this.mLargeIcon = paramBitmap;
    return this;
  }
  
  public Builder setLights(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    this.mNotification.ledARGB = paramInt1;
    this.mNotification.ledOnMS = paramInt2;
    this.mNotification.ledOffMS = paramInt3;
    int j;
    Notification localNotification;
    int k;
    if ((this.mNotification.ledOnMS != 0) && (this.mNotification.ledOffMS != 0))
    {
      j = i;
      localNotification = this.mNotification;
      k = 0xFFFFFFFE & this.mNotification.flags;
      if (j == 0) {
        break label92;
      }
    }
    for (;;)
    {
      localNotification.flags = (k | i);
      return this;
      j = 0;
      break;
      label92:
      i = 0;
    }
  }
  
  public Builder setLocalOnly(boolean paramBoolean)
  {
    this.mLocalOnly = paramBoolean;
    return this;
  }
  
  public Builder setNumber(int paramInt)
  {
    this.mNumber = paramInt;
    return this;
  }
  
  public Builder setOngoing(boolean paramBoolean)
  {
    setFlag(2, paramBoolean);
    return this;
  }
  
  public Builder setOnlyAlertOnce(boolean paramBoolean)
  {
    setFlag(8, paramBoolean);
    return this;
  }
  
  public Builder setPriority(int paramInt)
  {
    this.mPriority = paramInt;
    return this;
  }
  
  public Builder setProgress(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mProgressMax = paramInt1;
    this.mProgress = paramInt2;
    this.mProgressIndeterminate = paramBoolean;
    return this;
  }
  
  public Builder setPublicVersion(Notification paramNotification)
  {
    this.mPublicVersion = paramNotification;
    return this;
  }
  
  public Builder setShowWhen(boolean paramBoolean)
  {
    this.mShowWhen = paramBoolean;
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
  
  public Builder setSortKey(String paramString)
  {
    this.mSortKey = paramString;
    return this;
  }
  
  public Builder setSound(Uri paramUri)
  {
    this.mNotification.sound = paramUri;
    this.mNotification.audioStreamType = -1;
    return this;
  }
  
  public Builder setSound(Uri paramUri, int paramInt)
  {
    this.mNotification.sound = paramUri;
    this.mNotification.audioStreamType = paramInt;
    return this;
  }
  
  public Builder setStyle(NotificationCompat.Style paramStyle)
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
  
  public Builder setSubText(CharSequence paramCharSequence)
  {
    this.mSubText = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public Builder setTicker(CharSequence paramCharSequence)
  {
    this.mNotification.tickerText = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public Builder setTicker(CharSequence paramCharSequence, RemoteViews paramRemoteViews)
  {
    this.mNotification.tickerText = limitCharSequenceLength(paramCharSequence);
    this.mTickerView = paramRemoteViews;
    return this;
  }
  
  public Builder setUsesChronometer(boolean paramBoolean)
  {
    this.mUseChronometer = paramBoolean;
    return this;
  }
  
  public Builder setVibrate(long[] paramArrayOfLong)
  {
    this.mNotification.vibrate = paramArrayOfLong;
    return this;
  }
  
  public Builder setVisibility(int paramInt)
  {
    this.mVisibility = paramInt;
    return this;
  }
  
  public Builder setWhen(long paramLong)
  {
    this.mNotification.when = paramLong;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.Builder
 * JD-Core Version:    0.7.0.1
 */