import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.yik.yak.YikYak;
import java.io.IOException;

class CP
  implements yZ
{
  Handler a = new Handler(CM.b(this.e).getMainLooper());
  int b = 0;
  
  CP(CM paramCM, Handler.Callback paramCallback, String paramString) {}
  
  public void a(zF paramzF)
  {
    if (!paramzF.d()) {
      return;
    }
    for (;;)
    {
      Message localMessage2;
      Message localMessage1;
      try
      {
        String str = paramzF.h().f();
        localMessage2 = new Message();
        if (!str.equals("1")) {
          break label119;
        }
        ApplicationConfig.a(this.d);
        // TODO: Find out what this.d is
        YikYak.a(this.d);
        localMessage2.arg1 = 1;
        If.a().m();
        if (this.c == null) {
          break;
        }
        this.c.handleMessage(localMessage2);
      }
      catch (IOException localIOException)
      {
        localMessage1 = new Message();
      }
      if (this.c == null) {
        break;
      }
      localMessage1.arg1 = 0;
      this.c.handleMessage(localMessage1);
      break;
      label119:
      localMessage2.arg1 = -1;
      ApplicationConfig.a("");
    }
  }
  
  public void a(zz paramzz, IOException paramIOException)
  {
    Message localMessage = new Message();
    if (this.c != null)
    {
      localMessage.arg1 = 0;
      this.c.handleMessage(localMessage);
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     CP

 * JD-Core Version:    0.7.0.1

 */