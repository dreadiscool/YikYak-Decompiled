package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import android.os.Parcelable;

class NotificationCompatApi21
{
  public static final String CATEGORY_ALARM = "alarm";
  public static final String CATEGORY_CALL = "call";
  public static final String CATEGORY_EMAIL = "email";
  public static final String CATEGORY_ERROR = "err";
  public static final String CATEGORY_EVENT = "event";
  public static final String CATEGORY_MESSAGE = "msg";
  public static final String CATEGORY_PROGRESS = "progress";
  public static final String CATEGORY_PROMO = "promo";
  public static final String CATEGORY_RECOMMENDATION = "recommendation";
  public static final String CATEGORY_SERVICE = "service";
  public static final String CATEGORY_SOCIAL = "social";
  public static final String CATEGORY_STATUS = "status";
  public static final String CATEGORY_SYSTEM = "sys";
  public static final String CATEGORY_TRANSPORT = "transport";
  private static final String KEY_AUTHOR = "author";
  private static final String KEY_MESSAGES = "messages";
  private static final String KEY_ON_READ = "on_read";
  private static final String KEY_ON_REPLY = "on_reply";
  private static final String KEY_PARTICIPANTS = "participants";
  private static final String KEY_REMOTE_INPUT = "remote_input";
  private static final String KEY_TEXT = "text";
  private static final String KEY_TIMESTAMP = "timestamp";
  
  private static RemoteInput fromCompatRemoteInput(RemoteInputCompatBase.RemoteInput paramRemoteInput)
  {
    return new RemoteInput.Builder(paramRemoteInput.getResultKey()).setLabel(paramRemoteInput.getLabel()).setChoices(paramRemoteInput.getChoices()).setAllowFreeFormInput(paramRemoteInput.getAllowFreeFormInput()).addExtras(paramRemoteInput.getExtras()).build();
  }
  
  static Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation paramUnreadConversation)
  {
    Object localObject = null;
    int i = 0;
    if (paramUnreadConversation == null) {}
    for (;;)
    {
      return localObject;
      Bundle localBundle1 = new Bundle();
      if ((paramUnreadConversation.getParticipants() != null) && (paramUnreadConversation.getParticipants().length > 1)) {
        localObject = paramUnreadConversation.getParticipants()[0];
      }
      Parcelable[] arrayOfParcelable = new Parcelable[paramUnreadConversation.getMessages().length];
      while (i < arrayOfParcelable.length)
      {
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("text", paramUnreadConversation.getMessages()[i]);
        localBundle2.putString("author", (String)localObject);
        arrayOfParcelable[i] = localBundle2;
        i++;
      }
      localBundle1.putParcelableArray("messages", arrayOfParcelable);
      RemoteInputCompatBase.RemoteInput localRemoteInput = paramUnreadConversation.getRemoteInput();
      if (localRemoteInput != null) {
        localBundle1.putParcelable("remote_input", fromCompatRemoteInput(localRemoteInput));
      }
      localBundle1.putParcelable("on_reply", paramUnreadConversation.getReplyPendingIntent());
      localBundle1.putParcelable("on_read", paramUnreadConversation.getReadPendingIntent());
      localBundle1.putStringArray("participants", paramUnreadConversation.getParticipants());
      localBundle1.putLong("timestamp", paramUnreadConversation.getLatestTimestamp());
      localObject = localBundle1;
    }
  }
  
  public static String getCategory(Notification paramNotification)
  {
    return paramNotification.category;
  }
  
  static NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle paramBundle, NotificationCompatBase.UnreadConversation.Factory paramFactory, RemoteInputCompatBase.RemoteInput.Factory paramFactory1)
  {
    int i = 0;
    NotificationCompatBase.UnreadConversation localUnreadConversation = null;
    if (paramBundle == null) {
      return localUnreadConversation;
    }
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("messages");
    String[] arrayOfString3;
    int j;
    if (arrayOfParcelable != null)
    {
      arrayOfString3 = new String[arrayOfParcelable.length];
      j = 0;
      label36:
      if (j < arrayOfString3.length) {
        if (!(arrayOfParcelable[j] instanceof Bundle)) {
          label55:
          if (i == 0) {
            break label197;
          }
        }
      }
    }
    for (String[] arrayOfString1 = arrayOfString3;; arrayOfString1 = null)
    {
      PendingIntent localPendingIntent1 = (PendingIntent)paramBundle.getParcelable("on_read");
      PendingIntent localPendingIntent2 = (PendingIntent)paramBundle.getParcelable("on_reply");
      RemoteInput localRemoteInput = (RemoteInput)paramBundle.getParcelable("remote_input");
      String[] arrayOfString2 = paramBundle.getStringArray("participants");
      if ((arrayOfString2 == null) || (arrayOfString2.length != 1)) {
        break;
      }
      if (localRemoteInput != null) {}
      for (RemoteInputCompatBase.RemoteInput localRemoteInput1 = toCompatRemoteInput(localRemoteInput, paramFactory1);; localRemoteInput1 = null)
      {
        localUnreadConversation = paramFactory.build(arrayOfString1, localRemoteInput1, localPendingIntent2, localPendingIntent1, arrayOfString2, paramBundle.getLong("timestamp"));
        break;
        arrayOfString3[j] = ((Bundle)arrayOfParcelable[j]).getString("text");
        if (arrayOfString3[j] == null) {
          break label55;
        }
        j++;
        break label36;
      }
      i = 1;
      break label55;
      label197:
      break;
    }
  }
  
  private static RemoteInputCompatBase.RemoteInput toCompatRemoteInput(RemoteInput paramRemoteInput, RemoteInputCompatBase.RemoteInput.Factory paramFactory)
  {
    return paramFactory.build(paramRemoteInput.getResultKey(), paramRemoteInput.getLabel(), paramRemoteInput.getChoices(), paramRemoteInput.getAllowFreeFormInput(), paramRemoteInput.getExtras());
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     android.support.v4.app.NotificationCompatApi21

 * JD-Core Version:    0.7.0.1

 */