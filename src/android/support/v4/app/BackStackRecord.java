package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LogWriter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackRecord
  extends FragmentTransaction
  implements FragmentManager.BackStackEntry, Runnable
{
  static final int OP_ADD = 1;
  static final int OP_ATTACH = 7;
  static final int OP_DETACH = 6;
  static final int OP_HIDE = 4;
  static final int OP_NULL = 0;
  static final int OP_REMOVE = 3;
  static final int OP_REPLACE = 2;
  static final int OP_SHOW = 5;
  static final String TAG = "FragmentManager";
  boolean mAddToBackStack;
  boolean mAllowAddToBackStack = true;
  int mBreadCrumbShortTitleRes;
  CharSequence mBreadCrumbShortTitleText;
  int mBreadCrumbTitleRes;
  CharSequence mBreadCrumbTitleText;
  boolean mCommitted;
  int mEnterAnim;
  int mExitAnim;
  BackStackRecord.Op mHead;
  int mIndex = -1;
  final FragmentManagerImpl mManager;
  String mName;
  int mNumOp;
  int mPopEnterAnim;
  int mPopExitAnim;
  ArrayList<String> mSharedElementSourceNames;
  ArrayList<String> mSharedElementTargetNames;
  BackStackRecord.Op mTail;
  int mTransition;
  int mTransitionStyle;
  
  public BackStackRecord(FragmentManagerImpl paramFragmentManagerImpl)
  {
    this.mManager = paramFragmentManagerImpl;
  }
  
  private BackStackRecord.TransitionState beginTransition(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2, boolean paramBoolean)
  {
    int i = 0;
    BackStackRecord.TransitionState localTransitionState = new BackStackRecord.TransitionState(this);
    localTransitionState.nonExistentView = new View(this.mManager.mActivity);
    int j = 0;
    int k = 0;
    if (j < paramSparseArray1.size()) {
      if (!configureTransitions(paramSparseArray1.keyAt(j), localTransitionState, paramBoolean, paramSparseArray1, paramSparseArray2)) {
        break label138;
      }
    }
    label138:
    for (int n = 1;; n = k)
    {
      j++;
      k = n;
      break;
      while (i < paramSparseArray2.size())
      {
        int m = paramSparseArray2.keyAt(i);
        if ((paramSparseArray1.get(m) == null) && (configureTransitions(m, localTransitionState, paramBoolean, paramSparseArray1, paramSparseArray2))) {
          k = 1;
        }
        i++;
      }
      if (k == 0) {
        localTransitionState = null;
      }
      return localTransitionState;
    }
  }
  
  private void calculateFragments(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    if (!this.mManager.mContainer.hasView()) {}
    BackStackRecord.Op localOp;
    do
    {
      return;
      localOp = this.mHead;
    } while (localOp == null);
    switch (localOp.cmd)
    {
    }
    for (;;)
    {
      localOp = localOp.next;
      break;
      setLastIn(paramSparseArray2, localOp.fragment);
      continue;
      Fragment localFragment1 = localOp.fragment;
      Fragment localFragment2;
      if (this.mManager.mAdded != null)
      {
        localFragment2 = localFragment1;
        int i = 0;
        if (i < this.mManager.mAdded.size())
        {
          Fragment localFragment3 = (Fragment)this.mManager.mAdded.get(i);
          if ((localFragment2 == null) || (localFragment3.mContainerId == localFragment2.mContainerId))
          {
            if (localFragment3 != localFragment2) {
              break label181;
            }
            localFragment2 = null;
          }
          for (;;)
          {
            i++;
            break;
            label181:
            setFirstOut(paramSparseArray1, localFragment3);
          }
        }
      }
      else
      {
        localFragment2 = localFragment1;
      }
      setLastIn(paramSparseArray2, localFragment2);
      continue;
      setFirstOut(paramSparseArray1, localOp.fragment);
      continue;
      setFirstOut(paramSparseArray1, localOp.fragment);
      continue;
      setLastIn(paramSparseArray2, localOp.fragment);
      continue;
      setFirstOut(paramSparseArray1, localOp.fragment);
      continue;
      setLastIn(paramSparseArray2, localOp.fragment);
    }
  }
  
  private void callSharedElementEnd(BackStackRecord.TransitionState paramTransitionState, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, ArrayMap<String, View> paramArrayMap)
  {
    if (paramBoolean) {}
    for (SharedElementCallback localSharedElementCallback = paramFragment2.mEnterTransitionCallback;; localSharedElementCallback = paramFragment1.mEnterTransitionCallback)
    {
      if (localSharedElementCallback != null) {
        localSharedElementCallback.onSharedElementEnd(new ArrayList(paramArrayMap.keySet()), new ArrayList(paramArrayMap.values()), null);
      }
      return;
    }
  }
  
  private static Object captureExitingViews(Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, ArrayMap<String, View> paramArrayMap)
  {
    if (paramObject != null) {
      paramObject = FragmentTransitionCompat21.captureExitingViews(paramObject, paramFragment.getView(), paramArrayList, paramArrayMap);
    }
    return paramObject;
  }
  
  private boolean configureTransitions(int paramInt, BackStackRecord.TransitionState paramTransitionState, boolean paramBoolean, SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    ViewGroup localViewGroup = (ViewGroup)this.mManager.mContainer.findViewById(paramInt);
    boolean bool2;
    if (localViewGroup == null) {
      bool2 = false;
    }
    for (;;)
    {
      return bool2;
      Fragment localFragment1 = (Fragment)paramSparseArray2.get(paramInt);
      Fragment localFragment2 = (Fragment)paramSparseArray1.get(paramInt);
      Object localObject1 = getEnterTransition(localFragment1, paramBoolean);
      Object localObject2 = getSharedElementTransition(localFragment1, localFragment2, paramBoolean);
      Object localObject3 = getExitTransition(localFragment2, paramBoolean);
      if ((localObject1 == null) && (localObject2 == null) && (localObject3 == null))
      {
        bool2 = false;
      }
      else
      {
        ArrayMap localArrayMap1 = null;
        ArrayList localArrayList1 = new ArrayList();
        label143:
        SharedElementCallback localSharedElementCallback;
        if (localObject2 != null)
        {
          localArrayMap1 = remapSharedElements(paramTransitionState, localFragment2, paramBoolean);
          if (!localArrayMap1.isEmpty()) {
            break label454;
          }
          localArrayList1.add(paramTransitionState.nonExistentView);
          if (!paramBoolean) {
            break label468;
          }
          localSharedElementCallback = localFragment2.mEnterTransitionCallback;
          label154:
          if (localSharedElementCallback != null) {
            localSharedElementCallback.onSharedElementStart(new ArrayList(localArrayMap1.keySet()), new ArrayList(localArrayMap1.values()), null);
          }
        }
        ArrayList localArrayList2 = new ArrayList();
        Object localObject4 = captureExitingViews(localObject3, localFragment2, localArrayList2, localArrayMap1);
        if ((this.mSharedElementTargetNames != null) && (localArrayMap1 != null))
        {
          View localView = (View)localArrayMap1.get(this.mSharedElementTargetNames.get(0));
          if (localView != null)
          {
            if (localObject4 != null) {
              FragmentTransitionCompat21.setEpicenter(localObject4, localView);
            }
            if (localObject2 != null) {
              FragmentTransitionCompat21.setEpicenter(localObject2, localView);
            }
          }
        }
        BackStackRecord.1 local1 = new BackStackRecord.1(this, localFragment1);
        if (localObject2 != null) {
          prepareSharedElementTransition(paramTransitionState, localViewGroup, localObject2, localFragment1, localFragment2, paramBoolean, localArrayList1);
        }
        ArrayList localArrayList3 = new ArrayList();
        ArrayMap localArrayMap2 = new ArrayMap();
        if (paramBoolean) {}
        for (boolean bool1 = localFragment1.getAllowReturnTransitionOverlap();; bool1 = localFragment1.getAllowEnterTransitionOverlap())
        {
          Object localObject5 = FragmentTransitionCompat21.mergeTransitions(localObject1, localObject4, localObject2, bool1);
          if (localObject5 != null)
          {
            FragmentTransitionCompat21.addTransitionTargets(localObject1, localObject2, localViewGroup, local1, paramTransitionState.nonExistentView, paramTransitionState.enteringEpicenterView, paramTransitionState.nameOverrides, localArrayList3, localArrayMap2, localArrayList1);
            excludeHiddenFragmentsAfterEnter(localViewGroup, paramTransitionState, paramInt, localObject5);
            FragmentTransitionCompat21.excludeTarget(localObject5, paramTransitionState.nonExistentView, true);
            excludeHiddenFragments(paramTransitionState, paramInt, localObject5);
            FragmentTransitionCompat21.beginDelayedTransition(localViewGroup, localObject5);
            FragmentTransitionCompat21.cleanupTransitions(localViewGroup, paramTransitionState.nonExistentView, localObject1, localArrayList3, localObject4, localArrayList2, localObject2, localArrayList1, localObject5, paramTransitionState.hiddenFragmentViews, localArrayMap2);
          }
          if (localObject5 == null) {
            break label488;
          }
          bool2 = true;
          break;
          label454:
          localArrayList1.addAll(localArrayMap1.values());
          break label143;
          label468:
          localSharedElementCallback = localFragment1.mEnterTransitionCallback;
          break label154;
        }
        label488:
        bool2 = false;
      }
    }
  }
  
  private void doAddOp(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    paramFragment.mFragmentManager = this.mManager;
    if (paramString != null)
    {
      if ((paramFragment.mTag != null) && (!paramString.equals(paramFragment.mTag))) {
        throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + paramFragment.mTag + " now " + paramString);
      }
      paramFragment.mTag = paramString;
    }
    if (paramInt1 != 0)
    {
      if ((paramFragment.mFragmentId != 0) && (paramFragment.mFragmentId != paramInt1)) {
        throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + paramFragment.mFragmentId + " now " + paramInt1);
      }
      paramFragment.mFragmentId = paramInt1;
      paramFragment.mContainerId = paramInt1;
    }
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    localOp.cmd = paramInt2;
    localOp.fragment = paramFragment;
    addOp(localOp);
  }
  
  private void excludeHiddenFragments(BackStackRecord.TransitionState paramTransitionState, int paramInt, Object paramObject)
  {
    if (this.mManager.mAdded != null)
    {
      int i = 0;
      if (i < this.mManager.mAdded.size())
      {
        Fragment localFragment = (Fragment)this.mManager.mAdded.get(i);
        if ((localFragment.mView != null) && (localFragment.mContainer != null) && (localFragment.mContainerId == paramInt))
        {
          if (!localFragment.mHidden) {
            break label122;
          }
          if (!paramTransitionState.hiddenFragmentViews.contains(localFragment.mView))
          {
            FragmentTransitionCompat21.excludeTarget(paramObject, localFragment.mView, true);
            paramTransitionState.hiddenFragmentViews.add(localFragment.mView);
          }
        }
        for (;;)
        {
          i++;
          break;
          label122:
          FragmentTransitionCompat21.excludeTarget(paramObject, localFragment.mView, false);
          paramTransitionState.hiddenFragmentViews.remove(localFragment.mView);
        }
      }
    }
  }
  
  private void excludeHiddenFragmentsAfterEnter(View paramView, BackStackRecord.TransitionState paramTransitionState, int paramInt, Object paramObject)
  {
    paramView.getViewTreeObserver().addOnPreDrawListener(new BackStackRecord.3(this, paramView, paramTransitionState, paramInt, paramObject));
  }
  
  private static Object getEnterTransition(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject2;
    if (paramFragment == null)
    {
      localObject2 = null;
      return localObject2;
    }
    if (paramBoolean) {}
    for (Object localObject1 = paramFragment.getReenterTransition();; localObject1 = paramFragment.getEnterTransition())
    {
      localObject2 = FragmentTransitionCompat21.cloneTransition(localObject1);
      break;
    }
  }
  
  private static Object getExitTransition(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject2;
    if (paramFragment == null)
    {
      localObject2 = null;
      return localObject2;
    }
    if (paramBoolean) {}
    for (Object localObject1 = paramFragment.getReturnTransition();; localObject1 = paramFragment.getExitTransition())
    {
      localObject2 = FragmentTransitionCompat21.cloneTransition(localObject1);
      break;
    }
  }
  
  private static Object getSharedElementTransition(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramFragment1 == null) || (paramFragment2 == null))
    {
      localObject1 = null;
      return localObject1;
    }
    if (paramBoolean) {}
    for (Object localObject2 = paramFragment2.getSharedElementReturnTransition();; localObject2 = paramFragment1.getSharedElementEnterTransition())
    {
      localObject1 = FragmentTransitionCompat21.cloneTransition(localObject2);
      break;
    }
  }
  
  private ArrayMap<String, View> mapEnteringSharedElements(BackStackRecord.TransitionState paramTransitionState, Fragment paramFragment, boolean paramBoolean)
  {
    ArrayMap localArrayMap = new ArrayMap();
    View localView = paramFragment.getView();
    if ((localView != null) && (this.mSharedElementSourceNames != null))
    {
      FragmentTransitionCompat21.findNamedViews(localArrayMap, localView);
      if (!paramBoolean) {
        break label56;
      }
      localArrayMap = remapNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames, localArrayMap);
    }
    for (;;)
    {
      return localArrayMap;
      label56:
      localArrayMap.retainAll(this.mSharedElementTargetNames);
    }
  }
  
  private ArrayMap<String, View> mapSharedElementsIn(BackStackRecord.TransitionState paramTransitionState, boolean paramBoolean, Fragment paramFragment)
  {
    ArrayMap localArrayMap = mapEnteringSharedElements(paramTransitionState, paramFragment, paramBoolean);
    if (paramBoolean)
    {
      if (paramFragment.mExitTransitionCallback != null) {
        paramFragment.mExitTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, localArrayMap);
      }
      setBackNameOverrides(paramTransitionState, localArrayMap, true);
    }
    for (;;)
    {
      return localArrayMap;
      if (paramFragment.mEnterTransitionCallback != null) {
        paramFragment.mEnterTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, localArrayMap);
      }
      setNameOverrides(paramTransitionState, localArrayMap, true);
    }
  }
  
  private void prepareSharedElementTransition(BackStackRecord.TransitionState paramTransitionState, View paramView, Object paramObject, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, ArrayList<View> paramArrayList)
  {
    paramView.getViewTreeObserver().addOnPreDrawListener(new BackStackRecord.2(this, paramView, paramObject, paramArrayList, paramTransitionState, paramBoolean, paramFragment1, paramFragment2));
  }
  
  private static ArrayMap<String, View> remapNames(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayMap<String, View> paramArrayMap)
  {
    if (paramArrayMap.isEmpty()) {}
    for (;;)
    {
      return paramArrayMap;
      ArrayMap localArrayMap = new ArrayMap();
      int i = paramArrayList1.size();
      for (int j = 0; j < i; j++)
      {
        View localView = (View)paramArrayMap.get(paramArrayList1.get(j));
        if (localView != null) {
          localArrayMap.put(paramArrayList2.get(j), localView);
        }
      }
      paramArrayMap = localArrayMap;
    }
  }
  
  private ArrayMap<String, View> remapSharedElements(BackStackRecord.TransitionState paramTransitionState, Fragment paramFragment, boolean paramBoolean)
  {
    ArrayMap localArrayMap = new ArrayMap();
    if (this.mSharedElementSourceNames != null)
    {
      FragmentTransitionCompat21.findNamedViews(localArrayMap, paramFragment.getView());
      if (paramBoolean) {
        localArrayMap.retainAll(this.mSharedElementTargetNames);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label92;
      }
      if (paramFragment.mEnterTransitionCallback != null) {
        paramFragment.mEnterTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, localArrayMap);
      }
      setBackNameOverrides(paramTransitionState, localArrayMap, false);
    }
    for (;;)
    {
      return localArrayMap;
      localArrayMap = remapNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames, localArrayMap);
      break;
      label92:
      if (paramFragment.mExitTransitionCallback != null) {
        paramFragment.mExitTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, localArrayMap);
      }
      setNameOverrides(paramTransitionState, localArrayMap, false);
    }
  }
  
  private void setBackNameOverrides(BackStackRecord.TransitionState paramTransitionState, ArrayMap<String, View> paramArrayMap, boolean paramBoolean)
  {
    int i;
    int j;
    label13:
    String str1;
    String str2;
    if (this.mSharedElementTargetNames == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      str1 = (String)this.mSharedElementSourceNames.get(j);
      View localView = (View)paramArrayMap.get((String)this.mSharedElementTargetNames.get(j));
      if (localView != null)
      {
        str2 = FragmentTransitionCompat21.getTransitionName(localView);
        if (!paramBoolean) {
          break label100;
        }
        setNameOverride(paramTransitionState.nameOverrides, str1, str2);
      }
    }
    for (;;)
    {
      j++;
      break label13;
      i = this.mSharedElementTargetNames.size();
      break;
      label100:
      setNameOverride(paramTransitionState.nameOverrides, str2, str1);
    }
  }
  
  private void setEpicenterIn(ArrayMap<String, View> paramArrayMap, BackStackRecord.TransitionState paramTransitionState)
  {
    if ((this.mSharedElementTargetNames != null) && (!paramArrayMap.isEmpty()))
    {
      View localView = (View)paramArrayMap.get(this.mSharedElementTargetNames.get(0));
      if (localView != null) {
        paramTransitionState.enteringEpicenterView.epicenter = localView;
      }
    }
  }
  
  private static void setFirstOut(SparseArray<Fragment> paramSparseArray, Fragment paramFragment)
  {
    if (paramFragment != null)
    {
      int i = paramFragment.mContainerId;
      if ((i != 0) && (!paramFragment.isHidden()) && (paramFragment.isAdded()) && (paramFragment.getView() != null) && (paramSparseArray.get(i) == null)) {
        paramSparseArray.put(i, paramFragment);
      }
    }
  }
  
  private void setLastIn(SparseArray<Fragment> paramSparseArray, Fragment paramFragment)
  {
    if (paramFragment != null)
    {
      int i = paramFragment.mContainerId;
      if (i != 0) {
        paramSparseArray.put(i, paramFragment);
      }
    }
  }
  
  private static void setNameOverride(ArrayMap<String, String> paramArrayMap, String paramString1, String paramString2)
  {
    int i;
    if ((paramString1 != null) && (paramString2 != null) && (!paramString1.equals(paramString2)))
    {
      i = 0;
      if (i >= paramArrayMap.size()) {
        break label52;
      }
      if (!paramString1.equals(paramArrayMap.valueAt(i))) {
        break label46;
      }
      paramArrayMap.setValueAt(i, paramString2);
    }
    for (;;)
    {
      return;
      label46:
      i++;
      break;
      label52:
      paramArrayMap.put(paramString1, paramString2);
    }
  }
  
  private void setNameOverrides(BackStackRecord.TransitionState paramTransitionState, ArrayMap<String, View> paramArrayMap, boolean paramBoolean)
  {
    int i = paramArrayMap.size();
    int j = 0;
    if (j < i)
    {
      String str1 = (String)paramArrayMap.keyAt(j);
      String str2 = FragmentTransitionCompat21.getTransitionName((View)paramArrayMap.valueAt(j));
      if (paramBoolean) {
        setNameOverride(paramTransitionState.nameOverrides, str1, str2);
      }
      for (;;)
      {
        j++;
        break;
        setNameOverride(paramTransitionState.nameOverrides, str2, str1);
      }
    }
  }
  
  private static void setNameOverrides(BackStackRecord.TransitionState paramTransitionState, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if (paramArrayList1 != null) {
      for (int i = 0; i < paramArrayList1.size(); i++)
      {
        String str1 = (String)paramArrayList1.get(i);
        String str2 = (String)paramArrayList2.get(i);
        setNameOverride(paramTransitionState.nameOverrides, str1, str2);
      }
    }
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment)
  {
    doAddOp(paramInt, paramFragment, null, 1);
    return this;
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment, String paramString)
  {
    doAddOp(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  public FragmentTransaction add(Fragment paramFragment, String paramString)
  {
    doAddOp(0, paramFragment, paramString, 1);
    return this;
  }
  
  void addOp(BackStackRecord.Op paramOp)
  {
    if (this.mHead == null)
    {
      this.mTail = paramOp;
      this.mHead = paramOp;
    }
    for (;;)
    {
      paramOp.enterAnim = this.mEnterAnim;
      paramOp.exitAnim = this.mExitAnim;
      paramOp.popEnterAnim = this.mPopEnterAnim;
      paramOp.popExitAnim = this.mPopExitAnim;
      this.mNumOp = (1 + this.mNumOp);
      return;
      paramOp.prev = this.mTail;
      this.mTail.next = paramOp;
      this.mTail = paramOp;
    }
  }
  
  public FragmentTransaction addSharedElement(View paramView, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      String str = FragmentTransitionCompat21.getTransitionName(paramView);
      if (str == null) {
        throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
      }
      if (this.mSharedElementSourceNames == null)
      {
        this.mSharedElementSourceNames = new ArrayList();
        this.mSharedElementTargetNames = new ArrayList();
      }
      this.mSharedElementSourceNames.add(str);
      this.mSharedElementTargetNames.add(paramString);
    }
    return this;
  }
  
  public FragmentTransaction addToBackStack(String paramString)
  {
    if (!this.mAllowAddToBackStack) {
      throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }
    this.mAddToBackStack = true;
    this.mName = paramString;
    return this;
  }
  
  public FragmentTransaction attach(Fragment paramFragment)
  {
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    localOp.cmd = 7;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  void bumpBackStackNesting(int paramInt)
  {
    if (!this.mAddToBackStack) {}
    for (;;)
    {
      return;
      if (FragmentManagerImpl.DEBUG) {
        new StringBuilder().append("Bump nesting in ").append(this).append(" by ").append(paramInt).toString();
      }
      for (BackStackRecord.Op localOp = this.mHead; localOp != null; localOp = localOp.next)
      {
        if (localOp.fragment != null)
        {
          Fragment localFragment2 = localOp.fragment;
          localFragment2.mBackStackNesting = (paramInt + localFragment2.mBackStackNesting);
          if (FragmentManagerImpl.DEBUG) {
            new StringBuilder().append("Bump nesting of ").append(localOp.fragment).append(" to ").append(localOp.fragment.mBackStackNesting).toString();
          }
        }
        if (localOp.removed != null) {
          for (int i = -1 + localOp.removed.size(); i >= 0; i--)
          {
            Fragment localFragment1 = (Fragment)localOp.removed.get(i);
            localFragment1.mBackStackNesting = (paramInt + localFragment1.mBackStackNesting);
            if (FragmentManagerImpl.DEBUG) {
              new StringBuilder().append("Bump nesting of ").append(localFragment1).append(" to ").append(localFragment1.mBackStackNesting).toString();
            }
          }
        }
      }
    }
  }
  
  public void calculateBackFragments(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    if (!this.mManager.mContainer.hasView()) {}
    BackStackRecord.Op localOp;
    do
    {
      return;
      localOp = this.mHead;
    } while (localOp == null);
    switch (localOp.cmd)
    {
    }
    for (;;)
    {
      localOp = localOp.next;
      break;
      setFirstOut(paramSparseArray1, localOp.fragment);
      continue;
      if (localOp.removed != null) {
        for (int i = -1 + localOp.removed.size(); i >= 0; i--) {
          setLastIn(paramSparseArray2, (Fragment)localOp.removed.get(i));
        }
      }
      setFirstOut(paramSparseArray1, localOp.fragment);
      continue;
      setLastIn(paramSparseArray2, localOp.fragment);
      continue;
      setLastIn(paramSparseArray2, localOp.fragment);
      continue;
      setFirstOut(paramSparseArray1, localOp.fragment);
      continue;
      setLastIn(paramSparseArray2, localOp.fragment);
      continue;
      setFirstOut(paramSparseArray1, localOp.fragment);
    }
  }
  
  public int commit()
  {
    return commitInternal(false);
  }
  
  public int commitAllowingStateLoss()
  {
    return commitInternal(true);
  }
  
  int commitInternal(boolean paramBoolean)
  {
    if (this.mCommitted) {
      throw new IllegalStateException("commit already called");
    }
    if (FragmentManagerImpl.DEBUG)
    {
      new StringBuilder().append("Commit: ").append(this).toString();
      dump("  ", null, new PrintWriter(new LogWriter("FragmentManager")), null);
    }
    this.mCommitted = true;
    if (this.mAddToBackStack) {}
    for (this.mIndex = this.mManager.allocBackStackIndex(this);; this.mIndex = -1)
    {
      this.mManager.enqueueAction(this, paramBoolean);
      return this.mIndex;
    }
  }
  
  public FragmentTransaction detach(Fragment paramFragment)
  {
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    localOp.cmd = 6;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public FragmentTransaction disallowAddToBackStack()
  {
    if (this.mAddToBackStack) {
      throw new IllegalStateException("This transaction is already being added to the back stack");
    }
    this.mAllowAddToBackStack = false;
    return this;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    dump(paramString, paramPrintWriter, true);
  }
  
  public void dump(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.mName);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.mIndex);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.mCommitted);
      if (this.mTransition != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.mTransition));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.mTransitionStyle));
      }
      if ((this.mEnterAnim != 0) || (this.mExitAnim != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.mEnterAnim));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.mExitAnim));
      }
      if ((this.mPopEnterAnim != 0) || (this.mPopExitAnim != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.mPopEnterAnim));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.mPopExitAnim));
      }
      if ((this.mBreadCrumbTitleRes != 0) || (this.mBreadCrumbTitleText != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.mBreadCrumbTitleText);
      }
      if ((this.mBreadCrumbShortTitleRes != 0) || (this.mBreadCrumbShortTitleText != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.mBreadCrumbShortTitleText);
      }
    }
    if (this.mHead != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      String str1 = paramString + "    ";
      BackStackRecord.Op localOp1 = this.mHead;
      int i = 0;
      BackStackRecord.Op localOp2 = localOp1;
      while (localOp2 != null)
      {
        String str2;
        int j;
        switch (localOp2.cmd)
        {
        default: 
          str2 = "cmd=" + localOp2.cmd;
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str2);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(localOp2.fragment);
          if (paramBoolean)
          {
            if ((localOp2.enterAnim != 0) || (localOp2.exitAnim != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(localOp2.enterAnim));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(localOp2.exitAnim));
            }
            if ((localOp2.popEnterAnim != 0) || (localOp2.popExitAnim != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(localOp2.popEnterAnim));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(localOp2.popExitAnim));
            }
          }
          if ((localOp2.removed == null) || (localOp2.removed.size() <= 0)) {
            break label808;
          }
          j = 0;
          label645:
          if (j >= localOp2.removed.size()) {
            break label808;
          }
          paramPrintWriter.print(str1);
          if (localOp2.removed.size() == 1) {
            paramPrintWriter.print("Removed: ");
          }
          break;
        }
        for (;;)
        {
          paramPrintWriter.println(localOp2.removed.get(j));
          j++;
          break label645;
          str2 = "NULL";
          break;
          str2 = "ADD";
          break;
          str2 = "REPLACE";
          break;
          str2 = "REMOVE";
          break;
          str2 = "HIDE";
          break;
          str2 = "SHOW";
          break;
          str2 = "DETACH";
          break;
          str2 = "ATTACH";
          break;
          if (j == 0) {
            paramPrintWriter.println("Removed:");
          }
          paramPrintWriter.print(str1);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(j);
          paramPrintWriter.print(": ");
        }
        label808:
        localOp2 = localOp2.next;
        i++;
      }
    }
  }
  
  public CharSequence getBreadCrumbShortTitle()
  {
    if (this.mBreadCrumbShortTitleRes != 0) {}
    for (CharSequence localCharSequence = this.mManager.mActivity.getText(this.mBreadCrumbShortTitleRes);; localCharSequence = this.mBreadCrumbShortTitleText) {
      return localCharSequence;
    }
  }
  
  public int getBreadCrumbShortTitleRes()
  {
    return this.mBreadCrumbShortTitleRes;
  }
  
  public CharSequence getBreadCrumbTitle()
  {
    if (this.mBreadCrumbTitleRes != 0) {}
    for (CharSequence localCharSequence = this.mManager.mActivity.getText(this.mBreadCrumbTitleRes);; localCharSequence = this.mBreadCrumbTitleText) {
      return localCharSequence;
    }
  }
  
  public int getBreadCrumbTitleRes()
  {
    return this.mBreadCrumbTitleRes;
  }
  
  public int getId()
  {
    return this.mIndex;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getTransition()
  {
    return this.mTransition;
  }
  
  public int getTransitionStyle()
  {
    return this.mTransitionStyle;
  }
  
  public FragmentTransaction hide(Fragment paramFragment)
  {
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    localOp.cmd = 4;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public boolean isAddToBackStackAllowed()
  {
    return this.mAllowAddToBackStack;
  }
  
  public boolean isEmpty()
  {
    if (this.mNumOp == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public BackStackRecord.TransitionState popFromBackStack(boolean paramBoolean, BackStackRecord.TransitionState paramTransitionState, SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    if (FragmentManagerImpl.DEBUG)
    {
      new StringBuilder().append("popFromBackStack: ").append(this).toString();
      dump("  ", null, new PrintWriter(new LogWriter("FragmentManager")), null);
    }
    label80:
    int i;
    label93:
    int j;
    label100:
    BackStackRecord.Op localOp;
    int k;
    if (paramTransitionState == null)
    {
      if ((paramSparseArray1.size() != 0) || (paramSparseArray2.size() != 0)) {
        paramTransitionState = beginTransition(paramSparseArray1, paramSparseArray2, true);
      }
      bumpBackStackNesting(-1);
      if (paramTransitionState == null) {
        break label223;
      }
      i = 0;
      if (paramTransitionState == null) {
        break label232;
      }
      j = 0;
      localOp = this.mTail;
      if (localOp == null) {
        break label557;
      }
      if (paramTransitionState == null) {
        break label241;
      }
      k = 0;
      label118:
      if (paramTransitionState == null) {
        break label251;
      }
    }
    label223:
    label232:
    label241:
    label251:
    for (int m = 0;; m = localOp.popExitAnim) {
      switch (localOp.cmd)
      {
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + localOp.cmd);
        if (paramBoolean) {
          break label80;
        }
        setNameOverrides(paramTransitionState, this.mSharedElementTargetNames, this.mSharedElementSourceNames);
        break label80;
        i = this.mTransitionStyle;
        break label93;
        j = this.mTransition;
        break label100;
        k = localOp.popEnterAnim;
        break label118;
      }
    }
    Fragment localFragment8 = localOp.fragment;
    localFragment8.mNextAnim = m;
    this.mManager.removeFragment(localFragment8, FragmentManagerImpl.reverseTransit(j), i);
    for (;;)
    {
      localOp = localOp.prev;
      break;
      Fragment localFragment6 = localOp.fragment;
      if (localFragment6 != null)
      {
        localFragment6.mNextAnim = m;
        this.mManager.removeFragment(localFragment6, FragmentManagerImpl.reverseTransit(j), i);
      }
      if (localOp.removed != null)
      {
        for (int n = 0; n < localOp.removed.size(); n++)
        {
          Fragment localFragment7 = (Fragment)localOp.removed.get(n);
          localFragment7.mNextAnim = k;
          this.mManager.addFragment(localFragment7, false);
        }
        Fragment localFragment5 = localOp.fragment;
        localFragment5.mNextAnim = k;
        this.mManager.addFragment(localFragment5, false);
        continue;
        Fragment localFragment4 = localOp.fragment;
        localFragment4.mNextAnim = k;
        this.mManager.showFragment(localFragment4, FragmentManagerImpl.reverseTransit(j), i);
        continue;
        Fragment localFragment3 = localOp.fragment;
        localFragment3.mNextAnim = m;
        this.mManager.hideFragment(localFragment3, FragmentManagerImpl.reverseTransit(j), i);
        continue;
        Fragment localFragment2 = localOp.fragment;
        localFragment2.mNextAnim = k;
        this.mManager.attachFragment(localFragment2, FragmentManagerImpl.reverseTransit(j), i);
        continue;
        Fragment localFragment1 = localOp.fragment;
        localFragment1.mNextAnim = k;
        this.mManager.detachFragment(localFragment1, FragmentManagerImpl.reverseTransit(j), i);
      }
    }
    label557:
    if (paramBoolean)
    {
      this.mManager.moveToState(this.mManager.mCurState, FragmentManagerImpl.reverseTransit(j), i, true);
      paramTransitionState = null;
    }
    if (this.mIndex >= 0)
    {
      this.mManager.freeBackStackIndex(this.mIndex);
      this.mIndex = -1;
    }
    return paramTransitionState;
  }
  
  public FragmentTransaction remove(Fragment paramFragment)
  {
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    localOp.cmd = 3;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment)
  {
    return replace(paramInt, paramFragment, null);
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment, String paramString)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
    doAddOp(paramInt, paramFragment, paramString, 2);
    return this;
  }
  
  public void run()
  {
    if (FragmentManagerImpl.DEBUG) {
      new StringBuilder().append("Run: ").append(this).toString();
    }
    if ((this.mAddToBackStack) && (this.mIndex < 0)) {
      throw new IllegalStateException("addToBackStack() called after commit()");
    }
    bumpBackStackNesting(1);
    SparseArray localSparseArray1;
    SparseArray localSparseArray2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localSparseArray1 = new SparseArray();
      localSparseArray2 = new SparseArray();
      calculateFragments(localSparseArray1, localSparseArray2);
    }
    for (BackStackRecord.TransitionState localTransitionState = beginTransition(localSparseArray1, localSparseArray2, false);; localTransitionState = null)
    {
      int i;
      label102:
      int j;
      label109:
      BackStackRecord.Op localOp;
      int k;
      if (localTransitionState != null)
      {
        i = 0;
        if (localTransitionState == null) {
          break label221;
        }
        j = 0;
        localOp = this.mHead;
        if (localOp == null) {
          break label713;
        }
        if (localTransitionState == null) {
          break label230;
        }
        k = 0;
        label127:
        if (localTransitionState == null) {
          break label240;
        }
      }
      label221:
      label230:
      label240:
      for (int m = 0;; m = localOp.exitAnim) {
        switch (localOp.cmd)
        {
        default: 
          throw new IllegalArgumentException("Unknown cmd: " + localOp.cmd);
          i = this.mTransitionStyle;
          break label102;
          j = this.mTransition;
          break label109;
          k = localOp.enterAnim;
          break label127;
        }
      }
      Fragment localFragment9 = localOp.fragment;
      localFragment9.mNextAnim = k;
      this.mManager.addFragment(localFragment9, false);
      for (;;)
      {
        localOp = localOp.next;
        break;
        Fragment localFragment6 = localOp.fragment;
        Fragment localFragment7;
        if (this.mManager.mAdded != null)
        {
          int n = 0;
          localFragment7 = localFragment6;
          if (n < this.mManager.mAdded.size())
          {
            Fragment localFragment8 = (Fragment)this.mManager.mAdded.get(n);
            if (FragmentManagerImpl.DEBUG) {
              new StringBuilder().append("OP_REPLACE: adding=").append(localFragment7).append(" old=").append(localFragment8).toString();
            }
            if ((localFragment7 == null) || (localFragment8.mContainerId == localFragment7.mContainerId))
            {
              if (localFragment8 != localFragment7) {
                break label419;
              }
              localOp.fragment = null;
              localFragment7 = null;
            }
            for (;;)
            {
              n++;
              break;
              label419:
              if (localOp.removed == null) {
                localOp.removed = new ArrayList();
              }
              localOp.removed.add(localFragment8);
              localFragment8.mNextAnim = m;
              if (this.mAddToBackStack)
              {
                localFragment8.mBackStackNesting = (1 + localFragment8.mBackStackNesting);
                if (FragmentManagerImpl.DEBUG) {
                  new StringBuilder().append("Bump nesting of ").append(localFragment8).append(" to ").append(localFragment8.mBackStackNesting).toString();
                }
              }
              this.mManager.removeFragment(localFragment8, j, i);
            }
          }
        }
        else
        {
          localFragment7 = localFragment6;
        }
        if (localFragment7 != null)
        {
          localFragment7.mNextAnim = k;
          this.mManager.addFragment(localFragment7, false);
          continue;
          Fragment localFragment5 = localOp.fragment;
          localFragment5.mNextAnim = m;
          this.mManager.removeFragment(localFragment5, j, i);
          continue;
          Fragment localFragment4 = localOp.fragment;
          localFragment4.mNextAnim = m;
          this.mManager.hideFragment(localFragment4, j, i);
          continue;
          Fragment localFragment3 = localOp.fragment;
          localFragment3.mNextAnim = k;
          this.mManager.showFragment(localFragment3, j, i);
          continue;
          Fragment localFragment2 = localOp.fragment;
          localFragment2.mNextAnim = m;
          this.mManager.detachFragment(localFragment2, j, i);
          continue;
          Fragment localFragment1 = localOp.fragment;
          localFragment1.mNextAnim = k;
          this.mManager.attachFragment(localFragment1, j, i);
        }
      }
      label713:
      this.mManager.moveToState(this.mManager.mCurState, j, i, true);
      if (this.mAddToBackStack) {
        this.mManager.addBackStackState(this);
      }
      return;
    }
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(int paramInt)
  {
    this.mBreadCrumbShortTitleRes = paramInt;
    this.mBreadCrumbShortTitleText = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(CharSequence paramCharSequence)
  {
    this.mBreadCrumbShortTitleRes = 0;
    this.mBreadCrumbShortTitleText = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(int paramInt)
  {
    this.mBreadCrumbTitleRes = paramInt;
    this.mBreadCrumbTitleText = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(CharSequence paramCharSequence)
  {
    this.mBreadCrumbTitleRes = 0;
    this.mBreadCrumbTitleText = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2)
  {
    return setCustomAnimations(paramInt1, paramInt2, 0, 0);
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mEnterAnim = paramInt1;
    this.mExitAnim = paramInt2;
    this.mPopEnterAnim = paramInt3;
    this.mPopExitAnim = paramInt4;
    return this;
  }
  
  public FragmentTransaction setTransition(int paramInt)
  {
    this.mTransition = paramInt;
    return this;
  }
  
  public FragmentTransaction setTransitionStyle(int paramInt)
  {
    this.mTransitionStyle = paramInt;
    return this;
  }
  
  public FragmentTransaction show(Fragment paramFragment)
  {
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    localOp.cmd = 5;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.mIndex >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.mIndex);
    }
    if (this.mName != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.mName);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.BackStackRecord
 * JD-Core Version:    0.7.0.1
 */