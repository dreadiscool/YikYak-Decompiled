package android.support.v4.app;

import android.os.Handler;
import android.os.Message;

class FragmentActivity$1
  extends Handler
{
  FragmentActivity$1(FragmentActivity paramFragmentActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    }
    for (;;)
    {
      return;
      if (this.this$0.mStopped)
      {
        this.this$0.doReallyStop(false);
        continue;
        this.this$0.onResumeFragments();
        this.this$0.mFragments.execPendingActions();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentActivity.1
 * JD-Core Version:    0.7.0.1
 */