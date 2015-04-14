package com.parse;

import java.util.HashMap;
import l;
import m;

class ParsePinningEventuallyQueue$5$1
  implements l<EventuallyPin, m<Void>>
{
  ParsePinningEventuallyQueue$5$1(ParsePinningEventuallyQueue.5 param5) {}
  
  public m<Void> then(m<EventuallyPin> paramm)
  {
    EventuallyPin localEventuallyPin = (EventuallyPin)paramm.e();
    Exception localException = paramm.f();
    if (localException != null)
    {
      if (5 >= Parse.getLogLevel()) {
        Parse.logW("ParsePinningEventuallyQueue", "Unable to save command for later.", localException);
      }
      this.this$1.this$0.notifyTestHelper(4);
    }
    for (m localm = m.a(null);; localm = paramm.j())
    {
      return localm;
      ParsePinningEventuallyQueue.access$200(this.this$1.this$0).put(localEventuallyPin.getUUID(), this.this$1.val$tcs);
      ParsePinningEventuallyQueue.access$300(this.this$1.this$0).b(new ParsePinningEventuallyQueue.5.1.1(this));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePinningEventuallyQueue.5.1
 * JD-Core Version:    0.7.0.1
 */