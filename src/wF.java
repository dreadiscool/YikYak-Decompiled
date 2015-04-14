import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

class wF
  implements Callable<List<wG>>
{
  private wu<Activity> a;
  private final List<wG> b = new ArrayList();
  private final DisplayMetrics c = new DisplayMetrics();
  private final wD d = new wD();
  private final int e = 160;
  
  private void a(wG paramwG)
  {
    View localView = paramwG.b;
    try
    {
      Class[] arrayOfClass = new Class[3];
      arrayOfClass[0] = Bitmap.Config.class;
      arrayOfClass[1] = Integer.TYPE;
      arrayOfClass[2] = Boolean.TYPE;
      Method localMethod = View.class.getDeclaredMethod("createSnapshot", arrayOfClass);
      localMethod.setAccessible(true);
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Bitmap.Config.RGB_565;
      arrayOfObject[1] = Integer.valueOf(-1);
      arrayOfObject[2] = Boolean.valueOf(false);
      localBitmap1 = (Bitmap)localMethod.invoke(localView, arrayOfObject);
      Object localObject1 = null;
      if (localBitmap1 == null)
      {
        try
        {
          localObject1 = Boolean.valueOf(localView.isDrawingCacheEnabled());
          localView.setDrawingCacheEnabled(true);
          localView.buildDrawingCache(true);
          Bitmap localBitmap4 = localView.getDrawingCache();
          Object localObject3 = localObject1;
          localBitmap2 = localBitmap4;
          localObject2 = localObject3;
          localBitmap3 = localBitmap2;
          localObject1 = localObject2;
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            float f;
            int i;
            int j;
            int k;
            int m;
            int n;
            if (uJ.a) {
              new StringBuilder().append("Can't take a bitmap snapshot of view ").append(localView).append(", skipping for now.").toString();
            }
            Bitmap localBitmap3 = localBitmap1;
          }
        }
        f = 1.0F;
        if (localBitmap3 != null)
        {
          i = localBitmap3.getDensity();
          if (i != 0) {
            f = 160.0F / i;
          }
          j = localBitmap3.getWidth();
          k = localBitmap3.getHeight();
          m = (int)(0.5D + f * localBitmap3.getWidth());
          n = (int)(0.5D + f * localBitmap3.getHeight());
          if ((j > 0) && (k > 0) && (m > 0) && (n > 0)) {
            this.d.a(m, n, 160, localBitmap3);
          }
        }
        if ((localObject1 != null) && (!((Boolean)localObject1).booleanValue())) {
          localView.setDrawingCacheEnabled(false);
        }
        paramwG.d = f;
        paramwG.c = this.d;
        return;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        localBitmap1 = null;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localBitmap1 = null;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        localBitmap1 = null;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localBitmap1 = null;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        Bitmap localBitmap1 = null;
        continue;
        Bitmap localBitmap2 = localBitmap1;
        Object localObject2 = null;
      }
    }
  }
  
  public List<wG> a()
  {
    this.b.clear();
    Iterator localIterator = this.a.a().iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)localIterator.next();
      String str = localActivity.getClass().getCanonicalName();
      View localView = localActivity.getWindow().getDecorView().getRootView();
      localActivity.getWindowManager().getDefaultDisplay().getMetrics(this.c);
      wG localwG = new wG(str, localView);
      this.b.add(localwG);
    }
    int i = this.b.size();
    for (int j = 0; j < i; j++) {
      a((wG)this.b.get(j));
    }
    return this.b;
  }
  
  public void a(wu<Activity> paramwu)
  {
    this.a = paramwu;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wF
 * JD-Core Version:    0.7.0.1
 */