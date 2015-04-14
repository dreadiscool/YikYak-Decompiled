public enum vB
{
  static
  {
    vB[] arrayOfvB = new vB[2];
    arrayOfvB[0] = a;
    arrayOfvB[1] = b;
    c = arrayOfvB;
  }
  
  private vB() {}
  
  public static vB[] a()
  {
    return (vB[])c.clone();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vB
 * JD-Core Version:    0.7.0.1
 */