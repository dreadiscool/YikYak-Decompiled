package com.facebook.widget;

import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;

class FacebookFragment$DefaultSessionStatusCallback
  implements Session.StatusCallback
{
  private FacebookFragment$DefaultSessionStatusCallback(FacebookFragment paramFacebookFragment) {}
  
  public void call(Session paramSession, SessionState paramSessionState, Exception paramException)
  {
    this.this$0.onSessionStateChange(paramSessionState, paramException);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.FacebookFragment.DefaultSessionStatusCallback
 * JD-Core Version:    0.7.0.1
 */