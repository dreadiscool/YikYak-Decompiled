package com.yik.yak.ui.adapter.viewholder;

import ApplicationConfig;
import CK;
import CR;
import EN;
import ES;
import ET;
import EV;
import Hs;
import If;
import Ik;
import Io;
import Is;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.yik.yak.ui.activity.FamousActivity;
import com.yik.yak.ui.activity.MapActivity;
import com.yik.yak.ui.activity.PhotoActivity;
import com.yik.yak.ui.activity.WebActivity;
import com.yik.yak.ui.activity.YikYakDialog;
import com.yik.yak.ui.view.PhotoLinkCardView;
import com.yik.yak.ui.view.VoteView;
import jF;
import jG;
import jZ;
import java.util.Locale;
import org.json.JSONObject;

public class YakDetailViewHolder
  extends EV<CK>
  implements Hs
{
  public Fragment fragment;
  @InjectView(2131558765)
  protected LinearLayout mMessageBody;
  @InjectView(2131558795)
  protected PhotoLinkCardView mPhotoLinkCardView;
  @InjectView(2131558766)
  protected ImageView mShareIcon;
  protected boolean mUseLeftVoteLayout = false;
  @InjectView(2131558584)
  public TextView shareButton;
  @InjectView(2131558582)
  protected TextView txtAge;
  @InjectView(2131558583)
  protected TextView txtComments;
  @InjectView(2131558579)
  protected TextView txtContent;
  @InjectView(2131558578)
  protected TextView txtHandle;
  @InjectView(2131558580)
  protected VoteView voteView;
  
  public YakDetailViewHolder(EN paramEN, View paramView, Fragment paramFragment)
  {
    super(paramEN, paramView);
    this.fragment = paramFragment;
    ButterKnife.inject(this, paramView);
    this.mPhotoLinkCardView.setOnCardClickListener(this);
    this.mUseLeftVoteLayout = ApplicationConfig.m().equals("left");
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.voteView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.mMessageBody.getLayoutParams();
    if (this.mUseLeftVoteLayout)
    {
      localLayoutParams1.addRule(11, 0);
      localLayoutParams1.addRule(9);
      localLayoutParams1.setMargins(0, 0, Ik.a(12), 0);
      localLayoutParams2.addRule(0, 2131558768);
      localLayoutParams2.addRule(1, 2131558580);
    }
    for (;;)
    {
      this.voteView.setLayoutParams(localLayoutParams1);
      this.mMessageBody.setLayoutParams(localLayoutParams2);
      return;
      localLayoutParams1.addRule(9, 0);
      localLayoutParams1.addRule(11);
      localLayoutParams1.setMargins(0, 0, Ik.a(3), 0);
      localLayoutParams2.addRule(0, 2131558580);
      localLayoutParams2.addRule(1, 2131558768);
    }
  }
  
  private boolean isYakFamousWorth()
  {
    if ((((CK)getItem()).n.equals(BV.getYakkerID())) && (((CK)getItem()).d >= CR.a("shareThreshold", "famousThreshold", 1))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void launchMapActivity()
  {
    Intent localIntent = new Intent(getContext(), MapActivity.class);
    localIntent.putExtra("lat", ((CK)getItem()).s);
    localIntent.putExtra("lon", ((CK)getItem()).t);
    if (((CK)getItem()).e == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("hidePin", bool);
      localIntent.putExtra("message", ((CK)getItem()).l);
      getContext().startActivity(localIntent);
      return;
    }
  }
  
  public void initMap(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    try
    {
      jG localjG = ((SupportMapFragment)this.fragment.getFragmentManager().findFragmentByTag("commentsMap")).b();
      localjG.d().a(false);
      localjG.d().b(false);
      localjG.a(jF.a(new LatLng(paramDouble1, paramDouble2), 15.0F));
      localjG.a(new ES(this));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onBindView(CK paramCK)
  {
    int i = 1;
    label45:
    label210:
    double d1;
    label147:
    double d2;
    if (paramCK.k.isEmpty())
    {
      this.txtHandle.setVisibility(8);
      if (paramCK.v) {
        break label348;
      }
      if (paramCK.f != 0) {
        break label260;
      }
      this.txtComments.setText("");
      this.txtAge.setText(new Io().a(paramCK.m));
      this.voteView.setYak(paramCK);
      this.txtContent.setText(paramCK.l);
      if (Ik.a(paramCK.z)) {
        break label388;
      }
      this.mPhotoLinkCardView.setVisibility(0);
      this.mPhotoLinkCardView.setYak(paramCK);
      if (paramCK.h == 6) {
        break label361;
      }
      this.txtContent.setLinksClickable(i);
      this.txtContent.setMovementMethod(LinkMovementMethod.getInstance());
      this.txtContent.setAutoLinkMask(15);
      if (!isYakFamousWorth()) {
        break label400;
      }
      this.shareButton.setText("FAMOUS");
      this.mShareIcon.setImageResource(2130837721);
      this.shareButton.setTextColor(getColor(2131427549));
      new Handler().postDelayed(new ET(this), 500L);
      d1 = paramCK.s;
      d2 = paramCK.t;
      if (paramCK.e != i) {
        break label437;
      }
    }
    for (;;)
    {
      initMap(d1, d2, i);
      return;
      this.txtHandle.setText(paramCK.k);
      this.txtHandle.setVisibility(0);
      break;
      label260:
      if (paramCK.f == i)
      {
        this.txtComments.setText(String.valueOf(paramCK.f) + " REPLY");
        break label45;
      }
      if (paramCK.f <= i) {
        break label45;
      }
      this.txtComments.setText(String.valueOf(paramCK.f) + " REPLIES");
      break label45;
      label348:
      this.txtComments.setText("");
      break label45;
      label361:
      this.txtContent.setLinksClickable(false);
      this.txtContent.setMovementMethod(null);
      this.txtContent.setAutoLinkMask(0);
      break label147;
      label388:
      this.mPhotoLinkCardView.setVisibility(8);
      break label147;
      label400:
      this.mShareIcon.setImageResource(2130837831);
      this.shareButton.setText("SHARE");
      this.shareButton.setTextColor(getColor(2131427469));
      break label210;
      label437:
      int j = 0;
    }
  }
  
  @OnClick({2131558584})
  public void onClick()
  {
    if (((CK)getItem()).d < CR.a("shareThreshold", "shareThreshold", 0))
    {
      String str = CR.a("shareThreshold", "message", getString(2131231014));
      Intent localIntent2 = new Intent(getContext(), YikYakDialog.class);
      localIntent2.putExtra("title", getContext().getResources().getString(2131231019));
      localIntent2.putExtra("message", str);
      localIntent2.putExtra("okText", "OK");
      localIntent2.putExtra("okOnly", "true");
      getContext().startActivity(localIntent2);
    }
    for (;;)
    {
      return;
      if (isYakFamousWorth())
      {
        Intent localIntent1 = new Intent(getContext(), FamousActivity.class);
        localIntent1.addFlags(67108864);
        localIntent1.putExtra("yak", ((CK)getItem()).d().toString());
        getContext().startActivity(localIntent1);
      }
      else
      {
        new Is(getContext(), (CK)getItem()).execute(new Void[0]);
      }
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
    If.a().g("Detail");
    Intent localIntent = new Intent(getContext(), PhotoActivity.class);
    localIntent.putExtra("url", ((CK)getItem()).z);
    getContext().startActivity(localIntent);
  }
  
  @OnClick({2131558579})
  public void openUrl()
  {
    Intent localIntent;
    if (!Ik.a(((CK)getItem()).z))
    {
      If.a().i(((CK)getItem()).z);
      if (((CK)getItem()).h == 6)
      {
        localIntent = new Intent(getContext(), PhotoActivity.class);
        localIntent.addFlags(67108864);
        localIntent.putExtra("url", ((CK)getItem()).z);
        getContext().startActivity(localIntent);
      }
    }
    for (;;)
    {
      return;
      localIntent = new Intent(getContext(), WebActivity.class);
      break;
      launchMapActivity();
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.yik.yak.ui.adapter.viewholder.YakDetailViewHolder

 * JD-Core Version:    0.7.0.1

 */