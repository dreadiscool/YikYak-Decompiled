package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class LoaderManagerImpl
  extends LoaderManager
{
  static boolean DEBUG = false;
  static final String TAG = "LoaderManager";
  FragmentActivity mActivity;
  boolean mCreatingLoader;
  final SparseArrayCompat<LoaderManagerImpl.LoaderInfo> mInactiveLoaders = new SparseArrayCompat();
  final SparseArrayCompat<LoaderManagerImpl.LoaderInfo> mLoaders = new SparseArrayCompat();
  boolean mRetaining;
  boolean mRetainingStarted;
  boolean mStarted;
  final String mWho;
  
  LoaderManagerImpl(String paramString, FragmentActivity paramFragmentActivity, boolean paramBoolean)
  {
    this.mWho = paramString;
    this.mActivity = paramFragmentActivity;
    this.mStarted = paramBoolean;
  }
  
  private LoaderManagerImpl.LoaderInfo createAndInstallLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    try
    {
      this.mCreatingLoader = true;
      LoaderManagerImpl.LoaderInfo localLoaderInfo = createLoader(paramInt, paramBundle, paramLoaderCallbacks);
      installLoader(localLoaderInfo);
      return localLoaderInfo;
    }
    finally
    {
      this.mCreatingLoader = false;
    }
  }
  
  private LoaderManagerImpl.LoaderInfo createLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    LoaderManagerImpl.LoaderInfo localLoaderInfo = new LoaderManagerImpl.LoaderInfo(this, paramInt, paramBundle, paramLoaderCallbacks);
    localLoaderInfo.mLoader = paramLoaderCallbacks.onCreateLoader(paramInt, paramBundle);
    return localLoaderInfo;
  }
  
  public void destroyLoader(int paramInt)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (DEBUG) {
      new StringBuilder().append("destroyLoader in ").append(this).append(" of ").append(paramInt).toString();
    }
    int i = this.mLoaders.indexOfKey(paramInt);
    if (i >= 0)
    {
      LoaderManagerImpl.LoaderInfo localLoaderInfo2 = (LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i);
      this.mLoaders.removeAt(i);
      localLoaderInfo2.destroy();
    }
    int j = this.mInactiveLoaders.indexOfKey(paramInt);
    if (j >= 0)
    {
      LoaderManagerImpl.LoaderInfo localLoaderInfo1 = (LoaderManagerImpl.LoaderInfo)this.mInactiveLoaders.valueAt(j);
      this.mInactiveLoaders.removeAt(j);
      localLoaderInfo1.destroy();
    }
    if ((this.mActivity != null) && (!hasRunningLoaders())) {
      this.mActivity.mFragments.startPendingDeferredFragments();
    }
  }
  
  void doDestroy()
  {
    if (!this.mRetaining)
    {
      if (DEBUG) {
        new StringBuilder().append("Destroying Active in ").append(this).toString();
      }
      for (int j = -1 + this.mLoaders.size(); j >= 0; j--) {
        ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(j)).destroy();
      }
      this.mLoaders.clear();
    }
    if (DEBUG) {
      new StringBuilder().append("Destroying Inactive in ").append(this).toString();
    }
    for (int i = -1 + this.mInactiveLoaders.size(); i >= 0; i--) {
      ((LoaderManagerImpl.LoaderInfo)this.mInactiveLoaders.valueAt(i)).destroy();
    }
    this.mInactiveLoaders.clear();
  }
  
  void doReportNextStart()
  {
    for (int i = -1 + this.mLoaders.size(); i >= 0; i--) {
      ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).mReportNextStart = true;
    }
  }
  
  void doReportStart()
  {
    for (int i = -1 + this.mLoaders.size(); i >= 0; i--) {
      ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).reportStart();
    }
  }
  
  void doRetain()
  {
    if (DEBUG) {
      new StringBuilder().append("Retaining in ").append(this).toString();
    }
    if (!this.mStarted)
    {
      new RuntimeException("here").fillInStackTrace();
      new StringBuilder().append("Called doRetain when not started: ").append(this).toString();
    }
    for (;;)
    {
      return;
      this.mRetaining = true;
      this.mStarted = false;
      for (int i = -1 + this.mLoaders.size(); i >= 0; i--) {
        ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).retain();
      }
    }
  }
  
  void doStart()
  {
    if (DEBUG) {
      new StringBuilder().append("Starting in ").append(this).toString();
    }
    if (this.mStarted)
    {
      new RuntimeException("here").fillInStackTrace();
      new StringBuilder().append("Called doStart when already started: ").append(this).toString();
    }
    for (;;)
    {
      return;
      this.mStarted = true;
      for (int i = -1 + this.mLoaders.size(); i >= 0; i--) {
        ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).start();
      }
    }
  }
  
  void doStop()
  {
    if (DEBUG) {
      new StringBuilder().append("Stopping in ").append(this).toString();
    }
    if (!this.mStarted)
    {
      new RuntimeException("here").fillInStackTrace();
      new StringBuilder().append("Called doStop when not started: ").append(this).toString();
    }
    for (;;)
    {
      return;
      for (int i = -1 + this.mLoaders.size(); i >= 0; i--) {
        ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).stop();
      }
      this.mStarted = false;
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i = 0;
    if (this.mLoaders.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      String str2 = paramString + "    ";
      for (int j = 0; j < this.mLoaders.size(); j++)
      {
        LoaderManagerImpl.LoaderInfo localLoaderInfo2 = (LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(j);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.mLoaders.keyAt(j));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localLoaderInfo2.toString());
        localLoaderInfo2.dump(str2, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
    }
    if (this.mInactiveLoaders.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Inactive Loaders:");
      String str1 = paramString + "    ";
      while (i < this.mInactiveLoaders.size())
      {
        LoaderManagerImpl.LoaderInfo localLoaderInfo1 = (LoaderManagerImpl.LoaderInfo)this.mInactiveLoaders.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.mInactiveLoaders.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localLoaderInfo1.toString());
        localLoaderInfo1.dump(str1, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i++;
      }
    }
  }
  
  void finishRetain()
  {
    if (this.mRetaining)
    {
      if (DEBUG) {
        new StringBuilder().append("Finished Retaining in ").append(this).toString();
      }
      this.mRetaining = false;
      for (int i = -1 + this.mLoaders.size(); i >= 0; i--) {
        ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).finishRetain();
      }
    }
  }
  
  public <D> Loader<D> getLoader(int paramInt)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    LoaderManagerImpl.LoaderInfo localLoaderInfo = (LoaderManagerImpl.LoaderInfo)this.mLoaders.get(paramInt);
    Loader localLoader;
    if (localLoaderInfo != null) {
      if (localLoaderInfo.mPendingLoader != null) {
        localLoader = localLoaderInfo.mPendingLoader.mLoader;
      }
    }
    for (;;)
    {
      return localLoader;
      localLoader = localLoaderInfo.mLoader;
      continue;
      localLoader = null;
    }
  }
  
  public boolean hasRunningLoaders()
  {
    int i = this.mLoaders.size();
    int j = 0;
    boolean bool1 = false;
    if (j < i)
    {
      LoaderManagerImpl.LoaderInfo localLoaderInfo = (LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(j);
      if ((localLoaderInfo.mStarted) && (!localLoaderInfo.mDeliveredData)) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        bool1 |= bool2;
        j++;
        break;
      }
    }
    return bool1;
  }
  
  public <D> Loader<D> initLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    LoaderManagerImpl.LoaderInfo localLoaderInfo = (LoaderManagerImpl.LoaderInfo)this.mLoaders.get(paramInt);
    if (DEBUG) {
      new StringBuilder().append("initLoader in ").append(this).append(": args=").append(paramBundle).toString();
    }
    if (localLoaderInfo == null)
    {
      localLoaderInfo = createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks);
      if (DEBUG) {
        new StringBuilder().append("  Created new loader ").append(localLoaderInfo).toString();
      }
    }
    for (;;)
    {
      if ((localLoaderInfo.mHaveData) && (this.mStarted)) {
        localLoaderInfo.callOnLoadFinished(localLoaderInfo.mLoader, localLoaderInfo.mData);
      }
      return localLoaderInfo.mLoader;
      if (DEBUG) {
        new StringBuilder().append("  Re-using existing loader ").append(localLoaderInfo).toString();
      }
      localLoaderInfo.mCallbacks = paramLoaderCallbacks;
    }
  }
  
  void installLoader(LoaderManagerImpl.LoaderInfo paramLoaderInfo)
  {
    this.mLoaders.put(paramLoaderInfo.mId, paramLoaderInfo);
    if (this.mStarted) {
      paramLoaderInfo.start();
    }
  }
  
  public <D> Loader<D> restartLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    LoaderManagerImpl.LoaderInfo localLoaderInfo1 = (LoaderManagerImpl.LoaderInfo)this.mLoaders.get(paramInt);
    if (DEBUG) {
      new StringBuilder().append("restartLoader in ").append(this).append(": args=").append(paramBundle).toString();
    }
    if (localLoaderInfo1 != null)
    {
      LoaderManagerImpl.LoaderInfo localLoaderInfo2 = (LoaderManagerImpl.LoaderInfo)this.mInactiveLoaders.get(paramInt);
      if (localLoaderInfo2 == null) {
        break label272;
      }
      if (!localLoaderInfo1.mHaveData) {
        break label169;
      }
      if (DEBUG) {
        new StringBuilder().append("  Removing last inactive loader: ").append(localLoaderInfo1).toString();
      }
      localLoaderInfo2.mDeliveredData = false;
      localLoaderInfo2.destroy();
      localLoaderInfo1.mLoader.abandon();
      this.mInactiveLoaders.put(paramInt, localLoaderInfo1);
    }
    for (;;)
    {
      for (Loader localLoader = createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks).mLoader;; localLoader = localLoaderInfo1.mPendingLoader.mLoader)
      {
        return localLoader;
        label169:
        if (!localLoaderInfo1.mStarted)
        {
          this.mLoaders.put(paramInt, null);
          localLoaderInfo1.destroy();
          break;
        }
        if (localLoaderInfo1.mPendingLoader != null)
        {
          if (DEBUG) {
            new StringBuilder().append("  Removing pending loader: ").append(localLoaderInfo1.mPendingLoader).toString();
          }
          localLoaderInfo1.mPendingLoader.destroy();
          localLoaderInfo1.mPendingLoader = null;
        }
        localLoaderInfo1.mPendingLoader = createLoader(paramInt, paramBundle, paramLoaderCallbacks);
      }
      label272:
      if (DEBUG) {
        new StringBuilder().append("  Making last loader inactive: ").append(localLoaderInfo1).toString();
      }
      localLoaderInfo1.mLoader.abandon();
      this.mInactiveLoaders.put(paramInt, localLoaderInfo1);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    DebugUtils.buildShortClassTag(this.mActivity, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  void updateActivity(FragmentActivity paramFragmentActivity)
  {
    this.mActivity = paramFragmentActivity;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl
 * JD-Core Version:    0.7.0.1
 */