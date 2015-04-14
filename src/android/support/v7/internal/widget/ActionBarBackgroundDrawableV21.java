package android.support.v7.internal.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class ActionBarBackgroundDrawableV21
  extends ActionBarBackgroundDrawable
{
  public ActionBarBackgroundDrawableV21(ActionBarContainer paramActionBarContainer)
  {
    super(paramActionBarContainer);
  }
  
  public void getOutline(Outline paramOutline)
  {
    if (this.mContainer.mIsSplit) {
      if (this.mContainer.mSplitBackground != null) {
        this.mContainer.mSplitBackground.getOutline(paramOutline);
      }
    }
    for (;;)
    {
      return;
      if (this.mContainer.mBackground != null) {
        this.mContainer.mBackground.getOutline(paramOutline);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarBackgroundDrawableV21
 * JD-Core Version:    0.7.0.1
 */