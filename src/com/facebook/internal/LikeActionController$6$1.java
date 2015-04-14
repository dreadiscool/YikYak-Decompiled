package com.facebook.internal;

import com.facebook.AppEventsLogger;
import com.facebook.RequestBatch;
import com.facebook.RequestBatch.Callback;

class LikeActionController$6$1
  implements RequestBatch.Callback
{
  LikeActionController$6$1(LikeActionController.6 param6, LikeActionController.PublishLikeRequestWrapper paramPublishLikeRequestWrapper) {}
  
  public void onBatchCompleted(RequestBatch paramRequestBatch)
  {
    LikeActionController.access$2002(this.this$1.this$0, false);
    if (this.val$likeRequest.error != null) {
      LikeActionController.access$2100(this.this$1.this$0, false);
    }
    for (;;)
    {
      return;
      LikeActionController.access$1302(this.this$1.this$0, Utility.coerceValueIfNullOrEmpty(this.val$likeRequest.unlikeToken, null));
      LikeActionController.access$2202(this.this$1.this$0, true);
      LikeActionController.access$1400(this.this$1.this$0).logSdkEvent("fb_like_control_did_like", null, this.this$1.val$analyticsParameters);
      LikeActionController.access$2300(this.this$1.this$0, this.this$1.val$analyticsParameters);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.6.1
 * JD-Core Version:    0.7.0.1
 */