import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class Ge
  implements View.OnClickListener
{
  Ge(Gd paramGd) {}
  
  public void onClick(View paramView)
  {
    if (((TextView)paramView).getText().toString().equals("NOTIFICATIONS")) {
      this.a.a(Gn.a, true);
    }
    for (;;)
    {
      return;
      this.a.a(Gn.b, false);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ge
 * JD-Core Version:    0.7.0.1
 */