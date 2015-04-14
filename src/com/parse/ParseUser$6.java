package com.parse;

import java.util.concurrent.Callable;

class ParseUser$6
  implements Callable<ParseOperationSet>
{
  ParseUser$6(ParseUser paramParseUser) {}
  
  public ParseOperationSet call()
  {
    synchronized (this.this$0.mutex)
    {
      ParseOperationSet localParseOperationSet = this.this$0.startSave();
      return localParseOperationSet;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.6
 * JD-Core Version:    0.7.0.1
 */