import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.yik.yak.YikYak;
import com.yik.yak.ui.activity.MainActivity;
import com.yik.yak.ui.activity.PinCodeDialog;

public class GI
  extends Fa
{
  private View b;
  private Context c = getActivity();
  private CM d = null;
  private ImageView e;
  private ImageView f;
  private int g;
  private View.OnClickListener h = new GJ(this);
  
  private void a()
  {
    Intent localIntent = new Intent(this.c, PinCodeDialog.class);
    localIntent.putExtra("title", getResources().getString(2131230960));
    localIntent.putExtra("pin", "new");
    startActivityForResult(localIntent, 6001);
  }
  
  private void b(String paramString)
  {
    if (paramString.equals("left"))
    {
      this.e.setBackgroundResource(2130837580);
      this.f.setBackgroundResource(0);
    }
    for (;;)
    {
      return;
      this.e.setBackgroundResource(0);
      this.f.setBackgroundResource(2130837580);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
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
      if (paramInt2 == 6003)
      {
        String str = "";
        if (paramIntent != null) {
          str = paramIntent.getStringExtra("pin");
        }
        Intent localIntent = new Intent(this.c, PinCodeDialog.class);
        localIntent.putExtra("title", getResources().getString(2131230959));
        localIntent.putExtra("pin", str);
        startActivityForResult(localIntent, 6002);
      }
      else
      {
        ((Switch)this.b.findViewById(2131558700)).setChecked(false);
        continue;
        if (paramInt2 == 6003)
        {
          if (paramIntent != null)
          {
            ApplicationConfig.e(true);
            ApplicationConfig.d(paramIntent.getStringExtra("pin"));
            ((MainActivity)getActivity()).g();
          }
          else
          {
            ApplicationConfig.d("");
            ((Switch)this.b.findViewById(2131558700)).setChecked(false);
          }
        }
        else
        {
          ((Switch)this.b.findViewById(2131558700)).setChecked(false);
          continue;
          if (paramInt2 == -1) {
            a();
          } else {
            ((Switch)this.b.findViewById(2131558700)).setChecked(false);
          }
        }
      }
    }
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.d = CM.a(this.c);
    this.b = paramLayoutInflater.inflate(2130903113, paramViewGroup, false);
    this.c = this.b.getContext();
    setHasOptionsMenu(true);
    TextView localTextView1 = (TextView)this.b.findViewById(2131558704);
    localTextView1.setTag("left");
    localTextView1.setOnClickListener(this.h);
    TextView localTextView2 = (TextView)this.b.findViewById(2131558707);
    localTextView2.setTag("right");
    localTextView2.setOnClickListener(this.h);
    this.e = ((ImageView)this.b.findViewById(2131558705));
    this.e.setTag("left");
    this.e.setOnClickListener(this.h);
    this.f = ((ImageView)this.b.findViewById(2131558708));
    this.f.setTag("right");
    this.f.setOnClickListener(this.h);
    Switch localSwitch1 = (Switch)this.b.findViewById(2131558700);
    localSwitch1.setChecked(BV.j());
    localSwitch1.setOnCheckedChangeListener(new GK(this));
    Switch localSwitch2 = (Switch)this.b.findViewById(2131558733);
    localSwitch2.setChecked(BV.n());
    localSwitch2.setOnCheckedChangeListener(new GL(this));
    Switch localSwitch3 = (Switch)this.b.findViewById(2131558711);
    localSwitch3.setChecked(BV.l());
    localSwitch3.setOnCheckedChangeListener(new GM(this));
    Switch localSwitch4 = (Switch)this.b.findViewById(2131558721);
    localSwitch4.setChecked(BV.k());
    localSwitch4.setOnCheckedChangeListener(new GN(this));
    ((Button)this.b.findViewById(2131558726)).setOnClickListener(new GO(this));
    ((Button)this.b.findViewById(2131558729)).setOnClickListener(new GP(this));
    View localView = this.b.findViewById(2131558716);
    this.g = Ik.a(44);
    Switch localSwitch5 = (Switch)this.b.findViewById(2131558715);
    localSwitch5.setChecked(BV.i());
    if (!BV.i()) {
      localView.startAnimation(new EW(localView, 0, 1));
    }
    localSwitch5.setOnCheckedChangeListener(new GQ(this, localView));
    Switch localSwitch6 = (Switch)this.b.findViewById(2131558718);
    localSwitch6.setEnabled(BV.i());
    localSwitch6.setChecked(BV.a());
    localSwitch6.setOnCheckedChangeListener(new NotificationSoundListener(this));
    ((TextView)this.b.findViewById(2131558734)).setText("Version: " + YikYak.getVersion());
    b(BV.m());
    return this.b;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    paramMenuItem.getItemId();
    return super.onOptionsItemSelected(paramMenuItem);
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     GI

 * JD-Core Version:    0.7.0.1

 */