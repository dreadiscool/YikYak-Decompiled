package com.yik.yak.ui.fragment;

import Fo;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class CommentFragment$$ViewInjector<T extends CommentFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    paramT.mReplyField = ((EditText)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558634, "field 'mReplyField'"), 2131558634, "field 'mReplyField'"));
    View localView = (View)paramFinder.findRequiredView(paramObject, 2131558633, "field 'mSendButton' and method 'onSendCommentClicked'");
    paramT.mSendButton = ((Button)paramFinder.castView(localView, 2131558633, "field 'mSendButton'"));
    localView.setOnClickListener(new Fo(this, paramT));
    paramT.mCommentFooter = ((RelativeLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558632, "field 'mCommentFooter'"), 2131558632, "field 'mCommentFooter'"));
  }
  
  public void reset(T paramT)
  {
    paramT.mReplyField = null;
    paramT.mSendButton = null;
    paramT.mCommentFooter = null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.fragment.CommentFragment..ViewInjector
 * JD-Core Version:    0.7.0.1
 */