package android.support.v7.widget;

class StaggeredGridLayoutManager$AnchorInfo
{
  boolean mInvalidateOffsets;
  boolean mLayoutFromEnd;
  int mOffset;
  int mPosition;
  
  private StaggeredGridLayoutManager$AnchorInfo(StaggeredGridLayoutManager paramStaggeredGridLayoutManager) {}
  
  void assignCoordinateFromPadding()
  {
    if (this.mLayoutFromEnd) {}
    for (int i = this.this$0.mPrimaryOrientation.getEndAfterPadding();; i = this.this$0.mPrimaryOrientation.getStartAfterPadding())
    {
      this.mOffset = i;
      return;
    }
  }
  
  void assignCoordinateFromPadding(int paramInt)
  {
    if (this.mLayoutFromEnd) {}
    for (this.mOffset = (this.this$0.mPrimaryOrientation.getEndAfterPadding() - paramInt);; this.mOffset = (paramInt + this.this$0.mPrimaryOrientation.getStartAfterPadding())) {
      return;
    }
  }
  
  void reset()
  {
    this.mPosition = -1;
    this.mOffset = -2147483648;
    this.mLayoutFromEnd = false;
    this.mInvalidateOffsets = false;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.AnchorInfo
 * JD-Core Version:    0.7.0.1
 */