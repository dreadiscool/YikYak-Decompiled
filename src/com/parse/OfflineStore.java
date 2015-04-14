package com.parse;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.WeakHashMap;
import k;
import m;
import y;

class OfflineStore
{
  private static final int MAX_SQL_VARIABLES = 999;
  private static OfflineStore defaultInstance = null;
  private static final Object defaultInstanceLock = new Object();
  private final WeakValueHashMap<Pair<String, String>, ParseObject> classNameAndObjectIdToObjectMap = new WeakValueHashMap();
  private final WeakHashMap<ParseObject, m<ParseObject>> fetchedObjects = new WeakHashMap();
  private final OfflineSQLiteOpenHelper helper;
  private final Object lock = new Object();
  private final WeakHashMap<ParseObject, m<String>> objectToUuidMap = new WeakHashMap();
  private final WeakValueHashMap<String, ParseObject> uuidToObjectMap = new WeakValueHashMap();
  
  private OfflineStore(Context paramContext)
  {
    this.helper = new OfflineSQLiteOpenHelper(paramContext);
  }
  
  private m<Void> deleteDataForObjectAsync(ParseObject paramParseObject, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    k localk = new k();
    m localm2;
    synchronized (this.lock)
    {
      m localm1 = (m)this.objectToUuidMap.get(paramParseObject);
      if (localm1 == null) {
        localm2 = m.a(null);
      } else {
        localm2 = localm1.d(new OfflineStore.38(this, localk)).d(new OfflineStore.40(this, localk, paramParseSQLiteDatabase)).d(new OfflineStore.39(this, paramParseSQLiteDatabase, paramParseObject)).d(new OfflineStore.42(this, localk, paramParseSQLiteDatabase)).d(new OfflineStore.41(this, localk, paramParseSQLiteDatabase));
      }
    }
    return localm2;
  }
  
  private m<Void> deleteObjects(List<String> paramList, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    int i = 0;
    m localm;
    if (paramList.size() <= 0) {
      localm = m.a(null);
    }
    for (;;)
    {
      return localm;
      if (paramList.size() > 999)
      {
        localm = deleteObjects(paramList.subList(0, 999), paramParseSQLiteDatabase).d(new OfflineStore.33(this, paramList, paramParseSQLiteDatabase));
      }
      else
      {
        String[] arrayOfString = new String[paramList.size()];
        while (i < arrayOfString.length)
        {
          arrayOfString[i] = "?";
          i++;
        }
        localm = paramParseSQLiteDatabase.deleteAsync("ParseObjects", "uuid IN (" + TextUtils.join(",", arrayOfString) + ")", (String[])paramList.toArray(new String[paramList.size()]));
      }
    }
  }
  
  static void disableOfflineStore()
  {
    synchronized (defaultInstanceLock)
    {
      defaultInstance = null;
      return;
    }
  }
  
  public static void enableOfflineStore(Context paramContext)
  {
    synchronized (defaultInstanceLock)
    {
      if (defaultInstance == null)
      {
        defaultInstance = new OfflineStore(paramContext);
        return;
      }
      throw new RuntimeException("enableOfflineStore() called multiple times.");
    }
  }
  
  public static OfflineStore getCurrent()
  {
    synchronized (defaultInstanceLock)
    {
      OfflineStore localOfflineStore = defaultInstance;
      return localOfflineStore;
    }
  }
  
  private m<String> getOrCreateUUIDAsync(ParseObject paramParseObject, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    String str = UUID.randomUUID().toString();
    y localy = m.a();
    m localm;
    synchronized (this.lock)
    {
      localm = (m)this.objectToUuidMap.get(paramParseObject);
      if (localm == null)
      {
        this.objectToUuidMap.put(paramParseObject, localy.a());
        this.uuidToObjectMap.put(str, paramParseObject);
        this.fetchedObjects.put(paramParseObject, localy.a().c(new OfflineStore.1(this, paramParseObject)));
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("uuid", str);
        localContentValues.put("className", paramParseObject.getClassName());
        paramParseSQLiteDatabase.insertOrThrowAsync("ParseObjects", localContentValues).a(new OfflineStore.2(this, localy, str));
        localm = localy.a();
      }
    }
    return localm;
  }
  
  private <T extends ParseObject> m<T> getPointerAsync(String paramString, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    m localm;
    synchronized (this.lock)
    {
      ParseObject localParseObject = (ParseObject)this.uuidToObjectMap.get(paramString);
      if (localParseObject != null)
      {
        localm = m.a(localParseObject);
      }
      else
      {
        String[] arrayOfString1 = new String[2];
        arrayOfString1[0] = "className";
        arrayOfString1[1] = "objectId";
        String[] arrayOfString2 = new String[1];
        arrayOfString2[0] = paramString;
        localm = paramParseSQLiteDatabase.queryAsync("ParseObjects", arrayOfString1, "uuid = ?", arrayOfString2).c(new OfflineStore.3(this, paramString));
      }
    }
    return localm;
  }
  
