package com.parse;

import l;
import m;

class ParseUser$1
  implements l<Void, m<Void>>
{
  ParseUser$1(ParseUser paramParseUser) {}
  
  public m<Void> then(m<Void> paramm)
  {
    m localm;
    synchronized (this.this$0.mutex)
    {
      this.this$0.cleanUpAuthData();
      if (this.this$0.isCurrentUser()) {
        localm = ParseUser.access$000(this.this$0);
      } else {
        localm = m.a(null);
      }
    }
    return localm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.1
 * JD-Core Version:    0.7.0.1
 */