import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.yik.yak.data.models.YakkerLocation;
import com.yik.yak.ui.activity.MainActivity;
import java.util.ArrayList;
import java.util.TreeMap;

public class Gt
  extends Fb
{
  private boolean F = false;
  
  public Gt()
  {
    super(2130903117);
  }
  
  public void a()
  {
    g();
    FragmentActivity localFragmentActivity = getActivity();
    YakkerLocation localYakkerLocation = CM.a(localFragmentActivity).f();
    this.h = false;
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("userID", ApplicationConfig.getYakkerID());
    localTreeMap.put("lat", localYakkerLocation.getLatitude());
    localTreeMap.put("long", localYakkerLocation.getLongitude());
    this.l = new ArrayList();
    this.m = new ArrayList();
    String str = UrlHelper.calculateRequestUrl("getMyRecentYaks", localTreeMap, localYakkerLocation);
    zz localzz = new zB().a(str).b();
    UrlHelper.a(true).a(localzz).a(new Gu(this, localFragmentActivity));
  }
  
  public void c()
  {
    if ((!this.F) && (this.v == Fn.b))
    {
      this.F = true;
      If.a().p();
    }
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
    paramMenuInflater.inflate(2131755014, paramMenu);
    ((MainActivity)getActivity()).c();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.v = Fn.a;
    a();
    return localView;
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     Gt

 * JD-Core Version:    0.7.0.1

 */