package com.yik.yak.ui.adapter.viewholder;

import ApplicationConfig;
import CK;
import EN;
import EV;
import Hs;
import If;
import Ik;
import Io;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.yik.yak.ui.activity.PhotoActivity;
import com.yik.yak.ui.activity.WebActivity;
import com.yik.yak.ui.view.PhotoLinkCardView;
import com.yik.yak.ui.view.VoteView;
import java.util.Locale;

public class YakViewHolder
  extends EV<CK>
  implements Hs
{
  public static final int CONTEXT_MENU_ID_DELETE = 1;
  public static final int CONTEXT_MENU_ID_REPORT = 2;
  public static final int CONTEXT_MENU_ID_SHARE;
  @InjectView(2131558756)
  protected CardView cardView;
  @InjectView(2131558757)
  protected LinearLayout mContentLayout;
  @InjectView(2131558761)
  protected TextView mDeletedStatusText;
  @InjectView(2131558763)
  protected ImageView mLoadingIcon;
  @InjectView(2131558762)
  protected RelativeLayout mLoadingLayout;
  @InjectView(2131558795)
  protected PhotoLinkCardView mPhotoLinkCardView;
  @InjectView(2131558758)
  protected RelativeLayout pnlContainer;
  @InjectView(2131558752)
  protected LinearLayout pnlMessage;
  @InjectView(2131558760)
  protected View pnlStatus;
  @InjectView(2131558582)
  protected TextView txtAge;
  @InjectView(2131558583)
  protected TextView txtComments;
  @InjectView(2131558759)
  protected TextView txtContent;
  @InjectView(2131558578)
  protected TextView txtHandle;
  @InjectView(2131558580)
  protected VoteView voteView;
  protected CK yak;
  
  public YakViewHolder(EN paramEN, View paramView)
  {
    super(paramEN, paramView);
    ButterKnife.inject(this, paramView);
    this.mPhotoLinkCardView.setOnCardClickListener(this);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.voteView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.pnlMessage.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)this.txtAge.getLayoutParams();
    if (BV.m().equals("left"))
    {
      localLayoutParams1.addRule(11, 0);
      localLayoutParams1.addRule(9);
      localLayoutParams1.setMargins(0, 0, Ik.a(12), 0);
      localLayoutParams2.addRule(0, 0);
      localLayoutParams2.addRule(1, 2131558580);
      localLayoutParams3.addRule(9, 0);
      localLayoutParams3.addRule(11);
    }
    for (;;)
    {
      this.voteView.setLayoutParams(localLayoutParams1);
      this.pnlMessage.setLayoutParams(localLayoutParams2);
      this.txtAge.setLayoutParams(localLayoutParams3);
      return;
      localLayoutParams1.addRule(9, 0);
      localLayoutParams1.addRule(11);
      localLayoutParams1.setMargins(0, 0, Ik.a(3), 0);
      localLayoutParams2.addRule(0, 2131558580);
      localLayoutParams2.addRule(1, 0);
      localLayoutParams3.addRule(11, 0);
      localLayoutParams3.addRule(9);
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
  
  private void setViewStyle(CK paramCK, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.cardView.setCardBackgroundColor(paramInt1);
    this.pnlContainer.setBackgroundColor(paramInt2);
    this.txtContent.setTextColor(paramInt3);
    this.txtHandle.setTextColor(paramInt4);
    if (paramBoolean1)
    {
      this.voteView.setVisibility(0);
      if (!paramBoolean4) {
        break label132;
      }
      this.pnlStatus.setVisibility(0);
      label60:
      if (!paramBoolean2) {
        break label144;
      }
      this.txtContent.setAutoLinkMask(15);
      label74:
      this.txtContent.setLinksClickable(paramBoolean3);
      if (((!paramBoolean2) && (!paramBoolean5)) || (Ik.a(paramCK.D))) {
        break label155;
      }
      this.mPhotoLinkCardView.setVisibility(0);
      this.mPhotoLinkCardView.setYak(paramCK);
    }
    for (;;)
    {
      return;
      this.voteView.setVisibility(8);
      break;
      label132:
      this.pnlStatus.setVisibility(8);
      break label60;
      label144:
      this.txtContent.setAutoLinkMask(0);
      break label74;
      label155:
      this.mPhotoLinkCardView.setVisibility(8);
    }
  }
  
  private void setYakToDeletedStyle(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mDeletedStatusText.setVisibility(0);
      this.mContentLayout.setVisibility(8);
      this.mDeletedStatusText.setText(((CK)getItem()).o);
    }
    for (;;)
    {
      return;
      this.mDeletedStatusText.setVisibility(8);
      this.mContentLayout.setVisibility(0);
    }
  }
  
  public void onBindView(CK paramCK)
  {
    if (handleLoading())
    {
      this.voteView.setYak(paramCK);
      return;
    }
    if (paramCK.k.isEmpty())
    {
      this.txtHandle.setVisibility(8);
      label35:
      if (paramCK.v) {
        break label300;
      }
      if (paramCK.f != 0) {
        break label212;
      }
      this.txtComments.setText("");
      label59:
      this.txtAge.setText(new Io().a(paramCK.m));
      this.voteView.setYak(paramCK);
      setYakToDeletedStyle(paramCK.x);
      if (paramCK.x) {}
    }
    switch (paramCK.h)
    {
    default: 
      setViewStyle(paramCK, -1, -1, getColor(2131427546), getColor(2131427551), true, false, false, true, false);
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        this.txtContent.setText(paramCK.l);
        break;
        this.txtHandle.setText(paramCK.k);
        this.txtHandle.setVisibility(0);
        break label35;
        label212:
        if (paramCK.f == 1)
        {
          this.txtComments.setText(String.valueOf(paramCK.f) + " reply");
          break label59;
        }
        if (paramCK.f <= 1) {
          break label59;
        }
        this.txtComments.setText(String.valueOf(paramCK.f) + " replies");
        break label59;
        label300:
        this.txtComments.setText("");
        break label59;
        setViewStyle(paramCK, -1, -1, getColor(2131427546), getColor(2131427551), true, false, false, true, false);
        continue;
        setViewStyle(paramCK, getColor(2131427549), getColor(2131427549), -1, -1, false, true, true, false, false);
        continue;
        setViewStyle(paramCK, -256, -256, -16777216, -16777216, false, true, true, false, false);
        continue;
        setViewStyle(paramCK, -65536, -65536, -1, -1, false, true, true, false, false);
        continue;
        setViewStyle(paramCK, -1, -1, getColor(2131427546), -16776961, false, true, true, false, false);
        continue;
        setViewStyle(paramCK, -1, -1, getColor(2131427546), getColor(2131427551), true, true, false, true, false);
      }
    }
    int i = getColor(2131427546);
    int j = getColor(2131427551);
    if (!Ik.a(paramCK.z)) {}
    for (boolean bool = true;; bool = false)
    {
      setViewStyle(paramCK, -1, -1, i, j, true, true, false, true, bool);
      break;
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
      this.voteView.a();
    }
    for (;;)
    {
      return false;
      broadcastClick();
    }
  }
  
  public void onLinkCardClicked(PhotoLinkCardView paramPhotoLinkCardView)
  {
    String str = ((CK)getItem()).z;
    If.a().i(str);
    if ((str.toLowerCase(Locale.US).contains("youtube")) || (str.toLowerCase(Locale.US).contains("youtu.be"))) {
      getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
    for (;;)
    {
      return;
      Intent localIntent = new Intent(getContext(), WebActivity.class);
      localIntent.addFlags(67108864);
      localIntent.putExtra("title", ((CK)getItem()).A);
      localIntent.putExtra("url", str);
      getContext().startActivity(localIntent);
    }
  }
  
  public void onPhotoCardClicked(PhotoLinkCardView paramPhotoLinkCardView)
  {
    If.a().g("Feed");
    Intent localIntent = new Intent(getContext(), PhotoActivity.class);
    localIntent.putExtra("url", ((CK)getItem()).z);
    getContext().startActivity(localIntent);
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.yik.yak.ui.adapter.viewholder.YakViewHolder

 * JD-Core Version:    0.7.0.1

 */