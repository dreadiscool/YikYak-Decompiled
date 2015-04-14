package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.RemoteException;
import hZ;

public abstract class BaseImplementation$a<R extends Result, A extends Api.a>
  extends BaseImplementation.AbstractPendingResult<R>
  implements c.d<A>
{
  private final Api.c<A> Jn;
  private final GoogleApiClient Jx;
  private c.b Jy;
  
  public BaseImplementation$a(Api.c<A> paramc, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient.getLooper());
    this.Jn = ((Api.c)hZ.a(paramc));
    this.Jx = paramGoogleApiClient;
  }
  
  private void a(RemoteException paramRemoteException)
  {
    l(new Status(8, paramRemoteException.getLocalizedMessage(), null));
  }
  
  public abstract void a(A paramA);
  
  public void a(c.b paramb)
  {
    this.Jy = paramb;
  }
  
  public final void b(A paramA)
  {
    try
    {
      a(paramA);
      return;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      a(localDeadObjectException);
      throw localDeadObjectException;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        a(localRemoteException);
      }
    }
  }
  
  protected void gB()
  {
    super.gB();
    if (this.Jy != null)
    {
      this.Jy.b(this);
      this.Jy = null;
    }
  }
  
  public final a gE()
  {
    hZ.a(this.Jx, "GoogleApiClient was not set.");
    this.Jx.b(this);
    return this;
  }
  
  public int gF()
  {
    return 0;
  }
  
  public final Api.c<A> gz()
  {
    return this.Jn;
  }
  
  public final void l(Status paramStatus)
  {
    if (!paramStatus.isSuccess()) {}
    for (boolean bool = true;; bool = false)
    {
      hZ.b(bool, "Failed result must not be success");
      b(c(paramStatus));
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.BaseImplementation.a
 * JD-Core Version:    0.7.0.1
 */