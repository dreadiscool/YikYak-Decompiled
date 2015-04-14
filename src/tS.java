import java.nio.ByteBuffer;
import java.util.Arrays;

public class tS
  implements tP
{
  protected static byte[] b = new byte[0];
  private ByteBuffer a;
  protected boolean c;
  protected tR d;
  protected boolean e;
  
  public tS() {}
  
  public tS(tQ paramtQ)
  {
    this.c = paramtQ.d();
    this.d = paramtQ.f();
    this.a = paramtQ.c();
    this.e = paramtQ.e();
  }
  
  public tS(tR paramtR)
  {
    this.d = paramtR;
    this.a = ByteBuffer.wrap(b);
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    this.a = paramByteBuffer;
  }
  
  public void a(tR paramtR)
  {
    this.d = paramtR;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public ByteBuffer c()
  {
    return this.a;
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public tR f()
  {
    return this.d;
  }
  
  public String toString()
  {
    return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.a.position() + ", len:" + this.a.remaining() + "], payload:" + Arrays.toString(ue.a(new String(this.a.array()))) + "}";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     tS
 * JD-Core Version:    0.7.0.1
 */