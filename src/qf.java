import java.lang.reflect.Method;

final class qf
  extends qc
{
  qf(Method paramMethod, int paramInt) {}
  
  public <T> T a(Class<T> paramClass)
  {
    Method localMethod = this.a;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramClass;
    arrayOfObject[1] = Integer.valueOf(this.b);
    return localMethod.invoke(null, arrayOfObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qf
 * JD-Core Version:    0.7.0.1
 */