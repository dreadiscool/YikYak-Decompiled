import android.content.Context;

public class Kx
  implements Runnable
{
  private final Context a;
  private final Kt b;
  
  public Kx(Context paramContext, Kt paramKt)
  {
    this.a = paramContext;
    this.b = paramKt;
  }
  
  public void run()
  {
    try
    {
      Jg.a(this.a, "Performing time based file roll over.");
      if (!this.b.e()) {
        this.b.d();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Jg.a(this.a, "Failed to roll over file", localException);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Kx
 * JD-Core Version:    0.7.0.1
 */