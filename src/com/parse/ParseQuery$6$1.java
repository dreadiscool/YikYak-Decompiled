package com.parse;

import java.util.List;
import l;
import m;
import org.json.JSONObject;

class ParseQuery$6$1
  implements l<Object, List<T>>
{
  ParseQuery$6$1(ParseQuery.6 param6, boolean paramBoolean) {}
  
  public List<T> then(m<Object> paramm)
  {
    if (this.val$caching)
    {
      Object localObject = paramm.e();
      Parse.saveToKeyValueCache(ParseQuery.access$400(this.this$1.this$0).getCacheKey(), localObject.toString());
    }
    ParseQuery.access$702(this.this$1.this$0, System.nanoTime());
    return ParseQuery.access$800(this.this$1.this$0, (JSONObject)paramm.e());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.6.1
 * JD-Core Version:    0.7.0.1
 */