package com.parse;

import java.util.Iterator;
import org.json.JSONObject;

final class Parse$5
  implements Iterable<String>
{
  Parse$5(JSONObject paramJSONObject) {}
  
  public Iterator<String> iterator()
  {
    return this.val$finalObject.keys();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.Parse.5
 * JD-Core Version:    0.7.0.1
 */