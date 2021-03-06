package android.support.v4.view;

import android.database.DataSetObserver;

class PagerTitleStrip$PageListener
  extends DataSetObserver
  implements ViewPager.OnAdapterChangeListener, ViewPager.OnPageChangeListener
{
  private int mScrollState;
  
  private PagerTitleStrip$PageListener(PagerTitleStrip paramPagerTitleStrip) {}
  
  public void onAdapterChanged(PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2)
  {
    this.this$0.updateAdapter(paramPagerAdapter1, paramPagerAdapter2);
  }
  
  public void onChanged()
  {
    float f = 0.0F;
    this.this$0.updateText(this.this$0.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
    if (PagerTitleStrip.access$100(this.this$0) >= 0.0F) {
      f = PagerTitleStrip.access$100(this.this$0);
    }
    this.this$0.updateTextPositions(this.this$0.mPager.getCurrentItem(), f, true);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.mScrollState = paramInt;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramFloat > 0.5F) {
      paramInt1++;
    }
    this.this$0.updateTextPositions(paramInt1, paramFloat, false);
  }
  
  public void onPageSelected(int paramInt)
  {
    float f = 0.0F;
    if (this.mScrollState == 0)
    {
      this.this$0.updateText(this.this$0.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
      if (PagerTitleStrip.access$100(this.this$0) >= 0.0F) {
        f = PagerTitleStrip.access$100(this.this$0);
      }
      this.this$0.updateTextPositions(this.this$0.mPager.getCurrentItem(), f, true);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.PagerTitleStrip.PageListener
 * JD-Core Version:    0.7.0.1
 */