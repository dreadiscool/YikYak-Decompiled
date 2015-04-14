import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;

class GA
  implements FragmentManager.OnBackStackChangedListener
{
  GA(Gz paramGz) {}
  
  public void onBackStackChanged()
  {
    try
    {
      if (Gz.a(this.a).getBackStackEntryCount() == 0)
      {
        ActionBar localActionBar = this.a.getActivity().getActionBar();
        if (localActionBar != null) {
          switch (localActionBar.getSelectedTab().getPosition())
          {
          case 1: 
            localActionBar.setTitle("Peek");
            break;
          case 2: 
            localActionBar.setTitle("Me");
            break;
          case 3: 
            localActionBar.setTitle("More");
          }
        }
      }
      label88:
      return;
    }
    catch (Exception localException)
    {
      break label88;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     GA
 * JD-Core Version:    0.7.0.1
 */