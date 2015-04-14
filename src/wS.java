import java.util.concurrent.Semaphore;
import org.json.JSONException;
import org.json.JSONObject;

public class wS
  implements Runnable
{
  private String b = null;
  private String c = null;
  private JSONObject d = null;
  private boolean e = false;
  
  protected wS(wR paramwR, String paramString1, String paramString2, JSONObject paramJSONObject, boolean paramBoolean)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramJSONObject;
    this.e = paramBoolean;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        wR.a(this.a).acquire();
        localJSONObject = new JSONObject();
      }
      catch (InterruptedException localInterruptedException)
      {
        JSONObject localJSONObject;
        int i;
        String str;
        localInterruptedException.printStackTrace();
        wR.a(this.a).release();
        continue;
      }
      finally
      {
        wR.a(this.a).release();
      }
      try
      {
        localJSONObject.put("link", this.b);
        localJSONObject.put("data", this.c);
        localJSONObject.put("post_body", this.d);
        localJSONObject.put("first_session", this.e);
        i = 1 + this.a.a();
        this.a.a(i);
        str = Integer.toString(i);
        this.a.a(localJSONObject, str);
        wR.a(this.a).release();
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        wR.a(this.a).release();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wS
 * JD-Core Version:    0.7.0.1
 */