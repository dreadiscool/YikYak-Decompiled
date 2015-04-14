import android.content.Context;
import android.os.Handler;
import com.yik.yak.data.models.YakkerLocation;
import java.io.IOException;
import org.json.JSONObject;

class FS
  implements yZ
{
  Handler a = new Handler(this.f.r.getMainLooper());
  int b = 0;
  
  FS(FR paramFR, YakkerLocation paramYakkerLocation, CM paramCM, Context paramContext) {}
  
  public void a(zF paramzF)
  {
    if ((this.f.getActivity() == null) || (!this.f.isAdded())) {}
    for (;;)
    {
      return;
      if (!paramzF.d()) {
        this.f.a(null);
      } else {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramzF.h().f());
          this.a.post(new FT(this, localJSONObject));
        }
        catch (Exception localException)
        {
          this.f.a(null);
        }
      }
    }
  }
  
  public void a(zz paramzz, IOException paramIOException)
  {
    if ((this.f.getActivity() == null) || (!this.f.isAdded())) {}
    for (;;)
    {
      return;
      this.f.a(paramIOException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     FS
 * JD-Core Version:    0.7.0.1
 */