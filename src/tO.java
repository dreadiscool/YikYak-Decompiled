import java.nio.ByteBuffer;

public class tO
  extends tS
  implements tN
{
  static final ByteBuffer a = ByteBuffer.allocate(0);
  private int f;
  private String g;
  
  public tO()
  {
    super(tR.f);
    a(true);
  }
  
  public tO(int paramInt)
  {
    super(tR.f);
    a(true);
    a(paramInt, "");
  }
  
  public tO(int paramInt, String paramString)
  {
    super(tR.f);
    a(true);
    a(paramInt, paramString);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      if (paramInt == 1015)
      {
        str = "";
        paramInt = 1005;
      }
      if (paramInt == 1005)
      {
        if (str.length() > 0) {
          throw new tH(1002, "A close frame must have a closecode if it has a reason");
        }
      }
      else
      {
        byte[] arrayOfByte = ue.a(str);
        ByteBuffer localByteBuffer1 = ByteBuffer.allocate(4);
        localByteBuffer1.putInt(paramInt);
        localByteBuffer1.position(2);
        ByteBuffer localByteBuffer2 = ByteBuffer.allocate(2 + arrayOfByte.length);
        localByteBuffer2.put(localByteBuffer1);
        localByteBuffer2.put(arrayOfByte);
        localByteBuffer2.rewind();
        a(localByteBuffer2);
      }
      return;
    }
  }
  
  private void g()
  {
    this.f = 1005;
    ByteBuffer localByteBuffer1 = super.c();
    localByteBuffer1.mark();
    if (localByteBuffer1.remaining() >= 2)
    {
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate(4);
      localByteBuffer2.position(2);
      localByteBuffer2.putShort(localByteBuffer1.getShort());
      localByteBuffer2.position(0);
      this.f = localByteBuffer2.getInt();
      if ((this.f == 1006) || (this.f == 1015) || (this.f == 1005) || (this.f > 4999) || (this.f < 1000) || (this.f == 1004)) {
        throw new tI("closecode must not be sent over the wire: " + this.f);
      }
    }
    localByteBuffer1.reset();
  }
  
  private void h()
  {
    if (this.f == 1005) {
      this.g = ue.a(super.c());
    }
    for (;;)
    {
      return;
      ByteBuffer localByteBuffer = super.c();
      int i = localByteBuffer.position();
      try
      {
        localByteBuffer.position(2 + localByteBuffer.position());
        this.g = ue.a(localByteBuffer);
        localByteBuffer.position(i);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new tI(localIllegalArgumentException);
      }
      finally
      {
        localByteBuffer.position(i);
      }
    }
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    super.a(paramByteBuffer);
    g();
    h();
  }
  
  public String b()
  {
    return this.g;
  }
  
  public ByteBuffer c()
  {
    if (this.f == 1005) {}
    for (ByteBuffer localByteBuffer = a;; localByteBuffer = super.c()) {
      return localByteBuffer;
    }
  }
  
  public String toString()
  {
    return super.toString() + "code: " + this.f;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     tO
 * JD-Core Version:    0.7.0.1
 */