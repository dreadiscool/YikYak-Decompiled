package com.parse;

import java.util.Set;
import k;
import l;
import m;

class PushService$6
  implements l<Boolean, m<Set<String>>>
{
  PushService$6(PushService paramPushService, k paramk) {}
  
  public m<Set<String>> then(m<Boolean> paramm)
  {
    this.val$forceEnabledCapture.a(paramm.e());
    return PushRouter.getSubscriptionsAsync(true);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushService.6
 * JD-Core Version:    0.7.0.1
 */