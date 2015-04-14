import java.io.IOException;
import java.io.InterruptedIOException;

public class Lu
  extends LW
{
  private static Lu a;
  private boolean c;
  private Lu d;
  private long e;
  
  private static void a(Lu paramLu, long paramLong, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (a == null)
        {
          a = new Lu();
          new Lx().start();
        }
        long l1 = System.nanoTime();
        if ((paramLong != 0L) && (paramBoolean))
        {
          paramLu.e = (l1 + Math.min(paramLong, paramLu.h() - l1));
          long l2 = paramLu.b(l1);
          localLu = a;
          if ((localLu.d != null) && (l2 >= localLu.d.b(l1))) {
            break label183;
          }
          paramLu.d = localLu.d;
          localLu.d = paramLu;
          if (localLu == a) {
            Lu.class.notify();
          }
          return;
        }
        if (paramLong != 0L)
        {
          long l3 = l1 + paramLong;
          paramLu.e = l3;
          continue;
        }
        if (!paramBoolean) {
          break label175;
        }
      }
      finally {}
      paramLu.e = paramLu.h();
      continue;
      label175:
      throw new AssertionError();
      label183:
      Lu localLu = localLu.d;
    }
  }
  
  /* Error */
  private static boolean a(Lu paramLu)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 18	Lu:a	LLu;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +39 -> 47
    //   11: aload_2
    //   12: getfield 48	Lu:d	LLu;
    //   15: aload_0
    //   16: if_acmpne +23 -> 39
    //   19: aload_2
    //   20: aload_0
    //   21: getfield 48	Lu:d	LLu;
    //   24: putfield 48	Lu:d	LLu;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 48	Lu:d	LLu;
    //   32: iconst_0
    //   33: istore_3
    //   34: ldc 2
    //   36: monitorexit
    //   37: iload_3
    //   38: ireturn
    //   39: aload_2
    //   40: getfield 48	Lu:d	LLu;
    //   43: astore_2
    //   44: goto -37 -> 7
    //   47: iconst_1
    //   48: istore_3
    //   49: goto -15 -> 34
    //   52: astore_1
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramLu	Lu
    //   52	5	1	localObject	Object
    //   6	38	2	localLu	Lu
    //   33	16	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	32	52	finally
    //   39	44	52	finally
  }
  
  private long b(long paramLong)
  {
    return this.e - paramLong;
  }
  
  private static Lu b()
  {
    Object localObject1 = null;
    for (;;)
    {
      Lu localLu;
      try
      {
        localLu = a.d;
        if (localLu == null)
        {
          Lu.class.wait();
          return localObject1;
        }
        long l1 = localLu.b(System.nanoTime());
        if (l1 > 0L)
        {
          long l2 = l1 / 1000000L;
          Lu.class.wait(l2, (int)(l1 - 1000000L * l2));
          continue;
        }
        a.d = localLu.d;
      }
      finally {}
      localLu.d = null;
      localObject1 = localLu;
    }
  }
  
  public final LU a(LU paramLU)
  {
    return new Lv(this, paramLU);
  }
  
  public final LV a(LV paramLV)
  {
    return new Lw(this, paramLV);
  }
  
  final IOException a(IOException paramIOException)
  {
    if (!d()) {}
    for (;;)
    {
      return paramIOException;
      InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
      localInterruptedIOException.initCause(paramIOException);
      paramIOException = localInterruptedIOException;
    }
  }
  
  protected void a() {}
  
  final void a(boolean paramBoolean)
  {
    if ((d()) && (paramBoolean)) {
      throw new InterruptedIOException("timeout");
    }
  }
  
  public final void c()
  {
    if (this.c) {
      throw new IllegalStateException("Unbalanced enter/exit");
    }
    long l = f();
    boolean bool = g();
    if ((l == 0L) && (!bool)) {}
    for (;;)
    {
      return;
      this.c = true;
      a(this, l, bool);
    }
  }
  
  public final boolean d()
  {
    boolean bool = false;
    if (!this.c) {}
    for (;;)
    {
      return bool;
      this.c = false;
      bool = a(this);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Lu
 * JD-Core Version:    0.7.0.1
 */