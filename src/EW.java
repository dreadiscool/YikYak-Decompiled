import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout.LayoutParams;

public class EW
  extends Animation
{
  private View a;
  private int b;
  private int c;
  private LinearLayout.LayoutParams d;
  
  public EW(View paramView, int paramInt1, int paramInt2)
  {
    setDuration(paramInt1);
    this.a = paramView;
    this.d = ((LinearLayout.LayoutParams)paramView.getLayoutParams());
    this.b = this.d.height;
    this.c = paramInt2;
    if (this.c == 0) {}
    for (this.d.height = 0;; this.d.height = this.b)
    {
      paramView.setVisibility(0);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if (paramFloat < 1.0F) {
      if (this.c == 0)
      {
        this.d.height = ((int)(paramFloat * this.b));
        this.a.requestLayout();
      }
    }
    for (;;)
    {
      return;
      this.d.height = ((int)(this.b * (1.0F - paramFloat)));
      break;
      if (this.c == 0)
      {
        this.d.height = this.b;
        this.a.requestLayout();
      }
      else
      {
        this.a.setVisibility(8);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     EW
 * JD-Core Version:    0.7.0.1
 */