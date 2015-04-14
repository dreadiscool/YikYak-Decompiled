public final class zO
{
  private final zQ b;
  private final boolean[] c;
  private boolean d;
  private boolean e;
  
  private zO(zL paramzL, zQ paramzQ)
  {
    this.b = paramzQ;
    if (zQ.f(paramzQ)) {}
    for (boolean[] arrayOfBoolean = null;; arrayOfBoolean = new boolean[zL.e(paramzL)])
    {
      this.c = arrayOfBoolean;
      return;
    }
  }
  
  /* Error */
  public LU a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	zO:a	LzL;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 22	zO:b	LzQ;
    //   11: invokestatic 49	zQ:a	(LzQ;)LzO;
    //   14: aload_0
    //   15: if_acmpeq +16 -> 31
    //   18: new 51	java/lang/IllegalStateException
    //   21: dup
    //   22: invokespecial 52	java/lang/IllegalStateException:<init>	()V
    //   25: athrow
    //   26: astore_3
    //   27: aload_2
    //   28: monitorexit
    //   29: aload_3
    //   30: athrow
    //   31: aload_0
    //   32: getfield 22	zO:b	LzQ;
    //   35: invokestatic 28	zQ:f	(LzQ;)Z
    //   38: ifne +10 -> 48
    //   41: aload_0
    //   42: getfield 30	zO:c	[Z
    //   45: iload_1
    //   46: iconst_1
    //   47: bastore
    //   48: aload_0
    //   49: getfield 22	zO:b	LzQ;
    //   52: invokestatic 55	zQ:d	(LzQ;)[Ljava/io/File;
    //   55: iload_1
    //   56: aaload
    //   57: astore 4
    //   59: aload 4
    //   61: invokestatic 60	LK:b	(Ljava/io/File;)LLU;
    //   64: astore 11
    //   66: aload 11
    //   68: astore 10
    //   70: new 62	zP
    //   73: dup
    //   74: aload_0
    //   75: aload 10
    //   77: invokespecial 65	zP:<init>	(LzO;LLU;)V
    //   80: astore 8
    //   82: aload_2
    //   83: monitorexit
    //   84: goto +39 -> 123
    //   87: astore 5
    //   89: aload_0
    //   90: getfield 17	zO:a	LzL;
    //   93: invokestatic 68	zL:f	(LzL;)Ljava/io/File;
    //   96: invokevirtual 74	java/io/File:mkdirs	()Z
    //   99: pop
    //   100: aload 4
    //   102: invokestatic 60	LK:b	(Ljava/io/File;)LLU;
    //   105: astore 9
    //   107: aload 9
    //   109: astore 10
    //   111: goto -41 -> 70
    //   114: astore 7
    //   116: invokestatic 77	zL:c	()LLU;
    //   119: astore 8
    //   121: aload_2
    //   122: monitorexit
    //   123: aload 8
    //   125: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	zO
    //   0	126	1	paramInt	int
    //   4	118	2	localzL	zL
    //   26	4	3	localObject1	Object
    //   57	44	4	localFile	java.io.File
    //   87	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   114	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   80	44	8	localObject2	Object
    //   105	3	9	localLU1	LU
    //   68	42	10	localObject3	Object
    //   64	3	11	localLU2	LU
    // Exception table:
    //   from	to	target	type
    //   7	29	26	finally
    //   31	59	26	finally
    //   59	66	26	finally
    //   70	100	26	finally
    //   100	107	26	finally
    //   116	123	26	finally
    //   59	66	87	java/io/FileNotFoundException
    //   100	107	114	java/io/FileNotFoundException
  }
  
  public void a()
  {
    synchronized (this.a)
    {
      if (this.d)
      {
        zL.a(this.a, this, false);
        zL.a(this.a, this.b);
        this.e = true;
        return;
      }
      zL.a(this.a, this, true);
    }
  }
  
  public void b()
  {
    synchronized (this.a)
    {
      zL.a(this.a, this, false);
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zO
 * JD-Core Version:    0.7.0.1
 */