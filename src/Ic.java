import android.content.Context;
import android.os.Build.VERSION;

public abstract class Ic
{
  public static Ic a(Context paramContext)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT < 9) {
      localObject = new Ib(paramContext);
    }
    for (;;)
    {
      return localObject;
      if (Build.VERSION.SDK_INT < 14) {
        localObject = new HM(paramContext);
      } else {
        localObject = new HO(paramContext);
      }
    }
  }
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public abstract boolean b();
  
  public abstract int c();
  
  public abstract int d();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ic
 * JD-Core Version:    0.7.0.1
 */