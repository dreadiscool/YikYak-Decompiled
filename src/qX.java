import java.util.Locale;
import java.util.StringTokenizer;

final class qX
  extends pm<Locale>
{
  public Locale a(ro paramro)
  {
    Locale localLocale = null;
    if (paramro.f() == rq.i)
    {
      paramro.j();
      return localLocale;
    }
    StringTokenizer localStringTokenizer = new StringTokenizer(paramro.h(), "_");
    if (localStringTokenizer.hasMoreElements()) {}
    for (String str1 = localStringTokenizer.nextToken();; str1 = null)
    {
      if (localStringTokenizer.hasMoreElements()) {}
      for (String str2 = localStringTokenizer.nextToken();; str2 = null)
      {
        if (localStringTokenizer.hasMoreElements()) {}
        for (String str3 = localStringTokenizer.nextToken();; str3 = null)
        {
          if ((str2 == null) && (str3 == null))
          {
            localLocale = new Locale(str1);
            break;
          }
          if (str3 == null)
          {
            localLocale = new Locale(str1, str2);
            break;
          }
          localLocale = new Locale(str1, str2, str3);
          break;
        }
      }
    }
  }
  
  public void a(rr paramrr, Locale paramLocale)
  {
    if (paramLocale == null) {}
    for (String str = null;; str = paramLocale.toString())
    {
      paramrr.b(str);
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qX
 * JD-Core Version:    0.7.0.1
 */