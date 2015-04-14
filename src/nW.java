 enum nW
{
  static
  {
    nW[] arrayOfnW = new nW[3];
    arrayOfnW[0] = a;
    arrayOfnW[1] = b;
    arrayOfnW[2] = c;
    d = arrayOfnW;
  }
  
  private nW() {}
  
  public static nW[] a()
  {
    return (nW[])d.clone();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     nW
 * JD-Core Version:    0.7.0.1
 */