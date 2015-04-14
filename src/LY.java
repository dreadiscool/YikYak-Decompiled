import java.nio.charset.Charset;

final class LY
{
  public static final Charset a = Charset.forName("UTF-8");
  
  public static int a(int paramInt)
  {
    return (0xFF000000 & paramInt) >>> 24 | (0xFF0000 & paramInt) >>> 8 | (0xFF00 & paramInt) << 8 | (paramInt & 0xFF) << 24;
  }
  
  public static short a(short paramShort)
  {
    int i = 0xFFFF & paramShort;
    return (0xFF00 & i) >>> 8 | (i & 0xFF) << 8;
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) < 0L) || (paramLong2 > paramLong1) || (paramLong1 - paramLong2 < paramLong3))
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Long.valueOf(paramLong1);
      arrayOfObject[1] = Long.valueOf(paramLong2);
      arrayOfObject[2] = Long.valueOf(paramLong3);
      throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", arrayOfObject));
    }
  }
  
  public static void a(Throwable paramThrowable)
  {
    b(paramThrowable);
  }
  
  private static <T extends Throwable> void b(Throwable paramThrowable)
  {
    throw paramThrowable;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LY
 * JD-Core Version:    0.7.0.1
 */