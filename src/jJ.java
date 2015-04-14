import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.GoogleMapOptions;

public class jJ
  implements kH
{
  private final Fragment a;
  private final km b;
  
  public jJ(Fragment paramFragment, km paramkm)
  {
    this.b = ((km)hZ.a(paramkm));
    this.a = ((Fragment)hZ.a(paramFragment));
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    try
    {
      gU localgU = this.b.a(gX.a(paramLayoutInflater), gX.a(paramViewGroup), paramBundle);
      return (View)gX.a(localgU);
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
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
    GoogleMapOptions localGoogleMapOptions = (GoogleMapOptions)paramBundle1.getParcelable("MapOptions");
    try
    {
      this.b.a(gX.a(paramActivity), localGoogleMapOptions, paramBundle2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    try
    {
      paramBundle = new Bundle();
      Bundle localBundle = this.a.getArguments();
      if ((localBundle != null) && (localBundle.containsKey("MapOptions"))) {
        lW.a(paramBundle, "MapOptions", localBundle.getParcelable("MapOptions"));
      }
      this.b.a(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
  
  public void a(jQ paramjQ)
  {
    try
    {
      this.b.a(new jK(this, paramjQ));
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
  
  public void d()
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
  
  public void e()
  {
    try
    {
      this.b.f();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
  
  public km f()
  {
    return this.b;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jJ
 * JD-Core Version:    0.7.0.1
 */