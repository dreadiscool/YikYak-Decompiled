import android.app.ActionBar;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.yik.yak.ui.activity.MainActivity;

public class Dm
  implements ViewPager.OnPageChangeListener
{
  public Dm(MainActivity paramMainActivity) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    MainActivity.a(this.a).setSelectedNavigationItem(paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Dm
 * JD-Core Version:    0.7.0.1
 */