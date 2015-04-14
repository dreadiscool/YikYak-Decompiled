import android.content.Context;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ew
  implements eZ, eb, ec
{
  private volatile long a;
  private volatile eA b;
  private volatile dY c;
  private ed d;
  private ed e;
  private final eL f;
  private final ef g;
  private final Context h;
  private final Queue<eD> i = new ConcurrentLinkedQueue();
  private volatile int j;
  private volatile Timer k;
  private volatile Timer l;
  private volatile Timer m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private ej r;
  private long s = 300000L;
  
  ew(Context paramContext, ef paramef)
  {
    this(paramContext, paramef, null, eL.a(paramContext));
  }
  
  @VisibleForTesting
  ew(Context paramContext, ef paramef, ed paramed, eL parameL)
  {
    this.e = paramed;
    this.h = paramContext;
    this.g = paramef;
    this.f = parameL;
    this.r = new ex(this);
    this.j = 0;
    this.b = eA.g;
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
          this.g.c().add(new ey(this));
          return;
        }
        if (this.o) {
          d();
        }
        switch (ez.a[this.b.ordinal()])
        {
        case 1: 
          if (!this.i.isEmpty())
          {
            eD localeD2 = (eD)this.i.poll();
            eO.c("Sending hit to store  " + localeD2);
            this.d.a(localeD2.a(), localeD2.b(), localeD2.c(), localeD2.d());
            continue;
          }
          if (!this.n) {
            continue;
          }
        }
      }
      finally {}
      i();
      continue;
      if (!this.i.isEmpty())
      {
        eD localeD1 = (eD)this.i.peek();
        eO.c("Sending hit to service   " + localeD1);
        if (!this.f.b()) {
          this.c.a(localeD1.a(), localeD1.b(), localeD1.c(), localeD1.d());
        }
        for (;;)
        {
          this.i.poll();
          break;
          eO.c("Dry run enabled. Hit not actually sent to service.");
        }
      }
      this.a = this.r.a();
      continue;
      eO.c("Need to reconnect");
      if (!this.i.isEmpty()) {
        k();
      }
    }
  }
  
  private void i()
  {
    this.d.a();
    this.n = false;
  }
  
  private void j()
  {
    for (;;)
    {
      try
      {
        eA localeA1 = this.b;
        eA localeA2 = eA.c;
        if (localeA1 == localeA2) {
          return;
        }
        g();
        eO.c("falling back to local store");
        if (this.e != null)
        {
          this.d = this.e;
          this.b = eA.c;
          h();
          continue;
        }
        localet = et.a();
      }
      finally {}
      et localet;
      localet.a(this.h, this.g);
      this.d = localet.b();
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
          eA localeA1 = this.b;
          eA localeA2 = eA.c;
          if (localeA1 != localeA2) {
            try
            {
              this.j = (1 + this.j);
              a(this.l);
              this.b = eA.a;
              this.l = new Timer("Failed Connect");
              this.l.schedule(new eC(this, null), 3000L);
              eO.c("connecting to Analytics service");
              this.c.b();
              return;
            }
            catch (SecurityException localSecurityException)
            {
              eO.d("security exception on connectToService");
              j();
              continue;
            }
          }
        }
        eO.d("client not initialized.");
      }
      finally {}
      j();
    }
  }
  
  private void l()
  {
    try
    {
      if ((this.c != null) && (this.b == eA.b))
      {
        this.b = eA.f;
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
    this.k.schedule(new eE(this, null), 5000L);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: aload_0
    //   5: getfield 111	ew:l	Ljava/util/Timer;
    //   8: invokespecial 109	ew:a	(Ljava/util/Timer;)Ljava/util/Timer;
    //   11: putfield 111	ew:l	Ljava/util/Timer;
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 82	ew:j	I
    //   19: ldc_w 295
    //   22: invokestatic 185	eO:c	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getstatic 282	eA:b	LeA;
    //   29: putfield 88	ew:b	LeA;
    //   32: aload_0
    //   33: getfield 297	ew:p	Z
    //   36: ifeq +15 -> 51
    //   39: aload_0
    //   40: invokespecial 233	ew:l	()V
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 297	ew:p	Z
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: invokespecial 96	ew:h	()V
    //   55: aload_0
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 113	ew:m	Ljava/util/Timer;
    //   61: invokespecial 109	ew:a	(Ljava/util/Timer;)Ljava/util/Timer;
    //   64: putfield 113	ew:m	Ljava/util/Timer;
    //   67: aload_0
    //   68: new 91	java/util/Timer
    //   71: dup
    //   72: ldc_w 299
    //   75: invokespecial 260	java/util/Timer:<init>	(Ljava/lang/String;)V
    //   78: putfield 113	ew:m	Ljava/util/Timer;
    //   81: aload_0
    //   82: getfield 113	ew:m	Ljava/util/Timer;
    //   85: new 301	eB
    //   88: dup
    //   89: aload_0
    //   90: aconst_null
    //   91: invokespecial 302	eB:<init>	(Lew;Lex;)V
    //   94: aload_0
    //   95: getfield 65	ew:s	J
    //   98: invokevirtual 271	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   101: goto -53 -> 48
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	ew
    //   104	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	48	104	finally
    //   51	101	104	finally
  }
  
  /* Error */
  public void a(int paramInt, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic 305	eA:e	LeA;
    //   6: putfield 88	ew:b	LeA;
    //   9: aload_0
    //   10: getfield 82	ew:j	I
    //   13: iconst_2
    //   14: if_icmpge +39 -> 53
    //   17: new 166	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 307
    //   27: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_1
    //   31: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: ldc_w 312
    //   37: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 279	eO:d	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: invokespecial 314	ew:m	()V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: new 166	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 307
    //   63: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload_1
    //   67: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc_w 316
    //   73: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 279	eO:d	(Ljava/lang/String;)V
    //   82: aload_0
    //   83: invokespecial 99	ew:j	()V
    //   86: goto -36 -> 50
    //   89: astore_3
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_3
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	ew
    //   0	94	1	paramInt	int
    //   0	94	2	paramIntent	android.content.Intent
    //   89	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	50	89	finally
    //   53	86	89	finally
  }
  
  public void a(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList)
  {
    eO.c("putHit called");
    this.i.add(new eD(paramMap, paramLong, paramString, paramList));
    h();
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        if (this.b == eA.f)
        {
          eO.c("Disconnected from service");
          g();
          this.b = eA.g;
          return;
        }
        eO.c("Unexpected disconnect.");
        this.b = eA.e;
        if (this.j < 2) {
          m();
        } else {
          j();
        }
      }
      finally {}
    }
  }
  
  public void c()
  {
    switch (ez.a[this.b.ordinal()])
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
  
  public void d()
  {
    eO.c("clearHits called");
    this.i.clear();
    switch (ez.a[this.b.ordinal()])
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
  
  public void e()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.q;
        if (bool) {
          return;
        }
        eO.c("setForceLocalDispatch called.");
        this.q = true;
        switch (ez.a[this.b.ordinal()])
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
  
  public void f()
  {
    if (this.c != null) {}
    for (;;)
    {
      return;
      this.c = new dZ(this.h, this, this);
      k();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ew
 * JD-Core Version:    0.7.0.1
 */