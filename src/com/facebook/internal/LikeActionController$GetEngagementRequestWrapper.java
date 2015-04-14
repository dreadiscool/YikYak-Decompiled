package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.Response;
import org.json.JSONObject;

class LikeActionController$GetEngagementRequestWrapper
  extends LikeActionController.AbstractRequestWrapper
{
  String likeCountStringWithLike = LikeActionController.access$900(this.this$0);
  String likeCountStringWithoutLike = LikeActionController.access$1000(this.this$0);
  String socialSentenceStringWithLike = LikeActionController.access$1100(this.this$0);
  String socialSentenceStringWithoutLike = LikeActionController.access$1200(this.this$0);
  
  LikeActionController$GetEngagementRequestWrapper(LikeActionController paramLikeActionController, String paramString)
  {
    super(paramLikeActionController, paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
    setRequest(new Request(LikeActionController.access$2700(paramLikeActionController), paramString, localBundle, HttpMethod.GET));
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    LoggingBehavior localLoggingBehavior = LoggingBehavior.REQUESTS;
    String str = LikeActionController.access$1600();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.objectId;
    arrayOfObject[1] = paramFacebookRequestError;
    Logger.log(localLoggingBehavior, str, "Error fetching engagement for object '%s' : %s", arrayOfObject);
    LikeActionController.access$2600(this.this$0, "get_engagement", paramFacebookRequestError);
  }
  
  protected void processSuccess(Response paramResponse)
  {
    JSONObject localJSONObject = Utility.tryGetJSONObjectFromResponse(paramResponse.getGraphObject(), "engagement");
    if (localJSONObject != null)
    {
      this.likeCountStringWithLike = localJSONObject.optString("count_string_with_like", this.likeCountStringWithLike);
      this.likeCountStringWithoutLike = localJSONObject.optString("count_string_without_like", this.likeCountStringWithoutLike);
      this.socialSentenceStringWithLike = localJSONObject.optString("social_sentence_with_like", this.socialSentenceStringWithLike);
      this.socialSentenceStringWithoutLike = localJSONObject.optString("social_sentence_without_like", this.socialSentenceStringWithoutLike);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.GetEngagementRequestWrapper
 * JD-Core Version:    0.7.0.1
 */