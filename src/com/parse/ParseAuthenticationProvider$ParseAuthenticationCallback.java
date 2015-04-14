package com.parse;

import org.json.JSONObject;

public abstract interface ParseAuthenticationProvider$ParseAuthenticationCallback
{
  public abstract void onCancel();
  
  public abstract void onError(Throwable paramThrowable);
  
  public abstract void onSuccess(JSONObject paramJSONObject);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseAuthenticationProvider.ParseAuthenticationCallback
 * JD-Core Version:    0.7.0.1
 */