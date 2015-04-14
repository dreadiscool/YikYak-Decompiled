import java.io.OutputStream;
import java.util.ArrayList;

public final class sb
  extends OutputStream
{
  private static final byte[] a = new byte[0];
  private final int b;
  private final ArrayList<rZ> c;
  private int d;
  private byte[] e;
  private int f;
  
  sb(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Buffer size < 0");
    }
    this.b = paramInt;
    this.c = new ArrayList();
    this.e = new byte[paramInt];
  }
  
  private void a(int paramInt)
  {
    this.c.add(new sB(this.e));
    this.d += this.e.length;
    this.e = new byte[Math.max(this.b, Math.max(paramInt, this.d >>> 1))];
    this.f = 0;
  }
  
  private void c()
  {
    if (this.f < this.e.length) {
      if (this.f > 0)
      {
        byte[] arrayOfByte = new byte[this.f];
        System.arraycopy(this.e, 0, arrayOfByte, 0, this.f);
        this.c.add(new sB(arrayOfByte));
      }
    }
    for (;;)
    {
      this.d += this.f;
      this.f = 0;
      return;
      this.c.add(new sB(this.e));
      this.e = a;
    }
  }
  
  public rZ a()
  {
    try
    {
      c();
      rZ localrZ = rZ.a(this.c);
      return localrZ;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int b()
  {
    try
    {
      int i = this.d;
      int j = this.f;
      int k = i + j;
      return k;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.toHexString(System.identityHashCode(this));
    arrayOfObject[1] = Integer.valueOf(b());
    return String.format("<ByteString.Output@%s size=%d>", arrayOfObject);
  }
  
  public void write(int paramInt)
  {
    try
    {
      if (this.f == this.e.length) {
        a(1);
      }
      byte[] arrayOfByte = this.e;
      int i = this.f;
      this.f = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: aload_0
    //   4: getfield 38	sb:e	[B
    //   7: arraylength
    //   8: aload_0
    //   9: getfield 57	sb:f	I
    //   12: isub
    //   13: if_icmpgt +30 -> 43
    //   16: aload_1
    //   17: iload_2
    //   18: aload_0
    //   19: getfield 38	sb:e	[B
    //   22: aload_0
    //   23: getfield 57	sb:f	I
    //   26: iload_3
    //   27: invokestatic 63	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   30: aload_0
    //   31: iload_3
    //   32: aload_0
    //   33: getfield 57	sb:f	I
    //   36: iadd
    //   37: putfield 57	sb:f	I
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: aload_0
    //   44: getfield 38	sb:e	[B
    //   47: arraylength
    //   48: aload_0
    //   49: getfield 57	sb:f	I
    //   52: isub
    //   53: istore 5
    //   55: aload_1
    //   56: iload_2
    //   57: aload_0
    //   58: getfield 38	sb:e	[B
    //   61: aload_0
    //   62: getfield 57	sb:f	I
    //   65: iload 5
    //   67: invokestatic 63	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   70: iload_2
    //   71: iload 5
    //   73: iadd
    //   74: istore 6
    //   76: iload_3
    //   77: iload 5
    //   79: isub
    //   80: istore 7
    //   82: aload_0
    //   83: iload 7
    //   85: invokespecial 103	sb:a	(I)V
    //   88: aload_1
    //   89: iload 6
    //   91: aload_0
    //   92: getfield 38	sb:e	[B
    //   95: iconst_0
    //   96: iload 7
    //   98: invokestatic 63	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   101: aload_0
    //   102: iload 7
    //   104: putfield 57	sb:f	I
    //   107: goto -67 -> 40
    //   110: astore 4
    //   112: aload_0
    //   113: monitorexit
    //   114: aload 4
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	sb
    //   0	117	1	paramArrayOfByte	byte[]
    //   0	117	2	paramInt1	int
    //   0	117	3	paramInt2	int
    //   110	5	4	localObject	Object
    //   53	27	5	i	int
    //   74	16	6	j	int
    //   80	23	7	k	int
    // Exception table:
    //   from	to	target	type
    //   2	40	110	finally
    //   43	107	110	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sb
 * JD-Core Version:    0.7.0.1
 */