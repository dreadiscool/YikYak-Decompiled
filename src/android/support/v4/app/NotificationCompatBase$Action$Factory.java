package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;

public abstract interface NotificationCompatBase$Action$Factory
{
  public abstract NotificationCompatBase.Action build(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInputCompatBase.RemoteInput[] paramArrayOfRemoteInput);
  
  public abstract NotificationCompatBase.Action[] newArray(int paramInt);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompatBase.Action.Factory
 * JD-Core Version:    0.7.0.1
 */