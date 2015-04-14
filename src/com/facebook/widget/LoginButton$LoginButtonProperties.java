package com.facebook.widget;

import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionDefaultAudience;
import com.facebook.SessionLoginBehavior;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.internal.Utility;
import java.util.Collections;
import java.util.List;

class LoginButton$LoginButtonProperties
{
  private SessionAuthorizationType authorizationType = null;
  private SessionDefaultAudience defaultAudience = SessionDefaultAudience.FRIENDS;
  private SessionLoginBehavior loginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;
  private LoginButton.OnErrorListener onErrorListener;
  private List<String> permissions = Collections.emptyList();
  private Session.StatusCallback sessionStatusCallback;
  
  private boolean validatePermissions(List<String> paramList, SessionAuthorizationType paramSessionAuthorizationType, Session paramSession)
  {
    if ((SessionAuthorizationType.PUBLISH.equals(paramSessionAuthorizationType)) && (Utility.isNullOrEmpty(paramList))) {
      throw new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
    }
    if ((paramSession != null) && (paramSession.isOpened()) && (!Utility.isSubset(paramList, paramSession.getPermissions()))) {
      LoginButton.access$000();
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public void clearPermissions()
  {
    this.permissions = null;
    this.authorizationType = null;
  }
  
  public SessionDefaultAudience getDefaultAudience()
  {
    return this.defaultAudience;
  }
  
  public SessionLoginBehavior getLoginBehavior()
  {
    return this.loginBehavior;
  }
  
  public LoginButton.OnErrorListener getOnErrorListener()
  {
    return this.onErrorListener;
  }
  
  List<String> getPermissions()
  {
    return this.permissions;
  }
  
  public Session.StatusCallback getSessionStatusCallback()
  {
    return this.sessionStatusCallback;
  }
  
  public void setDefaultAudience(SessionDefaultAudience paramSessionDefaultAudience)
  {
    this.defaultAudience = paramSessionDefaultAudience;
  }
  
  public void setLoginBehavior(SessionLoginBehavior paramSessionLoginBehavior)
  {
    this.loginBehavior = paramSessionLoginBehavior;
  }
  
  public void setOnErrorListener(LoginButton.OnErrorListener paramOnErrorListener)
  {
    this.onErrorListener = paramOnErrorListener;
  }
  
  public void setPublishPermissions(List<String> paramList, Session paramSession)
  {
    if (SessionAuthorizationType.READ.equals(this.authorizationType)) {
      throw new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
    }
    if (validatePermissions(paramList, SessionAuthorizationType.PUBLISH, paramSession))
    {
      this.permissions = paramList;
      this.authorizationType = SessionAuthorizationType.PUBLISH;
    }
  }
  
  public void setReadPermissions(List<String> paramList, Session paramSession)
  {
    if (SessionAuthorizationType.PUBLISH.equals(this.authorizationType)) {
      throw new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
    }
    if (validatePermissions(paramList, SessionAuthorizationType.READ, paramSession))
    {
      this.permissions = paramList;
      this.authorizationType = SessionAuthorizationType.READ;
    }
  }
  
  public void setSessionStatusCallback(Session.StatusCallback paramStatusCallback)
  {
    this.sessionStatusCallback = paramStatusCallback;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.LoginButton.LoginButtonProperties
 * JD-Core Version:    0.7.0.1
 */