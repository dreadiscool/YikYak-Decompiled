import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class tB
  extends ty
{
  private ByteBuffer g;
  private tQ h = null;
  private final Random i = new Random();
  
  static
  {
    if (!tB.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      f = bool;
      return;
    }
  }
  
  private byte a(tR paramtR)
  {
    byte b;
    if (paramtR == tR.a) {
      b = 0;
    }
    for (;;)
    {
      return b;
      if (paramtR == tR.b)
      {
        b = 1;
      }
      else if (paramtR == tR.c)
      {
        b = 2;
      }
      else if (paramtR == tR.f)
      {
        b = 8;
      }
      else if (paramtR == tR.d)
      {
        b = 9;
      }
      else
      {
        if (paramtR != tR.e) {
          break;
        }
        b = 10;
      }
    }
    throw new RuntimeException("Don't know how to handle " + paramtR.toString());
  }
  
  private String a(String paramString)
  {
    String str1 = paramString.trim();
    String str2 = str1 + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      return uc.a(localMessageDigest.digest(str2.getBytes()));
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
  }
  
  private tR a(byte paramByte)
  {
    tR localtR;
    switch (paramByte)
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new tI("unknow optcode " + (short)paramByte);
    case 0: 
      localtR = tR.a;
    }
    for (;;)
    {
      return localtR;
      localtR = tR.b;
      continue;
      localtR = tR.c;
      continue;
      localtR = tR.f;
      continue;
      localtR = tR.d;
      continue;
      localtR = tR.e;
    }
  }
  
  private byte[] a(long paramLong, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int j = -8 + paramInt * 8;
    for (int k = 0; k < paramInt; k++) {
      arrayOfByte[k] = ((byte)(int)(paramLong >>> j - k * 8));
    }
    return arrayOfByte;
  }
  
  public static int b(tY paramtY)
  {
    int j = -1;
    String str = paramtY.b("Sec-WebSocket-Version");
    if (str.length() > 0) {}
    try
    {
      int k = new Integer(str.trim()).intValue();
      j = k;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label38:
      break label38;
    }
    return j;
  }
  
  public ByteBuffer a(tQ paramtQ)
  {
    int j = -128;
    int k = 0;
    ByteBuffer localByteBuffer1 = paramtQ.c();
    int m;
    int n;
    label39:
    int i1;
    label51:
    int i3;
    label65:
    ByteBuffer localByteBuffer2;
    int i4;
    if (this.d == tr.a)
    {
      m = 1;
      if (localByteBuffer1.remaining() > 125) {
        break label159;
      }
      n = 1;
      if (n <= 1) {
        break label182;
      }
      i1 = n + 1;
      int i2 = i1 + 1;
      if (m == 0) {
        break label189;
      }
      i3 = 4;
      localByteBuffer2 = ByteBuffer.allocate(i3 + i2 + localByteBuffer1.remaining());
      i4 = a(paramtQ.f());
      if (!paramtQ.d()) {
        break label195;
      }
    }
    byte[] arrayOfByte;
    label159:
    label182:
    label189:
    label195:
    for (int i5 = j;; i5 = 0)
    {
      localByteBuffer2.put(i4 | (byte)i5);
      arrayOfByte = a(localByteBuffer1.remaining(), n);
      if ((f) || (arrayOfByte.length == n)) {
        break label201;
      }
      throw new AssertionError();
      m = 0;
      break;
      if (localByteBuffer1.remaining() <= 65535)
      {
        n = 2;
        break label39;
      }
      n = 8;
      break label39;
      i1 = n;
      break label51;
      i3 = 0;
      break label65;
    }
    label201:
    if (n == 1)
    {
      int i6 = arrayOfByte[0];
      if (m != 0) {}
      for (;;)
      {
        localByteBuffer2.put((byte)(i6 | j));
        if (m == 0) {
          break;
        }
        ByteBuffer localByteBuffer3 = ByteBuffer.allocate(4);
        localByteBuffer3.putInt(this.i.nextInt());
        localByteBuffer2.put(localByteBuffer3.array());
        while (localByteBuffer1.hasRemaining())
        {
          localByteBuffer2.put(localByteBuffer1.get() ^ localByteBuffer3.get(k % 4));
          k++;
        }
        j = 0;
      }
    }
    if (n == 2)
    {
      if (m != 0) {}
      for (;;)
      {
        localByteBuffer2.put((byte)(j | 0x7E));
        localByteBuffer2.put(arrayOfByte);
        break;
        j = 0;
      }
    }
    if (n == 8)
    {
      if (m != 0) {}
      for (;;)
      {
        localByteBuffer2.put((byte)(j | 0x7F));
        localByteBuffer2.put(arrayOfByte);
        break;
        j = 0;
      }
    }
    throw new RuntimeException("Size representation not supported/specified");
    localByteBuffer2.put(localByteBuffer1);
    if ((!f) && (localByteBuffer2.remaining() != 0)) {
      throw new AssertionError(localByteBuffer2.remaining());
    }
    localByteBuffer2.flip();
    return localByteBuffer2;
  }
  
  public tA a(tT paramtT)
  {
    int j = b(paramtT);
    tA localtA;
    if ((j == 7) || (j == 8)) {
      if (a(paramtT)) {
        localtA = tA.a;
      }
    }
    for (;;)
    {
      return localtA;
      localtA = tA.b;
      continue;
      localtA = tA.b;
    }
  }
  
  public tA a(tT paramtT, ua paramua)
  {
    tA localtA;
    if ((!paramtT.c("Sec-WebSocket-Key")) || (!paramua.c("Sec-WebSocket-Accept"))) {
      localtA = tA.b;
    }
    for (;;)
    {
      return localtA;
      String str = paramua.b("Sec-WebSocket-Accept");
      if (a(paramtT.b("Sec-WebSocket-Key")).equals(str)) {
        localtA = tA.a;
      } else {
        localtA = tA.b;
      }
    }
  }
  
  public tU a(tU paramtU)
  {
    paramtU.a("Upgrade", "websocket");
    paramtU.a("Connection", "Upgrade");
    paramtU.a("Sec-WebSocket-Version", "8");
    byte[] arrayOfByte = new byte[16];
    this.i.nextBytes(arrayOfByte);
    paramtU.a("Sec-WebSocket-Key", uc.a(arrayOfByte));
    return paramtU;
  }
  
  public tV a(tT paramtT, ub paramub)
  {
    paramub.a("Upgrade", "websocket");
    paramub.a("Connection", paramtT.b("Connection"));
    paramub.a("Switching Protocols");
    String str = paramtT.b("Sec-WebSocket-Key");
    if (str == null) {
      throw new tJ("missing Sec-WebSocket-Key");
    }
    paramub.a("Sec-WebSocket-Accept", a(str));
    return paramub;
  }
  
  public void a()
  {
    this.g = null;
  }
  
  public tz b()
  {
    return tz.c;
  }
  
  public List<tQ> c(ByteBuffer paramByteBuffer)
  {
    LinkedList localLinkedList = new LinkedList();
    if (this.g != null) {}
    Object localObject;
    try
    {
      paramByteBuffer.mark();
      int j = paramByteBuffer.remaining();
      int k = this.g.remaining();
      if (k > j)
      {
        this.g.put(paramByteBuffer.array(), paramByteBuffer.position(), j);
        paramByteBuffer.position(j + paramByteBuffer.position());
        localObject = Collections.emptyList();
      }
      else
      {
        this.g.put(paramByteBuffer.array(), paramByteBuffer.position(), k);
        paramByteBuffer.position(k + paramByteBuffer.position());
        localLinkedList.add(e((ByteBuffer)this.g.duplicate().position(0)));
        this.g = null;
        while (paramByteBuffer.hasRemaining())
        {
          paramByteBuffer.mark();
          try
          {
            localLinkedList.add(e(paramByteBuffer));
          }
          catch (tC localtC1)
          {
            paramByteBuffer.reset();
            this.g = ByteBuffer.allocate(a(localtC1.a()));
            this.g.put(paramByteBuffer);
          }
        }
        localObject = localLinkedList;
      }
    }
    catch (tC localtC2)
    {
      this.g.limit();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(a(localtC2.a()));
      if ((!f) && (localByteBuffer.limit() <= this.g.limit())) {
        throw new AssertionError();
      }
      this.g.rewind();
      localByteBuffer.put(this.g);
      this.g = localByteBuffer;
      localObject = c(paramByteBuffer);
    }
    return localObject;
  }
  
  public ty c()
  {
    return new tB();
  }
  
  public tQ e(ByteBuffer paramByteBuffer)
  {
    int j = 2;
    int k = 0;
    int m = paramByteBuffer.remaining();
    if (m < j) {
      throw new tC(this, j);
    }
    int n = paramByteBuffer.get();
    if (n >> 8 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      int i1 = (n & 0x7F) >> 4;
      if (i1 == 0) {
        break;
      }
      throw new tI("bad rsv " + i1);
    }
    int i2 = paramByteBuffer.get();
    if ((i2 & 0xFFFFFF80) != 0) {}
    int i4;
    tR localtR;
    for (int i3 = 1;; i3 = 0)
    {
      i4 = i2 & 0x7F;
      localtR = a(n & 0xF);
      if ((bool) || ((localtR != tR.d) && (localtR != tR.e) && (localtR != tR.f))) {
        break;
      }
      throw new tI("control frames may no be fragmented");
    }
    if ((i4 >= 0) && (i4 <= 125)) {
      if (i3 == 0) {
        break label416;
      }
    }
    label416:
    for (int i7 = 4;; i7 = 0)
    {
      int i8 = i4 + (i7 + j);
      if (m >= i8) {
        break label422;
      }
      throw new tC(this, i8);
      if ((localtR == tR.d) || (localtR == tR.e) || (localtR == tR.f)) {
        throw new tI("more than 125 octets");
      }
      if (i4 == 126)
      {
        if (m < 4) {
          throw new tC(this, 4);
        }
        byte[] arrayOfByte3 = new byte[3];
        arrayOfByte3[1] = paramByteBuffer.get();
        arrayOfByte3[j] = paramByteBuffer.get();
        i4 = new BigInteger(arrayOfByte3).intValue();
        j = 4;
        break;
      }
      if (m < 10) {
        throw new tC(this, 10);
      }
      byte[] arrayOfByte1 = new byte[8];
      for (int i5 = 0; i5 < 8; i5++) {
        arrayOfByte1[i5] = paramByteBuffer.get();
      }
      long l = new BigInteger(arrayOfByte1).longValue();
      if (l > 2147483647L) {
        throw new tK("Payloadsize is to big...");
      }
      int i6 = (int)l;
      j = 10;
      i4 = i6;
      break;
    }
    label422:
    ByteBuffer localByteBuffer = ByteBuffer.allocate(a(i4));
    if (i3 != 0)
    {
      byte[] arrayOfByte2 = new byte[4];
      paramByteBuffer.get(arrayOfByte2);
      while (k < i4)
      {
        localByteBuffer.put(paramByteBuffer.get() ^ arrayOfByte2[(k % 4)]);
        k += 1;
      }
    }
    localByteBuffer.put(paramByteBuffer.array(), paramByteBuffer.position(), localByteBuffer.limit());
    paramByteBuffer.position(paramByteBuffer.position() + localByteBuffer.limit());
    Object localObject;
    if (localtR == tR.f) {
      localObject = new tO();
    }
    for (;;)
    {
      localByteBuffer.flip();
      ((tP)localObject).a(localByteBuffer);
      return localObject;
      localObject = new tS();
      ((tP)localObject).a(bool);
      ((tP)localObject).a(localtR);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     tB
 * JD-Core Version:    0.7.0.1
 */