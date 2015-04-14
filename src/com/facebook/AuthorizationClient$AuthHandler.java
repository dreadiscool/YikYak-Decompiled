package com.facebook;

import android.content.Intent;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

abstract class AuthorizationClient$AuthHandler
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  Map<String, String> methodLoggingExtras;
  
  AuthorizationClient$AuthHandler(AuthorizationClient paramAuthorizationClient) {}
  
  protected void addLoggingExtra(String paramString, Object paramObject)
  {
    if (this.methodLoggingExtras == null) {
      this.methodLoggingExtras = new HashMap();
    }
    Map localMap = this.methodLoggingExtras;
    if (paramObject == null) {}
    for (Object localObject = null;; localObject = paramObject.toString())
    {
      localMap.put(paramString, localObject);
      return;
    }
  }
  
  void cancel() {}
  
  abstract String getNameForLogging();
  
  boolean needsInternetPermission()
  {
    return false;
  }
  
  boolean needsRestart()
  {
    return false;
  }
  
  boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  abstract boolean tryAuthorize(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AuthorizationClient.AuthHandler
 * JD-Core Version:    0.7.0.1
 */