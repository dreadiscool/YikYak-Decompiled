package android.support.v7.widget;

class RecyclerView$ItemAnimatorRestoreListener
  implements RecyclerView.ItemAnimator.ItemAnimatorListener
{
  private RecyclerView$ItemAnimatorRestoreListener(RecyclerView paramRecyclerView) {}
  
  public void onAddFinished(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder.setIsRecyclable(true);
    if (paramViewHolder.isRecyclable()) {
      RecyclerView.access$5000(this.this$0, paramViewHolder.itemView);
    }
  }
  
  public void onChangeFinished(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder.setIsRecyclable(true);
    if ((paramViewHolder.mShadowedHolder != null) && (paramViewHolder.mShadowingHolder == null))
    {
      paramViewHolder.mShadowedHolder = null;
      paramViewHolder.setFlags(-65, RecyclerView.ViewHolder.access$5100(paramViewHolder));
    }
    paramViewHolder.mShadowingHolder = null;
    if (paramViewHolder.isRecyclable()) {
      RecyclerView.access$5000(this.this$0, paramViewHolder.itemView);
    }
  }
  
  public void onMoveFinished(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder.setIsRecyclable(true);
    if (paramViewHolder.isRecyclable()) {
      RecyclerView.access$5000(this.this$0, paramViewHolder.itemView);
    }
  }
  
  public void onRemoveFinished(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder.setIsRecyclable(true);
    if ((!RecyclerView.access$5000(this.this$0, paramViewHolder.itemView)) && (paramViewHolder.isTmpDetached())) {
      this.this$0.removeDetachedView(paramViewHolder.itemView, false);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.ItemAnimatorRestoreListener
 * JD-Core Version:    0.7.0.1
 */