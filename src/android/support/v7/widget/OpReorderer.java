package android.support.v7.widget;

import java.util.List;

class OpReorderer
{
  final OpReorderer.Callback mCallback;
  
  public OpReorderer(OpReorderer.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> paramList)
  {
    int i = 0;
    int j = -1 + paramList.size();
    int k;
    if (j >= 0) {
      if (((AdapterHelper.UpdateOp)paramList.get(j)).cmd == 3)
      {
        if (i == 0) {
          break label62;
        }
        k = j;
        label40:
        return k;
      }
    }
    label62:
    for (int m = 1;; m = i)
    {
      j--;
      i = m;
      break;
      k = -1;
      break label40;
    }
  }
  
  private void swapMoveAdd(List<AdapterHelper.UpdateOp> paramList, int paramInt1, AdapterHelper.UpdateOp paramUpdateOp1, int paramInt2, AdapterHelper.UpdateOp paramUpdateOp2)
  {
    int i = 0;
    if (paramUpdateOp1.itemCount < paramUpdateOp2.positionStart) {
      i = -1;
    }
    if (paramUpdateOp1.positionStart < paramUpdateOp2.positionStart) {
      i++;
    }
    if (paramUpdateOp2.positionStart <= paramUpdateOp1.positionStart) {
      paramUpdateOp1.positionStart += paramUpdateOp2.itemCount;
    }
    if (paramUpdateOp2.positionStart <= paramUpdateOp1.itemCount) {
      paramUpdateOp1.itemCount += paramUpdateOp2.itemCount;
    }
    paramUpdateOp2.positionStart = (i + paramUpdateOp2.positionStart);
    paramList.set(paramInt1, paramUpdateOp2);
    paramList.set(paramInt2, paramUpdateOp1);
  }
  
  private void swapMoveOp(List<AdapterHelper.UpdateOp> paramList, int paramInt1, int paramInt2)
  {
    AdapterHelper.UpdateOp localUpdateOp1 = (AdapterHelper.UpdateOp)paramList.get(paramInt1);
    AdapterHelper.UpdateOp localUpdateOp2 = (AdapterHelper.UpdateOp)paramList.get(paramInt2);
    switch (localUpdateOp2.cmd)
    {
    }
    for (;;)
    {
      return;
      swapMoveRemove(paramList, paramInt1, localUpdateOp1, paramInt2, localUpdateOp2);
      continue;
      swapMoveAdd(paramList, paramInt1, localUpdateOp1, paramInt2, localUpdateOp2);
      continue;
      swapMoveUpdate(paramList, paramInt1, localUpdateOp1, paramInt2, localUpdateOp2);
    }
  }
  
  void reorderOps(List<AdapterHelper.UpdateOp> paramList)
  {
    for (;;)
    {
      int i = getLastMoveOutOfOrder(paramList);
      if (i == -1) {
        break;
      }
      swapMoveOp(paramList, i, i + 1);
    }
  }
  
