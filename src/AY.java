import java.io.IOException;
import java.util.logging.Logger;

public final class AY
  implements BI
{
  private static final Logger a = Logger.getLogger(Ba.class.getName());
  private static final LE b = LE.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  
  private static int b(int paramInt, byte paramByte, short paramShort)
  {
    if ((paramByte & 0x8) != 0) {
      paramInt -= 1;
    }
    if (paramShort > paramInt)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Short.valueOf(paramShort);
      arrayOfObject[1] = Integer.valueOf(paramInt);
      throw d("PROTOCOL_ERROR padding %s > remaining length %s", arrayOfObject);
    }
    return paramInt - paramShort;
  }
  
  private static int b(LD paramLD)
  {
    return (0xFF & paramLD.k()) << 16 | (0xFF & paramLD.k()) << 8 | 0xFF & paramLD.k();
  }
  
  private static void b(LC paramLC, int paramInt)
  {
    paramLC.g(0xFF & paramInt >>> 16);
    paramLC.g(0xFF & paramInt >>> 8);
    paramLC.g(paramInt & 0xFF);
  }
  
  private static IllegalArgumentException c(String paramString, Object... paramVarArgs)
  {
    throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
  }
  
  private static IOException d(String paramString, Object... paramVarArgs)
  {
    throw new IOException(String.format(paramString, paramVarArgs));
  }
  
  public AQ a(LD paramLD, boolean paramBoolean)
  {
    return new Bb(paramLD, 4096, paramBoolean);
  }
  
  public AS a(LC paramLC, boolean paramBoolean)
  {
    return new Bc(paramLC, paramBoolean);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AY
 * JD-Core Version:    0.7.0.1
 */