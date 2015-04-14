class sN
  implements sa
{
  int a;
  private final sM c;
  private sa d;
  
  private sN(sJ paramsJ)
  {
    this.c = new sM(paramsJ, null);
    this.d = this.c.a().c();
    this.a = paramsJ.a();
  }
  
  public Byte a()
  {
    return Byte.valueOf(b());
  }
  
  public byte b()
  {
    if (!this.d.hasNext()) {
      this.d = this.c.a().c();
    }
    this.a = (-1 + this.a);
    return this.d.b();
  }
  
  public boolean hasNext()
  {
    if (this.a > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sN
 * JD-Core Version:    0.7.0.1
 */