import java.util.concurrent.Callable;

public abstract class KI<V>
  implements Callable<V>
{
  protected abstract V b();
  
  protected abstract void c();
  
  /* Error */
  public V call()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: invokevirtual 21	KI:b	()Ljava/lang/Object;
    //   6: astore 6
    //   8: aload_0
    //   9: invokevirtual 23	KI:c	()V
    //   12: aload 6
    //   14: areturn
    //   15: astore 7
    //   17: new 17	KH
    //   20: dup
    //   21: aload 7
    //   23: invokespecial 26	KH:<init>	(Ljava/io/IOException;)V
    //   26: athrow
    //   27: astore 5
    //   29: aload 5
    //   31: athrow
    //   32: astore_2
    //   33: aload_0
    //   34: invokevirtual 23	KI:c	()V
    //   37: aload_2
    //   38: athrow
    //   39: astore 4
    //   41: new 17	KH
    //   44: dup
    //   45: aload 4
    //   47: invokespecial 26	KH:<init>	(Ljava/io/IOException;)V
    //   50: athrow
    //   51: astore_3
    //   52: iload_1
    //   53: ifne -16 -> 37
    //   56: new 17	KH
    //   59: dup
    //   60: aload_3
    //   61: invokespecial 26	KH:<init>	(Ljava/io/IOException;)V
    //   64: athrow
    //   65: astore_2
    //   66: iconst_0
    //   67: istore_1
    //   68: goto -35 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	KI
    //   1	67	1	i	int
    //   32	6	2	localObject1	Object
    //   65	1	2	localObject2	Object
    //   51	10	3	localIOException1	java.io.IOException
    //   39	7	4	localIOException2	java.io.IOException
    //   27	3	5	localKH	KH
    //   6	7	6	localObject3	Object
    //   15	7	7	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   8	12	15	java/io/IOException
    //   2	8	27	KH
    //   29	32	32	finally
    //   41	51	32	finally
    //   2	8	39	java/io/IOException
    //   33	37	51	java/io/IOException
    //   2	8	65	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     KI
 * JD-Core Version:    0.7.0.1
 */