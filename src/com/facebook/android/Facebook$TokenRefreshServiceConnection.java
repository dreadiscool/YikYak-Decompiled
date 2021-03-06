package com.facebook.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

class Facebook$TokenRefreshServiceConnection
  implements ServiceConnection
{
  final Context applicationsContext;
  final Messenger messageReceiver = new Messenger(new Facebook.TokenRefreshConnectionHandler(this.this$0, this));
  Messenger messageSender = null;
  final Facebook.ServiceListener serviceListener;
  
  public Facebook$TokenRefreshServiceConnection(Facebook paramFacebook, Context paramContext, Facebook.ServiceListener paramServiceListener)
  {
    this.applicationsContext = paramContext;
    this.serviceListener = paramServiceListener;
  }
  
  private void refreshToken()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("access_token", Facebook.access$100(this.this$0));
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
        this.serviceListener.onError(new Error("Service connection error"));
      }
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.messageSender = new Messenger(paramIBinder);
    refreshToken();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.serviceListener.onError(new Error("Service disconnected"));
    try
    {
      this.applicationsContext.unbindService(this);
      label26:
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label26;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.android.Facebook.TokenRefreshServiceConnection
 * JD-Core Version:    0.7.0.1
 */