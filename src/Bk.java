import java.util.concurrent.CountDownLatch;

public final class Bk
{
  private final CountDownLatch a = new CountDownLatch(1);
  private long b = -1L;
  private long c = -1L;
  
  void a()
  {
    if (this.b != -1L) {
      throw new IllegalStateException();
    }
    this.b = System.nanoTime();
  }
  
  void b()
  {
    if ((this.c != -1L) || (this.b == -1L)) {
      throw new IllegalStateException();
    }
    this.c = System.nanoTime();
    this.a.countDown();
  }
  
  void c()
  {
    if ((this.c != -1L) || (this.b == -1L)) {
      throw new IllegalStateException();
    }
    this.c = (this.b - 1L);
    this.a.countDown();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Bk
 * JD-Core Version:    0.7.0.1
 */