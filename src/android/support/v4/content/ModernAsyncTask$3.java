package android.support.v4.content;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class ModernAsyncTask$3
  extends FutureTask<Result>
{
  ModernAsyncTask$3(ModernAsyncTask paramModernAsyncTask, Callable paramCallable)
  {
    super(paramCallable);
  }
  
  protected void done()
  {
    try
    {
      Object localObject = get();
      ModernAsyncTask.access$400(this.this$0, localObject);
      label15:
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      throw new RuntimeException("An error occured while executing doInBackground()", localExecutionException.getCause());
    }
    catch (CancellationException localCancellationException)
    {
      for (;;)
      {
        ModernAsyncTask.access$400(this.this$0, null);
      }
    }
    catch (Throwable localThrowable)
    {
      throw new RuntimeException("An error occured while executing doInBackground()", localThrowable);
    }
    catch (InterruptedException localInterruptedException)
    {
      break label15;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.ModernAsyncTask.3
 * JD-Core Version:    0.7.0.1
 */