import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class tF
  extends tE
{
  private static final byte[] j;
  private boolean i = false;
  private final Random k = new Random();
  
  static
  {
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = -1;
    arrayOfByte[1] = 0;
    j = arrayOfByte;
  }
  
  private static byte[] a(String paramString)
  {
    long l1;
    long l2;
    try
    {
      l1 = Long.parseLong(paramString.replaceAll("[^0-9]", ""));
      l2 = -1 + paramString.split(" ").length;
      if (l2 == 0L) {
        throw new tJ("invalid Sec-WebSocket-Key (/key2/)");
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new tJ("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
    }
    long l3 = new Long(l1 / l2).longValue();
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[0] = ((byte)(int)(l3 >> 24));
    arrayOfByte[1] = ((byte)(int)(l3 << 8 >> 24));
    arrayOfByte[2] = ((byte)(int)(l3 << 16 >> 24));
    arrayOfByte[3] = ((byte)(int)(l3 << 24 >> 24));
    return arrayOfByte;
  }
  
  public static byte[] a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = a(paramString1);
    byte[] arrayOfByte2 = a(paramString2);
    byte[] arrayOfByte3 = new byte[16];
    arrayOfByte3[0] = arrayOfByte1[0];
    arrayOfByte3[1] = arrayOfByte1[1];
    arrayOfByte3[2] = arrayOfByte1[2];
    arrayOfByte3[3] = arrayOfByte1[3];
    arrayOfByte3[4] = arrayOfByte2[0];
    arrayOfByte3[5] = arrayOfByte2[1];
    arrayOfByte3[6] = arrayOfByte2[2];
    arrayOfByte3[7] = arrayOfByte2[3];
    arrayOfByte3[8] = paramArrayOfByte[0];
    arrayOfByte3[9] = paramArrayOfByte[1];
    arrayOfByte3[10] = paramArrayOfByte[2];
    arrayOfByte3[11] = paramArrayOfByte[3];
    arrayOfByte3[12] = paramArrayOfByte[4];
    arrayOfByte3[13] = paramArrayOfByte[5];
    arrayOfByte3[14] = paramArrayOfByte[6];
    arrayOfByte3[15] = paramArrayOfByte[7];
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      return localMessageDigest.digest(arrayOfByte3);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
  }
  
  private static String e()
  {
    Random localRandom = new Random();
    long l = 1 + localRandom.nextInt(12);
    String str1 = Long.toString(l * (1 + localRandom.nextInt(Math.abs(new Long(4294967295L / l).intValue()))));
    int m = 1 + localRandom.nextInt(12);
    for (int n = 0; n < m; n++)
    {
      int i3 = Math.abs(localRandom.nextInt(str1.length()));
      int i4 = (char)(33 + localRandom.nextInt(95));
      if ((i4 >= 48) && (i4 <= 57)) {
        i4 += -15;
      }
      str1 = new StringBuilder(str1).insert(i3, i4).toString();
    }
    int i1 = 0;
    String str2 = str1;
    while (i1 < l)
    {
      int i2 = Math.abs(1 + localRandom.nextInt(-1 + str2.length()));
      str2 = new StringBuilder(str2).insert(i2, " ").toString();
      i1++;
    }
    return str2;
  }
  
  public ByteBuffer a(tQ paramtQ)
  {
    if (paramtQ.f() == tR.f) {}
    for (ByteBuffer localByteBuffer = ByteBuffer.wrap(j);; localByteBuffer = super.a(paramtQ)) {
      return localByteBuffer;
    }
  }
  
  public tA a(tT paramtT)
  {
    if ((paramtT.b("Upgrade").equals("WebSocket")) && (paramtT.b("Connection").contains("Upgrade")) && (paramtT.b("Sec-WebSocket-Key1").length() > 0) && (!paramtT.b("Sec-WebSocket-Key2").isEmpty()) && (paramtT.c("Origin"))) {}
    for (tA localtA = tA.a;; localtA = tA.b) {
      return localtA;
    }
  }
  
  public tA a(tT paramtT, ua paramua)
  {
    tA localtA;
    if (this.i) {
      localtA = tA.b;
    }
    for (;;)
    {
      return localtA;
      byte[] arrayOfByte;
      try
      {
        if ((!paramua.b("Sec-WebSocket-Origin").equals(paramtT.b("Origin"))) || (!a(paramua)))
        {
          localtA = tA.b;
          continue;
        }
        arrayOfByte = paramua.c();
        if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
          throw new tG();
        }
      }
      catch (tJ localtJ)
      {
        throw new RuntimeException("bad handshakerequest", localtJ);
      }
      if (Arrays.equals(arrayOfByte, a(paramtT.b("Sec-WebSocket-Key1"), paramtT.b("Sec-WebSocket-Key2"), paramtT.c()))) {
        localtA = tA.a;
      } else {
        localtA = tA.b;
      }
    }
  }
  
  public tU a(tU paramtU)
  {
    paramtU.a("Upgrade", "WebSocket");
    paramtU.a("Connection", "Upgrade");
    paramtU.a("Sec-WebSocket-Key1", e());
    paramtU.a("Sec-WebSocket-Key2", e());
    if (!paramtU.c("Origin")) {
      paramtU.a("Origin", "random" + this.k.nextInt());
    }
    byte[] arrayOfByte = new byte[8];
    this.k.nextBytes(arrayOfByte);
    paramtU.a(arrayOfByte);
    return paramtU;
  }
  
  public tV a(tT paramtT, ub paramub)
  {
    paramub.a("WebSocket Protocol Handshake");
    paramub.a("Upgrade", "WebSocket");
    paramub.a("Connection", paramtT.b("Connection"));
    paramub.a("Sec-WebSocket-Origin", paramtT.b("Origin"));
    paramub.a("Sec-WebSocket-Location", "ws://" + paramtT.b("Host") + paramtT.a());
    String str1 = paramtT.b("Sec-WebSocket-Key1");
    String str2 = paramtT.b("Sec-WebSocket-Key2");
    byte[] arrayOfByte = paramtT.c();
    if ((str1 == null) || (str2 == null) || (arrayOfByte == null) || (arrayOfByte.length != 8)) {
      throw new tJ("Bad keys");
    }
    paramub.a(a(str1, str2, arrayOfByte));
    return paramub;
  }
  
  public tz b()
  {
    return tz.b;
  }
  
  public List<tQ> c(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.mark();
    List localList = super.e(paramByteBuffer);
    if (localList == null)
    {
      paramByteBuffer.reset();
      localList = this.g;
      this.f = true;
      if (this.h == null)
      {
        this.h = ByteBuffer.allocate(2);
        if (paramByteBuffer.remaining() > this.h.remaining()) {
          throw new tI();
        }
      }
      else
      {
        throw new tI();
      }
      this.h.put(paramByteBuffer);
      if (this.h.hasRemaining()) {
        break label137;
      }
      if (!Arrays.equals(this.h.array(), j)) {
        break label129;
      }
      localList.add(new tO(1000));
    }
    for (;;)
    {
      return localList;
      label129:
      throw new tI();
      label137:
      this.g = new LinkedList();
    }
  }
  
  public ty c()
  {
    return new tF();
  }
  
  public tY d(ByteBuffer paramByteBuffer)
  {
    tV localtV = a(paramByteBuffer, this.d);
    if (((localtV.c("Sec-WebSocket-Key1")) || (this.d == tr.a)) && (!localtV.c("Sec-WebSocket-Version"))) {
      if (this.d != tr.b) {
        break label77;
      }
    }
    for (int m = 8;; m = 16)
    {
      byte[] arrayOfByte = new byte[m];
      try
      {
        paramByteBuffer.get(arrayOfByte);
        localtV.a(arrayOfByte);
        return localtV;
      }
      catch (BufferUnderflowException localBufferUnderflowException)
      {
        label77:
        throw new tG(16 + paramByteBuffer.capacity());
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     tF
 * JD-Core Version:    0.7.0.1
 */