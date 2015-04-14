package com.parse;

import l;
import m;

class ParseRequest$6
  implements l<Void, m<Response>>
{
  ParseRequest$6(ParseRequest paramParseRequest, ProgressCallback paramProgressCallback) {}
  
  public m<Response> then(m<Void> paramm)
  {
    long l = ParseRequest.access$200() + (ParseRequest.access$200() * Math.random());
    if (ParseRequest.access$000(this.this$0) == null) {
      ParseRequest.access$002(this.this$0, this.this$0.newRequest());
    }
    return ParseRequest.access$300(this.this$0, 0, l, this.val$progressCallback);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseRequest.6
 * JD-Core Version:    0.7.0.1
 */