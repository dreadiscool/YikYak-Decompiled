package com.parse;

import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

class AnonymousAuthenticationProvider
  implements ParseAuthenticationProvider
{
  public void authenticate(ParseAuthenticationProvider.ParseAuthenticationCallback paramParseAuthenticationCallback)
  {
    try
    {
      paramParseAuthenticationCallback.onSuccess(getAuthData());
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  public void cancel() {}
  
  public void deauthenticate() {}
  
  public JSONObject getAuthData()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("id", UUID.randomUUID());
    return localJSONObject;
  }
  
  public String getAuthType()
  {
    return "anonymous";
  }
  
  public boolean restoreAuthentication(JSONObject paramJSONObject)
  {
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.AnonymousAuthenticationProvider
 * JD-Core Version:    0.7.0.1
 */