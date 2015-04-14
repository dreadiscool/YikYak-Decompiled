import android.content.Context;
import android.os.Message;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class uf
{
  private static int d = 0;
  private static int e = 1;
  private static int f = 2;
  private static int g = 5;
  private static int h = 12;
  private static int i = 13;
  private static final Map<Context, uf> j = new HashMap();
  private final uh a;
  private final Context b;
  private final uJ c;
  
  uf(Context paramContext)
  {
    this.b = paramContext;
    this.c = c(paramContext);
    this.a = new uh(this);
  }
  
  public static uf a(Context paramContext)
  {
    synchronized (j)
    {
      Context localContext = paramContext.getApplicationContext();
      if (!j.containsKey(localContext))
      {
        localuf = new uf(localContext);
        j.put(localContext, localuf);
        return localuf;
      }
      uf localuf = (uf)j.get(localContext);
    }
  }
  
  private void a(String paramString)
  {
    if (uJ.a) {
      new StringBuilder().append(paramString).append(" (Thread ").append(Thread.currentThread().getId()).append(")").toString();
    }
  }
  
  private void a(String paramString, Throwable paramThrowable)
  {
    if (uJ.a) {
      new StringBuilder().append(paramString).append(" (Thread ").append(Thread.currentThread().getId()).append(")").toString();
    }
  }
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = f;
    this.a.a(localMessage);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Message localMessage = Message.obtain();
    localMessage.what = d;
    localMessage.obj = paramJSONObject;
    this.a.a(localMessage);
  }
  
  public void a(ug paramug)
  {
    Message localMessage = Message.obtain();
    localMessage.what = e;
    localMessage.obj = paramug;
    this.a.a(localMessage);
  }
  
  public void a(ut paramut)
  {
    Message localMessage = Message.obtain();
    localMessage.what = h;
    localMessage.obj = paramut;
    this.a.a(localMessage);
  }
  
  protected uK b(Context paramContext)
  {
    return new uK(paramContext);
  }
  
  protected vh b()
  {
    return new vh();
  }
  
  protected uJ c(Context paramContext)
  {
    return uJ.a(paramContext);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     uf
 * JD-Core Version:    0.7.0.1
 */