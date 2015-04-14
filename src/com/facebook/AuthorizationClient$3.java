package com.facebook;

import com.facebook.model.GraphUser;
import java.util.ArrayList;

class AuthorizationClient$3
  implements Request.Callback
{
  AuthorizationClient$3(AuthorizationClient paramAuthorizationClient, ArrayList paramArrayList) {}
  
  public void onCompleted(Response paramResponse)
  {
    try
    {
      GraphUser localGraphUser = (GraphUser)paramResponse.getGraphObjectAs(GraphUser.class);
      if (localGraphUser != null) {
        this.val$fbids.add(localGraphUser.getId());
      }
      label28:
      return;
    }
    catch (Exception localException)
    {
      break label28;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AuthorizationClient.3
 * JD-Core Version:    0.7.0.1
 */