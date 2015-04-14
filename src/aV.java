import java.io.File;
import java.util.Iterator;
import java.util.List;

class aV
  extends IU
  implements Ku
{
  private final String b;
  
  public aV(IM paramIM, String paramString1, String paramString2, KK paramKK, String paramString3)
  {
    this(paramIM, paramString1, paramString2, paramKK, paramString3, KB.b);
  }
  
  aV(IM paramIM, String paramString1, String paramString2, KK paramKK, String paramString3, KB paramKB)
  {
    super(paramIM, paramString1, paramString2, paramKK, paramKB);
    this.b = paramString3;
  }
  
  private KC a(KC paramKC, String paramString)
  {
    return paramKC.a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", aR.b().d()).a("X-CRASHLYTICS-API-KEY", paramString);
  }
  
  private KC a(KC paramKC, List<File> paramList)
  {
    Iterator localIterator = paramList.iterator();
    for (int i = 0; localIterator.hasNext(); i++)
    {
      File localFile = (File)localIterator.next();
      Jg.a(aR.b().C(), "Adding analytics session file " + localFile.getName() + " to multipart POST");
      paramKC.a("session_analytics_file_" + i, localFile.getName(), "application/vnd.crashlytics.android.events", localFile);
    }
    return paramKC;
  }
  
  public boolean a(List<File> paramList)
  {
    KC localKC = a(a(b(), this.b), paramList);
    Jg.a(aR.b().C(), "Sending " + paramList.size() + " analytics files to " + a());
    int i = localKC.b();
    Jg.a(aR.b().C(), "Response code for analytics file send is " + i);
    if (JB.a(i) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     aV
 * JD-Core Version:    0.7.0.1
 */