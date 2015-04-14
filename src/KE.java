import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public abstract class KE<V>
  extends KI<V>
{
  private final Closeable a;
  private final boolean b;
  
  protected KE(Closeable paramCloseable, boolean paramBoolean)
  {
    this.a = paramCloseable;
    this.b = paramBoolean;
  }
  
  protected void c()
  {
    if ((this.a instanceof Flushable)) {
      ((Flushable)this.a).flush();
    }
    if (this.b) {}
    try
    {
      this.a.close();
      for (;;)
      {
        label38:
        return;
        this.a.close();
      }
    }
    catch (IOException localIOException)
    {
      break label38;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     KE
 * JD-Core Version:    0.7.0.1
 */