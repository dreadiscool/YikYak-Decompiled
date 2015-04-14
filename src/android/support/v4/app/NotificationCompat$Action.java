package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;

public class NotificationCompat$Action
  extends NotificationCompatBase.Action
{
  public static final NotificationCompatBase.Action.Factory FACTORY = new NotificationCompat.Action.1();
  public PendingIntent actionIntent;
  public int icon;
  private final Bundle mExtras;
  private final RemoteInput[] mRemoteInputs;
  public CharSequence title;
  
  public NotificationCompat$Action(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramCharSequence, paramPendingIntent, new Bundle(), null);
  }
  
  private NotificationCompat$Action(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput)
  {
    this.icon = paramInt;
    this.title = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    this.actionIntent = paramPendingIntent;
    if (paramBundle != null) {}
    for (;;)
    {
      this.mExtras = paramBundle;
      this.mRemoteInputs = paramArrayOfRemoteInput;
      return;
      paramBundle = new Bundle();
    }
  }
  
  protected PendingIntent getActionIntent()
  {
    return this.actionIntent;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  protected int getIcon()
  {
    return this.icon;
  }
  
  public RemoteInput[] getRemoteInputs()
  {
    return this.mRemoteInputs;
  }
  
  protected CharSequence getTitle()
  {
    return this.title;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.Action
 * JD-Core Version:    0.7.0.1
 */