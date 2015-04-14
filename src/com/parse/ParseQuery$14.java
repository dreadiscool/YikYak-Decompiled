package com.parse;

import java.util.List;
import java.util.concurrent.Callable;
import m;

class ParseQuery$14
  implements Callable<m<List<T>>>
{
  ParseQuery$14(ParseQuery paramParseQuery, ParseUser paramParseUser) {}
  
  public m<List<T>> call()
  {
    return this.this$0.findWithCachePolicyAsync(ParseQuery.access$500(this.this$0), this.val$user);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.14
 * JD-Core Version:    0.7.0.1
 */