import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.yik.yak.ui.view.NoDefaultSpinner;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ho
  implements InvocationHandler
{
  protected SpinnerAdapter a;
  protected Method b;
  
  public Ho(NoDefaultSpinner paramNoDefaultSpinner, SpinnerAdapter paramSpinnerAdapter)
  {
    this.a = paramSpinnerAdapter;
    try
    {
      Class[] arrayOfClass = new Class[3];
      arrayOfClass[0] = Integer.TYPE;
      arrayOfClass[1] = View.class;
      arrayOfClass[2] = ViewGroup.class;
      this.b = SpinnerAdapter.class.getMethod("getView", arrayOfClass);
      return;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
  
  protected View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramInt < 0)
    {
      localObject = (TextView)((LayoutInflater)this.c.getContext().getSystemService("layout_inflater")).inflate(17367048, paramViewGroup, false);
      ((TextView)localObject).setTextSize(0, NoDefaultSpinner.a(this.c).getResources().getDimension(2131492993));
      ((TextView)localObject).setHint(this.c.getPrompt());
      ((TextView)localObject).setHintTextColor(this.c.getResources().getColor(2131427556));
    }
    for (;;)
    {
      return localObject;
      localObject = this.a.getView(paramInt, paramView, paramViewGroup);
    }
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    Object localObject2;
    try
    {
      if ((paramMethod.equals(this.b)) && (((Integer)paramArrayOfObject[0]).intValue() < 0))
      {
        localObject2 = a(((Integer)paramArrayOfObject[0]).intValue(), (View)paramArrayOfObject[1], (ViewGroup)paramArrayOfObject[2]);
      }
      else
      {
        Object localObject1 = paramMethod.invoke(this.a, paramArrayOfObject);
        localObject2 = localObject1;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw localInvocationTargetException.getTargetException();
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    return localObject2;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ho
 * JD-Core Version:    0.7.0.1
 */