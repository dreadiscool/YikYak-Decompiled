import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class oZ
  extends pb
  implements Iterable<pb>
{
  private final List<pb> a = new ArrayList();
  
  public Number a()
  {
    if (this.a.size() == 1) {
      return ((pb)this.a.get(0)).a();
    }
    throw new IllegalStateException();
  }
  
  public void a(pb parampb)
  {
    if (parampb == null) {
      parampb = pd.a;
    }
    this.a.add(parampb);
  }
  
  public String b()
  {
    if (this.a.size() == 1) {
      return ((pb)this.a.get(0)).b();
    }
    throw new IllegalStateException();
  }
  
  public double c()
  {
    if (this.a.size() == 1) {
      return ((pb)this.a.get(0)).c();
    }
    throw new IllegalStateException();
  }
  
  public long d()
  {
    if (this.a.size() == 1) {
      return ((pb)this.a.get(0)).d();
    }
    throw new IllegalStateException();
  }
  
  public int e()
  {
    if (this.a.size() == 1) {
      return ((pb)this.a.get(0)).e();
    }
    throw new IllegalStateException();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == this) || (((paramObject instanceof oZ)) && (((oZ)paramObject).a.equals(this.a)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean f()
  {
    if (this.a.size() == 1) {
      return ((pb)this.a.get(0)).f();
    }
    throw new IllegalStateException();
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public Iterator<pb> iterator()
  {
    return this.a.iterator();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     oZ
 * JD-Core Version:    0.7.0.1
 */