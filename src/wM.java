import android.view.View;
import java.util.List;

abstract class wM
  extends wH
{
  private final wN a;
  private final String b;
  private final boolean c;
  
  public wM(List<wr> paramList, String paramString, wN paramwN, boolean paramBoolean)
  {
    super(paramList);
    this.a = paramwN;
    this.b = paramString;
    this.c = paramBoolean;
  }
  
  protected String b()
  {
    return this.b;
  }
  
  protected void c(View paramView)
  {
    this.a.a(paramView, this.b, this.c);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wM
 * JD-Core Version:    0.7.0.1
 */