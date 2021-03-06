package com.facebook;

import android.app.Activity;
import android.support.v4.app.Fragment;
import java.util.List;

public final class Session$NewPermissionsRequest
  extends Session.AuthorizationRequest
{
  private static final long serialVersionUID = 1L;
  
  public Session$NewPermissionsRequest(Activity paramActivity, List<String> paramList)
  {
    super(paramActivity);
    setPermissions(paramList);
  }
  
  public Session$NewPermissionsRequest(Activity paramActivity, String... paramVarArgs)
  {
    super(paramActivity);
    setPermissions(paramVarArgs);
  }
  
  public Session$NewPermissionsRequest(Fragment paramFragment, List<String> paramList)
  {
    super(paramFragment);
    setPermissions(paramList);
  }
  
  public Session$NewPermissionsRequest(Fragment paramFragment, String... paramVarArgs)
  {
    super(paramFragment);
    setPermissions(paramVarArgs);
  }
  
  AuthorizationClient.AuthorizationRequest getAuthorizationClientRequest()
  {
    AuthorizationClient.AuthorizationRequest localAuthorizationRequest = super.getAuthorizationClientRequest();
    localAuthorizationRequest.setRerequest(true);
    return localAuthorizationRequest;
  }
  
  public final NewPermissionsRequest setCallback(Session.StatusCallback paramStatusCallback)
  {
    super.setCallback(paramStatusCallback);
    return this;
  }
  
  public final NewPermissionsRequest setDefaultAudience(SessionDefaultAudience paramSessionDefaultAudience)
  {
    super.setDefaultAudience(paramSessionDefaultAudience);
    return this;
  }
  
  public final NewPermissionsRequest setLoginBehavior(SessionLoginBehavior paramSessionLoginBehavior)
  {
    super.setLoginBehavior(paramSessionLoginBehavior);
    return this;
  }
  
  public final NewPermissionsRequest setRequestCode(int paramInt)
  {
    super.setRequestCode(paramInt);
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Session.NewPermissionsRequest
 * JD-Core Version:    0.7.0.1
 */