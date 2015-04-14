import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.mpmetrics.Survey;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

public class ut
{
  private String a;
  private final String b;
  private final Set<Integer> c;
  private final Set<Integer> d;
  private final List<Survey> e;
  private final List<InAppNotification> f;
  private final uu g;
  private final wv h;
  
  public ut(String paramString, uu paramuu, wv paramwv)
  {
    this.b = paramString;
    this.g = paramuu;
    this.h = paramwv;
    this.a = null;
    this.e = new LinkedList();
    this.f = new LinkedList();
    this.c = new HashSet();
    this.d = new HashSet();
  }
  
  /* Error */
  public Survey a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	ut:e	Ljava/util/List;
    //   6: invokeinterface 54 1 0
    //   11: istore_3
    //   12: iload_3
    //   13: ifeq +11 -> 24
    //   16: aconst_null
    //   17: astore 4
    //   19: aload_0
    //   20: monitorexit
    //   21: aload 4
    //   23: areturn
    //   24: aload_0
    //   25: getfield 38	ut:e	Ljava/util/List;
    //   28: iconst_0
    //   29: invokeinterface 58 2 0
    //   34: checkcast 60	com/mixpanel/android/mpmetrics/Survey
    //   37: astore 4
    //   39: iload_1
    //   40: ifeq -21 -> 19
    //   43: aload_0
    //   44: getfield 38	ut:e	Ljava/util/List;
    //   47: aload_0
    //   48: getfield 38	ut:e	Ljava/util/List;
    //   51: invokeinterface 64 1 0
    //   56: aload 4
    //   58: invokeinterface 68 3 0
    //   63: goto -44 -> 19
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	ut
    //   0	71	1	paramBoolean	boolean
    //   66	4	2	localObject	Object
    //   11	2	3	bool	boolean
    //   17	40	4	localSurvey	Survey
    // Exception table:
    //   from	to	target	type
    //   2	12	66	finally
    //   24	63	66	finally
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(String paramString)
  {
    try
    {
      this.e.clear();
      this.f.clear();
      this.a = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(List<Survey> paramList, List<InAppNotification> paramList1, JSONArray paramJSONArray)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        this.h.a(paramJSONArray);
        Iterator localIterator1 = paramList.iterator();
        if (localIterator1.hasNext())
        {
          Survey localSurvey = (Survey)localIterator1.next();
          int m = localSurvey.b();
          if (this.c.contains(Integer.valueOf(m))) {
            break label284;
          }
          this.c.add(Integer.valueOf(m));
          this.e.add(localSurvey);
          n = 1;
          break label288;
        }
        Iterator localIterator2 = paramList1.iterator();
        if (localIterator2.hasNext())
        {
          InAppNotification localInAppNotification = (InAppNotification)localIterator2.next();
          int j = localInAppNotification.b();
          if (!this.d.contains(Integer.valueOf(j)))
          {
            this.d.add(Integer.valueOf(j));
            this.f.add(localInAppNotification);
            k = 1;
            break label295;
          }
        }
        else
        {
          if (uJ.a) {
            new StringBuilder().append("New Decide content has become available. ").append(paramList.size()).append(" surveys and ").append(paramList1.size()).append(" notifications have been added.").toString();
          }
          if ((i != 0) && (c()) && (this.g != null)) {
            this.g.a();
          }
          return;
        }
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
      int k = i;
      break label295;
      label284:
      int n = i;
      label288:
      i = n;
      continue;
      label295:
      i = k;
    }
  }
  
  public InAppNotification b(boolean paramBoolean)
  {
    for (;;)
    {
      InAppNotification localInAppNotification;
      try
      {
        if (this.f.isEmpty())
        {
          localInAppNotification = null;
          return localInAppNotification;
        }
        localInAppNotification = (InAppNotification)this.f.remove(0);
        if (paramBoolean)
        {
          this.f.add(this.f.size(), localInAppNotification);
          continue;
        }
        if (!uJ.a) {
          continue;
        }
      }
      finally {}
      new StringBuilder().append("Recording notification ").append(localInAppNotification).append(" as seen.").toString();
    }
  }
  
  public String b()
  {
    try
    {
      String str = this.a;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	ut:f	Ljava/util/List;
    //   6: invokeinterface 54 1 0
    //   11: ifeq +17 -> 28
    //   14: aload_0
    //   15: getfield 38	ut:e	Ljava/util/List;
    //   18: invokeinterface 54 1 0
    //   23: istore_3
    //   24: iload_3
    //   25: ifne +9 -> 34
    //   28: iconst_1
    //   29: istore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: iload_2
    //   33: ireturn
    //   34: iconst_0
    //   35: istore_2
    //   36: goto -6 -> 30
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	ut
    //   39	4	1	localObject	Object
    //   29	7	2	bool1	boolean
    //   23	2	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   2	24	39	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ut
 * JD-Core Version:    0.7.0.1
 */