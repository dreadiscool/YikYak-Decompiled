import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.yik.yak.ui.activity.MainActivity;
import java.util.List;

class GB
  implements AdapterView.OnItemClickListener
{
  GB(Gz paramGz) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    CG localCG = (CG)Gz.b(this.a).get(paramInt);
    if (localCG.m)
    {
      localCG.m = false;
      CV.a(localCG);
      Gz.c(this.a).invalidateViews();
    }
    if ((localCG.a()) || (localCG.k)) {}
    for (;;)
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putString("userID", ApplicationConfig.getYakkerID());
      localBundle.putString("title", localCG.a);
      localBundle.putString("location", localCG.b);
      if (!localCG.j) {
        localBundle.putString("peekID", localCG.i);
      }
      localBundle.putBoolean("isCustom", localCG.j);
      localBundle.putBoolean("canSubmit", localCG.e);
      localBundle.putBoolean("canVote", localCG.f);
      localBundle.putBoolean("canReply", localCG.g);
      localBundle.putBoolean("canReport", localCG.h);
      localBundle.putString("peekLatitude", localCG.c);
      localBundle.putString("peekLongitude", localCG.d);
      ((MainActivity)this.a.getActivity()).a(localCG.b);
      If.a().a(localCG);
      Gw localGw = new Gw();
      localGw.setArguments(localBundle);
      FragmentTransaction localFragmentTransaction = Gz.a(this.a).beginTransaction();
      localFragmentTransaction.setTransition(4099);
      localFragmentTransaction.addToBackStack("fragment_peeklist");
      localFragmentTransaction.replace(2131558690, localGw, "fragment_peeklist.YakFragment");
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     GB

 * JD-Core Version:    0.7.0.1

 */