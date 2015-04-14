import com.google.android.gms.common.util.VisibleForTesting;

public class rv
{
  private final rK a;
  private rw b;
  private rH c;
  private ru d;
  private volatile String e;
  private volatile dG f;
  private volatile long g;
  private volatile int h;
  
  private boolean b(long paramLong)
  {
    boolean bool = true;
    if (this.g == 0L) {
      this.h = (-1 + this.h);
    }
    for (;;)
    {
      return bool;
      long l = paramLong - this.g;
      if (l < 5000L)
      {
        bool = false;
      }
      else
      {
        if (this.h < 30) {
          this.h = Math.min(30, (int)Math.floor(l / 900000L) + this.h);
        }
        if (this.h > 0) {
          this.h = (-1 + this.h);
        } else {
          bool = false;
        }
      }
    }
  }
  
  private rH c()
  {
    try
    {
      rH localrH = this.c;
      return localrH;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean d()
  {
    if (this.a.a() == rP.b) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        if (c() == null)
        {
          rB.b("refresh called for closed container");
          return;
        }
        try
        {
          if (!d()) {
            break label66;
          }
          rB.b("Container is in DEFAULT_CONTAINER mode. Refresh request is ignored.");
        }
        catch (Exception localException)
        {
          rB.a("Calling refresh() throws an exception: " + localException.getMessage());
        }
        continue;
        l = this.d.a();
      }
      finally {}
      label66:
      long l;
      if (b(l))
      {
        rB.d("Container refresh requested");
        a(0L);
        this.g = l;
      }
      else
      {
        rB.d("Container refresh was called too often. Ignored.");
      }
    }
  }
  
  /* Error */
  @VisibleForTesting
  void a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 112	rv:b	Lrw;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: invokespecial 69	rv:d	()Z
    //   13: ifne +14 -> 27
    //   16: aload_0
    //   17: getfield 114	rv:f	LdG;
    //   20: astore 4
    //   22: aload 4
    //   24: ifnonnull +6 -> 30
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: getfield 114	rv:f	LdG;
    //   34: invokevirtual 119	dG:C	()Ljava/lang/String;
    //   37: pop
    //   38: goto -11 -> 27
    //   41: astore_3
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_3
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	rv
    //   0	46	1	paramLong	long
    //   41	4	3	localObject	Object
    //   20	3	4	localdG	dG
    // Exception table:
    //   from	to	target	type
    //   2	22	41	finally
    //   30	38	41	finally
  }
  
  @VisibleForTesting
  void a(String paramString)
  {
    try
    {
      this.e = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  String b()
  {
    return this.e;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     rv
 * JD-Core Version:    0.7.0.1
 */