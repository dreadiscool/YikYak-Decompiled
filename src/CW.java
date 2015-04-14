import java.util.Comparator;
import java.util.Map.Entry;

final class CW
  implements Comparator<Map.Entry<String, CG>>
{
  public int a(Map.Entry<String, CG> paramEntry1, Map.Entry<String, CG> paramEntry2)
  {
    return ((CG)paramEntry1.getValue()).b.compareTo(((CG)paramEntry2.getValue()).b);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     CW
 * JD-Core Version:    0.7.0.1
 */