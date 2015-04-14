package com.amplitude.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.text.TextUtils;
import android.util.Pair;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Amplitude$Lib
{
  private String advertisingId;
  private String apiKey;
  private String brand;
  private String carrier;
  private Context context;
  private String country;
  private String deviceId;
  private DeviceInfo deviceInfo;
  private Runnable endSessionRunnable;
  WorkerThread httpThread = new WorkerThread("httpThread");
  private boolean initialized = false;
  private String language;
  WorkerThread logThread = new WorkerThread("logThread");
  private String manufacturer;
  private String model;
  private boolean newDeviceIdPerInstall = false;
  private boolean optOut = false;
  private String osName;
  private String osVersion;
  private long sessionId = -1L;
  private boolean sessionOpen = false;
  private long sessionTimeoutMillis = 1800000L;
  private AtomicBoolean updateScheduled = new AtomicBoolean(false);
  private AtomicBoolean uploadingCurrently = new AtomicBoolean(false);
  private boolean useAdvertisingIdForDeviceId = false;
  private String userId;
  JSONObject userProperties;
  private String versionName;
  
  protected Amplitude$Lib()
  {
    this.logThread.start();
    this.httpThread.start();
  }
  
  private String bytesToHexString(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[16];
    arrayOfChar1[0] = 48;
    arrayOfChar1[1] = 49;
    arrayOfChar1[2] = 50;
    arrayOfChar1[3] = 51;
    arrayOfChar1[4] = 52;
    arrayOfChar1[5] = 53;
    arrayOfChar1[6] = 54;
    arrayOfChar1[7] = 55;
    arrayOfChar1[8] = 56;
    arrayOfChar1[9] = 57;
    arrayOfChar1[10] = 97;
    arrayOfChar1[11] = 98;
    arrayOfChar1[12] = 99;
    arrayOfChar1[13] = 100;
    arrayOfChar1[14] = 101;
    arrayOfChar1[15] = 102;
    char[] arrayOfChar2 = new char[2 * paramArrayOfByte.length];
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      int j = 0xFF & paramArrayOfByte[i];
      arrayOfChar2[(i * 2)] = arrayOfChar1[(j >>> 4)];
      arrayOfChar2[(1 + i * 2)] = arrayOfChar1[(j & 0xF)];
    }
    return new String(arrayOfChar2);
  }
  
  private void checkedLogEvent(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2, long paramLong, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if (contextAndApiKeySet("logEvent()")) {
        runOnLogThread(new Amplitude.Lib.2(this, paramString, paramJSONObject1, paramJSONObject2, paramLong, paramBoolean));
      }
    }
  }
  
  private void clearEndSession()
  {
    this.context.getSharedPreferences(getSharedPreferencesName(), 0).edit().remove(Constants.PREFKEY_PREVIOUS_END_SESSION_TIME).remove(Constants.PREFKEY_PREVIOUS_END_SESSION_ID).commit();
  }
  
  private JSONObject cloneJSONObject(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.names();
    int i = localJSONArray.length();
    String[] arrayOfString = new String[i];
    for (int j = 0; j < i; j++) {
      arrayOfString[j] = localJSONArray.optString(j);
    }
    try
    {
      localJSONObject = new JSONObject(paramJSONObject, arrayOfString);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.toString();
        JSONObject localJSONObject = null;
      }
    }
  }
  
  private void closeSession()
  {
    this.sessionOpen = false;
  }
  
  private boolean contextAndApiKeySet(String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (this.context == null)
        {
          new StringBuilder().append("context cannot be null, set context with initialize() before calling ").append(paramString).toString();
          return bool;
        }
        if (TextUtils.isEmpty(this.apiKey)) {
          new StringBuilder().append("apiKey cannot be null or empty, set apiKey with initialize() before calling ").append(paramString).toString();
        } else {
          bool = true;
        }
      }
      finally {}
    }
  }
  
  private long getEndSessionId()
  {
    return this.context.getSharedPreferences(getSharedPreferencesName(), 0).getLong(Constants.PREFKEY_PREVIOUS_END_SESSION_ID, -1L);
  }
  
  private long getEndSessionTime()
  {
    return this.context.getSharedPreferences(getSharedPreferencesName(), 0).getLong(Constants.PREFKEY_PREVIOUS_END_SESSION_TIME, -1L);
  }
  
  private long getLastEventTime()
  {
    return this.context.getSharedPreferences(getSharedPreferencesName(), 0).getLong(Constants.PREFKEY_PREVIOUS_SESSION_TIME, -1L);
  }
  
  private String getSharedPreferencesName()
  {
    return Constants.SHARED_PREFERENCES_NAME_PREFIX + "." + this.context.getPackageName();
  }
  
  private String initializeDeviceId()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("");
    localHashSet.add("9774d56d682e549c");
    localHashSet.add("unknown");
    localHashSet.add("000000000000000");
    localHashSet.add("Android");
    localHashSet.add("DEFACE");
    SharedPreferences localSharedPreferences = this.context.getSharedPreferences(getSharedPreferencesName(), 0);
    String str = localSharedPreferences.getString(Constants.PREFKEY_DEVICE_ID, null);
    if ((!TextUtils.isEmpty(str)) && (!localHashSet.contains(str))) {}
    for (;;)
    {
      return str;
      if ((!this.newDeviceIdPerInstall) && (this.useAdvertisingIdForDeviceId))
      {
        str = this.deviceInfo.getAdvertisingId();
        if ((!TextUtils.isEmpty(str)) && (!localHashSet.contains(str)))
        {
          localSharedPreferences.edit().putString(Constants.PREFKEY_DEVICE_ID, str).commit();
          continue;
        }
      }
      str = this.deviceInfo.generateUUID() + "R";
      localSharedPreferences.edit().putString(Constants.PREFKEY_DEVICE_ID, str).commit();
    }
  }
  
  private void initializeDeviceInfo()
  {
    this.deviceInfo = new DeviceInfo(this.context);
    runOnLogThread(new Amplitude.Lib.1(this));
  }
  
  private long logEvent(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2, long paramLong, boolean paramBoolean)
  {
    long l;
    if (this.optOut) {
      l = -1L;
    }
    for (;;)
    {
      return l;
      if (paramBoolean) {
        startNewSessionIfNeeded(paramLong);
      }
      setLastEventTime(paramLong);
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("event_type", replaceWithJSONNull(paramString));
        localJSONObject1.put("timestamp", paramLong);
        Object localObject;
        if (this.userId == null)
        {
          localObject = replaceWithJSONNull(this.deviceId);
          label83:
          localJSONObject1.put("user_id", localObject);
          localJSONObject1.put("device_id", replaceWithJSONNull(this.deviceId));
          localJSONObject1.put("session_id", this.sessionId);
          localJSONObject1.put("version_name", replaceWithJSONNull(this.versionName));
          localJSONObject1.put("os_name", replaceWithJSONNull(this.osName));
          localJSONObject1.put("os_version", replaceWithJSONNull(this.osVersion));
          localJSONObject1.put("device_brand", replaceWithJSONNull(this.brand));
          localJSONObject1.put("device_manufacturer", replaceWithJSONNull(this.manufacturer));
          localJSONObject1.put("device_model", replaceWithJSONNull(this.model));
          localJSONObject1.put("carrier", replaceWithJSONNull(this.carrier));
          localJSONObject1.put("country", replaceWithJSONNull(this.country));
          localJSONObject1.put("language", replaceWithJSONNull(this.language));
          localJSONObject1.put("platform", "Android");
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("name", "amplitude-android");
          localJSONObject2.put("version", "1.4.6");
          localJSONObject1.put("library", localJSONObject2);
          if (paramJSONObject2 == null) {
            paramJSONObject2 = new JSONObject();
          }
          Location localLocation = this.deviceInfo.getMostRecentLocation();
          if (localLocation != null)
          {
            JSONObject localJSONObject3 = new JSONObject();
            localJSONObject3.put("lat", localLocation.getLatitude());
            localJSONObject3.put("lng", localLocation.getLongitude());
            paramJSONObject2.put("location", localJSONObject3);
          }
          if (this.advertisingId != null) {
            paramJSONObject2.put("androidADID", this.advertisingId);
          }
          localJSONObject1.put("api_properties", paramJSONObject2);
          if (paramJSONObject1 == null) {
            paramJSONObject1 = new JSONObject();
          }
          localJSONObject1.put("event_properties", paramJSONObject1);
          if (this.userProperties != null) {
            break label508;
          }
        }
        label508:
        for (JSONObject localJSONObject4 = new JSONObject();; localJSONObject4 = this.userProperties)
        {
          localJSONObject1.put("user_properties", localJSONObject4);
          l = saveEvent(localJSONObject1);
          break;
          localObject = replaceWithJSONNull(this.userId);
          break label83;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.toString();
        }
      }
    }
  }
  
  /* Error */
  private void makeEventUploadPostRequest(String paramString1, String paramString2, long paramLong)
  {
    // Byte code:
    //   0: new 490	org/apache/http/client/methods/HttpPost
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 491	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: new 493	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 494	java/util/ArrayList:<init>	()V
    //   17: astore 6
    //   19: new 304	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 305	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 337
    //   29: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokestatic 499	java/lang/System:currentTimeMillis	()J
    //   35: invokevirtual 502	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore 7
    //   43: ldc_w 337
    //   46: astore 8
    //   48: new 304	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 305	java/lang/StringBuilder:<init>	()V
    //   55: ldc_w 504
    //   58: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: getfield 314	com/amplitude/api/Amplitude$Lib:apiKey	Ljava/lang/String;
    //   65: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_2
    //   69: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 7
    //   74: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore 41
    //   82: aload_0
    //   83: ldc_w 506
    //   86: invokestatic 512	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   89: aload 41
    //   91: ldc_w 514
    //   94: invokevirtual 518	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   97: invokevirtual 522	java/security/MessageDigest:digest	([B)[B
    //   100: invokespecial 524	com/amplitude/api/Amplitude$Lib:bytesToHexString	([B)Ljava/lang/String;
    //   103: astore 42
    //   105: aload 42
    //   107: astore 8
    //   109: aload 6
    //   111: new 526	org/apache/http/message/BasicNameValuePair
    //   114: dup
    //   115: ldc_w 528
    //   118: ldc_w 504
    //   121: invokespecial 531	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: invokeinterface 534 2 0
    //   129: pop
    //   130: aload 6
    //   132: new 526	org/apache/http/message/BasicNameValuePair
    //   135: dup
    //   136: ldc_w 536
    //   139: aload_0
    //   140: getfield 314	com/amplitude/api/Amplitude$Lib:apiKey	Ljava/lang/String;
    //   143: invokespecial 531	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: invokeinterface 534 2 0
    //   151: pop
    //   152: aload 6
    //   154: new 526	org/apache/http/message/BasicNameValuePair
    //   157: dup
    //   158: ldc_w 538
    //   161: aload_2
    //   162: invokespecial 531	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: invokeinterface 534 2 0
    //   170: pop
    //   171: aload 6
    //   173: new 526	org/apache/http/message/BasicNameValuePair
    //   176: dup
    //   177: ldc_w 540
    //   180: aload 7
    //   182: invokespecial 531	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: invokeinterface 534 2 0
    //   190: pop
    //   191: aload 6
    //   193: new 526	org/apache/http/message/BasicNameValuePair
    //   196: dup
    //   197: ldc_w 542
    //   200: aload 8
    //   202: invokespecial 531	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: invokeinterface 534 2 0
    //   210: pop
    //   211: aload 5
    //   213: new 544	org/apache/http/client/entity/UrlEncodedFormEntity
    //   216: dup
    //   217: aload 6
    //   219: ldc_w 514
    //   222: invokespecial 547	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   225: invokevirtual 551	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   228: new 553	org/apache/http/impl/client/DefaultHttpClient
    //   231: dup
    //   232: invokespecial 554	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   235: astore 18
    //   237: aload 18
    //   239: aload 5
    //   241: invokeinterface 560 2 0
    //   246: invokeinterface 566 1 0
    //   251: invokestatic 571	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   254: astore 30
    //   256: aload 30
    //   258: ldc_w 573
    //   261: invokevirtual 576	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   264: istore 31
    //   266: iload 31
    //   268: ifeq +91 -> 359
    //   271: iconst_1
    //   272: istore 21
    //   274: aload_0
    //   275: getfield 80	com/amplitude/api/Amplitude$Lib:logThread	Lcom/amplitude/api/WorkerThread;
    //   278: new 578	com/amplitude/api/Amplitude$Lib$10
    //   281: dup
    //   282: aload_0
    //   283: lload_3
    //   284: invokespecial 580	com/amplitude/api/Amplitude$Lib$10:<init>	(Lcom/amplitude/api/Amplitude$Lib;J)V
    //   287: invokevirtual 583	com/amplitude/api/WorkerThread:post	(Ljava/lang/Runnable;)V
    //   290: aload 18
    //   292: invokeinterface 587 1 0
    //   297: ifnull +15 -> 312
    //   300: aload 18
    //   302: invokeinterface 587 1 0
    //   307: invokeinterface 592 1 0
    //   312: iload 21
    //   314: ifne +11 -> 325
    //   317: aload_0
    //   318: getfield 72	com/amplitude/api/Amplitude$Lib:uploadingCurrently	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   321: iconst_0
    //   322: invokevirtual 595	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   325: return
    //   326: astore 39
    //   328: aload 39
    //   330: invokevirtual 596	java/security/NoSuchAlgorithmException:toString	()Ljava/lang/String;
    //   333: pop
    //   334: goto -225 -> 109
    //   337: astore 9
    //   339: aload 9
    //   341: invokevirtual 597	java/io/UnsupportedEncodingException:toString	()Ljava/lang/String;
    //   344: pop
    //   345: goto -236 -> 109
    //   348: astore 16
    //   350: aload 16
    //   352: invokevirtual 597	java/io/UnsupportedEncodingException:toString	()Ljava/lang/String;
    //   355: pop
    //   356: goto -128 -> 228
    //   359: aload 30
    //   361: ldc_w 599
    //   364: invokevirtual 576	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   367: ifeq +9 -> 376
    //   370: iconst_0
    //   371: istore 21
    //   373: goto -83 -> 290
    //   376: aload 30
    //   378: ldc_w 601
    //   381: invokevirtual 576	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   384: ifeq +9 -> 393
    //   387: iconst_0
    //   388: istore 21
    //   390: goto -100 -> 290
    //   393: aload 30
    //   395: ldc_w 603
    //   398: invokevirtual 576	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   401: ifeq +9 -> 410
    //   404: iconst_0
    //   405: istore 21
    //   407: goto -117 -> 290
    //   410: new 304	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 305	java/lang/StringBuilder:<init>	()V
    //   417: ldc_w 605
    //   420: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload 30
    //   425: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: ldc_w 607
    //   431: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: pop
    //   438: iconst_0
    //   439: istore 21
    //   441: goto -151 -> 290
    //   444: astore 29
    //   446: iconst_0
    //   447: istore 21
    //   449: aload 18
    //   451: invokeinterface 587 1 0
    //   456: ifnull -144 -> 312
    //   459: aload 18
    //   461: invokeinterface 587 1 0
    //   466: invokeinterface 592 1 0
    //   471: goto -159 -> 312
    //   474: astore 28
    //   476: iconst_0
    //   477: istore 21
    //   479: aload 18
    //   481: invokeinterface 587 1 0
    //   486: ifnull -174 -> 312
    //   489: aload 18
    //   491: invokeinterface 587 1 0
    //   496: invokeinterface 592 1 0
    //   501: goto -189 -> 312
    //   504: astore 26
    //   506: iconst_0
    //   507: istore 24
    //   509: aload 26
    //   511: invokevirtual 608	org/apache/http/client/ClientProtocolException:toString	()Ljava/lang/String;
    //   514: pop
    //   515: aload 18
    //   517: invokeinterface 587 1 0
    //   522: ifnull +195 -> 717
    //   525: aload 18
    //   527: invokeinterface 587 1 0
    //   532: invokeinterface 592 1 0
    //   537: iload 24
    //   539: istore 21
    //   541: goto -229 -> 312
    //   544: astore 23
    //   546: iconst_0
    //   547: istore 24
    //   549: aload 23
    //   551: invokevirtual 609	java/io/IOException:toString	()Ljava/lang/String;
    //   554: pop
    //   555: aload 18
    //   557: invokeinterface 587 1 0
    //   562: ifnull +155 -> 717
    //   565: aload 18
    //   567: invokeinterface 587 1 0
    //   572: invokeinterface 592 1 0
    //   577: iload 24
    //   579: istore 21
    //   581: goto -269 -> 312
    //   584: astore 22
    //   586: iconst_0
    //   587: istore 21
    //   589: aload 18
    //   591: invokeinterface 587 1 0
    //   596: ifnull -284 -> 312
    //   599: aload 18
    //   601: invokeinterface 587 1 0
    //   606: invokeinterface 592 1 0
    //   611: goto -299 -> 312
    //   614: astore 20
    //   616: iconst_0
    //   617: istore 21
    //   619: aload 18
    //   621: invokeinterface 587 1 0
    //   626: ifnull -314 -> 312
    //   629: aload 18
    //   631: invokeinterface 587 1 0
    //   636: invokeinterface 592 1 0
    //   641: goto -329 -> 312
    //   644: astore 19
    //   646: aload 18
    //   648: invokeinterface 587 1 0
    //   653: ifnull +15 -> 668
    //   656: aload 18
    //   658: invokeinterface 587 1 0
    //   663: invokeinterface 592 1 0
    //   668: aload 19
    //   670: athrow
    //   671: astore 38
    //   673: goto -54 -> 619
    //   676: astore 37
    //   678: goto -89 -> 589
    //   681: astore 36
    //   683: iload 21
    //   685: istore 24
    //   687: aload 36
    //   689: astore 23
    //   691: goto -142 -> 549
    //   694: astore 35
    //   696: iload 21
    //   698: istore 24
    //   700: aload 35
    //   702: astore 26
    //   704: goto -195 -> 509
    //   707: astore 34
    //   709: goto -230 -> 479
    //   712: astore 33
    //   714: goto -265 -> 449
    //   717: iload 24
    //   719: istore 21
    //   721: goto -409 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	724	0	this	Lib
    //   0	724	1	paramString1	String
    //   0	724	2	paramString2	String
    //   0	724	3	paramLong	long
    //   8	232	5	localHttpPost	org.apache.http.client.methods.HttpPost
    //   17	201	6	localArrayList	java.util.ArrayList
    //   41	140	7	str1	String
    //   46	155	8	localObject1	Object
    //   337	3	9	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   348	3	16	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   235	422	18	localDefaultHttpClient	org.apache.http.impl.client.DefaultHttpClient
    //   644	25	19	localObject2	Object
    //   614	1	20	localException1	java.lang.Exception
    //   272	448	21	i	int
    //   584	1	22	localAssertionError1	java.lang.AssertionError
    //   544	6	23	localIOException1	java.io.IOException
    //   689	1	23	localObject3	Object
    //   507	211	24	j	int
    //   504	6	26	localClientProtocolException1	org.apache.http.client.ClientProtocolException
    //   702	1	26	localObject4	Object
    //   474	1	28	localUnknownHostException1	java.net.UnknownHostException
    //   444	1	29	localHttpHostConnectException1	org.apache.http.conn.HttpHostConnectException
    //   254	170	30	str2	String
    //   264	3	31	bool	boolean
    //   712	1	33	localHttpHostConnectException2	org.apache.http.conn.HttpHostConnectException
    //   707	1	34	localUnknownHostException2	java.net.UnknownHostException
    //   694	7	35	localClientProtocolException2	org.apache.http.client.ClientProtocolException
    //   681	7	36	localIOException2	java.io.IOException
    //   676	1	37	localAssertionError2	java.lang.AssertionError
    //   671	1	38	localException2	java.lang.Exception
    //   326	3	39	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   80	10	41	str3	String
    //   103	3	42	str4	String
    // Exception table:
    //   from	to	target	type
    //   48	105	326	java/security/NoSuchAlgorithmException
    //   48	105	337	java/io/UnsupportedEncodingException
    //   211	228	348	java/io/UnsupportedEncodingException
    //   237	266	444	org/apache/http/conn/HttpHostConnectException
    //   359	438	444	org/apache/http/conn/HttpHostConnectException
    //   237	266	474	java/net/UnknownHostException
    //   359	438	474	java/net/UnknownHostException
    //   237	266	504	org/apache/http/client/ClientProtocolException
    //   359	438	504	org/apache/http/client/ClientProtocolException
    //   237	266	544	java/io/IOException
    //   359	438	544	java/io/IOException
    //   237	266	584	java/lang/AssertionError
    //   359	438	584	java/lang/AssertionError
    //   237	266	614	java/lang/Exception
    //   359	438	614	java/lang/Exception
    //   237	266	644	finally
    //   274	290	644	finally
    //   359	438	644	finally
    //   509	515	644	finally
    //   549	555	644	finally
    //   274	290	671	java/lang/Exception
    //   274	290	676	java/lang/AssertionError
    //   274	290	681	java/io/IOException
    //   274	290	694	org/apache/http/client/ClientProtocolException
    //   274	290	707	java/net/UnknownHostException
    //   274	290	712	org/apache/http/conn/HttpHostConnectException
  }
  
  private void openSession()
  {
    clearEndSession();
    this.sessionOpen = true;
  }
  
  private Object replaceWithJSONNull(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = JSONObject.NULL;
    }
    return paramObject;
  }
  
  private void runOnLogThread(Runnable paramRunnable)
  {
    if (Thread.currentThread() != this.logThread) {
      this.logThread.post(paramRunnable);
    }
    for (;;)
    {
      return;
      paramRunnable.run();
    }
  }
  
  private long saveEvent(JSONObject paramJSONObject)
  {
    DatabaseHelper localDatabaseHelper = DatabaseHelper.getDatabaseHelper(this.context);
    long l = localDatabaseHelper.addEvent(paramJSONObject.toString());
    if (localDatabaseHelper.getEventCount() >= 1000L) {
      localDatabaseHelper.removeEvents(localDatabaseHelper.getNthEventId(20L));
    }
    if (localDatabaseHelper.getEventCount() >= 30L) {
      updateServer();
    }
    for (;;)
    {
      return l;
      updateServerLater(30000L);
    }
  }
  
  private void setLastEventTime(long paramLong)
  {
    this.context.getSharedPreferences(getSharedPreferencesName(), 0).edit().putLong(Constants.PREFKEY_PREVIOUS_SESSION_TIME, paramLong).commit();
  }
  
  private void startNewSession(long paramLong)
  {
    openSession();
    this.sessionId = paramLong;
    this.context.getSharedPreferences(getSharedPreferencesName(), 0).edit().putLong(Constants.PREFKEY_PREVIOUS_SESSION_ID, this.sessionId).commit();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("special", "session_start");
      label65:
      logEvent("session_start", null, localJSONObject, paramLong, false);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label65;
    }
  }
  
  private void startNewSessionIfNeeded(long paramLong)
  {
    long l;
    if (!this.sessionOpen) {
      if (paramLong - getEndSessionTime() < 15000L)
      {
        l = this.context.getSharedPreferences(getSharedPreferencesName(), 0).getLong(Constants.PREFKEY_PREVIOUS_SESSION_ID, -1L);
        if (l == -1L) {
          startNewSession(paramLong);
        }
      }
    }
    for (;;)
    {
      return;
      this.sessionId = l;
      continue;
      startNewSession(paramLong);
      continue;
      if ((paramLong - getLastEventTime() > this.sessionTimeoutMillis) || (this.sessionId == -1L)) {
        startNewSession(paramLong);
      }
    }
  }
  
  private void updateServer()
  {
    updateServer(true);
  }
  
  private void updateServer(boolean paramBoolean)
  {
    if (this.optOut) {
      return;
    }
    DatabaseHelper localDatabaseHelper;
    if (!this.uploadingCurrently.getAndSet(true)) {
      localDatabaseHelper = DatabaseHelper.getDatabaseHelper(this.context);
    }
    for (;;)
    {
      try
      {
        long l1 = getEndSessionId();
        if (!paramBoolean) {
          break label113;
        }
        i = 100;
        Pair localPair = localDatabaseHelper.getEvents(l1, i);
        long l2 = ((Long)localPair.first).longValue();
        JSONArray localJSONArray = (JSONArray)localPair.second;
        this.httpThread.post(new Amplitude.Lib.9(this, localJSONArray, l2));
      }
      catch (JSONException localJSONException)
      {
        this.uploadingCurrently.set(false);
        localJSONException.toString();
      }
      break;
      break;
      label113:
      int i = -1;
    }
  }
  
  private void updateServerLater(long paramLong)
  {
    if (!this.updateScheduled.getAndSet(true)) {
      this.logThread.postDelayed(new Amplitude.Lib.4(this), paramLong);
    }
  }
  
  public void disableLocationListening()
  {
    if (this.deviceInfo == null) {
      throw new IllegalStateException("Must initialize before acting on location listening.");
    }
    this.deviceInfo.setLocationListening(false);
  }
  
  public void enableLocationListening()
  {
    if (this.deviceInfo == null) {
      throw new IllegalStateException("Must initialize before acting on location listening.");
    }
    this.deviceInfo.setLocationListening(true);
  }
  
  public void enableNewDeviceIdPerInstall(boolean paramBoolean)
  {
    this.newDeviceIdPerInstall = paramBoolean;
  }
  
  public void endSession()
  {
    if (!contextAndApiKeySet("endSession()")) {}
    for (;;)
    {
      return;
      runOnLogThread(new Amplitude.Lib.6(this, System.currentTimeMillis()));
      this.logThread.removeCallbacks(this.endSessionRunnable);
      this.endSessionRunnable = new Amplitude.Lib.7(this);
      this.logThread.postDelayed(this.endSessionRunnable, 16000L);
    }
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public void initialize(Context paramContext, String paramString)
  {
    initialize(paramContext, paramString, null);
  }
  
  public void initialize(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return;
    }
    for (;;)
    {
      SharedPreferences localSharedPreferences;
      try
      {
        if ((TextUtils.isEmpty(paramString1)) || (this.initialized)) {
          break;
        }
        this.context = paramContext.getApplicationContext();
        this.apiKey = paramString1;
        initializeDeviceInfo();
        localSharedPreferences = paramContext.getSharedPreferences(getSharedPreferencesName(), 0);
        if (paramString2 != null)
        {
          this.userId = paramString2;
          localSharedPreferences.edit().putString(Constants.PREFKEY_USER_ID, paramString2).commit();
          this.optOut = localSharedPreferences.getBoolean(Constants.PREFKEY_OPT_OUT, false);
          this.initialized = true;
          break;
        }
      }
      finally {}
      this.userId = localSharedPreferences.getString(Constants.PREFKEY_USER_ID, null);
    }
  }
  
  public void logEvent(String paramString)
  {
    logEvent(paramString, null);
  }
  
  public void logEvent(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    for (JSONObject localJSONObject = cloneJSONObject(paramJSONObject);; localJSONObject = paramJSONObject)
    {
      checkedLogEvent(paramString, localJSONObject, null, System.currentTimeMillis(), true);
      return;
    }
  }
  
  public void logRevenue(double paramDouble)
  {
    logRevenue(null, 1, paramDouble);
  }
  
  public void logRevenue(String paramString, int paramInt, double paramDouble)
  {
    logRevenue(paramString, paramInt, paramDouble, null, null);
  }
  
  public void logRevenue(String paramString1, int paramInt, double paramDouble, String paramString2, String paramString3)
  {
    if (!contextAndApiKeySet("logRevenue()")) {}
    for (;;)
    {
      return;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("special", "revenue_amount");
        localJSONObject.put("productId", paramString1);
        localJSONObject.put("quantity", paramInt);
        localJSONObject.put("price", paramDouble);
        localJSONObject.put("receipt", paramString2);
        localJSONObject.put("receiptSig", paramString3);
        label84:
        checkedLogEvent("revenue_amount", null, localJSONObject, System.currentTimeMillis(), true);
      }
      catch (JSONException localJSONException)
      {
        break label84;
      }
    }
  }
  
  public void setOptOut(boolean paramBoolean)
  {
    this.optOut = paramBoolean;
    this.context.getSharedPreferences(getSharedPreferencesName(), 0).edit().putBoolean(Constants.PREFKEY_OPT_OUT, paramBoolean).commit();
  }
  
  public void setSessionTimeoutMillis(long paramLong)
  {
    this.sessionTimeoutMillis = paramLong;
  }
  
  public void setUserId(String paramString)
  {
    if (!contextAndApiKeySet("setUserId()")) {}
    for (;;)
    {
      return;
      this.userId = paramString;
      this.context.getSharedPreferences(getSharedPreferencesName(), 0).edit().putString(Constants.PREFKEY_USER_ID, paramString).commit();
    }
  }
  
  public void setUserProperties(JSONObject paramJSONObject)
  {
    setUserProperties(paramJSONObject, false);
  }
  
  public void setUserProperties(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.userProperties == null)) {
      this.userProperties = paramJSONObject;
    }
    for (;;)
    {
      return;
      if (paramJSONObject != null) {
        runOnLogThread(new Amplitude.Lib.8(this, paramJSONObject, this.userProperties));
      }
    }
  }
  
  public void startSession()
  {
    if (!contextAndApiKeySet("startSession()")) {}
    for (;;)
    {
      return;
      runOnLogThread(new Amplitude.Lib.5(this, System.currentTimeMillis()));
    }
  }
  
  public void uploadEvents()
  {
    if (!contextAndApiKeySet("uploadEvents()")) {}
    for (;;)
    {
      return;
      this.logThread.post(new Amplitude.Lib.3(this));
    }
  }
  
  public void useAdvertisingIdForDeviceId()
  {
    this.useAdvertisingIdForDeviceId = true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.amplitude.api.Amplitude.Lib
 * JD-Core Version:    0.7.0.1
 */