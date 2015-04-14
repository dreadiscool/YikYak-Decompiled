package com.facebook;

final class AppEventsLogger$4
  implements Runnable
{
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 13	java/util/HashSet
    //   3: dup
    //   4: invokespecial 14	java/util/HashSet:<init>	()V
    //   7: astore_1
    //   8: invokestatic 20	com/facebook/AppEventsLogger:access$400	()Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: invokestatic 24	com/facebook/AppEventsLogger:access$500	()Ljava/util/Map;
    //   17: invokeinterface 30 1 0
    //   22: invokeinterface 36 1 0
    //   27: astore 4
    //   29: aload 4
    //   31: invokeinterface 42 1 0
    //   36: ifeq +31 -> 67
    //   39: aload_1
    //   40: aload 4
    //   42: invokeinterface 45 1 0
    //   47: checkcast 47	com/facebook/AppEventsLogger$AccessTokenAppIdPair
    //   50: invokevirtual 51	com/facebook/AppEventsLogger$AccessTokenAppIdPair:getApplicationId	()Ljava/lang/String;
    //   53: invokeinterface 55 2 0
    //   58: pop
    //   59: goto -30 -> 29
    //   62: astore_3
    //   63: aload_2
    //   64: monitorexit
    //   65: aload_3
    //   66: athrow
    //   67: aload_2
    //   68: monitorexit
    //   69: aload_1
    //   70: invokeinterface 36 1 0
    //   75: astore 5
    //   77: aload 5
    //   79: invokeinterface 42 1 0
    //   84: ifeq +21 -> 105
    //   87: aload 5
    //   89: invokeinterface 45 1 0
    //   94: checkcast 57	java/lang/String
    //   97: iconst_1
    //   98: invokestatic 63	com/facebook/internal/Utility:queryAppSettings	(Ljava/lang/String;Z)Lcom/facebook/internal/Utility$FetchedAppSettings;
    //   101: pop
    //   102: goto -25 -> 77
    //   105: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	4
    //   7	63	1	localHashSet	java.util.HashSet
    //   11	57	2	localObject1	Object
    //   62	4	3	localObject2	Object
    //   27	14	4	localIterator1	java.util.Iterator
    //   75	13	5	localIterator2	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   14	65	62	finally
    //   67	69	62	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AppEventsLogger.4
 * JD-Core Version:    0.7.0.1
 */