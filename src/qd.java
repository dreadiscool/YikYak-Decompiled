import java.lang.reflect.Method;

final class qd
  extends qc
{
  qd(Method paramMethod, Object paramObject) {}
  
  public <T> T a(Class<T> paramClass)
  {
    Method localMethod = this.a;
    Object localObject = this.b;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramClass;
    return localMethod.invoke(localObject, arrayOfObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qd
 * JD-Core Version:    0.7.0.1
 */