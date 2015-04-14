class om
  extends ol
{
  private static final Object a = new Object();
  private static om k;
  private nH b;
  private volatile nG c;
  private int d = 1800000;
  private boolean e = true;
  private boolean f = false;
  private boolean g = true;
  private boolean h = true;
  private nI i = new on(this);
  private boolean j = false;
  
  public static om b()
  {
    if (k == null) {
      k = new om();
    }
    return k;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	om:f	Z
    //   6: ifne +16 -> 22
    //   9: ldc 61
    //   11: invokestatic 66	nK:d	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 37	om:e	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 68	om:c	LnG;
    //   26: pop
    //   27: new 70	oo
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 71	oo:<init>	(Lom;)V
    //   35: pop
    //   36: goto -17 -> 19
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	om
    //   39	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	39	finally
    //   22	36	39	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     om
 * JD-Core Version:    0.7.0.1
 */