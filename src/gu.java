import android.content.Context;
import com.google.android.gms.internal.ha;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

class gu
  implements fH, fN, fO
{
  private volatile long a;
  private volatile gx b;
  private volatile fK c;
  private fP d;
  private fP e;
  private final fl f;
  private final fU g;
  private final Context h;
  private final Queue<gA> i = new ConcurrentLinkedQueue();
  private volatile int j;
  private volatile Timer k;
  private volatile Timer l;
  private volatile Timer m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private it r;
  private long s = 300000L;
  
  gu(Context paramContext, fU paramfU)
  {
    this(paramContext, paramfU, null, fl.a(paramContext));
  }
  
  gu(Context paramContext, fU paramfU, fP paramfP, fl paramfl)
  {
    this.e = paramfP;
    this.h = paramContext;
    this.g = paramfU;
    this.f = paramfl;
    this.r = iu.c();
    this.j = 0;
    this.b = gx.g;
  }
  
  private Timer a(Timer paramTimer)
  {
    if (paramTimer != null) {
      paramTimer.cancel();
    }
    return null;
  }
  
  private void g()
  {
    this.k = a(this.k);
    this.l = a(this.l);
    this.m = a(this.m);
  }
  
  private void h()
  {
    for (;;)
    {
      try
      {
        if (!Thread.currentThread().equals(this.g.d()))
        {
          this.g.c().add(new gv(this));
          return;
        }
        if (this.o) {
          f();
        }
        switch (gw.a[this.b.ordinal()])
        {
        case 1: 
          if (this.i.isEmpty()) {
            break;
          }
          gA localgA2 = (gA)this.i.poll();
          fA.c("Sending hit to store  " + localgA2);
          this.d.a(localgA2.a(), localgA2.b(), localgA2.c(), localgA2.d());
          break;
        case 7: 
          fA.c("Blocked. Dropping hits.");
        }
      }
      finally {}
      this.i.clear();
      continue;
      if (this.n)
      {
        i();
        continue;
        if (!this.i.isEmpty())
        {
          gA localgA1 = (gA)this.i.peek();
          fA.c("Sending hit to service   " + localgA1);
          if (!this.f.b()) {
            this.c.a(localgA1.a(), localgA1.b(), localgA1.c(), localgA1.d());
          }
          for (;;)
          {
            this.i.poll();
            break;
            fA.c("Dry run enabled. Hit not actually sent to service.");
          }
        }
        this.a = this.r.b();
        continue;
        fA.c("Need to reconnect");
        if (!this.i.isEmpty()) {
          k();
        }
      }
    }
  }
  
  private void i()
  {
    this.d.c();
    this.n = false;
  }
  
  private void j()
  {
    try
    {
      gx localgx1 = this.b;
      gx localgx2 = gx.c;
      if (localgx1 == localgx2) {}
      for (;;)
      {
        return;
        if ((this.h == null) || (!"com.google.android.gms".equals(this.h.getPackageName()))) {
          break;
        }
        this.b = gx.d;
        this.c.c();
        fA.d("Attempted to fall back to local store from service.");
      }
      g();
    }
    finally {}
    fA.c("falling back to local store");
    if (this.e != null) {}
    gr localgr;
    for (this.d = this.e;; this.d = localgr.d())
    {
      this.b = gx.c;
      h();
      break;
      localgr = gr.c();
      localgr.a(this.h, this.g);
    }
  }
  
  private void k()
  {
    for (;;)
    {
      try
      {
        if ((!this.q) && (this.c != null))
        {
          gx localgx1 = this.b;
          gx localgx2 = gx.c;
          if (localgx1 != localgx2) {
            try
            {
              this.j = (1 + this.j);
              a(this.l);
              this.b = gx.a;
              this.l = new Timer("Failed Connect");
              this.l.schedule(new gz(this, null), 3000L);
              fA.c("connecting to Analytics service");
              this.c.b();
              return;
            }
            catch (SecurityException localSecurityException)
            {
              fA.d("security exception on connectToService");
              j();
              continue;
            }
          }
        }
        fA.d("client not initialized.");
      }
      finally {}
      j();
    }
  }
  
  private void l()
  {
    try
    {
      if ((this.c != null) && (this.b == gx.b))
      {
        this.b = gx.f;
        this.c.c();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void m()
  {
    this.k = a(this.k);
    this.k = new Timer("Service Reconnect");
    this.k.schedule(new gB(this, null), 5000L);
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.q;
        if (bool) {
          return;
        }
        fA.c("setForceLocalDispatch called.");
        this.q = true;
        switch (gw.a[this.b.ordinal()])
        {
        case 1: 
        case 2: 
          l();
          break;
        case 3: 
          this.p = true;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public void a(int paramInt, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic 318	gx:e	Lgx;
    //   6: putfield 87	gu:b	Lgx;
    //   9: aload_0
    //   10: getfield 81	gu:j	I
    //   13: iconst_2
    //   14: if_icmpge +39 -> 53
    //   17: new 167	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 320
    //   27: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_1
    //   31: invokevirtual 323	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: ldc_w 325
    //   37: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 258	fA:d	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: invokespecial 327	gu:m	()V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: new 167	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 320
    //   63: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload_1
    //   67: invokevirtual 323	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc_w 329
    //   73: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 258	fA:d	(Ljava/lang/String;)V
    //   82: aload_0
    //   83: invokespecial 99	gu:j	()V
    //   86: goto -36 -> 50
    //   89: astore_3
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_3
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	gu
    //   0	94	1	paramInt	int
    //   0	94	2	paramIntent	android.content.Intent
    //   89	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	50	89	finally
    //   53	86	89	finally
  }
  
  public void a(Map<String, String> paramMap, long paramLong, String paramString, List<ha> paramList)
  {
    fA.c("putHit called");
    this.i.add(new gA(paramMap, paramLong, paramString, paramList));
    h();
  }
  
  public void b()
  {
    switch (gw.a[this.b.ordinal()])
    {
    default: 
      this.n = true;
    }
    for (;;)
    {
      return;
      i();
    }
  }
  
  public void c()
  {
    if (this.c != null) {}
    for (;;)
    {
      return;
      this.c = new fL(this.h, this, this);
      k();
    }
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: aload_0
    //   5: getfield 111	gu:l	Ljava/util/Timer;
    //   8: invokespecial 109	gu:a	(Ljava/util/Timer;)Ljava/util/Timer;
    //   11: putfield 111	gu:l	Ljava/util/Timer;
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 81	gu:j	I
    //   19: ldc_w 341
    //   22: invokestatic 186	fA:c	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getstatic 302	gx:b	Lgx;
    //   29: putfield 87	gu:b	Lgx;
    //   32: aload_0
    //   33: getfield 315	gu:p	Z
    //   36: ifeq +15 -> 51
    //   39: aload_0
    //   40: invokespecial 238	gu:l	()V
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 315	gu:p	Z
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: invokespecial 96	gu:h	()V
    //   55: aload_0
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 113	gu:m	Ljava/util/Timer;
    //   61: invokespecial 109	gu:a	(Ljava/util/Timer;)Ljava/util/Timer;
    //   64: putfield 113	gu:m	Ljava/util/Timer;
    //   67: aload_0
    //   68: new 90	java/util/Timer
    //   71: dup
    //   72: ldc_w 343
    //   75: invokespecial 282	java/util/Timer:<init>	(Ljava/lang/String;)V
    //   78: putfield 113	gu:m	Ljava/util/Timer;
    //   81: aload_0
    //   82: getfield 113	gu:m	Ljava/util/Timer;
    //   85: new 345	gy
    //   88: dup
    //   89: aload_0
    //   90: aconst_null
    //   91: invokespecial 346	gy:<init>	(Lgu;Lgv;)V
    //   94: aload_0
    //   95: getfield 64	gu:s	J
    //   98: invokevirtual 293	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   101: goto -53 -> 48
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	gu
    //   104	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	48	104	finally
    //   51	101	104	finally
  }
  
  public void e()
  {
    for (;;)
    {
      try
      {
        if (this.b == gx.d)
        {
          fA.c("Service blocked.");
          g();
          return;
        }
        if (this.b == gx.f)
        {
          fA.c("Disconnected from service");
          g();
          this.b = gx.g;
          continue;
        }
        fA.c("Unexpected disconnect.");
      }
      finally {}
      this.b = gx.e;
      if (this.j < 2) {
        m();
      } else {
        j();
      }
    }
  }
  
  public void f()
  {
    fA.c("clearHits called");
    this.i.clear();
    switch (gw.a[this.b.ordinal()])
    {
    default: 
      this.o = true;
    }
    for (;;)
    {
      return;
      this.d.a(0L);
      this.o = false;
      continue;
      this.c.a();
      this.o = false;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gu
 * JD-Core Version:    0.7.0.1
 */