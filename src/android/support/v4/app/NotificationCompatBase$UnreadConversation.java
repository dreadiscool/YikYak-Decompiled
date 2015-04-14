package android.support.v4.app;

import android.app.PendingIntent;

public abstract class NotificationCompatBase$UnreadConversation
{
  abstract long getLatestTimestamp();
  
  abstract String[] getMessages();
  
  abstract String getParticipant();
  
  abstract String[] getParticipants();
  
  abstract PendingIntent getReadPendingIntent();
  
  abstract RemoteInputCompatBase.RemoteInput getRemoteInput();
  
  abstract PendingIntent getReplyPendingIntent();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompatBase.UnreadConversation
 * JD-Core Version:    0.7.0.1
 */