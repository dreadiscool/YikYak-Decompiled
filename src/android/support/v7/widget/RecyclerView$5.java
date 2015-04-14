package android.support.v7.widget;

class RecyclerView$5
  implements AdapterHelper.Callback
{
  RecyclerView$5(RecyclerView paramRecyclerView) {}
  
  void dispatchUpdate(AdapterHelper.UpdateOp paramUpdateOp)
  {
    switch (paramUpdateOp.cmd)
    {
    }
    for (;;)
    {
      return;
      RecyclerView.access$1100(this.this$0).onItemsAdded(this.this$0, paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      continue;
      RecyclerView.access$1100(this.this$0).onItemsRemoved(this.this$0, paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      continue;
      RecyclerView.access$1100(this.this$0).onItemsUpdated(this.this$0, paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      continue;
      RecyclerView.access$1100(this.this$0).onItemsMoved(this.this$0, paramUpdateOp.positionStart, paramUpdateOp.itemCount, 1);
    }
  }
  
  public RecyclerView.ViewHolder findViewHolder(int paramInt)
  {
    return this.this$0.findViewHolderForPosition(paramInt, true);
  }
  
  public void markViewHoldersUpdated(int paramInt1, int paramInt2)
  {
    this.this$0.viewRangeUpdate(paramInt1, paramInt2);
    this.this$0.mItemsChanged = true;
  }
  
  public void offsetPositionsForAdd(int paramInt1, int paramInt2)
  {
    this.this$0.offsetPositionRecordsForInsert(paramInt1, paramInt2);
    this.this$0.mItemsAddedOrRemoved = true;
  }
  
  public void offsetPositionsForMove(int paramInt1, int paramInt2)
  {
    this.this$0.offsetPositionRecordsForMove(paramInt1, paramInt2);
    this.this$0.mItemsAddedOrRemoved = true;
  }
  
  public void offsetPositionsForRemovingInvisible(int paramInt1, int paramInt2)
  {
    this.this$0.offsetPositionRecordsForRemove(paramInt1, paramInt2, true);
    this.this$0.mItemsAddedOrRemoved = true;
    RecyclerView.State.access$1012(this.this$0.mState, paramInt2);
  }
  
  public void offsetPositionsForRemovingLaidOutOrNewView(int paramInt1, int paramInt2)
  {
    this.this$0.offsetPositionRecordsForRemove(paramInt1, paramInt2, false);
    this.this$0.mItemsAddedOrRemoved = true;
  }
  
  public void onDispatchFirstPass(AdapterHelper.UpdateOp paramUpdateOp)
  {
    dispatchUpdate(paramUpdateOp);
  }
  
  public void onDispatchSecondPass(AdapterHelper.UpdateOp paramUpdateOp)
  {
    dispatchUpdate(paramUpdateOp);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.5
 * JD-Core Version:    0.7.0.1
 */