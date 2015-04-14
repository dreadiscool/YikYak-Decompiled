package android.support.v7.internal.widget;

import android.util.SparseArray;
import android.view.View;

class AbsSpinnerCompat$RecycleBin
{
  private final SparseArray<View> mScrapHeap = new SparseArray();
  
  AbsSpinnerCompat$RecycleBin(AbsSpinnerCompat paramAbsSpinnerCompat) {}
  
  void clear()
  {
    SparseArray localSparseArray = this.mScrapHeap;
    int i = localSparseArray.size();
    for (int j = 0; j < i; j++)
    {
      View localView = (View)localSparseArray.valueAt(j);
      if (localView != null) {
        AbsSpinnerCompat.access$000(this.this$0, localView, true);
      }
    }
    localSparseArray.clear();
  }
  
  View get(int paramInt)
  {
    View localView = (View)this.mScrapHeap.get(paramInt);
    if (localView != null) {
      this.mScrapHeap.delete(paramInt);
    }
    return localView;
  }
  
  public void put(int paramInt, View paramView)
  {
    this.mScrapHeap.put(paramInt, paramView);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.AbsSpinnerCompat.RecycleBin
 * JD-Core Version:    0.7.0.1
 */