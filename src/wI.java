import android.view.View;
import android.view.View.AccessibilityDelegate;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class wI
  extends wM
{
  private final int a;
  private final WeakHashMap<View, wJ> b;
  
  public wI(List<wr> paramList, int paramInt, String paramString, wN paramwN)
  {
    super(paramList, paramString, paramwN, false);
    this.a = paramInt;
    this.b = new WeakHashMap();
  }
  
  private View.AccessibilityDelegate d(View paramView)
  {
    try
    {
      localAccessibilityDelegate = (View.AccessibilityDelegate)paramView.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(paramView, new Object[0]);
      return localAccessibilityDelegate;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        localAccessibilityDelegate = null;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localAccessibilityDelegate = null;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        View.AccessibilityDelegate localAccessibilityDelegate = null;
      }
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      View localView = (View)localEntry.getKey();
      wJ localwJ = (wJ)localEntry.getValue();
      View.AccessibilityDelegate localAccessibilityDelegate = d(localView);
      if (localAccessibilityDelegate == localwJ) {
        localView.setAccessibilityDelegate(localwJ.a());
      } else if ((localAccessibilityDelegate instanceof wJ)) {
        ((wJ)localAccessibilityDelegate).a(localwJ);
      }
    }
    this.b.clear();
  }
  
  public void a(View paramView)
  {
    View.AccessibilityDelegate localAccessibilityDelegate = d(paramView);
    if (((localAccessibilityDelegate instanceof wJ)) && (((wJ)localAccessibilityDelegate).a(b()))) {}
    for (;;)
    {
      return;
      wJ localwJ = new wJ(this, localAccessibilityDelegate);
      paramView.setAccessibilityDelegate(localwJ);
      this.b.put(paramView, localwJ);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wI
 * JD-Core Version:    0.7.0.1
 */