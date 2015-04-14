public enum gg
{
  static
  {
    gg[] arrayOfgg = new gg[2];
    arrayOfgg[0] = a;
    arrayOfgg[1] = b;
    c = arrayOfgg;
  }
  
  private gg() {}
  
  public static gg[] a()
  {
    return (gg[])c.clone();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gg
 * JD-Core Version:    0.7.0.1
 */