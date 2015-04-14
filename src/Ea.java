import android.os.Handler;
import com.yik.yak.ui.activity.SendAYak;
import java.io.IOException;

public class Ea
  implements yZ
{
  Handler a = new Handler(this.c.getMainLooper());
  
  public Ea(SendAYak paramSendAYak, String paramString) {}
  
  public void a(zF paramzF)
  {
    if (!paramzF.d()) {}
    for (;;)
    {
      return;
      try
      {
        paramzF.h().f();
        this.a.post(new Eb(this));
      }
      catch (IOException localIOException) {}
    }
  }
  
  public void a(zz paramzz, IOException paramIOException)
  {
    this.a.post(new Ec(this, paramIOException));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ea
 * JD-Core Version:    0.7.0.1
 */