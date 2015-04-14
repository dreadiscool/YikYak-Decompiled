import java.io.File;
import java.io.FilenameFilter;

class an
  implements FilenameFilter
{
  private final String a;
  
  public an(String paramString)
  {
    this.a = paramString;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    if ((paramString.contains(this.a)) && (!paramString.endsWith(".cls_temp"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     an
 * JD-Core Version:    0.7.0.1
 */