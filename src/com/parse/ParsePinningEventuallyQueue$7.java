package com.parse;

import java.util.Iterator;
import java.util.List;
import l;
import m;

class ParsePinningEventuallyQueue$7
  implements l<List<EventuallyPin>, m<Void>>
{
  ParsePinningEventuallyQueue$7(ParsePinningEventuallyQueue paramParsePinningEventuallyQueue) {}
  
  public m<Void> then(m<List<EventuallyPin>> paramm)
  {
    Iterator localIterator = ((List)paramm.e()).iterator();
    while (localIterator.hasNext())
    {
      EventuallyPin localEventuallyPin = (EventuallyPin)localIterator.next();
      ParsePinningEventuallyQueue.access$500(this.this$0, localEventuallyPin);
    }
    return paramm.j();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePinningEventuallyQueue.7
 * JD-Core Version:    0.7.0.1
 */