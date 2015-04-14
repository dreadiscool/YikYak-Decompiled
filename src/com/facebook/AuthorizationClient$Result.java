package com.facebook;

import android.text.TextUtils;
import com.facebook.internal.Utility;
import java.io.Serializable;
import java.util.Map;

class AuthorizationClient$Result
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  final AuthorizationClient.Result.Code code;
  final String errorCode;
  final String errorMessage;
  Map<String, String> loggingExtras;
  final AuthorizationClient.AuthorizationRequest request;
  final AccessToken token;
  
  private AuthorizationClient$Result(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, AuthorizationClient.Result.Code paramCode, AccessToken paramAccessToken, String paramString1, String paramString2)
  {
    this.request = paramAuthorizationRequest;
    this.token = paramAccessToken;
    this.errorMessage = paramString1;
    this.code = paramCode;
    this.errorCode = paramString2;
  }
  
  static Result createCancelResult(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, String paramString)
  {
    return new Result(paramAuthorizationRequest, AuthorizationClient.Result.Code.CANCEL, null, paramString, null);
  }
  
  static Result createErrorResult(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, String paramString1, String paramString2)
  {
    return createErrorResult(paramAuthorizationRequest, paramString1, paramString2, null);
  }
  
  static Result createErrorResult(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, String paramString1, String paramString2, String paramString3)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString1;
    arrayOfString[1] = paramString2;
    String str = TextUtils.join(": ", Utility.asListNoNulls(arrayOfString));
    return new Result(paramAuthorizationRequest, AuthorizationClient.Result.Code.ERROR, null, str, paramString3);
  }
  
  static Result createTokenResult(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, AccessToken paramAccessToken)
  {
    return new Result(paramAuthorizationRequest, AuthorizationClient.Result.Code.SUCCESS, paramAccessToken, null, null);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AuthorizationClient.Result
 * JD-Core Version:    0.7.0.1
 */