import java.util.Map.Entry;
import java.util.Set;

public final class pe
  extends pb
{
  private final pO<String, pb> a = new pO();
  
  public void a(String paramString, pb parampb)
  {
    if (parampb == null) {
      parampb = pd.a;
    }
    this.a.put(paramString, parampb);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == this) || (((paramObject instanceof pe)) && (((pe)paramObject).a.equals(this.a)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public Set<Map.Entry<String, pb>> o()
  {
    return this.a.entrySet();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pe
 * JD-Core Version:    0.7.0.1
 */