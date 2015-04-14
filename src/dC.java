public final class dC
  extends sl
  implements dF
{
  public static sI<dC> a = new dD();
  private static final dC c;
  private static volatile sH j = null;
  private final rZ d;
  private int e;
  private int f;
  private int g;
  private byte h = -1;
  private int i = -1;
  
  static
  {
    c = new dC(true);
    c.l();
  }
  
  /* Error */
  private dC(sc paramsc, sg paramsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 47	sl:<init>	()V
    //   4: aload_0
    //   5: bipush 255
    //   7: putfield 49	dC:h	B
    //   10: aload_0
    //   11: bipush 255
    //   13: putfield 51	dC:i	I
    //   16: aload_0
    //   17: invokespecial 41	dC:l	()V
    //   20: invokestatic 56	rZ:i	()Lsb;
    //   23: astore_3
    //   24: aload_3
    //   25: invokestatic 61	se:a	(Ljava/io/OutputStream;)Lse;
    //   28: astore 4
    //   30: iconst_0
    //   31: istore 5
    //   33: iload 5
    //   35: ifne +156 -> 191
    //   38: aload_1
    //   39: invokevirtual 66	sc:a	()I
    //   42: istore 13
    //   44: iload 13
    //   46: lookupswitch	default:+34->80, 0:+215->261, 8:+53->99, 16:+105->151
    //   81: aload_1
    //   82: aload 4
    //   84: aload_2
    //   85: iload 13
    //   87: invokevirtual 69	dC:a	(Lsc;Lse;Lsg;I)Z
    //   90: ifne -57 -> 33
    //   93: iconst_1
    //   94: istore 5
    //   96: goto -63 -> 33
    //   99: aload_0
    //   100: iconst_1
    //   101: aload_0
    //   102: getfield 71	dC:e	I
    //   105: ior
    //   106: putfield 71	dC:e	I
    //   109: aload_0
    //   110: aload_1
    //   111: invokevirtual 73	sc:f	()I
    //   114: putfield 75	dC:f	I
    //   117: goto -84 -> 33
    //   120: astore 12
    //   122: aload 12
    //   124: aload_0
    //   125: invokevirtual 78	sx:a	(LsE;)Lsx;
    //   128: athrow
    //   129: astore 9
    //   131: aload 4
    //   133: invokevirtual 80	se:a	()V
    //   136: aload_0
    //   137: aload_3
    //   138: invokevirtual 85	sb:a	()LrZ;
    //   141: putfield 87	dC:d	LrZ;
    //   144: aload_0
    //   145: invokevirtual 90	dC:R	()V
    //   148: aload 9
    //   150: athrow
    //   151: aload_0
    //   152: iconst_2
    //   153: aload_0
    //   154: getfield 71	dC:e	I
    //   157: ior
    //   158: putfield 71	dC:e	I
    //   161: aload_0
    //   162: aload_1
    //   163: invokevirtual 73	sc:f	()I
    //   166: putfield 92	dC:g	I
    //   169: goto -136 -> 33
    //   172: astore 8
    //   174: new 44	sx
    //   177: dup
    //   178: aload 8
    //   180: invokevirtual 96	java/io/IOException:getMessage	()Ljava/lang/String;
    //   183: invokespecial 99	sx:<init>	(Ljava/lang/String;)V
    //   186: aload_0
    //   187: invokevirtual 78	sx:a	(LsE;)Lsx;
    //   190: athrow
    //   191: aload 4
    //   193: invokevirtual 80	se:a	()V
    //   196: aload_0
    //   197: aload_3
    //   198: invokevirtual 85	sb:a	()LrZ;
    //   201: putfield 87	dC:d	LrZ;
    //   204: aload_0
    //   205: invokevirtual 90	dC:R	()V
    //   208: return
    //   209: astore 7
    //   211: aload_0
    //   212: aload_3
    //   213: invokevirtual 85	sb:a	()LrZ;
    //   216: putfield 87	dC:d	LrZ;
    //   219: goto -15 -> 204
    //   222: astore 6
    //   224: aload_0
    //   225: aload_3
    //   226: invokevirtual 85	sb:a	()LrZ;
    //   229: putfield 87	dC:d	LrZ;
    //   232: aload 6
    //   234: athrow
    //   235: astore 11
    //   237: aload_0
    //   238: aload_3
    //   239: invokevirtual 85	sb:a	()LrZ;
    //   242: putfield 87	dC:d	LrZ;
    //   245: goto -101 -> 144
    //   248: astore 10
    //   250: aload_0
    //   251: aload_3
    //   252: invokevirtual 85	sb:a	()LrZ;
    //   255: putfield 87	dC:d	LrZ;
    //   258: aload 10
    //   260: athrow
    //   261: iconst_1
    //   262: istore 5
    //   264: goto -231 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	dC
    //   0	267	1	paramsc	sc
    //   0	267	2	paramsg	sg
    //   23	229	3	localsb	sb
    //   28	164	4	localse	se
    //   31	232	5	k	int
    //   222	11	6	localObject1	Object
    //   209	1	7	localIOException1	java.io.IOException
    //   172	7	8	localIOException2	java.io.IOException
    //   129	20	9	localObject2	Object
    //   248	11	10	localObject3	Object
    //   235	1	11	localIOException3	java.io.IOException
    //   120	3	12	localsx	sx
    //   42	44	13	m	int
    // Exception table:
    //   from	to	target	type
    //   38	117	120	sx
    //   151	169	120	sx
    //   38	117	129	finally
    //   122	129	129	finally
    //   151	169	129	finally
    //   174	191	129	finally
    //   38	117	172	java/io/IOException
    //   151	169	172	java/io/IOException
    //   191	196	209	java/io/IOException
    //   191	196	222	finally
    //   131	136	235	java/io/IOException
    //   131	136	248	finally
  }
  
  private dC(sn paramsn)
  {
    super(paramsn);
    this.d = paramsn.r();
  }
  
  private dC(boolean paramBoolean)
  {
    this.d = rZ.a;
  }
  
  public static dC a()
  {
    return c;
  }
  
  public static dE a(dC paramdC)
  {
    return h().a(paramdC);
  }
  
  public static dE h()
  {
    return dE.l();
  }
  
  private void l()
  {
    this.f = 0;
    this.g = 0;
  }
  
  public dC b()
  {
    return c;
  }
  
  public sI<dC> c()
  {
    return a;
  }
  
  public boolean d()
  {
    int k = 1;
    if ((0x1 & this.e) == k) {}
    for (;;)
    {
      return k;
      int m = 0;
    }
  }
  
  public int e()
  {
    return this.f;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    if (paramObject == this) {}
    for (;;)
    {
      return bool1;
      if (!(paramObject instanceof dC))
      {
        bool1 = super.equals(paramObject);
      }
      else
      {
        dC localdC = (dC)paramObject;
        boolean bool2;
        if (d() == localdC.d())
        {
          bool2 = bool1;
          label44:
          if (d())
          {
            if ((!bool2) || (e() != localdC.e())) {
              break label123;
            }
            bool2 = bool1;
          }
          label70:
          if ((!bool2) || (f() != localdC.f())) {
            break label129;
          }
        }
        label129:
        for (boolean bool3 = bool1;; bool3 = false)
        {
          if (!f()) {
            break label135;
          }
          if ((bool3) && (g() == localdC.g())) {
            break;
          }
          bool1 = false;
          break;
          bool2 = false;
          break label44;
          label123:
          bool2 = false;
          break label70;
        }
        label135:
        bool1 = bool3;
      }
    }
  }
  
  public boolean f()
  {
    if ((0x2 & this.e) == 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int g()
  {
    return this.g;
  }
  
  public int hashCode()
  {
    int m;
    if (this.b != 0) {
      m = this.b;
    }
    for (;;)
    {
      return m;
      int k = 779 + dC.class.hashCode();
      if (d()) {
        k = 53 * (1 + k * 37) + e();
      }
      if (f()) {
        k = 53 * (2 + k * 37) + g();
      }
      m = k * 29 + this.d.hashCode();
      this.b = m;
    }
  }
  
  public dE i()
  {
    return h();
  }
  
  public final boolean j()
  {
    int k = 1;
    int m = this.h;
    if (m != -1) {
      if (m != k) {}
    }
    for (;;)
    {
      return k;
      k = 0;
      continue;
      if (!d())
      {
        this.h = 0;
        k = 0;
      }
      else if (!f())
      {
        this.h = 0;
        k = 0;
      }
      else
      {
        this.h = k;
      }
    }
  }
  
  public dE k()
  {
    return a(this);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     dC
 * JD-Core Version:    0.7.0.1
 */