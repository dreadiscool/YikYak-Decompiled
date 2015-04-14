package com.parse;

import l;
import m;
import y;

class ParseRequest$8$1$1
  implements l<Response, m<Void>>
{
  ParseRequest$8$1$1(ParseRequest.8.1 param1) {}
  
  public m<Void> then(m<Response> paramm)
  {
    if (paramm.c()) {
      this.this$2.val$retryTask.c();
    }
    for (;;)
    {
      return null;
      if (paramm.d()) {
        this.this$2.val$retryTask.b(paramm.f());
      } else {
        this.this$2.val$retryTask.b(paramm.e());
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseRequest.8.1.1
 * JD-Core Version:    0.7.0.1
 */