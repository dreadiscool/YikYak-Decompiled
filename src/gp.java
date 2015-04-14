import android.os.Build.VERSION;
import java.io.File;

public class gp
{
  public static int a()
  {
    try
    {
      int j = Integer.parseInt(Build.VERSION.SDK);
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        fA.a("Invalid version number: " + Build.VERSION.SDK);
        int i = 0;
      }
    }
    return i;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = false;
    if (a() < 9) {}
    for (;;)
    {
      return bool;
      File localFile = new File(paramString);
      localFile.setReadable(false, false);
      localFile.setWritable(false, false);
      localFile.setReadable(true, true);
      localFile.setWritable(true, true);
      bool = true;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gp
 * JD-Core Version:    0.7.0.1
 */