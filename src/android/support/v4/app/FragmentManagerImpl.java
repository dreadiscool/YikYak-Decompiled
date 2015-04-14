package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class FragmentManagerImpl
  extends FragmentManager
  implements LayoutInflater.Factory
{
  static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5F);
  static final Interpolator ACCELERATE_QUINT;
  static final int ANIM_DUR = 220;
  public static final int ANIM_STYLE_CLOSE_ENTER = 3;
  public static final int ANIM_STYLE_CLOSE_EXIT = 4;
  public static final int ANIM_STYLE_FADE_ENTER = 5;
  public static final int ANIM_STYLE_FADE_EXIT = 6;
  public static final int ANIM_STYLE_OPEN_ENTER = 1;
  public static final int ANIM_STYLE_OPEN_EXIT = 2;
  static boolean DEBUG = false;
  static final Interpolator DECELERATE_CUBIC;
  static final Interpolator DECELERATE_QUINT;
  static final boolean HONEYCOMB = false;
  static final String TAG = "FragmentManager";
  static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
  static final String TARGET_STATE_TAG = "android:target_state";
  static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
  static final String VIEW_STATE_TAG = "android:view_state";
  ArrayList<Fragment> mActive;
  FragmentActivity mActivity;
  ArrayList<Fragment> mAdded;
  ArrayList<Integer> mAvailBackStackIndices;
  ArrayList<Integer> mAvailIndices;
  ArrayList<BackStackRecord> mBackStack;
  ArrayList<FragmentManager.OnBackStackChangedListener> mBackStackChangeListeners;
  ArrayList<BackStackRecord> mBackStackIndices;
  FragmentContainer mContainer;
  ArrayList<Fragment> mCreatedMenus;
  int mCurState = 0;
  boolean mDestroyed;
  Runnable mExecCommit = new FragmentManagerImpl.1(this);
  boolean mExecutingActions;
  boolean mHavePendingDeferredStart;
  boolean mNeedMenuInvalidate;
  String mNoTransactionsBecause;
  Fragment mParent;
  ArrayList<Runnable> mPendingActions;
  SparseArray<Parcelable> mStateArray = null;
  Bundle mStateBundle = null;
  boolean mStateSaved;
  Runnable[] mTmpActions;
  
  static
  {
    boolean bool = false;
    DEBUG = false;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    }
    HONEYCOMB = bool;
    DECELERATE_QUINT = new DecelerateInterpolator(2.5F);
    DECELERATE_CUBIC = new DecelerateInterpolator(1.5F);
    ACCELERATE_QUINT = new AccelerateInterpolator(2.5F);
  }
  
  private void checkStateLoss()
  {
    if (this.mStateSaved) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
    if (this.mNoTransactionsBecause != null) {
      throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
    }
  }
  
  static Animation makeFadeAnimation(Context paramContext, float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setInterpolator(DECELERATE_CUBIC);
    localAlphaAnimation.setDuration(220L);
    return localAlphaAnimation;
  }
  
  static Animation makeOpenCloseAnimation(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setInterpolator(DECELERATE_QUINT);
    localScaleAnimation.setDuration(220L);
    localAnimationSet.addAnimation(localScaleAnimation);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat3, paramFloat4);
    localAlphaAnimation.setInterpolator(DECELERATE_CUBIC);
    localAlphaAnimation.setDuration(220L);
    localAnimationSet.addAnimation(localAlphaAnimation);
    return localAnimationSet;
  }
  
  public static int reverseTransit(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return i;
      i = 8194;
      continue;
      i = 4097;
      continue;
      i = 4099;
    }
  }
  
  private void throwException(RuntimeException paramRuntimeException)
  {
    paramRuntimeException.getMessage();
    PrintWriter localPrintWriter = new PrintWriter(new LogWriter("FragmentManager"));
    if (this.mActivity != null) {}
    try
    {
      this.mActivity.dump("  ", null, localPrintWriter, new String[0]);
      for (;;)
      {
        label44:
        throw paramRuntimeException;
        try
        {
          dump("  ", null, localPrintWriter, new String[0]);
        }
        catch (Exception localException1) {}
      }
    }
    catch (Exception localException2)
    {
      break label44;
    }
  }
  
  public static int transitToStyleIndex(int paramInt, boolean paramBoolean)
  {
    int i = -1;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return i;
      if (paramBoolean)
      {
        i = 1;
      }
      else
      {
        i = 2;
        continue;
        if (paramBoolean)
        {
          i = 3;
        }
        else
        {
          i = 4;
          continue;
          if (paramBoolean) {
            i = 5;
          } else {
            i = 6;
          }
        }
      }
    }
  }
  
  void addBackStackState(BackStackRecord paramBackStackRecord)
  {
    if (this.mBackStack == null) {
      this.mBackStack = new ArrayList();
    }
    this.mBackStack.add(paramBackStackRecord);
    reportBackStackChanged();
  }
  
  public void addFragment(Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mAdded == null) {
      this.mAdded = new ArrayList();
    }
    if (DEBUG) {
      new StringBuilder().append("add: ").append(paramFragment).toString();
    }
    makeActive(paramFragment);
    if (!paramFragment.mDetached)
    {
      if (this.mAdded.contains(paramFragment)) {
        throw new IllegalStateException("Fragment already added: " + paramFragment);
      }
      this.mAdded.add(paramFragment);
      paramFragment.mAdded = true;
      paramFragment.mRemoving = false;
      if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      if (paramBoolean) {
        moveToState(paramFragment);
      }
    }
  }
  
  public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (this.mBackStackChangeListeners == null) {
      this.mBackStackChangeListeners = new ArrayList();
    }
    this.mBackStackChangeListeners.add(paramOnBackStackChangedListener);
  }
  
  public int allocBackStackIndex(BackStackRecord paramBackStackRecord)
  {
    int i;
    try
    {
      if ((this.mAvailBackStackIndices == null) || (this.mAvailBackStackIndices.size() <= 0))
      {
        if (this.mBackStackIndices == null) {
          this.mBackStackIndices = new ArrayList();
        }
        i = this.mBackStackIndices.size();
        if (DEBUG) {
          new StringBuilder().append("Setting back stack index ").append(i).append(" to ").append(paramBackStackRecord).toString();
        }
        this.mBackStackIndices.add(paramBackStackRecord);
      }
      else
      {
        i = ((Integer)this.mAvailBackStackIndices.remove(-1 + this.mAvailBackStackIndices.size())).intValue();
        if (DEBUG) {
          new StringBuilder().append("Adding back stack index ").append(i).append(" with ").append(paramBackStackRecord).toString();
        }
        this.mBackStackIndices.set(i, paramBackStackRecord);
      }
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
    return i;
  }
  
  public void attachActivity(FragmentActivity paramFragmentActivity, FragmentContainer paramFragmentContainer, Fragment paramFragment)
  {
    if (this.mActivity != null) {
      throw new IllegalStateException("Already attached");
    }
    this.mActivity = paramFragmentActivity;
    this.mContainer = paramFragmentContainer;
    this.mParent = paramFragment;
  }
  
  public void attachFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      new StringBuilder().append("attach: ").append(paramFragment).toString();
    }
    if (paramFragment.mDetached)
    {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded)
      {
        if (this.mAdded == null) {
          this.mAdded = new ArrayList();
        }
        if (this.mAdded.contains(paramFragment)) {
          throw new IllegalStateException("Fragment already added: " + paramFragment);
        }
        if (DEBUG) {
          new StringBuilder().append("add from attach: ").append(paramFragment).toString();
        }
        this.mAdded.add(paramFragment);
        paramFragment.mAdded = true;
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.mNeedMenuInvalidate = true;
        }
        moveToState(paramFragment, this.mCurState, paramInt1, paramInt2, false);
      }
    }
  }
  
  public FragmentTransaction beginTransaction()
  {
    return new BackStackRecord(this);
  }
  
  public void detachFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      new StringBuilder().append("detach: ").append(paramFragment).toString();
    }
    if (!paramFragment.mDetached)
    {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded)
      {
        if (this.mAdded != null)
        {
          if (DEBUG) {
            new StringBuilder().append("remove from detach: ").append(paramFragment).toString();
          }
          this.mAdded.remove(paramFragment);
        }
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.mNeedMenuInvalidate = true;
        }
        paramFragment.mAdded = false;
        moveToState(paramFragment, 1, paramInt1, paramInt2, false);
      }
    }
  }
  
  public void dispatchActivityCreated()
  {
    this.mStateSaved = false;
    moveToState(2, false);
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.mAdded != null) {
      for (int i = 0; i < this.mAdded.size(); i++)
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if (localFragment != null) {
          localFragment.performConfigurationChanged(paramConfiguration);
        }
      }
    }
  }
  
  public boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = false;
    if (this.mAdded != null) {}
    for (int i = 0;; i++) {
      if (i < this.mAdded.size())
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem))) {
          bool = true;
        }
      }
      else
      {
        return bool;
      }
    }
  }
  
  public void dispatchCreate()
  {
    this.mStateSaved = false;
    moveToState(1, false);
  }
  
  public boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int i = 0;
    ArrayList localArrayList = null;
    if (this.mAdded != null)
    {
      int j = 0;
      boolean bool2;
      for (bool1 = false; j < this.mAdded.size(); bool1 = bool2)
      {
        Fragment localFragment2 = (Fragment)this.mAdded.get(j);
        if ((localFragment2 != null) && (localFragment2.performCreateOptionsMenu(paramMenu, paramMenuInflater)))
        {
          bool1 = true;
          if (localArrayList == null) {
            localArrayList = new ArrayList();
          }
          localArrayList.add(localFragment2);
        }
        bool2 = bool1;
        j++;
      }
    }
    boolean bool1 = false;
    if (this.mCreatedMenus != null) {
      while (i < this.mCreatedMenus.size())
      {
        Fragment localFragment1 = (Fragment)this.mCreatedMenus.get(i);
        if ((localArrayList == null) || (!localArrayList.contains(localFragment1))) {
          localFragment1.onDestroyOptionsMenu();
        }
        i++;
      }
    }
    this.mCreatedMenus = localArrayList;
    return bool1;
  }
  
  public void dispatchDestroy()
  {
    this.mDestroyed = true;
    execPendingActions();
    moveToState(0, false);
    this.mActivity = null;
    this.mContainer = null;
    this.mParent = null;
  }
  
  public void dispatchDestroyView()
  {
    moveToState(1, false);
  }
  
  public void dispatchLowMemory()
  {
    if (this.mAdded != null) {
      for (int i = 0; i < this.mAdded.size(); i++)
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if (localFragment != null) {
          localFragment.performLowMemory();
        }
      }
    }
  }
  
  public boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = false;
    if (this.mAdded != null) {}
    for (int i = 0;; i++) {
      if (i < this.mAdded.size())
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem))) {
          bool = true;
        }
      }
      else
      {
        return bool;
      }
    }
  }
  
  public void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    if (this.mAdded != null) {
      for (int i = 0; i < this.mAdded.size(); i++)
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if (localFragment != null) {
          localFragment.performOptionsMenuClosed(paramMenu);
        }
      }
    }
  }
  
  public void dispatchPause()
  {
    moveToState(4, false);
  }
  
  public boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.mAdded != null)
    {
      int i = 0;
      bool = false;
      while (i < this.mAdded.size())
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if ((localFragment != null) && (localFragment.performPrepareOptionsMenu(paramMenu))) {
          bool = true;
        }
        i++;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public void dispatchReallyStop()
  {
    moveToState(2, false);
  }
  
  public void dispatchResume()
  {
    this.mStateSaved = false;
    moveToState(5, false);
  }
  
  public void dispatchStart()
  {
    this.mStateSaved = false;
    moveToState(4, false);
  }
  
  public void dispatchStop()
  {
    this.mStateSaved = true;
    moveToState(3, false);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i = 0;
    String str = paramString + "    ";
    if (this.mActive != null)
    {
      int i6 = this.mActive.size();
      if (i6 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        for (int i7 = 0; i7 < i6; i7++)
        {
          Fragment localFragment3 = (Fragment)this.mActive.get(i7);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i7);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment3);
          if (localFragment3 != null) {
            localFragment3.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          }
        }
      }
    }
    if (this.mAdded != null)
    {
      int i4 = this.mAdded.size();
      if (i4 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Added Fragments:");
        for (int i5 = 0; i5 < i4; i5++)
        {
          Fragment localFragment2 = (Fragment)this.mAdded.get(i5);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i5);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment2.toString());
        }
      }
    }
    if (this.mCreatedMenus != null)
    {
      int i2 = this.mCreatedMenus.size();
      if (i2 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        for (int i3 = 0; i3 < i2; i3++)
        {
          Fragment localFragment1 = (Fragment)this.mCreatedMenus.get(i3);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i3);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment1.toString());
        }
      }
    }
    if (this.mBackStack != null)
    {
      int n = this.mBackStack.size();
      if (n > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        for (int i1 = 0; i1 < n; i1++)
        {
          BackStackRecord localBackStackRecord2 = (BackStackRecord)this.mBackStack.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localBackStackRecord2.toString());
          localBackStackRecord2.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
      }
    }
    try
    {
      if (this.mBackStackIndices != null)
      {
        int k = this.mBackStackIndices.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          for (int m = 0; m < k; m++)
          {
            BackStackRecord localBackStackRecord1 = (BackStackRecord)this.mBackStackIndices.get(m);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(m);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(localBackStackRecord1);
          }
        }
      }
      if ((this.mAvailBackStackIndices != null) && (this.mAvailBackStackIndices.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
      }
      if (this.mPendingActions != null)
      {
        int j = this.mPendingActions.size();
        if (j > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          while (i < j)
          {
            Runnable localRunnable = (Runnable)this.mPendingActions.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(localRunnable);
            i++;
          }
        }
      }
      paramPrintWriter.print(paramString);
    }
    finally {}
    paramPrintWriter.println("FragmentManager misc state:");
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mActivity=");
    paramPrintWriter.println(this.mActivity);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mContainer=");
    paramPrintWriter.println(this.mContainer);
    if (this.mParent != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mParent=");
      paramPrintWriter.println(this.mParent);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mCurState=");
    paramPrintWriter.print(this.mCurState);
    paramPrintWriter.print(" mStateSaved=");
    paramPrintWriter.print(this.mStateSaved);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(this.mDestroyed);
    if (this.mNeedMenuInvalidate)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNeedMenuInvalidate=");
      paramPrintWriter.println(this.mNeedMenuInvalidate);
    }
    if (this.mNoTransactionsBecause != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNoTransactionsBecause=");
      paramPrintWriter.println(this.mNoTransactionsBecause);
    }
    if ((this.mAvailIndices != null) && (this.mAvailIndices.size() > 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mAvailIndices: ");
      paramPrintWriter.println(Arrays.toString(this.mAvailIndices.toArray()));
    }
  }
  
  /* Error */
  public void enqueueAction(Runnable paramRunnable, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifne +7 -> 8
    //   4: aload_0
    //   5: invokespecial 495	android/support/v4/app/FragmentManagerImpl:checkStateLoss	()V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 374	android/support/v4/app/FragmentManagerImpl:mDestroyed	Z
    //   14: ifne +10 -> 24
    //   17: aload_0
    //   18: getfield 210	android/support/v4/app/FragmentManagerImpl:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   21: ifnonnull +19 -> 40
    //   24: new 133	java/lang/IllegalStateException
    //   27: dup
    //   28: ldc_w 497
    //   31: invokespecial 138	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   34: athrow
    //   35: astore_3
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_3
    //   39: athrow
    //   40: aload_0
    //   41: getfield 461	android/support/v4/app/FragmentManagerImpl:mPendingActions	Ljava/util/ArrayList;
    //   44: ifnonnull +14 -> 58
    //   47: aload_0
    //   48: new 229	java/util/ArrayList
    //   51: dup
    //   52: invokespecial 230	java/util/ArrayList:<init>	()V
    //   55: putfield 461	android/support/v4/app/FragmentManagerImpl:mPendingActions	Ljava/util/ArrayList;
    //   58: aload_0
    //   59: getfield 461	android/support/v4/app/FragmentManagerImpl:mPendingActions	Ljava/util/ArrayList;
    //   62: aload_1
    //   63: invokevirtual 234	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   66: pop
    //   67: aload_0
    //   68: getfield 461	android/support/v4/app/FragmentManagerImpl:mPendingActions	Ljava/util/ArrayList;
    //   71: invokevirtual 288	java/util/ArrayList:size	()I
    //   74: iconst_1
    //   75: if_icmpne +32 -> 107
    //   78: aload_0
    //   79: getfield 210	android/support/v4/app/FragmentManagerImpl:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   82: getfield 501	android/support/v4/app/FragmentActivity:mHandler	Landroid/os/Handler;
    //   85: aload_0
    //   86: getfield 128	android/support/v4/app/FragmentManagerImpl:mExecCommit	Ljava/lang/Runnable;
    //   89: invokevirtual 507	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   92: aload_0
    //   93: getfield 210	android/support/v4/app/FragmentManagerImpl:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   96: getfield 501	android/support/v4/app/FragmentActivity:mHandler	Landroid/os/Handler;
    //   99: aload_0
    //   100: getfield 128	android/support/v4/app/FragmentManagerImpl:mExecCommit	Ljava/lang/Runnable;
    //   103: invokevirtual 511	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   106: pop
    //   107: aload_0
    //   108: monitorexit
    //   109: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	FragmentManagerImpl
    //   0	110	1	paramRunnable	Runnable
    //   0	110	2	paramBoolean	boolean
    //   35	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	38	35	finally
    //   40	109	35	finally
  }
  
  public boolean execPendingActions()
  {
    if (this.mExecutingActions) {
      throw new IllegalStateException("Recursive entry to executePendingTransactions");
    }
    if (Looper.myLooper() != this.mActivity.mHandler.getLooper()) {
      throw new IllegalStateException("Must be called from main thread of process");
    }
    boolean bool2;
    for (boolean bool1 = false;; bool1 = true) {
      try
      {
        if ((this.mPendingActions == null) || (this.mPendingActions.size() == 0))
        {
          if (!this.mHavePendingDeferredStart) {
            return bool1;
          }
          int i = 0;
          bool2 = false;
          while (i < this.mActive.size())
          {
            Fragment localFragment = (Fragment)this.mActive.get(i);
            if ((localFragment != null) && (localFragment.mLoaderManager != null)) {
              bool2 |= localFragment.mLoaderManager.hasRunningLoaders();
            }
            i++;
          }
        }
        int j = this.mPendingActions.size();
        if ((this.mTmpActions == null) || (this.mTmpActions.length < j)) {
          this.mTmpActions = new Runnable[j];
        }
        this.mPendingActions.toArray(this.mTmpActions);
        this.mPendingActions.clear();
        this.mActivity.mHandler.removeCallbacks(this.mExecCommit);
        this.mExecutingActions = true;
        for (int k = 0; k < j; k++)
        {
          this.mTmpActions[k].run();
          this.mTmpActions[k] = null;
        }
        this.mExecutingActions = false;
      }
      finally {}
    }
    if (!bool2)
    {
      this.mHavePendingDeferredStart = false;
      startPendingDeferredFragments();
    }
    return bool1;
  }
  
  public boolean executePendingTransactions()
  {
    return execPendingActions();
  }
  
  public Fragment findFragmentById(int paramInt)
  {
    int j;
    Fragment localFragment;
    if (this.mAdded != null)
    {
      j = -1 + this.mAdded.size();
      if (j >= 0)
      {
        localFragment = (Fragment)this.mAdded.get(j);
        if ((localFragment == null) || (localFragment.mFragmentId != paramInt)) {}
      }
    }
    for (;;)
    {
      return localFragment;
      j--;
      break;
      if (this.mActive != null) {
        for (int i = -1 + this.mActive.size();; i--)
        {
          if (i < 0) {
            break label109;
          }
          localFragment = (Fragment)this.mActive.get(i);
          if ((localFragment != null) && (localFragment.mFragmentId == paramInt)) {
            break;
          }
        }
      }
      label109:
      localFragment = null;
    }
  }
  
  public Fragment findFragmentByTag(String paramString)
  {
    int j;
    Fragment localFragment;
    if ((this.mAdded != null) && (paramString != null))
    {
      j = -1 + this.mAdded.size();
      if (j >= 0)
      {
        localFragment = (Fragment)this.mAdded.get(j);
        if ((localFragment == null) || (!paramString.equals(localFragment.mTag))) {}
      }
    }
    for (;;)
    {
      return localFragment;
      j--;
      break;
      if ((this.mActive != null) && (paramString != null)) {
        for (int i = -1 + this.mActive.size();; i--)
        {
          if (i < 0) {
            break label123;
          }
          localFragment = (Fragment)this.mActive.get(i);
          if ((localFragment != null) && (paramString.equals(localFragment.mTag))) {
            break;
          }
        }
      }
      label123:
      localFragment = null;
    }
  }
  
  public Fragment findFragmentByWho(String paramString)
  {
    int i;
    Fragment localFragment1;
    if ((this.mActive != null) && (paramString != null))
    {
      i = -1 + this.mActive.size();
      if (i >= 0)
      {
        Fragment localFragment2 = (Fragment)this.mActive.get(i);
        if (localFragment2 != null)
        {
          localFragment1 = localFragment2.findFragmentByWho(paramString);
          if (localFragment1 == null) {}
        }
      }
    }
    for (;;)
    {
      return localFragment1;
      i--;
      break;
      localFragment1 = null;
    }
  }
  
  public void freeBackStackIndex(int paramInt)
  {
    try
    {
      this.mBackStackIndices.set(paramInt, null);
      if (this.mAvailBackStackIndices == null) {
        this.mAvailBackStackIndices = new ArrayList();
      }
      if (DEBUG) {
        new StringBuilder().append("Freeing back stack index ").append(paramInt).toString();
      }
      this.mAvailBackStackIndices.add(Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public FragmentManager.BackStackEntry getBackStackEntryAt(int paramInt)
  {
    return (FragmentManager.BackStackEntry)this.mBackStack.get(paramInt);
  }
  
  public int getBackStackEntryCount()
  {
    if (this.mBackStack != null) {}
    for (int i = this.mBackStack.size();; i = 0) {
      return i;
    }
  }
  
  public Fragment getFragment(Bundle paramBundle, String paramString)
  {
    int i = paramBundle.getInt(paramString, -1);
    Fragment localFragment;
    if (i == -1) {
      localFragment = null;
    }
    for (;;)
    {
      return localFragment;
      if (i >= this.mActive.size()) {
        throwException(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i));
      }
      localFragment = (Fragment)this.mActive.get(i);
      if (localFragment == null) {
        throwException(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i));
      }
    }
  }
  
  public List<Fragment> getFragments()
  {
    return this.mActive;
  }
  
  LayoutInflater.Factory getLayoutInflaterFactory()
  {
    return this;
  }
  
  public void hideFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      new StringBuilder().append("hide: ").append(paramFragment).toString();
    }
    if (!paramFragment.mHidden)
    {
      paramFragment.mHidden = true;
      if (paramFragment.mView != null)
      {
        Animation localAnimation = loadAnimation(paramFragment, paramInt1, false, paramInt2);
        if (localAnimation != null) {
          paramFragment.mView.startAnimation(localAnimation);
        }
        paramFragment.mView.setVisibility(8);
      }
      if ((paramFragment.mAdded) && (paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.onHiddenChanged(true);
    }
  }
  
  public boolean isDestroyed()
  {
    return this.mDestroyed;
  }
  
  Animation loadAnimation(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Animation localAnimation = paramFragment.onCreateAnimation(paramInt1, paramBoolean, paramFragment.mNextAnim);
    if (localAnimation != null) {}
    for (;;)
    {
      return localAnimation;
      if (paramFragment.mNextAnim != 0)
      {
        localAnimation = AnimationUtils.loadAnimation(this.mActivity, paramFragment.mNextAnim);
        if (localAnimation != null) {}
      }
      else if (paramInt1 == 0)
      {
        localAnimation = null;
      }
      else
      {
        int i = transitToStyleIndex(paramInt1, paramBoolean);
        if (i < 0) {
          localAnimation = null;
        } else {
          switch (i)
          {
          default: 
            if ((paramInt2 == 0) && (this.mActivity.getWindow() != null)) {
              paramInt2 = this.mActivity.getWindow().getAttributes().windowAnimations;
            }
            if (paramInt2 == 0) {
              localAnimation = null;
            }
            break;
          case 1: 
            localAnimation = makeOpenCloseAnimation(this.mActivity, 1.125F, 1.0F, 0.0F, 1.0F);
            break;
          case 2: 
            localAnimation = makeOpenCloseAnimation(this.mActivity, 1.0F, 0.975F, 1.0F, 0.0F);
            break;
          case 3: 
            localAnimation = makeOpenCloseAnimation(this.mActivity, 0.975F, 1.0F, 0.0F, 1.0F);
            break;
          case 4: 
            localAnimation = makeOpenCloseAnimation(this.mActivity, 1.0F, 1.075F, 1.0F, 0.0F);
            break;
          case 5: 
            localAnimation = makeFadeAnimation(this.mActivity, 0.0F, 1.0F);
            break;
          case 6: 
            localAnimation = makeFadeAnimation(this.mActivity, 1.0F, 0.0F);
            continue;
            localAnimation = null;
          }
        }
      }
    }
  }
  
  void makeActive(Fragment paramFragment)
  {
    if (paramFragment.mIndex >= 0) {}
    label142:
    for (;;)
    {
      return;
      if ((this.mAvailIndices == null) || (this.mAvailIndices.size() <= 0))
      {
        if (this.mActive == null) {
          this.mActive = new ArrayList();
        }
        paramFragment.setIndex(this.mActive.size(), this.mParent);
        this.mActive.add(paramFragment);
      }
      for (;;)
      {
        if (!DEBUG) {
          break label142;
        }
        new StringBuilder().append("Allocated fragment index ").append(paramFragment).toString();
        break;
        paramFragment.setIndex(((Integer)this.mAvailIndices.remove(-1 + this.mAvailIndices.size())).intValue(), this.mParent);
        this.mActive.set(paramFragment.mIndex, paramFragment);
      }
    }
  }
  
  void makeInactive(Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0) {}
    for (;;)
    {
      return;
      if (DEBUG) {
        new StringBuilder().append("Freeing fragment index ").append(paramFragment).toString();
      }
      this.mActive.set(paramFragment.mIndex, null);
      if (this.mAvailIndices == null) {
        this.mAvailIndices = new ArrayList();
      }
      this.mAvailIndices.add(Integer.valueOf(paramFragment.mIndex));
      this.mActivity.invalidateSupportFragment(paramFragment.mWho);
      paramFragment.initState();
    }
  }
  
  void moveToState(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((this.mActivity == null) && (paramInt1 != 0)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (this.mCurState == paramInt1)) {}
    do
    {
      return;
      this.mCurState = paramInt1;
    } while (this.mActive == null);
    int i = 0;
    boolean bool1 = false;
    label54:
    Fragment localFragment;
    if (i < this.mActive.size())
    {
      localFragment = (Fragment)this.mActive.get(i);
      if (localFragment == null) {
        break label172;
      }
      moveToState(localFragment, paramInt1, paramInt2, paramInt3, false);
      if (localFragment.mLoaderManager == null) {
        break label172;
      }
    }
    label172:
    for (boolean bool2 = bool1 | localFragment.mLoaderManager.hasRunningLoaders();; bool2 = bool1)
    {
      i++;
      bool1 = bool2;
      break label54;
      if (!bool1) {
        startPendingDeferredFragments();
      }
      if ((!this.mNeedMenuInvalidate) || (this.mActivity == null) || (this.mCurState != 5)) {
        break;
      }
      this.mActivity.supportInvalidateOptionsMenu();
      this.mNeedMenuInvalidate = false;
      break;
    }
  }
  
  void moveToState(int paramInt, boolean paramBoolean)
  {
    moveToState(paramInt, 0, 0, paramBoolean);
  }
  
  void moveToState(Fragment paramFragment)
  {
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  void moveToState(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (((!paramFragment.mAdded) || (paramFragment.mDetached)) && (paramInt1 > 1)) {
      paramInt1 = 1;
    }
    if ((paramFragment.mRemoving) && (paramInt1 > paramFragment.mState)) {
      paramInt1 = paramFragment.mState;
    }
    if ((paramFragment.mDeferStart) && (paramFragment.mState < 4) && (paramInt1 > 3)) {
      paramInt1 = 3;
    }
    label506:
    ViewGroup localViewGroup;
    if (paramFragment.mState < paramInt1)
    {
      if ((paramFragment.mFromLayout) && (!paramFragment.mInLayout)) {}
      for (;;)
      {
        return;
        if (paramFragment.mAnimatingAway != null)
        {
          paramFragment.mAnimatingAway = null;
          moveToState(paramFragment, paramFragment.mStateAfterAnimating, 0, 0, true);
        }
        switch (paramFragment.mState)
        {
        default: 
          paramFragment.mState = paramInt1;
        }
      }
      if (DEBUG) {
        new StringBuilder().append("moveto CREATED: ").append(paramFragment).toString();
      }
      if (paramFragment.mSavedFragmentState != null)
      {
        paramFragment.mSavedFragmentState.setClassLoader(this.mActivity.getClassLoader());
        paramFragment.mSavedViewState = paramFragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        paramFragment.mTarget = getFragment(paramFragment.mSavedFragmentState, "android:target_state");
        if (paramFragment.mTarget != null) {
          paramFragment.mTargetRequestCode = paramFragment.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        paramFragment.mUserVisibleHint = paramFragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        if (!paramFragment.mUserVisibleHint)
        {
          paramFragment.mDeferStart = true;
          if (paramInt1 > 3) {
            paramInt1 = 3;
          }
        }
      }
      paramFragment.mActivity = this.mActivity;
      paramFragment.mParentFragment = this.mParent;
      if (this.mParent != null) {}
      for (FragmentManagerImpl localFragmentManagerImpl = this.mParent.mChildFragmentManager;; localFragmentManagerImpl = this.mActivity.mFragments)
      {
        paramFragment.mFragmentManager = localFragmentManagerImpl;
        paramFragment.mCalled = false;
        paramFragment.onAttach(this.mActivity);
        if (paramFragment.mCalled) {
          break;
        }
        throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onAttach()");
      }
      if (paramFragment.mParentFragment == null) {
        this.mActivity.onAttachFragment(paramFragment);
      }
      if (!paramFragment.mRetaining) {
        paramFragment.performCreate(paramFragment.mSavedFragmentState);
      }
      paramFragment.mRetaining = false;
      if (paramFragment.mFromLayout)
      {
        paramFragment.mView = paramFragment.performCreateView(paramFragment.getLayoutInflater(paramFragment.mSavedFragmentState), null, paramFragment.mSavedFragmentState);
        if (paramFragment.mView != null)
        {
          paramFragment.mInnerView = paramFragment.mView;
          paramFragment.mView = NoSaveStateFrameLayout.wrap(paramFragment.mView);
          if (paramFragment.mHidden) {
            paramFragment.mView.setVisibility(8);
          }
          paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
        }
      }
      else if (paramInt1 > 1)
      {
        if (DEBUG) {
          new StringBuilder().append("moveto ACTIVITY_CREATED: ").append(paramFragment).toString();
        }
        if (!paramFragment.mFromLayout)
        {
          if (paramFragment.mContainerId == 0) {
            break label1431;
          }
          localViewGroup = (ViewGroup)this.mContainer.findViewById(paramFragment.mContainerId);
          if ((localViewGroup == null) && (!paramFragment.mRestored)) {
            throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(paramFragment.mContainerId) + " (" + paramFragment.getResources().getResourceName(paramFragment.mContainerId) + ") for fragment " + paramFragment));
          }
        }
      }
    }
    for (;;)
    {
      paramFragment.mContainer = localViewGroup;
      paramFragment.mView = paramFragment.performCreateView(paramFragment.getLayoutInflater(paramFragment.mSavedFragmentState), localViewGroup, paramFragment.mSavedFragmentState);
      if (paramFragment.mView != null)
      {
        paramFragment.mInnerView = paramFragment.mView;
        paramFragment.mView = NoSaveStateFrameLayout.wrap(paramFragment.mView);
        if (localViewGroup != null)
        {
          Animation localAnimation2 = loadAnimation(paramFragment, paramInt2, true, paramInt3);
          if (localAnimation2 != null) {
            paramFragment.mView.startAnimation(localAnimation2);
          }
          localViewGroup.addView(paramFragment.mView);
        }
        if (paramFragment.mHidden) {
          paramFragment.mView.setVisibility(8);
        }
        paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
      }
      for (;;)
      {
        paramFragment.performActivityCreated(paramFragment.mSavedFragmentState);
        if (paramFragment.mView != null) {
          paramFragment.restoreViewState(paramFragment.mSavedFragmentState);
        }
        paramFragment.mSavedFragmentState = null;
        if (paramInt1 > 3)
        {
          if (DEBUG) {
            new StringBuilder().append("moveto STARTED: ").append(paramFragment).toString();
          }
          paramFragment.performStart();
        }
        if (paramInt1 <= 4) {
          break;
        }
        if (DEBUG) {
          new StringBuilder().append("moveto RESUMED: ").append(paramFragment).toString();
        }
        paramFragment.mResumed = true;
        paramFragment.performResume();
        paramFragment.mSavedFragmentState = null;
        paramFragment.mSavedViewState = null;
        break;
        paramFragment.mInnerView = null;
        break label506;
        paramFragment.mInnerView = null;
      }
      if (paramFragment.mState <= paramInt1) {
        break;
      }
      switch (paramFragment.mState)
      {
      default: 
        break;
      case 1: 
      case 5: 
      case 4: 
      case 3: 
      case 2: 
        label955:
        do
        {
          if (paramInt1 >= 1) {
            break;
          }
          if ((this.mDestroyed) && (paramFragment.mAnimatingAway != null))
          {
            View localView = paramFragment.mAnimatingAway;
            paramFragment.mAnimatingAway = null;
            localView.clearAnimation();
          }
          if (paramFragment.mAnimatingAway == null) {
            break label1294;
          }
          paramFragment.mStateAfterAnimating = paramInt1;
          paramInt1 = 1;
          break;
          if (paramInt1 < 5)
          {
            if (DEBUG) {
              new StringBuilder().append("movefrom RESUMED: ").append(paramFragment).toString();
            }
            paramFragment.performPause();
            paramFragment.mResumed = false;
          }
          if (paramInt1 < 4)
          {
            if (DEBUG) {
              new StringBuilder().append("movefrom STARTED: ").append(paramFragment).toString();
            }
            paramFragment.performStop();
          }
          if (paramInt1 < 3)
          {
            if (DEBUG) {
              new StringBuilder().append("movefrom STOPPED: ").append(paramFragment).toString();
            }
            paramFragment.performReallyStop();
          }
        } while (paramInt1 >= 2);
        if (DEBUG) {
          new StringBuilder().append("movefrom ACTIVITY_CREATED: ").append(paramFragment).toString();
        }
        if ((paramFragment.mView != null) && (!this.mActivity.isFinishing()) && (paramFragment.mSavedViewState == null)) {
          saveFragmentViewState(paramFragment);
        }
        paramFragment.performDestroyView();
        if ((paramFragment.mView != null) && (paramFragment.mContainer != null)) {
          if ((this.mCurState <= 0) || (this.mDestroyed)) {
            break label1425;
          }
        }
        label1294:
        label1425:
        for (Animation localAnimation1 = loadAnimation(paramFragment, paramInt2, false, paramInt3);; localAnimation1 = null)
        {
          if (localAnimation1 != null)
          {
            paramFragment.mAnimatingAway = paramFragment.mView;
            paramFragment.mStateAfterAnimating = paramInt1;
            localAnimation1.setAnimationListener(new FragmentManagerImpl.5(this, paramFragment));
            paramFragment.mView.startAnimation(localAnimation1);
          }
          paramFragment.mContainer.removeView(paramFragment.mView);
          paramFragment.mContainer = null;
          paramFragment.mView = null;
          paramFragment.mInnerView = null;
          break label955;
          if (DEBUG) {
            new StringBuilder().append("movefrom CREATED: ").append(paramFragment).toString();
          }
          if (!paramFragment.mRetaining) {
            paramFragment.performDestroy();
          }
          paramFragment.mCalled = false;
          paramFragment.onDetach();
          if (!paramFragment.mCalled) {
            throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onDetach()");
          }
          if (paramBoolean) {
            break;
          }
          if (!paramFragment.mRetaining)
          {
            makeInactive(paramFragment);
            break;
          }
          paramFragment.mActivity = null;
          paramFragment.mParentFragment = null;
          paramFragment.mFragmentManager = null;
          paramFragment.mChildFragmentManager = null;
          break;
        }
        label1431:
        localViewGroup = null;
      }
    }
  }
  
  public void noteStateNotSaved()
  {
    this.mStateSaved = false;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView;
    if (!"fragment".equals(paramString))
    {
      localView = null;
      return localView;
    }
    String str1 = paramAttributeSet.getAttributeValue(null, "class");
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, FragmentManagerImpl.FragmentTag.Fragment);
    if (str1 == null) {}
    for (String str2 = localTypedArray.getString(0);; str2 = str1)
    {
      int i = localTypedArray.getResourceId(1, -1);
      String str3 = localTypedArray.getString(2);
      localTypedArray.recycle();
      if (!Fragment.isSupportFragmentClass(this.mActivity, str2))
      {
        localView = null;
        break;
      }
      if (0 != 0) {}
      for (int j = null.getId(); (j == -1) && (i == -1) && (str3 == null); j = 0) {
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
      }
      Fragment localFragment1;
      int k;
      label299:
      Fragment localFragment2;
      if (i != -1)
      {
        localFragment1 = findFragmentById(i);
        if ((localFragment1 == null) && (str3 != null)) {
          localFragment1 = findFragmentByTag(str3);
        }
        if ((localFragment1 == null) && (j != -1)) {
          localFragment1 = findFragmentById(j);
        }
        if (DEBUG) {
          new StringBuilder().append("onCreateView: id=0x").append(Integer.toHexString(i)).append(" fname=").append(str2).append(" existing=").append(localFragment1).toString();
        }
        if (localFragment1 != null) {
          break label440;
        }
        Fragment localFragment3 = Fragment.instantiate(paramContext, str2);
        localFragment3.mFromLayout = true;
        if (i == 0) {
          break label433;
        }
        k = i;
        localFragment3.mFragmentId = k;
        localFragment3.mContainerId = j;
        localFragment3.mTag = str3;
        localFragment3.mInLayout = true;
        localFragment3.mFragmentManager = this;
        localFragment3.onInflate(this.mActivity, paramAttributeSet, localFragment3.mSavedFragmentState);
        addFragment(localFragment3, true);
        localFragment2 = localFragment3;
        label358:
        if ((this.mCurState >= 1) || (!localFragment2.mFromLayout)) {
          break label561;
        }
        moveToState(localFragment2, 1, 0, 0, false);
      }
      for (;;)
      {
        if (localFragment2.mView != null) {
          break label570;
        }
        throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
        localFragment1 = null;
        break;
        label433:
        k = j;
        break label299;
        label440:
        if (localFragment1.mInLayout) {
          throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(i) + ", tag " + str3 + ", or parent id 0x" + Integer.toHexString(j) + " with another fragment for " + str2);
        }
        localFragment1.mInLayout = true;
        if (!localFragment1.mRetaining) {
          localFragment1.onInflate(this.mActivity, paramAttributeSet, localFragment1.mSavedFragmentState);
        }
        localFragment2 = localFragment1;
        break label358;
        label561:
        moveToState(localFragment2);
      }
      label570:
      if (i != 0) {
        localFragment2.mView.setId(i);
      }
      if (localFragment2.mView.getTag() == null) {
        localFragment2.mView.setTag(str3);
      }
      localView = localFragment2.mView;
      break;
    }
  }
  
  public void performPendingDeferredStart(Fragment paramFragment)
  {
    if (paramFragment.mDeferStart)
    {
      if (!this.mExecutingActions) {
        break label20;
      }
      this.mHavePendingDeferredStart = true;
    }
    for (;;)
    {
      return;
      label20:
      paramFragment.mDeferStart = false;
      moveToState(paramFragment, this.mCurState, 0, 0, false);
    }
  }
  
  public void popBackStack()
  {
    enqueueAction(new FragmentManagerImpl.2(this), false);
  }
  
  public void popBackStack(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt1);
    }
    enqueueAction(new FragmentManagerImpl.4(this, paramInt1, paramInt2), false);
  }
  
  public void popBackStack(String paramString, int paramInt)
  {
    enqueueAction(new FragmentManagerImpl.3(this, paramString, paramInt), false);
  }
  
  public boolean popBackStackImmediate()
  {
    checkStateLoss();
    executePendingTransactions();
    return popBackStackState(this.mActivity.mHandler, null, -1, 0);
  }
  
  public boolean popBackStackImmediate(int paramInt1, int paramInt2)
  {
    checkStateLoss();
    executePendingTransactions();
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt1);
    }
    return popBackStackState(this.mActivity.mHandler, null, paramInt1, paramInt2);
  }
  
  public boolean popBackStackImmediate(String paramString, int paramInt)
  {
    checkStateLoss();
    executePendingTransactions();
    return popBackStackState(this.mActivity.mHandler, paramString, -1, paramInt);
  }
  
  boolean popBackStackState(Handler paramHandler, String paramString, int paramInt1, int paramInt2)
  {
    boolean bool1 = false;
    if (this.mBackStack == null) {
      break label167;
    }
    label10:
    int i2;
    do
    {
      return bool1;
      if ((paramString != null) || (paramInt1 >= 0) || ((paramInt2 & 0x1) != 0)) {
        break;
      }
      i2 = -1 + this.mBackStack.size();
    } while (i2 < 0);
    BackStackRecord localBackStackRecord4 = (BackStackRecord)this.mBackStack.remove(i2);
    SparseArray localSparseArray3 = new SparseArray();
    SparseArray localSparseArray4 = new SparseArray();
    localBackStackRecord4.calculateBackFragments(localSparseArray3, localSparseArray4);
    localBackStackRecord4.popFromBackStack(true, null, localSparseArray3, localSparseArray4);
    reportBackStackChanged();
    for (;;)
    {
      bool1 = true;
      break label10;
      int i = -1;
      if ((paramString != null) || (paramInt1 >= 0))
      {
        for (int j = -1 + this.mBackStack.size();; j--)
        {
          BackStackRecord localBackStackRecord3;
          if (j >= 0)
          {
            localBackStackRecord3 = (BackStackRecord)this.mBackStack.get(j);
            if ((paramString == null) || (!paramString.equals(localBackStackRecord3.getName()))) {}
          }
          else
          {
            label167:
            if (j < 0) {
              break label10;
            }
            if ((paramInt2 & 0x1) == 0) {
              break label255;
            }
            j--;
            while (j >= 0)
            {
              BackStackRecord localBackStackRecord2 = (BackStackRecord)this.mBackStack.get(j);
              if (((paramString == null) || (!paramString.equals(localBackStackRecord2.getName()))) && ((paramInt1 < 0) || (paramInt1 != localBackStackRecord2.mIndex))) {
                break;
              }
              j--;
            }
          }
          if ((paramInt1 >= 0) && (paramInt1 == localBackStackRecord3.mIndex)) {
            break;
          }
        }
        label255:
        i = j;
      }
      if (i == -1 + this.mBackStack.size()) {
        break label10;
      }
      ArrayList localArrayList = new ArrayList();
      for (int k = -1 + this.mBackStack.size(); k > i; k--) {
        localArrayList.add(this.mBackStack.remove(k));
      }
      int m = -1 + localArrayList.size();
      SparseArray localSparseArray1 = new SparseArray();
      SparseArray localSparseArray2 = new SparseArray();
      for (int n = 0; n <= m; n++) {
        ((BackStackRecord)localArrayList.get(n)).calculateBackFragments(localSparseArray1, localSparseArray2);
      }
      Object localObject = null;
      int i1 = 0;
      if (i1 <= m)
      {
        if (DEBUG) {
          new StringBuilder().append("Popping back stack state: ").append(localArrayList.get(i1)).toString();
        }
        BackStackRecord localBackStackRecord1 = (BackStackRecord)localArrayList.get(i1);
        if (i1 == m) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          BackStackRecord.TransitionState localTransitionState = localBackStackRecord1.popFromBackStack(bool2, (BackStackRecord.TransitionState)localObject, localSparseArray1, localSparseArray2);
          i1++;
          localObject = localTransitionState;
          break;
        }
      }
      reportBackStackChanged();
    }
  }
  
  public void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    paramBundle.putInt(paramString, paramFragment.mIndex);
  }
  
  public void removeFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      new StringBuilder().append("remove: ").append(paramFragment).append(" nesting=").append(paramFragment.mBackStackNesting).toString();
    }
    int i;
    if (!paramFragment.isInBackStack())
    {
      i = 1;
      if ((!paramFragment.mDetached) || (i != 0))
      {
        if (this.mAdded != null) {
          this.mAdded.remove(paramFragment);
        }
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.mNeedMenuInvalidate = true;
        }
        paramFragment.mAdded = false;
        paramFragment.mRemoving = true;
        if (i == 0) {
          break label132;
        }
      }
    }
    label132:
    for (int j = 0;; j = 1)
    {
      moveToState(paramFragment, j, paramInt1, paramInt2, false);
      return;
      i = 0;
      break;
    }
  }
  
  public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (this.mBackStackChangeListeners != null) {
      this.mBackStackChangeListeners.remove(paramOnBackStackChangedListener);
    }
  }
  
  void reportBackStackChanged()
  {
    if (this.mBackStackChangeListeners != null) {
      for (int i = 0; i < this.mBackStackChangeListeners.size(); i++) {
        ((FragmentManager.OnBackStackChangedListener)this.mBackStackChangeListeners.get(i)).onBackStackChanged();
      }
    }
  }
  
  void restoreAllState(Parcelable paramParcelable, ArrayList<Fragment> paramArrayList)
  {
    if (paramParcelable == null) {}
    for (;;)
    {
      return;
      FragmentManagerState localFragmentManagerState = (FragmentManagerState)paramParcelable;
      if (localFragmentManagerState.mActive != null)
      {
        if (paramArrayList != null) {
          for (int n = 0; n < paramArrayList.size(); n++)
          {
            Fragment localFragment4 = (Fragment)paramArrayList.get(n);
            if (DEBUG) {
              new StringBuilder().append("restoreAllState: re-attaching retained ").append(localFragment4).toString();
            }
            FragmentState localFragmentState2 = localFragmentManagerState.mActive[localFragment4.mIndex];
            localFragmentState2.mInstance = localFragment4;
            localFragment4.mSavedViewState = null;
            localFragment4.mBackStackNesting = 0;
            localFragment4.mInLayout = false;
            localFragment4.mAdded = false;
            localFragment4.mTarget = null;
            if (localFragmentState2.mSavedFragmentState != null)
            {
              localFragmentState2.mSavedFragmentState.setClassLoader(this.mActivity.getClassLoader());
              localFragment4.mSavedViewState = localFragmentState2.mSavedFragmentState.getSparseParcelableArray("android:view_state");
              localFragment4.mSavedFragmentState = localFragmentState2.mSavedFragmentState;
            }
          }
        }
        this.mActive = new ArrayList(localFragmentManagerState.mActive.length);
        if (this.mAvailIndices != null) {
          this.mAvailIndices.clear();
        }
        int i = 0;
        if (i < localFragmentManagerState.mActive.length)
        {
          FragmentState localFragmentState1 = localFragmentManagerState.mActive[i];
          if (localFragmentState1 != null)
          {
            Fragment localFragment3 = localFragmentState1.instantiate(this.mActivity, this.mParent);
            if (DEBUG) {
              new StringBuilder().append("restoreAllState: active #").append(i).append(": ").append(localFragment3).toString();
            }
            this.mActive.add(localFragment3);
            localFragmentState1.mInstance = null;
          }
          for (;;)
          {
            i++;
            break;
            this.mActive.add(null);
            if (this.mAvailIndices == null) {
              this.mAvailIndices = new ArrayList();
            }
            if (DEBUG) {
              new StringBuilder().append("restoreAllState: avail #").append(i).toString();
            }
            this.mAvailIndices.add(Integer.valueOf(i));
          }
        }
        if (paramArrayList != null)
        {
          int m = 0;
          if (m < paramArrayList.size())
          {
            Fragment localFragment2 = (Fragment)paramArrayList.get(m);
            if (localFragment2.mTargetIndex >= 0) {
              if (localFragment2.mTargetIndex >= this.mActive.size()) {
                break label455;
              }
            }
            for (localFragment2.mTarget = ((Fragment)this.mActive.get(localFragment2.mTargetIndex));; localFragment2.mTarget = null)
            {
              m++;
              break;
              label455:
              new StringBuilder().append("Re-attaching retained fragment ").append(localFragment2).append(" target no longer exists: ").append(localFragment2.mTargetIndex).toString();
            }
          }
        }
        if (localFragmentManagerState.mAdded != null)
        {
          this.mAdded = new ArrayList(localFragmentManagerState.mAdded.length);
          for (int k = 0; k < localFragmentManagerState.mAdded.length; k++)
          {
            Fragment localFragment1 = (Fragment)this.mActive.get(localFragmentManagerState.mAdded[k]);
            if (localFragment1 == null) {
              throwException(new IllegalStateException("No instantiated fragment for index #" + localFragmentManagerState.mAdded[k]));
            }
            localFragment1.mAdded = true;
            if (DEBUG) {
              new StringBuilder().append("restoreAllState: added #").append(k).append(": ").append(localFragment1).toString();
            }
            if (this.mAdded.contains(localFragment1)) {
              throw new IllegalStateException("Already added!");
            }
            this.mAdded.add(localFragment1);
          }
        }
        this.mAdded = null;
        if (localFragmentManagerState.mBackStack != null)
        {
          this.mBackStack = new ArrayList(localFragmentManagerState.mBackStack.length);
          for (int j = 0; j < localFragmentManagerState.mBackStack.length; j++)
          {
            BackStackRecord localBackStackRecord = localFragmentManagerState.mBackStack[j].instantiate(this);
            if (DEBUG)
            {
              new StringBuilder().append("restoreAllState: back stack #").append(j).append(" (index ").append(localBackStackRecord.mIndex).append("): ").append(localBackStackRecord).toString();
              localBackStackRecord.dump("  ", new PrintWriter(new LogWriter("FragmentManager")), false);
            }
            this.mBackStack.add(localBackStackRecord);
            if (localBackStackRecord.mIndex >= 0) {
              setBackStackIndex(localBackStackRecord.mIndex, localBackStackRecord);
            }
          }
        }
        else
        {
          this.mBackStack = null;
        }
      }
    }
  }
  
  ArrayList<Fragment> retainNonConfig()
  {
    ArrayList localArrayList = null;
    if (this.mActive != null)
    {
      int i = 0;
      if (i < this.mActive.size())
      {
        Fragment localFragment = (Fragment)this.mActive.get(i);
        if ((localFragment != null) && (localFragment.mRetainInstance))
        {
          if (localArrayList == null) {
            localArrayList = new ArrayList();
          }
          localArrayList.add(localFragment);
          localFragment.mRetaining = true;
          if (localFragment.mTarget == null) {
            break label123;
          }
        }
        label123:
        for (int j = localFragment.mTarget.mIndex;; j = -1)
        {
          localFragment.mTargetIndex = j;
          if (DEBUG) {
            new StringBuilder().append("retainNonConfig: keeping retained ").append(localFragment).toString();
          }
          i++;
          break;
        }
      }
    }
    return localArrayList;
  }
  
  Parcelable saveAllState()
  {
    Object localObject = null;
    execPendingActions();
    if (HONEYCOMB) {
      this.mStateSaved = true;
    }
    if ((this.mActive == null) || (this.mActive.size() <= 0)) {
      return localObject;
    }
    int i = this.mActive.size();
    FragmentState[] arrayOfFragmentState = new FragmentState[i];
    int j = 0;
    int k = 0;
    label57:
    Fragment localFragment;
    FragmentState localFragmentState;
    if (j < i)
    {
      localFragment = (Fragment)this.mActive.get(j);
      if (localFragment == null) {
        break label699;
      }
      if (localFragment.mIndex < 0) {
        throwException(new IllegalStateException("Failure saving state: active " + localFragment + " has cleared index: " + localFragment.mIndex));
      }
      localFragmentState = new FragmentState(localFragment);
      arrayOfFragmentState[j] = localFragmentState;
      if ((localFragment.mState > 0) && (localFragmentState.mSavedFragmentState == null))
      {
        localFragmentState.mSavedFragmentState = saveFragmentBasicState(localFragment);
        if (localFragment.mTarget != null)
        {
          if (localFragment.mTarget.mIndex < 0) {
            throwException(new IllegalStateException("Failure saving state: " + localFragment + " has target not in fragment manager: " + localFragment.mTarget));
          }
          if (localFragmentState.mSavedFragmentState == null) {
            localFragmentState.mSavedFragmentState = new Bundle();
          }
          putFragment(localFragmentState.mSavedFragmentState, "android:target_state", localFragment.mTarget);
          if (localFragment.mTargetRequestCode != 0) {
            localFragmentState.mSavedFragmentState.putInt("android:target_req_state", localFragment.mTargetRequestCode);
          }
        }
        label305:
        if (DEBUG) {
          new StringBuilder().append("Saved state of ").append(localFragment).append(": ").append(localFragmentState.mSavedFragmentState).toString();
        }
      }
    }
    label699:
    for (int i3 = 1;; i3 = k)
    {
      j++;
      k = i3;
      break label57;
      localFragmentState.mSavedFragmentState = localFragment.mSavedFragmentState;
      break label305;
      if (k == 0) {
        break;
      }
      if (this.mAdded != null)
      {
        int i1 = this.mAdded.size();
        if (i1 > 0)
        {
          arrayOfInt = new int[i1];
          for (int i2 = 0; i2 < i1; i2++)
          {
            arrayOfInt[i2] = ((Fragment)this.mAdded.get(i2)).mIndex;
            if (arrayOfInt[i2] < 0) {
              throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(i2) + " has cleared index: " + arrayOfInt[i2]));
            }
            if (DEBUG) {
              new StringBuilder().append("saveAllState: adding fragment #").append(i2).append(": ").append(this.mAdded.get(i2)).toString();
            }
          }
        }
      }
      int[] arrayOfInt = null;
      if (this.mBackStack != null)
      {
        int m = this.mBackStack.size();
        if (m > 0)
        {
          localObject = new BackStackState[m];
          for (int n = 0; n < m; n++)
          {
            localObject[n] = new BackStackState(this, (BackStackRecord)this.mBackStack.get(n));
            if (DEBUG) {
              new StringBuilder().append("saveAllState: adding back stack #").append(n).append(": ").append(this.mBackStack.get(n)).toString();
            }
          }
        }
      }
      FragmentManagerState localFragmentManagerState = new FragmentManagerState();
      localFragmentManagerState.mActive = arrayOfFragmentState;
      localFragmentManagerState.mAdded = arrayOfInt;
      localFragmentManagerState.mBackStack = ((BackStackState[])localObject);
      localObject = localFragmentManagerState;
      break;
    }
  }
  
  Bundle saveFragmentBasicState(Fragment paramFragment)
  {
    if (this.mStateBundle == null) {
      this.mStateBundle = new Bundle();
    }
    paramFragment.performSaveInstanceState(this.mStateBundle);
    Bundle localBundle;
    if (!this.mStateBundle.isEmpty())
    {
      localBundle = this.mStateBundle;
      this.mStateBundle = null;
    }
    for (;;)
    {
      if (paramFragment.mView != null) {
        saveFragmentViewState(paramFragment);
      }
      if (paramFragment.mSavedViewState != null)
      {
        if (localBundle == null) {
          localBundle = new Bundle();
        }
        localBundle.putSparseParcelableArray("android:view_state", paramFragment.mSavedViewState);
      }
      if (!paramFragment.mUserVisibleHint)
      {
        if (localBundle == null) {
          localBundle = new Bundle();
        }
        localBundle.putBoolean("android:user_visible_hint", paramFragment.mUserVisibleHint);
      }
      return localBundle;
      localBundle = null;
    }
  }
  
  public Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment)
  {
    Fragment.SavedState localSavedState = null;
    if (paramFragment.mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    if (paramFragment.mState > 0)
    {
      Bundle localBundle = saveFragmentBasicState(paramFragment);
      if (localBundle != null) {
        localSavedState = new Fragment.SavedState(localBundle);
      }
    }
    return localSavedState;
  }
  
  void saveFragmentViewState(Fragment paramFragment)
  {
    if (paramFragment.mInnerView == null) {
      return;
    }
    if (this.mStateArray == null) {
      this.mStateArray = new SparseArray();
    }
    for (;;)
    {
      paramFragment.mInnerView.saveHierarchyState(this.mStateArray);
      if (this.mStateArray.size() <= 0) {
        break;
      }
      paramFragment.mSavedViewState = this.mStateArray;
      this.mStateArray = null;
      break;
      this.mStateArray.clear();
    }
  }
  
  public void setBackStackIndex(int paramInt, BackStackRecord paramBackStackRecord)
  {
    try
    {
      if (this.mBackStackIndices == null) {
        this.mBackStackIndices = new ArrayList();
      }
      int i = this.mBackStackIndices.size();
      if (paramInt < i)
      {
        if (DEBUG) {
          new StringBuilder().append("Setting back stack index ").append(paramInt).append(" to ").append(paramBackStackRecord).toString();
        }
        this.mBackStackIndices.set(paramInt, paramBackStackRecord);
        return;
      }
      while (i < paramInt)
      {
        this.mBackStackIndices.add(null);
        if (this.mAvailBackStackIndices == null) {
          this.mAvailBackStackIndices = new ArrayList();
        }
        if (DEBUG) {
          new StringBuilder().append("Adding available back stack index ").append(i).toString();
        }
        this.mAvailBackStackIndices.add(Integer.valueOf(i));
        i++;
      }
      if (DEBUG) {
        new StringBuilder().append("Adding back stack index ").append(paramInt).append(" with ").append(paramBackStackRecord).toString();
      }
      this.mBackStackIndices.add(paramBackStackRecord);
    }
    finally {}
  }
  
  public void showFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      new StringBuilder().append("show: ").append(paramFragment).toString();
    }
    if (paramFragment.mHidden)
    {
      paramFragment.mHidden = false;
      if (paramFragment.mView != null)
      {
        Animation localAnimation = loadAnimation(paramFragment, paramInt1, true, paramInt2);
        if (localAnimation != null) {
          paramFragment.mView.startAnimation(localAnimation);
        }
        paramFragment.mView.setVisibility(0);
      }
      if ((paramFragment.mAdded) && (paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.onHiddenChanged(false);
    }
  }
  
  void startPendingDeferredFragments()
  {
    if (this.mActive == null) {}
    for (;;)
    {
      return;
      for (int i = 0; i < this.mActive.size(); i++)
      {
        Fragment localFragment = (Fragment)this.mActive.get(i);
        if (localFragment != null) {
          performPendingDeferredStart(localFragment);
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    if (this.mParent != null) {
      DebugUtils.buildShortClassTag(this.mParent, localStringBuilder);
    }
    for (;;)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      DebugUtils.buildShortClassTag(this.mActivity, localStringBuilder);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl
 * JD-Core Version:    0.7.0.1
 */