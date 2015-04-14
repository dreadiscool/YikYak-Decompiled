package com.parse;

import l;
import m;
import org.json.JSONObject;

final class ParseUser$23
  implements l<JSONObject, m<ParseUser>>
{
  ParseUser$23(ParseAuthenticationProvider paramParseAuthenticationProvider) {}
  
  public m<ParseUser> then(m<JSONObject> paramm)
  {
    return ParseUser.logInWithAsync(this.val$authenticator.getAuthType(), (JSONObject)paramm.e());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.23
 * JD-Core Version:    0.7.0.1
 */