import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class xM
  implements Cloneable
{
  private static final xP i = new xs();
  private static final xP j = new xq();
  private static Class[] k;
  private static Class[] l;
  private static Class[] m;
  private static final HashMap<Class, HashMap<String, Method>> n = new HashMap();
  private static final HashMap<Class, HashMap<String, Method>> o = new HashMap();
  String a;
  protected xZ b;
  Method c = null;
  Class d;
  xv e = null;
  final ReentrantReadWriteLock f = new ReentrantReadWriteLock();
  final Object[] g = new Object[1];
  private Method h = null;
  private xP p;
  private Object q;
  
  static
  {
    Class[] arrayOfClass1 = new Class[6];
    arrayOfClass1[0] = Float.TYPE;
    arrayOfClass1[1] = Float.class;
    arrayOfClass1[2] = Double.TYPE;
    arrayOfClass1[3] = Integer.TYPE;
    arrayOfClass1[4] = Double.class;
    arrayOfClass1[5] = Integer.class;
    k = arrayOfClass1;
    Class[] arrayOfClass2 = new Class[6];
    arrayOfClass2[0] = Integer.TYPE;
    arrayOfClass2[1] = Integer.class;
    arrayOfClass2[2] = Float.TYPE;
    arrayOfClass2[3] = Double.TYPE;
    arrayOfClass2[4] = Float.class;
    arrayOfClass2[5] = Double.class;
    l = arrayOfClass2;
    Class[] arrayOfClass3 = new Class[6];
    arrayOfClass3[0] = Double.TYPE;
    arrayOfClass3[1] = Double.class;
    arrayOfClass3[2] = Float.TYPE;
    arrayOfClass3[3] = Integer.TYPE;
    arrayOfClass3[4] = Float.class;
    arrayOfClass3[5] = Integer.class;
    m = arrayOfClass3;
  }
  
  private xM(String paramString)
  {
    this.a = paramString;
  }
  
  private xM(xZ paramxZ)
  {
    this.b = paramxZ;
    if (paramxZ != null) {
      this.a = paramxZ.a();
    }
  }
  
  static String a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() == 0)) {}
    for (;;)
    {
      return paramString1;
      char c1 = Character.toUpperCase(paramString2.charAt(0));
      String str = paramString2.substring(1);
      paramString1 = paramString1 + c1 + str;
    }
  }
  
  private Method a(Class paramClass1, String paramString, Class paramClass2)
  {
    Method localMethod1 = null;
    String str = a(paramString, this.a);
    if (paramClass2 == null) {}
    for (;;)
    {
      try
      {
        Method localMethod3 = paramClass1.getMethod(str, null);
        localObject = localMethod3;
        return localObject;
      }
      catch (NoSuchMethodException localNoSuchMethodException3) {}
      try
      {
        Method localMethod2 = paramClass1.getDeclaredMethod(str, null);
        localObject = localMethod2;
        try
        {
          ((Method)localObject).setAccessible(true);
        }
        catch (NoSuchMethodException localNoSuchMethodException5) {}
      }
      catch (NoSuchMethodException localNoSuchMethodException4)
      {
        for (;;)
        {
          Class[] arrayOfClass1;
          Class[] arrayOfClass2;
          int i1;
          int i2;
          localObject = null;
        }
      }
      new StringBuilder().append("Couldn't find no-arg method for property ").append(this.a).append(": ").append(localNoSuchMethodException3).toString();
      continue;
      arrayOfClass1 = new Class[1];
      if (this.d.equals(Float.class))
      {
        arrayOfClass2 = k;
        label118:
        i1 = arrayOfClass2.length;
        i2 = 0;
      }
      for (;;)
      {
        for (;;)
        {
          if (i2 >= i1) {
            break label265;
          }
          Class localClass = arrayOfClass2[i2];
          arrayOfClass1[0] = localClass;
          try
          {
            localMethod1 = paramClass1.getMethod(str, arrayOfClass1);
            this.d = localClass;
            localObject = localMethod1;
            break;
            if (this.d.equals(Integer.class))
            {
              arrayOfClass2 = l;
              break label118;
            }
            if (this.d.equals(Double.class))
            {
              arrayOfClass2 = m;
              break label118;
            }
            arrayOfClass2 = new Class[1];
            arrayOfClass2[0] = this.d;
          }
          catch (NoSuchMethodException localNoSuchMethodException1)
          {
            try
            {
              localMethod1 = paramClass1.getDeclaredMethod(str, arrayOfClass1);
              localMethod1.setAccessible(true);
              this.d = localClass;
              localObject = localMethod1;
            }
            catch (NoSuchMethodException localNoSuchMethodException2)
            {
              i2++;
            }
          }
        }
      }
      label265:
      new StringBuilder().append("Couldn't find setter/getter for property ").append(this.a).append(" with value type ").append(this.d).toString();
      localObject = localMethod1;
    }
  }
  
  private Method a(Class paramClass1, HashMap<Class, HashMap<String, Method>> paramHashMap, String paramString, Class paramClass2)
  {
    Method localMethod1 = null;
    try
    {
      this.f.writeLock().lock();
      HashMap localHashMap = (HashMap)paramHashMap.get(paramClass1);
      if (localHashMap != null) {
        localMethod1 = (Method)localHashMap.get(this.a);
      }
      if (localMethod1 == null)
      {
        localMethod1 = a(paramClass1, paramString, paramClass2);
        if (localHashMap == null)
        {
          localHashMap = new HashMap();
          paramHashMap.put(paramClass1, localHashMap);
        }
        localHashMap.put(this.a, localMethod1);
      }
      Method localMethod2 = localMethod1;
      return localMethod2;
    }
    finally
    {
      this.f.writeLock().unlock();
    }
  }
  
  public static xM a(String paramString, float... paramVarArgs)
  {
    return new xO(paramString, paramVarArgs);
  }
  
  public static xM a(xZ<?, Float> paramxZ, float... paramVarArgs)
  {
    return new xO(paramxZ, paramVarArgs);
  }
  
  private void b(Class paramClass)
  {
    this.h = a(paramClass, o, "get", null);
  }
  
  public xM a()
  {
    try
    {
      localxM = (xM)super.clone();
      localxM.a = this.a;
      localxM.b = this.b;
      localxM.e = this.e.b();
      localxM.p = this.p;
      return localxM;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        xM localxM = null;
      }
    }
  }
  
  void a(float paramFloat)
  {
    this.q = this.e.a(paramFloat);
  }
  
  void a(Class paramClass)
  {
    this.c = a(paramClass, n, "set", this.d);
  }
  
  void a(Object paramObject)
  {
    if (this.b != null)
    {
      try
      {
        this.b.a(paramObject);
        Iterator localIterator2 = this.e.e.iterator();
        while (localIterator2.hasNext())
        {
          xt localxt2 = (xt)localIterator2.next();
          if (!localxt2.a()) {
            localxt2.a(this.b.a(paramObject));
          }
        }
        localClass = paramObject.getClass();
      }
      catch (ClassCastException localClassCastException)
      {
        new StringBuilder().append("No such property (").append(this.b.a()).append(") on target object ").append(paramObject).append(". Trying reflection instead").toString();
        this.b = null;
      }
    }
    else
    {
      Class localClass;
      if (this.c == null) {
        a(localClass);
      }
      Iterator localIterator1 = this.e.e.iterator();
      while (localIterator1.hasNext())
      {
        xt localxt1 = (xt)localIterator1.next();
        if (!localxt1.a())
        {
          if (this.h == null) {
            b(localClass);
          }
          try
          {
            localxt1.a(this.h.invoke(paramObject, new Object[0]));
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            localInvocationTargetException.toString();
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            localIllegalAccessException.toString();
          }
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(xP paramxP)
  {
    this.p = paramxP;
    this.e.a(paramxP);
  }
  
  public void a(xZ paramxZ)
  {
    this.b = paramxZ;
  }
  
  public void a(float... paramVarArgs)
  {
    this.d = Float.TYPE;
    this.e = xv.a(paramVarArgs);
  }
  
  void b()
  {
    xP localxP;
    if (this.p == null)
    {
      if (this.d != Integer.class) {
        break label44;
      }
      localxP = i;
    }
    for (;;)
    {
      this.p = localxP;
      if (this.p != null) {
        this.e.a(this.p);
      }
      return;
      label44:
      if (this.d == Float.class) {
        localxP = j;
      } else {
        localxP = null;
      }
    }
  }
  
  void b(Object paramObject)
  {
    if (this.b != null) {
      this.b.a(paramObject, d());
    }
    if (this.c != null) {}
    try
    {
      this.g[0] = d();
      this.c.invoke(paramObject, this.g);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        localInvocationTargetException.toString();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.toString();
      }
    }
  }
  
  public String c()
  {
    return this.a;
  }
  
  Object d()
  {
    return this.q;
  }
  
  public String toString()
  {
    return this.a + ": " + this.e.toString();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xM
 * JD-Core Version:    0.7.0.1
 */