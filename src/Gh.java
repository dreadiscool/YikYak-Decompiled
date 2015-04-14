import android.content.Context;
import android.os.Handler;
import java.io.IOException;
import org.json.JSONObject;

class Gh
  implements yZ
{
  Handler a = new Handler(Gd.c(this.c).getMainLooper());
  int b = 0;
  
  Gh(Gd paramGd) {}
  
  public void a(zF paramzF)
  {
    if ((this.c.getActivity() == null) || (!this.c.isAdded())) {}
    for (;;)
    {
      return;
      if (!paramzF.d()) {
        new StringBuilder().append("Failed:").append(paramzF.e()).append("").toString();
      } else {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramzF.h().f());
          this.a.post(new Gi(this, localJSONObject));
        }
        catch (Exception localException)
        {
          new StringBuilder().append("Failed:").append(localException.getMessage()).append("").toString();
        }
      }
    }
  }
  
  public void a(zz paramzz, IOException paramIOException)
  {
    if ((this.c.getActivity() == null) || (!this.c.isAdded())) {}
    for (;;)
    {
      return;
      this.a.post(new Gj(this));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Gh
 * JD-Core Version:    0.7.0.1
 */