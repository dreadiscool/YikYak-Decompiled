import android.app.Activity;
import java.util.Collections;
import java.util.Map;

final class bb
{
  public final bd a;
  public final long b;
  public final bc c;
  public final Map<String, String> d;
  public final String e;
  public final Map<String, Object> f;
  private String g;
  
  private bb(bd parambd, long paramLong, bc parambc, Map<String, String> paramMap, String paramString, Map<String, Object> paramMap1)
  {
    this.a = parambd;
    this.b = paramLong;
    this.c = parambc;
    this.d = paramMap;
    this.e = paramString;
    this.f = paramMap1;
  }
  
  public static bb a(bd parambd)
  {
    return a(parambd, bc.j, Collections.emptyMap());
  }
  
  public static bb a(bd parambd, bc parambc, Activity paramActivity)
  {
    return a(parambd, parambc, Collections.singletonMap("activity", paramActivity.getClass().getName()));
  }
  
  private static bb a(bd parambd, bc parambc, Map<String, String> paramMap)
  {
    return a(parambd, parambc, paramMap, null, Collections.emptyMap());
  }
  
  private static bb a(bd parambd, bc parambc, Map<String, String> paramMap, String paramString, Map<String, Object> paramMap1)
  {
    return new bb(parambd, System.currentTimeMillis(), parambc, paramMap, paramString, paramMap1);
  }
  
  public static bb a(bd parambd, String paramString)
  {
    Map localMap = Collections.singletonMap("sessionId", paramString);
    return a(parambd, bc.i, localMap);
  }
  
  public String toString()
  {
    if (this.g == null) {
      this.g = ("[" + getClass().getSimpleName() + ": " + "timestamp=" + this.b + ", type=" + this.c + ", details=" + this.d.toString() + ", customType=" + this.e + ", customAttributes=" + this.f.toString() + ", metadata=[" + this.a + "]]");
    }
    return this.g;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bb
 * JD-Core Version:    0.7.0.1
 */