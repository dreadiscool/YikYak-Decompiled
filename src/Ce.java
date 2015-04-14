import android.content.Context;
import android.os.Handler;

public class Ce
{
  public static final zt a = zt.a("application/x-www-form-urlencoded");
  private static Ce b;
  
  public static Ce a()
  {
    try
    {
      if (b == null) {
        b = new Ce();
      }
      Ce localCe = b;
      return localCe;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(Context paramContext, zz paramzz, Class paramClass, Cj paramCj)
  {
    Im.a(false).a(paramzz).a(new Cf(this, paramClass, new Handler(paramContext.getMainLooper()), paramCj, paramzz));
  }
  
  public void a(Context paramContext, Cr paramCr, Cj paramCj)
  {
    switch (Ci.a[paramCr.e().ordinal()])
    {
    }
    for (;;)
    {
      return;
      a(paramContext, paramCr.b(), paramCr.a(), paramCj);
      continue;
      String str = Ir.a.a(paramCr, paramCr.getClass());
      a(paramContext, paramCr.b(), str, paramCr.a(), paramCj);
    }
  }
  
  public void a(Context paramContext, String paramString, Class paramClass, Cj paramCj)
  {
    a(paramContext, new zB().a().a(paramString).b(), paramClass, paramCj);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, Class paramClass, Cj paramCj)
  {
    a(paramContext, new zB().a(paramString1).a(zC.a(null, paramString2)).b(), paramClass, paramCj);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ce
 * JD-Core Version:    0.7.0.1
 */