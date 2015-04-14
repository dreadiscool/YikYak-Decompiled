package com.yik.yak.ui.adapter.viewholder;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.yik.yak.ui.view.PhotoLinkCardView;
import com.yik.yak.ui.view.VoteView;

public class YakViewHolder$$ViewInjector<T extends YakViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    paramT.txtAge = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558582, "field 'txtAge'"), 2131558582, "field 'txtAge'"));
    paramT.pnlMessage = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558752, "field 'pnlMessage'"), 2131558752, "field 'pnlMessage'"));
    paramT.txtHandle = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558578, "field 'txtHandle'"), 2131558578, "field 'txtHandle'"));
    paramT.txtContent = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558759, "field 'txtContent'"), 2131558759, "field 'txtContent'"));
    paramT.txtComments = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558583, "field 'txtComments'"), 2131558583, "field 'txtComments'"));
    paramT.pnlStatus = ((View)paramFinder.findRequiredView(paramObject, 2131558760, "field 'pnlStatus'"));
    paramT.voteView = ((VoteView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558580, "field 'voteView'"), 2131558580, "field 'voteView'"));
    paramT.pnlContainer = ((RelativeLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558758, "field 'pnlContainer'"), 2131558758, "field 'pnlContainer'"));
    paramT.cardView = ((CardView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558756, "field 'cardView'"), 2131558756, "field 'cardView'"));
    paramT.mPhotoLinkCardView = ((PhotoLinkCardView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558795, "field 'mPhotoLinkCardView'"), 2131558795, "field 'mPhotoLinkCardView'"));
    paramT.mContentLayout = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558757, "field 'mContentLayout'"), 2131558757, "field 'mContentLayout'"));
    paramT.mDeletedStatusText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558761, "field 'mDeletedStatusText'"), 2131558761, "field 'mDeletedStatusText'"));
    paramT.mLoadingLayout = ((RelativeLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558762, "field 'mLoadingLayout'"), 2131558762, "field 'mLoadingLayout'"));
    paramT.mLoadingIcon = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558763, "field 'mLoadingIcon'"), 2131558763, "field 'mLoadingIcon'"));
  }
  
  public void reset(T paramT)
  {
    paramT.txtAge = null;
    paramT.pnlMessage = null;
    paramT.txtHandle = null;
    paramT.txtContent = null;
    paramT.txtComments = null;
    paramT.pnlStatus = null;
    paramT.voteView = null;
    paramT.pnlContainer = null;
    paramT.cardView = null;
    paramT.mPhotoLinkCardView = null;
    paramT.mContentLayout = null;
    paramT.mDeletedStatusText = null;
    paramT.mLoadingLayout = null;
    paramT.mLoadingIcon = null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.adapter.viewholder.YakViewHolder..ViewInjector
 * JD-Core Version:    0.7.0.1
 */