package com.facebook;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

class Session$SerializationProxyV2
  implements Serializable
{
  private static final long serialVersionUID = 7663436173185080064L;
  private final String applicationId;
  private final Date lastAttemptedTokenExtendDate;
  private final Session.AuthorizationRequest pendingAuthorizationRequest;
  private final Set<String> requestedPermissions;
  private final boolean shouldAutoPublish;
  private final SessionState state;
  private final AccessToken tokenInfo;
  
  Session$SerializationProxyV2(String paramString, SessionState paramSessionState, AccessToken paramAccessToken, Date paramDate, boolean paramBoolean, Session.AuthorizationRequest paramAuthorizationRequest, Set<String> paramSet)
  {
    this.applicationId = paramString;
    this.state = paramSessionState;
    this.tokenInfo = paramAccessToken;
    this.lastAttemptedTokenExtendDate = paramDate;
    this.shouldAutoPublish = paramBoolean;
    this.pendingAuthorizationRequest = paramAuthorizationRequest;
    this.requestedPermissions = paramSet;
  }
  
  private Object readResolve()
  {
    return new Session(this.applicationId, this.state, this.tokenInfo, this.lastAttemptedTokenExtendDate, this.shouldAutoPublish, this.pendingAuthorizationRequest, this.requestedPermissions, null);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Session.SerializationProxyV2
 * JD-Core Version:    0.7.0.1
 */