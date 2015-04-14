package com.mixpanel.android.surveys;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import to;
import vB;
import vC;
import vD;
import vm;
import vy;

public class CardCarouselLayout
  extends ViewGroup
{
  private static int a = 45;
  private static float b = 0.8F;
  private static float c = 0.5F;
  private static float d = 0.5F;
  private final List<View> e = new ArrayList(1);
  private vD f;
  private vD g;
  private vC h = null;
  
  public CardCarouselLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public CardCarouselLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public CardCarouselLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private Animation a()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    RotateAnimation localRotateAnimation = new RotateAnimation(a, 0.0F, 1, c, 1, d);
    localRotateAnimation.setDuration(198L);
    localAnimationSet.addAnimation(localRotateAnimation);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(b, 1.0F, b, 1.0F, 1, c, 1, d);
    localScaleAnimation.setDuration(198L);
    localAnimationSet.addAnimation(localScaleAnimation);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 1.3F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    localTranslateAnimation.setDuration(330L);
    localAnimationSet.addAnimation(localTranslateAnimation);
    return localAnimationSet;
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramContext);
    View localView1 = localLayoutInflater.inflate(to.com_mixpanel_android_question_card, this, false);
    this.f = new vD(this, localView1);
    View localView2 = localLayoutInflater.inflate(to.com_mixpanel_android_question_card, this, false);
    this.g = new vD(this, localView2);
    addView(localView1);
    addView(localView2);
  }
  
  private Animation b()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, a, 1, c, 1, d);
    localRotateAnimation.setDuration(198L);
    localRotateAnimation.setStartOffset(132L);
    localAnimationSet.addAnimation(localRotateAnimation);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, b, 1.0F, b, 1, c, 1, d);
    localScaleAnimation.setDuration(198L);
    localScaleAnimation.setStartOffset(132L);
    localAnimationSet.addAnimation(localScaleAnimation);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, -1.0F, 2, 0.3F, 2, 0.0F, 2, 0.0F);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    localTranslateAnimation.setDuration(330L);
    localAnimationSet.addAnimation(localTranslateAnimation);
    return localAnimationSet;
  }
  
  private Animation c()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    RotateAnimation localRotateAnimation = new RotateAnimation(-a, 0.0F, 1, c, 1, d);
    localRotateAnimation.setDuration(198L);
    localAnimationSet.addAnimation(localRotateAnimation);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(b, 1.0F, b, 1.0F, 1, c, 1, d);
    localScaleAnimation.setDuration(198L);
    localAnimationSet.addAnimation(localScaleAnimation);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, -1.3F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    localTranslateAnimation.setDuration(330L);
    localAnimationSet.addAnimation(localTranslateAnimation);
    return localAnimationSet;
  }
  
  private Animation d()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, -a, 1, c, 1, d);
    localRotateAnimation.setDuration(330L);
    localRotateAnimation.setStartOffset(132L);
    localAnimationSet.addAnimation(localRotateAnimation);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, b, 1.0F, b, 1, c, 1, d);
    localScaleAnimation.setDuration(330L);
    localScaleAnimation.setStartOffset(132L);
    localAnimationSet.addAnimation(localScaleAnimation);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, -1.0F, 2, -2.3F, 2, 0.0F, 2, 0.0F);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    localTranslateAnimation.setDuration(330L);
    localAnimationSet.addAnimation(localTranslateAnimation);
    return localAnimationSet;
  }
  
  public void a(vm paramvm, String paramString)
  {
    this.f.a(paramvm, paramString);
    removeAllViews();
    addView(this.f.a());
    addView(this.g.a());
    invalidate();
  }
  
  public void a(vm paramvm, String paramString, vB paramvB)
  {
    Animation localAnimation1 = null;
    vD localvD = this.g;
    this.g = this.f;
    this.f = localvD;
    this.f.a(paramvm, paramString);
    View localView1 = this.g.a();
    View localView2 = this.f.a();
    localView1.setVisibility(0);
    localView2.setVisibility(0);
    Animation localAnimation2;
    switch (vz.a[paramvB.ordinal()])
    {
    default: 
      localAnimation2 = null;
    }
    for (;;)
    {
      localAnimation2.setAnimationListener(new vy(this, localView1));
      localView1.startAnimation(localAnimation2);
      localView2.startAnimation(localAnimation1);
      invalidate();
      return;
      localAnimation2 = d();
      localAnimation1 = a();
      continue;
      localAnimation2 = b();
      localAnimation1 = c();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView1 = this.f.a();
    int i;
    if (localView1.getVisibility() != 8)
    {
      i = localView1.getMeasuredWidth();
      localView1.layout(0, 0, i, localView1.getMeasuredHeight());
    }
    for (;;)
    {
      View localView2 = this.g.a();
      if (localView2.getVisibility() != 8)
      {
        int j = localView2.getMeasuredWidth();
        int k = localView2.getMeasuredHeight();
        localView2.layout(i, 0, j + i, k);
      }
      return;
      i = 0;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    if ((View.MeasureSpec.getMode(paramInt1) != 1073741824) || (View.MeasureSpec.getMode(paramInt2) != 1073741824)) {}
    int m;
    int n;
    for (int j = 1;; j = 0)
    {
      this.e.clear();
      int k = 0;
      m = 0;
      n = 0;
      while (k < i)
      {
        View localView2 = getChildAt(k);
        if (localView2.getVisibility() != 8)
        {
          ViewGroup.LayoutParams localLayoutParams2 = localView2.getLayoutParams();
          localView2.measure(getChildMeasureSpec(paramInt1, 0, localLayoutParams2.width), getChildMeasureSpec(paramInt2, 0, localLayoutParams2.height));
          m = Math.max(m, localView2.getMeasuredWidth());
          n = Math.max(n, localView2.getMeasuredHeight());
          if ((j != 0) && ((localLayoutParams2.width == -1) || (localLayoutParams2.height == -1))) {
            this.e.add(localView2);
          }
        }
        k++;
      }
    }
    int i1 = Math.max(n, getSuggestedMinimumHeight());
    setMeasuredDimension(resolveSize(Math.max(m, getSuggestedMinimumWidth()), paramInt1), resolveSize(i1, paramInt2));
    Iterator localIterator = this.e.iterator();
    if (localIterator.hasNext())
    {
      View localView1 = (View)localIterator.next();
      ViewGroup.LayoutParams localLayoutParams1 = localView1.getLayoutParams();
      int i2;
      if (localLayoutParams1.width == -1)
      {
        i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        label268:
        if (localLayoutParams1.height != -1) {
          break label316;
        }
      }
      label316:
      for (int i3 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);; i3 = getChildMeasureSpec(paramInt2, 0, localLayoutParams1.height))
      {
        localView1.measure(i2, i3);
        break;
        i2 = getChildMeasureSpec(paramInt1, 0, localLayoutParams1.width);
        break label268;
      }
    }
  }
  
  public void setOnQuestionAnsweredListener(vC paramvC)
  {
    this.h = paramvC;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.mixpanel.android.surveys.CardCarouselLayout
 * JD-Core Version:    0.7.0.1
 */