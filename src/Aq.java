final class Aq
  implements LU
{
  private final byte[] b;
  private boolean c;
  
  private Aq(An paramAn)
  {
    byte[] arrayOfByte = new byte[18];
    arrayOfByte[0] = 0;
    arrayOfByte[1] = 0;
    arrayOfByte[2] = 0;
    arrayOfByte[3] = 0;
    arrayOfByte[4] = 0;
    arrayOfByte[5] = 0;
    arrayOfByte[6] = 0;
    arrayOfByte[7] = 0;
    arrayOfByte[8] = 0;
    arrayOfByte[9] = 0;
    arrayOfByte[10] = 0;
    arrayOfByte[11] = 0;
    arrayOfByte[12] = 0;
    arrayOfByte[13] = 0;
    arrayOfByte[14] = 0;
    arrayOfByte[15] = 0;
    arrayOfByte[16] = 13;
    arrayOfByte[17] = 10;
    this.b = arrayOfByte;
  }
  
  private void a(long paramLong)
  {
    int i = 16;
    do
    {
      byte[] arrayOfByte = this.b;
      i--;
      arrayOfByte[i] = An.l()[((int)(0xF & paramLong))];
      paramLong >>>= 4;
    } while (paramLong != 0L);
    An.a(this.a).c(this.b, i, this.b.length - i);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	Aq:c	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 16	Aq:a	LAn;
    //   18: invokestatic 39	An:a	(LAn;)LLC;
    //   21: invokeinterface 48 1 0
    //   26: goto -15 -> 11
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	Aq
    //   29	4	1	localObject	Object
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
    //   14	26	29	finally
  }
  
  public void a_(Lz paramLz, long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    if (paramLong == 0L) {}
    for (;;)
    {
      return;
      a(paramLong);
      An.a(this.a).a_(paramLz, paramLong);
      An.a(this.a).c(An.j());
    }
  }
  
  public LW b()
  {
    return An.a(this.a).b();
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	Aq:c	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 46	Aq:c	Z
    //   19: aload_0
    //   20: getfield 16	Aq:a	LAn;
    //   23: invokestatic 39	An:a	(LAn;)LLC;
    //   26: invokestatic 74	An:k	()[B
    //   29: invokeinterface 67 2 0
    //   34: pop
    //   35: aload_0
    //   36: getfield 16	Aq:a	LAn;
    //   39: iconst_3
    //   40: invokestatic 77	An:a	(LAn;I)I
    //   43: pop
    //   44: goto -33 -> 11
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	Aq
    //   47	4	1	localObject	Object
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   14	44	47	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Aq
 * JD-Core Version:    0.7.0.1
 */