package com.parse;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ParseEventuallyQueue$TestHelper
{
  public static final int COMMAND_ENQUEUED = 3;
  public static final int COMMAND_FAILED = 2;
  public static final int COMMAND_NOT_ENQUEUED = 4;
  public static final int COMMAND_SUCCESSFUL = 1;
  private static final int MAX_EVENTS = 1000;
  public static final int NETWORK_DOWN = 7;
  public static final int OBJECT_REMOVED = 6;
  public static final int OBJECT_UPDATED = 5;
  private SparseArray<Semaphore> events = new SparseArray();
  
  private ParseEventuallyQueue$TestHelper()
  {
    clear();
  }
  
  public static String getEventString(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException("Encountered unknown event: " + paramInt);
    case 1: 
      str = "COMMAND_SUCCESSFUL";
    }
    for (;;)
    {
      return str;
      str = "COMMAND_FAILED";
      continue;
      str = "COMMAND_ENQUEUED";
      continue;
      str = "COMMAND_NOT_ENQUEUED";
      continue;
      str = "OBJECT_UPDATED";
      continue;
      str = "OBJECT_REMOVED";
      continue;
      str = "NETWORK_DOWN";
    }
  }
  
  public void clear()
  {
    this.events.clear();
    this.events.put(1, new Semaphore(1000));
    this.events.put(2, new Semaphore(1000));
    this.events.put(3, new Semaphore(1000));
    this.events.put(4, new Semaphore(1000));
    this.events.put(5, new Semaphore(1000));
    this.events.put(6, new Semaphore(1000));
    this.events.put(7, new Semaphore(1000));
    for (int i = 0; i < this.events.size(); i++)
    {
      int j = this.events.keyAt(i);
      ((Semaphore)this.events.get(j)).acquireUninterruptibly(1000);
    }
  }
  
  public List<String> getUnexpectedEvents()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < this.events.size(); i++)
    {
      int j = this.events.keyAt(i);
      if (((Semaphore)this.events.get(j)).availablePermits() > 0) {
        localArrayList.add(getEventString(j));
      }
    }
    return localArrayList;
  }
  
  public void notify(int paramInt)
  {
    ((Semaphore)this.events.get(paramInt)).release();
  }
  
  public int unexpectedEvents()
  {
    int i = 0;
    int j = 0;
    while (i < this.events.size())
    {
      int k = this.events.keyAt(i);
      j += ((Semaphore)this.events.get(k)).availablePermits();
      i++;
    }
    return j;
  }
  
  public boolean waitFor(int paramInt)
  {
    return waitFor(paramInt, 1);
  }
  
  public boolean waitFor(int paramInt1, int paramInt2)
  {
    try
    {
      boolean bool2 = ((Semaphore)this.events.get(paramInt1)).tryAcquire(paramInt2, 120L, TimeUnit.SECONDS);
      bool1 = bool2;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        boolean bool1 = false;
      }
    }
    return bool1;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseEventuallyQueue.TestHelper
 * JD-Core Version:    0.7.0.1
 */