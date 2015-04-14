import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class LW
{
  public static final LW b = new LX();
  private boolean a;
  private long c;
  private long d;
  
  public LW a(long paramLong)
  {
    this.a = true;
    this.c = paramLong;
    return this;
  }
  
  public LW a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0: " + paramLong);
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    this.d = paramTimeUnit.toNanos(paramLong);
    return this;
  }
  
  public long f()
  {
    return this.d;
  }
  
  public boolean g()
  {
    return this.a;
  }
  
  public long h()
  {
    if (!this.a) {
      throw new IllegalStateException("No deadline");
    }
    return this.c;
  }
  
  public LW i()
  {
    this.a = false;
    return this;
  }
  
  public void j()
  {
    if (Thread.interrupted()) {
      throw new InterruptedIOException();
    }
    if ((this.a) && (System.nanoTime() > this.c)) {
      throw new IOException("deadline reached");
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LW
 * JD-Core Version:    0.7.0.1
 */