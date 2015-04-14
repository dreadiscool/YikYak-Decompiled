import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class nw
{
  private static nw g;
  private final nB a;
  private final Context b;
  private final no c;
  private final ol d;
  private final ConcurrentMap<ox, Boolean> e;
  private final oA f;
  
  nw(Context paramContext, nB paramnB, no paramno, ol paramol)
  {
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.b = paramContext.getApplicationContext();
    this.d = paramol;
    this.a = paramnB;
    this.e = new ConcurrentHashMap();
    this.c = paramno;
    this.c.a(new nx(this));
    this.c.a(new or(this.b));
    this.f = new oA();
    b();
  }
  
  /* Error */
  public static nw a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 75	nw:g	Lnw;
    //   6: ifnonnull +62 -> 68
    //   9: aload_0
    //   10: ifnonnull +22 -> 32
    //   13: ldc 77
    //   15: invokestatic 81	nK:a	(Ljava/lang/String;)V
    //   18: new 26	java/lang/NullPointerException
    //   21: dup
    //   22: invokespecial 82	java/lang/NullPointerException:<init>	()V
    //   25: athrow
    //   26: astore_1
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    //   32: new 2	nw
    //   35: dup
    //   36: aload_0
    //   37: new 84	ny
    //   40: dup
    //   41: invokespecial 85	ny:<init>	()V
    //   44: new 57	no
    //   47: dup
    //   48: new 87	oC
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 88	oC:<init>	(Landroid/content/Context;)V
    //   56: invokespecial 91	no:<init>	(Lnt;)V
    //   59: invokestatic 96	om:b	()Lom;
    //   62: invokespecial 98	nw:<init>	(Landroid/content/Context;LnB;Lno;Lol;)V
    //   65: putstatic 75	nw:g	Lnw;
    //   68: getstatic 75	nw:g	Lnw;
    //   71: astore_2
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_2
    //   76: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramContext	Context
    //   26	5	1	localObject	Object
    //   71	5	2	localnw	nw
    // Exception table:
    //   from	to	target	type
    //   3	30	26	finally
    //   32	75	26	finally
  }
  
  private void a(String paramString)
  {
    Iterator localIterator = this.e.keySet().iterator();
    while (localIterator.hasNext()) {
      ((ox)localIterator.next()).a(paramString);
    }
  }
  
  private void b()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.b.registerComponentCallbacks(new nz(this));
    }
  }
  
  public void a()
  {
    this.d.a();
  }
  
  public boolean a(Uri paramUri)
  {
    for (;;)
    {
      nV localnV;
      String str;
      boolean bool;
      try
      {
        localnV = nV.a();
        if (!localnV.a(paramUri)) {
          break label228;
        }
        str = localnV.d();
        int i = nA.a[localnV.b().ordinal()];
        switch (i)
        {
        default: 
          bool = true;
          return bool;
        }
      }
      finally {}
      Iterator localIterator2 = this.e.keySet().iterator();
      if (localIterator2.hasNext())
      {
        ox localox2 = (ox)localIterator2.next();
        if (localox2.b().equals(str))
        {
          localox2.b(null);
          localox2.a();
        }
      }
      else
      {
        continue;
        Iterator localIterator1 = this.e.keySet().iterator();
        while (localIterator1.hasNext())
        {
          ox localox1 = (ox)localIterator1.next();
          if (localox1.b().equals(str))
          {
            localox1.b(localnV.c());
            localox1.a();
          }
          else if (localox1.c() != null)
          {
            localox1.b(null);
            localox1.a();
          }
        }
        continue;
        label228:
        bool = false;
      }
    }
  }
  
  boolean a(ox paramox)
  {
    if (this.e.remove(paramox) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     nw
 * JD-Core Version:    0.7.0.1
 */