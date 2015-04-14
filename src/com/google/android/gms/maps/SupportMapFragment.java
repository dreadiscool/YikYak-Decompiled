package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import jG;
import jW;
import jY;
import kg;
import km;
import md;

public class SupportMapFragment
  extends Fragment
{
  private final jY a = new jY(this);
  private jG b;
  
  protected km a()
  {
    this.a.g();
    if (this.a.a() == null) {}
    for (km localkm = null;; localkm = ((jW)this.a.a()).f()) {
      return localkm;
    }
  }
  
  @Deprecated
  public final jG b()
  {
    jG localjG = null;
    km localkm = a();
    if (localkm == null) {}
    for (;;)
    {
      return localjG;
      try
      {
        kg localkg = localkm.a();
        if (localkg == null) {
          continue;
        }
        if ((this.b == null) || (this.b.a().asBinder() != localkg.asBinder())) {
          this.b = new jG(localkg);
        }
        localjG = this.b;
      }
      catch (RemoteException localRemoteException)
      {
        throw new md(localRemoteException);
      }
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(SupportMapFragment.class.getClassLoader());
    }
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    jY.a(this.a, paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a.a(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.a.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    this.a.e();
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.a.d();
    super.onDestroyView();
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    jY.a(this.a, paramActivity);
    GoogleMapOptions localGoogleMapOptions = GoogleMapOptions.a(paramActivity, paramAttributeSet);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("MapOptions", localGoogleMapOptions);
    this.a.a(paramActivity, localBundle, paramBundle);
  }
  
  public void onLowMemory()
  {
    this.a.f();
    super.onLowMemory();
  }
  
  public void onPause()
  {
    this.a.c();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.a.b();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(SupportMapFragment.class.getClassLoader());
    }
    super.onSaveInstanceState(paramBundle);
    this.a.b(paramBundle);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.SupportMapFragment
 * JD-Core Version:    0.7.0.1
 */