import java.net.Proxy.Type;
import java.net.URL;

public final class AG
{
  public static String a(URL paramURL)
  {
    String str = paramURL.getFile();
    if (str == null) {
      str = "/";
    }
    for (;;)
    {
      return str;
      if (!str.startsWith("/")) {
        str = "/" + str;
      }
    }
  }
  
  public static String a(zy paramzy)
  {
    if (paramzy == zy.a) {}
    for (String str = "HTTP/1.0";; str = "HTTP/1.1") {
      return str;
    }
  }
  
  static String a(zz paramzz, Proxy.Type paramType, zy paramzy)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramzz.d());
    localStringBuilder.append(' ');
    if (a(paramzz, paramType)) {
      localStringBuilder.append(paramzz.a());
    }
    for (;;)
    {
      localStringBuilder.append(' ');
      localStringBuilder.append(a(paramzy));
      return localStringBuilder.toString();
      localStringBuilder.append(a(paramzz.a()));
    }
  }
  
  private static boolean a(zz paramzz, Proxy.Type paramType)
  {
    if ((!paramzz.i()) && (paramType == Proxy.Type.HTTP)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AG
 * JD-Core Version:    0.7.0.1
 */