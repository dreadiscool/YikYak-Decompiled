package com.google.android.gms.common.api;

import android.os.Looper;
import android.os.Message;
import hZ;

public final class d<L>
{
  private final d<L>.a Kt;
  private volatile L mListener;
  
  d(Looper paramLooper, L paramL)
  {
    this.Kt = new d.a(this, paramLooper);
    this.mListener = hZ.a(paramL, "Listener must not be null");
  }
  
  public void a(d.b<? super L> paramb)
  {
    hZ.a(paramb, "Notifier must not be null");
    Message localMessage = this.Kt.obtainMessage(1, paramb);
    this.Kt.sendMessage(localMessage);
  }
  
  void b(d.b<? super L> paramb)
  {
    Object localObject = this.mListener;
    if (localObject == null) {
      paramb.gG();
    }
    for (;;)
    {
      return;
      try
      {
        paramb.c(localObject);
      }
      catch (Exception localException)
      {
        paramb.gG();
      }
    }
  }
  
  public void clear()
  {
    this.mListener = null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.d
 * JD-Core Version:    0.7.0.1
 */