import java.lang.reflect.Method;

final class qe
  extends qc
{
  qe(Method paramMethod) {}
  
  public <T> T a(Class<T> paramClass)
  {
    Method localMethod = this.a;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramClass;
    arrayOfObject[1] = Object.class;
    return localMethod.invoke(null, arrayOfObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qe
 * JD-Core Version:    0.7.0.1
 */