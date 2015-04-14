package com.facebook;

import android.content.ActivityNotFoundException;
import android.content.Intent;

abstract class AuthorizationClient$KatanaAuthHandler
  extends AuthorizationClient.AuthHandler
{
  private static final long serialVersionUID = 1L;
  
  AuthorizationClient$KatanaAuthHandler(AuthorizationClient paramAuthorizationClient)
  {
    super(paramAuthorizationClient);
  }
  
  protected boolean tryIntent(Intent paramIntent, int paramInt)
  {
    boolean bool = false;
    if (paramIntent == null) {}
    for (;;)
    {
      return bool;
      try
      {
        this.this$0.getStartActivityDelegate().startActivityForResult(paramIntent, paramInt);
        bool = true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException) {}
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AuthorizationClient.KatanaAuthHandler
 * JD-Core Version:    0.7.0.1
 */