import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import java.io.IOException;
import org.json.JSONObject;

class Gx
  implements yZ
{
  Handler a = new Handler(this.e.getActivity().getMainLooper());
  int b = 0;
  
  Gx(Gw paramGw, Context paramContext, String paramString) {}
  
  public void a(zF paramzF)
  {
    if ((this.e.getActivity() == null) || (!this.e.isAdded())) {}
    for (;;)
    {
      return;
      if (!paramzF.d()) {
        this.e.a(null);
      } else {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramzF.h().f());
          this.a.post(new Gy(this, localJSONObject));
        }
        catch (Exception localException)
        {
          this.e.a(null);
        }
      }
    }
  }
  
  public void a(zz paramzz, IOException paramIOException)
  {
    if ((this.e.getActivity() == null) || (!this.e.isAdded())) {}
    for (;;)
    {
      return;
      this.e.a(paramIOException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Gx
 * JD-Core Version:    0.7.0.1
 */