package com.parse;

import org.json.JSONObject;

abstract interface ParseAuthenticationProvider
{
  public abstract void authenticate(ParseAuthenticationProvider.ParseAuthenticationCallback paramParseAuthenticationCallback);
  
  public abstract void cancel();
  
  public abstract void deauthenticate();
  
  public abstract String getAuthType();
  
  public abstract boolean restoreAuthentication(JSONObject paramJSONObject);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseAuthenticationProvider
 * JD-Core Version:    0.7.0.1
 */