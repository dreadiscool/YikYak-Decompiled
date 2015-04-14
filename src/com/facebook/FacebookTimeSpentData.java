package com.facebook;

import android.os.Bundle;
import com.facebook.internal.Logger;
import java.io.Serializable;

class FacebookTimeSpentData
  implements Serializable
{
  private static final long APP_ACTIVATE_SUPPRESSION_PERIOD_IN_MILLISECONDS = 300000L;
  private static final long FIRST_TIME_LOAD_RESUME_TIME = -1L;
  private static final long[] INACTIVE_SECONDS_QUANTA;
  private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000L;
  private static final long NUM_MILLISECONDS_IDLE_TO_BE_NEW_SESSION = 60000L;
  private static final String TAG = AppEventsLogger.class.getCanonicalName();
  private static final long serialVersionUID = 1L;
  private String firstOpenSourceApplication;
  private int interruptionCount;
  private boolean isAppActive;
  private boolean isWarmLaunch;
  private long lastActivateEventLoggedTime;
  private long lastResumeTime;
  private long lastSuspendTime;
  private long millisecondsSpentInSession;
  
  static
  {
    long[] arrayOfLong = new long[19];
    arrayOfLong[0] = 300000L;
    arrayOfLong[1] = 900000L;
    arrayOfLong[2] = 1800000L;
    arrayOfLong[3] = 3600000L;
    arrayOfLong[4] = 21600000L;
    arrayOfLong[5] = 43200000L;
    arrayOfLong[6] = 86400000L;
    arrayOfLong[7] = 172800000L;
    arrayOfLong[8] = 259200000L;
    arrayOfLong[9] = 604800000L;
    arrayOfLong[10] = 1209600000L;
    arrayOfLong[11] = 1814400000L;
    arrayOfLong[12] = 2419200000L;
    arrayOfLong[13] = 5184000000L;
    arrayOfLong[14] = 7776000000L;
    arrayOfLong[15] = 10368000000L;
    arrayOfLong[16] = 12960000000L;
    arrayOfLong[17] = 15552000000L;
    arrayOfLong[18] = 31536000000L;
    INACTIVE_SECONDS_QUANTA = arrayOfLong;
  }
  
  FacebookTimeSpentData()
  {
    resetSession();
  }
  
  private FacebookTimeSpentData(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    resetSession();
    this.lastResumeTime = paramLong1;
    this.lastSuspendTime = paramLong2;
    this.millisecondsSpentInSession = paramLong3;
    this.interruptionCount = paramInt;
  }
  
  private FacebookTimeSpentData(long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString)
  {
    resetSession();
    this.lastResumeTime = paramLong1;
    this.lastSuspendTime = paramLong2;
    this.millisecondsSpentInSession = paramLong3;
    this.interruptionCount = paramInt;
    this.firstOpenSourceApplication = paramString;
  }
  
  private static int getQuantaIndex(long paramLong)
  {
    for (int i = 0; (i < INACTIVE_SECONDS_QUANTA.length) && (INACTIVE_SECONDS_QUANTA[i] < paramLong); i++) {}
    return i;
  }
  
  private boolean isColdLaunch()
  {
    if (!this.isWarmLaunch) {}
    for (boolean bool = true;; bool = false)
    {
      this.isWarmLaunch = true;
      return bool;
    }
  }
  
  private void logAppDeactivatedEvent(AppEventsLogger paramAppEventsLogger, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fb_mobile_app_interruptions", this.interruptionCount);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(getQuantaIndex(paramLong));
    localBundle.putString("fb_mobile_time_between_sessions", String.format("session_quanta_%d", arrayOfObject));
    localBundle.putString("fb_mobile_launch_source", this.firstOpenSourceApplication);
    paramAppEventsLogger.logEvent("fb_mobile_deactivate_app", this.millisecondsSpentInSession / 1000L, localBundle);
    resetSession();
  }
  
  private void resetSession()
  {
    this.isAppActive = false;
    this.lastResumeTime = -1L;
    this.lastSuspendTime = -1L;
    this.interruptionCount = 0;
    this.millisecondsSpentInSession = 0L;
  }
  
  private boolean wasSuspendedEver()
  {
    if (this.lastSuspendTime != -1L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private Object writeReplace()
  {
    return new FacebookTimeSpentData.SerializationProxyV2(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, this.firstOpenSourceApplication);
  }
  
  void onResume(AppEventsLogger paramAppEventsLogger, long paramLong, String paramString)
  {
    long l1 = 0L;
    if ((isColdLaunch()) || (paramLong - this.lastActivateEventLoggedTime > 300000L))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("fb_mobile_launch_source", paramString);
      paramAppEventsLogger.logEvent("fb_mobile_activate_app", localBundle);
      this.lastActivateEventLoggedTime = paramLong;
    }
    if (this.isAppActive)
    {
      Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Resume for active app");
      return;
    }
    long l2;
    if (wasSuspendedEver())
    {
      l2 = paramLong - this.lastSuspendTime;
      label88:
      if (l2 >= l1) {
        break label178;
      }
      Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
    }
    for (;;)
    {
      if (l1 > 60000L) {
        logAppDeactivatedEvent(paramAppEventsLogger, l1);
      }
      for (;;)
      {
        if (this.interruptionCount == 0) {
          this.firstOpenSourceApplication = paramString;
        }
        this.lastResumeTime = paramLong;
        this.isAppActive = true;
        break;
        l2 = l1;
        break label88;
        if (l1 > 1000L) {
          this.interruptionCount = (1 + this.interruptionCount);
        }
      }
      label178:
      l1 = l2;
    }
  }
  
  void onSuspend(AppEventsLogger paramAppEventsLogger, long paramLong)
  {
    long l1 = 0L;
    if (!this.isAppActive)
    {
      Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Suspend for inactive app");
      return;
    }
    long l2 = paramLong - this.lastResumeTime;
    if (l2 < l1) {
      Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
    }
    for (;;)
    {
      this.millisecondsSpentInSession = (l1 + this.millisecondsSpentInSession);
      this.lastSuspendTime = paramLong;
      this.isAppActive = false;
      break;
      l1 = l2;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.FacebookTimeSpentData
 * JD-Core Version:    0.7.0.1
 */