package com.yik.yak.ui.activity;

import ApplicationConfig;
import CM;
import CR;
import CU;
import Cl;
import Ej;
import Ek;
import El;
import Em;
import En;
import Eo;
import Ep;
import Eq;
import Er;
import Es;
import If;
import Il;
import It;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.widget.TextView;
import com.yik.yak.YikYak;

public class SplashScreen
  extends BaseYikYakActivity
{
  private final Handler.Callback a = new Ej(this);
  private final Runnable b = new El(this);
  private Handler.Callback c = new Em(this);
  private Context d;
  private Dialog e;
  private Dialog f;
  private Handler g = new Handler();
  private CM h = null;
  
  private void a()
  {
    if (!Il.a(this)) {
      h();
    }
    for (;;)
    {
      return;
      e();
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 5000);
    }
    for (;;)
    {
      return;
      e();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Intent localIntent = new Intent(getApplicationContext(), MainActivity.class);
    if (getIntent().getExtras() != null)
    {
      localIntent.putExtras(getIntent().getExtras());
      if (paramBoolean) {
        If.a().b(getString(2131230747));
      }
    }
    startActivity(localIntent);
    finish();
  }
  
  private void b()
  {
    if (this.h.d()) {
      this.h.a(this.c);
    }
    for (;;)
    {
      return;
      i();
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 1) {
      b();
    }
    for (;;)
    {
      return;
      finish();
      System.exit(0);
    }
  }
  
  private void c()
  {
    if (this.e != null) {
      this.e.dismiss();
    }
    if (this.f != null) {
      this.f.dismiss();
    }
  }
  
  private void d()
  {
    if (!isFinishing()) {
      this.g.postDelayed(this.b, 500L);
    }
  }
  
  private void e()
  {
    new Cl().a(this, new En(this));
  }
  
  private void f()
  {
    CR.b(CR.a("endpoints"));
    CR.h();
  }
  
  private void g()
  {
    if (ApplicationConfig.getYakkerID().isEmpty()) {
      this.h.b(this.a);
    }
    for (;;)
    {
      return;
      if (!ApplicationConfig.c()) {
        YikYak.setParseChannel(ApplicationConfig.getYakkerID());
      }
      d();
    }
  }
  
  private void h()
  {
    c();
    this.e = It.a(this, 2131230943, 2131230942, new Eo(this), new Ep(this));
  }
  
  private void i()
  {
    c();
    this.f = It.a(this, 2131230937, 2131230936, new Eq(this), new Er(this));
  }
  
  private void j()
  {
    Intent localIntent = new Intent(this.d, YikYakDialog.class);
    localIntent.putExtra("title", "Connection");
    localIntent.putExtra("message", "There was a problem connectng to our servers.\r\n\r\nWould you like to try again or come back later?");
    localIntent.putExtra("okText", "Try Again");
    localIntent.putExtra("cancelText", "Later");
    startActivityForResult(localIntent, 100);
  }
  
  private void k()
  {
    ((TextView)findViewById(2131558521)).setText(YikYak.getVersion());
  }
  
  private void l()
  {
    new Handler().postDelayed(new Es(this), 2000L);
  }
  
  private void m()
  {
    new Handler().postDelayed(new Ek(this), 2000L);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return;
      a(paramInt2);
      continue;
      b(paramInt2);
      continue;
      l();
      continue;
      m();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903071);
    this.d = this;
    this.h = CM.a(this.d);
    if ((CU.b()) || (CU.a())) {
      a(false);
    }
    k();
  }
  
  protected void onPause()
  {
    super.onPause();
    c();
    this.g.removeCallbacks(this.b);
    if (this.f != null) {
      this.f.dismiss();
    }
    if (this.e != null) {
      this.e.dismiss();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    b();
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.yik.yak.ui.activity.SplashScreen

 * JD-Core Version:    0.7.0.1

 */