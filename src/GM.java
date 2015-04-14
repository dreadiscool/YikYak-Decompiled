import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class GM
  implements CompoundButton.OnCheckedChangeListener
{
  GM(GI paramGI) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ApplicationConfig.g(paramBoolean);
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     GM

 * JD-Core Version:    0.7.0.1

 */