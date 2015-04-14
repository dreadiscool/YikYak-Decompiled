public abstract class xX<T>
  extends xZ<T, Float>
{
  public xX(String paramString)
  {
    super(Float.class, paramString);
  }
  
  public abstract void a(T paramT, float paramFloat);
  
  public final void a(T paramT, Float paramFloat)
  {
    a(paramT, paramFloat.floatValue());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xX
 * JD-Core Version:    0.7.0.1
 */