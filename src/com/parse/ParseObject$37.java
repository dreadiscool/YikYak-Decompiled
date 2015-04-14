package com.parse;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import k;
import l;
import m;

final class ParseObject$37
  implements l<Void, m<Void>>
{
  ParseObject$37(List paramList, String paramString) {}
  
  public m<Void> then(m<Void> paramm)
  {
    IdentityHashMap localIdentityHashMap = new IdentityHashMap();
    Iterator localIterator = this.val$objects.iterator();
    while (localIterator.hasNext()) {
      localIdentityHashMap.put((ParseObject)localIterator.next(), Boolean.valueOf(true));
    }
    k localk = new k(new ArrayList(localIdentityHashMap.keySet()));
    return m.a(null).a(new ParseObject.37.1(this, localk), new ParseObject.37.2(this, localk));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.37
 * JD-Core Version:    0.7.0.1
 */