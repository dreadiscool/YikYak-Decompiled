import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;

public class KC
{
  private static final String[] b = new String[0];
  private static KF c = KF.a;
  public final URL a;
  private HttpURLConnection d = null;
  private final String e;
  private KJ f;
  private boolean g;
  private boolean h = true;
  private boolean i = false;
  private int j = 8192;
  private String k;
  private int l;
  
  public KC(CharSequence paramCharSequence, String paramString)
  {
    try
    {
      this.a = new URL(paramCharSequence.toString());
      this.e = paramString;
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new KH(localMalformedURLException);
    }
  }
  
  public static KC a(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean)
  {
    String str = a(paramCharSequence, paramMap);
    if (paramBoolean) {
      str = a(str);
    }
    return b(str);
  }
  
  /* Error */
  public static String a(CharSequence paramCharSequence)
  {
    // Byte code:
    //   0: new 52	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokeinterface 58 1 0
    //   10: invokespecial 61	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 88	java/net/URL:getHost	()Ljava/lang/String;
    //   18: astore_2
    //   19: aload_1
    //   20: invokevirtual 92	java/net/URL:getPort	()I
    //   23: istore_3
    //   24: iload_3
    //   25: bipush 255
    //   27: if_icmpeq +30 -> 57
    //   30: new 94	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   37: aload_2
    //   38: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: bipush 58
    //   43: invokevirtual 102	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   46: iload_3
    //   47: invokestatic 107	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   50: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore_2
    //   57: new 110	java/net/URI
    //   60: dup
    //   61: aload_1
    //   62: invokevirtual 113	java/net/URL:getProtocol	()Ljava/lang/String;
    //   65: aload_2
    //   66: aload_1
    //   67: invokevirtual 116	java/net/URL:getPath	()Ljava/lang/String;
    //   70: aload_1
    //   71: invokevirtual 119	java/net/URL:getQuery	()Ljava/lang/String;
    //   74: aconst_null
    //   75: invokespecial 122	java/net/URI:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   78: invokevirtual 125	java/net/URI:toASCIIString	()Ljava/lang/String;
    //   81: astore 7
    //   83: aload 7
    //   85: bipush 63
    //   87: invokevirtual 129	java/lang/String:indexOf	(I)I
    //   90: istore 8
    //   92: iload 8
    //   94: ifle +63 -> 157
    //   97: iload 8
    //   99: iconst_1
    //   100: iadd
    //   101: aload 7
    //   103: invokevirtual 132	java/lang/String:length	()I
    //   106: if_icmpge +51 -> 157
    //   109: new 94	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   116: aload 7
    //   118: iconst_0
    //   119: iload 8
    //   121: iconst_1
    //   122: iadd
    //   123: invokevirtual 136	java/lang/String:substring	(II)Ljava/lang/String;
    //   126: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload 7
    //   131: iload 8
    //   133: iconst_1
    //   134: iadd
    //   135: invokevirtual 138	java/lang/String:substring	(I)Ljava/lang/String;
    //   138: ldc 140
    //   140: ldc 142
    //   142: invokevirtual 146	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   145: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: astore 9
    //   153: aload 9
    //   155: astore 7
    //   157: aload 7
    //   159: areturn
    //   160: astore 10
    //   162: new 67	KH
    //   165: dup
    //   166: aload 10
    //   168: invokespecial 70	KH:<init>	(Ljava/io/IOException;)V
    //   171: athrow
    //   172: astore 4
    //   174: new 83	java/io/IOException
    //   177: dup
    //   178: ldc 148
    //   180: invokespecial 149	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   183: astore 5
    //   185: aload 5
    //   187: aload 4
    //   189: invokevirtual 153	java/io/IOException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   192: pop
    //   193: new 67	KH
    //   196: dup
    //   197: aload 5
    //   199: invokespecial 70	KH:<init>	(Ljava/io/IOException;)V
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramCharSequence	CharSequence
    //   13	58	1	localURL	URL
    //   18	48	2	str1	String
    //   23	24	3	m	int
    //   172	16	4	localURISyntaxException	java.net.URISyntaxException
    //   183	15	5	localIOException1	IOException
    //   81	77	7	localObject	Object
    //   90	45	8	n	int
    //   151	3	9	str2	String
    //   160	7	10	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   0	14	160	java/io/IOException
    //   57	153	172	java/net/URISyntaxException
  }
  
