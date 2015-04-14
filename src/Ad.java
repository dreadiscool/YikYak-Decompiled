import java.util.LinkedHashSet;
import java.util.Set;

public final class Ad
{
  private final Set<zJ> a = new LinkedHashSet();
  
  public void a(zJ paramzJ)
  {
    try
    {
      this.a.add(paramzJ);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(zJ paramzJ)
  {
    try
    {
      this.a.remove(paramzJ);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean c(zJ paramzJ)
  {
    try
    {
      boolean bool = this.a.contains(paramzJ);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ad
 * JD-Core Version:    0.7.0.1
 */