package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class ChildHelper
{
  private static final boolean DEBUG = false;
  private static final String TAG = "ChildrenHelper";
  final ChildHelper.Bucket mBucket;
  final ChildHelper.Callback mCallback;
  final List<View> mHiddenViews;
  
  ChildHelper(ChildHelper.Callback paramCallback)
  {
    this.mCallback = paramCallback;
    this.mBucket = new ChildHelper.Bucket();
    this.mHiddenViews = new ArrayList();
  }
  
  private int getOffset(int paramInt)
  {
    int j;
    if (paramInt < 0) {
      j = -1;
    }
    for (;;)
    {
      return j;
      int i = this.mCallback.getChildCount();
      j = paramInt;
      for (;;)
      {
        if (j >= i) {
          break label70;
        }
        int k = paramInt - (j - this.mBucket.countOnesBefore(j));
        if (k == 0)
        {
          while (this.mBucket.get(j)) {
            j++;
          }
          break;
        }
        j += k;
      }
      label70:
      j = -1;
    }
  }
  
  void addView(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (int i = this.mCallback.getChildCount();; i = getOffset(paramInt))
    {
      this.mCallback.addView(paramView, i);
      this.mBucket.insert(i, paramBoolean);
      if (paramBoolean) {
        this.mHiddenViews.add(paramView);
      }
      return;
    }
  }
  
  void addView(View paramView, boolean paramBoolean)
  {
    addView(paramView, -1, paramBoolean);
  }
  
  void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (int i = this.mCallback.getChildCount();; i = getOffset(paramInt))
    {
      this.mCallback.attachViewToParent(paramView, i, paramLayoutParams);
      this.mBucket.insert(i, paramBoolean);
      if (paramBoolean) {
        this.mHiddenViews.add(paramView);
      }
      return;
    }
  }
  
  void detachViewFromParent(int paramInt)
  {
    int i = getOffset(paramInt);
    this.mCallback.detachViewFromParent(i);
    this.mBucket.remove(i);
  }
  
  View findHiddenNonRemovedView(int paramInt1, int paramInt2)
  {
    int i = this.mHiddenViews.size();
    int j = 0;
    View localView;
    if (j < i)
    {
      localView = (View)this.mHiddenViews.get(j);
      RecyclerView.ViewHolder localViewHolder = this.mCallback.getChildViewHolder(localView);
      if ((localViewHolder.getPosition() != paramInt1) || (localViewHolder.isInvalid()) || ((paramInt2 != -1) && (localViewHolder.getItemViewType() != paramInt2))) {}
    }
    for (;;)
    {
      return localView;
      j++;
      break;
      localView = null;
    }
  }
  
  View getChildAt(int paramInt)
  {
    int i = getOffset(paramInt);
    return this.mCallback.getChildAt(i);
  }
  
  int getChildCount()
  {
    return this.mCallback.getChildCount() - this.mHiddenViews.size();
  }
  
  View getUnfilteredChildAt(int paramInt)
  {
    return this.mCallback.getChildAt(paramInt);
  }
  
  int getUnfilteredChildCount()
  {
    return this.mCallback.getChildCount();
  }
  
  void hide(View paramView)
  {
    int i = this.mCallback.indexOfChild(paramView);
    if (i < 0) {
      throw new IllegalArgumentException("view is not a child, cannot hide " + paramView);
    }
    this.mBucket.set(i);
    this.mHiddenViews.add(paramView);
  }
  
  int indexOfChild(View paramView)
  {
    int i = -1;
    int j = this.mCallback.indexOfChild(paramView);
    if (j == i) {}
    for (;;)
    {
      return i;
      if (!this.mBucket.get(j)) {
        i = j - this.mBucket.countOnesBefore(j);
      }
    }
  }
  
  boolean isHidden(View paramView)
  {
    return this.mHiddenViews.contains(paramView);
  }
  
  void removeAllViewsUnfiltered()
  {
    this.mCallback.removeAllViews();
    this.mBucket.reset();
    this.mHiddenViews.clear();
  }
  
  void removeView(View paramView)
  {
    int i = this.mCallback.indexOfChild(paramView);
    if (i < 0) {}
    for (;;)
    {
      return;
      this.mCallback.removeViewAt(i);
      if (this.mBucket.remove(i)) {
        this.mHiddenViews.remove(paramView);
      }
    }
  }
  
  void removeViewAt(int paramInt)
  {
    int i = getOffset(paramInt);
    View localView = this.mCallback.getChildAt(i);
    if (localView == null) {}
    for (;;)
    {
      return;
      this.mCallback.removeViewAt(i);
      if (this.mBucket.remove(i)) {
        this.mHiddenViews.remove(localView);
      }
    }
  }
  
  boolean removeViewIfHidden(View paramView)
  {
    boolean bool = true;
    int i = this.mCallback.indexOfChild(paramView);
    if (i == -1) {
      this.mHiddenViews.remove(paramView);
    }
    for (;;)
    {
      return bool;
      if (this.mBucket.get(i))
      {
        this.mBucket.remove(i);
        this.mCallback.removeViewAt(i);
        this.mHiddenViews.remove(paramView);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public String toString()
  {
    return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ChildHelper
 * JD-Core Version:    0.7.0.1
 */