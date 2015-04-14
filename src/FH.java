import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.yik.yak.data.models.YakkerLocation;
import com.yik.yak.ui.activity.MainActivity;
import com.yik.yak.ui.activity.SendAYak;
import com.yik.yak.ui.adapter.YakRecyclerViewAdapter;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FH
  extends Fa
  implements EP
{
  protected boolean b = false;
  protected RelativeLayout c;
  protected TranslateAnimation d;
  protected TranslateAnimation e;
  private View f;
  private Context g;
  private JSONObject h;
  private TextView i;
  private EditText j;
  private ImageView k;
  private EditText l;
  private CM m = null;
  private boolean n = false;
  private int o;
  private CK p;
  private ArrayList<CK> q;
  private YakRecyclerViewAdapter r;
  private LinearLayoutManager s;
  private RecyclerView t;
  private Animation.AnimationListener u = new FI(this);
  private Comparator<CK> v = new FJ(this);
  
  private void a()
  {
    this.c = ((RelativeLayout)this.f.findViewById(2131558657));
    this.e = new TranslateAnimation(0.0F, 0.0F, 0.0F, Ik.a(134));
    this.e.setDuration(350L);
    this.e.setFillAfter(true);
    this.e.setAnimationListener(this.u);
    this.d = new TranslateAnimation(0.0F, 0.0F, Ik.a(134), 0.0F);
    this.d.setDuration(350L);
    this.d.setFillAfter(true);
    ((TextView)this.f.findViewById(2131558588)).setOnClickListener(new FN(this));
    ((TextView)this.f.findViewById(2131558659)).setOnClickListener(new FO(this));
    ((TextView)this.f.findViewById(2131558660)).setOnClickListener(new FP(this));
    this.f.findViewById(2131558656).setOnClickListener(new FQ(this));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      If.a().i();
    }
    this.q.remove(paramInt);
    for (;;)
    {
      try
      {
        this.h = new JSONObject("{\"messages\": []}");
        Iterator localIterator = this.q.iterator();
        if (localIterator.hasNext())
        {
          CK localCK = (CK)localIterator.next();
          try
          {
            this.h.getJSONArray("messages").put(localCK.d());
          }
          catch (JSONException localJSONException2)
          {
            localJSONException2.printStackTrace();
          }
          continue;
        }
      }
      catch (JSONException localJSONException1)
      {
        FileOutputStream localFileOutputStream;
        continue;
      }
      try
      {
        localFileOutputStream = this.g.openFileOutput("drafts.json", 0);
        localFileOutputStream.write(this.h.toString().getBytes());
        localFileOutputStream.close();
        a(this.h);
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  private void a(CK paramCK)
  {
    Intent localIntent = new Intent(this.g, SendAYak.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("content", paramCK.l);
    localIntent.putExtra("yakkerHandle", paramCK.k);
    localIntent.putExtra("showHandle", paramCK.w);
    startActivityForResult(localIntent, 19);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramTextView.setTypeface(paramTextView.getTypeface(), 0);
      paramTextView.setTextColor(getResources().getColor(2131427549));
    }
    for (;;)
    {
      return;
      paramTextView.setTypeface(paramTextView.getTypeface(), 2);
      paramTextView.setTextColor(getResources().getColor(2131427546));
    }
  }
  
  private void c()
  {
    this.c.startAnimation(this.e);
    this.b = false;
  }
  
  private void d()
  {
    this.s = new LinearLayoutManager(this.g);
    this.r = new YakRecyclerViewAdapter(this.g, this.q);
    this.r.setOnItemClickListener(this);
    this.t.setAdapter(this.r);
  }
  
  private void e()
  {
    this.j.setText("");
  }
  
  /* Error */
  private JSONObject f()
  {
    // Byte code:
    //   0: new 361	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 362	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 200	FH:g	Landroid/content/Context;
    //   12: ldc 202
    //   14: invokevirtual 366	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   17: astore 5
    //   19: aload 5
    //   21: ifnull +45 -> 66
    //   24: new 368	java/io/BufferedReader
    //   27: dup
    //   28: new 370	java/io/InputStreamReader
    //   31: dup
    //   32: aload 5
    //   34: invokespecial 373	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   37: invokespecial 376	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore 6
    //   42: aload 6
    //   44: invokevirtual 379	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore 7
    //   49: aload 7
    //   51: ifnull +47 -> 98
    //   54: aload_1
    //   55: aload 7
    //   57: invokevirtual 383	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: goto -19 -> 42
    //   64: astore 4
    //   66: aload_1
    //   67: ifnull +13 -> 80
    //   70: aload_1
    //   71: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokevirtual 388	java/lang/String:length	()I
    //   77: ifne +33 -> 110
    //   80: aload_0
    //   81: new 157	org/json/JSONObject
    //   84: dup
    //   85: ldc 159
    //   87: invokespecial 162	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   90: putfield 164	FH:h	Lorg/json/JSONObject;
    //   93: aload_0
    //   94: getfield 164	FH:h	Lorg/json/JSONObject;
    //   97: areturn
    //   98: aload 5
    //   100: invokevirtual 391	java/io/InputStream:close	()V
    //   103: goto -37 -> 66
    //   106: astore_2
    //   107: goto -41 -> 66
    //   110: aload_0
    //   111: new 157	org/json/JSONObject
    //   114: dup
    //   115: aload_1
    //   116: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokespecial 162	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   122: putfield 164	FH:h	Lorg/json/JSONObject;
    //   125: goto -32 -> 93
    //   128: astore_3
    //   129: aload_3
    //   130: invokevirtual 198	org/json/JSONException:printStackTrace	()V
    //   133: goto -40 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	FH
    //   7	109	1	localStringBuilder	StringBuilder
    //   106	1	2	localIOException	java.io.IOException
    //   128	2	3	localJSONException	JSONException
    //   64	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   17	82	5	localFileInputStream	java.io.FileInputStream
    //   40	3	6	localBufferedReader	java.io.BufferedReader
    //   47	9	7	str	String
    // Exception table:
    //   from	to	target	type
    //   8	61	64	java/io/FileNotFoundException
    //   98	103	64	java/io/FileNotFoundException
    //   8	61	106	java/io/IOException
    //   98	103	106	java/io/IOException
    //   70	93	128	org/json/JSONException
    //   110	125	128	org/json/JSONException
  }
  
  private boolean g()
  {
    If.a().h();
    ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 2);
    boolean bool;
    if ((this.i.getText().equals("200")) || (this.i.getText().equals("")))
    {
      Toast.makeText(this.g, "You have not entered a Yak yet", 1).show();
      bool = false;
    }
    for (;;)
    {
      return bool;
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      YakkerLocation localYakkerLocation = this.m.f();
      CK localCK = new CK();
      localCK.b = UUID.randomUUID().toString();
      localCK.l = this.j.getText().toString();
      localCK.s = localYakkerLocation.getLatitude();
      localCK.t = localYakkerLocation.getLatitude();
      localCK.m = localSimpleDateFormat.format(new Date());
      localCK.d = 0;
      localCK.h = 0;
      localCK.f = 0;
      localCK.j = ApplicationConfig.getYakkerID();
      String str = this.l.getText().toString();
      if ((this.n) && (!Ik.a(str)))
      {
        localCK.k = str;
        localCK.w = true;
      }
      try
      {
        this.h.getJSONArray("messages").put(localCK.d());
      }
      catch (JSONException localJSONException)
      {
        try
        {
          for (;;)
          {
            FileOutputStream localFileOutputStream = this.g.openFileOutput("drafts.json", 0);
            localFileOutputStream.write(this.h.toString().getBytes());
            localFileOutputStream.close();
            label291:
            e();
            a(this.h);
            bool = true;
            break;
            localCK.k = "";
            localCK.w = false;
            continue;
            localJSONException = localJSONException;
            localJSONException.printStackTrace();
          }
        }
        catch (Exception localException)
        {
          break label291;
        }
      }
    }
  }
  
  public void a(EV<?> paramEV, EN paramEN, int paramInt)
  {
    if (this.q == null) {}
    for (;;)
    {
      return;
      this.p = ((CK)paramEN.getItem(paramInt));
      if (this.p != null)
      {
        this.c.startAnimation(this.d);
        this.c.setVisibility(0);
        this.f.findViewById(2131558658).setVisibility(0);
        this.f.findViewById(2131558656).setVisibility(0);
        this.b = true;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = f();
    }
    this.q = new ArrayList();
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("messages");
      int i2 = localJSONArray.length();
      for (int i3 = 0; i3 < i2; i3++)
      {
        CK localCK = new CK(localJSONArray.getJSONObject(i3), false, false, false, this.g, i2 - i3);
        this.q.add(localCK);
      }
      try
      {
        View localView = this.f.findViewById(2131558505);
        if (this.q.size() == 0) {}
        for (int i1 = 0;; i1 = 8)
        {
          localView.setVisibility(i1);
          Collections.sort(this.q, this.v);
          d();
          return;
        }
      }
      catch (Exception localException)
      {
        break label137;
      }
    }
    catch (JSONException localJSONException) {}
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
      if (paramInt2 == 2001)
      {
        If.a().j();
        a(this.o, false);
        try
        {
          ((MainActivity)getActivity()).a(0);
          ((MainActivity)getActivity()).d();
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    this.j.requestFocus();
    AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    this.o = localAdapterContextMenuInfo.position;
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = super.onContextItemSelected(paramMenuItem);
    }
    for (;;)
    {
      return bool;
      a((CK)this.q.get(localAdapterContextMenuInfo.position));
      bool = true;
      continue;
      bool = true;
      continue;
      a(this.o, true);
      bool = true;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    if (paramView.getId() == 2131558655)
    {
      paramContextMenu.setHeaderTitle("Select Action");
      getActivity().getMenuInflater().inflate(2131755012, paramContextMenu);
    }
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
    paramMenuInflater.inflate(2131755011, paramMenu);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.f = paramLayoutInflater.inflate(2130903106, paramViewGroup, false);
    this.g = this.f.getContext();
    this.m = CM.a(this.g);
    this.l = ((EditText)this.f.findViewById(2131558518));
    this.l.setText(BV.d());
    this.l.setOnFocusChangeListener(new FK(this));
    this.k = ((ImageView)this.f.findViewById(2131558517));
    this.k.setOnClickListener(new FL(this));
    this.j = ((EditText)this.f.findViewById(2131558508));
    if (this.j.requestFocus()) {
      getActivity().getWindow().setSoftInputMode(5);
    }
    this.i = ((TextView)this.f.findViewById(2131558519));
    this.i.setGravity(17);
    this.i.setText("200");
    FM localFM = new FM(this);
    this.j.addTextChangedListener(localFM);
    this.q = new ArrayList();
    this.s = new LinearLayoutManager(this.g);
    this.t = ((RecyclerView)this.f.findViewById(2131558655));
    this.t.setLayoutManager(this.s);
    a();
    a(null);
    setHasOptionsMenu(true);
    return this.f;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (boolean bool = super.onOptionsItemSelected(paramMenuItem);; bool = true)
    {
      return bool;
      if (g()) {
        e();
      }
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     FH

 * JD-Core Version:    0.7.0.1

 */