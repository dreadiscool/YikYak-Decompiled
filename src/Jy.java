class Jy
{
  static final Jy a = new Jy(0, 0);
  final int b;
  final int c;
  
  Jy(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "[" + "position = " + this.b + ", length = " + this.c + "]";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Jy
 * JD-Core Version:    0.7.0.1
 */