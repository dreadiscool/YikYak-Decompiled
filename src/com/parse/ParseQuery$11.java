package com.parse;

import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

class ParseQuery$11
  implements Callable<Integer>
{
  ParseQuery$11(ParseQuery paramParseQuery) {}
  
  public Integer call()
  {
    Object localObject = Parse.jsonFromKeyValueCache(ParseQuery.access$1100(this.this$0, ParseUser.getCurrentSessionToken()).getCacheKey(), ParseQuery.access$1000(this.this$0));
    if (localObject == null) {
      throw new ParseException(120, "results not cached");
    }
    if (!(localObject instanceof JSONObject)) {
      throw new ParseException(120, "the cache contains the wrong datatype");
    }
    JSONObject localJSONObject = (JSONObject)localObject;
    try
    {
      Integer localInteger = Integer.valueOf(localJSONObject.getInt("count"));
      return localInteger;
    }
    catch (JSONException localJSONException)
    {
      throw new ParseException(120, "the cache contains corrupted json");
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.11
 * JD-Core Version:    0.7.0.1
 */