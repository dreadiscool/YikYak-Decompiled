import android.os.Message;
import org.json.JSONObject;

class wy
  implements wi
{
  private wy(ww paramww) {}
  
  public void a()
  {
    Message localMessage = ww.a(this.a).obtainMessage(4);
    ww.a(this.a).sendMessage(localMessage);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Message localMessage = ww.a(this.a).obtainMessage(2);
    localMessage.obj = paramJSONObject;
    ww.a(this.a).sendMessage(localMessage);
  }
  
  public void b()
  {
    Message localMessage = ww.a(this.a).obtainMessage(10);
    ww.a(this.a).sendMessage(localMessage);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    Message localMessage = ww.a(this.a).obtainMessage(3);
    localMessage.obj = paramJSONObject;
    ww.a(this.a).sendMessage(localMessage);
  }
  
  public void c(JSONObject paramJSONObject)
  {
    Message localMessage = ww.a(this.a).obtainMessage(8);
    localMessage.obj = paramJSONObject;
    ww.a(this.a).sendMessage(localMessage);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wy
 * JD-Core Version:    0.7.0.1
 */