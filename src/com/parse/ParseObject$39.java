package com.parse;

import java.util.List;
import l;
import m;

final class ParseObject$39
  implements l<Void, m<List<T>>>
{
  ParseObject$39(ParseQuery paramParseQuery, ParseUser paramParseUser) {}
  
  public m<List<T>> then(m<Void> paramm)
  {
    return this.val$query.findWithCachePolicyAsync(ParseQuery.CachePolicy.IGNORE_CACHE, this.val$user);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.39
 * JD-Core Version:    0.7.0.1
 */