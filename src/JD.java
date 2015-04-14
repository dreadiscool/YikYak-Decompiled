import android.util.Log;

@Deprecated
public class JD
{
  private final String a;
  private final String b;
  private final boolean c;
  private long d;
  private long e;
  
  public JD(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    if (!Log.isLoggable(paramString2, 2)) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      return;
    }
  }
  
  private void c()
  {
    new StringBuilder().append(this.a).append(": ").append(this.e).append("ms").toString();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	JD:c	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokestatic 56	android/os/SystemClock:elapsedRealtime	()J
    //   18: putfield 58	JD:d	J
    //   21: aload_0
    //   22: lconst_0
    //   23: putfield 41	JD:e	J
    //   26: goto -15 -> 11
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	JD
    //   29	4	1	localObject	Object
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
    //   14	26	29	finally
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	JD:c	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 41	JD:e	J
    //   18: lconst_0
    //   19: lcmp
    //   20: ifne -9 -> 11
    //   23: aload_0
    //   24: invokestatic 56	android/os/SystemClock:elapsedRealtime	()J
    //   27: aload_0
    //   28: getfield 58	JD:d	J
    //   31: lsub
    //   32: putfield 41	JD:e	J
    //   35: aload_0
    //   36: invokespecial 60	JD:c	()V
    //   39: goto -28 -> 11
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	JD
    //   42	4	1	localObject	Object
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	42	finally
    //   14	39	42	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     JD
 * JD-Core Version:    0.7.0.1
 */