import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;

class FK
  implements View.OnFocusChangeListener
{
  FK(FH paramFH) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      FH.b(this.a).setImageResource(2130837736);
    }
    FH.a(this.a, FH.c(this.a), true);
    FH.a(this.a, true);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     FK
 * JD-Core Version:    0.7.0.1
 */