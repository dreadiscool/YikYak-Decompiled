import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public final class LK
{
  private static final Logger a = Logger.getLogger(LK.class.getName());
  
  public static LC a(LU paramLU)
  {
    if (paramLU == null) {
      throw new IllegalArgumentException("sink == null");
    }
    return new LO(paramLU);
  }
  
  public static LD a(LV paramLV)
  {
    if (paramLV == null) {
      throw new IllegalArgumentException("source == null");
    }
    return new LQ(paramLV);
  }
  
  public static LU a(OutputStream paramOutputStream)
  {
    return a(paramOutputStream, new LW());
  }
  
  private static LU a(OutputStream paramOutputStream, LW paramLW)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    if (paramLW == null) {
      throw new IllegalArgumentException("timeout == null");
    }
    return new LL(paramLW, paramOutputStream);
  }
  
  public static LU a(Socket paramSocket)
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("socket == null");
    }
    Lu localLu = c(paramSocket);
    return localLu.a(a(paramSocket.getOutputStream(), localLu));
  }
  
  public static LV a(File paramFile)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("file == null");
    }
    return a(new FileInputStream(paramFile));
  }
  
  public static LV a(InputStream paramInputStream)
  {
    return a(paramInputStream, new LW());
  }
  
  private static LV a(InputStream paramInputStream, LW paramLW)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("in == null");
    }
    if (paramLW == null) {
      throw new IllegalArgumentException("timeout == null");
    }
    return new LM(paramLW, paramInputStream);
  }
  
  public static LU b(File paramFile)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("file == null");
    }
    return a(new FileOutputStream(paramFile));
  }
  
  public static LV b(Socket paramSocket)
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("socket == null");
    }
    Lu localLu = c(paramSocket);
    return localLu.a(a(paramSocket.getInputStream(), localLu));
  }
  
  public static LU c(File paramFile)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("file == null");
    }
    return a(new FileOutputStream(paramFile, true));
  }
  
  private static Lu c(Socket paramSocket)
  {
    return new LN(paramSocket);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LK
 * JD-Core Version:    0.7.0.1
 */