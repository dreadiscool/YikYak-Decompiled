package android.support.v4.app;

import android.view.MenuItem;

class ShareCompat$ShareCompatImplICS
  extends ShareCompat.ShareCompatImplBase
{
  public void configureMenuItem(MenuItem paramMenuItem, ShareCompat.IntentBuilder paramIntentBuilder)
  {
    ShareCompatICS.configureMenuItem(paramMenuItem, paramIntentBuilder.getActivity(), paramIntentBuilder.getIntent());
    if (shouldAddChooserIntent(paramMenuItem)) {
      paramMenuItem.setIntent(paramIntentBuilder.createChooserIntent());
    }
  }
  
  boolean shouldAddChooserIntent(MenuItem paramMenuItem)
  {
    if (!paramMenuItem.hasSubMenu()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ShareCompat.ShareCompatImplICS
 * JD-Core Version:    0.7.0.1
 */