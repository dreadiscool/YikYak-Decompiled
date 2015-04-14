import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.location.Location;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.yik.yak.YikYak;
import com.yik.yak.data.models.YakkerLocation;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CR
{
    public static final String a = YikYak.getContext().getResources().getString(2131230881);
    public static final String b = YikYak.getContext().getResources().getString(2131230883);
    public static final String c = YikYak.getContext().getResources().getString(2131230884);
    public static final String d = YikYak.getContext().getResources().getString(2131230882);
    private static String e = b;
    private static CR f = new CR();
    private static HashMap<String, Boolean> g;
    private static List<Cs> h = null;
    private static List<Pattern> i = null;
    private static boolean endpointsInitialized = false;
    private static boolean k = false;
    private static JSONObject l = null;
    
    public static int a(String paramString1, String paramString2, int paramInt)
    {
        if (l == null) {
            d(a("features"));
        }
        try
        {
            int m = l.getJSONObject("configuration").getJSONObject(paramString1).getInt(paramString2);
            paramInt = m;
        }
        catch (NullPointerException localNullPointerException)
        {
            break label35;
        }
        catch (JSONException localJSONException)
        {
            label35:
            break label35;
        }
        return paramInt;
    }
    
    public static String a(String paramString)
    {
        return Ik.a(YikYak.getContext(), paramString);
    }
    
    public static String a(String paramString1, String paramString2, String paramString3)
    {
        if (l == null) {
            d(a("features"));
        }
        try
        {
            String str = l.getJSONObject("configuration").getJSONObject(paramString1).getString(paramString2);
            paramString3 = str;
        }
        catch (NullPointerException localNullPointerException)
        {
            break label35;
        }
        catch (JSONException localJSONException)
        {
            label35:
            break label35;
        }
        return paramString3;
    }
    
    // public static void a()
    public static void initYakBandC()
    {
        YikYak.b = Ik.a("bg", 2);
        YikYak.c = Ik.a("fg", 2);
    }
    
    public static void a(String paramString1, String paramString2)
    {
        Ik.a(YikYak.getContext(), paramString2, paramString1);
    }
    
    // public static void a(JSONObject)
    public static void initEndpoints(JSONObject paramJSONObject)
    {
        endpointsInitialized = true;
        CR.calculateApiKey();
        h = new ArrayList();
        try
        {
            JSONArray localJSONArray = paramJSONObject.getJSONObject("configuration").getJSONArray("endpoints");
            for (int m = 0; m < localJSONArray.length(); m++)
            {
                JSONObject localJSONObject = localJSONArray.getJSONObject(m);
                h.add(new Cs(false, localJSONObject.getDouble("min_latitude"), localJSONObject.getDouble("min_longitude"), localJSONObject.getDouble("max_latitude"), localJSONObject.getDouble("max_longitude"), localJSONObject.getString("url")));
            }
            a("endpoints", paramJSONObject.toString());
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = "initializeEndPoints(JSONObject) succeeded.";
            Iq.a(CR.class, arrayOfObject2);
            Im.a(f());
            return;
        }
        catch (Exception localException)
        {
            for (;;)
            {
                localException.printStackTrace();
                Object[] arrayOfObject1 = new Object[1];
                arrayOfObject1[0] = ("initializeEndPoints(JSONObject) failed: " + localException.getMessage());
                Iq.b(CR.class, arrayOfObject1);
            }
        }
    }
    
    public static boolean a(Context paramContext)
    {
        boolean bool1 = false;
        boolean bool2;
        TelephonyManager localTelephonyManager;
        if ((Build.MODEL.contains("google_sdk")) || (Build.MODEL.contains("Emulator")) || (Build.MODEL.contains("Android SDK")))
        {
            bool2 = true;
            localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
            if (localTelephonyManager != null) {
                break label58;
            }
        }
        for (;;)
        {
            return bool2;
            bool2 = false;
            break;
            label58:
            String str = localTelephonyManager.getDeviceId();
            if (str != null)
            {
                if ((str.equals("000000000000000")) || (bool2)) {
                    bool1 = true;
                }
                bool2 = bool1;
            }
        }
    }
    
    public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
    {
        if (l == null) {
            d(a("features"));
        }
        try
        {
            boolean bool = l.getJSONObject("configuration").getJSONObject(paramString1).getBoolean(paramString2);
            paramBoolean = bool;
        }
        catch (NullPointerException localNullPointerException)
        {
            break label35;
        }
        catch (JSONException localJSONException)
        {
            label35:
            break label35;
        }
        return paramBoolean;
    }
    
    public static boolean a(String paramString, boolean paramBoolean)
    {
        if (g == null) {
            g = new HashMap();
        }
        for (;;)
        {
            return paramBoolean;
            if (g.containsKey(paramString)) {
                paramBoolean = ((Boolean)g.get(paramString)).booleanValue();
            }
        }
    }
    
    public static void b(String paramString)
    {
        j = true;
        j();
        try
        {
            a(new JSONObject(paramString));
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = "initializeEndPoints(String) succeeded.";
            Iq.a(CR.class, arrayOfObject2);
            return;
        }
        catch (Exception localException)
        {
            for (;;)
            {
                localException.printStackTrace();
                Object[] arrayOfObject1 = new Object[1];
                arrayOfObject1[0] = ("initializeEndPoints(String) failed: " + localException.getMessage());
                Iq.b(CR.class, arrayOfObject1);
            }
        }
    }
    
    public static void b(String paramString, boolean paramBoolean)
    {
        if (g == null) {
            g = new HashMap();
        }
        g.put(paramString, Boolean.valueOf(paramBoolean));
    }
    
    public static boolean b()
    {
        return bool1;
    }
    
    public static void c(String paramString)
    {
        k = false;
        try
        {
            l = new JSONObject(paramString);
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = "initializeConfiguration(String) succeeded.";
            Iq.a(CR.class, arrayOfObject2);
            k = true;
            return;
        }
        catch (Exception localException)
        {
            for (;;)
            {
                localException.printStackTrace();
                Object[] arrayOfObject1 = new Object[1];
                arrayOfObject1[0] = ("initializeConfiguration(String) failed: " + localException.getMessage());
                Iq.b(CR.class, arrayOfObject1);
            }
        }
    }
    
    public static boolean c()
    {
        if (Runtime.getRuntime().maxMemory() < 128000000L) {}
        for (boolean bool = true;; bool = false) {
            return bool;
        }
    }
    
    public static void d(String paramString)
    {
        try
        {
            d(new JSONObject(paramString));
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = "initializeThreatWords(String) succeeded.";
            Iq.a(CR.class, arrayOfObject2);
            return;
        }
        catch (Exception localException)
        {
            for (;;)
            {
                localException.printStackTrace();
                Object[] arrayOfObject1 = new Object[1];
                arrayOfObject1[0] = ("initializeThreatWords(String) failed: " + localException.getMessage());
                Iq.b(CR.class, arrayOfObject1);
            }
        }
    }
    
    private static void d(JSONObject paramJSONObject)
    {
        i = new ArrayList();
        try
        {
            JSONObject localJSONObject1 = paramJSONObject.getJSONObject("configuration");
            if (localJSONObject1.has("threat_checks"))
            {
                JSONArray localJSONArray1 = localJSONObject1.getJSONArray("threat_checks");
                m = 0;
                if (m < localJSONArray1.length())
                {
                    JSONObject localJSONObject2 = localJSONArray1.getJSONObject(m);
                    if (!localJSONObject2.has("expressions")) {
                        break label138;
                    }
                    JSONArray localJSONArray2 = localJSONObject2.getJSONArray("expressions");
                    for (int n = 0; n < localJSONArray2.length(); n++)
                    {
                        String str = localJSONArray2.getString(n);
                        i.add(Pattern.compile(str, 2));
                    }
                }
            }
            a("threatwords", paramJSONObject.toString());
            return;
        }
        catch (JSONException localJSONException)
        {
            for (;;)
            {
                int m;
                localJSONException.printStackTrace();
                continue;
                label138:
                m++;
            }
        }
    }
    
    public static boolean d()
    {
        boolean bool1 = false;
        for (;;)
        {
            try
            {
                Context localContext = YikYak.getContext();
                Signature[] arrayOfSignature = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 64).signatures;
                int m = arrayOfSignature.length;
                n = 0;
                if (n < m)
                {
                    Signature localSignature = arrayOfSignature[n];
                    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
                    localMessageDigest.update(localSignature.toByteArray());
                    boolean bool2 = Base64.encodeToString(localMessageDigest.digest(), 0).toUpperCase().startsWith("YS");
                    if (!bool2) {
                        continue;
                    }
                    bool1 = true;
                }
            }
            catch (Exception localException)
            {
                int n;
                continue;
            }
            return bool1;
            n++;
        }
    }
    
    public static List<Pattern> e()
    {
        if (i == null) {
            d(a("threatwords"));
        }
        if (i == null) {
            i = new ArrayList();
        }
        return i;
    }
    
    public static String f()
    {
        String str1;
        if (CM.a().i())
        {
            SharedPreferences localSharedPreferences = ApplicationConfig.getSharedPreferences();
            String str2 = YikYak.getContext().getResources().getString(2131230886);
            str1 = localSharedPreferences.getString("endPoint", str2);
            if (str1.equals(str2)) {}
        }
        for (;;)
        {
            return str1;
            if (h == null) {
                b(a("endpoints"));
            }
            YakkerLocation localYakkerLocation = CM.a().f();
            double d1 = localYakkerLocation.getLatitude();
            double d2 = localYakkerLocation.getLongitude();
            if (h != null)
            {
                Iterator localIterator = h.iterator();
                for (;;)
                {
                    if (localIterator.hasNext())
                    {
                        Cs localCs = (Cs)localIterator.next();
                        if ((d1 >= localCs.b) && (d1 <= localCs.d) && (d2 >= localCs.c) && (d2 <= localCs.d))
                        {
                            str1 = localCs.f;
                            break;
                        }
                    }
                }
            }
            if (0 == 0) {
                str1 = a;
            } else {
                str1 = null;
            }
        }
    }
    
    // public static String g()
    public static String getUserAgent()
    {
        return Ik.c(System.getProperty("http.agent"));
    }
    
    public static void h()
    {
        k = false;
        new Cm().a(YikYak.getContext(), new CS());
    }
    
    public static void i()
    {
        new Cn().a(YikYak.getContext(), new CT());
    }
    
    // public static void j()
    public static void calculateApiKey()
    {
        int m = 0;
        for (;;)
        {
            try
            {
                Context localContext = YikYak.getContext();
                if (!a(localContext)) {
                    break label191;
                }
                str1 = "e";
                Signature[] arrayOfSignature = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 64).signatures;
                int n = arrayOfSignature.length;
                if (m < n)
                {
                    Signature localSignature = arrayOfSignature[m];
                    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
                    localMessageDigest.update(localSignature.toByteArray());
                    str2 = Base64.encodeToString(localMessageDigest.digest(), 0);
                    if (str2.toUpperCase().startsWith("YS"))
                    {
                        YikYak.d = "d";
                        YikYak.a = Ik.c(str2);
                    }
                    else if (str2.toUpperCase().startsWith("GQ"))
                    {
                        YikYak.d = str1;
                        YikYak.a = Ik.c(str2);
                    }
                }
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException)
            {
                String str2;
                localNameNotFoundException.printStackTrace();
                return;
                YikYak.d = str1;
                YikYak.a = Ik.c(str2);
            }
            catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
            {
                localNoSuchAlgorithmException.printStackTrace();
                continue;
            }
            catch (NullPointerException localNullPointerException)
            {
                localNullPointerException.printStackTrace();
                continue;
            }
            m++;
            continue;
            label191:
            String str1 = "";
        }
    }
    
    public static String k()
    {
        return e;
    }
    
    public static String l()
    {
        String str1 = f();
        if ((Ik.a(str1)) || (str1.equals(a))) {}
        for (String str2 = d;; str2 = "http://qa.yikyakapi.net:8001/upload") {
            return str2;
        }
    }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     CR

 * JD-Core Version:    0.7.0.1

 */