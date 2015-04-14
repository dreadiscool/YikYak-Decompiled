import java.net.InetSocketAddress;

public abstract class ts
  implements tu
{
  public String a(tp paramtp)
  {
    InetSocketAddress localInetSocketAddress = paramtp.a();
    if (localInetSocketAddress == null) {
      throw new tJ("socket not bound");
    }
    StringBuffer localStringBuffer = new StringBuffer(90);
    localStringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
    localStringBuffer.append(localInetSocketAddress.getPort());
    localStringBuffer.append("\" /></cross-domain-policy>��");
    return localStringBuffer.toString();
  }
  
  public ub a(tp paramtp, ty paramty, tT paramtT)
  {
    return new tX();
  }
  
  public void a(tp paramtp, tQ paramtQ)
  {
    tS localtS = new tS(paramtQ);
    localtS.a(tR.e);
    paramtp.a(localtS);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ts
 * JD-Core Version:    0.7.0.1
 */