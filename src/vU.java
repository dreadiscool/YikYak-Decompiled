import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class vU
{
  private final String a;
  private final Object[] b;
  private final Class<?>[] c;
  private final Class<?> d;
  private final Class<?> e;
  private final Method f;
  
  public vU(Class<?> paramClass1, String paramString, Object[] paramArrayOfObject, Class<?> paramClass2)
  {
    this.a = paramString;
    this.b = paramArrayOfObject;
    this.d = paramClass2;
    this.c = new Class[this.b.length];
    for (int i = 0; i < this.b.length; i++) {
      this.c[i] = this.b[i].getClass();
    }
    this.f = b(paramClass1);
    if (this.f == null) {
      throw new NoSuchMethodException("Method " + paramClass1.getName() + "." + this.a + " doesn't exit");
    }
    this.e = this.f.getDeclaringClass();
  }
  
  private static Class<?> a(Class<?> paramClass)
  {
    if (paramClass == Integer.class) {
      paramClass = Integer.TYPE;
    }
    for (;;)
    {
      return paramClass;
      if (paramClass == Float.class) {
        paramClass = Float.TYPE;
      } else if (paramClass == Double.class) {
        paramClass = Double.TYPE;
      } else if (paramClass == Boolean.class) {
        paramClass = Boolean.TYPE;
      }
    }
  }
  
  private Method b(Class<?> paramClass)
  {
    Method[] arrayOfMethod = paramClass.getMethods();
    int i = arrayOfMethod.length;
    int j = 0;
    Method localMethod2;
    if (j < i)
    {
      localMethod2 = arrayOfMethod[j];
      String str = localMethod2.getName();
      Class[] arrayOfClass = localMethod2.getParameterTypes();
      if ((!str.equals(this.a)) || (arrayOfClass.length != this.b.length)) {}
      boolean bool;
      do
      {
        do
        {
          j++;
          break;
        } while (!a(this.d).isAssignableFrom(a(localMethod2.getReturnType())));
        bool = true;
        for (int k = 0; (k < arrayOfClass.length) && (bool); k++)
        {
          Class localClass = a(this.c[k]);
          bool = a(arrayOfClass[k]).isAssignableFrom(localClass);
        }
      } while (!bool);
    }
    for (Method localMethod1 = localMethod2;; localMethod1 = null) {
      return localMethod1;
    }
  }
  
  public Object a(View paramView)
  {
    Class localClass = paramView.getClass();
    if (this.e.isAssignableFrom(localClass)) {}
    try
    {
      Object localObject2 = this.f.invoke(paramView, this.b);
      localObject1 = localObject2;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        new StringBuilder().append("Method ").append(this.f.getName()).append(" appears not to be public").toString();
        Object localObject1 = null;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        new StringBuilder().append("Method ").append(this.f.getName()).append(" threw an exception").toString();
      }
    }
    return localObject1;
  }
  
  public Object[] a()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "[Caller " + this.a + "(" + this.b + ")" + "]";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vU
 * JD-Core Version:    0.7.0.1
 */