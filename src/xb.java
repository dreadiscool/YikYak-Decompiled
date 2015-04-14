import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

final class xb
{
  private HttpClient a;
  
  public xb()
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    localSchemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 60000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 60000);
    this.a = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
  }
  
  /* Error */
  public final org.json.JSONObject a(java.lang.String paramString, org.json.JSONObject paramJSONObject, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_2
    //   4: ifnull +10 -> 14
    //   7: aload_2
    //   8: invokevirtual 92	org/json/JSONObject:length	()I
    //   11: ifne +226 -> 237
    //   14: aload_0
    //   15: getfield 83	xb:a	Lorg/apache/http/client/HttpClient;
    //   18: new 94	org/apache/http/client/methods/HttpGet
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 97	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   26: invokeinterface 103 2 0
    //   31: astore 17
    //   33: aload 17
    //   35: astore 6
    //   37: aload 6
    //   39: ifnull +291 -> 330
    //   42: aload 6
    //   44: invokeinterface 109 1 0
    //   49: astore 8
    //   51: aload 6
    //   53: ldc 111
    //   55: invokeinterface 115 2 0
    //   60: astore 9
    //   62: iload_3
    //   63: ifeq +26 -> 89
    //   66: new 117	java/lang/StringBuilder
    //   69: dup
    //   70: ldc 119
    //   72: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: aload 8
    //   77: invokeinterface 125 1 0
    //   82: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: pop
    //   89: aload 8
    //   91: invokeinterface 125 1 0
    //   96: sipush 200
    //   99: if_icmplt +243 -> 342
    //   102: aload 8
    //   104: invokeinterface 125 1 0
    //   109: sipush 299
    //   112: if_icmpgt +230 -> 342
    //   115: new 135	java/io/BufferedReader
    //   118: dup
    //   119: new 137	java/io/InputStreamReader
    //   122: dup
    //   123: aload 6
    //   125: invokeinterface 141 1 0
    //   130: invokeinterface 147 1 0
    //   135: ldc 54
    //   137: invokespecial 150	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   140: invokespecial 153	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   143: astore 11
    //   145: new 117	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   152: astore 12
    //   154: aload 11
    //   156: invokevirtual 157	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   159: astore 13
    //   161: aload 13
    //   163: ifnonnull +144 -> 307
    //   166: aload 11
    //   168: invokevirtual 160	java/io/BufferedReader:close	()V
    //   171: aload 12
    //   173: invokevirtual 161	java/lang/StringBuilder:length	()I
    //   176: ifle +154 -> 330
    //   179: new 88	org/json/JSONObject
    //   182: dup
    //   183: new 163	org/json/JSONTokener
    //   186: dup
    //   187: aload 12
    //   189: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokespecial 164	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   195: invokespecial 167	org/json/JSONObject:<init>	(Lorg/json/JSONTokener;)V
    //   198: astore 4
    //   200: aload 4
    //   202: areturn
    //   203: astore 5
    //   205: iload_3
    //   206: ifeq +20 -> 226
    //   209: new 117	java/lang/StringBuilder
    //   212: dup
    //   213: ldc 169
    //   215: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   218: aload_1
    //   219: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: pop
    //   226: aload 5
    //   228: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   231: aconst_null
    //   232: astore 6
    //   234: goto -197 -> 37
    //   237: new 177	org/apache/http/entity/StringEntity
    //   240: dup
    //   241: aload_2
    //   242: invokevirtual 178	org/json/JSONObject:toString	()Ljava/lang/String;
    //   245: invokespecial 179	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;)V
    //   248: astore 18
    //   250: aload 18
    //   252: ldc 181
    //   254: invokevirtual 184	org/apache/http/entity/StringEntity:setContentType	(Ljava/lang/String;)V
    //   257: new 186	org/apache/http/client/methods/HttpPost
    //   260: dup
    //   261: aload_1
    //   262: invokespecial 187	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   265: astore 20
    //   267: aload 20
    //   269: aload 18
    //   271: invokevirtual 191	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   274: aload_0
    //   275: getfield 83	xb:a	Lorg/apache/http/client/HttpClient;
    //   278: aload 20
    //   280: invokeinterface 103 2 0
    //   285: astore 21
    //   287: aload 21
    //   289: astore 6
    //   291: goto -254 -> 37
    //   294: astore 19
    //   296: aload 19
    //   298: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   301: aconst_null
    //   302: astore 6
    //   304: goto -267 -> 37
    //   307: aload 12
    //   309: aload 13
    //   311: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: ldc 193
    //   316: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: goto -166 -> 154
    //   323: astore 7
    //   325: aload 7
    //   327: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   330: new 88	org/json/JSONObject
    //   333: dup
    //   334: invokespecial 194	org/json/JSONObject:<init>	()V
    //   337: astore 4
    //   339: goto -139 -> 200
    //   342: aload 8
    //   344: invokeinterface 125 1 0
    //   349: istore 10
    //   351: iload 10
    //   353: sipush 400
    //   356: if_icmpne -26 -> 330
    //   359: aload 9
    //   361: ifnull -31 -> 330
    //   364: goto -164 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	xb
    //   0	367	1	paramString	java.lang.String
    //   0	367	2	paramJSONObject	org.json.JSONObject
    //   0	367	3	paramBoolean	boolean
    //   1	337	4	localJSONObject	org.json.JSONObject
    //   203	24	5	localException1	java.lang.Exception
    //   35	268	6	localObject	Object
    //   323	3	7	localException2	java.lang.Exception
    //   49	294	8	localStatusLine	org.apache.http.StatusLine
    //   60	300	9	localHeader	org.apache.http.Header
    //   349	8	10	i	int
    //   143	24	11	localBufferedReader	java.io.BufferedReader
    //   152	156	12	localStringBuilder	java.lang.StringBuilder
    //   159	151	13	str	java.lang.String
    //   31	3	17	localHttpResponse1	org.apache.http.HttpResponse
    //   248	22	18	localStringEntity	org.apache.http.entity.StringEntity
    //   294	3	19	localException3	java.lang.Exception
    //   265	14	20	localHttpPost	org.apache.http.client.methods.HttpPost
    //   285	3	21	localHttpResponse2	org.apache.http.HttpResponse
    // Exception table:
    //   from	to	target	type
    //   14	33	203	java/lang/Exception
    //   237	287	294	java/lang/Exception
    //   42	200	323	java/lang/Exception
    //   307	320	323	java/lang/Exception
    //   342	351	323	java/lang/Exception
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xb
 * JD-Core Version:    0.7.0.1
 */