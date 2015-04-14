package android.support.v4.view;

import android.view.View;
import android.view.View.OnClickListener;

class PagerTabStrip$2
  implements View.OnClickListener
{
  PagerTabStrip$2(PagerTabStrip paramPagerTabStrip) {}
  
  public void onClick(View paramView)
  {
    this.this$0.mPager.setCurrentItem(1 + this.this$0.mPager.getCurrentItem());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.PagerTabStrip.2
 * JD-Core Version:    0.7.0.1
 */