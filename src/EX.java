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

public class EX
  extends Fb
{
  public EX()
  {
    super(2130903117);
    this.i = true;
  }
  
  public void a()
  {
    g();
    this.v = Fn.b;
    FragmentActivity localFragmentActivity = getActivity();
    YakkerLocation localYakkerLocation = CM.a(localFragmentActivity).f();
    this.h = false;
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("userID", ApplicationConfig.getYakkerID());
    localTreeMap.put("lat", localYakkerLocation.getLatitude());
    localTreeMap.put("long", localYakkerLocation.getLongitude());
    this.l = new ArrayList();
    this.m = new ArrayList();
    String str = UrlHelper.calculateRequestUrl("getAreaTops", localTreeMap, localYakkerLocation);
    zz localzz = new zB().a(str).b();
    UrlHelper.a(true).a(localzz).a(new EY(this, localFragmentActivity));
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
    a();
    return localView;
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     EX

 * JD-Core Version:    0.7.0.1

 */