package com.facebook;

import java.util.ArrayList;

class AuthorizationClient$4
  implements Request.Callback
{
  AuthorizationClient$4(AuthorizationClient paramAuthorizationClient, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void onCompleted(Response paramResponse)
  {
    try
    {
      Session.PermissionsPair localPermissionsPair = Session.handlePermissionResponse(paramResponse);
      if (localPermissionsPair != null)
      {
        this.val$grantedPermissions.addAll(localPermissionsPair.getGrantedPermissions());
        this.val$declinedPermissions.addAll(localPermissionsPair.getDeclinedPermissions());
      }
      label33:
      return;
    }
    catch (Exception localException)
    {
      break label33;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AuthorizationClient.4
 * JD-Core Version:    0.7.0.1
 */