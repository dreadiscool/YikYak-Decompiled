package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.Response;

class LikeActionController$PublishLikeRequestWrapper
  extends LikeActionController.AbstractRequestWrapper
{
  String unlikeToken;
  
  LikeActionController$PublishLikeRequestWrapper(LikeActionController paramLikeActionController, String paramString)
  {
    super(paramLikeActionController, paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("object", paramString);
    setRequest(new Request(LikeActionController.access$2700(paramLikeActionController), "me/og.likes", localBundle, HttpMethod.POST));
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    if (paramFacebookRequestError.getErrorCode() == 3501) {
      this.error = null;
    }
    for (;;)
    {
      return;
      LoggingBehavior localLoggingBehavior = LoggingBehavior.REQUESTS;
      String str = LikeActionController.access$1600();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.objectId;
      arrayOfObject[1] = paramFacebookRequestError;
      Logger.log(localLoggingBehavior, str, "Error liking object '%s' : %s", arrayOfObject);
      LikeActionController.access$2600(this.this$0, "publish_like", paramFacebookRequestError);
    }
  }
  
  protected void processSuccess(Response paramResponse)
  {
    this.unlikeToken = Utility.safeGetStringFromResponse(paramResponse.getGraphObject(), "id");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.PublishLikeRequestWrapper
 * JD-Core Version:    0.7.0.1
 */