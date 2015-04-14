import android.content.ServiceConnection;

public class hJ
  implements ServiceConnection
{
  public hJ(hI paramhI) {}
  
  /* Error */
  public void onServiceConnected(android.content.ComponentName paramComponentName, android.os.IBinder paramIBinder)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	hJ:a	LhI;
    //   4: getfield 22	hI:a	LhH;
    //   7: invokestatic 27	hH:a	(LhH;)Ljava/util/HashMap;
    //   10: astore_3
    //   11: aload_3
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield 12	hJ:a	LhI;
    //   17: aload_2
    //   18: invokestatic 30	hI:a	(LhI;Landroid/os/IBinder;)Landroid/os/IBinder;
    //   21: pop
    //   22: aload_0
    //   23: getfield 12	hJ:a	LhI;
    //   26: aload_1
    //   27: invokestatic 33	hI:a	(LhI;Landroid/content/ComponentName;)Landroid/content/ComponentName;
    //   30: pop
    //   31: aload_0
    //   32: getfield 12	hJ:a	LhI;
    //   35: invokestatic 36	hI:a	(LhI;)Ljava/util/HashSet;
    //   38: invokevirtual 42	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   41: astore 7
    //   43: aload 7
    //   45: invokeinterface 48 1 0
    //   50: ifeq +28 -> 78
    //   53: aload 7
    //   55: invokeinterface 52 1 0
    //   60: checkcast 54	hC
    //   63: aload_1
    //   64: aload_2
    //   65: invokevirtual 56	hC:onServiceConnected	(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    //   68: goto -25 -> 43
    //   71: astore 4
    //   73: aload_3
    //   74: monitorexit
    //   75: aload 4
    //   77: athrow
    //   78: aload_0
    //   79: getfield 12	hJ:a	LhI;
    //   82: iconst_1
    //   83: invokestatic 59	hI:a	(LhI;I)I
    //   86: pop
    //   87: aload_3
    //   88: monitorexit
    //   89: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	hJ
    //   0	90	1	paramComponentName	android.content.ComponentName
    //   0	90	2	paramIBinder	android.os.IBinder
    //   10	78	3	localHashMap	java.util.HashMap
    //   71	5	4	localObject	Object
    //   41	13	7	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   13	75	71	finally
    //   78	89	71	finally
  }
  
  /* Error */
  public void onServiceDisconnected(android.content.ComponentName paramComponentName)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	hJ:a	LhI;
    //   4: getfield 22	hI:a	LhH;
    //   7: invokestatic 27	hH:a	(LhH;)Ljava/util/HashMap;
    //   10: astore_2
    //   11: aload_2
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield 12	hJ:a	LhI;
    //   17: aconst_null
    //   18: invokestatic 30	hI:a	(LhI;Landroid/os/IBinder;)Landroid/os/IBinder;
    //   21: pop
    //   22: aload_0
    //   23: getfield 12	hJ:a	LhI;
    //   26: aload_1
    //   27: invokestatic 33	hI:a	(LhI;Landroid/content/ComponentName;)Landroid/content/ComponentName;
    //   30: pop
    //   31: aload_0
    //   32: getfield 12	hJ:a	LhI;
    //   35: invokestatic 36	hI:a	(LhI;)Ljava/util/HashSet;
    //   38: invokevirtual 42	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   41: astore 6
    //   43: aload 6
    //   45: invokeinterface 48 1 0
    //   50: ifeq +25 -> 75
    //   53: aload 6
    //   55: invokeinterface 52 1 0
    //   60: checkcast 54	hC
    //   63: aload_1
    //   64: invokevirtual 63	hC:onServiceDisconnected	(Landroid/content/ComponentName;)V
    //   67: goto -24 -> 43
    //   70: astore_3
    //   71: aload_2
    //   72: monitorexit
    //   73: aload_3
    //   74: athrow
    //   75: aload_0
    //   76: getfield 12	hJ:a	LhI;
    //   79: iconst_2
    //   80: invokestatic 59	hI:a	(LhI;I)I
    //   83: pop
    //   84: aload_2
    //   85: monitorexit
    //   86: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	hJ
    //   0	87	1	paramComponentName	android.content.ComponentName
    //   10	75	2	localHashMap	java.util.HashMap
    //   70	4	3	localObject	Object
    //   41	13	6	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   13	73	70	finally
    //   75	86	70	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hJ
 * JD-Core Version:    0.7.0.1
 */