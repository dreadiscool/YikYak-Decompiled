package com.yik.yak.ui.activity;

import ApplicationConfig;
import CK;
import CM;
import CV;
import Di;
import Dj;
import Dk;
import Dl;
import Dm;
import Dn;
import Do;
import EE;
import FR;
import Fb;
import Fn;
import Gd;
import Gn;
import If;
import Ik;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.AlarmManager;
import android.app.FragmentTransaction;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.adjust.sdk.Adjust;
import com.yik.yak.YikYak;
import java.util.List;
import wV;

public class MainActivity
  extends BaseYikYakFragmentActivity
  implements ActionBar.TabListener, FragmentManager.OnBackStackChangedListener
{
  public boolean b = false;
  public wV c = null;
  BroadcastReceiver d = new Di(this);
  private final Do e = new Do(this);
  private final String f = "BadgeUpdate";
  private android.support.v4.app.FragmentManager g;
  private ViewPager h;
  private EE i;
  private Context j;
  private ActionBar k;
  private Menu l;
  private String m = "Home";
  private Bundle n = null;
  private boolean o = false;
  private Runnable p = new Dj(this);
  private boolean q = false;
  private ImageView r;
  private ImageView s;
  private RelativeLayout t;
  private TextView u;
  private ImageView v;
  private RelativeLayout w;
  private TextView x;
  private ImageView y;
  private boolean z = false;
  
  private void d(int paramInt)
  {
    new Handler().postDelayed(this.p, paramInt * 1000);
  }
  
  private void h()
  {
    this.j = this;
    this.g = getSupportFragmentManager();
    Dl localDl = new Dl(this);
    this.i = new EE(this.g, localDl);
    this.h = ((ViewPager)findViewById(2131558495));
    this.h.setAdapter(this.i);
    this.h.setOffscreenPageLimit(4);
    this.h.setBackgroundColor(getResources().getColor(2131427545));
    this.k = getActionBar();
    this.k.setTitle("Yik Yak");
    this.k.setDisplayShowCustomEnabled(true);
    LayoutInflater localLayoutInflater = LayoutInflater.from(this);
    View localView1 = localLayoutInflater.inflate(2130903133, null);
    this.r = ((ImageView)localView1.findViewById(2131558790));
    View localView2 = localLayoutInflater.inflate(2130903136, null);
    this.s = ((ImageView)localView2.findViewById(2131558790));
    this.t = ((RelativeLayout)localView2.findViewById(2131558791));
    this.u = ((TextView)localView2.findViewById(2131558792));
    View localView3 = localLayoutInflater.inflate(2130903134, null);
    this.v = ((ImageView)localView3.findViewById(2131558790));
    this.w = ((RelativeLayout)localView3.findViewById(2131558791));
    this.x = ((TextView)localView3.findViewById(2131558792));
    View localView4 = localLayoutInflater.inflate(2130903135, null);
    this.y = ((ImageView)localView4.findViewById(2131558790));
    for (int i1 = 0; i1 < 4; i1++)
    {
      ActionBar.Tab localTab = this.k.newTab();
      localTab.setTag("activity_main." + i1);
      localTab.setTabListener(this);
      if (i1 == 0) {
        localTab.setCustomView(localView1);
      }
      if (i1 == 1) {
        localTab.setCustomView(localView2);
      }
      if (i1 == 2) {
        localTab.setCustomView(localView3);
      }
      if (i1 == 3) {
        localTab.setCustomView(localView4);
      }
      this.k.addTab(localTab);
    }
    this.k.setNavigationMode(2);
    b(0);
    this.h.setOnPageChangeListener(new Dm(this));
    e();
  }
  
  private void i()
  {
    Intent localIntent = new Intent(this, SendAYak.class);
    localIntent.addFlags(67108864);
    Fb localFb = (Fb)this.g.findFragmentByTag("fragment_peeklist.YakFragment");
    String str2;
    boolean bool;
    if (localFb != null)
    {
      localIntent.putExtra("isPeek", true);
      Bundle localBundle = localFb.getArguments();
      if (localBundle == null) {
        break label115;
      }
      str2 = localBundle.getString("peekID", "-1");
      bool = localBundle.getBoolean("canSubmit", false);
    }
    for (String str1 = str2;; str1 = "-1")
    {
      localIntent.putExtra("peekID", str1);
      localIntent.putExtra("canSubmit", bool);
      startActivityForResult(localIntent, 2000);
      return;
      label115:
      bool = false;
    }
  }
  
  private void j()
  {
    int i1;
    if (!this.q)
    {
      this.q = true;
      getFragmentManager().executePendingTransactions();
      i1 = 0;
    }
    for (;;)
    {
      if (i1 < this.g.getBackStackEntryCount()) {}
      try
      {
        new StringBuilder().append("mFragmentManager.").append(i1).toString();
        this.g.getBackStackEntryAt(i1).getName();
        this.g.popBackStack();
        label75:
        i1++;
        continue;
        this.q = false;
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        break label75;
      }
    }
  }
  
  private void k()
  {
    if (!BV.a(3))
    {
      String str = getResources().getString(getResources().getIdentifier("rules_rules", "string", getPackageName()));
      Intent localIntent = new Intent(this.j, YikYakDialog.class);
      localIntent.putExtra("title", "Rules");
      localIntent.putExtra("message", str);
      localIntent.putExtra("align", "left");
      localIntent.putExtra("okText", "Agree");
      localIntent.putExtra("cancelText", "Disagree");
      startActivityForResult(localIntent, 33);
    }
    for (;;)
    {
      return;
      i();
    }
  }
  
  public void a()
  {
    int i1;
    if ((this.i.a) && (this.n != null))
    {
      if ((!this.n.containsKey("action")) || (this.n.getInt("action", 0) != 4000)) {
        break label216;
      }
      YikYak.setPendingNotifications(0);
      String str2 = this.n.getString("yakId", "");
      if ((!this.o) || (!BV.j()) || (BV.h().length() != 4)) {
        break label185;
      }
      i1 = 1;
      if ((this.n.getInt("count", 1) != 1) || (i1 != 0)) {
        break label208;
      }
      a(0);
      CK localCK = new CK(str2, this.j, 1);
      if (localCK.E) {
        break label191;
      }
      FR localFR = (FR)this.g.getFragments().get(0);
      if (localFR != null)
      {
        localFR.b("PushNotification");
        localFR.a(localCK);
      }
    }
    label185:
    label191:
    label208:
    label216:
    String str1;
    label262:
    do
    {
      do
      {
        for (;;)
        {
          this.n = null;
          return;
          i1 = 0;
          break;
          Toast.makeText(this.j, "The yak is no longer available.", 0).show();
          continue;
          a(2);
          continue;
          if ((!this.n.containsKey("action")) || (this.n.getInt("action", 0) != 6005)) {
            break label262;
          }
          YikYak.setPendingNotifications(0);
          ApplicationConfig.e(false);
          this.o = false;
        }
      } while (!this.n.containsKey("android.intent.extra.TEXT"));
      str1 = this.n.getString("android.intent.extra.TEXT");
    } while (Ik.a(str1));
    String[] arrayOfString = str1.split("\\s\\|\\s");
    Intent localIntent = new Intent(this.j, SendAYak.class);
    localIntent.addFlags(67108864);
    if (arrayOfString.length == 2) {
      localIntent.putExtra("content", arrayOfString[0] + "\r\n" + arrayOfString[1]);
    }
    for (;;)
    {
      startActivityForResult(localIntent, 20);
      break;
      localIntent.putExtra("content", arrayOfString[0]);
    }
  }
  
  public void a(int paramInt)
  {
    this.k.setSelectedNavigationItem(paramInt);
    if (paramInt == 2) {}
    try
    {
      Gd localGd = (Gd)this.g.getFragments().get(2);
      if (localGd != null) {
        localGd.a(Gn.a, true);
      }
      label42:
      return;
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
  
  public void a(String paramString)
  {
    this.k.setTitle(paramString);
  }
  
  public int b()
  {
    try
    {
      int i2 = this.k.getSelectedTab().getPosition();
      i1 = i2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1 = 1;
      }
    }
    return i1;
  }
  
  public void b(int paramInt)
  {
    if (this.k.getTabCount() == 4) {
      if (getResources().getConfiguration().orientation != 2) {
        break label61;
      }
    }
    label61:
    for (int i1 = 1;; i1 = 0) {
      switch (paramInt)
      {
      default: 
        return;
      }
    }
    this.k.setTitle(this.m);
    ImageView localImageView4 = this.r;
    if (i1 != 0) {}
    for (int i5 = 2130837864;; i5 = 2130837741)
    {
      localImageView4.setImageResource(i5);
      this.s.setImageResource(2130837802);
      this.v.setImageResource(2130837737);
      this.y.setImageResource(2130837787);
      break;
    }
    this.k.setTitle("Peek");
    this.r.setImageResource(2130837742);
    ImageView localImageView3 = this.s;
    if (i1 != 0) {}
    for (int i4 = 2130837868;; i4 = 2130837801)
    {
      localImageView3.setImageResource(i4);
      this.v.setImageResource(2130837737);
      this.y.setImageResource(2130837787);
      break;
    }
    this.k.setTitle("Me");
    this.r.setImageResource(2130837742);
    this.s.setImageResource(2130837802);
    ImageView localImageView2 = this.v;
    if (i1 != 0) {}
    for (int i3 = 2130837862;; i3 = 2130837736)
    {
      localImageView2.setImageResource(i3);
      this.y.setImageResource(2130837787);
      break;
    }
    this.k.setTitle("More");
    this.r.setImageResource(2130837742);
    this.s.setImageResource(2130837802);
    this.v.setImageResource(2130837737);
    ImageView localImageView1 = this.y;
    if (i1 != 0) {}
    for (int i2 = 2130837867;; i2 = 2130837786)
    {
      localImageView1.setImageResource(i2);
      break;
    }
  }
  
  public void b(String paramString)
  {
    this.m = paramString;
    if (this.k.getSelectedTab().getPosition() == 0) {
      this.k.setTitle(this.m);
    }
  }
  
  public void c()
  {
    if (this.l != null)
    {
      MenuItem localMenuItem = this.l.findItem(2131558820);
      if (localMenuItem != null) {
        localMenuItem.setTitleCondensed(BV.e());
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt <= 0) {
      this.w.setVisibility(8);
    }
    for (;;)
    {
      this.x.setText(String.valueOf(paramInt));
      return;
      this.w.setVisibility(0);
    }
  }
  
  public void d()
  {
    try
    {
      ((FR)this.g.getFragments().get(0)).a();
      label19:
      return;
    }
    catch (Exception localException)
    {
      break label19;
    }
  }
  
  public void e()
  {
    try
    {
      ActionBar localActionBar = getActionBar();
      if (getSupportFragmentManager().getBackStackEntryCount() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        localActionBar.setDisplayHomeAsUpEnabled(bool);
        label22:
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      break label22;
    }
  }
  
  public void f()
  {
    try
    {
      Gd localGd = (Gd)this.g.getFragments().get(2);
      if (localGd != null) {
        localGd.c();
      }
      label25:
      return;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  public boolean g()
  {
    if ((BV.j()) && (BV.h().length() == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      this.o = bool;
      return this.o;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      label59:
      do
      {
        return;
        if (paramInt2 != 1) {
          break;
        }
        ApplicationConfig.setMessageTrue(3);
        i();
        break;
      } while (paramInt2 == 0);
      if ((paramInt2 == 2001) || (paramInt2 == 2002))
      {
        Object localObject = null;
        try
        {
          switch (this.k.getSelectedTab().getPosition())
          {
          }
          while (localObject != null)
          {
            ((Fb)localObject).a();
            break;
            localObject = (FR)this.g.getFragments().get(0);
            ((Fb)localObject).a(Fn.a);
            this.b = false;
            continue;
            if (paramInt2 == 2001) {}
            for (localObject = (Fb)this.g.getFragments().get(0);; localObject = (Fb)this.g.findFragmentByTag("fragment_peek.YakFragment"))
            {
              this.b = false;
              break;
            }
            localObject = (Fb)this.g.findFragmentByTag("fragment_me.YakFragment");
            this.b = true;
            continue;
            localObject = (Fb)this.g.findFragmentByTag("fragment_more.YakFragment");
            this.b = true;
          }
          if (paramInt2 == 6003)
          {
            this.o = false;
            d(300);
            a(2);
            break label59;
          }
          this.o = true;
          a(0);
        }
        catch (Exception localException) {}
        FR localFR = (FR)this.g.getFragments().get(0);
        if (localFR != null)
        {
          localFR.a();
          continue;
          if (paramInt2 == 1) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.j.getPackageName())));
          }
        }
      }
    }
  }
  
  public void onBackStackChanged()
  {
    e();
    if (getCurrentFocus() != null) {}
    try
    {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
      label33:
      return;
    }
    catch (Exception localException)
    {
      break label33;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.z = true;
    this.k.setNavigationMode(1);
    super.onConfigurationChanged(paramConfiguration);
    this.k.setNavigationMode(2);
    this.z = false;
    try
    {
      Gd localGd = (Gd)this.g.getFragments().get(2);
      if (localGd != null) {
        localGd.a(true);
      }
      label57:
      b(this.h.getCurrentItem());
      return;
    }
    catch (Exception localException)
    {
      break label57;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    try
    {
      super.onCreate(paramBundle);
      setContentView(2130903066);
      getSupportFragmentManager().addOnBackStackChangedListener(this);
      this.n = getIntent().getExtras();
      h();
    }
    catch (Exception localException1)
    {
      try
      {
        wV.a(getApplicationContext(), "21484", "cb4977fb01bb2fa9f16c219f01b59817");
        this.c = wV.a();
        label55:
        registerReceiver(this.d, new IntentFilter("IN_APP_NOTIFY"));
        new Thread(new Dk(this)).start();
        g();
        return;
        localException1 = localException1;
        PendingIntent localPendingIntent = PendingIntent.getActivity(this, 123456, new Intent(this, SplashScreen.class), 268435456);
        ((AlarmManager)getSystemService("alarm")).set(1, 100L + System.currentTimeMillis(), localPendingIntent);
        System.exit(0);
      }
      catch (Exception localException2)
      {
        break label55;
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131755014, paramMenu);
    this.l = paramMenu;
    c();
    return true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.d);
    If.a().f();
    If.a().d();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.n = paramIntent.getExtras();
    a();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = true;
    try
    {
      switch (paramMenuItem.getItemId())
      {
      default: 
        bool = super.onOptionsItemSelected(paramMenuItem);
        break;
      case 16908332: 
        android.support.v4.app.FragmentManager localFragmentManager = getSupportFragmentManager();
        if (localFragmentManager.getBackStackEntryCount() > 0) {
          localFragmentManager.popBackStack();
        }
        break;
      case 2131558823: 
        k();
        break;
      case 2131558820: 
        startActivity(new Intent(this, YakarmaActivity.class));
      }
      label97:
      return bool;
    }
    catch (Exception localException)
    {
      break label97;
    }
  }
  
  public void onPause()
  {
    boolean bool1 = true;
    super.onPause();
    Adjust.onPause();
    PowerManager localPowerManager = (PowerManager)getSystemService("power");
    try
    {
      if (Build.VERSION.SDK_INT < 20) {
        if (!localPowerManager.isScreenOn())
        {
          if ((!BV.j()) || (BV.h().length() != 4)) {
            break label62;
          }
          this.o = bool1;
        }
      }
      for (;;)
      {
        CV.a("BadgeUpdate");
        return;
        label62:
        bool1 = false;
        break;
        if (!localPowerManager.isInteractive())
        {
          if ((!BV.j()) || (BV.h().length() != 4)) {
            break label106;
          }
          bool2 = bool1;
          this.o = bool2;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        label106:
        boolean bool2 = false;
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.q = false;
    this.c.a(this);
    this.c.c();
    CM.a(this.j).g();
    if (this.n == null) {
      If.a().b(getString(2131230746));
    }
    Adjust.onResume(this);
    Adjust.setOnFinishedListener(new Dn(this));
    CV.a("BadgeUpdate", this.e);
  }
  
  public void onStart()
  {
    super.onStart();
    If.a().e();
  }
  
  public void onStop()
  {
    super.onStop();
    If.a().g();
    If.a().d();
  }
  
  public void onTabReselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction)
  {
    if (this.z) {}
    for (;;)
    {
      return;
      j();
      if (paramTab.getPosition() == 2)
      {
        Gd localGd = (Gd)this.g.getFragments().get(2);
        if (localGd != null) {
          localGd.e();
        }
      }
    }
  }
  
  public void onTabSelected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction)
  {
    if (this.z) {}
    for (;;)
    {
      return;
      int i1 = paramTab.getPosition();
      this.z = true;
      this.h.setCurrentItem(i1);
      this.z = false;
      b(i1);
      j();
      if (this.b)
      {
        FR localFR = (FR)this.g.getFragments().get(0);
        if (localFR != null) {
          localFR.a();
        }
        this.b = false;
      }
      Gd localGd;
      switch (i1)
      {
      default: 
        break;
      case 0: 
        If.a().a("MainScreen");
        If.a().f("Home");
        this.k.setTitle(this.m);
        break;
      case 1: 
        If.a().f("Peek");
        If.a().a("PeekScreen");
        CV.b();
        this.k.setTitle("Peek");
        break;
      case 2: 
        localGd = (Gd)this.g.getFragments().get(2);
        if (this.o)
        {
          if (localGd != null) {
            localGd.a(Gn.b, false);
          }
          Intent localIntent = new Intent(this.j, PinCodeDialog.class);
          localIntent.putExtra("title", getResources().getString(2131230958));
          localIntent.putExtra("pin", ApplicationConfig.h());
          startActivityForResult(localIntent, 6000);
          this.k.setTitle("Me");
          continue;
        }
        if (localGd == null) {}
      case 3: 
        try
        {
          label275:
          localGd.a();
          if ((localGd.g() == Gn.a) || (localGd.f() != 0))
          {
            localGd.e();
            localGd.a(Gn.a, true);
            YikYak.setPendingNotifications(0);
            ((NotificationManager)getSystemService("notification")).cancelAll();
          }
          label348:
          If.a().f("Me");
          If.a().a("MeScreen");
          break label275;
          If.a().f("More");
          If.a().a("MoreScreen");
          this.k.setTitle("More");
        }
        catch (Exception localException)
        {
          break label348;
        }
      }
    }
  }
  
  public void onTabUnselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction) {}
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.yik.yak.ui.activity.MainActivity

 * JD-Core Version:    0.7.0.1

 */