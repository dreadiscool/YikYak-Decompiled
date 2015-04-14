package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;

class NotificationCompat$NotificationCompatImplApi21
  extends NotificationCompat.NotificationCompatImplApi20
{
  public Notification build(NotificationCompat.Builder paramBuilder)
  {
    NotificationCompatApi21.Builder localBuilder = new NotificationCompatApi21.Builder(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon, paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate, paramBuilder.mShowWhen, paramBuilder.mUseChronometer, paramBuilder.mPriority, paramBuilder.mSubText, paramBuilder.mLocalOnly, paramBuilder.mCategory, paramBuilder.mPeople, paramBuilder.mExtras, paramBuilder.mColor, paramBuilder.mVisibility, paramBuilder.mPublicVersion, paramBuilder.mGroupKey, paramBuilder.mGroupSummary, paramBuilder.mSortKey);
    NotificationCompat.access$000(localBuilder, paramBuilder.mActions);
    NotificationCompat.access$100(localBuilder, paramBuilder.mStyle);
    return localBuilder.build();
  }
  
  public Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation paramUnreadConversation)
  {
    return NotificationCompatApi21.getBundleForUnreadConversation(paramUnreadConversation);
  }
  
  public String getCategory(Notification paramNotification)
  {
    return NotificationCompatApi21.getCategory(paramNotification);
  }
  
  public NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle paramBundle, NotificationCompatBase.UnreadConversation.Factory paramFactory, RemoteInputCompatBase.RemoteInput.Factory paramFactory1)
  {
    return NotificationCompatApi21.getUnreadConversationFromBundle(paramBundle, paramFactory, paramFactory1);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.NotificationCompatImplApi21
 * JD-Core Version:    0.7.0.1
 */