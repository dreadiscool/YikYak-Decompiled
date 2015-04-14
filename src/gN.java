import java.util.Iterator;
import java.util.LinkedList;

class gN
  implements gY<T>
{
  gN(gM paramgM) {}
  
  public void a(T paramT)
  {
    gM.a(this.a, paramT);
    Iterator localIterator = gM.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((gT)localIterator.next()).a(gM.b(this.a));
    }
    gM.a(this.a).clear();
    gM.a(this.a, null);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gN
 * JD-Core Version:    0.7.0.1
 */