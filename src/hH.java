import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.HashMap;

public final class hH
  implements Handler.Callback
{
  private static final Object a = new Object();
  private static hH b;
  private final Context c;
  private final HashMap<String, hI> d = new HashMap();
  private final Handler e = new Handler(paramContext.getMainLooper(), this);
  
  private hH(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
  }
  
  public static hH a(Context paramContext)
  {
    synchronized (a)
    {
      if (b == null) {
        b = new hH(paramContext.getApplicationContext());
      }
      return b;
    }
  }
  
  /* Error */
  public boolean a(String paramString, hy<?>.hC paramhy)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	hH:d	Ljava/util/HashMap;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 43	hH:d	Ljava/util/HashMap;
    //   11: aload_1
    //   12: invokevirtual 61	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 63	hI
    //   18: astore 5
    //   20: aload 5
    //   22: ifnonnull +48 -> 70
    //   25: new 63	hI
    //   28: dup
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 66	hI:<init>	(LhH;Ljava/lang/String;)V
    //   34: astore 5
    //   36: aload 5
    //   38: aload_2
    //   39: invokevirtual 69	hI:a	(LhC;)V
    //   42: aload 5
    //   44: invokevirtual 71	hI:a	()V
    //   47: aload_0
    //   48: getfield 43	hH:d	Ljava/util/HashMap;
    //   51: aload_1
    //   52: aload 5
    //   54: invokevirtual 75	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   57: pop
    //   58: aload 5
    //   60: invokevirtual 78	hI:d	()Z
    //   63: istore 7
    //   65: aload_3
    //   66: monitorexit
    //   67: iload 7
    //   69: ireturn
    //   70: aload_0
    //   71: getfield 38	hH:e	Landroid/os/Handler;
    //   74: iconst_0
    //   75: aload 5
    //   77: invokevirtual 82	android/os/Handler:removeMessages	(ILjava/lang/Object;)V
    //   80: aload 5
    //   82: aload_2
    //   83: invokevirtual 85	hI:c	(LhC;)Z
    //   86: ifeq +37 -> 123
    //   89: new 87	java/lang/IllegalStateException
    //   92: dup
    //   93: new 89	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   100: ldc 92
    //   102: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 103	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   115: athrow
    //   116: astore 4
    //   118: aload_3
    //   119: monitorexit
    //   120: aload 4
    //   122: athrow
    //   123: aload 5
    //   125: aload_2
    //   126: invokevirtual 69	hI:a	(LhC;)V
    //   129: aload 5
    //   131: invokevirtual 106	hI:e	()I
    //   134: tableswitch	default:+47 -> 181, 1:+22->156, 2:+39->173
    //   157: aload 5
    //   159: invokevirtual 110	hI:h	()Landroid/content/ComponentName;
    //   162: aload 5
    //   164: invokevirtual 114	hI:g	()Landroid/os/IBinder;
    //   167: invokevirtual 120	hC:onServiceConnected	(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    //   170: goto -112 -> 58
    //   173: aload 5
    //   175: invokevirtual 71	hI:a	()V
    //   178: goto -120 -> 58
    //   181: goto -123 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	hH
    //   0	184	1	paramString	String
    //   0	184	2	paramhy	hy<?>.hC
    //   4	115	3	localHashMap	HashMap
    //   116	5	4	localObject	Object
    //   18	156	5	localhI	hI
    //   63	5	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	120	116	finally
    //   123	178	116	finally
  }
  
  /* Error */
  public void b(String paramString, hy<?>.hC paramhy)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	hH:d	Ljava/util/HashMap;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 43	hH:d	Ljava/util/HashMap;
    //   11: aload_1
    //   12: invokevirtual 61	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 63	hI
    //   18: astore 5
    //   20: aload 5
    //   22: ifnonnull +37 -> 59
    //   25: new 87	java/lang/IllegalStateException
    //   28: dup
    //   29: new 89	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   36: ldc 123
    //   38: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_1
    //   42: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 103	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   51: athrow
    //   52: astore 4
    //   54: aload_3
    //   55: monitorexit
    //   56: aload 4
    //   58: athrow
    //   59: aload 5
    //   61: aload_2
    //   62: invokevirtual 85	hI:c	(LhC;)Z
    //   65: ifne +30 -> 95
    //   68: new 87	java/lang/IllegalStateException
    //   71: dup
    //   72: new 89	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   79: ldc 125
    //   81: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_1
    //   85: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokespecial 103	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   94: athrow
    //   95: aload 5
    //   97: aload_2
    //   98: invokevirtual 127	hI:b	(LhC;)V
    //   101: aload 5
    //   103: invokevirtual 130	hI:f	()Z
    //   106: ifeq +28 -> 134
    //   109: aload_0
    //   110: getfield 38	hH:e	Landroid/os/Handler;
    //   113: iconst_0
    //   114: aload 5
    //   116: invokevirtual 134	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   119: astore 6
    //   121: aload_0
    //   122: getfield 38	hH:e	Landroid/os/Handler;
    //   125: aload 6
    //   127: ldc2_w 135
    //   130: invokevirtual 140	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   133: pop
    //   134: aload_3
    //   135: monitorexit
    //   136: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	hH
    //   0	137	1	paramString	String
    //   0	137	2	paramhy	hy<?>.hC
    //   4	131	3	localHashMap	HashMap
    //   52	5	4	localObject	Object
    //   18	97	5	localhI	hI
    //   119	7	6	localMessage	Message
    // Exception table:
    //   from	to	target	type
    //   7	56	52	finally
    //   59	136	52	finally
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      hI localhI = (hI)paramMessage.obj;
      synchronized (this.d)
      {
        if (localhI.f())
        {
          localhI.b();
          this.d.remove(localhI.c());
        }
        bool = true;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hH
 * JD-Core Version:    0.7.0.1
 */