 enum eA
{
  static
  {
    eA[] arrayOfeA = new eA[7];
    arrayOfeA[0] = a;
    arrayOfeA[1] = b;
    arrayOfeA[2] = c;
    arrayOfeA[3] = d;
    arrayOfeA[4] = e;
    arrayOfeA[5] = f;
    arrayOfeA[6] = g;
    h = arrayOfeA;
  }
  
  private eA() {}
  
  public static eA[] a()
  {
    return (eA[])h.clone();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     eA
 * JD-Core Version:    0.7.0.1
 */