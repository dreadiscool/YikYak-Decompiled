package com.parse;

import com.parse.internal.AsyncCallback;
import com.parse.twitter.Twitter;
import org.json.JSONException;
import org.json.JSONObject;

class TwitterAuthenticationProvider$1
  implements AsyncCallback
{
  TwitterAuthenticationProvider$1(TwitterAuthenticationProvider paramTwitterAuthenticationProvider, ParseAuthenticationProvider.ParseAuthenticationCallback paramParseAuthenticationCallback) {}
  
  public void onCancel()
  {
    TwitterAuthenticationProvider.access$000(this.this$0, this.val$callback);
  }
  
  public void onFailure(Throwable paramThrowable)
  {
    if (TwitterAuthenticationProvider.access$100(this.this$0) != this.val$callback) {}
    for (;;)
    {
      return;
      try
      {
        this.val$callback.onError(paramThrowable);
        TwitterAuthenticationProvider.access$102(this.this$0, null);
      }
      finally
      {
        TwitterAuthenticationProvider.access$102(this.this$0, null);
      }
    }
  }
  
  public void onSuccess(Object paramObject)
  {
    if (TwitterAuthenticationProvider.access$100(this.this$0) != this.val$callback) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = this.this$0.getAuthData(TwitterAuthenticationProvider.access$200(this.this$0).getUserId(), TwitterAuthenticationProvider.access$200(this.this$0).getScreenName(), TwitterAuthenticationProvider.access$200(this.this$0).getAuthToken(), TwitterAuthenticationProvider.access$200(this.this$0).getAuthTokenSecret());
        this.val$callback.onSuccess(localJSONObject);
        TwitterAuthenticationProvider.access$102(this.this$0, null);
      }
      catch (JSONException localJSONException)
      {
        this.val$callback.onError(localJSONException);
        TwitterAuthenticationProvider.access$102(this.this$0, null);
      }
      finally
      {
        TwitterAuthenticationProvider.access$102(this.this$0, null);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.TwitterAuthenticationProvider.1
 * JD-Core Version:    0.7.0.1
 */