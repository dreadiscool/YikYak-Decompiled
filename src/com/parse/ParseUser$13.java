package com.parse;

import l;
import m;
import org.json.JSONObject;

class ParseUser$13
  implements l<Void, m<Void>>
{
  ParseUser$13(ParseUser paramParseUser, String paramString) {}
  
  public m<Void> then(m<Void> paramm)
  {
    m localm;
    synchronized (this.this$0.mutex)
    {
      if (ParseUser.access$700(this.this$0).has(this.val$authType))
      {
        ParseUser.access$700(this.this$0).put(this.val$authType, JSONObject.NULL);
        ParseUser.access$402(this.this$0, true);
        localm = this.this$0.saveInBackground();
      }
      else
      {
        localm = m.a(null);
      }
    }
    return localm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.13
 * JD-Core Version:    0.7.0.1
 */