package com.yik.yak.ui.activity;

import ApplicationConfig;
import CK;
import CM;
import CR;
import Co;
import Cq;
import DL;
import DM;
import DN;
import DO;
import DP;
import DQ;
import DR;
import DS;
import DT;
import DU;
import DV;
import DW;
import DX;
import Ea;
import Ed;
import Ef;
import Eg;
import Eh;
import Ei;
import Hm;
import If;
import Ik;
import Im;
import android.app.ActionBar;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.location.Location;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.nispok.snackbar.Snackbar;
import com.yik.yak.data.models.YakkerLocation;
import com.yik.yak.ui.view.LinkDetectingEditText;
import com.yik.yak.ui.view.LinkIconView;
import java.io.File;
import java.util.TreeMap;
import yC;
import yD;
import yE;
import yV;
import yz;
import zB;
import zC;
import zt;
import zu;
import zz;

public class SendAYak
  extends BaseYikYakActivity
{
  private Bundle a = new Bundle();
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private Context g;
  private Ei h;
  private Handler i = new Handler();
  private Runnable j = new DL(this);
  private String k;
  private String l;
  private CM m = null;
  private EditText n;
  private ImageView o;
  private ImageView p;
  private LinkDetectingEditText q;
  private LinkIconView r;
  private ProgressBar s;
  private RelativeLayout t;
  private TextView u;
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      h();
      super.onBackPressed();
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = ThumbnailUtils.extractThumbnail(paramBitmap, Ik.a(55), Ik.a(55));
    o();
    ((ImageView)findViewById(2131558512)).setImageBitmap(localBitmap);
  }
  
  private void a(Bundle paramBundle)
  {
    this.n.setText(paramBundle.getString("yakkerHandle", ""));
    this.d = paramBundle.getBoolean("showHandle", false);
    if (!this.d)
    {
      this.o.setImageResource(2130837565);
      a(this.n, false);
    }
    for (;;)
    {
      this.q.setText(paramBundle.getString("content", ""));
      this.u.setText(String.valueOf(200 - this.q.getText().length()));
      return;
      this.o.setImageResource(2130837564);
      a(this.n, true);
    }
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramTextView.setTextColor(getResources().getColor(2131427549));
    }
    for (;;)
    {
      return;
      paramTextView.setTextColor(getResources().getColor(2131427546));
    }
  }
  
  private void a(String paramString)
  {
    if (((!BV.a(2)) || (CR.a("threatWords", "alwaysShowMessage", true))) && (Ik.b(paramString)))
    {
      String str = CR.a("threatWords", "message", CR.c);
      Intent localIntent = new Intent(this.g, YikYakDialog.class);
      localIntent.putExtra("title", "WARNING");
      localIntent.putExtra("message", str);
      localIntent.putExtra("value", paramString);
      localIntent.putExtra("okText", "YES");
      localIntent.putExtra("cancelText", "NO");
      startActivityForResult(localIntent, 7004);
    }
    for (;;)
    {
      return;
      this.c = true;
      if (this.b) {
        a(paramString, 0);
      } else {
        b(paramString, 0);
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    String str1 = this.a.getString("peekID", "-1");
    if (str1.equals("-1"))
    {
      Toast.makeText(this.g, "Cannot post Yak to this Peek.", 0).show();
      setResult(2003);
      finish();
    }
    for (;;)
    {
      return;
      TreeMap localTreeMap = new TreeMap();
      localTreeMap.put("userID", ApplicationConfig.getYakkerID());
      localTreeMap.put("peekID", String.valueOf(str1));
      localTreeMap.put("message", paramString);
      localTreeMap.put("bypassedThreatPopup", String.valueOf(paramInt));
      String str2 = this.n.getText().toString();
      if ((this.d) && (!Ik.a(str2))) {
        localTreeMap.put("hndl", str2);
      }
      ApplicationConfig.b(str2);
      String str3 = Im.b(CR.f(), "submitPeekMessage", localTreeMap, null);
      zC localzC = zC.a(zt.a("application/x-www-form-urlencoded"), (String)localTreeMap.get("RequestBody:body"));
      zz localzz = new zB().a(localzC).a(str3).b();
      Im.a(true).a(localzz).a(new DX(this));
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this.g, YikYakDialog.class);
    localIntent.putExtra("title", paramString1);
    localIntent.putExtra("message", paramString2);
    localIntent.putExtra("okText", "OK");
    localIntent.putExtra("okOnly", "true");
    startActivity(localIntent);
  }
  
  private void a(String paramString, yz paramyz)
  {
    a(paramString, paramyz, null, null);
  }
  
  private void a(String paramString1, yz paramyz, String paramString2, yE paramyE)
  {
    Snackbar localSnackbar1 = yC.b();
    if ((localSnackbar1 != null) && (localSnackbar1.d().toString().equals(paramString1)) && (!localSnackbar1.h())) {}
    for (;;)
    {
      return;
      n();
      Snackbar localSnackbar2 = Snackbar.a(this).a(paramString1).a(paramyz).a(2131427619).a(false);
      if (paramString2 != null) {
        localSnackbar2.a(yD.b).b(paramString2).a(paramyE);
      }
      yC.a(localSnackbar2, (ViewGroup)findViewById(2131558514));
    }
  }
  
  private boolean a()
  {
    return this.q.getText().toString().isEmpty();
  }
  
  private void b()
  {
    YakkerLocation localYakkerLocation = CM.a(this).f();
    if ((localYakkerLocation == null) || ((localYakkerLocation.getLatitude() == 0.0D) && (localYakkerLocation.getLongitude() == 0.0D)))
    {
      Intent localIntent = new Intent(this.g, YikYakDialog.class);
      localIntent.putExtra("title", "Location Services");
      localIntent.putExtra("message", "Location services must be enabled to postw and read local Yaks. Would you like to enable it now?");
      localIntent.putExtra("okText", "YES");
      localIntent.putExtra("cancelText", "NO");
      startActivityForResult(localIntent, 5002);
    }
  }
  
  private void b(String paramString)
  {
    String str1 = CR.a("images", "s3Url", CR.l());
    String str2 = str1 + "?s3_object_name=" + paramString;
    zz localzz = new zB().a(str2).b();
    Im.a(true).a(localzz).a(new Ed(this, paramString));
  }
  
  private void b(String paramString, int paramInt)
  {
    TreeMap localTreeMap = new TreeMap();
    int i1 = 0;
    String str1 = this.n.getText().toString();
    if ((this.d) && (!Ik.a(str1))) {
      localTreeMap.put("hndl", str1);
    }
    ApplicationConfig.b(str1);
    YakkerLocation localYakkerLocation = this.m.f();
    localTreeMap.put("userID", ApplicationConfig.getYakkerID());
    localTreeMap.put("lat", localYakkerLocation.getLatitude());
    localTreeMap.put("long", localYakkerLocation.getLongitude());
    localTreeMap.put("bypassedThreatPopup", String.valueOf(paramInt));
    localTreeMap.put("message", paramString);
    if (!Ik.a(this.k))
    {
      i1 = 6;
      localTreeMap.put("pID", this.k);
    }
    String str2 = CK.a(i1);
    String str3 = Im.b(CR.f(), "sendMessage", localTreeMap, null);
    zC localzC = zC.a(zt.a("application/x-www-form-urlencoded"), (String)localTreeMap.get("RequestBody:body"));
    zz localzz = new zB().a(localzC).a(str3).b();
    Im.a(true).a(localzz).a(new Ea(this, str2));
  }
  
  private void c()
  {
    f();
    new Handler().postDelayed(new DV(this), 500L);
  }
  
  private void d()
  {
    startActivityForResult(new Intent(this, WebsiteWhiteListActivity.class), 100);
  }
  
  private void e()
  {
    if (this.f) {
      Toast.makeText(getApplicationContext(), "We are currently processing your link.", 1).show();
    }
    if (this.e) {
      Toast.makeText(getApplicationContext(), "We are currently processing your image.", 1).show();
    }
    for (;;)
    {
      return;
      if (this.r.a() == Hm.a)
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this).setTitle("Invalid Link Input").setPositiveButton("Ok", null);
        int i1;
        if (this.q.b()) {
          i1 = 2131230922;
        }
        for (;;)
        {
          localBuilder.setMessage(i1);
          localBuilder.show();
          break;
          i1 = 2131230921;
          localBuilder.setNeutralButton("Sites", new DW(this));
        }
      }
      if (!this.c) {
        if ((this.u.getText().equals("200")) || (this.u.getText().equals("")) || (this.q.getText().toString().trim().length() == 0)) {
          Toast.makeText(getApplicationContext(), "You have not entered a Yak yet", 1).show();
        } else {
          a(this.q.getText().toString());
        }
      }
    }
  }
  
  private void f()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.q.getWindowToken(), 2);
  }
  
  private void g()
  {
    new Handler(Looper.getMainLooper()).post(new Ef(this));
  }
  
  private void h()
  {
    if (Ik.a(this.l)) {}
    for (;;)
    {
      return;
      try
      {
        String str = this.l;
        this.l = null;
        new File(str).delete();
      }
      catch (Exception localException) {}
    }
  }
  
  private void i()
  {
    Intent localIntent = new Intent(this.g, YikYakDialog.class);
    localIntent.putExtra("title", "Remove Image?");
    localIntent.putExtra("message", "Are you sure you want to remove this image?");
    localIntent.putExtra("okText", "YES");
    localIntent.putExtra("cancelText", "NO");
    startActivityForResult(localIntent, 2005);
  }
  
  private void j()
  {
    this.r.setIconState(Hm.b);
    this.q.setLinkTextColor(-16776961);
    n();
  }
  
  private void k()
  {
    this.r.setIconState(Hm.a);
    this.q.setLinkTextColor(-65536);
    a("This link is not valid.", yz.c, "View Sites", new Eg(this));
  }
  
  private void l()
  {
    this.f = true;
    new Cq(this.q.getText().toString()).a(this, new Eh(this));
  }
  
  private void m()
  {
    this.t.setVisibility(8);
  }
  
  private void n() {}
  
  private void o()
  {
    this.t.setVisibility(0);
  }
  
  private void p()
  {
    this.e = true;
    this.s.setVisibility(0);
  }
  
  private void q()
  {
    this.e = false;
    this.s.setVisibility(8);
  }
  
  private void r()
  {
    this.q = ((LinkDetectingEditText)findViewById(2131558508));
    if (this.a.containsKey("content"))
    {
      this.q.clearFocus();
      a(this.a);
    }
    this.r = ((LinkIconView)findViewById(2131558516));
    if (CR.a("linksEnabled", false))
    {
      this.r.setVisibility(0);
      this.q.setLinksEnabled(true);
    }
    for (;;)
    {
      return;
      this.r.setVisibility(8);
      this.q.setLinksEnabled(false);
    }
  }
  
  private void s()
  {
    this.r.setOnClickListener(new DQ(this));
    this.q.setOnLinkAddedOrEditedListener(new DR(this));
    this.q.addTextChangedListener(new DS(this));
  }
  
  private void t()
  {
    new Co().a(this, new DT(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 0) {}
    for (;;)
    {
      return;
      switch (paramInt1)
      {
      default: 
        break;
      case 100: 
        this.q.setText(paramIntent.getStringExtra("url"));
        break;
      case 7007: 
        a(paramInt2);
        break;
      case 2005: 
        g();
        if (paramInt2 == 1)
        {
          h();
          this.k = null;
          this.l = null;
          m();
        }
        break;
      case 5002: 
        if (paramInt2 == 1)
        {
          startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 5000);
        }
        else
        {
          setResult(0);
          finish();
        }
        break;
      case 5000: 
        b();
        break;
      case 7004: 
        switch (paramInt2)
        {
        default: 
          break;
        case 1: 
          ApplicationConfig.b(2);
          this.c = true;
          if (this.b) {
            a(paramIntent.getStringExtra("value"), 1);
          } else {
            b(paramIntent.getStringExtra("value"), 1);
          }
          break;
        }
        break;
      case 2004: 
        if (paramInt2 == -1)
        {
          m();
          p();
          new Handler().postDelayed(new DU(this), 500L);
        }
        else
        {
          g();
          this.k = null;
        }
        break;
      }
    }
  }
  
  public void onBackPressed()
  {
    if (!a())
    {
      Intent localIntent = new Intent(this.g, YikYakDialog.class);
      localIntent.putExtra("title", getString(2131230962));
      localIntent.putExtra("message", getString(2131230961));
      localIntent.putExtra("okText", getString(2131231036));
      localIntent.putExtra("cancelText", getString(2131230941));
      startActivityForResult(localIntent, 7007);
    }
    for (;;)
    {
      return;
      h();
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903070);
    this.g = this;
    this.m = CM.a(this.g);
    this.a = getIntent().getExtras();
    if (this.a == null) {
      this.a = new Bundle();
    }
    this.b = this.a.getBoolean("isPeek", false);
    if ((this.a.containsKey("canSubmit")) && (!this.a.getBoolean("canSubmit")))
    {
      Toast.makeText(this.g, "Cannot post Yak to this Peek.", 0).show();
      setResult(2003);
      finish();
    }
    for (;;)
    {
      return;
      ActionBar localActionBar = getActionBar();
      if (localActionBar != null) {
        localActionBar.setTitle("Send a Yak");
      }
      this.s = ((ProgressBar)findViewById(2131558513));
      this.n = ((EditText)findViewById(2131558518));
      this.n.setText(BV.d());
      this.n.setOnFocusChangeListener(new DM(this));
      this.o = ((ImageView)findViewById(2131558517));
      this.o.setOnClickListener(new DN(this));
      if ((CR.a("photosEnabled", false)) && (this.g.getPackageManager().hasSystemFeature("android.hardware.camera") == true))
      {
        this.p = ((ImageView)findViewById(2131558515));
        this.p.setVisibility(0);
        this.p.setOnClickListener(new DO(this));
      }
      this.u = ((TextView)findViewById(2131558519));
      this.u.setGravity(17);
      this.u.setText("200");
      this.t = ((RelativeLayout)findViewById(2131558511));
      this.t.setOnClickListener(new DP(this));
      b();
      r();
      s();
      t();
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131755020, paramMenu);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = true;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = super.onOptionsItemSelected(paramMenuItem);
    }
    for (;;)
    {
      return bool;
      setResult(0);
      onBackPressed();
      continue;
      e();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!this.q.getText().toString().isEmpty())
    {
      this.i.removeCallbacks(this.j);
      this.i.postDelayed(this.j, 500L);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    If.a().a("SendScreen");
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.yik.yak.ui.activity.SendAYak

 * JD-Core Version:    0.7.0.1

 */