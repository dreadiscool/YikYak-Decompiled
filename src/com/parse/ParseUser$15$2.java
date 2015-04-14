package com.parse;

import java.util.Set;
import l;
import m;
import org.json.JSONObject;

class ParseUser$15$2
  implements l<Void, m<Void>>
{
  ParseUser$15$2(ParseUser.15 param15) {}
  
  public m<Void> then(m<Void> paramm)
  {
    synchronized (this.this$0.val$user.mutex)
    {
      ParseUser.access$1200(this.this$0.val$user);
      ParseUser.access$700(this.this$0.val$user).put(this.this$0.val$authType, this.this$0.val$authData);
      ParseUser.access$800(this.this$0.val$user).add(this.this$0.val$authType);
      m localm = ParseUser.access$1300(this.this$0.val$user, paramm);
      return localm;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.15.2
 * JD-Core Version:    0.7.0.1
 */