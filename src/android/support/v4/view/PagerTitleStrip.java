package android.support.v4.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class PagerTitleStrip
  extends ViewGroup
  implements ViewPager.Decor
{
  private static final int[] ATTRS;
  private static final PagerTitleStrip.PagerTitleStripImpl IMPL;
  private static final float SIDE_ALPHA = 0.6F;
  private static final String TAG = "PagerTitleStrip";
  private static final int[] TEXT_ATTRS;
  private static final int TEXT_SPACING = 16;
  TextView mCurrText;
  private int mGravity;
  private int mLastKnownCurrentPage = -1;
  private float mLastKnownPositionOffset = -1.0F;
  TextView mNextText;
  private int mNonPrimaryAlpha;
  private final PagerTitleStrip.PageListener mPageListener = new PagerTitleStrip.PageListener(this, null);
  ViewPager mPager;
  TextView mPrevText;
  private int mScaledTextSpacing;
  int mTextColor;
  private boolean mUpdatingPositions;
  private boolean mUpdatingText;
  private WeakReference<PagerAdapter> mWatchingAdapter;
  
  static
  {
    int[] arrayOfInt1 = new int[4];
    arrayOfInt1[0] = 16842804;
    arrayOfInt1[1] = 16842901;
    arrayOfInt1[2] = 16842904;
    arrayOfInt1[3] = 16842927;
    ATTRS = arrayOfInt1;
    int[] arrayOfInt2 = new int[1];
    arrayOfInt2[0] = 16843660;
    TEXT_ATTRS = arrayOfInt2;
    if (Build.VERSION.SDK_INT >= 14) {}
    for (IMPL = new PagerTitleStrip.PagerTitleStripImplIcs();; IMPL = new PagerTitleStrip.PagerTitleStripImplBase()) {
      return;
    }
  }
  
  public PagerTitleStrip(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TextView localTextView1 = new TextView(paramContext);
    this.mPrevText = localTextView1;
    addView(localTextView1);
    TextView localTextView2 = new TextView(paramContext);
    this.mCurrText = localTextView2;
    addView(localTextView2);
    TextView localTextView3 = new TextView(paramContext);
    this.mNextText = localTextView3;
    addView(localTextView3);
    TypedArray localTypedArray1 = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
    int i = localTypedArray1.getResourceId(0, 0);
    if (i != 0)
    {
      this.mPrevText.setTextAppearance(paramContext, i);
      this.mCurrText.setTextAppearance(paramContext, i);
      this.mNextText.setTextAppearance(paramContext, i);
    }
    int j = localTypedArray1.getDimensionPixelSize(1, 0);
    if (j != 0) {
      setTextSize(0, j);
    }
    if (localTypedArray1.hasValue(2))
    {
      int k = localTypedArray1.getColor(2, 0);
      this.mPrevText.setTextColor(k);
      this.mCurrText.setTextColor(k);
      this.mNextText.setTextColor(k);
    }
    this.mGravity = localTypedArray1.getInteger(3, 80);
    localTypedArray1.recycle();
    this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
    setNonPrimaryAlpha(0.6F);
    this.mPrevText.setEllipsize(TextUtils.TruncateAt.END);
    this.mCurrText.setEllipsize(TextUtils.TruncateAt.END);
    this.mNextText.setEllipsize(TextUtils.TruncateAt.END);
    if (i != 0)
    {
      TypedArray localTypedArray2 = paramContext.obtainStyledAttributes(i, TEXT_ATTRS);
      bool = localTypedArray2.getBoolean(0, false);
      localTypedArray2.recycle();
    }
    if (bool)
    {
      setSingleLineAllCaps(this.mPrevText);
      setSingleLineAllCaps(this.mCurrText);
      setSingleLineAllCaps(this.mNextText);
    }
    for (;;)
    {
      this.mScaledTextSpacing = ((int)(16.0F * paramContext.getResources().getDisplayMetrics().density));
      return;
      this.mPrevText.setSingleLine();
      this.mCurrText.setSingleLine();
      this.mNextText.setSingleLine();
    }
  }
  
  private static void setSingleLineAllCaps(TextView paramTextView)
  {
    IMPL.setSingleLineAllCaps(paramTextView);
  }
  
  int getMinHeight()
  {
    int i = 0;
    Drawable localDrawable = getBackground();
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicHeight();
    }
    return i;
  }
  
  public int getTextSpacing()
  {
    return this.mScaledTextSpacing;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewParent localViewParent = getParent();
    if (!(localViewParent instanceof ViewPager)) {
      throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }
    ViewPager localViewPager = (ViewPager)localViewParent;
    PagerAdapter localPagerAdapter1 = localViewPager.getAdapter();
    localViewPager.setInternalPageChangeListener(this.mPageListener);
    localViewPager.setOnAdapterChangeListener(this.mPageListener);
    this.mPager = localViewPager;
    if (this.mWatchingAdapter != null) {}
    for (PagerAdapter localPagerAdapter2 = (PagerAdapter)this.mWatchingAdapter.get();; localPagerAdapter2 = null)
    {
      updateAdapter(localPagerAdapter2, localPagerAdapter1);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mPager != null)
    {
      updateAdapter(this.mPager.getAdapter(), null);
      this.mPager.setInternalPageChangeListener(null);
      this.mPager.setOnAdapterChangeListener(null);
      this.mPager = null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 0.0F;
    if (this.mPager != null)
    {
      if (this.mLastKnownPositionOffset >= 0.0F) {
        f = this.mLastKnownPositionOffset;
      }
      updateTextPositions(this.mLastKnownCurrentPage, f, true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    if (i != 1073741824) {
      throw new IllegalStateException("Must measure with an exact width");
    }
    int n = getMinHeight();
    int i1 = getPaddingTop() + getPaddingBottom();
    int i2 = m - i1;
    int i3 = View.MeasureSpec.makeMeasureSpec((int)(0.8F * k), -2147483648);
    int i4 = View.MeasureSpec.makeMeasureSpec(i2, -2147483648);
    this.mPrevText.measure(i3, i4);
    this.mCurrText.measure(i3, i4);
    this.mNextText.measure(i3, i4);
    if (j == 1073741824) {
      setMeasuredDimension(k, m);
    }
    for (;;)
    {
      return;
      setMeasuredDimension(k, Math.max(n, i1 + this.mCurrText.getMeasuredHeight()));
    }
  }
  
  public void requestLayout()
  {
    if (!this.mUpdatingText) {
      super.requestLayout();
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.mGravity = paramInt;
    requestLayout();
  }
  
  public void setNonPrimaryAlpha(float paramFloat)
  {
    this.mNonPrimaryAlpha = (0xFF & (int)(255.0F * paramFloat));
    int i = this.mNonPrimaryAlpha << 24 | 0xFFFFFF & this.mTextColor;
    this.mPrevText.setTextColor(i);
    this.mNextText.setTextColor(i);
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextColor = paramInt;
    this.mCurrText.setTextColor(paramInt);
    int i = this.mNonPrimaryAlpha << 24 | 0xFFFFFF & this.mTextColor;
    this.mPrevText.setTextColor(i);
    this.mNextText.setTextColor(i);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    this.mPrevText.setTextSize(paramInt, paramFloat);
    this.mCurrText.setTextSize(paramInt, paramFloat);
    this.mNextText.setTextSize(paramInt, paramFloat);
  }
  
  public void setTextSpacing(int paramInt)
  {
    this.mScaledTextSpacing = paramInt;
    requestLayout();
  }
  
  void updateAdapter(PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2)
  {
    if (paramPagerAdapter1 != null)
    {
      paramPagerAdapter1.unregisterDataSetObserver(this.mPageListener);
      this.mWatchingAdapter = null;
    }
    if (paramPagerAdapter2 != null)
    {
      paramPagerAdapter2.registerDataSetObserver(this.mPageListener);
      this.mWatchingAdapter = new WeakReference(paramPagerAdapter2);
    }
    if (this.mPager != null)
    {
      this.mLastKnownCurrentPage = -1;
      this.mLastKnownPositionOffset = -1.0F;
      updateText(this.mPager.getCurrentItem(), paramPagerAdapter2);
      requestLayout();
    }
  }
  
  void updateText(int paramInt, PagerAdapter paramPagerAdapter)
  {
    CharSequence localCharSequence1 = null;
    int i;
    if (paramPagerAdapter != null)
    {
      i = paramPagerAdapter.getCount();
      this.mUpdatingText = true;
      if ((paramInt < 1) || (paramPagerAdapter == null)) {
        break label233;
      }
    }
    label233:
    for (CharSequence localCharSequence2 = paramPagerAdapter.getPageTitle(paramInt - 1);; localCharSequence2 = null)
    {
      this.mPrevText.setText(localCharSequence2);
      TextView localTextView = this.mCurrText;
      if ((paramPagerAdapter != null) && (paramInt < i)) {}
      for (CharSequence localCharSequence3 = paramPagerAdapter.getPageTitle(paramInt);; localCharSequence3 = null)
      {
        localTextView.setText(localCharSequence3);
        if ((paramInt + 1 < i) && (paramPagerAdapter != null)) {
          localCharSequence1 = paramPagerAdapter.getPageTitle(paramInt + 1);
        }
        this.mNextText.setText(localCharSequence1);
        int j = getWidth() - getPaddingLeft() - getPaddingRight();
        int k = getHeight() - getPaddingTop() - getPaddingBottom();
        int m = View.MeasureSpec.makeMeasureSpec((int)(0.8F * j), -2147483648);
        int n = View.MeasureSpec.makeMeasureSpec(k, -2147483648);
        this.mPrevText.measure(m, n);
        this.mCurrText.measure(m, n);
        this.mNextText.measure(m, n);
        this.mLastKnownCurrentPage = paramInt;
        if (!this.mUpdatingPositions) {
          updateTextPositions(paramInt, this.mLastKnownPositionOffset, false);
        }
        this.mUpdatingText = false;
        return;
        i = 0;
        break;
      }
    }
  }
  
  void updateTextPositions(int paramInt, float paramFloat, boolean paramBoolean)
  {
    int i;
    int k;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i9;
    int i10;
    int i15;
    int i16;
    int i17;
    int i21;
    int i23;
    int i24;
    int i25;
    if (paramInt != this.mLastKnownCurrentPage)
    {
      updateText(paramInt, this.mPager.getAdapter());
      this.mUpdatingPositions = true;
      i = this.mPrevText.getMeasuredWidth();
      int j = this.mCurrText.getMeasuredWidth();
      k = this.mNextText.getMeasuredWidth();
      int m = j / 2;
      n = getWidth();
      i1 = getHeight();
      i2 = getPaddingLeft();
      i3 = getPaddingRight();
      i4 = getPaddingTop();
      i5 = getPaddingBottom();
      int i6 = i2 + m;
      int i7 = i3 + m;
      int i8 = n - i6 - i7;
      float f = 0.5F + paramFloat;
      if (f > 1.0F) {
        f -= 1.0F;
      }
      i9 = n - i7 - (int)(f * i8) - j / 2;
      i10 = i9 + j;
      int i11 = this.mPrevText.getBaseline();
      int i12 = this.mCurrText.getBaseline();
      int i13 = this.mNextText.getBaseline();
      int i14 = Math.max(Math.max(i11, i12), i13);
      i15 = i14 - i11;
      i16 = i14 - i12;
      i17 = i14 - i13;
      int i18 = i15 + this.mPrevText.getMeasuredHeight();
      int i19 = i16 + this.mCurrText.getMeasuredHeight();
      int i20 = i17 + this.mNextText.getMeasuredHeight();
      i21 = Math.max(Math.max(i18, i19), i20);
      switch (0x70 & this.mGravity)
      {
      default: 
        i23 = i4 + i15;
        i24 = i16 + i4;
        i25 = i4 + i17;
      }
    }
    for (;;)
    {
      this.mCurrText.layout(i9, i24, i10, i24 + this.mCurrText.getMeasuredHeight());
      int i26 = Math.min(i2, i9 - this.mScaledTextSpacing - i);
      this.mPrevText.layout(i26, i23, i + i26, i23 + this.mPrevText.getMeasuredHeight());
      int i27 = Math.max(n - i3 - k, i10 + this.mScaledTextSpacing);
      this.mNextText.layout(i27, i25, i27 + k, i25 + this.mNextText.getMeasuredHeight());
      this.mLastKnownPositionOffset = paramFloat;
      this.mUpdatingPositions = false;
      for (;;)
      {
        return;
        if ((paramBoolean) || (paramFloat != this.mLastKnownPositionOffset)) {
          break;
        }
      }
      int i28 = (i1 - i4 - i5 - i21) / 2;
      i23 = i28 + i15;
      i24 = i16 + i28;
      i25 = i28 + i17;
      continue;
      int i22 = i1 - i5 - i21;
      i23 = i22 + i15;
      i24 = i16 + i22;
      i25 = i22 + i17;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.PagerTitleStrip
 * JD-Core Version:    0.7.0.1
 */