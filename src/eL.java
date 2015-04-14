import android.content.Context;
import com.google.analytics.tracking.android.Tracker;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

public class eL
  extends fc
{
  private static eL g;
  private boolean a;
  private ef b;
  private Context c;
  private volatile Boolean d = Boolean.valueOf(false);
  private final Map<String, Tracker> e = new HashMap();
  private eP f;
  
  @VisibleForTesting
  protected eL(Context paramContext)
  {
    this(paramContext, eF.a(paramContext));
  }
  
  private eL(Context paramContext, ef paramef)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context cannot be null");
    }
    this.c = paramContext.getApplicationContext();
    this.b = paramef;
    eg.a(this.c);
    eX.a(this.c);
    eh.a(this.c);
    this.f = new ek();
  }
  
  static eL a()
  {
    try
    {
      eL localeL = g;
      return localeL;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static eL a(Context paramContext)
  {
    try
    {
      if (g == null) {
        g = new eL(paramContext);
      }
      eL localeL = g;
      return localeL;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  void a(Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +20 -> 23
    //   6: new 48	java/lang/IllegalArgumentException
    //   9: dup
    //   10: ldc 87
    //   12: invokespecial 53	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   15: athrow
    //   16: astore 4
    //   18: aload_0
    //   19: monitorexit
    //   20: aload 4
    //   22: athrow
    //   23: aload_1
    //   24: ldc 89
    //   26: invokestatic 95	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   29: invokestatic 100	fd:a	(Ljava/util/Locale;)Ljava/lang/String;
    //   32: invokestatic 103	fd:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_1
    //   36: ldc 105
    //   38: invokestatic 108	eX:a	()LeX;
    //   41: ldc 105
    //   43: invokevirtual 111	eX:b	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokestatic 103	fd:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_1
    //   50: ldc 113
    //   52: invokestatic 118	eJ:a	()LeJ;
    //   55: invokevirtual 121	eJ:c	()Ljava/lang/String;
    //   58: invokeinterface 127 3 0
    //   63: pop
    //   64: invokestatic 118	eJ:a	()LeJ;
    //   67: invokevirtual 129	eJ:b	()Ljava/lang/String;
    //   70: pop
    //   71: aload_0
    //   72: getfield 63	eL:b	Lef;
    //   75: aload_1
    //   76: invokeinterface 133 2 0
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	eL
    //   0	84	1	paramMap	Map<String, String>
    //   16	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	20	16	finally
    //   23	83	16	finally
  }
  
  public void a(boolean paramBoolean)
  {
    eJ.a().a(eK.ac);
    this.a = paramBoolean;
  }
  
  public boolean b()
  {
    eJ.a().a(eK.ad);
    return this.a;
  }
  
  public boolean c()
  {
    eJ.a().a(eK.R);
    return this.d.booleanValue();
  }
  
  public eP d()
  {
    return this.f;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     eL
 * JD-Core Version:    0.7.0.1
 */