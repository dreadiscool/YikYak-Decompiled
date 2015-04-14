import android.content.Context;

public abstract class IQ<T>
  implements IS<T>
{
  private final IS<T> a;
  
  public IQ(IS<T> paramIS)
  {
    this.a = paramIS;
  }
  
  private void b(Context paramContext, T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    a(paramContext, paramT);
  }
  
  protected abstract T a(Context paramContext);
  
  /* Error */
  public final T a(Context paramContext, IT<T> paramIT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 28	IQ:a	(Landroid/content/Context;)Ljava/lang/Object;
    //   7: astore 4
    //   9: aload 4
    //   11: ifnonnull +30 -> 41
    //   14: aload_0
    //   15: getfield 17	IQ:a	LIS;
    //   18: ifnull +28 -> 46
    //   21: aload_0
    //   22: getfield 17	IQ:a	LIS;
    //   25: aload_1
    //   26: aload_2
    //   27: invokeinterface 30 3 0
    //   32: astore 4
    //   34: aload_0
    //   35: aload_1
    //   36: aload 4
    //   38: invokespecial 32	IQ:b	(Landroid/content/Context;Ljava/lang/Object;)V
    //   41: aload_0
    //   42: monitorexit
    //   43: aload 4
    //   45: areturn
    //   46: aload_2
    //   47: aload_1
    //   48: invokeinterface 37 2 0
    //   53: astore 5
    //   55: aload 5
    //   57: astore 4
    //   59: goto -25 -> 34
    //   62: astore_3
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_3
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	IQ
    //   0	67	1	paramContext	Context
    //   0	67	2	paramIT	IT<T>
    //   62	4	3	localObject1	Object
    //   7	51	4	localObject2	Object
    //   53	3	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	41	62	finally
    //   46	55	62	finally
  }
  
  protected abstract void a(Context paramContext, T paramT);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     IQ
 * JD-Core Version:    0.7.0.1
 */