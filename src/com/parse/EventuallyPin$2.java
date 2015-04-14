package com.parse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l;
import m;

final class EventuallyPin$2
  implements l<List<EventuallyPin>, m<List<EventuallyPin>>>
{
  public m<List<EventuallyPin>> then(m<List<EventuallyPin>> paramm)
  {
    List localList = (List)paramm.e();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ParseObject localParseObject = ((EventuallyPin)localIterator.next()).getObject();
      if (localParseObject != null) {
        localArrayList.add(localParseObject.fetchFromLocalDatastoreAsync().j());
      }
    }
    return m.a(localArrayList).b(new EventuallyPin.2.1(this, localList));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.EventuallyPin.2
 * JD-Core Version:    0.7.0.1
 */