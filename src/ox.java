import com.google.android.gms.common.api.Status;

class ox
  implements nn
{
  private nm a;
  private nm b;
  private Status c;
  private oz d;
  private oy e;
  private boolean f;
  private nw g;
  
  public void a()
  {
    try
    {
      if (this.f) {
        nK.a("Refreshing a released ContainerHolder.");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	ox:f	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 31	ox:a	Lnm;
    //   18: aload_1
    //   19: invokevirtual 34	nm:a	(Ljava/lang/String;)V
    //   22: goto -11 -> 11
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	ox
    //   0	30	1	paramString	String
    //   25	4	2	localObject	Object
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   14	22	25	finally
  }
  
  String b()
  {
    if (this.f) {
      nK.a("getContainerId called on a released ContainerHolder.");
    }
    for (String str = "";; str = this.a.a()) {
      return str;
    }
  }
  
  void b(String paramString)
  {
    if (this.f) {
      nK.a("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
    }
  }
  
  String c()
  {
    if (this.f) {
      nK.a("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
    }
    for (String str = "";; str = this.e.a()) {
      return str;
    }
  }
  
  public Status getStatus()
  {
    return this.c;
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	ox:f	Z
    //   6: ifeq +11 -> 17
    //   9: ldc 55
    //   11: invokestatic 29	nK:a	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 22	ox:f	Z
    //   22: aload_0
    //   23: getfield 57	ox:g	Lnw;
    //   26: aload_0
    //   27: invokevirtual 62	nw:a	(Lox;)Z
    //   30: pop
    //   31: aload_0
    //   32: getfield 31	ox:a	Lnm;
    //   35: invokevirtual 64	nm:b	()V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 31	ox:a	Lnm;
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 66	ox:b	Lnm;
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 45	ox:e	Loy;
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 68	ox:d	Loz;
    //   58: goto -44 -> 14
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	ox
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	61	finally
    //   17	58	61	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ox
 * JD-Core Version:    0.7.0.1
 */