import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.ha;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class gC
  extends Thread
  implements fU
{
  private static gC e;
  private final LinkedBlockingQueue<Runnable> a = new LinkedBlockingQueue();
  private volatile boolean b = false;
  private volatile boolean c = false;
  private volatile String d;
  private volatile fH f;
  private final Context g;
  private final Lock h;
  private final List<ha> i = new ArrayList();
  
  private gC(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (this.g = paramContext.getApplicationContext();; this.g = paramContext)
    {
      this.i.add(new ha("appendVersion", "&_v".substring(1), "ma4.0.4"));
      this.h = new ReentrantLock();
      start();
      return;
    }
  }
  
  static int a(String paramString)
  {
    int j = 1;
    if (!TextUtils.isEmpty(paramString))
    {
      int k = -1 + paramString.length();
      j = 0;
      for (int m = k; m >= 0; m--)
      {
        int n = paramString.charAt(m);
        j = n + (0xFFFFFFF & j << 6) + (n << 14);
        int i1 = 0xFE00000 & j;
        if (i1 != 0) {
          j ^= i1 >> 21;
        }
      }
    }
    return j;
  }
  
  static gC a(Context paramContext)
  {
    if (e == null) {
      e = new gC(paramContext);
    }
    return e;
  }
  
  private String a(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  private void a(Runnable paramRunnable)
  {
    this.a.add(paramRunnable);
  }
  
  static String b(Context paramContext)
  {
    Object localObject = null;
    try
    {
      FileInputStream localFileInputStream = paramContext.openFileInput("gaInstallData");
      arrayOfByte = new byte[8192];
      j = localFileInputStream.read(arrayOfByte, 0, 8192);
      if (localFileInputStream.available() > 0)
      {
        fA.a("Too much campaign data, ignoring it.");
        localFileInputStream.close();
        paramContext.deleteFile("gaInstallData");
      }
      else
      {
        localFileInputStream.close();
        paramContext.deleteFile("gaInstallData");
        if (j <= 0) {
          fA.d("Campaign file is empty.");
        }
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      byte[] arrayOfByte;
      int j;
      fA.b("No campaign data found.");
      return localObject;
      String str = new String(arrayOfByte, 0, j);
      fA.b("Campaign found: " + str);
      localObject = str;
    }
    catch (IOException localIOException)
    {
      fA.a("Error reading campaign data.");
      paramContext.deleteFile("gaInstallData");
    }
    return localObject;
  }
  
  public void a()
  {
    a(new gE(this, null));
  }
  
  public void a(Map<String, String> paramMap)
  {
    a(new gG(this, paramMap));
  }
  
  public void b()
  {
    a(new gF(this, null));
  }
  
  public LinkedBlockingQueue<Runnable> c()
  {
    return this.a;
  }
  
  public Thread d()
  {
    return this;
  }
  
  public void e()
  {
    f();
    ArrayList localArrayList = new ArrayList();
    this.a.drainTo(localArrayList);
    this.h.lock();
    try
    {
      this.b = true;
      Iterator localIterator = localArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Runnable localRunnable = (Runnable)localIterator.next();
          try
          {
            localRunnable.run();
          }
          catch (Throwable localThrowable)
          {
            fA.a("Error dispatching all events on exit, giving up: " + a(localThrowable));
          }
        }
      }
      return;
    }
    finally
    {
      this.h.unlock();
    }
  }
  
  /* Error */
  protected void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 204	gC:f	LfH;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: new 261	gu
    //   18: dup
    //   19: aload_0
    //   20: getfield 56	gC:g	Landroid/content/Context;
    //   23: aload_0
    //   24: invokespecial 264	gu:<init>	(Landroid/content/Context;LfU;)V
    //   27: putfield 204	gC:f	LfH;
    //   30: aload_0
    //   31: getfield 204	gC:f	LfH;
    //   34: invokeinterface 268 1 0
    //   39: goto -28 -> 11
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	gC
    //   42	4	1	localObject	Object
    //   6	2	2	localfH	fH
    // Exception table:
    //   from	to	target	type
    //   2	7	42	finally
    //   14	39	42	finally
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    try
    {
      Thread.sleep(5000L);
    }
    catch (InterruptedException localInterruptedException1)
    {
      try
      {
        for (;;)
        {
          f();
          this.d = b(this.g);
          fA.c("Initialized GA Thread");
          while (!this.c) {
            try
            {
              localRunnable = (Runnable)this.a.take();
              this.h.lock();
            }
            catch (InterruptedException localInterruptedException2)
            {
              try
              {
                Runnable localRunnable;
                if (!this.b) {
                  localRunnable.run();
                }
                this.h.unlock();
              }
              finally
              {
                this.h.unlock();
              }
              localInterruptedException2 = localInterruptedException2;
              fA.b(localInterruptedException2.toString());
            }
            catch (Throwable localThrowable2)
            {
              fA.a("Error on GAThread: " + a(localThrowable2));
              fA.a("Google Analytics is shutting down.");
              this.b = true;
            }
          }
          localInterruptedException1 = localInterruptedException1;
          fA.d("sleep interrupted in GAThread initialize");
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          fA.a("Error initializing the GAThread: " + a(localThrowable1));
          fA.a("Google Analytics will not start up.");
          this.b = true;
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gC
 * JD-Core Version:    0.7.0.1
 */