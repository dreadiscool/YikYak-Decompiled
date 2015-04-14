import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public abstract class zI
  implements Closeable
{
  private Charset g()
  {
    zt localzt = a();
    if (localzt != null) {}
    for (Charset localCharset = localzt.a(Ae.d);; localCharset = Ae.d) {
      return localCharset;
    }
  }
  
  public abstract zt a();
  
  public abstract long b();
  
  public abstract LD c();
  
  public void close()
  {
    c().close();
  }
  
  public final InputStream d()
  {
    return c().i();
  }
  
  public final byte[] e()
  {
    long l = b();
    if (l > 2147483647L) {
      throw new IOException("Cannot buffer entire body for content length: " + l);
    }
    LD localLD = c();
    byte[] arrayOfByte;
    try
    {
      arrayOfByte = localLD.r();
      Ae.a(localLD);
      if ((l != -1L) && (l != arrayOfByte.length)) {
        throw new IOException("Content-Length and stream length disagree");
      }
    }
    finally
    {
      Ae.a(localLD);
    }
    return arrayOfByte;
  }
  
  public final String f()
  {
    return new String(e(), g().name());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zI
 * JD-Core Version:    0.7.0.1
 */