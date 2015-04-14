import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

class uh
{
  private final Object b = new Object();
  private Handler c = a();
  private long d = 0L;
  private long e = 0L;
  private long f = -1L;
  private vr g;
  
  public uh(uf paramuf) {}
  
  private Handler a()
  {
    HandlerThread localHandlerThread = new HandlerThread("com.mixpanel.android.AnalyticsWorker", 1);
    localHandlerThread.start();
    return new ui(this, localHandlerThread.getLooper());
  }
  
  private void b()
  {
    long l1 = System.currentTimeMillis();
    long l2 = 1L + this.d;
    if (this.f > 0L)
    {
      this.e = ((l1 - this.f + this.e * this.d) / l2);
      long l3 = this.e / 1000L;
      uf.a(this.a, "Average send frequency approximately " + l3 + " seconds.");
    }
    this.f = l1;
    this.d = l2;
  }
  
  public void a(Message paramMessage)
  {
    synchronized (this.b)
    {
      if (this.c == null)
      {
        uf.a(this.a, "Dead mixpanel worker dropping a message: " + paramMessage.what);
        return;
      }
      this.c.sendMessage(paramMessage);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     uh
 * JD-Core Version:    0.7.0.1
 */