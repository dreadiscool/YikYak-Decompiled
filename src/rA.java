import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

public class rA
{
  @VisibleForTesting
  static Map<String, String> a = new HashMap();
  private static String b;
  
  static String a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      if (paramString1.length() <= 0) {}
    }
    for (;;)
    {
      return paramString1;
      paramString1 = null;
      continue;
      paramString1 = Uri.parse("http://hostname/?" + paramString1).getQueryParameter(paramString2);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    rI.a(paramContext, "gtm_install_referrer", "referrer", paramString);
    b(paramContext, paramString);
  }
  
  public static void a(String paramString)
  {
    try
    {
      b = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static void b(Context paramContext, String paramString)
  {
    String str = a(paramString, "conv");
    if ((str != null) && (str.length() > 0))
    {
      a.put(str, paramString);
      rI.a(paramContext, "gtm_click_referrers", str, paramString);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     rA
 * JD-Core Version:    0.7.0.1
 */