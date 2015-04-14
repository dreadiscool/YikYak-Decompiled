import android.app.Activity;

class M
  implements Ll<Boolean>
{
  M(G paramG) {}
  
  public Boolean a(Lo paramLo)
  {
    boolean bool = true;
    Activity localActivity = this.a.D().b();
    if ((localActivity != null) && (!localActivity.isFinishing()) && (this.a.v())) {
      bool = G.a(this.a, localActivity, paramLo.c);
    }
    return Boolean.valueOf(bool);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     M
 * JD-Core Version:    0.7.0.1
 */