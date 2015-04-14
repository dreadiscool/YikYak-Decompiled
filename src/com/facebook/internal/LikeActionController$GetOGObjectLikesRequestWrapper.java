package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import org.json.JSONArray;
import org.json.JSONObject;

class LikeActionController$GetOGObjectLikesRequestWrapper
  extends LikeActionController.AbstractRequestWrapper
{
  boolean objectIsLiked = LikeActionController.access$2800(this.this$0);
  String unlikeToken;
  
  LikeActionController$GetOGObjectLikesRequestWrapper(LikeActionController paramLikeActionController, String paramString)
  {
    super(paramLikeActionController, paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", "id,application");
    localBundle.putString("object", paramString);
    setRequest(new Request(LikeActionController.access$2700(paramLikeActionController), "me/og.likes", localBundle, HttpMethod.GET));
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    LoggingBehavior localLoggingBehavior = LoggingBehavior.REQUESTS;
    String str = LikeActionController.access$1600();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.objectId;
    arrayOfObject[1] = paramFacebookRequestError;
    Logger.log(localLoggingBehavior, str, "Error fetching like status for object '%s' : %s", arrayOfObject);
    LikeActionController.access$2600(this.this$0, "get_og_object_like", paramFacebookRequestError);
  }
  
  protected void processSuccess(Response paramResponse)
  {
    JSONArray localJSONArray = Utility.tryGetJSONArrayFromResponse(paramResponse.getGraphObject(), "data");
    if (localJSONArray != null) {
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        JSONObject localJSONObject1 = localJSONArray.optJSONObject(i);
        if (localJSONObject1 != null)
        {
          this.objectIsLiked = true;
          JSONObject localJSONObject2 = localJSONObject1.optJSONObject("application");
          if ((localJSONObject2 != null) && (Utility.areObjectsEqual(LikeActionController.access$2700(this.this$0).getApplicationId(), localJSONObject2.optString("id")))) {
            this.unlikeToken = localJSONObject1.optString("id");
          }
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.GetOGObjectLikesRequestWrapper
 * JD-Core Version:    0.7.0.1
 */