import java.io.File;
import java.io.FilenameFilter;

final class D
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(".cls_temp");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     D
 * JD-Core Version:    0.7.0.1
 */