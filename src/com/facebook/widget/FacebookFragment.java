package com.facebook.widget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.Session;
import com.facebook.Session.Builder;
import com.facebook.Session.OpenRequest;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.internal.SessionTracker;
import java.util.Date;
import java.util.List;

class FacebookFragment
  extends Fragment
{
  private SessionTracker sessionTracker;
  
  private void openSession(String paramString, List<String> paramList, SessionLoginBehavior paramSessionLoginBehavior, int paramInt, SessionAuthorizationType paramSessionAuthorizationType)
  {
    Session localSession;
    Session.OpenRequest localOpenRequest;
    if (this.sessionTracker != null)
    {
      localSession = this.sessionTracker.getSession();
      if ((localSession == null) || (localSession.getState().isClosed()))
      {
        localSession = new Session.Builder(getActivity()).setApplicationId(paramString).build();
        Session.setActiveSession(localSession);
      }
      if (!localSession.isOpened())
      {
        localOpenRequest = new Session.OpenRequest(this).setPermissions(paramList).setLoginBehavior(paramSessionLoginBehavior).setRequestCode(paramInt);
        if (!SessionAuthorizationType.PUBLISH.equals(paramSessionAuthorizationType)) {
          break label107;
        }
        localSession.openForPublish(localOpenRequest);
      }
    }
    for (;;)
    {
      return;
      label107:
      localSession.openForRead(localOpenRequest);
    }
  }
  
  protected final void closeSession()
  {
    if (this.sessionTracker != null)
    {
      Session localSession = this.sessionTracker.getOpenSession();
      if (localSession != null) {
        localSession.close();
      }
    }
  }
  
  protected final void closeSessionAndClearTokenInformation()
  {
    if (this.sessionTracker != null)
    {
      Session localSession = this.sessionTracker.getOpenSession();
      if (localSession != null) {
        localSession.closeAndClearTokenInformation();
      }
    }
  }
  
  protected final String getAccessToken()
  {
    String str = null;
    if (this.sessionTracker != null)
    {
      Session localSession = this.sessionTracker.getOpenSession();
      if (localSession != null) {
        str = localSession.getAccessToken();
      }
    }
    return str;
  }
  
  protected final Date getExpirationDate()
  {
    Date localDate = null;
    if (this.sessionTracker != null)
    {
      Session localSession = this.sessionTracker.getOpenSession();
      if (localSession != null) {
        localDate = localSession.getExpirationDate();
      }
    }
    return localDate;
  }
  
  protected final Session getSession()
  {
    if (this.sessionTracker != null) {}
    for (Session localSession = this.sessionTracker.getSession();; localSession = null) {
      return localSession;
    }
  }
  
  protected final List<String> getSessionPermissions()
  {
    List localList = null;
    if (this.sessionTracker != null)
    {
      Session localSession = this.sessionTracker.getSession();
      if (localSession != null) {
        localList = localSession.getPermissions();
      }
    }
    return localList;
  }
  
  protected final SessionState getSessionState()
  {
    SessionState localSessionState = null;
    if (this.sessionTracker != null)
    {
      Session localSession = this.sessionTracker.getSession();
      if (localSession != null) {
        localSessionState = localSession.getState();
      }
    }
    return localSessionState;
  }
  
  protected final boolean isSessionOpen()
  {
    boolean bool = false;
    if ((this.sessionTracker != null) && (this.sessionTracker.getOpenSession() != null)) {
      bool = true;
    }
    return bool;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.sessionTracker = new SessionTracker(getActivity(), new FacebookFragment.DefaultSessionStatusCallback(this, null));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.sessionTracker.getSession().onActivityResult(getActivity(), paramInt1, paramInt2, paramIntent);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.sessionTracker.stopTracking();
  }
  
  protected void onSessionStateChange(SessionState paramSessionState, Exception paramException) {}
  
  protected final void openSession()
  {
    openSessionForRead(null, null);
  }
  
  protected final void openSessionForPublish(String paramString, List<String> paramList)
  {
    openSessionForPublish(paramString, paramList, SessionLoginBehavior.SSO_WITH_FALLBACK, 64206);
  }
  
  protected final void openSessionForPublish(String paramString, List<String> paramList, SessionLoginBehavior paramSessionLoginBehavior, int paramInt)
  {
    openSession(paramString, paramList, paramSessionLoginBehavior, paramInt, SessionAuthorizationType.PUBLISH);
  }
  
  protected final void openSessionForRead(String paramString, List<String> paramList)
  {
    openSessionForRead(paramString, paramList, SessionLoginBehavior.SSO_WITH_FALLBACK, 64206);
  }
  
  protected final void openSessionForRead(String paramString, List<String> paramList, SessionLoginBehavior paramSessionLoginBehavior, int paramInt)
  {
    openSession(paramString, paramList, paramSessionLoginBehavior, paramInt, SessionAuthorizationType.READ);
  }
  
  public void setSession(Session paramSession)
  {
    if (this.sessionTracker != null) {
      this.sessionTracker.setSession(paramSession);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.FacebookFragment
 * JD-Core Version:    0.7.0.1
 */