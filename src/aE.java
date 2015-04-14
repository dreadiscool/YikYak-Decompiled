abstract class aE
{
  private final int a;
  private final aE[] b;
  
  public aE(int paramInt, aE... paramVarArgs)
  {
    this.a = paramInt;
    if (paramVarArgs != null) {}
    for (;;)
    {
      this.b = paramVarArgs;
      return;
      paramVarArgs = aw.a();
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a(E paramE) {}
  
  public int b()
  {
    int i = c();
    return i + E.l(i) + E.j(this.a);
  }
  
  public void b(E paramE)
  {
    paramE.i(this.a, 2);
    paramE.k(c());
    a(paramE);
    aE[] arrayOfaE = this.b;
    int i = arrayOfaE.length;
    for (int j = 0; j < i; j++) {
      arrayOfaE[j].b(paramE);
    }
  }
  
  public int c()
  {
    int i = a();
    aE[] arrayOfaE = this.b;
    int j = arrayOfaE.length;
    for (int k = 0; k < j; k++) {
      i += arrayOfaE[k].b();
    }
    return i;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     aE
 * JD-Core Version:    0.7.0.1
 */