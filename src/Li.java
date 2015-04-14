import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class Li
{
  private final AtomicReference<Lo> a = new AtomicReference();
  private final CountDownLatch b = new CountDownLatch(1);
  private Ln c;
  private boolean d = false;
  
  public static Li a()
  {
    return Lk.a();
  }
  
  private void a(Lo paramLo)
  {
    this.a.set(paramLo);
    this.b.countDown();
  }
  
  /* Error */
  public Li a(IM paramIM, Js paramJs, KK paramKK, java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	Li:d	Z
    //   6: istore 8
    //   8: iload 8
    //   10: ifeq +11 -> 21
    //   13: aload_0
    //   14: astore 9
    //   16: aload_0
    //   17: monitorexit
    //   18: aload 9
    //   20: areturn
    //   21: aload_0
    //   22: getfield 49	Li:c	LLn;
    //   25: ifnonnull +184 -> 209
    //   28: aload_1
    //   29: invokevirtual 55	IM:C	()Landroid/content/Context;
    //   32: astore 10
    //   34: aload_2
    //   35: invokevirtual 60	Js:c	()Ljava/lang/String;
    //   38: astore 11
    //   40: new 62	Je
    //   43: dup
    //   44: invokespecial 63	Je:<init>	()V
    //   47: aload 10
    //   49: invokevirtual 66	Je:a	(Landroid/content/Context;)Ljava/lang/String;
    //   52: astore 12
    //   54: aload_2
    //   55: invokevirtual 69	Js:h	()Ljava/lang/String;
    //   58: astore 13
    //   60: new 71	JC
    //   63: dup
    //   64: invokespecial 72	JC:<init>	()V
    //   67: astore 14
    //   69: new 74	Lc
    //   72: dup
    //   73: invokespecial 75	Lc:<init>	()V
    //   76: astore 15
    //   78: new 77	La
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 80	La:<init>	(LIM;)V
    //   86: astore 16
    //   88: aload 10
    //   90: invokestatic 85	Jg:k	(Landroid/content/Context;)Ljava/lang/String;
    //   93: astore 17
    //   95: getstatic 91	java/util/Locale:US	Ljava/util/Locale;
    //   98: astore 18
    //   100: iconst_1
    //   101: anewarray 4	java/lang/Object
    //   104: astore 19
    //   106: aload 19
    //   108: iconst_0
    //   109: aload 11
    //   111: aastore
    //   112: new 93	Ld
    //   115: dup
    //   116: aload_1
    //   117: aload 6
    //   119: aload 18
    //   121: ldc 95
    //   123: aload 19
    //   125: invokestatic 101	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   128: aload_3
    //   129: invokespecial 104	Ld:<init>	(LIM;Ljava/lang/String;Ljava/lang/String;LKK;)V
    //   132: astore 20
    //   134: aload_2
    //   135: aload 12
    //   137: aload 11
    //   139: invokevirtual 107	Js:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   142: astore 21
    //   144: iconst_1
    //   145: anewarray 97	java/lang/String
    //   148: astore 22
    //   150: aload 22
    //   152: iconst_0
    //   153: aload 10
    //   155: invokestatic 110	Jg:m	(Landroid/content/Context;)Ljava/lang/String;
    //   158: aastore
    //   159: aload_0
    //   160: new 112	Lb
    //   163: dup
    //   164: aload_1
    //   165: new 114	Lr
    //   168: dup
    //   169: aload 12
    //   171: aload 21
    //   173: aload 22
    //   175: invokestatic 117	Jg:a	([Ljava/lang/String;)Ljava/lang/String;
    //   178: aload 5
    //   180: aload 4
    //   182: aload 13
    //   184: invokestatic 122	Jm:a	(Ljava/lang/String;)LJm;
    //   187: invokevirtual 125	Jm:a	()I
    //   190: aload 17
    //   192: invokespecial 128	Lr:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   195: aload 14
    //   197: aload 15
    //   199: aload 16
    //   201: aload 20
    //   203: invokespecial 131	Lb:<init>	(LIM;LLr;LJl;LLq;LKY;LLs;)V
    //   206: putfield 49	Li:c	LLn;
    //   209: aload_0
    //   210: iconst_1
    //   211: putfield 31	Li:d	Z
    //   214: aload_0
    //   215: astore 9
    //   217: goto -201 -> 16
    //   220: astore 7
    //   222: aload_0
    //   223: monitorexit
    //   224: aload 7
    //   226: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	Li
    //   0	227	1	paramIM	IM
    //   0	227	2	paramJs	Js
    //   0	227	3	paramKK	KK
    //   0	227	4	paramString1	java.lang.String
    //   0	227	5	paramString2	java.lang.String
    //   0	227	6	paramString3	java.lang.String
    //   220	5	7	localObject	Object
    //   6	3	8	bool	boolean
    //   14	202	9	localLi	Li
    //   32	122	10	localContext	android.content.Context
    //   38	100	11	str1	java.lang.String
    //   52	118	12	str2	java.lang.String
    //   58	125	13	str3	java.lang.String
    //   67	129	14	localJC	JC
    //   76	122	15	localLc	Lc
    //   86	114	16	localLa	La
    //   93	98	17	str4	java.lang.String
    //   98	22	18	localLocale	java.util.Locale
    //   104	20	19	arrayOfObject	Object[]
    //   132	70	20	localLd	Ld
    //   142	30	21	str5	java.lang.String
    //   148	26	22	arrayOfString	java.lang.String[]
    // Exception table:
    //   from	to	target	type
    //   2	8	220	finally
    //   21	214	220	finally
  }
  
  public <T> T a(Ll<T> paramLl, T paramT)
  {
    Lo localLo = (Lo)this.a.get();
    if (localLo == null) {}
    for (;;)
    {
      return paramT;
      paramT = paramLl.b(localLo);
    }
  }
  
  public Lo b()
  {
    try
    {
      this.b.await();
      localLo = (Lo)this.a.get();
      return localLo;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        IC.g();
        Lo localLo = null;
      }
    }
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	Li:c	LLn;
    //   6: invokeinterface 160 1 0
    //   11: astore_2
    //   12: aload_0
    //   13: aload_2
    //   14: invokespecial 162	Li:a	(LLo;)V
    //   17: aload_2
    //   18: ifnull +9 -> 27
    //   21: iconst_1
    //   22: istore_3
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_3
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_3
    //   29: goto -6 -> 23
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	Li
    //   32	4	1	localObject	Object
    //   11	7	2	localLo	Lo
    //   22	7	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally
  }
  
  /* Error */
  public boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	Li:c	LLn;
    //   6: getstatic 167	Lm:b	LLm;
    //   9: invokeinterface 170 2 0
    //   14: astore_2
    //   15: aload_0
    //   16: aload_2
    //   17: invokespecial 162	Li:a	(LLo;)V
    //   20: aload_2
    //   21: ifnonnull +7 -> 28
    //   24: invokestatic 155	IC:g	()LIO;
    //   27: pop
    //   28: aload_2
    //   29: ifnull +9 -> 38
    //   32: iconst_1
    //   33: istore_3
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_3
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_3
    //   40: goto -6 -> 34
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	Li
    //   43	4	1	localObject	Object
    //   14	15	2	localLo	Lo
    //   33	7	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	28	43	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Li
 * JD-Core Version:    0.7.0.1
 */