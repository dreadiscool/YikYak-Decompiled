package com.yik.yak.ui.activity;

import Dz;
import HT;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class PhotoActivity
  extends BaseYikYakFragmentActivity
{
  public HT b;
  @InjectView(2131558507)
  public ImageView mImageView;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903069);
    ButterKnife.inject(this);
    getActionBar().hide();
    overridePendingTransition(2130968595, 2130968600);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.b != null) {
      this.b.a();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    overridePendingTransition(2130968594, 2130968601);
  }
  
  public void onResume()
  {
    super.onResume();
    Bundle localBundle = getIntent().getExtras();
    if ((localBundle != null) && (localBundle.containsKey("url")))
    {
      String str = localBundle.getString("url");
      Picasso.with(this).load(str).into(this.mImageView, new Dz(this));
    }
    for (;;)
    {
      return;
      finish();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.activity.PhotoActivity
 * JD-Core Version:    0.7.0.1
 */