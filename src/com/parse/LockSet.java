package com.parse;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

class LockSet
{
  private static long nextStableId = 0L;
  private static WeakHashMap<Lock, Long> stableIds = new WeakHashMap();
  private final Set<Lock> locks = new TreeSet(new LockSet.1(this));
  
  public LockSet(Collection<Lock> paramCollection)
  {
    this.locks.addAll(paramCollection);
  }
  
  private static Long getStableId(Lock paramLock)
  {
    Long localLong;
    synchronized (stableIds)
    {
      if (stableIds.containsKey(paramLock))
      {
        localLong = (Long)stableIds.get(paramLock);
      }
      else
      {
        long l = nextStableId;
        nextStableId = 1L + l;
        stableIds.put(paramLock, Long.valueOf(l));
        localLong = Long.valueOf(l);
      }
    }
    return localLong;
  }
  
  public void lock()
  {
    Iterator localIterator = this.locks.iterator();
    while (localIterator.hasNext()) {
      ((Lock)localIterator.next()).lock();
    }
  }
  
  public void unlock()
  {
    Iterator localIterator = this.locks.iterator();
    while (localIterator.hasNext()) {
      ((Lock)localIterator.next()).unlock();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.LockSet
 * JD-Core Version:    0.7.0.1
 */