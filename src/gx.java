 enum gx
{
  static
  {
    gx[] arrayOfgx = new gx[7];
    arrayOfgx[0] = a;
    arrayOfgx[1] = b;
    arrayOfgx[2] = c;
    arrayOfgx[3] = d;
    arrayOfgx[4] = e;
    arrayOfgx[5] = f;
    arrayOfgx[6] = g;
    h = arrayOfgx;
  }
  
  private gx() {}
  
  public static gx[] a()
  {
    return (gx[])h.clone();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gx
 * JD-Core Version:    0.7.0.1
 */