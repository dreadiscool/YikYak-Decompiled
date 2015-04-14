import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import java.lang.reflect.Field;
import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import org.json.JSONObject;

public class Js
{
  private static final Pattern a = Pattern.compile("[^\\p{Alnum}]");
  private static final String b = Pattern.quote("/");
  private final ReentrantLock c = new ReentrantLock();
  private final Ju d;
  private final boolean e;
  private final boolean f;
  private final Context g;
  private final String h;
  private final String i;
  private final Collection<IM> j;
  
  public Js(Context paramContext, String paramString1, String paramString2, Collection<IM> paramCollection)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("appContext must not be null");
    }
    if (paramString1 == null) {
      throw new IllegalArgumentException("appIdentifier must not be null");
    }
    if (paramCollection == null) {
      throw new IllegalArgumentException("kits must not be null");
    }
    this.g = paramContext;
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramCollection;
    this.d = new Ju();
    this.e = Jg.a(paramContext, "com.crashlytics.CollectDeviceIdentifiers", true);
    if (!this.e)
    {
      IC.g();
      new StringBuilder().append("Device ID collection disabled for ").append(paramContext.getPackageName()).toString();
    }
    this.f = Jg.a(paramContext, "com.crashlytics.CollectUserIdentifiers", true);
    if (!this.f)
    {
      IC.g();
      new StringBuilder().append("User information collection disabled for ").append(paramContext.getPackageName()).toString();
    }
  }
  
  private String a(SharedPreferences paramSharedPreferences)
  {
    this.c.lock();
    try
    {
      String str = paramSharedPreferences.getString("crashlytics.installation.id", null);
      if (str == null)
      {
        str = b(UUID.randomUUID().toString());
        paramSharedPreferences.edit().putString("crashlytics.installation.id", str).commit();
      }
      return str;
    }
    finally
    {
      this.c.unlock();
    }
  }
  
  private void a(Map<Jt, String> paramMap, Jt paramJt, String paramString)
  {
    if (paramString != null) {
      paramMap.put(paramJt, paramString);
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("APPLICATION_INSTALLATION_UUID".toLowerCase(Locale.US), b());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IC.g();
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if (this.g.checkCallingPermission(paramString) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private String b(String paramString)
  {
    if (paramString == null) {}
    for (String str = null;; str = a.matcher(paramString).replaceAll("").toLowerCase(Locale.US)) {
      return str;
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    Iterator localIterator = g().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      try
      {
        paramJSONObject.put(((Jt)localEntry.getKey()).name().toLowerCase(Locale.US), localEntry.getValue());
      }
      catch (Exception localException)
      {
        IC.g();
        new StringBuilder().append("Could not write value to JSON: ").append(((Jt)localEntry.getKey()).name()).toString();
      }
    }
  }
  
  private String c(String paramString)
  {
    return paramString.replaceAll(b, "");
  }
  
  private void c(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("os_version", d());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IC.g();
      }
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("model", e());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IC.g();
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    try
    {
      char[] arrayOfChar = new char[3];
      arrayOfChar[0] = 115;
      arrayOfChar[1] = 108;
      arrayOfChar[2] = 99;
      String str1 = paramString2.replaceAll("\\.", new StringBuilder(new String(arrayOfChar)).reverse().toString());
      localCipher = Jg.a(1, Jg.a(paramString1 + str1));
      localJSONObject = new JSONObject();
      a(localJSONObject);
      b(localJSONObject);
      c(localJSONObject);
      d(localJSONObject);
      localObject = "";
      if (localJSONObject.length() <= 0) {}
    }
    catch (GeneralSecurityException localGeneralSecurityException1)
    {
      for (;;)
      {
        Cipher localCipher;
        JSONObject localJSONObject;
        String str2;
        label148:
        IC.g();
        Object localObject = "";
      }
    }
    try
    {
      str2 = Jg.a(localCipher.doFinal(localJSONObject.toString().getBytes()));
      localObject = str2;
    }
    catch (GeneralSecurityException localGeneralSecurityException2)
    {
      IC.g();
      break label148;
    }
    return localObject;
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public String b()
  {
    String str = this.i;
    if (str == null)
    {
      SharedPreferences localSharedPreferences = Jg.a(this.g);
      str = localSharedPreferences.getString("crashlytics.installation.id", null);
      if (str == null) {
        str = a(localSharedPreferences);
      }
    }
    return str;
  }
  
  public String c()
  {
    return this.h;
  }
  
  public String d()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = c(Build.VERSION.RELEASE);
    arrayOfObject[1] = c(Build.VERSION.INCREMENTAL);
    return String.format(localLocale, "%s/%s", arrayOfObject);
  }
  
  public String e()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = c(Build.MANUFACTURER);
    arrayOfObject[1] = c(Build.MODEL);
    return String.format(localLocale, "%s/%s", arrayOfObject);
  }
  
  public String f()
  {
    String str = "";
    if (this.e)
    {
      str = j();
      if (str == null)
      {
        SharedPreferences localSharedPreferences = Jg.a(this.g);
        str = localSharedPreferences.getString("crashlytics.installation.id", null);
        if (str == null) {
          str = a(localSharedPreferences);
        }
      }
    }
    return str;
  }
  
  public Map<Jt, String> g()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.j.iterator();
    while (localIterator1.hasNext())
    {
      IM localIM = (IM)localIterator1.next();
      if ((localIM instanceof Jn))
      {
        Iterator localIterator2 = ((Jn)localIM).e().entrySet().iterator();
        while (localIterator2.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator2.next();
          a(localHashMap, (Jt)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
    }
    a(localHashMap, Jt.d, j());
    a(localHashMap, Jt.e, k());
    a(localHashMap, Jt.f, n());
    a(localHashMap, Jt.a, l());
    a(localHashMap, Jt.b, m());
    a(localHashMap, Jt.g, i());
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public String h()
  {
    return this.d.a(this.g);
  }
  
  public String i()
  {
    String str = null;
    if (this.e)
    {
      IV localIV = new IW(this.g).a();
      if (localIV != null) {
        str = localIV.a;
      }
    }
    return str;
  }
  
  public String j()
  {
    String str1 = null;
    if (this.e)
    {
      String str2 = Settings.Secure.getString(this.g.getContentResolver(), "android_id");
      if (!"9774d56d682e549c".equals(str2)) {
        str1 = b(str2);
      }
    }
    return str1;
  }
  
  public String k()
  {
    TelephonyManager localTelephonyManager;
    if ((this.e) && (a("android.permission.READ_PHONE_STATE")))
    {
      localTelephonyManager = (TelephonyManager)this.g.getSystemService("phone");
      if (localTelephonyManager == null) {}
    }
    for (String str = b(localTelephonyManager.getDeviceId());; str = null) {
      return str;
    }
  }
  
  public String l()
  {
    WifiInfo localWifiInfo;
    if ((this.e) && (a("android.permission.ACCESS_WIFI_STATE")))
    {
      WifiManager localWifiManager = (WifiManager)this.g.getSystemService("wifi");
      if (localWifiManager != null)
      {
        localWifiInfo = localWifiManager.getConnectionInfo();
        if (localWifiInfo == null) {}
      }
    }
    for (String str = b(localWifiInfo.getMacAddress());; str = null) {
      return str;
    }
  }
  
  public String m()
  {
    if ((this.e) && (a("android.permission.BLUETOOTH"))) {}
    try
    {
      BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      if (localBluetoothAdapter != null) {
        b(localBluetoothAdapter.getAddress());
      }
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IC.g();
      }
    }
  }
  
  public String n()
  {
    if ((this.e) && (Build.VERSION.SDK_INT >= 9)) {}
    for (;;)
    {
      try
      {
        String str2 = b((String)Build.class.getField("SERIAL").get(null));
        str1 = str2;
        return str1;
      }
      catch (Exception localException)
      {
        IC.g();
      }
      String str1 = null;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Js
 * JD-Core Version:    0.7.0.1
 */