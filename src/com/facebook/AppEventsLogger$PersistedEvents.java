package com.facebook;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class AppEventsLogger$PersistedEvents
{
  static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
  private static Object staticLock = new Object();
  private Context context;
  private HashMap<AppEventsLogger.AccessTokenAppIdPair, List<AppEventsLogger.AppEvent>> persistedEvents = new HashMap();
  
  private AppEventsLogger$PersistedEvents(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static void persistEvents(Context paramContext, AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEventsLogger.SessionEventsState paramSessionEventsState)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramAccessTokenAppIdPair, paramSessionEventsState);
    persistEvents(paramContext, localHashMap);
  }
  
  /* Error */
  public static void persistEvents(Context paramContext, Map<AppEventsLogger.AccessTokenAppIdPair, AppEventsLogger.SessionEventsState> paramMap)
  {
    // Byte code:
    //   0: getstatic 22	com/facebook/AppEventsLogger$PersistedEvents:staticLock	Ljava/lang/Object;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: aload_0
    //   7: invokestatic 45	com/facebook/AppEventsLogger$PersistedEvents:readAndClearStore	(Landroid/content/Context;)Lcom/facebook/AppEventsLogger$PersistedEvents;
    //   10: astore 4
    //   12: aload_1
    //   13: invokeinterface 49 1 0
    //   18: invokeinterface 55 1 0
    //   23: astore 5
    //   25: aload 5
    //   27: invokeinterface 61 1 0
    //   32: ifeq +65 -> 97
    //   35: aload 5
    //   37: invokeinterface 65 1 0
    //   42: checkcast 67	java/util/Map$Entry
    //   45: astore 6
    //   47: aload 6
    //   49: invokeinterface 70 1 0
    //   54: checkcast 72	com/facebook/AppEventsLogger$SessionEventsState
    //   57: invokevirtual 76	com/facebook/AppEventsLogger$SessionEventsState:getEventsToPersist	()Ljava/util/List;
    //   60: astore 7
    //   62: aload 7
    //   64: invokeinterface 82 1 0
    //   69: ifeq -44 -> 25
    //   72: aload 4
    //   74: aload 6
    //   76: invokeinterface 85 1 0
    //   81: checkcast 87	com/facebook/AppEventsLogger$AccessTokenAppIdPair
    //   84: aload 7
    //   86: invokevirtual 91	com/facebook/AppEventsLogger$PersistedEvents:addEvents	(Lcom/facebook/AppEventsLogger$AccessTokenAppIdPair;Ljava/util/List;)V
    //   89: goto -64 -> 25
    //   92: astore_3
    //   93: aload_2
    //   94: monitorexit
    //   95: aload_3
    //   96: athrow
    //   97: aload 4
    //   99: invokespecial 94	com/facebook/AppEventsLogger$PersistedEvents:write	()V
    //   102: aload_2
    //   103: monitorexit
    //   104: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramContext	Context
    //   0	105	1	paramMap	Map<AppEventsLogger.AccessTokenAppIdPair, AppEventsLogger.SessionEventsState>
    //   3	100	2	localObject1	Object
    //   92	4	3	localObject2	Object
    //   10	88	4	localPersistedEvents	PersistedEvents
    //   23	13	5	localIterator	java.util.Iterator
    //   45	30	6	localEntry	java.util.Map.Entry
    //   60	25	7	localList	List
    // Exception table:
    //   from	to	target	type
    //   6	95	92	finally
    //   97	104	92	finally
  }
  
  public static PersistedEvents readAndClearStore(Context paramContext)
  {
    synchronized (staticLock)
    {
      PersistedEvents localPersistedEvents = new PersistedEvents(paramContext);
      localPersistedEvents.readAndClearStore();
      return localPersistedEvents;
    }
  }
  
  /* Error */
  private void readAndClearStore()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 104	java/io/ObjectInputStream
    //   5: dup
    //   6: new 106	java/io/BufferedInputStream
    //   9: dup
    //   10: aload_0
    //   11: getfield 30	com/facebook/AppEventsLogger$PersistedEvents:context	Landroid/content/Context;
    //   14: ldc 8
    //   16: invokevirtual 112	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   19: invokespecial 115	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: invokespecial 116	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_2
    //   26: aload_2
    //   27: invokevirtual 119	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   30: checkcast 25	java/util/HashMap
    //   33: astore 8
    //   35: aload_0
    //   36: getfield 30	com/facebook/AppEventsLogger$PersistedEvents:context	Landroid/content/Context;
    //   39: ldc 8
    //   41: invokevirtual 123	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   44: invokevirtual 128	java/io/File:delete	()Z
    //   47: pop
    //   48: aload_0
    //   49: aload 8
    //   51: putfield 28	com/facebook/AppEventsLogger$PersistedEvents:persistedEvents	Ljava/util/HashMap;
    //   54: aload_2
    //   55: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   58: return
    //   59: astore 12
    //   61: aload_1
    //   62: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   65: goto -7 -> 58
    //   68: astore 11
    //   70: aconst_null
    //   71: astore_2
    //   72: aload 11
    //   74: astore 4
    //   76: invokestatic 140	com/facebook/AppEventsLogger:access$1300	()Ljava/lang/String;
    //   79: pop
    //   80: new 142	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   87: ldc 145
    //   89: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload 4
    //   94: invokevirtual 152	java/lang/Exception:toString	()Ljava/lang/String;
    //   97: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: pop
    //   104: aload_2
    //   105: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   108: goto -50 -> 58
    //   111: astore 10
    //   113: aconst_null
    //   114: astore_2
    //   115: aload 10
    //   117: astore 5
    //   119: aload_2
    //   120: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   123: aload 5
    //   125: athrow
    //   126: astore 5
    //   128: goto -9 -> 119
    //   131: astore 4
    //   133: goto -57 -> 76
    //   136: astore_3
    //   137: aload_2
    //   138: astore_1
    //   139: goto -78 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	PersistedEvents
    //   1	138	1	localObject1	Object
    //   25	113	2	localObjectInputStream	java.io.ObjectInputStream
    //   136	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   74	19	4	localException1	java.lang.Exception
    //   131	1	4	localException2	java.lang.Exception
    //   117	7	5	localObject2	Object
    //   126	1	5	localObject3	Object
    //   33	17	8	localHashMap	HashMap
    //   111	5	10	localObject4	Object
    //   68	5	11	localException3	java.lang.Exception
    //   59	1	12	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   2	26	59	java/io/FileNotFoundException
    //   2	26	68	java/lang/Exception
    //   2	26	111	finally
    //   26	54	126	finally
    //   76	104	126	finally
    //   26	54	131	java/lang/Exception
    //   26	54	136	java/io/FileNotFoundException
  }
  
  /* Error */
  private void write()
  {
    // Byte code:
    //   0: new 155	java/io/ObjectOutputStream
    //   3: dup
    //   4: new 157	java/io/BufferedOutputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 30	com/facebook/AppEventsLogger$PersistedEvents:context	Landroid/content/Context;
    //   12: ldc 8
    //   14: iconst_0
    //   15: invokevirtual 161	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   18: invokespecial 164	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: invokespecial 165	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_1
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 28	com/facebook/AppEventsLogger$PersistedEvents:persistedEvents	Ljava/util/HashMap;
    //   30: invokevirtual 169	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   33: aload_1
    //   34: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   37: return
    //   38: astore_2
    //   39: aconst_null
    //   40: astore_1
    //   41: invokestatic 140	com/facebook/AppEventsLogger:access$1300	()Ljava/lang/String;
    //   44: pop
    //   45: new 142	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   52: ldc 145
    //   54: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_2
    //   58: invokevirtual 152	java/lang/Exception:toString	()Ljava/lang/String;
    //   61: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: pop
    //   68: aload_1
    //   69: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   72: goto -35 -> 37
    //   75: astore_3
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   82: aload_3
    //   83: athrow
    //   84: astore_3
    //   85: goto -7 -> 78
    //   88: astore_2
    //   89: goto -48 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	PersistedEvents
    //   24	55	1	localObjectOutputStream	java.io.ObjectOutputStream
    //   38	20	2	localException1	java.lang.Exception
    //   88	1	2	localException2	java.lang.Exception
    //   75	8	3	localObject1	Object
    //   84	1	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	25	38	java/lang/Exception
    //   0	25	75	finally
    //   25	33	84	finally
    //   41	68	84	finally
    //   25	33	88	java/lang/Exception
  }
  
  public void addEvents(AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair, List<AppEventsLogger.AppEvent> paramList)
  {
    if (!this.persistedEvents.containsKey(paramAccessTokenAppIdPair)) {
      this.persistedEvents.put(paramAccessTokenAppIdPair, new ArrayList());
    }
    ((List)this.persistedEvents.get(paramAccessTokenAppIdPair)).addAll(paramList);
  }
  
  public List<AppEventsLogger.AppEvent> getEvents(AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    return (List)this.persistedEvents.get(paramAccessTokenAppIdPair);
  }
  
  public Set<AppEventsLogger.AccessTokenAppIdPair> keySet()
  {
    return this.persistedEvents.keySet();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AppEventsLogger.PersistedEvents
 * JD-Core Version:    0.7.0.1
 */