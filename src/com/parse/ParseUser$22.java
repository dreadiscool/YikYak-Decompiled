package com.parse;

import org.json.JSONObject;
import y;

final class ParseUser$22
  implements ParseAuthenticationProvider.ParseAuthenticationCallback
{
  ParseUser$22(y paramy) {}
  
  public void onCancel()
  {
    this.val$tcs.c();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$tcs.b(new ParseException(paramThrowable));
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    this.val$tcs.b(paramJSONObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.22
 * JD-Core Version:    0.7.0.1
 */