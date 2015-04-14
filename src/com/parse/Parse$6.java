package com.parse;

import java.util.concurrent.Executor;
import l;
import m;
import y;

final class Parse$6
  implements l<T, Void>
{
  Parse$6(boolean paramBoolean, y paramy, ParseCallback paramParseCallback) {}
  
  public Void then(m<T> paramm)
  {
    if ((paramm.c()) && (!this.val$reportCancellation)) {
      this.val$tcs.c();
    }
    for (;;)
    {
      return null;
      m.b.execute(new Parse.6.1(this, paramm));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.Parse.6
 * JD-Core Version:    0.7.0.1
 */