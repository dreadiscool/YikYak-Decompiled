package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

class IntentCompat$IntentCompatImplHC
  extends IntentCompat.IntentCompatImplBase
{
  public Intent makeMainActivity(ComponentName paramComponentName)
  {
    return IntentCompatHoneycomb.makeMainActivity(paramComponentName);
  }
  
  public Intent makeRestartActivityTask(ComponentName paramComponentName)
  {
    return IntentCompatHoneycomb.makeRestartActivityTask(paramComponentName);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.IntentCompat.IntentCompatImplHC
 * JD-Core Version:    0.7.0.1
 */