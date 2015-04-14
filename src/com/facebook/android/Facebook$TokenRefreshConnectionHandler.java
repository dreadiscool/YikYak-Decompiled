package com.facebook.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.facebook.LegacyHelper;
import com.facebook.Session;
import java.lang.ref.WeakReference;

class Facebook$TokenRefreshConnectionHandler
  extends Handler
{
  WeakReference<Facebook.TokenRefreshServiceConnection> connectionWeakReference;
  WeakReference<Facebook> facebookWeakReference;
  
  Facebook$TokenRefreshConnectionHandler(Facebook paramFacebook, Facebook.TokenRefreshServiceConnection paramTokenRefreshServiceConnection)
  {
    this.facebookWeakReference = new WeakReference(paramFacebook);
    this.connectionWeakReference = new WeakReference(paramTokenRefreshServiceConnection);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Facebook localFacebook = (Facebook)this.facebookWeakReference.get();
    Facebook.TokenRefreshServiceConnection localTokenRefreshServiceConnection = (Facebook.TokenRefreshServiceConnection)this.connectionWeakReference.get();
    if ((localFacebook == null) || (localTokenRefreshServiceConnection == null)) {
      return;
    }
    String str1 = paramMessage.getData().getString("access_token");
    long l = 1000L * paramMessage.getData().getLong("expires_in");
    if (str1 != null)
    {
      localFacebook.setAccessToken(str1);
      localFacebook.setAccessExpires(l);
      Session localSession = Facebook.access$200(localFacebook);
      if (localSession != null) {
        LegacyHelper.extendTokenCompleted(localSession, paramMessage.getData());
      }
      if (localTokenRefreshServiceConnection.serviceListener != null)
      {
        Bundle localBundle = (Bundle)paramMessage.getData().clone();
        localBundle.putLong("expires_in", l);
        localTokenRefreshServiceConnection.serviceListener.onComplete(localBundle);
      }
    }
    String str2;
    for (;;)
    {
      localTokenRefreshServiceConnection.applicationsContext.unbindService(localTokenRefreshServiceConnection);
      break;
      if (localTokenRefreshServiceConnection.serviceListener != null)
      {
        str2 = paramMessage.getData().getString("error");
        if (!paramMessage.getData().containsKey("error_code")) {
          break label209;
        }
        int i = paramMessage.getData().getInt("error_code");
        localTokenRefreshServiceConnection.serviceListener.onFacebookError(new FacebookError(str2, null, i));
      }
    }
    label209:
    Facebook.ServiceListener localServiceListener = localTokenRefreshServiceConnection.serviceListener;
    if (str2 != null) {}
    for (;;)
    {
      localServiceListener.onError(new Error(str2));
      break;
      str2 = "Unknown service error";
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.android.Facebook.TokenRefreshConnectionHandler
 * JD-Core Version:    0.7.0.1
 */