public enum Hr
{
  private int i;
  
  static
  {
    Hr[] arrayOfHr = new Hr[8];
    arrayOfHr[0] = a;
    arrayOfHr[1] = b;
    arrayOfHr[2] = c;
    arrayOfHr[3] = d;
    arrayOfHr[4] = e;
    arrayOfHr[5] = f;
    arrayOfHr[6] = g;
    arrayOfHr[7] = h;
    j = arrayOfHr;
  }
  
  private Hr(int paramInt)
  {
    this.i = paramInt;
  }
  
  public static Hr a(int paramInt)
  {
    Hr[] arrayOfHr = a();
    int k = arrayOfHr.length;
    int m = 0;
    Hr localHr;
    if (m < k)
    {
      localHr = arrayOfHr[m];
      if (localHr.i != paramInt) {}
    }
    for (;;)
    {
      return localHr;
      m++;
      break;
      localHr = a;
    }
  }
  
  public static Hr[] a()
  {
    return (Hr[])j.clone();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Hr
 * JD-Core Version:    0.7.0.1
 */