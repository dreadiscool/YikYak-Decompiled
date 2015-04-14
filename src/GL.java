import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class GL
  implements CompoundButton.OnCheckedChangeListener
{
  GL(GI paramGI) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ApplicationConfig.h(paramBoolean);
    If.a().a(paramBoolean);
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     GL

 * JD-Core Version:    0.7.0.1

 */