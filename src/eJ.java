import java.util.SortedSet;
import java.util.TreeSet;

public class eJ
{
  private static final eJ d = new eJ();
  private SortedSet<eK> a = new TreeSet();
  private StringBuilder b = new StringBuilder();
  private boolean c = false;
  
  public static eJ a()
  {
    return d;
  }
  
  public void a(eK parameK)
  {
    try
    {
      if (!this.c)
      {
        this.a.add(parameK);
        this.b.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(parameK.ordinal()));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.c = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String b()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 6;
      int j = 0;
      while (this.a.size() > 0)
      {
        eK localeK = (eK)this.a.first();
        this.a.remove(localeK);
        int k = localeK.ordinal();
        while (k >= i)
        {
          localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(j));
          i += 6;
          j = 0;
        }
        j += (1 << localeK.ordinal() % 6);
      }
      if ((j > 0) || (localStringBuilder.length() == 0)) {
        localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(j));
      }
      this.a.clear();
      String str = localStringBuilder.toString();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String c()
  {
    try
    {
      if (this.b.length() > 0) {
        this.b.insert(0, ".");
      }
      String str = this.b.toString();
      this.b = new StringBuilder();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     eJ
 * JD-Core Version:    0.7.0.1
 */