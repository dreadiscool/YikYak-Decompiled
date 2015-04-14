import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.concurrent.Semaphore;
import org.json.JSONObject;

public class wR
{
  private static long d = 0L;
  private SharedPreferences a;
  private Semaphore b;
  private wV c;
  
  public wR(Context paramContext, wV paramwV)
  {
    this.a = paramContext.getSharedPreferences("mat_queue", 0);
    this.b = new Semaphore(1, true);
    this.c = paramwV;
  }
  
  protected int a()
  {
    try
    {
      int i = this.a.getInt("queuesize", 0);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void a(int paramInt)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.a.edit();
      if (paramInt < 0) {
        paramInt = 0;
      }
      localEditor.putInt("queuesize", paramInt);
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void a(String paramString)
  {
    try
    {
      a(-1 + a());
      SharedPreferences.Editor localEditor = this.a.edit();
      localEditor.remove(paramString);
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.a.edit();
      localEditor.putString(paramString, paramJSONObject.toString());
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected String b(String paramString)
  {
    try
    {
      String str = this.a.getString(paramString, null);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wR
 * JD-Core Version:    0.7.0.1
 */