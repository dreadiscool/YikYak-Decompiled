import java.util.ArrayList;

public abstract class hA<TListener>
{
  private TListener b;
  private boolean c;
  
  public hA(TListener paramTListener)
  {
    Object localObject;
    this.b = localObject;
    this.c = false;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	hA:b	Ljava/lang/Object;
    //   6: astore_2
    //   7: aload_0
    //   8: getfield 23	hA:c	Z
    //   11: ifeq +28 -> 39
    //   14: new 27	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   21: ldc 30
    //   23: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: ldc 39
    //   32: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: pop
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: ifnull +8 -> 50
    //   45: aload_0
    //   46: aload_2
    //   47: invokevirtual 46	hA:a	(Ljava/lang/Object;)V
    //   50: aload_0
    //   51: monitorenter
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 23	hA:c	Z
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_0
    //   60: invokevirtual 48	hA:b	()V
    //   63: return
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    //   69: astore 4
    //   71: aload 4
    //   73: athrow
    //   74: astore_3
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_3
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	hA
    //   64	4	1	localObject1	Object
    //   6	41	2	localObject2	Object
    //   74	4	3	localObject3	Object
    //   69	3	4	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   2	41	64	finally
    //   65	67	64	finally
    //   45	50	69	java/lang/RuntimeException
    //   52	59	74	finally
    //   75	77	74	finally
  }
  
  protected abstract void a(TListener paramTListener);
  
  public void b()
  {
    c();
    synchronized (hy.b(this.a))
    {
      hy.b(this.a).remove(this);
      return;
    }
  }
  
  public void c()
  {
    try
    {
      this.b = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hA
 * JD-Core Version:    0.7.0.1
 */