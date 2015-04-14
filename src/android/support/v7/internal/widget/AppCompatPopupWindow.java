package android.support.v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

public class AppCompatPopupWindow
  extends PopupWindow
{
  private final boolean mOverlapAnchor;
  
  public AppCompatPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.PopupWindow, paramInt, 0);
    this.mOverlapAnchor = localTintTypedArray.getBoolean(R.styleable.PopupWindow_overlapAnchor, false);
    setBackgroundDrawable(localTintTypedArray.getDrawable(R.styleable.PopupWindow_android_popupBackground));
    localTintTypedArray.recycle();
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    if ((Build.VERSION.SDK_INT < 21) && (this.mOverlapAnchor)) {
      paramInt2 -= paramView.getHeight();
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  @TargetApi(19)
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((Build.VERSION.SDK_INT < 21) && (this.mOverlapAnchor)) {
      paramInt2 -= paramView.getHeight();
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void update(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((Build.VERSION.SDK_INT < 21) && (this.mOverlapAnchor)) {}
    for (int i = paramInt2 - paramView.getHeight();; i = paramInt2)
    {
      super.update(paramView, paramInt1, i, paramInt3, paramInt4);
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.AppCompatPopupWindow
 * JD-Core Version:    0.7.0.1
 */