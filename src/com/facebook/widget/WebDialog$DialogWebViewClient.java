package com.facebook.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.internal.Utility;

class WebDialog$DialogWebViewClient
  extends WebViewClient
{
  private WebDialog$DialogWebViewClient(WebDialog paramWebDialog) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (!WebDialog.access$200(this.this$0)) {
      WebDialog.access$300(this.this$0).dismiss();
    }
    WebDialog.access$400(this.this$0).setBackgroundColor(0);
    WebDialog.access$500(this.this$0).setVisibility(0);
    WebDialog.access$600(this.this$0).setVisibility(0);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    Utility.logd("FacebookSDK.WebDialog", "Webview loading URL: " + paramString);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if (!WebDialog.access$200(this.this$0)) {
      WebDialog.access$300(this.this$0).show();
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    this.this$0.sendErrorToListener(new FacebookDialogException(paramString1, paramInt, paramString2));
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
    paramSslErrorHandler.cancel();
    this.this$0.sendErrorToListener(new FacebookDialogException(null, -11, null));
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Utility.logd("FacebookSDK.WebDialog", "Redirect URL: " + paramString);
    Bundle localBundle;
    String str1;
    String str2;
    String str3;
    if (paramString.startsWith(WebDialog.access$100(this.this$0)))
    {
      localBundle = this.this$0.parseResponseUri(paramString);
      str1 = localBundle.getString("error");
      if (str1 == null) {
        str1 = localBundle.getString("error_type");
      }
      str2 = localBundle.getString("error_msg");
      if (str2 == null) {
        str2 = localBundle.getString("error_description");
      }
      str3 = localBundle.getString("error_code");
      if (Utility.isNullOrEmpty(str3)) {
        break label319;
      }
    }
    for (;;)
    {
      int i;
      boolean bool;
      try
      {
        int j = Integer.parseInt(str3);
        i = j;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        i = -1;
        continue;
        if ((str1 == null) || ((!str1.equals("access_denied")) && (!str1.equals("OAuthAccessDeniedException")))) {
          continue;
        }
        this.this$0.sendCancelToListener();
        continue;
        if (i != 4201) {
          continue;
        }
        this.this$0.sendCancelToListener();
        continue;
        FacebookRequestError localFacebookRequestError = new FacebookRequestError(i, str1, str2);
        this.this$0.sendErrorToListener(new FacebookServiceException(localFacebookRequestError, str2));
        continue;
      }
      if ((Utility.isNullOrEmpty(str1)) && (Utility.isNullOrEmpty(str2)) && (i == -1))
      {
        this.this$0.sendSuccessToListener(localBundle);
        bool = true;
        return bool;
      }
      if (paramString.startsWith("fbconnect://cancel"))
      {
        this.this$0.sendCancelToListener();
        bool = true;
      }
      else if (paramString.contains("touch"))
      {
        bool = false;
      }
      else
      {
        this.this$0.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
        bool = true;
        continue;
        label319:
        i = -1;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.WebDialog.DialogWebViewClient
 * JD-Core Version:    0.7.0.1
 */