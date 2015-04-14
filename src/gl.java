class gl
  implements fr
{
  private int a = 2;
  
  private String e(String paramString)
  {
    return Thread.currentThread().toString() + ": " + paramString;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(String paramString)
  {
    if (this.a <= 0) {
      e(paramString);
    }
  }
  
  public void b(String paramString)
  {
    if (this.a <= 1) {
      e(paramString);
    }
  }
  
  public void c(String paramString)
  {
    if (this.a <= 2) {
      e(paramString);
    }
  }
  
  public void d(String paramString)
  {
    if (this.a <= 3) {
      e(paramString);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gl
 * JD-Core Version:    0.7.0.1
 */