package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.Response;
import org.json.JSONObject;

class LikeActionController$GetPageIdRequestWrapper
  extends LikeActionController.AbstractRequestWrapper
{
  boolean objectIsPage;
  String verifiedObjectId;
  
  LikeActionController$GetPageIdRequestWrapper(LikeActionController paramLikeActionController, String paramString)
  {
    super(paramLikeActionController, paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", "id");
    localBundle.putString("ids", paramString);
    setRequest(new Request(LikeActionController.access$2700(paramLikeActionController), "", localBundle, HttpMethod.GET));
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    LoggingBehavior localLoggingBehavior = LoggingBehavior.REQUESTS;
    String str = LikeActionController.access$1600();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.objectId;
    arrayOfObject[1] = paramFacebookRequestError;
    Logger.log(localLoggingBehavior, str, "Error getting the FB id for object '%s' : %s", arrayOfObject);
  }
  
  protected void processSuccess(Response paramResponse)
  {
    JSONObject localJSONObject = Utility.tryGetJSONObjectFromResponse(paramResponse.getGraphObject(), this.objectId);
    if (localJSONObject != null)
    {
      this.verifiedObjectId = localJSONObject.optString("id");
      if (Utility.isNullOrEmpty(this.verifiedObjectId)) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      this.objectIsPage = bool;
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.GetPageIdRequestWrapper
 * JD-Core Version:    0.7.0.1
 */