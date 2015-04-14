import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;

public class iL
{
  private final iR<iI> a;
  private final Context b;
  private ContentProviderClient c = null;
  private boolean d = false;
  private HashMap<ju, iN> e = new HashMap();
  
  public iL(Context paramContext, iR<iI> paramiR)
  {
    this.b = paramContext;
    this.a = paramiR;
  }
  
  private iN a(ju paramju, Looper paramLooper)
  {
    if (paramLooper == null) {
      hZ.a(Looper.myLooper(), "Can't create handler inside thread that has not called Looper.prepare()");
    }
    synchronized (this.e)
    {
      iN localiN = (iN)this.e.get(paramju);
      if (localiN == null) {
        localiN = new iN(paramju, paramLooper);
      }
      this.e.put(paramju, localiN);
      return localiN;
    }
  }
  
  public Location a()
  {
    this.a.a();
    try
    {
      Location localLocation = ((iI)this.a.c()).a(this.b.getPackageName());
      return localLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void a(LocationRequest paramLocationRequest, ju paramju, Looper paramLooper)
  {
    this.a.a();
    iN localiN = a(paramju, paramLooper);
    ((iI)this.a.c()).a(paramLocationRequest, localiN);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a();
    ((iI)this.a.c()).a(paramBoolean);
    this.d = paramBoolean;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	iL:e	Ljava/util/HashMap;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 30	iL:e	Ljava/util/HashMap;
    //   11: invokevirtual 99	java/util/HashMap:values	()Ljava/util/Collection;
    //   14: invokeinterface 105 1 0
    //   19: astore 4
    //   21: aload 4
    //   23: invokeinterface 111 1 0
    //   28: ifeq +57 -> 85
    //   31: aload 4
    //   33: invokeinterface 115 1 0
    //   38: checkcast 54	iN
    //   41: astore 5
    //   43: aload 5
    //   45: ifnull -24 -> 21
    //   48: aload_0
    //   49: getfield 34	iL:a	LiR;
    //   52: invokeinterface 70 1 0
    //   57: checkcast 72	iI
    //   60: aload 5
    //   62: invokeinterface 118 2 0
    //   67: goto -46 -> 21
    //   70: astore_3
    //   71: aload_2
    //   72: monitorexit
    //   73: aload_3
    //   74: athrow
    //   75: astore_1
    //   76: new 83	java/lang/IllegalStateException
    //   79: dup
    //   80: aload_1
    //   81: invokespecial 86	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   84: athrow
    //   85: aload_0
    //   86: getfield 30	iL:e	Ljava/util/HashMap;
    //   89: invokevirtual 121	java/util/HashMap:clear	()V
    //   92: aload_2
    //   93: monitorexit
    //   94: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	iL
    //   75	6	1	localRemoteException	RemoteException
    //   4	89	2	localHashMap	HashMap
    //   70	4	3	localObject	Object
    //   19	13	4	localIterator	java.util.Iterator
    //   41	20	5	localiN	iN
    // Exception table:
    //   from	to	target	type
    //   7	73	70	finally
    //   85	94	70	finally
    //   0	7	75	android/os/RemoteException
    //   73	75	75	android/os/RemoteException
  }
  
  public void c()
  {
    if (this.d) {}
    try
    {
      a(false);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iL
 * JD-Core Version:    0.7.0.1
 */