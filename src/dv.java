public enum dv
  implements sv
{
  private static sw<dv> d = new dw();
  private final int e;
  
  static
  {
    dv[] arrayOfdv = new dv[3];
    arrayOfdv[0] = a;
    arrayOfdv[1] = b;
    arrayOfdv[2] = c;
    f = arrayOfdv;
  }
  
  private dv(int paramInt1, int paramInt2)
  {
    this.e = paramInt2;
  }
  
  public static dv a(int paramInt)
  {
    dv localdv;
    switch (paramInt)
    {
    default: 
      localdv = null;
    }
    for (;;)
    {
      return localdv;
      localdv = a;
      continue;
      localdv = b;
      continue;
      localdv = c;
    }
  }
  
  public final int a()
  {
    return this.e;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     dv
 * JD-Core Version:    0.7.0.1
 */