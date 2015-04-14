import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

class vj
  implements Callable<SharedPreferences>
{
  private final Context a;
  private final String b;
  private final vk c;
  
  public vj(Context paramContext, String paramString, vk paramvk)
  {
    this.a = paramContext;
    this.b = paramString;
    this.c = paramvk;
  }
  
  public SharedPreferences a()
  {
    SharedPreferences localSharedPreferences = this.a.getSharedPreferences(this.b, 0);
    if (this.c != null) {
      this.c.a(localSharedPreferences);
    }
    return localSharedPreferences;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vj
 * JD-Core Version:    0.7.0.1
 */