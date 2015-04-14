public enum JN
{
  static
  {
    JN[] arrayOfJN = new JN[3];
    arrayOfJN[0] = a;
    arrayOfJN[1] = b;
    arrayOfJN[2] = c;
    d = arrayOfJN;
  }
  
  private JN() {}
  
  public static JN[] a()
  {
    return (JN[])d.clone();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     JN
 * JD-Core Version:    0.7.0.1
 */