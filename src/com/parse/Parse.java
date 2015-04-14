package com.parse;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.parse.codec.binary.Base64;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import y;

public class Parse
{
  public static final int LOG_LEVEL_DEBUG = 3;
  public static final int LOG_LEVEL_ERROR = 6;
  public static final int LOG_LEVEL_INFO = 4;
  public static final int LOG_LEVEL_NONE = 2147483647;
  public static final int LOG_LEVEL_VERBOSE = 2;
  public static final int LOG_LEVEL_WARNING = 5;
  private static final Object SCHEDULED_EXECUTOR_LOCK = new Object();
  private static final String TAG = "com.parse.Parse";
  static Context applicationContext;
  static String applicationId;
  static String clientKey;
  private static final DateFormat dateFormat;
  static ParseEventuallyQueue eventuallyQueue;
  static final Object lock;
  private static int logLevel = 6;
  static int maxKeyValueCacheBytes;
  static int maxKeyValueCacheFiles;
  static int maxParseFileSize = 10485760;
  private static ScheduledExecutorService scheduledExecutor;
  
  static
  {
    maxKeyValueCacheBytes = 2097152;
    maxKeyValueCacheFiles = 1000;
    eventuallyQueue = null;
    lock = new Object();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    dateFormat = localSimpleDateFormat;
  }
  
  private Parse()
  {
    throw new AssertionError();
  }
  
  static Number addNumbers(Number paramNumber1, Number paramNumber2)
  {
    Object localObject;
    if (((paramNumber1 instanceof Double)) || ((paramNumber2 instanceof Double))) {
      localObject = Double.valueOf(paramNumber1.doubleValue() + paramNumber2.doubleValue());
    }
    for (;;)
    {
      return localObject;
      if (((paramNumber1 instanceof Float)) || ((paramNumber2 instanceof Float)))
      {
        localObject = Float.valueOf(paramNumber1.floatValue() + paramNumber2.floatValue());
      }
      else if (((paramNumber1 instanceof Long)) || ((paramNumber2 instanceof Long)))
      {
        localObject = Long.valueOf(paramNumber1.longValue() + paramNumber2.longValue());
      }
      else if (((paramNumber1 instanceof Integer)) || ((paramNumber2 instanceof Integer)))
      {
        localObject = Integer.valueOf(paramNumber1.intValue() + paramNumber2.intValue());
      }
      else if (((paramNumber1 instanceof Short)) || ((paramNumber2 instanceof Short)))
      {
        localObject = Integer.valueOf(paramNumber1.shortValue() + paramNumber2.shortValue());
      }
      else
      {
        if ((!(paramNumber1 instanceof Byte)) && (!(paramNumber2 instanceof Byte))) {
          break;
        }
        localObject = Integer.valueOf(paramNumber1.byteValue() + paramNumber2.byteValue());
      }
    }
    throw new RuntimeException("Unknown number type.");
  }
  
