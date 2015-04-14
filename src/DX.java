import android.os.Handler;
import com.yik.yak.ui.activity.SendAYak;
import java.io.IOException;

public class DX
  implements yZ
{
  Handler a = new Handler(this.b.getMainLooper());
  
  public DX(SendAYak paramSendAYak) {}
  
  public void a(zF paramzF)
  {
    if (!paramzF.d()) {}
    for (;;)
    {
      return;
      try
      {
        paramzF.h().f();
        this.a.post(new DY(this));
      }
      catch (IOException localIOException) {}
    }
  }
  
  public void a(zz paramzz, IOException paramIOException)
  {
    this.a.post(new DZ(this, paramIOException));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     DX
 * JD-Core Version:    0.7.0.1
 */