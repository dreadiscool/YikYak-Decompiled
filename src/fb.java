import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class fb
  implements ep
{
  private final TreeSet<String> a = new TreeSet();
  
  public fb(Context paramContext, Collection<String> paramCollection)
  {
    a(paramContext, paramCollection);
  }
  
  public String a(String paramString, Throwable paramThrowable)
  {
    return a(a(paramThrowable), b(a(paramThrowable)), paramString);
  }
  
  protected String a(Throwable paramThrowable, StackTraceElement paramStackTraceElement, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThrowable.getClass().getSimpleName());
    if (paramStackTraceElement != null)
    {
      String[] arrayOfString = paramStackTraceElement.getClassName().split("\\.");
      String str = "unknown";
      if ((arrayOfString != null) && (arrayOfString.length > 0)) {
        str = arrayOfString[(-1 + arrayOfString.length)];
      }
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = str;
      arrayOfObject2[1] = paramStackTraceElement.getMethodName();
      arrayOfObject2[2] = Integer.valueOf(paramStackTraceElement.getLineNumber());
      localStringBuilder.append(String.format(" (@%s:%s:%s)", arrayOfObject2));
    }
    if (paramString != null)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramString;
      localStringBuilder.append(String.format(" {%s}", arrayOfObject1));
    }
    return localStringBuilder.toString();
  }
  
  protected Throwable a(Throwable paramThrowable)
  {
    while (paramThrowable.getCause() != null) {
      paramThrowable = paramThrowable.getCause();
    }
    return paramThrowable;
  }
  
  public void a(Context paramContext, Collection<String> paramCollection)
  {
    this.a.clear();
    HashSet localHashSet = new HashSet();
    if (paramCollection != null) {
      localHashSet.addAll(paramCollection);
    }
    if (paramContext != null) {
      try
      {
        String str3 = paramContext.getApplicationContext().getPackageName();
        this.a.add(str3);
        ActivityInfo[] arrayOfActivityInfo = paramContext.getApplicationContext().getPackageManager().getPackageInfo(str3, 15).activities;
        if (arrayOfActivityInfo != null)
        {
          int j = arrayOfActivityInfo.length;
          for (int k = 0; k < j; k++) {
            localHashSet.add(arrayOfActivityInfo[k].packageName);
          }
        }
        localIterator1 = localHashSet.iterator();
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        eO.b("No package found");
      }
    }
    Iterator localIterator1;
    if (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      Iterator localIterator2 = this.a.iterator();
      for (int i = 1;; i = 0)
      {
        if (localIterator2.hasNext())
        {
          String str2 = (String)localIterator2.next();
          if (str1.startsWith(str2)) {
            continue;
          }
          if (str2.startsWith(str1)) {
            this.a.remove(str2);
          }
        }
        if (i == 0) {
          break;
        }
        this.a.add(str1);
        break;
      }
    }
  }
  
  protected StackTraceElement b(Throwable paramThrowable)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    Object localObject;
    if ((arrayOfStackTraceElement == null) || (arrayOfStackTraceElement.length == 0)) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      int i = arrayOfStackTraceElement.length;
      for (int j = 0;; j++)
      {
        if (j >= i) {
          break label94;
        }
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[j];
        String str = localStackTraceElement.getClassName();
        Iterator localIterator = this.a.iterator();
        for (;;)
        {
          if (localIterator.hasNext()) {
            if (str.startsWith((String)localIterator.next()))
            {
              localObject = localStackTraceElement;
              break;
            }
          }
        }
      }
      label94:
      localObject = arrayOfStackTraceElement[0];
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fb
 * JD-Core Version:    0.7.0.1
 */