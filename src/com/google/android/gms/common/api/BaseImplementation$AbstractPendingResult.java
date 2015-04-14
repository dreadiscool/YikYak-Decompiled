package com.google.android.gms.common.api;

import android.os.Looper;
import hL;
import hZ;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class BaseImplementation$AbstractPendingResult<R extends Result>
  implements BaseImplementation.b<R>, PendingResult<R>
{
  private final Object Jp = new Object();
  private final ArrayList<PendingResult.a> Jq = new ArrayList();
  private ResultCallback<R> Jr;
  private volatile R Js;
  private volatile boolean Jt;
  private boolean Ju;
  private boolean Jv;
  private hL Jw;
  protected final BaseImplementation.CallbackHandler<R> mHandler;
  private final CountDownLatch mr = new CountDownLatch(1);
  
  protected BaseImplementation$AbstractPendingResult(Looper paramLooper)
  {
    this.mHandler = new BaseImplementation.CallbackHandler(paramLooper);
  }
  
  protected BaseImplementation$AbstractPendingResult(BaseImplementation.CallbackHandler<R> paramCallbackHandler)
  {
    this.mHandler = paramCallbackHandler;
  }
  
  private void c(R paramR)
  {
    this.Js = paramR;
    this.Jw = null;
    this.mr.countDown();
    Status localStatus = this.Js.getStatus();
    if (this.Jr != null)
    {
      this.mHandler.removeTimeoutMessages();
      if (!this.Ju) {
        this.mHandler.sendResultCallback(this.Jr, gA());
      }
    }
    Iterator localIterator = this.Jq.iterator();
    while (localIterator.hasNext()) {
      ((PendingResult.a)localIterator.next()).m(localStatus);
    }
    this.Jq.clear();
  }
  
  private R gA()
  {
    for (;;)
    {
      synchronized (this.Jp)
      {
        if (!this.Jt)
        {
          bool = true;
          hZ.a(bool, "Result has already been consumed.");
          hZ.a(isReady(), "Result is not ready.");
          Result localResult = this.Js;
          gB();
          return localResult;
        }
      }
      boolean bool = false;
    }
  }
  
  private void gC()
  {
    synchronized (this.Jp)
    {
      if (!isReady())
      {
        b(c(Status.Kx));
        this.Jv = true;
      }
      return;
    }
  }
  
  private void gD()
  {
    synchronized (this.Jp)
    {
      if (!isReady())
      {
        b(c(Status.Kz));
        this.Jv = true;
      }
      return;
    }
  }
  
  public final void a(PendingResult.a parama)
  {
    boolean bool;
    if (!this.Jt) {
      bool = true;
    }
    for (;;)
    {
      hZ.a(bool, "Result has already been consumed.");
      synchronized (this.Jp)
      {
        if (isReady())
        {
          parama.m(this.Js.getStatus());
          return;
        }
        this.Jq.add(parama);
      }
    }
  }
  
  protected final void a(hL paramhL)
  {
    synchronized (this.Jp)
    {
      this.Jw = paramhL;
      return;
    }
  }
  
  public final R await()
  {
    boolean bool1 = true;
    boolean bool2;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool2 = bool1;
    }
    for (;;)
    {
      hZ.a(bool2, "await must not be called on the UI thread");
      if (!this.Jt) {
        hZ.a(bool1, "Result has already been consumed");
      }
      try
      {
        this.mr.await();
        hZ.a(isReady(), "Result is not ready.");
        return gA();
        bool2 = false;
        continue;
        bool1 = false;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          gC();
        }
      }
    }
  }
  
  public final R await(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((paramLong <= 0L) || (Looper.myLooper() != Looper.getMainLooper())) {
      bool2 = bool1;
    }
    for (;;)
    {
      hZ.a(bool2, "await must not be called on the UI thread when time is greater than zero.");
      if (!this.Jt) {
        hZ.a(bool1, "Result has already been consumed.");
      }
      try
      {
        if (!this.mr.await(paramLong, paramTimeUnit)) {
          gD();
        }
        hZ.a(isReady(), "Result is not ready.");
        return gA();
        bool2 = false;
        continue;
        bool1 = false;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          gC();
        }
      }
    }
  }
  
  public final void b(R paramR)
  {
    boolean bool1 = true;
    for (;;)
    {
      synchronized (this.Jp)
      {
        if ((this.Jv) || (this.Ju))
        {
          BaseImplementation.a(paramR);
          break;
        }
        if (!isReady())
        {
          bool2 = bool1;
          hZ.a(bool2, "Results have already been set");
          if (this.Jt) {
            break label85;
          }
          hZ.a(bool1, "Result has already been consumed");
          c(paramR);
        }
      }
      boolean bool2 = false;
      continue;
      label85:
      bool1 = false;
    }
  }
  
  public abstract R c(Status paramStatus);
  
  public void cancel()
  {
    synchronized (this.Jp)
    {
      if ((this.Ju) || (!this.Jt))
      {
        BaseImplementation.a(this.Js);
        this.Jr = null;
        this.Ju = true;
        c(c(Status.KA));
      }
    }
  }
  
  protected void gB()
  {
    this.Jt = true;
    this.Js = null;
    this.Jr = null;
  }
  
  public boolean isCanceled()
  {
    synchronized (this.Jp)
    {
      boolean bool = this.Ju;
      return bool;
    }
  }
  
  public final boolean isReady()
  {
    if (this.mr.getCount() == 0L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final void setResultCallback(ResultCallback<R> paramResultCallback)
  {
    if (!this.Jt) {}
    for (boolean bool = true;; bool = false)
    {
      hZ.a(bool, "Result has already been consumed.");
      synchronized (this.Jp)
      {
        if (!isCanceled()) {
          if (isReady()) {
            this.mHandler.sendResultCallback(paramResultCallback, gA());
          }
        }
      }
    }
  }
  
  public final void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool1 = true;
    boolean bool2;
    if (!this.Jt)
    {
      bool2 = bool1;
      hZ.a(bool2, "Result has already been consumed.");
      if (this.mHandler == null) {
        break label119;
      }
    }
    for (;;)
    {
      hZ.a(bool1, "CallbackHandler has not been set before calling setResultCallback.");
      synchronized (this.Jp)
      {
        if (!isCanceled()) {
          if (isReady()) {
            this.mHandler.sendResultCallback(paramResultCallback, gA());
          }
        }
      }
      bool2 = false;
      break;
      label119:
      bool1 = false;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.BaseImplementation.AbstractPendingResult
 * JD-Core Version:    0.7.0.1
 */