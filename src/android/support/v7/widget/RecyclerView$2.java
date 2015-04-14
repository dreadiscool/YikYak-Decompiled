package android.support.v7.widget;

class RecyclerView$2
  implements Runnable
{
  RecyclerView$2(RecyclerView paramRecyclerView) {}
  
  public void run()
  {
    if (this.this$0.mItemAnimator != null) {
      this.this$0.mItemAnimator.runPendingAnimations();
    }
    RecyclerView.access$502(this.this$0, false);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.2
 * JD-Core Version:    0.7.0.1
 */