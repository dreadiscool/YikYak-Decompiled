public final class AT
{
  public static final LE a = LE.a(":status");
  public static final LE b = LE.a(":method");
  public static final LE c = LE.a(":path");
  public static final LE d = LE.a(":scheme");
  public static final LE e = LE.a(":authority");
  public static final LE f = LE.a(":host");
  public static final LE g = LE.a(":version");
  public final LE h;
  public final LE i;
  final int j;
  
  public AT(LE paramLE1, LE paramLE2)
  {
    this.h = paramLE1;
    this.i = paramLE2;
    this.j = (32 + paramLE1.e() + paramLE2.e());
  }
  
  public AT(LE paramLE, String paramString)
  {
    this(paramLE, LE.a(paramString));
  }
  
  public AT(String paramString1, String paramString2)
  {
    this(LE.a(paramString1), LE.a(paramString2));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof AT))
    {
      AT localAT = (AT)paramObject;
      if ((this.h.equals(localAT.h)) && (this.i.equals(localAT.i))) {
        bool = true;
      }
    }
    return bool;
  }
  
  public int hashCode()
  {
    return 31 * (527 + this.h.hashCode()) + this.i.hashCode();
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.h.a();
    arrayOfObject[1] = this.i.a();
    return String.format("%s: %s", arrayOfObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AT
 * JD-Core Version:    0.7.0.1
 */