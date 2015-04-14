import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class fa
  implements em
{
  private final String a;
  private final HttpClient b;
  private final Context c;
  private eL d;
  private URL e;
  
  fa(HttpClient paramHttpClient, Context paramContext)
  {
    this(paramHttpClient, eL.a(paramContext), paramContext);
  }
  
  @VisibleForTesting
  fa(HttpClient paramHttpClient, eL parameL, Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.a = a("GoogleAnalytics", "3.0", Build.VERSION.RELEASE, fd.a(Locale.getDefault()), Build.MODEL, Build.ID);
    this.b = paramHttpClient;
    this.d = parameL;
  }
  
  private HttpEntityEnclosingRequest a(String paramString1, String paramString2)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString1))
    {
      eO.d("Empty hit, discarding.");
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      String str = paramString2 + "?" + paramString1;
      if (str.length() < 2036) {
        localObject = new BasicHttpEntityEnclosingRequest("GET", str);
      }
      for (;;)
      {
        ((HttpEntityEnclosingRequest)localObject).addHeader("User-Agent", this.a);
        break;
        localObject = new BasicHttpEntityEnclosingRequest("POST", paramString2);
        try
        {
          ((HttpEntityEnclosingRequest)localObject).setEntity(new StringEntity(paramString1));
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          eO.d("Encoding error, discarding hit");
          localObject = null;
        }
      }
    }
  }
  
  private void a(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Header[] arrayOfHeader = paramHttpEntityEnclosingRequest.getAllHeaders();
    int i = arrayOfHeader.length;
    for (int j = 0; j < i; j++) {
      localStringBuffer.append(arrayOfHeader[j].toString()).append("\n");
    }
    localStringBuffer.append(paramHttpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
    if (paramHttpEntityEnclosingRequest.getEntity() != null) {}
    try
    {
      InputStream localInputStream = paramHttpEntityEnclosingRequest.getEntity().getContent();
      if (localInputStream != null)
      {
        int k = localInputStream.available();
        if (k > 0)
        {
          byte[] arrayOfByte = new byte[k];
          localInputStream.read(arrayOfByte);
          localStringBuffer.append("POST:\n");
          localStringBuffer.append(new String(arrayOfByte)).append("\n");
        }
      }
      eO.c(localStringBuffer.toString());
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        eO.c("Error Writing hit to log...");
      }
    }
  }
  
  public int a(List<eM> paramList)
  {
    int i = Math.min(paramList.size(), 40);
    int j = 1;
    int k = 0;
    int m = 0;
    HttpHost localHttpHost;
    HttpEntityEnclosingRequest localHttpEntityEnclosingRequest;
    label191:
    int i1;
    if (k < i)
    {
      eM localeM = (eM)paramList.get(k);
      URL localURL = a(localeM);
      int i4;
      if (localURL == null)
      {
        if (eO.a()) {
          eO.d("No destination: discarding hit: " + localeM.a());
        }
        for (;;)
        {
          i4 = m + 1;
          k++;
          m = i4;
          break;
          eO.d("No destination: discarding hit.");
        }
      }
      localHttpHost = new HttpHost(localURL.getHost(), localURL.getPort(), localURL.getProtocol());
      String str1 = localURL.getPath();
      if (TextUtils.isEmpty(localeM.a())) {}
      for (String str2 = "";; str2 = eN.a(localeM, System.currentTimeMillis()))
      {
        localHttpEntityEnclosingRequest = a(str2, str1);
        if (localHttpEntityEnclosingRequest != null) {
          break label191;
        }
        i4 = m + 1;
        break;
      }
      localHttpEntityEnclosingRequest.addHeader("Host", localHttpHost.toHostString());
      if (eO.a()) {
        a(localHttpEntityEnclosingRequest);
      }
      if (str2.length() > 8192) {
        eO.d("Hit too long (> 8192 bytes)--not sent");
      }
      for (i1 = j;; i1 = j)
      {
        int i2 = m + 1;
        int i3 = i1;
        i4 = i2;
        j = i3;
        break;
        if (!this.d.b()) {
          break label279;
        }
        eO.b("Dry run enabled. Hit not actually sent.");
      }
      label279:
      if (j == 0) {
        break label461;
      }
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          es.b(this.c);
          i1 = 0;
          try
          {
            HttpResponse localHttpResponse = this.b.execute(localHttpHost, localHttpEntityEnclosingRequest);
            int i5 = localHttpResponse.getStatusLine().getStatusCode();
            HttpEntity localHttpEntity = localHttpResponse.getEntity();
            if (localHttpEntity != null) {
              localHttpEntity.consumeContent();
            }
            if (i5 == 200) {
              break;
            }
            eO.d("Bad response: " + localHttpResponse.getStatusLine().getStatusCode());
          }
          catch (ClientProtocolException localClientProtocolException1) {}
        }
      }
      catch (IOException localIOException)
      {
        eO.d("Exception sending hit: " + localIOException.getClass().getSimpleName());
        eO.d(localIOException.getMessage());
        int n = m;
        return n;
        n = m;
        continue;
      }
      catch (ClientProtocolException localClientProtocolException2)
      {
        i1 = j;
        continue;
      }
      eO.d("ClientProtocolException sending hit; discarding hit...");
      break;
      label461:
      i1 = j;
    }
  }
  
  String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = paramString2;
    arrayOfObject[2] = paramString3;
    arrayOfObject[3] = paramString4;
    arrayOfObject[4] = paramString5;
    arrayOfObject[5] = paramString6;
    return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", arrayOfObject);
  }
  
  @VisibleForTesting
  URL a(eM parameM)
  {
    URL localURL;
    if (this.e != null)
    {
      localURL = this.e;
      return localURL;
    }
    String str1 = parameM.d();
    for (;;)
    {
      try
      {
        if (!"http:".equals(str1)) {
          break label63;
        }
        str2 = "http://www.google-analytics.com/collect";
        localURL = new URL(str2);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        eO.a("Error trying to parse the hardcoded host url. This really shouldn't happen.");
        localURL = null;
      }
      break;
      label63:
      String str2 = "https://ssl.google-analytics.com/collect";
    }
  }
  
  @VisibleForTesting
  public void a(String paramString)
  {
    try
    {
      this.e = new URL(paramString);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        this.e = null;
      }
    }
  }
  
  public boolean a()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.c.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected())) {
      eO.c("...no network connectivity");
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fa
 * JD-Core Version:    0.7.0.1
 */