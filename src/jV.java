import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import java.util.ArrayList;
import java.util.List;

public class jV
  extends gM<jT>
{
  protected gY<jT> a;
  private final ViewGroup b;
  private final Context c;
  private final StreetViewPanoramaOptions d;
  private final List<jR> e = new ArrayList();
  
  public jV(ViewGroup paramViewGroup, Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
  {
    this.b = paramViewGroup;
    this.c = paramContext;
    this.d = paramStreetViewPanoramaOptions;
  }
  
  protected void a(gY<jT> paramgY)
  {
    this.a = paramgY;
    g();
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	jV:a	LgY;
    //   4: ifnull +122 -> 126
    //   7: aload_0
    //   8: invokevirtual 46	jV:a	()LgL;
    //   11: ifnonnull +115 -> 126
    //   14: aload_0
    //   15: getfield 31	jV:c	Landroid/content/Context;
    //   18: invokestatic 51	lX:a	(Landroid/content/Context;)LkO;
    //   21: aload_0
    //   22: getfield 31	jV:c	Landroid/content/Context;
    //   25: invokestatic 56	gX:a	(Ljava/lang/Object;)LgU;
    //   28: aload_0
    //   29: getfield 33	jV:d	Lcom/google/android/gms/maps/StreetViewPanoramaOptions;
    //   32: invokeinterface 61 3 0
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 36	jV:a	LgY;
    //   42: new 63	jT
    //   45: dup
    //   46: aload_0
    //   47: getfield 29	jV:b	Landroid/view/ViewGroup;
    //   50: aload_3
    //   51: invokespecial 66	jT:<init>	(Landroid/view/ViewGroup;LkB;)V
    //   54: invokeinterface 71 2 0
    //   59: aload_0
    //   60: getfield 27	jV:e	Ljava/util/List;
    //   63: invokeinterface 77 1 0
    //   68: astore 4
    //   70: aload 4
    //   72: invokeinterface 83 1 0
    //   77: ifeq +40 -> 117
    //   80: aload 4
    //   82: invokeinterface 87 1 0
    //   87: checkcast 89	jR
    //   90: astore 5
    //   92: aload_0
    //   93: invokevirtual 46	jV:a	()LgL;
    //   96: checkcast 63	jT
    //   99: aload 5
    //   101: invokevirtual 92	jT:a	(LjR;)V
    //   104: goto -34 -> 70
    //   107: astore_2
    //   108: new 94	md
    //   111: dup
    //   112: aload_2
    //   113: invokespecial 97	md:<init>	(Landroid/os/RemoteException;)V
    //   116: athrow
    //   117: aload_0
    //   118: getfield 27	jV:e	Ljava/util/List;
    //   121: invokeinterface 100 1 0
    //   126: return
    //   127: astore_1
    //   128: goto -2 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	jV
    //   127	1	1	localGooglePlayServicesNotAvailableException	com.google.android.gms.common.GooglePlayServicesNotAvailableException
    //   107	6	2	localRemoteException	android.os.RemoteException
    //   37	14	3	localkB	kB
    //   68	13	4	localIterator	java.util.Iterator
    //   90	10	5	localjR	jR
    // Exception table:
    //   from	to	target	type
    //   14	104	107	android/os/RemoteException
    //   117	126	107	android/os/RemoteException
    //   14	104	127	com/google/android/gms/common/GooglePlayServicesNotAvailableException
    //   117	126	127	com/google/android/gms/common/GooglePlayServicesNotAvailableException
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jV
 * JD-Core Version:    0.7.0.1
 */