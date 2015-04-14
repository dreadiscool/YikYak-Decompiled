package com.yik.yak.ui.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import jF;
import jG;
import jZ;

public class MapActivity
  extends BaseYikYakFragmentActivity
{
  public void a(double paramDouble1, double paramDouble2, boolean paramBoolean, String paramString)
  {
    try
    {
      jG localjG = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(2131558496)).b();
      localjG.d().a(true);
      localjG.d().b(true);
      localjG.a(jF.a(new LatLng(paramDouble1, paramDouble2), 15.0F));
      label54:
      return;
    }
    catch (Exception localException)
    {
      break label54;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903067);
    ActionBar localActionBar = getActionBar();
    if (localActionBar != null)
    {
      localActionBar.setTitle("Map");
      localActionBar.setDisplayHomeAsUpEnabled(true);
    }
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      a(localBundle.getDouble("lat", 0.0D), localBundle.getDouble("lon", 0.0D), localBundle.getBoolean("hidePin", true), "");
    }
    for (;;)
    {
      return;
      finish();
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
      onBackPressed();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.activity.MapActivity
 * JD-Core Version:    0.7.0.1
 */