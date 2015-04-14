package com.parse;

import java.util.HashMap;
import l;
import m;
import y;

class ParsePinningEventuallyQueue$12
  implements l<Object, m<Object>>
{
  ParsePinningEventuallyQueue$12(ParsePinningEventuallyQueue paramParsePinningEventuallyQueue, String paramString, y paramy) {}
  
  public m<Object> then(m<Object> paramm)
  {
    for (;;)
    {
      synchronized (ParsePinningEventuallyQueue.access$900(this.this$0))
      {
        ParsePinningEventuallyQueue.access$1000(this.this$0).remove(this.val$uuid);
        ParsePinningEventuallyQueue.access$1100(this.this$0).remove(this.val$uuid);
        ParsePinningEventuallyQueue.access$1200(this.this$0).remove(this.val$uuid);
        Exception localException = paramm.f();
        if (localException != null)
        {
          this.val$tcs.a(localException);
          return this.val$tcs.a();
        }
      }
      if (paramm.c()) {
        this.val$tcs.b();
      } else {
        this.val$tcs.a(paramm.e());
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePinningEventuallyQueue.12
 * JD-Core Version:    0.7.0.1
 */