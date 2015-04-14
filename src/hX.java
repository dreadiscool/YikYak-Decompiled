import java.util.ArrayList;
import java.util.List;

public final class hX
{
  private final List<String> a;
  private final Object b;
  
  private hX(Object paramObject)
  {
    this.b = hZ.a(paramObject);
    this.a = new ArrayList();
  }
  
  public hX a(String paramString, Object paramObject)
  {
    this.a.add((String)hZ.a(paramString) + "=" + String.valueOf(paramObject));
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append('{');
    int i = this.a.size();
    for (int j = 0; j < i; j++)
    {
      localStringBuilder.append((String)this.a.get(j));
      if (j < i - 1) {
        localStringBuilder.append(", ");
      }
    }
    return '}';
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hX
 * JD-Core Version:    0.7.0.1
 */