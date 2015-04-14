package com.facebook;

import android.net.Uri;
import com.facebook.model.GraphObject;
import e;
import f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import y;

class FacebookAppLinkResolver$2
  implements Request.Callback
{
  FacebookAppLinkResolver$2(FacebookAppLinkResolver paramFacebookAppLinkResolver, y paramy, Map paramMap, HashSet paramHashSet) {}
  
  public void onCompleted(Response paramResponse)
  {
    FacebookRequestError localFacebookRequestError = paramResponse.getError();
    if (localFacebookRequestError != null)
    {
      this.val$taskCompletionSource.b(localFacebookRequestError.getException());
      return;
    }
    GraphObject localGraphObject = paramResponse.getGraphObject();
    if (localGraphObject != null) {}
    for (JSONObject localJSONObject1 = localGraphObject.getInnerJSONObject();; localJSONObject1 = null)
    {
      if (localJSONObject1 != null) {
        break label63;
      }
      this.val$taskCompletionSource.b(this.val$appLinkResults);
      break;
    }
    label63:
    Iterator localIterator = this.val$urisToRequest.iterator();
    Uri localUri;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localUri = (Uri)localIterator.next();
    } while (!localJSONObject1.has(localUri.toString()));
    for (;;)
    {
      int j;
      try
      {
        for (;;)
        {
          JSONObject localJSONObject2 = localJSONObject1.getJSONObject(localUri.toString()).getJSONObject("app_links");
          JSONArray localJSONArray = localJSONObject2.getJSONArray("android");
          int i = localJSONArray.length();
          ArrayList localArrayList = new ArrayList(i);
          j = 0;
          if (j < i)
          {
            f localf = FacebookAppLinkResolver.access$000(localJSONArray.getJSONObject(j));
            if (localf == null) {
              break;
            }
            localArrayList.add(localf);
            break;
          }
          e locale = new e(localUri, localArrayList, FacebookAppLinkResolver.access$100(localUri, localJSONObject2));
          this.val$appLinkResults.put(localUri, locale);
          synchronized (FacebookAppLinkResolver.access$200(this.this$0))
          {
            FacebookAppLinkResolver.access$200(this.this$0).put(localUri, locale);
          }
        }
      }
      catch (JSONException localJSONException) {}
      this.val$taskCompletionSource.b(this.val$appLinkResults);
      break;
      j++;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.FacebookAppLinkResolver.2
 * JD-Core Version:    0.7.0.1
 */