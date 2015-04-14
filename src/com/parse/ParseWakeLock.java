package com.parse;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

class ParseWakeLock
{
  private static final String TAG = "com.parse.ParseWakeLock";
  private static volatile boolean hasWakeLockPermission = true;
  private final PowerManager.WakeLock wakeLock;
  
  private ParseWakeLock(PowerManager.WakeLock paramWakeLock)
  {
    this.wakeLock = paramWakeLock;
  }
  
  public static ParseWakeLock acquireNewWakeLock(Context paramContext, int paramInt, String paramString, long paramLong)
  {
    Object localObject = null;
    if (hasWakeLockPermission) {}
    try
    {
      PowerManager localPowerManager = (PowerManager)paramContext.getApplicationContext().getSystemService("power");
      if (localPowerManager != null)
      {
        localWakeLock = localPowerManager.newWakeLock(paramInt, paramString);
        if (localWakeLock != null)
        {
          localWakeLock.setReferenceCounted(false);
          if (paramLong != 0L) {
            break label73;
          }
          localWakeLock.acquire();
        }
        for (;;)
        {
          localObject = localWakeLock;
          return new ParseWakeLock(localObject);
          label73:
          localWakeLock.acquire(paramLong);
        }
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Parse.logE("com.parse.ParseWakeLock", "Failed to acquire a PowerManager.WakeLock. This isnecessary for reliable handling of pushes. Please add this to your Manifest.xml: <uses-permission android:name=\"android.permission.WAKE_LOCK\" /> ");
        hasWakeLockPermission = false;
        continue;
        PowerManager.WakeLock localWakeLock = null;
      }
    }
  }
  
  public void release()
  {
    if (this.wakeLock != null) {
      this.wakeLock.release();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseWakeLock
 * JD-Core Version:    0.7.0.1
 */