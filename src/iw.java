import android.content.Context;

public class iw
{
  private final Context a;
  private final String b;
  private final iR<iI> c;
  private final String d;
  private ix e;
  
  private iw(Context paramContext, String paramString1, String paramString2, iR<iI> paramiR)
  {
    this.a = paramContext;
    this.b = paramString1;
    this.c = paramiR;
    this.e = null;
    this.d = paramString2;
  }
  
  public static iw a(Context paramContext, String paramString1, String paramString2, iR<iI> paramiR)
  {
    return new iw(paramContext, paramString1, paramString2, paramiR);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iw
 * JD-Core Version:    0.7.0.1
 */