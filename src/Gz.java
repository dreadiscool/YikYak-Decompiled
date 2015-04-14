import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.yik.yak.ui.activity.MainActivity;
import com.yik.yak.ui.activity.PeekSearchActivity;
import com.yik.yak.ui.activity.YikYakDialog;
import java.util.ArrayList;
import java.util.List;

public class Gz
  extends Fa
{
  private static final String b = Gz.class.getSimpleName();
  private final GG c = new GG(this);
  private final String d = "PeekListFragment";
  private View e;
  private Context f;
  private List<CG> g = new ArrayList();
  private ListView h;
  private Vibrator i;
  private FragmentManager j;
  
  private void a()
  {
    startActivityForResult(new Intent(this.f, PeekSearchActivity.class), 1000);
  }
  
  private void a(CG paramCG)
  {
    Intent localIntent = new Intent(this.f, YikYakDialog.class);
    localIntent.putExtra("title", "Delete Peek Location");
    localIntent.putExtra("message", "Do you want to remove " + paramCG.b + "?");
    localIntent.putExtra("value", paramCG.i);
    localIntent.putExtra("okText", "Yes");
    localIntent.putExtra("cancelText", "No");
    startActivityForResult(localIntent, 1003);
  }
  
  private void c()
  {
    getFragmentManager().executePendingTransactions();
    if (isAdded()) {
      a(CV.c());
    }
  }
  
  public void a(List<CG> paramList)
  {
    this.g = paramList;
    if (this.g == null) {}
    for (;;)
    {
      return;
      GD localGD = new GD(this, this.f, 2130903128, paramList);
      this.h.setAdapter(localGD);
      this.h.invalidateViews();
    }
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
        CV.a();
        getFragmentManager().executePendingTransactions();
        if (isAdded())
        {
          a(CV.c());
          continue;
          String str = paramIntent.getStringExtra("value");
          switch (paramInt2)
          {
          default: 
            break;
          case 1: 
            CV.d(str);
            CV.a();
            c();
          }
        }
        break;
      }
    }
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
    paramMenuInflater.inflate(2131755018, paramMenu);
    ((MainActivity)getActivity()).c();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.e = paramLayoutInflater.inflate(2130903111, paramViewGroup, false);
    this.f = this.e.getContext();
    this.i = ((Vibrator)this.f.getSystemService("vibrator"));
    this.h = ((ListView)this.e.findViewById(2131558692));
    this.h.setLongClickable(true);
    this.j = getFragmentManager();
    this.j.addOnBackStackChangedListener(new GA(this));
    this.h.setOnItemClickListener(new GB(this));
    this.h.setOnItemLongClickListener(new GC(this));
    setHasOptionsMenu(true);
    return this.e;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (boolean bool = super.onOptionsItemSelected(paramMenuItem);; bool = false)
    {
      return bool;
      a();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    CV.a("PeekListFragment");
  }
  
  public void onResume()
  {
    super.onResume();
    CV.a("PeekListFragment", this.c);
    c();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Gz
 * JD-Core Version:    0.7.0.1
 */