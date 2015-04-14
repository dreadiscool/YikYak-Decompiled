public enum uF
{
  static
  {
    uF[] arrayOfuF = new uF[3];
    arrayOfuF[0] = a;
    arrayOfuF[1] = b;
    arrayOfuF[2] = c;
    d = arrayOfuF;
  }
  
  private uF() {}
  
  public static uF[] a()
  {
    return (uF[])d.clone();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     uF
 * JD-Core Version:    0.7.0.1
 */