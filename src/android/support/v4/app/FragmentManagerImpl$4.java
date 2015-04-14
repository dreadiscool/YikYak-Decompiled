package android.support.v4.app;

class FragmentManagerImpl$4
  implements Runnable
{
  FragmentManagerImpl$4(FragmentManagerImpl paramFragmentManagerImpl, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.this$0.popBackStackState(this.this$0.mActivity.mHandler, null, this.val$id, this.val$flags);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */