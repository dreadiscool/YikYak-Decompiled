import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.yik.yak.YikYak;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CV
{
  private static CV a = new CV();
  private static List<CG> b = null;
  private static HashMap<String, Handler> c = new HashMap();
  private static List<CG> d = null;
  private static List<CG> e = null;
  private static HashMap<String, CG> f = null;
  private static HashMap<String, CG> g = null;
  private static int h = 0;
  private static boolean i = false;
  
  public CV()
  {
    if (b == null) {
      b = new ArrayList();
    }
    SharedPreferences localSharedPreferences = ApplicationConfig.getSharedPreferences();
    if ((localSharedPreferences.contains("myPeekLocations")) && (Ik.a(YikYak.getContext(), localSharedPreferences.getString("myPeekLocations", ""), "myPeekLocations.json")))
    {
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      localEditor.remove("myPeekLocations");
      localEditor.apply();
    }
  }
  
  public static String a(Location paramLocation)
  {
    if ((f == null) || (f.size() == 0)) {
      d();
    }
    if (f.size() == 1)
    {
      String str = (String)f.keySet().toArray()[0];
      if (((CG)f.get(str)).k) {
        f.remove(str);
      }
    }
    CG localCG = new CG("My Peeks", paramLocation.getProvider(), String.valueOf(paramLocation.getLatitude()), String.valueOf(paramLocation.getLongitude()), UUID.randomUUID().toString(), false);
    f.put(localCG.i, localCG);
    b(CX.a);
    If.a().b(localCG);
    return localCG.i;
  }
  
  public static void a()
  {
    if (d == null) {
      d = new ArrayList();
    }
    if (f == null) {
      f = new HashMap();
    }
    if (e == null) {
      e = new ArrayList();
    }
    b = new ArrayList();
    b.add(new CG("Featured", "Featured", 0, "0", 0, 0, 0));
    b.addAll(e);
    b.add(new CG("My Peeks", "My Peeks", 0, "", 0, 0, 0));
    b.addAll(e());
    b.add(new CG("Peek Near", "Peek Near", 0, "0", 0, 0, 0));
    b.addAll(d);
    g();
  }
  
  public static void a(CG paramCG)
  {
    if (g == null) {}
    for (;;)
    {
      return;
      if (g.containsKey(paramCG.i))
      {
        ((CG)g.get(paramCG.i)).m = false;
        b(CX.d);
      }
    }
  }
  
  public static void a(CX paramCX)
  {
    for (;;)
    {
      int j;
      JSONObject localJSONObject;
      String str3;
      try
      {
        String str1;
        if (paramCX == CX.a)
        {
          str1 = "myPeekLocations";
          f = new HashMap();
          String str2 = Ik.a(YikYak.getContext(), str1 + ".json");
          if (Ik.a(str2)) {
            break label295;
          }
          JSONArray localJSONArray = new JSONObject(str2).getJSONArray(str1);
          if (localJSONArray.length() <= 0) {
            break label282;
          }
          j = 0;
          if (j < localJSONArray.length())
          {
            localJSONObject = localJSONArray.getJSONObject(j);
            str3 = UUID.randomUUID().toString();
            if (paramCX != CX.a) {
              break label209;
            }
            CG localCG1 = new CG("My Peeks", localJSONObject.getString("location"), localJSONObject.getString("latitude"), localJSONObject.getString("longitude"), localJSONObject.optString("id", str3), false);
            f.put(localCG1.i, localCG1);
            break label308;
          }
        }
        else if (paramCX == CX.d)
        {
          str1 = "visitedPeeks";
          g = new HashMap();
          continue;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        if (paramCX == CX.a) {
          h();
        }
      }
      for (;;)
      {
        label209:
        CG localCG2 = new CG("Visited", localJSONObject.getString("location"), null, null, localJSONObject.optString("id", str3), false);
        localCG2.l = false;
        localCG2.m = localJSONObject.getBoolean("isUnread");
        g.put(localJSONObject.optString("id", str3), localCG2);
        break;
        label282:
        if (paramCX == CX.a)
        {
          h();
          continue;
          label295:
          if (paramCX == CX.a) {
            h();
          }
        }
      }
      label308:
      j++;
    }
  }
  
  public static void a(String paramString)
  {
    c.remove(paramString);
  }
  
  public static void a(String paramString, Handler.Callback paramCallback)
  {
    if (a == null) {
      a = new CV();
    }
    Handler localHandler = new Handler(paramCallback);
    c.put(paramString, localHandler);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (f == null) {
      d();
    }
    CG localCG = (CG)f.get(paramString1);
    if (localCG != null)
    {
      localCG.b = paramString2;
      f.put(localCG.i, localCG);
    }
    b(CX.a);
    a();
  }
  
  public static void a(List<CG> paramList)
  {
    h = 0;
    if (a == null) {
      a = new CV();
    }
    b = paramList;
    if (b == null) {
      b = new ArrayList();
    }
    d = new ArrayList();
    f = new HashMap();
    e = new ArrayList();
    if ((g == null) || (g.size() == 0)) {
      a(CX.d);
    }
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      CG localCG1 = (CG)localIterator.next();
      if (!localCG1.a())
      {
        if (localCG1.a.equals("Featured"))
        {
          CG localCG2 = (CG)g.get(localCG1.i);
          if (localCG2 == null)
          {
            h = 1 + h;
            localCG1.l = true;
            localCG1.m = true;
            b(localCG1);
          }
          for (;;)
          {
            e.add(localCG1);
            break;
            localCG2.l = false;
            localCG1.l = false;
            localCG1.m = localCG2.m;
          }
        }
        if (localCG1.a.equals("My Peeks")) {
          f.put(localCG1.i, localCG1);
        } else if (localCG1.a.equals("Peek Near")) {
          d.add(localCG1);
        }
      }
    }
    i = true;
    g();
  }
  
  public static CG b(String paramString)
  {
    CG localCG;
    if ((b == null) || (b.size() == 0)) {
      localCG = null;
    }
    for (;;)
    {
      return localCG;
      for (int j = 0;; j++)
      {
        if (j >= b.size()) {
          break label65;
        }
        localCG = (CG)b.get(j);
        if (localCG.i.equals(paramString)) {
          break;
        }
      }
      label65:
      localCG = null;
    }
  }
  
  public static void b()
  {
    if (g == null) {}
    for (;;)
    {
      return;
      b(CX.d);
      h = 0;
      g();
    }
  }
  
  private static void b(CG paramCG)
  {
    CG localCG = new CG(paramCG.a, paramCG.b, paramCG.c, paramCG.d, paramCG.i, false);
    localCG.l = true;
    localCG.m = true;
    g.put(localCG.i, localCG);
  }
  
  private static void b(CX paramCX)
  {
    String str = "";
    JSONObject localJSONObject1;
    JSONArray localJSONArray;
    Collection localCollection;
    try
    {
      if ((paramCX == CX.a) && (f != null) && (f.size() != 0))
      {
        str = "myPeekLocations";
        localJSONObject1 = new JSONObject();
        localJSONArray = new JSONArray();
        if (paramCX != CX.a) {
          break label292;
        }
        localCollection = f.values();
        label61:
        Iterator localIterator = localCollection.iterator();
        while (localIterator.hasNext())
        {
          CG localCG = (CG)localIterator.next();
          if (!localCG.k)
          {
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("section", "My Peeks");
            localJSONObject2.put("location", localCG.b);
            localJSONObject2.put("latitude", localCG.c);
            localJSONObject2.put("longitude", localCG.d);
            localJSONObject2.put("id", localCG.i);
            if (paramCX == CX.d)
            {
              localJSONObject2.put("isNew", false);
              localJSONObject2.put("isUnread", localCG.m);
            }
            localJSONArray.put(localJSONObject2);
            continue;
            return;
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      new StringBuilder().append("save ").append(str).toString();
      new StringBuilder().append("Failed:").append(localJSONException.toString()).toString();
    }
    for (;;)
    {
      if ((paramCX == CX.d) && (g != null) && (g.size() != 0))
      {
        str = "visitedPeeks";
        break;
        label292:
        localCollection = g.values();
        break label61;
        localJSONObject1.put(str, localJSONArray);
        Ik.a(YikYak.getContext(), localJSONObject1.toString(), str + ".json");
      }
    }
  }
  
  public static CG c(String paramString)
  {
    if (f == null) {
      f = new HashMap();
    }
    return (CG)f.get(paramString);
  }
  
  public static List<CG> c()
  {
    if (a == null) {
      a = new CV();
    }
    return b;
  }
  
  public static List<CG> d()
  {
    a(CX.a);
    return e();
  }
  
  public static void d(String paramString)
  {
    if (f == null) {
      d();
    }
    if (f.get(paramString) != null) {
      f.remove(paramString);
    }
    if (f.size() == 0) {
      h();
    }
    b(CX.a);
  }
  
  public static List<CG> e()
  {
    ArrayList localArrayList1 = new ArrayList(f.entrySet());
    Collections.sort(localArrayList1, new CW());
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext()) {
      localArrayList2.add(((Map.Entry)localIterator.next()).getValue());
    }
    return localArrayList2;
  }
  
  public static int f()
  {
    if (f == null) {
      f = new HashMap();
    }
    int j;
    if (f.size() > 1) {
      j = f.size();
    }
    for (;;)
    {
      return j;
      if (f.size() == 1)
      {
        String str = (String)f.keySet().toArray()[0];
        if (((CG)f.get(str)).k) {
          j = 0;
        } else {
          j = 1;
        }
      }
      else
      {
        j = 0;
      }
    }
  }
  
  private static void g()
  {
    if ((c != null) && (c.size() != 0))
    {
      int j = h;
      Iterator localIterator = c.values().iterator();
      while (localIterator.hasNext())
      {
        Handler localHandler = (Handler)localIterator.next();
        Message localMessage = new Message();
        localMessage.arg1 = j;
        localHandler.sendMessage(localMessage);
      }
    }
  }
  
  private static void h()
  {
    String str = UUID.randomUUID().toString();
    if (f == null) {
      f = new HashMap();
    }
    f.put(str, new CG("My Peeks", "Tap the magnifying glass here or in the upper right corner to find and save Peek locations.", "0", "0", str, true));
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     CV

 * JD-Core Version:    0.7.0.1

 */