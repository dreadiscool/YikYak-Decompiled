package android.support.v7.internal.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.ActionProvider;

@TargetApi(16)
class MenuItemWrapperJB
  extends MenuItemWrapperICS
{
  MenuItemWrapperJB(Context paramContext, SupportMenuItem paramSupportMenuItem)
  {
    super(paramContext, paramSupportMenuItem);
  }
  
  MenuItemWrapperICS.ActionProviderWrapper createActionProviderWrapper(ActionProvider paramActionProvider)
  {
    return new MenuItemWrapperJB.ActionProviderWrapperJB(this, this.mContext, paramActionProvider);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperJB
 * JD-Core Version:    0.7.0.1
 */