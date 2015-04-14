package com.facebook;

class Session$2
  implements Request.Callback
{
  Session$2(Session paramSession) {}
  
  public void onCompleted(Response paramResponse)
  {
    Session.PermissionsPair localPermissionsPair = Session.handlePermissionResponse(paramResponse);
    if (localPermissionsPair != null) {
      synchronized (Session.access$200(this.this$0))
      {
        Session.access$302(this.this$0, AccessToken.createFromTokenWithRefreshedPermissions(Session.access$300(this.this$0), localPermissionsPair.getGrantedPermissions(), localPermissionsPair.getDeclinedPermissions()));
        this.this$0.postStateChange(Session.access$400(this.this$0), SessionState.OPENED_TOKEN_UPDATED, null);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Session.2
 * JD-Core Version:    0.7.0.1
 */