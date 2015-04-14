package com.parse;

import l;
import m;
import org.json.JSONObject;

final class PushRouter$9
  implements l<Void, Void>
{
  PushRouter$9(JSONObject paramJSONObject) {}
  
  public Void then(m<Void> paramm)
  {
    if (this.val$pushPayload != null) {
      PushRouter.access$000().handlePpnsPush(this.val$pushPayload);
    }
    return null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushRouter.9
 * JD-Core Version:    0.7.0.1
 */