package com.google.android.gms.common;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class GooglePlayServicesUtil$a
  extends Handler
{
  private final Context mO;
  
  GooglePlayServicesUtil$a(Context paramContext) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      new StringBuilder().append("Don't know how to handle this message: ").append(paramMessage.what).toString();
    }
    for (;;)
    {
      return;
      int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mO);
      if (GooglePlayServicesUtil.isUserRecoverableError(i)) {
        GooglePlayServicesUtil.b(i, this.mO);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesUtil.a
 * JD-Core Version:    0.7.0.1
 */