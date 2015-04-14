package com.yik.yak.ui.view;

import Hp;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class PhotoLinkCardView$$ViewInjector<T extends PhotoLinkCardView>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    paramT.mImageView = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558796, "field 'mImageView'"), 2131558796, "field 'mImageView'"));
    paramT.mLinkDetails = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558797, "field 'mLinkDetails'"), 2131558797, "field 'mLinkDetails'"));
    paramT.mLinkTitle = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558798, "field 'mLinkTitle'"), 2131558798, "field 'mLinkTitle'"));
    paramT.mLinkDescription = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558799, "field 'mLinkDescription'"), 2131558799, "field 'mLinkDescription'"));
    paramT.mLink = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558800, "field 'mLink'"), 2131558800, "field 'mLink'"));
    paramT.setOnClickListener(new Hp(this, paramT));
  }
  
  public void reset(T paramT)
  {
    paramT.mImageView = null;
    paramT.mLinkDetails = null;
    paramT.mLinkTitle = null;
    paramT.mLinkDescription = null;
    paramT.mLink = null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.view.PhotoLinkCardView..ViewInjector
 * JD-Core Version:    0.7.0.1
 */