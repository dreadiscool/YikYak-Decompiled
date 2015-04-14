package com.yik.yak.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FamousActivity$$ViewInjector<T extends FamousActivity>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    paramT.mRecyclerView = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558492, "field 'mRecyclerView'"), 2131558492, "field 'mRecyclerView'"));
    paramT.imgShareCardPreview = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558484, "field 'imgShareCardPreview'"), 2131558484, "field 'imgShareCardPreview'"));
    paramT.txtShareFamous = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558493, "field 'txtShareFamous'"), 2131558493, "field 'txtShareFamous'"));
  }
  
  public void reset(T paramT)
  {
    paramT.mRecyclerView = null;
    paramT.imgShareCardPreview = null;
    paramT.txtShareFamous = null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.activity.FamousActivity..ViewInjector
 * JD-Core Version:    0.7.0.1
 */