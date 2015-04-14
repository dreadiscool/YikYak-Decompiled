import java.net.Socket;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;

class wj
  extends tv
{
  public wj(wg paramwg, URI paramURI, int paramInt, Socket paramSocket)
  {
    super(paramURI, new tD(), null, paramInt);
    a(paramSocket);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (uJ.a) {
      new StringBuilder().append("WebSocket closed. Code: ").append(paramInt).append(", reason: ").append(paramString).append("\nURI: ").append(wg.b(this.c)).toString();
    }
    wg.a(this.c).b();
  }
  
  public void a(Exception paramException)
  {
    if ((paramException != null) && (paramException.getMessage() != null)) {
      new StringBuilder().append("Websocket Error: ").append(paramException.getMessage()).toString();
    }
  }
  
  public void a(String paramString)
  {
    if (uJ.a) {
      new StringBuilder().append("Received message from editor:\n").append(paramString).toString();
    }
    JSONObject localJSONObject;
    String str;
    try
    {
      localJSONObject = new JSONObject(paramString);
      str = localJSONObject.getString("type");
      if (str.equals("device_info_request")) {
        wg.a(this.c).a();
      } else if (str.equals("snapshot_request")) {
        wg.a(this.c).a(localJSONObject);
      }
    }
    catch (JSONException localJSONException)
    {
      new StringBuilder().append("Bad JSON received:").append(paramString).toString();
    }
    if (str.equals("change_request")) {
      wg.a(this.c).b(localJSONObject);
    } else if (str.equals("event_binding_request")) {
      wg.a(this.c).c(localJSONObject);
    }
  }
  
  public void a(ua paramua) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wj
 * JD-Core Version:    0.7.0.1
 */