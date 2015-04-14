import java.net.Socket;
import java.util.concurrent.TimeUnit;

public final class An
{
  private static final byte[] h;
  private static final byte[] i;
  private static final byte[] j;
  private final zg a;
  private final zf b;
  private final Socket c;
  private final LD d;
  private final LC e;
  private int f = 0;
  private int g = 0;
  
  static
  {
    byte[] arrayOfByte1 = new byte[2];
    arrayOfByte1[0] = 13;
    arrayOfByte1[1] = 10;
    h = arrayOfByte1;
    byte[] arrayOfByte2 = new byte[16];
    arrayOfByte2[0] = 48;
    arrayOfByte2[1] = 49;
    arrayOfByte2[2] = 50;
    arrayOfByte2[3] = 51;
    arrayOfByte2[4] = 52;
    arrayOfByte2[5] = 53;
    arrayOfByte2[6] = 54;
    arrayOfByte2[7] = 55;
    arrayOfByte2[8] = 56;
    arrayOfByte2[9] = 57;
    arrayOfByte2[10] = 97;
    arrayOfByte2[11] = 98;
    arrayOfByte2[12] = 99;
    arrayOfByte2[13] = 100;
    arrayOfByte2[14] = 101;
    arrayOfByte2[15] = 102;
    i = arrayOfByte2;
    byte[] arrayOfByte3 = new byte[5];
    arrayOfByte3[0] = 48;
    arrayOfByte3[1] = 13;
    arrayOfByte3[2] = 10;
    arrayOfByte3[3] = 13;
    arrayOfByte3[4] = 10;
    j = arrayOfByte3;
  }
  
  public An(zg paramzg, zf paramzf, Socket paramSocket)
  {
    this.a = paramzg;
    this.b = paramzf;
    this.c = paramSocket;
    this.d = LK.a(LK.b(paramSocket));
    this.e = LK.a(LK.a(paramSocket));
  }
  
  public LU a(long paramLong)
  {
    if (this.f != 1) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.f = 2;
    return new As(this, paramLong, null);
  }
  
  public LV a(Ax paramAx)
  {
    if (this.f != 4) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.f = 5;
    return new Ar(this, paramAx);
  }
  
  public void a()
  {
    this.g = 1;
    if (this.f == 0)
    {
      this.g = 0;
      zS.b.a(this.a, this.b);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      this.d.b().a(paramInt1, TimeUnit.MILLISECONDS);
    }
    if (paramInt2 != 0) {
      this.e.b().a(paramInt2, TimeUnit.MILLISECONDS);
    }
  }
  
  public void a(AH paramAH)
  {
    if (this.f != 1) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.f = 3;
    paramAH.a(this.e);
  }
  
  public void a(Object paramObject)
  {
    zS.b.a(this.b, paramObject);
  }
  
  public void a(zo paramzo, String paramString)
  {
    if (this.f != 0) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.e.b(paramString).b("\r\n");
    int k = 0;
    int m = paramzo.a();
    while (k < m)
    {
      this.e.b(paramzo.a(k)).b(": ").b(paramzo.b(k)).b("\r\n");
      k++;
    }
    this.e.b("\r\n");
    this.f = 1;
  }
  
  public void a(zq paramzq)
  {
    for (;;)
    {
      String str = this.d.q();
      if (str.length() == 0) {
        break;
      }
      zS.b.a(paramzq, str);
    }
  }
  
  public LV b(long paramLong)
  {
    if (this.f != 4) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.f = 5;
    return new At(this, paramLong);
  }
  
  public void b()
  {
    this.g = 2;
    if (this.f == 0)
    {
      this.f = 6;
      this.b.d().close();
    }
  }
  
  public boolean c()
  {
    if (this.f == 6) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void d()
  {
    this.e.a();
  }
  
  public long e()
  {
    return this.d.d().c();
  }
  
  /* Error */
  public boolean f()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 61	An:c	Ljava/net/Socket;
    //   6: invokevirtual 223	java/net/Socket:getSoTimeout	()I
    //   9: istore 4
    //   11: aload_0
    //   12: getfield 61	An:c	Ljava/net/Socket;
    //   15: iconst_1
    //   16: invokevirtual 227	java/net/Socket:setSoTimeout	(I)V
    //   19: aload_0
    //   20: getfield 71	An:d	LLD;
    //   23: invokeinterface 229 1 0
    //   28: istore 6
    //   30: iload 6
    //   32: ifeq +15 -> 47
    //   35: aload_0
    //   36: getfield 61	An:c	Ljava/net/Socket;
    //   39: iload 4
    //   41: invokevirtual 227	java/net/Socket:setSoTimeout	(I)V
    //   44: goto +38 -> 82
    //   47: aload_0
    //   48: getfield 61	An:c	Ljava/net/Socket;
    //   51: iload 4
    //   53: invokevirtual 227	java/net/Socket:setSoTimeout	(I)V
    //   56: iconst_1
    //   57: istore_1
    //   58: goto +24 -> 82
    //   61: astore 5
    //   63: aload_0
    //   64: getfield 61	An:c	Ljava/net/Socket;
    //   67: iload 4
    //   69: invokevirtual 227	java/net/Socket:setSoTimeout	(I)V
    //   72: aload 5
    //   74: athrow
    //   75: astore_3
    //   76: iconst_1
    //   77: istore_1
    //   78: goto +4 -> 82
    //   81: astore_2
    //   82: iload_1
    //   83: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	An
    //   1	82	1	bool1	boolean
    //   81	1	2	localIOException	java.io.IOException
    //   75	1	3	localSocketTimeoutException	java.net.SocketTimeoutException
    //   9	59	4	k	int
    //   61	12	5	localObject	Object
    //   28	3	6	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   11	30	61	finally
    //   2	11	75	java/net/SocketTimeoutException
    //   35	75	75	java/net/SocketTimeoutException
    //   2	11	81	java/io/IOException
    //   35	75	81	java/io/IOException
  }
  
  public zH g()
  {
    if ((this.f != 1) && (this.f != 3)) {
      throw new IllegalStateException("state: " + this.f);
    }
    AK localAK;
    zH localzH;
    do
    {
      localAK = AK.a(this.d.q());
      localzH = new zH().a(localAK.a).a(localAK.b).a(localAK.c);
      zq localzq = new zq();
      a(localzq);
      localzq.a(AD.d, localAK.a.toString());
      localzH.a(localzq.a());
    } while (localAK.b == 100);
    this.f = 4;
    return localzH;
  }
  
  public LU h()
  {
    if (this.f != 1) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.f = 2;
    return new Aq(this, null);
  }
  
  public LV i()
  {
    if (this.f != 4) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.f = 5;
    return new Au(this, null);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     An
 * JD-Core Version:    0.7.0.1
 */