package com.facebook.widget;

import com.facebook.FacebookRequestError;
import com.facebook.Request.GraphUserCallback;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.model.GraphUser;

class UserSettingsFragment$1
  implements Request.GraphUserCallback
{
  UserSettingsFragment$1(UserSettingsFragment paramUserSettingsFragment, Session paramSession) {}
  
  public void onCompleted(GraphUser paramGraphUser, Response paramResponse)
  {
    if (this.val$currentSession == this.this$0.getSession())
    {
      UserSettingsFragment.access$002(this.this$0, paramGraphUser);
      UserSettingsFragment.access$100(this.this$0);
    }
    if (paramResponse.getError() != null) {
      UserSettingsFragment.access$200(this.this$0).handleError(paramResponse.getError().getException());
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.UserSettingsFragment.1
 * JD-Core Version:    0.7.0.1
 */