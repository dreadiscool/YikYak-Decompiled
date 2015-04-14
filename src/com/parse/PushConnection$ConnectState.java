package com.parse;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import m;
import org.json.JSONObject;

public class PushConnection$ConnectState
  extends PushConnection.State
{
  private long lastDelay;
  
  public PushConnection$ConnectState(PushConnection paramPushConnection, long paramLong)
  {
    super(paramPushConnection);
    this.lastDelay = paramLong;
  }
  
  private long nextDelay()
  {
    return Math.min(Math.max(15000L, (this.lastDelay * (1.5D + 0.5D * Math.random()))), 300000L);
  }
  
  private boolean sendHandshake(Socket paramSocket)
  {
    m localm = PushRouter.getPushRequestJSONAsync();
    try
    {
      localm.g();
      JSONObject localJSONObject = (JSONObject)localm.e();
      if (localJSONObject != null)
      {
        bool = PushConnection.access$700(paramSocket, localJSONObject.toString());
        return bool;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Parse.logE("com.parse.PushConnection", "Unexpected interruption when waiting for handshake to be sent", localInterruptedException);
        continue;
        boolean bool = false;
      }
    }
  }
  
  public PushConnection.State runState()
  {
    int i = 0;
    Socket localSocket = new Socket();
    Object localObject1 = null;
    try
    {
      InetSocketAddress localInetSocketAddress = new InetSocketAddress(PushConnection.access$400(this.this$0), PushConnection.access$500(this.this$0));
      if (localInetSocketAddress != null)
      {
        localSocket.connect(localInetSocketAddress, 40000);
        localSocket.setKeepAlive(true);
        localSocket.setTcpNoDelay(true);
        boolean bool = sendHandshake(localSocket);
        i = bool;
      }
    }
    catch (SecurityException localSecurityException)
    {
      Object localObject2;
      break label68;
    }
    catch (IOException localIOException)
    {
      label68:
      break label68;
    }
    if (localObject1 != null) {
      Parse.logI("com.parse.PushConnection", "Failed to connect to push server due to " + localObject1);
    }
    if (i == 0) {
      PushConnection.access$600(localSocket);
    }
    for (localObject2 = new PushConnection.WaitRetryState(this.this$0, nextDelay());; localObject2 = new PushConnection.ConnectedState(this.this$0, localSocket)) {
      return localObject2;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushConnection.ConnectState
 * JD-Core Version:    0.7.0.1
 */