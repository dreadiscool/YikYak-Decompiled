package com.parse;

import java.net.Socket;
import java.util.Set;

public class PushConnection$ConnectedState
  extends PushConnection.State
{
  private Socket socket;
  
  public PushConnection$ConnectedState(PushConnection paramPushConnection, Socket paramSocket)
  {
    super(paramPushConnection);
    this.socket = paramSocket;
  }
  
  public PushConnection.State runState()
  {
    Object localObject = null;
    PushConnection.ReachabilityMonitor localReachabilityMonitor = new PushConnection.ReachabilityMonitor(this.this$0, null);
    PushConnection.KeepAliveMonitor localKeepAliveMonitor = new PushConnection.KeepAliveMonitor(this.this$0, this.socket, PushConnection.KEEP_ALIVE_INTERVAL);
    PushConnection.ReaderThread localReaderThread = new PushConnection.ReaderThread(this.this$0, this.socket);
    localReachabilityMonitor.register();
    localKeepAliveMonitor.register();
    localReaderThread.start();
    while (localObject == null)
    {
      PushConnection.EventSet localEventSet2 = PushConnection.access$300(this.this$0);
      PushConnection.Event[] arrayOfEvent2 = new PushConnection.Event[4];
      arrayOfEvent2[0] = PushConnection.Event.STOP;
      arrayOfEvent2[1] = PushConnection.Event.CONNECTIVITY_CHANGED;
      arrayOfEvent2[2] = PushConnection.Event.KEEP_ALIVE_ERROR;
      arrayOfEvent2[3] = PushConnection.Event.READ_ERROR;
      Set localSet = localEventSet2.await(arrayOfEvent2);
      if (localSet.contains(PushConnection.Event.STOP)) {
        localObject = new PushConnection.StoppedState(this.this$0);
      } else if ((localSet.contains(PushConnection.Event.READ_ERROR)) || (localSet.contains(PushConnection.Event.KEEP_ALIVE_ERROR)) || (localSet.contains(PushConnection.Event.CONNECTIVITY_CHANGED))) {
        localObject = new PushConnection.WaitRetryState(this.this$0, 0L);
      }
    }
    localReachabilityMonitor.unregister();
    localKeepAliveMonitor.unregister();
    localReaderThread.stopReading();
    PushConnection.access$600(this.socket);
    PushConnection.EventSet localEventSet1 = PushConnection.access$300(this.this$0);
    PushConnection.Event[] arrayOfEvent1 = new PushConnection.Event[3];
    arrayOfEvent1[0] = PushConnection.Event.CONNECTIVITY_CHANGED;
    arrayOfEvent1[1] = PushConnection.Event.KEEP_ALIVE_ERROR;
    arrayOfEvent1[2] = PushConnection.Event.READ_ERROR;
    localEventSet1.removeEvents(arrayOfEvent1);
    return localObject;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushConnection.ConnectedState
 * JD-Core Version:    0.7.0.1
 */