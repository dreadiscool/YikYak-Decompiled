import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

class GE
  implements View.OnClickListener
{
  GE(GD paramGD) {}
  
  public void onClick(View paramView)
  {
    if (CV.f() != 0)
    {
      FV localFV = new FV();
      FragmentTransaction localFragmentTransaction = this.a.h.getFragmentManager().beginTransaction();
      localFragmentTransaction.setTransition(4099);
      localFragmentTransaction.addToBackStack("fragment_peeklist");
      localFragmentTransaction.replace(2131558690, localFV);
      localFragmentTransaction.commitAllowingStateLoss();
    }
    for (;;)
    {
      return;
      Toast.makeText(Gz.e(this.a.h), "You don't have any saved peeks to manage.", 0).show();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     GE
 * JD-Core Version:    0.7.0.1
 */