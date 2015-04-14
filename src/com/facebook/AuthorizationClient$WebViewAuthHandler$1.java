package com.facebook;

import android.os.Bundle;
import com.facebook.widget.WebDialog.OnCompleteListener;

class AuthorizationClient$WebViewAuthHandler$1
  implements WebDialog.OnCompleteListener
{
  AuthorizationClient$WebViewAuthHandler$1(AuthorizationClient.WebViewAuthHandler paramWebViewAuthHandler, AuthorizationClient.AuthorizationRequest paramAuthorizationRequest) {}
  
  public void onComplete(Bundle paramBundle, FacebookException paramFacebookException)
  {
    this.this$1.onWebDialogComplete(this.val$request, paramBundle, paramFacebookException);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AuthorizationClient.WebViewAuthHandler.1
 * JD-Core Version:    0.7.0.1
 */