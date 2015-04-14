import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

class aX
  extends Kf<bb>
  implements ba<bb>
{
  Ku a;
  private final KK g;
  
  public aX(Context paramContext, ScheduledExecutorService paramScheduledExecutorService, aY paramaY, KK paramKK)
  {
    super(paramContext, paramScheduledExecutorService, paramaY);
    this.g = paramKK;
  }
  
  public Ku a()
  {
    return this.a;
  }
  
  public void a(KT paramKT, String paramString)
  {
    this.a = new aV(aR.b(), paramString, paramKT.a, this.g, new Je().a(this.b));
    ((aY)this.d).a(paramKT);
    a(paramKT.b);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     aX
 * JD-Core Version:    0.7.0.1
 */