package com.yik.yak.ui.adapter.viewholder;

import EQ;
import ER;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.yik.yak.ui.view.PhotoLinkCardView;
import com.yik.yak.ui.view.VoteView;

public class YakDetailViewHolder$$ViewInjector<T extends YakDetailViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    paramT.txtAge = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558582, "field 'txtAge'"), 2131558582, "field 'txtAge'"));
    paramT.txtHandle = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558578, "field 'txtHandle'"), 2131558578, "field 'txtHandle'"));
    View localView1 = (View)paramFinder.findRequiredView(paramObject, 2131558579, "field 'txtContent' and method 'openUrl'");
    paramT.txtContent = ((TextView)paramFinder.castView(localView1, 2131558579, "field 'txtContent'"));
    localView1.setOnClickListener(new EQ(this, paramT));
    paramT.txtComments = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558583, "field 'txtComments'"), 2131558583, "field 'txtComments'"));
    paramT.voteView = ((VoteView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558580, "field 'voteView'"), 2131558580, "field 'voteView'"));
    paramT.mPhotoLinkCardView = ((PhotoLinkCardView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558795, "field 'mPhotoLinkCardView'"), 2131558795, "field 'mPhotoLinkCardView'"));
    paramT.mShareIcon = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558766, "field 'mShareIcon'"), 2131558766, "field 'mShareIcon'"));
    View localView2 = (View)paramFinder.findRequiredView(paramObject, 2131558584, "field 'shareButton' and method 'onClick'");
    paramT.shareButton = ((TextView)paramFinder.castView(localView2, 2131558584, "field 'shareButton'"));
    localView2.setOnClickListener(new ER(this, paramT));
    paramT.mMessageBody = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558765, "field 'mMessageBody'"), 2131558765, "field 'mMessageBody'"));
  }
  
  public void reset(T paramT)
  {
    paramT.txtAge = null;
    paramT.txtHandle = null;
    paramT.txtContent = null;
    paramT.txtComments = null;
    paramT.voteView = null;
    paramT.mPhotoLinkCardView = null;
    paramT.mShareIcon = null;
    paramT.shareButton = null;
    paramT.mMessageBody = null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.adapter.viewholder.YakDetailViewHolder..ViewInjector
 * JD-Core Version:    0.7.0.1
 */