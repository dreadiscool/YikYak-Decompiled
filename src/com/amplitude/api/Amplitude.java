package com.amplitude.api;

import android.content.Context;
import org.json.JSONObject;

public class Amplitude
{
  public static final String END_SESSION_EVENT = "session_end";
  public static final String REVENUE_EVENT = "revenue_amount";
  public static final String START_SESSION_EVENT = "session_start";
  public static final String TAG = "com.amplitude.api.Amplitude";
  private static Amplitude.Lib instance = new Amplitude.Lib();
  
  public static void disableLocationListening()
  {
    instance.disableLocationListening();
  }
  
  public static void enableLocationListening()
  {
    instance.enableLocationListening();
  }
  
  public static void enableNewDeviceIdPerInstall(boolean paramBoolean)
  {
    instance.enableNewDeviceIdPerInstall(paramBoolean);
  }
  
  public static void endSession()
  {
    instance.endSession();
  }
  
  public static String getDeviceId()
  {
    return instance.getDeviceId();
  }
  
  static Amplitude.Lib getInstance()
  {
    return instance;
  }
  
  public static void initialize(Context paramContext, String paramString)
  {
    instance.initialize(paramContext, paramString);
  }
  
  public static void initialize(Context paramContext, String paramString1, String paramString2)
  {
    instance.initialize(paramContext, paramString1, paramString2);
  }
  
  public static void logEvent(String paramString)
  {
    instance.logEvent(paramString);
  }
  
  public static void logEvent(String paramString, JSONObject paramJSONObject)
  {
    instance.logEvent(paramString, paramJSONObject);
  }
  
  public static void logRevenue(double paramDouble)
  {
    instance.logRevenue(paramDouble);
  }
  
  public static void logRevenue(String paramString, int paramInt, double paramDouble)
  {
    instance.logRevenue(paramString, paramInt, paramDouble);
  }
  
  public static void logRevenue(String paramString1, int paramInt, double paramDouble, String paramString2, String paramString3)
  {
    instance.logRevenue(paramString1, paramInt, paramDouble, paramString2, paramString3);
  }
  
  public static void setOptOut(boolean paramBoolean)
  {
    instance.setOptOut(paramBoolean);
  }
  
  public static void setSessionTimeoutMillis(long paramLong)
  {
    instance.setSessionTimeoutMillis(paramLong);
  }
  
  public static void setUserId(String paramString)
  {
    instance.setUserId(paramString);
  }
  
  public static void setUserProperties(JSONObject paramJSONObject)
  {
    instance.setUserProperties(paramJSONObject);
  }
  
  public static void setUserProperties(JSONObject paramJSONObject, boolean paramBoolean)
  {
    instance.setUserProperties(paramJSONObject, paramBoolean);
  }
  
  public static void startSession()
  {
    instance.startSession();
  }
  
  public static void uploadEvents()
  {
    instance.uploadEvents();
  }
  
  public static void useAdvertisingIdForDeviceId()
  {
    instance.useAdvertisingIdForDeviceId();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.amplitude.api.Amplitude
 * JD-Core Version:    0.7.0.1
 */