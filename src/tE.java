import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class tE
  extends ty
{
  protected boolean f = false;
  protected List<tQ> g = new LinkedList();
  protected ByteBuffer h;
  private final Random i = new Random();
  
  public ByteBuffer a(tQ paramtQ)
  {
    if (paramtQ.f() != tR.b) {
      throw new RuntimeException("only text frames supported");
    }
    ByteBuffer localByteBuffer1 = paramtQ.c();
    ByteBuffer localByteBuffer2 = ByteBuffer.allocate(2 + localByteBuffer1.remaining());
    localByteBuffer2.put((byte)0);
    localByteBuffer1.mark();
    localByteBuffer2.put(localByteBuffer1);
    localByteBuffer1.reset();
    localByteBuffer2.put((byte)-1);
    localByteBuffer2.flip();
    return localByteBuffer2;
  }
  
  public tA a(tT paramtT)
  {
    if ((paramtT.c("Origin")) && (a(paramtT))) {}
    for (tA localtA = tA.a;; localtA = tA.b) {
      return localtA;
    }
  }
  
  public tA a(tT paramtT, ua paramua)
  {
    if ((paramtT.b("WebSocket-Origin").equals(paramua.b("Origin"))) && (a(paramua))) {}
    for (tA localtA = tA.a;; localtA = tA.b) {
      return localtA;
    }
  }
  
  public tU a(tU paramtU)
  {
    paramtU.a("Upgrade", "WebSocket");
    paramtU.a("Connection", "Upgrade");
    if (!paramtU.c("Origin")) {
      paramtU.a("Origin", "random" + this.i.nextInt());
    }
    return paramtU;
  }
  
  public tV a(tT paramtT, ub paramub)
  {
    paramub.a("Web Socket Protocol Handshake");
    paramub.a("Upgrade", "WebSocket");
    paramub.a("Connection", paramtT.b("Connection"));
    paramub.a("WebSocket-Origin", paramtT.b("Origin"));
    paramub.a("WebSocket-Location", "ws://" + paramtT.b("Host") + paramtT.a());
    return paramub;
  }
  
  public void a()
  {
    this.f = false;
    this.h = null;
  }
  
  public tz b()
  {
    return tz.a;
  }
  
  public List<tQ> c(ByteBuffer paramByteBuffer)
  {
    List localList = e(paramByteBuffer);
    if (localList == null) {
      throw new tH(1002);
    }
    return localList;
  }
  
  public ty c()
  {
    return new tE();
  }
  
  public ByteBuffer d()
  {
    return ByteBuffer.allocate(b);
  }
  
  protected List<tQ> e(ByteBuffer paramByteBuffer)
  {
    List localList = null;
    while (paramByteBuffer.hasRemaining())
    {
      byte b = paramByteBuffer.get();
      if (b == 0)
      {
        if (this.f) {
          throw new tI("unexpected START_OF_FRAME");
        }
        this.f = true;
      }
      else if (b == -1)
      {
        if (!this.f) {
          throw new tI("unexpected END_OF_FRAME");
        }
        if (this.h != null)
        {
          this.h.flip();
          tS localtS = new tS();
          localtS.a(this.h);
          localtS.a(true);
          localtS.a(tR.b);
          this.g.add(localtS);
          this.h = null;
          paramByteBuffer.mark();
        }
        this.f = false;
      }
      else
      {
        if (!this.f) {
          return localList;
        }
        if (this.h == null) {
          this.h = d();
        }
        for (;;)
        {
          this.h.put(b);
          break;
          if (!this.h.hasRemaining()) {
            this.h = f(this.h);
          }
        }
      }
    }
    localList = this.g;
    this.g = new LinkedList();
    return localList;
  }
  
  public ByteBuffer f(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.flip();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(a(2 * paramByteBuffer.capacity()));
    localByteBuffer.put(paramByteBuffer);
    return localByteBuffer;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     tE
 * JD-Core Version:    0.7.0.1
 */