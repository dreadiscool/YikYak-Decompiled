import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.yik.yak.ui.activity.YakDetailActivity;
import com.yik.yak.ui.adapter.YakRecyclerViewAdapter;
import com.yik.yak.ui.view.RefreshListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;

public abstract class Fb
  extends Fa
  implements View.OnClickListener
{
  protected ImageView A = null;
  protected LinearLayout B = null;
  protected LinearLayout C;
  protected RefreshListView D;
  protected View E;
  public boolean b = true;
  public boolean c = true;
  public boolean d = true;
  public boolean e = true;
  public boolean f = false;
  public boolean g = false;
  public boolean h = false;
  public boolean i = false;
  protected String j;
  protected Animation.AnimationListener k = new Fc(this);
  protected ArrayList<CK> l;
  protected ArrayList<CK> m;
  protected BroadcastReceiver n = new Ff(this);
  protected Bundle o = null;
  protected Comparator<CK> p = new Fg(this);
  protected Comparator<CK> q = new Fh(this);
  protected Context r;
  protected int s;
  protected TranslateAnimation t;
  protected TranslateAnimation u;
  protected Fn v = Fn.a;
  protected Fn w = Fn.a;
  protected YakRecyclerViewAdapter x;
  protected YakRecyclerViewAdapter y;
  protected ImageView z = null;
  
  public Fb()
  {
    this.s = 2130903116;
  }
  
  public Fb(int paramInt)
  {
    this.s = paramInt;
  }
  
  public abstract void a();
  
  public void a(CK paramCK)
  {
    Intent localIntent = new Intent(getActivity(), YakDetailActivity.class);
    localIntent.putExtra("canSubmit", this.b);
    localIntent.putExtra("canVote", paramCK.G);
    localIntent.putExtra("canReply", paramCK.F);
    localIntent.putExtra("canReport", paramCK.H);
    localIntent.putExtra("yak", paramCK.d().toString());
    localIntent.putExtra("caller", this.j);
    startActivityForResult(localIntent, 123);
  }
  
  public void a(Fn paramFn)
  {
    this.v = paramFn;
  }
  
  protected void a(Exception paramException)
  {
    if (!isAdded()) {}
    for (;;)
    {
      return;
      new Handler(this.r.getMainLooper()).post(new Fi(this, paramException));
    }
  }
  
  public void a(Comparator<CK> paramComparator1, Comparator<CK> paramComparator2)
  {
    if ((this.l != null) && (this.l.size() > 1) && (paramComparator1 != null)) {
      Collections.sort(this.l, paramComparator1);
    }
    if ((this.m != null) && (this.m.size() > 1) && (paramComparator2 != null)) {
      Collections.sort(this.m, paramComparator2);
    }
    if (this.v == Fn.b)
    {
      this.z.setVisibility(8);
      this.A.setVisibility(0);
      this.D.setAdapter(this.y);
      this.y.setData(this.m);
      this.y.notifyDataSetChanged();
    }
    for (;;)
    {
      this.D.setRefreshing(false);
      return;
      this.z.setVisibility(0);
      this.A.setVisibility(8);
      this.D.setAdapter(this.x);
      this.x.setData(this.l);
      this.x.notifyDataSetChanged();
    }
  }
  
  public void b(String paramString)
  {
    this.j = paramString;
  }
  
  public void c() {}
  
  protected List<CK> d()
  {
    if (this.v == Fn.b) {}
    for (ArrayList localArrayList = this.m;; localArrayList = this.l) {
      return localArrayList;
    }
  }
  
  protected void e()
  {
    if (!this.D.f())
    {
      if (!CZ.c()) {
        break label72;
      }
      if (!CR.c()) {
        break label51;
      }
      this.D.setRefreshStyle(1);
      this.D.setRefreshImageDrawable(CZ.c);
      this.D.setRefreshImage(CZ.c);
    }
    for (;;)
    {
      return;
      label51:
      this.D.setRefreshStyle(2);
      this.D.setAnimationBackgroundColor(CZ.b());
      continue;
      label72:
      this.D.setRefreshStyle(1);
      this.D.setRefreshImageDrawable(2130837837);
      this.D.setRefreshImage(2130837837);
    }
  }
  
  protected void f()
  {
    if (((this.v == Fn.a) && ((this.l == null) || (this.l.size() == 0))) || ((this.v == Fn.b) && ((this.m == null) || (this.m.size() == 0)))) {
      this.D.b();
    }
    for (;;)
    {
      return;
      this.D.a();
    }
  }
  
  protected void g()
  {
    if (!this.D.f())
    {
      this.E.findViewById(2131558505).setVisibility(8);
      View localView = this.E.findViewById(2131558504);
      localView.setVisibility(0);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setDuration(1000L);
      localView.startAnimation(localRotateAnimation);
    }
  }
  
  protected void h()
  {
    View localView = this.E.findViewById(2131558504);
    localView.setAnimation(null);
    localView.setVisibility(8);
    f();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {}
    for (;;)
    {
      return;
      switch (paramInt1)
      {
      default: 
        break;
      case 123: 
        a();
      }
    }
  }
  
  public void onClick(View paramView) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.E = paramLayoutInflater.inflate(this.s, paramViewGroup, false);
    this.r = this.E.getContext();
    setHasOptionsMenu(true);
    this.o = getArguments();
    if (this.o != null)
    {
      this.b = this.o.getBoolean("canSubmit", true);
      this.c = this.o.getBoolean("canVote", true);
      this.d = this.o.getBoolean("canReply", true);
      this.e = this.o.getBoolean("canReport", true);
    }
    this.C = ((LinearLayout)this.E.findViewById(2131558742));
    this.D = ((RefreshListView)this.E.findViewById(2131558801));
    this.D.setOnRefreshListener(new Fj(this));
    this.u = new TranslateAnimation(0.0F, 0.0F, 0.0F, Ik.a(40));
    this.u.setDuration(300L);
    this.u.setFillAfter(true);
    this.u.setAnimationListener(this.k);
    this.t = new TranslateAnimation(0.0F, 0.0F, Ik.a(40), 0.0F);
    this.t.setDuration(300L);
    this.t.setFillAfter(true);
    this.D.e().setOnClickListener(this);
    this.D.setOnScrollListener(new Fk(this));
    this.x = new YakRecyclerViewAdapter(getActivity());
    this.y = new YakRecyclerViewAdapter(getActivity());
    this.x.setContextMenuEnabled(false);
    this.y.setContextMenuEnabled(false);
    this.y.setOnItemClickListener(new Fl(this));
    this.x.setOnItemClickListener(new Fm(this));
    this.z = ((ImageView)this.E.findViewById(2131558745));
    this.B = ((LinearLayout)this.E.findViewById(2131558743));
    this.B.setOnClickListener(new Fd(this));
    this.A = ((ImageView)this.E.findViewById(2131558748));
    ((LinearLayout)this.E.findViewById(2131558746)).setOnClickListener(new Fe(this));
    e();
    return this.E;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    this.r.unregisterReceiver(this.n);
  }
  
  public void onResume()
  {
    super.onResume();
    this.r.registerReceiver(this.n, new IntentFilter("REFRESH_ASSET_READY"));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Fb
 * JD-Core Version:    0.7.0.1
 */