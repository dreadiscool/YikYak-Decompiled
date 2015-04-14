import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class rK
{
  private static rK f;
  private final rO a;
  private final Context b;
  private final rx c;
  private volatile rP d;
  private final ConcurrentMap<String, rv> e;
  
  @VisibleForTesting
  rK(Context paramContext, rO paramrO, rx paramrx)
  {
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.b = paramContext.getApplicationContext();
    this.a = paramrO;
    this.d = rP.a;
    this.e = new ConcurrentHashMap();
    this.c = paramrx;
    this.c.a(new rL(this));
    this.c.a(new rt(this.b));
  }
  
  public static rK a(Context paramContext)
  {
    try
    {
      if (f == null) {
        f = new rK(paramContext, new rM(), new rx());
      }
      rK localrK = f;
      return localrK;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public rP a()
  {
    return this.d;
  }
  
  public boolean a(Uri paramUri)
  {
    for (;;)
    {
      rF localrF;
      String str;
      boolean bool;
      try
      {
        localrF = rF.a();
        if (!localrF.a(paramUri)) {
          break label215;
        }
        str = localrF.d();
        int i = rN.a[localrF.b().ordinal()];
        switch (i)
        {
        default: 
          bool = true;
          return bool;
        }
      }
      finally {}
      rv localrv2 = (rv)this.e.get(str);
      if (localrv2 != null)
      {
        localrv2.a(null);
        localrv2.a();
        continue;
        Iterator localIterator = this.e.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          rv localrv1 = (rv)localEntry.getValue();
          if (((String)localEntry.getKey()).equals(str))
          {
            localrv1.a(localrF.c());
            localrv1.a();
          }
          else if (localrv1.b() != null)
          {
            localrv1.a(null);
            localrv1.a();
          }
        }
        continue;
        label215:
        bool = false;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     rK
 * JD-Core Version:    0.7.0.1
 */