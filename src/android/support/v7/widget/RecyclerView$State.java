package android.support.v7.widget;

import android.support.v4.util.ArrayMap;
import android.util.SparseArray;

public class RecyclerView$State
{
  private SparseArray<Object> mData;
  private int mDeletedInvisibleItemCountSincePreviousLayout = 0;
  private boolean mInPreLayout = false;
  int mItemCount = 0;
  ArrayMap<Long, RecyclerView.ViewHolder> mOldChangedHolders = new ArrayMap();
  ArrayMap<RecyclerView.ViewHolder, RecyclerView.ItemHolderInfo> mPostLayoutHolderMap = new ArrayMap();
  ArrayMap<RecyclerView.ViewHolder, RecyclerView.ItemHolderInfo> mPreLayoutHolderMap = new ArrayMap();
  private int mPreviousLayoutItemCount = 0;
  private boolean mRunPredictiveAnimations = false;
  private boolean mRunSimpleAnimations = false;
  private boolean mStructureChanged = false;
  private int mTargetPosition = -1;
  
  private void removeFrom(ArrayMap<Long, RecyclerView.ViewHolder> paramArrayMap, RecyclerView.ViewHolder paramViewHolder)
  {
    for (int i = -1 + paramArrayMap.size();; i--) {
      if (i >= 0)
      {
        if (paramViewHolder == paramArrayMap.valueAt(i)) {
          paramArrayMap.removeAt(i);
        }
      }
      else {
        return;
      }
    }
  }
  
  public boolean didStructureChange()
  {
    return this.mStructureChanged;
  }
  
  public <T> T get(int paramInt)
  {
    if (this.mData == null) {}
    for (Object localObject = null;; localObject = this.mData.get(paramInt)) {
      return localObject;
    }
  }
  
  public int getItemCount()
  {
    if (this.mInPreLayout) {}
    for (int i = this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;; i = this.mItemCount) {
      return i;
    }
  }
  
  public int getTargetScrollPosition()
  {
    return this.mTargetPosition;
  }
  
  public boolean hasTargetScrollPosition()
  {
    if (this.mTargetPosition != -1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isPreLayout()
  {
    return this.mInPreLayout;
  }
  
  public void onViewIgnored(RecyclerView.ViewHolder paramViewHolder)
  {
    onViewRecycled(paramViewHolder);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    this.mPreLayoutHolderMap.remove(paramViewHolder);
    this.mPostLayoutHolderMap.remove(paramViewHolder);
    if (this.mOldChangedHolders != null) {
      removeFrom(this.mOldChangedHolders, paramViewHolder);
    }
  }
  
  public void put(int paramInt, Object paramObject)
  {
    if (this.mData == null) {
      this.mData = new SparseArray();
    }
    this.mData.put(paramInt, paramObject);
  }
  
  public void remove(int paramInt)
  {
    if (this.mData == null) {}
    for (;;)
    {
      return;
      this.mData.remove(paramInt);
    }
  }
  
  State reset()
  {
    this.mTargetPosition = -1;
    if (this.mData != null) {
      this.mData.clear();
    }
    this.mItemCount = 0;
    this.mStructureChanged = false;
    return this;
  }
  
  public String toString()
  {
    return "State{mTargetPosition=" + this.mTargetPosition + ", mPreLayoutHolderMap=" + this.mPreLayoutHolderMap + ", mPostLayoutHolderMap=" + this.mPostLayoutHolderMap + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
  }
  
  public boolean willRunPredictiveAnimations()
  {
    return this.mRunPredictiveAnimations;
  }
  
  public boolean willRunSimpleAnimations()
  {
    return this.mRunSimpleAnimations;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.State
 * JD-Core Version:    0.7.0.1
 */