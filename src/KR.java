import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

public class KR
  implements KQ
{
  private final SharedPreferences a;
  private final String b;
  private final Context c;
  
  public KR(IM paramIM)
  {
    this(paramIM.C(), paramIM.getClass().getName());
  }
  
  public KR(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }
    this.c = paramContext;
    this.b = paramString;
    this.a = this.c.getSharedPreferences(this.b, 0);
  }
  
  public SharedPreferences a()
  {
    return this.a;
  }
  
  @TargetApi(9)
  public boolean a(SharedPreferences.Editor paramEditor)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      paramEditor.apply();
    }
    for (boolean bool = true;; bool = paramEditor.commit()) {
      return bool;
    }
  }
  
  public SharedPreferences.Editor b()
  {
    return this.a.edit();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     KR
 * JD-Core Version:    0.7.0.1
 */