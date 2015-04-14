package com.parse;

class PushConnection$ReachabilityMonitor
{
  private ConnectivityNotifier.ConnectivityListener listener;
  private boolean unregistered;
  
  private PushConnection$ReachabilityMonitor(PushConnection paramPushConnection) {}
  
  public void register()
  {
    this.listener = new PushConnection.ReachabilityMonitor.1(this);
    ConnectivityNotifier.getNotifier().addListener(this.listener, PushConnection.access$1000(this.this$0));
  }
  
  public void unregister()
  {
    ConnectivityNotifier.getNotifier().removeListener(this.listener);
    try
    {
      this.unregistered = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushConnection.ReachabilityMonitor
 * JD-Core Version:    0.7.0.1
 */