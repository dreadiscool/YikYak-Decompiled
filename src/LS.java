final class LS
{
  final byte[] a = new byte[2048];
  int b;
  int c;
  LS d;
  LS e;
  
  public LS a()
  {
    if (this.d != this) {}
    for (LS localLS = this.d;; localLS = null)
    {
      this.e.d = this.d;
      this.d.e = this.e;
      this.d = null;
      this.e = null;
      return localLS;
    }
  }
  
  public LS a(int paramInt)
  {
    int i = this.c - this.b - paramInt;
    if ((paramInt <= 0) || (i <= 0)) {
      throw new IllegalArgumentException();
    }
    if (paramInt < i)
    {
      LS localLS2 = LT.a.a();
      System.arraycopy(this.a, this.b, localLS2.a, localLS2.b, paramInt);
      this.b = (paramInt + this.b);
      localLS2.c = (paramInt + localLS2.c);
      this.e.a(localLS2);
      this = localLS2;
    }
    for (;;)
    {
      return this;
      LS localLS1 = LT.a.a();
      System.arraycopy(this.a, paramInt + this.b, localLS1.a, localLS1.b, i);
      this.c -= i;
      localLS1.c = (i + localLS1.c);
      a(localLS1);
    }
  }
  
  public LS a(LS paramLS)
  {
    paramLS.e = this;
    paramLS.d = this.d;
    this.d.e = paramLS;
    this.d = paramLS;
    return paramLS;
  }
  
  public void a(LS paramLS, int paramInt)
  {
    if (paramInt + (paramLS.c - paramLS.b) > 2048) {
      throw new IllegalArgumentException();
    }
    if (paramInt + paramLS.c > 2048)
    {
      System.arraycopy(paramLS.a, paramLS.b, paramLS.a, 0, paramLS.c - paramLS.b);
      paramLS.c -= paramLS.b;
      paramLS.b = 0;
    }
    System.arraycopy(this.a, this.b, paramLS.a, paramLS.c, paramInt);
    paramLS.c = (paramInt + paramLS.c);
    this.b = (paramInt + this.b);
  }
  
  public void b()
  {
    if (this.e == this) {
      throw new IllegalStateException();
    }
    if (this.e.c - this.e.b + (this.c - this.b) > 2048) {}
    for (;;)
    {
      return;
      a(this.e, this.c - this.b);
      a();
      LT.a.a(this);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LS
 * JD-Core Version:    0.7.0.1
 */