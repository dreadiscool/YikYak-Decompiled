import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

public class su
{
  public static final byte[] a = new byte[0];
  public static final ByteBuffer b = ByteBuffer.wrap(a);
  
  public static int a(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }
  
  public static int a(List<? extends sv> paramList)
  {
    Iterator localIterator = paramList.iterator();
    sv localsv;
    for (int i = 1; localIterator.hasNext(); i = i * 31 + a(localsv)) {
      localsv = (sv)localIterator.next();
    }
    return i;
  }
  
  public static int a(sv paramsv)
  {
    return paramsv.a();
  }
  
  public static int a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1231;; i = 1237) {
      return i;
    }
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    return tb.a(paramArrayOfByte);
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    try
    {
      String str = new String(paramArrayOfByte, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported?", localUnsupportedEncodingException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     su
 * JD-Core Version:    0.7.0.1
 */