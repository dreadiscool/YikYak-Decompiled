final class LT
{
  static final LT a = new LT();
  long b;
  private LS c;
  
  LS a()
  {
    LS localLS;
    try
    {
      if (this.c != null)
      {
        localLS = this.c;
        this.c = localLS.d;
        localLS.d = null;
        this.b -= 2048L;
      }
      else
      {
        localLS = new LS();
      }
    }
    finally {}
    return localLS;
  }
  
  void a(LS paramLS)
  {
    if ((paramLS.d != null) || (paramLS.e != null)) {
      throw new IllegalArgumentException();
    }
    try
    {
      if (2048L + this.b > 65536L) {
        return;
      }
      this.b = (2048L + this.b);
      paramLS.d = this.c;
      paramLS.c = 0;
      paramLS.b = 0;
      this.c = paramLS;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LT
 * JD-Core Version:    0.7.0.1
 */