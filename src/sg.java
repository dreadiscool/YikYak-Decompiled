import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class sg
{
  private static volatile boolean a = false;
  private static final sg c = new sg(true);
  private final Map<sh, ss<?, ?>> b;
  
  sg()
  {
    this.b = new HashMap();
  }
  
  private sg(boolean paramBoolean)
  {
    this.b = Collections.emptyMap();
  }
  
  public static sg a()
  {
    return c;
  }
  
  public <ContainingType extends sE> ss<ContainingType, ?> a(ContainingType paramContainingType, int paramInt)
  {
    return (ss)this.b.get(new sh(paramContainingType, paramInt));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sg
 * JD-Core Version:    0.7.0.1
 */