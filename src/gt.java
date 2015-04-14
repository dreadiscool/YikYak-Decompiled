import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class gt
  implements Handler.Callback
{
  gt(gr paramgr) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((1 == paramMessage.what) && (gr.f().equals(paramMessage.obj)))
    {
      gH.a().a(true);
      this.a.a();
      gH.a().a(false);
      if ((gr.b(this.a) > 0) && (!gr.c(this.a))) {
        gr.d(this.a).sendMessageDelayed(gr.d(this.a).obtainMessage(1, gr.f()), 1000 * gr.b(this.a));
      }
    }
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gt
 * JD-Core Version:    0.7.0.1
 */