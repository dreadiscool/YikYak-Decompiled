package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.internal.Utility;
import com.facebook.widget.WebDialog;
import com.facebook.widget.WebDialog.Builder;

class AuthorizationClient$WebViewAuthHandler
  extends AuthorizationClient.AuthHandler
{
  private static final long serialVersionUID = 1L;
  private String applicationId;
  private String e2e;
  private transient WebDialog loginDialog;
  
  AuthorizationClient$WebViewAuthHandler(AuthorizationClient paramAuthorizationClient)
  {
    super(paramAuthorizationClient);
  }
  
  private String loadCookieToken()
  {
    return this.this$0.getStartActivityDelegate().getActivityContext().getSharedPreferences("com.facebook.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", "");
  }
  
  private void saveCookieToken(String paramString)
  {
    this.this$0.getStartActivityDelegate().getActivityContext().getSharedPreferences("com.facebook.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", paramString).apply();
  }
  
  void cancel()
  {
    if (this.loginDialog != null)
    {
      this.loginDialog.setOnCompleteListener(null);
      this.loginDialog.dismiss();
      this.loginDialog = null;
    }
  }
  
  String getNameForLogging()
  {
    return "web_view";
  }
  
  boolean needsInternetPermission()
  {
    return true;
  }
  
  boolean needsRestart()
  {
    return true;
  }
  
  void onWebDialogComplete(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, Bundle paramBundle, FacebookException paramFacebookException)
  {
    AuthorizationClient.Result localResult;
    if (paramBundle != null)
    {
      if (paramBundle.containsKey("e2e")) {
        this.e2e = paramBundle.getString("e2e");
      }
      AccessToken localAccessToken = AccessToken.createFromWebBundle(paramAuthorizationRequest.getPermissions(), paramBundle, AccessTokenSource.WEB_VIEW);
      localResult = AuthorizationClient.Result.createTokenResult(this.this$0.pendingRequest, localAccessToken);
      CookieSyncManager.createInstance(this.this$0.context).sync();
      saveCookieToken(localAccessToken.getToken());
    }
    for (;;)
    {
      if (!Utility.isNullOrEmpty(this.e2e)) {
        AuthorizationClient.access$200(this.this$0, this.applicationId, this.e2e);
      }
      this.this$0.completeAndValidate(localResult);
      return;
      if (!(paramFacebookException instanceof FacebookOperationCanceledException)) {
        break;
      }
      localResult = AuthorizationClient.Result.createCancelResult(this.this$0.pendingRequest, "User canceled log in.");
    }
    this.e2e = null;
    String str1 = paramFacebookException.getMessage();
    String str2;
    if ((paramFacebookException instanceof FacebookServiceException))
    {
      FacebookRequestError localFacebookRequestError = ((FacebookServiceException)paramFacebookException).getRequestError();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(localFacebookRequestError.getErrorCode());
      str2 = String.format("%d", arrayOfObject);
      str1 = localFacebookRequestError.toString();
    }
    for (;;)
    {
      localResult = AuthorizationClient.Result.createErrorResult(this.this$0.pendingRequest, null, str1, str2);
      break;
      str2 = null;
    }
  }
  
  boolean tryAuthorize(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest)
  {
    this.applicationId = paramAuthorizationRequest.getApplicationId();
    Bundle localBundle = new Bundle();
    if (!Utility.isNullOrEmpty(paramAuthorizationRequest.getPermissions()))
    {
      String str2 = TextUtils.join(",", paramAuthorizationRequest.getPermissions());
      localBundle.putString("scope", str2);
      addLoggingExtra("scope", str2);
    }
    localBundle.putString("default_audience", paramAuthorizationRequest.getDefaultAudience().getNativeProtocolAudience());
    String str1 = paramAuthorizationRequest.getPreviousAccessToken();
    if ((!Utility.isNullOrEmpty(str1)) && (str1.equals(loadCookieToken())))
    {
      localBundle.putString("access_token", str1);
      addLoggingExtra("access_token", "1");
    }
    for (;;)
    {
      AuthorizationClient.WebViewAuthHandler.1 local1 = new AuthorizationClient.WebViewAuthHandler.1(this, paramAuthorizationRequest);
      this.e2e = AuthorizationClient.access$100();
      addLoggingExtra("e2e", this.e2e);
      this.loginDialog = ((WebDialog.Builder)new AuthorizationClient.AuthDialogBuilder(this.this$0.getStartActivityDelegate().getActivityContext(), this.applicationId, localBundle).setE2E(this.e2e).setIsRerequest(paramAuthorizationRequest.isRerequest()).setOnCompleteListener(local1)).build();
      this.loginDialog.show();
      return true;
      Utility.clearFacebookCookies(this.this$0.context);
      addLoggingExtra("access_token", "0");
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AuthorizationClient.WebViewAuthHandler
 * JD-Core Version:    0.7.0.1
 */