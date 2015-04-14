import android.annotation.TargetApi;
import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import com.nispok.snackbar.Snackbar;

@TargetApi(16)
public class yB
  extends View
{
  public yB(Context paramContext)
  {
    super(paramContext);
    setSaveEnabled(false);
    setWillNotDraw(true);
    setVisibility(8);
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    super.onWindowSystemUiVisibilityChanged(paramInt);
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof Snackbar)) {
      ((Snackbar)localViewParent).b(paramInt);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yB
 * JD-Core Version:    0.7.0.1
 */