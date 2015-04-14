package butterknife;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

 enum ButterKnife$Finder$3
{
  ButterKnife$Finder$3()
  {
    super(str, i, null);
  }
  
  protected View findView(Object paramObject, int paramInt)
  {
    return ((Dialog)paramObject).findViewById(paramInt);
  }
  
  protected Context getContext(Object paramObject)
  {
    return ((Dialog)paramObject).getContext();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.ButterKnife.Finder.3
 * JD-Core Version:    0.7.0.1
 */