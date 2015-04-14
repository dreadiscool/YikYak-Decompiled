import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.yik.yak.ui.pullrefresh.PullRefreshLayout;
import java.util.HashMap;

public class GV
  extends Hc
  implements Runnable
{
  private boolean a;
  private Handler b = new Handler();
  private int c;
  private int d;
  private int e;
  private int f;
  private int g = 0;
  private int h = 0;
  private Rect i;
  private int j = 0;
  private Runnable k = new GW(this);
  private PullRefreshLayout l;
  private Paint m = new Paint();
  private int n = 0;
  
  public GV(Context paramContext, PullRefreshLayout paramPullRefreshLayout)
  {
    super(paramContext, paramPullRefreshLayout);
    this.l = paramPullRefreshLayout;
  }
  
  private void a(Canvas paramCanvas)
  {
    this.m.setStyle(Paint.Style.STROKE);
    this.m.setStrokeWidth(1.0F);
    this.m.setAntiAlias(true);
    this.m.setColor(this.n);
    this.m.setStyle(Paint.Style.FILL);
    if (this.c >= -1) {}
    for (int i1 = 0;; i1 = this.c)
    {
      paramCanvas.drawRect(0.0F, i1, this.i.width(), this.f + this.c, this.m);
      return;
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    float f1 = 1.0F;
    try
    {
      if (this.c >= 0) {}
      for (;;)
      {
        int i2 = (int)(f1 * this.g);
        if (i2 - 1 < 0) {
          break;
        }
        paramCanvas.drawBitmap(CZ.b(i2 - 1), new Rect(0, 0, 640, 280), new Rect(0, 0, this.d, this.e), null);
        break;
        float f2 = this.f + this.c;
        int i1 = this.f;
        f1 = f2 / (f1 * i1);
      }
      return;
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  private void c(Canvas paramCanvas)
  {
    try
    {
      if (this.j < this.h)
      {
        paramCanvas.drawBitmap(CZ.a(this.j), new Rect(0, 0, 640, 280), new Rect(0, 0, this.d, this.e), null);
        this.j = (1 + this.j);
      }
      label65:
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      break label65;
    }
  }
  
  public void a(int paramInt)
  {
    this.c = (paramInt + this.c);
    invalidateSelf();
  }
  
  public void a(Drawable paramDrawable) {}
  
  public void draw(Canvas paramCanvas)
  {
    if (!this.a)
    {
      paramCanvas.save();
      a(paramCanvas);
      if (this.c > 1)
      {
        paramCanvas.translate(this.i.width() / 2 - this.d / 2, this.c / 2);
        b(paramCanvas);
        paramCanvas.restore();
      }
    }
    for (;;)
    {
      return;
      paramCanvas.translate(this.i.width() / 2 - this.d / 2, this.c);
      break;
      paramCanvas.save();
      a(paramCanvas);
      paramCanvas.translate(this.i.width() / 2 - this.d / 2, 0.0F);
      c(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public boolean isRunning()
  {
    return this.a;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.i = paramRect;
    if (!CZ.c()) {
      this.d = this.i.width();
    }
    float f1;
    for (this.e = this.i.height();; this.e = (1 + (int)(f1 * CZ.b(0).getHeight())))
    {
      this.l.setMaxDragDistance(this.e);
      this.g = CZ.b.size();
      this.h = CZ.a.size();
      this.n = CZ.b();
      this.c = (-this.e);
      this.f = Math.abs(this.c);
      return;
      f1 = this.i.width() / CZ.b(0).getWidth();
      this.d = this.i.width();
    }
  }
  
  public void run()
  {
    if (isRunning())
    {
      invalidateSelf();
      this.b.postDelayed(this, 30L);
    }
  }
  
  public void start()
  {
    this.a = true;
    this.b.post(this.k);
  }
  
  public void stop()
  {
    this.j = 0;
    this.a = false;
    this.b.removeCallbacks(this);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     GV
 * JD-Core Version:    0.7.0.1
 */