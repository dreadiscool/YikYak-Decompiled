import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class sV
  implements Iterator<Map.Entry<K, V>>
{
  private int b = -1;
  private boolean c;
  private Iterator<Map.Entry<K, V>> d;
  
  private sV(sP paramsP) {}
  
  private Iterator<Map.Entry<K, V>> b()
  {
    if (this.d == null) {
      this.d = sP.c(this.a).entrySet().iterator();
    }
    return this.d;
  }
  
  public Map.Entry<K, V> a()
  {
    this.c = true;
    int i = 1 + this.b;
    this.b = i;
    if (i < sP.b(this.a).size()) {}
    for (Map.Entry localEntry = (Map.Entry)sP.b(this.a).get(this.b);; localEntry = (Map.Entry)b().next()) {
      return localEntry;
    }
  }
  
  public boolean hasNext()
  {
    if ((1 + this.b < sP.b(this.a).size()) || (b().hasNext())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void remove()
  {
    if (!this.c) {
      throw new IllegalStateException("remove() was called before next()");
    }
    this.c = false;
    sP.a(this.a);
    if (this.b < sP.b(this.a).size())
    {
      sP localsP = this.a;
      int i = this.b;
      this.b = (i - 1);
      sP.a(localsP, i);
    }
    for (;;)
    {
      return;
      b().remove();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sV
 * JD-Core Version:    0.7.0.1
 */