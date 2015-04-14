import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Kh<T>
{
  protected final Context a;
  protected final Kg<T> b;
  protected final Jl c;
  protected final Kq d;
  protected volatile long e;
  protected final List<Kr> f = new CopyOnWriteArrayList();
  private final int g;
  
  public Kh(Context paramContext, Kg<T> paramKg, Jl paramJl, Kq paramKq, int paramInt)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramKg;
    this.d = paramKq;
    this.c = paramJl;
    this.e = this.c.a();
    this.g = paramInt;
  }
  
  private void a(int paramInt)
  {
    if (!this.d.a(paramInt, c()))
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(this.d.a());
      arrayOfObject[1] = Integer.valueOf(paramInt);
      arrayOfObject[2] = Integer.valueOf(c());
      String str = String.format(localLocale, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", arrayOfObject);
      Jg.a(this.a, 4, "Fabric", str);
      d();
    }
  }
  
  private void b(String paramString)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      Kr localKr = (Kr)localIterator.next();
      try
      {
        localKr.a(paramString);
      }
      catch (Exception localException)
      {
        Jg.a(this.a, "One of the roll over listeners threw an exception", localException);
      }
    }
  }
  
  public long a(String paramString)
  {
    long l1 = 0L;
    String[] arrayOfString = paramString.split("_");
    if (arrayOfString.length != 3) {}
    for (;;)
    {
      return l1;
      try
      {
        long l2 = Long.valueOf(arrayOfString[2]).longValue();
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
  }
  
  protected abstract String a();
  
  public void a(Kr paramKr)
  {
    if (paramKr != null) {
      this.f.add(paramKr);
    }
  }
  
  public void a(T paramT)
  {
    byte[] arrayOfByte = this.b.a(paramT);
    a(arrayOfByte.length);
    this.d.a(arrayOfByte);
  }
  
  public void a(List<File> paramList)
  {
    this.d.a(paramList);
  }
  
  protected int b()
  {
    return this.g;
  }
  
  protected int c()
  {
    return 8000;
  }
  
  public boolean d()
  {
    boolean bool = true;
    String str = null;
    if (!this.d.b())
    {
      str = a();
      this.d.a(str);
      Context localContext = this.a;
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[bool];
      arrayOfObject[0] = str;
      Jg.a(localContext, 4, "Fabric", String.format(localLocale, "generated new file %s", arrayOfObject));
      this.e = this.c.a();
    }
    for (;;)
    {
      b(str);
      return bool;
      bool = false;
    }
  }
  
  public List<File> e()
  {
    return this.d.a(1);
  }
  
  public void f()
  {
    this.d.a(this.d.c());
    this.d.d();
  }
  
  public void g()
  {
    List localList = this.d.c();
    int i = b();
    if (localList.size() <= i) {}
    for (;;)
    {
      return;
      int j = localList.size() - i;
      Context localContext = this.a;
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(localList.size());
      arrayOfObject[1] = Integer.valueOf(i);
      arrayOfObject[2] = Integer.valueOf(j);
      Jg.a(localContext, String.format(localLocale, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", arrayOfObject));
      TreeSet localTreeSet = new TreeSet(new Ki(this));
      Iterator localIterator1 = localList.iterator();
      while (localIterator1.hasNext())
      {
        File localFile = (File)localIterator1.next();
        localTreeSet.add(new Kj(localFile, a(localFile.getName())));
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator2 = localTreeSet.iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        localArrayList.add(((Kj)localIterator2.next()).a);
      } while (localArrayList.size() != j);
      this.d.a(localArrayList);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Kh
 * JD-Core Version:    0.7.0.1
 */