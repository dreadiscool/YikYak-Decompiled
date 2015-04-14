package android.support.v7.widget;

import android.view.ViewGroup;

public abstract class RecyclerView$Adapter<VH extends RecyclerView.ViewHolder>
{
  private boolean mHasStableIds = false;
  private final RecyclerView.AdapterDataObservable mObservable = new RecyclerView.AdapterDataObservable();
  
  public final void bindViewHolder(VH paramVH, int paramInt)
  {
    paramVH.mPosition = paramInt;
    if (hasStableIds()) {
      paramVH.mItemId = getItemId(paramInt);
    }
    onBindViewHolder(paramVH, paramInt);
    paramVH.setFlags(1, 7);
  }
  
  public final VH createViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = onCreateViewHolder(paramViewGroup, paramInt);
    localViewHolder.mItemViewType = paramInt;
    return localViewHolder;
  }
  
  public abstract int getItemCount();
  
  public long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final boolean hasObservers()
  {
    return this.mObservable.hasObservers();
  }
  
  public final boolean hasStableIds()
  {
    return this.mHasStableIds;
  }
  
  public final void notifyDataSetChanged()
  {
    this.mObservable.notifyChanged();
  }
  
  public final void notifyItemChanged(int paramInt)
  {
    this.mObservable.notifyItemRangeChanged(paramInt, 1);
  }
  
  public final void notifyItemInserted(int paramInt)
  {
    this.mObservable.notifyItemRangeInserted(paramInt, 1);
  }
  
  public final void notifyItemMoved(int paramInt1, int paramInt2)
  {
    this.mObservable.notifyItemMoved(paramInt1, paramInt2);
  }
  
  public final void notifyItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.mObservable.notifyItemRangeChanged(paramInt1, paramInt2);
  }
  
  public final void notifyItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.mObservable.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public final void notifyItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.mObservable.notifyItemRangeRemoved(paramInt1, paramInt2);
  }
  
  public final void notifyItemRemoved(int paramInt)
  {
    this.mObservable.notifyItemRangeRemoved(paramInt, 1);
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView) {}
  
  public abstract void onBindViewHolder(VH paramVH, int paramInt);
  
  public abstract VH onCreateViewHolder(ViewGroup paramViewGroup, int paramInt);
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView) {}
  
  public void onViewAttachedToWindow(VH paramVH) {}
  
  public void onViewDetachedFromWindow(VH paramVH) {}
  
  public void onViewRecycled(VH paramVH) {}
  
  public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver paramAdapterDataObserver)
  {
    this.mObservable.registerObserver(paramAdapterDataObserver);
  }
  
  public void setHasStableIds(boolean paramBoolean)
  {
    if (hasObservers()) {
      throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
    }
    this.mHasStableIds = paramBoolean;
  }
  
  public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver paramAdapterDataObserver)
  {
    this.mObservable.unregisterObserver(paramAdapterDataObserver);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.Adapter
 * JD-Core Version:    0.7.0.1
 */