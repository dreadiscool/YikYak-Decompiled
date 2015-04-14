package com.parse;

import java.util.Set;
import l;
import m;

final class PushService$2
  implements l<Set<String>, Void>
{
  public Void then(m<Set<String>> paramm)
  {
    if (((Set)paramm.e()).size() == 0) {
      PushService.stopPpnsService(Parse.applicationContext);
    }
    return null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushService.2
 * JD-Core Version:    0.7.0.1
 */