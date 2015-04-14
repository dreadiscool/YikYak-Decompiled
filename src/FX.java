import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import java.util.List;

class FX
  implements AdapterView.OnItemClickListener
{
  FX(FV paramFV) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((FV.b(this.a) == null) || (FV.b(this.a).size() == 0)) {}
    for (;;)
    {
      return;
      FV.a(this.a, (CG)FV.b(this.a).get(paramInt));
      if (FV.c(this.a) != null)
      {
        this.a.c.startAnimation(this.a.d);
        this.a.c.setVisibility(0);
        FV.a(this.a).findViewById(2131558670).setVisibility(0);
        FV.a(this.a).findViewById(2131558656).setVisibility(0);
        this.a.b = true;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     FX
 * JD-Core Version:    0.7.0.1
 */