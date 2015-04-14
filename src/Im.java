import android.net.Uri;
import android.net.Uri.Builder;
import com.yik.yak.YikYak;
import com.yik.yak.data.models.YakkerLocation;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Im
{
    public static String a = null;
    private static zu b = null;
    private static zu c = null;
    private static za d = null;
    
    public static String a(String paramString1, String paramString2, TreeMap<String, String> paramTreeMap, YakkerLocation paramYakkerLocation)
    {
        int i = 1;
        String unixTimestampString = String.valueOf(System.currentTimeMillis() / 1000L);
        Uri localUri = Uri.parse(paramString1);
        List localList = localUri.getPathSegments();
        String str2 = (String)localList.get(-1 + localList.size());
        Uri.Builder localBuilder = new Uri.Builder();
        Iterator localIterator;
        if (Ik.a(paramString2))
        {
            localBuilder.scheme(localUri.getScheme()).authority(localUri.getAuthority()).appendPath(localUri.getPath().substring(i));
            paramTreeMap.put("version", YikYak.getVersion());
            if (paramYakkerLocation != null)
            {
                paramTreeMap.put("userLat", paramYakkerLocation.getLatitude());
                paramTreeMap.put("userLong", paramYakkerLocation.getLongitude());
                if (paramYakkerLocation.hasAccuracy()) {
                    paramTreeMap.put("accuracy", String.valueOf(paramYakkerLocation.getAccuracy()));
                }
                if (paramYakkerLocation.hasAltitude()) {
                    paramTreeMap.put("altitude", String.valueOf(paramYakkerLocation.getAltitude()));
                }
            }
            if (paramTreeMap.size() == 0) {
                break label380;
            }
            localIterator = paramTreeMap.keySet().iterator();
            label196:
            if (!localIterator.hasNext()) {
                break label380;
            }
            if (i == 0) {
                break label481;
            }
            paramString2 = paramString2 + "?";
        }
        label481:
        for (int j = 0;; j = i)
        {
            String str4 = (String)localIterator.next();
            paramString2 = paramString2 + str4 + "=" + (String)paramTreeMap.get(str4);
            localBuilder.appendQueryParameter(str4, (String)paramTreeMap.get(str4));
            if (localIterator.hasNext()) {
                paramString2 = paramString2 + "&";
            }
            i = j;
            break label196;
            localBuilder.scheme(localUri.getScheme()).authority(localUri.getAuthority()).appendPath(localUri.getPath().substring(i)).appendPath(paramString2);
            break;
            label380:
            String str3 = a("/" + str2 + "/" + paramString2 + unixTimestampString, YikYak.a.getBytes());
            paramTreeMap.put("salt", str1);
            localBuilder.appendQueryParameter("salt", unixTimestampString);
            paramTreeMap.put("hash", str3);
            localBuilder.appendQueryParameter("hash", str3);
            localBuilder.build().toString();
            return localBuilder.build().toString();
        }
    }
    
    public static String a(String paramString, TreeMap<String, String> paramTreeMap, YakkerLocation paramYakkerLocation)
    {
        String str;
        if (a == null)
        {
            str = CR.f();
            if (str == null) {
                break label28;
            }
        }
        for (;;)
        {
            a = str;
            return a(a, paramString, paramTreeMap, paramYakkerLocation);
            label28:
            str = CR.a;
        }
    }
    
    /* Error */
    public static String a(String paramString, byte[] paramArrayOfByte)
    {
        // Byte code:
        //   0: new 217 javax/crypto/spec/SecretKeySpec
        //   3: dup
        //   4: aload_1
        //   5: ldc 219
        //   7: invokespecial 222   javax/crypto/spec/SecretKeySpec:<init>  ([BLjava/lang/String;)V
        //   10: astore_2
        //   11: ldc 219
        //   13: invokestatic 228   javax/crypto/Mac:getInstance    (Ljava/lang/String;)Ljavax/crypto/Mac;
        //   16: astore 8
        //   18: aload 8
        //   20: aload_2
        //   21: invokevirtual 232  javax/crypto/Mac:init   (Ljava/security/Key;)V
        //   24: aload 8
        //   26: aload_0
        //   27: invokevirtual 190  java/lang/String:getBytes   ()[B
        //   30: invokevirtual 236  javax/crypto/Mac:doFinal    ([B)[B
        //   33: iconst_0
        //   34: invokestatic 242   android/util/Base64:encodeToString  ([BI)Ljava/lang/String;
        //   37: astore 9
        //   39: aload 9
        //   41: invokevirtual 245  java/lang/String:trim   ()Ljava/lang/String;
        //   44: astore 12
        //   46: aload 12
        //   48: astore 4
        //   50: aload 4
        //   52: areturn
        //   53: astore 6
        //   55: aconst_null
        //   56: astore 4
        //   58: aload 6
        //   60: astore 7
        //   62: aload 7
        //   64: invokevirtual 248  java/security/NoSuchAlgorithmException:printStackTrace  ()V
        //   67: goto -17 -> 50
        //   70: astore_3
        //   71: aconst_null
        //   72: astore 4
        //   74: aload_3
        //   75: astore 5
        //   77: aload 5
        //   79: invokevirtual 249  java/security/InvalidKeyException:printStackTrace   ()V
        //   82: goto -32 -> 50
        //   85: astore 11
        //   87: aload 9
        //   89: astore 4
        //   91: aload 11
        //   93: astore 5
        //   95: goto -18 -> 77
        //   98: astore 10
        //   100: aload 9
        //   102: astore 4
        //   104: aload 10
        //   106: astore 7
        //   108: goto -46 -> 62
        // Local variable table:
        //   start  length  slot    name    signature
        //   0  111 0   paramString String
        //   0  111 1   paramArrayOfByte    byte[]
        //   10 11  2   localSecretKeySpec  javax.crypto.spec.SecretKeySpec
        //   70 5   3   localInvalidKeyException1   java.security.InvalidKeyException
        //   48 55  4   str1    String
        //   75 19  5   localObject1    Object
        //   53 6   6   localNoSuchAlgorithmException1  java.security.NoSuchAlgorithmException
        //   60 47  7   localObject2    Object
        //   16 9   8   localMac    javax.crypto.Mac
        //   37 64  9   str2    String
        //   98 7   10  localNoSuchAlgorithmException2  java.security.NoSuchAlgorithmException
        //   85 7   11  localInvalidKeyException2   java.security.InvalidKeyException
        //   44 3   12  str3    String
        // Exception table:
        //   from   to  target  type
        //   0  39  53  java/security/NoSuchAlgorithmException
        //   0  39  70  java/security/InvalidKeyException
        //   39 46  85  java/security/InvalidKeyException
        //   39 46  98  java/security/NoSuchAlgorithmException
    }
    
    public static zu a(boolean paramBoolean)
    {
        if (paramBoolean) {
            if (c == null)
            {
                c = new zu();
                c.v().add(new In());
            }
        }
        for (;;)
        {
            try
            {
                if (d == null) {
                    a(CR.f());
                }
                if (CR.a("googleAnalytics", "PeekSearched", false)) {
                    c.a(d);
                }
                localzu = c;
                return localzu;
            }
            catch (Exception localException)
            {
                localException.getMessage();
                continue;
            }
            if (b == null)
            {
                b = new zu();
                b.v().add(new In());
            }
            zu localzu = b;
        }
    }
    
    public static void a(String paramString)
    {
        String str = Uri.parse(paramString).getHost();
        zc localzc1 = new zc();
        String[] arrayOfString1 = new String[1];
        arrayOfString1[0] = "sha1/SXxoaOSEzPC6BgGmxAt/EAcsajw=";
        zc localzc2 = localzc1.a(str, arrayOfString1);
        String[] arrayOfString2 = new String[1];
        arrayOfString2[0] = "sha1/blhOM3W9V/bVQhsWAcLYwPU6n24=";
        d = localzc2.a(str, arrayOfString2).a();
    }
    
    public static String b(String paramString1, String paramString2, TreeMap<String, String> paramTreeMap, YakkerLocation paramYakkerLocation)
    {
        Object localObject1 = "";
        if (paramTreeMap == null) {
            paramTreeMap = new TreeMap();
        }
        TreeMap localTreeMap = new TreeMap();
        if (paramTreeMap.containsKey("userID")) {
            localTreeMap.put("userID", paramTreeMap.get("userID"));
        }
        String str1 = a(paramString1, paramString2, localTreeMap, paramYakkerLocation);
        Iterator localIterator1 = localTreeMap.keySet().iterator();
        while (localIterator1.hasNext())
        {
            String str4 = (String)localIterator1.next();
            if (!paramTreeMap.containsKey(str4)) {
                paramTreeMap.put(str4, localTreeMap.get(str4));
            }
        }
        String str2;
        if (paramTreeMap.size() != 0)
        {
            Iterator localIterator2 = paramTreeMap.keySet().iterator();
            if (localIterator2.hasNext())
            {
                str2 = (String)localIterator2.next();
                if (((String)paramTreeMap.get(str2)).equals(null)) {
                    break label331;
                }
                try
                {
                    String str3 = (String)localObject1 + str2 + "=" + URLEncoder.encode((String)paramTreeMap.get(str2), "utf-8");
                    localObject2 = str3;
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                    for (;;)
                    {
                        localObject2 = (String)localObject1 + str2 + "=" + (String)paramTreeMap.get(str2);
                    }
                }
                if (!localIterator2.hasNext()) {}
            }
        }
        label331:
        for (Object localObject2 = (String)localObject2 + "&";; localObject2 = localObject1)
        {
            localObject1 = localObject2;
            break;
            paramTreeMap.put("RequestBody:body", localObject1);
            return str1;
        }
    }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     Im

 * JD-Core Version:    0.7.0.1

 */