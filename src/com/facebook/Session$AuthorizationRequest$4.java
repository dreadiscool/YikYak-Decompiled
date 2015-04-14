package com.facebook;

import android.app.Activity;
import android.content.Intent;

class Session$AuthorizationRequest$4
  implements AuthorizationClient.StartActivityDelegate
{
  Session$AuthorizationRequest$4(Session.AuthorizationRequest paramAuthorizationRequest) {}
  
  public Activity getActivityContext()
  {
    return Session.AuthorizationRequest.access$1800(this.this$0).getActivityContext();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    Session.AuthorizationRequest.access$1800(this.this$0).startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Session.AuthorizationRequest.4
 * JD-Core Version:    0.7.0.1
 */