package com.adjust.sdk;

import android.content.Context;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

public class AdjustFactory
{
  private static HttpClient httpClient;
  private static Logger logger;
  private static IPackageHandler packageHandler = null;
  private static IRequestHandler requestHandler = null;
  private static long sessionInterval = -1L;
  private static long subsessionInterval = -1L;
  private static long timerInterval;
  
  static
  {
    logger = null;
    httpClient = null;
    timerInterval = -1L;
  }
  
  public static HttpClient getHttpClient(HttpParams paramHttpParams)
  {
    if (httpClient == null) {}
    for (Object localObject = new DefaultHttpClient(paramHttpParams);; localObject = httpClient) {
      return localObject;
    }
  }
  
  public static Logger getLogger()
  {
    if (logger == null) {
      logger = new LogCatLogger();
    }
    return logger;
  }
  
  public static IPackageHandler getPackageHandler(ActivityHandler paramActivityHandler, Context paramContext, boolean paramBoolean)
  {
    if (packageHandler == null) {}
    for (Object localObject = new PackageHandler(paramActivityHandler, paramContext, paramBoolean);; localObject = packageHandler) {
      return localObject;
    }
  }
  
  public static IRequestHandler getRequestHandler(IPackageHandler paramIPackageHandler)
  {
    if (requestHandler == null) {}
    for (Object localObject = new RequestHandler(paramIPackageHandler);; localObject = requestHandler) {
      return localObject;
    }
  }
  
  public static long getSessionInterval()
  {
    if (sessionInterval == -1L) {}
    for (long l = 1800000L;; l = sessionInterval) {
      return l;
    }
  }
  
  public static long getSubsessionInterval()
  {
    if (subsessionInterval == -1L) {}
    for (long l = 1000L;; l = subsessionInterval) {
      return l;
    }
  }
  
  public static long getTimerInterval()
  {
    if (timerInterval == -1L) {}
    for (long l = 60000L;; l = timerInterval) {
      return l;
    }
  }
  
  public static void setHttpClient(HttpClient paramHttpClient)
  {
    httpClient = paramHttpClient;
  }
  
  public static void setLogger(Logger paramLogger)
  {
    logger = paramLogger;
  }
  
  public static void setPackageHandler(IPackageHandler paramIPackageHandler)
  {
    packageHandler = paramIPackageHandler;
  }
  
  public static void setRequestHandler(IRequestHandler paramIRequestHandler)
  {
    requestHandler = paramIRequestHandler;
  }
  
  public static void setSessionInterval(long paramLong)
  {
    sessionInterval = paramLong;
  }
  
  public static void setSubsessionInterval(long paramLong)
  {
    subsessionInterval = paramLong;
  }
  
  public static void setTimerInterval(long paramLong)
  {
    timerInterval = paramLong;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.AdjustFactory
 * JD-Core Version:    0.7.0.1
 */