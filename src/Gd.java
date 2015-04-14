import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.yik.yak.YikYak;
import com.yik.yak.ui.activity.MainActivity;
import com.yik.yak.ui.activity.YakarmaActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Gd
  extends Fa
{
  private static Handler b = null;
  private View c;
  private Context d;
  private jG e;
  private List<CH> f = new ArrayList();
  private Location g;
  private ListView h;
  private List<Cu> i;
  private ListView j;
  private Cu k;
  private EH l;
  private Gn m = Gn.c;
  private CH n = null;
  private int o = 0;
  private boolean p = false;
  private boolean q = false;
  private ImageView r = null;
  private float s = 0.0F;
  private Animation t;
  private Animation u;
  private View.OnClickListener v = new Ge(this);
  
  private void a(int paramInt)
  {
    try
    {
      ((MainActivity)getActivity()).c(paramInt);
      label11:
      return;
    }
    catch (Exception localException)
    {
      break label11;
    }
  }
  
  private void a(CH paramCH)
  {
    int i1 = 1;
    try
    {
      i1 = Integer.parseInt(paramCH.c);
      ((MainActivity)getActivity()).a(paramCH.b);
      ((MainActivity)getActivity()).a(paramCH.b);
      switch (i1)
      {
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        ((MainActivity)getActivity()).a("My Recent Yaks");
        continue;
        If.a().n();
        Gt localGt = new Gt();
        localGt.a("MyRecentScreen");
        localGt.a(Fn.a);
        a(localGt, "MyYaksFragment");
        continue;
        If.a().o();
        Gq localGq = new Gq();
        localGq.a("MyRecentRepliesScreen");
        localGq.a(Fn.a);
        a(localGq, "MyReplies");
        continue;
        a(new GI(), "SettingsFragment");
        continue;
        FV localFV = new FV();
        localFV.a("ManageMyPeeksScreen");
        a(localFV, "ManageMyPeeksScreen");
        continue;
        FH localFH = new FH();
        localFH.a("DraftsFragment");
        a(localFH, "DraftsFragment");
      }
    }
  }
  
  private void h()
  {
    if (this.i == null) {
      this.i = new ArrayList();
    }
    this.i.add(new Cu("", "", "", "", "", "", "system", "You do not have any notifications.", "", "system", "", ""));
  }
  
  public void a()
  {
    this.g = CM.a(getActivity()).f();
    try
    {
      this.e = ((SupportMapFragment)getChildFragmentManager().findFragmentById(2131558676)).b();
      this.e.d().a(false);
      this.e.d().b(false);
      jE localjE = jF.a(new LatLng(this.g.getLatitude(), this.g.getLongitude()), 12.0F);
      this.e.a(localjE);
      label91:
      return;
    }
    catch (Exception localException)
    {
      break label91;
    }
  }
  
  public void a(Cw paramCw)
  {
    CM.a(YikYak.getContext());
    String str = CR.k() + "/" + paramCw.toString() + "/";
    switch (Gm.a[paramCw.ordinal()])
    {
    }
    for (;;)
    {
      zz localzz = new zB().a(str).b();
      UrlHelper.a(false).a(localzz).a(new Gh(this));
      return;
      str = str + ApplicationConfig.getYakkerID();
    }
  }
  
  public void a(Cw paramCw, List<Cu> paramList, String paramString)
  {
    CM.a(YikYak.getContext());
    String str = CR.k() + "/" + paramCw.toString() + "/";
    if ((paramList == null) || (paramList.size() == 0) || (Ik.a(paramString))) {
      Toast.makeText(this.d, "There are no notifications to update", 0).show();
    }
    JSONObject localJSONObject2;
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject1 = new JSONObject("{\"notificationIDs\":[],\"status\":\"" + paramString + "\",\"userID\":\"" + ApplicationConfig.getYakkerID() + "\"}");
        localJSONObject2 = localJSONObject1;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          Iterator localIterator;
          localJSONException2.printStackTrace();
          localJSONObject2 = null;
        }
        this.o = 0;
        a(this.o);
      }
      if (localJSONObject2 == null) {
        break label360;
      }
      switch (Gm.a[paramCw.ordinal()])
      {
      }
    }
    localIterator = paramList.iterator();
    for (int i1 = 0;; i1 = i2)
    {
      if (!localIterator.hasNext()) {
        break label264;
      }
      Cu localCu = (Cu)localIterator.next();
      try
      {
        localJSONObject2.getJSONArray("notificationIDs").put(localCu.a());
        localCu.a(paramString);
        i2 = 1;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          i2 = i1;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          int i2 = i1;
        }
      }
    }
    for (;;)
    {
      label264:
      if (i1 == 0)
      {
        Toast.makeText(this.d, "There are no notifications to update", 0).show();
        break;
      }
      zC localzC = zC.a(zt.a("application/json; charset=utf-8"), localJSONObject2.toString());
      zz localzz = new zB().a(localzC).a(str).b();
      UrlHelper.a(false).a(localzz).a(new Gk(this));
      break;
      label360:
      i1 = 0;
    }
  }
  
  public void a(Gn paramGn, boolean paramBoolean)
  {
    if (b != null)
    {
      Message localMessage = new Message();
      localMessage.arg1 = this.o;
      b.sendMessage(localMessage);
    }
    if (paramGn == Gn.a)
    {
      if ((this.m != paramGn) || (this.p))
      {
        this.r.startAnimation(this.u);
        this.p = false;
      }
      this.m = Gn.a;
      this.c.findViewById(2131558685).setVisibility(8);
      this.c.findViewById(2131558683).setVisibility(0);
      if (paramBoolean) {
        a(Cw.c);
      }
    }
    for (;;)
    {
      return;
      if ((this.m != paramGn) || (this.p))
      {
        this.r.startAnimation(this.t);
        this.p = false;
      }
      this.m = Gn.b;
      this.c.findViewById(2131558683).setVisibility(8);
      this.c.findViewById(2131558685).setVisibility(0);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
    float f1 = Resources.getSystem().getDisplayMetrics().widthPixels / 10.0F;
    float f2 = 3.0F * f1;
    float f3 = 6.0F * f1;
    this.r = ((ImageView)this.c.findViewById(2131558679));
    this.r.getLayoutParams().width = Math.round(f2);
    this.r.setLeft(Math.round(this.s));
    this.t = new TranslateAnimation(f1, f3, 0.0F, 0.0F);
    this.t.setInterpolator(new BounceInterpolator());
    this.t.setDuration(1000L);
    this.t.setFillAfter(true);
    this.u = new TranslateAnimation(f3, f1, 0.0F, 0.0F);
    this.u.setInterpolator(new BounceInterpolator());
    this.u.setDuration(1000L);
    this.u.setFillAfter(true);
    if (paramBoolean) {
      a(this.m, false);
    }
  }
  
  public void c()
  {
    this.j = ((ListView)this.c.findViewById(2131558684));
    this.j.setItemsCanFocus(false);
    this.j.setOnItemClickListener(new Gf(this));
    this.i = new ArrayList();
    a(Cw.c);
  }
  
  public void d()
  {
    this.h = ((ListView)this.c.findViewById(2131558686));
    this.h.setItemsCanFocus(false);
    this.h.setOnItemClickListener(new Gg(this));
    this.f = new CH().a(this.d, CI.a);
    EF localEF = new EF(this.d, 2130903124, this.f);
    this.h.setAdapter(localEF);
  }
  
  public void e()
  {
    if (!this.q) {}
    for (;;)
    {
      return;
      if ((this.o != 0) && (this.m != Gn.a)) {
        a(Gn.a, false);
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        Cu localCu = (Cu)localIterator.next();
        if (localCu.i().equals("new")) {
          localArrayList.add(localCu);
        }
      }
      if (localArrayList.size() > 0) {
        a(Cw.i, localArrayList, "unread");
      }
    }
  }
  
  public int f()
  {
    return this.o;
  }
  
  public Gn g()
  {
    return this.m;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
    paramMenuInflater.inflate(2131755016, paramMenu);
    ((MainActivity)getActivity()).c();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = paramLayoutInflater.inflate(2130903109, paramViewGroup, false);
    this.d = this.c.getContext();
    ((TextView)this.c.findViewById(2131558681)).setOnClickListener(this.v);
    ((TextView)this.c.findViewById(2131558682)).setOnClickListener(this.v);
    a(false);
    a();
    d();
    c();
    setHasOptionsMenu(true);
    return this.c;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (boolean bool = super.onOptionsItemSelected(paramMenuItem);; bool = false)
    {
      return bool;
      startActivity(new Intent(this.d, YakarmaActivity.class));
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     Gd

 * JD-Core Version:    0.7.0.1

 */