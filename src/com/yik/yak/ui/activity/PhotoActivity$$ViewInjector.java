package com.yik.yak.ui.activity;

import android.view.View;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class PhotoActivity$$ViewInjector<T extends PhotoActivity>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    paramT.mImageView = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558507, "field 'mImageView'"), 2131558507, "field 'mImageView'"));
  }
  
  public void reset(T paramT)
  {
    paramT.mImageView = null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.activity.PhotoActivity..ViewInjector
 * JD-Core Version:    0.7.0.1
 */