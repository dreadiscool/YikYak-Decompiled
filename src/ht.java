public final class ht
{
  public final int a;
  public final int b;
  
  public ht(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof ht)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (this != paramObject)
      {
        ht localht = (ht)paramObject;
        if ((localht.a != this.a) || (localht.b != this.b)) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = Integer.valueOf(this.b);
    return hV.a(arrayOfObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ht
 * JD-Core Version:    0.7.0.1
 */