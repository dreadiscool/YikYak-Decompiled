import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import java.io.IOException;
import org.json.JSONObject;

class Gu
  implements yZ
{
  Handler a = new Handler(this.d.getActivity().getMainLooper());
  int b = 0;
  
  Gu(Gt paramGt, Context paramContext) {}
  
  public void a(zF paramzF)
  {
    if ((this.d.getActivity() == null) || (!this.d.isAdded())) {}
    for (;;)
    {
      return;
      if (!paramzF.d()) {
        this.d.a(null);
      } else {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramzF.h().f());
          this.a.post(new Gv(this, localJSONObject));
        }
        catch (Exception localException)
        {
          this.d.a(null);
        }
      }
    }
  }
  
  public void a(zz paramzz, IOException paramIOException)
  {
    if ((this.d.getActivity() == null) || (!this.d.isAdded())) {}
    for (;;)
    {
      return;
      this.d.a(paramIOException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Gu
 * JD-Core Version:    0.7.0.1
 */