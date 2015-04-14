import android.view.View;
import android.view.View.OnClickListener;
import com.yik.yak.ui.activity.MainActivity;

class GJ
  implements View.OnClickListener
{
  GJ(GI paramGI) {}
  
  public void onClick(View paramView)
  {
    String str = paramView.getTag().toString();
    ApplicationConfig.e(str);
    GI.a(this.a, str);
    ((MainActivity)this.a.getActivity()).d();
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     GJ

 * JD-Core Version:    0.7.0.1

 */