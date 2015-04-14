import android.content.Context;
import android.os.IBinder;
import android.view.View;

public final class ia
  extends gZ<hS>
{
  private static final ia a = new ia();
  
  private ia()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View a(Context paramContext, int paramInt1, int paramInt2)
  {
    return a.b(paramContext, paramInt1, paramInt2);
  }
  
  private View b(Context paramContext, int paramInt1, int paramInt2)
  {
    try
    {
      gU localgU = gX.a(paramContext);
      View localView = (View)gX.a(((hS)a(paramContext)).a(localgU, paramInt1, paramInt2));
      return localView;
    }
    catch (Exception localException)
    {
      throw new ha("Could not get button with size " + paramInt1 + " and color " + paramInt2, localException);
    }
  }
  
  public hS b(IBinder paramIBinder)
  {
    return hT.a(paramIBinder);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ia
 * JD-Core Version:    0.7.0.1
 */