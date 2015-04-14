package com.yik.yak.ui.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.yik.yak.ui.pullrefresh.PullRefreshLayout;

public class RefreshListView$$ViewInjector<T extends RefreshListView>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    paramT.refreshImage = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558504, "field 'refreshImage'"), 2131558504, "field 'refreshImage'"));
    paramT.noYaksImage = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558505, "field 'noYaksImage'"), 2131558505, "field 'noYaksImage'"));
    paramT.pullToRefreshLayout = ((PullRefreshLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558802, "field 'pullToRefreshLayout'"), 2131558802, "field 'pullToRefreshLayout'"));
    paramT.recyclerView = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558506, "field 'recyclerView'"), 2131558506, "field 'recyclerView'"));
  }
  
  public void reset(T paramT)
  {
    paramT.refreshImage = null;
    paramT.noYaksImage = null;
    paramT.pullToRefreshLayout = null;
    paramT.recyclerView = null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.view.RefreshListView..ViewInjector
 * JD-Core Version:    0.7.0.1
 */