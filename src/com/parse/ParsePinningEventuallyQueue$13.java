package com.parse;

import l;
import m;

class ParsePinningEventuallyQueue$13
  implements l<Void, m<Object>>
{
  ParsePinningEventuallyQueue$13(ParsePinningEventuallyQueue paramParsePinningEventuallyQueue, EventuallyPin paramEventuallyPin, ParseOperationSet paramParseOperationSet) {}
  
  public m<Object> then(m<Void> paramm)
  {
    int i = this.val$eventuallyPin.getType();
    ParseObject localParseObject = this.val$eventuallyPin.getObject();
    String str = this.val$eventuallyPin.getSessionToken();
    m localm;
    if (i == 1) {
      localm = localParseObject.saveAsync(this.val$operationSet, str);
    }
    for (;;)
    {
      return localm.b(new ParsePinningEventuallyQueue.13.1(this, i, localParseObject));
      if (i == 2) {
        localm = localParseObject.deleteAsync(str);
      } else {
        localm = this.val$eventuallyPin.getCommand().executeAsync();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePinningEventuallyQueue.13
 * JD-Core Version:    0.7.0.1
 */