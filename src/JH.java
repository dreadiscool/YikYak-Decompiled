import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class JH
  extends FutureTask<Result>
{
  JH(JE paramJE, Callable paramCallable)
  {
    super(paramCallable);
  }
  
  protected void done()
  {
    try
    {
      JE.b(this.a, get());
      label11:
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
        JE.b(this.a, null);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label11;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     JH
 * JD-Core Version:    0.7.0.1
 */