package com.yik.yak.ui.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

public abstract class FragmentContainerActivity
  extends BaseYikYakFragmentActivity
{
  protected abstract Fragment a();
  
  protected abstract String b();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903065);
    getActionBar().setDisplayShowHomeEnabled(true);
    getActionBar().setDisplayHomeAsUpEnabled(true);
    getActionBar().setTitle(b());
    if (paramBundle == null)
    {
      Fragment localFragment = a();
      getSupportFragmentManager().beginTransaction().add(2131558494, localFragment).commit();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (boolean bool = super.onOptionsItemSelected(paramMenuItem);; bool = true)
    {
      return bool;
      super.onBackPressed();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.activity.FragmentContainerActivity
 * JD-Core Version:    0.7.0.1
 */