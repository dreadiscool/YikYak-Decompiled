import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class GN
  implements CompoundButton.OnCheckedChangeListener
{
  GN(GI paramGI) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ApplicationConfig.f(paramBoolean);
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     GN

 * JD-Core Version:    0.7.0.1

 */