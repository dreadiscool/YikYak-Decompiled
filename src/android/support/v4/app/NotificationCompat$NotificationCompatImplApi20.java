package android.support.v4.app;

import android.app.Notification;
import android.os.Parcelable;
import java.util.ArrayList;

class NotificationCompat$NotificationCompatImplApi20
  extends NotificationCompat.NotificationCompatImplKitKat
{
  public Notification build(NotificationCompat.Builder paramBuilder)
  {
    NotificationCompatApi20.Builder localBuilder = new NotificationCompatApi20.Builder(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon, paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate, paramBuilder.mShowWhen, paramBuilder.mUseChronometer, paramBuilder.mPriority, paramBuilder.mSubText, paramBuilder.mLocalOnly, paramBuilder.mPeople, paramBuilder.mExtras, paramBuilder.mGroupKey, paramBuilder.mGroupSummary, paramBuilder.mSortKey);
    NotificationCompat.access$000(localBuilder, paramBuilder.mActions);
    NotificationCompat.access$100(localBuilder, paramBuilder.mStyle);
    return localBuilder.build();
  }
  
  public NotificationCompat.Action getAction(Notification paramNotification, int paramInt)
  {
    return (NotificationCompat.Action)NotificationCompatApi20.getAction(paramNotification, paramInt, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
  }
  
  public NotificationCompat.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> paramArrayList)
  {
    return (NotificationCompat.Action[])NotificationCompatApi20.getActionsFromParcelableArrayList(paramArrayList, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
  }
  
  public String getGroup(Notification paramNotification)
  {
    return NotificationCompatApi20.getGroup(paramNotification);
  }
  
  public boolean getLocalOnly(Notification paramNotification)
  {
    return NotificationCompatApi20.getLocalOnly(paramNotification);
  }
  
  public ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat.Action[] paramArrayOfAction)
  {
    return NotificationCompatApi20.getParcelableArrayListForActions(paramArrayOfAction);
  }
  
  public String getSortKey(Notification paramNotification)
  {
    return NotificationCompatApi20.getSortKey(paramNotification);
  }
  
  public boolean isGroupSummary(Notification paramNotification)
  {
    return NotificationCompatApi20.isGroupSummary(paramNotification);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.NotificationCompatImplApi20
 * JD-Core Version:    0.7.0.1
 */