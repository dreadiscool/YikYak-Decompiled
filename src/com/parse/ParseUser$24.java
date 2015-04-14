package com.parse;

import l;
import m;
import org.json.JSONObject;

class ParseUser$24
  implements l<Void, m<Void>>
{
  ParseUser$24(ParseUser paramParseUser, JSONObject paramJSONObject, String paramString) {}
  
  public m<Void> then(m<Void> paramm)
  {
    synchronized (this.this$0.mutex)
    {
      if ((paramm.d()) || (paramm.c())) {
        ParseUser.access$1100(this.this$0, this.val$oldAnonymousData);
      } else {
        ParseUser.access$1000(this.this$0, this.val$authType);
      }
    }
    return paramm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.24
 * JD-Core Version:    0.7.0.1
 */