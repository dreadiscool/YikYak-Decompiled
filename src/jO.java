import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.maps.GoogleMapOptions;
import java.util.ArrayList;
import java.util.List;

public class jO
  extends gM<jM>
{
  protected gY<jM> a;
  private final ViewGroup b;
  private final Context c;
  private final GoogleMapOptions d;
  private final List<jQ> e = new ArrayList();
  
  public jO(ViewGroup paramViewGroup, Context paramContext, GoogleMapOptions paramGoogleMapOptions)
  {
    this.b = paramViewGroup;
    this.c = paramContext;
    this.d = paramGoogleMapOptions;
  }
  
  protected void a(gY<jM> paramgY)
  {
    this.a = paramgY;
    g();
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	jO:a	LgY;
    //   4: ifnull +122 -> 126
    //   7: aload_0
    //   8: invokevirtual 46	jO:a	()LgL;
    //   11: ifnonnull +115 -> 126
    //   14: aload_0
    //   15: getfield 31	jO:c	Landroid/content/Context;
    //   18: invokestatic 51	lX:a	(Landroid/content/Context;)LkO;
    //   21: aload_0
    //   22: getfield 31	jO:c	Landroid/content/Context;
    //   25: invokestatic 56	gX:a	(Ljava/lang/Object;)LgU;
    //   28: aload_0
    //   29: getfield 33	jO:d	Lcom/google/android/gms/maps/GoogleMapOptions;
    //   32: invokeinterface 61 3 0
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 36	jO:a	LgY;
    //   42: new 63	jM
    //   45: dup
    //   46: aload_0
    //   47: getfield 29	jO:b	Landroid/view/ViewGroup;
    //   50: aload_3
    //   51: invokespecial 66	jM:<init>	(Landroid/view/ViewGroup;Lkp;)V
    //   54: invokeinterface 71 2 0
    //   59: aload_0
    //   60: getfield 27	jO:e	Ljava/util/List;
    //   63: invokeinterface 77 1 0
    //   68: astore 4
    //   70: aload 4
    //   72: invokeinterface 83 1 0
    //   77: ifeq +40 -> 117
    //   80: aload 4
    //   82: invokeinterface 87 1 0
    //   87: checkcast 89	jQ
    //   90: astore 5
    //   92: aload_0
    //   93: invokevirtual 46	jO:a	()LgL;
    //   96: checkcast 63	jM
    //   99: aload 5
    //   101: invokevirtual 92	jM:a	(LjQ;)V
    //   104: goto -34 -> 70
    //   107: astore_2
    //   108: new 94	md
    //   111: dup
    //   112: aload_2
    //   113: invokespecial 97	md:<init>	(Landroid/os/RemoteException;)V
    //   116: athrow
    //   117: aload_0
    //   118: getfield 27	jO:e	Ljava/util/List;
    //   121: invokeinterface 100 1 0
    //   126: return
    //   127: astore_1
    //   128: goto -2 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	jO
    //   127	1	1	localGooglePlayServicesNotAvailableException	com.google.android.gms.common.GooglePlayServicesNotAvailableException
    //   107	6	2	localRemoteException	android.os.RemoteException
    //   37	14	3	localkp	kp
    //   68	13	4	localIterator	java.util.Iterator
    //   90	10	5	localjQ	jQ
    // Exception table:
    //   from	to	target	type
    //   14	104	107	android/os/RemoteException
    //   117	126	107	android/os/RemoteException
    //   14	104	127	com/google/android/gms/common/GooglePlayServicesNotAvailableException
    //   117	126	127	com/google/android/gms/common/GooglePlayServicesNotAvailableException
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jO
 * JD-Core Version:    0.7.0.1
 */