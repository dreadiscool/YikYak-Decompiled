package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import jG;
import jJ;
import jL;
import kg;
import km;
import md;

public class MapFragment
  extends Fragment
{
  private final jL a = new jL(this);
  private jG b;
  
  protected km a()
  {
    this.a.g();
    if (this.a.a() == null) {}
    for (km localkm = null;; localkm = ((jJ)this.a.a()).f()) {
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
      paramBundle.setClassLoader(MapFragment.class.getClassLoader());
    }
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    jL.a(this.a, paramActivity);
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
    jL.a(this.a, paramActivity);
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
      paramBundle.setClassLoader(MapFragment.class.getClassLoader());
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
 * Qualified Name:     com.google.android.gms.maps.MapFragment
 * JD-Core Version:    0.7.0.1
 */