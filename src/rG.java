 enum rG
{
  static
  {
    rG[] arrayOfrG = new rG[3];
    arrayOfrG[0] = a;
    arrayOfrG[1] = b;
    arrayOfrG[2] = c;
    d = arrayOfrG;
  }
  
  private rG() {}
  
  public static rG[] a()
  {
    return (rG[])d.clone();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     rG
 * JD-Core Version:    0.7.0.1
 */