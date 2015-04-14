import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class zo
{
  private final String[] a;
  
  private zo(zq paramzq)
  {
    this.a = ((String[])zq.a(paramzq).toArray(new String[zq.a(paramzq).size()]));
  }
  
  private static String a(String[] paramArrayOfString, String paramString)
  {
    int i = -2 + paramArrayOfString.length;
    if (i >= 0) {
      if (!paramString.equalsIgnoreCase(paramArrayOfString[i])) {}
    }
    for (String str = paramArrayOfString[(i + 1)];; str = null)
    {
      return str;
      i -= 2;
      break;
    }
  }
  
  public int a()
  {
    return this.a.length / 2;
  }
  
  public String a(int paramInt)
  {
    int i = paramInt * 2;
    if ((i < 0) || (i >= this.a.length)) {}
    for (String str = null;; str = this.a[i]) {
      return str;
    }
  }
  
  public String a(String paramString)
  {
    return a(this.a, paramString);
  }
  
  public String b(int paramInt)
  {
    int i = 1 + paramInt * 2;
    if ((i < 0) || (i >= this.a.length)) {}
    for (String str = null;; str = this.a[i]) {
      return str;
    }
  }
  
  public Date b(String paramString)
  {
    String str = a(paramString);
    if (str != null) {}
    for (Date localDate = Av.a(str);; localDate = null) {
      return localDate;
    }
  }
  
  public zq b()
  {
    zq localzq = new zq();
    zq.a(localzq).addAll(Arrays.asList(this.a));
    return localzq;
  }
  
  public List<String> c(String paramString)
  {
    int i = a();
    ArrayList localArrayList = null;
    for (int j = 0; j < i; j++) {
      if (paramString.equalsIgnoreCase(a(j)))
      {
        if (localArrayList == null) {
          localArrayList = new ArrayList(2);
        }
        localArrayList.add(b(j));
      }
    }
    if (localArrayList != null) {}
    for (List localList = Collections.unmodifiableList(localArrayList);; localList = Collections.emptyList()) {
      return localList;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = a();
    while (i < j)
    {
      localStringBuilder.append(a(i)).append(": ").append(b(i)).append("\n");
      i++;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zo
 * JD-Core Version:    0.7.0.1
 */