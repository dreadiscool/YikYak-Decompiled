import android.content.Context;
import android.net.Uri;
import java.util.Map;

class or
  implements ns
{
  private final Context a;
  
  public or(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a(Map<String, Object> paramMap)
  {
    Object localObject1 = paramMap.get("gtm.url");
    Object localObject3;
    if (localObject1 == null)
    {
      localObject3 = paramMap.get("gtm");
      if ((localObject3 == null) || (!(localObject3 instanceof Map))) {}
    }
    for (Object localObject2 = ((Map)localObject3).get("url");; localObject2 = localObject1)
    {
      if ((localObject2 == null) || (!(localObject2 instanceof String))) {}
      for (;;)
      {
        return;
        String str = Uri.parse((String)localObject2).getQueryParameter("referrer");
        if (str != null) {
          nJ.b(this.a, str);
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     or
 * JD-Core Version:    0.7.0.1
 */