package com.parse;

import m;

abstract class ParseEventuallyQueue
{
  private boolean isConnected;
  private ParseEventuallyQueue.TestHelper testHelper;
  
  public abstract void clear();
  
  public abstract m<Object> enqueueEventuallyAsync(ParseCommand paramParseCommand, ParseObject paramParseObject);
  
  void fakeObjectUpdate()
  {
    if (this.testHelper != null)
    {
      this.testHelper.notify(3);
      this.testHelper.notify(1);
      this.testHelper.notify(5);
    }
  }
  
  public ParseEventuallyQueue.TestHelper getTestHelper()
  {
    if (this.testHelper == null) {
      this.testHelper = new ParseEventuallyQueue.TestHelper(null);
    }
    return this.testHelper;
  }
  
  public boolean isConnected()
  {
    return this.isConnected;
  }
  
  protected void notifyTestHelper(int paramInt)
  {
    if (this.testHelper != null) {
      this.testHelper.notify(paramInt);
    }
  }
  
  public abstract void pause();
  
  public abstract int pendingCount();
  
  public abstract void resume();
  
  public void setConnected(boolean paramBoolean)
  {
    this.isConnected = paramBoolean;
  }
  
  public void setMaxCacheSizeBytes(int paramInt) {}
  
  public void setTimeoutRetryWaitSeconds(double paramDouble) {}
  
  abstract void simulateReboot();
  
  m<Object> waitForOperationSetAndEventuallyPin(ParseOperationSet paramParseOperationSet, EventuallyPin paramEventuallyPin)
  {
    return m.a(null);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseEventuallyQueue
 * JD-Core Version:    0.7.0.1
 */