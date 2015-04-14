import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class aK
{
  static final Map<String, String> a;
  private static final FilenameFilter b = new aL();
  private static final short[] c;
  private final Object d = new Object();
  private final aq e;
  private Thread f;
  
  static
  {
    a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
    short[] arrayOfShort = new short[6];
    arrayOfShort[0] = 10;
    arrayOfShort[1] = 20;
    arrayOfShort[2] = 30;
    arrayOfShort[3] = 60;
    arrayOfShort[4] = 120;
    arrayOfShort[5] = 300;
    c = arrayOfShort;
  }
  
  public aK(aq paramaq)
  {
    if (paramaq == null) {
      throw new IllegalArgumentException("createReportCall must not be null.");
    }
    this.e = paramaq;
  }
  
  List<aJ> a()
  {
    IC.g();
    LinkedList localLinkedList;
    synchronized (this.d)
    {
      File[] arrayOfFile = G.f().u().listFiles(b);
      localLinkedList = new LinkedList();
      int i = arrayOfFile.length;
      int j = 0;
      if (j < i)
      {
        File localFile = arrayOfFile[j];
        IC.g();
        new StringBuilder().append("Found crash report ").append(localFile.getPath()).toString();
        localLinkedList.add(new aO(localFile));
        j++;
      }
    }
    if (localLinkedList.isEmpty()) {
      IC.g();
    }
    return localLinkedList;
  }
  
  public void a(float paramFloat)
  {
    try
    {
      if (this.f == null)
      {
        this.f = new Thread(new aM(this, paramFloat), "Crashlytics Report Uploader");
        this.f.start();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean a(aJ paramaJ)
  {
    boolean bool1 = false;
    synchronized (this.d)
    {
      try
      {
        Context localContext = G.f().C();
        ap localap = new ap(new Je().a(localContext), paramaJ);
        boolean bool2 = this.e.a(localap);
        IC.g();
        StringBuilder localStringBuilder = new StringBuilder().append("Crashlytics report upload ");
        if (!bool2) {
          break label117;
        }
        str = "complete: ";
        localStringBuilder.append(str).append(paramaJ.b()).toString();
        if (bool2)
        {
          paramaJ.a();
          bool1 = true;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str;
          label117:
          IC.g();
          new StringBuilder().append("Error occurred sending report ").append(paramaJ).toString();
        }
      }
      return bool1;
      str = "FAILED: ";
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     aK
 * JD-Core Version:    0.7.0.1
 */