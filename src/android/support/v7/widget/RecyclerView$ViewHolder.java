package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

public abstract class RecyclerView$ViewHolder
{
  static final int FLAG_BOUND = 1;
  static final int FLAG_CHANGED = 64;
  static final int FLAG_IGNORE = 128;
  static final int FLAG_INVALID = 4;
  static final int FLAG_NOT_RECYCLABLE = 16;
  static final int FLAG_REMOVED = 8;
  static final int FLAG_RETURNED_FROM_SCRAP = 32;
  static final int FLAG_TMP_DETACHED = 256;
  static final int FLAG_UPDATE = 2;
  public final View itemView;
  private int mFlags;
  private int mIsRecyclableCount = 0;
  long mItemId = -1L;
  int mItemViewType = -1;
  int mOldPosition = -1;
  int mPosition = -1;
  int mPreLayoutPosition = -1;
  private RecyclerView.Recycler mScrapContainer = null;
  ViewHolder mShadowedHolder = null;
  ViewHolder mShadowingHolder = null;
  
  public RecyclerView$ViewHolder(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("itemView may not be null");
    }
    this.itemView = paramView;
  }
  
  void addFlags(int paramInt)
  {
    this.mFlags = (paramInt | this.mFlags);
  }
  
  void clearOldPosition()
  {
    this.mOldPosition = -1;
    this.mPreLayoutPosition = -1;
  }
  
  void clearReturnedFromScrapFlag()
  {
    this.mFlags = (0xFFFFFFDF & this.mFlags);
  }
  
  void clearTmpDetachFlag()
  {
    this.mFlags = (0xFFFFFEFF & this.mFlags);
  }
  
  void flagRemovedAndOffsetPosition(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    addFlags(8);
    offsetPosition(paramInt2, paramBoolean);
    this.mPosition = paramInt1;
  }
  
  public final long getItemId()
  {
    return this.mItemId;
  }
  
  public final int getItemViewType()
  {
    return this.mItemViewType;
  }
  
  public final int getOldPosition()
  {
    return this.mOldPosition;
  }
  
  public final int getPosition()
  {
    if (this.mPreLayoutPosition == -1) {}
    for (int i = this.mPosition;; i = this.mPreLayoutPosition) {
      return i;
    }
  }
  
  boolean isBound()
  {
    if ((0x1 & this.mFlags) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean isChanged()
  {
    if ((0x40 & this.mFlags) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean isInvalid()
  {
    if ((0x4 & this.mFlags) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean isRecyclable()
  {
    if (((0x10 & this.mFlags) == 0) && (!ViewCompat.hasTransientState(this.itemView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean isRemoved()
  {
    if ((0x8 & this.mFlags) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean isScrap()
  {
    if (this.mScrapContainer != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean isTmpDetached()
  {
    if ((0x100 & this.mFlags) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean needsUpdate()
  {
    if ((0x2 & this.mFlags) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void offsetPosition(int paramInt, boolean paramBoolean)
  {
    if (this.mOldPosition == -1) {
      this.mOldPosition = this.mPosition;
    }
    if (this.mPreLayoutPosition == -1) {
      this.mPreLayoutPosition = this.mPosition;
    }
    if (paramBoolean) {
      this.mPreLayoutPosition = (paramInt + this.mPreLayoutPosition);
    }
    this.mPosition = (paramInt + this.mPosition);
    if (this.itemView.getLayoutParams() != null) {
      ((RecyclerView.LayoutParams)this.itemView.getLayoutParams()).mInsetsDirty = true;
    }
  }
  
  void resetInternal()
  {
    this.mFlags = 0;
    this.mPosition = -1;
    this.mOldPosition = -1;
    this.mItemId = -1L;
    this.mPreLayoutPosition = -1;
    this.mIsRecyclableCount = 0;
    this.mShadowedHolder = null;
    this.mShadowingHolder = null;
  }
  
  void saveOldPosition()
  {
    if (this.mOldPosition == -1) {
      this.mOldPosition = this.mPosition;
    }
  }
  
  void setFlags(int paramInt1, int paramInt2)
  {
    this.mFlags = (this.mFlags & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void setIsRecyclable(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = -1 + this.mIsRecyclableCount;
      this.mIsRecyclableCount = i;
      if (this.mIsRecyclableCount >= 0) {
        break label60;
      }
      this.mIsRecyclableCount = 0;
      new StringBuilder().append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this).toString();
    }
    for (;;)
    {
      return;
      i = 1 + this.mIsRecyclableCount;
      break;
      label60:
      if ((!paramBoolean) && (this.mIsRecyclableCount == 1)) {
        this.mFlags = (0x10 | this.mFlags);
      } else if ((paramBoolean) && (this.mIsRecyclableCount == 0)) {
        this.mFlags = (0xFFFFFFEF & this.mFlags);
      }
    }
  }
  
  void setScrapContainer(RecyclerView.Recycler paramRecycler)
  {
    this.mScrapContainer = paramRecycler;
  }
  
  boolean shouldIgnore()
  {
    if ((0x80 & this.mFlags) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void stopIgnoring()
  {
    this.mFlags = (0xFFFFFF7F & this.mFlags);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
    if (isScrap()) {
      localStringBuilder.append(" scrap");
    }
    if (isInvalid()) {
      localStringBuilder.append(" invalid");
    }
    if (!isBound()) {
      localStringBuilder.append(" unbound");
    }
    if (needsUpdate()) {
      localStringBuilder.append(" update");
    }
    if (isRemoved()) {
      localStringBuilder.append(" removed");
    }
    if (shouldIgnore()) {
      localStringBuilder.append(" ignored");
    }
    if (isChanged()) {
      localStringBuilder.append(" changed");
    }
    if (isTmpDetached()) {
      localStringBuilder.append(" tmpDetached");
    }
    if (!isRecyclable()) {
      localStringBuilder.append(" not recyclable(" + this.mIsRecyclableCount + ")");
    }
    if (this.itemView.getParent() == null) {
      localStringBuilder.append(" no parent");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  void unScrap()
  {
    this.mScrapContainer.unscrapView(this);
  }
  
  boolean wasReturnedFromScrap()
  {
    if ((0x20 & this.mFlags) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.ViewHolder
 * JD-Core Version:    0.7.0.1
 */