package android.support.v4.app;

import android.app.PendingIntent;

public class NotificationCompat$CarExtender$UnreadConversation
  extends NotificationCompatBase.UnreadConversation
{
  static final NotificationCompatBase.UnreadConversation.Factory FACTORY = new NotificationCompat.CarExtender.UnreadConversation.1();
  private final long mLatestTimestamp;
  private final String[] mMessages;
  private final String[] mParticipants;
  private final PendingIntent mReadPendingIntent;
  private final RemoteInput mRemoteInput;
  private final PendingIntent mReplyPendingIntent;
  
  NotificationCompat$CarExtender$UnreadConversation(String[] paramArrayOfString1, RemoteInput paramRemoteInput, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String[] paramArrayOfString2, long paramLong)
  {
    this.mMessages = paramArrayOfString1;
    this.mRemoteInput = paramRemoteInput;
    this.mReadPendingIntent = paramPendingIntent2;
    this.mReplyPendingIntent = paramPendingIntent1;
    this.mParticipants = paramArrayOfString2;
    this.mLatestTimestamp = paramLong;
  }
  
  long getLatestTimestamp()
  {
    return this.mLatestTimestamp;
  }
  
  String[] getMessages()
  {
    return this.mMessages;
  }
  
  String getParticipant()
  {
    if (this.mParticipants.length > 0) {}
    for (String str = this.mParticipants[0];; str = null) {
      return str;
    }
  }
  
  String[] getParticipants()
  {
    return this.mParticipants;
  }
  
  PendingIntent getReadPendingIntent()
  {
    return this.mReadPendingIntent;
  }
  
  RemoteInput getRemoteInput()
  {
    return this.mRemoteInput;
  }
  
  PendingIntent getReplyPendingIntent()
  {
    return this.mReplyPendingIntent;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation
 * JD-Core Version:    0.7.0.1
 */