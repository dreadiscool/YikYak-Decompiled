public enum fY
{
  static
  {
    fY[] arrayOffY = new fY[6];
    arrayOffY[0] = a;
    arrayOffY[1] = b;
    arrayOffY[2] = c;
    arrayOffY[3] = d;
    arrayOffY[4] = e;
    arrayOffY[5] = f;
    g = arrayOffY;
  }
  
  private fY() {}
  
  public static fY[] a()
  {
    return (fY[])g.clone();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fY
 * JD-Core Version:    0.7.0.1
 */