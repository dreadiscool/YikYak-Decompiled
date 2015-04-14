package com.google.android.gms.common.api;

public class CommonStatusCodes
{
  public static final int CANCELED = 16;
  public static final int DEVELOPER_ERROR = 10;
  public static final int ERROR = 13;
  public static final int INTERNAL_ERROR = 8;
  public static final int INTERRUPTED = 14;
  public static final int INVALID_ACCOUNT = 5;
  public static final int LICENSE_CHECK_FAILED = 11;
  public static final int NETWORK_ERROR = 7;
  public static final int RESOLUTION_REQUIRED = 6;
  public static final int SERVICE_DISABLED = 3;
  public static final int SERVICE_INVALID = 9;
  public static final int SERVICE_MISSING = 1;
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  public static final int SIGN_IN_REQUIRED = 4;
  public static final int SUCCESS = 0;
  public static final int SUCCESS_CACHE = -1;
  public static final int TIMEOUT = 15;
  
  public static String getStatusCodeString(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknown status code: " + paramInt;
    }
    for (;;)
    {
      return str;
      str = "SUCCESS_CACHE";
      continue;
      str = "SUCCESS";
      continue;
      str = "SERVICE_MISSING";
      continue;
      str = "SERVICE_VERSION_UPDATE_REQUIRED";
      continue;
      str = "SERVICE_DISABLED";
      continue;
      str = "SIGN_IN_REQUIRED";
      continue;
      str = "INVALID_ACCOUNT";
      continue;
      str = "RESOLUTION_REQUIRED";
      continue;
      str = "NETWORK_ERROR";
      continue;
      str = "INTERNAL_ERROR";
      continue;
      str = "SERVICE_INVALID";
      continue;
      str = "DEVELOPER_ERROR";
      continue;
      str = "LICENSE_CHECK_FAILED";
      continue;
      str = "ERROR_OPERATION_FAILED";
      continue;
      str = "INTERRUPTED";
      continue;
      str = "TIMEOUT";
      continue;
      str = "CANCELED";
      continue;
      str = "AUTH_API_INVALID_CREDENTIALS";
      continue;
      str = "AUTH_API_ACCESS_FORBIDDEN";
      continue;
      str = "AUTH_API_CLIENT_ERROR";
      continue;
      str = "AUTH_API_SERVER_ERROR";
      continue;
      str = "AUTH_TOKEN_ERROR";
      continue;
      str = "AUTH_URL_RESOLUTION";
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.CommonStatusCodes
 * JD-Core Version:    0.7.0.1
 */