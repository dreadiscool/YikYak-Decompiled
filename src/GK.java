import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class GK
  implements CompoundButton.OnCheckedChangeListener
{
  GK(GI paramGI) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ApplicationConfig.e(false);
    if (paramBoolean) {
      GI.a(this.a);
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     GK

 * JD-Core Version:    0.7.0.1

 */