package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;

class NotificationCompat$NotificationCompatImplKitKat
  extends NotificationCompat.NotificationCompatImplJellybean
{
  public Notification build(NotificationCompat.Builder paramBuilder)
  {
    NotificationCompatKitKat.Builder localBuilder = new NotificationCompatKitKat.Builder(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon, paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate, paramBuilder.mShowWhen, paramBuilder.mUseChronometer, paramBuilder.mPriority, paramBuilder.mSubText, paramBuilder.mLocalOnly, paramBuilder.mPeople, paramBuilder.mExtras, paramBuilder.mGroupKey, paramBuilder.mGroupSummary, paramBuilder.mSortKey);
    NotificationCompat.access$000(localBuilder, paramBuilder.mActions);
    NotificationCompat.access$100(localBuilder, paramBuilder.mStyle);
    return localBuilder.build();
  }
  
  public NotificationCompat.Action getAction(Notification paramNotification, int paramInt)
  {
    return (NotificationCompat.Action)NotificationCompatKitKat.getAction(paramNotification, paramInt, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
  }
  
  public int getActionCount(Notification paramNotification)
  {
    return NotificationCompatKitKat.getActionCount(paramNotification);
  }
  
  public Bundle getExtras(Notification paramNotification)
  {
    return NotificationCompatKitKat.getExtras(paramNotification);
  }
  
  public String getGroup(Notification paramNotification)
  {
    return NotificationCompatKitKat.getGroup(paramNotification);
  }
  
  public boolean getLocalOnly(Notification paramNotification)
  {
    return NotificationCompatKitKat.getLocalOnly(paramNotification);
  }
  
  public String getSortKey(Notification paramNotification)
  {
    return NotificationCompatKitKat.getSortKey(paramNotification);
  }
  
  public boolean isGroupSummary(Notification paramNotification)
  {
    return NotificationCompatKitKat.isGroupSummary(paramNotification);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.NotificationCompatImplKitKat
 * JD-Core Version:    0.7.0.1
 */