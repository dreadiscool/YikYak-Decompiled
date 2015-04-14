package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.FacebookDialog.Callback;
import com.facebook.widget.FacebookDialog.PendingCall;
import com.facebook.widget.WebDialog.OnCompleteListener;

final class FacebookWebFallbackDialog$1
  implements WebDialog.OnCompleteListener
{
  FacebookWebFallbackDialog$1(Context paramContext, FacebookDialog.PendingCall paramPendingCall, FacebookDialog.Callback paramCallback) {}
  
  public void onComplete(Bundle paramBundle, FacebookException paramFacebookException)
  {
    Intent localIntent = new Intent();
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    localIntent.putExtras(paramBundle);
    FacebookDialog.handleActivityResult(this.val$context, this.val$appCall, this.val$appCall.getRequestCode(), localIntent, this.val$callback);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.FacebookWebFallbackDialog.1
 * JD-Core Version:    0.7.0.1
 */