public enum AU
{
  static
  {
    AU[] arrayOfAU = new AU[4];
    arrayOfAU[0] = a;
    arrayOfAU[1] = b;
    arrayOfAU[2] = c;
    arrayOfAU[3] = d;
    e = arrayOfAU;
  }
  
  private AU() {}
  
  public boolean a()
  {
    if ((this == b) || (this == c)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean b()
  {
    if (this == a) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean c()
  {
    if (this == c) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean d()
  {
    if (this == b) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AU
 * JD-Core Version:    0.7.0.1
 */