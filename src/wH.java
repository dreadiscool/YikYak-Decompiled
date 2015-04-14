import android.annotation.TargetApi;
import android.view.View;
import java.util.List;

@TargetApi(16)
abstract class wH
  implements wp
{
  private final List<wr> a;
  private final wo b;
  
  protected wH(List<wr> paramList)
  {
    this.a = paramList;
    this.b = new wo();
  }
  
  public abstract void a();
  
  public void b(View paramView)
  {
    this.b.a(paramView, this.a, this);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wH
 * JD-Core Version:    0.7.0.1
 */