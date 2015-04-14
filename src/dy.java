import java.util.Collections;
import java.util.List;

public final class dy
  extends sl
  implements dB
{
  public static sI<dy> a = new dz();
  private static final dy c;
  private static volatile sH m = null;
  private final rZ d;
  private int e;
  private List<Integer> f;
  private int g;
  private int h;
  private boolean i;
  private boolean j;
  private byte k = -1;
  private int l = -1;
  
  static
  {
    c = new dy(true);
    c.u();
  }
  
  /* Error */
  private dy(sc paramsc, sg paramsg)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: invokespecial 53	sl:<init>	()V
    //   6: aload_0
    //   7: bipush 255
    //   9: putfield 55	dy:k	B
    //   12: aload_0
    //   13: bipush 255
    //   15: putfield 57	dy:l	I
    //   18: aload_0
    //   19: invokespecial 47	dy:u	()V
    //   22: invokestatic 62	rZ:i	()Lsb;
    //   25: astore 4
    //   27: aload 4
    //   29: invokestatic 67	se:a	(Ljava/io/OutputStream;)Lse;
    //   32: astore 5
    //   34: iconst_0
    //   35: istore 6
    //   37: iload_3
    //   38: ifne +374 -> 412
    //   41: aload_1
    //   42: invokevirtual 72	sc:a	()I
    //   45: istore 14
    //   47: iload 14
    //   49: lookupswitch	default:+67->116, 0:+457->506, 8:+85->134, 16:+158->207, 24:+198->247, 26:+243->292, 32:+321->370, 48:+342->391
    //   117: aload_1
    //   118: aload 5
    //   120: aload_2
    //   121: iload 14
    //   123: invokevirtual 75	dy:a	(Lsc;Lse;Lsg;I)Z
    //   126: ifne -89 -> 37
    //   129: iconst_1
    //   130: istore_3
    //   131: goto -94 -> 37
    //   134: aload_0
    //   135: bipush 8
    //   137: aload_0
    //   138: getfield 77	dy:e	I
    //   141: ior
    //   142: putfield 77	dy:e	I
    //   145: aload_0
    //   146: aload_1
    //   147: invokevirtual 80	sc:i	()Z
    //   150: putfield 82	dy:j	Z
    //   153: goto -116 -> 37
    //   156: astore 13
    //   158: aload 13
    //   160: aload_0
    //   161: invokevirtual 85	sx:a	(LsE;)Lsx;
    //   164: athrow
    //   165: astore 10
    //   167: iload 6
    //   169: iconst_1
    //   170: iand
    //   171: iconst_1
    //   172: if_icmpne +14 -> 186
    //   175: aload_0
    //   176: aload_0
    //   177: getfield 87	dy:f	Ljava/util/List;
    //   180: invokestatic 93	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   183: putfield 87	dy:f	Ljava/util/List;
    //   186: aload 5
    //   188: invokevirtual 95	se:a	()V
    //   191: aload_0
    //   192: aload 4
    //   194: invokevirtual 100	sb:a	()LrZ;
    //   197: putfield 102	dy:d	LrZ;
    //   200: aload_0
    //   201: invokevirtual 105	dy:R	()V
    //   204: aload 10
    //   206: athrow
    //   207: aload_0
    //   208: iconst_1
    //   209: aload_0
    //   210: getfield 77	dy:e	I
    //   213: ior
    //   214: putfield 77	dy:e	I
    //   217: aload_0
    //   218: aload_1
    //   219: invokevirtual 107	sc:f	()I
    //   222: putfield 109	dy:g	I
    //   225: goto -188 -> 37
    //   228: astore 9
    //   230: new 50	sx
    //   233: dup
    //   234: aload 9
    //   236: invokevirtual 113	java/io/IOException:getMessage	()Ljava/lang/String;
    //   239: invokespecial 116	sx:<init>	(Ljava/lang/String;)V
    //   242: aload_0
    //   243: invokevirtual 85	sx:a	(LsE;)Lsx;
    //   246: athrow
    //   247: iload 6
    //   249: iconst_1
    //   250: iand
    //   251: iconst_1
    //   252: if_icmpeq +20 -> 272
    //   255: aload_0
    //   256: new 118	java/util/ArrayList
    //   259: dup
    //   260: invokespecial 119	java/util/ArrayList:<init>	()V
    //   263: putfield 87	dy:f	Ljava/util/List;
    //   266: iload 6
    //   268: iconst_1
    //   269: ior
    //   270: istore 6
    //   272: aload_0
    //   273: getfield 87	dy:f	Ljava/util/List;
    //   276: aload_1
    //   277: invokevirtual 107	sc:f	()I
    //   280: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: invokeinterface 131 2 0
    //   288: pop
    //   289: goto -252 -> 37
    //   292: aload_1
    //   293: aload_1
    //   294: invokevirtual 134	sc:s	()I
    //   297: invokevirtual 137	sc:c	(I)I
    //   300: istore 15
    //   302: iload 6
    //   304: iconst_1
    //   305: iand
    //   306: iconst_1
    //   307: if_icmpeq +27 -> 334
    //   310: aload_1
    //   311: invokevirtual 140	sc:w	()I
    //   314: ifle +20 -> 334
    //   317: aload_0
    //   318: new 118	java/util/ArrayList
    //   321: dup
    //   322: invokespecial 119	java/util/ArrayList:<init>	()V
    //   325: putfield 87	dy:f	Ljava/util/List;
    //   328: iload 6
    //   330: iconst_1
    //   331: ior
    //   332: istore 6
    //   334: aload_1
    //   335: invokevirtual 140	sc:w	()I
    //   338: ifle +23 -> 361
    //   341: aload_0
    //   342: getfield 87	dy:f	Ljava/util/List;
    //   345: aload_1
    //   346: invokevirtual 107	sc:f	()I
    //   349: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: invokeinterface 131 2 0
    //   357: pop
    //   358: goto -24 -> 334
    //   361: aload_1
    //   362: iload 15
    //   364: invokevirtual 143	sc:d	(I)V
    //   367: goto -330 -> 37
    //   370: aload_0
    //   371: iconst_2
    //   372: aload_0
    //   373: getfield 77	dy:e	I
    //   376: ior
    //   377: putfield 77	dy:e	I
    //   380: aload_0
    //   381: aload_1
    //   382: invokevirtual 107	sc:f	()I
    //   385: putfield 145	dy:h	I
    //   388: goto -351 -> 37
    //   391: aload_0
    //   392: iconst_4
    //   393: aload_0
    //   394: getfield 77	dy:e	I
    //   397: ior
    //   398: putfield 77	dy:e	I
    //   401: aload_0
    //   402: aload_1
    //   403: invokevirtual 80	sc:i	()Z
    //   406: putfield 147	dy:i	Z
    //   409: goto -372 -> 37
    //   412: iload 6
    //   414: iconst_1
    //   415: iand
    //   416: iconst_1
    //   417: if_icmpne +14 -> 431
    //   420: aload_0
    //   421: aload_0
    //   422: getfield 87	dy:f	Ljava/util/List;
    //   425: invokestatic 93	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   428: putfield 87	dy:f	Ljava/util/List;
    //   431: aload 5
    //   433: invokevirtual 95	se:a	()V
    //   436: aload_0
    //   437: aload 4
    //   439: invokevirtual 100	sb:a	()LrZ;
    //   442: putfield 102	dy:d	LrZ;
    //   445: aload_0
    //   446: invokevirtual 105	dy:R	()V
    //   449: return
    //   450: astore 8
    //   452: aload_0
    //   453: aload 4
    //   455: invokevirtual 100	sb:a	()LrZ;
    //   458: putfield 102	dy:d	LrZ;
    //   461: goto -16 -> 445
    //   464: astore 7
    //   466: aload_0
    //   467: aload 4
    //   469: invokevirtual 100	sb:a	()LrZ;
    //   472: putfield 102	dy:d	LrZ;
    //   475: aload 7
    //   477: athrow
    //   478: astore 12
    //   480: aload_0
    //   481: aload 4
    //   483: invokevirtual 100	sb:a	()LrZ;
    //   486: putfield 102	dy:d	LrZ;
    //   489: goto -289 -> 200
    //   492: astore 11
    //   494: aload_0
    //   495: aload 4
    //   497: invokevirtual 100	sb:a	()LrZ;
    //   500: putfield 102	dy:d	LrZ;
    //   503: aload 11
    //   505: athrow
    //   506: iconst_1
    //   507: istore_3
    //   508: goto -471 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	dy
    //   0	511	1	paramsc	sc
    //   0	511	2	paramsg	sg
    //   1	507	3	n	int
    //   25	471	4	localsb	sb
    //   32	400	5	localse	se
    //   35	381	6	i1	int
    //   464	12	7	localObject1	Object
    //   450	1	8	localIOException1	java.io.IOException
    //   228	7	9	localIOException2	java.io.IOException
    //   165	40	10	localObject2	Object
    //   492	12	11	localObject3	Object
    //   478	1	12	localIOException3	java.io.IOException
    //   156	3	13	localsx	sx
    //   45	77	14	i2	int
    //   300	63	15	i3	int
    // Exception table:
    //   from	to	target	type
    //   41	153	156	sx
    //   207	225	156	sx
    //   255	409	156	sx
    //   41	153	165	finally
    //   158	165	165	finally
    //   207	225	165	finally
    //   230	247	165	finally
    //   255	409	165	finally
    //   41	153	228	java/io/IOException
    //   207	225	228	java/io/IOException
    //   255	409	228	java/io/IOException
    //   431	436	450	java/io/IOException
    //   431	436	464	finally
    //   186	191	478	java/io/IOException
    //   186	191	492	finally
  }
  
  private dy(sn paramsn)
  {
    super(paramsn);
    this.d = paramsn.r();
  }
  
  private dy(boolean paramBoolean)
  {
    this.d = rZ.a;
  }
  
  public static dA a(dy paramdy)
  {
    return r().a(paramdy);
  }
  
  public static dy a()
  {
    return c;
  }
  
  public static dA r()
  {
    return dA.k();
  }
  
  private void u()
  {
    this.f = Collections.emptyList();
    this.g = 0;
    this.h = 0;
    this.i = false;
    this.j = false;
  }
  
  public dy b()
  {
    return c;
  }
  
  public sI<dy> c()
  {
    return a;
  }
  
  public List<Integer> d()
  {
    return this.f;
  }
  
  public int e()
  {
    return this.f.size();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    if (paramObject == this) {}
    for (;;)
    {
      return bool1;
      if (!(paramObject instanceof dy))
      {
        bool1 = super.equals(paramObject);
      }
      else
      {
        dy localdy = (dy)paramObject;
        boolean bool2;
        label49:
        boolean bool3;
        label68:
        label94:
        boolean bool4;
        label113:
        boolean bool5;
        if (d().equals(localdy.d()))
        {
          bool2 = bool1;
          if ((!bool2) || (f() != localdy.f())) {
            break label237;
          }
          bool3 = bool1;
          if (f())
          {
            if ((!bool3) || (g() != localdy.g())) {
              break label243;
            }
            bool3 = bool1;
          }
          if ((!bool3) || (h() != localdy.h())) {
            break label249;
          }
          bool4 = bool1;
          if (h())
          {
            if ((!bool4) || (i() != localdy.i())) {
              break label255;
            }
            bool4 = bool1;
          }
          label139:
          if ((!bool4) || (k() != localdy.k())) {
            break label261;
          }
          bool5 = bool1;
          label158:
          if (k())
          {
            if ((!bool5) || (l() != localdy.l())) {
              break label267;
            }
            bool5 = bool1;
          }
          label184:
          if ((!bool5) || (m() != localdy.m())) {
            break label273;
          }
        }
        label261:
        label267:
        label273:
        for (boolean bool6 = bool1;; bool6 = false)
        {
          if (!m()) {
            break label279;
          }
          if ((bool6) && (q() == localdy.q())) {
            break;
          }
          bool1 = false;
          break;
          bool2 = false;
          break label49;
          label237:
          bool3 = false;
          break label68;
          label243:
          bool3 = false;
          break label94;
          label249:
          bool4 = false;
          break label113;
          label255:
          bool4 = false;
          break label139;
          bool5 = false;
          break label158;
          bool5 = false;
          break label184;
        }
        label279:
        bool1 = bool6;
      }
    }
  }
  
  public boolean f()
  {
    int n = 1;
    if ((0x1 & this.e) == n) {}
    for (;;)
    {
      return n;
      int i1 = 0;
    }
  }
  
  public int g()
  {
    return this.g;
  }
  
  public boolean h()
  {
    if ((0x2 & this.e) == 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    int i1;
    if (this.b != 0) {
      i1 = this.b;
    }
    for (;;)
    {
      return i1;
      int n = 779 + dy.class.hashCode();
      if (e() > 0) {
        n = 53 * (3 + n * 37) + d().hashCode();
      }
      if (f()) {
        n = 53 * (2 + n * 37) + g();
      }
      if (h()) {
        n = 53 * (4 + n * 37) + i();
      }
      if (k()) {
        n = 53 * (6 + n * 37) + su.a(l());
      }
      if (m()) {
        n = 53 * (1 + n * 37) + su.a(q());
      }
      i1 = n * 29 + this.d.hashCode();
      this.b = i1;
    }
  }
  
  public int i()
  {
    return this.h;
  }
  
  public final boolean j()
  {
    int n = 1;
    int i1 = this.k;
    if (i1 != -1) {
      if (i1 != n) {}
    }
    for (;;)
    {
      return n;
      n = 0;
      continue;
      if (!f())
      {
        this.k = 0;
        n = 0;
      }
      else
      {
        this.k = n;
      }
    }
  }
  
  public boolean k()
  {
    if ((0x4 & this.e) == 4) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean l()
  {
    return this.i;
  }
  
  public boolean m()
  {
    if ((0x8 & this.e) == 8) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean q()
  {
    return this.j;
  }
  
  public dA s()
  {
    return r();
  }
  
  public dA t()
  {
    return a(this);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     dy
 * JD-Core Version:    0.7.0.1
 */