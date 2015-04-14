import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;

@TargetApi(9)
public class HM
  extends Ic
{
  protected final OverScroller a;
  private boolean b = false;
  
  public HM(Context paramContext)
  {
    this.a = new OverScroller(paramContext);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    this.a.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.forceFinished(paramBoolean);
  }
  
  public boolean a()
  {
    if (this.b)
    {
      this.a.computeScrollOffset();
      this.b = false;
    }
    return this.a.computeScrollOffset();
  }
  
  public boolean b()
  {
    return this.a.isFinished();
  }
  
  public int c()
  {
    return this.a.getCurrX();
  }
  
  public int d()
  {
    return this.a.getCurrY();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     HM
 * JD-Core Version:    0.7.0.1
 */