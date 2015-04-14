import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class ge
  implements gm
{
  private static ge a;
  private static final Object b = new Object();
  private final Context c;
  private String d;
  private boolean e = false;
  private final Object f = new Object();
  
  protected ge(Context paramContext)
  {
    this.c = paramContext;
    f();
  }
  
  public static ge a()
  {
    synchronized (b)
    {
      ge localge = a;
      return localge;
    }
  }
  
  public static void a(Context paramContext)
  {
    synchronized (b)
    {
      if (a == null) {
        a = new ge(paramContext);
      }
      return;
    }
  }
  
  private boolean c(String paramString)
  {
    boolean bool = false;
    try
    {
      fA.c("Storing clientId.");
      FileOutputStream localFileOutputStream = this.c.openFileOutput("gaClientId", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      bool = true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        fA.a("Error creating clientId file.");
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        fA.a("Error writing to clientId file.");
      }
    }
    return bool;
  }
  
  private String e()
  {
    if (!this.e) {}
    synchronized (this.f)
    {
      if (!this.e) {
        fA.c("Waiting for clientId to load");
      }
      try
      {
        do
        {
          this.f.wait();
        } while (!this.e);
        fA.c("Loaded clientId");
        return this.d;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          fA.a("Exception while waiting for clientId: " + localInterruptedException);
        }
      }
    }
  }
  
  private void f()
  {
    new gf(this, "client_id_fetcher").start();
  }
  
  public String a(String paramString)
  {
    if ("&cid".equals(paramString)) {}
    for (String str = e();; str = null) {
      return str;
    }
  }
  
  String b()
  {
    synchronized (this.f)
    {
      this.d = c();
      String str = this.d;
      return str;
    }
  }
  
  public boolean b(String paramString)
  {
    return "&cid".equals(paramString);
  }
  
  protected String c()
  {
    String str = UUID.randomUUID().toString().toLowerCase();
    try
    {
      if (!c(str)) {
        str = "0";
      }
      return str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        str = null;
      }
    }
  }
  
  String d()
  {
    Object localObject = null;
    try
    {
      localFileInputStream = this.c.openFileInput("gaClientId");
      byte[] arrayOfByte = new byte[''];
      int i = localFileInputStream.read(arrayOfByte, 0, 128);
      if (localFileInputStream.available() > 0)
      {
        fA.a("clientId file seems corrupted, deleting it.");
        localFileInputStream.close();
        this.c.deleteFile("gaClientId");
      }
      for (;;)
      {
        label61:
        if (localObject == null) {
          localObject = c();
        }
        return localObject;
        if (i > 0) {
          break;
        }
        fA.a("clientId file seems empty, deleting it.");
        localFileInputStream.close();
        this.c.deleteFile("gaClientId");
      }
      str = new String(arrayOfByte, 0, i);
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          FileInputStream localFileInputStream;
          localFileInputStream.close();
          fA.c("Loaded client id from disk.");
          localObject = str;
        }
        catch (IOException localIOException2)
        {
          localObject = str;
          continue;
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          String str;
          localObject = str;
        }
        localIOException1 = localIOException1;
        fA.a("Error reading clientId file, deleting it.");
        this.c.deleteFile("gaClientId");
      }
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      break label61;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ge
 * JD-Core Version:    0.7.0.1
 */