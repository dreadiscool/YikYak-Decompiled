import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.List;

public final class Ah
  implements yK
{
  public static final yK a = new Ah();
  
  private InetAddress a(Proxy paramProxy, URL paramURL)
  {
    if ((paramProxy != null) && (paramProxy.type() != Proxy.Type.DIRECT)) {}
    for (InetAddress localInetAddress = ((InetSocketAddress)paramProxy.address()).getAddress();; localInetAddress = InetAddress.getByName(paramURL.getHost())) {
      return localInetAddress;
    }
  }
  
  public zz a(Proxy paramProxy, zF paramzF)
  {
    List localList = paramzF.l();
    zz localzz1 = paramzF.a();
    URL localURL = localzz1.a();
    int i = localList.size();
    int j = 0;
    String str;
    if (j < i)
    {
      zd localzd = (zd)localList.get(j);
      if (!"Basic".equalsIgnoreCase(localzd.a())) {}
      PasswordAuthentication localPasswordAuthentication;
      do
      {
        j++;
        break;
        localPasswordAuthentication = Authenticator.requestPasswordAuthentication(localURL.getHost(), a(paramProxy, localURL), localURL.getPort(), localURL.getProtocol(), localzd.b(), localzd.a(), localURL, Authenticator.RequestorType.SERVER);
      } while (localPasswordAuthentication == null);
      str = zl.a(localPasswordAuthentication.getUserName(), new String(localPasswordAuthentication.getPassword()));
    }
    for (zz localzz2 = localzz1.g().a("Authorization", str).b();; localzz2 = null) {
      return localzz2;
    }
  }
  
  public zz b(Proxy paramProxy, zF paramzF)
  {
    List localList = paramzF.l();
    zz localzz1 = paramzF.a();
    URL localURL = localzz1.a();
    int i = localList.size();
    int j = 0;
    String str;
    if (j < i)
    {
      zd localzd = (zd)localList.get(j);
      if (!"Basic".equalsIgnoreCase(localzd.a())) {}
      PasswordAuthentication localPasswordAuthentication;
      do
      {
        j++;
        break;
        InetSocketAddress localInetSocketAddress = (InetSocketAddress)paramProxy.address();
        localPasswordAuthentication = Authenticator.requestPasswordAuthentication(localInetSocketAddress.getHostName(), a(paramProxy, localURL), localInetSocketAddress.getPort(), localURL.getProtocol(), localzd.b(), localzd.a(), localURL, Authenticator.RequestorType.PROXY);
      } while (localPasswordAuthentication == null);
      str = zl.a(localPasswordAuthentication.getUserName(), new String(localPasswordAuthentication.getPassword()));
    }
    for (zz localzz2 = localzz1.g().a("Proxy-Authorization", str).b();; localzz2 = null) {
      return localzz2;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ah
 * JD-Core Version:    0.7.0.1
 */