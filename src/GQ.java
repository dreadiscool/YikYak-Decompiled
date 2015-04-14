import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;

class GQ
  implements CompoundButton.OnCheckedChangeListener
{
  GQ(GI paramGI, View paramView) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ApplicationConfig.d(paramBoolean);
    ((Switch)GI.b(this.b).findViewById(2131558718)).setEnabled(paramBoolean);
    if (paramBoolean)
    {
      EW localEW1 = new EW(this.a, 250, 0);
      localEW1.a(GI.c(this.b));
      this.a.startAnimation(localEW1);
    }
    for (;;)
    {
      return;
      EW localEW2 = new EW(this.a, 250, 1);
      this.a.startAnimation(localEW2);
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     GQ

 * JD-Core Version:    0.7.0.1

 */