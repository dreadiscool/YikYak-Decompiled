package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView
  extends ViewGroup
{
  private static final boolean DEBUG = false;
  private static final boolean DISPATCH_TEMP_DETACH = false;
  private static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
  public static final int HORIZONTAL = 0;
  private static final int INVALID_POINTER = -1;
  public static final int INVALID_TYPE = -1;
  private static final int MAX_SCROLL_DURATION = 2000;
  public static final long NO_ID = -1L;
  public static final int NO_POSITION = -1;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  private static final String TAG = "RecyclerView";
  public static final int TOUCH_SLOP_DEFAULT = 0;
  public static final int TOUCH_SLOP_PAGING = 1;
  public static final int VERTICAL = 1;
  private static final Interpolator sQuinticInterpolator;
  private RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
  private final AccessibilityManager mAccessibilityManager;
  private RecyclerView.OnItemTouchListener mActiveOnItemTouchListener;
  private RecyclerView.Adapter mAdapter;
  AdapterHelper mAdapterHelper;
  private boolean mAdapterUpdateDuringMeasure;
  private EdgeEffectCompat mBottomGlow;
  ChildHelper mChildHelper;
  private boolean mClipToPadding;
  private boolean mDataSetHasChangedAfterLayout = false;
  final List<View> mDisappearingViewsInLayoutPass = new ArrayList();
  private boolean mEatRequestLayout;
  private boolean mFirstLayoutComplete;
  private boolean mHasFixedSize;
  private int mInitialTouchX;
  private int mInitialTouchY;
  private boolean mIsAttached;
  RecyclerView.ItemAnimator mItemAnimator = new DefaultItemAnimator();
  private RecyclerView.ItemAnimator.ItemAnimatorListener mItemAnimatorListener = new RecyclerView.ItemAnimatorRestoreListener(this, null);
  private Runnable mItemAnimatorRunner = new RecyclerView.2(this);
  private final ArrayList<RecyclerView.ItemDecoration> mItemDecorations = new ArrayList();
  boolean mItemsAddedOrRemoved = false;
  boolean mItemsChanged = false;
  private int mLastTouchX;
  private int mLastTouchY;
  private RecyclerView.LayoutManager mLayout;
  private boolean mLayoutRequestEaten;
  private EdgeEffectCompat mLeftGlow;
  private final int mMaxFlingVelocity;
  private final int mMinFlingVelocity;
  private final RecyclerView.RecyclerViewDataObserver mObserver = new RecyclerView.RecyclerViewDataObserver(this, null);
  private final ArrayList<RecyclerView.OnItemTouchListener> mOnItemTouchListeners = new ArrayList();
  private RecyclerView.SavedState mPendingSavedState;
  private final boolean mPostUpdatesOnAnimation;
  private boolean mPostedAnimatorRunner = false;
  final RecyclerView.Recycler mRecycler = new RecyclerView.Recycler(this);
  private RecyclerView.RecyclerListener mRecyclerListener;
  private EdgeEffectCompat mRightGlow;
  private boolean mRunningLayoutOrScroll = false;
  private RecyclerView.OnScrollListener mScrollListener;
  private int mScrollPointerId = -1;
  private int mScrollState = 0;
  final RecyclerView.State mState = new RecyclerView.State();
  private final Rect mTempRect = new Rect();
  private EdgeEffectCompat mTopGlow;
  private int mTouchSlop;
  private final Runnable mUpdateChildViewsRunnable = new RecyclerView.1(this);
  private VelocityTracker mVelocityTracker;
  private final RecyclerView.ViewFlinger mViewFlinger = new RecyclerView.ViewFlinger(this);
  
  static
  {
    if ((Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20)) {}
    for (boolean bool = true;; bool = false)
    {
      FORCE_INVALIDATE_DISPLAY_LIST = bool;
      sQuinticInterpolator = new RecyclerView.3();
      return;
    }
  }
  
  public RecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (Build.VERSION.SDK_INT >= 16) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      this.mPostUpdatesOnAnimation = bool2;
      ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
      this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
      this.mMinFlingVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
      this.mMaxFlingVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
      if (ViewCompat.getOverScrollMode(this) == 2) {
        bool1 = true;
      }
      setWillNotDraw(bool1);
      this.mItemAnimator.setListener(this.mItemAnimatorListener);
      initAdapterManager();
      initChildrenHelper();
      if (ViewCompat.getImportantForAccessibility(this) == 0) {
        ViewCompat.setImportantForAccessibility(this, 1);
      }
      this.mAccessibilityManager = ((AccessibilityManager)getContext().getSystemService("accessibility"));
      setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
      return;
    }
  }
  
  private void addAnimatingView(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    int i;
    if (localView.getParent() == this)
    {
      i = 1;
      this.mRecycler.unscrapView(getChildViewHolder(localView));
      if (!paramViewHolder.isTmpDetached()) {
        break label55;
      }
      this.mChildHelper.attachViewToParent(localView, -1, localView.getLayoutParams(), true);
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label55:
      if (i == 0) {
        this.mChildHelper.addView(localView, true);
      } else {
        this.mChildHelper.hide(localView);
      }
    }
  }
  
  private void addToDisappearingList(View paramView)
  {
    if (!this.mDisappearingViewsInLayoutPass.contains(paramView)) {
      this.mDisappearingViewsInLayoutPass.add(paramView);
    }
  }
  
  private void animateAppearance(RecyclerView.ViewHolder paramViewHolder, Rect paramRect, int paramInt1, int paramInt2)
  {
    if ((paramRect != null) && ((paramRect.left != paramInt1) || (paramRect.top != paramInt2)))
    {
      paramViewHolder.setIsRecyclable(false);
      if (this.mItemAnimator.animateMove(paramViewHolder, paramRect.left, paramRect.top, paramInt1, paramInt2)) {
        postAnimationRunner();
      }
    }
    for (;;)
    {
      return;
      paramViewHolder.setIsRecyclable(false);
      if (this.mItemAnimator.animateAdd(paramViewHolder)) {
        postAnimationRunner();
      }
    }
  }
  
  private void animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    paramViewHolder1.setIsRecyclable(false);
    addAnimatingView(paramViewHolder1);
    paramViewHolder1.mShadowedHolder = paramViewHolder2;
    this.mRecycler.unscrapView(paramViewHolder1);
    int i = paramViewHolder1.itemView.getLeft();
    int j = paramViewHolder1.itemView.getTop();
    int k;
    int m;
    if ((paramViewHolder2 == null) || (paramViewHolder2.shouldIgnore()))
    {
      k = j;
      m = i;
    }
    for (;;)
    {
      if (this.mItemAnimator.animateChange(paramViewHolder1, paramViewHolder2, i, j, m, k)) {
        postAnimationRunner();
      }
      return;
      m = paramViewHolder2.itemView.getLeft();
      k = paramViewHolder2.itemView.getTop();
      paramViewHolder2.setIsRecyclable(false);
      paramViewHolder2.mShadowingHolder = paramViewHolder1;
    }
  }
  
  private void animateDisappearance(RecyclerView.ItemHolderInfo paramItemHolderInfo)
  {
    View localView = paramItemHolderInfo.holder.itemView;
    addAnimatingView(paramItemHolderInfo.holder);
    int i = paramItemHolderInfo.left;
    int j = paramItemHolderInfo.top;
    int k = localView.getLeft();
    int m = localView.getTop();
    if ((i != k) || (j != m))
    {
      paramItemHolderInfo.holder.setIsRecyclable(false);
      localView.layout(k, m, k + localView.getWidth(), m + localView.getHeight());
      if (this.mItemAnimator.animateMove(paramItemHolderInfo.holder, i, j, k, m)) {
        postAnimationRunner();
      }
    }
    for (;;)
    {
      return;
      paramItemHolderInfo.holder.setIsRecyclable(false);
      if (this.mItemAnimator.animateRemove(paramItemHolderInfo.holder)) {
        postAnimationRunner();
      }
    }
  }
  
  private void cancelTouch()
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.clear();
    }
    releaseGlows();
    setScrollState(0);
  }
  
  private void considerReleasingGlowsOnScroll(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if ((this.mLeftGlow != null) && (!this.mLeftGlow.isFinished()) && (paramInt1 > 0)) {
      bool = this.mLeftGlow.onRelease();
    }
    if ((this.mRightGlow != null) && (!this.mRightGlow.isFinished()) && (paramInt1 < 0)) {
      bool |= this.mRightGlow.onRelease();
    }
    if ((this.mTopGlow != null) && (!this.mTopGlow.isFinished()) && (paramInt2 > 0)) {
      bool |= this.mTopGlow.onRelease();
    }
    if ((this.mBottomGlow != null) && (!this.mBottomGlow.isFinished()) && (paramInt2 < 0)) {
      bool |= this.mBottomGlow.onRelease();
    }
    if (bool) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void consumePendingUpdateOperations()
  {
    this.mUpdateChildViewsRunnable.run();
  }
  
  private void dispatchChildAttached(View paramView)
  {
    if (this.mAdapter != null) {
      this.mAdapter.onViewAttachedToWindow(getChildViewHolderInt(paramView));
    }
    onChildAttachedToWindow(paramView);
  }
  
  private void dispatchChildDetached(View paramView)
  {
    if (this.mAdapter != null) {
      this.mAdapter.onViewDetachedFromWindow(getChildViewHolderInt(paramView));
    }
    onChildDetachedFromWindow(paramView);
  }
  
  private boolean dispatchOnItemTouch(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int k;
    boolean bool;
    if (this.mActiveOnItemTouchListener != null)
    {
      if (i == 0) {
        this.mActiveOnItemTouchListener = null;
      }
    }
    else
    {
      if (i == 0) {
        break label117;
      }
      int j = this.mOnItemTouchListeners.size();
      k = 0;
      if (k >= j) {
        break label117;
      }
      RecyclerView.OnItemTouchListener localOnItemTouchListener = (RecyclerView.OnItemTouchListener)this.mOnItemTouchListeners.get(k);
      if (!localOnItemTouchListener.onInterceptTouchEvent(this, paramMotionEvent)) {
        break label111;
      }
      this.mActiveOnItemTouchListener = localOnItemTouchListener;
      bool = true;
    }
    for (;;)
    {
      return bool;
      this.mActiveOnItemTouchListener.onTouchEvent(this, paramMotionEvent);
      if ((i == 3) || (i == 1)) {
        this.mActiveOnItemTouchListener = null;
      }
      bool = true;
      continue;
      label111:
      k++;
      break;
      label117:
      bool = false;
    }
  }
  
  private boolean dispatchOnItemTouchIntercept(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 0)) {
      this.mActiveOnItemTouchListener = null;
    }
    int j = this.mOnItemTouchListeners.size();
    int k = 0;
    if (k < j)
    {
      RecyclerView.OnItemTouchListener localOnItemTouchListener = (RecyclerView.OnItemTouchListener)this.mOnItemTouchListeners.get(k);
      if ((localOnItemTouchListener.onInterceptTouchEvent(this, paramMotionEvent)) && (i != 3)) {
        this.mActiveOnItemTouchListener = localOnItemTouchListener;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      k++;
      break;
    }
  }
  
  static RecyclerView.ViewHolder getChildViewHolderInt(View paramView)
  {
    if (paramView == null) {}
    for (RecyclerView.ViewHolder localViewHolder = null;; localViewHolder = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mViewHolder) {
      return localViewHolder;
    }
  }
  
  private void initChildrenHelper()
  {
    this.mChildHelper = new ChildHelper(new RecyclerView.4(this));
  }
  
  private void onPointerUp(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i) == this.mScrollPointerId) {
      if (i != 0) {
        break label81;
      }
    }
    label81:
    for (int j = 1;; j = 0)
    {
      this.mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, j);
      int k = (int)(0.5F + MotionEventCompat.getX(paramMotionEvent, j));
      this.mLastTouchX = k;
      this.mInitialTouchX = k;
      int m = (int)(0.5F + MotionEventCompat.getY(paramMotionEvent, j));
      this.mLastTouchY = m;
      this.mInitialTouchY = m;
      return;
    }
  }
  
  private void postAnimationRunner()
  {
    if ((!this.mPostedAnimatorRunner) && (this.mIsAttached))
    {
      ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
      this.mPostedAnimatorRunner = true;
    }
  }
  
  private boolean predictiveItemAnimationsEnabled()
  {
    if ((this.mItemAnimator != null) && (this.mLayout.supportsPredictiveItemAnimations())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void processAdapterUpdatesAndSetAnimationFlags()
  {
    boolean bool1 = true;
    if (this.mDataSetHasChangedAfterLayout)
    {
      this.mAdapterHelper.reset();
      markKnownViewsInvalid();
      this.mLayout.onItemsChanged(this);
    }
    boolean bool2;
    label89:
    boolean bool3;
    label149:
    RecyclerView.State localState2;
    if ((this.mItemAnimator != null) && (this.mLayout.supportsPredictiveItemAnimations()))
    {
      this.mAdapterHelper.preProcess();
      if (((!this.mItemsAddedOrRemoved) || (this.mItemsChanged)) && (!this.mItemsAddedOrRemoved) && ((!this.mItemsChanged) || (!supportsChangeAnimations()))) {
        break label208;
      }
      bool2 = bool1;
      RecyclerView.State localState1 = this.mState;
      if ((!this.mFirstLayoutComplete) || (this.mItemAnimator == null) || ((!this.mDataSetHasChangedAfterLayout) && (!bool2) && (!RecyclerView.LayoutManager.access$1700(this.mLayout))) || ((this.mDataSetHasChangedAfterLayout) && (!this.mAdapter.hasStableIds()))) {
        break label213;
      }
      bool3 = bool1;
      RecyclerView.State.access$1602(localState1, bool3);
      localState2 = this.mState;
      if ((!RecyclerView.State.access$1600(this.mState)) || (!bool2) || (this.mDataSetHasChangedAfterLayout) || (!predictiveItemAnimationsEnabled())) {
        break label219;
      }
    }
    for (;;)
    {
      RecyclerView.State.access$1402(localState2, bool1);
      return;
      this.mAdapterHelper.consumeUpdatesInOnePass();
      break;
      label208:
      bool2 = false;
      break label89;
      label213:
      bool3 = false;
      break label149;
      label219:
      bool1 = false;
    }
  }
  
  private void processDisappearingList(ArrayMap<View, Rect> paramArrayMap)
  {
    int i = this.mDisappearingViewsInLayoutPass.size();
    int j = 0;
    if (j < i)
    {
      View localView = (View)this.mDisappearingViewsInLayoutPass.get(j);
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(localView);
      RecyclerView.ItemHolderInfo localItemHolderInfo = (RecyclerView.ItemHolderInfo)this.mState.mPreLayoutHolderMap.remove(localViewHolder);
      if (!this.mState.isPreLayout()) {
        this.mState.mPostLayoutHolderMap.remove(localViewHolder);
      }
      if (paramArrayMap.remove(localView) != null) {
        this.mLayout.removeAndRecycleView(localView, this.mRecycler);
      }
      for (;;)
      {
        j++;
        break;
        if (localItemHolderInfo != null) {
          animateDisappearance(localItemHolderInfo);
        } else {
          animateDisappearance(new RecyclerView.ItemHolderInfo(localViewHolder, localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
        }
      }
    }
    this.mDisappearingViewsInLayoutPass.clear();
  }
  
  private void pullGlows(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      ensureLeftGlow();
      this.mLeftGlow.onPull(-paramInt1 / getWidth());
      if (paramInt2 >= 0) {
        break label90;
      }
      ensureTopGlow();
      this.mTopGlow.onPull(-paramInt2 / getHeight());
    }
    for (;;)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return;
      if (paramInt1 <= 0) {
        break;
      }
      ensureRightGlow();
      this.mRightGlow.onPull(paramInt1 / getWidth());
      break;
      label90:
      if (paramInt2 > 0)
      {
        ensureBottomGlow();
        this.mBottomGlow.onPull(paramInt2 / getHeight());
      }
    }
  }
  
  private void releaseGlows()
  {
    boolean bool = false;
    if (this.mLeftGlow != null) {
      bool = this.mLeftGlow.onRelease();
    }
    if (this.mTopGlow != null) {
      bool |= this.mTopGlow.onRelease();
    }
    if (this.mRightGlow != null) {
      bool |= this.mRightGlow.onRelease();
    }
    if (this.mBottomGlow != null) {
      bool |= this.mBottomGlow.onRelease();
    }
    if (bool) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private boolean removeAnimatingView(View paramView)
  {
    eatRequestLayout();
    boolean bool = this.mChildHelper.removeViewIfHidden(paramView);
    if (bool)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(paramView);
      this.mRecycler.unscrapView(localViewHolder);
      this.mRecycler.recycleViewHolderInternal(localViewHolder);
    }
    resumeRequestLayout(false);
    return bool;
  }
  
  private void removeFromDisappearingList(View paramView)
  {
    this.mDisappearingViewsInLayoutPass.remove(paramView);
  }
  
  private void setAdapterInternal(RecyclerView.Adapter paramAdapter, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.unregisterAdapterDataObserver(this.mObserver);
      this.mAdapter.onDetachedFromRecyclerView(this);
    }
    if ((!paramBoolean1) || (paramBoolean2))
    {
      if (this.mItemAnimator != null) {
        this.mItemAnimator.endAnimations();
      }
      if (this.mLayout != null)
      {
        this.mLayout.removeAndRecycleAllViews(this.mRecycler);
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
      }
    }
    this.mAdapterHelper.reset();
    RecyclerView.Adapter localAdapter = this.mAdapter;
    this.mAdapter = paramAdapter;
    if (paramAdapter != null)
    {
      paramAdapter.registerAdapterDataObserver(this.mObserver);
      paramAdapter.onAttachedToRecyclerView(this);
    }
    if (this.mLayout != null) {
      this.mLayout.onAdapterChanged(localAdapter, this.mAdapter);
    }
    this.mRecycler.onAdapterChanged(localAdapter, this.mAdapter, paramBoolean1);
    RecyclerView.State.access$1202(this.mState, true);
    markKnownViewsInvalid();
  }
  
  private void setScrollState(int paramInt)
  {
    if (paramInt == this.mScrollState) {}
    for (;;)
    {
      return;
      this.mScrollState = paramInt;
      if (paramInt != 2) {
        stopScrollersInternal();
      }
      if (this.mScrollListener != null) {
        this.mScrollListener.onScrollStateChanged(this, paramInt);
      }
      this.mLayout.onScrollStateChanged(paramInt);
    }
  }
  
  private void stopScrollersInternal()
  {
    this.mViewFlinger.stop();
    this.mLayout.stopSmoothScroller();
  }
  
  private boolean supportsChangeAnimations()
  {
    if ((this.mItemAnimator != null) && (this.mItemAnimator.getSupportsChangeAnimations())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void absorbGlows(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      ensureLeftGlow();
      this.mLeftGlow.onAbsorb(-paramInt1);
      if (paramInt2 >= 0) {
        break label69;
      }
      ensureTopGlow();
      this.mTopGlow.onAbsorb(-paramInt2);
    }
    for (;;)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return;
      if (paramInt1 <= 0) {
        break;
      }
      ensureRightGlow();
      this.mRightGlow.onAbsorb(paramInt1);
      break;
      label69:
      if (paramInt2 > 0)
      {
        ensureBottomGlow();
        this.mBottomGlow.onAbsorb(paramInt2);
      }
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if (!this.mLayout.onAddFocusables(this, paramArrayList, paramInt1, paramInt2)) {
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
    }
  }
  
  public void addItemDecoration(RecyclerView.ItemDecoration paramItemDecoration)
  {
    addItemDecoration(paramItemDecoration, -1);
  }
  
  public void addItemDecoration(RecyclerView.ItemDecoration paramItemDecoration, int paramInt)
  {
    if (this.mLayout != null) {
      this.mLayout.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
    }
    if (this.mItemDecorations.isEmpty()) {
      setWillNotDraw(false);
    }
    if (paramInt < 0) {
      this.mItemDecorations.add(paramItemDecoration);
    }
    for (;;)
    {
      markItemDecorInsetsDirty();
      requestLayout();
      return;
      this.mItemDecorations.add(paramInt, paramItemDecoration);
    }
  }
  
  public void addOnItemTouchListener(RecyclerView.OnItemTouchListener paramOnItemTouchListener)
  {
    this.mOnItemTouchListeners.add(paramOnItemTouchListener);
  }
  
  void assertInLayoutOrScroll(String paramString)
  {
    if (!this.mRunningLayoutOrScroll)
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling");
      }
      throw new IllegalStateException(paramString);
    }
  }
  
  void assertNotInLayoutOrScroll(String paramString)
  {
    if (this.mRunningLayoutOrScroll)
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
      }
      throw new IllegalStateException(paramString);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (((paramLayoutParams instanceof RecyclerView.LayoutParams)) && (this.mLayout.checkLayoutParams((RecyclerView.LayoutParams)paramLayoutParams))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void clearOldPositions()
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if (!localViewHolder.shouldIgnore()) {
        localViewHolder.clearOldPosition();
      }
    }
    this.mRecycler.clearOldPositions();
  }
  
  protected int computeHorizontalScrollExtent()
  {
    if (this.mLayout.canScrollHorizontally()) {}
    for (int i = this.mLayout.computeHorizontalScrollExtent(this.mState);; i = 0) {
      return i;
    }
  }
  
  protected int computeHorizontalScrollOffset()
  {
    if (this.mLayout.canScrollHorizontally()) {}
    for (int i = this.mLayout.computeHorizontalScrollOffset(this.mState);; i = 0) {
      return i;
    }
  }
  
  protected int computeHorizontalScrollRange()
  {
    if (this.mLayout.canScrollHorizontally()) {}
    for (int i = this.mLayout.computeHorizontalScrollRange(this.mState);; i = 0) {
      return i;
    }
  }
  
  protected int computeVerticalScrollExtent()
  {
    if (this.mLayout.canScrollVertically()) {}
    for (int i = this.mLayout.computeVerticalScrollExtent(this.mState);; i = 0) {
      return i;
    }
  }
  
  protected int computeVerticalScrollOffset()
  {
    if (this.mLayout.canScrollVertically()) {}
    for (int i = this.mLayout.computeVerticalScrollOffset(this.mState);; i = 0) {
      return i;
    }
  }
  
  protected int computeVerticalScrollRange()
  {
    if (this.mLayout.canScrollVertically()) {}
    for (int i = this.mLayout.computeVerticalScrollRange(this.mState);; i = 0) {
      return i;
    }
  }
  
  void dispatchLayout()
  {
    if (this.mAdapter == null) {
      return;
    }
    this.mDisappearingViewsInLayoutPass.clear();
    eatRequestLayout();
    this.mRunningLayoutOrScroll = true;
    processAdapterUpdatesAndSetAnimationFlags();
    RecyclerView.State localState1 = this.mState;
    ArrayMap localArrayMap1;
    int i13;
    label153:
    RecyclerView.ViewHolder localViewHolder8;
    if ((RecyclerView.State.access$1600(this.mState)) && (this.mItemsChanged) && (supportsChangeAnimations()))
    {
      localArrayMap1 = new ArrayMap();
      localState1.mOldChangedHolders = localArrayMap1;
      this.mItemsChanged = false;
      this.mItemsAddedOrRemoved = false;
      RecyclerView.State.access$1502(this.mState, RecyclerView.State.access$1400(this.mState));
      this.mState.mItemCount = this.mAdapter.getItemCount();
      if (!RecyclerView.State.access$1600(this.mState)) {
        break label263;
      }
      this.mState.mPreLayoutHolderMap.clear();
      this.mState.mPostLayoutHolderMap.clear();
      int i12 = this.mChildHelper.getChildCount();
      i13 = 0;
      if (i13 >= i12) {
        break label263;
      }
      localViewHolder8 = getChildViewHolderInt(this.mChildHelper.getChildAt(i13));
      if ((!localViewHolder8.shouldIgnore()) && ((!localViewHolder8.isInvalid()) || (this.mAdapter.hasStableIds()))) {
        break label211;
      }
    }
    for (;;)
    {
      i13++;
      break label153;
      localArrayMap1 = null;
      break;
      label211:
      View localView3 = localViewHolder8.itemView;
      this.mState.mPreLayoutHolderMap.put(localViewHolder8, new RecyclerView.ItemHolderInfo(localViewHolder8, localView3.getLeft(), localView3.getTop(), localView3.getRight(), localView3.getBottom()));
    }
    label263:
    ArrayMap localArrayMap4;
    int i7;
    label444:
    View localView2;
    if (RecyclerView.State.access$1400(this.mState))
    {
      saveOldPositions();
      if (this.mState.mOldChangedHolders != null)
      {
        int i10 = this.mChildHelper.getChildCount();
        for (int i11 = 0; i11 < i10; i11++)
        {
          RecyclerView.ViewHolder localViewHolder7 = getChildViewHolderInt(this.mChildHelper.getChildAt(i11));
          if ((localViewHolder7.isChanged()) && (!localViewHolder7.isRemoved()) && (!localViewHolder7.shouldIgnore()))
          {
            long l4 = getChangedHolderKey(localViewHolder7);
            this.mState.mOldChangedHolders.put(Long.valueOf(l4), localViewHolder7);
            this.mState.mPreLayoutHolderMap.remove(localViewHolder7);
          }
        }
      }
      boolean bool2 = RecyclerView.State.access$1200(this.mState);
      RecyclerView.State.access$1202(this.mState, false);
      this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
      RecyclerView.State.access$1202(this.mState, bool2);
      localArrayMap4 = new ArrayMap();
      i7 = 0;
      if (i7 < this.mChildHelper.getChildCount())
      {
        localView2 = this.mChildHelper.getChildAt(i7);
        if (!getChildViewHolderInt(localView2).shouldIgnore()) {}
      }
    }
    label898:
    label1447:
    for (;;)
    {
      label478:
      i7++;
      break label444;
      int i8 = 0;
      label487:
      if (i8 < this.mState.mPreLayoutHolderMap.size()) {
        if (((RecyclerView.ViewHolder)this.mState.mPreLayoutHolderMap.keyAt(i8)).itemView != localView2) {}
      }
      label716:
      label728:
      label997:
      label1512:
      for (int i9 = 1;; i9 = 0)
      {
        if (i9 != 0) {
          break label1668;
        }
        localArrayMap4.put(localView2, new Rect(localView2.getLeft(), localView2.getTop(), localView2.getRight(), localView2.getBottom()));
        break label478;
        i8++;
        break label487;
        clearOldPositions();
        this.mAdapterHelper.consumePostponedUpdates();
        label1256:
        label1658:
        for (ArrayMap localArrayMap2 = localArrayMap4;; localArrayMap2 = null)
        {
          this.mState.mItemCount = this.mAdapter.getItemCount();
          RecyclerView.State.access$1002(this.mState, 0);
          RecyclerView.State.access$1502(this.mState, false);
          this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
          RecyclerView.State.access$1202(this.mState, false);
          this.mPendingSavedState = null;
          RecyclerView.State localState2 = this.mState;
          boolean bool1;
          ArrayMap localArrayMap3;
          int j;
          RecyclerView.ViewHolder localViewHolder5;
          if ((RecyclerView.State.access$1600(this.mState)) && (this.mItemAnimator != null))
          {
            bool1 = true;
            RecyclerView.State.access$1602(localState2, bool1);
            if (!RecyclerView.State.access$1600(this.mState)) {
              break label1559;
            }
            if (this.mState.mOldChangedHolders == null) {
              break label892;
            }
            localArrayMap3 = new ArrayMap();
            int i = this.mChildHelper.getChildCount();
            j = 0;
            if (j >= i) {
              break label997;
            }
            localViewHolder5 = getChildViewHolderInt(this.mChildHelper.getChildAt(j));
            if (!localViewHolder5.shouldIgnore()) {
              break label898;
            }
          }
          for (;;)
          {
            j++;
            break label728;
            clearOldPositions();
            this.mAdapterHelper.consumeUpdatesInOnePass();
            if (this.mState.mOldChangedHolders == null) {
              break label1658;
            }
            int i5 = this.mChildHelper.getChildCount();
            for (int i6 = 0; i6 < i5; i6++)
            {
              RecyclerView.ViewHolder localViewHolder6 = getChildViewHolderInt(this.mChildHelper.getChildAt(i6));
              if ((localViewHolder6.isChanged()) && (!localViewHolder6.isRemoved()) && (!localViewHolder6.shouldIgnore()))
              {
                long l3 = getChangedHolderKey(localViewHolder6);
                this.mState.mOldChangedHolders.put(Long.valueOf(l3), localViewHolder6);
                this.mState.mPreLayoutHolderMap.remove(localViewHolder6);
              }
            }
            bool1 = false;
            break;
            label892:
            localArrayMap3 = null;
            break label716;
            View localView1 = localViewHolder5.itemView;
            long l2 = getChangedHolderKey(localViewHolder5);
            if ((localArrayMap3 != null) && (this.mState.mOldChangedHolders.get(Long.valueOf(l2)) != null)) {
              localArrayMap3.put(Long.valueOf(l2), localViewHolder5);
            } else {
              this.mState.mPostLayoutHolderMap.put(localViewHolder5, new RecyclerView.ItemHolderInfo(localViewHolder5, localView1.getLeft(), localView1.getTop(), localView1.getRight(), localView1.getBottom()));
            }
          }
          processDisappearingList(localArrayMap2);
          for (int k = -1 + this.mState.mPreLayoutHolderMap.size(); k >= 0; k--)
          {
            RecyclerView.ViewHolder localViewHolder4 = (RecyclerView.ViewHolder)this.mState.mPreLayoutHolderMap.keyAt(k);
            if (!this.mState.mPostLayoutHolderMap.containsKey(localViewHolder4))
            {
              RecyclerView.ItemHolderInfo localItemHolderInfo4 = (RecyclerView.ItemHolderInfo)this.mState.mPreLayoutHolderMap.valueAt(k);
              this.mState.mPreLayoutHolderMap.removeAt(k);
              this.mRecycler.unscrapView(localItemHolderInfo4.holder);
              animateDisappearance(localItemHolderInfo4);
            }
          }
          int m = this.mState.mPostLayoutHolderMap.size();
          if (m > 0)
          {
            int i4 = m - 1;
            if (i4 >= 0)
            {
              RecyclerView.ViewHolder localViewHolder3 = (RecyclerView.ViewHolder)this.mState.mPostLayoutHolderMap.keyAt(i4);
              RecyclerView.ItemHolderInfo localItemHolderInfo3 = (RecyclerView.ItemHolderInfo)this.mState.mPostLayoutHolderMap.valueAt(i4);
              if ((this.mState.mPreLayoutHolderMap.isEmpty()) || (!this.mState.mPreLayoutHolderMap.containsKey(localViewHolder3)))
              {
                this.mState.mPostLayoutHolderMap.removeAt(i4);
                if (localArrayMap2 == null) {
                  break label1256;
                }
              }
              for (Rect localRect = (Rect)localArrayMap2.get(localViewHolder3.itemView);; localRect = null)
              {
                animateAppearance(localViewHolder3, localRect, localItemHolderInfo3.left, localItemHolderInfo3.top);
                i4--;
                break;
              }
            }
          }
          int n = this.mState.mPostLayoutHolderMap.size();
          for (int i1 = 0; i1 < n; i1++)
          {
            RecyclerView.ViewHolder localViewHolder2 = (RecyclerView.ViewHolder)this.mState.mPostLayoutHolderMap.keyAt(i1);
            RecyclerView.ItemHolderInfo localItemHolderInfo1 = (RecyclerView.ItemHolderInfo)this.mState.mPostLayoutHolderMap.valueAt(i1);
            RecyclerView.ItemHolderInfo localItemHolderInfo2 = (RecyclerView.ItemHolderInfo)this.mState.mPreLayoutHolderMap.get(localViewHolder2);
            if ((localItemHolderInfo2 != null) && (localItemHolderInfo1 != null) && ((localItemHolderInfo2.left != localItemHolderInfo1.left) || (localItemHolderInfo2.top != localItemHolderInfo1.top)))
            {
              localViewHolder2.setIsRecyclable(false);
              if (this.mItemAnimator.animateMove(localViewHolder2, localItemHolderInfo2.left, localItemHolderInfo2.top, localItemHolderInfo1.left, localItemHolderInfo1.top)) {
                postAnimationRunner();
              }
            }
          }
          int i2;
          int i3;
          long l1;
          RecyclerView.ViewHolder localViewHolder1;
          if (this.mState.mOldChangedHolders != null)
          {
            i2 = this.mState.mOldChangedHolders.size();
            i3 = i2 - 1;
            if (i3 < 0) {
              break label1559;
            }
            l1 = ((Long)this.mState.mOldChangedHolders.keyAt(i3)).longValue();
            localViewHolder1 = (RecyclerView.ViewHolder)this.mState.mOldChangedHolders.get(Long.valueOf(l1));
            if (!localViewHolder1.shouldIgnore()) {
              break label1512;
            }
          }
          for (;;)
          {
            i3--;
            break label1447;
            i2 = 0;
            break;
            if ((RecyclerView.Recycler.access$1800(this.mRecycler) != null) && (RecyclerView.Recycler.access$1800(this.mRecycler).contains(localViewHolder1))) {
              animateChange(localViewHolder1, (RecyclerView.ViewHolder)localArrayMap3.get(Long.valueOf(l1)));
            }
          }
          resumeRequestLayout(false);
          this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
          RecyclerView.State.access$1902(this.mState, this.mState.mItemCount);
          this.mDataSetHasChangedAfterLayout = false;
          RecyclerView.State.access$1602(this.mState, false);
          RecyclerView.State.access$1402(this.mState, false);
          this.mRunningLayoutOrScroll = false;
          RecyclerView.LayoutManager.access$1702(this.mLayout, false);
          if (RecyclerView.Recycler.access$1800(this.mRecycler) != null) {
            RecyclerView.Recycler.access$1800(this.mRecycler).clear();
          }
          this.mState.mOldChangedHolders = null;
          break;
        }
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = 1;
    int j = 0;
    super.draw(paramCanvas);
    int k = this.mItemDecorations.size();
    for (int m = 0; m < k; m++) {
      ((RecyclerView.ItemDecoration)this.mItemDecorations.get(m)).onDrawOver(paramCanvas, this, this.mState);
    }
    int i9;
    int n;
    if ((this.mLeftGlow != null) && (!this.mLeftGlow.isFinished()))
    {
      int i8 = paramCanvas.save();
      if (this.mClipToPadding)
      {
        i9 = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i9 + -getHeight(), 0.0F);
        if ((this.mLeftGlow == null) || (!this.mLeftGlow.draw(paramCanvas))) {
          break label454;
        }
        n = i;
        label133:
        paramCanvas.restoreToCount(i8);
      }
    }
    for (;;)
    {
      int i7;
      label204:
      int i4;
      label259:
      int i5;
      if ((this.mTopGlow != null) && (!this.mTopGlow.isFinished()))
      {
        int i6 = paramCanvas.save();
        if (this.mClipToPadding) {
          paramCanvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if ((this.mTopGlow != null) && (this.mTopGlow.draw(paramCanvas)))
        {
          i7 = i;
          n |= i7;
          paramCanvas.restoreToCount(i6);
        }
      }
      else
      {
        if ((this.mRightGlow != null) && (!this.mRightGlow.isFinished()))
        {
          int i2 = paramCanvas.save();
          int i3 = getWidth();
          if (!this.mClipToPadding) {
            break label466;
          }
          i4 = getPaddingTop();
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-i4, -i3);
          if ((this.mRightGlow == null) || (!this.mRightGlow.draw(paramCanvas))) {
            break label472;
          }
          i5 = i;
          label299:
          n |= i5;
          paramCanvas.restoreToCount(i2);
        }
        if ((this.mBottomGlow != null) && (!this.mBottomGlow.isFinished()))
        {
          int i1 = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!this.mClipToPadding) {
            break label478;
          }
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label375:
          if ((this.mBottomGlow != null) && (this.mBottomGlow.draw(paramCanvas))) {
            j = i;
          }
          n |= j;
          paramCanvas.restoreToCount(i1);
        }
        if ((n != 0) || (this.mItemAnimator == null) || (this.mItemDecorations.size() <= 0) || (!this.mItemAnimator.isRunning())) {
          break label497;
        }
      }
      for (;;)
      {
        if (i != 0) {
          ViewCompat.postInvalidateOnAnimation(this);
        }
        return;
        i9 = 0;
        break;
        label454:
        n = 0;
        break label133;
        i7 = 0;
        break label204;
        label466:
        i4 = 0;
        break label259;
        label472:
        i5 = 0;
        break label299;
        label478:
        paramCanvas.translate(-getWidth(), -getHeight());
        break label375;
        label497:
        i = n;
      }
      n = 0;
    }
  }
  
  void eatRequestLayout()
  {
    if (!this.mEatRequestLayout)
    {
      this.mEatRequestLayout = true;
      this.mLayoutRequestEaten = false;
    }
  }
  
  void ensureBottomGlow()
  {
    if (this.mBottomGlow != null) {}
    for (;;)
    {
      return;
      this.mBottomGlow = new EdgeEffectCompat(getContext());
      if (this.mClipToPadding) {
        this.mBottomGlow.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      } else {
        this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
      }
    }
  }
  
  void ensureLeftGlow()
  {
    if (this.mLeftGlow != null) {}
    for (;;)
    {
      return;
      this.mLeftGlow = new EdgeEffectCompat(getContext());
      if (this.mClipToPadding) {
        this.mLeftGlow.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      } else {
        this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
      }
    }
  }
  
  void ensureRightGlow()
  {
    if (this.mRightGlow != null) {}
    for (;;)
    {
      return;
      this.mRightGlow = new EdgeEffectCompat(getContext());
      if (this.mClipToPadding) {
        this.mRightGlow.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      } else {
        this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
      }
    }
  }
  
  void ensureTopGlow()
  {
    if (this.mTopGlow != null) {}
    for (;;)
    {
      return;
      this.mTopGlow = new EdgeEffectCompat(getContext());
      if (this.mClipToPadding) {
        this.mTopGlow.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      } else {
        this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
      }
    }
  }
  
  public View findChildViewUnder(float paramFloat1, float paramFloat2)
  {
    int i = -1 + this.mChildHelper.getChildCount();
    View localView;
    if (i >= 0)
    {
      localView = this.mChildHelper.getChildAt(i);
      float f1 = ViewCompat.getTranslationX(localView);
      float f2 = ViewCompat.getTranslationY(localView);
      if ((paramFloat1 < f1 + localView.getLeft()) || (paramFloat1 > f1 + localView.getRight()) || (paramFloat2 < f2 + localView.getTop()) || (paramFloat2 > f2 + localView.getBottom())) {}
    }
    for (;;)
    {
      return localView;
      i--;
      break;
      localView = null;
    }
  }
  
  public RecyclerView.ViewHolder findViewHolderForItemId(long paramLong)
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    int j = 0;
    RecyclerView.ViewHolder localViewHolder;
    if (j < i)
    {
      localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if ((localViewHolder == null) || (localViewHolder.getItemId() != paramLong)) {}
    }
    for (;;)
    {
      return localViewHolder;
      j++;
      break;
      localViewHolder = null;
    }
  }
  
  public RecyclerView.ViewHolder findViewHolderForPosition(int paramInt)
  {
    return findViewHolderForPosition(paramInt, false);
  }
  
  RecyclerView.ViewHolder findViewHolderForPosition(int paramInt, boolean paramBoolean)
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    int j = 0;
    RecyclerView.ViewHolder localViewHolder;
    if (j < i)
    {
      localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if ((localViewHolder != null) && (!localViewHolder.isRemoved())) {
        if (paramBoolean) {
          if (localViewHolder.mPosition != paramInt) {
            break label69;
          }
        }
      }
    }
    for (;;)
    {
      return localViewHolder;
      if (localViewHolder.getPosition() != paramInt)
      {
        label69:
        j++;
        break;
        localViewHolder = null;
      }
    }
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (Math.abs(paramInt1) < this.mMinFlingVelocity) {
      paramInt1 = 0;
    }
    if (Math.abs(paramInt2) < this.mMinFlingVelocity) {
      paramInt2 = 0;
    }
    int i = Math.max(-this.mMaxFlingVelocity, Math.min(paramInt1, this.mMaxFlingVelocity));
    int j = Math.max(-this.mMaxFlingVelocity, Math.min(paramInt2, this.mMaxFlingVelocity));
    if ((i != 0) || (j != 0))
    {
      this.mViewFlinger.fling(i, j);
      bool = true;
    }
    return bool;
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    View localView = this.mLayout.onInterceptFocusSearch(paramView, paramInt);
    if (localView != null) {}
    for (;;)
    {
      return localView;
      localView = FocusFinder.getInstance().findNextFocus(this, paramView, paramInt);
      if ((localView == null) && (this.mAdapter != null))
      {
        eatRequestLayout();
        localView = this.mLayout.onFocusSearchFailed(paramView, paramInt, this.mRecycler, this.mState);
        resumeRequestLayout(false);
      }
      if (localView == null) {
        localView = super.focusSearch(paramView, paramInt);
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    if (this.mLayout == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.mLayout.generateDefaultLayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (this.mLayout == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.mLayout.generateLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.mLayout == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.mLayout.generateLayoutParams(paramLayoutParams);
  }
  
  public RecyclerView.Adapter getAdapter()
  {
    return this.mAdapter;
  }
  
  long getChangedHolderKey(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.mAdapter.hasStableIds()) {}
    for (long l = paramViewHolder.getItemId();; l = paramViewHolder.mPosition) {
      return l;
    }
  }
  
  public long getChildItemId(View paramView)
  {
    long l = -1L;
    if ((this.mAdapter == null) || (!this.mAdapter.hasStableIds())) {}
    for (;;)
    {
      return l;
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(paramView);
      if (localViewHolder != null) {
        l = localViewHolder.getItemId();
      }
    }
  }
  
  public int getChildPosition(View paramView)
  {
    RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(paramView);
    if (localViewHolder != null) {}
    for (int i = localViewHolder.getPosition();; i = -1) {
      return i;
    }
  }
  
  public RecyclerView.ViewHolder getChildViewHolder(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this)) {
      throw new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
    }
    return getChildViewHolderInt(paramView);
  }
  
  public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate()
  {
    return this.mAccessibilityDelegate;
  }
  
  public RecyclerView.ItemAnimator getItemAnimator()
  {
    return this.mItemAnimator;
  }
  
  Rect getItemDecorInsetsForChild(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.mInsetsDirty) {}
    Rect localRect;
    for (Object localObject = localLayoutParams.mDecorInsets;; localObject = localRect)
    {
      return localObject;
      localRect = localLayoutParams.mDecorInsets;
      localRect.set(0, 0, 0, 0);
      int i = this.mItemDecorations.size();
      for (int j = 0; j < i; j++)
      {
        this.mTempRect.set(0, 0, 0, 0);
        ((RecyclerView.ItemDecoration)this.mItemDecorations.get(j)).getItemOffsets(this.mTempRect, paramView, this, this.mState);
        localRect.left += this.mTempRect.left;
        localRect.top += this.mTempRect.top;
        localRect.right += this.mTempRect.right;
        localRect.bottom += this.mTempRect.bottom;
      }
      localLayoutParams.mInsetsDirty = false;
    }
  }
  
  public RecyclerView.LayoutManager getLayoutManager()
  {
    return this.mLayout;
  }
  
  public RecyclerView.RecycledViewPool getRecycledViewPool()
  {
    return this.mRecycler.getRecycledViewPool();
  }
  
  public int getScrollState()
  {
    return this.mScrollState;
  }
  
  public boolean hasFixedSize()
  {
    return this.mHasFixedSize;
  }
  
  void initAdapterManager()
  {
    this.mAdapterHelper = new AdapterHelper(new RecyclerView.5(this));
  }
  
  void invalidateGlows()
  {
    this.mBottomGlow = null;
    this.mTopGlow = null;
    this.mRightGlow = null;
    this.mLeftGlow = null;
  }
  
  public void invalidateItemDecorations()
  {
    if (this.mItemDecorations.size() == 0) {}
    for (;;)
    {
      return;
      if (this.mLayout != null) {
        this.mLayout.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
      }
      markItemDecorInsetsDirty();
      requestLayout();
    }
  }
  
  void markItemDecorInsetsDirty()
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++) {
      ((RecyclerView.LayoutParams)this.mChildHelper.getUnfilteredChildAt(j).getLayoutParams()).mInsetsDirty = true;
    }
    this.mRecycler.markItemDecorInsetsDirty();
  }
  
  void markKnownViewsInvalid()
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore())) {
        localViewHolder.addFlags(6);
      }
    }
    markItemDecorInsetsDirty();
    this.mRecycler.markKnownViewsInvalid();
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    int i = this.mChildHelper.getChildCount();
    for (int j = 0; j < i; j++) {
      this.mChildHelper.getChildAt(j).offsetLeftAndRight(paramInt);
    }
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    int i = this.mChildHelper.getChildCount();
    for (int j = 0; j < i; j++) {
      this.mChildHelper.getChildAt(j).offsetTopAndBottom(paramInt);
    }
  }
  
  void offsetPositionRecordsForInsert(int paramInt1, int paramInt2)
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()) && (localViewHolder.mPosition >= paramInt1))
      {
        localViewHolder.offsetPosition(paramInt2, false);
        RecyclerView.State.access$1202(this.mState, true);
      }
    }
    this.mRecycler.offsetPositionRecordsForInsert(paramInt1, paramInt2);
    requestLayout();
  }
  
  void offsetPositionRecordsForMove(int paramInt1, int paramInt2)
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    int j;
    int k;
    if (paramInt1 < paramInt2)
    {
      j = -1;
      k = paramInt2;
    }
    RecyclerView.ViewHolder localViewHolder;
    for (int m = paramInt1;; m = paramInt2)
    {
      for (int n = 0;; n++)
      {
        if (n >= i) {
          break label130;
        }
        localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(n));
        if ((localViewHolder != null) && (localViewHolder.mPosition >= m) && (localViewHolder.mPosition <= k)) {
          break;
        }
      }
      j = 1;
      k = paramInt1;
    }
    if (localViewHolder.mPosition == paramInt1) {
      localViewHolder.offsetPosition(paramInt2 - paramInt1, false);
    }
    for (;;)
    {
      RecyclerView.State.access$1202(this.mState, true);
      break;
      localViewHolder.offsetPosition(j, false);
    }
    label130:
    this.mRecycler.offsetPositionRecordsForMove(paramInt1, paramInt2);
    requestLayout();
  }
  
  void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramInt1 + paramInt2;
    int j = this.mChildHelper.getUnfilteredChildCount();
    int k = 0;
    if (k < j)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(k));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()))
      {
        if (localViewHolder.mPosition < i) {
          break label84;
        }
        localViewHolder.offsetPosition(-paramInt2, paramBoolean);
        RecyclerView.State.access$1202(this.mState, true);
      }
      for (;;)
      {
        k++;
        break;
        label84:
        if (localViewHolder.mPosition >= paramInt1)
        {
          localViewHolder.flagRemovedAndOffsetPosition(paramInt1 - 1, -paramInt2, paramBoolean);
          RecyclerView.State.access$1202(this.mState, true);
        }
      }
    }
    this.mRecycler.offsetPositionRecordsForRemove(paramInt1, paramInt2, paramBoolean);
    requestLayout();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mIsAttached = true;
    this.mFirstLayoutComplete = false;
    if (this.mLayout != null) {
      this.mLayout.onAttachedToWindow(this);
    }
    this.mPostedAnimatorRunner = false;
  }
  
  public void onChildAttachedToWindow(View paramView) {}
  
  public void onChildDetachedFromWindow(View paramView) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mItemAnimator != null) {
      this.mItemAnimator.endAnimations();
    }
    this.mFirstLayoutComplete = false;
    stopScroll();
    this.mIsAttached = false;
    if (this.mLayout != null) {
      this.mLayout.onDetachedFromWindow(this, this.mRecycler);
    }
    removeCallbacks(this.mItemAnimatorRunner);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = this.mItemDecorations.size();
    for (int j = 0; j < i; j++) {
      ((RecyclerView.ItemDecoration)this.mItemDecorations.get(j)).onDraw(paramCanvas, this, this.mState);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = -1;
    int j = 1;
    if (dispatchOnItemTouchIntercept(paramMotionEvent))
    {
      cancelTouch();
      return j;
    }
    boolean bool1 = this.mLayout.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int n = MotionEventCompat.getActionMasked(paramMotionEvent);
    int i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
    label116:
    int m;
    int i6;
    int i13;
    switch (n)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
    case 2: 
      for (;;)
      {
        if (this.mScrollState != j)
        {
          int k = 0;
          break;
          this.mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
          int i16 = (int)(0.5F + paramMotionEvent.getX());
          this.mLastTouchX = i16;
          this.mInitialTouchX = i16;
          int i17 = (int)(0.5F + paramMotionEvent.getY());
          this.mLastTouchY = i17;
          this.mInitialTouchY = i17;
          if (this.mScrollState == 2)
          {
            getParent().requestDisallowInterceptTouchEvent(k);
            setScrollState(k);
            continue;
            this.mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, i1);
            int i14 = (int)(0.5F + MotionEventCompat.getX(paramMotionEvent, i1));
            this.mLastTouchX = i14;
            this.mInitialTouchX = i14;
            int i15 = (int)(0.5F + MotionEventCompat.getY(paramMotionEvent, i1));
            this.mLastTouchY = i15;
            this.mInitialTouchY = i15;
            continue;
            int i2 = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mScrollPointerId);
            if (i2 < 0)
            {
              new StringBuilder().append("Error processing scroll; pointer index for id ").append(this.mScrollPointerId).append(" not found. Did any MotionEvents get skipped?").toString();
              m = 0;
              break;
            }
            int i3 = (int)(0.5F + MotionEventCompat.getX(paramMotionEvent, i2));
            int i4 = (int)(0.5F + MotionEventCompat.getY(paramMotionEvent, i2));
            if (this.mScrollState != m)
            {
              int i5 = i3 - this.mInitialTouchX;
              i6 = i4 - this.mInitialTouchY;
              if ((!bool1) || (Math.abs(i5) <= this.mTouchSlop)) {
                break label534;
              }
              int i11 = this.mInitialTouchX;
              int i12 = this.mTouchSlop;
              if (i5 < 0)
              {
                i13 = i;
                label412:
                this.mLastTouchX = (i11 + i13 * i12);
              }
            }
          }
        }
      }
    }
    label504:
    int i8;
    label534:
    for (int i7 = m;; i8 = 0)
    {
      int i9;
      int i10;
      if ((bool2) && (Math.abs(i6) > this.mTouchSlop))
      {
        i9 = this.mInitialTouchY;
        i10 = this.mTouchSlop;
        if (i6 >= 0) {
          break label504;
        }
      }
      for (;;)
      {
        this.mLastTouchY = (i9 + i * i10);
        i7 = m;
        if (i7 == 0) {
          break;
        }
        getParent().requestDisallowInterceptTouchEvent(m);
        setScrollState(m);
        break;
        i13 = m;
        break label412;
        i = m;
      }
      onPointerUp(paramMotionEvent);
      break label116;
      this.mVelocityTracker.clear();
      break label116;
      cancelTouch();
      break label116;
      break;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    eatRequestLayout();
    dispatchLayout();
    resumeRequestLayout(false);
    this.mFirstLayoutComplete = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mAdapterUpdateDuringMeasure)
    {
      eatRequestLayout();
      processAdapterUpdatesAndSetAnimationFlags();
      if (RecyclerView.State.access$1400(this.mState))
      {
        RecyclerView.State.access$1502(this.mState, true);
        this.mAdapterUpdateDuringMeasure = false;
        resumeRequestLayout(false);
      }
    }
    else
    {
      if (this.mAdapter == null) {
        break label111;
      }
    }
    label111:
    for (this.mState.mItemCount = this.mAdapter.getItemCount();; this.mState.mItemCount = 0)
    {
      this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
      RecyclerView.State.access$1502(this.mState, false);
      return;
      this.mAdapterHelper.consumeUpdatesInOnePass();
      RecyclerView.State.access$1502(this.mState, false);
      break;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    this.mPendingSavedState = ((RecyclerView.SavedState)paramParcelable);
    super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
    if ((this.mLayout != null) && (this.mPendingSavedState.mLayoutState != null)) {
      this.mLayout.onRestoreInstanceState(this.mPendingSavedState.mLayoutState);
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    RecyclerView.SavedState localSavedState = new RecyclerView.SavedState(super.onSaveInstanceState());
    if (this.mPendingSavedState != null) {
      RecyclerView.SavedState.access$1300(localSavedState, this.mPendingSavedState);
    }
    for (;;)
    {
      return localSavedState;
      if (this.mLayout != null) {
        localSavedState.mLayoutState = this.mLayout.onSaveInstanceState();
      } else {
        localSavedState.mLayoutState = null;
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      invalidateGlows();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = -1;
    int j = 1;
    if (dispatchOnItemTouch(paramMotionEvent)) {
      cancelTouch();
    }
    boolean bool1;
    boolean bool2;
    int n;
    for (;;)
    {
      return j;
      bool1 = this.mLayout.canScrollHorizontally();
      bool2 = this.mLayout.canScrollVertically();
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      int k = MotionEventCompat.getActionMasked(paramMotionEvent);
      int m = MotionEventCompat.getActionIndex(paramMotionEvent);
      switch (k)
      {
      case 4: 
      default: 
        break;
      case 0: 
        this.mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        int i18 = (int)(0.5F + paramMotionEvent.getX());
        this.mLastTouchX = i18;
        this.mInitialTouchX = i18;
        int i19 = (int)(0.5F + paramMotionEvent.getY());
        this.mLastTouchY = i19;
        this.mInitialTouchY = i19;
        break;
      case 5: 
        this.mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, m);
        int i16 = (int)(0.5F + MotionEventCompat.getX(paramMotionEvent, m));
        this.mLastTouchX = i16;
        this.mInitialTouchX = i16;
        int i17 = (int)(0.5F + MotionEventCompat.getY(paramMotionEvent, m));
        this.mLastTouchY = i17;
        this.mInitialTouchY = i17;
        break;
      case 2: 
        n = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mScrollPointerId);
        if (n >= 0) {
          break label290;
        }
        new StringBuilder().append("Error processing scroll; pointer index for id ").append(this.mScrollPointerId).append(" not found. Did any MotionEvents get skipped?").toString();
        j = 0;
      }
    }
    label290:
    int i1 = (int)(0.5F + MotionEventCompat.getX(paramMotionEvent, n));
    int i2 = (int)(0.5F + MotionEventCompat.getY(paramMotionEvent, n));
    int i8;
    int i15;
    if (this.mScrollState != j)
    {
      int i7 = i1 - this.mInitialTouchX;
      i8 = i2 - this.mInitialTouchY;
      if ((!bool1) || (Math.abs(i7) <= this.mTouchSlop)) {
        break label680;
      }
      int i13 = this.mInitialTouchX;
      int i14 = this.mTouchSlop;
      if (i7 >= 0) {
        break label531;
      }
      i15 = i;
      label379:
      this.mLastTouchX = (i13 + i15 * i14);
    }
    label428:
    label498:
    int i10;
    label531:
    label542:
    label548:
    label680:
    for (int i9 = j;; i10 = 0)
    {
      int i4;
      int i5;
      if ((bool2) && (Math.abs(i8) > this.mTouchSlop))
      {
        int i11 = this.mInitialTouchY;
        int i12 = this.mTouchSlop;
        if (i8 < 0)
        {
          this.mLastTouchY = (i11 + i * i12);
          i9 = j;
        }
      }
      else
      {
        if (i9 != 0)
        {
          getParent().requestDisallowInterceptTouchEvent(j);
          setScrollState(j);
        }
        if (this.mScrollState == j)
        {
          int i3 = i1 - this.mLastTouchX;
          i4 = i2 - this.mLastTouchY;
          if (!bool1) {
            break label542;
          }
          i5 = -i3;
          if (!bool2) {
            break label548;
          }
        }
      }
      for (int i6 = -i4;; i6 = 0)
      {
        scrollByInternal(i5, i6);
        this.mLastTouchX = i1;
        this.mLastTouchY = i2;
        break;
        i15 = j;
        break label379;
        i = j;
        break label428;
        i5 = 0;
        break label498;
      }
      onPointerUp(paramMotionEvent);
      break;
      this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
      float f1;
      if (bool1)
      {
        f1 = -VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mScrollPointerId);
        label596:
        if (!bool2) {
          break label667;
        }
      }
      for (float f2 = -VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mScrollPointerId);; f2 = 0.0F)
      {
        if (((f1 == 0.0F) && (f2 == 0.0F)) || (!fling((int)f1, (int)f2))) {
          setScrollState(0);
        }
        this.mVelocityTracker.clear();
        releaseGlows();
        break;
        f1 = 0.0F;
        break label596;
      }
      cancelTouch();
      break;
    }
  }
  
  void rebindUpdatedViewHolders()
  {
    int i = this.mChildHelper.getChildCount();
    int j = 0;
    if (j < i)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(j));
      if ((localViewHolder == null) || (localViewHolder.shouldIgnore())) {}
      for (;;)
      {
        j++;
        break;
        if ((localViewHolder.isRemoved()) || (localViewHolder.isInvalid()))
        {
          requestLayout();
        }
        else if (localViewHolder.needsUpdate())
        {
          int k = this.mAdapter.getItemViewType(localViewHolder.mPosition);
          if (localViewHolder.getItemViewType() == k)
          {
            if ((!localViewHolder.isChanged()) || (!supportsChangeAnimations())) {
              this.mAdapter.bindViewHolder(localViewHolder, localViewHolder.mPosition);
            } else {
              requestLayout();
            }
          }
          else
          {
            localViewHolder.addFlags(4);
            requestLayout();
          }
        }
      }
    }
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(paramView);
    if (localViewHolder != null)
    {
      if (!localViewHolder.isTmpDetached()) {
        break label32;
      }
      localViewHolder.clearTmpDetachFlag();
    }
    label32:
    while (localViewHolder.shouldIgnore())
    {
      dispatchChildDetached(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      return;
    }
    throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + localViewHolder);
  }
  
  public void removeItemDecoration(RecyclerView.ItemDecoration paramItemDecoration)
  {
    if (this.mLayout != null) {
      this.mLayout.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
    }
    this.mItemDecorations.remove(paramItemDecoration);
    if (this.mItemDecorations.isEmpty()) {
      if (ViewCompat.getOverScrollMode(this) != 2) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      markItemDecorInsetsDirty();
      requestLayout();
      return;
    }
  }
  
  public void removeOnItemTouchListener(RecyclerView.OnItemTouchListener paramOnItemTouchListener)
  {
    this.mOnItemTouchListeners.remove(paramOnItemTouchListener);
    if (this.mActiveOnItemTouchListener == paramOnItemTouchListener) {
      this.mActiveOnItemTouchListener = null;
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    boolean bool = false;
    if ((!this.mLayout.onRequestChildFocus(this, this.mState, paramView1, paramView2)) && (paramView2 != null))
    {
      this.mTempRect.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
      offsetDescendantRectToMyCoords(paramView2, this.mTempRect);
      offsetRectIntoDescendantCoords(paramView1, this.mTempRect);
      Rect localRect = this.mTempRect;
      if (!this.mFirstLayoutComplete) {
        bool = true;
      }
      requestChildRectangleOnScreen(paramView1, localRect, bool);
    }
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return this.mLayout.requestChildRectangleOnScreen(this, paramView, paramRect, paramBoolean);
  }
  
  public void requestLayout()
  {
    if (!this.mEatRequestLayout) {
      super.requestLayout();
    }
    for (;;)
    {
      return;
      this.mLayoutRequestEaten = true;
    }
  }
  
  void resumeRequestLayout(boolean paramBoolean)
  {
    if (this.mEatRequestLayout)
    {
      if ((paramBoolean) && (this.mLayoutRequestEaten) && (this.mLayout != null) && (this.mAdapter != null)) {
        dispatchLayout();
      }
      this.mEatRequestLayout = false;
      this.mLayoutRequestEaten = false;
    }
  }
  
  void saveOldPositions()
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++)
    {
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if (!localViewHolder.shouldIgnore()) {
        localViewHolder.saveOldPosition();
      }
    }
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (this.mLayout == null) {
      throw new IllegalStateException("Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    }
    boolean bool1 = this.mLayout.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    if ((bool1) || (bool2))
    {
      if (!bool1) {
        break label60;
      }
      if (!bool2) {
        break label65;
      }
    }
    for (;;)
    {
      scrollByInternal(paramInt1, paramInt2);
      return;
      label60:
      paramInt1 = 0;
      break;
      label65:
      paramInt2 = 0;
    }
  }
  
  void scrollByInternal(int paramInt1, int paramInt2)
  {
    consumePendingUpdateOperations();
    int n;
    int m;
    int i;
    int i1;
    label74:
    label221:
    int k;
    int j;
    if (this.mAdapter != null)
    {
      eatRequestLayout();
      this.mRunningLayoutOrScroll = true;
      if (paramInt1 != 0)
      {
        n = this.mLayout.scrollHorizontallyBy(paramInt1, this.mRecycler, this.mState);
        m = paramInt1 - n;
        if (paramInt2 != 0)
        {
          i = this.mLayout.scrollVerticallyBy(paramInt2, this.mRecycler, this.mState);
          i1 = paramInt2 - i;
          if (supportsChangeAnimations())
          {
            int i3 = this.mChildHelper.getChildCount();
            int i4 = 0;
            if (i4 < i3)
            {
              View localView1 = this.mChildHelper.getChildAt(i4);
              RecyclerView.ViewHolder localViewHolder1 = getChildViewHolder(localView1);
              RecyclerView.ViewHolder localViewHolder2;
              if ((localViewHolder1 != null) && (localViewHolder1.mShadowingHolder != null))
              {
                localViewHolder2 = localViewHolder1.mShadowingHolder;
                if (localViewHolder2 == null) {
                  break label221;
                }
              }
              for (View localView2 = localViewHolder2.itemView;; localView2 = null)
              {
                if (localView2 != null)
                {
                  int i5 = localView1.getLeft();
                  int i6 = localView1.getTop();
                  if ((i5 != localView2.getLeft()) || (i6 != localView2.getTop())) {
                    localView2.layout(i5, i6, i5 + localView2.getWidth(), i6 + localView2.getHeight());
                  }
                }
                i4++;
                break;
              }
            }
          }
          this.mRunningLayoutOrScroll = false;
          resumeRequestLayout(false);
          int i2 = n;
          k = i1;
          j = i2;
        }
      }
    }
    for (;;)
    {
      if (!this.mItemDecorations.isEmpty()) {
        invalidate();
      }
      if (ViewCompat.getOverScrollMode(this) != 2)
      {
        considerReleasingGlowsOnScroll(paramInt1, paramInt2);
        pullGlows(m, k);
      }
      if ((j != 0) || (i != 0))
      {
        onScrollChanged(0, 0, 0, 0);
        if (this.mScrollListener != null) {
          this.mScrollListener.onScrolled(this, j, i);
        }
      }
      if (!awakenScrollBars()) {
        invalidate();
      }
      return;
      i = 0;
      i1 = 0;
      break label74;
      n = 0;
      m = 0;
      break;
      i = 0;
      j = 0;
      k = 0;
      m = 0;
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
  }
  
  public void scrollToPosition(int paramInt)
  {
    stopScroll();
    this.mLayout.scrollToPosition(paramInt);
    awakenScrollBars();
  }
  
  public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate paramRecyclerViewAccessibilityDelegate)
  {
    this.mAccessibilityDelegate = paramRecyclerViewAccessibilityDelegate;
    ViewCompat.setAccessibilityDelegate(this, this.mAccessibilityDelegate);
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    setAdapterInternal(paramAdapter, false, true);
    requestLayout();
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.mClipToPadding) {
      invalidateGlows();
    }
    this.mClipToPadding = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.mFirstLayoutComplete) {
      requestLayout();
    }
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.mHasFixedSize = paramBoolean;
  }
  
  public void setItemAnimator(RecyclerView.ItemAnimator paramItemAnimator)
  {
    if (this.mItemAnimator != null)
    {
      this.mItemAnimator.endAnimations();
      this.mItemAnimator.setListener(null);
    }
    this.mItemAnimator = paramItemAnimator;
    if (this.mItemAnimator != null) {
      this.mItemAnimator.setListener(this.mItemAnimatorListener);
    }
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    this.mRecycler.setViewCacheSize(paramInt);
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager == this.mLayout) {}
    for (;;)
    {
      return;
      if (this.mLayout != null)
      {
        if (this.mIsAttached) {
          this.mLayout.onDetachedFromWindow(this, this.mRecycler);
        }
        this.mLayout.setRecyclerView(null);
      }
      this.mRecycler.clear();
      this.mChildHelper.removeAllViewsUnfiltered();
      this.mLayout = paramLayoutManager;
      if (paramLayoutManager != null)
      {
        if (paramLayoutManager.mRecyclerView != null) {
          throw new IllegalArgumentException("LayoutManager " + paramLayoutManager + " is already attached to a RecyclerView: " + paramLayoutManager.mRecyclerView);
        }
        this.mLayout.setRecyclerView(this);
        if (this.mIsAttached) {
          this.mLayout.onAttachedToWindow(this);
        }
      }
      requestLayout();
    }
  }
  
  public void setOnScrollListener(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    this.mScrollListener = paramOnScrollListener;
  }
  
  public void setRecycledViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    this.mRecycler.setRecycledViewPool(paramRecycledViewPool);
  }
  
  public void setRecyclerListener(RecyclerView.RecyclerListener paramRecyclerListener)
  {
    this.mRecyclerListener = paramRecyclerListener;
  }
  
  public void setScrollingTouchSlop(int paramInt)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    switch (paramInt)
    {
    default: 
      new StringBuilder().append("setScrollingTouchSlop(): bad argument constant ").append(paramInt).append("; using default value").toString();
    }
    for (this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();; this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration)) {
      return;
    }
  }
  
  public void setViewCacheExtension(RecyclerView.ViewCacheExtension paramViewCacheExtension)
  {
    this.mRecycler.setViewCacheExtension(paramViewCacheExtension);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.mViewFlinger.smoothScrollBy(paramInt1, paramInt2);
    }
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    this.mLayout.smoothScrollToPosition(this, this.mState, paramInt);
  }
  
  public void stopScroll()
  {
    setScrollState(0);
    stopScrollersInternal();
  }
  
  public void swapAdapter(RecyclerView.Adapter paramAdapter, boolean paramBoolean)
  {
    setAdapterInternal(paramAdapter, true, paramBoolean);
    this.mDataSetHasChangedAfterLayout = true;
    requestLayout();
  }
  
  void viewRangeUpdate(int paramInt1, int paramInt2)
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    int j = paramInt1 + paramInt2;
    int k = 0;
    if (k < i)
    {
      View localView = this.mChildHelper.getUnfilteredChildAt(k);
      RecyclerView.ViewHolder localViewHolder = getChildViewHolderInt(localView);
      if ((localViewHolder == null) || (localViewHolder.shouldIgnore())) {}
      for (;;)
      {
        k++;
        break;
        if ((localViewHolder.mPosition >= paramInt1) && (localViewHolder.mPosition < j))
        {
          localViewHolder.addFlags(2);
          if (supportsChangeAnimations()) {
            localViewHolder.addFlags(64);
          }
          ((RecyclerView.LayoutParams)localView.getLayoutParams()).mInsetsDirty = true;
        }
      }
    }
    this.mRecycler.viewRangeUpdate(paramInt1, paramInt2);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView
 * JD-Core Version:    0.7.0.1
 */