package com.parse.twitter;

import android.net.Uri;
import android.os.AsyncTask;
import android.webkit.CookieSyncManager;
import com.parse.internal.AsyncCallback;
import com.parse.oauth.OAuth1FlowDialog.FlowResultHandler;
import com.parse.oauth.OAuth1FlowException;

class Twitter$1$1
  implements OAuth1FlowDialog.FlowResultHandler
{
  Twitter$1$1(Twitter.1 param1) {}
  
  public void onCancel()
  {
    this.this$1.val$callback.onCancel();
  }
  
  public void onComplete(String paramString)
  {
    CookieSyncManager.getInstance().sync();
    String str = Uri.parse(paramString).getQueryParameter("oauth_verifier");
    if (str == null) {
      this.this$1.val$callback.onCancel();
    }
    for (;;)
    {
      return;
      new Twitter.1.1.1(this, str).execute(new Void[0]);
    }
  }
  
  public void onError(int paramInt, String paramString1, String paramString2)
  {
    this.this$1.val$callback.onFailure(new OAuth1FlowException(paramInt, paramString1, paramString2));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.twitter.Twitter.1.1
 * JD-Core Version:    0.7.0.1
 */