package com.parse;

import com.facebook.FacebookRequestError;
import com.facebook.Request.Callback;
import com.facebook.Response;
import com.facebook.model.GraphObject;

class FacebookAuthenticationProvider$2$1
  implements Request.Callback
{
  FacebookAuthenticationProvider$2$1(FacebookAuthenticationProvider.2 param2) {}
  
  public void onCompleted(Response paramResponse)
  {
    if (paramResponse.getError() != null) {
      if (paramResponse.getError().getException() != null) {
        FacebookAuthenticationProvider.access$200(this.this$1.this$0, paramResponse.getError().getException());
      }
    }
    for (;;)
    {
      return;
      FacebookAuthenticationProvider.access$200(this.this$1.this$0, new ParseException(-1, "An error occurred while fetching the Facebook user's identity."));
      continue;
      FacebookAuthenticationProvider.access$100(this.this$1.this$0, (String)paramResponse.getGraphObject().getProperty("id"));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.FacebookAuthenticationProvider.2.1
 * JD-Core Version:    0.7.0.1
 */