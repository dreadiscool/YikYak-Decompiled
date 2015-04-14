public enum KB
{
  static
  {
    KB[] arrayOfKB = new KB[4];
    arrayOfKB[0] = a;
    arrayOfKB[1] = b;
    arrayOfKB[2] = c;
    arrayOfKB[3] = d;
    e = arrayOfKB;
  }
  
  private KB() {}
  
  public static KB[] a()
  {
    return (KB[])e.clone();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     KB
 * JD-Core Version:    0.7.0.1
 */