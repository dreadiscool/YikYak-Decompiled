import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

class BA
  extends zU
  implements AR
{
  AQ a;
  
  private BA(Br paramBr)
  {
    super("OkHttp %s", arrayOfObject);
  }
  
  private void a(Bn paramBn)
  {
    ExecutorService localExecutorService = Br.f();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Br.a(this.c);
    localExecutorService.submit(new BC(this, "OkHttp %s ACK Settings", arrayOfObject, paramBn));
  }
  
  public void a(int paramInt1, int paramInt2, List<AT> paramList)
  {
    Br.a(this.c, paramInt2, paramList);
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      synchronized (this.c)
      {
        Br localBr2 = this.c;
        localBr2.d = (paramLong + localBr2.d);
        this.c.notifyAll();
      }
    }
    BD localBD = this.c.a(paramInt);
    if (localBD != null) {
      try
      {
        localBD.a(paramLong);
      }
      finally
      {
        localObject1 = finally;
        throw localObject1;
      }
    }
  }
  
  public void a(int paramInt, AP paramAP)
  {
    if (Br.a(this.c, paramInt)) {
      Br.a(this.c, paramInt, paramAP);
    }
    for (;;)
    {
      return;
      BD localBD = this.c.b(paramInt);
      if (localBD != null) {
        localBD.c(paramAP);
      }
    }
  }
  
  public void a(int paramInt, AP paramAP, LE paramLE)
  {
    paramLE.e();
    synchronized (this.c)
    {
      BD[] arrayOfBD = (BD[])Br.e(this.c).values().toArray(new BD[Br.e(this.c).size()]);
      Br.b(this.c, true);
      int i = arrayOfBD.length;
      int j = 0;
      if (j < i)
      {
        BD localBD = arrayOfBD[j];
        if ((localBD.a() > paramInt) && (localBD.c()))
        {
          localBD.c(AP.k);
          this.c.b(localBD.a());
        }
        j++;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      Bk localBk = Br.c(this.c, paramInt1);
      if (localBk != null) {
        localBk.b();
      }
    }
    for (;;)
    {
      return;
      Br.b(this.c, true, paramInt1, paramInt2, null);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, LD paramLD, int paramInt2)
  {
    if (Br.a(this.c, paramInt1)) {
      Br.a(this.c, paramInt1, paramLD, paramInt2, paramBoolean);
    }
    for (;;)
    {
      return;
      BD localBD = this.c.a(paramInt1);
      if (localBD == null)
      {
        this.c.a(paramInt1, AP.c);
        paramLD.g(paramInt2);
      }
      else
      {
        localBD.a(paramLD, paramInt2);
        if (paramBoolean) {
          localBD.h();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Bn paramBn)
  {
    for (;;)
    {
      int m;
      synchronized (this.c)
      {
        int i = this.c.f.e(65536);
        if (paramBoolean) {
          this.c.f.a();
        }
        this.c.f.a(paramBn);
        if (this.c.a() == zy.d) {
          a(paramBn);
        }
        int j = this.c.f.e(65536);
        if ((j == -1) || (j == i)) {
          break label257;
        }
        l = j - i;
        if (!Br.g(this.c))
        {
          this.c.a(l);
          Br.a(this.c, true);
        }
        if (Br.e(this.c).isEmpty()) {
          break label251;
        }
        arrayOfBD = (BD[])Br.e(this.c).values().toArray(new BD[Br.e(this.c).size()]);
        if ((arrayOfBD == null) || (l == 0L)) {
          break label250;
        }
        int k = arrayOfBD.length;
        m = 0;
        if (m >= k) {
          break label250;
        }
      }
      synchronized (arrayOfBD[m])
      {
        ???.a(l);
        m++;
        continue;
        localObject1 = finally;
        throw localObject1;
      }
      label250:
      return;
      label251:
      BD[] arrayOfBD = null;
      continue;
      label257:
      arrayOfBD = null;
      long l = 0L;
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<AT> paramList, AU paramAU)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	BA:c	LBr;
    //   4: iload_3
    //   5: invokestatic 72	Br:a	(LBr;I)Z
    //   8: ifeq +15 -> 23
    //   11: aload_0
    //   12: getfield 14	BA:c	LBr;
    //   15: iload_3
    //   16: aload 5
    //   18: iload_2
    //   19: invokestatic 188	Br:a	(LBr;ILjava/util/List;Z)V
    //   22: return
    //   23: aload_0
    //   24: getfield 14	BA:c	LBr;
    //   27: astore 7
    //   29: aload 7
    //   31: monitorenter
    //   32: aload_0
    //   33: getfield 14	BA:c	LBr;
    //   36: invokestatic 190	Br:b	(LBr;)Z
    //   39: ifeq +17 -> 56
    //   42: aload 7
    //   44: monitorexit
    //   45: goto -23 -> 22
    //   48: astore 8
    //   50: aload 7
    //   52: monitorexit
    //   53: aload 8
    //   55: athrow
    //   56: aload_0
    //   57: getfield 14	BA:c	LBr;
    //   60: iload_3
    //   61: invokevirtual 63	Br:a	(I)LBD;
    //   64: astore 9
    //   66: aload 9
    //   68: ifnonnull +170 -> 238
    //   71: aload 6
    //   73: invokevirtual 194	AU:a	()Z
    //   76: ifeq +20 -> 96
    //   79: aload_0
    //   80: getfield 14	BA:c	LBr;
    //   83: iload_3
    //   84: getstatic 139	AP:c	LAP;
    //   87: invokevirtual 141	Br:a	(ILAP;)V
    //   90: aload 7
    //   92: monitorexit
    //   93: goto -71 -> 22
    //   96: iload_3
    //   97: aload_0
    //   98: getfield 14	BA:c	LBr;
    //   101: invokestatic 197	Br:c	(LBr;)I
    //   104: if_icmpgt +9 -> 113
    //   107: aload 7
    //   109: monitorexit
    //   110: goto -88 -> 22
    //   113: iload_3
    //   114: iconst_2
    //   115: irem
    //   116: aload_0
    //   117: getfield 14	BA:c	LBr;
    //   120: invokestatic 199	Br:d	(LBr;)I
    //   123: iconst_2
    //   124: irem
    //   125: if_icmpne +9 -> 134
    //   128: aload 7
    //   130: monitorexit
    //   131: goto -109 -> 22
    //   134: new 65	BD
    //   137: dup
    //   138: iload_3
    //   139: aload_0
    //   140: getfield 14	BA:c	LBr;
    //   143: iload_1
    //   144: iload_2
    //   145: aload 5
    //   147: invokespecial 202	BD:<init>	(ILBr;ZZLjava/util/List;)V
    //   150: astore 11
    //   152: aload_0
    //   153: getfield 14	BA:c	LBr;
    //   156: iload_3
    //   157: invokestatic 205	Br:b	(LBr;I)I
    //   160: pop
    //   161: aload_0
    //   162: getfield 14	BA:c	LBr;
    //   165: invokestatic 91	Br:e	(LBr;)Ljava/util/Map;
    //   168: iload_3
    //   169: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   172: aload 11
    //   174: invokeinterface 215 3 0
    //   179: pop
    //   180: invokestatic 34	Br:f	()Ljava/util/concurrent/ExecutorService;
    //   183: astore 14
    //   185: iconst_2
    //   186: anewarray 16	java/lang/Object
    //   189: astore 15
    //   191: aload 15
    //   193: iconst_0
    //   194: aload_0
    //   195: getfield 14	BA:c	LBr;
    //   198: invokestatic 21	Br:a	(LBr;)Ljava/lang/String;
    //   201: aastore
    //   202: aload 15
    //   204: iconst_1
    //   205: iload_3
    //   206: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   209: aastore
    //   210: aload 14
    //   212: new 217	BB
    //   215: dup
    //   216: aload_0
    //   217: ldc 219
    //   219: aload 15
    //   221: aload 11
    //   223: invokespecial 222	BB:<init>	(LBA;Ljava/lang/String;[Ljava/lang/Object;LBD;)V
    //   226: invokeinterface 47 2 0
    //   231: pop
    //   232: aload 7
    //   234: monitorexit
    //   235: goto -213 -> 22
    //   238: aload 7
    //   240: monitorexit
    //   241: aload 6
    //   243: invokevirtual 224	AU:b	()Z
    //   246: ifeq +23 -> 269
    //   249: aload 9
    //   251: getstatic 226	AP:b	LAP;
    //   254: invokevirtual 228	BD:b	(LAP;)V
    //   257: aload_0
    //   258: getfield 14	BA:c	LBr;
    //   261: iload_3
    //   262: invokevirtual 78	Br:b	(I)LBD;
    //   265: pop
    //   266: goto -244 -> 22
    //   269: aload 9
    //   271: aload 5
    //   273: aload 6
    //   275: invokevirtual 231	BD:a	(Ljava/util/List;LAU;)V
    //   278: iload_2
    //   279: ifeq -257 -> 22
    //   282: aload 9
    //   284: invokevirtual 152	BD:h	()V
    //   287: goto -265 -> 22
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	BA
    //   0	290	1	paramBoolean1	boolean
    //   0	290	2	paramBoolean2	boolean
    //   0	290	3	paramInt1	int
    //   0	290	4	paramInt2	int
    //   0	290	5	paramList	List<AT>
    //   0	290	6	paramAU	AU
    //   27	212	7	localBr	Br
    //   48	6	8	localObject	Object
    //   64	219	9	localBD1	BD
    //   150	72	11	localBD2	BD
    //   183	28	14	localExecutorService	ExecutorService
    //   189	31	15	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   32	53	48	finally
    //   56	241	48	finally
  }
  
  /* Error */
  protected void b()
  {
    // Byte code:
    //   0: getstatic 235	AP:g	LAP;
    //   3: astore_1
    //   4: getstatic 235	AP:g	LAP;
    //   7: astore_2
    //   8: aload_0
    //   9: aload_0
    //   10: getfield 14	BA:c	LBr;
    //   13: getfield 238	Br:g	LBI;
    //   16: aload_0
    //   17: getfield 14	BA:c	LBr;
    //   20: getfield 241	Br:h	Ljava/net/Socket;
    //   23: invokestatic 246	LK:b	(Ljava/net/Socket;)LLV;
    //   26: invokestatic 249	LK:a	(LLV;)LLD;
    //   29: aload_0
    //   30: getfield 14	BA:c	LBr;
    //   33: getfield 252	Br:b	Z
    //   36: invokeinterface 257 3 0
    //   41: putfield 259	BA:a	LAQ;
    //   44: aload_0
    //   45: getfield 14	BA:c	LBr;
    //   48: getfield 252	Br:b	Z
    //   51: ifne +12 -> 63
    //   54: aload_0
    //   55: getfield 259	BA:a	LAQ;
    //   58: invokeinterface 262 1 0
    //   63: aload_0
    //   64: getfield 259	BA:a	LAQ;
    //   67: aload_0
    //   68: invokeinterface 265 2 0
    //   73: ifne -10 -> 63
    //   76: getstatic 267	AP:a	LAP;
    //   79: astore_1
    //   80: getstatic 270	AP:l	LAP;
    //   83: astore 10
    //   85: aload_0
    //   86: getfield 14	BA:c	LBr;
    //   89: aload_1
    //   90: aload 10
    //   92: invokestatic 273	Br:a	(LBr;LAP;LAP;)V
    //   95: aload_0
    //   96: getfield 259	BA:a	LAQ;
    //   99: invokestatic 278	Ae:a	(Ljava/io/Closeable;)V
    //   102: return
    //   103: astore 7
    //   105: getstatic 226	AP:b	LAP;
    //   108: astore 4
    //   110: getstatic 226	AP:b	LAP;
    //   113: astore 8
    //   115: aload_0
    //   116: getfield 14	BA:c	LBr;
    //   119: aload 4
    //   121: aload 8
    //   123: invokestatic 273	Br:a	(LBr;LAP;LAP;)V
    //   126: aload_0
    //   127: getfield 259	BA:a	LAQ;
    //   130: invokestatic 278	Ae:a	(Ljava/io/Closeable;)V
    //   133: goto -31 -> 102
    //   136: astore_3
    //   137: aload_1
    //   138: astore 4
    //   140: aload_3
    //   141: astore 5
    //   143: aload_0
    //   144: getfield 14	BA:c	LBr;
    //   147: aload 4
    //   149: aload_2
    //   150: invokestatic 273	Br:a	(LBr;LAP;LAP;)V
    //   153: aload_0
    //   154: getfield 259	BA:a	LAQ;
    //   157: invokestatic 278	Ae:a	(Ljava/io/Closeable;)V
    //   160: aload 5
    //   162: athrow
    //   163: astore 6
    //   165: goto -12 -> 153
    //   168: astore 5
    //   170: goto -27 -> 143
    //   173: astore 9
    //   175: goto -49 -> 126
    //   178: astore 11
    //   180: goto -85 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	BA
    //   3	135	1	localAP1	AP
    //   7	143	2	localAP2	AP
    //   136	5	3	localObject1	Object
    //   108	40	4	localAP3	AP
    //   141	20	5	localObject2	Object
    //   168	1	5	localObject3	Object
    //   163	1	6	localIOException1	java.io.IOException
    //   103	1	7	localIOException2	java.io.IOException
    //   113	9	8	localAP4	AP
    //   173	1	9	localIOException3	java.io.IOException
    //   83	8	10	localAP5	AP
    //   178	1	11	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   8	85	103	java/io/IOException
    //   8	85	136	finally
    //   105	110	136	finally
    //   143	153	163	java/io/IOException
    //   110	115	168	finally
    //   115	126	173	java/io/IOException
    //   85	95	178	java/io/IOException
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     BA
 * JD-Core Version:    0.7.0.1
 */