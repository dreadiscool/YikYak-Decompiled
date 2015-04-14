import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class bj
{
  private final Context a;
  private final bh b;
  private final Js c;
  private final KX d;
  private final bi e;
  private final KQ f;
  private final Jl g;
  private final KK h;
  
  public bj(Context paramContext, bh parambh, Js paramJs, KX paramKX, bi parambi, KQ paramKQ, Jl paramJl, KK paramKK)
  {
    this.a = paramContext;
    this.b = parambh;
    this.c = paramJs;
    this.d = paramKX;
    this.e = parambi;
    this.f = paramKQ;
    this.g = paramJl;
    this.h = paramKK;
  }
  
  public void a()
  {
    long l1 = this.g.a();
    long l2 = 1000 * this.d.b;
    IC.g();
    new StringBuilder().append("Check for updates delay: ").append(l2).toString();
    long l3 = this.f.a().getLong("last_update_check", 0L);
    IC.g();
    new StringBuilder().append("Check for updates last check time: ").append(l3).toString();
    long l4 = l2 + l3;
    IC.g();
    new StringBuilder().append("Check for updates current time: ").append(l1).append(", next check time: ").append(l4).toString();
    if (l1 >= l4) {}
    for (;;)
    {
      try
      {
        IC.g();
        String str1 = new Je().a(this.a);
        String str2 = this.c.a(str1, this.e.d);
        new bk(this.b, this.b.f(), this.d.a, this.h, new bm()).a(str1, str2, this.e);
        return;
      }
      finally
      {
        this.f.b().putLong("last_update_check", l1).commit();
      }
      IC.g();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bj
 * JD-Core Version:    0.7.0.1
 */