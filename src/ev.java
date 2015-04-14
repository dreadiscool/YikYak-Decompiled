import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class ev
  implements Handler.Callback
{
  ev(et paramet) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((1 == paramMessage.what) && (et.f().equals(paramMessage.obj)))
    {
      eJ.a().a(true);
      this.a.c();
      eJ.a().a(false);
      if ((et.b(this.a) > 0) && (!et.c(this.a))) {
        et.d(this.a).sendMessageDelayed(et.d(this.a).obtainMessage(1, et.f()), 1000 * et.b(this.a));
      }
    }
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ev
 * JD-Core Version:    0.7.0.1
 */