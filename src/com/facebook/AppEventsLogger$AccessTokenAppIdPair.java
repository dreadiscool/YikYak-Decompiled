package com.facebook;

import com.facebook.internal.Utility;
import java.io.Serializable;

class AppEventsLogger$AccessTokenAppIdPair
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final String accessToken;
  private final String applicationId;
  
  AppEventsLogger$AccessTokenAppIdPair(Session paramSession)
  {
    this(paramSession.getAccessToken(), paramSession.getApplicationId());
  }
  
  AppEventsLogger$AccessTokenAppIdPair(String paramString1, String paramString2)
  {
    if (Utility.isNullOrEmpty(paramString1)) {
      paramString1 = null;
    }
    this.accessToken = paramString1;
    this.applicationId = paramString2;
  }
  
  private Object writeReplace()
  {
    return new AppEventsLogger.AccessTokenAppIdPair.SerializationProxyV1(this.accessToken, this.applicationId, null);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (!(paramObject instanceof AccessTokenAppIdPair)) {}
    for (;;)
    {
      return bool;
      AccessTokenAppIdPair localAccessTokenAppIdPair = (AccessTokenAppIdPair)paramObject;
      if ((Utility.areObjectsEqual(localAccessTokenAppIdPair.accessToken, this.accessToken)) && (Utility.areObjectsEqual(localAccessTokenAppIdPair.applicationId, this.applicationId))) {
        bool = true;
      }
    }
  }
  
  String getAccessToken()
  {
    return this.accessToken;
  }
  
  String getApplicationId()
  {
    return this.applicationId;
  }
  
  public int hashCode()
  {
    int i = 0;
    int j;
    if (this.accessToken == null)
    {
      j = 0;
      if (this.applicationId != null) {
        break label33;
      }
    }
    for (;;)
    {
      return j ^ i;
      j = this.accessToken.hashCode();
      break;
      label33:
      i = this.applicationId.hashCode();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AppEventsLogger.AccessTokenAppIdPair
 * JD-Core Version:    0.7.0.1
 */