package com.amplitude.api;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class Amplitude$Lib$8
  implements Runnable
{
  Amplitude$Lib$8(Amplitude.Lib paramLib, JSONObject paramJSONObject1, JSONObject paramJSONObject2) {}
  
  public void run()
  {
    Iterator localIterator = this.val$userProperties.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        this.val$currentUserProperties.put(str, this.val$userProperties.get(str));
      }
      catch (JSONException localJSONException)
      {
        localJSONException.toString();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.amplitude.api.Amplitude.Lib.8
 * JD-Core Version:    0.7.0.1
 */