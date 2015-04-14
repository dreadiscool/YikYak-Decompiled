package com.facebook.internal;

import android.os.Bundle;
import com.facebook.RequestBatch;

class LikeActionController$6
  implements LikeActionController.RequestCompletionCallback
{
  LikeActionController$6(LikeActionController paramLikeActionController, Bundle paramBundle) {}
  
  public void onComplete()
  {
    if (Utility.isNullOrEmpty(LikeActionController.access$1900(this.this$0)))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Invalid Object Id");
      LikeActionController.access$1800(this.this$0, "com.facebook.sdk.LikeActionController.DID_ERROR", localBundle);
    }
    for (;;)
    {
      return;
      RequestBatch localRequestBatch = new RequestBatch();
      LikeActionController.PublishLikeRequestWrapper localPublishLikeRequestWrapper = new LikeActionController.PublishLikeRequestWrapper(this.this$0, LikeActionController.access$1900(this.this$0));
      localPublishLikeRequestWrapper.addToBatch(localRequestBatch);
      localRequestBatch.addCallback(new LikeActionController.6.1(this, localPublishLikeRequestWrapper));
      localRequestBatch.executeAsync();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.6
 * JD-Core Version:    0.7.0.1
 */