package com.facebook;

import android.content.Context;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.FileLruCache.Limits;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;
import com.facebook.model.GraphObjectList;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Response
{
  private static final String BODY_KEY = "body";
  private static final String CODE_KEY = "code";
  private static final int INVALID_SESSION_FACEBOOK_ERROR_CODE = 190;
  public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
  private static final String RESPONSE_CACHE_TAG = "ResponseCache";
  private static final String RESPONSE_LOG_TAG = "Response";
  public static final String SUCCESS_KEY = "success";
  private static FileLruCache responseCache;
  private final HttpURLConnection connection;
  private final FacebookRequestError error;
  private final GraphObject graphObject;
  private final GraphObjectList<GraphObject> graphObjectList;
  private final boolean isFromCache;
  private final String rawResponse;
  private final Request request;
  
  static
  {
    if (!Response.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  Response(Request paramRequest, HttpURLConnection paramHttpURLConnection, FacebookRequestError paramFacebookRequestError)
  {
    this(paramRequest, paramHttpURLConnection, null, null, null, false, paramFacebookRequestError);
  }
  
  Response(Request paramRequest, HttpURLConnection paramHttpURLConnection, String paramString, GraphObject paramGraphObject, GraphObjectList<GraphObject> paramGraphObjectList, boolean paramBoolean, FacebookRequestError paramFacebookRequestError)
  {
    this.request = paramRequest;
    this.connection = paramHttpURLConnection;
    this.rawResponse = paramString;
    this.graphObject = paramGraphObject;
    this.graphObjectList = paramGraphObjectList;
    this.isFromCache = paramBoolean;
    this.error = paramFacebookRequestError;
  }
  
  Response(Request paramRequest, HttpURLConnection paramHttpURLConnection, String paramString, GraphObject paramGraphObject, boolean paramBoolean)
  {
    this(paramRequest, paramHttpURLConnection, paramString, paramGraphObject, null, paramBoolean, null);
  }
  
  Response(Request paramRequest, HttpURLConnection paramHttpURLConnection, String paramString, GraphObjectList<GraphObject> paramGraphObjectList, boolean paramBoolean)
  {
    this(paramRequest, paramHttpURLConnection, paramString, null, paramGraphObjectList, paramBoolean, null);
  }
  
  static List<Response> constructErrorResponses(List<Request> paramList, HttpURLConnection paramHttpURLConnection, FacebookException paramFacebookException)
  {
    int i = paramList.size();
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++) {
      localArrayList.add(new Response((Request)paramList.get(j), paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, paramFacebookException)));
    }
    return localArrayList;
  }
  
  private static Response createResponseFromObject(Request paramRequest, HttpURLConnection paramHttpURLConnection, Object paramObject1, boolean paramBoolean, Object paramObject2)
  {
    JSONObject localJSONObject;
    Response localResponse;
    if ((paramObject1 instanceof JSONObject))
    {
      localJSONObject = (JSONObject)paramObject1;
      FacebookRequestError localFacebookRequestError = FacebookRequestError.checkResponseAndCreateError(localJSONObject, paramObject2, paramHttpURLConnection);
      if (localFacebookRequestError != null)
      {
        if (localFacebookRequestError.getErrorCode() == 190)
        {
          Session localSession = paramRequest.getSession();
          if (localSession != null) {
            localSession.closeAndClearTokenInformation();
          }
        }
        localResponse = new Response(paramRequest, paramHttpURLConnection, localFacebookRequestError);
      }
    }
    for (;;)
    {
      return localResponse;
      Object localObject = Utility.getStringPropertyAsJSON(localJSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
      if ((localObject instanceof JSONObject))
      {
        GraphObject localGraphObject = GraphObject.Factory.create((JSONObject)localObject);
        localResponse = new Response(paramRequest, paramHttpURLConnection, localObject.toString(), localGraphObject, paramBoolean);
      }
      else if ((localObject instanceof JSONArray))
      {
        GraphObjectList localGraphObjectList = GraphObject.Factory.createList((JSONArray)localObject, GraphObject.class);
        localResponse = new Response(paramRequest, paramHttpURLConnection, localObject.toString(), localGraphObjectList, paramBoolean);
      }
      else
      {
        paramObject1 = JSONObject.NULL;
        if (paramObject1 != JSONObject.NULL) {
          break;
        }
        localResponse = new Response(paramRequest, paramHttpURLConnection, paramObject1.toString(), (GraphObject)null, paramBoolean);
      }
    }
    throw new FacebookException("Got unexpected object type in response, class: " + paramObject1.getClass().getSimpleName());
  }
  
  private static List<Response> createResponsesFromObject(HttpURLConnection paramHttpURLConnection, List<Request> paramList, Object paramObject, boolean paramBoolean)
  {
    int i = 0;
    assert ((paramHttpURLConnection != null) || (paramBoolean));
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList(j);
    Request localRequest2;
    if (j == 1) {
      localRequest2 = (Request)paramList.get(0);
    }
    Object localObject;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("body", paramObject);
        if (paramHttpURLConnection != null)
        {
          k = paramHttpURLConnection.getResponseCode();
          localJSONObject.put("code", k);
          localObject = new JSONArray();
          ((JSONArray)localObject).put(localJSONObject);
          if (((localObject instanceof JSONArray)) && (((JSONArray)localObject).length() == j)) {
            break;
          }
          throw new FacebookException("Unexpected number of results");
        }
        int k = 200;
        continue;
      }
      catch (JSONException localJSONException2)
      {
        localArrayList.add(new Response(localRequest2, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localJSONException2)));
        localObject = paramObject;
        continue;
      }
      catch (IOException localIOException)
      {
        localArrayList.add(new Response(localRequest2, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localIOException)));
      }
      localObject = paramObject;
    }
    JSONArray localJSONArray = (JSONArray)localObject;
    for (;;)
    {
      if (i < localJSONArray.length())
      {
        Request localRequest1 = (Request)paramList.get(i);
        try
        {
          localArrayList.add(createResponseFromObject(localRequest1, paramHttpURLConnection, localJSONArray.get(i), paramBoolean, paramObject));
          i++;
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            localArrayList.add(new Response(localRequest1, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localJSONException1)));
          }
        }
        catch (FacebookException localFacebookException)
        {
          for (;;)
          {
            localArrayList.add(new Response(localRequest1, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localFacebookException)));
          }
        }
      }
    }
    return localArrayList;
  }
  
  static List<Response> createResponsesFromStream(InputStream paramInputStream, HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch, boolean paramBoolean)
  {
    String str = Utility.readStreamToString(paramInputStream);
    LoggingBehavior localLoggingBehavior = LoggingBehavior.INCLUDE_RAW_RESPONSES;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(str.length());
    arrayOfObject[1] = str;
    Logger.log(localLoggingBehavior, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", arrayOfObject);
    return createResponsesFromString(str, paramHttpURLConnection, paramRequestBatch, paramBoolean);
  }
  
  static List<Response> createResponsesFromString(String paramString, HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch, boolean paramBoolean)
  {
    List localList = createResponsesFromObject(paramHttpURLConnection, paramRequestBatch, new JSONTokener(paramString).nextValue(), paramBoolean);
    LoggingBehavior localLoggingBehavior = LoggingBehavior.REQUESTS;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = paramRequestBatch.getId();
    arrayOfObject[1] = Integer.valueOf(paramString.length());
    arrayOfObject[2] = localList;
    Logger.log(localLoggingBehavior, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", arrayOfObject);
    return localList;
  }
  
  /* Error */
  static List<Response> fromHttpConnection(HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: instanceof 273
    //   6: ifeq +552 -> 558
    //   9: aload_1
    //   10: checkcast 273	com/facebook/internal/CacheableRequestBatch
    //   13: astore 25
    //   15: invokestatic 277	com/facebook/Response:getResponseCache	()Lcom/facebook/internal/FileLruCache;
    //   18: astore 26
    //   20: aload 25
    //   22: invokevirtual 280	com/facebook/internal/CacheableRequestBatch:getCacheKeyOverride	()Ljava/lang/String;
    //   25: astore 27
    //   27: aload 27
    //   29: invokestatic 284	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   32: ifeq +21 -> 53
    //   35: aload_1
    //   36: invokevirtual 285	com/facebook/RequestBatch:size	()I
    //   39: iconst_1
    //   40: if_icmpne +70 -> 110
    //   43: aload_1
    //   44: iconst_0
    //   45: invokevirtual 288	com/facebook/RequestBatch:get	(I)Lcom/facebook/Request;
    //   48: invokevirtual 291	com/facebook/Request:getUrlForSingleRequest	()Ljava/lang/String;
    //   51: astore 27
    //   53: aload 25
    //   55: invokevirtual 294	com/facebook/internal/CacheableRequestBatch:getForceRoundTrip	()Z
    //   58: ifne +484 -> 542
    //   61: aload 26
    //   63: ifnull +479 -> 542
    //   66: aload 27
    //   68: invokestatic 284	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   71: ifne +471 -> 542
    //   74: aload 26
    //   76: aload 27
    //   78: invokevirtual 299	com/facebook/internal/FileLruCache:get	(Ljava/lang/String;)Ljava/io/InputStream;
    //   81: astore 36
    //   83: aload 36
    //   85: astore_2
    //   86: aload_2
    //   87: ifnull +37 -> 124
    //   90: aload_2
    //   91: aconst_null
    //   92: aload_1
    //   93: iconst_1
    //   94: invokestatic 301	com/facebook/Response:createResponsesFromStream	(Ljava/io/InputStream;Ljava/net/HttpURLConnection;Lcom/facebook/RequestBatch;Z)Ljava/util/List;
    //   97: astore 39
    //   99: aload 39
    //   101: astore 10
    //   103: aload_2
    //   104: invokestatic 305	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   107: aload 10
    //   109: areturn
    //   110: getstatic 260	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   113: ldc 23
    //   115: ldc_w 307
    //   118: invokestatic 310	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
    //   121: goto -68 -> 53
    //   124: aload_2
    //   125: invokestatic 305	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   128: aload 26
    //   130: astore_3
    //   131: aload 27
    //   133: astore 37
    //   135: aload_2
    //   136: astore 4
    //   138: aload 37
    //   140: astore_2
    //   141: aload_0
    //   142: invokevirtual 200	java/net/HttpURLConnection:getResponseCode	()I
    //   145: sipush 400
    //   148: if_icmplt +107 -> 255
    //   151: aload_0
    //   152: invokevirtual 314	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   155: astore 4
    //   157: aload 4
    //   159: aload_0
    //   160: aload_1
    //   161: iconst_0
    //   162: invokestatic 301	com/facebook/Response:createResponsesFromStream	(Ljava/io/InputStream;Ljava/net/HttpURLConnection;Lcom/facebook/RequestBatch;Z)Ljava/util/List;
    //   165: astore 24
    //   167: aload 24
    //   169: astore 10
    //   171: aload 4
    //   173: invokestatic 305	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   176: goto -69 -> 107
    //   179: astore 34
    //   181: aconst_null
    //   182: astore 35
    //   184: aload 35
    //   186: invokestatic 305	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   189: aload 27
    //   191: astore_2
    //   192: aload 35
    //   194: astore 4
    //   196: aload 26
    //   198: astore_3
    //   199: goto -58 -> 141
    //   202: astore 32
    //   204: aload_2
    //   205: invokestatic 305	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   208: aload 26
    //   210: astore_3
    //   211: aload 27
    //   213: astore 33
    //   215: aload_2
    //   216: astore 4
    //   218: aload 33
    //   220: astore_2
    //   221: goto -80 -> 141
    //   224: astore 30
    //   226: aload_2
    //   227: invokestatic 305	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   230: aload 26
    //   232: astore_3
    //   233: aload 27
    //   235: astore 31
    //   237: aload_2
    //   238: astore 4
    //   240: aload 31
    //   242: astore_2
    //   243: goto -102 -> 141
    //   246: astore 29
    //   248: aload_2
    //   249: invokestatic 305	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   252: aload 29
    //   254: athrow
    //   255: aload_0
    //   256: invokevirtual 317	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   259: astore 4
    //   261: aload_3
    //   262: ifnull -105 -> 157
    //   265: aload_2
    //   266: ifnull -109 -> 157
    //   269: aload 4
    //   271: ifnull -114 -> 157
    //   274: aload_3
    //   275: aload_2
    //   276: aload 4
    //   278: invokevirtual 321	com/facebook/internal/FileLruCache:interceptAndPut	(Ljava/lang/String;Ljava/io/InputStream;)Ljava/io/InputStream;
    //   281: astore 23
    //   283: aload 23
    //   285: ifnull -128 -> 157
    //   288: aload 23
    //   290: astore 4
    //   292: goto -135 -> 157
    //   295: astore 19
    //   297: getstatic 260	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   300: astore 20
    //   302: iconst_1
    //   303: anewarray 4	java/lang/Object
    //   306: astore 21
    //   308: aload 21
    //   310: iconst_0
    //   311: aload 19
    //   313: aastore
    //   314: aload 20
    //   316: ldc 26
    //   318: ldc_w 323
    //   321: aload 21
    //   323: invokestatic 244	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   326: aload_1
    //   327: aload_0
    //   328: aload 19
    //   330: invokestatic 325	com/facebook/Response:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
    //   333: astore 22
    //   335: aload 22
    //   337: astore 10
    //   339: aload 4
    //   341: invokestatic 305	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   344: goto -237 -> 107
    //   347: astore 15
    //   349: getstatic 260	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   352: astore 16
    //   354: iconst_1
    //   355: anewarray 4	java/lang/Object
    //   358: astore 17
    //   360: aload 17
    //   362: iconst_0
    //   363: aload 15
    //   365: aastore
    //   366: aload 16
    //   368: ldc 26
    //   370: ldc_w 323
    //   373: aload 17
    //   375: invokestatic 244	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   378: aload_1
    //   379: aload_0
    //   380: new 161	com/facebook/FacebookException
    //   383: dup
    //   384: aload 15
    //   386: invokespecial 328	com/facebook/FacebookException:<init>	(Ljava/lang/Throwable;)V
    //   389: invokestatic 325	com/facebook/Response:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
    //   392: astore 18
    //   394: aload 18
    //   396: astore 10
    //   398: aload 4
    //   400: invokestatic 305	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   403: goto -296 -> 107
    //   406: astore 11
    //   408: getstatic 260	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   411: astore 12
    //   413: iconst_1
    //   414: anewarray 4	java/lang/Object
    //   417: astore 13
    //   419: aload 13
    //   421: iconst_0
    //   422: aload 11
    //   424: aastore
    //   425: aload 12
    //   427: ldc 26
    //   429: ldc_w 323
    //   432: aload 13
    //   434: invokestatic 244	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   437: aload_1
    //   438: aload_0
    //   439: new 161	com/facebook/FacebookException
    //   442: dup
    //   443: aload 11
    //   445: invokespecial 328	com/facebook/FacebookException:<init>	(Ljava/lang/Throwable;)V
    //   448: invokestatic 325	com/facebook/Response:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
    //   451: astore 14
    //   453: aload 14
    //   455: astore 10
    //   457: aload 4
    //   459: invokestatic 305	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   462: goto -355 -> 107
    //   465: astore 6
    //   467: getstatic 260	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   470: astore 7
    //   472: iconst_1
    //   473: anewarray 4	java/lang/Object
    //   476: astore 8
    //   478: aload 8
    //   480: iconst_0
    //   481: aload 6
    //   483: aastore
    //   484: aload 7
    //   486: ldc 26
    //   488: ldc_w 323
    //   491: aload 8
    //   493: invokestatic 244	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   496: aload_1
    //   497: aload_0
    //   498: new 161	com/facebook/FacebookException
    //   501: dup
    //   502: aload 6
    //   504: invokespecial 328	com/facebook/FacebookException:<init>	(Ljava/lang/Throwable;)V
    //   507: invokestatic 325	com/facebook/Response:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
    //   510: astore 9
    //   512: aload 9
    //   514: astore 10
    //   516: aload 4
    //   518: invokestatic 305	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   521: goto -414 -> 107
    //   524: astore 5
    //   526: aload 4
    //   528: invokestatic 305	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   531: aload 5
    //   533: athrow
    //   534: astore 38
    //   536: aload_2
    //   537: astore 35
    //   539: goto -355 -> 184
    //   542: aload 26
    //   544: astore_3
    //   545: aload 27
    //   547: astore 28
    //   549: aconst_null
    //   550: astore 4
    //   552: aload 28
    //   554: astore_2
    //   555: goto -414 -> 141
    //   558: aconst_null
    //   559: astore_3
    //   560: aconst_null
    //   561: astore 4
    //   563: goto -422 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	paramHttpURLConnection	HttpURLConnection
    //   0	566	1	paramRequestBatch	RequestBatch
    //   1	554	2	localObject1	Object
    //   130	430	3	localFileLruCache1	FileLruCache
    //   136	426	4	localObject2	Object
    //   524	8	5	localObject3	Object
    //   465	38	6	localSecurityException	java.lang.SecurityException
    //   470	15	7	localLoggingBehavior1	LoggingBehavior
    //   476	16	8	arrayOfObject1	Object[]
    //   510	3	9	localList1	List
    //   101	414	10	localObject4	Object
    //   406	38	11	localIOException1	IOException
    //   411	15	12	localLoggingBehavior2	LoggingBehavior
    //   417	16	13	arrayOfObject2	Object[]
    //   451	3	14	localList2	List
    //   347	38	15	localJSONException1	JSONException
    //   352	15	16	localLoggingBehavior3	LoggingBehavior
    //   358	16	17	arrayOfObject3	Object[]
    //   392	3	18	localList3	List
    //   295	34	19	localFacebookException1	FacebookException
    //   300	15	20	localLoggingBehavior4	LoggingBehavior
    //   306	16	21	arrayOfObject4	Object[]
    //   333	3	22	localList4	List
    //   281	8	23	localInputStream1	InputStream
    //   165	3	24	localList5	List
    //   13	41	25	localCacheableRequestBatch	com.facebook.internal.CacheableRequestBatch
    //   18	525	26	localFileLruCache2	FileLruCache
    //   25	521	27	str1	String
    //   547	6	28	str2	String
    //   246	7	29	localObject5	Object
    //   224	1	30	localIOException2	IOException
    //   235	6	31	str3	String
    //   202	1	32	localJSONException2	JSONException
    //   213	6	33	str4	String
    //   179	1	34	localFacebookException2	FacebookException
    //   182	356	35	localObject6	Object
    //   81	3	36	localInputStream2	InputStream
    //   133	6	37	str5	String
    //   534	1	38	localFacebookException3	FacebookException
    //   97	3	39	localList6	List
    // Exception table:
    //   from	to	target	type
    //   74	83	179	com/facebook/FacebookException
    //   74	83	202	org/json/JSONException
    //   90	99	202	org/json/JSONException
    //   74	83	224	java/io/IOException
    //   90	99	224	java/io/IOException
    //   74	83	246	finally
    //   90	99	246	finally
    //   141	167	295	com/facebook/FacebookException
    //   255	283	295	com/facebook/FacebookException
    //   141	167	347	org/json/JSONException
    //   255	283	347	org/json/JSONException
    //   141	167	406	java/io/IOException
    //   255	283	406	java/io/IOException
    //   141	167	465	java/lang/SecurityException
    //   255	283	465	java/lang/SecurityException
    //   141	167	524	finally
    //   255	283	524	finally
    //   297	335	524	finally
    //   349	394	524	finally
    //   408	453	524	finally
    //   467	512	524	finally
    //   90	99	534	com/facebook/FacebookException
  }
  
  static FileLruCache getResponseCache()
  {
    if (responseCache == null)
    {
      Context localContext = Session.getStaticContext();
      if (localContext != null) {
        responseCache = new FileLruCache(localContext, "ResponseCache", new FileLruCache.Limits());
      }
    }
    return responseCache;
  }
  
  public final HttpURLConnection getConnection()
  {
    return this.connection;
  }
  
  public final FacebookRequestError getError()
  {
    return this.error;
  }
  
  public final GraphObject getGraphObject()
  {
    return this.graphObject;
  }
  
  public final <T extends GraphObject> T getGraphObjectAs(Class<T> paramClass)
  {
    if (this.graphObject == null) {}
    for (Object localObject = null;; localObject = this.graphObject.cast(paramClass))
    {
      return localObject;
      if (paramClass == null) {
        throw new NullPointerException("Must pass in a valid interface that extends GraphObject");
      }
    }
  }
  
  public final GraphObjectList<GraphObject> getGraphObjectList()
  {
    return this.graphObjectList;
  }
  
  public final <T extends GraphObject> GraphObjectList<T> getGraphObjectListAs(Class<T> paramClass)
  {
    if (this.graphObjectList == null) {}
    for (Object localObject = null;; localObject = this.graphObjectList.castToListOf(paramClass)) {
      return localObject;
    }
  }
  
  public final boolean getIsFromCache()
  {
    return this.isFromCache;
  }
  
  public String getRawResponse()
  {
    return this.rawResponse;
  }
  
  public Request getRequest()
  {
    return this.request;
  }
  
  public Request getRequestForPagedResults(Response.PagingDirection paramPagingDirection)
  {
    Object localObject = null;
    Response.PagingInfo localPagingInfo;
    String str;
    if (this.graphObject != null)
    {
      localPagingInfo = ((Response.PagedResults)this.graphObject.cast(Response.PagedResults.class)).getPaging();
      if (localPagingInfo != null) {
        if (paramPagingDirection == Response.PagingDirection.NEXT) {
          str = localPagingInfo.getNext();
        }
      }
    }
    for (;;)
    {
      if (Utility.isNullOrEmpty(str)) {}
      for (;;)
      {
        return localObject;
        str = localPagingInfo.getPrevious();
        break;
        if ((str == null) || (!str.equals(this.request.getUrlForSingleRequest()))) {
          try
          {
            Request localRequest = new Request(this.request.getSession(), new URL(str));
            localObject = localRequest;
          }
          catch (MalformedURLException localMalformedURLException) {}
        }
      }
      str = null;
    }
  }
  
  public String toString()
  {
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = new Object[1];
        if (this.connection == null) {
          continue;
        }
        i = this.connection.getResponseCode();
        arrayOfObject[0] = Integer.valueOf(i);
        String str2 = String.format("%d", arrayOfObject);
        str1 = str2;
      }
      catch (IOException localIOException)
      {
        int i;
        String str1 = "unknown";
        continue;
      }
      return "{Response: " + " responseCode: " + str1 + ", graphObject: " + this.graphObject + ", error: " + this.error + ", isFromCache:" + this.isFromCache + "}";
      i = 200;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Response
 * JD-Core Version:    0.7.0.1
 */