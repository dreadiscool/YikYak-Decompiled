import java.io.IOException;
import java.util.HashMap;
import org.json.JSONObject;

final class Da
  implements yZ
{
  Da(String paramString) {}
  
  public void a(zF paramzF)
  {
    if (!paramzF.d()) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramzF.h().f());
        CZ.d().put(this.a, localJSONObject);
        if (localJSONObject.getJSONObject("refresh_asset") != null) {
          CZ.a(CZ.e(), localJSONObject);
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public void a(zz paramzz, IOException paramIOException) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Da
 * JD-Core Version:    0.7.0.1
 */