public enum Cp
{
  static
  {
    Cp[] arrayOfCp = new Cp[2];
    arrayOfCp[0] = a;
    arrayOfCp[1] = b;
    c = arrayOfCp;
  }
  
  private Cp() {}
  
  public static Cp[] a()
  {
    return (Cp[])c.clone();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Cp
 * JD-Core Version:    0.7.0.1
 */