package com.parse;

import java.util.List;
import l;
import m;

class ParsePinningEventuallyQueue$8
  implements l<Void, m<List<EventuallyPin>>>
{
  ParsePinningEventuallyQueue$8(ParsePinningEventuallyQueue paramParsePinningEventuallyQueue) {}
  
  public m<List<EventuallyPin>> then(m<Void> paramm)
  {
    return EventuallyPin.findAllPinned(ParsePinningEventuallyQueue.access$600(this.this$0));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePinningEventuallyQueue.8
 * JD-Core Version:    0.7.0.1
 */