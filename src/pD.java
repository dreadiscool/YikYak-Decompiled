import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class pD
  implements pW<T>
{
  pD(px parampx, Constructor paramConstructor) {}
  
  public T a()
  {
    try
    {
      Object localObject = this.a.newInstance(null);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException("Failed to invoke " + this.a + " with no args", localInstantiationException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException("Failed to invoke " + this.a + " with no args", localInvocationTargetException.getTargetException());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pD
 * JD-Core Version:    0.7.0.1
 */