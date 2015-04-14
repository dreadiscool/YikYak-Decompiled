package com.adjust.sdk;

import java.util.Arrays;
import java.util.List;

public abstract interface Constants
{
  public static final String BASE_URL = "https://app.adjust.io";
  public static final String CLIENT_SDK = "android3.6.1";
  public static final String ENCODING = "UTF-8";
  public static final String HIGH = "high";
  public static final String LARGE = "large";
  public static final String LOGTAG = "Adjust";
  public static final String LONG = "long";
  public static final String LOW = "low";
  public static final String MALFORMED = "malformed";
  public static final String MD5 = "MD5";
  public static final String MEDIUM = "medium";
  public static final String NORMAL = "normal";
  public static final String NO_ACTIVITY_HANDLER_FOUND = "No activity handler found";
  public static final int ONE_MINUTE = 60000;
  public static final int ONE_SECOND = 1000;
  public static final List<String> PLUGINS;
  public static final String REFERRER = "referrer";
  public static final String SESSION_STATE_FILENAME = "AdjustIoActivityState";
  public static final String SHA1 = "SHA-1";
  public static final String SMALL = "small";
  public static final int THIRTY_MINUTES = 1800000;
  public static final String UNKNOWN = "unknown";
  public static final String XLARGE = "xlarge";
  
  static
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "com.adjust.sdk.plugin.Vulcun";
    PLUGINS = Arrays.asList(arrayOfString);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.Constants
 * JD-Core Version:    0.7.0.1
 */