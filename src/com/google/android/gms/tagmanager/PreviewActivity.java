package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import nK;
import nv;
import nw;

public class PreviewActivity
  extends Activity
{
  private void a(String paramString1, String paramString2, String paramString3)
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.setTitle(paramString1);
    localAlertDialog.setMessage(paramString2);
    localAlertDialog.setButton(-1, paramString3, new nv(this));
    localAlertDialog.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    try
    {
      super.onCreate(paramBundle);
      nK.c("Preview activity");
      Uri localUri = getIntent().getData();
      if (!nw.a(this).a(localUri))
      {
        String str = "Cannot preview the app with the uri: " + localUri + ". Launching current version instead.";
        nK.b(str);
        a("Preview failure", str, "Continue");
      }
      Intent localIntent = getPackageManager().getLaunchIntentForPackage(getPackageName());
      if (localIntent != null)
      {
        nK.c("Invoke the launch activity for package name: " + getPackageName());
        startActivity(localIntent);
      }
      else
      {
        nK.c("No launch activity found for package name: " + getPackageName());
      }
    }
    catch (Exception localException)
    {
      nK.a("Calling preview threw an exception: " + localException.getMessage());
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.PreviewActivity
 * JD-Core Version:    0.7.0.1
 */