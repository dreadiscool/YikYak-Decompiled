package com.facebook.widget;

import android.os.Bundle;

public abstract interface FacebookDialog$Callback
{
  public abstract void onComplete(FacebookDialog.PendingCall paramPendingCall, Bundle paramBundle);
  
  public abstract void onError(FacebookDialog.PendingCall paramPendingCall, Exception paramException, Bundle paramBundle);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.FacebookDialog.Callback
 * JD-Core Version:    0.7.0.1
 */