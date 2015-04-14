package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewCompatEclairMr1
{
  public static final String TAG = "ViewCompat";
  private static Method sChildrenDrawingOrderMethod;
  
  public static boolean isOpaque(View paramView)
  {
    return paramView.isOpaque();
  }
  
  public static void setChildrenDrawingOrderEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (sChildrenDrawingOrderMethod == null) {}
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Boolean.TYPE;
      sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", arrayOfClass);
      label31:
      sChildrenDrawingOrderMethod.setAccessible(true);
      try
      {
        Method localMethod = sChildrenDrawingOrderMethod;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Boolean.valueOf(paramBoolean);
        localMethod.invoke(paramViewGroup, arrayOfObject);
        label66:
        return;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        break label66;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        break label66;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        break label66;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label31;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewCompatEclairMr1
 * JD-Core Version:    0.7.0.1
 */