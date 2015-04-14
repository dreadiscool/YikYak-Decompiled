package com.parse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l;
import m;

class ParsePinningEventuallyQueue$14$1$1
  implements l<List<EventuallyPin>, m<Void>>
{
  ParsePinningEventuallyQueue$14$1$1(ParsePinningEventuallyQueue.14.1 param1) {}
  
  public m<Void> then(m<List<EventuallyPin>> paramm)
  {
    List localList = (List)paramm.e();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((EventuallyPin)localIterator.next()).unpinInBackground("_eventuallyPin"));
    }
    return m.a(localArrayList);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePinningEventuallyQueue.14.1.1
 * JD-Core Version:    0.7.0.1
 */