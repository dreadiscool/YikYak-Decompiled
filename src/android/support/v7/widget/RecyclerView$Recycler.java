package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecyclerView$Recycler
{
  private static final int DEFAULT_CACHE_SIZE = 2;
  final ArrayList<RecyclerView.ViewHolder> mAttachedScrap = new ArrayList();
  final ArrayList<RecyclerView.ViewHolder> mCachedViews = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mChangedScrap = null;
  private RecyclerView.RecycledViewPool mRecyclerPool;
  private final List<RecyclerView.ViewHolder> mUnmodifiableAttachedScrap = Collections.unmodifiableList(this.mAttachedScrap);
  private RecyclerView.ViewCacheExtension mViewCacheExtension;
  private int mViewCacheMax = 2;
  
  public RecyclerView$Recycler(RecyclerView paramRecyclerView) {}
  
  private void attachAccessibilityDelegate(View paramView)
  {
    if ((RecyclerView.access$3800(this.this$0) != null) && (RecyclerView.access$3800(this.this$0).isEnabled()))
    {
      if (ViewCompat.getImportantForAccessibility(paramView) == 0) {
        ViewCompat.setImportantForAccessibility(paramView, 1);
      }
      if (!ViewCompat.hasAccessibilityDelegate(paramView)) {
        ViewCompat.setAccessibilityDelegate(paramView, RecyclerView.access$3900(this.this$0).getItemDelegate());
      }
    }
  }
  
  private void invalidateDisplayListInt(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder.itemView instanceof ViewGroup)) {
      invalidateDisplayListInt((ViewGroup)paramViewHolder.itemView, false);
    }
  }
  
  private void invalidateDisplayListInt(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    for (int i = -1 + paramViewGroup.getChildCount(); i >= 0; i--)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        invalidateDisplayListInt((ViewGroup)localView, true);
      }
    }
    if (!paramBoolean) {}
    for (;;)
    {
      return;
      if (paramViewGroup.getVisibility() == 4)
      {
        paramViewGroup.setVisibility(0);
        paramViewGroup.setVisibility(4);
      }
      else
      {
        int j = paramViewGroup.getVisibility();
        paramViewGroup.setVisibility(4);
        paramViewGroup.setVisibility(j);
      }
    }
  }
  
  public void bindViewToPosition(View paramView, int paramInt)
  {
    boolean bool = true;
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder == null) {
      throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
    }
    int i = this.this$0.mAdapterHelper.findPositionOffset(paramInt);
    if ((i < 0) || (i >= RecyclerView.access$2200(this.this$0).getItemCount())) {
      throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + i + ")." + "state:" + this.this$0.mState.getItemCount());
    }
    RecyclerView.access$2200(this.this$0).bindViewHolder(localViewHolder, i);
    attachAccessibilityDelegate(paramView);
    if (this.this$0.mState.isPreLayout()) {
      localViewHolder.mPreLayoutPosition = paramInt;
    }
    ViewGroup.LayoutParams localLayoutParams = localViewHolder.itemView.getLayoutParams();
    RecyclerView.LayoutParams localLayoutParams1;
    if (localLayoutParams == null)
    {
      localLayoutParams1 = (RecyclerView.LayoutParams)this.this$0.generateDefaultLayoutParams();
      localViewHolder.itemView.setLayoutParams(localLayoutParams1);
      localLayoutParams1.mInsetsDirty = bool;
      localLayoutParams1.mViewHolder = localViewHolder;
      if (localViewHolder.itemView.getParent() != null) {
        break label271;
      }
    }
    for (;;)
    {
      localLayoutParams1.mPendingInvalidate = bool;
      return;
      if (!this.this$0.checkLayoutParams(localLayoutParams))
      {
        localLayoutParams1 = (RecyclerView.LayoutParams)this.this$0.generateLayoutParams(localLayoutParams);
        localViewHolder.itemView.setLayoutParams(localLayoutParams1);
        break;
      }
      localLayoutParams1 = (RecyclerView.LayoutParams)localLayoutParams;
      break;
      label271:
      bool = false;
    }
  }
  
  public void clear()
  {
    this.mAttachedScrap.clear();
    recycleAndClearCachedViews();
  }
  
  void clearOldPositions()
  {
    int i = 0;
    int j = this.mCachedViews.size();
    for (int k = 0; k < j; k++) {
      ((RecyclerView.ViewHolder)this.mCachedViews.get(k)).clearOldPosition();
    }
    int m = this.mAttachedScrap.size();
    for (int n = 0; n < m; n++) {
      ((RecyclerView.ViewHolder)this.mAttachedScrap.get(n)).clearOldPosition();
    }
    if (this.mChangedScrap != null)
    {
      int i1 = this.mChangedScrap.size();
      while (i < i1)
      {
        ((RecyclerView.ViewHolder)this.mChangedScrap.get(i)).clearOldPosition();
        i++;
      }
    }
  }
  
  void clearScrap()
  {
    this.mAttachedScrap.clear();
  }
  
  public int convertPreLayoutPositionToPostLayout(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.this$0.mState.getItemCount())) {
      throw new IndexOutOfBoundsException("invalid position " + paramInt + ". State " + "item count is " + this.this$0.mState.getItemCount());
    }
    if (!this.this$0.mState.isPreLayout()) {}
    for (;;)
    {
      return paramInt;
      paramInt = this.this$0.mAdapterHelper.findPositionOffset(paramInt);
    }
  }
  
  void dispatchViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    if (RecyclerView.access$4100(this.this$0) != null) {
      RecyclerView.access$4100(this.this$0).onViewRecycled(paramViewHolder);
    }
    if (RecyclerView.access$2200(this.this$0) != null) {
      RecyclerView.access$2200(this.this$0).onViewRecycled(paramViewHolder);
    }
    if (this.this$0.mState != null) {
      this.this$0.mState.onViewRecycled(paramViewHolder);
    }
  }
  
  RecyclerView.ViewHolder getChangedScrapViewForPosition(int paramInt)
  {
    int i = 0;
    int j;
    RecyclerView.ViewHolder localViewHolder;
    if (this.mChangedScrap != null)
    {
      j = this.mChangedScrap.size();
      if (j != 0) {}
    }
    else
    {
      localViewHolder = null;
    }
    for (;;)
    {
      return localViewHolder;
      for (int k = 0;; k++)
      {
        if (k >= j) {
          break label80;
        }
        localViewHolder = (RecyclerView.ViewHolder)this.mChangedScrap.get(k);
        if ((!localViewHolder.wasReturnedFromScrap()) && (localViewHolder.getPosition() == paramInt))
        {
          localViewHolder.addFlags(32);
          break;
        }
      }
      label80:
      if (RecyclerView.access$2200(this.this$0).hasStableIds())
      {
        int m = this.this$0.mAdapterHelper.findPositionOffset(paramInt);
        if ((m > 0) && (m < RecyclerView.access$2200(this.this$0).getItemCount()))
        {
          long l = RecyclerView.access$2200(this.this$0).getItemId(m);
          for (;;)
          {
            if (i >= j) {
              break label190;
            }
            localViewHolder = (RecyclerView.ViewHolder)this.mChangedScrap.get(i);
            if ((!localViewHolder.wasReturnedFromScrap()) && (localViewHolder.getItemId() == l))
            {
              localViewHolder.addFlags(32);
              break;
            }
            i++;
          }
        }
      }
      label190:
      localViewHolder = null;
    }
  }
  
  RecyclerView.RecycledViewPool getRecycledViewPool()
  {
    if (this.mRecyclerPool == null) {
      this.mRecyclerPool = new RecyclerView.RecycledViewPool();
    }
    return this.mRecyclerPool;
  }
  
  int getScrapCount()
  {
    return this.mAttachedScrap.size();
  }
  
  public List<RecyclerView.ViewHolder> getScrapList()
  {
    return this.mUnmodifiableAttachedScrap;
  }
  
  View getScrapViewAt(int paramInt)
  {
    return ((RecyclerView.ViewHolder)this.mAttachedScrap.get(paramInt)).itemView;
  }
  
  RecyclerView.ViewHolder getScrapViewForId(long paramLong, int paramInt, boolean paramBoolean)
  {
    int i = -1 + this.mAttachedScrap.size();
    RecyclerView.ViewHolder localViewHolder;
    if (i >= 0)
    {
      localViewHolder = (RecyclerView.ViewHolder)this.mAttachedScrap.get(i);
      if ((localViewHolder.getItemId() == paramLong) && (!localViewHolder.wasReturnedFromScrap())) {
        if (paramInt == localViewHolder.getItemViewType())
        {
          localViewHolder.addFlags(32);
          if ((localViewHolder.isRemoved()) && (!this.this$0.mState.isPreLayout())) {
            localViewHolder.setFlags(2, 14);
          }
        }
      }
    }
    for (;;)
    {
      return localViewHolder;
      if (!paramBoolean)
      {
        this.mAttachedScrap.remove(i);
        this.this$0.removeDetachedView(localViewHolder.itemView, false);
        quickRecycleScrapView(localViewHolder.itemView);
      }
      i--;
      break;
      for (int j = -1 + this.mCachedViews.size();; j--)
      {
        if (j < 0) {
          break label226;
        }
        localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(j);
        if (localViewHolder.getItemId() == paramLong)
        {
          if (paramInt == localViewHolder.getItemViewType())
          {
            if (paramBoolean) {
              break;
            }
            this.mCachedViews.remove(j);
            break;
          }
          if (!paramBoolean) {
            tryToRecycleCachedViewAt(j);
          }
        }
      }
      label226:
      localViewHolder = null;
    }
  }
  
  RecyclerView.ViewHolder getScrapViewForPosition(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = 0;
    int j = this.mAttachedScrap.size();
    int k = 0;
    RecyclerView.ViewHolder localViewHolder;
    if (k < j)
    {
      localViewHolder = (RecyclerView.ViewHolder)this.mAttachedScrap.get(k);
      if ((localViewHolder.wasReturnedFromScrap()) || (localViewHolder.getPosition() != paramInt1) || (localViewHolder.isInvalid()) || ((!RecyclerView.State.access$1500(this.this$0.mState)) && (localViewHolder.isRemoved()))) {
        break label270;
      }
      if ((paramInt2 != -1) && (localViewHolder.getItemViewType() != paramInt2)) {
        new StringBuilder().append("Scrap view for position ").append(paramInt1).append(" isn't dirty but has").append(" wrong view type! (found ").append(localViewHolder.getItemViewType()).append(" but expected ").append(paramInt2).append(")").toString();
      }
    }
    else
    {
      if (!paramBoolean)
      {
        View localView = this.this$0.mChildHelper.findHiddenNonRemovedView(paramInt1, paramInt2);
        if (localView != null) {
          this.this$0.mItemAnimator.endAnimation(this.this$0.getChildViewHolder(localView));
        }
      }
      int m = this.mCachedViews.size();
      label205:
      if (i >= m) {
        break label282;
      }
      localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
      if ((localViewHolder.isInvalid()) || (localViewHolder.getPosition() != paramInt1)) {
        break label276;
      }
      if (!paramBoolean) {
        this.mCachedViews.remove(i);
      }
    }
    for (;;)
    {
      return localViewHolder;
      localViewHolder.addFlags(32);
      continue;
      label270:
      k++;
      break;
      label276:
      i++;
      break label205;
      label282:
      localViewHolder = null;
    }
  }
  
  public View getViewForPosition(int paramInt)
  {
    return getViewForPosition(paramInt, false);
  }
  
  View getViewForPosition(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramInt < 0) || (paramInt >= this.this$0.mState.getItemCount())) {
      throw new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + this.this$0.mState.getItemCount());
    }
    int i3;
    int i;
    RecyclerView.ViewHolder localViewHolder1;
    if (this.this$0.mState.isPreLayout())
    {
      RecyclerView.ViewHolder localViewHolder4 = getChangedScrapViewForPosition(paramInt);
      if (localViewHolder4 != null)
      {
        i3 = bool;
        i = i3;
        localViewHolder1 = localViewHolder4;
      }
    }
    for (;;)
    {
      label178:
      int j;
      if (localViewHolder1 == null)
      {
        localViewHolder1 = getScrapViewForPosition(paramInt, -1, paramBoolean);
        if (localViewHolder1 != null) {
          if (!validateViewHolderForOffsetPosition(localViewHolder1)) {
            if (!paramBoolean)
            {
              localViewHolder1.addFlags(4);
              if (localViewHolder1.isScrap())
              {
                this.this$0.removeDetachedView(localViewHolder1.itemView, false);
                localViewHolder1.unScrap();
                recycleViewHolderInternal(localViewHolder1);
              }
            }
            else
            {
              localViewHolder1 = null;
              j = i;
            }
          }
        }
      }
      for (;;)
      {
        RecyclerView.ViewHolder localViewHolder3;
        int k;
        if (localViewHolder1 == null)
        {
          int i1 = this.this$0.mAdapterHelper.findPositionOffset(paramInt);
          if ((i1 < 0) || (i1 >= RecyclerView.access$2200(this.this$0).getItemCount()))
          {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + i1 + ")." + "state:" + this.this$0.mState.getItemCount());
            i3 = 0;
            break;
            if (!localViewHolder1.wasReturnedFromScrap()) {
              break label178;
            }
            localViewHolder1.clearReturnedFromScrapFlag();
            break label178;
            j = bool;
            continue;
          }
          int i2 = RecyclerView.access$2200(this.this$0).getItemViewType(i1);
          if (RecyclerView.access$2200(this.this$0).hasStableIds())
          {
            localViewHolder1 = getScrapViewForId(RecyclerView.access$2200(this.this$0).getItemId(i1), i2, paramBoolean);
            if (localViewHolder1 != null)
            {
              localViewHolder1.mPosition = i1;
              j = bool;
            }
          }
          if ((localViewHolder1 == null) && (this.mViewCacheExtension != null))
          {
            View localView = this.mViewCacheExtension.getViewForPositionAndType(this, paramInt, i2);
            if (localView != null)
            {
              localViewHolder1 = this.this$0.getChildViewHolder(localView);
              if (localViewHolder1 == null) {
                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
              }
              if (localViewHolder1.shouldIgnore()) {
                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
              }
            }
          }
          if (localViewHolder1 == null)
          {
            localViewHolder1 = getRecycledViewPool().getRecycledView(RecyclerView.access$2200(this.this$0).getItemViewType(i1));
            if (localViewHolder1 != null)
            {
              localViewHolder1.resetInternal();
              if (RecyclerView.access$3700()) {
                invalidateDisplayListInt(localViewHolder1);
              }
            }
          }
          if (localViewHolder1 == null)
          {
            localViewHolder3 = RecyclerView.access$2200(this.this$0).createViewHolder(this.this$0, RecyclerView.access$2200(this.this$0).getItemViewType(i1));
            k = j;
          }
        }
        for (RecyclerView.ViewHolder localViewHolder2 = localViewHolder3;; localViewHolder2 = localViewHolder1)
        {
          int n;
          if ((this.this$0.mState.isPreLayout()) && (localViewHolder2.isBound()))
          {
            localViewHolder2.mPreLayoutPosition = paramInt;
            n = 0;
          }
          for (;;)
          {
            ViewGroup.LayoutParams localLayoutParams = localViewHolder2.itemView.getLayoutParams();
            RecyclerView.LayoutParams localLayoutParams1;
            if (localLayoutParams == null)
            {
              localLayoutParams1 = (RecyclerView.LayoutParams)this.this$0.generateDefaultLayoutParams();
              localViewHolder2.itemView.setLayoutParams(localLayoutParams1);
              label612:
              localLayoutParams1.mViewHolder = localViewHolder2;
              if ((k == 0) || (n == 0)) {
                break label775;
              }
            }
            for (;;)
            {
              localLayoutParams1.mPendingInvalidate = bool;
              return localViewHolder2.itemView;
              if ((localViewHolder2.isBound()) && (!localViewHolder2.needsUpdate()) && (!localViewHolder2.isInvalid())) {
                break label780;
              }
              int m = this.this$0.mAdapterHelper.findPositionOffset(paramInt);
              RecyclerView.access$2200(this.this$0).bindViewHolder(localViewHolder2, m);
              attachAccessibilityDelegate(localViewHolder2.itemView);
              if (this.this$0.mState.isPreLayout()) {
                localViewHolder2.mPreLayoutPosition = paramInt;
              }
              n = bool;
              break;
              if (!this.this$0.checkLayoutParams(localLayoutParams))
              {
                localLayoutParams1 = (RecyclerView.LayoutParams)this.this$0.generateLayoutParams(localLayoutParams);
                localViewHolder2.itemView.setLayoutParams(localLayoutParams1);
                break label612;
              }
              localLayoutParams1 = (RecyclerView.LayoutParams)localLayoutParams;
              break label612;
              label775:
              bool = false;
            }
            label780:
            n = 0;
          }
          k = j;
        }
        j = i;
      }
      localViewHolder1 = null;
      i = 0;
    }
  }
  
  void markItemDecorInsetsDirty()
  {
    int i = this.mCachedViews.size();
    for (int j = 0; j < i; j++)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((RecyclerView.ViewHolder)this.mCachedViews.get(j)).itemView.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.mInsetsDirty = true;
      }
    }
  }
  
  void markKnownViewsInvalid()
  {
    int j;
    int k;
    if ((RecyclerView.access$2200(this.this$0) != null) && (RecyclerView.access$2200(this.this$0).hasStableIds()))
    {
      j = this.mCachedViews.size();
      k = 0;
    }
    while (k < j)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(k);
      if (localViewHolder != null) {
        localViewHolder.addFlags(6);
      }
      k++;
      continue;
      for (int i = -1 + this.mCachedViews.size(); i >= 0; i--) {
        if (!tryToRecycleCachedViewAt(i)) {
          ((RecyclerView.ViewHolder)this.mCachedViews.get(i)).addFlags(6);
        }
      }
    }
  }
  
  void offsetPositionRecordsForInsert(int paramInt1, int paramInt2)
  {
    int i = this.mCachedViews.size();
    for (int j = 0; j < i; j++)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(j);
      if ((localViewHolder != null) && (localViewHolder.getPosition() >= paramInt1)) {
        localViewHolder.offsetPosition(paramInt2, true);
      }
    }
  }
  
  void offsetPositionRecordsForMove(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    int n;
    label26:
    RecyclerView.ViewHolder localViewHolder;
    if (paramInt1 < paramInt2)
    {
      i = -1;
      j = paramInt2;
      k = paramInt1;
      int m = this.mCachedViews.size();
      n = 0;
      if (n >= m) {
        return;
      }
      localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(n);
      if ((localViewHolder != null) && (localViewHolder.mPosition >= k) && (localViewHolder.mPosition <= j)) {
        break label89;
      }
    }
    for (;;)
    {
      n++;
      break label26;
      i = 1;
      j = paramInt1;
      k = paramInt2;
      break;
      label89:
      if (localViewHolder.mPosition == paramInt1) {
        localViewHolder.offsetPosition(paramInt2 - paramInt1, false);
      } else {
        localViewHolder.offsetPosition(i, false);
      }
    }
  }
  
  void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramInt1 + paramInt2;
    int j = -1 + this.mCachedViews.size();
    if (j >= 0)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(j);
      if (localViewHolder != null)
      {
        if (localViewHolder.getPosition() < i) {
          break label65;
        }
        localViewHolder.offsetPosition(-paramInt2, paramBoolean);
      }
      for (;;)
      {
        j--;
        break;
        label65:
        if ((localViewHolder.getPosition() >= paramInt1) && (!tryToRecycleCachedViewAt(j))) {
          localViewHolder.addFlags(4);
        }
      }
    }
  }
  
  void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2, boolean paramBoolean)
  {
    clear();
    getRecycledViewPool().onAdapterChanged(paramAdapter1, paramAdapter2, paramBoolean);
  }
  
  void quickRecycleScrapView(View paramView)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    RecyclerView.ViewHolder.access$4002(localViewHolder, null);
    localViewHolder.clearReturnedFromScrapFlag();
    recycleViewHolderInternal(localViewHolder);
  }
  
  void recycleAndClearCachedViews()
  {
    for (int i = -1 + this.mCachedViews.size(); i >= 0; i--) {
      tryToRecycleCachedViewAt(i);
    }
    this.mCachedViews.clear();
  }
  
  public void recycleView(View paramView)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder.isTmpDetached()) {
      this.this$0.removeDetachedView(paramView, false);
    }
    if (localViewHolder.isScrap()) {
      localViewHolder.unScrap();
    }
    for (;;)
    {
      recycleViewHolderInternal(localViewHolder);
      return;
      if (localViewHolder.wasReturnedFromScrap()) {
        localViewHolder.clearReturnedFromScrapFlag();
      }
    }
  }
  
  void recycleViewHolderInternal(RecyclerView.ViewHolder paramViewHolder)
  {
    boolean bool = true;
    int i = 0;
    if ((paramViewHolder.isScrap()) || (paramViewHolder.itemView.getParent() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(paramViewHolder.isScrap()).append(" isAttached:");
      if (paramViewHolder.itemView.getParent() != null) {}
      for (;;)
      {
        throw new IllegalArgumentException(bool);
        bool = false;
      }
    }
    if (paramViewHolder.isTmpDetached()) {
      throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paramViewHolder);
    }
    if (paramViewHolder.shouldIgnore()) {
      throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
    }
    if (paramViewHolder.isRecyclable()) {
      if ((!paramViewHolder.isInvalid()) && ((RecyclerView.State.access$1500(this.this$0.mState)) || (!paramViewHolder.isRemoved())) && (!paramViewHolder.isChanged())) {
        if ((this.mCachedViews.size() != this.mViewCacheMax) || (this.mCachedViews.isEmpty())) {}
      }
    }
    for (int j = 0;; j++) {
      if ((j >= this.mCachedViews.size()) || (tryToRecycleCachedViewAt(j)))
      {
        if (this.mCachedViews.size() < this.mViewCacheMax)
        {
          this.mCachedViews.add(paramViewHolder);
          i = bool;
        }
        if (i == 0)
        {
          getRecycledViewPool().putRecycledView(paramViewHolder);
          dispatchViewRecycled(paramViewHolder);
        }
        this.this$0.mState.onViewRecycled(paramViewHolder);
        return;
      }
    }
  }
  
  void recycleViewInternal(View paramView)
  {
    recycleViewHolderInternal(RecyclerView.getChildViewHolderInt(paramView));
  }
  
  void scrapView(View paramView)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    localViewHolder.setScrapContainer(this);
    if ((!localViewHolder.isChanged()) || (!RecyclerView.access$2400(this.this$0)))
    {
      if ((localViewHolder.isInvalid()) && (!localViewHolder.isRemoved()) && (!RecyclerView.access$2200(this.this$0).hasStableIds())) {
        throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
      }
      this.mAttachedScrap.add(localViewHolder);
    }
    for (;;)
    {
      return;
      if (this.mChangedScrap == null) {
        this.mChangedScrap = new ArrayList();
      }
      this.mChangedScrap.add(localViewHolder);
    }
  }
  
  void setRecycledViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    if (this.mRecyclerPool != null) {
      this.mRecyclerPool.detach();
    }
    this.mRecyclerPool = paramRecycledViewPool;
    if (paramRecycledViewPool != null) {
      this.mRecyclerPool.attach(this.this$0.getAdapter());
    }
  }
  
  void setViewCacheExtension(RecyclerView.ViewCacheExtension paramViewCacheExtension)
  {
    this.mViewCacheExtension = paramViewCacheExtension;
  }
  
  public void setViewCacheSize(int paramInt)
  {
    this.mViewCacheMax = paramInt;
    for (int i = -1 + this.mCachedViews.size(); (i >= 0) && (this.mCachedViews.size() > paramInt); i--) {
      tryToRecycleCachedViewAt(i);
    }
    while (this.mCachedViews.size() > paramInt) {
      this.mCachedViews.remove(-1 + this.mCachedViews.size());
    }
  }
  
  boolean tryToRecycleCachedViewAt(int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(paramInt);
    if (localViewHolder.isRecyclable())
    {
      getRecycledViewPool().putRecycledView(localViewHolder);
      dispatchViewRecycled(localViewHolder);
      this.mCachedViews.remove(paramInt);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void unscrapView(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((!paramViewHolder.isChanged()) || (!RecyclerView.access$2400(this.this$0)) || (this.mChangedScrap == null)) {
      this.mAttachedScrap.remove(paramViewHolder);
    }
    for (;;)
    {
      RecyclerView.ViewHolder.access$4002(paramViewHolder, null);
      paramViewHolder.clearReturnedFromScrapFlag();
      return;
      this.mChangedScrap.remove(paramViewHolder);
    }
  }
  
  boolean validateViewHolderForOffsetPosition(RecyclerView.ViewHolder paramViewHolder)
  {
    boolean bool = true;
    if (paramViewHolder.isRemoved()) {}
    for (;;)
    {
      return bool;
      if ((paramViewHolder.mPosition < 0) || (paramViewHolder.mPosition >= RecyclerView.access$2200(this.this$0).getItemCount())) {
        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + paramViewHolder);
      }
      if ((!this.this$0.mState.isPreLayout()) && (RecyclerView.access$2200(this.this$0).getItemViewType(paramViewHolder.mPosition) != paramViewHolder.getItemViewType())) {
        bool = false;
      } else if ((RecyclerView.access$2200(this.this$0).hasStableIds()) && (paramViewHolder.getItemId() != RecyclerView.access$2200(this.this$0).getItemId(paramViewHolder.mPosition))) {
        bool = false;
      }
    }
  }
  
  void viewRangeUpdate(int paramInt1, int paramInt2)
  {
    int i = paramInt1 + paramInt2;
    int j = this.mCachedViews.size();
    int k = 0;
    if (k < j)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(k);
      if (localViewHolder == null) {}
      for (;;)
      {
        k++;
        break;
        int m = localViewHolder.getPosition();
        if ((m >= paramInt1) && (m < i)) {
          localViewHolder.addFlags(2);
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.Recycler
 * JD-Core Version:    0.7.0.1
 */