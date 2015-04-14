package com.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class GcmRegistrar$Request$1
  extends BroadcastReceiver
{
  GcmRegistrar$Request$1(GcmRegistrar.Request paramRequest) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getIntExtra("random", 0) == GcmRegistrar.Request.access$200(this.this$0))) {
      GcmRegistrar.Request.access$300(this.this$0);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.GcmRegistrar.Request.1
 * JD-Core Version:    0.7.0.1
 */