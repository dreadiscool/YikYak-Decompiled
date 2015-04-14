package com.yik.yak.ui.view;

import CK;
import Hi;
import Hu;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class VoteView
  extends LinearLayout
  implements View.OnClickListener
{
  private boolean a = true;
  private CK b;
  private AnimatedTextView c;
  private VoteArrowView d;
  private VoteArrowView e;
  
  public VoteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(ImageView paramImageView)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.25F, 1.0F, 1.25F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation.setDuration(1000L);
    localScaleAnimation.setFillAfter(true);
    paramImageView.startAnimation(localScaleAnimation);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b().setNumber(this.b.d);
      setVotingEnabled(this.b.G);
      if (!this.a) {
        break label126;
      }
      b().setColor(getContext().getResources().getColor(2131427549));
      if (this.b.g != 1) {
        break label94;
      }
      setVoteType(Hu.a);
    }
    for (;;)
    {
      return;
      b().setNumber(this.b.d, Hi.c);
      break;
      label94:
      if (this.b.g == -1)
      {
        setVoteType(Hu.b);
      }
      else
      {
        setVoteType(Hu.c);
        continue;
        label126:
        setVotingEnabled(false);
      }
    }
  }
  
  private void e()
  {
    Toast.makeText(getContext(), getContext().getString(2131230966), 0).show();
  }
  
  private void f()
  {
    a(c());
    if (this.a) {
      if (this.b.c()) {
        a(true);
      }
    }
    for (;;)
    {
      return;
      if (!this.b.a) {
        e();
      }
    }
  }
  
  private void g()
  {
    a(d());
    if (this.a) {
      if (this.b.b()) {
        a(true);
      }
    }
    for (;;)
    {
      return;
      if (!this.b.a) {
        e();
      }
    }
  }
  
  public void a()
  {
    onClick(d());
  }
  
  public AnimatedTextView b()
  {
    if (this.c == null) {
      this.c = ((AnimatedTextView)findViewById(2131558806));
    }
    return this.c;
  }
  
  public VoteArrowView c()
  {
    if (this.d == null)
    {
      this.d = ((VoteArrowView)findViewById(2131558807));
      this.d.setOnClickListener(this);
    }
    return this.d;
  }
  
  public VoteArrowView d()
  {
    if (this.e == null)
    {
      this.e = ((VoteArrowView)findViewById(2131558805));
      this.e.setOnClickListener(this);
    }
    return this.e;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return;
      f();
      continue;
      g();
    }
  }
  
  public void setVoteType(Hu paramHu)
  {
    boolean bool1 = true;
    VoteArrowView localVoteArrowView1 = c();
    boolean bool2;
    VoteArrowView localVoteArrowView2;
    if (paramHu == Hu.b)
    {
      bool2 = bool1;
      localVoteArrowView1.setSelected(bool2);
      localVoteArrowView2 = d();
      if (paramHu != Hu.a) {
        break label49;
      }
    }
    for (;;)
    {
      localVoteArrowView2.setSelected(bool1);
      return;
      bool2 = false;
      break;
      label49:
      bool1 = false;
    }
  }
  
  public void setVotingEnabled(boolean paramBoolean)
  {
    this.a = paramBoolean;
    c().setEnabled(paramBoolean);
    d().setEnabled(paramBoolean);
    b().setColor(getContext().getResources().getColor(2131427655));
  }
  
  public void setYak(CK paramCK)
  {
    if (this.b != paramCK)
    {
      this.b = paramCK;
      a(false);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.view.VoteView
 * JD-Core Version:    0.7.0.1
 */