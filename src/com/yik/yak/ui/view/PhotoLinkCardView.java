package com.yik.yak.ui.view;

import CK;
import Hr;
import Hs;
import Ik;
import Iq;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.yik.yak.YikYak;

public class PhotoLinkCardView
  extends RelativeLayout
{
  protected Hs a;
  protected CK b;
  @InjectView(2131558796)
  protected ImageView mImageView;
  @InjectView(2131558800)
  protected TextView mLink;
  @InjectView(2131558799)
  protected TextView mLinkDescription;
  @InjectView(2131558797)
  protected LinearLayout mLinkDetails;
  @InjectView(2131558798)
  protected TextView mLinkTitle;
  
  public PhotoLinkCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Hr a()
  {
    return Hr.a(this.b.h);
  }
  
  private void b()
  {
    setVisibility(0);
    switch (Hq.a[a().ordinal()])
    {
    default: 
      Iq.a("un handled type: " + a() + " yak", new Object[0]);
      if (Ik.a(this.b.D)) {
        setVisibility(8);
      }
      break;
    }
    for (;;)
    {
      f();
      return;
      Iq.a("link or sponsered yak", new Object[0]);
      this.mLinkDetails.setVisibility(0);
      this.mLinkTitle.setText(this.b.A);
      this.mLinkDescription.setText(this.b.B);
      this.mLink.setText(this.b.C);
      continue;
      Iq.a("image yak", new Object[0]);
      this.mLinkDetails.setVisibility(8);
      continue;
      this.mLinkDetails.setVisibility(0);
      this.mLinkTitle.setText(this.b.A);
      this.mLinkDescription.setText(this.b.B);
      this.mLink.setText(this.b.C);
    }
  }
  
  private void c()
  {
    if (this.a != null) {
      this.a.onLinkCardClicked(this);
    }
  }
  
  private void d()
  {
    if (this.a != null) {
      this.a.onPhotoCardClicked(this);
    }
  }
  
  private void e()
  {
    this.mImageView.setImageDrawable(null);
  }
  
  private void f()
  {
    e();
    if (!Ik.a(this.b.z)) {
      Picasso.with(YikYak.getInstance()).load(this.b.D).into(this.mImageView);
    }
  }
  
  @OnClick
  public void onClick()
  {
    switch (Hq.a[a().ordinal()])
    {
    default: 
      if (!Ik.a(this.b.D)) {
        c();
      }
      break;
    }
    for (;;)
    {
      return;
      c();
      continue;
      d();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this, this);
  }
  
  public void setOnCardClickListener(Hs paramHs)
  {
    this.a = paramHs;
  }
  
  public void setYak(CK paramCK)
  {
    this.b = paramCK;
    b();
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.yik.yak.ui.view.PhotoLinkCardView

 * JD-Core Version:    0.7.0.1

 */