import android.content.Context;
import android.os.Handler;
import com.yik.yak.ui.activity.PeekSearchActivity;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class Dt
  implements yZ
{
  Handler a = new Handler(PeekSearchActivity.f(this.b).getMainLooper());
  
  public Dt(PeekSearchActivity paramPeekSearchActivity) {}
  
  public void a(zF paramzF)
  {
    if (!paramzF.d()) {
      new StringBuilder().append("Failed:").append(paramzF.e()).append("").toString();
    }
    for (;;)
    {
      return;
      try
      {
        localJSONObject = new JSONObject(paramzF.h().f());
        this.a.post(new Du(this, localJSONObject));
      }
      catch (JSONException localJSONException)
      {
        new StringBuilder().append("Failed:").append(localJSONException.getMessage()).append("").toString();
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          JSONObject localJSONObject = null;
        }
      }
    }
  }
  
  public void a(zz paramzz, IOException paramIOException)
  {
    this.a.post(new Dv(this, paramIOException));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Dt
 * JD-Core Version:    0.7.0.1
 */