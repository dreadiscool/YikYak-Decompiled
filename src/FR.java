import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.yik.yak.YikYak;
import com.yik.yak.data.models.YakkerLocation;
import com.yik.yak.ui.activity.MainActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FR
  extends Fb
{
  private final FU F = new FU(this);
  private final String G = "HomeFragment";
  private Menu H;
  
  public void a()
  {
    g();
    CR.b("photosEnabled", false);
    CR.b("linksEnabled", false);
    FragmentActivity localFragmentActivity = getActivity();
    CM localCM = CM.a(localFragmentActivity);
    YakkerLocation localYakkerLocation = localCM.f();
    this.h = false;
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("userID", ApplicationConfig.getYakkerID());
    localTreeMap.put("lat", localYakkerLocation.getLatitude());
    localTreeMap.put("long", localYakkerLocation.getLongitude());
    String str1;
    if (this.v == Fn.b)
    {
      str1 = "hot";
      this.m = new ArrayList();
    }
    for (;;)
    {
      this.i = false;
      String str2 = Im.a(str1, localTreeMap, localYakkerLocation);
      zz localzz = new zB().a(str2).b();
      Im.a(true).a(localzz).a(new FS(this, localYakkerLocation, localCM, localFragmentActivity));
      return;
      str1 = "getMessages";
      this.l = new ArrayList();
    }
  }
  
  public void i()
  {
    YakkerLocation localYakkerLocation = CM.a(this.r).f();
    CZ.a(this.r, "https://content.yikyakapi.net/refreshers/locate?latitude=" + localYakkerLocation.c() + "&longitude=" + localYakkerLocation.d() + "&device=android&version=" + YikYak.getVersion());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      do
      {
        for (;;)
        {
          return;
          if (paramInt2 == 1) {
            a();
          }
          if (paramInt2 == 1)
          {
            Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.r.getPackageName()));
            if (this.r.getPackageManager().queryIntentActivities(localIntent, 0).size() > 0)
            {
              startActivity(localIntent);
            }
            else
            {
              GS localGS = new GS();
              localGS.b("https://play.google.com/store/apps/details?id=com.yik.yak");
              a(localGS, "Web.RateYikYak");
            }
          }
        }
        if (paramInt2 != 1) {
          break;
        }
      } while (paramIntent == null);
      String str = paramIntent.getStringExtra("peekID");
      if (!Ik.a(str))
      {
        CG localCG = CV.c(str);
        if (localCG != null)
        {
          ((MainActivity)getActivity()).b(localCG.b);
          CM.a(this.r).b(localCG.c, localCG.d);
          a();
        }
      }
    }
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
    paramMenuInflater.inflate(2131755013, paramMenu);
    this.H = paramMenu;
    ((MainActivity)getActivity()).c();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.j = "MainFeed";
    a();
    return localView;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getGroupId() == 100000)
    {
      paramMenuItem.getItemId();
      i();
    }
    for (boolean bool = true;; bool = super.onOptionsItemSelected(paramMenuItem)) {
      return bool;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    CV.a("HomeFragment");
  }
  
  public void onResume()
  {
    super.onResume();
    CV.a("HomeFragment", this.F);
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     FR

 * JD-Core Version:    0.7.0.1

 */