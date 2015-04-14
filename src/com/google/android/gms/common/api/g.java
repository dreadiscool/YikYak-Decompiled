package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import hZ;

public class g
  extends Fragment
  implements DialogInterface.OnCancelListener, LoaderManager.LoaderCallbacks<ConnectionResult>
{
  private boolean KC;
  private int KD = -1;
  private ConnectionResult KE;
  private final Handler KF = new Handler(Looper.getMainLooper());
  private final SparseArray<g.b> KG = new SparseArray();
  
  public static g a(FragmentActivity paramFragmentActivity)
  {
    hZ.b("Must be called from main thread of process");
    FragmentManager localFragmentManager = paramFragmentActivity.getSupportFragmentManager();
    try
    {
      g localg = (g)localFragmentManager.findFragmentByTag("GmsSupportLifecycleFragment");
      if ((localg == null) || (localg.isRemoving()))
      {
        localg = new g();
        localFragmentManager.beginTransaction().add(localg, "GmsSupportLifecycleFragment").commit();
        localFragmentManager.executePendingTransactions();
      }
      return localg;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", localClassCastException);
    }
  }
  
  private void a(int paramInt, ConnectionResult paramConnectionResult)
  {
    if (!this.KC)
    {
      this.KC = true;
      this.KD = paramInt;
      this.KE = paramConnectionResult;
      this.KF.post(new g.c(this, paramInt, paramConnectionResult));
    }
  }
  
  private void aq(int paramInt)
  {
    if (paramInt == this.KD) {
      gR();
    }
  }
  
  private void b(int paramInt, ConnectionResult paramConnectionResult)
  {
    g.b localb = (g.b)this.KG.get(paramInt);
    if (localb != null)
    {
      ao(paramInt);
      GoogleApiClient.OnConnectionFailedListener localOnConnectionFailedListener = localb.KK;
      if (localOnConnectionFailedListener != null) {
        localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
      }
    }
    gR();
  }
  
  private void gR()
  {
    int i = 0;
    this.KC = false;
    this.KD = -1;
    this.KE = null;
    LoaderManager localLoaderManager = getLoaderManager();
    while (i < this.KG.size())
    {
      int j = this.KG.keyAt(i);
      g.a locala = ap(j);
      if (locala != null) {
        locala.gS();
      }
      localLoaderManager.initLoader(j, null, this);
      i++;
    }
  }
  
  public void a(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    hZ.a(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (this.KG.indexOfKey(paramInt) < 0) {}
    for (boolean bool = true;; bool = false)
    {
      hZ.a(bool, "Already managing a GoogleApiClient with id " + paramInt);
      g.b localb = new g.b(paramGoogleApiClient, paramOnConnectionFailedListener, null);
      this.KG.put(paramInt, localb);
      if (getActivity() != null) {
        getLoaderManager().initLoader(paramInt, null, this);
      }
      return;
    }
  }
  
  public void a(Loader<ConnectionResult> paramLoader, ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.isSuccess()) {
      aq(paramLoader.getId());
    }
    for (;;)
    {
      return;
      a(paramLoader.getId(), paramConnectionResult);
    }
  }
  
  public GoogleApiClient an(int paramInt)
  {
    g.a locala;
    if (getActivity() != null)
    {
      locala = ap(paramInt);
      if (locala == null) {}
    }
    for (GoogleApiClient localGoogleApiClient = locala.KH;; localGoogleApiClient = null) {
      return localGoogleApiClient;
    }
  }
  
  public void ao(int paramInt)
  {
    getLoaderManager().destroyLoader(paramInt);
    this.KG.remove(paramInt);
  }
  
  g.a ap(int paramInt)
  {
    try
    {
      g.a locala = (g.a)getLoaderManager().getLoader(paramInt);
      return locala;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new IllegalStateException("Unknown loader in SupportLifecycleFragment", localClassCastException);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    switch (paramInt1)
    {
    default: 
      i = 0;
      label31:
      if (i != 0) {
        gR();
      }
      break;
    }
    for (;;)
    {
      return;
      if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) != 0) {
        break;
      }
      break label31;
      if (paramInt2 != -1) {
        break;
      }
      break label31;
      b(this.KD, this.KE);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    int i = 0;
    if (i < this.KG.size())
    {
      int j = this.KG.keyAt(i);
      g.a locala = ap(j);
      if ((locala != null) && (((g.b)this.KG.valueAt(i)).KH != locala.KH)) {
        getLoaderManager().restartLoader(j, null, this);
      }
      for (;;)
      {
        i++;
        break;
        getLoaderManager().initLoader(j, null, this);
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    b(this.KD, this.KE);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.KC = paramBundle.getBoolean("resolving_error", false);
      this.KD = paramBundle.getInt("failed_client_id", -1);
      if (this.KD >= 0) {
        this.KE = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
      }
    }
  }
  
  public Loader<ConnectionResult> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new g.a(getActivity(), ((g.b)this.KG.get(paramInt)).KH);
  }
  
  public void onLoaderReset(Loader<ConnectionResult> paramLoader)
  {
    if (paramLoader.getId() == this.KD) {
      gR();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", this.KC);
    if (this.KD >= 0)
    {
      paramBundle.putInt("failed_client_id", this.KD);
      paramBundle.putInt("failed_status", this.KE.getErrorCode());
      paramBundle.putParcelable("failed_resolution", this.KE.getResolution());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (!this.KC) {
      for (int i = 0; i < this.KG.size(); i++) {
        getLoaderManager().initLoader(this.KG.keyAt(i), null, this);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.g
 * JD-Core Version:    0.7.0.1
 */