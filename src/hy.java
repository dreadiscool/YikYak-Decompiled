import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.a;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;

public abstract class hy<T extends IInterface>
  implements Api.a, hG
{
  public static final String[] c;
  final Handler a;
  boolean b = false;
  private final Context d;
  private final Looper e;
  private final Object f = new Object();
  private T g;
  private final ArrayList<hy<T>.hA<?>> h = new ArrayList();
  private hy<T>.hC i;
  private int j = 1;
  private final String[] k;
  private final hE l;
  
  static
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "service_esmobile";
    arrayOfString[1] = "service_googleme";
    c = arrayOfString;
  }
  
  protected hy(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String... paramVarArgs)
  {
    this.d = ((Context)hZ.a(paramContext));
    this.e = ((Looper)hZ.a(paramLooper, "Looper must not be null"));
    this.l = new hE(paramContext, paramLooper, this);
    this.a = new hz(this, paramLooper);
    this.k = paramVarArgs;
    a((GoogleApiClient.ConnectionCallbacks)hZ.a(paramConnectionCallbacks));
    a((GoogleApiClient.OnConnectionFailedListener)hZ.a(paramOnConnectionFailedListener));
  }
  
  private void a(int paramInt, T paramT)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    if (paramInt == 3)
    {
      bool2 = bool1;
      if (paramT == null) {
        break label65;
      }
      bool3 = bool1;
      label17:
      if (bool2 != bool3) {
        break label71;
      }
    }
    for (;;)
    {
      hZ.b(bool1);
      synchronized (this.f)
      {
        this.j = paramInt;
        this.g = paramT;
        return;
      }
      bool2 = false;
      break;
      label65:
      bool3 = false;
      break label17;
      label71:
      bool1 = false;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, T paramT)
  {
    boolean bool;
    synchronized (this.f)
    {
      if (this.j != paramInt1)
      {
        bool = false;
      }
      else
      {
        a(paramInt2, paramT);
        bool = true;
      }
    }
    return bool;
  }
  
  protected abstract T a(IBinder paramIBinder);
  
  protected abstract String a();
  
  public void a(int paramInt)
  {
    this.a.sendMessage(this.a.obtainMessage(4, Integer.valueOf(paramInt)));
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    this.a.sendMessage(this.a.obtainMessage(1, new hD(this, paramInt, paramIBinder, paramBundle)));
  }
  
  public void a(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.l.a(paramConnectionCallbacks);
  }
  
  public void a(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.l.a(paramOnConnectionFailedListener);
  }
  
  protected abstract void a(hP paramhP, hB paramhB);
  
  protected abstract String b();
  
  protected final void b(IBinder paramIBinder)
  {
    try
    {
      a(hQ.a(paramIBinder), new hB(this));
      label16:
      return;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      for (;;)
      {
        a(1);
      }
    }
    catch (RemoteException localRemoteException)
    {
      break label16;
    }
  }
  
  public boolean c()
  {
    for (;;)
    {
      synchronized (this.f)
      {
        if (this.j == 2)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void connect()
  {
    this.b = true;
    a(2, null);
    int m = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.d);
    if (m != 0)
    {
      a(1, null);
      this.a.sendMessage(this.a.obtainMessage(3, Integer.valueOf(m)));
    }
    for (;;)
    {
      return;
      if (this.i != null)
      {
        new StringBuilder().append("Calling connect() while still connected, missing disconnect() for ").append(a()).toString();
        hH.a(this.d).b(a(), this.i);
      }
      this.i = new hC(this);
      if (!hH.a(this.d).a(a(), this.i))
      {
        new StringBuilder().append("unable to connect to service: ").append(a()).toString();
        this.a.sendMessage(this.a.obtainMessage(3, Integer.valueOf(9)));
      }
    }
  }
  
  public final Context d()
  {
    return this.d;
  }
  
  public void disconnect()
  {
    this.b = false;
    synchronized (this.h)
    {
      int m = this.h.size();
      for (int n = 0; n < m; n++) {
        ((hA)this.h.get(n)).c();
      }
      this.h.clear();
      a(1, null);
      if (this.i != null)
      {
        hH.a(this.d).b(a(), this.i);
        this.i = null;
      }
      return;
    }
  }
  
  protected final void e()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  /* Error */
  public final T f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	hy:f	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 58	hy:j	I
    //   11: iconst_4
    //   12: if_icmpne +16 -> 28
    //   15: new 157	android/os/DeadObjectException
    //   18: dup
    //   19: invokespecial 240	android/os/DeadObjectException:<init>	()V
    //   22: athrow
    //   23: astore_2
    //   24: aload_1
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    //   28: aload_0
    //   29: invokevirtual 242	hy:e	()V
    //   32: aload_0
    //   33: getfield 114	hy:g	Landroid/os/IInterface;
    //   36: ifnull +22 -> 58
    //   39: iconst_1
    //   40: istore_3
    //   41: iload_3
    //   42: ldc 244
    //   44: invokestatic 247	hZ:a	(ZLjava/lang/Object;)V
    //   47: aload_0
    //   48: getfield 114	hy:g	Landroid/os/IInterface;
    //   51: astore 4
    //   53: aload_1
    //   54: monitorexit
    //   55: aload 4
    //   57: areturn
    //   58: iconst_0
    //   59: istore_3
    //   60: goto -19 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	hy
    //   4	50	1	localObject1	Object
    //   23	4	2	localObject2	Object
    //   40	20	3	bool	boolean
    //   51	5	4	localIInterface	IInterface
    // Exception table:
    //   from	to	target	type
    //   7	26	23	finally
    //   28	55	23	finally
  }
  
  public Bundle fX()
  {
    return null;
  }
  
  public boolean gN()
  {
    return this.b;
  }
  
  public boolean isConnected()
  {
    for (;;)
    {
      synchronized (this.f)
      {
        if (this.j == 3)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hy
 * JD-Core Version:    0.7.0.1
 */