package com.parse;

import l;
import m;
import org.json.JSONObject;

final class PushRouter$14
  implements l<Void, Void>
{
  PushRouter$14(PushRouter.PushListener paramPushListener, JSONObject paramJSONObject, PushRouter.HandlePushResult paramHandlePushResult) {}
  
  public Void then(m<Void> paramm)
  {
    this.val$finalListener.onPushHandled(this.val$pushData, this.val$result);
    return null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushRouter.14
 * JD-Core Version:    0.7.0.1
 */