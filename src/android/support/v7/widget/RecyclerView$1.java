package android.support.v7.widget;

class RecyclerView$1
  implements Runnable
{
  RecyclerView$1(RecyclerView paramRecyclerView) {}
  
  public void run()
  {
    if (!RecyclerView.access$100(this.this$0)) {}
    for (;;)
    {
      return;
      if (RecyclerView.access$200(this.this$0))
      {
        this.this$0.dispatchLayout();
      }
      else if (this.this$0.mAdapterHelper.hasPendingUpdates())
      {
        this.this$0.eatRequestLayout();
        this.this$0.mAdapterHelper.preProcess();
        if (!RecyclerView.access$300(this.this$0)) {
          this.this$0.rebindUpdatedViewHolders();
        }
        this.this$0.resumeRequestLayout(true);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.1
 * JD-Core Version:    0.7.0.1
 */