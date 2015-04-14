package android.support.v4.content;

import android.os.Handler;
import android.os.Message;

class ModernAsyncTask$InternalHandler
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    ModernAsyncTask.AsyncTaskResult localAsyncTaskResult = (ModernAsyncTask.AsyncTaskResult)paramMessage.obj;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      ModernAsyncTask.access$500(localAsyncTaskResult.mTask, localAsyncTaskResult.mData[0]);
      continue;
      localAsyncTaskResult.mTask.onProgressUpdate(localAsyncTaskResult.mData);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.ModernAsyncTask.InternalHandler
 * JD-Core Version:    0.7.0.1
 */