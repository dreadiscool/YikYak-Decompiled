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

public class Gw
  extends Fb
{
  public Gw()
  {
    super(2130903117);
    a("PeekFragment", "PeekFragment");
  }
  
  public void a()
  {
    CR.b("photosEnabled", false);
    CR.b("linksEnabled", false);
    g();
    FragmentActivity localFragmentActivity = getActivity();
    YakkerLocation localYakkerLocation1 = CM.a(localFragmentActivity).f();
    this.h = false;
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("userID", ApplicationConfig.getYakkerID());
    localTreeMap.put("lat", localYakkerLocation1.a());
    localTreeMap.put("long", localYakkerLocation1.b());
    String str1 = this.o.getString("peekID", "");
    String str2;
    if (str1.equals(""))
    {
      YakkerLocation localYakkerLocation2 = new YakkerLocation("peek");
      localYakkerLocation2.setLatitude(Double.parseDouble(this.o.getString("peekLatitude", "0")));
      localYakkerLocation2.setLongitude(Double.parseDouble(this.o.getString("peekLongitude", "0")));
      localTreeMap.put("lat", localYakkerLocation2.a());
      localTreeMap.put("long", localYakkerLocation2.b());
      if (this.v == Fn.b)
      {
        str2 = "hot";
        this.m = new ArrayList();
      }
    }
    for (;;)
    {
      this.i = false;
      String str3 = Im.a(str2, localTreeMap, localYakkerLocation1);
      zz localzz = new zB().a(str3).b();
      Im.a(true).a(localzz).a(new Gx(this, localFragmentActivity, str1));
      return;
      str2 = "yaks";
      this.l = new ArrayList();
      continue;
      str2 = "getPeekMessages";
      localTreeMap.put("peekID", this.o.getString("peekID", ""));
      this.l = new ArrayList();
      this.m = new ArrayList();
    }
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
    if (this.b == true) {
      paramMenuInflater.inflate(2131755014, paramMenu);
    }
    for (;;)
    {
      ((MainActivity)getActivity()).c();
      return;
      paramMenuInflater.inflate(2131755019, paramMenu);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    String str1 = this.o.getString("peekID", "");
    if (Ik.a(str1))
    {
      this.v = Fn.b;
      this.j = "CustomPeek";
    }
    CG localCG;
    do
    {
      a();
      return localView;
      localCG = CV.b(str1);
    } while (localCG == null);
    Fn localFn;
    if (localCG.a.equals("Featured"))
    {
      localFn = Fn.a;
      label80:
      this.v = localFn;
      if (!localCG.a.equals("Featured")) {
        break label120;
      }
    }
    label120:
    for (String str2 = "FeaturedPeek";; str2 = "OtherPeek")
    {
      this.j = str2;
      break;
      localFn = Fn.b;
      break label80;
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     Gw

 * JD-Core Version:    0.7.0.1

 */