import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

final class aP
{
  public static void a(File paramFile, FilenameFilter paramFilenameFilter, int paramInt, Comparator<File> paramComparator)
  {
    File[] arrayOfFile = paramFile.listFiles(paramFilenameFilter);
    int i;
    int j;
    if ((arrayOfFile != null) && (arrayOfFile.length > paramInt))
    {
      Arrays.sort(arrayOfFile, paramComparator);
      i = arrayOfFile.length;
      j = arrayOfFile.length;
    }
    for (int k = 0;; k++)
    {
      File localFile;
      if (k < j)
      {
        localFile = arrayOfFile[k];
        if (i > paramInt) {}
      }
      else
      {
        return;
      }
      localFile.delete();
      i--;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     aP
 * JD-Core Version:    0.7.0.1
 */