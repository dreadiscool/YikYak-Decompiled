package android.support.v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.View;

@TargetApi(11)
public class NativeActionModeAwareLayout
  extends ContentFrameLayout
{
  private NativeActionModeAwareLayout.OnActionModeForChildListener mActionModeForChildListener;
  
  public NativeActionModeAwareLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void setActionModeForChildListener(NativeActionModeAwareLayout.OnActionModeForChildListener paramOnActionModeForChildListener)
  {
    this.mActionModeForChildListener = paramOnActionModeForChildListener;
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback)
  {
    if (this.mActionModeForChildListener != null) {}
    for (ActionMode localActionMode = this.mActionModeForChildListener.startActionModeForChild(paramView, paramCallback);; localActionMode = super.startActionModeForChild(paramView, paramCallback)) {
      return localActionMode;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.NativeActionModeAwareLayout
 * JD-Core Version:    0.7.0.1
 */