import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.ArrayList;
import java.util.Iterator;

public final class hE
{
  final ArrayList<GoogleApiClient.ConnectionCallbacks> a = new ArrayList();
  private final hG b;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> c = new ArrayList();
  private boolean d = false;
  private final ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> e = new ArrayList();
  private final Handler f;
  
  public hE(Context paramContext, Looper paramLooper, hG paramhG)
  {
    this.b = paramhG;
    this.f = new hF(this, paramLooper);
  }
  
  protected void a()
  {
    synchronized (this.c)
    {
      a(this.b.fX());
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.f.removeMessages(1);
    synchronized (this.c)
    {
      this.d = true;
      Iterator localIterator = new ArrayList(this.c).iterator();
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
      do
      {
        if (localIterator.hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator.next();
          if (this.b.gN()) {}
        }
        else
        {
          this.d = false;
          return;
        }
      } while (!this.c.contains(localConnectionCallbacks));
      localConnectionCallbacks.onConnectionSuspended(paramInt);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    boolean bool1 = true;
    for (;;)
    {
      boolean bool2;
      synchronized (this.c)
      {
        if (!this.d)
        {
          bool2 = bool1;
          hZ.a(bool2);
          this.f.removeMessages(1);
          this.d = true;
          if (this.a.size() != 0) {
            break label164;
          }
          hZ.a(bool1);
          Iterator localIterator = new ArrayList(this.c).iterator();
          GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
          if (localIterator.hasNext())
          {
            localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator.next();
            if ((this.b.gN()) && (this.b.isConnected())) {}
          }
          else
          {
            this.a.clear();
            this.d = false;
            return;
          }
          if (this.a.contains(localConnectionCallbacks)) {
            continue;
          }
          localConnectionCallbacks.onConnected(paramBundle);
        }
      }
      continue;
      label164:
      bool1 = false;
    }
  }
  
  /* Error */
  public void a(com.google.android.gms.common.ConnectionResult paramConnectionResult)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	hE:f	Landroid/os/Handler;
    //   4: iconst_1
    //   5: invokevirtual 58	android/os/Handler:removeMessages	(I)V
    //   8: aload_0
    //   9: getfield 32	hE:e	Ljava/util/ArrayList;
    //   12: astore_2
    //   13: aload_2
    //   14: monitorenter
    //   15: new 23	java/util/ArrayList
    //   18: dup
    //   19: aload_0
    //   20: getfield 32	hE:e	Ljava/util/ArrayList;
    //   23: invokespecial 61	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   26: invokevirtual 65	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   29: astore 4
    //   31: aload 4
    //   33: invokeinterface 71 1 0
    //   38: ifeq +60 -> 98
    //   41: aload 4
    //   43: invokeinterface 75 1 0
    //   48: checkcast 108	com/google/android/gms/common/GooglePlayServicesClient$OnConnectionFailedListener
    //   51: astore 5
    //   53: aload_0
    //   54: getfield 34	hE:b	LhG;
    //   57: invokeinterface 80 1 0
    //   62: ifne +8 -> 70
    //   65: aload_2
    //   66: monitorexit
    //   67: goto +33 -> 100
    //   70: aload_0
    //   71: getfield 32	hE:e	Ljava/util/ArrayList;
    //   74: aload 5
    //   76: invokevirtual 84	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   79: ifeq -48 -> 31
    //   82: aload 5
    //   84: aload_1
    //   85: invokeinterface 111 2 0
    //   90: goto -59 -> 31
    //   93: astore_3
    //   94: aload_2
    //   95: monitorexit
    //   96: aload_3
    //   97: athrow
    //   98: aload_2
    //   99: monitorexit
    //   100: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	hE
    //   0	101	1	paramConnectionResult	com.google.android.gms.common.ConnectionResult
    //   12	87	2	localArrayList	ArrayList
    //   93	4	3	localObject	Object
    //   29	13	4	localIterator	Iterator
    //   51	32	5	localOnConnectionFailedListener	GooglePlayServicesClient.OnConnectionFailedListener
    // Exception table:
    //   from	to	target	type
    //   15	96	93	finally
    //   98	100	93	finally
  }
  
  public void a(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    hZ.a(paramOnConnectionFailedListener);
    synchronized (this.e)
    {
      if (this.e.contains(paramOnConnectionFailedListener))
      {
        new StringBuilder().append("registerConnectionFailedListener(): listener ").append(paramOnConnectionFailedListener).append(" is already registered").toString();
        return;
      }
      this.e.add(paramOnConnectionFailedListener);
    }
  }
  
  public void a(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    hZ.a(paramConnectionCallbacks);
    synchronized (this.c)
    {
      if (this.c.contains(paramConnectionCallbacks))
      {
        new StringBuilder().append("registerConnectionCallbacks(): listener ").append(paramConnectionCallbacks).append(" is already registered").toString();
        if (this.b.isConnected()) {
          this.f.sendMessage(this.f.obtainMessage(1, paramConnectionCallbacks));
        }
        return;
      }
      this.c.add(paramConnectionCallbacks);
    }
  }
  
  public boolean b(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    hZ.a(paramOnConnectionFailedListener);
    synchronized (this.e)
    {
      boolean bool = this.e.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }
  
  public boolean b(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    hZ.a(paramConnectionCallbacks);
    synchronized (this.c)
    {
      boolean bool = this.c.contains(paramConnectionCallbacks);
      return bool;
    }
  }
  
  public void c(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    hZ.a(paramOnConnectionFailedListener);
    synchronized (this.e)
    {
      if ((this.e != null) && (!this.e.remove(paramOnConnectionFailedListener))) {
        new StringBuilder().append("unregisterConnectionFailedListener(): listener ").append(paramOnConnectionFailedListener).append(" not found").toString();
      }
      return;
    }
  }
  
  public void c(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    hZ.a(paramConnectionCallbacks);
    synchronized (this.c)
    {
      if (this.c != null)
      {
        if (this.c.remove(paramConnectionCallbacks)) {
          break label58;
        }
        new StringBuilder().append("unregisterConnectionCallbacks(): listener ").append(paramConnectionCallbacks).append(" not found").toString();
      }
      label58:
      while (!this.d) {
        return;
      }
      this.a.add(paramConnectionCallbacks);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hE
 * JD-Core Version:    0.7.0.1
 */