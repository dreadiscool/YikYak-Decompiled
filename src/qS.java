import java.net.InetAddress;

final class qS
  extends pm<InetAddress>
{
  public InetAddress a(ro paramro)
  {
    if (paramro.f() == rq.i) {
      paramro.j();
    }
    for (InetAddress localInetAddress = null;; localInetAddress = InetAddress.getByName(paramro.h())) {
      return localInetAddress;
    }
  }
  
  public void a(rr paramrr, InetAddress paramInetAddress)
  {
    if (paramInetAddress == null) {}
    for (String str = null;; str = paramInetAddress.getHostAddress())
    {
      paramrr.b(str);
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qS
 * JD-Core Version:    0.7.0.1
 */