package butterknife;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.util.Property;
import android.view.View;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ButterKnife
{
  static final Map<Class<?>, ButterKnife.Injector<Object>> INJECTORS = new LinkedHashMap();
  static final ButterKnife.Injector<Object> NOP_INJECTOR = new ButterKnife.1();
  private static final String TAG = "ButterKnife";
  private static boolean debug = false;
  
  private ButterKnife()
  {
    throw new AssertionError("No instances.");
  }
  
  @TargetApi(14)
  public static <T extends View, V> void apply(List<T> paramList, Property<? super T, V> paramProperty, V paramV)
  {
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      paramProperty.set(paramList.get(i), paramV);
      i++;
    }
  }
  
  public static <T extends View> void apply(List<T> paramList, ButterKnife.Action<? super T> paramAction)
  {
    int i = paramList.size();
    for (int j = 0; j < i; j++) {
      paramAction.apply((View)paramList.get(j), j);
    }
  }
  
  public static <T extends View, V> void apply(List<T> paramList, ButterKnife.Setter<? super T, V> paramSetter, V paramV)
  {
    int i = paramList.size();
    for (int j = 0; j < i; j++) {
      paramSetter.set((View)paramList.get(j), paramV, j);
    }
  }
  
  public static <T extends View> T findById(Activity paramActivity, int paramInt)
  {
    return paramActivity.findViewById(paramInt);
  }
  
  public static <T extends View> T findById(Dialog paramDialog, int paramInt)
  {
    return paramDialog.findViewById(paramInt);
  }
  
  public static <T extends View> T findById(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  private static ButterKnife.Injector<Object> findInjectorForClass(Class<?> paramClass)
  {
    ButterKnife.Injector localInjector = (ButterKnife.Injector)INJECTORS.get(paramClass);
    if (localInjector != null) {}
    for (;;)
    {
      return localInjector;
      String str = paramClass.getName();
      if ((str.startsWith("android.")) || (str.startsWith("java.")))
      {
        localInjector = NOP_INJECTOR;
        continue;
      }
      try
      {
        localInjector = (ButterKnife.Injector)Class.forName(str + "$$ViewInjector").newInstance();
        INJECTORS.put(paramClass, localInjector);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          if (debug) {
            new StringBuilder().append("Not found. Trying superclass ").append(paramClass.getSuperclass().getName()).toString();
          }
          localInjector = findInjectorForClass(paramClass.getSuperclass());
        }
      }
    }
  }
  
  public static void inject(Activity paramActivity)
  {
    inject(paramActivity, paramActivity, ButterKnife.Finder.ACTIVITY);
  }
  
  public static void inject(Dialog paramDialog)
  {
    inject(paramDialog, paramDialog, ButterKnife.Finder.DIALOG);
  }
  
  public static void inject(View paramView)
  {
    inject(paramView, paramView, ButterKnife.Finder.VIEW);
  }
  
  public static void inject(Object paramObject, Activity paramActivity)
  {
    inject(paramObject, paramActivity, ButterKnife.Finder.ACTIVITY);
  }
  
  public static void inject(Object paramObject, Dialog paramDialog)
  {
    inject(paramObject, paramDialog, ButterKnife.Finder.DIALOG);
  }
  
  public static void inject(Object paramObject, View paramView)
  {
    inject(paramObject, paramView, ButterKnife.Finder.VIEW);
  }
  
  static void inject(Object paramObject1, Object paramObject2, ButterKnife.Finder paramFinder)
  {
    Class localClass = paramObject1.getClass();
    try
    {
      if (debug) {
        new StringBuilder().append("Looking up view injector for ").append(localClass.getName()).toString();
      }
      ButterKnife.Injector localInjector = findInjectorForClass(localClass);
      if (localInjector != null) {
        localInjector.inject(paramFinder, paramObject1, paramObject2);
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Unable to inject views for " + paramObject1, localException);
    }
  }
  
  public static void reset(Object paramObject)
  {
    Class localClass = paramObject.getClass();
    try
    {
      if (debug) {
        new StringBuilder().append("Looking up view injector for ").append(localClass.getName()).toString();
      }
      ButterKnife.Injector localInjector = findInjectorForClass(localClass);
      if (localInjector != null) {
        localInjector.reset(paramObject);
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Unable to reset views for " + paramObject, localException);
    }
  }
  
  public static void setDebug(boolean paramBoolean)
  {
    debug = paramBoolean;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.ButterKnife
 * JD-Core Version:    0.7.0.1
 */