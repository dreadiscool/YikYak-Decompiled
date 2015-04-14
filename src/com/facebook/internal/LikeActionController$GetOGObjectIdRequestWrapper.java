package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.Response;
import org.json.JSONObject;

class LikeActionController$GetOGObjectIdRequestWrapper
  extends LikeActionController.AbstractRequestWrapper
{
  String verifiedObjectId;
  
  LikeActionController$GetOGObjectIdRequestWrapper(LikeActionController paramLikeActionController, String paramString)
  {
    super(paramLikeActionController, paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", "og_object.fields(id)");
    localBundle.putString("ids", paramString);
    setRequest(new Request(LikeActionController.access$2700(paramLikeActionController), "", localBundle, HttpMethod.GET));
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    if (paramFacebookRequestError.getErrorMessage().contains("og_object")) {
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
      Logger.log(localLoggingBehavior, str, "Error getting the FB id for object '%s' : %s", arrayOfObject);
    }
  }
  
  protected void processSuccess(Response paramResponse)
  {
    JSONObject localJSONObject1 = Utility.tryGetJSONObjectFromResponse(paramResponse.getGraphObject(), this.objectId);
    if (localJSONObject1 != null)
    {
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("og_object");
      if (localJSONObject2 != null) {
        this.verifiedObjectId = localJSONObject2.optString("id");
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.GetOGObjectIdRequestWrapper
 * JD-Core Version:    0.7.0.1
 */