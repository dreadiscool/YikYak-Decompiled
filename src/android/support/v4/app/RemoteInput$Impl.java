package android.support.v4.app;

import android.content.Intent;
import android.os.Bundle;

abstract interface RemoteInput$Impl
{
  public abstract void addResultsToIntent(RemoteInput[] paramArrayOfRemoteInput, Intent paramIntent, Bundle paramBundle);
  
  public abstract Bundle getResultsFromIntent(Intent paramIntent);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.RemoteInput.Impl
 * JD-Core Version:    0.7.0.1
 */