package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.SparseArray;

public abstract class WakefulBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String EXTRA_WAKE_LOCK_ID = "android.support.content.wakelockid";
  private static final SparseArray<PowerManager.WakeLock> mActiveWakeLocks = new SparseArray();
  private static int mNextId = 1;
  
  public static boolean completeWakefulIntent(Intent paramIntent)
  {
    boolean bool = false;
    int i = paramIntent.getIntExtra("android.support.content.wakelockid", 0);
    if (i == 0) {}
    for (;;)
    {
      return bool;
      synchronized (mActiveWakeLocks)
      {
        PowerManager.WakeLock localWakeLock = (PowerManager.WakeLock)mActiveWakeLocks.get(i);
        if (localWakeLock != null)
        {
          localWakeLock.release();
          mActiveWakeLocks.remove(i);
          bool = true;
          continue;
        }
        new StringBuilder().append("No active wake lock id #").append(i).toString();
        bool = true;
      }
    }
  }
  
  public static ComponentName startWakefulService(Context paramContext, Intent paramIntent)
  {
    ComponentName localComponentName2;
    synchronized (mActiveWakeLocks)
    {
      int i = mNextId;
      mNextId = 1 + mNextId;
      if (mNextId <= 0) {
        mNextId = 1;
      }
      paramIntent.putExtra("android.support.content.wakelockid", i);
      ComponentName localComponentName1 = paramContext.startService(paramIntent);
      if (localComponentName1 == null)
      {
        localComponentName2 = null;
      }
      else
      {
        PowerManager.WakeLock localWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "wake:" + localComponentName1.flattenToShortString());
        localWakeLock.setReferenceCounted(false);
        localWakeLock.acquire(60000L);
        mActiveWakeLocks.put(i, localWakeLock);
        localComponentName2 = localComponentName1;
      }
    }
    return localComponentName2;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.WakefulBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */