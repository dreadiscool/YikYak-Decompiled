import java.io.File;
import java.util.Comparator;

final class Jh
  implements Comparator<File>
{
  public int a(File paramFile1, File paramFile2)
  {
    return (int)(paramFile1.lastModified() - paramFile2.lastModified());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Jh
 * JD-Core Version:    0.7.0.1
 */