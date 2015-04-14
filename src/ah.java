import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class ah
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return Y.h().matcher(paramString).matches();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ah
 * JD-Core Version:    0.7.0.1
 */