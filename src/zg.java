import java.net.SocketException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zg
{
  private static final zg a;
  private final int b;
  private final long c;
  private final LinkedList<zf> d = new LinkedList();
  private Executor e = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Ae.a("OkHttp ConnectionPool", true));
  private final Runnable f = new zh(this);
  
  static
  {
    String str1 = System.getProperty("http.keepAlive");
    String str2 = System.getProperty("http.keepAliveDuration");
    String str3 = System.getProperty("http.maxConnections");
    long l;
    if (str2 != null)
    {
      l = Long.parseLong(str2);
      if ((str1 == null) || (Boolean.parseBoolean(str1))) {
        break label58;
      }
      a = new zg(0, l);
    }
    for (;;)
    {
      return;
      l = 300000L;
      break;
      label58:
      if (str3 != null) {
        a = new zg(Integer.parseInt(str3), l);
      } else {
        a = new zg(5, l);
      }
    }
  }
  
  public zg(int paramInt, long paramLong)
  {
    this.b = paramInt;
    this.c = (1000L * (paramLong * 1000L));
  }
  
  public static zg a()
  {
    return a;
  }
  
  private void c()
  {
    while (b()) {}
  }
  
  private void c(zf paramzf)
  {
    boolean bool = this.d.isEmpty();
    this.d.addFirst(paramzf);
    if (bool) {
      this.e.execute(this.f);
    }
    for (;;)
    {
      return;
      notifyAll();
    }
  }
  
  public zf a(yJ paramyJ)
  {
    for (;;)
    {
      try
      {
        ListIterator localListIterator = this.d.listIterator(this.d.size());
        zf localzf;
        if (localListIterator.hasPrevious())
        {
          localzf = (zf)localListIterator.previous();
          if ((localzf.c().a().equals(paramyJ)) && (localzf.e()) && (System.nanoTime() - localzf.i() < this.c))
          {
            localListIterator.remove();
            boolean bool = localzf.k();
            if (!bool) {}
            try
            {
              zY.a().a(localzf.d());
              if ((localzf != null) && (localzf.k())) {
                this.d.addFirst(localzf);
              }
              return localzf;
            }
            catch (SocketException localSocketException)
            {
              Ae.a(localzf.d());
              zY.a().a("Unable to tagSocket(): " + localSocketException);
            }
          }
        }
        else
        {
          localzf = null;
        }
      }
      finally {}
    }
  }
  
  void a(zf paramzf)
  {
    if (paramzf.k()) {}
    for (;;)
    {
      return;
      if (paramzf.a())
      {
        if (paramzf.e()) {
          break label32;
        }
        Ae.a(paramzf.d());
        continue;
      }
      continue;
      try
      {
        label32:
        zY.a().b(paramzf.d());
        try
        {
          c(paramzf);
          paramzf.m();
          paramzf.g();
        }
        finally
        {
          localObject = finally;
          throw localObject;
        }
      }
      catch (SocketException localSocketException)
      {
        zY.a().a("Unable to untagSocket(): " + localSocketException);
        Ae.a(paramzf.d());
      }
    }
  }
  
  void b(zf paramzf)
  {
    if (!paramzf.k()) {
      throw new IllegalArgumentException();
    }
    if (!paramzf.e()) {}
    for (;;)
    {
      return;
      try
      {
        c(paramzf);
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  boolean b()
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        if (this.d.isEmpty())
        {
          bool2 = false;
          break label367;
        }
        localArrayList = new ArrayList();
        i = 0;
        long l1 = System.nanoTime();
        l2 = this.c;
        ListIterator localListIterator1 = this.d.listIterator(this.d.size());
        if (localListIterator1.hasPrevious())
        {
          zf localzf2 = (zf)localListIterator1.previous();
          long l4 = localzf2.i() + this.c - l1;
          if ((l4 <= 0L) || (!localzf2.e()))
          {
            localListIterator1.remove();
            localArrayList.add(localzf2);
            long l5 = l2;
            n = i;
            l6 = l5;
            break label370;
          }
          if (!localzf2.h()) {
            break label353;
          }
          int i1 = i + 1;
          l6 = Math.min(l2, l4);
          n = i1;
          break label370;
        }
        ListIterator localListIterator2 = this.d.listIterator(this.d.size());
        if ((localListIterator2.hasPrevious()) && (i > this.b))
        {
          zf localzf1 = (zf)localListIterator2.previous();
          if (!localzf1.h()) {
            break label347;
          }
          localArrayList.add(localzf1);
          localListIterator2.remove();
          m = i - 1;
          break label384;
        }
        boolean bool1 = localArrayList.isEmpty();
        if (!bool1) {}
      }
      finally
      {
        try
        {
          long l3 = l2 / 1000000L;
          wait(l3, (int)(l2 - 1000000L * l3));
          bool2 = true;
        }
        catch (InterruptedException localInterruptedException) {}
        localObject = finally;
      }
      int j = localArrayList.size();
      for (int k = 0; k < j; k++) {
        Ae.a(((zf)localArrayList.get(k)).d());
      }
      boolean bool2 = true;
      break label367;
      label347:
      int m = i;
      break label384;
      label353:
      long l8 = l2;
      int n = i;
      long l6 = l8;
      break label370;
      label367:
      return bool2;
      label370:
      long l7 = l6;
      int i = n;
      long l2 = l7;
      continue;
      label384:
      i = m;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zg
 * JD-Core Version:    0.7.0.1
 */