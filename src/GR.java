import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class GR
  implements CompoundButton.OnCheckedChangeListener
{
  GR(GI paramGI) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ApplicationConfig.a(paramBoolean);
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     GR

 * JD-Core Version:    0.7.0.1

 */