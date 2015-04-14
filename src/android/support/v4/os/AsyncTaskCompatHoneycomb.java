package android.support.v4.os;

import android.os.AsyncTask;

class AsyncTaskCompatHoneycomb
{
  static <Params, Progress, Result> void executeParallel(AsyncTask<Params, Progress, Result> paramAsyncTask, Params... paramVarArgs)
  {
    paramAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramVarArgs);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.os.AsyncTaskCompatHoneycomb
 * JD-Core Version:    0.7.0.1
 */