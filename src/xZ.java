public abstract class xZ<T, V>
{
  private final String a;
  private final Class<V> b;
  
  public xZ(Class<V> paramClass, String paramString)
  {
    this.a = paramString;
    this.b = paramClass;
  }
  
  public abstract V a(T paramT);
  
  public String a()
  {
    return this.a;
  }
  
  public void a(T paramT, V paramV)
  {
    throw new UnsupportedOperationException("Property " + a() + " is read-only");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xZ
 * JD-Core Version:    0.7.0.1
 */