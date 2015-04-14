package android.support.v7.internal.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewUtils
{
  private static final String TAG = "ViewUtils";
  private static Method sComputeFitSystemWindowsMethod;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = Rect.class;
      arrayOfClass[1] = Rect.class;
      sComputeFitSystemWindowsMethod = View.class.getDeclaredMethod("computeFitSystemWindows", arrayOfClass);
      if (!sComputeFitSystemWindowsMethod.isAccessible()) {
        sComputeFitSystemWindowsMethod.setAccessible(true);
      }
      label50:
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label50;
    }
  }
  
  public static int combineMeasuredStates(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public static void computeFitSystemWindows(View paramView, Rect paramRect1, Rect paramRect2)
  {
    if (sComputeFitSystemWindowsMethod != null) {}
    try
    {
      Method localMethod = sComputeFitSystemWindowsMethod;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramRect1;
      arrayOfObject[1] = paramRect2;
      localMethod.invoke(paramView, arrayOfObject);
      label36:
      return;
    }
    catch (Exception localException)
    {
      break label36;
    }
  }
  
  public static boolean isLayoutRtl(View paramView)
  {
    int i = 1;
    if (ViewCompat.getLayoutDirection(paramView) == i) {}
    for (;;)
    {
      return i;
      int j = 0;
    }
  }
  
  public static void makeOptionalFitsSystemWindows(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    try
    {
      Method localMethod = paramView.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
      if (!localMethod.isAccessible()) {
        localMethod.setAccessible(true);
      }
      localMethod.invoke(paramView, new Object[0]);
      label48:
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label48;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      break label48;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label48;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ViewUtils
 * JD-Core Version:    0.7.0.1
 */