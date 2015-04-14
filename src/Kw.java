import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Kw
  implements Kq
{
  private final Context a;
  private final File b;
  private final String c;
  private final File d;
  private Jw e;
  private File f;
  
  public Kw(Context paramContext, File paramFile, String paramString1, String paramString2)
  {
    this.a = paramContext;
    this.b = paramFile;
    this.c = paramString2;
    this.d = new File(this.b, paramString1);
    this.e = new Jw(this.d);
    e();
  }
  
  private void a(File paramFile1, File paramFile2)
  {
    OutputStream localOutputStream = null;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile1);
      Jg.a(localFileInputStream, "Failed to close file input stream");
    }
    finally
    {
      try
      {
        localOutputStream = a(paramFile2);
        Jg.a(localFileInputStream, localOutputStream, new byte[1024]);
        Jg.a(localFileInputStream, "Failed to close file input stream");
        Jg.a(localOutputStream, "Failed to close output stream");
        paramFile1.delete();
        return;
      }
      finally {}
      localObject1 = finally;
      localFileInputStream = null;
    }
    Jg.a(localOutputStream, "Failed to close output stream");
    paramFile1.delete();
    throw localObject1;
  }
  
  private void e()
  {
    this.f = new File(this.b, this.c);
    if (!this.f.exists()) {
      this.f.mkdirs();
    }
  }
  
  public int a()
  {
    return this.e.a();
  }
  
  public OutputStream a(File paramFile)
  {
    return new FileOutputStream(paramFile);
  }
  
  public List<File> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = this.f.listFiles();
    int i = arrayOfFile.length;
    for (int j = 0;; j++) {
      if (j < i)
      {
        localArrayList.add(arrayOfFile[j]);
        if (localArrayList.size() < paramInt) {}
      }
      else
      {
        return localArrayList;
      }
    }
  }
  
  public void a(String paramString)
  {
    this.e.close();
    a(this.d, new File(this.f, paramString));
    this.e = new Jw(this.d);
  }
  
  public void a(List<File> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      File localFile = (File)localIterator.next();
      Context localContext = this.a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localFile.getName();
      Jg.a(localContext, String.format("deleting sent analytics file %s", arrayOfObject));
      localFile.delete();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.e.a(paramArrayOfByte);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return this.e.a(paramInt1, paramInt2);
  }
  
  public boolean b()
  {
    return this.e.b();
  }
  
  public List<File> c()
  {
    return Arrays.asList(this.f.listFiles());
  }
  
  public void d()
  {
    try
    {
      this.e.close();
      label7:
      this.d.delete();
      return;
    }
    catch (IOException localIOException)
    {
      break label7;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Kw
 * JD-Core Version:    0.7.0.1
 */