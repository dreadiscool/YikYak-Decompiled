import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Br
  implements Closeable
{
  private static final ExecutorService l;
  final zy a;
  final boolean b;
  long c = 0L;
  long d;
  final Bn e = new Bn();
  final Bn f = new Bn();
  final BI g;
  final Socket h;
  final AS i;
  final BA j;
  private final Bf m;
  private final Map<Integer, BD> n = new HashMap();
  private final String o;
  private int p;
  private int q;
  private boolean r;
  private long s = System.nanoTime();
  private final ExecutorService t;
  private Map<Integer, Bk> u;
  private final Bl v;
  private int w;
  private boolean x = false;
  private final Set<Integer> y = new LinkedHashSet();
  
  static
  {
    if (!Br.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      k = bool;
      l = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Ae.a("OkHttp SpdyConnection", true));
      return;
    }
  }
  
  private Br(Bz paramBz)
  {
    this.a = Bz.a(paramBz);
    this.v = Bz.b(paramBz);
    this.b = Bz.c(paramBz);
    this.m = Bz.d(paramBz);
    int i2;
    if (Bz.c(paramBz))
    {
      i2 = 1;
      this.q = i2;
      if ((Bz.c(paramBz)) && (this.a == zy.d)) {
        this.q = (2 + this.q);
      }
      if (Bz.c(paramBz)) {
        i1 = 1;
      }
      this.w = i1;
      if (Bz.c(paramBz)) {
        this.e.a(7, 0, 16777216);
      }
      this.o = Bz.e(paramBz);
      if (this.a != zy.d) {
        break label370;
      }
      this.g = new AY();
      TimeUnit localTimeUnit = TimeUnit.SECONDS;
      LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.o;
      this.t = new ThreadPoolExecutor(0, 1, 60L, localTimeUnit, localLinkedBlockingQueue, Ae.a(String.format("OkHttp %s Push Observer", arrayOfObject), true));
      this.f.a(7, 0, 65535);
      this.f.a(5, 0, 16384);
    }
    for (;;)
    {
      this.d = this.f.e(65536);
      this.h = Bz.f(paramBz);
      this.i = this.g.a(LK.a(LK.a(Bz.f(paramBz))), this.b);
      this.j = new BA(this, null);
      new Thread(this.j).start();
      return;
      i2 = i1;
      break;
      label370:
      if (this.a != zy.c) {
        break label399;
      }
      this.g = new Bo();
      this.t = null;
    }
    label399:
    throw new AssertionError(this.a);
  }
  
  /* Error */
  private BD a(int paramInt, List<AT> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iload_3
    //   4: ifne +55 -> 59
    //   7: iload 5
    //   9: istore 6
    //   11: iload 4
    //   13: ifne +52 -> 65
    //   16: aload_0
    //   17: getfield 202	Br:i	LAS;
    //   20: astore 7
    //   22: aload 7
    //   24: monitorenter
    //   25: aload_0
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield 233	Br:r	Z
    //   31: ifeq +40 -> 71
    //   34: new 235	java/io/IOException
    //   37: dup
    //   38: ldc 237
    //   40: invokespecial 240	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   43: athrow
    //   44: astore 9
    //   46: aload_0
    //   47: monitorexit
    //   48: aload 9
    //   50: athrow
    //   51: astore 8
    //   53: aload 7
    //   55: monitorexit
    //   56: aload 8
    //   58: athrow
    //   59: iconst_0
    //   60: istore 6
    //   62: goto -51 -> 11
    //   65: iconst_0
    //   66: istore 5
    //   68: goto -52 -> 16
    //   71: aload_0
    //   72: getfield 142	Br:q	I
    //   75: istore 10
    //   77: aload_0
    //   78: iconst_2
    //   79: aload_0
    //   80: getfield 142	Br:q	I
    //   83: iadd
    //   84: putfield 142	Br:q	I
    //   87: new 242	BD
    //   90: dup
    //   91: iload 10
    //   93: aload_0
    //   94: iload 6
    //   96: iload 5
    //   98: aload_2
    //   99: invokespecial 245	BD:<init>	(ILBr;ZZLjava/util/List;)V
    //   102: astore 11
    //   104: aload 11
    //   106: invokevirtual 247	BD:b	()Z
    //   109: ifeq +25 -> 134
    //   112: aload_0
    //   113: getfield 94	Br:n	Ljava/util/Map;
    //   116: iload 10
    //   118: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: aload 11
    //   123: invokeinterface 259 3 0
    //   128: pop
    //   129: aload_0
    //   130: iconst_0
    //   131: invokespecial 262	Br:a	(Z)V
    //   134: aload_0
    //   135: monitorexit
    //   136: iload_1
    //   137: ifne +39 -> 176
    //   140: aload_0
    //   141: getfield 202	Br:i	LAS;
    //   144: iload 6
    //   146: iload 5
    //   148: iload 10
    //   150: iload_1
    //   151: aload_2
    //   152: invokeinterface 267 6 0
    //   157: aload 7
    //   159: monitorexit
    //   160: iload_3
    //   161: ifne +12 -> 173
    //   164: aload_0
    //   165: getfield 202	Br:i	LAS;
    //   168: invokeinterface 269 1 0
    //   173: aload 11
    //   175: areturn
    //   176: aload_0
    //   177: getfield 135	Br:b	Z
    //   180: ifeq +14 -> 194
    //   183: new 271	java/lang/IllegalArgumentException
    //   186: dup
    //   187: ldc_w 273
    //   190: invokespecial 274	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   193: athrow
    //   194: aload_0
    //   195: getfield 202	Br:i	LAS;
    //   198: iload_1
    //   199: iload 10
    //   201: aload_2
    //   202: invokeinterface 277 4 0
    //   207: goto -50 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	Br
    //   0	210	1	paramInt	int
    //   0	210	2	paramList	List<AT>
    //   0	210	3	paramBoolean1	boolean
    //   0	210	4	paramBoolean2	boolean
    //   1	146	5	bool1	boolean
    //   9	136	6	bool2	boolean
    //   20	138	7	localAS	AS
    //   51	6	8	localObject1	Object
    //   44	5	9	localObject2	Object
    //   75	125	10	i1	int
    //   102	72	11	localBD	BD
    // Exception table:
    //   from	to	target	type
    //   27	48	44	finally
    //   71	136	44	finally
    //   25	27	51	finally
    //   48	56	51	finally
    //   140	160	51	finally
    //   176	207	51	finally
  }
  
  private void a(int paramInt1, LD paramLD, int paramInt2, boolean paramBoolean)
  {
    Lz localLz = new Lz();
    paramLD.a(paramInt2);
    paramLD.a(localLz, paramInt2);
    if (localLz.c() != paramInt2) {
      throw new IOException(localLz.c() + " != " + paramInt2);
    }
    ExecutorService localExecutorService = this.t;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.o;
    arrayOfObject[1] = Integer.valueOf(paramInt1);
    localExecutorService.submit(new Bx(this, "OkHttp %s Push Data[%s]", arrayOfObject, paramInt1, localLz, paramInt2, paramBoolean));
  }
  
  private void a(int paramInt, List<AT> paramList)
  {
    try
    {
      if (this.y.contains(Integer.valueOf(paramInt)))
      {
        a(paramInt, AP.b);
      }
      else
      {
        this.y.add(Integer.valueOf(paramInt));
        ExecutorService localExecutorService = this.t;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = this.o;
        arrayOfObject[1] = Integer.valueOf(paramInt);
        localExecutorService.submit(new Bv(this, "OkHttp %s Push Request[%s]", arrayOfObject, paramInt, paramList));
      }
    }
    finally {}
  }
  
  private void a(int paramInt, List<AT> paramList, boolean paramBoolean)
  {
    ExecutorService localExecutorService = this.t;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.o;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    localExecutorService.submit(new Bw(this, "OkHttp %s Push Headers[%s]", arrayOfObject, paramInt, paramList, paramBoolean));
  }
  
  /* Error */
  private void a(AP paramAP1, AP paramAP2)
  {
    // Byte code:
    //   0: getstatic 59	Br:k	Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: invokestatic 361	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +11 -> 21
    //   13: new 224	java/lang/AssertionError
    //   16: dup
    //   17: invokespecial 362	java/lang/AssertionError:<init>	()V
    //   20: athrow
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 365	Br:a	(LAP;)V
    //   26: aconst_null
    //   27: astore 4
    //   29: aload_0
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield 94	Br:n	Ljava/util/Map;
    //   35: invokeinterface 368 1 0
    //   40: ifne +264 -> 304
    //   43: aload_0
    //   44: getfield 94	Br:n	Ljava/util/Map;
    //   47: invokeinterface 372 1 0
    //   52: aload_0
    //   53: getfield 94	Br:n	Ljava/util/Map;
    //   56: invokeinterface 376 1 0
    //   61: anewarray 242	BD
    //   64: invokeinterface 382 2 0
    //   69: checkcast 384	[LBD;
    //   72: astore 17
    //   74: aload_0
    //   75: getfield 94	Br:n	Ljava/util/Map;
    //   78: invokeinterface 387 1 0
    //   83: aload_0
    //   84: iconst_0
    //   85: invokespecial 262	Br:a	(Z)V
    //   88: aload 17
    //   90: astore 6
    //   92: aload_0
    //   93: getfield 389	Br:u	Ljava/util/Map;
    //   96: ifnull +202 -> 298
    //   99: aload_0
    //   100: getfield 389	Br:u	Ljava/util/Map;
    //   103: invokeinterface 372 1 0
    //   108: aload_0
    //   109: getfield 389	Br:u	Ljava/util/Map;
    //   112: invokeinterface 376 1 0
    //   117: anewarray 391	Bk
    //   120: invokeinterface 382 2 0
    //   125: checkcast 393	[LBk;
    //   128: astore 16
    //   130: aload_0
    //   131: aconst_null
    //   132: putfield 389	Br:u	Ljava/util/Map;
    //   135: aload 16
    //   137: astore 7
    //   139: aload_0
    //   140: monitorexit
    //   141: aload 6
    //   143: ifnull +73 -> 216
    //   146: aload 6
    //   148: arraylength
    //   149: istore 11
    //   151: iconst_0
    //   152: istore 12
    //   154: aload 4
    //   156: astore 13
    //   158: iload 12
    //   160: iload 11
    //   162: if_icmpge +50 -> 212
    //   165: aload 6
    //   167: iload 12
    //   169: aaload
    //   170: astore 14
    //   172: aload 14
    //   174: aload_2
    //   175: invokevirtual 394	BD:a	(LAP;)V
    //   178: iinc 12 1
    //   181: goto -23 -> 158
    //   184: astore_3
    //   185: aload_3
    //   186: astore 4
    //   188: goto -159 -> 29
    //   191: astore 5
    //   193: aload_0
    //   194: monitorexit
    //   195: aload 5
    //   197: athrow
    //   198: astore 15
    //   200: aload 13
    //   202: ifnull -24 -> 178
    //   205: aload 15
    //   207: astore 13
    //   209: goto -31 -> 178
    //   212: aload 13
    //   214: astore 4
    //   216: aload 7
    //   218: ifnull +32 -> 250
    //   221: aload 7
    //   223: arraylength
    //   224: istore 9
    //   226: iconst_0
    //   227: istore 10
    //   229: iload 10
    //   231: iload 9
    //   233: if_icmpge +17 -> 250
    //   236: aload 7
    //   238: iload 10
    //   240: aaload
    //   241: invokevirtual 396	Bk:c	()V
    //   244: iinc 10 1
    //   247: goto -18 -> 229
    //   250: aload_0
    //   251: getfield 202	Br:i	LAS;
    //   254: invokeinterface 399 1 0
    //   259: aload 4
    //   261: astore 8
    //   263: aload_0
    //   264: getfield 187	Br:h	Ljava/net/Socket;
    //   267: invokevirtual 402	java/net/Socket:close	()V
    //   270: aload 8
    //   272: ifnull +20 -> 292
    //   275: aload 8
    //   277: athrow
    //   278: astore 8
    //   280: aload 4
    //   282: ifnull -19 -> 263
    //   285: aload 4
    //   287: astore 8
    //   289: goto -26 -> 263
    //   292: return
    //   293: astore 8
    //   295: goto -25 -> 270
    //   298: aconst_null
    //   299: astore 7
    //   301: goto -162 -> 139
    //   304: aconst_null
    //   305: astore 6
    //   307: goto -215 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	Br
    //   0	310	1	paramAP1	AP
    //   0	310	2	paramAP2	AP
    //   184	2	3	localIOException1	IOException
    //   27	259	4	localObject1	Object
    //   191	5	5	localObject2	Object
    //   90	216	6	arrayOfBD1	BD[]
    //   137	163	7	arrayOfBk1	Bk[]
    //   261	15	8	localObject3	Object
    //   278	1	8	localIOException2	IOException
    //   287	1	8	localObject4	Object
    //   293	1	8	localIOException3	IOException
    //   224	10	9	i1	int
    //   227	18	10	i2	int
    //   149	14	11	i3	int
    //   152	27	12	i4	int
    //   156	57	13	localObject5	Object
    //   170	3	14	localBD	BD
    //   198	8	15	localIOException4	IOException
    //   128	8	16	arrayOfBk2	Bk[]
    //   72	17	17	arrayOfBD2	BD[]
    // Exception table:
    //   from	to	target	type
    //   21	26	184	java/io/IOException
    //   31	141	191	finally
    //   193	195	191	finally
    //   172	178	198	java/io/IOException
    //   250	259	278	java/io/IOException
    //   263	270	293	java/io/IOException
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        l1 = System.nanoTime();
        this.s = l1;
        return;
      }
      finally {}
      long l1 = 9223372036854775807L;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, Bk paramBk)
  {
    ExecutorService localExecutorService = l;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.o;
    arrayOfObject[1] = Integer.valueOf(paramInt1);
    arrayOfObject[2] = Integer.valueOf(paramInt2);
    localExecutorService.submit(new Bu(this, "OkHttp %s ping %08x%08x", arrayOfObject, paramBoolean, paramInt1, paramInt2, paramBk));
  }
  
  private void b(boolean paramBoolean, int paramInt1, int paramInt2, Bk paramBk)
  {
    AS localAS = this.i;
    if (paramBk != null) {}
    try
    {
      paramBk.a();
      this.i.a(paramBoolean, paramInt1, paramInt2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private Bk c(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 389	Br:u	Ljava/util/Map;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 389	Br:u	Ljava/util/Map;
    //   13: iload_1
    //   14: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokeinterface 452 2 0
    //   22: checkcast 391	Bk
    //   25: astore_3
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_3
    //   29: areturn
    //   30: aconst_null
    //   31: astore_3
    //   32: goto -6 -> 26
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	Br
    //   0	40	1	paramInt	int
    //   35	4	2	localObject	Object
    //   25	7	3	localBk	Bk
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  private void c(int paramInt, AP paramAP)
  {
    ExecutorService localExecutorService = this.t;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.o;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    localExecutorService.submit(new By(this, "OkHttp %s Push Reset[%s]", arrayOfObject, paramInt, paramAP));
  }
  
  private boolean d(int paramInt)
  {
    if ((this.a == zy.d) && (paramInt != 0) && ((paramInt & 0x1) == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  BD a(int paramInt)
  {
    try
    {
      BD localBD = (BD)this.n.get(Integer.valueOf(paramInt));
      return localBD;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BD a(List<AT> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(0, paramList, paramBoolean1, paramBoolean2);
  }
  
  public zy a()
  {
    return this.a;
  }
  
  void a(int paramInt, long paramLong)
  {
    ExecutorService localExecutorService = l;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.o;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    localExecutorService.submit(new Bt(this, "OkHttp Window Update %s stream %d", arrayOfObject, paramInt, paramLong));
  }
  
  void a(int paramInt, AP paramAP)
  {
    ExecutorService localExecutorService = l;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.o;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    localExecutorService.submit(new Bs(this, "OkHttp %s stream %d", arrayOfObject, paramInt, paramAP));
  }
  
  public void a(int paramInt, boolean paramBoolean, Lz paramLz, long paramLong)
  {
    if (paramLong == 0L)
    {
      this.i.a(paramBoolean, paramInt, paramLz, 0);
      return;
    }
    for (;;)
    {
      try
      {
        int i1 = Math.min((int)Math.min(paramLong, this.d), this.i.c());
        this.d -= i1;
        paramLong -= i1;
        AS localAS = this.i;
        if ((paramBoolean) && (paramLong == 0L))
        {
          bool = true;
          localAS.a(bool, paramInt, paramLz, i1);
          if (paramLong <= 0L) {
            break;
          }
          try
          {
            if (this.d > 0L) {
              continue;
            }
            wait();
            continue;
            localObject = finally;
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new InterruptedIOException();
          }
        }
        boolean bool = false;
      }
      finally {}
    }
  }
  
  void a(long paramLong)
  {
    this.d = (paramLong + this.d);
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public void a(AP paramAP)
  {
    synchronized (this.i) {}
    try
    {
      if (this.r) {}
      for (;;)
      {
        return;
        this.r = true;
        int i1 = this.p;
        this.i.a(i1, paramAP, Ae.a);
      }
      localObject1 = finally;
      throw localObject1;
    }
    finally {}
  }
  
  BD b(int paramInt)
  {
    try
    {
      BD localBD = (BD)this.n.remove(Integer.valueOf(paramInt));
      if ((localBD != null) && (this.n.isEmpty())) {
        a(true);
      }
      return localBD;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void b(int paramInt, AP paramAP)
  {
    this.i.a(paramInt, paramAP);
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 102	Br:s	J
    //   6: lstore_2
    //   7: lload_2
    //   8: ldc2_w 422
    //   11: lcmp
    //   12: ifeq +11 -> 23
    //   15: iconst_1
    //   16: istore 4
    //   18: aload_0
    //   19: monitorexit
    //   20: iload 4
    //   22: ireturn
    //   23: iconst_0
    //   24: istore 4
    //   26: goto -8 -> 18
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	Br
    //   29	4	1	localObject	Object
    //   6	2	2	l1	long
    //   16	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
  }
  
  public long c()
  {
    try
    {
      long l1 = this.s;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void close()
  {
    a(AP.a, AP.l);
  }
  
  public void d()
  {
    this.i.b();
  }
  
  public void e()
  {
    this.i.a();
    this.i.b(this.e);
    int i1 = this.e.e(65536);
    if (i1 != 65536) {
      this.i.a(0, i1 - 65536);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Br
 * JD-Core Version:    0.7.0.1
 */