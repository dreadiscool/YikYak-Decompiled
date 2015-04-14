package com.parse;

import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import com.parse.codec.digest.DigestUtils;
import com.parse.signpost.OAuthConsumer;
import com.parse.signpost.commonshttp.CommonsHttpOAuthConsumer;
import com.parse.signpost.exception.OAuthCommunicationException;
import com.parse.signpost.exception.OAuthExpectationFailedException;
import com.parse.signpost.exception.OAuthMessageSignerException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;
import m;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

class ParseCommand
  extends ParseRequest<JSONObject, Object>
{
  private static final String APP_BUILD_VERSION = "appBuildVersion";
  private static final String APP_DISPLAY_VERSION = "appDisplayVersion";
  private static final String COMMAND_UUID = "uuid";
  private static final String DEVICE_TYPE_AND_SDK_VERSION = "v";
  private static final String INSTALLATION_ID = "iid";
  private static final String OS_VERSION = "osVersion";
  private static final String SESSION_TOKEN = "session_token";
  private String localId;
  private String op;
  private String operationSetUUID;
  JSONObject params;
  private final String sessionToken;
  
  ParseCommand(String paramString1, String paramString2)
  {
    this(paramString1, new JSONObject(), null, null, paramString2);
  }
  
  private ParseCommand(String paramString1, JSONObject paramJSONObject, String paramString2, String paramString3, String paramString4)
  {
    super(1, generateUrl(paramString1));
    this.op = paramString1;
    this.params = paramJSONObject;
    this.localId = paramString2;
    this.operationSetUUID = paramString3;
    this.sessionToken = paramString4;
    this.maxRetries = 0;
  }
  
  ParseCommand(JSONObject paramJSONObject) {}
  
  static void addDefaultParameters(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject.put("osVersion", Build.VERSION.RELEASE);
    paramJSONObject.put("appBuildVersion", Integer.toString(ManifestInfo.getVersionCode()));
    paramJSONObject.put("appDisplayVersion", ManifestInfo.getVersionName());
    paramJSONObject.put("v", "a1.7.1");
    paramJSONObject.put("iid", ParseInstallation.getOrCreateCurrentInstallationId());
    paramJSONObject.put("uuid", UUID.randomUUID().toString());
    if (paramString != null) {
      paramJSONObject.put("session_token", paramString);
    }
  }
  
  static void addToStringer(JSONStringer paramJSONStringer, Object paramObject)
  {
    if ((paramObject instanceof JSONObject))
    {
      paramJSONStringer.object();
      JSONObject localJSONObject = (JSONObject)paramObject;
      Iterator localIterator1 = localJSONObject.keys();
      ArrayList localArrayList = new ArrayList();
      while (localIterator1.hasNext()) {
        localArrayList.add(localIterator1.next());
      }
      Collections.sort(localArrayList);
      Iterator localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        paramJSONStringer.key(str);
        addToStringer(paramJSONStringer, localJSONObject.opt(str));
      }
      paramJSONStringer.endObject();
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof JSONArray))
      {
        JSONArray localJSONArray = (JSONArray)paramObject;
        paramJSONStringer.array();
        for (int i = 0; i < localJSONArray.length(); i++) {
          addToStringer(paramJSONStringer, localJSONArray.get(i));
        }
        paramJSONStringer.endArray();
      }
      else
      {
        paramJSONStringer.value(paramObject);
      }
    }
  }
  
  private static String generateUrl(String paramString)
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = ParseObject.server;
    arrayOfObject[1] = "2";
    arrayOfObject[2] = paramString;
    return String.format("%s/%s/%s", arrayOfObject);
  }
  
  private static void getLocalPointersIn(Object paramObject, ArrayList<JSONObject> paramArrayList)
  {
    JSONObject localJSONObject;
    if ((paramObject instanceof JSONObject))
    {
      localJSONObject = (JSONObject)paramObject;
      if (("Pointer".equals(localJSONObject.opt("__type"))) && (localJSONObject.has("localId"))) {
        paramArrayList.add((JSONObject)paramObject);
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext()) {
        getLocalPointersIn(localJSONObject.get((String)localIterator.next()), paramArrayList);
      }
      if ((paramObject instanceof JSONArray))
      {
        JSONArray localJSONArray = (JSONArray)paramObject;
        for (int i = 0; i < localJSONArray.length(); i++) {
          getLocalPointersIn(localJSONArray.get(i), paramArrayList);
        }
      }
    }
  }
  
  static String toDeterministicString(Object paramObject)
  {
    JSONStringer localJSONStringer = new JSONStringer();
    addToStringer(localJSONStringer, paramObject);
    return localJSONStringer.toString();
  }
  
  void enableRetrying()
  {
    this.maxRetries = 4;
  }
  
  String getCacheKey()
  {
    try
    {
      String str1 = toDeterministicString(this.params);
      String str2 = str1;
      if (this.sessionToken != null) {
        str2 = str2 + this.sessionToken;
      }
      return "ParseCommand." + this.op + "." + "2" + "." + DigestUtils.md5Hex(str2);
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException.getMessage());
    }
  }
  
  String getLocalId()
  {
    return this.localId;
  }
  
  String getOp()
  {
    return this.op;
  }
  
  String getOperationSetUUID()
  {
    return this.operationSetUUID;
  }
  
  String getSessionToken()
  {
    return this.sessionToken;
  }
  
  public void maybeChangeServerOperation()
  {
    if (this.localId != null)
    {
      String str = LocalIdManager.getDefaultInstance().getObjectId(this.localId);
      if (str != null)
      {
        this.localId = null;
        JSONObject localJSONObject = this.params.optJSONObject("data");
        if (localJSONObject != null) {
          localJSONObject.put("objectId", str);
        }
        if (this.op.equals("create")) {
          setOp("update");
        }
      }
    }
  }
  
  protected HttpEntity newEntity()
  {
    Iterator localIterator = this.params.keys();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, this.params.get(str));
      }
      addDefaultParameters(localJSONObject, this.sessionToken);
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException.getMessage());
    }
    try
    {
      StringEntity localStringEntity = new StringEntity(localJSONObject.toString(), "UTF8");
      localStringEntity.setContentType("application/json");
      return localStringEntity;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException(localUnsupportedEncodingException.getMessage());
    }
  }
  
  protected HttpUriRequest newRequest()
  {
    HttpUriRequest localHttpUriRequest = super.newRequest();
    try
    {
      CommonsHttpOAuthConsumer localCommonsHttpOAuthConsumer = new CommonsHttpOAuthConsumer(Parse.applicationId, Parse.clientKey);
      localCommonsHttpOAuthConsumer.setTokenWithSecret(null, "");
      localCommonsHttpOAuthConsumer.sign(localHttpUriRequest);
      return localHttpUriRequest;
    }
    catch (OAuthMessageSignerException localOAuthMessageSignerException)
    {
      throw new ParseException(109, localOAuthMessageSignerException.getMessage());
    }
    catch (OAuthExpectationFailedException localOAuthExpectationFailedException)
    {
      throw new ParseException(109, localOAuthExpectationFailedException.getMessage());
    }
    catch (OAuthCommunicationException localOAuthCommunicationException)
    {
      throw new ParseException(109, localOAuthCommunicationException.getMessage());
    }
  }
  
  protected m<Object> onPostExecute(m<JSONObject> paramm)
  {
    JSONObject localJSONObject = (JSONObject)paramm.e();
    m localm;
    try
    {
      if (localJSONObject.has("error"))
      {
        localm = m.a(new ParseException(localJSONObject.getInt("code"), localJSONObject.getString("error")));
      }
      else
      {
        Object localObject = localJSONObject.get("result");
        localm = m.a(localObject);
      }
    }
    catch (JSONException localJSONException)
    {
      localm = m.a(connectionFailed("corrupted json", localJSONException));
    }
    return localm;
  }
  
  protected m<Void> onPreExecute(m<Void> paramm)
  {
    Parse.checkInit();
    resolveLocalIds();
    return paramm;
  }
  
  protected JSONObject onResponse(HttpResponse paramHttpResponse, ProgressCallback paramProgressCallback)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(new JSONTokener(new String(ParseIOUtils.toByteArray(AndroidHttpClient.getUngzippedContent(paramHttpResponse.getEntity())))));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw connectionFailed("bad json response", localJSONException);
    }
  }
  
  void put(String paramString, int paramInt)
  {
    try
    {
      this.params.put(paramString, paramInt);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException.getMessage());
    }
  }
  
  void put(String paramString, long paramLong)
  {
    try
    {
      this.params.put(paramString, paramLong);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException.getMessage());
    }
  }
  
  void put(String paramString1, String paramString2)
  {
    try
    {
      this.params.put(paramString1, paramString2);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException.getMessage());
    }
  }
  
  void put(String paramString, JSONArray paramJSONArray)
  {
    try
    {
      this.params.put(paramString, paramJSONArray);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException.getMessage());
    }
  }
  
  void put(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      this.params.put(paramString, paramJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException.getMessage());
    }
  }
  
  public void releaseLocalIds()
  {
    if (this.localId != null) {
      LocalIdManager.getDefaultInstance().releaseLocalIdOnDisk(this.localId);
    }
    try
    {
      Object localObject = this.params.get("data");
      ArrayList localArrayList = new ArrayList();
      getLocalPointersIn(localObject, localArrayList);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)((JSONObject)localIterator.next()).get("localId");
        LocalIdManager.getDefaultInstance().releaseLocalIdOnDisk(str);
      }
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public void resolveLocalIds()
  {
    try
    {
      Object localObject = this.params.get("data");
      ArrayList localArrayList = new ArrayList();
      getLocalPointersIn(localObject, localArrayList);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        JSONObject localJSONObject = (JSONObject)localIterator.next();
        String str1 = (String)localJSONObject.get("localId");
        String str2 = LocalIdManager.getDefaultInstance().getObjectId(str1);
        if (str2 == null) {
          throw new IllegalStateException("Tried to serialize a command referencing a new, unsaved object.");
        }
        localJSONObject.put("objectId", str2);
        localJSONObject.remove("localId");
      }
      maybeChangeServerOperation();
    }
    catch (JSONException localJSONException) {}
  }
  
  public void retainLocalIds()
  {
    if (this.localId != null) {
      LocalIdManager.getDefaultInstance().retainLocalIdOnDisk(this.localId);
    }
    try
    {
      Object localObject = this.params.get("data");
      ArrayList localArrayList = new ArrayList();
      getLocalPointersIn(localObject, localArrayList);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)((JSONObject)localIterator.next()).get("localId");
        LocalIdManager.getDefaultInstance().retainLocalIdOnDisk(str);
      }
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  void setLocalId(String paramString)
  {
    this.localId = paramString;
  }
  
  void setOp(String paramString)
  {
    this.op = paramString;
    setUrl(generateUrl(paramString));
  }
  
  void setOperationSetUUID(String paramString)
  {
    this.operationSetUUID = paramString;
  }
  
  /* Error */
  JSONObject toJSONObject()
  {
    // Byte code:
    //   0: new 37	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 40	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 66
    //   11: aload_0
    //   12: getfield 52	com/parse/ParseCommand:op	Ljava/lang/String;
    //   15: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   18: pop
    //   19: aload_1
    //   20: ldc 70
    //   22: aload_0
    //   23: getfield 54	com/parse/ParseCommand:params	Lorg/json/JSONObject;
    //   26: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_0
    //   31: getfield 56	com/parse/ParseCommand:localId	Ljava/lang/String;
    //   34: ifnull +14 -> 48
    //   37: aload_1
    //   38: ldc 75
    //   40: aload_0
    //   41: getfield 56	com/parse/ParseCommand:localId	Ljava/lang/String;
    //   44: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   47: pop
    //   48: aload_0
    //   49: getfield 58	com/parse/ParseCommand:operationSetUUID	Ljava/lang/String;
    //   52: ifnull +14 -> 66
    //   55: aload_1
    //   56: ldc 80
    //   58: aload_0
    //   59: getfield 58	com/parse/ParseCommand:operationSetUUID	Ljava/lang/String;
    //   62: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   65: pop
    //   66: aload_0
    //   67: getfield 60	com/parse/ParseCommand:sessionToken	Ljava/lang/String;
    //   70: ifnull +20 -> 90
    //   73: aload_0
    //   74: getfield 60	com/parse/ParseCommand:sessionToken	Ljava/lang/String;
    //   77: astore 5
    //   79: aload_1
    //   80: ldc 27
    //   82: aload 5
    //   84: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   87: pop
    //   88: aload_1
    //   89: areturn
    //   90: getstatic 460	org/json/JSONObject:NULL	Ljava/lang/Object;
    //   93: astore 5
    //   95: goto -16 -> 79
    //   98: astore_2
    //   99: new 260	java/lang/RuntimeException
    //   102: dup
    //   103: aload_2
    //   104: invokevirtual 263	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   107: invokespecial 266	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	ParseCommand
    //   7	82	1	localJSONObject	JSONObject
    //   98	6	2	localJSONException	JSONException
    //   77	17	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	95	98	org/json/JSONException
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseCommand
 * JD-Core Version:    0.7.0.1
 */