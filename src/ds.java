public final class ds
  extends sl
  implements dx
{
  public static sI<ds> a = new dt();
  private static final ds c;
  private static volatile sH k = null;
  private final rZ d;
  private int e;
  private dv f;
  private int g;
  private int h;
  private byte i = -1;
  private int j = -1;
  
  static
  {
    c = new ds(true);
    c.q();
  }
  
  /* Error */
  private ds(sc paramsc, sg paramsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 49	sl:<init>	()V
    //   4: aload_0
    //   5: bipush 255
    //   7: putfield 51	ds:i	B
    //   10: aload_0
    //   11: bipush 255
    //   13: putfield 53	ds:j	I
    //   16: aload_0
    //   17: invokespecial 43	ds:q	()V
    //   20: invokestatic 58	rZ:i	()Lsb;
    //   23: astore_3
    //   24: aload_3
    //   25: invokestatic 63	se:a	(Ljava/io/OutputStream;)Lse;
    //   28: astore 4
    //   30: iconst_0
    //   31: istore 5
    //   33: iload 5
    //   35: ifne +218 -> 253
    //   38: aload_1
    //   39: invokevirtual 68	sc:a	()I
    //   42: istore 13
    //   44: iload 13
    //   46: lookupswitch	default:+42->88, 0:+277->323, 8:+61->107, 16:+165->211, 24:+186->232
    //   89: aload_1
    //   90: aload 4
    //   92: aload_2
    //   93: iload 13
    //   95: invokevirtual 71	ds:a	(Lsc;Lse;Lsg;I)Z
    //   98: ifne -65 -> 33
    //   101: iconst_1
    //   102: istore 5
    //   104: goto -71 -> 33
    //   107: aload_1
    //   108: invokevirtual 74	sc:n	()I
    //   111: istore 14
    //   113: iload 14
    //   115: invokestatic 79	dv:a	(I)Ldv;
    //   118: astore 15
    //   120: aload 15
    //   122: ifnonnull +51 -> 173
    //   125: aload 4
    //   127: iload 13
    //   129: invokevirtual 82	se:d	(I)V
    //   132: aload 4
    //   134: iload 14
    //   136: invokevirtual 82	se:d	(I)V
    //   139: goto -106 -> 33
    //   142: astore 12
    //   144: aload 12
    //   146: aload_0
    //   147: invokevirtual 85	sx:a	(LsE;)Lsx;
    //   150: athrow
    //   151: astore 9
    //   153: aload 4
    //   155: invokevirtual 87	se:a	()V
    //   158: aload_0
    //   159: aload_3
    //   160: invokevirtual 92	sb:a	()LrZ;
    //   163: putfield 94	ds:d	LrZ;
    //   166: aload_0
    //   167: invokevirtual 97	ds:R	()V
    //   170: aload 9
    //   172: athrow
    //   173: aload_0
    //   174: iconst_1
    //   175: aload_0
    //   176: getfield 99	ds:e	I
    //   179: ior
    //   180: putfield 99	ds:e	I
    //   183: aload_0
    //   184: aload 15
    //   186: putfield 101	ds:f	Ldv;
    //   189: goto -156 -> 33
    //   192: astore 8
    //   194: new 46	sx
    //   197: dup
    //   198: aload 8
    //   200: invokevirtual 105	java/io/IOException:getMessage	()Ljava/lang/String;
    //   203: invokespecial 108	sx:<init>	(Ljava/lang/String;)V
    //   206: aload_0
    //   207: invokevirtual 85	sx:a	(LsE;)Lsx;
    //   210: athrow
    //   211: aload_0
    //   212: iconst_2
    //   213: aload_0
    //   214: getfield 99	ds:e	I
    //   217: ior
    //   218: putfield 99	ds:e	I
    //   221: aload_0
    //   222: aload_1
    //   223: invokevirtual 110	sc:f	()I
    //   226: putfield 112	ds:g	I
    //   229: goto -196 -> 33
    //   232: aload_0
    //   233: iconst_4
    //   234: aload_0
    //   235: getfield 99	ds:e	I
    //   238: ior
    //   239: putfield 99	ds:e	I
    //   242: aload_0
    //   243: aload_1
    //   244: invokevirtual 110	sc:f	()I
    //   247: putfield 114	ds:h	I
    //   250: goto -217 -> 33
    //   253: aload 4
    //   255: invokevirtual 87	se:a	()V
    //   258: aload_0
    //   259: aload_3
    //   260: invokevirtual 92	sb:a	()LrZ;
    //   263: putfield 94	ds:d	LrZ;
    //   266: aload_0
    //   267: invokevirtual 97	ds:R	()V
    //   270: return
    //   271: astore 7
    //   273: aload_0
    //   274: aload_3
    //   275: invokevirtual 92	sb:a	()LrZ;
    //   278: putfield 94	ds:d	LrZ;
    //   281: goto -15 -> 266
    //   284: astore 6
    //   286: aload_0
    //   287: aload_3
    //   288: invokevirtual 92	sb:a	()LrZ;
    //   291: putfield 94	ds:d	LrZ;
    //   294: aload 6
    //   296: athrow
    //   297: astore 11
    //   299: aload_0
    //   300: aload_3
    //   301: invokevirtual 92	sb:a	()LrZ;
    //   304: putfield 94	ds:d	LrZ;
    //   307: goto -141 -> 166
    //   310: astore 10
    //   312: aload_0
    //   313: aload_3
    //   314: invokevirtual 92	sb:a	()LrZ;
    //   317: putfield 94	ds:d	LrZ;
    //   320: aload 10
    //   322: athrow
    //   323: iconst_1
    //   324: istore 5
    //   326: goto -293 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	ds
    //   0	329	1	paramsc	sc
    //   0	329	2	paramsg	sg
    //   23	291	3	localsb	sb
    //   28	226	4	localse	se
    //   31	294	5	m	int
    //   284	11	6	localObject1	Object
    //   271	1	7	localIOException1	java.io.IOException
    //   192	7	8	localIOException2	java.io.IOException
    //   151	20	9	localObject2	Object
    //   310	11	10	localObject3	Object
    //   297	1	11	localIOException3	java.io.IOException
    //   142	3	12	localsx	sx
    //   42	86	13	n	int
    //   111	24	14	i1	int
    //   118	67	15	localdv	dv
    // Exception table:
    //   from	to	target	type
    //   38	139	142	sx
    //   173	189	142	sx
    //   211	250	142	sx
    //   38	139	151	finally
    //   144	151	151	finally
    //   173	189	151	finally
    //   194	211	151	finally
    //   211	250	151	finally
    //   38	139	192	java/io/IOException
    //   173	189	192	java/io/IOException
    //   211	250	192	java/io/IOException
    //   253	258	271	java/io/IOException
    //   253	258	284	finally
    //   153	158	297	java/io/IOException
    //   153	158	310	finally
  }
  
  private ds(sn paramsn)
  {
    super(paramsn);
    this.d = paramsn.r();
  }
  
  private ds(boolean paramBoolean)
  {
    this.d = rZ.a;
  }
  
  public static ds a()
  {
    return c;
  }
  
  public static du a(ds paramds)
  {
    return k().a(paramds);
  }
  
  public static du k()
  {
    return du.i();
  }
  
  private void q()
  {
    this.f = dv.a;
    this.g = 0;
    this.h = 0;
  }
  
  public ds b()
  {
    return c;
  }
  
  public sI<ds> c()
  {
    return a;
  }
  
  public boolean d()
  {
    int m = 1;
    if ((0x1 & this.e) == m) {}
    for (;;)
    {
      return m;
      int n = 0;
    }
  }
  
  public dv e()
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
      if (!(paramObject instanceof ds))
      {
        bool1 = super.equals(paramObject);
      }
      else
      {
        ds localds = (ds)paramObject;
        boolean bool2;
        label44:
        label70:
        boolean bool3;
        if (d() == localds.d())
        {
          bool2 = bool1;
          if (d())
          {
            if ((!bool2) || (e() != localds.e())) {
              break label168;
            }
            bool2 = bool1;
          }
          if ((!bool2) || (f() != localds.f())) {
            break label174;
          }
          bool3 = bool1;
          label89:
          if (f())
          {
            if ((!bool3) || (g() != localds.g())) {
              break label180;
            }
            bool3 = bool1;
          }
          label115:
          if ((!bool3) || (h() != localds.h())) {
            break label186;
          }
        }
        label168:
        label174:
        label180:
        label186:
        for (boolean bool4 = bool1;; bool4 = false)
        {
          if (!h()) {
            break label192;
          }
          if ((bool4) && (i() == localds.i())) {
            break;
          }
          bool1 = false;
          break;
          bool2 = false;
          break label44;
          bool2 = false;
          break label70;
          bool3 = false;
          break label89;
          bool3 = false;
          break label115;
        }
        label192:
        bool1 = bool4;
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
  
  public boolean h()
  {
    if ((0x4 & this.e) == 4) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    int n;
    if (this.b != 0) {
      n = this.b;
    }
    for (;;)
    {
      return n;
      int m = 779 + ds.class.hashCode();
      if (d()) {
        m = 53 * (1 + m * 37) + su.a(e());
      }
      if (f()) {
        m = 53 * (2 + m * 37) + g();
      }
      if (h()) {
        m = 53 * (3 + m * 37) + i();
      }
      n = m * 29 + this.d.hashCode();
      this.b = n;
    }
  }
  
  public int i()
  {
    return this.h;
  }
  
  public final boolean j()
  {
    int m = 1;
    int n = this.i;
    if (n != -1) {
      if (n != m) {}
    }
    for (;;)
    {
      return m;
      m = 0;
      continue;
      this.i = m;
    }
  }
  
  public du l()
  {
    return k();
  }
  
  public du m()
  {
    return a(this);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ds
 * JD-Core Version:    0.7.0.1
 */