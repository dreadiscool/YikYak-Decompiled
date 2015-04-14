package com.facebook.widget;

import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;

class LoginButton$LoginButtonCallback
  implements Session.StatusCallback
{
  private LoginButton$LoginButtonCallback(LoginButton paramLoginButton) {}
  
  public void call(Session paramSession, SessionState paramSessionState, Exception paramException)
  {
    LoginButton.access$1700(this.this$0);
    LoginButton.access$1800(this.this$0);
    if (LoginButton.LoginButtonProperties.access$1900(LoginButton.access$1000(this.this$0)) != null) {
      LoginButton.LoginButtonProperties.access$1900(LoginButton.access$1000(this.this$0)).call(paramSession, paramSessionState, paramException);
    }
    for (;;)
    {
      return;
      if (paramException != null) {
        this.this$0.handleError(paramException);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.LoginButton.LoginButtonCallback
 * JD-Core Version:    0.7.0.1
 */