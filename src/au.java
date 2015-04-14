import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;

class au
{
  private final Context a;
  private final File b;
  private Jw c;
  
  public au(Context paramContext, File paramFile)
  {
    this.a = paramContext;
    this.b = paramFile;
  }
  
  static A a(Jw paramJw)
  {
    A localA;
    if (paramJw == null) {
      localA = null;
    }
    for (;;)
    {
      return localA;
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 0;
      byte[] arrayOfByte = new byte[paramJw.a()];
      try
      {
        paramJw.a(new av(arrayOfByte, arrayOfInt));
        localA = A.a(arrayOfByte, 0, arrayOfInt[0]);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          IC.g();
        }
      }
    }
  }
  
  private boolean b()
  {
    boolean bool = false;
    if (!Jg.a(this.a, "com.crashlytics.CollectCustomLogs", true)) {
      IC.g();
    }
    for (;;)
    {
      return bool;
      Jg.a(this.c, "Could not close log file: " + this.c);
      try
      {
        String str = "crashlytics-userlog-" + UUID.randomUUID().toString() + ".temp";
        localFile = new File(this.b, str);
      }
      catch (Exception localException1)
      {
        try
        {
          this.c = new Jw(localFile);
          localFile.delete();
          bool = true;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            File localFile;
            Object localObject = localFile;
          }
        }
        localException1 = localException1;
        localObject = null;
      }
      IC.g();
      new StringBuilder().append("Could not create log file: ").append(localObject).toString();
    }
  }
  
  Jw a()
  {
    return this.c;
  }
  
  public void a(long paramLong, String paramString)
  {
    if (this.c == null) {
      b();
    }
    a(this.c, 65536, paramLong, paramString);
  }
  
  void a(Jw paramJw, int paramInt, long paramLong, String paramString)
  {
    if (paramJw == null) {
      return;
    }
    if (paramString == null) {}
    for (String str1 = "null";; str1 = paramString) {
      try
      {
        int i = paramInt / 4;
        if (str1.length() > i) {
          str1 = "..." + str1.substring(str1.length() - i);
        }
        String str2 = str1.replaceAll("\r", " ").replaceAll("\n", " ");
        Locale localLocale = Locale.US;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Long.valueOf(paramLong);
        arrayOfObject[1] = str2;
        paramJw.a(String.format(localLocale, "%d %s%n", arrayOfObject).getBytes("UTF-8"));
        while ((!paramJw.b()) && (paramJw.a() > paramInt)) {
          paramJw.c();
        }
      }
      catch (IOException localIOException)
      {
        IC.g();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     au
 * JD-Core Version:    0.7.0.1
 */