package android.support.v7.widget;

import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class AdapterHelper
  implements OpReorderer.Callback
{
  private static final boolean DEBUG = false;
  static final int POSITION_TYPE_INVISIBLE = 0;
  static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
  private static final String TAG = "AHT";
  final AdapterHelper.Callback mCallback;
  final boolean mDisableRecycler;
  Runnable mOnItemProcessedCallback;
  final OpReorderer mOpReorderer;
  final ArrayList<AdapterHelper.UpdateOp> mPendingUpdates = new ArrayList();
  final ArrayList<AdapterHelper.UpdateOp> mPostponedList = new ArrayList();
  private Pools.Pool<AdapterHelper.UpdateOp> mUpdateOpPool = new Pools.SimplePool(30);
  
  AdapterHelper(AdapterHelper.Callback paramCallback)
  {
    this(paramCallback, false);
  }
  
  AdapterHelper(AdapterHelper.Callback paramCallback, boolean paramBoolean)
  {
    this.mCallback = paramCallback;
    this.mDisableRecycler = paramBoolean;
    this.mOpReorderer = new OpReorderer(this);
  }
  
  private void applyAdd(AdapterHelper.UpdateOp paramUpdateOp)
  {
    postponeAndUpdateViewHolders(paramUpdateOp);
  }
  
  private void applyMove(AdapterHelper.UpdateOp paramUpdateOp)
  {
    postponeAndUpdateViewHolders(paramUpdateOp);
  }
  
  private void applyRemove(AdapterHelper.UpdateOp paramUpdateOp)
  {
    int i = paramUpdateOp.positionStart;
    int j = paramUpdateOp.positionStart + paramUpdateOp.itemCount;
    int k = -1;
    int m = paramUpdateOp.positionStart;
    int n = 0;
    if (m < j) {
      if ((this.mCallback.findViewHolder(m) != null) || (canFindInPreLayout(m)))
      {
        if (k != 0) {
          break label220;
        }
        dispatchAndUpdateViewHolders(obtainUpdateOp(1, i, n));
      }
    }
    label214:
    label220:
    for (int i1 = 1;; i1 = 0)
    {
      k = 1;
      int i6;
      int i4;
      int i5;
      if (i1 != 0)
      {
        i6 = m - n;
        i4 = j - n;
        i5 = 1;
        label101:
        int i7 = i6 + 1;
        n = i5;
        j = i4;
        m = i7;
        break;
        if (k != 1) {
          break label214;
        }
        postponeAndUpdateViewHolders(obtainUpdateOp(1, i, n));
      }
      for (i1 = 1;; i1 = 0)
      {
        k = 0;
        break;
        int i2 = n + 1;
        int i3 = m;
        i4 = j;
        i5 = i2;
        i6 = i3;
        break label101;
        if (n != paramUpdateOp.itemCount)
        {
          recycleUpdateOp(paramUpdateOp);
          paramUpdateOp = obtainUpdateOp(1, i, n);
        }
        if (k == 0) {
          dispatchAndUpdateViewHolders(paramUpdateOp);
        }
        for (;;)
        {
          return;
          postponeAndUpdateViewHolders(paramUpdateOp);
        }
      }
    }
  }
  
  private void applyUpdate(AdapterHelper.UpdateOp paramUpdateOp)
  {
    int i = paramUpdateOp.positionStart;
    int j = paramUpdateOp.positionStart + paramUpdateOp.itemCount;
    int k = paramUpdateOp.positionStart;
    int m = -1;
    int n = 0;
    if (k < j)
    {
      int i1;
      int i2;
      if ((this.mCallback.findViewHolder(k) != null) || (canFindInPreLayout(k)))
      {
        if (m == 0)
        {
          dispatchAndUpdateViewHolders(obtainUpdateOp(2, i, n));
          n = 0;
          i = k;
        }
        i1 = i;
        i2 = n;
      }
      for (int i3 = 1;; i3 = 0)
      {
        int i4 = i2 + 1;
        k++;
        int i5 = i3;
        n = i4;
        i = i1;
        m = i5;
        break;
        if (m == 1)
        {
          postponeAndUpdateViewHolders(obtainUpdateOp(2, i, n));
          n = 0;
          i = k;
        }
        i1 = i;
        i2 = n;
      }
    }
    if (n != paramUpdateOp.itemCount)
    {
      recycleUpdateOp(paramUpdateOp);
      paramUpdateOp = obtainUpdateOp(2, i, n);
    }
    if (m == 0) {
      dispatchAndUpdateViewHolders(paramUpdateOp);
    }
    for (;;)
    {
      return;
      postponeAndUpdateViewHolders(paramUpdateOp);
    }
  }
  
  private boolean canFindInPreLayout(int paramInt)
  {
    int i = this.mPostponedList.size();
    int j = 0;
    AdapterHelper.UpdateOp localUpdateOp;
    boolean bool;
    if (j < i)
    {
      localUpdateOp = (AdapterHelper.UpdateOp)this.mPostponedList.get(j);
      if (localUpdateOp.cmd == 3)
      {
        if (findPositionOffset(localUpdateOp.itemCount, j + 1) != paramInt) {
          break label119;
        }
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      if (localUpdateOp.cmd == 0)
      {
        int k = localUpdateOp.positionStart + localUpdateOp.itemCount;
        for (int m = localUpdateOp.positionStart;; m++)
        {
          if (m >= k) {
            break label119;
          }
          if (findPositionOffset(m, j + 1) == paramInt)
          {
            bool = true;
            break;
          }
        }
      }
      label119:
      j++;
      break;
      bool = false;
    }
  }
  
  private void dispatchAndUpdateViewHolders(AdapterHelper.UpdateOp paramUpdateOp)
  {
    if ((paramUpdateOp.cmd == 0) || (paramUpdateOp.cmd == 3)) {
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }
    int i = updatePositionWithPostponed(paramUpdateOp.positionStart, paramUpdateOp.cmd);
    int j = paramUpdateOp.positionStart;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    label110:
    int i3;
    int i4;
    switch (paramUpdateOp.cmd)
    {
    default: 
      throw new IllegalArgumentException("op should be remove or update." + paramUpdateOp);
    case 2: 
      k = 1;
      m = 1;
      n = i;
      i1 = j;
      i2 = 1;
      if (i2 >= paramUpdateOp.itemCount) {
        break label280;
      }
      i3 = updatePositionWithPostponed(paramUpdateOp.positionStart + k * i2, paramUpdateOp.cmd);
      switch (paramUpdateOp.cmd)
      {
      default: 
        i4 = 0;
        label167:
        if (i4 != 0) {
          m++;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      i2++;
      break label110;
      k = 0;
      break;
      if (i3 == n + 1)
      {
        i4 = 1;
        break label167;
      }
      i4 = 0;
      break label167;
      if (i3 == n)
      {
        i4 = 1;
        break label167;
      }
      i4 = 0;
      break label167;
      AdapterHelper.UpdateOp localUpdateOp2 = obtainUpdateOp(paramUpdateOp.cmd, n, m);
      dispatchFirstPassAndUpdateViewHolders(localUpdateOp2, i1);
      recycleUpdateOp(localUpdateOp2);
      if (paramUpdateOp.cmd == 2) {
        i1 += m;
      }
      m = 1;
      n = i3;
    }
    label280:
    recycleUpdateOp(paramUpdateOp);
    if (m > 0)
    {
      AdapterHelper.UpdateOp localUpdateOp1 = obtainUpdateOp(paramUpdateOp.cmd, n, m);
      dispatchFirstPassAndUpdateViewHolders(localUpdateOp1, i1);
      recycleUpdateOp(localUpdateOp1);
    }
  }
  
  private void postponeAndUpdateViewHolders(AdapterHelper.UpdateOp paramUpdateOp)
  {
    this.mPostponedList.add(paramUpdateOp);
    switch (paramUpdateOp.cmd)
    {
    default: 
      throw new IllegalArgumentException("Unknown update op type for " + paramUpdateOp);
    case 0: 
      this.mCallback.offsetPositionsForAdd(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
    }
    for (;;)
    {
      return;
      this.mCallback.offsetPositionsForMove(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      continue;
      this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      continue;
      this.mCallback.markViewHoldersUpdated(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
    }
  }
  
  private int updatePositionWithPostponed(int paramInt1, int paramInt2)
  {
    int i = -1 + this.mPostponedList.size();
    int j = paramInt1;
    if (i >= 0)
    {
      AdapterHelper.UpdateOp localUpdateOp2 = (AdapterHelper.UpdateOp)this.mPostponedList.get(i);
      int m;
      int n;
      label67:
      label107:
      int i1;
      if (localUpdateOp2.cmd == 3) {
        if (localUpdateOp2.positionStart < localUpdateOp2.itemCount)
        {
          m = localUpdateOp2.positionStart;
          n = localUpdateOp2.itemCount;
          if ((j < m) || (j > n)) {
            break label207;
          }
          if (m != localUpdateOp2.positionStart) {
            break label161;
          }
          if (paramInt2 != 0) {
            break label140;
          }
          localUpdateOp2.itemCount = (1 + localUpdateOp2.itemCount);
          i1 = j + 1;
          label113:
          j = i1;
        }
      }
      for (;;)
      {
        i--;
        break;
        m = localUpdateOp2.itemCount;
        n = localUpdateOp2.positionStart;
        break label67;
        label140:
        if (paramInt2 != 1) {
          break label107;
        }
        localUpdateOp2.itemCount = (-1 + localUpdateOp2.itemCount);
        break label107;
        label161:
        if (paramInt2 == 0) {
          localUpdateOp2.positionStart = (1 + localUpdateOp2.positionStart);
        }
        for (;;)
        {
          i1 = j - 1;
          break;
          if (paramInt2 == 1) {
            localUpdateOp2.positionStart = (-1 + localUpdateOp2.positionStart);
          }
        }
        label207:
        if (j < localUpdateOp2.positionStart)
        {
          if (paramInt2 == 0)
          {
            localUpdateOp2.positionStart = (1 + localUpdateOp2.positionStart);
            localUpdateOp2.itemCount = (1 + localUpdateOp2.itemCount);
            i1 = j;
            break label113;
          }
          if (paramInt2 == 1)
          {
            localUpdateOp2.positionStart = (-1 + localUpdateOp2.positionStart);
            localUpdateOp2.itemCount = (-1 + localUpdateOp2.itemCount);
          }
        }
        i1 = j;
        break label113;
        if (localUpdateOp2.positionStart <= j)
        {
          if (localUpdateOp2.cmd == 0) {
            j -= localUpdateOp2.itemCount;
          } else if (localUpdateOp2.cmd == 1) {
            j += localUpdateOp2.itemCount;
          }
        }
        else if (paramInt2 == 0) {
          localUpdateOp2.positionStart = (1 + localUpdateOp2.positionStart);
        } else if (paramInt2 == 1) {
          localUpdateOp2.positionStart = (-1 + localUpdateOp2.positionStart);
        }
      }
    }
    int k = -1 + this.mPostponedList.size();
    if (k >= 0)
    {
      AdapterHelper.UpdateOp localUpdateOp1 = (AdapterHelper.UpdateOp)this.mPostponedList.get(k);
      if (localUpdateOp1.cmd == 3) {
        if ((localUpdateOp1.itemCount == localUpdateOp1.positionStart) || (localUpdateOp1.itemCount < 0))
        {
          this.mPostponedList.remove(k);
          recycleUpdateOp(localUpdateOp1);
        }
      }
      for (;;)
      {
        k--;
        break;
        if (localUpdateOp1.itemCount <= 0)
        {
          this.mPostponedList.remove(k);
          recycleUpdateOp(localUpdateOp1);
        }
      }
    }
    return j;
  }
  
  AdapterHelper addUpdateOp(AdapterHelper.UpdateOp... paramVarArgs)
  {
    Collections.addAll(this.mPendingUpdates, paramVarArgs);
    return this;
  }
  
  void consumePostponedUpdates()
  {
    int i = this.mPostponedList.size();
    for (int j = 0; j < i; j++) {
      this.mCallback.onDispatchSecondPass((AdapterHelper.UpdateOp)this.mPostponedList.get(j));
    }
    recycleUpdateOpsAndClearList(this.mPostponedList);
  }
  
  void consumeUpdatesInOnePass()
  {
    consumePostponedUpdates();
    int i = this.mPendingUpdates.size();
    int j = 0;
    if (j < i)
    {
      AdapterHelper.UpdateOp localUpdateOp = (AdapterHelper.UpdateOp)this.mPendingUpdates.get(j);
      switch (localUpdateOp.cmd)
      {
      }
      for (;;)
      {
        if (this.mOnItemProcessedCallback != null) {
          this.mOnItemProcessedCallback.run();
        }
        j++;
        break;
        this.mCallback.onDispatchSecondPass(localUpdateOp);
        this.mCallback.offsetPositionsForAdd(localUpdateOp.positionStart, localUpdateOp.itemCount);
        continue;
        this.mCallback.onDispatchSecondPass(localUpdateOp);
        this.mCallback.offsetPositionsForRemovingInvisible(localUpdateOp.positionStart, localUpdateOp.itemCount);
        continue;
        this.mCallback.onDispatchSecondPass(localUpdateOp);
        this.mCallback.markViewHoldersUpdated(localUpdateOp.positionStart, localUpdateOp.itemCount);
        continue;
        this.mCallback.onDispatchSecondPass(localUpdateOp);
        this.mCallback.offsetPositionsForMove(localUpdateOp.positionStart, localUpdateOp.itemCount);
      }
    }
    recycleUpdateOpsAndClearList(this.mPendingUpdates);
  }
  
  void dispatchFirstPassAndUpdateViewHolders(AdapterHelper.UpdateOp paramUpdateOp, int paramInt)
  {
    this.mCallback.onDispatchFirstPass(paramUpdateOp);
    switch (paramUpdateOp.cmd)
    {
    default: 
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 1: 
      this.mCallback.offsetPositionsForRemovingInvisible(paramInt, paramUpdateOp.itemCount);
    }
    for (;;)
    {
      return;
      this.mCallback.markViewHoldersUpdated(paramInt, paramUpdateOp.itemCount);
    }
  }
  
  int findPositionOffset(int paramInt)
  {
    return findPositionOffset(paramInt, 0);
  }
  
  int findPositionOffset(int paramInt1, int paramInt2)
  {
    int i = this.mPostponedList.size();
    int j = paramInt1;
    AdapterHelper.UpdateOp localUpdateOp;
    if (paramInt2 < i)
    {
      localUpdateOp = (AdapterHelper.UpdateOp)this.mPostponedList.get(paramInt2);
      if (localUpdateOp.cmd == 3) {
        if (localUpdateOp.positionStart == j) {
          j = localUpdateOp.itemCount;
        }
      }
    }
    for (;;)
    {
      paramInt2++;
      break;
      if (localUpdateOp.positionStart < j) {
        j--;
      }
      if (localUpdateOp.itemCount <= j)
      {
        j++;
        continue;
        if (localUpdateOp.positionStart <= j) {
          if (localUpdateOp.cmd == 1)
          {
            if (j < localUpdateOp.positionStart + localUpdateOp.itemCount)
            {
              j = -1;
              return j;
            }
            j -= localUpdateOp.itemCount;
          }
          else if (localUpdateOp.cmd == 0)
          {
            j += localUpdateOp.itemCount;
          }
        }
      }
    }
  }
  
  boolean hasPendingUpdates()
  {
    if (this.mPendingUpdates.size() > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public AdapterHelper.UpdateOp obtainUpdateOp(int paramInt1, int paramInt2, int paramInt3)
  {
    AdapterHelper.UpdateOp localUpdateOp = (AdapterHelper.UpdateOp)this.mUpdateOpPool.acquire();
    if (localUpdateOp == null) {
      localUpdateOp = new AdapterHelper.UpdateOp(paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      return localUpdateOp;
      localUpdateOp.cmd = paramInt1;
      localUpdateOp.positionStart = paramInt2;
      localUpdateOp.itemCount = paramInt3;
    }
  }
  
  boolean onItemRangeChanged(int paramInt1, int paramInt2)
  {
    int i = 1;
    this.mPendingUpdates.add(obtainUpdateOp(2, paramInt1, paramInt2));
    if (this.mPendingUpdates.size() == i) {}
    for (;;)
    {
      return i;
      int j = 0;
    }
  }
  
  boolean onItemRangeInserted(int paramInt1, int paramInt2)
  {
    int i = 1;
    this.mPendingUpdates.add(obtainUpdateOp(0, paramInt1, paramInt2));
    if (this.mPendingUpdates.size() == i) {}
    for (;;)
    {
      return i;
      int j = 0;
    }
  }
  
  boolean onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    int i = 1;
    if (paramInt1 == paramInt2) {
      return bool;
    }
    if (paramInt3 != i) {
      throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }
    this.mPendingUpdates.add(obtainUpdateOp(3, paramInt1, paramInt2));
    if (this.mPendingUpdates.size() == i) {}
    for (;;)
    {
      bool = i;
      break;
      i = 0;
    }
  }
  
  boolean onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    int i = 1;
    this.mPendingUpdates.add(obtainUpdateOp(i, paramInt1, paramInt2));
    if (this.mPendingUpdates.size() == i) {}
    for (;;)
    {
      return i;
      int j = 0;
    }
  }
  
  void preProcess()
  {
    this.mOpReorderer.reorderOps(this.mPendingUpdates);
    int i = this.mPendingUpdates.size();
    int j = 0;
    if (j < i)
    {
      AdapterHelper.UpdateOp localUpdateOp = (AdapterHelper.UpdateOp)this.mPendingUpdates.get(j);
      switch (localUpdateOp.cmd)
      {
      }
      for (;;)
      {
        if (this.mOnItemProcessedCallback != null) {
          this.mOnItemProcessedCallback.run();
        }
        j++;
        break;
        applyAdd(localUpdateOp);
        continue;
        applyRemove(localUpdateOp);
        continue;
        applyUpdate(localUpdateOp);
        continue;
        applyMove(localUpdateOp);
      }
    }
    this.mPendingUpdates.clear();
  }
  
  public void recycleUpdateOp(AdapterHelper.UpdateOp paramUpdateOp)
  {
    if (!this.mDisableRecycler) {
      this.mUpdateOpPool.release(paramUpdateOp);
    }
  }
  
  void recycleUpdateOpsAndClearList(List<AdapterHelper.UpdateOp> paramList)
  {
    int i = paramList.size();
    for (int j = 0; j < i; j++) {
      recycleUpdateOp((AdapterHelper.UpdateOp)paramList.get(j));
    }
    paramList.clear();
  }
  
  void reset()
  {
    recycleUpdateOpsAndClearList(this.mPendingUpdates);
    recycleUpdateOpsAndClearList(this.mPostponedList);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AdapterHelper
 * JD-Core Version:    0.7.0.1
 */