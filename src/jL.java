import android.app.Activity;
import android.app.Fragment;
import java.util.ArrayList;
import java.util.List;

public class jL
  extends gM<jJ>
{
  protected gY<jJ> a;
  private final Fragment b;
  private Activity c;
  private final List<jQ> d = new ArrayList();
  
  public jL(Fragment paramFragment)
  {
    this.b = paramFragment;
  }
  
  private void a(Activity paramActivity)
  {
    this.c = paramActivity;
    g();
  }
  
  protected void a(gY<jJ> paramgY)
  {
    this.a = paramgY;
    g();
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	jL:c	Landroid/app/Activity;
    //   4: ifnull +135 -> 139
    //   7: aload_0
    //   8: getfield 39	jL:a	LgY;
    //   11: ifnull +128 -> 139
    //   14: aload_0
    //   15: invokevirtual 46	jL:a	()LgL;
    //   18: ifnonnull +121 -> 139
    //   21: aload_0
    //   22: getfield 30	jL:c	Landroid/app/Activity;
    //   25: invokestatic 51	jP:a	(Landroid/content/Context;)I
    //   28: pop
    //   29: aload_0
    //   30: getfield 30	jL:c	Landroid/app/Activity;
    //   33: invokestatic 56	lX:a	(Landroid/content/Context;)LkO;
    //   36: aload_0
    //   37: getfield 30	jL:c	Landroid/app/Activity;
    //   40: invokestatic 61	gX:a	(Ljava/lang/Object;)LgU;
    //   43: invokeinterface 66 2 0
    //   48: astore 4
    //   50: aload_0
    //   51: getfield 39	jL:a	LgY;
    //   54: new 68	jJ
    //   57: dup
    //   58: aload_0
    //   59: getfield 27	jL:b	Landroid/app/Fragment;
    //   62: aload 4
    //   64: invokespecial 71	jJ:<init>	(Landroid/app/Fragment;Lkm;)V
    //   67: invokeinterface 76 2 0
    //   72: aload_0
    //   73: getfield 25	jL:d	Ljava/util/List;
    //   76: invokeinterface 82 1 0
    //   81: astore 5
    //   83: aload 5
    //   85: invokeinterface 88 1 0
    //   90: ifeq +40 -> 130
    //   93: aload 5
    //   95: invokeinterface 92 1 0
    //   100: checkcast 94	jQ
    //   103: astore 6
    //   105: aload_0
    //   106: invokevirtual 46	jL:a	()LgL;
    //   109: checkcast 68	jJ
    //   112: aload 6
    //   114: invokevirtual 97	jJ:a	(LjQ;)V
    //   117: goto -34 -> 83
    //   120: astore_2
    //   121: new 99	md
    //   124: dup
    //   125: aload_2
    //   126: invokespecial 102	md:<init>	(Landroid/os/RemoteException;)V
    //   129: athrow
    //   130: aload_0
    //   131: getfield 25	jL:d	Ljava/util/List;
    //   134: invokeinterface 105 1 0
    //   139: return
    //   140: astore_1
    //   141: goto -2 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	jL
    //   140	1	1	localGooglePlayServicesNotAvailableException	com.google.android.gms.common.GooglePlayServicesNotAvailableException
    //   120	6	2	localRemoteException	android.os.RemoteException
    //   48	15	4	localkm	km
    //   81	13	5	localIterator	java.util.Iterator
    //   103	10	6	localjQ	jQ
    // Exception table:
    //   from	to	target	type
    //   21	117	120	android/os/RemoteException
    //   130	139	120	android/os/RemoteException
    //   21	117	140	com/google/android/gms/common/GooglePlayServicesNotAvailableException
    //   130	139	140	com/google/android/gms/common/GooglePlayServicesNotAvailableException
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jL
 * JD-Core Version:    0.7.0.1
 */