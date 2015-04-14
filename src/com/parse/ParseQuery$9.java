package com.parse;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

class ParseQuery$9
  implements Callable<List<T>>
{
  ParseQuery$9(ParseQuery paramParseQuery) {}
  
  public List<T> call()
  {
    Object localObject = Parse.jsonFromKeyValueCache(ParseQuery.access$900(this.this$0, ParseUser.getCurrentSessionToken()).getCacheKey(), ParseQuery.access$1000(this.this$0));
    if (localObject == null) {
      throw new ParseException(120, "results not cached");
    }
    if (!(localObject instanceof JSONObject)) {
      throw new ParseException(120, "the cache contains the wrong datatype");
    }
    JSONObject localJSONObject = (JSONObject)localObject;
    try
    {
      List localList = ParseQuery.access$800(this.this$0, localJSONObject);
      return localList;
    }
    catch (JSONException localJSONException)
    {
      throw new ParseException(120, "the cache contains corrupted json");
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.9
 * JD-Core Version:    0.7.0.1
 */