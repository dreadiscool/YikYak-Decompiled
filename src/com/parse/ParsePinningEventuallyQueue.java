package com.parse;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import m;
import y;

class ParsePinningEventuallyQueue
  extends ParseEventuallyQueue
{
  private static final String TAG = "ParsePinningEventuallyQueue";
  private final Object connectionLock = new Object();
  private m<Void>.y connectionTaskCompletionSource = m.a();
  private ArrayList<String> eventuallyPinUUIDQueue = new ArrayList();
  private TaskQueue operationSetTaskQueue = new TaskQueue();
  private HashMap<String, m<Object>.y> pendingEventuallyTasks = new HashMap();
  private HashMap<String, m<Object>.y> pendingOperationSetUUIDTasks = new HashMap();
  private TaskQueue taskQueue = new TaskQueue();
  private final Object taskQueueSyncLock = new Object();
  private HashMap<String, EventuallyPin> uuidToEventuallyPin = new HashMap();
  private HashMap<String, ParseOperationSet> uuidToOperationSet = new HashMap();
  
  public ParsePinningEventuallyQueue(Context paramContext)
  {
    setConnected(ConnectivityNotifier.getNotifier().isConnected());
    ConnectivityNotifier.getNotifier().addListener(new ParsePinningEventuallyQueue.1(this), paramContext);
    resume();
  }
  
  private m<Void> enqueueEventuallyAsync(ParseCommand paramParseCommand, ParseObject paramParseObject, m<Void> paramm, m<Object>.y paramm1)
  {
    return paramm.b(new ParsePinningEventuallyQueue.5(this, paramParseObject, paramParseCommand, paramm1));
  }
  
  private m<Void> populateQueueAsync()
  {
    return this.taskQueue.enqueue(new ParsePinningEventuallyQueue.6(this));
  }
  
  private m<Void> populateQueueAsync(m<Void> paramm)
  {
    return paramm.b(new ParsePinningEventuallyQueue.8(this)).d(new ParsePinningEventuallyQueue.7(this));
  }
  
  private m<Object> process(EventuallyPin paramEventuallyPin, ParseOperationSet paramParseOperationSet)
  {
    return waitForConnectionAsync().d(new ParsePinningEventuallyQueue.13(this, paramEventuallyPin, paramParseOperationSet));
  }
  
  private m<Void> runEventuallyAsync(EventuallyPin paramEventuallyPin)
  {
    String str = paramEventuallyPin.getUUID();
    if (this.eventuallyPinUUIDQueue.contains(str)) {}
    for (m localm = m.a(null);; localm = m.a(null))
    {
      return localm;
      this.eventuallyPinUUIDQueue.add(str);
      this.operationSetTaskQueue.enqueue(new ParsePinningEventuallyQueue.9(this, paramEventuallyPin, str));
    }
  }
  
  private m<Void> runEventuallyAsync(EventuallyPin paramEventuallyPin, m<Void> paramm)
  {
    return paramm.b(new ParsePinningEventuallyQueue.11(this)).d(new ParsePinningEventuallyQueue.10(this, paramEventuallyPin));
  }
  
  private m<Void> waitForConnectionAsync()
  {
    synchronized (this.connectionLock)
    {
      m localm = this.connectionTaskCompletionSource.a();
      return localm;
    }
  }
  
  private m<Void> whenAll(Collection<TaskQueue> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((TaskQueue)localIterator.next()).enqueue(new ParsePinningEventuallyQueue.15(this)));
    }
    return m.a(localArrayList);
  }
  
  public void clear()
  {
    pause();
    m localm = this.taskQueue.enqueue(new ParsePinningEventuallyQueue.14(this));
    try
    {
      Parse.waitForTask(localm);
      simulateReboot();
      resume();
      return;
    }
    catch (ParseException localParseException)
    {
      throw new IllegalStateException(localParseException);
    }
  }
  
  public m<Object> enqueueEventuallyAsync(ParseCommand paramParseCommand, ParseObject paramParseObject)
  {
    Parse.requirePermission("android.permission.ACCESS_NETWORK_STATE");
    y localy = m.a();
    this.taskQueue.enqueue(new ParsePinningEventuallyQueue.4(this, paramParseCommand, paramParseObject, localy));
    return localy.a();
  }
  
  /* Error */
  public void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 63	com/parse/ParsePinningEventuallyQueue:connectionLock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 58	com/parse/ParsePinningEventuallyQueue:connectionTaskCompletionSource	Ly;
    //   11: new 268	com/parse/ParsePinningEventuallyQueue$PauseException
    //   14: dup
    //   15: aconst_null
    //   16: invokespecial 271	com/parse/ParsePinningEventuallyQueue$PauseException:<init>	(Lcom/parse/ParsePinningEventuallyQueue$1;)V
    //   19: invokevirtual 274	y:a	(Ljava/lang/Exception;)Z
    //   22: pop
    //   23: aload_0
    //   24: invokestatic 56	m:a	()Ly;
    //   27: putfield 58	com/parse/ParsePinningEventuallyQueue:connectionTaskCompletionSource	Ly;
    //   30: aload_0
    //   31: getfield 58	com/parse/ParsePinningEventuallyQueue:connectionTaskCompletionSource	Ly;
    //   34: new 268	com/parse/ParsePinningEventuallyQueue$PauseException
    //   37: dup
    //   38: aconst_null
    //   39: invokespecial 271	com/parse/ParsePinningEventuallyQueue$PauseException:<init>	(Lcom/parse/ParsePinningEventuallyQueue$1;)V
    //   42: invokevirtual 274	y:a	(Ljava/lang/Exception;)Z
    //   45: pop
    //   46: aload_1
    //   47: monitorexit
    //   48: aload_0
    //   49: getfield 65	com/parse/ParsePinningEventuallyQueue:taskQueueSyncLock	Ljava/lang/Object;
    //   52: astore 5
    //   54: aload 5
    //   56: monitorenter
    //   57: aload_0
    //   58: getfield 67	com/parse/ParsePinningEventuallyQueue:pendingEventuallyTasks	Ljava/util/HashMap;
    //   61: invokevirtual 278	java/util/HashMap:keySet	()Ljava/util/Set;
    //   64: invokeinterface 281 1 0
    //   69: astore 7
    //   71: aload 7
    //   73: invokeinterface 219 1 0
    //   78: ifeq +55 -> 133
    //   81: aload 7
    //   83: invokeinterface 223 1 0
    //   88: checkcast 283	java/lang/String
    //   91: astore 11
    //   93: aload_0
    //   94: getfield 67	com/parse/ParsePinningEventuallyQueue:pendingEventuallyTasks	Ljava/util/HashMap;
    //   97: aload 11
    //   99: invokevirtual 287	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast 204	y
    //   105: new 268	com/parse/ParsePinningEventuallyQueue$PauseException
    //   108: dup
    //   109: aconst_null
    //   110: invokespecial 271	com/parse/ParsePinningEventuallyQueue$PauseException:<init>	(Lcom/parse/ParsePinningEventuallyQueue$1;)V
    //   113: invokevirtual 274	y:a	(Ljava/lang/Exception;)Z
    //   116: pop
    //   117: goto -46 -> 71
    //   120: astore 6
    //   122: aload 5
    //   124: monitorexit
    //   125: aload 6
    //   127: athrow
    //   128: astore_2
    //   129: aload_1
    //   130: monitorexit
    //   131: aload_2
    //   132: athrow
    //   133: aload_0
    //   134: getfield 67	com/parse/ParsePinningEventuallyQueue:pendingEventuallyTasks	Ljava/util/HashMap;
    //   137: invokevirtual 289	java/util/HashMap:clear	()V
    //   140: aload_0
    //   141: getfield 69	com/parse/ParsePinningEventuallyQueue:uuidToOperationSet	Ljava/util/HashMap;
    //   144: invokevirtual 289	java/util/HashMap:clear	()V
    //   147: aload_0
    //   148: getfield 71	com/parse/ParsePinningEventuallyQueue:uuidToEventuallyPin	Ljava/util/HashMap;
    //   151: invokevirtual 289	java/util/HashMap:clear	()V
    //   154: aload 5
    //   156: monitorexit
    //   157: iconst_2
    //   158: anewarray 40	com/parse/TaskQueue
    //   161: astore 9
    //   163: aload 9
    //   165: iconst_0
    //   166: aload_0
    //   167: getfield 43	com/parse/ParsePinningEventuallyQueue:taskQueue	Lcom/parse/TaskQueue;
    //   170: aastore
    //   171: aload 9
    //   173: iconst_1
    //   174: aload_0
    //   175: getfield 45	com/parse/ParsePinningEventuallyQueue:operationSetTaskQueue	Lcom/parse/TaskQueue;
    //   178: aastore
    //   179: aload_0
    //   180: aload 9
    //   182: invokestatic 295	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   185: invokespecial 297	com/parse/ParsePinningEventuallyQueue:whenAll	(Ljava/util/Collection;)Lm;
    //   188: invokestatic 246	com/parse/Parse:waitForTask	(Lm;)Ljava/lang/Object;
    //   191: pop
    //   192: return
    //   193: astore 8
    //   195: new 251	java/lang/IllegalStateException
    //   198: dup
    //   199: aload 8
    //   201: invokespecial 254	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   204: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	ParsePinningEventuallyQueue
    //   4	126	1	localObject1	Object
    //   128	4	2	localObject2	Object
    //   52	103	5	localObject3	Object
    //   120	6	6	localObject4	Object
    //   69	13	7	localIterator	Iterator
    //   193	7	8	localParseException	ParseException
    //   161	20	9	arrayOfTaskQueue	TaskQueue[]
    //   91	7	11	str	String
    // Exception table:
    //   from	to	target	type
    //   57	125	120	finally
    //   133	157	120	finally
    //   7	48	128	finally
    //   129	131	128	finally
    //   157	192	193	com/parse/ParseException
  }
  
  public int pendingCount()
  {
    try
    {
      int i = ((Integer)Parse.waitForTask(pendingCountAsync())).intValue();
      return i;
    }
    catch (ParseException localParseException)
    {
      throw new IllegalStateException(localParseException);
    }
  }
  
  public m<Integer> pendingCountAsync()
  {
    y localy = m.a();
    this.taskQueue.enqueue(new ParsePinningEventuallyQueue.2(this, localy));
    return localy.a();
  }
  
  public m<Integer> pendingCountAsync(m<Void> paramm)
  {
    return paramm.b(new ParsePinningEventuallyQueue.3(this));
  }
  
  public void resume()
  {
    setConnected(isConnected());
    populateQueueAsync();
  }
  
  public void setConnected(boolean paramBoolean)
  {
    synchronized (this.connectionLock)
    {
      super.setConnected(paramBoolean);
      if (paramBoolean)
      {
        this.connectionTaskCompletionSource.a(null);
        this.connectionTaskCompletionSource = m.a();
        this.connectionTaskCompletionSource.a(null);
        return;
      }
      this.connectionTaskCompletionSource = m.a();
    }
  }
  
  void simulateReboot()
  {
    pause();
    this.pendingOperationSetUUIDTasks.clear();
    this.pendingEventuallyTasks.clear();
    this.uuidToOperationSet.clear();
    this.uuidToEventuallyPin.clear();
    resume();
  }
  
  /* Error */
  m<Object> waitForOperationSetAndEventuallyPin(ParseOperationSet paramParseOperationSet, EventuallyPin paramEventuallyPin)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +22 -> 23
    //   4: aload_2
    //   5: invokevirtual 324	com/parse/EventuallyPin:getType	()I
    //   8: iconst_1
    //   9: if_icmpeq +14 -> 23
    //   12: aload_0
    //   13: aload_2
    //   14: aconst_null
    //   15: invokespecial 113	com/parse/ParsePinningEventuallyQueue:process	(Lcom/parse/EventuallyPin;Lcom/parse/ParseOperationSet;)Lm;
    //   18: astore 12
    //   20: aload 12
    //   22: areturn
    //   23: aload_0
    //   24: getfield 65	com/parse/ParsePinningEventuallyQueue:taskQueueSyncLock	Ljava/lang/Object;
    //   27: astore_3
    //   28: aload_3
    //   29: monitorenter
    //   30: aload_1
    //   31: ifnull +111 -> 142
    //   34: aload_2
    //   35: ifnonnull +107 -> 142
    //   38: aload_1
    //   39: invokevirtual 327	com/parse/ParseOperationSet:getUUID	()Ljava/lang/String;
    //   42: astore 14
    //   44: aload_0
    //   45: getfield 69	com/parse/ParsePinningEventuallyQueue:uuidToOperationSet	Ljava/util/HashMap;
    //   48: aload 14
    //   50: aload_1
    //   51: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: aload 14
    //   57: astore 7
    //   59: aload_0
    //   60: getfield 71	com/parse/ParsePinningEventuallyQueue:uuidToEventuallyPin	Ljava/util/HashMap;
    //   63: aload 7
    //   65: invokevirtual 287	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 175	com/parse/EventuallyPin
    //   71: astore 8
    //   73: aload_0
    //   74: getfield 69	com/parse/ParsePinningEventuallyQueue:uuidToOperationSet	Ljava/util/HashMap;
    //   77: aload 7
    //   79: invokevirtual 287	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 326	com/parse/ParseOperationSet
    //   85: astore 9
    //   87: aload 8
    //   89: ifnull +8 -> 97
    //   92: aload 9
    //   94: ifnonnull +111 -> 205
    //   97: aload_0
    //   98: getfield 67	com/parse/ParsePinningEventuallyQueue:pendingEventuallyTasks	Ljava/util/HashMap;
    //   101: aload 7
    //   103: invokevirtual 334	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   106: ifeq +79 -> 185
    //   109: aload_0
    //   110: getfield 67	com/parse/ParsePinningEventuallyQueue:pendingEventuallyTasks	Ljava/util/HashMap;
    //   113: aload 7
    //   115: invokevirtual 287	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   118: checkcast 204	y
    //   121: astore 10
    //   123: aload 10
    //   125: invokevirtual 206	y:a	()Lm;
    //   128: astore 12
    //   130: aload_3
    //   131: monitorexit
    //   132: goto -112 -> 20
    //   135: astore 4
    //   137: aload_3
    //   138: monitorexit
    //   139: aload 4
    //   141: athrow
    //   142: aload_1
    //   143: ifnonnull +31 -> 174
    //   146: aload_2
    //   147: ifnull +27 -> 174
    //   150: aload_2
    //   151: invokevirtual 337	com/parse/EventuallyPin:getOperationSetUUID	()Ljava/lang/String;
    //   154: astore 5
    //   156: aload_0
    //   157: getfield 71	com/parse/ParsePinningEventuallyQueue:uuidToEventuallyPin	Ljava/util/HashMap;
    //   160: aload 5
    //   162: aload_2
    //   163: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   166: pop
    //   167: aload 5
    //   169: astore 7
    //   171: goto -112 -> 59
    //   174: new 251	java/lang/IllegalStateException
    //   177: dup
    //   178: ldc_w 339
    //   181: invokespecial 341	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   184: athrow
    //   185: invokestatic 56	m:a	()Ly;
    //   188: astore 10
    //   190: aload_0
    //   191: getfield 67	com/parse/ParsePinningEventuallyQueue:pendingEventuallyTasks	Ljava/util/HashMap;
    //   194: aload 7
    //   196: aload 10
    //   198: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: pop
    //   202: goto -79 -> 123
    //   205: aload_0
    //   206: getfield 67	com/parse/ParsePinningEventuallyQueue:pendingEventuallyTasks	Ljava/util/HashMap;
    //   209: aload 7
    //   211: invokevirtual 287	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   214: checkcast 204	y
    //   217: astore 13
    //   219: aload_3
    //   220: monitorexit
    //   221: aload_0
    //   222: aload 8
    //   224: aload 9
    //   226: invokespecial 113	com/parse/ParsePinningEventuallyQueue:process	(Lcom/parse/EventuallyPin;Lcom/parse/ParseOperationSet;)Lm;
    //   229: new 343	com/parse/ParsePinningEventuallyQueue$12
    //   232: dup
    //   233: aload_0
    //   234: aload 7
    //   236: aload 13
    //   238: invokespecial 346	com/parse/ParsePinningEventuallyQueue$12:<init>	(Lcom/parse/ParsePinningEventuallyQueue;Ljava/lang/String;Ly;)V
    //   241: invokevirtual 153	m:b	(Ll;)Lm;
    //   244: astore 12
    //   246: goto -226 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	ParsePinningEventuallyQueue
    //   0	249	1	paramParseOperationSet	ParseOperationSet
    //   0	249	2	paramEventuallyPin	EventuallyPin
    //   27	193	3	localObject1	Object
    //   135	5	4	localObject2	Object
    //   154	14	5	str1	String
    //   57	178	7	localObject3	Object
    //   71	152	8	localEventuallyPin	EventuallyPin
    //   85	140	9	localParseOperationSet	ParseOperationSet
    //   121	76	10	localy1	y
    //   18	227	12	localm	m
    //   217	20	13	localy2	y
    //   42	14	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   38	139	135	finally
    //   150	221	135	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePinningEventuallyQueue
 * JD-Core Version:    0.7.0.1
 */