package com.parse;

import java.util.HashMap;
import l;
import m;
import y;

class ParsePinningEventuallyQueue$10$1
  implements l<Object, m<Void>>
{
  ParsePinningEventuallyQueue$10$1(ParsePinningEventuallyQueue.10 param10) {}
  
  public m<Void> then(m<Object> paramm)
  {
    Exception localException = paramm.f();
    m localm;
    label52:
    y localy;
    if (localException != null)
    {
      if ((localException instanceof ParsePinningEventuallyQueue.PauseException))
      {
        localm = paramm.j();
        return localm;
      }
      if (6 >= Parse.getLogLevel()) {
        Parse.logE("ParsePinningEventuallyQueue", "Failed to run command.", localException);
      }
      this.this$1.this$0.notifyTestHelper(2);
      localy = (y)ParsePinningEventuallyQueue.access$200(this.this$1.this$0).remove(this.this$1.val$eventuallyPin.getUUID());
      if (localy != null)
      {
        if (localException == null) {
          break label115;
        }
        localy.b(localException);
      }
    }
    for (;;)
    {
      localm = paramm.j();
      break;
      this.this$1.this$0.notifyTestHelper(1);
      break label52;
      label115:
      localy.b(paramm.e());
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePinningEventuallyQueue.10.1
 * JD-Core Version:    0.7.0.1
 */