import java.io.File;
import java.io.FilenameFilter;

class ao
  implements FilenameFilter
{
  private final String a;
  
  public ao(String paramString)
  {
    this.a = paramString;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    boolean bool = false;
    if (paramString.equals(this.a + ".cls")) {}
    for (;;)
    {
      return bool;
      if ((paramString.contains(this.a)) && (!paramString.endsWith(".cls_temp"))) {
        bool = true;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ao
 * JD-Core Version:    0.7.0.1
 */