package com.parse;

import org.json.JSONObject;

final class ParseFacebookUtils$1
  implements ParseAuthenticationProvider.ParseAuthenticationCallback
{
  ParseFacebookUtils$1(ParseUser paramParseUser, SaveCallback paramSaveCallback) {}
  
  public void onCancel()
  {
    if (this.val$callback != null) {
      this.val$callback.internalDone(null, null);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.val$callback != null) {
      this.val$callback.internalDone(null, new ParseException(paramThrowable));
    }
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    Parse.callbackOnMainThreadAsync(this.val$user.linkWithAsync(ParseFacebookUtils.provider.getAuthType(), paramJSONObject), this.val$callback, true);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseFacebookUtils.1
 * JD-Core Version:    0.7.0.1
 */