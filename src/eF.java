import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

class eF
  extends Thread
  implements ef
{
  private static eF g;
  private final LinkedBlockingQueue<Runnable> a = new LinkedBlockingQueue();
  private volatile boolean b = false;
  private volatile boolean c = false;
  private volatile List<Command> d;
  private volatile String e;
  private volatile String f;
  private volatile eZ h;
  private final Context i;
  
  private eF(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (this.i = paramContext.getApplicationContext();; this.i = paramContext)
    {
      start();
      return;
    }
  }
  
  @VisibleForTesting
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
  
  static eF a(Context paramContext)
  {
    if (g == null) {
      g = new eF(paramContext);
    }
    return g;
  }
  
  private String a(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  @VisibleForTesting
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
        eO.a("Too much campaign data, ignoring it.");
        localFileInputStream.close();
        paramContext.deleteFile("gaInstallData");
      }
      else
      {
        localFileInputStream.close();
        paramContext.deleteFile("gaInstallData");
        if (j <= 0) {
          eO.d("Campaign file is empty.");
        }
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      byte[] arrayOfByte;
      int j;
      eO.b("No campaign data found.");
      return localObject;
      String str = new String(arrayOfByte, 0, j);
      eO.b("Campaign found: " + str);
      localObject = str;
    }
    catch (IOException localIOException)
    {
      eO.a("Error reading campaign data.");
      paramContext.deleteFile("gaInstallData");
    }
    return localObject;
  }
  
  private String b(Map<String, String> paramMap)
  {
    String str;
    if (paramMap.containsKey("useSecure")) {
      if (fd.a((String)paramMap.get("useSecure"), true)) {
        str = "https:";
      }
    }
    for (;;)
    {
      return str;
      str = "http:";
      continue;
      str = "https:";
    }
  }
  
  private boolean c(Map<String, String> paramMap)
  {
    boolean bool;
    if (paramMap.get("&sf") == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      double d1 = fd.a((String)paramMap.get("&sf"), 100.0D);
      if (d1 >= 100.0D)
      {
        bool = false;
      }
      else
      {
        if (a((String)paramMap.get("&cid")) % 10000 >= d1 * 100.0D)
        {
          if (paramMap.get("&t") == null) {}
          for (String str = "unknown";; str = (String)paramMap.get("&t"))
          {
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = str;
            eO.c(String.format("%s hit sampled out", arrayOfObject));
            bool = true;
            break;
          }
        }
        bool = false;
      }
    }
  }
  
  private void d(Map<String, String> paramMap)
  {
    eg localeg = eg.a();
    fd.a(paramMap, "&an", localeg.b("&an"));
    fd.a(paramMap, "&av", localeg.b("&av"));
    fd.a(paramMap, "&aid", localeg.b("&aid"));
    fd.a(paramMap, "&aiid", localeg.b("&aiid"));
    paramMap.put("&v", "1");
  }
  
  public void a()
  {
    a(new eH(this));
  }
  
  @VisibleForTesting
  void a(Runnable paramRunnable)
  {
    this.a.add(paramRunnable);
  }
  
  public void a(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap(paramMap);
    String str = (String)paramMap.get("&ht");
    if (str != null) {}
    try
    {
      Long.valueOf(str).longValue();
      if (str == null) {
        localHashMap.put("&ht", Long.toString(System.currentTimeMillis()));
      }
      a(new eG(this, localHashMap));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        str = null;
      }
    }
  }
  
  public void b()
  {
    a(new eI(this));
  }
  
  public LinkedBlockingQueue<Runnable> c()
  {
    return this.a;
  }
  
  public Thread d()
  {
    return this;
  }
  
  @VisibleForTesting
  protected void e()
  {
    this.h.f();
    this.d = new ArrayList();
    this.d.add(new Command("appendVersion", "&_v".substring(1), "ma3.0.1"));
    this.d.add(new Command("appendQueueTime", "&qt".substring(1), null));
    this.d.add(new Command("appendCacheBuster", "&z".substring(1), null));
  }
  
  public void run()
  {
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
          if (this.h == null) {
            this.h = new ew(this.i, this);
          }
          e();
          this.f = eh.a().b("&cid");
          this.e = b(this.i);
          while (!this.c) {
            try
            {
              Runnable localRunnable = (Runnable)this.a.take();
              if (!this.b) {
                localRunnable.run();
              }
            }
            catch (InterruptedException localInterruptedException2)
            {
              eO.b(localInterruptedException2.toString());
            }
            catch (Throwable localThrowable2)
            {
              eO.a("Error on GAThread: " + a(localThrowable2));
              eO.a("Google Analytics is shutting down.");
              this.b = true;
            }
          }
          localInterruptedException1 = localInterruptedException1;
          eO.d("sleep interrupted in GAThread initialize");
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          eO.a("Error initializing the GAThread: " + a(localThrowable1));
          eO.a("Google Analytics will not start up.");
          this.b = true;
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     eF
 * JD-Core Version:    0.7.0.1
 */