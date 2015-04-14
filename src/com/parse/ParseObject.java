package com.parse;

import android.content.Context;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.concurrent.ConcurrentHashMap;
import k;
import m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseObject
{
  static final String API_VERSION = "2";
  private static final String AUTO_CLASS_NAME = "_Automatic";
  public static final String DEFAULT_PIN = "_default";
  private static final String NEW_OFFLINE_OBJECT_ID_PLACEHOLDER = "*** Offline Object ***";
  private static final String REST_KEY_COMPLETE = "__complete";
  private static final String REST_KEY_OPERATIONS = "__operations";
  private static final String TAG = "com.parse.ParseObject";
  static final String VERSION_NAME = "1.7.1";
  private static final Map<Class<? extends ParseObject>, String> classNames;
  private static final DateFormat impreciseDateFormat;
  private static final ThreadLocal<String> isCreatingPointerForObjectId = new ParseObject.1();
  private static final Map<String, Class<? extends ParseObject>> objectTypes;
  static String server = "https://api.parse.com";
  private String className;
  private Date createdAt;
  private final Map<String, Boolean> dataAvailability;
  private final Map<String, Object> estimatedData;
  boolean hasBeenFetched;
  private final Map<Object, ParseJSONCacheItem> hashedObjects;
  boolean isDeleted;
  int isDeletingEventually;
  private String localId;
  final Object mutex = new Object();
  private String objectId;
  final LinkedList<ParseOperationSet> operationSetQueue;
  private final ParseMulticastDelegate<ParseObject> saveEvent = new ParseMulticastDelegate();
  private final Map<String, Object> serverData;
  final TaskQueue taskQueue = new TaskQueue();
  private Date updatedAt;
  
  static
  {
    classNames = new ConcurrentHashMap();
    objectTypes = new ConcurrentHashMap();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    impreciseDateFormat = localSimpleDateFormat;
  }
  
  protected ParseObject()
  {
    this("_Automatic");
  }
  
  public ParseObject(String paramString)
  {
    String str = (String)isCreatingPointerForObjectId.get();
    if (paramString == null) {
      throw new IllegalArgumentException("You must specify a Parse class name when creating a new ParseObject.");
    }
    if ("_Automatic".equals(paramString)) {
      paramString = getClassName(getClass());
    }
    if ((getClass().equals(ParseObject.class)) && (objectTypes.containsKey(paramString)) && (!((Class)objectTypes.get(paramString)).isInstance(this))) {
      throw new IllegalArgumentException("You must create this type of ParseObject using ParseObject.create() or the proper subclass.");
    }
    if ((!getClass().equals(ParseObject.class)) && (!getClass().equals(objectTypes.get(paramString)))) {
      throw new IllegalArgumentException("You must register this ParseObject subclass before instantiating it.");
    }
    this.localId = null;
    this.serverData = new HashMap();
    this.operationSetQueue = new LinkedList();
    this.operationSetQueue.add(new ParseOperationSet());
    this.estimatedData = new HashMap();
    this.hashedObjects = new IdentityHashMap();
    this.dataAvailability = new HashMap();
    this.className = paramString;
    if (str == null) {
      setDefaultValues();
    }
    for (this.hasBeenFetched = true;; this.hasBeenFetched = false)
    {
      OfflineStore localOfflineStore = OfflineStore.getCurrent();
      if (localOfflineStore != null) {
        localOfflineStore.registerNewObject(this);
      }
      return;
      if (!str.equals("*** Offline Object ***")) {
        this.objectId = str;
      }
    }
  }
  
  /* Error */
  private void applyOperations(ParseOperationSet paramParseOperationSet, Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 127	com/parse/ParseObject:mutex	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_1
    //   8: invokevirtual 297	com/parse/ParseOperationSet:keySet	()Ljava/util/Set;
    //   11: invokeinterface 303 1 0
    //   16: astore 5
    //   18: aload 5
    //   20: invokeinterface 308 1 0
    //   25: ifeq +80 -> 105
    //   28: aload 5
    //   30: invokeinterface 311 1 0
    //   35: checkcast 140	java/lang/String
    //   38: astore 6
    //   40: aload_1
    //   41: aload 6
    //   43: invokevirtual 312	com/parse/ParseOperationSet:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   46: checkcast 314	com/parse/ParseFieldOperation
    //   49: aload_2
    //   50: aload 6
    //   52: invokeinterface 166 2 0
    //   57: aload_0
    //   58: aload 6
    //   60: invokeinterface 318 4 0
    //   65: astore 7
    //   67: aload 7
    //   69: ifnull +24 -> 93
    //   72: aload_2
    //   73: aload 6
    //   75: aload 7
    //   77: invokeinterface 322 3 0
    //   82: pop
    //   83: goto -65 -> 18
    //   86: astore 4
    //   88: aload_3
    //   89: monitorexit
    //   90: aload 4
    //   92: athrow
    //   93: aload_2
    //   94: aload 6
    //   96: invokeinterface 325 2 0
    //   101: pop
    //   102: goto -84 -> 18
    //   105: aload_3
    //   106: monitorexit
    //   107: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	ParseObject
    //   0	108	1	paramParseOperationSet	ParseOperationSet
    //   0	108	2	paramMap	Map<String, Object>
    //   4	102	3	localObject1	Object
    //   86	5	4	localObject2	Object
    //   16	13	5	localIterator	Iterator
    //   38	57	6	str	String
    //   65	11	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   7	90	86	finally
    //   93	107	86	finally
  }
  
  private boolean canBeSerialized()
  {
    synchronized (this.mutex)
    {
      k localk = new k(Boolean.valueOf(true));
      new ParseObject.36(this, localk).setYieldRoot(false).setTraverseParseObjects(true).traverse(this);
      boolean bool = ((Boolean)localk.a()).booleanValue();
      return bool;
    }
  }
  
  /* Error */
  private void checkForChangesToMutableContainer(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 127	com/parse/ParseObject:mutex	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_2
    //   8: invokestatic 368	com/parse/Parse:isContainerObject	(Ljava/lang/Object;)Z
    //   11: ifeq +89 -> 100
    //   14: aload_0
    //   15: getfield 200	com/parse/ParseObject:hashedObjects	Ljava/util/Map;
    //   18: aload_2
    //   19: invokeinterface 166 2 0
    //   24: checkcast 370	com/parse/ParseJSONCacheItem
    //   27: astore 6
    //   29: aload 6
    //   31: ifnonnull +21 -> 52
    //   34: new 142	java/lang/IllegalArgumentException
    //   37: dup
    //   38: ldc_w 372
    //   41: invokespecial 145	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   44: athrow
    //   45: astore 4
    //   47: aload_3
    //   48: monitorexit
    //   49: aload 4
    //   51: athrow
    //   52: new 370	com/parse/ParseJSONCacheItem
    //   55: dup
    //   56: aload_2
    //   57: invokespecial 373	com/parse/ParseJSONCacheItem:<init>	(Ljava/lang/Object;)V
    //   60: astore 7
    //   62: aload 6
    //   64: aload 7
    //   66: invokevirtual 376	com/parse/ParseJSONCacheItem:equals	(Lcom/parse/ParseJSONCacheItem;)Z
    //   69: ifne +16 -> 85
    //   72: aload_0
    //   73: aload_1
    //   74: new 378	com/parse/ParseSetOperation
    //   77: dup
    //   78: aload_2
    //   79: invokespecial 379	com/parse/ParseSetOperation:<init>	(Ljava/lang/Object;)V
    //   82: invokevirtual 383	com/parse/ParseObject:performOperation	(Ljava/lang/String;Lcom/parse/ParseFieldOperation;)V
    //   85: aload_3
    //   86: monitorexit
    //   87: return
    //   88: astore 8
    //   90: new 385	java/lang/RuntimeException
    //   93: dup
    //   94: aload 8
    //   96: invokespecial 388	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   99: athrow
    //   100: aload_0
    //   101: getfield 200	com/parse/ParseObject:hashedObjects	Ljava/util/Map;
    //   104: aload_2
    //   105: invokeinterface 325 2 0
    //   110: pop
    //   111: goto -26 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	ParseObject
    //   0	114	1	paramString	String
    //   0	114	2	paramObject	Object
    //   4	82	3	localObject1	Object
    //   45	5	4	localObject2	Object
    //   27	36	6	localParseJSONCacheItem1	ParseJSONCacheItem
    //   60	5	7	localParseJSONCacheItem2	ParseJSONCacheItem
    //   88	7	8	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   7	49	45	finally
    //   52	62	45	finally
    //   62	111	45	finally
    //   52	62	88	org/json/JSONException
  }
  
  private void checkGetAccess(String paramString)
  {
    if (!isDataAvailable(paramString)) {
      throw new IllegalStateException("ParseObject has no data for this key.  Call fetchIfNeeded() to get the data.");
    }
  }
  
  /* Error */
  private void checkpointAllMutableContainers()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 127	com/parse/ParseObject:mutex	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 195	com/parse/ParseObject:estimatedData	Ljava/util/Map;
    //   11: invokeinterface 399 1 0
    //   16: invokeinterface 402 1 0
    //   21: astore_3
    //   22: aload_3
    //   23: invokeinterface 308 1 0
    //   28: ifeq +21 -> 49
    //   31: aload_0
    //   32: aload_3
    //   33: invokeinterface 311 1 0
    //   38: invokespecial 405	com/parse/ParseObject:checkpointMutableContainer	(Ljava/lang/Object;)V
    //   41: goto -19 -> 22
    //   44: astore_2
    //   45: aload_1
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    //   49: aload_1
    //   50: monitorexit
    //   51: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ParseObject
    //   4	46	1	localObject1	Object
    //   44	4	2	localObject2	Object
    //   21	12	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   7	47	44	finally
    //   49	51	44	finally
  }
  
  private void checkpointMutableContainer(Object paramObject)
  {
    synchronized (this.mutex)
    {
      boolean bool = Parse.isContainerObject(paramObject);
      if (bool) {}
      try
      {
        ParseJSONCacheItem localParseJSONCacheItem = new ParseJSONCacheItem(paramObject);
        this.hashedObjects.put(paramObject, localParseJSONCacheItem);
        return;
      }
      catch (JSONException localJSONException)
      {
        throw new RuntimeException(localJSONException);
      }
    }
  }
  
  private static void collectDirtyChildren(Object paramObject, List<ParseObject> paramList, List<ParseFile> paramList1)
  {
    collectDirtyChildren(paramObject, paramList, paramList1, new IdentityHashMap(), new IdentityHashMap());
  }
  
  private static void collectDirtyChildren(Object paramObject, List<ParseObject> paramList, List<ParseFile> paramList1, IdentityHashMap<ParseObject, ParseObject> paramIdentityHashMap1, IdentityHashMap<ParseObject, ParseObject> paramIdentityHashMap2)
  {
    new ParseObject.35(paramList1, paramIdentityHashMap1, paramIdentityHashMap2, paramList).setYieldRoot(true).traverse(paramObject);
  }
  
  private Map<String, ParseObject> collectFetchedObjects()
  {
    HashMap localHashMap = new HashMap();
    new ParseObject.4(this, localHashMap).traverse(this.estimatedData);
    return localHashMap;
  }
  
  private ParseCommand constructDeleteCommand(boolean paramBoolean, String paramString)
  {
    synchronized (this.mutex)
    {
      ParseCommand localParseCommand = new ParseCommand("delete", paramString);
      localParseCommand.enableRetrying();
      localParseCommand.put("classname", this.className);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("objectId", this.objectId);
        localParseCommand.put("data", localJSONObject);
        return localParseCommand;
      }
      catch (JSONException localJSONException)
      {
        throw new RuntimeException(localJSONException.getMessage());
      }
    }
  }
  
  public static <T extends ParseObject> T create(Class<T> paramClass)
  {
    return create(getClassName(paramClass));
  }
  
  public static ParseObject create(String paramString)
  {
    if (objectTypes.containsKey(paramString)) {}
    for (;;)
    {
      try
      {
        localParseObject = (ParseObject)((Class)objectTypes.get(paramString)).newInstance();
        return localParseObject;
      }
      catch (Exception localException)
      {
        if ((localException instanceof RuntimeException)) {
          throw ((RuntimeException)localException);
        }
        throw new RuntimeException("Failed to create instance of subclass.", localException);
      }
      ParseObject localParseObject = new ParseObject(paramString);
    }
  }
  
  public static <T extends ParseObject> T createWithoutData(Class<T> paramClass, String paramString)
  {
    return createWithoutData(getClassName(paramClass), paramString);
  }
  
  /* Error */
  public static ParseObject createWithoutData(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 215	com/parse/OfflineStore:getCurrent	()Lcom/parse/OfflineStore;
    //   3: astore_2
    //   4: aload_1
    //   5: ifnonnull +99 -> 104
    //   8: getstatic 116	com/parse/ParseObject:isCreatingPointerForObjectId	Ljava/lang/ThreadLocal;
    //   11: ldc 17
    //   13: invokevirtual 473	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   16: aload_2
    //   17: ifnull +110 -> 127
    //   20: aload_1
    //   21: ifnull +106 -> 127
    //   24: aload_2
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 477	com/parse/OfflineStore:getOrCreateObjectWithoutData	(Ljava/lang/String;Ljava/lang/String;)Landroid/util/Pair;
    //   30: astore 9
    //   32: aload 9
    //   34: getfield 482	android/util/Pair:first	Ljava/lang/Object;
    //   37: checkcast 2	com/parse/ParseObject
    //   40: astore 10
    //   42: aload 9
    //   44: getfield 485	android/util/Pair:second	Ljava/lang/Object;
    //   47: checkcast 329	java/lang/Boolean
    //   50: invokevirtual 359	java/lang/Boolean:booleanValue	()Z
    //   53: istore 11
    //   55: aload 10
    //   57: astore 6
    //   59: iload 11
    //   61: istore 7
    //   63: iload 7
    //   65: ifeq +78 -> 143
    //   68: aload 6
    //   70: invokevirtual 488	com/parse/ParseObject:hasChanges	()Z
    //   73: ifeq +70 -> 143
    //   76: new 391	java/lang/IllegalStateException
    //   79: dup
    //   80: ldc_w 490
    //   83: invokespecial 394	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   86: athrow
    //   87: astore 8
    //   89: aload 8
    //   91: athrow
    //   92: astore 4
    //   94: getstatic 116	com/parse/ParseObject:isCreatingPointerForObjectId	Ljava/lang/ThreadLocal;
    //   97: aconst_null
    //   98: invokevirtual 473	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   101: aload 4
    //   103: athrow
    //   104: getstatic 116	com/parse/ParseObject:isCreatingPointerForObjectId	Ljava/lang/ThreadLocal;
    //   107: aload_1
    //   108: invokevirtual 473	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   111: goto -95 -> 16
    //   114: astore_3
    //   115: new 385	java/lang/RuntimeException
    //   118: dup
    //   119: ldc_w 462
    //   122: aload_3
    //   123: invokespecial 465	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   126: athrow
    //   127: aload_0
    //   128: invokestatic 455	com/parse/ParseObject:create	(Ljava/lang/String;)Lcom/parse/ParseObject;
    //   131: astore 5
    //   133: aload 5
    //   135: astore 6
    //   137: iconst_1
    //   138: istore 7
    //   140: goto -77 -> 63
    //   143: getstatic 116	com/parse/ParseObject:isCreatingPointerForObjectId	Ljava/lang/ThreadLocal;
    //   146: aconst_null
    //   147: invokevirtual 473	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   150: aload 6
    //   152: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramString1	String
    //   0	153	1	paramString2	String
    //   3	22	2	localOfflineStore	OfflineStore
    //   114	9	3	localException	Exception
    //   92	10	4	localObject1	Object
    //   131	3	5	localParseObject1	ParseObject
    //   57	94	6	localObject2	Object
    //   61	78	7	bool1	boolean
    //   87	3	8	localRuntimeException	RuntimeException
    //   30	13	9	localPair	android.util.Pair
    //   40	16	10	localParseObject2	ParseObject
    //   53	7	11	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   8	87	87	java/lang/RuntimeException
    //   104	111	87	java/lang/RuntimeException
    //   127	133	87	java/lang/RuntimeException
    //   8	87	92	finally
    //   89	92	92	finally
    //   104	111	92	finally
    //   115	127	92	finally
    //   127	133	92	finally
    //   8	87	114	java/lang/Exception
    //   104	111	114	java/lang/Exception
    //   127	133	114	java/lang/Exception
  }
  
  private ParseOperationSet currentOperations()
  {
    synchronized (this.mutex)
    {
      ParseOperationSet localParseOperationSet = (ParseOperationSet)this.operationSetQueue.getLast();
      return localParseOperationSet;
    }
  }
  
  private static m<Void> deepSaveAsync(Object paramObject, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    collectDirtyChildren(paramObject, localArrayList1, localArrayList2);
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = localArrayList2.iterator();
    while (localIterator.hasNext()) {
      localArrayList3.add(((ParseFile)localIterator.next()).saveInBackground());
    }
    return m.a(localArrayList3).d(new ParseObject.37(localArrayList1, paramString));
  }
  
  public static <T extends ParseObject> void deleteAll(List<T> paramList)
  {
    Parse.waitForTask(deleteAllAsync(paramList, ParseUser.getCurrentSessionToken()));
  }
  
  private static <T extends ParseObject> m<Void> deleteAllAsync(List<T> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ParseObject localParseObject = (ParseObject)localIterator.next();
      if (!localHashSet.contains(localParseObject.getObjectId()))
      {
        localHashSet.add(localParseObject.getObjectId());
        localArrayList.add(localParseObject);
      }
    }
    return m.a(null).b(new ParseObject.34(localArrayList, paramString));
  }
  
  public static <T extends ParseObject> m<Void> deleteAllInBackground(List<T> paramList)
  {
    return deleteAllAsync(paramList, ParseUser.getCurrentSessionToken());
  }
  
  public static <T extends ParseObject> void deleteAllInBackground(List<T> paramList, DeleteCallback paramDeleteCallback)
  {
    Parse.callbackOnMainThreadAsync(deleteAllInBackground(paramList), paramDeleteCallback);
  }
  
  private m<Void> deleteAsync(m<Void> paramm)
  {
    String str = ParseUser.getCurrentSessionToken();
    return m.a(null).d(new ParseObject.31(this)).d(TaskQueue.waitFor(paramm)).d(new ParseObject.30(this, str)).d(new ParseObject.29(this));
  }
  
  /* Error */
  static <T> m<T> enqueueForAll(List<? extends ParseObject> paramList, l<Void, m<T>> paraml)
  {
    // Byte code:
    //   0: invokestatic 587	m:a	()Ly;
    //   3: astore_2
    //   4: new 497	java/util/ArrayList
    //   7: dup
    //   8: aload_0
    //   9: invokeinterface 591 1 0
    //   14: invokespecial 594	java/util/ArrayList:<init>	(I)V
    //   17: astore_3
    //   18: aload_0
    //   19: invokeinterface 503 1 0
    //   24: astore 4
    //   26: aload 4
    //   28: invokeinterface 308 1 0
    //   33: ifeq +29 -> 62
    //   36: aload_3
    //   37: aload 4
    //   39: invokeinterface 311 1 0
    //   44: checkcast 2	com/parse/ParseObject
    //   47: getfield 132	com/parse/ParseObject:taskQueue	Lcom/parse/TaskQueue;
    //   50: invokevirtual 598	com/parse/TaskQueue:getLock	()Ljava/util/concurrent/locks/Lock;
    //   53: invokeinterface 510 2 0
    //   58: pop
    //   59: goto -33 -> 26
    //   62: new 600	com/parse/LockSet
    //   65: dup
    //   66: aload_3
    //   67: invokespecial 603	com/parse/LockSet:<init>	(Ljava/util/Collection;)V
    //   70: astore 5
    //   72: aload 5
    //   74: invokevirtual 606	com/parse/LockSet:lock	()V
    //   77: aload_1
    //   78: aload_2
    //   79: invokevirtual 610	y:a	()Lm;
    //   82: invokeinterface 615 2 0
    //   87: checkcast 512	m
    //   90: astore 9
    //   92: new 497	java/util/ArrayList
    //   95: dup
    //   96: invokespecial 498	java/util/ArrayList:<init>	()V
    //   99: astore 10
    //   101: aload_0
    //   102: invokeinterface 503 1 0
    //   107: astore 11
    //   109: aload 11
    //   111: invokeinterface 308 1 0
    //   116: ifeq +61 -> 177
    //   119: aload 11
    //   121: invokeinterface 311 1 0
    //   126: checkcast 2	com/parse/ParseObject
    //   129: getfield 132	com/parse/ParseObject:taskQueue	Lcom/parse/TaskQueue;
    //   132: new 617	com/parse/ParseObject$2
    //   135: dup
    //   136: aload 10
    //   138: aload 9
    //   140: invokespecial 620	com/parse/ParseObject$2:<init>	(Ljava/util/List;Lm;)V
    //   143: invokevirtual 623	com/parse/TaskQueue:enqueue	(Ll;)Lm;
    //   146: pop
    //   147: goto -38 -> 109
    //   150: astore 7
    //   152: aload 5
    //   154: invokevirtual 626	com/parse/LockSet:unlock	()V
    //   157: aload 7
    //   159: athrow
    //   160: astore 8
    //   162: aload 8
    //   164: athrow
    //   165: astore 6
    //   167: new 385	java/lang/RuntimeException
    //   170: dup
    //   171: aload 6
    //   173: invokespecial 388	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   176: athrow
    //   177: aload 10
    //   179: invokestatic 515	m:a	(Ljava/util/Collection;)Lm;
    //   182: new 628	com/parse/ParseObject$3
    //   185: dup
    //   186: aload_2
    //   187: invokespecial 631	com/parse/ParseObject$3:<init>	(Ly;)V
    //   190: invokevirtual 633	m:a	(Ll;)Lm;
    //   193: pop
    //   194: aload 5
    //   196: invokevirtual 626	com/parse/LockSet:unlock	()V
    //   199: aload 9
    //   201: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	paramList	List<? extends ParseObject>
    //   0	202	1	paraml	l<Void, m<T>>
    //   3	184	2	localy	y
    //   17	50	3	localArrayList1	ArrayList
    //   24	14	4	localIterator1	Iterator
    //   70	125	5	localLockSet	LockSet
    //   165	7	6	localException	Exception
    //   150	8	7	localObject	Object
    //   160	3	8	localRuntimeException	RuntimeException
    //   90	110	9	localm	m
    //   99	79	10	localArrayList2	ArrayList
    //   107	13	11	localIterator2	Iterator
    // Exception table:
    //   from	to	target	type
    //   77	92	150	finally
    //   92	147	150	finally
    //   162	194	150	finally
    //   77	92	160	java/lang/RuntimeException
    //   77	92	165	java/lang/Exception
  }
  
  private m<Void> enqueueSaveEventuallyOperationAsync(ParseOperationSet paramParseOperationSet)
  {
    if (!paramParseOperationSet.isSaveEventually()) {
      throw new IllegalStateException("This should only be used to enqueue saveEventually operation sets");
    }
    return this.taskQueue.enqueue(new ParseObject.14(this, paramParseOperationSet));
  }
  
  public static <T extends ParseObject> List<T> fetchAll(List<T> paramList)
  {
    return (List)Parse.waitForTask(fetchAllInBackground(paramList));
  }
  
  private static <T extends ParseObject> m<List<T>> fetchAllAsync(List<T> paramList, ParseUser paramParseUser, m<Void> paramm)
  {
    if (paramList.size() == 0) {}
    ParseQuery localParseQuery;
    for (m localm = m.a(paramList);; localm = paramm.b(new ParseObject.42(localParseQuery, paramParseUser)).c(new ParseObject.41(paramList)))
    {
      return localm;
      ArrayList localArrayList = new ArrayList();
      String str = ((ParseObject)paramList.get(0)).getClassName();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ParseObject localParseObject = (ParseObject)localIterator.next();
        if (!localParseObject.getClassName().equals(str)) {
          throw new IllegalArgumentException("All objects should have the same class");
        }
        if (localParseObject.getObjectId() == null) {
          throw new IllegalArgumentException("All objects must exist on the server");
        }
        localArrayList.add(localParseObject.getObjectId());
      }
      localParseQuery = ParseQuery.getQuery(str);
      localParseQuery.whereContainedIn("objectId", localArrayList);
    }
  }
  
  public static <T extends ParseObject> List<T> fetchAllIfNeeded(List<T> paramList)
  {
    return (List)Parse.waitForTask(fetchAllIfNeededInBackground(paramList));
  }
  
  private static <T extends ParseObject> m<List<T>> fetchAllIfNeededAsync(List<T> paramList, ParseUser paramParseUser, m<Void> paramm)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = null;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ParseObject localParseObject = (ParseObject)localIterator.next();
      if (!localParseObject.isDataAvailable())
      {
        if ((str1 != null) && (!str1.equals(localParseObject.getClassName()))) {
          throw new IllegalArgumentException("All objects should have the same class");
        }
        str1 = localParseObject.getClassName();
        String str2 = localParseObject.getObjectId();
        if (str2 != null) {
          localArrayList.add(str2);
        }
      }
      str1 = str1;
    }
    if (localArrayList.size() == 0) {}
    ParseQuery localParseQuery;
    for (m localm = m.a(paramList);; localm = paramm.b(new ParseObject.39(localParseQuery, paramParseUser)).c(new ParseObject.38(paramList)))
    {
      return localm;
      localParseQuery = ParseQuery.getQuery(str1);
      localParseQuery.whereContainedIn("objectId", localArrayList);
    }
  }
  
  public static <T extends ParseObject> m<List<T>> fetchAllIfNeededInBackground(List<T> paramList)
  {
    return enqueueForAll(paramList, new ParseObject.40(paramList, ParseUser.getCurrentUser()));
  }
  
  public static <T extends ParseObject> void fetchAllIfNeededInBackground(List<T> paramList, FindCallback<T> paramFindCallback)
  {
    Parse.callbackOnMainThreadAsync(fetchAllIfNeededInBackground(paramList), paramFindCallback);
  }
  
  public static <T extends ParseObject> m<List<T>> fetchAllInBackground(List<T> paramList)
  {
    return enqueueForAll(paramList, new ParseObject.43(paramList, ParseUser.getCurrentUser()));
  }
  
  public static <T extends ParseObject> void fetchAllInBackground(List<T> paramList, FindCallback<T> paramFindCallback)
  {
    Parse.callbackOnMainThreadAsync(fetchAllInBackground(paramList), paramFindCallback);
  }
  
  private static void findUnsavedChildren(Object paramObject, List<ParseObject> paramList)
  {
    if ((paramObject instanceof List))
    {
      Iterator localIterator2 = ((List)paramObject).iterator();
      while (localIterator2.hasNext()) {
        findUnsavedChildren(localIterator2.next(), paramList);
      }
    }
    if ((paramObject instanceof Map))
    {
      Iterator localIterator1 = ((Map)paramObject).values().iterator();
      while (localIterator1.hasNext()) {
        findUnsavedChildren(localIterator1.next(), paramList);
      }
    }
    if ((paramObject instanceof ParseObject))
    {
      ParseObject localParseObject = (ParseObject)paramObject;
      if (localParseObject.isDirty()) {
        paramList.add(localParseObject);
      }
    }
  }
  
  static <T extends ParseObject> T fromJSON(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    return fromJSON(paramJSONObject, paramString, paramBoolean, new ParseDecoder());
  }
  
  static <T extends ParseObject> T fromJSON(JSONObject paramJSONObject, String paramString, boolean paramBoolean, ParseDecoder paramParseDecoder)
  {
    String str1 = null;
    JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
    String str2;
    if (localJSONObject != null)
    {
      str2 = localJSONObject.optString("objectId", null);
      str1 = localJSONObject.optString("classname", paramString);
    }
    for (;;)
    {
      ParseObject localParseObject = createWithoutData(str1, str2);
      localParseObject.mergeAfterFetch(paramJSONObject, paramParseDecoder, paramBoolean);
      return localParseObject;
      str2 = null;
    }
  }
  
  /* Error */
  private ParseACL getACL(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 127	com/parse/ParseObject:mutex	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: ldc_w 737
    //   11: invokespecial 739	com/parse/ParseObject:checkGetAccess	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 195	com/parse/ParseObject:estimatedData	Ljava/util/Map;
    //   18: ldc_w 737
    //   21: invokeinterface 166 2 0
    //   26: astore 4
    //   28: aload 4
    //   30: ifnonnull +11 -> 41
    //   33: aconst_null
    //   34: astore 5
    //   36: aload_2
    //   37: monitorexit
    //   38: goto +87 -> 125
    //   41: aload 4
    //   43: instanceof 741
    //   46: ifne +19 -> 65
    //   49: new 385	java/lang/RuntimeException
    //   52: dup
    //   53: ldc_w 743
    //   56: invokespecial 450	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   59: athrow
    //   60: astore_3
    //   61: aload_2
    //   62: monitorexit
    //   63: aload_3
    //   64: athrow
    //   65: iload_1
    //   66: ifeq +50 -> 116
    //   69: aload 4
    //   71: checkcast 741	com/parse/ParseACL
    //   74: invokevirtual 746	com/parse/ParseACL:isShared	()Z
    //   77: ifeq +39 -> 116
    //   80: aload 4
    //   82: checkcast 741	com/parse/ParseACL
    //   85: invokevirtual 750	com/parse/ParseACL:copy	()Lcom/parse/ParseACL;
    //   88: astore 5
    //   90: aload_0
    //   91: getfield 195	com/parse/ParseObject:estimatedData	Ljava/util/Map;
    //   94: ldc_w 737
    //   97: aload 5
    //   99: invokeinterface 322 3 0
    //   104: pop
    //   105: aload_0
    //   106: aload 5
    //   108: invokevirtual 753	com/parse/ParseObject:addToHashedObjects	(Ljava/lang/Object;)V
    //   111: aload_2
    //   112: monitorexit
    //   113: goto +12 -> 125
    //   116: aload 4
    //   118: checkcast 741	com/parse/ParseACL
    //   121: astore 5
    //   123: aload_2
    //   124: monitorexit
    //   125: aload 5
    //   127: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	ParseObject
    //   0	128	1	paramBoolean	boolean
    //   4	120	2	localObject1	Object
    //   60	4	3	localObject2	Object
    //   26	91	4	localObject3	Object
    //   34	92	5	localParseACL	ParseACL
    // Exception table:
    //   from	to	target	type
    //   7	63	60	finally
    //   69	125	60	finally
  }
  
  static String getApplicationId()
  {
    Parse.checkInit();
    return Parse.applicationId;
  }
  
  static String getClassName(Class<? extends ParseObject> paramClass)
  {
    String str = (String)classNames.get(paramClass);
    ParseClassName localParseClassName;
    if (str == null)
    {
      localParseClassName = (ParseClassName)paramClass.getAnnotation(ParseClassName.class);
      if (localParseClassName != null) {
        break label36;
      }
      str = null;
    }
    for (;;)
    {
      return str;
      label36:
      str = localParseClassName.value();
      classNames.put(paramClass, str);
    }
  }
  
  static ParseObject getFromDisk(Context paramContext, String paramString)
  {
    Object localObject = null;
    if (OfflineStore.isEnabled()) {
      throw new IllegalStateException("ParseObject#getFromDisk is not allowed when OfflineStore is enabled");
    }
    JSONObject localJSONObject = Parse.getDiskObject(paramContext, paramString);
    if (localJSONObject == null) {}
    for (;;)
    {
      return localObject;
      try
      {
        ParseObject localParseObject = createWithoutData(localJSONObject.getString("classname"), null);
        localParseObject.mergeFromServer(localJSONObject, new ParseDecoder(), true);
        localObject = localParseObject;
      }
      catch (JSONException localJSONException) {}
    }
  }
  
  private m<Void> handleDeleteResultAsync(Object paramObject)
  {
    int i = 1;
    m localm = m.a(null);
    localObject1 = this.mutex;
    if (paramObject != null) {}
    for (;;)
    {
      if (i != 0) {}
      try
      {
        this.isDeleted = true;
        OfflineStore localOfflineStore = OfflineStore.getCurrent();
        if (localOfflineStore != null) {
          localm = localm.b(new ParseObject.32(this, localOfflineStore));
        }
        return localm;
      }
      finally {}
      i = 0;
    }
  }
  
  private boolean hasDirtyChildren()
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        ArrayList localArrayList = new ArrayList();
        findUnsavedChildren(this.estimatedData, localArrayList);
        if (localArrayList.size() > 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private static Date impreciseParseDate(String paramString)
  {
    try
    {
      Date localDate2 = impreciseDateFormat.parse(paramString);
      localDate1 = localDate2;
    }
    catch (java.text.ParseException localParseException)
    {
      for (;;)
      {
        Parse.logE("com.parse.ParseObject", "could not parse date: " + paramString, localParseException);
        Date localDate1 = null;
      }
    }
    finally {}
    return localDate1;
  }
  
  private static boolean isAccessible(Member paramMember)
  {
    if ((Modifier.isPublic(paramMember.getModifiers())) || ((paramMember.getDeclaringClass().getPackage().getName().equals("com.parse")) && (!Modifier.isPrivate(paramMember.getModifiers())) && (!Modifier.isProtected(paramMember.getModifiers())))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean isDataAvailable(String paramString)
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        if (!isDataAvailable())
        {
          if ((!this.dataAvailability.containsKey(paramString)) || (!((Boolean)this.dataAvailability.get(paramString)).booleanValue())) {
            break label65;
          }
          break label59;
          return bool;
        }
      }
      label59:
      boolean bool = true;
      continue;
      label65:
      bool = false;
    }
  }
  
  private void mergeAfterSave(JSONObject paramJSONObject, ParseDecoder paramParseDecoder, ParseOperationSet paramParseOperationSet)
  {
    synchronized (this.mutex)
    {
      ListIterator localListIterator = this.operationSetQueue.listIterator(this.operationSetQueue.indexOf(paramParseOperationSet));
      localListIterator.next();
      localListIterator.remove();
      ParseOperationSet localParseOperationSet = (ParseOperationSet)localListIterator.next();
      if (paramJSONObject == null)
      {
        localParseOperationSet.mergeFrom(paramParseOperationSet);
        return;
      }
      applyOperations(paramParseOperationSet, this.serverData);
      mergeFromServer(paramJSONObject, paramParseDecoder, false);
      rebuildEstimatedData();
      checkpointAllMutableContainers();
    }
  }
  
  public static <T extends ParseObject> void pinAll(String paramString, List<T> paramList)
  {
    Parse.waitForTask(pinAllInBackground(paramString, paramList));
  }
  
  public static <T extends ParseObject> void pinAll(List<T> paramList)
  {
    Parse.waitForTask(pinAllInBackground("_default", paramList));
  }
  
  public static <T extends ParseObject> m<Void> pinAllInBackground(String paramString, List<T> paramList)
  {
    return ParsePin.pinAllObjectsAsync(paramString, paramList);
  }
  
  public static <T extends ParseObject> m<Void> pinAllInBackground(List<T> paramList)
  {
    return pinAllInBackground("_default", paramList);
  }
  
  public static <T extends ParseObject> void pinAllInBackground(String paramString, List<T> paramList, SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(pinAllInBackground(paramString, paramList), paramSaveCallback);
  }
  
  public static <T extends ParseObject> void pinAllInBackground(List<T> paramList, SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(pinAllInBackground("_default", paramList), paramSaveCallback);
  }
  
  /* Error */
  private void rebuildEstimatedData()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 127	com/parse/ParseObject:mutex	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 195	com/parse/ParseObject:estimatedData	Ljava/util/Map;
    //   11: invokeinterface 891 1 0
    //   16: aload_0
    //   17: getfield 195	com/parse/ParseObject:estimatedData	Ljava/util/Map;
    //   20: aload_0
    //   21: getfield 182	com/parse/ParseObject:serverData	Ljava/util/Map;
    //   24: invokeinterface 895 2 0
    //   29: aload_0
    //   30: getfield 187	com/parse/ParseObject:operationSetQueue	Ljava/util/LinkedList;
    //   33: invokevirtual 896	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   36: astore_3
    //   37: aload_3
    //   38: invokeinterface 308 1 0
    //   43: ifeq +28 -> 71
    //   46: aload_0
    //   47: aload_3
    //   48: invokeinterface 311 1 0
    //   53: checkcast 189	com/parse/ParseOperationSet
    //   56: aload_0
    //   57: getfield 195	com/parse/ParseObject:estimatedData	Ljava/util/Map;
    //   60: invokespecial 870	com/parse/ParseObject:applyOperations	(Lcom/parse/ParseOperationSet;Ljava/util/Map;)V
    //   63: goto -26 -> 37
    //   66: astore_2
    //   67: aload_1
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    //   71: aload_1
    //   72: monitorexit
    //   73: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	ParseObject
    //   4	68	1	localObject1	Object
    //   66	4	2	localObject2	Object
    //   36	12	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   7	69	66	finally
    //   71	73	66	finally
  }
  
  static void registerParseSubclasses()
  {
    registerSubclass(ParseUser.class);
    registerSubclass(ParseRole.class);
    registerSubclass(ParseInstallation.class);
    registerSubclass(ParsePin.class);
    registerSubclass(EventuallyPin.class);
  }
  
  public static void registerSubclass(Class<? extends ParseObject> paramClass)
  {
    String str = getClassName(paramClass);
    if (str == null) {
      throw new IllegalArgumentException("No ParseClassName annoation provided on " + paramClass);
    }
    if (paramClass.getDeclaredConstructors().length > 0) {
      try
      {
        if (!isAccessible(paramClass.getDeclaredConstructor(new Class[0]))) {
          throw new IllegalArgumentException("Default constructor for " + paramClass + " is not accessible.");
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        throw new IllegalArgumentException("No default constructor provided for " + paramClass);
      }
    }
    Class localClass = (Class)objectTypes.get(str);
    if ((localClass != null) && (paramClass.isAssignableFrom(localClass))) {}
    for (;;)
    {
      return;
      objectTypes.put(str, paramClass);
      if ((localClass != null) && (!paramClass.equals(localClass))) {
        if (str.equals(getClassName(ParseUser.class))) {
          ParseUser.clearCurrentUserFromMemory();
        } else if (str.equals(getClassName(ParseInstallation.class))) {
          ParseInstallation.clearCurrentInstallationFromMemory();
        }
      }
    }
  }
  
  public static <T extends ParseObject> void saveAll(List<T> paramList)
  {
    Parse.waitForTask(saveAllInBackground(paramList));
  }
  
  public static <T extends ParseObject> m<Void> saveAllInBackground(List<T> paramList)
  {
    return deepSaveAsync(paramList, ParseUser.getCurrentSessionToken());
  }
  
  public static <T extends ParseObject> void saveAllInBackground(List<T> paramList, SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(saveAllInBackground(paramList), paramSaveCallback);
  }
  
  private void setObjectIdInternal(String paramString)
  {
    synchronized (this.mutex)
    {
      String str = this.objectId;
      OfflineStore localOfflineStore = OfflineStore.getCurrent();
      if (localOfflineStore != null) {
        localOfflineStore.updateObjectId(this, str, paramString);
      }
      this.objectId = paramString;
      if (this.localId != null)
      {
        LocalIdManager.getDefaultInstance().setObjectId(this.localId, this.objectId);
        this.localId = null;
      }
      return;
    }
  }
  
  public static void unpinAll()
  {
    Parse.waitForTask(unpinAllInBackground());
  }
  
  public static void unpinAll(String paramString)
  {
    Parse.waitForTask(unpinAllInBackground(paramString));
  }
  
  public static <T extends ParseObject> void unpinAll(String paramString, List<T> paramList)
  {
    Parse.waitForTask(unpinAllInBackground(paramString, paramList));
  }
  
  public static <T extends ParseObject> void unpinAll(List<T> paramList)
  {
    Parse.waitForTask(unpinAllInBackground("_default", paramList));
  }
  
  public static m<Void> unpinAllInBackground()
  {
    return unpinAllInBackground("_default");
  }
  
  public static m<Void> unpinAllInBackground(String paramString)
  {
    return ParsePin.unpinAllObjectsAsync(paramString);
  }
  
  public static <T extends ParseObject> m<Void> unpinAllInBackground(String paramString, List<T> paramList)
  {
    return ParsePin.unpinAllObjectsAsync(paramString, paramList);
  }
  
  public static <T extends ParseObject> m<Void> unpinAllInBackground(List<T> paramList)
  {
    return unpinAllInBackground("_default", paramList);
  }
  
  public static void unpinAllInBackground(DeleteCallback paramDeleteCallback)
  {
    Parse.callbackOnMainThreadAsync(unpinAllInBackground(), paramDeleteCallback);
  }
  
  public static void unpinAllInBackground(String paramString, DeleteCallback paramDeleteCallback)
  {
    Parse.callbackOnMainThreadAsync(unpinAllInBackground(paramString), paramDeleteCallback);
  }
  
  public static <T extends ParseObject> void unpinAllInBackground(String paramString, List<T> paramList, DeleteCallback paramDeleteCallback)
  {
    Parse.callbackOnMainThreadAsync(unpinAllInBackground(paramString, paramList), paramDeleteCallback);
  }
  
  public static <T extends ParseObject> void unpinAllInBackground(List<T> paramList, DeleteCallback paramDeleteCallback)
  {
    Parse.callbackOnMainThreadAsync(unpinAllInBackground("_default", paramList), paramDeleteCallback);
  }
  
  static void unregisterSubclass(String paramString)
  {
    objectTypes.remove(paramString);
  }
  
  public void add(String paramString, Object paramObject)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramObject;
    addAll(paramString, Arrays.asList(arrayOfObject));
  }
  
  public void addAll(String paramString, Collection<?> paramCollection)
  {
    performOperation(paramString, new ParseAddOperation(paramCollection));
  }
  
  public void addAllUnique(String paramString, Collection<?> paramCollection)
  {
    performOperation(paramString, new ParseAddUniqueOperation(paramCollection));
  }
  
  void addToHashedObjects(Object paramObject)
  {
    synchronized (this.mutex)
    {
      try
      {
        this.hashedObjects.put(paramObject, new ParseJSONCacheItem(paramObject));
        return;
      }
      catch (JSONException localJSONException)
      {
        throw new IllegalArgumentException("Couldn't serialize container value to JSON.");
      }
    }
  }
  
  public void addUnique(String paramString, Object paramObject)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramObject;
    addAllUnique(paramString, Arrays.asList(arrayOfObject));
  }
  
  /* Error */
  void checkForChangesToMutableContainers()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 127	com/parse/ParseObject:mutex	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 195	com/parse/ParseObject:estimatedData	Ljava/util/Map;
    //   11: invokeinterface 1000 1 0
    //   16: invokeinterface 303 1 0
    //   21: astore_3
    //   22: aload_3
    //   23: invokeinterface 308 1 0
    //   28: ifeq +39 -> 67
    //   31: aload_3
    //   32: invokeinterface 311 1 0
    //   37: checkcast 140	java/lang/String
    //   40: astore 5
    //   42: aload_0
    //   43: aload 5
    //   45: aload_0
    //   46: getfield 195	com/parse/ParseObject:estimatedData	Ljava/util/Map;
    //   49: aload 5
    //   51: invokeinterface 166 2 0
    //   56: invokespecial 1002	com/parse/ParseObject:checkForChangesToMutableContainer	(Ljava/lang/String;Ljava/lang/Object;)V
    //   59: goto -37 -> 22
    //   62: astore_2
    //   63: aload_1
    //   64: monitorexit
    //   65: aload_2
    //   66: athrow
    //   67: aload_0
    //   68: getfield 200	com/parse/ParseObject:hashedObjects	Ljava/util/Map;
    //   71: invokeinterface 1000 1 0
    //   76: aload_0
    //   77: getfield 195	com/parse/ParseObject:estimatedData	Ljava/util/Map;
    //   80: invokeinterface 399 1 0
    //   85: invokeinterface 1006 2 0
    //   90: pop
    //   91: aload_1
    //   92: monitorexit
    //   93: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	ParseObject
    //   4	88	1	localObject1	Object
    //   62	4	2	localObject2	Object
    //   21	11	3	localIterator	Iterator
    //   40	10	5	str	String
    // Exception table:
    //   from	to	target	type
    //   7	65	62	finally
    //   67	93	62	finally
  }
  
  ParseCommand constructSaveCommand(ParseOperationSet paramParseOperationSet, ParseObjectEncodingStrategy paramParseObjectEncodingStrategy, String paramString)
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        JSONObject localJSONObject = toJSONObjectForSaving(paramParseOperationSet, paramParseObjectEncodingStrategy);
        if (this.objectId == null)
        {
          str = "create";
          ParseCommand localParseCommand = new ParseCommand(str, paramString);
          localParseCommand.enableRetrying();
          localParseCommand.put("classname", this.className);
          try
          {
            localParseCommand.put("data", localJSONObject.getJSONObject("data"));
            return localParseCommand;
          }
          catch (JSONException localJSONException)
          {
            throw new RuntimeException("could not decode data");
          }
        }
      }
      String str = "update";
    }
  }
  
  public boolean containsKey(String paramString)
  {
    synchronized (this.mutex)
    {
      boolean bool = this.estimatedData.containsKey(paramString);
      return bool;
    }
  }
  
  /* Error */
  void copyChangesFrom(ParseObject paramParseObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 127	com/parse/ParseObject:mutex	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: getfield 187	com/parse/ParseObject:operationSetQueue	Ljava/util/LinkedList;
    //   11: invokevirtual 1024	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   14: checkcast 189	com/parse/ParseOperationSet
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 297	com/parse/ParseOperationSet:keySet	()Ljava/util/Set;
    //   24: invokeinterface 303 1 0
    //   29: astore 5
    //   31: aload 5
    //   33: invokeinterface 308 1 0
    //   38: ifeq +39 -> 77
    //   41: aload 5
    //   43: invokeinterface 311 1 0
    //   48: checkcast 140	java/lang/String
    //   51: astore 6
    //   53: aload_0
    //   54: aload 6
    //   56: aload 4
    //   58: aload 6
    //   60: invokevirtual 312	com/parse/ParseOperationSet:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 314	com/parse/ParseFieldOperation
    //   66: invokevirtual 383	com/parse/ParseObject:performOperation	(Ljava/lang/String;Lcom/parse/ParseFieldOperation;)V
    //   69: goto -38 -> 31
    //   72: astore_3
    //   73: aload_2
    //   74: monitorexit
    //   75: aload_3
    //   76: athrow
    //   77: aload_2
    //   78: monitorexit
    //   79: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	ParseObject
    //   0	80	1	paramParseObject	ParseObject
    //   4	74	2	localObject1	Object
    //   72	4	3	localObject2	Object
    //   17	40	4	localParseOperationSet	ParseOperationSet
    //   29	13	5	localIterator	Iterator
    //   51	8	6	str	String
    // Exception table:
    //   from	to	target	type
    //   7	75	72	finally
    //   77	79	72	finally
  }
  
  public final void delete()
  {
    Parse.waitForTask(deleteInBackground());
  }
  
  m<Object> deleteAsync(String paramString)
  {
    return constructDeleteCommand(true, paramString).executeAsync();
  }
  
  public final m<Void> deleteEventually()
  {
    for (;;)
    {
      m localm2;
      synchronized (this.mutex)
      {
        validateDelete();
        this.isDeletingEventually = (1 + this.isDeletingEventually);
        if (getObjectId() != null) {
          break label153;
        }
        str = getOrCreateLocalId();
        OfflineStore localOfflineStore = OfflineStore.getCurrent();
        if (localOfflineStore != null)
        {
          m localm4 = localOfflineStore.updateDataForObjectAsync(this);
          localm1 = localm4;
        }
        try
        {
          ParseCommand localParseCommand = constructDeleteCommand(false, ParseUser.getCurrentSessionToken());
          localParseCommand.setLocalId(str);
          localm2 = localm1.b(new ParseObject.16(this, localParseCommand));
          if (!OfflineStore.isEnabled()) {
            break label135;
          }
          localm3 = localm2.j();
          return localm3;
        }
        catch (ParseException localParseException)
        {
          throw new IllegalStateException("Cannot deleteEventually this object.", localParseException);
        }
        m localm1 = m.a(null);
      }
      label135:
      m localm3 = localm2.d(new ParseObject.17(this));
      continue;
      label153:
      String str = null;
    }
  }
  
  public final void deleteEventually(DeleteCallback paramDeleteCallback)
  {
    Parse.callbackOnMainThreadAsync(deleteEventually(), paramDeleteCallback);
  }
  
  public final m<Void> deleteInBackground()
  {
    return this.taskQueue.enqueue(new ParseObject.33(this));
  }
  
  public final void deleteInBackground(DeleteCallback paramDeleteCallback)
  {
    Parse.callbackOnMainThreadAsync(deleteInBackground(), paramDeleteCallback);
  }
  
  public <T extends ParseObject> T fetch()
  {
    return (ParseObject)Parse.waitForTask(fetchInBackground());
  }
  
  <T extends ParseObject> m<T> fetchAsync(m<Void> paramm)
  {
    return m.b(new ParseObject.27(this, ParseUser.getCurrentSessionToken())).d(TaskQueue.waitFor(paramm)).d(new ParseObject.26(this)).d(new ParseObject.25(this)).c(new ParseObject.24(this));
  }
  
  public void fetchFromLocalDatastore()
  {
    Parse.waitForTask(fetchFromLocalDatastoreAsync());
  }
  
  <T extends ParseObject> m<T> fetchFromLocalDatastoreAsync()
  {
    OfflineStore localOfflineStore = OfflineStore.getCurrent();
    if (localOfflineStore == null) {
      throw new RuntimeException("You must enable the local datastore before calling fetchFromLocalDatastore().");
    }
    return localOfflineStore.fetchLocallyAsync(this);
  }
  
  public <T extends ParseObject> void fetchFromLocalDatastoreInBackground(GetCallback<T> paramGetCallback)
  {
    Parse.callbackOnMainThreadAsync(fetchFromLocalDatastoreAsync(), paramGetCallback);
  }
  
  public <T extends ParseObject> T fetchIfNeeded()
  {
    return (ParseObject)Parse.waitForTask(fetchIfNeededInBackground());
  }
  
  public final <T extends ParseObject> m<T> fetchIfNeededInBackground()
  {
    m localm;
    synchronized (this.mutex)
    {
      if (isDataAvailable()) {
        localm = m.a(this);
      } else {
        localm = fetchInBackground();
      }
    }
    return localm;
  }
  
  public final <T extends ParseObject> void fetchIfNeededInBackground(GetCallback<T> paramGetCallback)
  {
    Parse.callbackOnMainThreadAsync(fetchIfNeededInBackground(), paramGetCallback);
  }
  
  public final <T extends ParseObject> m<T> fetchInBackground()
  {
    return this.taskQueue.enqueue(new ParseObject.28(this));
  }
  
  public final <T extends ParseObject> void fetchInBackground(GetCallback<T> paramGetCallback)
  {
    Parse.callbackOnMainThreadAsync(fetchInBackground(), paramGetCallback);
  }
  
  public Object get(String paramString)
  {
    Object localObject3;
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      localObject3 = this.estimatedData.get(paramString);
      if (((localObject3 instanceof ParseACL)) && (paramString.equals("ACL")))
      {
        ParseACL localParseACL1 = (ParseACL)localObject3;
        if (localParseACL1.isShared())
        {
          ParseACL localParseACL2 = localParseACL1.copy();
          this.estimatedData.put("ACL", localParseACL2);
          addToHashedObjects(localParseACL2);
          localObject3 = getACL();
          break label124;
        }
      }
      if ((localObject3 instanceof ParseRelation)) {
        ((ParseRelation)localObject3).ensureParentAndKey(this, paramString);
      }
    }
    label124:
    return localObject3;
  }
  
  public ParseACL getACL()
  {
    return getACL(true);
  }
  
  public boolean getBoolean(String paramString)
  {
    boolean bool;
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      Object localObject3 = this.estimatedData.get(paramString);
      if (!(localObject3 instanceof Boolean)) {
        bool = false;
      } else {
        bool = ((Boolean)localObject3).booleanValue();
      }
    }
    return bool;
  }
  
  public byte[] getBytes(String paramString)
  {
    byte[] arrayOfByte;
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      Object localObject3 = this.estimatedData.get(paramString);
      if (!(localObject3 instanceof byte[])) {
        arrayOfByte = null;
      } else {
        arrayOfByte = (byte[])localObject3;
      }
    }
    return arrayOfByte;
  }
  
  public String getClassName()
  {
    synchronized (this.mutex)
    {
      String str = this.className;
      return str;
    }
  }
  
  public Date getCreatedAt()
  {
    synchronized (this.mutex)
    {
      Date localDate = this.createdAt;
      return localDate;
    }
  }
  
  public Date getDate(String paramString)
  {
    Date localDate;
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      Object localObject3 = this.estimatedData.get(paramString);
      if (!(localObject3 instanceof Date)) {
        localDate = null;
      } else {
        localDate = (Date)localObject3;
      }
    }
    return localDate;
  }
  
  public double getDouble(String paramString)
  {
    Number localNumber = getNumber(paramString);
    if (localNumber == null) {}
    for (double d = 0.0D;; d = localNumber.doubleValue()) {
      return d;
    }
  }
  
  public int getInt(String paramString)
  {
    Number localNumber = getNumber(paramString);
    if (localNumber == null) {}
    for (int i = 0;; i = localNumber.intValue()) {
      return i;
    }
  }
  
  public JSONArray getJSONArray(String paramString)
  {
    JSONArray localJSONArray;
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      Object localObject3 = this.estimatedData.get(paramString);
      if ((localObject3 instanceof List))
      {
        localObject3 = Parse.encode(localObject3, PointerOrLocalIdEncodingStrategy.get());
        put(paramString, localObject3);
      }
      if (!(localObject3 instanceof JSONArray)) {
        localJSONArray = null;
      } else {
        localJSONArray = (JSONArray)localObject3;
      }
    }
    return localJSONArray;
  }
  
  public JSONObject getJSONObject(String paramString)
  {
    JSONObject localJSONObject;
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      Object localObject3 = this.estimatedData.get(paramString);
      if ((localObject3 instanceof Map))
      {
        localObject3 = Parse.encode(localObject3, PointerOrLocalIdEncodingStrategy.get());
        put(paramString, localObject3);
      }
      if (!(localObject3 instanceof JSONObject)) {
        localJSONObject = null;
      } else {
        localJSONObject = (JSONObject)localObject3;
      }
    }
    return localJSONObject;
  }
  
  public <T> List<T> getList(String paramString)
  {
    List localList;
    synchronized (this.mutex)
    {
      Object localObject3 = this.estimatedData.get(paramString);
      if ((localObject3 instanceof JSONArray))
      {
        localObject3 = new ParseDecoder().convertJSONArrayToList((JSONArray)localObject3);
        put(paramString, localObject3);
      }
      if (!(localObject3 instanceof List)) {
        localList = null;
      } else {
        localList = (List)localObject3;
      }
    }
    return localList;
  }
  
  public long getLong(String paramString)
  {
    Number localNumber = getNumber(paramString);
    if (localNumber == null) {}
    for (long l = 0L;; l = localNumber.longValue()) {
      return l;
    }
  }
  
  public <V> Map<String, V> getMap(String paramString)
  {
    Map localMap;
    synchronized (this.mutex)
    {
      Object localObject3 = this.estimatedData.get(paramString);
      if ((localObject3 instanceof JSONObject))
      {
        localObject3 = new ParseDecoder().convertJSONObjectToMap((JSONObject)localObject3);
        put(paramString, localObject3);
      }
      if (!(localObject3 instanceof Map)) {
        localMap = null;
      } else {
        localMap = (Map)localObject3;
      }
    }
    return localMap;
  }
  
  public Number getNumber(String paramString)
  {
    Number localNumber;
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      Object localObject3 = this.estimatedData.get(paramString);
      if (!(localObject3 instanceof Number)) {
        localNumber = null;
      } else {
        localNumber = (Number)localObject3;
      }
    }
    return localNumber;
  }
  
  public String getObjectId()
  {
    synchronized (this.mutex)
    {
      String str = this.objectId;
      return str;
    }
  }
  
  /* Error */
  String getOrCreateLocalId()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 127	com/parse/ParseObject:mutex	Ljava/lang/Object;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 177	com/parse/ParseObject:localId	Ljava/lang/String;
    //   13: ifnonnull +41 -> 54
    //   16: aload_0
    //   17: getfield 221	com/parse/ParseObject:objectId	Ljava/lang/String;
    //   20: ifnull +24 -> 44
    //   23: new 391	java/lang/IllegalStateException
    //   26: dup
    //   27: ldc_w 1178
    //   30: invokespecial 394	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   33: athrow
    //   34: astore_3
    //   35: aload_2
    //   36: monitorexit
    //   37: aload_3
    //   38: athrow
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    //   44: aload_0
    //   45: invokestatic 955	com/parse/LocalIdManager:getDefaultInstance	()Lcom/parse/LocalIdManager;
    //   48: invokevirtual 1181	com/parse/LocalIdManager:createLocalId	()Ljava/lang/String;
    //   51: putfield 177	com/parse/ParseObject:localId	Ljava/lang/String;
    //   54: aload_0
    //   55: getfield 177	com/parse/ParseObject:localId	Ljava/lang/String;
    //   58: astore 4
    //   60: aload_2
    //   61: monitorexit
    //   62: aload_0
    //   63: monitorexit
    //   64: aload 4
    //   66: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	ParseObject
    //   39	4	1	localObject1	Object
    //   6	55	2	localObject2	Object
    //   34	4	3	localObject3	Object
    //   58	7	4	str	String
    // Exception table:
    //   from	to	target	type
    //   9	37	34	finally
    //   44	62	34	finally
    //   2	9	39	finally
    //   37	39	39	finally
  }
  
  public ParseFile getParseFile(String paramString)
  {
    Object localObject = get(paramString);
    if (!(localObject instanceof ParseFile)) {}
    for (ParseFile localParseFile = null;; localParseFile = (ParseFile)localObject) {
      return localParseFile;
    }
  }
  
  public ParseGeoPoint getParseGeoPoint(String paramString)
  {
    ParseGeoPoint localParseGeoPoint;
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      Object localObject3 = this.estimatedData.get(paramString);
      if (!(localObject3 instanceof ParseGeoPoint)) {
        localParseGeoPoint = null;
      } else {
        localParseGeoPoint = (ParseGeoPoint)localObject3;
      }
    }
    return localParseGeoPoint;
  }
  
  public ParseObject getParseObject(String paramString)
  {
    Object localObject = get(paramString);
    if (!(localObject instanceof ParseObject)) {}
    for (ParseObject localParseObject = null;; localParseObject = (ParseObject)localObject) {
      return localParseObject;
    }
  }
  
  public ParseUser getParseUser(String paramString)
  {
    Object localObject = get(paramString);
    if (!(localObject instanceof ParseUser)) {}
    for (ParseUser localParseUser = null;; localParseUser = (ParseUser)localObject) {
      return localParseUser;
    }
  }
  
  public <T extends ParseObject> ParseRelation<T> getRelation(String paramString)
  {
    ParseRelation localParseRelation;
    synchronized (this.mutex)
    {
      Object localObject3 = this.estimatedData.get(paramString);
      if ((localObject3 instanceof ParseRelation))
      {
        localParseRelation = (ParseRelation)localObject3;
        localParseRelation.ensureParentAndKey(this, paramString);
      }
      else
      {
        localParseRelation = new ParseRelation(this, paramString);
        this.estimatedData.put(paramString, localParseRelation);
      }
    }
    return localParseRelation;
  }
  
  public String getString(String paramString)
  {
    String str;
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      Object localObject3 = this.estimatedData.get(paramString);
      if (!(localObject3 instanceof String)) {
        str = null;
      } else {
        str = (String)localObject3;
      }
    }
    return str;
  }
  
  public Date getUpdatedAt()
  {
    synchronized (this.mutex)
    {
      Date localDate = this.updatedAt;
      return localDate;
    }
  }
  
  m<Void> handleDeleteEventuallyResultAsync(Object paramObject)
  {
    synchronized (this.mutex)
    {
      this.isDeletingEventually = (-1 + this.isDeletingEventually);
      return handleDeleteResultAsync(paramObject).d(new ParseObject.18(this, paramObject));
    }
  }
  
  m<Void> handleFetchResultAsync(JSONObject paramJSONObject)
  {
    m localm1 = m.a((Void)null);
    Map localMap = collectFetchedObjects();
    OfflineStore localOfflineStore = OfflineStore.getCurrent();
    if (localOfflineStore != null) {
      localm1 = localm1.d(new ParseObject.20(this, localOfflineStore)).b(new ParseObject.19(this));
    }
    m localm2 = localm1.d(new ParseObject.21(this, localMap, paramJSONObject));
    if (localOfflineStore != null) {
      localm2 = localm2.d(new ParseObject.23(this, localOfflineStore)).b(new ParseObject.22(this));
    }
    return localm2;
  }
  
  m<Void> handleSaveEventuallyResultAsync(JSONObject paramJSONObject, ParseOperationSet paramParseOperationSet)
  {
    return handleSaveResultAsync(paramJSONObject, paramParseOperationSet).d(new ParseObject.15(this));
  }
  
  m<Void> handleSaveResultAsync(JSONObject paramJSONObject, ParseOperationSet paramParseOperationSet)
  {
    m localm1 = m.a((Void)null);
    Map localMap = collectFetchedObjects();
    OfflineStore localOfflineStore = OfflineStore.getCurrent();
    if (localOfflineStore != null) {
      localm1 = localm1.b(new ParseObject.5(this, localOfflineStore));
    }
    m localm2 = localm1.a(new ParseObject.6(this, localMap, paramJSONObject, paramParseOperationSet));
    if (localOfflineStore != null) {
      localm2 = localm2.b(new ParseObject.7(this, localOfflineStore));
    }
    return localm2.a(new ParseObject.8(this));
  }
  
  public boolean has(String paramString)
  {
    return containsKey(paramString);
  }
  
  boolean hasChanges()
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        if (currentOperations().size() > 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  boolean hasOutstandingOperations()
  {
    int j;
    for (int i = 1;; j = 0) {
      synchronized (this.mutex)
      {
        if (this.operationSetQueue.size() > i) {
          return i;
        }
      }
    }
  }
  
  public boolean hasSameId(ParseObject paramParseObject)
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        if ((getClassName() != null) && (getObjectId() != null) && (getClassName().equals(paramParseObject.getClassName())) && (getObjectId().equals(paramParseObject.getObjectId())))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void increment(String paramString)
  {
    increment(paramString, Integer.valueOf(1));
  }
  
  public void increment(String paramString, Number paramNumber)
  {
    performOperation(paramString, new ParseIncrementOperation(paramNumber));
  }
  
  public boolean isDataAvailable()
  {
    synchronized (this.mutex)
    {
      boolean bool = this.hasBeenFetched;
      return bool;
    }
  }
  
  public boolean isDirty()
  {
    return isDirty(true);
  }
  
  public boolean isDirty(String paramString)
  {
    synchronized (this.mutex)
    {
      boolean bool = currentOperations().containsKey(paramString);
      return bool;
    }
  }
  
  boolean isDirty(boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        checkForChangesToMutableContainers();
        if ((!this.isDeleted) && (getObjectId() != null) && (!hasChanges()))
        {
          if ((!paramBoolean) || (!hasDirtyChildren())) {
            break label62;
          }
          break label56;
          return bool;
        }
      }
      label56:
      boolean bool = true;
      continue;
      label62:
      bool = false;
    }
  }
  
  public Set<String> keySet()
  {
    synchronized (this.mutex)
    {
      Set localSet = Collections.unmodifiableSet(this.estimatedData.keySet());
      return localSet;
    }
  }
  
  void mergeAfterFetch(JSONObject paramJSONObject, ParseDecoder paramParseDecoder, boolean paramBoolean)
  {
    synchronized (this.mutex)
    {
      mergeFromServer(paramJSONObject, paramParseDecoder, paramBoolean);
      rebuildEstimatedData();
      checkpointAllMutableContainers();
      return;
    }
  }
  
  /* Error */
  void mergeFromObject(ParseObject paramParseObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 127	com/parse/ParseObject:mutex	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: aload_1
    //   9: getfield 221	com/parse/ParseObject:objectId	Ljava/lang/String;
    //   12: putfield 221	com/parse/ParseObject:objectId	Ljava/lang/String;
    //   15: aload_0
    //   16: aload_1
    //   17: getfield 1123	com/parse/ParseObject:createdAt	Ljava/util/Date;
    //   20: putfield 1123	com/parse/ParseObject:createdAt	Ljava/util/Date;
    //   23: aload_0
    //   24: aload_1
    //   25: getfield 1198	com/parse/ParseObject:updatedAt	Ljava/util/Date;
    //   28: putfield 1198	com/parse/ParseObject:updatedAt	Ljava/util/Date;
    //   31: aload_0
    //   32: getfield 182	com/parse/ParseObject:serverData	Ljava/util/Map;
    //   35: invokeinterface 891 1 0
    //   40: aload_0
    //   41: getfield 182	com/parse/ParseObject:serverData	Ljava/util/Map;
    //   44: aload_1
    //   45: getfield 182	com/parse/ParseObject:serverData	Ljava/util/Map;
    //   48: invokeinterface 895 2 0
    //   53: aload_0
    //   54: getfield 187	com/parse/ParseObject:operationSetQueue	Ljava/util/LinkedList;
    //   57: invokevirtual 1257	java/util/LinkedList:size	()I
    //   60: iconst_1
    //   61: if_icmpeq +19 -> 80
    //   64: new 391	java/lang/IllegalStateException
    //   67: dup
    //   68: ldc_w 1289
    //   71: invokespecial 394	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: astore_3
    //   76: aload_2
    //   77: monitorexit
    //   78: aload_3
    //   79: athrow
    //   80: aload_0
    //   81: getfield 187	com/parse/ParseObject:operationSetQueue	Ljava/util/LinkedList;
    //   84: invokevirtual 1290	java/util/LinkedList:clear	()V
    //   87: aload_0
    //   88: getfield 187	com/parse/ParseObject:operationSetQueue	Ljava/util/LinkedList;
    //   91: new 189	com/parse/ParseOperationSet
    //   94: dup
    //   95: invokespecial 190	com/parse/ParseOperationSet:<init>	()V
    //   98: invokevirtual 193	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   101: pop
    //   102: aload_0
    //   103: invokespecial 873	com/parse/ParseObject:rebuildEstimatedData	()V
    //   106: aload_0
    //   107: invokespecial 875	com/parse/ParseObject:checkpointAllMutableContainers	()V
    //   110: aload_2
    //   111: monitorexit
    //   112: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	ParseObject
    //   0	113	1	paramParseObject	ParseObject
    //   4	107	2	localObject1	Object
    //   75	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	78	75	finally
    //   80	112	75	finally
  }
  
  void mergeFromServer(JSONObject paramJSONObject, ParseDecoder paramParseDecoder, boolean paramBoolean)
  {
    for (boolean bool = false;; bool = true)
    {
      synchronized (this.mutex)
      {
        if ((this.hasBeenFetched) || (paramBoolean)) {
          continue;
        }
        this.hasBeenFetched = bool;
        try
        {
          if ((paramJSONObject.has("id")) && (this.objectId == null)) {
            setObjectIdInternal(paramJSONObject.getString("id"));
          }
          if (paramJSONObject.has("created_at"))
          {
            String str4 = paramJSONObject.getString("created_at");
            if (str4 != null) {
              this.createdAt = impreciseParseDate(str4);
            }
          }
          if (paramJSONObject.has("updated_at"))
          {
            String str3 = paramJSONObject.getString("updated_at");
            if (str3 != null) {
              this.updatedAt = impreciseParseDate(str3);
            }
          }
          if (paramJSONObject.has("pointers"))
          {
            JSONObject localJSONObject2 = paramJSONObject.getJSONObject("pointers");
            Iterator localIterator2 = localJSONObject2.keys();
            while (localIterator2.hasNext())
            {
              String str2 = (String)localIterator2.next();
              JSONArray localJSONArray = localJSONObject2.getJSONArray(str2);
              this.serverData.put(str2, createWithoutData(localJSONArray.optString(0), localJSONArray.optString(1)));
              continue;
              localObject2 = finally;
            }
          }
        }
        catch (JSONException localJSONException)
        {
          throw new RuntimeException(localJSONException);
        }
      }
      if (paramJSONObject.has("data"))
      {
        JSONObject localJSONObject1 = paramJSONObject.getJSONObject("data");
        Iterator localIterator1 = localJSONObject1.keys();
        while (localIterator1.hasNext())
        {
          String str1 = (String)localIterator1.next();
          this.dataAvailability.put(str1, Boolean.valueOf(true));
          if (str1.equals("objectId"))
          {
            setObjectIdInternal(localJSONObject1.getString(str1));
          }
          else if (str1.equals("createdAt"))
          {
            this.createdAt = Parse.stringToDate(localJSONObject1.getString(str1));
          }
          else if (str1.equals("updatedAt"))
          {
            this.updatedAt = Parse.stringToDate(localJSONObject1.getString(str1));
          }
          else if (str1.equals("ACL"))
          {
            ParseACL localParseACL = ParseACL.createACLFromJSONObject(localJSONObject1.getJSONObject(str1), paramParseDecoder);
            this.serverData.put("ACL", localParseACL);
            addToHashedObjects(localParseACL);
          }
          else if ((!str1.equals("__type")) && (!str1.equals("className")))
          {
            Object localObject3 = paramParseDecoder.decode(localJSONObject1.get(str1));
            if (Parse.isContainerObject(localObject3)) {
              addToHashedObjects(localObject3);
            }
            this.serverData.put(str1, localObject3);
          }
        }
      }
      if ((this.updatedAt == null) && (this.createdAt != null)) {
        this.updatedAt = this.createdAt;
      }
      rebuildEstimatedData();
      checkpointAllMutableContainers();
      return;
    }
  }
  
  void mergeREST(JSONObject paramJSONObject, ParseDecoder paramParseDecoder)
  {
    ArrayList localArrayList = new ArrayList();
    String str;
    for (;;)
    {
      synchronized (this.mutex)
      {
        try
        {
          Iterator localIterator1 = paramJSONObject.keys();
          if (!localIterator1.hasNext()) {
            break label486;
          }
          str = (String)localIterator1.next();
          this.dataAvailability.put(str, Boolean.valueOf(true));
          if ((str.equals("__type")) || (str.equals("className"))) {
            continue;
          }
          if (str.equals("objectId"))
          {
            setObjectIdInternal(paramJSONObject.getString(str));
            continue;
            localObject2 = finally;
          }
        }
        catch (JSONException localJSONException)
        {
          throw new RuntimeException(localJSONException);
        }
      }
      if (str.equals("createdAt"))
      {
        this.createdAt = Parse.stringToDate(paramJSONObject.getString(str));
      }
      else if (str.equals("updatedAt"))
      {
        this.updatedAt = Parse.stringToDate(paramJSONObject.getString(str));
      }
      else if (str.equals("isDeletingEventually"))
      {
        this.isDeletingEventually = paramJSONObject.getInt(str);
      }
      else if (str.equals("ACL"))
      {
        ParseACL localParseACL = ParseACL.createACLFromJSONObject(paramJSONObject.getJSONObject(str), paramParseDecoder);
        this.serverData.put("ACL", localParseACL);
        addToHashedObjects(localParseACL);
      }
      else if (str.equals("__complete"))
      {
        if (this.hasBeenFetched) {
          break label554;
        }
        if (!paramJSONObject.getBoolean(str)) {
          break label560;
        }
        break label554;
      }
    }
    int i;
    Object localObject4;
    ParseOperationSet localParseOperationSet2;
    for (;;)
    {
      this.hasBeenFetched = bool;
      break;
      if (str.equals("__operations"))
      {
        ParseOperationSet localParseOperationSet1 = currentOperations();
        JSONArray localJSONArray = paramJSONObject.getJSONArray("__operations");
        if (localJSONArray != null)
        {
          this.operationSetQueue.clear();
          i = 0;
          localObject4 = null;
          if (i < localJSONArray.length())
          {
            localParseOperationSet2 = ParseOperationSet.fromRest(localJSONArray.getJSONObject(i), paramParseDecoder);
            if (localParseOperationSet2.isSaveEventually())
            {
              if (localObject4 != null)
              {
                this.operationSetQueue.add(localObject4);
                localObject4 = null;
              }
              localArrayList.add(localParseOperationSet2);
              this.operationSetQueue.add(localParseOperationSet2);
              break label566;
            }
            if (localObject4 == null) {
              break label572;
            }
            localParseOperationSet2.mergeFrom(localObject4);
            break label572;
          }
          if (localObject4 != null) {
            this.operationSetQueue.add(localObject4);
          }
        }
        currentOperations().mergeFrom(localParseOperationSet1);
        break;
      }
      Object localObject3 = paramParseDecoder.decode(paramJSONObject.get(str));
      if (Parse.isContainerObject(localObject3)) {
        addToHashedObjects(localObject3);
      }
      this.serverData.put(str, localObject3);
      break;
      label486:
      if ((this.updatedAt == null) && (this.createdAt != null)) {
        this.updatedAt = this.createdAt;
      }
      rebuildEstimatedData();
      checkpointAllMutableContainers();
      Iterator localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext()) {
        enqueueSaveEventuallyOperationAsync((ParseOperationSet)localIterator2.next());
      }
      return;
      label554:
      boolean bool = true;
      continue;
      label560:
      bool = false;
    }
    for (;;)
    {
      label566:
      i++;
      break;
      label572:
      localObject4 = localParseOperationSet2;
    }
  }
  
  boolean needsDefaultACL()
  {
    return true;
  }
  
  void performOperation(String paramString, ParseFieldOperation paramParseFieldOperation)
  {
    synchronized (this.mutex)
    {
      Object localObject3 = paramParseFieldOperation.apply(this.estimatedData.get(paramString), this, paramString);
      if (localObject3 != null)
      {
        this.estimatedData.put(paramString, localObject3);
        ParseFieldOperation localParseFieldOperation = paramParseFieldOperation.mergeWithPrevious((ParseFieldOperation)currentOperations().get(paramString));
        currentOperations().put(paramString, localParseFieldOperation);
        checkpointMutableContainer(localObject3);
        this.dataAvailability.put(paramString, Boolean.TRUE);
        return;
      }
      this.estimatedData.remove(paramString);
    }
  }
  
  public void pin()
  {
    Parse.waitForTask(pinInBackground());
  }
  
  public void pin(String paramString)
  {
    Parse.waitForTask(pinInBackground(paramString));
  }
  
  public m<Void> pinInBackground()
  {
    ParseObject[] arrayOfParseObject = new ParseObject[1];
    arrayOfParseObject[0] = this;
    return pinAllInBackground("_default", Arrays.asList(arrayOfParseObject));
  }
  
  public m<Void> pinInBackground(String paramString)
  {
    ParseObject[] arrayOfParseObject = new ParseObject[1];
    arrayOfParseObject[0] = this;
    return pinAllInBackground(paramString, Arrays.asList(arrayOfParseObject));
  }
  
  public void pinInBackground(SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(pinInBackground(), paramSaveCallback);
  }
  
  public void pinInBackground(String paramString, SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(pinInBackground(paramString), paramSaveCallback);
  }
  
  public void put(String paramString, Object paramObject)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("key may not be null.");
    }
    if (paramObject == null) {
      throw new IllegalArgumentException("value may not be null.");
    }
    if (!Parse.isValidType(paramObject)) {
      throw new IllegalArgumentException("invalid type for value: " + paramObject.getClass().toString());
    }
    performOperation(paramString, new ParseSetOperation(paramObject));
  }
  
  @Deprecated
  public final void refresh()
  {
    fetch();
  }
  
  @Deprecated
  public final void refreshInBackground(RefreshCallback paramRefreshCallback)
  {
    Parse.callbackOnMainThreadAsync(fetchInBackground(), paramRefreshCallback);
  }
  
  void registerSaveListener(GetCallback<ParseObject> paramGetCallback)
  {
    synchronized (this.mutex)
    {
      this.saveEvent.subscribe(paramGetCallback);
      return;
    }
  }
  
  public void remove(String paramString)
  {
    synchronized (this.mutex)
    {
      if (get(paramString) != null) {
        performOperation(paramString, ParseDeleteOperation.getInstance());
      }
      return;
    }
  }
  
  public void removeAll(String paramString, Collection<?> paramCollection)
  {
    performOperation(paramString, new ParseRemoveOperation(paramCollection));
  }
  
  void revert()
  {
    synchronized (this.mutex)
    {
      currentOperations().clear();
      rebuildEstimatedData();
      checkpointAllMutableContainers();
      return;
    }
  }
  
  public final void save()
  {
    Parse.waitForTask(saveInBackground());
  }
  
  m<Object> saveAsync(ParseOperationSet paramParseOperationSet, String paramString)
  {
    return constructSaveCommand(paramParseOperationSet, PointerEncodingStrategy.get(), paramString).executeAsync();
  }
  
  m<Void> saveAsync(m<Void> paramm)
  {
    if (!isDirty()) {}
    k localk;
    String str;
    for (m localm = m.a(null);; localm = m.a(null).d(new ParseObject.12(this, localk)).d(new ParseObject.11(this, str)).d(TaskQueue.waitFor(paramm)).d(new ParseObject.10(this, localk, str)))
    {
      return localm;
      localk = new k();
      str = ParseUser.getCurrentSessionToken();
    }
  }
  
  public final m<Void> saveEventually()
  {
    String str1 = null;
    m localm2;
    if (!isDirty())
    {
      Parse.getEventuallyQueue().fakeObjectUpdate();
      localm2 = m.a(null);
    }
    for (;;)
    {
      return localm2;
      ParseOperationSet localParseOperationSet;
      ParseCommand localParseCommand;
      synchronized (this.mutex)
      {
        updateBeforeSave();
        ArrayList localArrayList = new ArrayList();
        findUnsavedChildren(this.estimatedData, localArrayList);
        if (getObjectId() == null) {
          str1 = getOrCreateLocalId();
        }
        localParseOperationSet = startSave();
        localParseOperationSet.setIsSaveEventually(true);
        String str2 = ParseUser.getCurrentSessionToken();
        try
        {
          localParseCommand = constructSaveCommand(localParseOperationSet, PointerOrLocalIdEncodingStrategy.get(), str2);
          localParseCommand.setLocalId(str1);
          localParseCommand.setOperationSetUUID(localParseOperationSet.getUUID());
          localParseCommand.retainLocalIds();
          Iterator localIterator = localArrayList.iterator();
          while (localIterator.hasNext())
          {
            ((ParseObject)localIterator.next()).saveEventually();
            continue;
            localObject2 = finally;
          }
        }
        catch (ParseException localParseException)
        {
          throw new IllegalStateException("Unable to saveEventually.", localParseException);
        }
      }
      m localm1 = Parse.getEventuallyQueue().enqueueEventuallyAsync(localParseCommand, this);
      enqueueSaveEventuallyOperationAsync(localParseOperationSet);
      localParseCommand.releaseLocalIds();
      if (OfflineStore.isEnabled()) {
        localm2 = localm1.j();
      } else {
        localm2 = localm1.d(new ParseObject.13(this, localParseOperationSet));
      }
    }
  }
  
  public final void saveEventually(SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(saveEventually(), paramSaveCallback);
  }
  
  public final m<Void> saveInBackground()
  {
    return this.taskQueue.enqueue(new ParseObject.9(this));
  }
  
  public final void saveInBackground(SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(saveInBackground(), paramSaveCallback);
  }
  
  void saveToDisk(Context paramContext, String paramString)
  {
    if (OfflineStore.isEnabled()) {
      throw new IllegalStateException("ParseObject#saveToDisk is not allowed when OfflineStore is enabled");
    }
    synchronized (this.mutex)
    {
      Parse.saveDiskObject(paramContext, paramString, toJSONObjectForDataFile(false, PointerEncodingStrategy.get()));
      return;
    }
  }
  
  public void setACL(ParseACL paramParseACL)
  {
    put("ACL", paramParseACL);
  }
  
  void setDefaultValues()
  {
    if ((needsDefaultACL()) && (ParseACL.getDefaultACL() != null)) {
      setACL(ParseACL.getDefaultACL());
    }
  }
  
  public void setObjectId(String paramString)
  {
    synchronized (this.mutex)
    {
      setObjectIdInternal(paramString);
      return;
    }
  }
  
  ParseOperationSet startSave()
  {
    synchronized (this.mutex)
    {
      ParseOperationSet localParseOperationSet = currentOperations();
      this.operationSetQueue.addLast(new ParseOperationSet());
      return localParseOperationSet;
    }
  }
  
  JSONObject toJSONObjectForDataFile(boolean paramBoolean, ParseObjectEncodingStrategy paramParseObjectEncodingStrategy)
  {
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    for (;;)
    {
      String str2;
      Object localObject3;
      synchronized (this.mutex)
      {
        checkForChangesToMutableContainers();
        localJSONObject1 = new JSONObject();
        localJSONObject2 = new JSONObject();
        try
        {
          Iterator localIterator1 = this.serverData.keySet().iterator();
          if (!localIterator1.hasNext()) {
            break;
          }
          str2 = (String)localIterator1.next();
          localObject3 = this.serverData.get(str2);
          if ((Parse.isContainerObject(localObject3)) && (this.hashedObjects.containsKey(localObject3)))
          {
            localJSONObject2.put(str2, ((ParseJSONCacheItem)this.hashedObjects.get(localObject3)).getJSONObject());
            continue;
            localObject2 = finally;
          }
        }
        catch (JSONException localJSONException)
        {
          throw new RuntimeException("could not serialize object to JSON");
        }
      }
      localJSONObject2.put(str2, Parse.encode(localObject3, paramParseObjectEncodingStrategy));
    }
    if (this.createdAt != null) {
      localJSONObject2.put("createdAt", Parse.dateToString(this.createdAt));
    }
    if (this.updatedAt != null) {
      localJSONObject2.put("updatedAt", Parse.dateToString(this.updatedAt));
    }
    if (this.objectId != null) {
      localJSONObject2.put("objectId", this.objectId);
    }
    localJSONObject1.put("data", localJSONObject2);
    localJSONObject1.put("classname", this.className);
    if (paramBoolean)
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator2 = this.operationSetQueue.iterator();
      while (localIterator2.hasNext())
      {
        ParseOperationSet localParseOperationSet = (ParseOperationSet)localIterator2.next();
        JSONObject localJSONObject3 = new JSONObject();
        Iterator localIterator3 = localParseOperationSet.keySet().iterator();
        while (localIterator3.hasNext())
        {
          String str1 = (String)localIterator3.next();
          localJSONObject3.put(str1, ((ParseFieldOperation)localParseOperationSet.get(str1)).encode(paramParseObjectEncodingStrategy));
        }
        localJSONArray.put(localJSONObject3);
      }
      localJSONObject1.put("operations", localJSONArray);
    }
    return localJSONObject1;
  }
  
  JSONObject toJSONObjectForSaving(ParseOperationSet paramParseOperationSet, ParseObjectEncodingStrategy paramParseObjectEncodingStrategy)
  {
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    synchronized (this.mutex)
    {
      localJSONObject1 = new JSONObject();
      localJSONObject2 = new JSONObject();
      try
      {
        Iterator localIterator = paramParseOperationSet.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ParseFieldOperation localParseFieldOperation = (ParseFieldOperation)paramParseOperationSet.get(str);
          localJSONObject2.put(str, Parse.encode(localParseFieldOperation, paramParseObjectEncodingStrategy));
          if ((localParseFieldOperation instanceof ParseSetOperation))
          {
            Object localObject3 = ((ParseSetOperation)localParseFieldOperation).getValue();
            if ((Parse.isContainerObject(localObject3)) && (this.hashedObjects.containsKey(localObject3)))
            {
              this.hashedObjects.put(localObject3, new ParseJSONCacheItem(localObject3));
              continue;
              localObject2 = finally;
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
        throw new RuntimeException("could not serialize object to JSON");
      }
    }
    if (this.objectId != null) {
      localJSONObject2.put("objectId", this.objectId);
    }
    localJSONObject1.put("data", localJSONObject2);
    localJSONObject1.put("classname", this.className);
    return localJSONObject1;
  }
  
  JSONObject toRest(ParseObjectEncodingStrategy paramParseObjectEncodingStrategy)
  {
    JSONObject localJSONObject;
    synchronized (this.mutex)
    {
      checkForChangesToMutableContainers();
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("className", this.className);
        Iterator localIterator1 = this.serverData.keySet().iterator();
        while (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          localJSONObject.put(str, Parse.encode(this.serverData.get(str), paramParseObjectEncodingStrategy));
          continue;
          localObject2 = finally;
        }
      }
      catch (JSONException localJSONException)
      {
        throw new RuntimeException("could not serialize object to JSON");
      }
    }
    if (this.objectId != null) {
      localJSONObject.put("objectId", this.objectId);
    }
    if (this.createdAt != null) {
      localJSONObject.put("createdAt", Parse.dateToString(this.createdAt));
    }
    if (this.updatedAt != null) {
      localJSONObject.put("updatedAt", Parse.dateToString(this.updatedAt));
    }
    localJSONObject.put("isDeletingEventually", this.isDeletingEventually);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator2 = this.operationSetQueue.iterator();
    while (localIterator2.hasNext()) {
      localJSONArray.put(((ParseOperationSet)localIterator2.next()).toRest(paramParseObjectEncodingStrategy, null));
    }
    localJSONObject.put("__operations", localJSONArray);
    localJSONObject.put("__complete", this.hasBeenFetched);
    return localJSONObject;
  }
  
  public void unpin()
  {
    Parse.waitForTask(unpinInBackground());
  }
  
  public void unpin(String paramString)
  {
    Parse.waitForTask(unpinInBackground(paramString));
  }
  
  public m<Void> unpinInBackground()
  {
    ParseObject[] arrayOfParseObject = new ParseObject[1];
    arrayOfParseObject[0] = this;
    return unpinAllInBackground("_default", Arrays.asList(arrayOfParseObject));
  }
  
  public m<Void> unpinInBackground(String paramString)
  {
    ParseObject[] arrayOfParseObject = new ParseObject[1];
    arrayOfParseObject[0] = this;
    return unpinAllInBackground(paramString, Arrays.asList(arrayOfParseObject));
  }
  
  public void unpinInBackground(DeleteCallback paramDeleteCallback)
  {
    Parse.callbackOnMainThreadAsync(unpinInBackground(), paramDeleteCallback);
  }
  
  public void unpinInBackground(String paramString, DeleteCallback paramDeleteCallback)
  {
    Parse.callbackOnMainThreadAsync(unpinInBackground(paramString), paramDeleteCallback);
  }
  
  void unregisterSaveListener(GetCallback<ParseObject> paramGetCallback)
  {
    synchronized (this.mutex)
    {
      this.saveEvent.unsubscribe(paramGetCallback);
      return;
    }
  }
  
  void updateBeforeSave() {}
  
  void validateDelete() {}
  
  void validateSave() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject
 * JD-Core Version:    0.7.0.1
 */