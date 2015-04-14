import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class bn
  implements IT<String>
{
  public String a(Context paramContext)
  {
    long l = System.nanoTime();
    Object localObject1 = "";
    ZipInputStream localZipInputStream = null;
    for (;;)
    {
      try
      {
        localZipInputStream = b(paramContext);
        String str = a(localZipInputStream);
        localObject1 = str;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        double d;
        IC.g();
        if (localZipInputStream == null) {
          continue;
        }
        try
        {
          localZipInputStream.close();
        }
        catch (IOException localIOException5)
        {
          IC.g();
        }
        continue;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        IC.g();
        if (localZipInputStream == null) {
          continue;
        }
        try
        {
          localZipInputStream.close();
        }
        catch (IOException localIOException4)
        {
          IC.g();
        }
        continue;
      }
      catch (IOException localIOException2)
      {
        IC.g();
        if (localZipInputStream == null) {
          continue;
        }
        try
        {
          localZipInputStream.close();
        }
        catch (IOException localIOException3)
        {
          IC.g();
        }
        continue;
      }
      finally
      {
        if (localZipInputStream == null) {
          break label190;
        }
      }
      try
      {
        localZipInputStream.close();
        d = (System.nanoTime() - l) / 1000000.0D;
        IC.g();
        new StringBuilder().append("Beta device token load took ").append(d).append("ms").toString();
        return localObject1;
      }
      catch (IOException localIOException6)
      {
        IC.g();
      }
    }
    try
    {
      localZipInputStream.close();
      label190:
      throw localObject2;
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        IC.g();
      }
    }
  }
  
  String a(ZipInputStream paramZipInputStream)
  {
    String str2;
    do
    {
      ZipEntry localZipEntry = paramZipInputStream.getNextEntry();
      if (localZipEntry == null) {
        break;
      }
      str2 = localZipEntry.getName();
    } while (!str2.startsWith("assets/com.crashlytics.android.beta/dirfactor-device-token="));
    for (String str1 = str2.substring("assets/com.crashlytics.android.beta/dirfactor-device-token=".length(), -1 + str2.length());; str1 = "") {
      return str1;
    }
  }
  
  ZipInputStream b(Context paramContext)
  {
    return new ZipInputStream(new FileInputStream(paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0).sourceDir));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bn
 * JD-Core Version:    0.7.0.1
 */