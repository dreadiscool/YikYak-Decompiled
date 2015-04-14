package com.parse;

import android.os.SystemClock;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PushConnection$EventSet
{
  private final Condition condition = this.lock.newCondition();
  private final Lock lock = new ReentrantLock();
  private final HashSet<PushConnection.Event> signaledEvents = new HashSet();
  
  public Set<PushConnection.Event> await(PushConnection.Event... paramVarArgs)
  {
    return timedAwait(9223372036854775807L, paramVarArgs);
  }
  
  public void removeEvents(PushConnection.Event... paramVarArgs)
  {
    this.lock.lock();
    try
    {
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++)
      {
        PushConnection.Event localEvent = paramVarArgs[j];
        this.signaledEvents.remove(localEvent);
      }
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void signalEvent(PushConnection.Event paramEvent)
  {
    this.lock.lock();
    try
    {
      this.signaledEvents.add(paramEvent);
      this.condition.signalAll();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public Set<PushConnection.Event> timedAwait(long paramLong, PushConnection.Event... paramVarArgs)
  {
    HashSet localHashSet1 = new HashSet(Arrays.asList(paramVarArgs));
    long l1 = SystemClock.elapsedRealtime();
    int i;
    if (paramLong == 9223372036854775807L)
    {
      i = 1;
      this.lock.lock();
    }
    for (;;)
    {
      try
      {
        long l2 = SystemClock.elapsedRealtime() - l1;
        HashSet localHashSet2 = new HashSet(localHashSet1);
        localHashSet2.retainAll(this.signaledEvents);
        this.signaledEvents.removeAll(localHashSet1);
        int j = localHashSet2.size();
        if ((j != 0) || ((i == 0) && (l2 >= paramLong)))
        {
          return localHashSet2;
          i = 0;
          break;
        }
        if (i != 0) {
          this.condition.awaitUninterruptibly();
        } else {
          try
          {
            this.condition.await(paramLong - l2, TimeUnit.MILLISECONDS);
          }
          catch (InterruptedException localInterruptedException) {}
        }
      }
      finally
      {
        this.lock.unlock();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushConnection.EventSet
 * JD-Core Version:    0.7.0.1
 */