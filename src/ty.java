import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class ty
{
  public static int a = 1000;
  public static int b = 64;
  public static final byte[] c = ue.a("<policy-file-request/>��");
  protected tr d = null;
  protected tR e = null;
  
  public static ByteBuffer a(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(paramByteBuffer.remaining());
    byte b1;
    for (int i = 48;; i = b1) {
      if (paramByteBuffer.hasRemaining())
      {
        b1 = paramByteBuffer.get();
        localByteBuffer1.put(b1);
        if ((i == 13) && (b1 == 10))
        {
          localByteBuffer1.limit(-2 + localByteBuffer1.position());
          localByteBuffer1.position(0);
        }
      }
      else
      {
        for (ByteBuffer localByteBuffer2 = localByteBuffer1;; localByteBuffer2 = null)
        {
          return localByteBuffer2;
          paramByteBuffer.position(paramByteBuffer.position() - localByteBuffer1.position());
        }
      }
    }
  }
  
  public static tV a(ByteBuffer paramByteBuffer, tr paramtr)
  {
    String str1 = b(paramByteBuffer);
    if (str1 == null) {
      throw new tG(128 + paramByteBuffer.capacity());
    }
    String[] arrayOfString1 = str1.split(" ", 3);
    if (arrayOfString1.length != 3) {
      throw new tJ();
    }
    Object localObject;
    if (paramtr == tr.a)
    {
      localObject = new tX();
      ub localub = (ub)localObject;
      localub.a(Short.parseShort(arrayOfString1[1]));
      localub.a(arrayOfString1[2]);
    }
    for (String str2 = b(paramByteBuffer);; str2 = b(paramByteBuffer))
    {
      if ((str2 == null) || (str2.length() <= 0)) {
        break label192;
      }
      String[] arrayOfString2 = str2.split(":", 2);
      if (arrayOfString2.length != 2)
      {
        throw new tJ("not an http header");
        localObject = new tW();
        ((tU)localObject).a(arrayOfString1[1]);
        break;
      }
      ((tV)localObject).a(arrayOfString2[0], arrayOfString2[1].replaceFirst("^ +", ""));
    }
    label192:
    if (str2 == null) {
      throw new tG();
    }
    return localObject;
  }
  
  public static String b(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer = a(paramByteBuffer);
    if (localByteBuffer == null) {}
    for (String str = null;; str = ue.a(localByteBuffer.array(), 0, localByteBuffer.limit())) {
      return str;
    }
  }
  
  public int a(int paramInt)
  {
    if (paramInt < 0) {
      throw new tH(1002, "Negative count");
    }
    return paramInt;
  }
  
  public abstract ByteBuffer a(tQ paramtQ);
  
  public List<tQ> a(tR paramtR, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    if ((paramtR != tR.c) && (paramtR != tR.b) && (paramtR != tR.b)) {
      throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
    }
    tS localtS;
    if (this.e != null)
    {
      this.e = tR.a;
      localtS = new tS(this.e);
    }
    for (;;)
    {
      try
      {
        localtS.a(paramByteBuffer);
        localtS.a(paramBoolean);
        if (!paramBoolean) {
          break label109;
        }
        this.e = null;
        return Collections.singletonList(localtS);
      }
      catch (tH localtH)
      {
        throw new RuntimeException(localtH);
      }
      this.e = paramtR;
      break;
      label109:
      this.e = paramtR;
    }
  }
  
  public List<ByteBuffer> a(tY paramtY, tr paramtr)
  {
    return a(paramtY, paramtr, true);
  }
  
  public List<ByteBuffer> a(tY paramtY, tr paramtr, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    if ((paramtY instanceof tT))
    {
      localStringBuilder.append("GET ");
      localStringBuilder.append(((tT)paramtY).a());
      localStringBuilder.append(" HTTP/1.1");
    }
    for (;;)
    {
      localStringBuilder.append("\r\n");
      Iterator localIterator = paramtY.b();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramtY.b(str1);
        localStringBuilder.append(str1);
        localStringBuilder.append(": ");
        localStringBuilder.append(str2);
        localStringBuilder.append("\r\n");
      }
      if (!(paramtY instanceof ua)) {
        break;
      }
      localStringBuilder.append("HTTP/1.1 101 " + ((ua)paramtY).a());
    }
    throw new RuntimeException("unknow role");
    localStringBuilder.append("\r\n");
    byte[] arrayOfByte1 = ue.b(localStringBuilder.toString());
    byte[] arrayOfByte2;
    if (paramBoolean)
    {
      arrayOfByte2 = paramtY.c();
      if (arrayOfByte2 != null) {
        break label273;
      }
    }
    label273:
    for (int i = 0;; i = arrayOfByte2.length)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i + arrayOfByte1.length);
      localByteBuffer.put(arrayOfByte1);
      if (arrayOfByte2 != null) {
        localByteBuffer.put(arrayOfByte2);
      }
      localByteBuffer.flip();
      return Collections.singletonList(localByteBuffer);
      arrayOfByte2 = null;
      break;
    }
  }
  
  public abstract tA a(tT paramtT);
  
  public abstract tA a(tT paramtT, ua paramua);
  
  public abstract tU a(tU paramtU);
  
  public abstract tV a(tT paramtT, ub paramub);
  
  public abstract void a();
  
  public void a(tr paramtr)
  {
    this.d = paramtr;
  }
  
  protected boolean a(tY paramtY)
  {
    if ((paramtY.b("Upgrade").equalsIgnoreCase("websocket")) && (paramtY.b("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public abstract tz b();
  
  public abstract List<tQ> c(ByteBuffer paramByteBuffer);
  
  public abstract ty c();
  
  public tY d(ByteBuffer paramByteBuffer)
  {
    return a(paramByteBuffer, this.d);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ty
 * JD-Core Version:    0.7.0.1
 */