package com.google.tagmanager;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import rB;
import rK;

public class PreviewActivity
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    try
    {
      super.onCreate(paramBundle);
      rB.c("Preview activity");
      Uri localUri = getIntent().getData();
      if (!rK.a(this).a(localUri))
      {
        rB.b("Cannot preview the app with the uri: " + localUri);
      }
      else
      {
        Intent localIntent = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (localIntent != null)
        {
          rB.c("Invoke the launch activity for package name: " + getPackageName());
          startActivity(localIntent);
        }
      }
    }
    catch (Exception localException)
    {
      rB.a("Calling preview threw an exception: " + localException.getMessage());
    }
    rB.c("No launch activity found for package name: " + getPackageName());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.tagmanager.PreviewActivity
 * JD-Core Version:    0.7.0.1
 */