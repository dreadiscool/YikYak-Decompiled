import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.TypedValue;
import com.yik.yak.ui.pullrefresh.PullRefreshLayout;

public class Hd
  extends Hc
  implements Runnable
{
  private final int a = 50;
  private boolean b;
  private Handler c = new Handler();
  private PullRefreshLayout d;
  private int e;
  private int f;
  private int g;
  private int h;
  private Rect i;
  private Bitmap j;
  private int k = 180;
  private Runnable l = new He(this);
  
  public Hd(Context paramContext, PullRefreshLayout paramPullRefreshLayout)
  {
    super(paramContext, paramPullRefreshLayout);
    this.d = paramPullRefreshLayout;
  }
  
  private void a(Canvas paramCanvas)
  {
    float f1 = 1.0F;
    if (this.e >= 0) {}
    for (;;)
    {
      int m = (int)Math.max(0.0F, Math.min(180.0F, f1 * 360.0F - 180.0F));
      Matrix localMatrix = new Matrix();
      localMatrix.setRotate(m, this.f / 2.0F, this.f / 2.0F);
      paramCanvas.drawBitmap(this.j, localMatrix, null);
      return;
      f1 = (this.h + this.e) / (f1 * this.h);
    }
  }
  
  private int b(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, a().getResources().getDisplayMetrics());
  }
  
  private Bitmap b(Drawable paramDrawable)
  {
    int m = b(50);
    Bitmap localBitmap;
    if ((paramDrawable instanceof BitmapDrawable)) {
      localBitmap = Bitmap.createScaledBitmap(((BitmapDrawable)paramDrawable).getBitmap(), m, m, true);
    }
    for (;;)
    {
      return localBitmap;
      localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
      Bitmap.createScaledBitmap(localBitmap, m, m, true);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.k >= 359) {}
    for (int m = 0;; m = 10 + this.k)
    {
      this.k = m;
      Matrix localMatrix = new Matrix();
      localMatrix.setRotate(this.k, this.f / 2.0F, this.f / 2.0F);
      paramCanvas.drawBitmap(this.j, localMatrix, null);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.e = (paramInt + this.e);
    invalidateSelf();
  }
  
  public void a(Drawable paramDrawable)
  {
    this.j = b(paramDrawable);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!this.b)
    {
      paramCanvas.save();
      paramCanvas.translate(this.i.width() / 2 - this.f / 2, this.e);
      a(paramCanvas);
      paramCanvas.restore();
    }
    for (;;)
    {
      return;
      paramCanvas.save();
      paramCanvas.translate(this.i.width() / 2 - this.f / 2, this.e);
      b(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public boolean isRunning()
  {
    return this.b;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.f = b(50);
    this.g = this.f;
    this.e = (-this.g - (b().b() - this.g) / 2);
    this.h = Math.abs(this.e);
    this.i = paramRect;
  }
  
  public void run()
  {
    if (isRunning())
    {
      invalidateSelf();
      this.c.postDelayed(this, 15L);
    }
  }
  
  public void start()
  {
    this.b = true;
    this.c.post(this.l);
  }
  
  public void stop()
  {
    this.k = 180;
    this.b = false;
    this.c.removeCallbacks(this);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Hd
 * JD-Core Version:    0.7.0.1
 */