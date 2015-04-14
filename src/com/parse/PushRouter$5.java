package com.parse;

import l;
import m;

final class PushRouter$5
  implements l<Void, PushRoutes.Route>
{
  PushRouter$5(String paramString) {}
  
  public PushRoutes.Route then(m<Void> paramm)
  {
    PushRoutes.Route localRoute = PushRouter.access$200(PushRouter.access$000()).get(this.val$channel);
    if ((localRoute == null) && (this.val$channel != null)) {
      localRoute = PushRouter.access$200(PushRouter.access$000()).get(null);
    }
    return localRoute;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushRouter.5
 * JD-Core Version:    0.7.0.1
 */