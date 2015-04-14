package com.google.android.gms.common.api;

import android.content.IntentSender.SendIntentException;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.List;

class g$c
  implements Runnable
{
  private final int KL;
  private final ConnectionResult KM;
  
  public g$c(g paramg, int paramInt, ConnectionResult paramConnectionResult)
  {
    this.KL = paramInt;
    this.KM = paramConnectionResult;
  }
  
  public void run()
  {
    if (this.KM.hasResolution()) {}
    for (;;)
    {
      try
      {
        int i = 1 + (1 + this.KN.getActivity().getSupportFragmentManager().getFragments().indexOf(this.KN) << 16);
        this.KM.startResolutionForResult(this.KN.getActivity(), i);
        return;
      }
      catch (IntentSender.SendIntentException localSendIntentException)
      {
        g.a(this.KN);
        continue;
      }
      if (GooglePlayServicesUtil.isUserRecoverableError(this.KM.getErrorCode())) {
        GooglePlayServicesUtil.showErrorDialogFragment(this.KM.getErrorCode(), this.KN.getActivity(), this.KN, 2, this.KN);
      } else {
        g.a(this.KN, this.KL, this.KM);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.g.c
 * JD-Core Version:    0.7.0.1
 */