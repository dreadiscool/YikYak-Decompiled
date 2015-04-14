package com.parse;

import java.util.concurrent.Callable;
import m;

class ParseQuery$13
  implements Callable<m<TResult>>
{
  ParseQuery$13(ParseQuery paramParseQuery, ParseQuery.CallableWithCachePolicy paramCallableWithCachePolicy, ParseCallback paramParseCallback) {}
  
  public m<TResult> call()
  {
    if (ParseQuery.access$500(this.this$0) == ParseQuery.CachePolicy.CACHE_THEN_NETWORK) {}
    for (m localm = Parse.callbackOnMainThreadAsync((m)this.val$callable.call(ParseQuery.CachePolicy.CACHE_ONLY), this.val$callback).b(new ParseQuery.13.1(this));; localm = (m)this.val$callable.call(ParseQuery.access$500(this.this$0))) {
      return localm;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.13
 * JD-Core Version:    0.7.0.1
 */