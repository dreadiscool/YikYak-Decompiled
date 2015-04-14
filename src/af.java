import java.io.File;
import java.util.Comparator;

final class af
  implements Comparator<File>
{
  public int a(File paramFile1, File paramFile2)
  {
    return paramFile2.getName().compareTo(paramFile1.getName());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     af
 * JD-Core Version:    0.7.0.1
 */