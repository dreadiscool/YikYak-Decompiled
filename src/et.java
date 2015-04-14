import android.content.Context;
import android.os.Handler;
import com.google.android.gms.common.util.VisibleForTesting;

public class et
  extends eY
{
  private static final Object a = new Object();
  private static et o;
  private Context b;
  private ed c;
  private volatile ef d;
  private int e = 1800;
  private boolean f = true;
  private boolean g;
  private String h;
  private boolean i = true;
  private boolean j = true;
  private ee k = new eu(this);
  private Handler l;
  private es m;
  private boolean n = false;
  
  public static et a()
  {
    if (o == null) {
      o = new et();
    }
    return o;
  }
  
  private void g()
  {
    this.m = new es(this);
    this.m.a(this.b);
  }
  
  private void h()
  {
    this.l = new Handler(this.b.getMainLooper(), new ev(this));
    if (this.e > 0) {
      this.l.sendMessageDelayed(this.l.obtainMessage(1, a), 1000 * this.e);
    }
  }
  
  /* Error */
  @Deprecated
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 66	et:l	Landroid/os/Handler;
    //   6: ifnonnull +16 -> 22
    //   9: ldc 105
    //   11: invokestatic 110	eO:c	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 42	et:e	I
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 115	eJ:a	()LeJ;
    //   25: getstatic 121	eK:T	LeK;
    //   28: invokevirtual 124	eJ:a	(LeK;)V
    //   31: aload_0
    //   32: getfield 57	et:n	Z
    //   35: ifne +28 -> 63
    //   38: aload_0
    //   39: getfield 46	et:i	Z
    //   42: ifeq +21 -> 63
    //   45: aload_0
    //   46: getfield 42	et:e	I
    //   49: ifle +14 -> 63
    //   52: aload_0
    //   53: getfield 66	et:l	Landroid/os/Handler;
    //   56: iconst_1
    //   57: getstatic 39	et:a	Ljava/lang/Object;
    //   60: invokevirtual 128	android/os/Handler:removeMessages	(ILjava/lang/Object;)V
    //   63: aload_0
    //   64: iload_1
    //   65: putfield 42	et:e	I
    //   68: iload_1
    //   69: ifle -50 -> 19
    //   72: aload_0
    //   73: getfield 57	et:n	Z
    //   76: ifne -57 -> 19
    //   79: aload_0
    //   80: getfield 46	et:i	Z
    //   83: ifeq -64 -> 19
    //   86: aload_0
    //   87: getfield 66	et:l	Landroid/os/Handler;
    //   90: aload_0
    //   91: getfield 66	et:l	Landroid/os/Handler;
    //   94: iconst_1
    //   95: getstatic 39	et:a	Ljava/lang/Object;
    //   98: invokevirtual 97	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   101: iload_1
    //   102: sipush 1000
    //   105: imul
    //   106: i2l
    //   107: invokevirtual 101	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   110: pop
    //   111: goto -92 -> 19
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	et
    //   0	119	1	paramInt	int
    //   114	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	114	finally
    //   22	111	114	finally
  }
  
  /* Error */
  void a(Context paramContext, ef paramef)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 76	et:b	Landroid/content/Context;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 133	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   21: putfield 76	et:b	Landroid/content/Context;
    //   24: aload_0
    //   25: getfield 135	et:d	Lef;
    //   28: ifnonnull -15 -> 13
    //   31: aload_0
    //   32: aload_2
    //   33: putfield 135	et:d	Lef;
    //   36: aload_0
    //   37: getfield 44	et:f	Z
    //   40: ifeq +12 -> 52
    //   43: aload_0
    //   44: invokevirtual 137	et:c	()V
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 44	et:f	Z
    //   52: aload_0
    //   53: getfield 139	et:g	Z
    //   56: ifeq -43 -> 13
    //   59: aload_0
    //   60: invokevirtual 141	et:d	()V
    //   63: aload_0
    //   64: iconst_0
    //   65: putfield 139	et:g	Z
    //   68: goto -55 -> 13
    //   71: astore_3
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_3
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	et
    //   0	76	1	paramContext	Context
    //   0	76	2	paramef	ef
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
  
  @VisibleForTesting
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
      eO.c(str);
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
  
  ed b()
  {
    try
    {
      if (this.c != null) {
        break label80;
      }
      if (this.b == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.c = new eU(this.k, this.b);
    if (this.h != null)
    {
      this.c.b().a(this.h);
      this.h = null;
    }
    label80:
    if (this.l == null) {
      h();
    }
    if ((this.m == null) && (this.j)) {
      g();
    }
    ed localed = this.c;
    return localed;
  }
  
  /* Error */
  @Deprecated
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 135	et:d	Lef;
    //   6: ifnonnull +16 -> 22
    //   9: ldc 194
    //   11: invokestatic 110	eO:c	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 44	et:f	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 115	eJ:a	()LeJ;
    //   25: getstatic 197	eK:S	LeK;
    //   28: invokevirtual 124	eJ:a	(LeK;)V
    //   31: aload_0
    //   32: getfield 135	et:d	Lef;
    //   35: invokeinterface 201 1 0
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	et
    //   43	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	43	finally
    //   22	40	43	finally
  }
  
  @Deprecated
  public void d()
  {
    if (this.d == null)
    {
      eO.c("setForceLocalDispatch() queued. It will be called once initialization is complete.");
      this.g = true;
    }
    for (;;)
    {
      return;
      eJ.a().a(eK.af);
      this.d.b();
    }
  }
  
  void e()
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
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     et
 * JD-Core Version:    0.7.0.1
 */