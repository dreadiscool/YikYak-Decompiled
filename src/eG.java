import android.text.TextUtils;
import java.util.Map;

class eG
  implements Runnable
{
  eG(eF parameF, Map paramMap) {}
  
  public void run()
  {
    if (TextUtils.isEmpty((CharSequence)this.a.get("&cid"))) {
      this.a.put("&cid", eF.a(this.b));
    }
    if ((eL.a(eF.b(this.b)).c()) || (eF.a(this.b, this.a))) {}
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(eF.c(this.b)))
      {
        eJ.a().a(true);
        this.a.putAll(new eR().a(eF.c(this.b)).a());
        eJ.a().a(false);
        eF.a(this.b, null);
      }
      eF.b(this.b, this.a);
      Map localMap = eN.a(this.a);
      eF.e(this.b).a(localMap, Long.valueOf((String)this.a.get("&ht")).longValue(), eF.c(this.b, this.a), eF.d(this.b));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     eG
 * JD-Core Version:    0.7.0.1
 */