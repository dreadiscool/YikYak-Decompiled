package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StaggeredGridLayoutManager$LazySpanLookup
{
  private static final int MIN_SIZE = 10;
  int[] mData;
  List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> mFullSpanItems;
  
  private int invalidateFullSpansAfter(int paramInt)
  {
    int k;
    if (this.mFullSpanItems == null)
    {
      k = -1;
      return k;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1 = getFullSpanItem(paramInt);
    if (localFullSpanItem1 != null) {
      this.mFullSpanItems.remove(localFullSpanItem1);
    }
    int i = this.mFullSpanItems.size();
    int j = 0;
    label48:
    if (j < i) {
      if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(j)).mPosition < paramInt) {}
    }
    for (;;)
    {
      if (j != -1)
      {
        StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(j);
        this.mFullSpanItems.remove(j);
        k = localFullSpanItem2.mPosition;
        break;
        j++;
        break label48;
      }
      k = -1;
      break;
      j = -1;
    }
  }
  
  private void offsetFullSpansForAddition(int paramInt1, int paramInt2)
  {
    if (this.mFullSpanItems == null) {
      return;
    }
    int i = -1 + this.mFullSpanItems.size();
    label21:
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    if (i >= 0)
    {
      localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i);
      if (localFullSpanItem.mPosition >= paramInt1) {
        break label55;
      }
    }
    for (;;)
    {
      i--;
      break label21;
      break;
      label55:
      localFullSpanItem.mPosition = (paramInt2 + localFullSpanItem.mPosition);
    }
  }
  
  private void offsetFullSpansForRemoval(int paramInt1, int paramInt2)
  {
    if (this.mFullSpanItems == null) {
      return;
    }
    int i = paramInt1 + paramInt2;
    int j = -1 + this.mFullSpanItems.size();
    label26:
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    if (j >= 0)
    {
      localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(j);
      if (localFullSpanItem.mPosition >= paramInt1) {
        break label62;
      }
    }
    for (;;)
    {
      j--;
      break label26;
      break;
      label62:
      if (localFullSpanItem.mPosition < i) {
        this.mFullSpanItems.remove(j);
      } else {
        localFullSpanItem.mPosition -= paramInt2;
      }
    }
  }
  
  public void addFullSpanItem(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem paramFullSpanItem)
  {
    if (this.mFullSpanItems == null) {
      this.mFullSpanItems = new ArrayList();
    }
    int i = this.mFullSpanItems.size();
    int j = 0;
    if (j < i)
    {
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(j);
      if (localFullSpanItem.mPosition == paramFullSpanItem.mPosition) {
        this.mFullSpanItems.remove(j);
      }
      if (localFullSpanItem.mPosition >= paramFullSpanItem.mPosition) {
        this.mFullSpanItems.add(j, paramFullSpanItem);
      }
    }
    for (;;)
    {
      return;
      j++;
      break;
      this.mFullSpanItems.add(paramFullSpanItem);
    }
  }
  
  void clear()
  {
    if (this.mData != null) {
      Arrays.fill(this.mData, -1);
    }
    this.mFullSpanItems = null;
  }
  
  void ensureSize(int paramInt)
  {
    if (this.mData == null)
    {
      this.mData = new int[1 + Math.max(paramInt, 10)];
      Arrays.fill(this.mData, -1);
    }
    for (;;)
    {
      return;
      if (paramInt >= this.mData.length)
      {
        int[] arrayOfInt = this.mData;
        this.mData = new int[sizeForPosition(paramInt)];
        System.arraycopy(arrayOfInt, 0, this.mData, 0, arrayOfInt.length);
        Arrays.fill(this.mData, arrayOfInt.length, this.mData.length, -1);
      }
    }
  }
  
  int forceInvalidateAfter(int paramInt)
  {
    if (this.mFullSpanItems != null) {
      for (int i = -1 + this.mFullSpanItems.size(); i >= 0; i--) {
        if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i)).mPosition >= paramInt) {
          this.mFullSpanItems.remove(i);
        }
      }
    }
    return invalidateAfter(paramInt);
  }
  
  public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem getFirstFullSpanItemInRange(int paramInt1, int paramInt2, int paramInt3)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    if (this.mFullSpanItems == null) {
      localFullSpanItem = null;
    }
    for (;;)
    {
      return localFullSpanItem;
      for (int i = 0;; i++)
      {
        if (i >= this.mFullSpanItems.size()) {
          break label89;
        }
        localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i);
        if (localFullSpanItem.mPosition >= paramInt2)
        {
          localFullSpanItem = null;
          break;
        }
        if ((localFullSpanItem.mPosition >= paramInt1) && ((paramInt3 == 0) || (localFullSpanItem.mGapDir == paramInt3))) {
          break;
        }
      }
      label89:
      localFullSpanItem = null;
    }
  }
  
  public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem getFullSpanItem(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    if (this.mFullSpanItems == null) {
      localFullSpanItem = null;
    }
    for (;;)
    {
      return localFullSpanItem;
      for (int i = -1 + this.mFullSpanItems.size();; i--)
      {
        if (i < 0) {
          break label56;
        }
        localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i);
        if (localFullSpanItem.mPosition == paramInt) {
          break;
        }
      }
      label56:
      localFullSpanItem = null;
    }
  }
  
  int getSpan(int paramInt)
  {
    if ((this.mData == null) || (paramInt >= this.mData.length)) {}
    for (int i = -1;; i = this.mData[paramInt]) {
      return i;
    }
  }
  
  int invalidateAfter(int paramInt)
  {
    int i = -1;
    if (this.mData == null) {}
    for (;;)
    {
      return i;
      if (paramInt < this.mData.length)
      {
        int j = invalidateFullSpansAfter(paramInt);
        if (j == i)
        {
          Arrays.fill(this.mData, paramInt, this.mData.length, i);
          i = this.mData.length;
        }
        else
        {
          Arrays.fill(this.mData, paramInt, j + 1, i);
          i = j + 1;
        }
      }
    }
  }
  
  void offsetForAddition(int paramInt1, int paramInt2)
  {
    if ((this.mData == null) || (paramInt1 >= this.mData.length)) {}
    for (;;)
    {
      return;
      ensureSize(paramInt1 + paramInt2);
      System.arraycopy(this.mData, paramInt1, this.mData, paramInt1 + paramInt2, this.mData.length - paramInt1 - paramInt2);
      Arrays.fill(this.mData, paramInt1, paramInt1 + paramInt2, -1);
      offsetFullSpansForAddition(paramInt1, paramInt2);
    }
  }
  
  void offsetForRemoval(int paramInt1, int paramInt2)
  {
    if ((this.mData == null) || (paramInt1 >= this.mData.length)) {}
    for (;;)
    {
      return;
      ensureSize(paramInt1 + paramInt2);
      System.arraycopy(this.mData, paramInt1 + paramInt2, this.mData, paramInt1, this.mData.length - paramInt1 - paramInt2);
      Arrays.fill(this.mData, this.mData.length - paramInt2, this.mData.length, -1);
      offsetFullSpansForRemoval(paramInt1, paramInt2);
    }
  }
  
  void setSpan(int paramInt, StaggeredGridLayoutManager.Span paramSpan)
  {
    ensureSize(paramInt);
    this.mData[paramInt] = paramSpan.mIndex;
  }
  
  int sizeForPosition(int paramInt)
  {
    int i = this.mData.length;
    while (i <= paramInt) {
      i *= 2;
    }
    return i;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup
 * JD-Core Version:    0.7.0.1
 */