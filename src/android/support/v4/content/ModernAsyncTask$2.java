package android.support.v4.content;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

class ModernAsyncTask$2
  extends ModernAsyncTask.WorkerRunnable<Params, Result>
{
  ModernAsyncTask$2(ModernAsyncTask paramModernAsyncTask)
  {
    super(null);
  }
  
  public Result call()
  {
    ModernAsyncTask.access$200(this.this$0).set(true);
    Process.setThreadPriority(10);
    return ModernAsyncTask.access$300(this.this$0, this.this$0.doInBackground(this.mParams));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.ModernAsyncTask.2
 * JD-Core Version:    0.7.0.1
 */