  public static boolean isEnabled()
  {
    for (;;)
    {
      synchronized (defaultInstanceLock)
      {
        if (defaultInstance != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private m<Void> saveLocallyAsync(String paramString, ParseObject paramParseObject, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    if ((paramParseObject.getObjectId() != null) && (!paramParseObject.isDataAvailable()) && (!paramParseObject.hasChanges()) && (!paramParseObject.hasOutstandingOperations())) {}
    k localk1;
    k localk2;
    for (m localm = m.a(null);; localm = m.a(null).b(new OfflineStore.19(this, paramParseObject, paramParseSQLiteDatabase)).d(new OfflineStore.18(this, paramParseObject, paramParseSQLiteDatabase)).d(new OfflineStore.17(this, localk1, paramParseSQLiteDatabase, localk2, paramParseObject)).d(new OfflineStore.16(this, paramParseObject, localk2, localk1, paramParseSQLiteDatabase)).d(new OfflineStore.15(this, paramString, localk1, paramParseSQLiteDatabase)))
    {
      return localm;
      localk1 = new k();
      localk2 = new k();
    }
  }
  
  private m<Void> unpinAsync(String paramString)
  {
    return this.helper.getWritableDatabaseAsync().d(new OfflineStore.28(this, paramString));
  }
  
  private m<Void> unpinAsync(String paramString, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    LinkedList localLinkedList = new LinkedList();
    return m.a((Void)null).b(new OfflineStore.32(this, paramString, paramParseSQLiteDatabase)).d(new OfflineStore.31(this, localLinkedList, paramParseSQLiteDatabase)).d(new OfflineStore.30(this, paramString, paramParseSQLiteDatabase)).c(new OfflineStore.29(this, localLinkedList));
  }
  
  private m<Void> updateDataForObjectAsync(ParseObject paramParseObject, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    k localk1 = new k();
    k localk2 = new k();
    m localm2;
    synchronized (this.lock)
    {
      m localm1 = (m)this.objectToUuidMap.get(paramParseObject);
      if (localm1 == null) {
        localm2 = m.a(null);
      } else {
        localm2 = localm1.d(new OfflineStore.36(this, localk1, paramParseSQLiteDatabase, localk2, paramParseObject)).d(new OfflineStore.35(this, paramParseObject, localk2, localk1, paramParseSQLiteDatabase));
      }
    }
    return localm2;
  }
  
  void clearDatabase(Context paramContext)
  {
    this.helper.clearDatabase(paramContext);
  }
  
  <T extends ParseObject> m<Integer> countAsync(ParseQuery<T> paramParseQuery, ParseUser paramParseUser, ParsePin paramParsePin, boolean paramBoolean1, boolean paramBoolean2)
  {
    return findAsync(paramParseQuery, paramParseUser, paramParsePin, true, paramBoolean1, paramBoolean2).c(new OfflineStore.4(this));
  }
  
  m<Void> deleteDataForObjectAsync(ParseObject paramParseObject)
  {
    return this.helper.getWritableDatabaseAsync().b(new OfflineStore.37(this, paramParseObject));
  }
  
  <T extends ParseObject> m<T> fetchLocallyAsync(T paramT)
  {
    return this.helper.getWritableDatabaseAsync().b(new OfflineStore.14(this, paramT));
  }
  
  <T extends ParseObject> m<T> fetchLocallyAsync(T paramT, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    y localy = m.a();
    m localm4;
    for (;;)
    {
      m localm1;
      String str1;
      String str2;
      synchronized (this.lock)
      {
        if (this.fetchedObjects.containsKey(paramT))
        {
          localm4 = (m)this.fetchedObjects.get(paramT);
        }
        else
        {
          this.fetchedObjects.put(paramT, localy.a());
          localm1 = (m)this.objectToUuidMap.get(paramT);
          str1 = paramT.getClassName();
          str2 = paramT.getObjectId();
          m localm2 = m.a(null);
          if (str2 == null) {
            if (localm1 == null)
            {
              localm3 = localm2;
              localm4 = localm3.d(new OfflineStore.13(this, paramParseSQLiteDatabase, paramT)).b(new OfflineStore.12(this, localy, paramT));
            }
          }
        }
      }
      String[] arrayOfString3 = new String[1];
      arrayOfString3[0] = "json";
      k localk = new k();
      m localm3 = localm1.d(new OfflineStore.10(this, localk, paramParseSQLiteDatabase, arrayOfString3)).c(new OfflineStore.9(this, localk));
      continue;
      if (localm1 != null)
      {
        localy.b(new IllegalStateException("This object must have already been fetched from the local datastore, but isn't marked as fetched."));
        synchronized (this.lock)
        {
          this.fetchedObjects.remove(paramT);
          localm4 = localy.a();
        }
      }
      String[] arrayOfString1 = new String[2];
      arrayOfString1[0] = "json";
      arrayOfString1[1] = "uuid";
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "className";
      arrayOfObject[1] = "objectId";
      String str3 = String.format("%s = ? AND %s = ?", arrayOfObject);
      String[] arrayOfString2 = new String[2];
      arrayOfString2[0] = str1;
      arrayOfString2[1] = str2;
      localm3 = paramParseSQLiteDatabase.queryAsync("ParseObjects", arrayOfString1, str3, arrayOfString2).c(new OfflineStore.11(this, paramT));
    }
    return localm4;
  }
  
  <T extends ParseObject> m<List<T>> findAsync(ParseQuery<T> paramParseQuery, ParseUser paramParseUser, ParsePin paramParsePin, boolean paramBoolean1, boolean paramBoolean2)
  {
    return findAsync(paramParseQuery, paramParseUser, paramParsePin, false, paramBoolean1, paramBoolean2);
  }
  
  <T extends ParseObject> m<List<T>> findAsync(ParseQuery<T> paramParseQuery, ParseUser paramParseUser, ParsePin paramParsePin, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return this.helper.getWritableDatabaseAsync().b(new OfflineStore.5(this, paramParseQuery, paramParseUser, paramParsePin, paramBoolean1, paramBoolean2, paramBoolean3));
  }
  
  <T extends ParseObject> m<List<T>> findAsync(ParseQuery<T> paramParseQuery, ParseUser paramParseUser, ParsePin paramParsePin, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    OfflineQueryLogic localOfflineQueryLogic = new OfflineQueryLogic(this);
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString1;
    String str;
    String[] arrayOfString2;
    if (paramParsePin == null)
    {
      arrayOfString1 = new String[1];
      arrayOfString1[0] = "uuid";
      str = "className=?";
      if (!paramBoolean2) {
        str = str + " AND isDeletingEventually=0";
      }
      arrayOfString2 = new String[1];
      arrayOfString2[0] = paramParseQuery.getClassName();
    }
    m localm1;
    for (m localm2 = paramParseSQLiteDatabase.queryAsync("ParseObjects", arrayOfString1, str, arrayOfString2);; localm2 = localm1.d(new OfflineStore.6(this, paramBoolean2, paramParseQuery, paramParseSQLiteDatabase))) {
      for (m localm3 = localm2.d(new OfflineStore.8(this, localOfflineQueryLogic, paramParseQuery, paramParseUser, paramBoolean3, paramParseSQLiteDatabase, localArrayList)).d(new OfflineStore.7(this, localOfflineQueryLogic, localArrayList, paramParseQuery, paramBoolean1, paramParseSQLiteDatabase));; localm3 = m.a(localArrayList))
      {
        return localm3;
        localm1 = (m)this.objectToUuidMap.get(paramParsePin);
        if (localm1 != null) {
          break;
        }
      }
    }
  }
  
  Pair<ParseObject, Boolean> getOrCreateObjectWithoutData(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      throw new IllegalStateException("objectId cannot be null.");
    }
    Pair localPair1 = Pair.create(paramString1, paramString2);
    Pair localPair2;
    synchronized (this.lock)
    {
      ParseObject localParseObject = (ParseObject)this.classNameAndObjectIdToObjectMap.get(localPair1);
      if (localParseObject != null) {
        localPair2 = Pair.create(localParseObject, Boolean.valueOf(false));
      } else {
        localPair2 = Pair.create(ParseObject.create(paramString1), Boolean.valueOf(true));
      }
    }
    return localPair2;
  }
  
  void registerNewObject(ParseObject paramParseObject)
  {
    String str = paramParseObject.getObjectId();
    if (str != null)
    {
      Pair localPair = Pair.create(paramParseObject.getClassName(), str);
      this.classNameAndObjectIdToObjectMap.put(localPair, paramParseObject);
    }
  }
  
  m<Void> saveLocallyAsync(ParseObject paramParseObject, boolean paramBoolean)
  {
    return this.helper.getWritableDatabaseAsync().b(new OfflineStore.20(this, paramParseObject, paramBoolean));
  }
  
  m<Void> saveLocallyAsync(ParseObject paramParseObject, boolean paramBoolean, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (!paramBoolean) {
      localArrayList1.add(paramParseObject);
    }
    ArrayList localArrayList2;
    for (m localm = fetchLocallyAsync(paramParseObject, paramParseSQLiteDatabase).j();; localm = m.a(localArrayList2).b(new OfflineStore.25(this, paramParseObject)).d(new OfflineStore.24(this, paramParseSQLiteDatabase)).d(new OfflineStore.23(this, paramParseObject, paramParseSQLiteDatabase)).d(new OfflineStore.22(this, localArrayList1, paramParseSQLiteDatabase)))
    {
      return localm;
      new OfflineStore.21(this, localArrayList1).setYieldRoot(true).setTraverseParseObjects(true).traverse(paramParseObject);
      localArrayList2 = new ArrayList();
      Iterator localIterator = localArrayList1.iterator();
      while (localIterator.hasNext()) {
        localArrayList2.add(fetchLocallyAsync((ParseObject)localIterator.next(), paramParseSQLiteDatabase).j());
      }
    }
  }
  
  void simulateReboot()
  {
    synchronized (this.lock)
    {
      this.uuidToObjectMap.clear();
      this.objectToUuidMap.clear();
      this.classNameAndObjectIdToObjectMap.clear();
      this.fetchedObjects.clear();
      return;
    }
  }
  
  m<Void> unpinAsync(ParseObject paramParseObject)
  {
    return m.a(null).b(new OfflineStore.27(this, paramParseObject)).b(new OfflineStore.26(this));
  }
  
  m<Void> updateDataForObjectAsync(ParseObject paramParseObject)
  {
    m localm2;
    synchronized (this.lock)
    {
      m localm1 = (m)this.fetchedObjects.get(paramParseObject);
      if (localm1 == null) {
        localm2 = m.a(new IllegalStateException("An object cannot be updated if it wasn't fetched."));
      } else {
        localm2 = localm1.b(new OfflineStore.34(this, paramParseObject));
      }
    }
    return localm2;
  }
  
  /* Error */
  void updateObjectId(ParseObject paramParseObject, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +23 -> 24
    //   4: aload_2
    //   5: aload_3
    //   6: invokevirtual 563	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +4 -> 13
    //   12: return
    //   13: new 204	java/lang/RuntimeException
    //   16: dup
    //   17: ldc_w 565
    //   20: invokespecial 209	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   23: athrow
    //   24: aload_1
    //   25: invokevirtual 256	com/parse/ParseObject:getClassName	()Ljava/lang/String;
    //   28: aload_3
    //   29: invokestatic 462	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   32: astore 4
    //   34: aload_0
    //   35: getfield 36	com/parse/OfflineStore:lock	Ljava/lang/Object;
    //   38: astore 5
    //   40: aload 5
    //   42: monitorenter
    //   43: aload_0
    //   44: getfield 43	com/parse/OfflineStore:classNameAndObjectIdToObjectMap	Lcom/parse/WeakValueHashMap;
    //   47: aload 4
    //   49: invokevirtual 268	com/parse/WeakValueHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   52: checkcast 253	com/parse/ParseObject
    //   55: astore 7
    //   57: aload 7
    //   59: ifnull +28 -> 87
    //   62: aload 7
    //   64: aload_1
    //   65: if_acmpeq +22 -> 87
    //   68: new 204	java/lang/RuntimeException
    //   71: dup
    //   72: ldc_w 567
    //   75: invokespecial 209	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   78: athrow
    //   79: astore 6
    //   81: aload 5
    //   83: monitorexit
    //   84: aload 6
    //   86: athrow
    //   87: aload_0
    //   88: getfield 43	com/parse/OfflineStore:classNameAndObjectIdToObjectMap	Lcom/parse/WeakValueHashMap;
    //   91: aload 4
    //   93: aload_1
    //   94: invokevirtual 233	com/parse/WeakValueHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   97: aload 5
    //   99: monitorexit
    //   100: goto -88 -> 12
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	OfflineStore
    //   0	103	1	paramParseObject	ParseObject
    //   0	103	2	paramString1	String
    //   0	103	3	paramString2	String
    //   32	60	4	localPair	Pair
    //   38	60	5	localObject1	Object
    //   79	6	6	localObject2	Object
    //   55	8	7	localParseObject	ParseObject
    // Exception table:
    //   from	to	target	type
    //   43	84	79	finally
    //   87	100	79	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore
 * JD-Core Version:    0.7.0.1
 */