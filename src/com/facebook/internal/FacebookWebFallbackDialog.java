package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.facebook.widget.FacebookDialog.Callback;
import com.facebook.widget.FacebookDialog.PendingCall;
import com.facebook.widget.WebDialog;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookWebFallbackDialog
  extends WebDialog
{
  private static final int OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS = 1500;
  private static final String TAG = FacebookWebFallbackDialog.class.getName();
  private boolean waitingForDialogToClose;
  
  private FacebookWebFallbackDialog(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1);
    setExpectedRedirectUrl(paramString2);
  }
  
  public static boolean presentWebFallback(Context paramContext, String paramString1, String paramString2, FacebookDialog.PendingCall paramPendingCall, FacebookDialog.Callback paramCallback)
  {
    boolean bool = false;
    if (Utility.isNullOrEmpty(paramString1)) {}
    for (;;)
    {
      return bool;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[bool] = paramString2;
      FacebookWebFallbackDialog localFacebookWebFallbackDialog = new FacebookWebFallbackDialog(paramContext, paramString1, String.format("fb%s://bridge/", arrayOfObject));
      localFacebookWebFallbackDialog.setOnCompleteListener(new FacebookWebFallbackDialog.1(paramContext, paramPendingCall, paramCallback));
      localFacebookWebFallbackDialog.show();
      bool = true;
    }
  }
  
  public void dismiss()
  {
    WebView localWebView = getWebView();
    if ((isListenerCalled()) || (localWebView == null) || (!localWebView.isShown())) {
      super.dismiss();
    }
    for (;;)
    {
      return;
      if (!this.waitingForDialogToClose)
      {
        this.waitingForDialogToClose = true;
        localWebView.loadUrl("javascript:" + "(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();");
        new Handler(Looper.getMainLooper()).postDelayed(new FacebookWebFallbackDialog.2(this), 1500L);
      }
    }
  }
  
  protected Bundle parseResponseUri(String paramString)
  {
    Bundle localBundle = Utility.parseUrlQueryString(Uri.parse(paramString).getQuery());
    String str1 = localBundle.getString("bridge_args");
    localBundle.remove("bridge_args");
    if (!Utility.isNullOrEmpty(str1)) {}
    try
    {
      localBundle.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", BundleJSONConverter.convertToBundle(new JSONObject(str1)));
      str2 = localBundle.getString("method_results");
      localBundle.remove("method_results");
      if (!Utility.isNullOrEmpty(str2)) {
        if (Utility.isNullOrEmpty(str2)) {
          str2 = "{}";
        }
      }
    }
    catch (JSONException localJSONException2)
    {
      try
      {
        String str2;
        localBundle.putBundle("com.facebook.platform.protocol.RESULT_ARGS", BundleJSONConverter.convertToBundle(new JSONObject(str2)));
        localBundle.remove("version");
        localBundle.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", NativeProtocol.getLatestKnownVersion());
        return localBundle;
        localJSONException2 = localJSONException2;
        Utility.logd(TAG, "Unable to parse bridge_args JSON", localJSONException2);
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          Utility.logd(TAG, "Unable to parse bridge_args JSON", localJSONException1);
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.FacebookWebFallbackDialog
 * JD-Core Version:    0.7.0.1
 */