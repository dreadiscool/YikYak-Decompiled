package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator
  extends RecyclerView.ItemAnimator
{
  private static final boolean DEBUG;
  private ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList();
  private ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mChangeAnimations = new ArrayList();
  private ArrayList<ArrayList<DefaultItemAnimator.ChangeInfo>> mChangesList = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList();
  private ArrayList<ArrayList<DefaultItemAnimator.MoveInfo>> mMovesList = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList();
  private ArrayList<DefaultItemAnimator.ChangeInfo> mPendingChanges = new ArrayList();
  private ArrayList<DefaultItemAnimator.MoveInfo> mPendingMoves = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList();
  
  private void animateAddImpl(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    this.mAddAnimations.add(paramViewHolder);
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(localView);
    localViewPropertyAnimatorCompat.alpha(1.0F).setDuration(getAddDuration()).setListener(new DefaultItemAnimator.5(this, paramViewHolder, localViewPropertyAnimatorCompat)).start();
  }
  
  private void animateChangeImpl(DefaultItemAnimator.ChangeInfo paramChangeInfo)
  {
    View localView1 = null;
    RecyclerView.ViewHolder localViewHolder1 = paramChangeInfo.oldHolder;
    if (localViewHolder1 == null) {}
    for (View localView2 = null;; localView2 = localViewHolder1.itemView)
    {
      RecyclerView.ViewHolder localViewHolder2 = paramChangeInfo.newHolder;
      if (localViewHolder2 != null) {
        localView1 = localViewHolder2.itemView;
      }
      if (localView2 != null)
      {
        this.mChangeAnimations.add(paramChangeInfo.oldHolder);
        ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2 = ViewCompat.animate(localView2).setDuration(getChangeDuration());
        localViewPropertyAnimatorCompat2.translationX(paramChangeInfo.toX - paramChangeInfo.fromX);
        localViewPropertyAnimatorCompat2.translationY(paramChangeInfo.toY - paramChangeInfo.fromY);
        localViewPropertyAnimatorCompat2.alpha(0.0F).setListener(new DefaultItemAnimator.7(this, paramChangeInfo, localViewPropertyAnimatorCompat2)).start();
      }
      if (localView1 != null)
      {
        this.mChangeAnimations.add(paramChangeInfo.newHolder);
        ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1 = ViewCompat.animate(localView1);
        localViewPropertyAnimatorCompat1.translationX(0.0F).translationY(0.0F).setDuration(getChangeDuration()).alpha(1.0F).setListener(new DefaultItemAnimator.8(this, paramChangeInfo, localViewPropertyAnimatorCompat1, localView1)).start();
      }
      return;
    }
  }
  
  private void animateMoveImpl(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramViewHolder.itemView;
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if (i != 0) {
      ViewCompat.animate(localView).translationX(0.0F);
    }
    if (j != 0) {
      ViewCompat.animate(localView).translationY(0.0F);
    }
    this.mMoveAnimations.add(paramViewHolder);
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(localView);
    localViewPropertyAnimatorCompat.setDuration(getMoveDuration()).setListener(new DefaultItemAnimator.6(this, paramViewHolder, i, j, localViewPropertyAnimatorCompat)).start();
  }
  
  private void animateRemoveImpl(RecyclerView.ViewHolder paramViewHolder)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(paramViewHolder.itemView);
    localViewPropertyAnimatorCompat.setDuration(getRemoveDuration()).alpha(0.0F).setListener(new DefaultItemAnimator.4(this, paramViewHolder, localViewPropertyAnimatorCompat)).start();
    this.mRemoveAnimations.add(paramViewHolder);
  }
  
  private void dispatchFinishedWhenDone()
  {
    if (!isRunning()) {
      dispatchAnimationsFinished();
    }
  }
  
  private void endChangeAnimation(List<DefaultItemAnimator.ChangeInfo> paramList, RecyclerView.ViewHolder paramViewHolder)
  {
    for (int i = -1 + paramList.size(); i >= 0; i--)
    {
      DefaultItemAnimator.ChangeInfo localChangeInfo = (DefaultItemAnimator.ChangeInfo)paramList.get(i);
      if ((endChangeAnimationIfNecessary(localChangeInfo, paramViewHolder)) && (localChangeInfo.oldHolder == null) && (localChangeInfo.newHolder == null)) {
        paramList.remove(localChangeInfo);
      }
    }
  }
  
  private void endChangeAnimationIfNecessary(DefaultItemAnimator.ChangeInfo paramChangeInfo)
  {
    if (paramChangeInfo.oldHolder != null) {
      endChangeAnimationIfNecessary(paramChangeInfo, paramChangeInfo.oldHolder);
    }
    if (paramChangeInfo.newHolder != null) {
      endChangeAnimationIfNecessary(paramChangeInfo, paramChangeInfo.newHolder);
    }
  }
  
  private boolean endChangeAnimationIfNecessary(DefaultItemAnimator.ChangeInfo paramChangeInfo, RecyclerView.ViewHolder paramViewHolder)
  {
    boolean bool = false;
    if (paramChangeInfo.newHolder == paramViewHolder) {
      paramChangeInfo.newHolder = null;
    }
    for (;;)
    {
      ViewCompat.setAlpha(paramViewHolder.itemView, 1.0F);
      ViewCompat.setTranslationX(paramViewHolder.itemView, 0.0F);
      ViewCompat.setTranslationY(paramViewHolder.itemView, 0.0F);
      dispatchChangeFinished(paramViewHolder, bool);
      bool = true;
      do
      {
        return bool;
      } while (paramChangeInfo.oldHolder != paramViewHolder);
      paramChangeInfo.oldHolder = null;
      bool = true;
    }
  }
  
  public boolean animateAdd(RecyclerView.ViewHolder paramViewHolder)
  {
    endAnimation(paramViewHolder);
    ViewCompat.setAlpha(paramViewHolder.itemView, 0.0F);
    this.mPendingAdditions.add(paramViewHolder);
    return true;
  }
  
  public boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = ViewCompat.getTranslationX(paramViewHolder1.itemView);
    float f2 = ViewCompat.getTranslationY(paramViewHolder1.itemView);
    float f3 = ViewCompat.getAlpha(paramViewHolder1.itemView);
    endAnimation(paramViewHolder1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    ViewCompat.setTranslationX(paramViewHolder1.itemView, f1);
    ViewCompat.setTranslationY(paramViewHolder1.itemView, f2);
    ViewCompat.setAlpha(paramViewHolder1.itemView, f3);
    if ((paramViewHolder2 != null) && (paramViewHolder2.itemView != null))
    {
      endAnimation(paramViewHolder2);
      ViewCompat.setTranslationX(paramViewHolder2.itemView, -i);
      ViewCompat.setTranslationY(paramViewHolder2.itemView, -j);
      ViewCompat.setAlpha(paramViewHolder2.itemView, 0.0F);
    }
    this.mPendingChanges.add(new DefaultItemAnimator.ChangeInfo(paramViewHolder1, paramViewHolder2, paramInt1, paramInt2, paramInt3, paramInt4, null));
    return true;
  }
  
  public boolean animateMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramViewHolder.itemView;
    int i = (int)(paramInt1 + ViewCompat.getTranslationX(paramViewHolder.itemView));
    int j = (int)(paramInt2 + ViewCompat.getTranslationY(paramViewHolder.itemView));
    endAnimation(paramViewHolder);
    int k = paramInt3 - i;
    int m = paramInt4 - j;
    if ((k == 0) && (m == 0)) {
      dispatchMoveFinished(paramViewHolder);
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      if (k != 0) {
        ViewCompat.setTranslationX(localView, -k);
      }
      if (m != 0) {
        ViewCompat.setTranslationY(localView, -m);
      }
      this.mPendingMoves.add(new DefaultItemAnimator.MoveInfo(paramViewHolder, i, j, paramInt3, paramInt4, null));
    }
  }
  
  public boolean animateRemove(RecyclerView.ViewHolder paramViewHolder)
  {
    endAnimation(paramViewHolder);
    this.mPendingRemovals.add(paramViewHolder);
    return true;
  }
  
  void cancelAll(List<RecyclerView.ViewHolder> paramList)
  {
    for (int i = -1 + paramList.size(); i >= 0; i--) {
      ViewCompat.animate(((RecyclerView.ViewHolder)paramList.get(i)).itemView).cancel();
    }
  }
  
  public void endAnimation(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    ViewCompat.animate(localView).cancel();
    for (int i = -1 + this.mPendingMoves.size(); i >= 0; i--) {
      if (((DefaultItemAnimator.MoveInfo)this.mPendingMoves.get(i)).holder == paramViewHolder)
      {
        ViewCompat.setTranslationY(localView, 0.0F);
        ViewCompat.setTranslationX(localView, 0.0F);
        dispatchMoveFinished(paramViewHolder);
        this.mPendingMoves.remove(i);
      }
    }
    endChangeAnimation(this.mPendingChanges, paramViewHolder);
    if (this.mPendingRemovals.remove(paramViewHolder))
    {
      ViewCompat.setAlpha(localView, 1.0F);
      dispatchRemoveFinished(paramViewHolder);
    }
    if (this.mPendingAdditions.remove(paramViewHolder))
    {
      ViewCompat.setAlpha(localView, 1.0F);
      dispatchAddFinished(paramViewHolder);
    }
    for (int j = -1 + this.mChangesList.size(); j >= 0; j--)
    {
      ArrayList localArrayList3 = (ArrayList)this.mChangesList.get(j);
      endChangeAnimation(localArrayList3, paramViewHolder);
      if (localArrayList3.isEmpty()) {
        this.mChangesList.remove(j);
      }
    }
    int k = -1 + this.mMovesList.size();
    if (k >= 0)
    {
      ArrayList localArrayList2 = (ArrayList)this.mMovesList.get(k);
      for (int n = -1 + localArrayList2.size();; n--)
      {
        if (n >= 0)
        {
          if (((DefaultItemAnimator.MoveInfo)localArrayList2.get(n)).holder != paramViewHolder) {
            continue;
          }
          ViewCompat.setTranslationY(localView, 0.0F);
          ViewCompat.setTranslationX(localView, 0.0F);
          dispatchMoveFinished(paramViewHolder);
          localArrayList2.remove(n);
          if (localArrayList2.isEmpty()) {
            this.mMovesList.remove(k);
          }
        }
        k--;
        break;
      }
    }
    for (int m = -1 + this.mAdditionsList.size(); m >= 0; m--)
    {
      ArrayList localArrayList1 = (ArrayList)this.mAdditionsList.get(m);
      if (localArrayList1.remove(paramViewHolder))
      {
        ViewCompat.setAlpha(localView, 1.0F);
        dispatchAddFinished(paramViewHolder);
        if (localArrayList1.isEmpty()) {
          this.mAdditionsList.remove(m);
        }
      }
    }
    this.mRemoveAnimations.remove(paramViewHolder);
    this.mAddAnimations.remove(paramViewHolder);
    this.mChangeAnimations.remove(paramViewHolder);
    this.mMoveAnimations.remove(paramViewHolder);
    dispatchFinishedWhenDone();
  }
  
  public void endAnimations()
  {
    for (int i = -1 + this.mPendingMoves.size(); i >= 0; i--)
    {
      DefaultItemAnimator.MoveInfo localMoveInfo2 = (DefaultItemAnimator.MoveInfo)this.mPendingMoves.get(i);
      View localView2 = localMoveInfo2.holder.itemView;
      ViewCompat.setTranslationY(localView2, 0.0F);
      ViewCompat.setTranslationX(localView2, 0.0F);
      dispatchMoveFinished(localMoveInfo2.holder);
      this.mPendingMoves.remove(i);
    }
    for (int j = -1 + this.mPendingRemovals.size(); j >= 0; j--)
    {
      dispatchRemoveFinished((RecyclerView.ViewHolder)this.mPendingRemovals.get(j));
      this.mPendingRemovals.remove(j);
    }
    for (int k = -1 + this.mPendingAdditions.size(); k >= 0; k--)
    {
      RecyclerView.ViewHolder localViewHolder2 = (RecyclerView.ViewHolder)this.mPendingAdditions.get(k);
      ViewCompat.setAlpha(localViewHolder2.itemView, 1.0F);
      dispatchAddFinished(localViewHolder2);
      this.mPendingAdditions.remove(k);
    }
    for (int m = -1 + this.mPendingChanges.size(); m >= 0; m--) {
      endChangeAnimationIfNecessary((DefaultItemAnimator.ChangeInfo)this.mPendingChanges.get(m));
    }
    this.mPendingChanges.clear();
    if (!isRunning()) {}
    for (;;)
    {
      return;
      for (int n = -1 + this.mMovesList.size(); n >= 0; n--)
      {
        ArrayList localArrayList3 = (ArrayList)this.mMovesList.get(n);
        for (int i5 = -1 + localArrayList3.size(); i5 >= 0; i5--)
        {
          DefaultItemAnimator.MoveInfo localMoveInfo1 = (DefaultItemAnimator.MoveInfo)localArrayList3.get(i5);
          View localView1 = localMoveInfo1.holder.itemView;
          ViewCompat.setTranslationY(localView1, 0.0F);
          ViewCompat.setTranslationX(localView1, 0.0F);
          dispatchMoveFinished(localMoveInfo1.holder);
          localArrayList3.remove(i5);
          if (localArrayList3.isEmpty()) {
            this.mMovesList.remove(localArrayList3);
          }
        }
      }
      for (int i1 = -1 + this.mAdditionsList.size(); i1 >= 0; i1--)
      {
        ArrayList localArrayList2 = (ArrayList)this.mAdditionsList.get(i1);
        for (int i4 = -1 + localArrayList2.size(); i4 >= 0; i4--)
        {
          RecyclerView.ViewHolder localViewHolder1 = (RecyclerView.ViewHolder)localArrayList2.get(i4);
          ViewCompat.setAlpha(localViewHolder1.itemView, 1.0F);
          dispatchAddFinished(localViewHolder1);
          localArrayList2.remove(i4);
          if (localArrayList2.isEmpty()) {
            this.mAdditionsList.remove(localArrayList2);
          }
        }
      }
      for (int i2 = -1 + this.mChangesList.size(); i2 >= 0; i2--)
      {
        ArrayList localArrayList1 = (ArrayList)this.mChangesList.get(i2);
        for (int i3 = -1 + localArrayList1.size(); i3 >= 0; i3--)
        {
          endChangeAnimationIfNecessary((DefaultItemAnimator.ChangeInfo)localArrayList1.get(i3));
          if (localArrayList1.isEmpty()) {
            this.mChangesList.remove(localArrayList1);
          }
        }
      }
      cancelAll(this.mRemoveAnimations);
      cancelAll(this.mMoveAnimations);
      cancelAll(this.mAddAnimations);
      cancelAll(this.mChangeAnimations);
      dispatchAnimationsFinished();
    }
  }
  
  public boolean isRunning()
  {
    if ((!this.mPendingAdditions.isEmpty()) || (!this.mPendingChanges.isEmpty()) || (!this.mPendingMoves.isEmpty()) || (!this.mPendingRemovals.isEmpty()) || (!this.mMoveAnimations.isEmpty()) || (!this.mRemoveAnimations.isEmpty()) || (!this.mAddAnimations.isEmpty()) || (!this.mChangeAnimations.isEmpty()) || (!this.mMovesList.isEmpty()) || (!this.mAdditionsList.isEmpty()) || (!this.mChangesList.isEmpty())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void runPendingAnimations()
  {
    int i;
    int j;
    label24:
    int k;
    label36:
    int m;
    if (!this.mPendingRemovals.isEmpty())
    {
      i = 1;
      if (this.mPendingMoves.isEmpty()) {
        break label72;
      }
      j = 1;
      if (this.mPendingChanges.isEmpty()) {
        break label77;
      }
      k = 1;
      if (this.mPendingAdditions.isEmpty()) {
        break label82;
      }
      m = 1;
      label49:
      if ((i != 0) || (j != 0) || (m != 0) || (k != 0)) {
        break label88;
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label72:
      j = 0;
      break label24;
      label77:
      k = 0;
      break label36;
      label82:
      m = 0;
      break label49;
      label88:
      Iterator localIterator = this.mPendingRemovals.iterator();
      while (localIterator.hasNext()) {
        animateRemoveImpl((RecyclerView.ViewHolder)localIterator.next());
      }
      this.mPendingRemovals.clear();
      DefaultItemAnimator.1 local1;
      label211:
      DefaultItemAnimator.2 local2;
      label291:
      ArrayList localArrayList3;
      DefaultItemAnimator.3 local3;
      long l1;
      label366:
      long l2;
      if (j != 0)
      {
        ArrayList localArrayList1 = new ArrayList();
        localArrayList1.addAll(this.mPendingMoves);
        this.mMovesList.add(localArrayList1);
        this.mPendingMoves.clear();
        local1 = new DefaultItemAnimator.1(this, localArrayList1);
        if (i != 0) {
          ViewCompat.postOnAnimationDelayed(((DefaultItemAnimator.MoveInfo)localArrayList1.get(0)).holder.itemView, local1, getRemoveDuration());
        }
      }
      else
      {
        if (k != 0)
        {
          ArrayList localArrayList2 = new ArrayList();
          localArrayList2.addAll(this.mPendingChanges);
          this.mChangesList.add(localArrayList2);
          this.mPendingChanges.clear();
          local2 = new DefaultItemAnimator.2(this, localArrayList2);
          if (i == 0) {
            break label430;
          }
          ViewCompat.postOnAnimationDelayed(((DefaultItemAnimator.ChangeInfo)localArrayList2.get(0)).oldHolder.itemView, local2, getRemoveDuration());
        }
        if (m == 0) {
          break label438;
        }
        localArrayList3 = new ArrayList();
        localArrayList3.addAll(this.mPendingAdditions);
        this.mAdditionsList.add(localArrayList3);
        this.mPendingAdditions.clear();
        local3 = new DefaultItemAnimator.3(this, localArrayList3);
        if ((i == 0) && (j == 0) && (k == 0)) {
          break label458;
        }
        if (i == 0) {
          break label440;
        }
        l1 = getRemoveDuration();
        if (j == 0) {
          break label446;
        }
        l2 = getMoveDuration();
        label376:
        if (k == 0) {
          break label452;
        }
      }
      label430:
      label438:
      label440:
      label446:
      label452:
      for (long l3 = getChangeDuration();; l3 = 0L)
      {
        long l4 = l1 + Math.max(l2, l3);
        ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder)localArrayList3.get(0)).itemView, local3, l4);
        break;
        local1.run();
        break label211;
        local2.run();
        break label291;
        break;
        l1 = 0L;
        break label366;
        l2 = 0L;
        break label376;
      }
      label458:
      local3.run();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator
 * JD-Core Version:    0.7.0.1
 */