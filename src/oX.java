class oX<T>
  extends pm<T>
{
  private pm<T> a;
  
  public void a(pm<T> parampm)
  {
    if (this.a != null) {
      throw new AssertionError();
    }
    this.a = parampm;
  }
  
  public void a(rr paramrr, T paramT)
  {
    if (this.a == null) {
      throw new IllegalStateException();
    }
    this.a.a(paramrr, paramT);
  }
  
  public T b(ro paramro)
  {
    if (this.a == null) {
      throw new IllegalStateException();
    }
    return this.a.b(paramro);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     oX
 * JD-Core Version:    0.7.0.1
 */