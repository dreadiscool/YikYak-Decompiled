import android.content.Context;
import android.os.Handler;

class gr
  extends fG
{
  private static final Object a = new Object();
  private static gr p;
  private Context b;
  private fP c;
  private volatile fU d;
  private int e = 1800;
  private boolean f = true;
  private boolean g;
  private String h;
  private boolean i = true;
  private boolean j = true;
  private fQ k = new gs(this);
  private Handler l;
  private gq m;
  private boolean n = false;
  private boolean o = false;
  
  public static gr c()
  {
    if (p == null) {
      p = new gr();
    }
    return p;
  }
  
  private void g()
  {
    this.m = new gq(this);
    this.m.a(this.b);
  }
  
  private void h()
  {
    this.l = new Handler(this.b.getMainLooper(), new gt(this));
    if (this.e > 0) {
      this.l.sendMessageDelayed(this.l.obtainMessage(1, a), 1000 * this.e);
    }
  }
  
  /* Error */
  void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 106	gr:d	LfU;
    //   6: ifnonnull +16 -> 22
    //   9: ldc 108
    //   11: invokestatic 113	fA:c	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 45	gr:f	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 118	gH:a	()LgH;
    //   25: getstatic 124	gI:S	LgI;
    //   28: invokevirtual 127	gH:a	(LgI;)V
    //   31: aload_0
    //   32: getfield 106	gr:d	LfU;
    //   35: invokeinterface 131 1 0
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	gr
    //   43	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	43	finally
    //   22	40	43	finally
  }
  
  /* Error */
  void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 69	gr:l	Landroid/os/Handler;
    //   6: ifnonnull +16 -> 22
    //   9: ldc 134
    //   11: invokestatic 113	fA:c	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 43	gr:e	I
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 118	gH:a	()LgH;
    //   25: getstatic 137	gI:T	LgI;
    //   28: invokevirtual 127	gH:a	(LgI;)V
    //   31: aload_0
    //   32: getfield 58	gr:n	Z
    //   35: ifne +28 -> 63
    //   38: aload_0
    //   39: getfield 47	gr:i	Z
    //   42: ifeq +21 -> 63
    //   45: aload_0
    //   46: getfield 43	gr:e	I
    //   49: ifle +14 -> 63
    //   52: aload_0
    //   53: getfield 69	gr:l	Landroid/os/Handler;
    //   56: iconst_1
    //   57: getstatic 40	gr:a	Ljava/lang/Object;
    //   60: invokevirtual 141	android/os/Handler:removeMessages	(ILjava/lang/Object;)V
    //   63: aload_0
    //   64: iload_1
    //   65: putfield 43	gr:e	I
    //   68: iload_1
    //   69: ifle -50 -> 19
    //   72: aload_0
    //   73: getfield 58	gr:n	Z
    //   76: ifne -57 -> 19
    //   79: aload_0
    //   80: getfield 47	gr:i	Z
    //   83: ifeq -64 -> 19
    //   86: aload_0
    //   87: getfield 69	gr:l	Landroid/os/Handler;
    //   90: aload_0
    //   91: getfield 69	gr:l	Landroid/os/Handler;
    //   94: iconst_1
    //   95: getstatic 40	gr:a	Ljava/lang/Object;
    //   98: invokevirtual 100	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   101: iload_1
    //   102: sipush 1000
    //   105: imul
    //   106: i2l
    //   107: invokevirtual 104	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   110: pop
    //   111: goto -92 -> 19
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	gr
    //   0	119	1	paramInt	int
    //   114	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	114	finally
    //   22	111	114	finally
  }
  
  /* Error */
  void a(Context paramContext, fU paramfU)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	gr:b	Landroid/content/Context;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 146	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   21: putfield 79	gr:b	Landroid/content/Context;
    //   24: aload_0
    //   25: getfield 106	gr:d	LfU;
    //   28: ifnonnull -15 -> 13
    //   31: aload_0
    //   32: aload_2
    //   33: putfield 106	gr:d	LfU;
    //   36: aload_0
    //   37: getfield 45	gr:f	Z
    //   40: ifeq +12 -> 52
    //   43: aload_0
    //   44: invokevirtual 147	gr:a	()V
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 45	gr:f	Z
    //   52: aload_0
    //   53: getfield 149	gr:g	Z
    //   56: ifeq -43 -> 13
    //   59: aload_0
    //   60: invokevirtual 151	gr:e	()V
    //   63: aload_0
    //   64: iconst_0
    //   65: putfield 149	gr:g	Z
    //   68: goto -55 -> 13
    //   71: astore_3
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_3
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	gr
    //   0	76	1	paramContext	Context
    //   0	76	2	paramfU	fU
    //   71	4	3	localObject	Object
    //   6	3	4	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	8	71	finally
    //   16	68	71	finally
  }
  
  void a(boolean paramBoolean)
  {
    try
    {
      a(this.n, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        if (this.n == paramBoolean1)
        {
          boolean bool = this.i;
          if (bool == paramBoolean2) {
            return;
          }
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (this.e > 0)) {
          this.l.removeMessages(1, a);
        }
        if ((!paramBoolean1) && (paramBoolean2) && (this.e > 0)) {
          this.l.sendMessageDelayed(this.l.obtainMessage(1, a), 1000 * this.e);
        }
        localStringBuilder = new StringBuilder().append("PowerSaveMode ");
        if (paramBoolean1) {
          break label157;
        }
        if (paramBoolean2) {
          break label150;
        }
      }
      finally {}
      fA.c(str);
      this.n = paramBoolean1;
      this.i = paramBoolean2;
      continue;
      label150:
      String str = "terminated.";
      continue;
      label157:
      str = "initiated.";
    }
  }
  
  void b()
  {
    try
    {
      if ((!this.n) && (this.i) && (this.e > 0))
      {
        this.l.removeMessages(1, a);
        this.l.sendMessage(this.l.obtainMessage(1, a));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  fP d()
  {
    try
    {
      if (this.c != null) {
        break label100;
      }
      if (this.b == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.c = new fC(this.k, this.b, new gd());
    this.c.a(this.o);
    if (this.h != null)
    {
      this.c.d().a(this.h);
      this.h = null;
    }
    label100:
    if (this.l == null) {
      h();
    }
    if ((this.m == null) && (this.j)) {
      g();
    }
    fP localfP = this.c;
    return localfP;
  }
  
  void e()
  {
    if (this.d == null)
    {
      fA.c("setForceLocalDispatch() queued. It will be called once initialization is complete.");
      this.g = true;
    }
    for (;;)
    {
      return;
      gH.a().a(gI.af);
      this.d.b();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gr
 * JD-Core Version:    0.7.0.1
 */