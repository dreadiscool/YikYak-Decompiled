package com.parse;

import java.util.List;
import m;

class ParseQuery$15
  implements ParseQuery.CallableWithCachePolicy<m<List<T>>>
{
  ParseQuery$15(ParseQuery paramParseQuery, ParseUser paramParseUser) {}
  
  public m<List<T>> call(ParseQuery.CachePolicy paramCachePolicy)
  {
    return this.this$0.findWithCachePolicyAsync(paramCachePolicy, this.val$user);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.15
 * JD-Core Version:    0.7.0.1
 */