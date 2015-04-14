package com.parse;

import l;
import m;
import y;

class ParsePinningEventuallyQueue$5
  implements l<Void, m<Void>>
{
  ParsePinningEventuallyQueue$5(ParsePinningEventuallyQueue paramParsePinningEventuallyQueue, ParseObject paramParseObject, ParseCommand paramParseCommand, y paramy) {}
  
  public m<Void> then(m<Void> paramm)
  {
    return EventuallyPin.pinEventuallyCommand(this.val$object, this.val$command).b(new ParsePinningEventuallyQueue.5.1(this));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePinningEventuallyQueue.5
 * JD-Core Version:    0.7.0.1
 */