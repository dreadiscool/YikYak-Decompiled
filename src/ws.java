class ws
{
  public final String a;
  public final Class<?> b;
  public final vU c;
  private final String d;
  
  public ws(String paramString1, Class<?> paramClass, vU paramvU, String paramString2)
  {
    this.a = paramString1;
    this.b = paramClass;
    this.c = paramvU;
    this.d = paramString2;
  }
  
  public vU a(Object[] paramArrayOfObject)
  {
    if (this.d == null) {}
    for (vU localvU = null;; localvU = new vU(this.b, this.d, paramArrayOfObject, Void.TYPE)) {
      return localvU;
    }
  }
  
  public String toString()
  {
    return "[PropertyDescription " + this.a + "," + this.b + ", " + this.c + "/" + this.d + "]";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ws
 * JD-Core Version:    0.7.0.1
 */