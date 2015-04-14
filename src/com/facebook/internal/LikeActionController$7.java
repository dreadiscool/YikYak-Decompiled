package com.facebook.internal;

import android.os.Bundle;
import com.facebook.AppEventsLogger;
import com.facebook.RequestBatch;
import com.facebook.RequestBatch.Callback;

class LikeActionController$7
  implements RequestBatch.Callback
{
  LikeActionController$7(LikeActionController paramLikeActionController, LikeActionController.PublishUnlikeRequestWrapper paramPublishUnlikeRequestWrapper, Bundle paramBundle) {}
  
  public void onBatchCompleted(RequestBatch paramRequestBatch)
  {
    LikeActionController.access$2002(this.this$0, false);
    if (this.val$unlikeRequest.error != null) {
      LikeActionController.access$2100(this.this$0, true);
    }
    for (;;)
    {
      return;
      LikeActionController.access$1302(this.this$0, null);
      LikeActionController.access$2202(this.this$0, false);
      LikeActionController.access$1400(this.this$0).logSdkEvent("fb_like_control_did_unlike", null, this.val$analyticsParameters);
      LikeActionController.access$2300(this.this$0, this.val$analyticsParameters);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.7
 * JD-Core Version:    0.7.0.1
 */