import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

class Ab
  extends zY
{
  private final Method a;
  private final Method b;
  private final Method c;
  private final Class<?> d;
  private final Class<?> e;
  
  public Ab(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2)
  {
    this.a = paramMethod1;
    this.b = paramMethod2;
    this.c = paramMethod3;
    this.d = paramClass1;
    this.e = paramClass2;
  }
  
  public void a(SSLSocket paramSSLSocket)
  {
    try
    {
      Method localMethod = this.c;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramSSLSocket;
      localMethod.invoke(null, arrayOfObject);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError();
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new AssertionError();
    }
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<zy> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = paramList.size();
    int j = 0;
    if (j < i)
    {
      zy localzy = (zy)paramList.get(j);
      if (localzy == zy.a) {}
      for (;;)
      {
        j++;
        break;
        localArrayList.add(localzy.toString());
      }
    }
    try
    {
      ClassLoader localClassLoader = zY.class.getClassLoader();
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = this.d;
      arrayOfClass[1] = this.e;
      Object localObject = Proxy.newProxyInstance(localClassLoader, arrayOfClass, new Ac(localArrayList));
      Method localMethod = this.a;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramSSLSocket;
      arrayOfObject[1] = localObject;
      localMethod.invoke(null, arrayOfObject);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new AssertionError(localInvocationTargetException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
  }
  
  public String b(SSLSocket paramSSLSocket)
  {
    Object localObject1 = null;
    Object localObject2;
    try
    {
      Method localMethod = this.b;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramSSLSocket;
      Ac localAc = (Ac)Proxy.getInvocationHandler(localMethod.invoke(null, arrayOfObject));
      if ((!Ac.a(localAc)) && (Ac.b(localAc) == null))
      {
        zS.a.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
      }
      else if (Ac.a(localAc))
      {
        localObject2 = null;
      }
      else
      {
        String str = Ac.b(localAc);
        localObject2 = str;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new AssertionError();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError();
    }
    for (;;)
    {
      return localObject1;
      localObject1 = localObject2;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ab
 * JD-Core Version:    0.7.0.1
 */