import android.graphics.Canvas;
import android.graphics.Paint;
import com.yik.yak.ui.view.AnimatedTextView;

public class Hf
  extends Hg
{
  public Hf(AnimatedTextView paramAnimatedTextView)
  {
    super(paramAnimatedTextView);
  }
  
  public String a()
  {
    return "-";
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    paramPaint.getTextBounds(a(), 0, a().length(), this.b);
    int i = paramInt2 + b() / 4;
    paramCanvas.drawText(a(), paramInt1, i + this.a, paramPaint);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Hf
 * JD-Core Version:    0.7.0.1
 */