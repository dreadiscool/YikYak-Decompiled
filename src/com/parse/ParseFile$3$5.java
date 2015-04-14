package com.parse;

import java.util.concurrent.Callable;
import m;
import y;

class ParseFile$3$5
  implements Callable<ParseCommand>
{
  ParseFile$3$5(ParseFile.3 param3, String paramString) {}
  
  public ParseCommand call()
  {
    ParseCommand localParseCommand = ParseFile.access$300(this.this$1.this$0, this.val$sessionToken);
    this.this$1.val$tcs.a().a(new ParseFile.3.5.1(this, localParseCommand));
    return localParseCommand;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseFile.3.5
 * JD-Core Version:    0.7.0.1
 */