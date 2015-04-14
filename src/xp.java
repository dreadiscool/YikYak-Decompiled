import java.util.ArrayList;

class xp
  implements Cloneable
{
  public xg a;
  public ArrayList<xn> b = null;
  public ArrayList<xn> c = null;
  public ArrayList<xp> d = null;
  public ArrayList<xp> e = null;
  public boolean f = false;
  
  public xp(xg paramxg)
  {
    this.a = paramxg;
  }
  
  public xp a()
  {
    try
    {
      xp localxp = (xp)super.clone();
      localxp.a = this.a.c();
      return localxp;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
  
  public void a(xn paramxn)
  {
    if (this.b == null)
    {
      this.b = new ArrayList();
      this.d = new ArrayList();
    }
    this.b.add(paramxn);
    if (!this.d.contains(paramxn.a)) {
      this.d.add(paramxn.a);
    }
    xp localxp = paramxn.a;
    if (localxp.e == null) {
      localxp.e = new ArrayList();
    }
    localxp.e.add(this);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xp
 * JD-Core Version:    0.7.0.1
 */