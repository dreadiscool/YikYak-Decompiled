package com.facebook;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

final class Settings$2
  implements Runnable
{
  Settings$2(Context paramContext, String paramString, Request.Callback paramCallback) {}
  
  public void run()
  {
    Response localResponse = Settings.publishInstallAndWaitForResponse(this.val$applicationContext, this.val$applicationId);
    if (this.val$callback != null) {
      new Handler(Looper.getMainLooper()).post(new Settings.2.1(this, localResponse));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Settings.2
 * JD-Core Version:    0.7.0.1
 */