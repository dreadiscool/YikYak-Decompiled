import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class IC
{
  static volatile IC a;
  static final IO b = new IB();
  final IO c;
  final boolean d;
  private final Context e;
  private final Map<Class<? extends IM>, IM> f;
  private final ExecutorService g;
  private final Handler h;
  private final IH<IC> i;
  private final IH<?> j;
  private final Js k;
  private Ix l;
  private WeakReference<Activity> m;
  private IP n;
  private AtomicBoolean o;
  
  IC(Context paramContext, Map<Class<? extends IM>, IM> paramMap, Ka paramKa, Handler paramHandler, IO paramIO, boolean paramBoolean, IH paramIH, Js paramJs)
  {
    this.e = paramContext;
    this.f = paramMap;
    this.g = paramKa;
    this.h = paramHandler;
    this.c = paramIO;
    this.d = paramBoolean;
    this.i = paramIH;
    this.o = new AtomicBoolean(false);
    this.j = a(paramMap.size());
    this.k = paramJs;
  }
  
  static IC a()
  {
    if (a == null) {
      throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }
    return a;
  }
  
  public static IC a(Context paramContext, IM... paramVarArgs)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        c(new IF(paramContext).a(paramVarArgs).a());
      }
      return a;
    }
    finally {}
  }
  
  public static <T extends IM> T a(Class<T> paramClass)
  {
    return (IM)a().f.get(paramClass);
  }
  
  private static void a(Map<Class<? extends IM>, IM> paramMap, Collection<? extends IM> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      IM localIM = (IM)localIterator.next();
      paramMap.put(localIM.getClass(), localIM);
      if ((localIM instanceof IN)) {
        a(paramMap, ((IN)localIM).e());
      }
    }
  }
  
  private Activity b(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {}
    for (Activity localActivity = (Activity)paramContext;; localActivity = null) {
      return localActivity;
    }
  }
  
  private static Map<Class<? extends IM>, IM> b(Collection<? extends IM> paramCollection)
  {
    HashMap localHashMap = new HashMap(paramCollection.size());
    a(localHashMap, paramCollection);
    return localHashMap;
  }
  
  private static void c(IC paramIC)
  {
    a = paramIC;
    paramIC.i();
  }
  
  public static IO g()
  {
    if (a == null) {}
    for (IO localIO = b;; localIO = a.c) {
      return localIO;
    }
  }
  
  public static boolean h()
  {
    if (a == null) {}
    for (boolean bool = false;; bool = a.d) {
      return bool;
    }
  }
  
  private void i()
  {
    a(b(this.e));
    this.l = new Ix(this.e);
    this.l.a(new ID(this));
    a(this.e);
  }
  
  public IC a(Activity paramActivity)
  {
    this.m = new WeakReference(paramActivity);
    return this;
  }
  
  IH<?> a(int paramInt)
  {
    return new IE(this, paramInt);
  }
  
  void a(Context paramContext)
  {
    Collection localCollection = f();
    this.n = new IP(localCollection);
    ArrayList localArrayList = new ArrayList(localCollection);
    Collections.sort(localArrayList);
    this.n.a(paramContext, this, IH.d, this.k);
    Iterator localIterator1 = localArrayList.iterator();
    while (localIterator1.hasNext()) {
      ((IM)localIterator1.next()).a(paramContext, this, this.j, this.k);
    }
    this.n.A();
    if (g().a("Fabric", 3)) {}
    for (StringBuilder localStringBuilder = new StringBuilder("Initializing ").append(d()).append(" [Version: ").append(c()).append("], with the following kits:\n");; localStringBuilder = null)
    {
      Iterator localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext())
      {
        IM localIM = (IM)localIterator2.next();
        localIM.c.a(this.n.c);
        a(this.f, localIM);
        localIM.A();
        if (localStringBuilder != null) {
          localStringBuilder.append(localIM.c()).append(" [Version: ").append(localIM.d()).append("]\n");
        }
      }
    }
    if (localStringBuilder != null)
    {
      g();
      localStringBuilder.toString();
    }
  }
  
  void a(Map<Class<? extends IM>, IM> paramMap, IM paramIM)
  {
    JR localJR = (JR)paramIM.getClass().getAnnotation(JR.class);
    if (localJR != null) {
      for (Class localClass : localJR.a())
      {
        if (localClass.isInterface())
        {
          Iterator localIterator = paramMap.values().iterator();
          while (localIterator.hasNext())
          {
            IM localIM = (IM)localIterator.next();
            if (localClass.isAssignableFrom(localIM.getClass())) {
              paramIM.c.a(localIM.c);
            }
          }
        }
        if ((IM)paramMap.get(localClass) == null) {
          throw new Kd("Referenced Kit was null, does the kit exist?");
        }
        paramIM.c.a(((IM)paramMap.get(localClass)).c);
      }
    }
  }
  
  public Activity b()
  {
    if (this.m != null) {}
    for (Activity localActivity = (Activity)this.m.get();; localActivity = null) {
      return localActivity;
    }
  }
  
  public String c()
  {
    return "1.2.0.37";
  }
  
  public String d()
  {
    return "io.fabric.sdk.android:fabric";
  }
  
  public ExecutorService e()
  {
    return this.g;
  }
  
  public Collection<IM> f()
  {
    return this.f.values();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     IC
 * JD-Core Version:    0.7.0.1
 */