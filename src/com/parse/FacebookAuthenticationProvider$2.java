package com.parse;

import android.os.Bundle;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;

class FacebookAuthenticationProvider$2
  implements Session.StatusCallback
{
  FacebookAuthenticationProvider$2(FacebookAuthenticationProvider paramFacebookAuthenticationProvider) {}
  
  public void call(Session paramSession, SessionState paramSessionState, Exception paramException)
  {
    if (paramSessionState == SessionState.OPENING) {}
    for (;;)
    {
      return;
      if (paramSessionState.isOpened())
      {
        if (FacebookAuthenticationProvider.access$300(this.this$0) != null)
        {
          Request localRequest = Request.newGraphPathRequest(paramSession, "me", new FacebookAuthenticationProvider.2.1(this));
          localRequest.getParameters().putString("fields", "id");
          localRequest.executeAsync();
        }
      }
      else if (paramException != null) {
        FacebookAuthenticationProvider.access$200(this.this$0, paramException);
      } else {
        FacebookAuthenticationProvider.access$400(this.this$0);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.FacebookAuthenticationProvider.2
 * JD-Core Version:    0.7.0.1
 */