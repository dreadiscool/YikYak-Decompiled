class IV
{
  public final String a;
  public final boolean b;
  
  IV(String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {}
    IV localIV;
    do
    {
      for (;;)
      {
        return bool;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
        {
          bool = false;
        }
        else
        {
          localIV = (IV)paramObject;
          if (this.b == localIV.b) {
            break;
          }
          bool = false;
        }
      }
      if (this.a == null) {
        break;
      }
    } while (this.a.equals(localIV.a));
    for (;;)
    {
      bool = false;
      break;
      if (localIV.a == null) {
        break;
      }
    }
  }
  
  public int hashCode()
  {
    int i = 0;
    if (this.a != null) {}
    for (int j = this.a.hashCode();; j = 0)
    {
      int k = j * 31;
      if (this.b) {
        i = 1;
      }
      return k + i;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     IV
 * JD-Core Version:    0.7.0.1
 */