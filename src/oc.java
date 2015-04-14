import java.util.Collections;
import java.util.Map;

public class oc
{
  private final Map<String, hf> a;
  private final hf b;
  
  public Map<String, hf> a()
  {
    return Collections.unmodifiableMap(this.a);
  }
  
  public void a(String paramString, hf paramhf)
  {
    this.a.put(paramString, paramhf);
  }
  
  public hf b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "Properties: " + a() + " pushAfterEvaluate: " + this.b;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     oc
 * JD-Core Version:    0.7.0.1
 */