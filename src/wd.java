import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class wd
  extends wu<Activity>
{
  private final Handler a = new Handler(Looper.getMainLooper());
  private final Map<String, List<wH>> b = new HashMap();
  private final Set<wf> c = new HashSet();
  
  private void a(View paramView, List<wH> paramList)
  {
    synchronized (this.c)
    {
      int i = paramList.size();
      for (int j = 0; j < i; j++)
      {
        wf localwf = new wf(paramView, (wH)paramList.get(j), this.a);
        this.c.add(localwf);
      }
      return;
    }
  }
  
  private void c()
  {
    if (Thread.currentThread() == this.a.getLooper().getThread()) {
      d();
    }
    for (;;)
    {
      return;
      this.a.post(new we(this));
    }
  }
  
  private void d()
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)localIterator.next();
      String str = localActivity.getClass().getCanonicalName();
      View localView = localActivity.getWindow().getDecorView().getRootView();
      synchronized (this.b)
      {
        List localList1 = (List)this.b.get(str);
        List localList2 = (List)this.b.get(null);
        if (localList1 != null) {
          a(localView, localList1);
        }
        if (localList2 != null) {
          a(localView, localList2);
        }
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    super.b(paramActivity);
    c();
  }
  
  /* Error */
  public void a(Map<String, List<wH>> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	wd:c	Ljava/util/Set;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 40	wd:c	Ljava/util/Set;
    //   11: invokeinterface 95 1 0
    //   16: astore 4
    //   18: aload 4
    //   20: invokeinterface 101 1 0
    //   25: ifeq +24 -> 49
    //   28: aload 4
    //   30: invokeinterface 105 1 0
    //   35: checkcast 49	wf
    //   38: invokevirtual 152	wf:a	()V
    //   41: goto -23 -> 18
    //   44: astore_3
    //   45: aload_2
    //   46: monitorexit
    //   47: aload_3
    //   48: athrow
    //   49: aload_0
    //   50: getfield 40	wd:c	Ljava/util/Set;
    //   53: invokeinterface 155 1 0
    //   58: aload_2
    //   59: monitorexit
    //   60: aload_0
    //   61: getfield 35	wd:b	Ljava/util/Map;
    //   64: astore 5
    //   66: aload 5
    //   68: monitorenter
    //   69: aload_0
    //   70: getfield 35	wd:b	Ljava/util/Map;
    //   73: invokeinterface 156 1 0
    //   78: aload_0
    //   79: getfield 35	wd:b	Ljava/util/Map;
    //   82: aload_1
    //   83: invokeinterface 159 2 0
    //   88: aload 5
    //   90: monitorexit
    //   91: aload_0
    //   92: invokespecial 147	wd:c	()V
    //   95: return
    //   96: astore 6
    //   98: aload 5
    //   100: monitorexit
    //   101: aload 6
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	wd
    //   0	104	1	paramMap	Map<String, List<wH>>
    //   4	55	2	localSet	Set
    //   44	4	3	localObject1	Object
    //   16	13	4	localIterator	Iterator
    //   96	6	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	47	44	finally
    //   49	60	44	finally
    //   69	91	96	finally
    //   98	101	96	finally
  }
  
  public void b(Activity paramActivity)
  {
    super.a(paramActivity);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wd
 * JD-Core Version:    0.7.0.1
 */