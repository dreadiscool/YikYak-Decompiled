import java.net.URL;

final class yY
  extends zU
{
  private final yZ c;
  
  private yY(yV paramyV, yZ paramyZ)
  {
    super("OkHttp %s", arrayOfObject);
    this.c = paramyZ;
  }
  
  String a()
  {
    return this.a.b.a().getHost();
  }
  
  /* Error */
  protected void b()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 12	yY:a	LyV;
    //   6: invokestatic 49	yV:a	(LyV;)LzF;
    //   9: astore 4
    //   11: aload_0
    //   12: getfield 12	yY:a	LyV;
    //   15: getfield 52	yV:a	Z
    //   18: istore 5
    //   20: iload 5
    //   22: ifeq +43 -> 65
    //   25: aload_0
    //   26: getfield 32	yY:c	LyZ;
    //   29: aload_0
    //   30: getfield 12	yY:a	LyV;
    //   33: getfield 20	yV:b	Lzz;
    //   36: new 46	java/io/IOException
    //   39: dup
    //   40: ldc 54
    //   42: invokespecial 57	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   45: invokeinterface 62 3 0
    //   50: aload_0
    //   51: getfield 12	yY:a	LyV;
    //   54: invokestatic 65	yV:c	(LyV;)Lzu;
    //   57: invokevirtual 71	zu:r	()Lzm;
    //   60: aload_0
    //   61: invokevirtual 76	zm:b	(LyY;)V
    //   64: return
    //   65: aload_0
    //   66: getfield 32	yY:c	LyZ;
    //   69: aload 4
    //   71: invokeinterface 79 2 0
    //   76: goto -26 -> 50
    //   79: astore_2
    //   80: iload_1
    //   81: ifeq +55 -> 136
    //   84: getstatic 84	zS:a	Ljava/util/logging/Logger;
    //   87: getstatic 90	java/util/logging/Level:INFO	Ljava/util/logging/Level;
    //   90: new 92	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   97: ldc 96
    //   99: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: getfield 12	yY:a	LyV;
    //   106: invokestatic 103	yV:b	(LyV;)Ljava/lang/String;
    //   109: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: aload_2
    //   116: invokevirtual 112	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   119: aload_0
    //   120: getfield 12	yY:a	LyV;
    //   123: invokestatic 65	yV:c	(LyV;)Lzu;
    //   126: invokevirtual 71	zu:r	()Lzm;
    //   129: aload_0
    //   130: invokevirtual 76	zm:b	(LyY;)V
    //   133: goto -69 -> 64
    //   136: aload_0
    //   137: getfield 32	yY:c	LyZ;
    //   140: aload_0
    //   141: getfield 12	yY:a	LyV;
    //   144: getfield 115	yV:c	LAx;
    //   147: invokevirtual 121	Ax:g	()Lzz;
    //   150: aload_2
    //   151: invokeinterface 62 3 0
    //   156: goto -37 -> 119
    //   159: astore_3
    //   160: aload_0
    //   161: getfield 12	yY:a	LyV;
    //   164: invokestatic 65	yV:c	(LyV;)Lzu;
    //   167: invokevirtual 71	zu:r	()Lzm;
    //   170: aload_0
    //   171: invokevirtual 76	zm:b	(LyY;)V
    //   174: aload_3
    //   175: athrow
    //   176: astore_2
    //   177: iconst_0
    //   178: istore_1
    //   179: goto -99 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	yY
    //   1	178	1	i	int
    //   79	72	2	localIOException1	java.io.IOException
    //   176	1	2	localIOException2	java.io.IOException
    //   159	16	3	localObject	Object
    //   9	61	4	localzF	zF
    //   18	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   25	50	79	java/io/IOException
    //   65	76	79	java/io/IOException
    //   2	20	159	finally
    //   25	50	159	finally
    //   65	76	159	finally
    //   84	119	159	finally
    //   136	156	159	finally
    //   2	20	176	java/io/IOException
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yY
 * JD-Core Version:    0.7.0.1
 */