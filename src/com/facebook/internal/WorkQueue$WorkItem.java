package com.facebook.internal;

abstract interface WorkQueue$WorkItem
{
  public abstract boolean cancel();
  
  public abstract boolean isRunning();
  
  public abstract void moveToFront();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.WorkQueue.WorkItem
 * JD-Core Version:    0.7.0.1
 */