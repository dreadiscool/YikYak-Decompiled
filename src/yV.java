import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class yV
{
  volatile boolean a;
  zz b;
  Ax c;
  private final zu d;
  private boolean e;
  
  protected yV(zu paramzu, zz paramzz)
  {
    this.d = paramzu.w();
    this.b = paramzz;
  }
  
  private String b()
  {
    if (this.a) {}
    for (Object localObject = "canceled call";; localObject = "call")
    {
      try
      {
        String str1 = new URL(this.b.a(), "/...").toString();
        String str2 = (String)localObject + " to " + str1;
        localObject = str2;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        label58:
        break label58;
      }
      return localObject;
    }
  }
  
  private zF c()
  {
    return new yX(this, 0, this.b).a(this.b);
  }
  
  /* Error */
  public zF a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	yV:e	Z
    //   6: ifeq +18 -> 24
    //   9: new 82	java/lang/IllegalStateException
    //   12: dup
    //   13: ldc 84
    //   15: invokespecial 87	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   18: athrow
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: athrow
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 80	yV:e	Z
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_0
    //   32: getfield 26	yV:d	Lzu;
    //   35: invokevirtual 91	zu:r	()Lzm;
    //   38: aload_0
    //   39: invokevirtual 96	zm:a	(LyV;)V
    //   42: aload_0
    //   43: invokespecial 32	yV:c	()LzF;
    //   46: astore_3
    //   47: aload_3
    //   48: ifnonnull +27 -> 75
    //   51: new 98	java/io/IOException
    //   54: dup
    //   55: ldc 100
    //   57: invokespecial 101	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   60: athrow
    //   61: astore_2
    //   62: aload_0
    //   63: getfield 26	yV:d	Lzu;
    //   66: invokevirtual 91	zu:r	()Lzm;
    //   69: aload_0
    //   70: invokevirtual 103	zm:b	(LyV;)V
    //   73: aload_2
    //   74: athrow
    //   75: aload_0
    //   76: getfield 26	yV:d	Lzu;
    //   79: invokevirtual 91	zu:r	()Lzm;
    //   82: aload_0
    //   83: invokevirtual 103	zm:b	(LyV;)V
    //   86: aload_3
    //   87: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	yV
    //   19	4	1	localObject1	Object
    //   61	13	2	localObject2	Object
    //   46	41	3	localzF	zF
    // Exception table:
    //   from	to	target	type
    //   2	22	19	finally
    //   24	31	19	finally
    //   31	61	61	finally
  }
  
  zF a(zz paramzz, boolean paramBoolean)
  {
    zC localzC = paramzz.f();
    zB localzB;
    if (localzC != null)
    {
      localzB = paramzz.g();
      zt localzt = localzC.a();
      if (localzt != null) {
        localzB.a("Content-Type", localzt.toString());
      }
      long l = localzC.b();
      if (l != -1L)
      {
        localzB.a("Content-Length", Long.toString(l));
        localzB.b("Transfer-Encoding");
      }
    }
    for (zz localzz1 = localzB.b();; localzz1 = paramzz)
    {
      this.c = new Ax(this.d, localzz1, false, false, paramBoolean, null, null, null, null);
      label126:
      int j;
      for (int i = 0;; i = j)
      {
        zF localzF;
        zz localzz2;
        for (;;)
        {
          if (this.a)
          {
            this.c.k();
            localzF = null;
            return localzF;
            localzB.a("Transfer-Encoding", "chunked");
            localzB.b("Content-Length");
            break;
          }
          try
          {
            this.c.a();
            this.c.n();
            localzF = this.c.h();
            localzz2 = this.c.o();
            if (localzz2 == null)
            {
              if (paramBoolean) {
                break label126;
              }
              this.c.k();
            }
          }
          catch (IOException localIOException)
          {
            Ax localAx = this.c.a(localIOException, null);
            if (localAx != null) {
              this.c = localAx;
            } else {
              throw localIOException;
            }
          }
        }
        j = i + 1;
        if (j > 20) {
          throw new ProtocolException("Too many follow-up requests: " + j);
        }
        if (!this.c.b(localzz2.a())) {
          this.c.k();
        }
        zf localzf = this.c.m();
        this.c = new Ax(this.d, localzz2, false, false, paramBoolean, localzf, null, null, localzF);
      }
    }
  }
  
  /* Error */
  public void a(yZ paramyZ)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	yV:e	Z
    //   6: ifeq +18 -> 24
    //   9: new 82	java/lang/IllegalStateException
    //   12: dup
    //   13: ldc 84
    //   15: invokespecial 87	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   18: athrow
    //   19: astore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 80	yV:e	Z
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_0
    //   32: getfield 26	yV:d	Lzu;
    //   35: invokevirtual 91	zu:r	()Lzm;
    //   38: new 191	yY
    //   41: dup
    //   42: aload_0
    //   43: aload_1
    //   44: aconst_null
    //   45: invokespecial 194	yY:<init>	(LyV;LyZ;LyW;)V
    //   48: invokevirtual 197	zm:a	(LyY;)V
    //   51: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	yV
    //   0	52	1	paramyZ	yZ
    //   19	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	19	finally
    //   24	31	19	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yV
 * JD-Core Version:    0.7.0.1
 */