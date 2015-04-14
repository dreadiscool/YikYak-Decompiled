package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.lang.ref.WeakReference;

class c$a
  extends BroadcastReceiver
{
  private WeakReference<c> Ks;
  
  c$a(c paramc)
  {
    this.Ks = new WeakReference(paramc);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Uri localUri = paramIntent.getData();
    String str = null;
    if (localUri != null) {
      str = localUri.getSchemeSpecificPart();
    }
    if ((str == null) || (!str.equals("com.google.android.gms"))) {}
    for (;;)
    {
      return;
      c localc = (c)this.Ks.get();
      if ((localc != null) && (!localc.isConnected()) && (!localc.isConnecting()) && (localc.gL())) {
        localc.connect();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.c.a
 * JD-Core Version:    0.7.0.1
 */