package com.parse;

import l;
import m;

class ParsePinningEventuallyQueue$3
  implements l<Void, m<Integer>>
{
  ParsePinningEventuallyQueue$3(ParsePinningEventuallyQueue paramParsePinningEventuallyQueue) {}
  
  public m<Integer> then(m<Void> paramm)
  {
    return EventuallyPin.findAllPinned().b(new ParsePinningEventuallyQueue.3.1(this));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePinningEventuallyQueue.3
 * JD-Core Version:    0.7.0.1
 */