import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class Kv
  extends Kw
{
  public Kv(Context paramContext, File paramFile, String paramString1, String paramString2)
  {
    super(paramContext, paramFile, paramString1, paramString2);
  }
  
  public OutputStream a(File paramFile)
  {
    return new GZIPOutputStream(new FileOutputStream(paramFile));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Kv
 * JD-Core Version:    0.7.0.1
 */