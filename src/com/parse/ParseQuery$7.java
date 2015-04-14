package com.parse;

import java.util.concurrent.Callable;

class ParseQuery$7
  implements Callable<Void>
{
  ParseQuery$7(ParseQuery paramParseQuery, boolean paramBoolean) {}
  
  public Void call()
  {
    if (this.val$shouldRetry) {
      ParseQuery.access$400(this.this$0).enableRetrying();
    }
    return null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.7
 * JD-Core Version:    0.7.0.1
 */