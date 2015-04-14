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

final class FragmentTransitionCompat21$2
  implements ViewTreeObserver.OnPreDrawListener
{
  FragmentTransitionCompat21$2(View paramView, FragmentTransitionCompat21.ViewRetriever paramViewRetriever, Map paramMap1, Map paramMap2, Transition paramTransition, ArrayList paramArrayList) {}
  
  public boolean onPreDraw()
  {
    this.val$container.getViewTreeObserver().removeOnPreDrawListener(this);
    View localView1 = this.val$inFragment.getView();
    if (localView1 != null)
    {
      if (!this.val$nameOverrides.isEmpty())
      {
        FragmentTransitionCompat21.findNamedViews(this.val$renamedViews, localView1);
        this.val$renamedViews.keySet().retainAll(this.val$nameOverrides.values());
        Iterator localIterator = this.val$nameOverrides.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str = (String)localEntry.getValue();
          View localView2 = (View)this.val$renamedViews.get(str);
          if (localView2 != null) {
            localView2.setTransitionName((String)localEntry.getKey());
          }
        }
      }
      if (this.val$enterTransition != null)
      {
        FragmentTransitionCompat21.access$000(this.val$enteringViews, localView1);
        this.val$enteringViews.removeAll(this.val$renamedViews.values());
        FragmentTransitionCompat21.addTargets(this.val$enterTransition, this.val$enteringViews);
      }
    }
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentTransitionCompat21.2
 * JD-Core Version:    0.7.0.1
 */