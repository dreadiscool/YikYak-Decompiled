package com.parse;

import l;
import m;

class ParsePinningEventuallyQueue$13$1
  implements l<Object, m<Object>>
{
  ParsePinningEventuallyQueue$13$1(ParsePinningEventuallyQueue.13 param13, int paramInt, ParseObject paramParseObject) {}
  
  public m<Object> then(m<Object> paramm)
  {
    Exception localException = paramm.f();
    if ((localException != null) && ((localException instanceof ParseException)) && (((ParseException)localException).getCode() == 100))
    {
      this.this$1.this$0.setConnected(false);
      this.this$1.this$0.notifyTestHelper(7);
    }
    for (m localm = ParsePinningEventuallyQueue.access$1300(this.this$1.this$0, this.this$1.val$eventuallyPin, this.this$1.val$operationSet);; localm = this.this$1.val$eventuallyPin.unpinInBackground("_eventuallyPin").b(new ParsePinningEventuallyQueue.13.1.2(this, paramm)).b(new ParsePinningEventuallyQueue.13.1.1(this, paramm))) {
      return localm;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePinningEventuallyQueue.13.1
 * JD-Core Version:    0.7.0.1
 */