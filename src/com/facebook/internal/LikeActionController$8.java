package com.facebook.internal;

import com.facebook.RequestBatch;

class LikeActionController$8
  implements LikeActionController.RequestCompletionCallback
{
  LikeActionController$8(LikeActionController paramLikeActionController) {}
  
  public void onComplete()
  {
    LikeActionController.GetOGObjectLikesRequestWrapper localGetOGObjectLikesRequestWrapper = new LikeActionController.GetOGObjectLikesRequestWrapper(this.this$0, LikeActionController.access$1900(this.this$0));
    LikeActionController.GetEngagementRequestWrapper localGetEngagementRequestWrapper = new LikeActionController.GetEngagementRequestWrapper(this.this$0, LikeActionController.access$1900(this.this$0));
    RequestBatch localRequestBatch = new RequestBatch();
    localGetOGObjectLikesRequestWrapper.addToBatch(localRequestBatch);
    localGetEngagementRequestWrapper.addToBatch(localRequestBatch);
    localRequestBatch.addCallback(new LikeActionController.8.1(this, localGetOGObjectLikesRequestWrapper, localGetEngagementRequestWrapper));
    localRequestBatch.executeAsync();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.8
 * JD-Core Version:    0.7.0.1
 */