package android.support.v4.app;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class FragmentTransitionCompat21$4
  implements ViewTreeObserver.OnPreDrawListener
{
  FragmentTransitionCompat21$4(View paramView1, Transition paramTransition1, View paramView2, ArrayList paramArrayList1, Transition paramTransition2, ArrayList paramArrayList2, Transition paramTransition3, ArrayList paramArrayList3, Map paramMap, ArrayList paramArrayList4, Transition paramTransition4) {}
  
  public boolean onPreDraw()
  {
    this.val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
    if (this.val$enterTransition != null)
    {
      this.val$enterTransition.removeTarget(this.val$nonExistentView);
      FragmentTransitionCompat21.removeTargets(this.val$enterTransition, this.val$enteringViews);
    }
    if (this.val$exitTransition != null) {
      FragmentTransitionCompat21.removeTargets(this.val$exitTransition, this.val$exitingViews);
    }
    if (this.val$sharedElementTransition != null) {
      FragmentTransitionCompat21.removeTargets(this.val$sharedElementTransition, this.val$sharedElementTargets);
    }
    Iterator localIterator = this.val$renamedViews.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((View)localEntry.getValue()).setTransitionName((String)localEntry.getKey());
    }
    int i = this.val$hiddenViews.size();
    for (int j = 0; j < i; j++) {
      this.val$overallTransition.excludeTarget((View)this.val$hiddenViews.get(j), false);
    }
    this.val$overallTransition.excludeTarget(this.val$nonExistentView, false);
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentTransitionCompat21.4
 * JD-Core Version:    0.7.0.1
 */