import android.annotation.TargetApi;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import java.util.HashSet;
import java.util.Set;

class Iy
{
  private final Set<Application.ActivityLifecycleCallbacks> a = new HashSet();
  private final Application b;
  
  Iy(Application paramApplication)
  {
    this.b = paramApplication;
  }
  
  @TargetApi(14)
  private boolean a(IA paramIA)
  {
    if (this.b != null)
    {
      Iz localIz = new Iz(this, paramIA);
      this.b.registerActivityLifecycleCallbacks(localIz);
      this.a.add(localIz);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Iy
 * JD-Core Version:    0.7.0.1
 */