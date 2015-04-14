public final class zd
{
  private final String a;
  private final String b;
  
  public zd(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof zd)) && (Ae.a(this.a, ((zd)paramObject).a)) && (Ae.a(this.b, ((zd)paramObject).b))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    int i = 0;
    if (this.b != null) {}
    for (int j = this.b.hashCode();; j = 0)
    {
      int k = 31 * (j + 899);
      if (this.a != null) {
        i = this.a.hashCode();
      }
      return k + i;
    }
  }
  
  public String toString()
  {
    return this.a + " realm=\"" + this.b + "\"";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zd
 * JD-Core Version:    0.7.0.1
 */