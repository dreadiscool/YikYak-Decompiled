import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class CZ
{
  public static HashMap<String, Bitmap> a = new HashMap();
  public static HashMap<String, Bitmap> b = new HashMap();
  public static Drawable c;
  private static HashMap<String, JSONObject> d;
  private static Context e;
  private static int f = 0;
  private static boolean g = false;
  private static HashMap<String, String> h = new HashMap();
  private static HashMap<String, String> i = new HashMap();
  private static HashMap<String, String> j = new HashMap();
  private static CZ k = new CZ();
  
  public static CZ a()
  {
    try
    {
      if (k == null) {
        k = new CZ();
      }
      if (d == null) {
        d = new HashMap();
      }
      CZ localCZ = k;
      return localCZ;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static Bitmap a(int paramInt)
  {
    return (Bitmap)a.get(String.valueOf(paramInt));
  }
  
  public static String a(String paramString)
  {
    if (h != null) {}
    for (String str = (String)h.get(paramString);; str = null) {
      return str;
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a();
    g = false;
    e = paramContext;
    if (d.containsKey(paramString)) {
      a(e, (JSONObject)d.get(paramString));
    }
    for (;;)
    {
      return;
      zz localzz = new zB().a(paramString).b();
      UrlHelper.a(true).a(localzz).a(new Da(paramString));
    }
  }
  
  public static void a(Context paramContext, JSONObject paramJSONObject)
  {
    f = paramContext.getResources().getDisplayMetrics().densityDpi;
    e = paramContext;
    h = new HashMap();
    System.gc();
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("refresh_asset");
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        h.put(str, localJSONObject.getString(str));
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      new Dc(null).execute(new Void[0]);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    g = paramBoolean;
    e.sendBroadcast(new Intent("REFRESH_ASSET_READY"));
  }
  
  public static int b()
  {
    try
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(0xFFFFFF & Integer.valueOf((String)h.get("background_color")).intValue());
      int n = Color.parseColor(String.format("#%06X", arrayOfObject));
      m = n;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int m = 0;
      }
    }
    return m;
  }
  
  public static Bitmap b(int paramInt)
  {
    return (Bitmap)b.get(String.valueOf(paramInt));
  }
  
  private static int c(String paramString)
  {
    String[] arrayOfString = paramString.substring(0, -4 + paramString.length()).split("-");
    try
    {
      int n = Integer.valueOf(arrayOfString[(-1 + arrayOfString.length)]).intValue();
      m = n;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int m = -1;
      }
    }
    return m;
  }
  
  public static boolean c()
  {
    return g;
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     CZ

 * JD-Core Version:    0.7.0.1

 */