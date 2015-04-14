import java.io.File;
import java.io.FilenameFilter;

class ad
  implements FilenameFilter
{
  ad(Y paramY, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith(this.a);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ad
 * JD-Core Version:    0.7.0.1
 */