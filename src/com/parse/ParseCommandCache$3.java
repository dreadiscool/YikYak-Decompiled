package com.parse;

import k;
import l;
import m;

class ParseCommandCache$3
  implements l<T, Void>
{
  ParseCommandCache$3(ParseCommandCache paramParseCommandCache, k paramk) {}
  
  public Void then(m<T> paramm)
  {
    this.val$finished.a(Boolean.valueOf(true));
    synchronized (ParseCommandCache.access$100())
    {
      ParseCommandCache.access$100().notifyAll();
      return null;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseCommandCache.3
 * JD-Core Version:    0.7.0.1
 */