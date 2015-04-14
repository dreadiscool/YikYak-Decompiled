import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.widget.ImageView;

class HX
  implements Runnable
{
  private final Ic b;
  private int c;
  private int d;
  
  public HX(HT paramHT, Context paramContext)
  {
    this.b = Ic.a(paramContext);
  }
  
  public void a()
  {
    if (HT.m()) {
      HP.a();
    }
    this.b.a(true);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RectF localRectF = this.a.b();
    if (localRectF == null) {
      return;
    }
    int i = Math.round(-localRectF.left);
    int j;
    int k;
    label53:
    int m;
    int n;
    if (paramInt1 < localRectF.width())
    {
      j = Math.round(localRectF.width() - paramInt1);
      k = 0;
      m = Math.round(-localRectF.top);
      if (paramInt2 >= localRectF.height()) {
        break label216;
      }
      n = Math.round(localRectF.height() - paramInt2);
    }
    for (int i1 = 0;; i1 = m)
    {
      this.c = i;
      this.d = m;
      if (HT.m())
      {
        HP.a();
        new StringBuilder().append("fling. StartX:").append(i).append(" StartY:").append(m).append(" MaxX:").append(j).append(" MaxY:").append(n).toString();
      }
      if ((i == j) && (m == n)) {
        break;
      }
      this.b.a(i, m, paramInt3, paramInt4, k, j, i1, n, 0, 0);
      break;
      j = i;
      k = i;
      break label53;
      label216:
      n = m;
    }
  }
  
  public void run()
  {
    if (this.b.b()) {}
    for (;;)
    {
      return;
      ImageView localImageView = this.a.c();
      if ((localImageView != null) && (this.b.a()))
      {
        int i = this.b.c();
        int j = this.b.d();
        if (HT.m())
        {
          HP.a();
          new StringBuilder().append("fling run(). CurrentX:").append(this.c).append(" CurrentY:").append(this.d).append(" NewX:").append(i).append(" NewY:").append(j).toString();
        }
        HT.b(this.a).postTranslate(this.c - i, this.d - j);
        HT.a(this.a, this.a.l());
        this.c = i;
        this.d = j;
        HF.a(localImageView, this);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     HX
 * JD-Core Version:    0.7.0.1
 */