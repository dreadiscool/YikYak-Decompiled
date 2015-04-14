import android.view.View;
import android.view.ViewGroup;
import java.util.List;

class wo
{
  private final wq a = new wq();
  
  private View a(wr paramwr, View paramView, int paramInt)
  {
    int i = this.a.a(paramInt);
    if (a(paramwr, paramView))
    {
      this.a.b(paramInt);
      if ((paramwr.c != -1) && (paramwr.c != i)) {}
    }
    for (;;)
    {
      return paramView;
      if ((paramwr.a == 1) && ((paramView instanceof ViewGroup)))
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        int j = localViewGroup.getChildCount();
        for (int k = 0;; k++)
        {
          if (k >= j) {
            break label117;
          }
          View localView = a(paramwr, localViewGroup.getChildAt(k), paramInt);
          if (localView != null)
          {
            paramView = localView;
            break;
          }
        }
      }
      label117:
      paramView = null;
    }
  }
  
  private static boolean a(Object paramObject, String paramString)
  {
    for (Class localClass = paramObject.getClass();; localClass = localClass.getSuperclass())
    {
      if (localClass.getCanonicalName().equals(paramString)) {}
      for (boolean bool = true;; bool = false)
      {
        return bool;
        if (localClass != Object.class) {
          break;
        }
      }
    }
  }
  
  private boolean a(wr paramwr, View paramView)
  {
    boolean bool = false;
    if ((paramwr.b != null) && (!a(paramView, paramwr.b))) {}
    for (;;)
    {
      return bool;
      if (((-1 == paramwr.d) || (paramView.getId() == paramwr.d)) && ((paramwr.e == null) || (paramwr.e.equals(paramView.getContentDescription()))))
      {
        String str = paramwr.f;
        if ((paramwr.f == null) || ((paramView.getTag() != null) && (str.equals(paramView.getTag().toString())))) {
          bool = true;
        }
      }
    }
  }
  
  private void b(View paramView, List<wr> paramList, wp paramwp)
  {
    int i = 0;
    if (paramList.isEmpty())
    {
      paramwp.a(paramView);
      return;
    }
    ViewGroup localViewGroup;
    wr localwr;
    List localList;
    int j;
    int k;
    if (((paramView instanceof ViewGroup)) && (!this.a.a()))
    {
      localViewGroup = (ViewGroup)paramView;
      localwr = (wr)paramList.get(0);
      localList = paramList.subList(1, paramList.size());
      j = localViewGroup.getChildCount();
      k = this.a.b();
    }
    for (;;)
    {
      if (i < j)
      {
        View localView = a(localwr, localViewGroup.getChildAt(i), k);
        if (localView != null) {
          b(localView, localList, paramwp);
        }
        if ((localwr.c < 0) || (this.a.a(k) <= localwr.c)) {}
      }
      else
      {
        this.a.c();
        break;
        break;
      }
      i++;
    }
  }
  
  public void a(View paramView, List<wr> paramList, wp paramwp)
  {
    if (paramList.isEmpty()) {}
    for (;;)
    {
      return;
      if (!this.a.a())
      {
        wr localwr = (wr)paramList.get(0);
        List localList = paramList.subList(1, paramList.size());
        View localView = a(localwr, paramView, this.a.b());
        this.a.c();
        if (localView != null) {
          b(localView, localList, paramwp);
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wo
 * JD-Core Version:    0.7.0.1
 */