  private static boolean allParsePushIntentReceiversInternal()
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "com.parse.push.intent.RECEIVE";
    arrayOfString[1] = "com.parse.push.intent.DELETE";
    arrayOfString[2] = "com.parse.push.intent.OPEN";
    Iterator localIterator = ManifestInfo.getIntentReceivers(arrayOfString).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((ResolveInfo)localIterator.next()).activityInfo.exported);
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  static <T> m<T> callbackOnMainThreadAsync(m<T> paramm, ParseCallback<T> paramParseCallback)
  {
    return callbackOnMainThreadAsync(paramm, paramParseCallback, false);
  }
  
  static <T> m<T> callbackOnMainThreadAsync(m<T> paramm, ParseCallback<T> paramParseCallback, boolean paramBoolean)
  {
    if (paramParseCallback == null) {}
    for (;;)
    {
      return paramm;
      y localy = m.a();
      paramm.a(new Parse.6(paramBoolean, localy, paramParseCallback));
      paramm = localy.a();
    }
  }
  
  static void checkCacheApplicationId()
  {
    synchronized (lock)
    {
      File localFile1;
      int i;
      if (applicationId != null)
      {
        localFile1 = new File(getParseDir(), "applicationId");
        boolean bool1 = localFile1.exists();
        if (bool1) {
          i = 0;
        }
      }
      try
      {
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile1, "r");
        byte[] arrayOfByte = new byte[(int)localRandomAccessFile.length()];
        localRandomAccessFile.readFully(arrayOfByte);
        localRandomAccessFile.close();
        boolean bool2 = new String(arrayOfByte, "UTF-8").equals(applicationId);
        i = bool2;
      }
      catch (IOException localIOException2)
      {
        File localFile2;
        break label95;
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        label95:
        break label95;
      }
      if (i == 0) {
        recursiveDelete(getParseDir());
      }
      localFile2 = new File(getParseDir(), "applicationId");
    }
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile2);
      localFileOutputStream.write(applicationId.getBytes("UTF-8"));
      localFileOutputStream.close();
      label150:
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (IOException localIOException1)
    {
      break label150;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label150;
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      break label150;
    }
  }
  
  static void checkContext()
  {
    if (applicationContext == null) {
      throw new RuntimeException("applicationContext is null. You must call Parse.initialize(context, applicationId, clientKey) before using the Parse library.");
    }
  }
  
  static void checkInit()
  {
    if (applicationId == null) {
      throw new RuntimeException("applicationId is null. You must call Parse.initialize(context, applicationId, clientKey) before using the Parse library.");
    }
    if (clientKey == null) {
      throw new RuntimeException("clientKey is null. You must call Parse.initialize(context, applicationId, clientKey) before using the Parse library.");
    }
  }
  
  static void clearCacheDir()
  {
    File[] arrayOfFile = getKeyValueCacheDir().listFiles();
    if (arrayOfFile == null) {}
    for (;;)
    {
      return;
      for (int i = 0; i < arrayOfFile.length; i++) {
        arrayOfFile[i].delete();
      }
    }
  }
  
  static void clearFromKeyValueCache(String paramString)
  {
    File localFile = getKeyValueCacheFile(paramString);
    if (localFile != null) {
      localFile.delete();
    }
  }
  
  static int compareNumbers(Number paramNumber1, Number paramNumber2)
  {
    int i;
    if (((paramNumber1 instanceof Double)) || ((paramNumber2 instanceof Double))) {
      i = (int)Math.signum(paramNumber1.doubleValue() - paramNumber2.doubleValue());
    }
    for (;;)
    {
      return i;
      if (((paramNumber1 instanceof Float)) || ((paramNumber2 instanceof Float)))
      {
        i = (int)Math.signum(paramNumber1.floatValue() - paramNumber2.floatValue());
      }
      else if (((paramNumber1 instanceof Long)) || ((paramNumber2 instanceof Long)))
      {
        long l = paramNumber1.longValue() - paramNumber2.longValue();
        if (l < 0L) {
          i = -1;
        } else if (l > 0L) {
          i = 1;
        } else {
          i = 0;
        }
      }
      else if (((paramNumber1 instanceof Integer)) || ((paramNumber2 instanceof Integer)))
      {
        i = paramNumber1.intValue() - paramNumber2.intValue();
      }
      else if (((paramNumber1 instanceof Short)) || ((paramNumber2 instanceof Short)))
      {
        i = paramNumber1.shortValue() - paramNumber2.shortValue();
      }
      else
      {
        if ((!(paramNumber1 instanceof Byte)) && (!(paramNumber2 instanceof Byte))) {
          break;
        }
        i = paramNumber1.byteValue() - paramNumber2.byteValue();
      }
    }
    throw new RuntimeException("Unknown number type.");
  }
  
  static File createKeyValueCacheFile(String paramString)
  {
    String str = String.valueOf(new Date().getTime()) + '.' + paramString;
    return new File(getKeyValueCacheDir(), str);
  }
  
  static String dateToString(Date paramDate)
  {
    synchronized (lock)
    {
      String str = dateFormat.format(paramDate);
      return str;
    }
  }
  
  static void deleteDiskObject(Context paramContext, String paramString)
  {
    try
    {
      setContextIfNeeded(paramContext);
      ParseFileUtils.deleteQuietly(new File(getParseDir(), paramString));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void enableLocalDatastore(Context paramContext)
  {
    OfflineStore.enableOfflineStore(paramContext);
  }
  
  static Object encode(Object paramObject, ParseObjectEncodingStrategy paramParseObjectEncodingStrategy)
  {
    try
    {
      if ((paramObject instanceof ParseObject))
      {
        paramObject = paramParseObjectEncodingStrategy.encodeRelatedObject((ParseObject)paramObject);
      }
      else if ((paramObject instanceof ParseQuery))
      {
        paramObject = ((ParseQuery)paramObject).toREST();
      }
      else if ((paramObject instanceof Date))
      {
        paramObject = encodeDate((Date)paramObject);
      }
      else if ((paramObject instanceof byte[]))
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("__type", "Bytes");
        localJSONObject1.put("base64", Base64.encodeBase64String((byte[])paramObject));
        paramObject = localJSONObject1;
      }
      else if ((paramObject instanceof ParseFile))
      {
        paramObject = ((ParseFile)paramObject).encode();
      }
      else if ((paramObject instanceof ParseGeoPoint))
      {
        ParseGeoPoint localParseGeoPoint = (ParseGeoPoint)paramObject;
        JSONObject localJSONObject5 = new JSONObject();
        localJSONObject5.put("__type", "GeoPoint");
        localJSONObject5.put("latitude", localParseGeoPoint.getLatitude());
        localJSONObject5.put("longitude", localParseGeoPoint.getLongitude());
        paramObject = localJSONObject5;
      }
      else if ((paramObject instanceof ParseACL))
      {
        paramObject = ((ParseACL)paramObject).toJSONObject(paramParseObjectEncodingStrategy);
      }
      else if ((paramObject instanceof Map))
      {
        Map localMap = (Map)paramObject;
        JSONObject localJSONObject4 = new JSONObject();
        Iterator localIterator3 = localMap.entrySet().iterator();
        while (localIterator3.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator3.next();
          localJSONObject4.put((String)localEntry.getKey(), encode(localEntry.getValue(), paramParseObjectEncodingStrategy));
        }
        paramObject = localJSONObject4;
      }
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
    break label614;
    JSONObject localJSONObject3;
    if ((paramObject instanceof JSONObject))
    {
      JSONObject localJSONObject2 = (JSONObject)paramObject;
      localJSONObject3 = new JSONObject();
      Iterator localIterator2 = localJSONObject2.keys();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        localJSONObject3.put(str, encode(localJSONObject2.opt(str), paramParseObjectEncodingStrategy));
      }
    }
    JSONArray localJSONArray1;
    if ((paramObject instanceof List))
    {
      localJSONArray1 = new JSONArray();
      Iterator localIterator1 = ((List)paramObject).iterator();
      while (localIterator1.hasNext()) {
        localJSONArray1.put(encode(localIterator1.next(), paramParseObjectEncodingStrategy));
      }
    }
    JSONArray localJSONArray3;
    if ((paramObject instanceof JSONArray))
    {
      JSONArray localJSONArray2 = (JSONArray)paramObject;
      localJSONArray3 = new JSONArray();
      for (int i = 0; i < localJSONArray2.length(); i++) {
        localJSONArray3.put(encode(localJSONArray2.opt(i), paramParseObjectEncodingStrategy));
      }
    }
    if ((paramObject instanceof ParseRelation)) {
      paramObject = ((ParseRelation)paramObject).encodeToJSON(paramParseObjectEncodingStrategy);
    } else if ((paramObject instanceof ParseFieldOperation)) {
      paramObject = ((ParseFieldOperation)paramObject).encode(paramParseObjectEncodingStrategy);
    } else if ((paramObject instanceof ParseQuery.RelationConstraint)) {
      paramObject = ((ParseQuery.RelationConstraint)paramObject).encode(paramParseObjectEncodingStrategy);
    } else if (paramObject == null) {
      paramObject = JSONObject.NULL;
    } else if (!isValidType(paramObject)) {
      throw new IllegalArgumentException("invalid type for ParseObject: " + paramObject.getClass().toString());
    }
    for (;;)
    {
      label614:
      return paramObject;
      paramObject = localJSONObject3;
      continue;
      paramObject = localJSONArray1;
      continue;
      paramObject = localJSONArray3;
    }
  }
  
  static JSONObject encodeDate(Date paramDate)
  {
    JSONObject localJSONObject = new JSONObject();
    String str = dateToString(paramDate);
    try
    {
      localJSONObject.put("__type", "Date");
      localJSONObject.put("iso", str);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  static Context getApplicationContext()
  {
    checkContext();
    return applicationContext;
  }
  
  static JSONObject getDiskObject(Context paramContext, String paramString)
  {
    try
    {
      setContextIfNeeded(paramContext);
      JSONObject localJSONObject = getDiskObject(new File(getParseDir(), paramString));
      return localJSONObject;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  static JSONObject getDiskObject(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: invokevirtual 239	java/io/File:exists	()Z
    //   9: istore_3
    //   10: iload_3
    //   11: ifne +8 -> 19
    //   14: ldc 2
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: new 391	org/json/JSONObject
    //   22: dup
    //   23: new 524	org/json/JSONTokener
    //   26: dup
    //   27: new 154	java/lang/String
    //   30: dup
    //   31: aload_0
    //   32: invokestatic 528	com/parse/ParseFileUtils:readFileToByteArray	(Ljava/io/File;)[B
    //   35: ldc_w 256
    //   38: invokespecial 259	java/lang/String:<init>	([BLjava/lang/String;)V
    //   41: invokespecial 529	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   44: invokespecial 532	org/json/JSONObject:<init>	(Lorg/json/JSONTokener;)V
    //   47: astore 4
    //   49: aload 4
    //   51: astore_1
    //   52: goto -38 -> 14
    //   55: astore_2
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_2
    //   60: athrow
    //   61: astore 6
    //   63: goto -49 -> 14
    //   66: astore 5
    //   68: goto -54 -> 14
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramFile	File
    //   1	51	1	localObject1	Object
    //   55	5	2	localObject2	Object
    //   9	2	3	bool	boolean
    //   47	3	4	localJSONObject	JSONObject
    //   66	1	5	localIOException	IOException
    //   61	1	6	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   5	10	55	finally
    //   19	49	55	finally
    //   19	49	61	org/json/JSONException
    //   19	49	66	java/io/IOException
  }
  
  static ParseEventuallyQueue getEventuallyQueue()
  {
    synchronized (lock)
    {
      boolean bool = OfflineStore.isEnabled();
      if ((eventuallyQueue == null) || ((bool) && ((eventuallyQueue instanceof ParseCommandCache))) || ((!bool) && ((eventuallyQueue instanceof ParsePinningEventuallyQueue))))
      {
        checkContext();
        if (!bool) {
          break label95;
        }
        localObject3 = new ParsePinningEventuallyQueue(applicationContext);
        eventuallyQueue = (ParseEventuallyQueue)localObject3;
        if ((bool) && (ParseCommandCache.getPendingCount() > 0)) {
          new ParseCommandCache(applicationContext);
        }
      }
      ParseEventuallyQueue localParseEventuallyQueue = eventuallyQueue;
      return localParseEventuallyQueue;
      label95:
      Object localObject3 = new ParseCommandCache(applicationContext);
    }
  }
  
  static long getKeyValueCacheAge(File paramFile)
  {
    String str = paramFile.getName();
    try
    {
      long l2 = Long.parseLong(str.substring(0, str.indexOf('.')));
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        long l1 = 0L;
      }
    }
    return l1;
  }
  
  static File getKeyValueCacheDir()
  {
    synchronized (lock)
    {
      checkContext();
      File localFile = new File(applicationContext.getCacheDir(), "ParseKeyValueCache");
      if ((localFile.isDirectory()) || (localFile.mkdir())) {
        return localFile;
      }
      throw new RuntimeException("could not create Parse cache directory");
    }
  }
  
  static File getKeyValueCacheFile(String paramString)
  {
    String str = '.' + paramString;
    File[] arrayOfFile = getKeyValueCacheDir().listFiles(new Parse.3(str));
    if ((arrayOfFile == null) || (arrayOfFile.length == 0)) {}
    for (File localFile = null;; localFile = arrayOfFile[0]) {
      return localFile;
    }
  }
  
  public static int getLogLevel()
  {
    return logLevel;
  }
  
  static File getParseCacheDir(String paramString)
  {
    synchronized (lock)
    {
      checkContext();
      File localFile = new File(new File(applicationContext.getCacheDir(), "com.parse"), paramString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return localFile;
    }
  }
  
  static File getParseDir()
  {
    synchronized (lock)
    {
      checkContext();
      File localFile = applicationContext.getDir("Parse", 0);
      return localFile;
    }
  }
  
  static File getParseFilesDir(String paramString)
  {
    synchronized (lock)
    {
      checkContext();
      File localFile = new File(new File(applicationContext.getFilesDir(), "com.parse"), paramString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return localFile;
    }
  }
  
  static ScheduledExecutorService getScheduledExecutor()
  {
    synchronized (SCHEDULED_EXECUTOR_LOCK)
    {
      if (scheduledExecutor == null) {
        scheduledExecutor = Executors.newScheduledThreadPool(1);
      }
      return scheduledExecutor;
    }
  }
  
  static boolean hasPermission(String paramString)
  {
    
    if (applicationContext.checkCallingOrSelfPermission(paramString) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void initialize(Context paramContext, String paramString1, String paramString2)
  {
    ParseRequest.initialize(paramContext);
    ParseObject.registerParseSubclasses();
    applicationId = paramString1;
    clientKey = paramString2;
    if (paramContext != null)
    {
      applicationContext = paramContext.getApplicationContext();
      checkCacheApplicationId();
      new Parse.1("Parse.initialize Disk Check & Starting Command Cache").start();
    }
    ParseFieldOperations.registerDefaultDecoders();
    if (!allParsePushIntentReceiversInternal()) {
      throw new SecurityException("To prevent external tampering to your app's notifications, all receivers registered to handle the following actions must have their exported attributes set to false: com.parse.push.intent.RECEIVE, com.parse.push.intent.OPEN, com.parse.push.intent.DELETE");
    }
    GcmRegistrar.updateAsync();
    ParseUser.getCurrentUser();
    ParseAnonymousUtils.initialize();
    m.a(null).a(new Parse.2(), m.a);
  }
  
  static boolean isContainerObject(Object paramObject)
  {
    if (((paramObject instanceof JSONObject)) || ((paramObject instanceof JSONArray)) || ((paramObject instanceof ParseACL)) || ((paramObject instanceof ParseGeoPoint)) || ((paramObject instanceof List)) || ((paramObject instanceof Map))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  static boolean isValidType(Object paramObject)
  {
    if (((paramObject instanceof JSONObject)) || ((paramObject instanceof JSONArray)) || ((paramObject instanceof String)) || ((paramObject instanceof Number)) || ((paramObject instanceof Boolean)) || (paramObject == JSONObject.NULL) || ((paramObject instanceof ParseObject)) || ((paramObject instanceof ParseACL)) || ((paramObject instanceof ParseFile)) || ((paramObject instanceof ParseGeoPoint)) || ((paramObject instanceof Date)) || ((paramObject instanceof byte[])) || ((paramObject instanceof List)) || ((paramObject instanceof Map)) || ((paramObject instanceof ParseRelation))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  static String join(Collection<String> paramCollection, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramCollection.iterator();
    if (localIterator.hasNext())
    {
      localStringBuffer.append((String)localIterator.next());
      while (localIterator.hasNext())
      {
        localStringBuffer.append(paramString);
        localStringBuffer.append((String)localIterator.next());
      }
    }
    return localStringBuffer.toString();
  }
  
  static Object jsonFromKeyValueCache(String paramString, long paramLong)
  {
    Object localObject1 = null;
    String str = loadFromKeyValueCache(paramString, paramLong);
    if (str == null) {}
    for (;;)
    {
      return localObject1;
      JSONTokener localJSONTokener = new JSONTokener(str);
      try
      {
        Object localObject2 = localJSONTokener.nextValue();
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        logE("com.parse.Parse", "corrupted cache for " + paramString, localJSONException);
        clearFromKeyValueCache(paramString);
      }
    }
  }
  
  static Iterable<String> keys(JSONObject paramJSONObject)
  {
    return new Parse.5(paramJSONObject);
  }
  
  static String loadFromKeyValueCache(String paramString, long paramLong)
  {
    Object localObject = null;
    File localFile = getKeyValueCacheFile(paramString);
    if (localFile == null) {}
    for (;;)
    {
      return localObject;
      Date localDate = new Date();
      long l = Math.max(0L, localDate.getTime() - paramLong);
      if (getKeyValueCacheAge(localFile) >= l)
      {
        localFile.setLastModified(localDate.getTime());
        try
        {
          RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "r");
          byte[] arrayOfByte = new byte[(int)localRandomAccessFile.length()];
          localRandomAccessFile.readFully(arrayOfByte);
          localRandomAccessFile.close();
          String str = new String(arrayOfByte, "UTF-8");
          localObject = str;
        }
        catch (IOException localIOException)
        {
          logE("com.parse.Parse", "error reading from cache", localIOException);
        }
      }
    }
  }
  
  private static void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramInt >= logLevel)
    {
      if (paramThrowable != null) {
        break label21;
      }
      Log.println(logLevel, paramString1, paramString2);
    }
    for (;;)
    {
      return;
      label21:
      Log.println(logLevel, paramString1, paramString2 + '\n' + Log.getStackTraceString(paramThrowable));
    }
  }
  
  static void logD(String paramString1, String paramString2)
  {
    logD(paramString1, paramString2, null);
  }
  
  static void logD(String paramString1, String paramString2, Throwable paramThrowable)
  {
    log(3, paramString1, paramString2, paramThrowable);
  }
  
  static void logE(String paramString1, String paramString2)
  {
    logE(paramString1, paramString2, null);
  }
  
  static void logE(String paramString1, String paramString2, Throwable paramThrowable)
  {
    log(6, paramString1, paramString2, paramThrowable);
  }
  
  static void logI(String paramString1, String paramString2)
  {
    logI(paramString1, paramString2, null);
  }
  
  static void logI(String paramString1, String paramString2, Throwable paramThrowable)
  {
    log(4, paramString1, paramString2, paramThrowable);
  }
  
  static void logV(String paramString1, String paramString2)
  {
    logV(paramString1, paramString2, null);
  }
  
  static void logV(String paramString1, String paramString2, Throwable paramThrowable)
  {
    log(2, paramString1, paramString2, paramThrowable);
  }
  
  static void logW(String paramString1, String paramString2)
  {
    logW(paramString1, paramString2, null);
  }
  
  static void logW(String paramString1, String paramString2, Throwable paramThrowable)
  {
    log(5, paramString1, paramString2, paramThrowable);
  }
  
  static void recursiveDelete(File paramFile)
  {
    synchronized (lock)
    {
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        int i = arrayOfFile.length;
        for (int j = 0; j < i; j++) {
          recursiveDelete(arrayOfFile[j]);
        }
      }
      paramFile.delete();
      return;
    }
  }
  
  static void requirePermission(String paramString)
  {
    if (!hasPermission(paramString)) {
      throw new IllegalStateException("To use this functionality, add this to your AndroidManifest.xml:\n<uses-permission android:name=\"" + paramString + "\" />");
    }
  }
  
  static void saveDiskObject(Context paramContext, String paramString, JSONObject paramJSONObject)
  {
    try
    {
      setContextIfNeeded(paramContext);
      saveDiskObject(new File(getParseDir(), paramString), paramJSONObject);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  static void saveDiskObject(File paramFile, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 773	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8: ldc_w 256
    //   11: invokevirtual 275	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   14: invokestatic 777	com/parse/ParseFileUtils:writeByteArrayToFile	(Ljava/io/File;[B)V
    //   17: ldc 2
    //   19: monitorexit
    //   20: return
    //   21: astore 4
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload 4
    //   28: athrow
    //   29: astore_3
    //   30: goto -13 -> 17
    //   33: astore_2
    //   34: goto -17 -> 17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	paramFile	File
    //   0	37	1	paramJSONObject	JSONObject
    //   33	1	2	localUnsupportedEncodingException	UnsupportedEncodingException
    //   29	1	3	localIOException	IOException
    //   21	6	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	17	21	finally
    //   3	17	29	java/io/IOException
    //   3	17	33	java/io/UnsupportedEncodingException
  }
  
  static void saveToKeyValueCache(String paramString1, String paramString2)
  {
    int i = 0;
    File localFile1 = getKeyValueCacheFile(paramString1);
    if (localFile1 != null) {
      localFile1.delete();
    }
    File localFile2 = createKeyValueCacheFile(paramString1);
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile2);
      localFileOutputStream.write(paramString2.getBytes("UTF-8"));
      localFileOutputStream.close();
      label50:
      File[] arrayOfFile = getKeyValueCacheDir().listFiles();
      int j = arrayOfFile.length;
      int k = arrayOfFile.length;
      int m = 0;
      int i2;
      for (int n = 0; m < k; n = i2)
      {
        File localFile4 = arrayOfFile[m];
        i2 = (int)(n + localFile4.length());
        m++;
      }
      int i1;
      if ((j > maxKeyValueCacheFiles) || (n > maxKeyValueCacheBytes))
      {
        Arrays.sort(arrayOfFile, new Parse.4());
        i1 = arrayOfFile.length;
      }
      for (;;)
      {
        if (i < i1)
        {
          File localFile3 = arrayOfFile[i];
          j--;
          n = (int)(n - localFile3.length());
          localFile3.delete();
          if ((j > maxKeyValueCacheFiles) || (n > maxKeyValueCacheBytes)) {}
        }
        else
        {
          return;
        }
        i++;
      }
    }
    catch (IOException localIOException)
    {
      break label50;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label50;
    }
  }
  
  static void setContextIfNeeded(Context paramContext)
  {
    if (applicationContext == null) {
      applicationContext = paramContext;
    }
  }
  
  public static void setLogLevel(int paramInt)
  {
    logLevel = paramInt;
  }
  
  static Date stringToDate(String paramString)
  {
    Date localDate1;
    synchronized (lock)
    {
      try
      {
        Date localDate2 = dateFormat.parse(paramString);
        localDate1 = localDate2;
      }
      catch (java.text.ParseException localParseException)
      {
        logE("com.parse.Parse", "could not parse date: " + paramString, localParseException);
        localDate1 = null;
      }
    }
    return localDate1;
  }
  
  static Number subtractNumbers(Number paramNumber1, Number paramNumber2)
  {
    Object localObject;
    if (((paramNumber1 instanceof Double)) || ((paramNumber2 instanceof Double))) {
      localObject = Double.valueOf(paramNumber1.doubleValue() - paramNumber2.doubleValue());
    }
    for (;;)
    {
      return localObject;
      if (((paramNumber1 instanceof Float)) || ((paramNumber2 instanceof Float)))
      {
        localObject = Float.valueOf(paramNumber1.floatValue() - paramNumber2.floatValue());
      }
      else if (((paramNumber1 instanceof Long)) || ((paramNumber2 instanceof Long)))
      {
        localObject = Long.valueOf(paramNumber1.longValue() - paramNumber2.longValue());
      }
      else if (((paramNumber1 instanceof Integer)) || ((paramNumber2 instanceof Integer)))
      {
        localObject = Integer.valueOf(paramNumber1.intValue() - paramNumber2.intValue());
      }
      else if (((paramNumber1 instanceof Short)) || ((paramNumber2 instanceof Short)))
      {
        localObject = Integer.valueOf(paramNumber1.shortValue() - paramNumber2.shortValue());
      }
      else
      {
        if ((!(paramNumber1 instanceof Byte)) && (!(paramNumber2 instanceof Byte))) {
          break;
        }
        localObject = Integer.valueOf(paramNumber1.byteValue() - paramNumber2.byteValue());
      }
    }
    throw new RuntimeException("Unknown number type.");
  }
  
  static <T> T waitForTask(m<T> paramm)
  {
    Exception localException;
    try
    {
      paramm.g();
      if (!paramm.d()) {
        break label59;
      }
      localException = paramm.f();
      if ((localException instanceof ParseException)) {
        throw ((ParseException)localException);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new RuntimeException(localInterruptedException);
    }
    if ((localException instanceof RuntimeException)) {
      throw ((RuntimeException)localException);
    }
    throw new RuntimeException(localException);
    label59:
    if (paramm.c()) {
      throw new RuntimeException(new CancellationException());
    }
    Object localObject = paramm.e();
    return localObject;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.Parse
 * JD-Core Version:    0.7.0.1
 */