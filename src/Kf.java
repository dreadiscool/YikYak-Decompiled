import android.content.Context;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Kf<T>
  implements Ks<T>
{
  protected final Context b;
  protected final ScheduledExecutorService c;
  protected final Kh<T> d;
  protected final AtomicReference<ScheduledFuture<?>> e;
  protected volatile int f = -1;
  
  public Kf(Context paramContext, ScheduledExecutorService paramScheduledExecutorService, Kh<T> paramKh)
  {
    this.b = paramContext;
    this.c = paramScheduledExecutorService;
    this.d = paramKh;
    this.e = new AtomicReference();
  }
  
  protected void a(int paramInt)
  {
    this.f = paramInt;
    a(0, this.f);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    try
    {
      Kx localKx = new Kx(this.b, this);
      Jg.a(this.b, "Scheduling time based file roll over every " + paramInt2 + " seconds");
      this.e.set(this.c.scheduleAtFixedRate(localKx, paramInt1, paramInt2, TimeUnit.SECONDS));
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      for (;;)
      {
        Jg.a(this.b, "Failed to schedule time based file roll over", localRejectedExecutionException);
      }
    }
  }
  
  public void a(T paramT)
  {
    Jg.a(this.b, paramT.toString());
    try
    {
      this.d.a(paramT);
      f();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Jg.a(this.b, "Failed to write event.", localIOException);
      }
    }
  }
  
  public void b()
  {
    g();
  }
  
  public void c()
  {
    this.d.f();
  }
  
  public void d()
  {
    if (this.e.get() != null)
    {
      Jg.a(this.b, "Cancelling time-based rollover because no events are currently being generated.");
      ((ScheduledFuture)this.e.get()).cancel(false);
      this.e.set(null);
    }
  }
  
  public boolean e()
  {
    try
    {
      boolean bool2 = this.d.d();
      bool1 = bool2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Jg.a(this.b, "Failed to roll file over.", localIOException);
        boolean bool1 = false;
      }
    }
    return bool1;
  }
  
  public void f()
  {
    int i = 1;
    int j;
    if (this.f != -1)
    {
      j = i;
      if (this.e.get() != null) {
        break label49;
      }
    }
    for (;;)
    {
      if ((j != 0) && (i != 0)) {
        a(this.f, this.f);
      }
      return;
      j = 0;
      break;
      label49:
      i = 0;
    }
  }
  
  /* Error */
  void g()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokevirtual 130	Kf:a	()LKu;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +13 -> 21
    //   11: aload_0
    //   12: getfield 28	Kf:b	Landroid/content/Context;
    //   15: ldc 132
    //   17: invokestatic 72	Jg:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   20: return
    //   21: aload_0
    //   22: getfield 28	Kf:b	Landroid/content/Context;
    //   25: ldc 134
    //   27: invokestatic 72	Jg:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 32	Kf:d	LKh;
    //   34: invokevirtual 137	Kh:e	()Ljava/util/List;
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 28	Kf:b	Landroid/content/Context;
    //   42: astore 6
    //   44: getstatic 143	java/util/Locale:US	Ljava/util/Locale;
    //   47: astore 7
    //   49: iconst_1
    //   50: anewarray 5	java/lang/Object
    //   53: astore 8
    //   55: aload 8
    //   57: iconst_0
    //   58: aload_3
    //   59: invokeinterface 149 1 0
    //   64: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: aload 6
    //   70: aload 7
    //   72: ldc 157
    //   74: aload 8
    //   76: invokestatic 163	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   79: invokestatic 72	Jg:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   82: aload_3
    //   83: astore 9
    //   85: iconst_0
    //   86: istore 5
    //   88: aload 9
    //   90: invokeinterface 149 1 0
    //   95: ifle +50 -> 145
    //   98: aload_2
    //   99: aload 9
    //   101: invokeinterface 168 2 0
    //   106: istore 11
    //   108: iload 11
    //   110: ifeq +30 -> 140
    //   113: aload 9
    //   115: invokeinterface 149 1 0
    //   120: istore 13
    //   122: iload 13
    //   124: iload 5
    //   126: iadd
    //   127: istore_1
    //   128: aload_0
    //   129: getfield 32	Kf:d	LKh;
    //   132: aload 9
    //   134: invokevirtual 171	Kh:a	(Ljava/util/List;)V
    //   137: iload_1
    //   138: istore 5
    //   140: iload 11
    //   142: ifne +18 -> 160
    //   145: iload 5
    //   147: ifne -127 -> 20
    //   150: aload_0
    //   151: getfield 32	Kf:d	LKh;
    //   154: invokevirtual 172	Kh:g	()V
    //   157: goto -137 -> 20
    //   160: aload_0
    //   161: getfield 32	Kf:d	LKh;
    //   164: invokevirtual 137	Kh:e	()Ljava/util/List;
    //   167: astore 12
    //   169: aload 12
    //   171: astore 9
    //   173: goto -85 -> 88
    //   176: astore 4
    //   178: aload_0
    //   179: getfield 28	Kf:b	Landroid/content/Context;
    //   182: new 51	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   189: ldc 174
    //   191: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 4
    //   196: invokevirtual 177	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   199: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: aload 4
    //   207: invokestatic 93	Jg:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   210: iload_1
    //   211: istore 5
    //   213: goto -68 -> 145
    //   216: astore 10
    //   218: iload 5
    //   220: istore_1
    //   221: aload 10
    //   223: astore 4
    //   225: goto -47 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	Kf
    //   1	220	1	i	int
    //   6	93	2	localKu	Ku
    //   37	46	3	localList1	java.util.List
    //   176	30	4	localException1	java.lang.Exception
    //   223	1	4	localObject1	Object
    //   86	133	5	j	int
    //   42	27	6	localContext	Context
    //   47	24	7	localLocale	java.util.Locale
    //   53	22	8	arrayOfObject	Object[]
    //   83	89	9	localObject2	Object
    //   216	6	10	localException2	java.lang.Exception
    //   106	35	11	bool	boolean
    //   167	3	12	localList2	java.util.List
    //   120	7	13	k	int
    // Exception table:
    //   from	to	target	type
    //   38	82	176	java/lang/Exception
    //   128	137	176	java/lang/Exception
    //   88	122	216	java/lang/Exception
    //   160	169	216	java/lang/Exception
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Kf
 * JD-Core Version:    0.7.0.1
 */