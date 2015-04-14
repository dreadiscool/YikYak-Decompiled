import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class aN
{
  private static final A a = A.a("0");
  private ActivityManager.RunningAppProcessInfo b;
  private Thread[] c;
  private List<StackTraceElement[]> d;
  private StackTraceElement[] e;
  private final Context f;
  private final A g;
  private final A h;
  private final int i = 8;
  
  public aN(Context paramContext, String paramString1, String paramString2)
  {
    this.f = paramContext;
    this.g = A.a(paramString2);
    if (paramString1 == null) {}
    for (A localA = null;; localA = A.a(paramString1.replace("-", "")))
    {
      this.h = localA;
      return;
    }
  }
  
  private int a()
  {
    return 0 + E.b(1, A.a(new Je().a(this.f)));
  }
  
  private int a(float paramFloat, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong1, long paramLong2)
  {
    return 0 + E.b(1, paramFloat) + E.h(2, paramInt1) + E.b(3, paramBoolean) + E.f(4, paramInt2) + E.b(5, paramLong1) + E.b(6, paramLong2);
  }
  
  private int a(int paramInt1, A paramA1, A paramA2, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, Map<Jt, String> paramMap, int paramInt3, A paramA3, A paramA4)
  {
    int j = 0 + E.b(1, paramA1) + E.g(3, paramInt1);
    if (paramA2 == null) {}
    int m;
    for (int k = 0;; k = E.b(4, paramA2))
    {
      m = k + j + E.f(5, paramInt2) + E.b(6, paramLong1) + E.b(7, paramLong2) + E.b(10, paramBoolean);
      if (paramMap == null) {
        break;
      }
      Iterator localIterator = paramMap.entrySet().iterator();
      n = m;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        int i5 = a((Jt)localEntry.getKey(), (String)localEntry.getValue());
        n += i5 + (E.j(11) + E.l(i5));
      }
    }
    int n = m;
    int i1 = n + E.f(12, paramInt3);
    int i2;
    int i3;
    if (paramA3 == null)
    {
      i2 = 0;
      i3 = i1 + i2;
      if (paramA4 != null) {
        break label220;
      }
    }
    label220:
    for (int i4 = 0;; i4 = E.b(14, paramA4))
    {
      return i4 + i3;
      i2 = E.b(13, paramA3);
      break;
    }
  }
  
  private int a(A paramA)
  {
    return E.b(1, paramA);
  }
  
  private int a(A paramA1, A paramA2, A paramA3, A paramA4, int paramInt)
  {
    int j = 0 + E.b(1, paramA1) + E.b(2, paramA2) + E.b(3, paramA3);
    int k = a();
    return j + (k + (E.j(5) + E.l(k))) + E.b(6, paramA4) + E.g(10, paramInt);
  }
  
  private int a(A paramA1, A paramA2, boolean paramBoolean)
  {
    return 0 + E.g(1, 3) + E.b(2, paramA1) + E.b(3, paramA2) + E.b(4, paramBoolean);
  }
  
  private int a(Jt paramJt, String paramString)
  {
    return E.g(1, paramJt.h) + E.b(2, A.a(paramString));
  }
  
  private int a(StackTraceElement paramStackTraceElement, boolean paramBoolean)
  {
    int j;
    int k;
    if (paramStackTraceElement.isNativeMethod())
    {
      j = 0 + E.b(1, Math.max(paramStackTraceElement.getLineNumber(), 0));
      k = j + E.b(2, A.a(paramStackTraceElement.getClassName() + "." + paramStackTraceElement.getMethodName()));
      if (paramStackTraceElement.getFileName() != null) {
        k += E.b(3, A.a(paramStackTraceElement.getFileName()));
      }
      if ((paramStackTraceElement.isNativeMethod()) || (paramStackTraceElement.getLineNumber() <= 0)) {
        break label148;
      }
    }
    label148:
    for (int m = k + E.b(4, paramStackTraceElement.getLineNumber());; m = k)
    {
      if (paramBoolean) {}
      for (int n = 2;; n = 0)
      {
        return m + E.f(5, n);
        j = 0 + E.b(1, 0L);
        break;
      }
    }
  }
  
  private int a(String paramString1, String paramString2)
  {
    int j = E.b(1, A.a(paramString1));
    if (paramString2 == null) {
      paramString2 = "";
    }
    return j + E.b(2, A.a(paramString2));
  }
  
  private int a(Thread paramThread, Throwable paramThrowable)
  {
    int j = a(paramThread, this.e, 4, true);
    int k = 0 + (j + (E.j(1) + E.l(j)));
    int m = this.c.length;
    int n = 0;
    int i1 = k;
    while (n < m)
    {
      int i7 = a(this.c[n], (StackTraceElement[])this.d.get(n), 0, false);
      i1 += i7 + (E.j(1) + E.l(i7));
      n++;
    }
    int i2 = a(paramThrowable, 1);
    int i3 = i1 + (i2 + (E.j(2) + E.l(i2)));
    int i4 = c();
    int i5 = i3 + (i4 + (E.j(3) + E.l(i4)));
    int i6 = b();
    return i5 + (i6 + (E.j(3) + E.l(i6)));
  }
  
  private int a(Thread paramThread, Throwable paramThrowable, int paramInt, Map<String, String> paramMap)
  {
    int j = a(paramThread, paramThrowable);
    int k = 0 + (j + (E.j(1) + E.l(j)));
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      m = k;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        int n = a((String)localEntry.getKey(), (String)localEntry.getValue());
        m += n + (E.j(2) + E.l(n));
      }
    }
    int m = k;
    if (this.b != null) {
      if (this.b.importance == 100) {
        break label163;
      }
    }
    label163:
    for (boolean bool = true;; bool = false)
    {
      m += E.b(3, bool);
      return m + E.f(4, paramInt);
    }
  }
  
  private int a(Thread paramThread, Throwable paramThrowable, String paramString, long paramLong1, Map<String, String> paramMap, float paramFloat, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong2, long paramLong3, A paramA)
  {
    int j = 0 + E.b(1, paramLong1) + E.b(2, A.a(paramString));
    int k = a(paramThread, paramThrowable, paramInt2, paramMap);
    int m = j + (k + (E.j(3) + E.l(k)));
    int n = a(paramFloat, paramInt1, paramBoolean, paramInt2, paramLong2, paramLong3);
    int i1 = m + (n + (E.j(5) + E.l(n)));
    if (paramA != null)
    {
      int i2 = a(paramA);
      i1 += i2 + (E.j(6) + E.l(i2));
    }
    return i1;
  }
  
  private int a(Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, int paramInt, boolean paramBoolean)
  {
    int j = E.b(1, A.a(paramThread.getName())) + E.f(2, paramInt);
    int k = paramArrayOfStackTraceElement.length;
    for (int m = 0; m < k; m++)
    {
      int n = a(paramArrayOfStackTraceElement[m], paramBoolean);
      j += n + (E.j(3) + E.l(n));
    }
    return j;
  }
  
  private int a(Throwable paramThrowable, int paramInt)
  {
    int j = 0;
    int k = 0 + E.b(1, A.a(paramThrowable.getClass().getName()));
    String str = paramThrowable.getLocalizedMessage();
    if (str != null) {
      k += E.b(3, A.a(str));
    }
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    int m = arrayOfStackTraceElement.length;
    int n = 0;
    while (n < m)
    {
      int i2 = a(arrayOfStackTraceElement[n], true);
      int i3 = k + (i2 + (E.j(4) + E.l(i2)));
      n++;
      k = i3;
    }
    Throwable localThrowable = paramThrowable.getCause();
    if (localThrowable != null)
    {
      if (paramInt >= this.i) {
        break label158;
      }
      int i1 = a(localThrowable, paramInt + 1);
      k += i1 + (E.j(6) + E.l(i1));
    }
    for (;;)
    {
      return k;
      label158:
      while (localThrowable != null)
      {
        localThrowable = localThrowable.getCause();
        j++;
      }
      k += E.f(7, j);
    }
  }
  
  private A a(String paramString)
  {
    if (paramString == null) {}
    for (A localA = null;; localA = A.a(paramString)) {
      return localA;
    }
  }
  
  private void a(E paramE, float paramFloat, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong1, long paramLong2)
  {
    paramE.i(5, 2);
    paramE.k(a(paramFloat, paramInt1, paramBoolean, paramInt2, paramLong1, paramLong2));
    paramE.a(1, paramFloat);
    paramE.d(2, paramInt1);
    paramE.a(3, paramBoolean);
    paramE.b(4, paramInt2);
    paramE.a(5, paramLong1);
    paramE.a(6, paramLong2);
  }
  
  private void a(E paramE, int paramInt, StackTraceElement paramStackTraceElement, boolean paramBoolean)
  {
    int j = 4;
    paramE.i(paramInt, 2);
    paramE.k(a(paramStackTraceElement, paramBoolean));
    if (paramStackTraceElement.isNativeMethod())
    {
      paramE.a(1, Math.max(paramStackTraceElement.getLineNumber(), 0));
      paramE.a(2, A.a(paramStackTraceElement.getClassName() + "." + paramStackTraceElement.getMethodName()));
      if (paramStackTraceElement.getFileName() != null) {
        paramE.a(3, A.a(paramStackTraceElement.getFileName()));
      }
      if ((!paramStackTraceElement.isNativeMethod()) && (paramStackTraceElement.getLineNumber() > 0)) {
        paramE.a(j, paramStackTraceElement.getLineNumber());
      }
      if (!paramBoolean) {
        break label144;
      }
    }
    for (;;)
    {
      paramE.b(5, j);
      return;
      paramE.a(1, 0L);
      break;
      label144:
      j = 0;
    }
  }
  
  private void a(E paramE, A paramA)
  {
    if (paramA != null)
    {
      paramE.i(6, 2);
      paramE.k(a(paramA));
      paramE.a(1, paramA);
    }
  }
  
  private void a(E paramE, Thread paramThread, Throwable paramThrowable)
  {
    paramE.i(1, 2);
    paramE.k(a(paramThread, paramThrowable));
    a(paramE, paramThread, this.e, 4, true);
    int j = this.c.length;
    for (int k = 0; k < j; k++) {
      a(paramE, this.c[k], (StackTraceElement[])this.d.get(k), 0, false);
    }
    a(paramE, paramThrowable, 1, 2);
    paramE.i(3, 2);
    paramE.k(c());
    paramE.a(1, a);
    paramE.a(2, a);
    paramE.a(3, 0L);
    paramE.i(4, 2);
    paramE.k(b());
    paramE.a(1, 0L);
    paramE.a(2, 0L);
    paramE.a(3, this.g);
    if (this.h != null) {
      paramE.a(4, this.h);
    }
  }
  
  private void a(E paramE, Thread paramThread, Throwable paramThrowable, int paramInt, Map<String, String> paramMap)
  {
    paramE.i(3, 2);
    paramE.k(a(paramThread, paramThrowable, paramInt, paramMap));
    a(paramE, paramThread, paramThrowable);
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      a(paramE, paramMap);
    }
    if (this.b != null) {
      if (this.b.importance == 100) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      paramE.a(3, bool);
      paramE.b(4, paramInt);
      return;
    }
  }
  
  private void a(E paramE, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, int paramInt, boolean paramBoolean)
  {
    paramE.i(1, 2);
    paramE.k(a(paramThread, paramArrayOfStackTraceElement, paramInt, paramBoolean));
    paramE.a(1, A.a(paramThread.getName()));
    paramE.b(2, paramInt);
    int j = paramArrayOfStackTraceElement.length;
    for (int k = 0; k < j; k++) {
      a(paramE, 3, paramArrayOfStackTraceElement[k], paramBoolean);
    }
  }
  
  private void a(E paramE, Throwable paramThrowable, int paramInt1, int paramInt2)
  {
    int j = 0;
    paramE.i(paramInt2, 2);
    paramE.k(a(paramThrowable, 1));
    paramE.a(1, A.a(paramThrowable.getClass().getName()));
    String str = paramThrowable.getLocalizedMessage();
    if (str != null) {
      paramE.a(3, A.a(str));
    }
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    int k = arrayOfStackTraceElement.length;
    for (int m = 0; m < k; m++) {
      a(paramE, 4, arrayOfStackTraceElement[m], true);
    }
    Throwable localThrowable = paramThrowable.getCause();
    if (localThrowable != null)
    {
      if (paramInt1 >= this.i) {
        break label127;
      }
      a(paramE, localThrowable, paramInt1 + 1, 6);
    }
    for (;;)
    {
      return;
      label127:
      while (localThrowable != null)
      {
        localThrowable = localThrowable.getCause();
        j++;
      }
      paramE.b(7, j);
    }
  }
  
  private void a(E paramE, Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramE.i(2, 2);
      paramE.k(a((String)localEntry.getKey(), (String)localEntry.getValue()));
      paramE.a(1, A.a((String)localEntry.getKey()));
      String str = (String)localEntry.getValue();
      if (str == null) {
        str = "";
      }
      paramE.a(2, A.a(str));
    }
  }
  
  private int b()
  {
    int j = 0 + E.b(1, 0L) + E.b(2, 0L) + E.b(3, this.g);
    if (this.h != null) {
      j += E.b(4, this.h);
    }
    return j;
  }
  
  private int c()
  {
    return 0 + E.b(1, a) + E.b(2, a) + E.b(3, 0L);
  }
  
  public void a(E paramE, long paramLong1, Thread paramThread, Throwable paramThrowable, String paramString, Thread[] paramArrayOfThread, float paramFloat, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong2, long paramLong3, ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, List<StackTraceElement[]> paramList, StackTraceElement[] paramArrayOfStackTraceElement, Jw paramJw, Map<String, String> paramMap)
  {
    this.b = paramRunningAppProcessInfo;
    this.d = paramList;
    this.e = paramArrayOfStackTraceElement;
    this.c = paramArrayOfThread;
    A localA = au.a(paramJw);
    if (localA == null) {
      IC.g();
    }
    Jg.a(paramJw, "There was a problem closing the Crashlytics log file.");
    paramE.i(10, 2);
    paramE.k(a(paramThread, paramThrowable, paramString, paramLong1, paramMap, paramFloat, paramInt1, paramBoolean, paramInt2, paramLong2, paramLong3, localA));
    paramE.a(1, paramLong1);
    paramE.a(2, A.a(paramString));
    a(paramE, paramThread, paramThrowable, paramInt2, paramMap);
    a(paramE, paramFloat, paramInt1, paramBoolean, paramInt2, paramLong2, paramLong3);
    a(paramE, localA);
  }
  
  public void a(E paramE, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, Map<Jt, String> paramMap, int paramInt3, String paramString3, String paramString4)
  {
    A localA1 = A.a(paramString1);
    A localA2 = a(paramString2);
    A localA3 = a(paramString4);
    A localA4 = a(paramString3);
    paramE.i(9, 2);
    paramE.k(a(paramInt1, localA1, localA2, paramInt2, paramLong1, paramLong2, paramBoolean, paramMap, paramInt3, localA4, localA3));
    paramE.a(1, localA1);
    paramE.c(3, paramInt1);
    paramE.a(4, localA2);
    paramE.b(5, paramInt2);
    paramE.a(6, paramLong1);
    paramE.a(7, paramLong2);
    paramE.a(10, paramBoolean);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramE.i(11, 2);
      paramE.k(a((Jt)localEntry.getKey(), (String)localEntry.getValue()));
      paramE.c(1, ((Jt)localEntry.getKey()).h);
      paramE.a(2, A.a((String)localEntry.getValue()));
    }
    paramE.b(12, paramInt3);
    if (localA4 != null) {
      paramE.a(13, localA4);
    }
    if (localA3 != null) {
      paramE.a(14, localA3);
    }
  }
  
  public void a(E paramE, String paramString1, String paramString2, long paramLong)
  {
    paramE.a(1, A.a(paramString2));
    paramE.a(2, A.a(paramString1));
    paramE.a(3, paramLong);
  }
  
  public void a(E paramE, String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    A localA1 = A.a(paramString1);
    A localA2 = a(paramString2);
    A localA3 = a(paramString3);
    int j = 0 + E.b(1, localA1);
    if (paramString2 != null) {
      j += E.b(2, localA2);
    }
    if (paramString3 != null) {
      j += E.b(3, localA3);
    }
    paramE.i(6, 2);
    paramE.k(j);
    paramE.a(1, localA1);
    if (paramString2 != null) {
      paramE.a(2, localA2);
    }
    if (paramString3 != null) {
      paramE.a(3, localA3);
    }
  }
  
  public void a(E paramE, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    A localA1 = A.a(paramString1);
    A localA2 = A.a(paramString2);
    A localA3 = A.a(paramString3);
    A localA4 = A.a(paramString4);
    paramE.i(7, 2);
    paramE.k(a(localA1, localA2, localA3, localA4, paramInt));
    paramE.a(1, localA1);
    paramE.a(2, localA2);
    paramE.a(3, localA3);
    paramE.i(5, 2);
    paramE.k(a());
    paramE.a(1, new Je().a(this.f));
    paramE.a(6, localA4);
    paramE.c(10, paramInt);
  }
  
  public void a(E paramE, boolean paramBoolean)
  {
    A localA1 = A.a(Build.VERSION.RELEASE);
    A localA2 = A.a(Build.VERSION.CODENAME);
    paramE.i(8, 2);
    paramE.k(a(localA1, localA2, paramBoolean));
    paramE.c(1, 3);
    paramE.a(2, localA1);
    paramE.a(3, localA2);
    paramE.a(4, paramBoolean);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     aN
 * JD-Core Version:    0.7.0.1
 */