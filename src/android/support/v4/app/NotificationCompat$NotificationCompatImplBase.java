package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;

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
  
  public NotificationCompat.Action getAction(Notification paramNotification, int paramInt)
  {
    return null;
  }
  
  public int getActionCount(Notification paramNotification)
  {
    return 0;
  }
  
  public NotificationCompat.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> paramArrayList)
  {
    return null;
  }
  
  public Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation paramUnreadConversation)
  {
    return null;
  }
  
  public String getCategory(Notification paramNotification)
  {
    return null;
  }
  
  public Bundle getExtras(Notification paramNotification)
  {
    return null;
  }
  
  public String getGroup(Notification paramNotification)
  {
    return null;
  }
  
  public boolean getLocalOnly(Notification paramNotification)
  {
    return false;
  }
  
  public ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat.Action[] paramArrayOfAction)
  {
    return null;
  }
  
  public String getSortKey(Notification paramNotification)
  {
    return null;
  }
  
  public NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle paramBundle, NotificationCompatBase.UnreadConversation.Factory paramFactory, RemoteInputCompatBase.RemoteInput.Factory paramFactory1)
  {
    return null;
  }
  
  public boolean isGroupSummary(Notification paramNotification)
  {
    return false;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.NotificationCompatImplBase
 * JD-Core Version:    0.7.0.1
 */