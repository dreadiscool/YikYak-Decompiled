package android.support.v4.widget;

import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class SlidingPaneLayout$SlidingPanelLayoutImplJB
  extends SlidingPaneLayout.SlidingPanelLayoutImplBase
{
  private Method mGetDisplayList;
  private Field mRecreateDisplayList;
  
  SlidingPaneLayout$SlidingPanelLayoutImplJB()
  {
    try
    {
      this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", (Class[])null);
      try
      {
        label19:
        this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
        this.mRecreateDisplayList.setAccessible(true);
        label38:
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label38;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label19;
    }
  }
  
  public void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
  {
    if ((this.mGetDisplayList != null) && (this.mRecreateDisplayList != null)) {}
    try
    {
      this.mRecreateDisplayList.setBoolean(paramView, true);
      this.mGetDisplayList.invoke(paramView, (Object[])null);
      label36:
      super.invalidateChildRegion(paramSlidingPaneLayout, paramView);
      for (;;)
      {
        return;
        paramView.invalidate();
      }
    }
    catch (Exception localException)
    {
      break label36;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplJB
 * JD-Core Version:    0.7.0.1
 */