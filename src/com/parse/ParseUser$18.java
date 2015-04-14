package com.parse;

import l;
import m;
import org.json.JSONObject;

class ParseUser$18
  implements l<JSONObject, m<Void>>
{
  ParseUser$18(ParseUser paramParseUser) {}
  
  public m<Void> then(m<JSONObject> paramm)
  {
    JSONObject localJSONObject = (JSONObject)paramm.e();
    m localm;
    synchronized (this.this$0.mutex)
    {
      ParseUser.access$402(this.this$0, false);
      if (localJSONObject.optBoolean("is_new"))
      {
        ParseUser.access$1402(this.this$0, false);
        localm = m.a(null);
      }
      else
      {
        localm = ParseUser.access$000((ParseUser)ParseObject.fromJSON(localJSONObject, "_User", true));
      }
    }
    return localm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.18
 * JD-Core Version:    0.7.0.1
 */