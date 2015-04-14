package com.parse;

import m;
import y;

class Parse$6$1
  implements Runnable
{
  Parse$6$1(Parse.6 param6, m paramm) {}
  
  public void run()
  {
    for (;;)
    {
      Exception localException;
      try
      {
        localException = this.val$task.f();
        if ((localException == null) || ((localException instanceof ParseException))) {
          break label193;
        }
        localObject2 = new ParseException(localException);
        this.this$0.val$callback.internalDone(this.val$task.e(), (ParseException)localObject2);
        return;
        if (this.val$task.d())
        {
          this.this$0.val$tcs.b(this.val$task.f());
          continue;
        }
        this.this$0.val$tcs.b(this.val$task.e());
        continue;
      }
      finally
      {
        if (this.val$task.c()) {
          this.this$0.val$tcs.c();
        }
      }
      this.this$0.val$tcs.b(this.val$task.e());
      continue;
      label193:
      Object localObject2 = localException;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.Parse.6.1
 * JD-Core Version:    0.7.0.1
 */