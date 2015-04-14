import java.io.File;
import java.util.Comparator;

final class ag
  implements Comparator<File>
{
  public int a(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareTo(paramFile2.getName());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ag
 * JD-Core Version:    0.7.0.1
 */