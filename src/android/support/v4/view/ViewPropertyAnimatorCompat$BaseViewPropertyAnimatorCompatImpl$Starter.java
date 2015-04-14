package android.support.v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

class ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl$Starter
  implements Runnable
{
  WeakReference<View> mViewRef;
  ViewPropertyAnimatorCompat mVpa;
  
  private ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl$Starter(ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl paramBaseViewPropertyAnimatorCompatImpl, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
  {
    this.mViewRef = new WeakReference(paramView);
    this.mVpa = paramViewPropertyAnimatorCompat;
  }
  
  public void run()
  {
    ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl.access$200(this.this$0, this.mVpa, (View)this.mViewRef.get());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl.Starter
 * JD-Core Version:    0.7.0.1
 */