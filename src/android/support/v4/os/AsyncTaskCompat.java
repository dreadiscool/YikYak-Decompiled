package android.support.v4.os;

import android.os.AsyncTask;
import android.os.Build.VERSION;

public class AsyncTaskCompat
{
  public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> executeParallel(AsyncTask<Params, Progress, Result> paramAsyncTask, Params... paramVarArgs)
  {
    if (paramAsyncTask == null) {
      throw new IllegalArgumentException("task can not be null");
    }
    if (Build.VERSION.SDK_INT >= 11) {
      AsyncTaskCompatHoneycomb.executeParallel(paramAsyncTask, paramVarArgs);
    }
    for (;;)
    {
      return paramAsyncTask;
      paramAsyncTask.execute(paramVarArgs);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.os.AsyncTaskCompat
 * JD-Core Version:    0.7.0.1
 */