class IL<Result>
  extends JT<Void, Void, Result>
{
  final IM<Result> a;
  
  public IL(IM<Result> paramIM)
  {
    this.a = paramIM;
  }
  
  private JD a(String paramString)
  {
    JD localJD = new JD(this.a.c() + "." + paramString, "KitInitialization");
    localJD.a();
    return localJD;
  }
  
  protected Result a(Void... paramVarArgs)
  {
    JD localJD = a("doInBackground");
    Object localObject = null;
    if (!b_()) {
      localObject = this.a.z();
    }
    localJD.b();
    return localObject;
  }
  
  /* Error */
  protected void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 69	JT:a	()V
    //   4: aload_0
    //   5: ldc 71
    //   7: invokespecial 53	IL:a	(Ljava/lang/String;)LJD;
    //   10: astore_1
    //   11: aload_0
    //   12: getfield 15	IL:a	LIM;
    //   15: invokevirtual 73	IM:a	()Z
    //   18: istore 8
    //   20: aload_1
    //   21: invokevirtual 64	JD:b	()V
    //   24: iload 8
    //   26: ifne +9 -> 35
    //   29: aload_0
    //   30: iconst_1
    //   31: invokevirtual 76	IL:a	(Z)Z
    //   34: pop
    //   35: return
    //   36: astore 7
    //   38: aload 7
    //   40: athrow
    //   41: astore 5
    //   43: aload_1
    //   44: invokevirtual 64	JD:b	()V
    //   47: aload_0
    //   48: iconst_1
    //   49: invokevirtual 76	IL:a	(Z)Z
    //   52: pop
    //   53: aload 5
    //   55: athrow
    //   56: astore_2
    //   57: invokestatic 82	IC:g	()LIO;
    //   60: pop
    //   61: aload_1
    //   62: invokevirtual 64	JD:b	()V
    //   65: aload_0
    //   66: iconst_1
    //   67: invokevirtual 76	IL:a	(Z)Z
    //   70: pop
    //   71: goto -36 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	IL
    //   10	52	1	localJD	JD
    //   56	1	2	localException	java.lang.Exception
    //   41	13	5	localObject	Object
    //   36	3	7	localKd	Kd
    //   18	7	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	20	36	Kd
    //   11	20	41	finally
    //   38	41	41	finally
    //   57	61	41	finally
    //   11	20	56	java/lang/Exception
  }
  
  protected void a(Result paramResult)
  {
    this.a.e.a(paramResult);
  }
  
  public JS b()
  {
    return JS.c;
  }
  
  protected void b(Result paramResult)
  {
    IK localIK = new IK(this.a.c() + " Initialization was cancelled");
    this.a.e.a(localIK);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     IL
 * JD-Core Version:    0.7.0.1
 */