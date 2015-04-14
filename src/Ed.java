import android.os.Handler;
import com.yik.yak.ui.activity.SendAYak;
import java.io.IOException;

public class Ed
  implements yZ
{
  Handler a = new Handler(this.c.getMainLooper());
  
  public Ed(SendAYak paramSendAYak, String paramString) {}
  
  public void a(zF paramzF)
  {
    if (!paramzF.d()) {
      a(null, new IOException());
    }
    for (;;)
    {
      return;
      try
      {
        String str = paramzF.h().f();
        SendAYak.a(this.c, new Ei(this.c, null));
        if (SendAYak.g(this.c).a(str, this.b, SendAYak.f(this.c))) {
          SendAYak.g(this.c).execute(new Void[0]);
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        a(null, new IOException());
      }
    }
  }
  
  public void a(zz paramzz, IOException paramIOException)
  {
    this.a.post(new Ee(this, paramIOException));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ed
 * JD-Core Version:    0.7.0.1
 */