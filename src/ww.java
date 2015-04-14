import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Pair;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONObject;

@TargetApi(16)
public class ww
  implements wt, wv
{
  private final List<Pair<String, JSONObject>> a;
  private final List<Pair<String, JSONObject>> b;
  private final List<Pair<String, JSONObject>> c;
  private final List<Pair<String, JSONObject>> d;
  private final uJ e;
  private final vV f;
  private final SSLSocketFactory g;
  private final wa h;
  private final wd i;
  private final vs j;
  private final Map<String, String> k;
  private final wB l;
  
  public ww(Context paramContext, String paramString, MixpanelAPI paramMixpanelAPI)
  {
    this.e = uJ.a(paramContext);
    this.a = new ArrayList();
    this.b = new ArrayList();
    this.c = new ArrayList();
    this.d = new ArrayList();
    String str = this.e.q();
    if (str == null) {
      str = paramContext.getPackageName();
    }
    this.h = new wa(new vg(str, paramContext));
    this.i = new wd();
    this.j = new vs();
    this.k = paramMixpanelAPI.getDeviceInfo();
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new wA(this));
    HandlerThread localHandlerThread = new HandlerThread(ww.class.getCanonicalName());
    localHandlerThread.setPriority(10);
    localHandlerThread.start();
    this.l = new wB(this, paramContext, paramString, localHandlerThread.getLooper());
    this.l.sendMessage(this.l.obtainMessage(0));
    this.f = new vV(paramMixpanelAPI, this.l);
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localSSLContext.init(null, null, null);
      SSLSocketFactory localSSLSocketFactory2 = localSSLContext.getSocketFactory();
      localSSLSocketFactory1 = localSSLSocketFactory2;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      for (;;)
      {
        SSLSocketFactory localSSLSocketFactory1 = null;
      }
    }
    this.g = localSSLSocketFactory1;
  }
  
  public void a(String paramString)
  {
    Message localMessage = this.l.obtainMessage();
    localMessage.what = 9;
    localMessage.obj = paramString;
    this.l.sendMessage(localMessage);
  }
  
  public void a(JSONArray paramJSONArray)
  {
    Message localMessage = this.l.obtainMessage(6);
    localMessage.obj = paramJSONArray;
    this.l.sendMessage(localMessage);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ww
 * JD-Core Version:    0.7.0.1
 */