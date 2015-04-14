package com.parse;

import l;
import m;

final class ParsePush$1
  implements l<Void, Void>
{
  ParsePush$1(boolean paramBoolean) {}
  
  public Void then(m<Void> paramm)
  {
    if (!this.val$enabled) {
      PushService.stopPpnsService(Parse.applicationContext);
    }
    for (;;)
    {
      return null;
      PushService.startServiceIfRequired(Parse.applicationContext);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePush.1
 * JD-Core Version:    0.7.0.1
 */