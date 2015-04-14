package android.support.v7.widget;

import android.database.Observable;
import java.util.ArrayList;

class RecyclerView$AdapterDataObservable
  extends Observable<RecyclerView.AdapterDataObserver>
{
  public boolean hasObservers()
  {
    if (!this.mObservers.isEmpty()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void notifyChanged()
  {
    for (int i = -1 + this.mObservers.size(); i >= 0; i--) {
      ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onChanged();
    }
  }
  
  public void notifyItemMoved(int paramInt1, int paramInt2)
  {
    for (int i = -1 + this.mObservers.size(); i >= 0; i--) {
      ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeMoved(paramInt1, paramInt2, 1);
    }
  }
  
  public void notifyItemRangeChanged(int paramInt1, int paramInt2)
  {
    for (int i = -1 + this.mObservers.size(); i >= 0; i--) {
      ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeChanged(paramInt1, paramInt2);
    }
  }
  
  public void notifyItemRangeInserted(int paramInt1, int paramInt2)
  {
    for (int i = -1 + this.mObservers.size(); i >= 0; i--) {
      ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeInserted(paramInt1, paramInt2);
    }
  }
  
  public void notifyItemRangeRemoved(int paramInt1, int paramInt2)
  {
    for (int i = -1 + this.mObservers.size(); i >= 0; i--) {
      ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeRemoved(paramInt1, paramInt2);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.AdapterDataObservable
 * JD-Core Version:    0.7.0.1
 */