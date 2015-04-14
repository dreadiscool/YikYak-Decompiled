import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

public final class BD
{
  long a = 0L;
  long b;
  final BF c;
  private final int e;
  private final Br f;
  private long g = 0L;
  private final List<AT> h;
  private List<AT> i;
  private final BG j;
  private final BH k = new BH(this);
  private final BH l = new BH(this);
  private AP m = null;
  
  static
  {
    if (!BD.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      return;
    }
  }
  
  BD(int paramInt, Br paramBr, boolean paramBoolean1, boolean paramBoolean2, List<AT> paramList)
  {
    if (paramBr == null) {
      throw new NullPointerException("connection == null");
    }
    if (paramList == null) {
      throw new NullPointerException("requestHeaders == null");
    }
    this.e = paramInt;
    this.f = paramBr;
    this.b = paramBr.f.e(65536);
    this.j = new BG(this, paramBr.e.e(65536), null);
    this.c = new BF(this);
    BG.a(this.j, paramBoolean2);
    BF.a(this.c, paramBoolean1);
    this.h = paramList;
  }
  
  /* Error */
  private boolean d(AP paramAP)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: getstatic 37	BD:d	Z
    //   5: ifne +18 -> 23
    //   8: aload_0
    //   9: invokestatic 115	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   12: ifeq +11 -> 23
    //   15: new 117	java/lang/AssertionError
    //   18: dup
    //   19: invokespecial 118	java/lang/AssertionError:<init>	()V
    //   22: athrow
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 56	BD:m	LAP;
    //   29: ifnull +8 -> 37
    //   32: aload_0
    //   33: monitorexit
    //   34: goto +58 -> 92
    //   37: aload_0
    //   38: getfield 91	BD:j	LBG;
    //   41: invokestatic 121	BG:a	(LBG;)Z
    //   44: ifeq +23 -> 67
    //   47: aload_0
    //   48: getfield 96	BD:c	LBF;
    //   51: invokestatic 124	BF:a	(LBF;)Z
    //   54: ifeq +13 -> 67
    //   57: aload_0
    //   58: monitorexit
    //   59: goto +33 -> 92
    //   62: astore_3
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_3
    //   66: athrow
    //   67: aload_0
    //   68: aload_1
    //   69: putfield 56	BD:m	LAP;
    //   72: aload_0
    //   73: invokevirtual 127	java/lang/Object:notifyAll	()V
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_0
    //   79: getfield 69	BD:f	LBr;
    //   82: aload_0
    //   83: getfield 67	BD:e	I
    //   86: invokevirtual 130	Br:b	(I)LBD;
    //   89: pop
    //   90: iconst_1
    //   91: istore_2
    //   92: iload_2
    //   93: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	BD
    //   0	94	1	paramAP	AP
    //   1	92	2	bool	boolean
    //   62	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   25	65	62	finally
    //   67	78	62	finally
  }
  
  private void i()
  {
    if ((!d) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    for (;;)
    {
      try
      {
        boolean bool;
        if ((!BG.a(this.j)) && (BG.b(this.j)))
        {
          if (BF.a(this.c)) {
            break label114;
          }
          if (BF.b(this.c))
          {
            break label114;
            bool = b();
            if (n == 0) {
              break label95;
            }
            a(AP.l);
            return;
          }
        }
        n = 0;
        continue;
        if (bool) {
          continue;
        }
      }
      finally {}
      label95:
      this.f.b(this.e);
      continue;
      label114:
      int n = 1;
    }
  }
  
  private void j()
  {
    if (BF.b(this.c)) {
      throw new IOException("stream closed");
    }
    if (BF.a(this.c)) {
      throw new IOException("stream finished");
    }
    if (this.m != null) {
      throw new IOException("stream was reset: " + this.m);
    }
  }
  
  private void k()
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new InterruptedIOException();
    }
  }
  
  public int a()
  {
    return this.e;
  }
  
  void a(long paramLong)
  {
    this.b = (paramLong + this.b);
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public void a(AP paramAP)
  {
    if (!d(paramAP)) {}
    for (;;)
    {
      return;
      this.f.b(this.e, paramAP);
    }
  }
  
  void a(LD paramLD, int paramInt)
  {
    if ((!d) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    this.j.a(paramLD, paramInt);
  }
  
  void a(List<AT> paramList, AU paramAU)
  {
    if ((!d) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    AP localAP = null;
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (this.i == null)
        {
          if (paramAU.c())
          {
            localAP = AP.b;
            if (localAP == null) {
              break label136;
            }
            b(localAP);
            return;
          }
          this.i = paramList;
          bool = b();
          notifyAll();
          continue;
        }
        if (!paramAU.d()) {
          break label97;
        }
      }
      finally {}
      localAP = AP.e;
      continue;
      label97:
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.i);
      localArrayList.addAll(paramList);
      this.i = localArrayList;
      continue;
      label136:
      if (!bool) {
        this.f.b(this.e);
      }
    }
  }
  
  public void b(AP paramAP)
  {
    if (!d(paramAP)) {}
    for (;;)
    {
      return;
      this.f.a(this.e, paramAP);
    }
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 56	BD:m	LAP;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 91	BD:j	LBG;
    //   21: invokestatic 121	BG:a	(LBG;)Z
    //   24: ifne +13 -> 37
    //   27: aload_0
    //   28: getfield 91	BD:j	LBG;
    //   31: invokestatic 138	BG:b	(LBG;)Z
    //   34: ifeq +34 -> 68
    //   37: aload_0
    //   38: getfield 96	BD:c	LBF;
    //   41: invokestatic 124	BF:a	(LBF;)Z
    //   44: ifne +13 -> 57
    //   47: aload_0
    //   48: getfield 96	BD:c	LBF;
    //   51: invokestatic 140	BF:b	(LBF;)Z
    //   54: ifeq +14 -> 68
    //   57: aload_0
    //   58: getfield 194	BD:i	Ljava/util/List;
    //   61: astore 4
    //   63: aload 4
    //   65: ifnonnull -52 -> 13
    //   68: iconst_1
    //   69: istore_1
    //   70: goto -57 -> 13
    //   73: astore_2
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_2
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	BD
    //   1	69	1	bool	boolean
    //   73	4	2	localObject	Object
    //   8	2	3	localAP	AP
    //   61	3	4	localList	List
    // Exception table:
    //   from	to	target	type
    //   4	9	73	finally
    //   17	63	73	finally
  }
  
  void c(AP paramAP)
  {
    try
    {
      if (this.m == null)
      {
        this.m = paramAP;
        notifyAll();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean c()
  {
    int n = 1;
    if ((0x1 & this.e) == n)
    {
      int i2 = n;
      if (this.f.b != i2) {
        break label32;
      }
    }
    for (;;)
    {
      return n;
      int i3 = 0;
      break;
      label32:
      int i1 = 0;
    }
  }
  
  public List<AT> d()
  {
    try
    {
      this.k.c();
    }
    finally
    {
      try
      {
        while ((this.i == null) && (this.m == null)) {
          k();
        }
      }
      finally
      {
        this.k.b();
      }
    }
    this.k.b();
    if (this.i != null)
    {
      List localList = this.i;
      return localList;
    }
    throw new IOException("stream was reset: " + this.m);
  }
  
  public LW e()
  {
    return this.k;
  }
  
  public LV f()
  {
    return this.j;
  }
  
  /* Error */
  public LU g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 194	BD:i	Ljava/util/List;
    //   6: ifnonnull +25 -> 31
    //   9: aload_0
    //   10: invokevirtual 228	BD:c	()Z
    //   13: ifne +18 -> 31
    //   16: new 230	java/lang/IllegalStateException
    //   19: dup
    //   20: ldc 232
    //   22: invokespecial 233	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   25: athrow
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: getfield 96	BD:c	LBF;
    //   37: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	BD
    //   26	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	26	finally
    //   31	33	26	finally
  }
  
  void h()
  {
    if ((!d) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      BG.a(this.j, true);
      boolean bool = b();
      notifyAll();
      if (!bool) {
        this.f.b(this.e);
      }
      return;
    }
    finally {}
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     BD
 * JD-Core Version:    0.7.0.1
 */