  public static String a(CharSequence paramCharSequence, Map<?, ?> paramMap)
  {
    String str = paramCharSequence.toString();
    if ((paramMap == null) || (paramMap.isEmpty())) {}
    for (;;)
    {
      return str;
      StringBuilder localStringBuilder = new StringBuilder(str);
      a(str, localStringBuilder);
      b(str, localStringBuilder);
      Iterator localIterator = paramMap.entrySet().iterator();
      Map.Entry localEntry1 = (Map.Entry)localIterator.next();
      localStringBuilder.append(localEntry1.getKey().toString());
      localStringBuilder.append('=');
      Object localObject1 = localEntry1.getValue();
      if (localObject1 != null) {
        localStringBuilder.append(localObject1);
      }
      while (localIterator.hasNext())
      {
        localStringBuilder.append('&');
        Map.Entry localEntry2 = (Map.Entry)localIterator.next();
        localStringBuilder.append(localEntry2.getKey().toString());
        localStringBuilder.append('=');
        Object localObject2 = localEntry2.getValue();
        if (localObject2 != null) {
          localStringBuilder.append(localObject2);
        }
      }
      str = localStringBuilder.toString();
    }
  }
  
  private static StringBuilder a(String paramString, StringBuilder paramStringBuilder)
  {
    if (2 + paramString.indexOf(':') == paramString.lastIndexOf('/')) {
      paramStringBuilder.append('/');
    }
    return paramStringBuilder;
  }
  
  public static KC b(CharSequence paramCharSequence)
  {
    return new KC(paramCharSequence, "GET");
  }
  
  public static KC b(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean)
  {
    String str = a(paramCharSequence, paramMap);
    if (paramBoolean) {
      str = a(str);
    }
    return c(str);
  }
  
  private static StringBuilder b(String paramString, StringBuilder paramStringBuilder)
  {
    int m = paramString.indexOf('?');
    int n = -1 + paramStringBuilder.length();
    if (m == -1) {
      paramStringBuilder.append('?');
    }
    for (;;)
    {
      return paramStringBuilder;
      if ((m < n) && (paramString.charAt(n) != '&')) {
        paramStringBuilder.append('&');
      }
    }
  }
  
  public static KC c(CharSequence paramCharSequence)
  {
    return new KC(paramCharSequence, "POST");
  }
  
  public static KC d(CharSequence paramCharSequence)
  {
    return new KC(paramCharSequence, "PUT");
  }
  
  public static KC e(CharSequence paramCharSequence)
  {
    return new KC(paramCharSequence, "DELETE");
  }
  
  private static String f(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (;;)
    {
      return paramString;
      paramString = "UTF-8";
    }
  }
  
