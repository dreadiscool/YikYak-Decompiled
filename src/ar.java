import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ar
  extends IU
  implements aq
{
  public ar(IM paramIM, String paramString1, String paramString2, KK paramKK)
  {
    super(paramIM, paramString1, paramString2, paramKK, KB.b);
  }
  
  private KC a(KC paramKC, ap paramap)
  {
    KC localKC1 = paramKC.a("X-CRASHLYTICS-API-KEY", paramap.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", G.f().d());
    Iterator localIterator = paramap.b.e().entrySet().iterator();
    for (KC localKC2 = localKC1; localIterator.hasNext(); localKC2 = localKC2.a((Map.Entry)localIterator.next())) {}
    return localKC2;
  }
  
  private KC b(KC paramKC, ap paramap)
  {
    aJ localaJ = paramap.b;
    return paramKC.a("report[file]", localaJ.b(), "application/octet-stream", localaJ.d()).e("report[identifier]", localaJ.c());
  }
  
  public boolean a(ap paramap)
  {
    KC localKC = b(a(b(), paramap), paramap);
    IC.g();
    new StringBuilder().append("Sending report to: ").append(a()).toString();
    int i = localKC.b();
    IC.g();
    new StringBuilder().append("Create report request ID: ").append(localKC.b("X-REQUEST-ID")).toString();
    IC.g();
    new StringBuilder().append("Result was: ").append(i).toString();
    if (JB.a(i) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ar
 * JD-Core Version:    0.7.0.1
 */