import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

class IE
  implements IH
{
  final CountDownLatch a = new CountDownLatch(this.b);
  
  IE(IC paramIC, int paramInt) {}
  
  public void a(Exception paramException)
  {
    IC.b(this.c).a(paramException);
  }
  
  public void a(Object paramObject)
  {
    this.a.countDown();
    if (this.a.getCount() == 0L)
    {
      IC.a(this.c).set(true);
      IC.b(this.c).a(this.c);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     IE
 * JD-Core Version:    0.7.0.1
 */