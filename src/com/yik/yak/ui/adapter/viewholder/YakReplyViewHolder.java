package com.yik.yak.ui.adapter.viewholder;

import ApplicationConfig;
import CK;
import EN;
import EV;
import Ij;
import Ik;
import Io;
import android.graphics.Typeface;
import android.text.Html;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.yik.yak.ui.view.IdentityView;
import com.yik.yak.ui.view.VoteView;

public class YakReplyViewHolder
  extends EV<CK>
{
  public static final int CONTEXT_MENU_ID_DELETE = 1;
  public static final int CONTEXT_MENU_ID_REPORT = 2;
  public static final int CONTEXT_MENU_ID_SHARE;
  @InjectView(2131558767)
  protected RelativeLayout mContentLayout;
  @InjectView(2131558761)
  protected TextView mDeletedStatusText;
  @InjectView(2131558768)
  protected IdentityView mIdentityView;
  @InjectView(2131558763)
  protected ImageView mLoadingIcon;
  @InjectView(2131558762)
  protected RelativeLayout mLoadingLayout;
  @InjectView(2131558770)
  protected TextView mReplyBody;
  @InjectView(2131558769)
  protected TextView mTimeSinceTextLabel;
  @InjectView(2131558771)
  protected View mUnderline;
  protected boolean mUseLeftVoteLayout = false;
  @InjectView(2131558580)
  protected VoteView mVoteView;
  protected CK yak;
  
  public YakReplyViewHolder(EN paramEN, View paramView)
  {
    super(paramEN, paramView);
    ButterKnife.inject(this, paramView);
    this.mUseLeftVoteLayout = ApplicationConfig.m().equals("left");
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.mVoteView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.mIdentityView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)this.mReplyBody.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams4 = (RelativeLayout.LayoutParams)this.mTimeSinceTextLabel.getLayoutParams();
    if (this.mUseLeftVoteLayout)
    {
      localLayoutParams1.addRule(11, 0);
      localLayoutParams1.addRule(9);
      localLayoutParams1.setMargins(0, 0, Ik.a(12), 0);
      localLayoutParams2.addRule(9, 0);
      localLayoutParams2.addRule(11);
      localLayoutParams2.setMargins(0, Ik.a(3), 0, 0);
      localLayoutParams3.addRule(0, 2131558768);
      localLayoutParams3.addRule(1, 2131558580);
      localLayoutParams4.addRule(9, 0);
      localLayoutParams4.addRule(11);
    }
    for (;;)
    {
      this.mVoteView.setLayoutParams(localLayoutParams1);
      this.mIdentityView.setLayoutParams(localLayoutParams2);
      this.mReplyBody.setLayoutParams(localLayoutParams3);
      this.mTimeSinceTextLabel.setLayoutParams(localLayoutParams4);
      return;
      localLayoutParams1.addRule(9, 0);
      localLayoutParams1.addRule(11);
      localLayoutParams1.setMargins(0, 0, Ik.a(3), 0);
      localLayoutParams2.addRule(11, 0);
      localLayoutParams2.addRule(9);
      localLayoutParams2.setMargins(0, Ik.a(5), Ik.a(12), 0);
      localLayoutParams3.addRule(0, 2131558580);
      localLayoutParams3.addRule(1, 2131558768);
      localLayoutParams4.addRule(11, 0);
      localLayoutParams4.addRule(9);
    }
  }
  
  private boolean handleLoading()
  {
    CK localCK = (CK)getItem();
    if (localCK.a)
    {
      this.mLoadingLayout.setVisibility(0);
      this.mContentLayout.setVisibility(8);
      this.mLoadingIcon.clearAnimation();
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setDuration(1000L);
      this.mLoadingIcon.startAnimation(localRotateAnimation);
    }
    for (;;)
    {
      return localCK.a;
      this.mLoadingLayout.setVisibility(8);
      this.mContentLayout.setVisibility(0);
    }
  }
  
  private void handleReplierIdentity(CK paramCK)
  {
    String str1 = Ij.a(paramCK.q);
    String str2 = Ij.b(paramCK.p);
    if ((Ik.a(paramCK.q)) && (Ik.a(paramCK.p))) {
      this.mIdentityView.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.mIdentityView.setVisibility(0);
      this.mIdentityView.setUrlForBackground(str1);
      this.mIdentityView.setUrlForForeground(str2);
    }
  }
  
  private void setViewStyle(CK paramCK, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.mReplyBody.setTextColor(paramInt3);
    if (paramBoolean1)
    {
      this.mVoteView.setVisibility(0);
      if (((paramBoolean2) || (paramBoolean5)) && (!Ik.a(paramCK.D)))
      {
        if (!paramBoolean2) {
          break label78;
        }
        this.mReplyBody.setAutoLinkMask(15);
      }
    }
    for (;;)
    {
      this.mReplyBody.setLinksClickable(paramBoolean3);
      return;
      this.mVoteView.setVisibility(8);
      break;
      label78:
      this.mReplyBody.setAutoLinkMask(0);
    }
  }
  
  private void setYakToDeletedStyle(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mDeletedStatusText.setVisibility(0);
      this.mContentLayout.setVisibility(8);
      this.mDeletedStatusText.setText(((CK)getItem()).o);
      this.mUnderline.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.mDeletedStatusText.setVisibility(8);
      this.mContentLayout.setVisibility(0);
      this.mUnderline.setVisibility(0);
    }
  }
  
  public void onBindView(CK paramCK)
  {
    if (handleLoading())
    {
      this.mVoteView.setYak(paramCK);
      return;
    }
    this.mTimeSinceTextLabel.setText(new Io().a(paramCK.m));
    this.mVoteView.setYak(paramCK);
    setYakToDeletedStyle(paramCK.x);
    if (!paramCK.x) {}
    switch (paramCK.h)
    {
    default: 
      setViewStyle(paramCK, -1, -1, getColor(2131427546), getColor(2131427551), true, false, false, true, false);
      label134:
      if (paramCK.r.equals("OP")) {
        this.mReplyBody.setTextColor(getColor(2131427549));
      }
      break;
    }
    for (;;)
    {
      handleReplierIdentity(paramCK);
      this.mReplyBody.setText(paramCK.l);
      break;
      setViewStyle(paramCK, -1, -1, getColor(2131427546), getColor(2131427551), true, false, false, true, false);
      break label134;
      setViewStyle(paramCK, getColor(2131427549), getColor(2131427549), -1, -1, false, false, false, false, false);
      break label134;
      setViewStyle(paramCK, -256, -256, -16777216, -16777216, false, false, false, false, false);
      break label134;
      setViewStyle(paramCK, -65536, -65536, -1, -1, false, true, true, false, false);
      break label134;
      setViewStyle(paramCK, -1, -1, getColor(2131427546), -16776961, false, true, false, false, false);
      break label134;
      setViewStyle(paramCK, -1, -1, getColor(2131427546), getColor(2131427551), true, true, false, true, false);
      break label134;
      int i = getColor(2131427546);
      int j = getColor(2131427551);
      if (!Ik.a(paramCK.z)) {}
      for (boolean bool = true;; bool = false)
      {
        setViewStyle(paramCK, -1, -1, i, j, true, true, false, true, bool);
        break;
      }
      this.mReplyBody.setTypeface(Typeface.DEFAULT);
    }
  }
  
  public boolean onClick(View paramView)
  {
    return super.onClick(paramView);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if ((!((CK)getItem()).x) && (!((CK)getItem()).a))
    {
      paramView.setTag(getItem());
      paramContextMenu.add(0, 0, 0, Html.fromHtml("Share")).setActionView(paramView);
      if (!((CK)getItem()).j.equals(BV.getYakkerID())) {
        break label99;
      }
      paramContextMenu.add(0, 1, 0, getString(2131230893)).setActionView(paramView);
    }
    for (;;)
    {
      return;
      label99:
      if (((CK)getItem()).H) {
        paramContextMenu.add(0, 2, 0, getString(2131230968)).setActionView(paramView);
      }
    }
  }
  
  public boolean onDoubleClick(View paramView)
  {
    if (BV.l()) {
      this.mVoteView.a();
    }
    for (;;)
    {
      return false;
      broadcastClick();
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.yik.yak.ui.adapter.viewholder.YakReplyViewHolder

 * JD-Core Version:    0.7.0.1

 */