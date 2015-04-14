import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.yik.yak.ui.activity.MainActivity;
import com.yik.yak.ui.activity.YakarmaActivity;
import java.util.ArrayList;
import java.util.List;

public class Go
  extends Fa
{
  ListView b;
  private View c;
  private Context d;
  private int e = 0;
  private List<CH> f = new ArrayList();
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
    paramMenuInflater.inflate(2131755016, paramMenu);
    ((MainActivity)getActivity()).c();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = paramLayoutInflater.inflate(2130903110, paramViewGroup, false);
    this.d = this.c.getContext();
    try
    {
      this.e = Integer.valueOf(BV.e()).intValue();
      this.f = new CH().a(this.d, CI.b);
      if (this.e < 10000)
      {
        i = 0;
        if (i < this.f.size())
        {
          if (!((CH)this.f.get(i)).c.equals("18")) {
            break label208;
          }
          this.f.remove(i);
        }
      }
      EG localEG = new EG(this.d, 2130903125, this.f);
      this.b = ((ListView)this.c.findViewById(2131558689));
      this.b.setItemsCanFocus(false);
      this.b.setAdapter(localEG);
      this.b.setOnItemClickListener(new Gp(this));
      setHasOptionsMenu(true);
      return this.c;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        this.e = 0;
        continue;
        label208:
        i++;
      }
    }
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
 * Qualified Name:     Go
 * JD-Core Version:    0.7.0.1
 */