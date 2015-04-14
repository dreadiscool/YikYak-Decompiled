package com.yik.yak.ui.view;

import Ho;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NoDefaultSpinner
  extends Spinner
{
  private Context a;
  
  public NoDefaultSpinner(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public NoDefaultSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  public NoDefaultSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
  }
  
  protected SpinnerAdapter a(SpinnerAdapter paramSpinnerAdapter)
  {
    ClassLoader localClassLoader = paramSpinnerAdapter.getClass().getClassLoader();
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = SpinnerAdapter.class;
    return (SpinnerAdapter)Proxy.newProxyInstance(localClassLoader, arrayOfClass, new Ho(this, paramSpinnerAdapter));
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    super.setAdapter(a(paramSpinnerAdapter));
    try
    {
      Class[] arrayOfClass1 = new Class[1];
      arrayOfClass1[0] = Integer.TYPE;
      Method localMethod1 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", arrayOfClass1);
      localMethod1.setAccessible(true);
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(-1);
      localMethod1.invoke(this, arrayOfObject1);
      Class[] arrayOfClass2 = new Class[1];
      arrayOfClass2[0] = Integer.TYPE;
      Method localMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", arrayOfClass2);
      localMethod2.setAccessible(true);
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(-1);
      localMethod2.invoke(this, arrayOfObject2);
      return;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.view.NoDefaultSpinner
 * JD-Core Version:    0.7.0.1
 */