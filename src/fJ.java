import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class fJ
{
  private static final char[] a;
  
  static
  {
    char[] arrayOfChar = new char[16];
    arrayOfChar[0] = 48;
    arrayOfChar[1] = 49;
    arrayOfChar[2] = 50;
    arrayOfChar[3] = 51;
    arrayOfChar[4] = 52;
    arrayOfChar[5] = 53;
    arrayOfChar[6] = 54;
    arrayOfChar[7] = 55;
    arrayOfChar[8] = 56;
    arrayOfChar[9] = 57;
    arrayOfChar[10] = 65;
    arrayOfChar[11] = 66;
    arrayOfChar[12] = 67;
    arrayOfChar[13] = 68;
    arrayOfChar[14] = 69;
    arrayOfChar[15] = 70;
    a = arrayOfChar;
  }
  
  public static double a(String paramString, double paramDouble)
  {
    if (paramString == null) {}
    for (;;)
    {
      return paramDouble;
      try
      {
        double d = Double.parseDouble(paramString);
        paramDouble = d;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
  }
  
  public static String a(Locale paramLocale)
  {
    String str = null;
    if (paramLocale == null) {}
    for (;;)
    {
      return str;
      if (!TextUtils.isEmpty(paramLocale.getLanguage()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLocale.getLanguage().toLowerCase());
        if (!TextUtils.isEmpty(paramLocale.getCountry())) {
          localStringBuilder.append("-").append(paramLocale.getCountry().toLowerCase());
        }
        str = localStringBuilder.toString();
      }
    }
  }
  
  public static String a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0") {
      return str;
    }
  }
  
  public static Map<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString1 = paramString.split("&");
    int i = arrayOfString1.length;
    int j = 0;
    if (j < i)
    {
      String[] arrayOfString2 = arrayOfString1[j].split("=");
      if (arrayOfString2.length > 1) {
        localHashMap.put(arrayOfString2[0], arrayOfString2[1]);
      }
      for (;;)
      {
        j++;
        break;
        if ((arrayOfString2.length == 1) && (arrayOfString2[0].length() != 0)) {
          localHashMap.put(arrayOfString2[0], null);
        }
      }
    }
    return localHashMap;
  }
  
  public static void a(Map<String, String> paramMap, String paramString, gm paramgm)
  {
    if (!paramMap.containsKey(paramString)) {
      paramMap.put(paramString, paramgm.a(paramString));
    }
  }
  
  public static void a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (!paramMap.containsKey(paramString1)) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (paramString != null) {
      if ((!paramString.equalsIgnoreCase("true")) && (!paramString.equalsIgnoreCase("yes")) && (!paramString.equalsIgnoreCase("1"))) {
        break label35;
      }
    }
    for (paramBoolean = true;; paramBoolean = false) {
      label35:
      do
      {
        return paramBoolean;
      } while ((!paramString.equalsIgnoreCase("false")) && (!paramString.equalsIgnoreCase("no")) && (!paramString.equalsIgnoreCase("0")));
    }
  }
  
  public static String b(String paramString)
  {
    String str1;
    if (TextUtils.isEmpty(paramString)) {
      str1 = null;
    }
    for (;;)
    {
      return str1;
      if (paramString.contains("?"))
      {
        String[] arrayOfString2 = paramString.split("[\\?]");
        if (arrayOfString2.length > 1) {
          paramString = arrayOfString2[1];
        }
      }
      if (paramString.contains("%3D")) {}
      StringBuilder localStringBuilder;
      while (paramString.contains("=")) {
        try
        {
          String str2 = URLDecoder.decode(paramString, "UTF-8");
          paramString = str2;
          Map localMap = a(paramString);
          String[] arrayOfString1 = new String[9];
          arrayOfString1[0] = "dclid";
          arrayOfString1[1] = "utm_source";
          arrayOfString1[2] = "gclid";
          arrayOfString1[3] = "utm_campaign";
          arrayOfString1[4] = "utm_medium";
          arrayOfString1[5] = "utm_term";
          arrayOfString1[6] = "utm_content";
          arrayOfString1[7] = "utm_id";
          arrayOfString1[8] = "gmob_t";
          localStringBuilder = new StringBuilder();
          for (int i = 0; i < arrayOfString1.length; i++) {
            if (!TextUtils.isEmpty((CharSequence)localMap.get(arrayOfString1[i])))
            {
              if (localStringBuilder.length() > 0) {
                localStringBuilder.append("&");
              }
              localStringBuilder.append(arrayOfString1[i]).append("=").append((String)localMap.get(arrayOfString1[i]));
            }
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          str1 = null;
        }
      }
      str1 = null;
      continue;
      str1 = localStringBuilder.toString();
    }
  }
  
  public static MessageDigest c(String paramString)
  {
    int i = 0;
    if (i < 2) {}
    for (;;)
    {
      try
      {
        MessageDigest localMessageDigest2 = MessageDigest.getInstance(paramString);
        localMessageDigest1 = localMessageDigest2;
        if (localMessageDigest1 != null) {
          return localMessageDigest1;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        i++;
      }
      break;
      MessageDigest localMessageDigest1 = null;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fJ
 * JD-Core Version:    0.7.0.1
 */