package com.google.android.gms.analytics;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import fA;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CampaignTrackingService
  extends IntentService
{
  public CampaignTrackingService()
  {
    super("CampaignIntentService");
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("referrer");
    try
    {
      FileOutputStream localFileOutputStream = paramContext.openFileOutput("gaInstallData", 0);
      localFileOutputStream.write(str.getBytes());
      localFileOutputStream.close();
      fA.c("Stored campaign information.");
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        fA.a("Error storing install campaign.");
      }
    }
  }
  
  public void onHandleIntent(Intent paramIntent)
  {
    a(this, paramIntent);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.CampaignTrackingService
 * JD-Core Version:    0.7.0.1
 */