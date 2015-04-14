package com.facebook.internal;

import com.facebook.LoggingBehavior;
import com.facebook.RequestBatch;
import com.facebook.RequestBatch.Callback;

class LikeActionController$8$1
  implements RequestBatch.Callback
{
  LikeActionController$8$1(LikeActionController.8 param8, LikeActionController.GetOGObjectLikesRequestWrapper paramGetOGObjectLikesRequestWrapper, LikeActionController.GetEngagementRequestWrapper paramGetEngagementRequestWrapper) {}
  
  public void onBatchCompleted(RequestBatch paramRequestBatch)
  {
    if ((this.val$objectLikesRequest.error != null) || (this.val$engagementRequest.error != null))
    {
      LoggingBehavior localLoggingBehavior = LoggingBehavior.REQUESTS;
      String str = LikeActionController.access$1600();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = LikeActionController.access$2400(this.this$1.this$0);
      Logger.log(localLoggingBehavior, str, "Unable to refresh like state for id: '%s'", arrayOfObject);
    }
    for (;;)
    {
      return;
      LikeActionController.access$1500(this.this$1.this$0, this.val$objectLikesRequest.objectIsLiked, this.val$engagementRequest.likeCountStringWithLike, this.val$engagementRequest.likeCountStringWithoutLike, this.val$engagementRequest.socialSentenceStringWithLike, this.val$engagementRequest.socialSentenceStringWithoutLike, this.val$objectLikesRequest.unlikeToken);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.8.1
 * JD-Core Version:    0.7.0.1
 */