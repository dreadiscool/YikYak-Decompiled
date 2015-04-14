package com.parse;

import l;
import m;

final class PushRouter$2
  implements l<Void, Void>
{
  PushRouter$2(String paramString) {}
  
  public Void then(m<Void> paramm)
  {
    PushRouter.access$000().unsubscribe(this.val$channel);
    return null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushRouter.2
 * JD-Core Version:    0.7.0.1
 */