  void swapMoveRemove(List<AdapterHelper.UpdateOp> paramList, int paramInt1, AdapterHelper.UpdateOp paramUpdateOp1, int paramInt2, AdapterHelper.UpdateOp paramUpdateOp2)
  {
    int i = 0;
    int j;
    if (paramUpdateOp1.positionStart < paramUpdateOp1.itemCount)
    {
      if ((paramUpdateOp2.positionStart != paramUpdateOp1.positionStart) || (paramUpdateOp2.itemCount != paramUpdateOp1.itemCount - paramUpdateOp1.positionStart)) {
        break label620;
      }
      j = 1;
    }
    for (;;)
    {
      label71:
      AdapterHelper.UpdateOp localUpdateOp;
      if (paramUpdateOp1.itemCount < paramUpdateOp2.positionStart)
      {
        paramUpdateOp2.positionStart = (-1 + paramUpdateOp2.positionStart);
        if (paramUpdateOp1.positionStart > paramUpdateOp2.positionStart) {
          break label245;
        }
        paramUpdateOp2.positionStart = (1 + paramUpdateOp2.positionStart);
        localUpdateOp = null;
      }
      for (;;)
      {
        label98:
        if (j != 0)
        {
          paramList.set(paramInt1, paramUpdateOp2);
          paramList.remove(paramInt2);
          this.mCallback.recycleUpdateOp(paramUpdateOp1);
        }
        label433:
        label593:
        label603:
        for (;;)
        {
          return;
          if ((paramUpdateOp2.positionStart != 1 + paramUpdateOp1.itemCount) || (paramUpdateOp2.itemCount != paramUpdateOp1.positionStart - paramUpdateOp1.itemCount)) {
            break label611;
          }
          i = 1;
          j = 1;
          break;
          if (paramUpdateOp1.itemCount >= paramUpdateOp2.positionStart + paramUpdateOp2.itemCount) {
            break label71;
          }
          paramUpdateOp2.itemCount = (-1 + paramUpdateOp2.itemCount);
          paramUpdateOp1.cmd = 1;
          paramUpdateOp1.itemCount = 1;
          if (paramUpdateOp2.itemCount == 0)
          {
            paramList.remove(paramInt2);
            this.mCallback.recycleUpdateOp(paramUpdateOp2);
            continue;
            label245:
            if (paramUpdateOp1.positionStart >= paramUpdateOp2.positionStart + paramUpdateOp2.itemCount) {
              break label605;
            }
            int k = paramUpdateOp2.positionStart + paramUpdateOp2.itemCount - paramUpdateOp1.positionStart;
            localUpdateOp = this.mCallback.obtainUpdateOp(1, 1 + paramUpdateOp1.positionStart, k);
            paramUpdateOp2.itemCount = (paramUpdateOp1.positionStart - paramUpdateOp2.positionStart);
            break label98;
            if (i != 0)
            {
              if (localUpdateOp != null)
              {
                if (paramUpdateOp1.positionStart > localUpdateOp.positionStart) {
                  paramUpdateOp1.positionStart -= localUpdateOp.itemCount;
                }
                if (paramUpdateOp1.itemCount > localUpdateOp.positionStart) {
                  paramUpdateOp1.itemCount -= localUpdateOp.itemCount;
                }
              }
              if (paramUpdateOp1.positionStart > paramUpdateOp2.positionStart) {
                paramUpdateOp1.positionStart -= paramUpdateOp2.itemCount;
              }
              if (paramUpdateOp1.itemCount > paramUpdateOp2.positionStart) {
                paramUpdateOp1.itemCount -= paramUpdateOp2.itemCount;
              }
              paramList.set(paramInt1, paramUpdateOp2);
              if (paramUpdateOp1.positionStart == paramUpdateOp1.itemCount) {
                break label593;
              }
              paramList.set(paramInt2, paramUpdateOp1);
            }
            for (;;)
            {
              if (localUpdateOp == null) {
                break label603;
              }
              paramList.add(paramInt1, localUpdateOp);
              break;
              if (localUpdateOp != null)
              {
                if (paramUpdateOp1.positionStart >= localUpdateOp.positionStart) {
                  paramUpdateOp1.positionStart -= localUpdateOp.itemCount;
                }
                if (paramUpdateOp1.itemCount >= localUpdateOp.positionStart) {
                  paramUpdateOp1.itemCount -= localUpdateOp.itemCount;
                }
              }
              if (paramUpdateOp1.positionStart >= paramUpdateOp2.positionStart) {
                paramUpdateOp1.positionStart -= paramUpdateOp2.itemCount;
              }
              if (paramUpdateOp1.itemCount < paramUpdateOp2.positionStart) {
                break label433;
              }
              paramUpdateOp1.itemCount -= paramUpdateOp2.itemCount;
              break label433;
              paramList.remove(paramInt2);
            }
          }
        }
        label605:
        localUpdateOp = null;
      }
      label611:
      j = 0;
      i = 1;
      continue;
      label620:
      j = 0;
    }
  }
  
  void swapMoveUpdate(List<AdapterHelper.UpdateOp> paramList, int paramInt1, AdapterHelper.UpdateOp paramUpdateOp1, int paramInt2, AdapterHelper.UpdateOp paramUpdateOp2)
  {
    Object localObject1 = null;
    Object localObject2;
    if (paramUpdateOp1.itemCount < paramUpdateOp2.positionStart)
    {
      paramUpdateOp2.positionStart = (-1 + paramUpdateOp2.positionStart);
      localObject2 = null;
    }
    for (;;)
    {
      if (paramUpdateOp1.positionStart <= paramUpdateOp2.positionStart)
      {
        paramUpdateOp2.positionStart = (1 + paramUpdateOp2.positionStart);
        label55:
        paramList.set(paramInt2, paramUpdateOp1);
        if (paramUpdateOp2.itemCount <= 0) {
          break label235;
        }
        paramList.set(paramInt1, paramUpdateOp2);
      }
      for (;;)
      {
        if (localObject2 != null) {
          paramList.add(paramInt1, localObject2);
        }
        if (localObject1 != null) {
          paramList.add(paramInt1, localObject1);
        }
        return;
        if (paramUpdateOp1.itemCount >= paramUpdateOp2.positionStart + paramUpdateOp2.itemCount) {
          break label257;
        }
        paramUpdateOp2.itemCount = (-1 + paramUpdateOp2.itemCount);
        localObject2 = this.mCallback.obtainUpdateOp(2, paramUpdateOp1.positionStart, 1);
        break;
        if (paramUpdateOp1.positionStart >= paramUpdateOp2.positionStart + paramUpdateOp2.itemCount) {
          break label55;
        }
        int i = paramUpdateOp2.positionStart + paramUpdateOp2.itemCount - paramUpdateOp1.positionStart;
        localObject1 = this.mCallback.obtainUpdateOp(2, 1 + paramUpdateOp1.positionStart, i);
        paramUpdateOp2.itemCount -= i;
        break label55;
        label235:
        paramList.remove(paramInt1);
        this.mCallback.recycleUpdateOp(paramUpdateOp2);
      }
      label257:
      localObject2 = null;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.OpReorderer
 * JD-Core Version:    0.7.0.1
 */