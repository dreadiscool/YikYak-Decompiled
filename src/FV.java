import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.yik.yak.ui.activity.MainActivity;
import com.yik.yak.ui.activity.PeekSearchActivity;
import com.yik.yak.ui.activity.YikYakDialog;
import java.util.List;

public class FV
  extends Fa
{
  protected boolean b = false;
  protected RelativeLayout c;
  protected TranslateAnimation d;
  protected TranslateAnimation e;
  private View f = null;
  private Context g = null;
  private ListView h;
  private Gc i;
  private List<CG> j;
  private CG k;
  private Animation.AnimationListener l = new FW(this);
  
  private void a()
  {
    this.c = ((RelativeLayout)this.f.findViewById(2131558669));
    this.e = new TranslateAnimation(0.0F, 0.0F, 0.0F, Ik.a(134));
    this.e.setDuration(350L);
    this.e.setFillAfter(true);
    this.e.setAnimationListener(this.l);
    this.d = new TranslateAnimation(0.0F, 0.0F, Ik.a(134), 0.0F);
    this.d.setDuration(350L);
    this.d.setFillAfter(true);
    ((TextView)this.f.findViewById(2131558671)).setOnClickListener(new FY(this));
    ((TextView)this.f.findViewById(2131558672)).setOnClickListener(new FZ(this));
    ((TextView)this.f.findViewById(2131558673)).setOnClickListener(new Ga(this));
    this.f.findViewById(2131558656).setOnClickListener(new Gb(this));
  }
  
  private void a(CG paramCG)
  {
    Intent localIntent = new Intent(this.g, YikYakDialog.class);
    localIntent.putExtra("title", "Edit Peek Location");
    localIntent.putExtra("message", "Enter the new name for the peek location.");
    localIntent.putExtra("editText", paramCG.b);
    localIntent.putExtra("value", paramCG.i);
    localIntent.putExtra("okText", "Yes");
    localIntent.putExtra("cancelText", "No");
    startActivityForResult(localIntent, 1002);
  }
  
  private void c()
  {
    this.c.startAnimation(this.e);
    this.b = false;
  }
  
  public void b(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this.g, YikYakDialog.class);
    localIntent.putExtra("title", "Delete Peek Location");
    localIntent.putExtra("message", "Do you want to remove " + paramString2 + "?");
    localIntent.putExtra("value", paramString1);
    localIntent.putExtra("okText", "Yes");
    localIntent.putExtra("cancelText", "No");
    startActivityForResult(localIntent, 1005);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getActionBar().setTitle("Manage My Peeks");
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
        this.j = CV.d();
        this.i = new Gc(this, this.g, 2130903126, this.j);
        this.h.setAdapter(this.i);
        continue;
        if (paramInt2 == 1) {
          if (paramIntent == null)
          {
            Toast.makeText(this.g, "Delete failed", 0).show();
          }
          else
          {
            String str3 = paramIntent.getStringExtra("value");
            if (!Ik.a(str3))
            {
              CV.d(str3);
              CV.a();
              this.j = CV.d();
              this.i = new Gc(this, this.g, 2130903126, this.j);
              this.h.setAdapter(this.i);
              this.h.invalidateViews();
              continue;
              if (paramInt2 == 1) {
                if (paramIntent == null)
                {
                  Toast.makeText(this.g, "Edit failed", 0).show();
                }
                else
                {
                  String str1 = paramIntent.getStringExtra("result");
                  String str2 = paramIntent.getStringExtra("value");
                  if (!Ik.a(str1))
                  {
                    CV.a(str2, str1);
                    CV.a();
                    this.i.notifyDataSetChanged();
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
    paramMenuInflater.inflate(2131755015, paramMenu);
    ((MainActivity)getActivity()).c();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.f = paramLayoutInflater.inflate(2130903108, paramViewGroup, false);
    this.h = ((ListView)this.f.findViewById(2131558668));
    this.g = getActivity();
    this.j = CV.d();
    this.i = new Gc(this, this.g, 2130903126, this.j);
    this.h.setAdapter(this.i);
    this.h.invalidateViews();
    this.h.setOnItemClickListener(new FX(this));
    setHasOptionsMenu(true);
    a();
    return this.f;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (boolean bool = super.onOptionsItemSelected(paramMenuItem);; bool = false)
    {
      return bool;
      startActivityForResult(new Intent(this.g, PeekSearchActivity.class), 1007);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     FV
 * JD-Core Version:    0.7.0.1
 */