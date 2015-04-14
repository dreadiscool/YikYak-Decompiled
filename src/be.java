import android.annotation.TargetApi;
import android.os.Build.VERSION;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class be
  implements Kg<bb>
{
  public byte[] a(bb parambb)
  {
    return b(parambb).toString().getBytes("UTF-8");
  }
  
  @TargetApi(9)
  public JSONObject b(bb parambb)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      bd localbd = parambb.a;
      localJSONObject.put("appBundleId", localbd.a);
      localJSONObject.put("executionId", localbd.b);
      localJSONObject.put("installationId", localbd.c);
      localJSONObject.put("androidId", localbd.d);
      localJSONObject.put("advertisingId", localbd.e);
      localJSONObject.put("betaDeviceToken", localbd.f);
      localJSONObject.put("buildId", localbd.g);
      localJSONObject.put("osVersion", localbd.h);
      localJSONObject.put("deviceModel", localbd.i);
      localJSONObject.put("appVersionCode", localbd.j);
      localJSONObject.put("appVersionName", localbd.k);
      localJSONObject.put("timestamp", parambb.b);
      localJSONObject.put("type", parambb.c.toString());
      localJSONObject.put("details", new JSONObject(parambb.d));
      localJSONObject.put("customType", parambb.e);
      localJSONObject.put("customAttributes", new JSONObject(parambb.f));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        throw new IOException(localJSONException.getMessage(), localJSONException);
      }
      throw new IOException(localJSONException.getMessage());
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     be
 * JD-Core Version:    0.7.0.1
 */