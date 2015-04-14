package com.facebook.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.Utility;

class LikeView$LikeControllerBroadcastReceiver
  extends BroadcastReceiver
{
  private LikeView$LikeControllerBroadcastReceiver(LikeView paramLikeView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 1;
    String str1 = paramIntent.getAction();
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle != null)
    {
      String str2 = localBundle.getString("com.facebook.sdk.LikeActionController.OBJECT_ID");
      if ((!Utility.isNullOrEmpty(str2)) && (!Utility.areObjectsEqual(LikeView.access$600(this.this$0), str2))) {}
    }
    else
    {
      if (i != 0) {
        break label61;
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label61:
      if ("com.facebook.sdk.LikeActionController.UPDATED".equals(str1))
      {
        LikeView.access$700(this.this$0);
      }
      else if ("com.facebook.sdk.LikeActionController.DID_ERROR".equals(str1))
      {
        if (LikeView.access$800(this.this$0) != null) {
          LikeView.access$800(this.this$0).onError(localBundle);
        }
      }
      else if ("com.facebook.sdk.LikeActionController.DID_RESET".equals(str1))
      {
        LikeView.access$900(this.this$0, LikeView.access$600(this.this$0));
        LikeView.access$700(this.this$0);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.LikeView.LikeControllerBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */