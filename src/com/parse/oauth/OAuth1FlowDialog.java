package com.parse.oauth;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class OAuth1FlowDialog
  extends Dialog
{
  private static final FrameLayout.LayoutParams FILL = new FrameLayout.LayoutParams(-1, -1);
  private final String callbackUrl;
  private ImageView closeImage;
  private FrameLayout content;
  private final OAuth1FlowDialog.FlowResultHandler handler;
  private ProgressDialog progressDialog;
  private final String requestUrl;
  private final String serviceUrlIdentifier;
  private WebView webView;
  
  public OAuth1FlowDialog(Context paramContext, String paramString1, String paramString2, String paramString3, OAuth1FlowDialog.FlowResultHandler paramFlowResultHandler)
  {
    super(paramContext, 16973840);
    this.requestUrl = paramString1;
    this.callbackUrl = paramString2;
    this.serviceUrlIdentifier = paramString3;
    this.handler = paramFlowResultHandler;
    setOnCancelListener(new OAuth1FlowDialog.1(this));
  }
  
  private void createCloseImage()
  {
    this.closeImage = new ImageView(getContext());
    this.closeImage.setOnClickListener(new OAuth1FlowDialog.2(this));
    Drawable localDrawable = getContext().getResources().getDrawable(17301527);
    this.closeImage.setImageDrawable(localDrawable);
    this.closeImage.setVisibility(4);
  }
  
  private void setUpWebView(int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    this.webView = new WebView(getContext());
    this.webView.setVerticalScrollBarEnabled(false);
    this.webView.setHorizontalScrollBarEnabled(false);
    this.webView.setWebViewClient(new OAuth1FlowDialog.OAuth1WebViewClient(this, null));
    this.webView.getSettings().setJavaScriptEnabled(true);
    this.webView.loadUrl(this.requestUrl);
    this.webView.setLayoutParams(FILL);
    this.webView.setVisibility(4);
    localLinearLayout.setPadding(paramInt, paramInt, paramInt, paramInt);
    localLinearLayout.addView(this.webView);
    this.content.addView(localLinearLayout);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.progressDialog = new ProgressDialog(getContext());
    this.progressDialog.requestWindowFeature(1);
    this.progressDialog.setMessage("Loading...");
    requestWindowFeature(1);
    this.content = new FrameLayout(getContext());
    createCloseImage();
    setUpWebView(this.closeImage.getDrawable().getIntrinsicWidth() / 2);
    this.content.addView(this.closeImage, new ViewGroup.LayoutParams(-2, -2));
    addContentView(this.content, new ViewGroup.LayoutParams(-1, -1));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.oauth.OAuth1FlowDialog
 * JD-Core Version:    0.7.0.1
 */