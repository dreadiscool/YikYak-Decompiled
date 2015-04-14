package com.parse;

import l;
import m;

class ParseQuery$19
  implements l<Object, m<Object>>
{
  ParseQuery$19(ParseQuery paramParseQuery, boolean paramBoolean) {}
  
  public m<Object> then(m<Object> paramm)
  {
    if (this.val$caching)
    {
      Object localObject = paramm.e();
      Parse.saveToKeyValueCache(ParseQuery.access$400(this.this$0).getCacheKey(), localObject.toString());
    }
    return paramm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.19
 * JD-Core Version:    0.7.0.1
 */