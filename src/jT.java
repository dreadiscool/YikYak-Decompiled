import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class jT
  implements kI
{
  private final ViewGroup a;
  private final kB b;
  private View c;
  
  public jT(ViewGroup paramViewGroup, kB paramkB)
  {
    this.b = ((kB)hZ.a(paramkB));
    this.a = ((ViewGroup)hZ.a(paramViewGroup));
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
  }
  
  public void a()
  {
    try
    {
      this.b.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
  {
    throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
  }
  
  public void a(Bundle paramBundle)
  {
    try
    {
      this.b.a(paramBundle);
      this.c = ((View)gX.a(this.b.f()));
      this.a.removeAllViews();
      this.a.addView(this.c);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
  
  public void a(jR paramjR)
  {
    try
    {
      this.b.a(new jU(this, paramjR));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
  
  public void b()
  {
    try
    {
      this.b.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    try
    {
      this.b.b(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
  
  public void c()
  {
    throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
  }
  
  public void d()
  {
    try
    {
      this.b.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
  
  public void e()
  {
    try
    {
      this.b.e();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jT
 * JD-Core Version:    0.7.0.1
 */