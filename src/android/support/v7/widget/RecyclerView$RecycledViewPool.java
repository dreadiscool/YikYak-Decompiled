package android.support.v7.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

public class RecyclerView$RecycledViewPool
{
  private static final int DEFAULT_MAX_SCRAP = 5;
  private int mAttachCount = 0;
  private SparseIntArray mMaxScrap = new SparseIntArray();
  private SparseArray<ArrayList<RecyclerView.ViewHolder>> mScrap = new SparseArray();
  
  private ArrayList<RecyclerView.ViewHolder> getScrapHeapForType(int paramInt)
  {
    ArrayList localArrayList = (ArrayList)this.mScrap.get(paramInt);
    if (localArrayList == null)
    {
      localArrayList = new ArrayList();
      this.mScrap.put(paramInt, localArrayList);
      if (this.mMaxScrap.indexOfKey(paramInt) < 0) {
        this.mMaxScrap.put(paramInt, 5);
      }
    }
    return localArrayList;
  }
  
  void attach(RecyclerView.Adapter paramAdapter)
  {
    this.mAttachCount = (1 + this.mAttachCount);
  }
  
  public void clear()
  {
    this.mScrap.clear();
  }
  
  void detach()
  {
    this.mAttachCount = (-1 + this.mAttachCount);
  }
  
  public RecyclerView.ViewHolder getRecycledView(int paramInt)
  {
    ArrayList localArrayList = (ArrayList)this.mScrap.get(paramInt);
    RecyclerView.ViewHolder localViewHolder;
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      int i = -1 + localArrayList.size();
      localViewHolder = (RecyclerView.ViewHolder)localArrayList.get(i);
      localArrayList.remove(i);
    }
    for (;;)
    {
      return localViewHolder;
      localViewHolder = null;
    }
  }
  
  void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2, boolean paramBoolean)
  {
    if (paramAdapter1 != null) {
      detach();
    }
    if ((!paramBoolean) && (this.mAttachCount == 0)) {
      clear();
    }
    if (paramAdapter2 != null) {
      attach(paramAdapter2);
    }
  }
  
  public void putRecycledView(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = paramViewHolder.getItemViewType();
    ArrayList localArrayList = getScrapHeapForType(i);
    if (this.mMaxScrap.get(i) <= localArrayList.size()) {}
    for (;;)
    {
      return;
      paramViewHolder.resetInternal();
      localArrayList.add(paramViewHolder);
    }
  }
  
  public void setMaxRecycledViews(int paramInt1, int paramInt2)
  {
    this.mMaxScrap.put(paramInt1, paramInt2);
    ArrayList localArrayList = (ArrayList)this.mScrap.get(paramInt1);
    if (localArrayList != null) {
      while (localArrayList.size() > paramInt2) {
        localArrayList.remove(-1 + localArrayList.size());
      }
    }
  }
  
  int size()
  {
    int i = 0;
    int j = 0;
    while (i < this.mScrap.size())
    {
      ArrayList localArrayList = (ArrayList)this.mScrap.valueAt(i);
      if (localArrayList != null) {
        j += localArrayList.size();
      }
      i++;
    }
    return j;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.RecycledViewPool
 * JD-Core Version:    0.7.0.1
 */