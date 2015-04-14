package com.parse;

import l;
import m;

class ParseUser$2
  implements l<T, m<T>>
{
  ParseUser$2(ParseUser paramParseUser) {}
  
  public m<T> then(m<T> paramm)
  {
    synchronized (this.this$0.mutex)
    {
      this.this$0.cleanUpAuthData();
      if (this.this$0.isCurrentUser()) {
        paramm = ParseUser.access$000(this.this$0).b(new ParseUser.2.1(this, paramm));
      }
    }
    return paramm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.2
 * JD-Core Version:    0.7.0.1
 */