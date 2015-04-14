import java.net.InetAddress;
import java.net.UnknownHostException;

final class zW
  implements zV
{
  public InetAddress[] a(String paramString)
  {
    if (paramString == null) {
      throw new UnknownHostException("host == null");
    }
    return InetAddress.getAllByName(paramString);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zW
 * JD-Core Version:    0.7.0.1
 */