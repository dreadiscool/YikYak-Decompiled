public enum Hi
{
  static
  {
    Hi[] arrayOfHi = new Hi[3];
    arrayOfHi[0] = a;
    arrayOfHi[1] = b;
    arrayOfHi[2] = c;
    d = arrayOfHi;
  }
  
  private Hi() {}
  
  public static Hi[] a()
  {
    return (Hi[])d.clone();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Hi
 * JD-Core Version:    0.7.0.1
 */