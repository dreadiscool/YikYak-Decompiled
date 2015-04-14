final class aF
  extends aE
{
  private final aE[] a;
  
  public aF(aE... paramVarArgs)
  {
    super(0, new aE[0]);
    this.a = paramVarArgs;
  }
  
  public int b()
  {
    int i = 0;
    aE[] arrayOfaE = this.a;
    int j = arrayOfaE.length;
    int k = 0;
    while (i < j)
    {
      k += arrayOfaE[i].b();
      i++;
    }
    return k;
  }
  
  public void b(E paramE)
  {
    aE[] arrayOfaE = this.a;
    int i = arrayOfaE.length;
    for (int j = 0; j < i; j++) {
      arrayOfaE[j].b(paramE);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     aF
 * JD-Core Version:    0.7.0.1
 */