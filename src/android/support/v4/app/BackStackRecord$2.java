package android.support.v4.app;

import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;

class BackStackRecord$2
  implements ViewTreeObserver.OnPreDrawListener
{
  BackStackRecord$2(BackStackRecord paramBackStackRecord, View paramView, Object paramObject, ArrayList paramArrayList, BackStackRecord.TransitionState paramTransitionState, boolean paramBoolean, Fragment paramFragment1, Fragment paramFragment2) {}
  
  public boolean onPreDraw()
  {
    this.val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
    ArrayMap localArrayMap;
    if (this.val$sharedElementTransition != null)
    {
      FragmentTransitionCompat21.removeTargets(this.val$sharedElementTransition, this.val$sharedElementTargets);
      this.val$sharedElementTargets.clear();
      localArrayMap = BackStackRecord.access$000(this.this$0, this.val$state, this.val$isBack, this.val$inFragment);
      if (!localArrayMap.isEmpty()) {
        break label127;
      }
      this.val$sharedElementTargets.add(this.val$state.nonExistentView);
    }
    for (;;)
    {
      FragmentTransitionCompat21.addTargets(this.val$sharedElementTransition, this.val$sharedElementTargets);
      BackStackRecord.access$100(this.this$0, localArrayMap, this.val$state);
      BackStackRecord.access$200(this.this$0, this.val$state, this.val$inFragment, this.val$outFragment, this.val$isBack, localArrayMap);
      return true;
      label127:
      this.val$sharedElementTargets.addAll(localArrayMap.values());
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.BackStackRecord.2
 * JD-Core Version:    0.7.0.1
 */