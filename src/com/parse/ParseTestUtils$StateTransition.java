package com.parse;

class ParseTestUtils$StateTransition
{
  public final PushConnection connection;
  public final PushConnection.State fromState;
  public final long timestamp;
  public final PushConnection.State toState;
  
  ParseTestUtils$StateTransition(long paramLong, PushConnection paramPushConnection, PushConnection.State paramState1, PushConnection.State paramState2)
  {
    this.timestamp = paramLong;
    this.connection = paramPushConnection;
    this.fromState = paramState1;
    this.toState = paramState2;
  }
  
  public String toString()
  {
    return this.timestamp + " ms: " + this.fromState + " to " + this.toState;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseTestUtils.StateTransition
 * JD-Core Version:    0.7.0.1
 */