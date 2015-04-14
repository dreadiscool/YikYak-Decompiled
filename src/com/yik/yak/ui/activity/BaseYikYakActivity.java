package com.yik.yak.ui.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.amplitude.api.Amplitude;
import com.facebook.AppEventsLogger;

public class BaseYikYakActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getResources().getBoolean(2131361800)) {
      setRequestedOrientation(1);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    Amplitude.endSession();
  }
  
  protected void onResume()
  {
    super.onResume();
    AppEventsLogger.activateApp(this, "1488368971408413");
    Amplitude.startSession();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.activity.BaseYikYakActivity
 * JD-Core Version:    0.7.0.1
 */