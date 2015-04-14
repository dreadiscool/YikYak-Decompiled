package com.facebook;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.facebook.internal.NativeProtocol;
import java.util.Date;

class Session$TokenRefreshRequest
  implements ServiceConnection
{
  final Messenger messageReceiver = new Messenger(new Session.TokenRefreshRequestHandler(this.this$0, this));
  Messenger messageSender = null;
  
  Session$TokenRefreshRequest(Session paramSession) {}
  
  private void cleanup()
  {
    if (Session.access$1600(this.this$0) == this) {
      Session.access$1602(this.this$0, null);
    }
  }
  
  private void refreshToken()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("access_token", this.this$0.getTokenInfo().getToken());
    Message localMessage = Message.obtain();
    localMessage.setData(localBundle);
    localMessage.replyTo = this.messageReceiver;
    try
    {
      this.messageSender.send(localMessage);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        cleanup();
      }
    }
  }
  
  public void bind()
  {
    Intent localIntent = NativeProtocol.createTokenRefreshIntent(Session.getStaticContext());
    if ((localIntent != null) && (Session.access$1500().bindService(localIntent, this, 1))) {
      this.this$0.setLastAttemptedTokenExtendDate(new Date());
    }
    for (;;)
    {
      return;
      cleanup();
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.messageSender = new Messenger(paramIBinder);
    refreshToken();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    cleanup();
    try
    {
      Session.access$1500().unbindService(this);
      label11:
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label11;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Session.TokenRefreshRequest
 * JD-Core Version:    0.7.0.1
 */