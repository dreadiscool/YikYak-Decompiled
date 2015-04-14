import java.io.File;
import java.nio.charset.Charset;

public abstract class zC
{
  public static zC a(zt paramzt, File paramFile)
  {
    if (paramFile == null) {
      throw new NullPointerException("content == null");
    }
    return new zE(paramzt, paramFile);
  }
  
  public static zC a(zt paramzt, String paramString)
  {
    Charset localCharset = Ae.d;
    if (paramzt != null)
    {
      localCharset = paramzt.a();
      if (localCharset == null)
      {
        localCharset = Ae.d;
        paramzt = zt.a(paramzt + "; charset=utf-8");
      }
    }
    return a(paramzt, paramString.getBytes(localCharset));
  }
  
  public static zC a(zt paramzt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("content == null");
    }
    return new zD(paramzt, paramArrayOfByte);
  }
  
  public abstract zt a();
  
  public abstract void a(LC paramLC);
  
  public long b()
  {
    return -1L;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zC
 * JD-Core Version:    0.7.0.1
 */