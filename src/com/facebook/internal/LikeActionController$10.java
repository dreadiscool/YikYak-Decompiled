package com.facebook.internal;

import com.facebook.FacebookRequestError;
import com.facebook.LoggingBehavior;
import com.facebook.RequestBatch;
import com.facebook.RequestBatch.Callback;

class LikeActionController$10
  implements RequestBatch.Callback
{
  LikeActionController$10(LikeActionController paramLikeActionController, LikeActionController.GetOGObjectIdRequestWrapper paramGetOGObjectIdRequestWrapper, LikeActionController.GetPageIdRequestWrapper paramGetPageIdRequestWrapper, LikeActionController.RequestCompletionCallback paramRequestCompletionCallback) {}
  
  public void onBatchCompleted(RequestBatch paramRequestBatch)
  {
    LikeActionController.access$1902(this.this$0, this.val$objectIdRequest.verifiedObjectId);
    if (Utility.isNullOrEmpty(LikeActionController.access$1900(this.this$0)))
    {
      LikeActionController.access$1902(this.this$0, this.val$pageIdRequest.verifiedObjectId);
      LikeActionController.access$2502(this.this$0, this.val$pageIdRequest.objectIsPage);
    }
    LikeActionController localLikeActionController;
    if (Utility.isNullOrEmpty(LikeActionController.access$1900(this.this$0)))
    {
      LoggingBehavior localLoggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
      String str = LikeActionController.access$1600();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = LikeActionController.access$2400(this.this$0);
      Logger.log(localLoggingBehavior, str, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", arrayOfObject);
      localLikeActionController = this.this$0;
      if (this.val$pageIdRequest.error == null) {
        break label158;
      }
    }
    label158:
    for (FacebookRequestError localFacebookRequestError = this.val$pageIdRequest.error;; localFacebookRequestError = this.val$objectIdRequest.error)
    {
      LikeActionController.access$2600(localLikeActionController, "get_verified_id", localFacebookRequestError);
      if (this.val$completionHandler != null) {
        this.val$completionHandler.onComplete();
      }
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.10
 * JD-Core Version:    0.7.0.1
 */