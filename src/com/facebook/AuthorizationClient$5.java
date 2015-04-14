package com.facebook;

import java.util.ArrayList;

class AuthorizationClient$5
  implements RequestBatch.Callback
{
  AuthorizationClient$5(AuthorizationClient paramAuthorizationClient, ArrayList paramArrayList1, AuthorizationClient.Result paramResult, ArrayList paramArrayList2, ArrayList paramArrayList3) {}
  
  public void onBatchCompleted(RequestBatch paramRequestBatch)
  {
    for (;;)
    {
      try
      {
        if ((this.val$fbids.size() == 2) && (this.val$fbids.get(0) != null) && (this.val$fbids.get(1) != null) && (((String)this.val$fbids.get(0)).equals(this.val$fbids.get(1))))
        {
          AccessToken localAccessToken = AccessToken.createFromTokenWithRefreshedPermissions(this.val$pendingResult.token, this.val$grantedPermissions, this.val$declinedPermissions);
          localObject2 = AuthorizationClient.Result.createTokenResult(this.this$0.pendingRequest, localAccessToken);
          this.this$0.complete((AuthorizationClient.Result)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        AuthorizationClient.Result localResult;
        this.this$0.complete(AuthorizationClient.Result.createErrorResult(this.this$0.pendingRequest, "Caught exception", localException.getMessage()));
        AuthorizationClient.access$000(this.this$0);
        continue;
      }
      finally
      {
        AuthorizationClient.access$000(this.this$0);
      }
      localResult = AuthorizationClient.Result.createErrorResult(this.this$0.pendingRequest, "User logged in as different Facebook user.", null);
      localObject2 = localResult;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AuthorizationClient.5
 * JD-Core Version:    0.7.0.1
 */