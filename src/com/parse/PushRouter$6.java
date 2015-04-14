package com.parse;

import java.util.Set;
import l;
import m;

final class PushRouter$6
  implements l<Void, Set<String>>
{
  PushRouter$6(boolean paramBoolean) {}
  
  public Set<String> then(m<Void> paramm)
  {
    return PushRouter.access$000().getSubscriptions(this.val$includeDefaultRoute);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushRouter.6
 * JD-Core Version:    0.7.0.1
 */