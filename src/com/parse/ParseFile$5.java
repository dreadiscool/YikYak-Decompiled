package com.parse;

import l;
import m;
import y;

class ParseFile$5
  implements l<byte[], Void>
{
  ParseFile$5(ParseFile paramParseFile, y paramy, ProgressCallback paramProgressCallback) {}
  
  public Void then(m<byte[]> paramm)
  {
    byte[] arrayOfByte = (byte[])paramm.e();
    if (arrayOfByte != null) {
      this.val$tcs.a(arrayOfByte);
    }
    for (;;)
    {
      return null;
      new ParseAWSRequest(ParseFile.access$400(this.this$0)).executeAsync(this.val$progressCallback).b(new ParseFile.5.2(this)).a(new ParseFile.5.1(this));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseFile.5
 * JD-Core Version:    0.7.0.1
 */