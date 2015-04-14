import java.io.BufferedOutputStream;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;

class wg
{
  private static final ByteBuffer d = ByteBuffer.allocate(0);
  private final wi a;
  private final wj b;
  private final URI c;
  
  public wg(URI paramURI, wi paramwi, Socket paramSocket)
  {
    this.a = paramwi;
    this.c = paramURI;
    try
    {
      this.b = new wj(this, paramURI, 5000, paramSocket);
      this.b.c();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new wk(this, localInterruptedException);
    }
  }
  
  public boolean a()
  {
    if ((!this.b.e()) && (!this.b.f()) && (!this.b.d())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public BufferedOutputStream b()
  {
    return new BufferedOutputStream(new wl(this, null));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wg
 * JD-Core Version:    0.7.0.1
 */