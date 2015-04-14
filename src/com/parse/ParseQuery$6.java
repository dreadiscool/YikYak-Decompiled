package com.parse;

import java.util.ArrayList;
import java.util.List;
import l;
import m;

class ParseQuery$6
  implements l<Void, m<List<T>>>
{
  ParseQuery$6(ParseQuery paramParseQuery) {}
  
  public m<List<T>> then(m<Void> paramm)
  {
    ArrayList localArrayList = new ArrayList();
    m localm;
    if (ParseQuery.access$400(this.this$0) == null)
    {
      localm = m.a(localArrayList);
      return localm;
    }
    if (ParseQuery.access$500(this.this$0) != ParseQuery.CachePolicy.IGNORE_CACHE) {}
    for (boolean bool = true;; bool = false)
    {
      ParseQuery.access$602(this.this$0, System.nanoTime());
      localm = ParseQuery.access$400(this.this$0).executeAsync().c(new ParseQuery.6.1(this, bool));
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.6
 * JD-Core Version:    0.7.0.1
 */