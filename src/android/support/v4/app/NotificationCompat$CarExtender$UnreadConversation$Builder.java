package android.support.v4.app;

import android.app.PendingIntent;
import java.util.ArrayList;
import java.util.List;

public class NotificationCompat$CarExtender$UnreadConversation$Builder
{
  private long mLatestTimestamp;
  private final List<String> mMessages = new ArrayList();
  private final String mParticipant;
  private PendingIntent mReadPendingIntent;
  private RemoteInput mRemoteInput;
  private PendingIntent mReplyPendingIntent;
  
  public NotificationCompat$CarExtender$UnreadConversation$Builder(String paramString)
  {
    this.mParticipant = paramString;
  }
  
  public Builder addMessage(String paramString)
  {
    this.mMessages.add(paramString);
    return this;
  }
  
  public NotificationCompat.CarExtender.UnreadConversation build()
  {
    String[] arrayOfString1 = (String[])this.mMessages.toArray(new String[this.mMessages.size()]);
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = this.mParticipant;
    return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString1, this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, arrayOfString2, this.mLatestTimestamp);
  }
  
  public Builder setLatestTimestamp(long paramLong)
  {
    this.mLatestTimestamp = paramLong;
    return this;
  }
  
  public Builder setReadPendingIntent(PendingIntent paramPendingIntent)
  {
    this.mReadPendingIntent = paramPendingIntent;
    return this;
  }
  
  public Builder setReplyAction(PendingIntent paramPendingIntent, RemoteInput paramRemoteInput)
  {
    this.mRemoteInput = paramRemoteInput;
    this.mReplyPendingIntent = paramPendingIntent;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation.Builder
 * JD-Core Version:    0.7.0.1
 */