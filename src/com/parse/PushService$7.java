package com.parse;

import android.content.Intent;

class PushService$7
  implements Runnable
{
  PushService$7(PushService paramPushService, Intent paramIntent, int paramInt) {}
  
  public void run()
  {
    try
    {
      PushService.access$000(this.this$0, this.val$intent);
      return;
    }
    finally
    {
      ServiceUtils.completeWakefulIntent(this.val$intent);
      this.this$0.stopSelf(this.val$startId);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushService.7
 * JD-Core Version:    0.7.0.1
 */