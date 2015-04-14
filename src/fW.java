import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

public class fW
  implements gn
{
  private final String a;
  private final HttpClient b;
  private final Context c;
  private URL d;
  private int e;
  private int f;
  private int g;
  private String h;
  private String i;
  private fY j;
  private gg k;
  private Set<Integer> l = new HashSet();
  private boolean m = false;
  private long n;
  private long o;
  private gk p;
  private volatile boolean q = false;
  
  fW(HttpClient paramHttpClient, Context paramContext, gk paramgk)
  {
    this.c = paramContext.getApplicationContext();
    this.p = paramgk;
    this.a = a("GoogleAnalytics", "4.0", Build.VERSION.RELEASE, fJ.a(Locale.getDefault()), Build.MODEL, Build.ID);
    this.b = paramHttpClient;
  }
  
  private String a(fx paramfx, List<String> paramList, fY paramfY)
  {
    String str3;
    long l1;
    Object localObject;
    if (paramfY == fY.a) {
      if ((paramfx.a() == null) || (paramfx.a().length() == 0))
      {
        str3 = "";
        l1 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str3)) {
          break label57;
        }
        localObject = "";
      }
    }
    for (;;)
    {
      return localObject;
      str3 = paramfx.a();
      break;
      label57:
      localObject = fy.a(paramfx, l1);
      continue;
      String str1 = "";
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (str2.length() != 0)
        {
          if (str1.length() != 0) {
            str1 = str1 + "\n";
          }
          str1 = str1 + str2;
        }
      }
      localObject = str1;
    }
  }
  
  private URL a(fx paramfx)
  {
    URL localURL;
    if (this.d != null)
    {
      localURL = this.d;
      return localURL;
    }
    String str1 = paramfx.d();
    for (;;)
    {
      try
      {
        if (!"http:".equals(str1)) {
          break label60;
        }
        str2 = "http://www.google-analytics.com/collect";
        localURL = new URL(str2);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        fA.a("Error trying to parse the hardcoded host url. This really shouldn't happen.");
        localURL = null;
      }
      break;
      label60:
      String str2 = "https://ssl.google-analytics.com/collect";
    }
  }
  
  private HttpEntityEnclosingRequest a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      System.out.println("Empty hit, discarding.");
      localObject = null;
      return localObject;
    }
    String str = this.h + "?" + paramString;
    if ((str.length() < this.e) && (!paramBoolean)) {
      localObject = new BasicHttpEntityEnclosingRequest("GET", str);
    }
    for (;;)
    {
      ((HttpEntityEnclosingRequest)localObject).addHeader("User-Agent", this.a);
      break;
      if (paramBoolean) {
        localObject = new BasicHttpEntityEnclosingRequest("POST", this.i);
      } else {
        localObject = new BasicHttpEntityEnclosingRequest("POST", this.h);
      }
    }
  }
  
  private void a(fB paramfB, HttpHost paramHttpHost, fY paramfY, gg paramgg)
  {
    paramfB.a("_bs", paramfY.toString());
    paramfB.a("_cs", paramgg.toString());
    String str = paramfB.a();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (paramHttpHost == null) {}
    for (;;)
    {
      try
      {
        URL localURL = new URL("https://ssl.google-analytics.com");
        localHttpHost = new HttpHost(localURL.getHost(), localURL.getPort(), localURL.getProtocol());
        a(str, localHttpHost, 1, paramfB, gg.a);
      }
      catch (MalformedURLException localMalformedURLException) {}
      break;
      HttpHost localHttpHost = paramHttpHost;
    }
  }
  
  private void a(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Header[] arrayOfHeader = paramHttpEntityEnclosingRequest.getAllHeaders();
    int i1 = arrayOfHeader.length;
    for (int i2 = 0; i2 < i1; i2++) {
      localStringBuffer.append(arrayOfHeader[i2].toString()).append("\n");
    }
    localStringBuffer.append(paramHttpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
    if (paramHttpEntityEnclosingRequest.getEntity() != null) {}
    try
    {
      InputStream localInputStream = paramHttpEntityEnclosingRequest.getEntity().getContent();
      if (localInputStream != null)
      {
        int i3 = localInputStream.available();
        if (i3 > 0)
        {
          byte[] arrayOfByte = new byte[i3];
          localInputStream.read(arrayOfByte);
          localStringBuffer.append("POST:\n");
          localStringBuffer.append(new String(arrayOfByte)).append("\n");
        }
      }
      fA.b(localStringBuffer.toString());
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        fA.d("Error Writing hit to log...");
      }
    }
  }
  
  private boolean a(String paramString, HttpHost paramHttpHost, int paramInt, fB paramfB, gg paramgg)
  {
    int i1 = 1;
    int i2;
    if (paramInt > i1)
    {
      i2 = i1;
      if ((paramString.getBytes().length <= this.g) && (paramString.getBytes().length <= this.f)) {
        break label85;
      }
      fA.d("Request too long (> " + Math.min(this.f, this.g) + " bytes)--not sent");
    }
    for (;;)
    {
      return i1;
      i2 = 0;
      break;
      label85:
      if (this.q)
      {
        fA.b("Dry run enabled. Hit not actually sent.");
      }
      else
      {
        HttpEntityEnclosingRequest localHttpEntityEnclosingRequest = a(paramString, i2);
        if (localHttpEntityEnclosingRequest != null)
        {
          int i4;
          int i3;
          if (localHttpEntityEnclosingRequest.getRequestLine().getMethod().equals("GET"))
          {
            i4 = paramString.getBytes().length;
            i3 = paramString.getBytes().length;
            localHttpEntityEnclosingRequest.addHeader("Host", paramHttpHost.toHostString());
            if (fA.a()) {
              a(localHttpEntityEnclosingRequest);
            }
          }
          try
          {
            HttpResponse localHttpResponse = this.b.execute(paramHttpHost, localHttpEntityEnclosingRequest);
            paramfB.a("_td", i4);
            paramfB.a("_cd", i3);
            int i5 = localHttpResponse.getStatusLine().getStatusCode();
            HttpEntity localHttpEntity = localHttpResponse.getEntity();
            if (localHttpEntity != null) {
              localHttpEntity.consumeContent();
            }
            if (i5 != 200) {
              if ((i2 != 0) && (this.l.contains(Integer.valueOf(i5))))
              {
                fA.b("Falling back to single hit per request mode.");
                this.m = true;
                this.n = System.currentTimeMillis();
                i1 = 0;
                continue;
                try
                {
                  switch (fX.a[paramgg.ordinal()])
                  {
                  default: 
                    i3 = paramString.getBytes().length;
                    localHttpEntityEnclosingRequest.setEntity(new StringEntity(paramString));
                  }
                  for (;;)
                  {
                    i4 = paramString.getBytes().length;
                    break;
                    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
                    localGZIPOutputStream.write(paramString.getBytes());
                    localGZIPOutputStream.close();
                    byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
                    i3 = 0 + arrayOfByte.length;
                    localHttpEntityEnclosingRequest.setEntity(new ByteArrayEntity(arrayOfByte));
                    localHttpEntityEnclosingRequest.addHeader("Content-Encoding", "gzip");
                  }
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  fA.a("Encoding error, hit will be discarded");
                }
                catch (IOException localIOException1)
                {
                  fA.a("Unexpected IOException: " + localIOException1.getMessage());
                  fA.a("Request will be discarded");
                }
              }
              else
              {
                fA.d("Bad response: " + localHttpResponse.getStatusLine().getStatusCode());
              }
            }
          }
          catch (ClientProtocolException localClientProtocolException)
          {
            fA.d("ClientProtocolException sending hit; discarding hit...");
          }
          catch (IOException localIOException2)
          {
            fA.d("Exception sending hit: " + localIOException2.getClass().getSimpleName());
            fA.d(localIOException2.getMessage());
            i1 = 0;
          }
        }
      }
    }
  }
  
  int a(List<fx> paramList, int paramInt)
  {
    if (paramList.isEmpty())
    {
      i2 = 0;
      return i2;
    }
    if (paramInt > paramList.size()) {
      paramInt = paramList.size();
    }
    int i1 = paramInt - 1;
    long l1 = 0L;
    int i2 = paramInt;
    label42:
    long l4;
    if (i1 > 0)
    {
      fx localfx1 = (fx)paramList.get(i1 - 1);
      fx localfx2 = (fx)paramList.get(i1);
      long l2 = localfx1.c();
      long l3 = localfx2.c();
      if ((l2 == 0L) || (l3 == 0L) || (l3 - l2 <= l1)) {
        break label135;
      }
      l4 = l3 - l2;
    }
    for (int i3 = i1;; i3 = i2)
    {
      i1--;
      i2 = i3;
      l1 = l4;
      break label42;
      break;
      label135:
      l4 = l1;
    }
  }
  
  public int a(List<fx> paramList, fB paramfB, boolean paramBoolean)
  {
    this.e = this.p.a();
    this.f = this.p.b();
    this.g = this.p.c();
    int i1 = this.p.d();
    this.h = this.p.f();
    this.i = this.p.g();
    this.j = this.p.h();
    this.k = this.p.i();
    this.l.clear();
    this.l.addAll(this.p.j());
    this.o = this.p.e();
    if ((!this.m) && (this.l.isEmpty()))
    {
      this.m = true;
      this.n = System.currentTimeMillis();
    }
    if ((this.m) && (System.currentTimeMillis() - this.n > 1000L * this.o)) {
      this.m = false;
    }
    gg localgg;
    Object localObject1;
    int i2;
    int i3;
    long l1;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    long l2;
    int i4;
    label301:
    fx localfx2;
    String str2;
    label338:
    int i17;
    label389:
    int i15;
    label430:
    int i5;
    if (this.m)
    {
      fY localfY2 = fY.a;
      localgg = gg.a;
      localObject1 = localfY2;
      i2 = 0;
      i3 = Math.min(paramList.size(), i1);
      paramfB.a("_hr", paramList.size());
      l1 = System.currentTimeMillis();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      l2 = 0L;
      if (localObject1 == fY.a) {
        break label1092;
      }
      Iterator localIterator2 = paramList.iterator();
      i4 = 0;
      if (!localIterator2.hasNext()) {
        break label1086;
      }
      localfx2 = (fx)localIterator2.next();
      if (!TextUtils.isEmpty(localfx2.a())) {
        break label501;
      }
      str2 = "";
      if (str2.getBytes().length > this.f) {
        str2 = "";
      }
      localArrayList1.add(str2);
      if (!TextUtils.isEmpty(str2))
      {
        int i16 = str2.getBytes().length;
        if (i4 != 0) {
          break label513;
        }
        i17 = 0;
        l2 += i17 + i16;
      }
      localArrayList2.add(Long.valueOf(l2));
      if (l2 > this.g) {
        break label1079;
      }
      i15 = i4 + 1;
      if (i15 != i3) {
        break label519;
      }
      i4 = i15;
      i5 = 1;
    }
    for (;;)
    {
      if ((i4 > 1) && (((Long)localArrayList2.get(i4 - 1)).longValue() > this.g))
      {
        i4--;
        continue;
        fY localfY1 = this.j;
        localgg = this.k;
        localObject1 = localfY1;
        break;
        label501:
        str2 = fy.a(localfx2, l1);
        break label338;
        label513:
        i17 = 1;
        break label389;
        label519:
        i4 = i15;
        break label301;
      }
      int i13;
      if (l2 > this.g) {
        switch (fX.b[localObject1.ordinal()])
        {
        default: 
          fA.d("Unexpected batching strategy encountered; sending a single hit.");
          String str1 = (String)localArrayList1.get(0);
          localArrayList1.clear();
          localArrayList1.add(str1);
          i13 = 1;
          if (i13 >= localArrayList1.size()) {
            break;
          }
        }
      }
      for (Object localObject2 = localArrayList1.subList(0, i13);; localObject2 = localArrayList1)
      {
        int i6 = 0;
        HttpHost localHttpHost = null;
        int i7 = 0;
        int i9;
        int i10;
        int i11;
        int i8;
        for (;;)
        {
          if (i7 < i5)
          {
            fx localfx1 = (fx)paramList.get(i7);
            URL localURL = a(localfx1);
            i9 = Math.max(1, ((List)localObject2).size());
            if (localURL == null)
            {
              fA.d("No destination: discarding hit.");
              i10 = i6 + i9;
              i11 = i2 + i9;
              i7++;
              i6 = i10;
              i2 = i11;
              continue;
              i13 = localArrayList1.size() / 2;
              if (i4 > i13) {
                break;
              }
              i13 = i4;
              break;
              i13 = a(paramList, i4);
              break;
              i13 = b(paramList, i4);
              break;
              if (l2 < 2 * this.g)
              {
                for (int i14 = -1 + localArrayList2.size(); (i14 > 0) && (((Long)localArrayList2.get(i14)).longValue() > l2 / 2L); i14--) {}
                i13 = i14;
                break;
              }
              i13 = i4;
              break;
              i13 = i4;
              break;
            }
            localHttpHost = new HttpHost(localURL.getHost(), localURL.getPort(), localURL.getProtocol());
            if (!a(a(localfx1, (List)localObject2, (fY)localObject1), localHttpHost, i9, paramfB, localgg))
            {
              paramfB.a("_de", 1);
              paramfB.a("_hd", i6);
              paramfB.a("_hs", i2);
              a(paramfB, localHttpHost, (fY)localObject1, localgg);
              i8 = i2;
              label952:
              return i8;
            }
            Iterator localIterator1 = ((List)localObject2).iterator();
            i10 = i6;
            label968:
            if (localIterator1.hasNext()) {
              if (!TextUtils.isEmpty((String)localIterator1.next())) {
                break label1065;
              }
            }
          }
        }
        label1065:
        for (int i12 = i10 + 1;; i12 = i10)
        {
          i10 = i12;
          break label968;
          paramfB.a("_rs", 1);
          i11 = i2 + i9;
          break;
          paramfB.a("_hd", i6);
          paramfB.a("_hs", i2);
          if (paramBoolean) {
            a(paramfB, localHttpHost, (fY)localObject1, localgg);
          }
          i8 = i2;
          break label952;
        }
      }
      label1079:
      i15 = i4;
      break label430;
      label1086:
      i5 = 1;
      continue;
      label1092:
      i4 = 0;
      i5 = i3;
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
  
  public void a(String paramString)
  {
    try
    {
      this.d = new URL(paramString);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        this.d = null;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public boolean a()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.c.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected())) {
      fA.c("...no network connectivity");
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  int b(List<fx> paramList, int paramInt)
  {
    if (paramList.isEmpty()) {
      paramInt = 0;
    }
    label82:
    for (;;)
    {
      return paramInt;
      for (int i1 = paramInt - 1;; i1--)
      {
        if (i1 <= 0) {
          break label82;
        }
        String str = ((fx)paramList.get(i1)).a();
        if (!TextUtils.isEmpty(str))
        {
          if (str.contains("sc=start"))
          {
            paramInt = i1;
            break;
          }
          if (str.contains("sc=end"))
          {
            paramInt = i1 + 1;
            break;
          }
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fW
 * JD-Core Version:    0.7.0.1
 */