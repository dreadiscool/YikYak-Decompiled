import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public final class BK
  implements HostnameVerifier
{
  public static final BK a = new BK();
  private static final Pattern b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
  
  public static List<String> a(X509Certificate paramX509Certificate)
  {
    List localList1 = a(paramX509Certificate, 7);
    List localList2 = a(paramX509Certificate, 2);
    ArrayList localArrayList = new ArrayList(localList1.size() + localList2.size());
    localArrayList.addAll(localList1);
    localArrayList.addAll(localList2);
    return localArrayList;
  }
  
  private static List<String> a(X509Certificate paramX509Certificate, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Collection localCollection = paramX509Certificate.getSubjectAlternativeNames();
      Object localObject;
      if (localCollection == null)
      {
        localObject = Collections.emptyList();
      }
      else
      {
        Iterator localIterator = localCollection.iterator();
        while (localIterator.hasNext())
        {
          List localList = (List)localIterator.next();
          if ((localList != null) && (localList.size() >= 2))
          {
            Integer localInteger = (Integer)localList.get(0);
            if ((localInteger != null) && (localInteger.intValue() == paramInt))
            {
              String str = (String)localList.get(1);
              if (str != null) {
                localArrayList.add(str);
              }
            }
          }
        }
      }
      return localObject;
    }
    catch (CertificateParsingException localCertificateParsingException)
    {
      localObject = Collections.emptyList();
      break label143;
      localObject = localArrayList;
    }
  }
  
  static boolean a(String paramString)
  {
    return b.matcher(paramString).matches();
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool = false;
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString1.startsWith(".")) || (paramString1.endsWith(".."))) {}
    for (;;)
    {
      return bool;
      if ((paramString2 != null) && (paramString2.length() != 0) && (!paramString2.startsWith(".")) && (!paramString2.endsWith("..")))
      {
        if (!paramString1.endsWith(".")) {
          paramString1 = paramString1 + '.';
        }
        if (!paramString2.endsWith(".")) {
          paramString2 = paramString2 + '.';
        }
        String str1 = paramString2.toLowerCase(Locale.US);
        if (!str1.contains("*"))
        {
          bool = paramString1.equals(str1);
        }
        else if ((str1.startsWith("*.")) && (str1.indexOf('*', 1) == -1) && (paramString1.length() >= str1.length()) && (!"*.".equals(str1)))
        {
          String str2 = str1.substring(1);
          if (paramString1.endsWith(str2))
          {
            int i = paramString1.length() - str2.length();
            if ((i <= 0) || (paramString1.lastIndexOf('.', i - 1) == -1)) {
              bool = true;
            }
          }
        }
      }
    }
  }
  
  private boolean b(String paramString, X509Certificate paramX509Certificate)
  {
    List localList = a(paramX509Certificate, 7);
    int i = localList.size();
    int j = 0;
    if (j < i) {
      if (!paramString.equalsIgnoreCase((String)localList.get(j))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      j++;
      break;
    }
  }
  
  private boolean c(String paramString, X509Certificate paramX509Certificate)
  {
    String str1 = paramString.toLowerCase(Locale.US);
    List localList = a(paramX509Certificate, 2);
    int i = localList.size();
    int j = 0;
    int k = 0;
    boolean bool;
    if (j < i) {
      if (a(str1, (String)localList.get(j))) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      j++;
      k = 1;
      break;
      if (k == 0)
      {
        String str2 = new BJ(paramX509Certificate.getSubjectX500Principal()).a("cn");
        if (str2 != null)
        {
          bool = a(str1, str2);
          continue;
        }
      }
      bool = false;
    }
  }
  
  public boolean a(String paramString, X509Certificate paramX509Certificate)
  {
    if (a(paramString)) {}
    for (boolean bool = b(paramString, paramX509Certificate);; bool = c(paramString, paramX509Certificate)) {
      return bool;
    }
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      boolean bool2 = a(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
      bool1 = bool2;
    }
    catch (SSLException localSSLException)
    {
      for (;;)
      {
        boolean bool1 = false;
      }
    }
    return bool1;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     BK
 * JD-Core Version:    0.7.0.1
 */