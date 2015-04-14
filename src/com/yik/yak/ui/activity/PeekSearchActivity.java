package com.yik.yak.ui.activity;

import ApplicationConfig;
import CK;
import CM;
import CR;
import CV;
import Dp;
import Dq;
import Dr;
import Ds;
import Dt;
import Dw;
import EN;
import EP;
import EV;
import If;
import Ik;
import Im;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.yik.yak.data.models.YakkerLocation;
import com.yik.yak.ui.adapter.YakRecyclerViewAdapter;
import jE;
import jF;
import jG;
import jZ;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import yV;
import zB;
import zu;
import zz;

public class PeekSearchActivity
  extends BaseYikYakFragmentActivity
  implements EP
{
  private Context b = null;
  private jG c;
  private ArrayList<CK> d;
  private YakRecyclerViewAdapter e;
  private LinearLayoutManager f;
  private RecyclerView g;
  private YakkerLocation h;
  private boolean i = true;
  private boolean j = false;
  private AutoCompleteTextView k = null;
  private Dw l = null;
  private float m = 10.0F;
  private boolean n = false;
  
  /* Error */
  private ArrayList<String> a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 39	com/yik/yak/ui/activity/PeekSearchActivity:i	Z
    //   6: ifeq +11 -> 17
    //   9: aload_1
    //   10: invokevirtual 74	java/lang/String:length	()I
    //   13: iconst_3
    //   14: if_icmpge +13 -> 27
    //   17: new 76	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 77	java/util/ArrayList:<init>	()V
    //   24: astore_3
    //   25: aload_3
    //   26: areturn
    //   27: new 79	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   34: astore 4
    //   36: new 82	java/util/TreeMap
    //   39: dup
    //   40: invokespecial 83	java/util/TreeMap:<init>	()V
    //   43: astore 5
    //   45: aload 5
    //   47: ldc 85
    //   49: aload_1
    //   50: invokevirtual 89	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   53: pop
    //   54: aload 5
    //   56: ldc 91
    //   58: ldc 93
    //   60: invokevirtual 89	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   63: pop
    //   64: new 95	java/net/URL
    //   67: dup
    //   68: ldc 97
    //   70: aload 5
    //   72: aconst_null
    //   73: invokestatic 102	Im:a	(Ljava/lang/String;Ljava/util/TreeMap;Lcom/yik/yak/data/models/YakkerLocation;)Ljava/lang/String;
    //   76: invokespecial 105	java/net/URL:<init>	(Ljava/lang/String;)V
    //   79: invokevirtual 109	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   82: checkcast 111	java/net/HttpURLConnection
    //   85: astore 11
    //   87: new 113	java/io/InputStreamReader
    //   90: dup
    //   91: aload 11
    //   93: invokevirtual 117	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   96: invokespecial 120	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   99: astore 12
    //   101: sipush 1024
    //   104: newarray char
    //   106: astore 16
    //   108: aload 12
    //   110: aload 16
    //   112: invokevirtual 124	java/io/InputStreamReader:read	([C)I
    //   115: istore 17
    //   117: iload 17
    //   119: bipush 255
    //   121: if_icmpeq +41 -> 162
    //   124: aload 4
    //   126: aload 16
    //   128: iconst_0
    //   129: iload 17
    //   131: invokevirtual 128	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: goto -27 -> 108
    //   138: astore 15
    //   140: aload 11
    //   142: astore_2
    //   143: new 76	java/util/ArrayList
    //   146: dup
    //   147: invokespecial 77	java/util/ArrayList:<init>	()V
    //   150: astore_3
    //   151: aload_2
    //   152: ifnull -127 -> 25
    //   155: aload_2
    //   156: invokevirtual 131	java/net/HttpURLConnection:disconnect	()V
    //   159: goto -134 -> 25
    //   162: aload 11
    //   164: ifnull +8 -> 172
    //   167: aload 11
    //   169: invokevirtual 131	java/net/HttpURLConnection:disconnect	()V
    //   172: new 133	org/json/JSONObject
    //   175: dup
    //   176: aload 4
    //   178: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokespecial 138	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   184: ldc 140
    //   186: invokevirtual 144	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   189: astore 19
    //   191: new 76	java/util/ArrayList
    //   194: dup
    //   195: aload 19
    //   197: invokevirtual 147	org/json/JSONArray:length	()I
    //   200: invokespecial 150	java/util/ArrayList:<init>	(I)V
    //   203: astore_3
    //   204: iconst_0
    //   205: istore 20
    //   207: iload 20
    //   209: aload 19
    //   211: invokevirtual 147	org/json/JSONArray:length	()I
    //   214: if_icmpge -189 -> 25
    //   217: aload_3
    //   218: aload 19
    //   220: iload 20
    //   222: invokevirtual 154	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   225: ldc 156
    //   227: invokevirtual 160	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   230: invokevirtual 164	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   233: pop
    //   234: iinc 20 1
    //   237: goto -30 -> 207
    //   240: astore 8
    //   242: new 76	java/util/ArrayList
    //   245: dup
    //   246: invokespecial 77	java/util/ArrayList:<init>	()V
    //   249: astore_3
    //   250: aload_2
    //   251: ifnull -226 -> 25
    //   254: aload_2
    //   255: invokevirtual 131	java/net/HttpURLConnection:disconnect	()V
    //   258: goto -233 -> 25
    //   261: astore 7
    //   263: aload_2
    //   264: ifnull +7 -> 271
    //   267: aload_2
    //   268: invokevirtual 131	java/net/HttpURLConnection:disconnect	()V
    //   271: aload 7
    //   273: athrow
    //   274: astore 18
    //   276: aconst_null
    //   277: astore_3
    //   278: goto -253 -> 25
    //   281: astore 21
    //   283: goto -258 -> 25
    //   286: astore 14
    //   288: aload 11
    //   290: astore_2
    //   291: aload 14
    //   293: astore 7
    //   295: goto -32 -> 263
    //   298: astore 13
    //   300: aload 11
    //   302: astore_2
    //   303: goto -61 -> 242
    //   306: astore 6
    //   308: goto -165 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	PeekSearchActivity
    //   0	311	1	paramString	String
    //   1	302	2	localObject1	Object
    //   24	254	3	localArrayList	ArrayList
    //   34	143	4	localStringBuilder	StringBuilder
    //   43	28	5	localTreeMap	TreeMap
    //   306	1	6	localMalformedURLException1	java.net.MalformedURLException
    //   261	11	7	localObject2	Object
    //   293	1	7	localObject3	Object
    //   240	1	8	localIOException1	IOException
    //   85	216	11	localHttpURLConnection	java.net.HttpURLConnection
    //   99	10	12	localInputStreamReader	java.io.InputStreamReader
    //   298	1	13	localIOException2	IOException
    //   286	6	14	localObject4	Object
    //   138	1	15	localMalformedURLException2	java.net.MalformedURLException
    //   106	21	16	arrayOfChar	char[]
    //   115	15	17	i1	int
    //   274	1	18	localJSONException1	org.json.JSONException
    //   189	30	19	localJSONArray	org.json.JSONArray
    //   205	30	20	i2	int
    //   281	1	21	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   87	135	138	java/net/MalformedURLException
    //   36	87	240	java/io/IOException
    //   36	87	261	finally
    //   143	151	261	finally
    //   242	250	261	finally
    //   172	204	274	org/json/JSONException
    //   207	234	281	org/json/JSONException
    //   87	135	286	finally
    //   87	135	298	java/io/IOException
    //   36	87	306	java/net/MalformedURLException
  }
  
  private String c(YakkerLocation paramYakkerLocation)
  {
    if (!Geocoder.isPresent()) {
      localObject2 = "Location name could not be found.";
    }
    for (;;)
    {
      return localObject2;
      this.i = false;
      localObject1 = "";
      for (;;)
      {
        try
        {
          localGeocoder = new Geocoder(this.b, Locale.getDefault());
        }
        catch (Exception localException1)
        {
          Geocoder localGeocoder;
          List localList2;
          List localList1;
          int i1;
          int i2;
          Address localAddress;
          String str2;
          String str3;
          localObject2 = localObject1;
          continue;
          localObject2 = str2;
          continue;
        }
        try
        {
          localList2 = localGeocoder.getFromLocation(paramYakkerLocation.getLatitude(), paramYakkerLocation.getLongitude(), 1);
          localList1 = localList2;
          if (localList1 != null)
          {
            i1 = 1;
            if (localList1.size() <= 0) {
              continue;
            }
            i2 = 1;
            if ((i2 & i1) == 0) {
              continue;
            }
            localAddress = (Address)localList1.get(0);
            String str1 = localAddress.getLocality();
            str2 = str1;
            if (str2 != null) {
              continue;
            }
          }
        }
        catch (IOException localIOException)
        {
          try
          {
            str2 = localAddress.getSubAdminArea();
            if (str2 != null) {
              continue;
            }
            str3 = localAddress.getAdminArea();
            localObject2 = str3;
            if (localObject2 == null) {
              localObject2 = "Lat: " + paramYakkerLocation.getLatitude() + " Long: " + paramYakkerLocation.getLongitude();
            }
            this.k.setText((CharSequence)localObject2);
            this.k.setSelection(this.k.getText().length());
            this.i = true;
          }
          catch (Exception localException2)
          {
            localObject1 = str2;
            continue;
          }
          localIOException = localIOException;
          if (!this.n)
          {
            Toast.makeText(this.b, "The Geocoder service is not responding correctly. This is a common problem on some android devices and may be fixed by a simple reboot of the phone.", 1).show();
            this.n = true;
          }
          localIOException.printStackTrace();
          localList1 = null;
          continue;
          i1 = 0;
          continue;
          i2 = 0;
        }
      }
    }
  }
  
  private void c()
  {
    this.e = new YakRecyclerViewAdapter(this.b, this.d);
    this.e.setOnItemClickListener(this);
    this.g.setAdapter(this.e);
  }
  
  private void d()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(findViewById(16908290).getRootView().getWindowToken(), 0);
  }
  
  private void e()
  {
    String str = "";
    if ((this.k.getText() != null) && (this.k.getText().length() != 0)) {
      str = this.k.getText().toString();
    }
    Intent localIntent = new Intent(this.b, YikYakDialog.class);
    localIntent.putExtra("title", "Save Peek Location");
    localIntent.putExtra("message", "Save the current location to your peeks.");
    localIntent.putExtra("editText", str.split("\\,")[0]);
    localIntent.putExtra("okText", "Yes");
    localIntent.putExtra("cancelText", "No");
    startActivityForResult(localIntent, 1001);
  }
  
  public void a()
  {
    findViewById(2131558505).setVisibility(8);
    this.g.setVisibility(8);
    View localView = findViewById(2131558504);
    localView.setVisibility(0);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setDuration(1000L);
    localView.startAnimation(localRotateAnimation);
  }
  
  public void a(EV<?> paramEV, EN paramEN, int paramInt)
  {
    Toast.makeText(this.b, "This is just a preview. Save this location to view the entire feed.", 0).show();
  }
  
  public void a(YakkerLocation paramYakkerLocation)
  {
    try
    {
      this.c.c();
      this.c.d().a(true);
      this.c.a(new MarkerOptions().a(new LatLng(paramYakkerLocation.getLatitude(), paramYakkerLocation.getLongitude())));
      jE localjE = jF.a(new LatLng(paramYakkerLocation.getLatitude(), paramYakkerLocation.getLongitude()), this.m);
      this.c.a(localjE);
      b(paramYakkerLocation);
      label89:
      return;
    }
    catch (Exception localException)
    {
      break label89;
    }
  }
  
  public void b()
  {
    int i1 = 0;
    View localView1 = findViewById(2131558504);
    localView1.setAnimation(null);
    localView1.setVisibility(8);
    RecyclerView localRecyclerView = this.g;
    int i2;
    View localView2;
    if (this.d.size() == 0)
    {
      i2 = 8;
      localRecyclerView.setVisibility(i2);
      localView2 = findViewById(2131558505);
      if (this.d.size() != 0) {
        break label78;
      }
    }
    for (;;)
    {
      localView2.setVisibility(i1);
      return;
      i2 = 0;
      break;
      label78:
      i1 = 8;
    }
  }
  
  public void b(YakkerLocation paramYakkerLocation)
  {
    CM localCM = CM.a(this.b);
    a();
    YakkerLocation localYakkerLocation = localCM.f();
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("userID", ApplicationConfig.getYakkerID());
    localTreeMap.put("lat", paramYakkerLocation.getLatitudeString());
    localTreeMap.put("long", paramYakkerLocation.getLongitud());
    String str = Im.a("getMessages", localTreeMap, localYakkerLocation);
    this.d = new ArrayList();
    zz localzz = new zB().a(str).b();
    Im.a(true).a(localzz).a(new Dt(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    new StringBuilder().append(getClass().getName()).append(".onActivityResult").toString();
    new StringBuilder().append(paramInt1).append(" ").append(paramInt2).toString();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        if (paramIntent == null)
        {
          Toast.makeText(this.b, "Save failed", 0).show();
        }
        else
        {
          String str1 = paramIntent.getStringExtra("result");
          if (!Ik.a(str1))
          {
            this.h.setProvider(str1);
            String str2 = CV.a(this.h);
            Intent localIntent = new Intent();
            localIntent.putExtra("peekID", str2);
            CV.a();
            setResult(1, localIntent);
            finish();
          }
        }
        break;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903068);
    ActionBar localActionBar = getActionBar();
    if (localActionBar != null)
    {
      localActionBar.setTitle("Peek Anywhere");
      localActionBar.setDisplayHomeAsUpEnabled(true);
    }
    this.b = this;
    this.c = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(2131558499)).b();
    this.h = CM.a(this.b).f();
    this.c.a(new Dp(this));
    this.j = CR.a("peekSearch", "enableAutocomplete", false);
    Drawable localDrawable = getResources().getDrawable(2130837525);
    this.l = new Dw(this, this.b, 2130903129, this.j);
    this.k = ((AutoCompleteTextView)findViewById(2131558501));
    this.k.setAdapter(this.l);
    this.k.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
    this.k.setOnKeyListener(new Dq(this));
    this.k.setOnItemClickListener(new Dr(this));
    this.k.setOnTouchListener(new Ds(this, localDrawable));
    this.d = new ArrayList();
    this.f = new LinearLayoutManager(this);
    this.g = ((RecyclerView)findViewById(2131558506));
    this.g.setLayoutManager(this.f);
    a(this.h);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131755017, paramMenu);
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
      onBackPressed();
      continue;
      e();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    If.a().a("PeekSearch");
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.yik.yak.ui.activity.PeekSearchActivity

 * JD-Core Version:    0.7.0.1

 */