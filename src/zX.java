import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class zX<T>
{
  private final Class<?> a;
  private final String b;
  private final Class[] c;
  
  public zX(Class<?> paramClass, String paramString, Class... paramVarArgs)
  {
    this.a = paramClass;
    this.b = paramString;
    this.c = paramVarArgs;
  }
  
  private Method a(Class<?> paramClass)
  {
    Object localObject = null;
    Method localMethod;
    if (this.b != null)
    {
      localMethod = a(paramClass, this.b, this.c);
      if ((localMethod == null) || (this.a == null) || (this.a.isAssignableFrom(localMethod.getReturnType()))) {
        break label49;
      }
    }
    for (;;)
    {
      return localObject;
      label49:
      localObject = localMethod;
    }
  }
  
  private static Method a(Class<?> paramClass, String paramString, Class[] paramArrayOfClass)
  {
    localObject = null;
    try
    {
      localMethod = paramClass.getMethod(paramString, paramArrayOfClass);
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      int i;
      label24:
      break label24;
    }
    try
    {
      i = localMethod.getModifiers();
      if ((i & 0x1) != 0) {
        break label39;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      localObject = localMethod;
      break label24;
      localObject = localMethod;
      break label24;
    }
    return localObject;
  }
  
  public Object a(T paramT, Object... paramVarArgs)
  {
    Object localObject1 = null;
    Method localMethod = a(paramT.getClass());
    if (localMethod == null) {}
    for (;;)
    {
      return localObject1;
      try
      {
        Object localObject2 = localMethod.invoke(paramT, paramVarArgs);
        localObject1 = localObject2;
      }
      catch (IllegalAccessException localIllegalAccessException) {}
    }
  }
  
  public boolean a(T paramT)
  {
    if (a(paramT.getClass()) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Object b(T paramT, Object... paramVarArgs)
  {
    try
    {
      Object localObject = a(paramT, paramVarArgs);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getTargetException();
      if ((localThrowable instanceof RuntimeException)) {
        throw ((RuntimeException)localThrowable);
      }
      AssertionError localAssertionError = new AssertionError("Unexpected exception");
      localAssertionError.initCause(localThrowable);
      throw localAssertionError;
    }
  }
  
  public Object c(T paramT, Object... paramVarArgs)
  {
    Method localMethod = a(paramT.getClass());
    if (localMethod == null) {
      throw new AssertionError("Method " + this.b + " not supported for object " + paramT);
    }
    try
    {
      Object localObject = localMethod.invoke(paramT, paramVarArgs);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      AssertionError localAssertionError = new AssertionError("Unexpectedly could not call: " + localMethod);
      localAssertionError.initCause(localIllegalAccessException);
      throw localAssertionError;
    }
  }
  
  public Object d(T paramT, Object... paramVarArgs)
  {
    try
    {
      Object localObject = c(paramT, paramVarArgs);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getTargetException();
      if ((localThrowable instanceof RuntimeException)) {
        throw ((RuntimeException)localThrowable);
      }
      AssertionError localAssertionError = new AssertionError("Unexpected exception");
      localAssertionError.initCause(localThrowable);
      throw localAssertionError;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zX
 * JD-Core Version:    0.7.0.1
 */