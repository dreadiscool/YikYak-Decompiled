package com.parse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;
import m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseQuery<T extends ParseObject>
{
  private static final String TAG = "com.parse.ParseQuery";
  private ParseQuery.CachePolicy cachePolicy;
  private String className;
  private ParseCommand currentCommand = null;
  private HashMap<String, Object> extraOptions = null;
  private boolean ignoreACLs;
  private ArrayList<String> include;
  private boolean isRunning = false;
  private final Object isRunningLock = new Object();
  private int limit;
  private long maxCacheAge;
  private long objectsParsed;
  private String order;
  private String pinName;
  private long queryReceived;
  private long querySent;
  private long queryStart;
  private ArrayList<String> selectedKeys;
  private int skip;
  private boolean trace;
  private ParseQuery.QueryConstraints where;
  
  public ParseQuery(Class<T> paramClass)
  {
    this(ParseObject.getClassName(paramClass));
  }
  
  public ParseQuery(String paramString)
  {
    this.className = paramString;
    this.limit = -1;
    this.skip = 0;
    this.where = new ParseQuery.QueryConstraints();
    this.include = new ArrayList();
    this.cachePolicy = ParseQuery.CachePolicy.IGNORE_CACHE;
    this.maxCacheAge = 9223372036854775807L;
    this.trace = false;
    this.extraOptions = new HashMap();
  }
  
  private void addCondition(String paramString1, String paramString2, Object paramObject)
  {
    checkIfRunning();
    Object localObject;
    if (this.where.containsKey(paramString1))
    {
      localObject = this.where.get(paramString1);
      if (!(localObject instanceof ParseQuery.KeyConstraints)) {}
    }
    for (ParseQuery.KeyConstraints localKeyConstraints = (ParseQuery.KeyConstraints)localObject;; localKeyConstraints = null)
    {
      if (localKeyConstraints == null) {
        localKeyConstraints = new ParseQuery.KeyConstraints();
      }
      localKeyConstraints.put(paramString2, paramObject);
      this.where.put(paramString1, localKeyConstraints);
      return;
    }
  }
  
  private void checkIfRunning()
  {
    checkIfRunning(false);
  }
  
  /* Error */
  private void checkIfRunning(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	com/parse/ParseQuery:isRunningLock	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 60	com/parse/ParseQuery:isRunning	Z
    //   11: ifeq +18 -> 29
    //   14: new 193	java/lang/RuntimeException
    //   17: dup
    //   18: ldc 195
    //   20: invokespecial 196	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   23: athrow
    //   24: astore_3
    //   25: aload_2
    //   26: monitorexit
    //   27: aload_3
    //   28: athrow
    //   29: iload_1
    //   30: ifeq +8 -> 38
    //   33: aload_0
    //   34: iconst_1
    //   35: putfield 60	com/parse/ParseQuery:isRunning	Z
    //   38: aload_2
    //   39: monitorexit
    //   40: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	ParseQuery
    //   0	41	1	paramBoolean	boolean
    //   4	35	2	localObject1	Object
    //   24	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	27	24	finally
    //   33	40	24	finally
  }
  
  private static void checkPinningEnabled(boolean paramBoolean)
  {
    if ((OfflineStore.isEnabled()) && (!paramBoolean))
    {
      if (paramBoolean) {
        throw new IllegalStateException("Method requires Pinning to be enabled.");
      }
      throw new IllegalStateException("Method not allowed when Pinning is enabled.");
    }
  }
  
  public static void clearAllCachedResults()
  {
    checkPinningEnabled(false);
    Parse.clearCacheDir();
  }
  
  private List<T> convertFindResponse(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    JSONArray localJSONArray = paramJSONObject.getJSONArray("results");
    if (localJSONArray == null)
    {
      Parse.logD("com.parse.ParseQuery", "null results in find response");
      this.objectsParsed = System.nanoTime();
      if (paramJSONObject.has("trace"))
      {
        Object localObject = paramJSONObject.get("trace");
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Float.valueOf((float)(this.querySent - this.queryStart) / 1000000.0F);
        arrayOfObject[1] = localObject;
        arrayOfObject[2] = Float.valueOf((float)(this.objectsParsed - this.queryReceived) / 1000000.0F);
        Parse.logD("ParseQuery", String.format("Query pre-processing took %f seconds\n%s\nClient side parsing took %f seconds\n", arrayOfObject));
      }
      return localArrayList;
    }
    String str1 = paramJSONObject.optString("className");
    if (str1.equals("")) {}
    for (String str2 = this.className;; str2 = str1)
    {
      int i = 0;
      label147:
      JSONObject localJSONObject;
      if (i < localJSONArray.length())
      {
        localJSONObject = localJSONArray.getJSONObject(i);
        if (this.selectedKeys != null) {
          break label228;
        }
      }
      label228:
      for (boolean bool = true;; bool = false)
      {
        ParseObject localParseObject = ParseObject.fromJSON(localJSONObject, str2, bool);
        localArrayList.add(localParseObject);
        ParseQuery.RelationConstraint localRelationConstraint = (ParseQuery.RelationConstraint)this.where.get("$relatedTo");
        if (localRelationConstraint != null) {
          localRelationConstraint.getRelation().addKnownObject(localParseObject);
        }
        i++;
        break label147;
        break;
      }
    }
  }
  
  private m<Integer> countFromCacheAsync(ParseUser paramParseUser, boolean paramBoolean1, boolean paramBoolean2)
  {
    OfflineStore localOfflineStore = OfflineStore.getCurrent();
    m localm2;
    if (localOfflineStore != null) {
      if (this.pinName != null) {
        localm2 = ParsePin.getParsePin(this.pinName);
      }
    }
    for (m localm1 = localm2.d(new ParseQuery.10(this, localOfflineStore, paramParseUser, paramBoolean1, paramBoolean2));; localm1 = m.a(new ParseQuery.11(this), m.a))
    {
      return localm1;
      localm2 = m.a(null);
      break;
    }
  }
  
  private m<Integer> countFromNetworkAsync()
  {
    if (this.cachePolicy != ParseQuery.CachePolicy.IGNORE_CACHE) {}
    for (boolean bool = true;; bool = false)
    {
      this.currentCommand = makeCountCommand(ParseUser.getCurrentSessionToken());
      return this.currentCommand.executeAsync().d(new ParseQuery.19(this, bool)).a(new ParseQuery.18(this));
    }
  }
  
  private m<Integer> countWithCachePolicyAsync(ParseQuery.CachePolicy paramCachePolicy, ParseUser paramParseUser)
  {
    return runCommandWithPolicyAsync(new ParseQuery.3(this, paramParseUser), paramCachePolicy);
  }
  
  private <TResult> void doInBackground(ParseQuery.CallableWithCachePolicy<m<TResult>> paramCallableWithCachePolicy, ParseCallback<TResult> paramParseCallback)
  {
    Parse.callbackOnMainThreadAsync(doWithRunningCheck(new ParseQuery.13(this, paramCallableWithCachePolicy, paramParseCallback)), paramParseCallback);
  }
  
  private <TResult> m<TResult> doWithRunningCheck(Callable<m<TResult>> paramCallable)
  {
    checkIfRunning(true);
    try
    {
      localm = (m)paramCallable.call();
      return localm.b(new ParseQuery.12(this));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        m localm = m.a(localException);
      }
    }
  }
  
  private m<List<T>> findFromNetworkAsync(boolean paramBoolean)
  {
    this.currentCommand = makeFindCommand(ParseUser.getCurrentSessionToken());
    return m.b(new ParseQuery.7(this, paramBoolean)).d(new ParseQuery.6(this));
  }
  
  private ParseQuery<T> fromLocalDatastore(String paramString, boolean paramBoolean)
  {
    checkPinningEnabled(true);
    checkIfRunning();
    this.cachePolicy = ParseQuery.CachePolicy.CACHE_ONLY;
    this.pinName = paramString;
    this.ignoreACLs = paramBoolean;
    return this;
  }
  
  private m<T> getFirstWithCachePolicyAsync(ParseQuery.CachePolicy paramCachePolicy, ParseUser paramParseUser)
  {
    this.limit = 1;
    return findWithCachePolicyAsync(paramCachePolicy, paramParseUser).a(new ParseQuery.5(this));
  }
  
  public static <T extends ParseObject> ParseQuery<T> getQuery(Class<T> paramClass)
  {
    return new ParseQuery(paramClass);
  }
  
  public static <T extends ParseObject> ParseQuery<T> getQuery(String paramString)
  {
    return new ParseQuery(paramString);
  }
  
  @Deprecated
  public static ParseQuery<ParseUser> getUserQuery()
  {
    return ParseUser.getQuery();
  }
  
  private m<T> getWithCachePolicyAsync(String paramString, ParseQuery.CachePolicy paramCachePolicy, ParseUser paramParseUser)
  {
    this.skip = -1;
    this.where = new ParseQuery.QueryConstraints();
    this.where.put("objectId", paramString);
    return getFirstWithCachePolicyAsync(paramCachePolicy, paramParseUser);
  }
  
  private ParseCommand makeCountCommand(String paramString)
  {
    ParseCommand localParseCommand = makeFindCommand(paramString);
    localParseCommand.put("limit", 0);
    localParseCommand.put("count", 1);
    return localParseCommand;
  }
  
  private ParseCommand makeFindCommand(String paramString)
  {
    localParseCommand = new ParseCommand("find", paramString);
    JSONObject localJSONObject = toJSON();
    Iterator localIterator = localJSONObject.keys();
    try
    {
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localParseCommand.put(str, localJSONObject.get(str).toString());
      }
      return localParseCommand;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  public static <T extends ParseObject> ParseQuery<T> or(List<ParseQuery<T>> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = null;
    for (int i = 0; i < paramList.size(); i++)
    {
      if ((localObject != null) && (!((ParseQuery)paramList.get(i)).className.equals(localObject))) {
        throw new IllegalArgumentException("All of the queries in an or query must be on the same class ");
      }
      localObject = ((ParseQuery)paramList.get(i)).className;
      localArrayList.add(paramList.get(i));
    }
    if (localArrayList.size() == 0) {
      throw new IllegalArgumentException("Can't take an or of an empty list of queries");
    }
    return new ParseQuery((String)localObject).whereSatifiesAnyOf(localArrayList);
  }
  
  private <TResult> m<TResult> runCommandWithPolicyAsync(ParseQuery.CommandDelegate<TResult> paramCommandDelegate, ParseQuery.CachePolicy paramCachePolicy)
  {
    m localm;
    switch (ParseQuery.24.$SwitchMap$com$parse$ParseQuery$CachePolicy[paramCachePolicy.ordinal()])
    {
    default: 
      throw new RuntimeException("Unknown cache policy: " + this.cachePolicy);
    case 1: 
    case 2: 
      localm = paramCommandDelegate.runOnNetworkAsync(true);
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        return localm;
        localm = paramCommandDelegate.runFromCacheAsync();
        continue;
        localm = paramCommandDelegate.runFromCacheAsync().b(new ParseQuery.1(this, paramCommandDelegate));
        continue;
        localm = paramCommandDelegate.runOnNetworkAsync(false).b(new ParseQuery.2(this, paramCommandDelegate));
      }
    }
    throw new RuntimeException("You cannot use the cache policy CACHE_THEN_NETWORK with find()");
  }
  
  private JSONObject toJSON()
  {
    JSONObject localJSONObject = toREST();
    try
    {
      if (!localJSONObject.isNull("where")) {
        localJSONObject.put("data", localJSONObject.remove("where"));
      }
      localJSONObject.put("classname", localJSONObject.remove("className"));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  private ParseQuery<T> whereSatifiesAnyOf(List<ParseQuery<? extends T>> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ParseQuery localParseQuery = (ParseQuery)localIterator.next();
      if (localParseQuery.limit >= 0) {
        throw new IllegalArgumentException("Cannot have limits in sub queries of an 'OR' query");
      }
      if (localParseQuery.skip > 0) {
        throw new IllegalArgumentException("Cannot have skips in sub queries of an 'OR' query");
      }
      if (localParseQuery.order != null) {
        throw new IllegalArgumentException("Cannot have an order in sub queries of an 'OR' query");
      }
      if (!localParseQuery.include.isEmpty()) {
        throw new IllegalArgumentException("Cannot have an include in sub queries of an 'OR' query");
      }
      if (localParseQuery.selectedKeys != null) {
        throw new IllegalArgumentException("Cannot have an selectKeys in sub queries of an 'OR' query");
      }
      localArrayList.add(localParseQuery.getConstraints());
    }
    this.where.put("$or", localArrayList);
    return this;
  }
  
  public ParseQuery<T> addAscendingOrder(String paramString)
  {
    checkIfRunning();
    if (this.order == null) {}
    for (this.order = paramString;; this.order = (this.order + "," + paramString)) {
      return this;
    }
  }
  
  public ParseQuery<T> addDescendingOrder(String paramString)
  {
    checkIfRunning();
    if (this.order == null) {}
    for (this.order = ("-" + paramString);; this.order = (this.order + ",-" + paramString)) {
      return this;
    }
  }
  
  public void cancel()
  {
    synchronized (this.isRunningLock)
    {
      if (this.currentCommand != null)
      {
        this.currentCommand.cancel();
        this.currentCommand = null;
      }
      this.isRunning = false;
      return;
    }
  }
  
  public void clearCachedResult()
  {
    checkPinningEnabled(false);
    Parse.clearFromKeyValueCache(makeFindCommand(ParseUser.getCurrentSessionToken()).getCacheKey());
  }
  
  public int count()
  {
    return ((Integer)Parse.waitForTask(countInBackground())).intValue();
  }
  
  public m<Integer> countInBackground()
  {
    ParseUser localParseUser = ParseUser.getCurrentUser();
    this.queryStart = System.nanoTime();
    return doWithRunningCheck(new ParseQuery.20(this, localParseUser));
  }
  
  public void countInBackground(CountCallback paramCountCallback)
  {
    ParseUser localParseUser = ParseUser.getCurrentUser();
    this.queryStart = System.nanoTime();
    doInBackground(new ParseQuery.21(this, localParseUser), paramCountCallback);
  }
  
  public List<T> find()
  {
    return (List)Parse.waitForTask(findInBackground());
  }
  
  m<List<T>> findFromCacheAsync(ParseUser paramParseUser, boolean paramBoolean1, boolean paramBoolean2)
  {
    OfflineStore localOfflineStore = OfflineStore.getCurrent();
    m localm2;
    if (localOfflineStore != null) {
      if (this.pinName != null) {
        localm2 = ParsePin.getParsePin(this.pinName);
      }
    }
    for (m localm1 = localm2.d(new ParseQuery.8(this, localOfflineStore, paramParseUser, paramBoolean1, paramBoolean2));; localm1 = m.a(new ParseQuery.9(this), m.a))
    {
      return localm1;
      localm2 = m.a(null);
      break;
    }
  }
  
  public m<List<T>> findInBackground()
  {
    return findInBackground(ParseUser.getCurrentUser());
  }
  
  m<List<T>> findInBackground(ParseUser paramParseUser)
  {
    this.queryStart = System.nanoTime();
    return doWithRunningCheck(new ParseQuery.14(this, paramParseUser));
  }
  
  public void findInBackground(FindCallback<T> paramFindCallback)
  {
    ParseUser localParseUser = ParseUser.getCurrentUser();
    this.queryStart = System.nanoTime();
    doInBackground(new ParseQuery.15(this, localParseUser), paramFindCallback);
  }
  
  m<List<T>> findWithCachePolicyAsync(ParseQuery.CachePolicy paramCachePolicy, ParseUser paramParseUser)
  {
    return runCommandWithPolicyAsync(new ParseQuery.4(this, paramParseUser), paramCachePolicy);
  }
  
  public ParseQuery<T> fromLocalDatastore()
  {
    return fromLocalDatastore(null, false);
  }
  
  ParseQuery<T> fromLocalDatastore(boolean paramBoolean)
  {
    return fromLocalDatastore(null, paramBoolean);
  }
  
  ParseQuery<T> fromNetwork()
  {
    checkPinningEnabled(true);
    checkIfRunning();
    this.cachePolicy = ParseQuery.CachePolicy.NETWORK_ONLY;
    this.pinName = null;
    this.ignoreACLs = false;
    return this;
  }
  
  public ParseQuery<T> fromPin()
  {
    return fromLocalDatastore("_default", false);
  }
  
  public ParseQuery<T> fromPin(String paramString)
  {
    return fromLocalDatastore(paramString, false);
  }
  
  ParseQuery<T> fromPin(String paramString, boolean paramBoolean)
  {
    return fromLocalDatastore(paramString, paramBoolean);
  }
  
  ParseQuery<T> fromPin(boolean paramBoolean)
  {
    return fromLocalDatastore("_default", paramBoolean);
  }
  
  public T get(String paramString)
  {
    return (ParseObject)Parse.waitForTask(getInBackground(paramString));
  }
  
  public ParseQuery.CachePolicy getCachePolicy()
  {
    checkPinningEnabled(false);
    return this.cachePolicy;
  }
  
  public String getClassName()
  {
    return this.className;
  }
  
  ParseQuery.QueryConstraints getConstraints()
  {
    return this.where;
  }
  
  public T getFirst()
  {
    return (ParseObject)Parse.waitForTask(getFirstInBackground());
  }
  
  public m<T> getFirstInBackground()
  {
    ParseUser localParseUser = ParseUser.getCurrentUser();
    this.queryStart = System.nanoTime();
    return doWithRunningCheck(new ParseQuery.16(this, localParseUser));
  }
  
  public void getFirstInBackground(GetCallback<T> paramGetCallback)
  {
    doInBackground(new ParseQuery.17(this, ParseUser.getCurrentUser()), paramGetCallback);
  }
  
  public m<T> getInBackground(String paramString)
  {
    ParseUser localParseUser = ParseUser.getCurrentUser();
    this.queryStart = System.nanoTime();
    return doWithRunningCheck(new ParseQuery.22(this, paramString, localParseUser));
  }
  
  public void getInBackground(String paramString, GetCallback<T> paramGetCallback)
  {
    doInBackground(new ParseQuery.23(this, paramString, ParseUser.getCurrentUser()), paramGetCallback);
  }
  
  List<String> getIncludes()
  {
    return Collections.unmodifiableList(this.include);
  }
  
  public int getLimit()
  {
    return this.limit;
  }
  
  public long getMaxCacheAge()
  {
    checkPinningEnabled(false);
    return this.maxCacheAge;
  }
  
  public int getSkip()
  {
    return this.skip;
  }
  
  public boolean hasCachedResult()
  {
    boolean bool = false;
    checkPinningEnabled(false);
    if (Parse.loadFromKeyValueCache(makeFindCommand(ParseUser.getCurrentSessionToken()).getCacheKey(), this.maxCacheAge) != null) {
      bool = true;
    }
    return bool;
  }
  
  public void include(String paramString)
  {
    checkIfRunning();
    this.include.add(paramString);
  }
  
  boolean isFromLocalDatastore()
  {
    boolean bool = true;
    checkPinningEnabled(bool);
    if (this.cachePolicy == ParseQuery.CachePolicy.CACHE_ONLY) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  boolean isFromNetwork()
  {
    boolean bool = true;
    checkPinningEnabled(bool);
    if (this.cachePolicy == ParseQuery.CachePolicy.NETWORK_ONLY) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public ParseQuery<T> orderByAscending(String paramString)
  {
    checkIfRunning();
    this.order = paramString;
    return this;
  }
  
  public ParseQuery<T> orderByDescending(String paramString)
  {
    checkIfRunning();
    this.order = ("-" + paramString);
    return this;
  }
  
  ParseQuery<T> redirectClassNameForKey(String paramString)
  {
    this.extraOptions.put("redirectClassNameForKey", paramString);
    return this;
  }
  
  public void selectKeys(Collection<String> paramCollection)
  {
    checkIfRunning();
    if (this.selectedKeys == null) {
      this.selectedKeys = new ArrayList();
    }
    this.selectedKeys.addAll(paramCollection);
  }
  
  public void setCachePolicy(ParseQuery.CachePolicy paramCachePolicy)
  {
    checkPinningEnabled(false);
    checkIfRunning();
    this.cachePolicy = paramCachePolicy;
  }
  
  public ParseQuery<T> setLimit(int paramInt)
  {
    checkIfRunning();
    this.limit = paramInt;
    return this;
  }
  
  public void setMaxCacheAge(long paramLong)
  {
    checkPinningEnabled(false);
    this.maxCacheAge = paramLong;
  }
  
  public ParseQuery<T> setSkip(int paramInt)
  {
    checkIfRunning();
    this.skip = paramInt;
    return this;
  }
  
  public void setTrace(boolean paramBoolean)
  {
    this.trace = paramBoolean;
  }
  
  String[] sortKeys()
  {
    if (this.order == null) {}
    for (String[] arrayOfString = new String[0];; arrayOfString = this.order.split(",")) {
      return arrayOfString;
    }
  }
  
  JSONObject toREST()
  {
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("className", this.className);
      localJSONObject.put("where", Parse.encode(this.where, PointerEncodingStrategy.get()));
      if (this.limit >= 0) {
        localJSONObject.put("limit", this.limit);
      }
      if (this.skip > 0) {
        localJSONObject.put("skip", this.skip);
      }
      if (this.order != null) {
        localJSONObject.put("order", this.order);
      }
      if (!this.include.isEmpty()) {
        localJSONObject.put("include", Parse.join(this.include, ","));
      }
      if (this.selectedKeys != null) {
        localJSONObject.put("fields", Parse.join(this.selectedKeys, ","));
      }
      if (this.trace) {
        localJSONObject.put("trace", "1");
      }
      Iterator localIterator = this.extraOptions.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, Parse.encode(this.extraOptions.get(str), PointerEncodingStrategy.get()));
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  public ParseQuery<T> whereContainedIn(String paramString, Collection<? extends Object> paramCollection)
  {
    addCondition(paramString, "$in", new ArrayList(paramCollection));
    return this;
  }
  
  public ParseQuery<T> whereContains(String paramString1, String paramString2)
  {
    whereMatches(paramString1, Pattern.quote(paramString2));
    return this;
  }
  
  public ParseQuery<T> whereContainsAll(String paramString, Collection<?> paramCollection)
  {
    addCondition(paramString, "$all", new ArrayList(paramCollection));
    return this;
  }
  
  public ParseQuery<T> whereDoesNotExist(String paramString)
  {
    addCondition(paramString, "$exists", Boolean.valueOf(false));
    return this;
  }
  
  public ParseQuery<T> whereDoesNotMatchKeyInQuery(String paramString1, String paramString2, ParseQuery<?> paramParseQuery)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("key", paramString2);
      localJSONObject.put("query", paramParseQuery);
      addCondition(paramString1, "$dontSelect", localJSONObject);
      return this;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  public ParseQuery<T> whereDoesNotMatchQuery(String paramString, ParseQuery<?> paramParseQuery)
  {
    addCondition(paramString, "$notInQuery", paramParseQuery);
    return this;
  }
  
  public ParseQuery<T> whereEndsWith(String paramString1, String paramString2)
  {
    whereMatches(paramString1, Pattern.quote(paramString2) + "$");
    return this;
  }
  
  public ParseQuery<T> whereEqualTo(String paramString, Object paramObject)
  {
    checkIfRunning();
    this.where.put(paramString, paramObject);
    return this;
  }
  
  public ParseQuery<T> whereExists(String paramString)
  {
    addCondition(paramString, "$exists", Boolean.valueOf(true));
    return this;
  }
  
  public ParseQuery<T> whereGreaterThan(String paramString, Object paramObject)
  {
    addCondition(paramString, "$gt", paramObject);
    return this;
  }
  
  public ParseQuery<T> whereGreaterThanOrEqualTo(String paramString, Object paramObject)
  {
    addCondition(paramString, "$gte", paramObject);
    return this;
  }
  
  public ParseQuery<T> whereLessThan(String paramString, Object paramObject)
  {
    addCondition(paramString, "$lt", paramObject);
    return this;
  }
  
  public ParseQuery<T> whereLessThanOrEqualTo(String paramString, Object paramObject)
  {
    addCondition(paramString, "$lte", paramObject);
    return this;
  }
  
  public ParseQuery<T> whereMatches(String paramString1, String paramString2)
  {
    addCondition(paramString1, "$regex", paramString2);
    return this;
  }
  
  public ParseQuery<T> whereMatches(String paramString1, String paramString2, String paramString3)
  {
    addCondition(paramString1, "$regex", paramString2);
    if (paramString3.length() != 0) {
      addCondition(paramString1, "$options", paramString3);
    }
    return this;
  }
  
  public ParseQuery<T> whereMatchesKeyInQuery(String paramString1, String paramString2, ParseQuery<?> paramParseQuery)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("key", paramString2);
      localJSONObject.put("query", paramParseQuery);
      addCondition(paramString1, "$select", localJSONObject);
      return this;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  public ParseQuery<T> whereMatchesQuery(String paramString, ParseQuery<?> paramParseQuery)
  {
    addCondition(paramString, "$inQuery", paramParseQuery);
    return this;
  }
  
  public ParseQuery<T> whereNear(String paramString, ParseGeoPoint paramParseGeoPoint)
  {
    addCondition(paramString, "$nearSphere", paramParseGeoPoint);
    return this;
  }
  
  public ParseQuery<T> whereNotContainedIn(String paramString, Collection<? extends Object> paramCollection)
  {
    addCondition(paramString, "$nin", new ArrayList(paramCollection));
    return this;
  }
  
  public ParseQuery<T> whereNotEqualTo(String paramString, Object paramObject)
  {
    addCondition(paramString, "$ne", paramObject);
    return this;
  }
  
  ParseQuery<T> whereRelatedTo(ParseObject paramParseObject, String paramString)
  {
    this.where.put("$relatedTo", new ParseQuery.RelationConstraint(paramString, paramParseObject));
    return this;
  }
  
  public ParseQuery<T> whereStartsWith(String paramString1, String paramString2)
  {
    whereMatches(paramString1, "^" + Pattern.quote(paramString2));
    return this;
  }
  
  public ParseQuery<T> whereWithinGeoBox(String paramString, ParseGeoPoint paramParseGeoPoint1, ParseGeoPoint paramParseGeoPoint2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramParseGeoPoint1);
    localArrayList.add(paramParseGeoPoint2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("$box", localArrayList);
    addCondition(paramString, "$within", localHashMap);
    return this;
  }
  
  public ParseQuery<T> whereWithinKilometers(String paramString, ParseGeoPoint paramParseGeoPoint, double paramDouble)
  {
    whereWithinRadians(paramString, paramParseGeoPoint, paramDouble / ParseGeoPoint.EARTH_MEAN_RADIUS_KM);
    return this;
  }
  
  public ParseQuery<T> whereWithinMiles(String paramString, ParseGeoPoint paramParseGeoPoint, double paramDouble)
  {
    whereWithinRadians(paramString, paramParseGeoPoint, paramDouble / ParseGeoPoint.EARTH_MEAN_RADIUS_MILE);
    return this;
  }
  
  public ParseQuery<T> whereWithinRadians(String paramString, ParseGeoPoint paramParseGeoPoint, double paramDouble)
  {
    addCondition(paramString, "$nearSphere", paramParseGeoPoint);
    addCondition(paramString, "$maxDistance", Double.valueOf(paramDouble));
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery
 * JD-Core Version:    0.7.0.1
 */