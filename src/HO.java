import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;

@TargetApi(14)
public class HO
  extends HM
{
  public HO(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean a()
  {
    return this.a.computeScrollOffset();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     HO
 * JD-Core Version:    0.7.0.1
 */