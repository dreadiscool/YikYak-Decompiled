package com.parse;

import l;
import m;

class ParseUser$4
  implements l<Void, m<Void>>
{
  ParseUser$4(ParseUser paramParseUser) {}
  
  public m<Void> then(m<Void> paramm)
  {
    synchronized (this.this$0.mutex)
    {
      this.this$0.mergeFromObject(ParseUser.getCurrentUser());
      m localm = ParseUser.access$000(this.this$0);
      return localm;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.4
 * JD-Core Version:    0.7.0.1
 */