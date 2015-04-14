package com.facebook;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class Session$TokenRefreshRequestHandler
  extends Handler
{
  private WeakReference<Session.TokenRefreshRequest> refreshRequestWeakReference;
  private WeakReference<Session> sessionWeakReference;
  
  Session$TokenRefreshRequestHandler(Session paramSession, Session.TokenRefreshRequest paramTokenRefreshRequest)
  {
    super(Looper.getMainLooper());
    this.sessionWeakReference = new WeakReference(paramSession);
    this.refreshRequestWeakReference = new WeakReference(paramTokenRefreshRequest);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str = paramMessage.getData().getString("access_token");
    Session localSession = (Session)this.sessionWeakReference.get();
    if ((localSession != null) && (str != null)) {
      localSession.extendTokenCompleted(paramMessage.getData());
    }
    Session.TokenRefreshRequest localTokenRefreshRequest = (Session.TokenRefreshRequest)this.refreshRequestWeakReference.get();
    if (localTokenRefreshRequest != null)
    {
      Session.access$1500().unbindService(localTokenRefreshRequest);
      Session.TokenRefreshRequest.access$1700(localTokenRefreshRequest);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Session.TokenRefreshRequestHandler
 * JD-Core Version:    0.7.0.1
 */