import android.content.Context;
import java.util.UUID;

class aY
  extends Kh<bb>
{
  private KT g;
  
  aY(Context paramContext, be parambe, Jl paramJl, Kq paramKq)
  {
    super(paramContext, parambe, paramJl, paramKq, 100);
  }
  
  protected String a()
  {
    UUID localUUID = UUID.randomUUID();
    return "sa" + "_" + localUUID.toString() + "_" + this.c.a() + ".tap";
  }
  
  void a(KT paramKT)
  {
    this.g = paramKT;
  }
  
  protected int b()
  {
    if (this.g == null) {}
    for (int i = super.b();; i = this.g.e) {
      return i;
    }
  }
  
  protected int c()
  {
    if (this.g == null) {}
    for (int i = super.c();; i = this.g.c) {
      return i;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     aY
 * JD-Core Version:    0.7.0.1
 */