  private Proxy q()
  {
    return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.k, this.l));
  }
  
  /* Error */
  private HttpURLConnection r()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 235	KC:k	Ljava/lang/String;
    //   4: ifnull +30 -> 34
    //   7: getstatic 36	KC:c	LKF;
    //   10: aload_0
    //   11: getfield 63	KC:a	Ljava/net/URL;
    //   14: aload_0
    //   15: invokespecial 247	KC:q	()Ljava/net/Proxy;
    //   18: invokeinterface 250 3 0
    //   23: astore_3
    //   24: aload_3
    //   25: aload_0
    //   26: getfield 65	KC:e	Ljava/lang/String;
    //   29: invokevirtual 255	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   32: aload_3
    //   33: areturn
    //   34: getstatic 36	KC:c	LKF;
    //   37: aload_0
    //   38: getfield 63	KC:a	Ljava/net/URL;
    //   41: invokeinterface 258 2 0
    //   46: astore_2
    //   47: aload_2
    //   48: astore_3
    //   49: goto -25 -> 24
    //   52: astore_1
    //   53: new 67	KH
    //   56: dup
    //   57: aload_1
    //   58: invokespecial 70	KH:<init>	(Ljava/io/IOException;)V
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	KC
    //   52	6	1	localIOException	IOException
    //   46	2	2	localHttpURLConnection	HttpURLConnection
    //   23	26	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	47	52	java/io/IOException
  }
  
  public int a(String paramString, int paramInt)
  {
    l();
    return a().getHeaderFieldInt(paramString, paramInt);
  }
  
  public KC a(int paramInt)
  {
    a().setConnectTimeout(paramInt);
    return this;
  }
  
  protected KC a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    return (KC)new KD(this, paramInputStream, this.h, paramInputStream, paramOutputStream).call();
  }
  
  public KC a(String paramString, Number paramNumber)
  {
    return a(paramString, null, paramNumber);
  }
  
  public KC a(String paramString1, String paramString2)
  {
    a().setRequestProperty(paramString1, paramString2);
    return this;
  }
  
  public KC a(String paramString1, String paramString2, Number paramNumber)
  {
    if (paramNumber != null) {}
    for (String str = paramNumber.toString();; str = null) {
      return b(paramString1, paramString2, str);
    }
  }
  
  protected KC a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("form-data; name=\"").append(paramString1);
    if (paramString2 != null) {
      localStringBuilder.append("\"; filename=\"").append(paramString2);
    }
    localStringBuilder.append('"');
    f("Content-Disposition", localStringBuilder.toString());
    if (paramString3 != null) {
      f("Content-Type", paramString3);
    }
    return f("\r\n");
  }
  
  /* Error */
  public KC a(String paramString1, String paramString2, String paramString3, java.io.File paramFile)
  {
    // Byte code:
    //   0: new 310	java/io/BufferedInputStream
    //   3: dup
    //   4: new 312	java/io/FileInputStream
    //   7: dup
    //   8: aload 4
    //   10: invokespecial 315	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   13: invokespecial 318	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   16: astore 5
    //   18: aload_0
    //   19: aload_1
    //   20: aload_2
    //   21: aload_3
    //   22: aload 5
    //   24: invokevirtual 321	KC:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)LKC;
    //   27: astore 9
    //   29: aload 5
    //   31: ifnull +8 -> 39
    //   34: aload 5
    //   36: invokevirtual 326	java/io/InputStream:close	()V
    //   39: aload 9
    //   41: areturn
    //   42: astore 6
    //   44: aconst_null
    //   45: astore 5
    //   47: new 67	KH
    //   50: dup
    //   51: aload 6
    //   53: invokespecial 70	KH:<init>	(Ljava/io/IOException;)V
    //   56: athrow
    //   57: astore 7
    //   59: aload 5
    //   61: ifnull +8 -> 69
    //   64: aload 5
    //   66: invokevirtual 326	java/io/InputStream:close	()V
    //   69: aload 7
    //   71: athrow
    //   72: astore 10
    //   74: goto -35 -> 39
    //   77: astore 8
    //   79: goto -10 -> 69
    //   82: astore 7
    //   84: aconst_null
    //   85: astore 5
    //   87: goto -28 -> 59
    //   90: astore 6
    //   92: goto -45 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	KC
    //   0	95	1	paramString1	String
    //   0	95	2	paramString2	String
    //   0	95	3	paramString3	String
    //   0	95	4	paramFile	java.io.File
    //   16	70	5	localBufferedInputStream	BufferedInputStream
    //   42	10	6	localIOException1	IOException
    //   90	1	6	localIOException2	IOException
    //   57	13	7	localObject1	Object
    //   82	1	7	localObject2	Object
    //   77	1	8	localIOException3	IOException
    //   27	13	9	localKC	KC
    //   72	1	10	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   0	18	42	java/io/IOException
    //   18	29	57	finally
    //   47	57	57	finally
    //   34	39	72	java/io/IOException
    //   64	69	77	java/io/IOException
    //   0	18	82	finally
    //   18	29	90	java/io/IOException
  }
  
  public KC a(String paramString1, String paramString2, String paramString3, InputStream paramInputStream)
  {
    try
    {
      n();
      a(paramString1, paramString2, paramString3);
      a(paramInputStream, this.f);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new KH(localIOException);
    }
  }
  
  public KC a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      n();
      a(paramString1, paramString2, paramString3);
      this.f.a(paramString4);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new KH(localIOException);
    }
  }
  
  public KC a(Map.Entry<String, String> paramEntry)
  {
    return a((String)paramEntry.getKey(), (String)paramEntry.getValue());
  }
  
  public KC a(boolean paramBoolean)
  {
    a().setUseCaches(paramBoolean);
    return this;
  }
  
  public String a(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = d();
    try
    {
      a(f(), localByteArrayOutputStream);
      String str = localByteArrayOutputStream.toString(f(paramString));
      return str;
    }
    catch (IOException localIOException)
    {
      throw new KH(localIOException);
    }
  }
  
  public HttpURLConnection a()
  {
    if (this.d == null) {
      this.d = r();
    }
    return this.d;
  }
  
  public int b()
  {
    try
    {
      k();
      int m = a().getResponseCode();
      return m;
    }
    catch (IOException localIOException)
    {
      throw new KH(localIOException);
    }
  }
  
  public KC b(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, null, paramString3);
  }
  
  public String b(String paramString)
  {
    l();
    return a().getHeaderField(paramString);
  }
  
  public String b(String paramString1, String paramString2)
  {
    return c(b(paramString1), paramString2);
  }
  
  public int c(String paramString)
  {
    return a(paramString, -1);
  }
  
  protected String c(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    int m;
    int n;
    for (String str = null;; str = null)
    {
      return str;
      m = paramString1.length();
      n = 1 + paramString1.indexOf(';');
      if ((n != 0) && (n != m)) {
        break;
      }
    }
    int i1 = paramString1.indexOf(';', n);
    int i2;
    int i3;
    if (i1 == -1)
    {
      i2 = n;
      i3 = m;
    }
    for (;;)
    {
      if (i2 < i3)
      {
        int i4 = paramString1.indexOf('=', i2);
        if ((i4 != -1) && (i4 < i3) && (paramString2.equals(paramString1.substring(i2, i4).trim())))
        {
          str = paramString1.substring(i4 + 1, i3).trim();
          int i8 = str.length();
          if (i8 != 0)
          {
            if ((i8 <= 2) || ('"' != str.charAt(0)) || ('"' != str.charAt(i8 - 1))) {
              break;
            }
            str = str.substring(1, i8 - 1);
            break;
          }
        }
        int i5 = i3 + 1;
        int i6 = paramString1.indexOf(';', i5);
        if (i6 == -1) {
          i6 = m;
        }
        int i7 = i6;
        i2 = i5;
        i3 = i7;
        continue;
      }
      str = null;
      break;
      i2 = n;
      i3 = i1;
    }
  }
  
  public boolean c()
  {
    if (200 == b()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public KC d(String paramString)
  {
    return d(paramString, null);
  }
  
  public KC d(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0)) {}
    for (KC localKC = a("Content-Type", paramString1 + "; charset=" + paramString2);; localKC = a("Content-Type", paramString1)) {
      return localKC;
    }
  }
  
  protected ByteArrayOutputStream d()
  {
    int m = j();
    if (m > 0) {}
    for (ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(m);; localByteArrayOutputStream = new ByteArrayOutputStream()) {
      return localByteArrayOutputStream;
    }
  }
  
  public KC e(String paramString1, String paramString2)
  {
    return b(paramString1, null, paramString2);
  }
  
  public String e()
  {
    return a(h());
  }
  
  public KC f(CharSequence paramCharSequence)
  {
    try
    {
      m();
      this.f.a(paramCharSequence.toString());
      return this;
    }
    catch (IOException localIOException)
    {
      throw new KH(localIOException);
    }
  }
  
  public KC f(String paramString1, String paramString2)
  {
    return f(paramString1).f(": ").f(paramString2).f("\r\n");
  }
  
  public BufferedInputStream f()
  {
    return new BufferedInputStream(g(), this.j);
  }
  
  public InputStream g()
  {
    if (b() < 400) {}
    for (;;)
    {
      try
      {
        InputStream localInputStream2 = a().getInputStream();
        localObject = localInputStream2;
        if ((this.i) && ("gzip".equals(i()))) {
          break label91;
        }
        return localObject;
      }
      catch (IOException localIOException3)
      {
        throw new KH(localIOException3);
      }
      Object localObject = a().getErrorStream();
      if (localObject != null) {
        continue;
      }
      try
      {
        InputStream localInputStream1 = a().getInputStream();
        localObject = localInputStream1;
      }
      catch (IOException localIOException1)
      {
        throw new KH(localIOException1);
      }
      try
      {
        label91:
        GZIPInputStream localGZIPInputStream = new GZIPInputStream((InputStream)localObject);
        localObject = localGZIPInputStream;
      }
      catch (IOException localIOException2)
      {
        throw new KH(localIOException2);
      }
    }
  }
  
  public String h()
  {
    return b("Content-Type", "charset");
  }
  
  public String i()
  {
    return b("Content-Encoding");
  }
  
  public int j()
  {
    return c("Content-Length");
  }
  
  protected KC k()
  {
    if (this.f == null) {}
    for (;;)
    {
      return this;
      if (this.g) {
        this.f.a("\r\n--00content0boundary00--\r\n");
      }
      if (this.h) {}
      try
      {
        this.f.close();
        for (;;)
        {
          label41:
          this.f = null;
          break;
          this.f.close();
        }
      }
      catch (IOException localIOException)
      {
        break label41;
      }
    }
  }
  
  protected KC l()
  {
    try
    {
      KC localKC = k();
      return localKC;
    }
    catch (IOException localIOException)
    {
      throw new KH(localIOException);
    }
  }
  
  protected KC m()
  {
    if (this.f != null) {}
    for (;;)
    {
      return this;
      a().setDoOutput(true);
      String str = c(a().getRequestProperty("Content-Type"), "charset");
      this.f = new KJ(a().getOutputStream(), str, this.j);
    }
  }
  
  protected KC n()
  {
    if (!this.g)
    {
      this.g = true;
      d("multipart/form-data; boundary=00content0boundary00").m();
      this.f.a("--00content0boundary00\r\n");
    }
    for (;;)
    {
      return this;
      this.f.a("\r\n--00content0boundary00\r\n");
    }
  }
  
  public URL o()
  {
    return a().getURL();
  }
  
  public String p()
  {
    return a().getRequestMethod();
  }
  
  public String toString()
  {
    return p() + ' ' + o();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     KC
 * JD-Core Version:    0.7.0.1
 */