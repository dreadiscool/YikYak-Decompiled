package com.parse;

import org.json.JSONObject;

final class OfflineQueryLogic$5
  implements OfflineQueryLogic.Decider
{
  public boolean decide(Object paramObject1, Object paramObject2)
  {
    boolean bool = false;
    if ((paramObject2 == null) || (paramObject2 == JSONObject.NULL)) {}
    for (;;)
    {
      return bool;
      if (OfflineQueryLogic.access$000(paramObject1, paramObject2) <= 0) {
        bool = true;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineQueryLogic.5
 * JD-Core Version:    0.7.0.1
 */