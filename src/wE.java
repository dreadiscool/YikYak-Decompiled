import android.util.LruCache;

class wE
  extends LruCache<Class<?>, String>
{
  public wE(int paramInt)
  {
    super(paramInt);
  }
  
  protected String a(Class<?> paramClass)
  {
    return paramClass.getCanonicalName();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wE
 * JD-Core Version:    0.7.0.1
 */