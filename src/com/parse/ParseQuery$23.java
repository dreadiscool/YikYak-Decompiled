package com.parse;

import m;

class ParseQuery$23
  implements ParseQuery.CallableWithCachePolicy<m<T>>
{
  ParseQuery$23(ParseQuery paramParseQuery, String paramString, ParseUser paramParseUser) {}
  
  public m<T> call(ParseQuery.CachePolicy paramCachePolicy)
  {
    return ParseQuery.access$1600(this.this$0, this.val$objectId, paramCachePolicy, this.val$user);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.23
 * JD-Core Version:    0.7.0.1
 */