package android.support.v7.internal.view;

import android.view.InflateException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import java.lang.reflect.Method;

class SupportMenuInflater$InflatedOnMenuItemClickListener
  implements MenuItem.OnMenuItemClickListener
{
  private static final Class<?>[] PARAM_TYPES;
  private Method mMethod;
  private Object mRealOwner;
  
  static
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = MenuItem.class;
    PARAM_TYPES = arrayOfClass;
  }
  
  public SupportMenuInflater$InflatedOnMenuItemClickListener(Object paramObject, String paramString)
  {
    this.mRealOwner = paramObject;
    Class localClass = paramObject.getClass();
    try
    {
      this.mMethod = localClass.getMethod(paramString, PARAM_TYPES);
      return;
    }
    catch (Exception localException)
    {
      InflateException localInflateException = new InflateException("Couldn't resolve menu item onClick handler " + paramString + " in class " + localClass.getName());
      localInflateException.initCause(localException);
      throw localInflateException;
    }
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    boolean bool = true;
    try
    {
      if (this.mMethod.getReturnType() == Boolean.TYPE)
      {
        Method localMethod2 = this.mMethod;
        Object localObject2 = this.mRealOwner;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = paramMenuItem;
        bool = ((Boolean)localMethod2.invoke(localObject2, arrayOfObject2)).booleanValue();
      }
      else
      {
        Method localMethod1 = this.mMethod;
        Object localObject1 = this.mRealOwner;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = paramMenuItem;
        localMethod1.invoke(localObject1, arrayOfObject1);
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    return bool;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.SupportMenuInflater.InflatedOnMenuItemClickListener
 * JD-Core Version:    0.7.0.1
 */