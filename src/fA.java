public class fA
{
  private static fl a;
  private static volatile boolean b = false;
  private static fr c;
  
  public static void a(String paramString)
  {
    fr localfr = b();
    if (localfr != null) {
      localfr.d(paramString);
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if ((b() != null) && (b().a() == 0)) {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  static fr b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 14	fA:b	Z
    //   6: ifeq +29 -> 35
    //   9: getstatic 32	fA:c	Lfr;
    //   12: ifnonnull +13 -> 25
    //   15: new 34	gl
    //   18: dup
    //   19: invokespecial 35	gl:<init>	()V
    //   22: putstatic 32	fA:c	Lfr;
    //   25: getstatic 32	fA:c	Lfr;
    //   28: astore_1
    //   29: ldc 2
    //   31: monitorexit
    //   32: goto +45 -> 77
    //   35: getstatic 37	fA:a	Lfl;
    //   38: ifnonnull +9 -> 47
    //   41: invokestatic 42	fl:a	()Lfl;
    //   44: putstatic 37	fA:a	Lfl;
    //   47: getstatic 37	fA:a	Lfl;
    //   50: ifnull +22 -> 72
    //   53: getstatic 37	fA:a	Lfl;
    //   56: invokevirtual 44	fl:d	()Lfr;
    //   59: astore_1
    //   60: ldc 2
    //   62: monitorexit
    //   63: goto +14 -> 77
    //   66: astore_0
    //   67: ldc 2
    //   69: monitorexit
    //   70: aload_0
    //   71: athrow
    //   72: ldc 2
    //   74: monitorexit
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_1
    //   78: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   66	5	0	localObject	Object
    //   28	50	1	localfr	fr
    // Exception table:
    //   from	to	target	type
    //   3	70	66	finally
    //   72	75	66	finally
  }
  
  public static void b(String paramString)
  {
    fr localfr = b();
    if (localfr != null) {
      localfr.b(paramString);
    }
  }
  
  public static void c(String paramString)
  {
    fr localfr = b();
    if (localfr != null) {
      localfr.a(paramString);
    }
  }
  
  public static void d(String paramString)
  {
    fr localfr = b();
    if (localfr != null) {
      localfr.c(paramString);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fA
 * JD-Core Version:    0.7.0.1
 */