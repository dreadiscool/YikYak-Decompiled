package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;

class NotificationCompat$NotificationCompatImplJellybean
  extends NotificationCompat.NotificationCompatImplBase
{
  public Notification build(NotificationCompat.Builder paramBuilder)
  {
    NotificationCompatJellybean.Builder localBuilder = new NotificationCompatJellybean.Builder(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon, paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate, paramBuilder.mUseChronometer, paramBuilder.mPriority, paramBuilder.mSubText, paramBuilder.mLocalOnly, paramBuilder.mExtras, paramBuilder.mGroupKey, paramBuilder.mGroupSummary, paramBuilder.mSortKey);
    NotificationCompat.access$000(localBuilder, paramBuilder.mActions);
    NotificationCompat.access$100(localBuilder, paramBuilder.mStyle);
    return localBuilder.build();
  }
  
  public NotificationCompat.Action getAction(Notification paramNotification, int paramInt)
  {
    return (NotificationCompat.Action)NotificationCompatJellybean.getAction(paramNotification, paramInt, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
  }
  
  public int getActionCount(Notification paramNotification)
  {
    return NotificationCompatJellybean.getActionCount(paramNotification);
  }
  
  public NotificationCompat.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> paramArrayList)
  {
    return (NotificationCompat.Action[])NotificationCompatJellybean.getActionsFromParcelableArrayList(paramArrayList, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
  }
  
  public Bundle getExtras(Notification paramNotification)
  {
    return NotificationCompatJellybean.getExtras(paramNotification);
  }
  
  public String getGroup(Notification paramNotification)
  {
    return NotificationCompatJellybean.getGroup(paramNotification);
  }
  
  public boolean getLocalOnly(Notification paramNotification)
  {
    return NotificationCompatJellybean.getLocalOnly(paramNotification);
  }
  
  public ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat.Action[] paramArrayOfAction)
  {
    return NotificationCompatJellybean.getParcelableArrayListForActions(paramArrayOfAction);
  }
  
  public String getSortKey(Notification paramNotification)
  {
    return NotificationCompatJellybean.getSortKey(paramNotification);
  }
  
  public boolean isGroupSummary(Notification paramNotification)
  {
    return NotificationCompatJellybean.isGroupSummary(paramNotification);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean
 * JD-Core Version:    0.7.0.1
 */