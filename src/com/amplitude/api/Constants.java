package com.amplitude.api;

public class Constants
{
  public static final int API_VERSION = 2;
  public static final String DATABASE_NAME;
  public static final int DATABASE_VERSION = 1;
  public static final String EVENT_LOG_URL = "https://api.amplitude.com/";
  public static final int EVENT_MAX_COUNT = 1000;
  public static final int EVENT_REMOVE_BATCH_SIZE = 20;
  public static final int EVENT_UPLOAD_MAX_BATCH_SIZE = 100;
  public static final long EVENT_UPLOAD_PERIOD_MILLIS = 30000L;
  public static final int EVENT_UPLOAD_THRESHOLD = 30;
  public static final String LIBRARY = "amplitude-android";
  public static final long MIN_TIME_BETWEEN_SESSIONS_MILLIS = 15000L;
  public static final String PACKAGE_NAME = Constants.class.getPackage().getName();
  public static final String PLATFORM = "Android";
  public static final String PREFKEY_DEVICE_ID;
  public static final String PREFKEY_OPT_OUT = PACKAGE_NAME + ".optOut";
  public static final String PREFKEY_PREVIOUS_END_SESSION_ID;
  public static final String PREFKEY_PREVIOUS_END_SESSION_TIME;
  public static final String PREFKEY_PREVIOUS_SESSION_ID;
  public static final String PREFKEY_PREVIOUS_SESSION_TIME;
  public static final String PREFKEY_USER_ID;
  public static final long SESSION_TIMEOUT_MILLIS = 1800000L;
  public static final String SHARED_PREFERENCES_NAME_PREFIX;
  public static final String VERSION = "1.4.6";
  
  static
  {
    DATABASE_NAME = PACKAGE_NAME;
    SHARED_PREFERENCES_NAME_PREFIX = PACKAGE_NAME;
    PREFKEY_PREVIOUS_SESSION_TIME = PACKAGE_NAME + ".previousSessionTime";
    PREFKEY_PREVIOUS_END_SESSION_TIME = PACKAGE_NAME + ".previousEndSessionTime";
    PREFKEY_PREVIOUS_END_SESSION_ID = PACKAGE_NAME + ".previousEndSessionId";
    PREFKEY_PREVIOUS_SESSION_ID = PACKAGE_NAME + ".previousSessionId";
    PREFKEY_DEVICE_ID = PACKAGE_NAME + ".deviceId";
    PREFKEY_USER_ID = PACKAGE_NAME + ".userId";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.amplitude.api.Constants
 * JD-Core Version:    0.7.0.1
 */