import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

class FL
  implements View.OnClickListener
{
  FL(FH paramFH) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    FH localFH;
    if (FH.d(this.a))
    {
      FH.b(this.a).setImageResource(2130837737);
      FH.a(this.a, FH.c(this.a), false);
      localFH = this.a;
      if (FH.d(this.a)) {
        break label122;
      }
    }
    for (;;)
    {
      FH.a(localFH, bool);
      return;
      FH.b(this.a).setImageResource(2130837736);
      FH.a(this.a, FH.c(this.a), bool);
      if (!FH.c(this.a).getText().equals("")) {
        break;
      }
      FH.c(this.a).requestFocus();
      break;
      label122:
      bool = false;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     FL
 * JD-Core Version:    0.7.0.1
 */