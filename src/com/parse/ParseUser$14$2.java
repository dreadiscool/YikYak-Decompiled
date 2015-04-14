package com.parse;

import l;
import m;

class ParseUser$14$2
  implements l<Void, m<Void>>
{
  ParseUser$14$2(ParseUser.14 param14, ParseUser paramParseUser) {}
  
  public m<Void> then(m<Void> paramm)
  {
    synchronized (this.val$user.mutex)
    {
      ParseUser.access$402(this.val$user, false);
      ParseUser.access$1000(this.val$user, this.this$0.val$authType);
      m localm = ParseUser.access$000(this.val$user);
      return localm;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.14.2
 * JD-Core Version:    0.7.0.1
 */