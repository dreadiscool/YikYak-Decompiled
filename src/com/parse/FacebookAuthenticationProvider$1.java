package com.parse;

import android.os.Bundle;
import com.facebook.android.Facebook.ServiceListener;
import com.facebook.android.FacebookError;

class FacebookAuthenticationProvider$1
  implements Facebook.ServiceListener
{
  FacebookAuthenticationProvider$1(FacebookAuthenticationProvider paramFacebookAuthenticationProvider) {}
  
  public void onComplete(Bundle paramBundle)
  {
    FacebookAuthenticationProvider.access$100(this.this$0, FacebookAuthenticationProvider.access$000(this.this$0));
  }
  
  public void onError(Error paramError)
  {
    FacebookAuthenticationProvider.access$200(this.this$0, paramError);
  }
  
  public void onFacebookError(FacebookError paramFacebookError)
  {
    FacebookAuthenticationProvider.access$200(this.this$0, paramFacebookError);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.FacebookAuthenticationProvider.1
 * JD-Core Version:    0.7.0.1
 */