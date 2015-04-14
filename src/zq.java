import java.util.ArrayList;
import java.util.List;

public final class zq
{
  private final List<String> a = new ArrayList(20);
  
  private zq c(String paramString1, String paramString2)
  {
    this.a.add(paramString1);
    this.a.add(paramString2.trim());
    return this;
  }
  
  public zo a()
  {
    return new zo(this, null);
  }
  
  zq a(String paramString)
  {
    int i = paramString.indexOf(":", 1);
    zq localzq;
    if (i != -1) {
      localzq = c(paramString.substring(0, i), paramString.substring(i + 1));
    }
    for (;;)
    {
      return localzq;
      if (paramString.startsWith(":")) {
        localzq = c("", paramString.substring(1));
      } else {
        localzq = c("", paramString);
      }
    }
  }
  
  public zq a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("name == null");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("value == null");
    }
    if ((paramString1.length() == 0) || (paramString1.indexOf(0) != -1) || (paramString2.indexOf(0) != -1)) {
      throw new IllegalArgumentException("Unexpected header: " + paramString1 + ": " + paramString2);
    }
    return c(paramString1, paramString2);
  }
  
  public zq b(String paramString)
  {
    for (int i = 0; i < this.a.size(); i += 2) {
      if (paramString.equalsIgnoreCase((String)this.a.get(i)))
      {
        this.a.remove(i);
        this.a.remove(i);
        i -= 2;
      }
    }
    return this;
  }
  
  public zq b(String paramString1, String paramString2)
  {
    b(paramString1);
    a(paramString1, paramString2);
    return this;
  }
  
  public String c(String paramString)
  {
    int i = -2 + this.a.size();
    if (i >= 0) {
      if (!paramString.equalsIgnoreCase((String)this.a.get(i))) {}
    }
    for (String str = (String)this.a.get(i + 1);; str = null)
    {
      return str;
      i -= 2;
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zq
 * JD-Core Version:    0.7.0.1
 */