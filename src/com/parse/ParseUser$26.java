package com.parse;

import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONObject;

class ParseUser$26
  implements Callable<Void>
{
  ParseUser$26(ParseUser paramParseUser, String paramString, JSONObject paramJSONObject) {}
  
  public Void call()
  {
    synchronized (this.this$0.mutex)
    {
      ParseUser.access$700(this.this$0).put(this.val$authType, this.val$authData);
      ParseUser.access$800(this.this$0).add(this.val$authType);
      ParseUser.access$1200(this.this$0);
      ParseUser.access$402(this.this$0, true);
      return null;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.26
 * JD-Core Version:    0.7.0.1
 */