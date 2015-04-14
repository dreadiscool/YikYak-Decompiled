import android.content.Context;
import java.io.File;

public class KP
{
  private final Context a;
  private final String b;
  private final String c;
  
  public KP(IM paramIM)
  {
    if (paramIM.C() == null) {
      throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }
    this.a = paramIM.C();
    this.b = paramIM.E();
    this.c = ("Android/" + this.a.getPackageName());
  }
  
  public File a()
  {
    return a(this.a.getFilesDir());
  }
  
  File a(File paramFile)
  {
    if (paramFile != null)
    {
      if ((paramFile.exists()) || (paramFile.mkdirs())) {
        return paramFile;
      }
      IC.g();
    }
    for (;;)
    {
      paramFile = null;
      break;
      IC.g();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     KP
 * JD-Core Version:    0.7.0.1
 */