package com.yik.yak.ui.activity;

import Et;
import Eu;
import Ik;
import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

public class WebActivity
  extends BaseYikYakFragmentActivity
{
  private ActionBar b;
  private ImageView c;
  private WebView d;
  private String e;
  
  private boolean a()
  {
    boolean bool = false;
    if (getIntent().hasExtra("shareEnabled")) {
      bool = getIntent().getBooleanExtra("shareEnabled", false);
    }
    return bool;
  }
  
  private String b()
  {
    String str = null;
    if (getIntent().getExtras() != null) {
      str = getIntent().getExtras().getString("title", null);
    }
    return str;
  }
  
  private String c()
  {
    String str = null;
    if (getIntent().getExtras() != null) {
      str = getIntent().getExtras().getString("url", null);
    }
    return str;
  }
  
  private void d()
  {
    if (this.c.getVisibility() == 0) {}
    for (;;)
    {
      return;
      this.c.setVisibility(0);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setDuration(1000L);
      this.c.startAnimation(localRotateAnimation);
    }
  }
  
  private void e()
  {
    this.c.setVisibility(8);
    this.c.clearAnimation();
  }
  
  private void f()
  {
    this.c = ((ImageView)findViewById(2131558737));
    this.d = ((WebView)findViewById(2131558738));
    this.d.setWebViewClient(new Et(this));
    this.d.getSettings().setJavaScriptEnabled(true);
    this.d.getSettings().setBuiltInZoomControls(true);
    this.d.getSettings().setUseWideViewPort(true);
    this.d.loadUrl(this.e);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 2)
    {
      if (this.b != null) {
        this.b.hide();
      }
      getWindow().addFlags(1024);
    }
    for (;;)
    {
      return;
      if (paramConfiguration.orientation == 1)
      {
        if (this.b != null) {
          this.b.show();
        }
        getWindow().clearFlags(1024);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    String str = "Yik Yak";
    setContentView(2130903114);
    this.b = getActionBar();
    this.b.setDisplayShowHomeEnabled(false);
    getIntent().getExtras();
    this.e = c();
    if (this.e != null)
    {
      str = b();
      if (Ik.a(str)) {
        str = "Yik Yak";
      }
    }
    for (;;)
    {
      if (Ik.a(this.e)) {
        finish();
      }
      if (this.b != null)
      {
        this.b.setTitle(str);
        this.b.setDisplayHomeAsUpEnabled(true);
      }
      f();
      return;
      try
      {
        Uri localUri = getIntent().getData();
        this.e = ("http" + localUri.toString().split("http")[1]);
      }
      catch (Exception localException)
      {
        this.e = "";
        localException.printStackTrace();
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (a()) {
      new MenuInflater(this).inflate(2131755008, paramMenu);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.d.setVisibility(8);
    this.d.loadUrl("about:blank");
    this.d.stopLoading();
    this.d.setWebChromeClient(null);
    this.d.setWebViewClient(null);
    new Handler().postDelayed(new Eu(this), 1000L + ViewConfiguration.getZoomControlsTimeout());
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      Intent localIntent = new Intent();
      localIntent.putExtra("url", this.d.getUrl());
      setResult(-1, localIntent);
      finish();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.activity.WebActivity
 * JD-Core Version:    0.7.0.1
 */