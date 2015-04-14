package butterknife;

import android.app.Activity;
import android.content.Context;
import android.view.View;

 enum ButterKnife$Finder$2
{
  ButterKnife$Finder$2()
  {
    super(str, i, null);
  }
  
  protected View findView(Object paramObject, int paramInt)
  {
    return ((Activity)paramObject).findViewById(paramInt);
  }
  
  protected Context getContext(Object paramObject)
  {
    return (Activity)paramObject;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.ButterKnife.Finder.2
 * JD-Core Version:    0.7.0.1
 */