package com.yik.yak.ui.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.yik.yak.ui.view.IdentityView;
import com.yik.yak.ui.view.VoteView;

public class YakReplyViewHolder$$ViewInjector<T extends YakReplyViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    paramT.mContentLayout = ((RelativeLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558767, "field 'mContentLayout'"), 2131558767, "field 'mContentLayout'"));
    paramT.mIdentityView = ((IdentityView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558768, "field 'mIdentityView'"), 2131558768, "field 'mIdentityView'"));
    paramT.mReplyBody = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558770, "field 'mReplyBody'"), 2131558770, "field 'mReplyBody'"));
    paramT.mVoteView = ((VoteView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558580, "field 'mVoteView'"), 2131558580, "field 'mVoteView'"));
    paramT.mTimeSinceTextLabel = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558769, "field 'mTimeSinceTextLabel'"), 2131558769, "field 'mTimeSinceTextLabel'"));
    paramT.mDeletedStatusText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558761, "field 'mDeletedStatusText'"), 2131558761, "field 'mDeletedStatusText'"));
    paramT.mLoadingLayout = ((RelativeLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558762, "field 'mLoadingLayout'"), 2131558762, "field 'mLoadingLayout'"));
    paramT.mLoadingIcon = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558763, "field 'mLoadingIcon'"), 2131558763, "field 'mLoadingIcon'"));
    paramT.mUnderline = ((View)paramFinder.findRequiredView(paramObject, 2131558771, "field 'mUnderline'"));
  }
  
  public void reset(T paramT)
  {
    paramT.mContentLayout = null;
    paramT.mIdentityView = null;
    paramT.mReplyBody = null;
    paramT.mVoteView = null;
    paramT.mTimeSinceTextLabel = null;
    paramT.mDeletedStatusText = null;
    paramT.mLoadingLayout = null;
    paramT.mLoadingIcon = null;
    paramT.mUnderline = null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.adapter.viewholder.YakReplyViewHolder..ViewInjector
 * JD-Core Version:    0.7.0.1
 */