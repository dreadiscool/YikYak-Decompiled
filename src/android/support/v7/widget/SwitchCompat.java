package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.text.AllCapsTransformationMethod;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.internal.widget.ViewUtils;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.widget.CompoundButton;
import java.util.List;

public class SwitchCompat
  extends CompoundButton
{
  private static final int[] CHECKED_STATE_SET;
  private static final int MONOSPACE = 3;
  private static final int SANS = 1;
  private static final int SERIF = 2;
  private static final int[] TEXT_APPEARANCE_ATTRS;
  private static final int THUMB_ANIMATION_DURATION = 250;
  private static final int TOUCH_MODE_DOWN = 1;
  private static final int TOUCH_MODE_DRAGGING = 2;
  private static final int TOUCH_MODE_IDLE;
  private int mMinFlingVelocity;
  private Layout mOffLayout;
  private Layout mOnLayout;
  private Animation mPositionAnimator;
  private boolean mShowText;
  private boolean mSplitTrack;
  private int mSwitchBottom;
  private int mSwitchHeight;
  private int mSwitchLeft;
  private int mSwitchMinWidth;
  private int mSwitchPadding;
  private int mSwitchRight;
  private int mSwitchTop;
  private TransformationMethod mSwitchTransformationMethod;
  private int mSwitchWidth;
  private final Rect mTempRect = new Rect();
  private ColorStateList mTextColors;
  private CharSequence mTextOff;
  private CharSequence mTextOn;
  private TextPaint mTextPaint = new TextPaint(1);
  private Drawable mThumbDrawable;
  private float mThumbPosition;
  private int mThumbTextPadding;
  private int mThumbWidth;
  private final TintManager mTintManager;
  private int mTouchMode;
  private int mTouchSlop;
  private float mTouchX;
  private float mTouchY;
  private Drawable mTrackDrawable;
  private VelocityTracker mVelocityTracker = VelocityTracker.obtain();
  
  static
  {
    int[] arrayOfInt1 = new int[3];
    arrayOfInt1[0] = 16842904;
    arrayOfInt1[1] = 16842901;
    arrayOfInt1[2] = R.attr.textAllCaps;
    TEXT_APPEARANCE_ATTRS = arrayOfInt1;
    int[] arrayOfInt2 = new int[1];
    arrayOfInt2[0] = 16842912;
    CHECKED_STATE_SET = arrayOfInt2;
  }
  
  public SwitchCompat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.switchStyle);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = getResources();
    this.mTextPaint.density = localResources.getDisplayMetrics().density;
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.SwitchCompat, paramInt, 0);
    this.mThumbDrawable = localTintTypedArray.getDrawable(R.styleable.SwitchCompat_android_thumb);
    this.mTrackDrawable = localTintTypedArray.getDrawable(R.styleable.SwitchCompat_track);
    this.mTextOn = localTintTypedArray.getText(R.styleable.SwitchCompat_android_textOn);
    this.mTextOff = localTintTypedArray.getText(R.styleable.SwitchCompat_android_textOff);
    this.mShowText = localTintTypedArray.getBoolean(R.styleable.SwitchCompat_showText, true);
    this.mThumbTextPadding = localTintTypedArray.getDimensionPixelSize(R.styleable.SwitchCompat_thumbTextPadding, 0);
    this.mSwitchMinWidth = localTintTypedArray.getDimensionPixelSize(R.styleable.SwitchCompat_switchMinWidth, 0);
    this.mSwitchPadding = localTintTypedArray.getDimensionPixelSize(R.styleable.SwitchCompat_switchPadding, 0);
    this.mSplitTrack = localTintTypedArray.getBoolean(R.styleable.SwitchCompat_splitTrack, false);
    int i = localTintTypedArray.getResourceId(R.styleable.SwitchCompat_switchTextAppearance, 0);
    if (i != 0) {
      setSwitchTextAppearance(paramContext, i);
    }
    this.mTintManager = localTintTypedArray.getTintManager();
    localTintTypedArray.recycle();
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    this.mMinFlingVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    refreshDrawableState();
    setChecked(isChecked());
  }
  
  private void animateThumbToCheckedState(boolean paramBoolean)
  {
    float f1 = this.mThumbPosition;
    if (paramBoolean) {}
    for (float f2 = 1.0F;; f2 = 0.0F)
    {
      this.mPositionAnimator = new SwitchCompat.1(this, f1, f2 - f1);
      this.mPositionAnimator.setDuration(250L);
      startAnimation(this.mPositionAnimator);
      return;
    }
  }
  
  private void cancelPositionAnimator()
  {
    if (this.mPositionAnimator != null)
    {
      clearAnimation();
      this.mPositionAnimator = null;
    }
  }
  
  private void cancelSuperTouch(MotionEvent paramMotionEvent)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    localMotionEvent.setAction(3);
    super.onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  private static float constrain(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {}
    for (;;)
    {
      return paramFloat2;
      if (paramFloat1 > paramFloat3) {
        paramFloat2 = paramFloat3;
      } else {
        paramFloat2 = paramFloat1;
      }
    }
  }
  
  private boolean getTargetCheckedState()
  {
    if (this.mThumbPosition > 0.5F) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private int getThumbOffset()
  {
    if (ViewUtils.isLayoutRtl(this)) {}
    for (float f = 1.0F - this.mThumbPosition;; f = this.mThumbPosition) {
      return (int)(0.5F + f * getThumbScrollRange());
    }
  }
  
  private int getThumbScrollRange()
  {
    Rect localRect;
    if (this.mTrackDrawable != null)
    {
      localRect = this.mTempRect;
      this.mTrackDrawable.getPadding(localRect);
    }
    for (int i = this.mSwitchWidth - this.mThumbWidth - localRect.left - localRect.right;; i = 0) {
      return i;
    }
  }
  
  private boolean hitThumb(float paramFloat1, float paramFloat2)
  {
    int i = getThumbOffset();
    this.mThumbDrawable.getPadding(this.mTempRect);
    int j = this.mSwitchTop - this.mTouchSlop;
    int k = i + this.mSwitchLeft - this.mTouchSlop;
    int m = k + this.mThumbWidth + this.mTempRect.left + this.mTempRect.right + this.mTouchSlop;
    int n = this.mSwitchBottom + this.mTouchSlop;
    if ((paramFloat1 > k) && (paramFloat1 < m) && (paramFloat2 > j) && (paramFloat2 < n)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private Layout makeLayout(CharSequence paramCharSequence)
  {
    if (this.mSwitchTransformationMethod != null) {}
    for (CharSequence localCharSequence = this.mSwitchTransformationMethod.getTransformation(paramCharSequence, this);; localCharSequence = paramCharSequence) {
      return new StaticLayout(localCharSequence, this.mTextPaint, (int)Math.ceil(Layout.getDesiredWidth(localCharSequence, this.mTextPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    }
  }
  
  private void setThumbPosition(float paramFloat)
  {
    this.mThumbPosition = paramFloat;
    invalidate();
  }
  
  private void stopDrag(MotionEvent paramMotionEvent)
  {
    int i = 1;
    this.mTouchMode = 0;
    float f;
    if ((paramMotionEvent.getAction() == i) && (isEnabled()))
    {
      int j = i;
      if (j == 0) {
        break label116;
      }
      this.mVelocityTracker.computeCurrentVelocity(1000);
      f = this.mVelocityTracker.getXVelocity();
      if (Math.abs(f) <= this.mMinFlingVelocity) {
        break label108;
      }
      if (!ViewUtils.isLayoutRtl(this)) {
        break label96;
      }
      if (f >= 0.0F) {
        break label91;
      }
    }
    for (;;)
    {
      setChecked(i);
      cancelSuperTouch(paramMotionEvent);
      return;
      int k = 0;
      break;
      label91:
      boolean bool = false;
      continue;
      label96:
      if (f <= 0.0F)
      {
        bool = false;
        continue;
        label108:
        bool = getTargetCheckedState();
        continue;
        label116:
        bool = isChecked();
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = this.mTempRect;
    int i = this.mSwitchLeft;
    int j = this.mSwitchTop;
    int k = this.mSwitchRight;
    int m = this.mSwitchBottom;
    int n = i + getThumbOffset();
    if (this.mTrackDrawable != null)
    {
      this.mTrackDrawable.getPadding(localRect);
      n += localRect.left;
      this.mTrackDrawable.setBounds(i, j, k, m);
    }
    if (this.mThumbDrawable != null)
    {
      this.mThumbDrawable.getPadding(localRect);
      int i1 = n - localRect.left;
      int i2 = n + this.mThumbWidth + localRect.right;
      this.mThumbDrawable.setBounds(i1, j, i2, m);
      Drawable localDrawable = getBackground();
      if (localDrawable != null) {
        DrawableCompat.setHotspotBounds(localDrawable, i1, j, i2, m);
      }
    }
    super.draw(paramCanvas);
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    super.drawableHotspotChanged(paramFloat1, paramFloat2);
    if (this.mThumbDrawable != null) {
      DrawableCompat.setHotspot(this.mThumbDrawable, paramFloat1, paramFloat2);
    }
    if (this.mTrackDrawable != null) {
      DrawableCompat.setHotspot(this.mTrackDrawable, paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if (this.mThumbDrawable != null) {
      this.mThumbDrawable.setState(arrayOfInt);
    }
    if (this.mTrackDrawable != null) {
      this.mTrackDrawable.setState(arrayOfInt);
    }
    invalidate();
  }
  
  public int getCompoundPaddingLeft()
  {
    int i;
    if (!ViewUtils.isLayoutRtl(this)) {
      i = super.getCompoundPaddingLeft();
    }
    for (;;)
    {
      return i;
      i = super.getCompoundPaddingLeft() + this.mSwitchWidth;
      if (!TextUtils.isEmpty(getText())) {
        i += this.mSwitchPadding;
      }
    }
  }
  
  public int getCompoundPaddingRight()
  {
    int i;
    if (ViewUtils.isLayoutRtl(this)) {
      i = super.getCompoundPaddingRight();
    }
    for (;;)
    {
      return i;
      i = super.getCompoundPaddingRight() + this.mSwitchWidth;
      if (!TextUtils.isEmpty(getText())) {
        i += this.mSwitchPadding;
      }
    }
  }
  
  public boolean getShowText()
  {
    return this.mShowText;
  }
  
  public boolean getSplitTrack()
  {
    return this.mSplitTrack;
  }
  
  public int getSwitchMinWidth()
  {
    return this.mSwitchMinWidth;
  }
  
  public int getSwitchPadding()
  {
    return this.mSwitchPadding;
  }
  
  public CharSequence getTextOff()
  {
    return this.mTextOff;
  }
  
  public CharSequence getTextOn()
  {
    return this.mTextOn;
  }
  
  public Drawable getThumbDrawable()
  {
    return this.mThumbDrawable;
  }
  
  public int getThumbTextPadding()
  {
    return this.mThumbTextPadding;
  }
  
  public Drawable getTrackDrawable()
  {
    return this.mTrackDrawable;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.jumpDrawablesToCurrentState();
      if (this.mThumbDrawable != null) {
        this.mThumbDrawable.jumpToCurrentState();
      }
      if (this.mTrackDrawable != null) {
        this.mTrackDrawable.jumpToCurrentState();
      }
      if ((this.mPositionAnimator != null) && (this.mPositionAnimator.hasStarted()) && (!this.mPositionAnimator.hasEnded()))
      {
        clearAnimation();
        this.mPositionAnimator = null;
      }
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Rect localRect1 = this.mTempRect;
    Drawable localDrawable1 = this.mTrackDrawable;
    int k;
    int m;
    int n;
    Layout localLayout;
    label100:
    Rect localRect2;
    if (localDrawable1 != null)
    {
      localDrawable1.getPadding(localRect1);
      int i = this.mSwitchTop;
      int j = this.mSwitchBottom;
      k = i + localRect1.top;
      m = j - localRect1.bottom;
      Drawable localDrawable2 = this.mThumbDrawable;
      if (localDrawable1 != null) {
        localDrawable1.draw(paramCanvas);
      }
      n = paramCanvas.save();
      if (localDrawable2 != null) {
        localDrawable2.draw(paramCanvas);
      }
      if (!getTargetCheckedState()) {
        break label230;
      }
      localLayout = this.mOnLayout;
      if (localLayout != null)
      {
        int[] arrayOfInt = getDrawableState();
        if (this.mTextColors != null) {
          this.mTextPaint.setColor(this.mTextColors.getColorForState(arrayOfInt, 0));
        }
        this.mTextPaint.drawableState = arrayOfInt;
        if (localDrawable2 == null) {
          break label239;
        }
        localRect2 = localDrawable2.getBounds();
      }
    }
    label230:
    label239:
    for (int i1 = localRect2.left + localRect2.right;; i1 = getWidth())
    {
      int i2 = i1 / 2 - localLayout.getWidth() / 2;
      int i3 = (k + m) / 2 - localLayout.getHeight() / 2;
      paramCanvas.translate(i2, i3);
      localLayout.draw(paramCanvas);
      paramCanvas.restoreToCount(n);
      return;
      localRect1.setEmpty();
      break;
      localLayout = this.mOffLayout;
      break label100;
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(SwitchCompat.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    CharSequence localCharSequence1;
    CharSequence localCharSequence2;
    if (Build.VERSION.SDK_INT >= 14)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(SwitchCompat.class.getName());
      if (!isChecked()) {
        break label59;
      }
      localCharSequence1 = this.mTextOn;
      if (!TextUtils.isEmpty(localCharSequence1))
      {
        localCharSequence2 = paramAccessibilityNodeInfo.getText();
        if (!TextUtils.isEmpty(localCharSequence2)) {
          break label67;
        }
        paramAccessibilityNodeInfo.setText(localCharSequence1);
      }
    }
    for (;;)
    {
      return;
      label59:
      localCharSequence1 = this.mTextOff;
      break;
      label67:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localCharSequence2).append(' ').append(localCharSequence1);
      paramAccessibilityNodeInfo.setText(localStringBuilder);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Rect localRect;
    int j;
    int i;
    label69:
    int m;
    int k;
    if (this.mThumbDrawable != null)
    {
      localRect = this.mTempRect;
      if (this.mTrackDrawable != null) {
        this.mTrackDrawable.getPadding(localRect);
      }
    }
    else
    {
      if (!ViewUtils.isLayoutRtl(this)) {
        break label152;
      }
      j = 0 + getPaddingLeft();
      i = 0 + (0 + (j + this.mSwitchWidth));
      switch (0x70 & getGravity())
      {
      default: 
        m = getPaddingTop();
        k = m + this.mSwitchHeight;
      }
    }
    for (;;)
    {
      this.mSwitchLeft = j;
      this.mSwitchTop = m;
      this.mSwitchBottom = k;
      this.mSwitchRight = i;
      return;
      localRect.setEmpty();
      break;
      label152:
      i = 0 + (getWidth() - getPaddingRight());
      j = 0 + (0 + (i - this.mSwitchWidth));
      break label69;
      m = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2 - this.mSwitchHeight / 2;
      k = m + this.mSwitchHeight;
      continue;
      k = getHeight() - getPaddingBottom();
      m = k - this.mSwitchHeight;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (this.mShowText)
    {
      if (this.mOnLayout == null) {
        this.mOnLayout = makeLayout(this.mTextOn);
      }
      if (this.mOffLayout == null) {
        this.mOffLayout = makeLayout(this.mTextOff);
      }
    }
    Rect localRect = this.mTempRect;
    int k;
    int j;
    int m;
    if (this.mThumbDrawable != null)
    {
      this.mThumbDrawable.getPadding(localRect);
      k = this.mThumbDrawable.getIntrinsicWidth() - localRect.left - localRect.right;
      j = this.mThumbDrawable.getIntrinsicHeight();
      if (!this.mShowText) {
        break label259;
      }
      m = Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + 2 * this.mThumbTextPadding;
      label133:
      this.mThumbWidth = Math.max(m, k);
      if (this.mTrackDrawable == null) {
        break label265;
      }
      this.mTrackDrawable.getPadding(localRect);
      i = this.mTrackDrawable.getIntrinsicHeight();
    }
    for (;;)
    {
      int n = localRect.left;
      int i1 = localRect.right;
      int i2 = Math.max(this.mSwitchMinWidth, i1 + (n + 2 * this.mThumbWidth));
      int i3 = Math.max(i, j);
      this.mSwitchWidth = i2;
      this.mSwitchHeight = i3;
      super.onMeasure(paramInt1, paramInt2);
      if (getMeasuredHeight() < i3) {
        setMeasuredDimension(ViewCompat.getMeasuredWidthAndState(this), i3);
      }
      return;
      j = 0;
      k = 0;
      break;
      label259:
      m = 0;
      break label133;
      label265:
      localRect.setEmpty();
    }
  }
  
  @TargetApi(14)
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (isChecked()) {}
    for (CharSequence localCharSequence = this.mTextOn;; localCharSequence = this.mTextOff)
    {
      if (localCharSequence != null) {
        paramAccessibilityEvent.getText().add(localCharSequence);
      }
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      for (;;)
      {
        return bool;
        float f7 = paramMotionEvent.getX();
        float f8 = paramMotionEvent.getY();
        if ((!isEnabled()) || (!hitThumb(f7, f8))) {
          break;
        }
        this.mTouchMode = 1;
        this.mTouchX = f7;
        this.mTouchY = f8;
        break;
        switch (this.mTouchMode)
        {
        case 0: 
        default: 
          break;
        case 1: 
          float f5 = paramMotionEvent.getX();
          float f6 = paramMotionEvent.getY();
          if ((Math.abs(f5 - this.mTouchX) <= this.mTouchSlop) && (Math.abs(f6 - this.mTouchY) <= this.mTouchSlop)) {
            break;
          }
          this.mTouchMode = 2;
          getParent().requestDisallowInterceptTouchEvent(true);
          this.mTouchX = f5;
          this.mTouchY = f6;
          bool = true;
          break;
        case 2: 
          float f1 = paramMotionEvent.getX();
          int i = getThumbScrollRange();
          float f2 = f1 - this.mTouchX;
          float f3;
          if (i != 0) {
            f3 = f2 / i;
          }
          for (;;)
          {
            if (ViewUtils.isLayoutRtl(this)) {
              f3 = -f3;
            }
            float f4 = constrain(f3 + this.mThumbPosition, 0.0F, 1.0F);
            if (f4 != this.mThumbPosition)
            {
              this.mTouchX = f1;
              setThumbPosition(f4);
            }
            bool = true;
            break;
            if (f2 > 0.0F) {
              f3 = 1.0F;
            } else {
              f3 = -1.0F;
            }
          }
          if (this.mTouchMode != 2) {
            break label349;
          }
          stopDrag(paramMotionEvent);
          super.onTouchEvent(paramMotionEvent);
          bool = true;
        }
      }
      label349:
      this.mTouchMode = 0;
      this.mVelocityTracker.clear();
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    boolean bool = isChecked();
    if (getWindowToken() != null)
    {
      animateThumbToCheckedState(bool);
      return;
    }
    cancelPositionAnimator();
    if (bool) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      setThumbPosition(f);
      break;
    }
  }
  
  public void setShowText(boolean paramBoolean)
  {
    if (this.mShowText != paramBoolean)
    {
      this.mShowText = paramBoolean;
      requestLayout();
    }
  }
  
  public void setSplitTrack(boolean paramBoolean)
  {
    this.mSplitTrack = paramBoolean;
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    this.mSwitchMinWidth = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt)
  {
    this.mSwitchPadding = paramInt;
    requestLayout();
  }
  
  public void setSwitchTextAppearance(Context paramContext, int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, TEXT_APPEARANCE_ATTRS);
    ColorStateList localColorStateList = localTypedArray.getColorStateList(0);
    if (localColorStateList != null)
    {
      this.mTextColors = localColorStateList;
      int i = localTypedArray.getDimensionPixelSize(1, 0);
      if ((i != 0) && (i != this.mTextPaint.getTextSize()))
      {
        this.mTextPaint.setTextSize(i);
        requestLayout();
      }
      if (!localTypedArray.getBoolean(2, false)) {
        break label108;
      }
    }
    label108:
    for (this.mSwitchTransformationMethod = new AllCapsTransformationMethod(getContext());; this.mSwitchTransformationMethod = null)
    {
      localTypedArray.recycle();
      return;
      this.mTextColors = getTextColors();
      break;
    }
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    if (this.mTextPaint.getTypeface() != paramTypeface)
    {
      this.mTextPaint.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  public void setSwitchTypeface(Typeface paramTypeface, int paramInt)
  {
    boolean bool = false;
    Typeface localTypeface;
    int i;
    label34:
    float f;
    if (paramInt > 0) {
      if (paramTypeface == null)
      {
        localTypeface = Typeface.defaultFromStyle(paramInt);
        setSwitchTypeface(localTypeface);
        if (localTypeface == null) {
          break label100;
        }
        i = localTypeface.getStyle();
        int j = paramInt & (i ^ 0xFFFFFFFF);
        TextPaint localTextPaint1 = this.mTextPaint;
        if ((j & 0x1) != 0) {
          bool = true;
        }
        localTextPaint1.setFakeBoldText(bool);
        TextPaint localTextPaint2 = this.mTextPaint;
        if ((j & 0x2) == 0) {
          break label106;
        }
        f = -0.25F;
        label82:
        localTextPaint2.setTextSkewX(f);
      }
    }
    for (;;)
    {
      return;
      localTypeface = Typeface.create(paramTypeface, paramInt);
      break;
      label100:
      i = 0;
      break label34;
      label106:
      f = 0.0F;
      break label82;
      this.mTextPaint.setFakeBoldText(false);
      this.mTextPaint.setTextSkewX(0.0F);
      setSwitchTypeface(paramTypeface);
    }
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    this.mTextOff = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    this.mTextOn = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    this.mThumbDrawable = paramDrawable;
    requestLayout();
  }
  
  public void setThumbResource(int paramInt)
  {
    setThumbDrawable(this.mTintManager.getDrawable(paramInt));
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    this.mThumbTextPadding = paramInt;
    requestLayout();
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    this.mTrackDrawable = paramDrawable;
    requestLayout();
  }
  
  public void setTrackResource(int paramInt)
  {
    setTrackDrawable(this.mTintManager.getDrawable(paramInt));
  }
  
  public void toggle()
  {
    if (!isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.mThumbDrawable) || (paramDrawable == this.mTrackDrawable)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.SwitchCompat
 * JD-Core Version:    0.7.0.1
 */