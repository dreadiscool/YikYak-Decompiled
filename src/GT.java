import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class GT
  implements View.OnClickListener
{
  private int a = 0;
  private int b;
  private View c;
  private EN d;
  
  public GT(EN paramEN, View paramView, int paramInt)
  {
    this.d = paramEN;
    this.c = paramView;
    this.b = paramInt;
  }
  
  public abstract void a(EN paramEN, View paramView, int paramInt);
  
  public abstract void b(EN paramEN, View paramView, int paramInt);
  
  public void onClick(View paramView)
  {
    this.a = (1 + this.a);
    Handler localHandler = new Handler();
    GU localGU = new GU(this);
    if (this.a == 1) {
      localHandler.postDelayed(localGU, 200L);
    }
    for (;;)
    {
      return;
      if (this.a == 2)
      {
        localHandler.removeCallbacks(localGU);
        this.a = 0;
        b(this.d, this.c, this.b);
      }
      else
      {
        this.a = 0;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     GT
 * JD-Core Version:    0.7.0.1
 */