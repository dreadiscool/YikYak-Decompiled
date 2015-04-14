package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FragmentActivity
  extends Activity
{
  static final String FRAGMENTS_TAG = "android:support:fragments";
  private static final int HONEYCOMB = 11;
  static final int MSG_REALLY_STOPPED = 1;
  static final int MSG_RESUME_PENDING = 2;
  private static final String TAG = "FragmentActivity";
  SimpleArrayMap<String, LoaderManagerImpl> mAllLoaderManagers;
  boolean mCheckedForLoaderManager;
  final FragmentContainer mContainer = new FragmentActivity.2(this);
  boolean mCreated;
  final FragmentManagerImpl mFragments = new FragmentManagerImpl();
  final Handler mHandler = new FragmentActivity.1(this);
  LoaderManagerImpl mLoaderManager;
  boolean mLoadersStarted;
  boolean mOptionsMenuInvalidated;
  boolean mReallyStopped;
  boolean mResumed;
  boolean mRetaining;
  boolean mStopped;
  
  private void dumpViewHierarchy(String paramString, PrintWriter paramPrintWriter, View paramView)
  {
    paramPrintWriter.print(paramString);
    if (paramView == null) {
      paramPrintWriter.println("null");
    }
    for (;;)
    {
      return;
      paramPrintWriter.println(viewToString(paramView));
      if ((paramView instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        int i = localViewGroup.getChildCount();
        if (i > 0)
        {
          String str = paramString + "  ";
          for (int j = 0; j < i; j++) {
            dumpViewHierarchy(str, paramPrintWriter, localViewGroup.getChildAt(j));
          }
        }
      }
    }
  }
  
  private static String viewToString(View paramView)
  {
    char c1 = 'F';
    char c2 = '.';
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(paramView.getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(paramView)));
    localStringBuilder.append(' ');
    switch (paramView.getVisibility())
    {
    default: 
      localStringBuilder.append(c2);
    }
    for (;;)
    {
      char c3;
      label108:
      char c4;
      label126:
      char c5;
      label143:
      char c6;
      label161:
      char c7;
      label179:
      char c8;
      label197:
      char c9;
      label215:
      label236:
      char c10;
      label253:
      int i;
      Resources localResources;
      if (paramView.isFocusable())
      {
        c3 = c1;
        localStringBuilder.append(c3);
        if (!paramView.isEnabled()) {
          break label533;
        }
        c4 = 'E';
        localStringBuilder.append(c4);
        if (!paramView.willNotDraw()) {
          break label539;
        }
        c5 = c2;
        localStringBuilder.append(c5);
        if (!paramView.isHorizontalScrollBarEnabled()) {
          break label546;
        }
        c6 = 'H';
        localStringBuilder.append(c6);
        if (!paramView.isVerticalScrollBarEnabled()) {
          break label552;
        }
        c7 = 'V';
        localStringBuilder.append(c7);
        if (!paramView.isClickable()) {
          break label558;
        }
        c8 = 'C';
        localStringBuilder.append(c8);
        if (!paramView.isLongClickable()) {
          break label564;
        }
        c9 = 'L';
        localStringBuilder.append(c9);
        localStringBuilder.append(' ');
        if (!paramView.isFocused()) {
          break label570;
        }
        localStringBuilder.append(c1);
        if (!paramView.isSelected()) {
          break label575;
        }
        c10 = 'S';
        localStringBuilder.append(c10);
        if (paramView.isPressed()) {
          c2 = 'P';
        }
        localStringBuilder.append(c2);
        localStringBuilder.append(' ');
        localStringBuilder.append(paramView.getLeft());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getTop());
        localStringBuilder.append('-');
        localStringBuilder.append(paramView.getRight());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getBottom());
        i = paramView.getId();
        if (i != -1)
        {
          localStringBuilder.append(" #");
          localStringBuilder.append(Integer.toHexString(i));
          localResources = paramView.getResources();
          if ((i != 0) && (localResources != null)) {
            switch (0xFF000000 & i)
            {
            }
          }
        }
      }
      try
      {
        String str1 = localResources.getResourcePackageName(i);
        for (;;)
        {
          String str2 = localResources.getResourceTypeName(i);
          String str3 = localResources.getResourceEntryName(i);
          localStringBuilder.append(" ");
          localStringBuilder.append(str1);
          localStringBuilder.append(":");
          localStringBuilder.append(str2);
          localStringBuilder.append("/");
          localStringBuilder.append(str3);
          label485:
          localStringBuilder.append("}");
          return localStringBuilder.toString();
          localStringBuilder.append('V');
          break;
          localStringBuilder.append('I');
          break;
          localStringBuilder.append('G');
          break;
          c3 = c2;
          break label108;
          label533:
          c4 = c2;
          break label126;
          label539:
          c5 = 'D';
          break label143;
          label546:
          c6 = c2;
          break label161;
          label552:
          c7 = c2;
          break label179;
          label558:
          c8 = c2;
          break label197;
          label564:
          c9 = c2;
          break label215;
          label570:
          c1 = c2;
          break label236;
          label575:
          c10 = c2;
          break label253;
          str1 = "app";
          continue;
          str1 = "android";
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        break label485;
      }
    }
  }
  
  void doReallyStop(boolean paramBoolean)
  {
    if (!this.mReallyStopped)
    {
      this.mReallyStopped = true;
      this.mRetaining = paramBoolean;
      this.mHandler.removeMessages(1);
      onReallyStop();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    String str = paramString + "  ";
    paramPrintWriter.print(str);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.mCreated);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(this.mResumed);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.mStopped);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(this.mReallyStopped);
    paramPrintWriter.print(str);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(this.mLoadersStarted);
    if (this.mLoaderManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this.mLoaderManager)));
      paramPrintWriter.println(":");
      this.mLoaderManager.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    this.mFragments.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.println("View Hierarchy:");
    dumpViewHierarchy(paramString + "  ", paramPrintWriter, getWindow().getDecorView());
  }
  
  public Object getLastCustomNonConfigurationInstance()
  {
    FragmentActivity.NonConfigurationInstances localNonConfigurationInstances = (FragmentActivity.NonConfigurationInstances)getLastNonConfigurationInstance();
    if (localNonConfigurationInstances != null) {}
    for (Object localObject = localNonConfigurationInstances.custom;; localObject = null) {
      return localObject;
    }
  }
  
  LoaderManagerImpl getLoaderManager(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mAllLoaderManagers == null) {
      this.mAllLoaderManagers = new SimpleArrayMap();
    }
    LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)this.mAllLoaderManagers.get(paramString);
    if (localLoaderManagerImpl == null) {
      if (paramBoolean2)
      {
        localLoaderManagerImpl = new LoaderManagerImpl(paramString, this, paramBoolean1);
        this.mAllLoaderManagers.put(paramString, localLoaderManagerImpl);
      }
    }
    for (;;)
    {
      return localLoaderManagerImpl;
      localLoaderManagerImpl.updateActivity(this);
    }
  }
  
  public FragmentManager getSupportFragmentManager()
  {
    return this.mFragments;
  }
  
  public LoaderManager getSupportLoaderManager()
  {
    if (this.mLoaderManager != null) {}
    for (LoaderManagerImpl localLoaderManagerImpl = this.mLoaderManager;; localLoaderManagerImpl = this.mLoaderManager)
    {
      return localLoaderManagerImpl;
      this.mCheckedForLoaderManager = true;
      this.mLoaderManager = getLoaderManager("(root)", this.mLoadersStarted, true);
    }
  }
  
  void invalidateSupportFragment(String paramString)
  {
    if (this.mAllLoaderManagers != null)
    {
      LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)this.mAllLoaderManagers.get(paramString);
      if ((localLoaderManagerImpl != null) && (!localLoaderManagerImpl.mRetaining))
      {
        localLoaderManagerImpl.doDestroy();
        this.mAllLoaderManagers.remove(paramString);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mFragments.noteStateNotSaved();
    int i = paramInt1 >> 16;
    int j;
    if (i != 0)
    {
      j = i - 1;
      if ((this.mFragments.mActive == null) || (j < 0) || (j >= this.mFragments.mActive.size())) {
        new StringBuilder().append("Activity result fragment index out of range: 0x").append(Integer.toHexString(paramInt1)).toString();
      }
    }
    for (;;)
    {
      return;
      Fragment localFragment = (Fragment)this.mFragments.mActive.get(j);
      if (localFragment == null)
      {
        new StringBuilder().append("Activity result no fragment exists for index: 0x").append(Integer.toHexString(paramInt1)).toString();
      }
      else
      {
        localFragment.onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
        continue;
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onBackPressed()
  {
    if (!this.mFragments.popBackStackImmediate()) {
      supportFinishAfterTransition();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.mFragments.dispatchConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mFragments.attachActivity(this, this.mContainer, null);
    if (getLayoutInflater().getFactory() == null) {
      getLayoutInflater().setFactory(this);
    }
    super.onCreate(paramBundle);
    FragmentActivity.NonConfigurationInstances localNonConfigurationInstances = (FragmentActivity.NonConfigurationInstances)getLastNonConfigurationInstance();
    if (localNonConfigurationInstances != null) {
      this.mAllLoaderManagers = localNonConfigurationInstances.loaders;
    }
    Parcelable localParcelable;
    FragmentManagerImpl localFragmentManagerImpl;
    if (paramBundle != null)
    {
      localParcelable = paramBundle.getParcelable("android:support:fragments");
      localFragmentManagerImpl = this.mFragments;
      if (localNonConfigurationInstances == null) {
        break label99;
      }
    }
    label99:
    for (ArrayList localArrayList = localNonConfigurationInstances.fragments;; localArrayList = null)
    {
      localFragmentManagerImpl.restoreAllState(localParcelable, localArrayList);
      this.mFragments.dispatchCreate();
      return;
    }
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    boolean bool;
    if (paramInt == 0)
    {
      bool = super.onCreatePanelMenu(paramInt, paramMenu) | this.mFragments.dispatchCreateOptionsMenu(paramMenu, getMenuInflater());
      if (Build.VERSION.SDK_INT < 11) {}
    }
    for (;;)
    {
      return bool;
      bool = true;
      continue;
      bool = super.onCreatePanelMenu(paramInt, paramMenu);
    }
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView;
    if (!"fragment".equals(paramString)) {
      localView = super.onCreateView(paramString, paramContext, paramAttributeSet);
    }
    for (;;)
    {
      return localView;
      localView = this.mFragments.onCreateView(paramString, paramContext, paramAttributeSet);
      if (localView == null) {
        localView = super.onCreateView(paramString, paramContext, paramAttributeSet);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    doReallyStop(false);
    this.mFragments.dispatchDestroy();
    if (this.mLoaderManager != null) {
      this.mLoaderManager.doDestroy();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((Build.VERSION.SDK_INT < 5) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0)) {
      onBackPressed();
    }
    for (boolean bool = true;; bool = super.onKeyDown(paramInt, paramKeyEvent)) {
      return bool;
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.mFragments.dispatchLowMemory();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    boolean bool;
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      switch (paramInt)
      {
      default: 
        bool = false;
        break;
      case 0: 
        bool = this.mFragments.dispatchOptionsItemSelected(paramMenuItem);
        break;
      case 6: 
        bool = this.mFragments.dispatchContextItemSelected(paramMenuItem);
      }
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.mFragments.noteStateNotSaved();
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onPanelClosed(paramInt, paramMenu);
      return;
      this.mFragments.dispatchOptionsMenuClosed(paramMenu);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.mResumed = false;
    if (this.mHandler.hasMessages(2))
    {
      this.mHandler.removeMessages(2);
      onResumeFragments();
    }
    this.mFragments.dispatchPause();
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    this.mHandler.removeMessages(2);
    onResumeFragments();
    this.mFragments.execPendingActions();
  }
  
  public boolean onPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    return super.onPreparePanel(0, paramView, paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) && (paramMenu != null)) {
      if (this.mOptionsMenuInvalidated)
      {
        this.mOptionsMenuInvalidated = false;
        paramMenu.clear();
        onCreatePanelMenu(paramInt, paramMenu);
      }
    }
    for (boolean bool = onPrepareOptionsPanel(paramView, paramMenu) | this.mFragments.dispatchPrepareOptionsMenu(paramMenu);; bool = super.onPreparePanel(paramInt, paramView, paramMenu)) {
      return bool;
    }
  }
  
  void onReallyStop()
  {
    if (this.mLoadersStarted)
    {
      this.mLoadersStarted = false;
      if (this.mLoaderManager != null)
      {
        if (this.mRetaining) {
          break label41;
        }
        this.mLoaderManager.doStop();
      }
    }
    for (;;)
    {
      this.mFragments.dispatchReallyStop();
      return;
      label41:
      this.mLoaderManager.doRetain();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.mHandler.sendEmptyMessage(2);
    this.mResumed = true;
    this.mFragments.execPendingActions();
  }
  
  protected void onResumeFragments()
  {
    this.mFragments.dispatchResume();
  }
  
  public Object onRetainCustomNonConfigurationInstance()
  {
    return null;
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    int i = 0;
    if (this.mStopped) {
      doReallyStop(true);
    }
    Object localObject1 = onRetainCustomNonConfigurationInstance();
    ArrayList localArrayList = this.mFragments.retainNonConfig();
    int j;
    if (this.mAllLoaderManagers != null)
    {
      int k = this.mAllLoaderManagers.size();
      LoaderManagerImpl[] arrayOfLoaderManagerImpl = new LoaderManagerImpl[k];
      for (int m = k - 1; m >= 0; m--) {
        arrayOfLoaderManagerImpl[m] = ((LoaderManagerImpl)this.mAllLoaderManagers.valueAt(m));
      }
      j = 0;
      if (i < k)
      {
        LoaderManagerImpl localLoaderManagerImpl = arrayOfLoaderManagerImpl[i];
        if (localLoaderManagerImpl.mRetaining) {
          j = 1;
        }
        for (;;)
        {
          i++;
          break;
          localLoaderManagerImpl.doDestroy();
          this.mAllLoaderManagers.remove(localLoaderManagerImpl.mWho);
        }
      }
    }
    else
    {
      j = 0;
    }
    Object localObject2;
    if ((localArrayList == null) && (j == 0) && (localObject1 == null)) {
      localObject2 = null;
    }
    for (;;)
    {
      return localObject2;
      localObject2 = new FragmentActivity.NonConfigurationInstances();
      ((FragmentActivity.NonConfigurationInstances)localObject2).activity = null;
      ((FragmentActivity.NonConfigurationInstances)localObject2).custom = localObject1;
      ((FragmentActivity.NonConfigurationInstances)localObject2).children = null;
      ((FragmentActivity.NonConfigurationInstances)localObject2).fragments = localArrayList;
      ((FragmentActivity.NonConfigurationInstances)localObject2).loaders = this.mAllLoaderManagers;
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Parcelable localParcelable = this.mFragments.saveAllState();
    if (localParcelable != null) {
      paramBundle.putParcelable("android:support:fragments", localParcelable);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.mStopped = false;
    this.mReallyStopped = false;
    this.mHandler.removeMessages(1);
    if (!this.mCreated)
    {
      this.mCreated = true;
      this.mFragments.dispatchActivityCreated();
    }
    this.mFragments.noteStateNotSaved();
    this.mFragments.execPendingActions();
    if (!this.mLoadersStarted)
    {
      this.mLoadersStarted = true;
      if (this.mLoaderManager == null) {
        break label146;
      }
      this.mLoaderManager.doStart();
    }
    int i;
    LoaderManagerImpl[] arrayOfLoaderManagerImpl;
    for (;;)
    {
      this.mCheckedForLoaderManager = true;
      this.mFragments.dispatchStart();
      if (this.mAllLoaderManagers == null) {
        return;
      }
      i = this.mAllLoaderManagers.size();
      arrayOfLoaderManagerImpl = new LoaderManagerImpl[i];
      for (int j = i - 1; j >= 0; j--) {
        arrayOfLoaderManagerImpl[j] = ((LoaderManagerImpl)this.mAllLoaderManagers.valueAt(j));
      }
      label146:
      if (!this.mCheckedForLoaderManager)
      {
        this.mLoaderManager = getLoaderManager("(root)", this.mLoadersStarted, false);
        if ((this.mLoaderManager != null) && (!this.mLoaderManager.mStarted)) {
          this.mLoaderManager.doStart();
        }
      }
    }
    for (int k = 0; k < i; k++)
    {
      LoaderManagerImpl localLoaderManagerImpl = arrayOfLoaderManagerImpl[k];
      localLoaderManagerImpl.finishRetain();
      localLoaderManagerImpl.doReportStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.mStopped = true;
    this.mHandler.sendEmptyMessage(1);
    this.mFragments.dispatchStop();
  }
  
  public void setEnterSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    ActivityCompat.setEnterSharedElementCallback(this, paramSharedElementCallback);
  }
  
  public void setExitSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    ActivityCompat.setExitSharedElementCallback(this, paramSharedElementCallback);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((paramInt != -1) && ((0xFFFF0000 & paramInt) != 0)) {
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    if (paramInt == -1) {
      super.startActivityForResult(paramIntent, -1);
    }
    for (;;)
    {
      return;
      if ((0xFFFF0000 & paramInt) != 0) {
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
      }
      super.startActivityForResult(paramIntent, (1 + paramFragment.mIndex << 16) + (0xFFFF & paramInt));
    }
  }
  
  public void supportFinishAfterTransition()
  {
    ActivityCompat.finishAfterTransition(this);
  }
  
  public void supportInvalidateOptionsMenu()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      ActivityCompatHoneycomb.invalidateOptionsMenu(this);
    }
    for (;;)
    {
      return;
      this.mOptionsMenuInvalidated = true;
    }
  }
  
  public void supportPostponeEnterTransition()
  {
    ActivityCompat.postponeEnterTransition(this);
  }
  
  public void supportStartPostponedEnterTransition()
  {
    ActivityCompat.startPostponedEnterTransition(this);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentActivity
 * JD-Core Version:    0.7.0.1
 */