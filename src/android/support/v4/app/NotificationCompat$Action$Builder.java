package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.ArrayList;

public final class NotificationCompat$Action$Builder
{
  private final Bundle mExtras;
  private final int mIcon;
  private final PendingIntent mIntent;
  private ArrayList<RemoteInput> mRemoteInputs;
  private final CharSequence mTitle;
  
  public NotificationCompat$Action$Builder(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramCharSequence, paramPendingIntent, new Bundle());
  }
  
  private NotificationCompat$Action$Builder(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
  {
    this.mIcon = paramInt;
    this.mTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    this.mIntent = paramPendingIntent;
    this.mExtras = paramBundle;
  }
  
  public NotificationCompat$Action$Builder(NotificationCompat.Action paramAction)
  {
    this(paramAction.icon, paramAction.title, paramAction.actionIntent, new Bundle(NotificationCompat.Action.access$300(paramAction)));
  }
  
  public Builder addExtras(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.mExtras.putAll(paramBundle);
    }
    return this;
  }
  
  public Builder addRemoteInput(RemoteInput paramRemoteInput)
  {
    if (this.mRemoteInputs == null) {
      this.mRemoteInputs = new ArrayList();
    }
    this.mRemoteInputs.add(paramRemoteInput);
    return this;
  }
  
  public NotificationCompat.Action build()
  {
    if (this.mRemoteInputs != null) {}
    for (RemoteInput[] arrayOfRemoteInput = (RemoteInput[])this.mRemoteInputs.toArray(new RemoteInput[this.mRemoteInputs.size()]);; arrayOfRemoteInput = null) {
      return new NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, arrayOfRemoteInput, null);
    }
  }
  
  public Builder extend(NotificationCompat.Action.Extender paramExtender)
  {
    paramExtender.extend(this);
    return this;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.Action.Builder
 * JD-Core Version:    0.7.0.1
 */