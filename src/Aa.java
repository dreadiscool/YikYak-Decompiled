import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLSocket;

class Aa
  extends zY
{
  private static final zX<Socket> a;
  private static final zX<Socket> b;
  private static final zX<Socket> c;
  private static final zX<Socket> d;
  private final Method e;
  private final Method f;
  
  static
  {
    Class[] arrayOfClass1 = new Class[1];
    arrayOfClass1[0] = Boolean.TYPE;
    a = new zX(null, "setUseSessionTickets", arrayOfClass1);
    Class[] arrayOfClass2 = new Class[1];
    arrayOfClass2[0] = String.class;
    b = new zX(null, "setHostname", arrayOfClass2);
    c = new zX([B.class, "getAlpnSelectedProtocol", new Class[0]);
    Class[] arrayOfClass3 = new Class[1];
    arrayOfClass3[0] = [B.class;
    d = new zX(null, "setAlpnProtocols", arrayOfClass3);
  }
  
  private Aa(Method paramMethod1, Method paramMethod2)
  {
    this.e = paramMethod1;
    this.f = paramMethod2;
  }
  
  public void a(Socket paramSocket)
  {
    if (this.e == null) {}
    for (;;)
    {
      return;
      try
      {
        Method localMethod = this.e;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramSocket;
        localMethod.invoke(null, arrayOfObject);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException(localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException(localInvocationTargetException.getCause());
      }
    }
  }
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    try
    {
      paramSocket.connect(paramInetSocketAddress, paramInt);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      IOException localIOException = new IOException("Exception in connect");
      localIOException.initCause(localSecurityException);
      throw localIOException;
    }
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<zy> paramList)
  {
    if (paramString != null)
    {
      zX localzX1 = a;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Boolean.valueOf(true);
      localzX1.b(paramSSLSocket, arrayOfObject2);
      zX localzX2 = b;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = paramString;
      localzX2.b(paramSSLSocket, arrayOfObject3);
    }
    if (!d.a(paramSSLSocket)) {}
    for (;;)
    {
      return;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = a(paramList);
      d.d(paramSSLSocket, arrayOfObject1);
    }
  }
  
  public String b(SSLSocket paramSSLSocket)
  {
    String str;
    if (!c.a(paramSSLSocket)) {
      str = null;
    }
    for (;;)
    {
      return str;
      byte[] arrayOfByte = (byte[])c.d(paramSSLSocket, new Object[0]);
      if (arrayOfByte != null) {
        str = new String(arrayOfByte, Ae.d);
      } else {
        str = null;
      }
    }
  }
  
  public void b(Socket paramSocket)
  {
    if (this.f == null) {}
    for (;;)
    {
      return;
      try
      {
        Method localMethod = this.f;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramSocket;
        localMethod.invoke(null, arrayOfObject);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException(localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException(localInvocationTargetException.getCause());
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Aa
 * JD-Core Version:    0.7.0.1
 */