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

public class Gq
  extends Fb
{
  public Gq()
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
    String str1;
    if (this.v == Fn.b)
    {
      str1 = "getMyTops";
      this.m = new ArrayList();
    }
    for (;;)
    {
      this.i = false;
      String str2 = UrlHelper.calculateRequestUrl(str1, localTreeMap, localYakkerLocation);
      zz localzz = new zB().a(str2).b();
      UrlHelper.a(true).a(localzz).a(new Gr(this, localFragmentActivity));
      return;
      str1 = "getMyRecentReplies";
      this.l = new ArrayList();
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

 * Qualified Name:     Gq

 * JD-Core Version:    0.7.0.1

 */