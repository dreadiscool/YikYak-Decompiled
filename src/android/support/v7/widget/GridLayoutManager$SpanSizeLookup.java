package android.support.v7.widget;

import android.util.SparseIntArray;

public abstract class GridLayoutManager$SpanSizeLookup
{
  private boolean mCacheSpanIndices = false;
  final SparseIntArray mSpanIndexCache = new SparseIntArray();
  
  int findReferenceIndexFromCache(int paramInt)
  {
    int i = 0;
    int j = -1 + this.mSpanIndexCache.size();
    while (i <= j)
    {
      int n = i + j >>> 1;
      if (this.mSpanIndexCache.keyAt(n) < paramInt) {
        i = n + 1;
      } else {
        j = n - 1;
      }
    }
    int k = i - 1;
    if ((k >= 0) && (k < this.mSpanIndexCache.size())) {}
    for (int m = this.mSpanIndexCache.keyAt(k);; m = -1) {
      return m;
    }
  }
  
  int getCachedSpanIndex(int paramInt1, int paramInt2)
  {
    int i;
    if (!this.mCacheSpanIndices) {
      i = getSpanIndex(paramInt1, paramInt2);
    }
    for (;;)
    {
      return i;
      i = this.mSpanIndexCache.get(paramInt1, -1);
      if (i == -1)
      {
        i = getSpanIndex(paramInt1, paramInt2);
        this.mSpanIndexCache.put(paramInt1, i);
      }
    }
  }
  
  public int getSpanGroupIndex(int paramInt1, int paramInt2)
  {
    int i = getSpanSize(paramInt1);
    int j = 0;
    int k = 0;
    int m = 0;
    int n;
    int i1;
    if (j < paramInt1)
    {
      n = getSpanSize(j);
      i1 = m + n;
      if (i1 == paramInt2)
      {
        k++;
        n = 0;
      }
    }
    for (;;)
    {
      j++;
      m = n;
      break;
      if (i1 > paramInt2)
      {
        k++;
        continue;
        if (m + i > paramInt2) {
          k++;
        }
        return k;
      }
      else
      {
        n = i1;
      }
    }
  }
  
  public int getSpanIndex(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = getSpanSize(paramInt1);
    if (j == paramInt2) {
      return i;
    }
    int m;
    int k;
    if ((this.mCacheSpanIndices) && (this.mSpanIndexCache.size() > 0))
    {
      int i3 = findReferenceIndexFromCache(paramInt1);
      if (i3 >= 0)
      {
        m = this.mSpanIndexCache.get(i3) + getSpanSize(i3);
        k = i3 + 1;
      }
    }
    for (;;)
    {
      int n = k;
      if (n < paramInt1)
      {
        int i1 = getSpanSize(n);
        int i2 = m + i1;
        if (i2 == paramInt2) {
          i1 = 0;
        }
        for (;;)
        {
          n++;
          m = i1;
          break;
          if (i2 <= paramInt2) {
            i1 = i2;
          }
        }
      }
      if (m + j > paramInt2) {
        break;
      }
      i = m;
      break;
      k = 0;
      m = 0;
    }
  }
  
  public abstract int getSpanSize(int paramInt);
  
  public void invalidateSpanIndexCache()
  {
    this.mSpanIndexCache.clear();
  }
  
  public boolean isSpanIndexCacheEnabled()
  {
    return this.mCacheSpanIndices;
  }
  
  public void setSpanIndexCacheEnabled(boolean paramBoolean)
  {
    this.mCacheSpanIndices = paramBoolean;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.GridLayoutManager.SpanSizeLookup
 * JD-Core Version:    0.7.0.1
 */