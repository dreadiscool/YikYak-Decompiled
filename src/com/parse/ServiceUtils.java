package com.parse;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;

class ServiceUtils
{
  private static final String TAG = "com.parse.ServiceUtils";
  private static final String WAKE_LOCK_EXTRA = "parseWakeLockId";
  private static int wakeLockId = 0;
  private static final SparseArray<ParseWakeLock> wakeLocks = new SparseArray();
  
  public static void completeWakefulIntent(Intent paramIntent)
  {
    int i;
    if ((paramIntent != null) && (paramIntent.hasExtra("parseWakeLockId"))) {
      i = paramIntent.getIntExtra("parseWakeLockId", -1);
    }
    for (;;)
    {
      ParseWakeLock localParseWakeLock;
      synchronized (wakeLocks)
      {
        localParseWakeLock = (ParseWakeLock)wakeLocks.get(i);
        wakeLocks.remove(i);
        if (localParseWakeLock == null)
        {
          Parse.logE("com.parse.ServiceUtils", "Got wake lock id of " + i + " in intent, but no such lock found in " + "global map. Was completeWakefulIntent called twice for the same intent?");
          return;
        }
      }
      localParseWakeLock.release();
    }
  }
  
  public static boolean runIntentInService(Context paramContext, Intent paramIntent, Class<? extends Service> paramClass)
  {
    boolean bool = false;
    if (paramIntent != null)
    {
      if (paramClass != null) {
        paramIntent.setClass(paramContext, paramClass);
      }
      if (paramContext.startService(paramIntent) != null) {
        bool = true;
      }
      if (!bool) {
        Parse.logE("com.parse.ServiceUtils", "Could not start the service. Make sure that the XML tag <service android:name=\"" + paramClass.toString() + "\" /> is in your " + "AndroidManifest.xml as a child of the <application> element.");
      }
    }
    return bool;
  }
  
  public static boolean runWakefulIntentInService(Context paramContext, Intent paramIntent, Class<? extends Service> paramClass, long paramLong)
  {
    boolean bool = false;
    ParseWakeLock localParseWakeLock;
    if (paramIntent != null) {
      localParseWakeLock = ParseWakeLock.acquireNewWakeLock(paramContext, 1, paramIntent.toString(), 0L);
    }
    synchronized (wakeLocks)
    {
      paramIntent.putExtra("parseWakeLockId", wakeLockId);
      wakeLocks.append(wakeLockId, localParseWakeLock);
      wakeLockId = 1 + wakeLockId;
      bool = runIntentInService(paramContext, paramIntent, paramClass);
      if (!bool) {
        completeWakefulIntent(paramIntent);
      }
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ServiceUtils
 * JD-Core Version:    0.7.0.1
 */