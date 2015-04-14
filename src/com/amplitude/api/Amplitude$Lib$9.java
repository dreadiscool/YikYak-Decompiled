package com.amplitude.api;

import org.json.JSONArray;

class Amplitude$Lib$9
  implements Runnable
{
  Amplitude$Lib$9(Amplitude.Lib paramLib, JSONArray paramJSONArray, long paramLong) {}
  
  public void run()
  {
    Amplitude.Lib.access$2700(this.this$0, "https://api.amplitude.com/", this.val$events.toString(), this.val$maxId);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.amplitude.api.Amplitude.Lib.9
 * JD-Core Version:    0.7.0.1
 */