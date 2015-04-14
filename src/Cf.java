import android.os.Handler;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class Cf
  implements yZ
{
  Cf(Ce paramCe, Class paramClass, Handler paramHandler, Cj paramCj, zz paramzz) {}
  
  private void a(Exception paramException)
  {
    this.b.post(new Ch(this, paramException));
  }
  
  public void a(zF paramzF)
  {
    String str;
    Object localObject;
    if (paramzF.d())
    {
      str = paramzF.h().f();
      if (this.a != null)
      {
        localObject = Ir.a.a(str, this.a);
        this.b.post(new Cg(this, paramzF, localObject));
      }
    }
    for (;;)
    {
      for (;;)
      {
        return;
        try
        {
          localObject = new JSONObject(str);
        }
        catch (JSONException localJSONException1)
        {
          try
          {
            localObject = new JSONArray(str);
          }
          catch (JSONException localJSONException2)
          {
            localJSONException1.printStackTrace();
            localJSONException2.printStackTrace();
            a(localJSONException1);
          }
        }
      }
      continue;
      a(null);
    }
  }
  
  public void a(zz paramzz, IOException paramIOException)
  {
    a(paramIOException);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Cf
 * JD-Core Version:    0.7.0.1
 */