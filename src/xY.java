public abstract class xY<T>
  extends xZ<T, Integer>
{
  public xY(String paramString)
  {
    super(Integer.class, paramString);
  }
  
  public final void a(T paramT, Integer paramInteger)
  {
    a(paramT, Integer.valueOf(paramInteger.intValue()));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xY
 * JD-Core Version:    0.7.0.1
 */