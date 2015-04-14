package com.parse;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import l;
import m;
import org.apache.http.client.methods.HttpUriRequest;
import y;

class ParseRequest$8
  implements l<Response, m<Response>>
{
  ParseRequest$8(ParseRequest paramParseRequest, int paramInt, long paramLong, ProgressCallback paramProgressCallback) {}
  
  public m<Response> then(m<Response> paramm)
  {
    if ((paramm.d()) && ((paramm.f() instanceof ParseException)))
    {
      if (!((y)ParseRequest.access$400(this.this$0).get()).a().c()) {
        break label45;
      }
      paramm = m.h();
    }
    for (;;)
    {
      return paramm;
      label45:
      if (this.val$attemptsMade < this.this$0.maxRetries)
      {
        Parse.logI("com.parse.ParseRequest", "Request failed. Waiting " + this.val$delay + " milliseconds before attempt #" + (1 + this.val$attemptsMade));
        y localy = m.a();
        Parse.getScheduledExecutor().schedule(new ParseRequest.8.1(this, localy), this.val$delay, TimeUnit.MILLISECONDS);
        paramm = localy.a();
      }
      else if (!ParseRequest.access$000(this.this$0).isAborted())
      {
        Parse.logI("com.parse.ParseRequest", "Request failed. Giving up.");
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseRequest.8
 * JD-Core Version:    0.7.0.1
 */