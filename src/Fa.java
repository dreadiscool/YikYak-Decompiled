import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Fa
  extends Fragment
{
  protected String a = "";
  
  protected void a(Fragment paramFragment, String paramString)
  {
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    localFragmentTransaction.setTransition(4099);
    localFragmentTransaction.addToBackStack(paramString);
    localFragmentTransaction.replace(16908290, paramFragment, paramString);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    new StringBuilder().append(getClass().getName()).append(":").append(paramString1).toString();
  }
  
  public void b()
  {
    try
    {
      ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getActivity().findViewById(16908290).getRootView().getWindowToken(), 0);
      label32:
      return;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    if (!Ik.a(this.a)) {
      If.a().a(this.a);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Fa
 * JD-Core Version:    0.7.0.1
 */