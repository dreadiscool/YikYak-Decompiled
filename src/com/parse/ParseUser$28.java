package com.parse;

import l;
import m;
import org.json.JSONObject;

class ParseUser$28
  implements l<JSONObject, m<Void>>
{
  ParseUser$28(ParseUser paramParseUser, ParseAuthenticationProvider paramParseAuthenticationProvider) {}
  
  public m<Void> then(m<JSONObject> paramm)
  {
    return this.this$0.linkWithAsync(this.val$authenticator.getAuthType(), (JSONObject)paramm.e());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.28
 * JD-Core Version:    0.7.0.1
 */