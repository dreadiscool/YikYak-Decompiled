package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.internal.widget.ActivityChooserModel;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShareActionProvider$ShareMenuItemOnMenuItemClickListener
  implements MenuItem.OnMenuItemClickListener
{
  private ShareActionProvider$ShareMenuItemOnMenuItemClickListener(ShareActionProvider paramShareActionProvider) {}
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    Intent localIntent = ActivityChooserModel.get(ShareActionProvider.access$100(this.this$0), ShareActionProvider.access$200(this.this$0)).chooseActivity(paramMenuItem.getItemId());
    if (localIntent != null)
    {
      localIntent.addFlags(524288);
      ShareActionProvider.access$100(this.this$0).startActivity(localIntent);
    }
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ShareActionProvider.ShareMenuItemOnMenuItemClickListener
 * JD-Core Version:    0.7.0.1
 */