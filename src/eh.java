import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class eh
  implements el
{
  private static eh a;
  private static final Object b = new Object();
  private final Context c;
  private String d;
  private boolean e = false;
  private final Object f = new Object();
  
  protected eh(Context paramContext)
  {
    this.c = paramContext;
    e();
  }
  
  public static eh a()
  {
    synchronized (b)
    {
      eh localeh = a;
      return localeh;
    }
  }
  
  public static void a(Context paramContext)
  {
    synchronized (b)
    {
      if (a == null) {
        a = new eh(paramContext);
      }
      return;
    }
  }
  
  private boolean c(String paramString)
  {
    boolean bool = false;
    try
    {
      eO.c("Storing clientId.");
      FileOutputStream localFileOutputStream = this.c.openFileOutput("gaClientId", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      bool = true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        eO.a("Error creating clientId file.");
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        eO.a("Error writing to clientId file.");
      }
    }
    return bool;
  }
  
  private String d()
  {
    if (!this.e) {}
    synchronized (this.f)
    {
      if (!this.e) {
        eO.c("Waiting for clientId to load");
      }
      try
      {
        do
        {
          this.f.wait();
        } while (!this.e);
        eO.c("Loaded clientId");
        return this.d;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          eO.a("Exception while waiting for clientId: " + localInterruptedException);
        }
      }
    }
  }
  
  private void e()
  {
    new ei(this, "client_id_fetcher").start();
  }
  
  public boolean a(String paramString)
  {
    return "&cid".equals(paramString);
  }
  
  protected String b()
  {
    String str = UUID.randomUUID().toString().toLowerCase();
    if (!c(str)) {
      str = "0";
    }
    return str;
  }
  
  public String b(String paramString)
  {
    if ("&cid".equals(paramString)) {}
    for (String str = d();; str = null) {
      return str;
    }
  }
  
  @VisibleForTesting
  String c()
  {
    Object localObject = null;
    try
    {
      localFileInputStream = this.c.openFileInput("gaClientId");
      byte[] arrayOfByte = new byte[''];
      int i = localFileInputStream.read(arrayOfByte, 0, 128);
      if (localFileInputStream.available() > 0)
      {
        eO.a("clientId file seems corrupted, deleting it.");
        localFileInputStream.close();
        this.c.deleteFile("gaClientId");
      }
      for (;;)
      {
        label61:
        if (localObject == null) {
          localObject = b();
        }
        return localObject;
        if (i > 0) {
          break;
        }
        eO.a("clientId file seems empty, deleting it.");
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
        eO.a("Error reading clientId file, deleting it.");
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
 * Qualified Name:     eh
 * JD-Core Version:    0.7.0.1
 */