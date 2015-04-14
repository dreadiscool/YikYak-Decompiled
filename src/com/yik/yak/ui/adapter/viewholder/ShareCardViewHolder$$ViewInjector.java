package com.yik.yak.ui.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class ShareCardViewHolder$$ViewInjector<T extends ShareCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    paramT.imgShareCard = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558484, "field 'imgShareCard'"), 2131558484, "field 'imgShareCard'"));
    paramT.txtShareCardCaption = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558753, "field 'txtShareCardCaption'"), 2131558753, "field 'txtShareCardCaption'"));
  }
  
  public void reset(T paramT)
  {
    paramT.imgShareCard = null;
    paramT.txtShareCardCaption = null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.adapter.viewholder.ShareCardViewHolder..ViewInjector
 * JD-Core Version:    0.7.0.1
 */