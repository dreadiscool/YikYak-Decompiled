import android.content.Context;
import android.os.Handler;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class EY
  implements yZ
{
  Handler a = new Handler(this.d.r.getMainLooper());
  int b = 0;
  
  EY(EX paramEX, Context paramContext) {}
  
  public void a(zF paramzF)
  {
    if ((this.d.getActivity() == null) || (!this.d.isAdded())) {}
    for (;;)
    {
      return;
      if (!paramzF.d())
      {
        this.d.a(null);
        continue;
      }
      try
      {
        localJSONObject = new JSONObject(paramzF.h().f());
        this.a.post(new EZ(this, localJSONObject));
      }
      catch (JSONException localJSONException)
      {
        this.d.a(null);
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
    this.d.a(paramIOException);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     EY
 * JD-Core Version:    0.7.0.1
 */