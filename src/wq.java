class wq
{
  private final int[] a = new int[256];
  private int b = 0;
  
  public int a(int paramInt)
  {
    return this.a[paramInt];
  }
  
  public boolean a()
  {
    if (this.a.length == this.b) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int b()
  {
    int i = this.b;
    this.b = (1 + this.b);
    this.a[i] = 0;
    return i;
  }
  
  public void b(int paramInt)
  {
    int[] arrayOfInt = this.a;
    arrayOfInt[paramInt] = (1 + arrayOfInt[paramInt]);
  }
  
  public void c()
  {
    this.b = (-1 + this.b);
    if (this.b < 0) {
      throw new ArrayIndexOutOfBoundsException(this.b);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wq
 * JD-Core Version:    0.7.0.1
 */