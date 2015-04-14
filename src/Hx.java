import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.List;

public class Hx
{
  public float a;
  public float b;
  public float c = 1.0F;
  public int d = 255;
  public float e = 0.0F;
  public float f = 0.0F;
  public float g = 0.0F;
  public float h = 0.0F;
  public float i;
  public float j;
  protected Bitmap k;
  protected long l;
  private Matrix m = new Matrix();
  private Paint n = new Paint();
  private float o;
  private float p;
  private float q;
  private long r;
  private int s;
  private int t;
  private List<Hz> u;
  
  protected Hx() {}
  
  public Hx(Bitmap paramBitmap)
  {
    this();
    this.k = paramBitmap;
  }
  
  public Hx a(long paramLong, List<Hz> paramList)
  {
    this.l = paramLong;
    this.u = paramList;
    return this;
  }
  
  public void a()
  {
    this.c = 1.0F;
    this.d = 255;
  }
  
  public void a(long paramLong, float paramFloat1, float paramFloat2)
  {
    this.s = (this.k.getWidth() / 2);
    this.t = (this.k.getHeight() / 2);
    this.o = (paramFloat1 - this.s);
    this.p = (paramFloat2 - this.t);
    this.a = this.o;
    this.b = this.p;
    this.r = paramLong;
  }
  
  public void a(Canvas paramCanvas)
  {
    this.m.reset();
    this.m.postRotate(this.q, this.s, this.t);
    this.m.postScale(this.c, this.c, this.s, this.t);
    this.m.postTranslate(this.a, this.b);
    this.n.setAlpha(this.d);
    paramCanvas.drawBitmap(this.k, this.m, this.n);
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = false;
    long l1 = paramLong - this.l;
    if (l1 > this.r) {}
    for (;;)
    {
      return bool;
      this.a = (this.o + this.g * (float)l1 + this.i * (float)l1 * (float)l1);
      this.b = (this.p + this.h * (float)l1 + this.j * (float)l1 * (float)l1);
      this.q = (this.e + this.f * (float)l1 / 1000.0F);
      for (int i1 = 0; i1 < this.u.size(); i1++) {
        ((Hz)this.u.get(i1)).a(this, l1);
      }
      bool = true;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Hx
 * JD-Core Version:    0.7.0.1
 */