package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;

public class KeyEventCompat
{
  static final KeyEventCompat.KeyEventVersionImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (IMPL = new KeyEventCompat.HoneycombKeyEventVersionImpl();; IMPL = new KeyEventCompat.BaseKeyEventVersionImpl()) {
      return;
    }
  }
  
  public static boolean dispatch(KeyEvent paramKeyEvent, KeyEvent.Callback paramCallback, Object paramObject1, Object paramObject2)
  {
    return IMPL.dispatch(paramKeyEvent, paramCallback, paramObject1, paramObject2);
  }
  
  public static Object getKeyDispatcherState(View paramView)
  {
    return IMPL.getKeyDispatcherState(paramView);
  }
  
  public static boolean hasModifiers(KeyEvent paramKeyEvent, int paramInt)
  {
    return IMPL.metaStateHasModifiers(paramKeyEvent.getMetaState(), paramInt);
  }
  
  public static boolean hasNoModifiers(KeyEvent paramKeyEvent)
  {
    return IMPL.metaStateHasNoModifiers(paramKeyEvent.getMetaState());
  }
  
  public static boolean isTracking(KeyEvent paramKeyEvent)
  {
    return IMPL.isTracking(paramKeyEvent);
  }
  
  public static boolean metaStateHasModifiers(int paramInt1, int paramInt2)
  {
    return IMPL.metaStateHasModifiers(paramInt1, paramInt2);
  }
  
  public static boolean metaStateHasNoModifiers(int paramInt)
  {
    return IMPL.metaStateHasNoModifiers(paramInt);
  }
  
  public static int normalizeMetaState(int paramInt)
  {
    return IMPL.normalizeMetaState(paramInt);
  }
  
  public static void startTracking(KeyEvent paramKeyEvent)
  {
    IMPL.startTracking(paramKeyEvent);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.KeyEventCompat
 * JD-Core Version:    0.7.0.1
 */