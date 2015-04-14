import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import java.util.concurrent.ScheduledExecutorService;

class aZ
{
  final bd a;
  final bf b;
  
  aZ(bd parambd, bf parambf)
  {
    this.a = parambd;
    this.b = parambf;
  }
  
  public static aZ a(Context paramContext, bd parambd, aY paramaY, KK paramKK)
  {
    ScheduledExecutorService localScheduledExecutorService = Jo.b("Crashlytics SAM");
    return new aZ(parambd, new bf(paramContext, new aX(paramContext, localScheduledExecutorService, paramaY, paramKK), paramaY, localScheduledExecutorService));
  }
  
  public void a()
  {
    this.b.b();
  }
  
  public void a(KT paramKT, String paramString)
  {
    this.b.a(paramKT, paramString);
  }
  
  public void a(Activity paramActivity)
  {
    this.b.a(bb.a(this.a, bc.a, paramActivity), false);
  }
  
  public void a(String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new IllegalStateException("onCrash called from main thread!!!");
    }
    this.b.a(bb.a(this.a, paramString));
  }
  
  public void b()
  {
    this.b.a(bb.a(this.a), true);
  }
  
  public void b(Activity paramActivity)
  {
    this.b.a(bb.a(this.a, bc.g, paramActivity), false);
  }
  
  public void c(Activity paramActivity)
  {
    this.b.a(bb.a(this.a, bc.e, paramActivity), false);
  }
  
  public void d(Activity paramActivity)
  {
    this.b.a(bb.a(this.a, bc.c, paramActivity), false);
  }
  
  public void e(Activity paramActivity)
  {
    this.b.a(bb.a(this.a, bc.d, paramActivity), false);
  }
  
  public void f(Activity paramActivity)
  {
    this.b.a(bb.a(this.a, bc.b, paramActivity), false);
  }
  
  public void g(Activity paramActivity)
  {
    this.b.a(bb.a(this.a, bc.f, paramActivity), false);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     aZ
 * JD-Core Version:    0.7.0.1
 */