import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.yik.yak.ui.activity.MainActivity;
import java.util.List;

class Gp
  implements AdapterView.OnItemClickListener
{
  Gp(Go paramGo) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    CH localCH = (CH)Go.a(this.a).get(paramInt);
    if (localCH.a()) {}
    for (;;)
    {
      label26:
      return;
      for (;;)
      {
        try
        {
          int j = Integer.parseInt(localCH.c);
          i = j;
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          try
          {
            ((MainActivity)this.a.getActivity()).a(localCH.b);
            switch (i)
            {
            case 5: 
            case 6: 
            case 8: 
            case 14: 
            case 15: 
            case 16: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            default: 
              if (Ik.a(localCH.d)) {
                break label26;
              }
              GS localGS11 = new GS();
              localGS11.a(localCH.b);
              localGS11.b(localCH.d);
              this.a.a(localGS11, "Web.Default");
            }
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            int i;
            Bundle localBundle;
            EX localEX;
            GS localGS10;
            Intent localIntent5;
            GH localGH;
            Intent localIntent4;
            GS localGS9;
            FB localFB;
            Intent localIntent3;
            GS localGS7;
            GS localGS8;
            Intent localIntent2;
            GS localGS5;
            GS localGS6;
            Intent localIntent1;
            GS localGS3;
            GS localGS4;
            GS localGS2;
            GS localGS1;
            break label251;
          }
          localNumberFormatException1 = localNumberFormatException1;
          i = 3;
        }
        label251:
        ((MainActivity)this.a.getActivity()).a("All-Time Greatest");
      }
      localBundle = new Bundle();
      localBundle.putBoolean("canSubmit", false);
      localBundle.putBoolean("canVote", false);
      localBundle.putBoolean("canReply", false);
      localBundle.putBoolean("canReport", false);
      localEX = new EX();
      localEX.a("GreatestScreen");
      localEX.a(Fn.b);
      localEX.setArguments(localBundle);
      this.a.a(localEX, "AreaTopYaks");
      continue;
      localGS10 = new GS();
      localGS10.a("OtherScreen");
      localGS10.b(localCH.d);
      this.a.a(localGS10, "Web.OtherYaks");
      continue;
      localIntent5 = new Intent("android.intent.action.DIAL");
      localIntent5.setData(Uri.parse("tel:18444689257"));
      this.a.startActivity(localIntent5);
      continue;
      localGH = new GH();
      localGH.a("RulesScreen");
      this.a.a(localGH, "Rules");
      continue;
      Iw.a(this.a.getActivity(), 2131231012, 2131231013);
      continue;
      localIntent4 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + Go.b(this.a).getPackageName()));
      if (Go.b(this.a).getPackageManager().queryIntentActivities(localIntent4, 0).size() > 0)
      {
        this.a.startActivity(localIntent4);
      }
      else
      {
        localGS9 = new GS();
        localGS9.b(localCH.d);
        this.a.a(localGS9, "Web.RateYikYak");
        continue;
        localFB = new FB();
        this.a.a(localFB, "ContactUs");
        continue;
        try
        {
          Go.b(this.a).getPackageManager().getPackageInfo("action", 0);
          localIntent3 = new Intent("android.intent.action.VIEW", Uri.parse("fb://profile/575262255856926"));
          if (Go.b(this.a).getPackageManager().queryIntentActivities(localIntent3, 0).size() <= 0) {
            break label714;
          }
          this.a.startActivity(localIntent3);
        }
        catch (Exception localException3)
        {
          localGS7 = new GS();
          localGS7.b(localCH.d);
          this.a.a(localGS7, "Web.Facebook");
        }
        continue;
        label714:
        localGS8 = new GS();
        localGS8.b(localCH.d);
        this.a.a(localGS8, "Web.Facebook");
        continue;
        try
        {
          localIntent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://twitter.com/yikyakapp"));
          if (Go.b(this.a).getPackageManager().queryIntentActivities(localIntent2, 0).size() <= 0) {
            break label834;
          }
          this.a.startActivity(localIntent2);
        }
        catch (Exception localException2)
        {
          localGS5 = new GS();
          localGS5.b(localCH.d);
          this.a.a(localGS5, "Web.Twitter");
        }
        continue;
        label834:
        localGS6 = new GS();
        localGS6.b(localCH.d);
        this.a.a(localGS6, "Web.Twitter");
        continue;
        try
        {
          localIntent1 = new Intent("android.intent.action.VIEW", Uri.parse("instagram://user?username=yikyakapp"));
          if (Go.b(this.a).getPackageManager().queryIntentActivities(localIntent1, 0).size() <= 0) {
            break label954;
          }
          this.a.startActivity(localIntent1);
        }
        catch (Exception localException1)
        {
          localGS3 = new GS();
          localGS3.b(localCH.d);
          this.a.a(localGS3, "Web.Instagram");
        }
        continue;
        label954:
        localGS4 = new GS();
        localGS4.b(localCH.d);
        this.a.a(localGS4, "Web.Instagram");
        continue;
        localGS2 = new GS();
        localGS2.a("TermsOfService");
        localGS2.b(localCH.d);
        this.a.a(localGS2, "Web.TermsOfService");
        continue;
        localGS1 = new GS();
        localGS1.a("PrivacyPolic");
        localGS1.b(localCH.d);
        this.a.a(localGS1, "Web.PrivacyPolicy");
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Gp
 * JD-Core Version:    0.7.0.1
 */