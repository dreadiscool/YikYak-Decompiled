import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

class B
{
  private static final AtomicLong a = new AtomicLong(0L);
  private static String b;
  
  public B(Js paramJs)
  {
    byte[] arrayOfByte = new byte[10];
    a(arrayOfByte);
    b(arrayOfByte);
    c(arrayOfByte);
    String str1 = Jg.a(paramJs.b());
    String str2 = Jg.a(arrayOfByte);
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = str2.substring(0, 12);
    arrayOfObject[1] = str2.substring(12, 16);
    arrayOfObject[2] = str2.subSequence(16, 20);
    arrayOfObject[3] = str1.substring(0, 12);
    b = String.format(localLocale, "%s-%s-%s-%s", arrayOfObject).toUpperCase(Locale.US);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    long l1 = new Date().getTime();
    long l2 = l1 / 1000L;
    long l3 = l1 % 1000L;
    byte[] arrayOfByte1 = a(l2);
    paramArrayOfByte[0] = arrayOfByte1[0];
    paramArrayOfByte[1] = arrayOfByte1[1];
    paramArrayOfByte[2] = arrayOfByte1[2];
    paramArrayOfByte[3] = arrayOfByte1[3];
    byte[] arrayOfByte2 = b(l3);
    paramArrayOfByte[4] = arrayOfByte2[0];
    paramArrayOfByte[5] = arrayOfByte2[1];
  }
  
  private static byte[] a(long paramLong)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.putInt((int)paramLong);
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    localByteBuffer.position(0);
    return localByteBuffer.array();
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = b(a.incrementAndGet());
    paramArrayOfByte[6] = arrayOfByte[0];
    paramArrayOfByte[7] = arrayOfByte[1];
  }
  
  private static byte[] b(long paramLong)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(2);
    localByteBuffer.putShort((short)(int)paramLong);
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    localByteBuffer.position(0);
    return localByteBuffer.array();
  }
  
  private void c(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = b(Integer.valueOf(Process.myPid()).shortValue());
    paramArrayOfByte[8] = arrayOfByte[0];
    paramArrayOfByte[9] = arrayOfByte[1];
  }
  
  public String toString()
  {
    return b;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     B
 * JD-Core Version:    0.7.0.1
 */