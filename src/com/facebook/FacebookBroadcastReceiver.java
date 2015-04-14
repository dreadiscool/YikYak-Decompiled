package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;

public class FacebookBroadcastReceiver
  extends BroadcastReceiver
{
  protected void onFailedAppCall(String paramString1, String paramString2, Bundle paramBundle) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
    String str2 = paramIntent.getStringExtra("com.facebook.platform.protocol.PROTOCOL_ACTION");
    Bundle localBundle;
    if ((str1 != null) && (str2 != null))
    {
      localBundle = paramIntent.getExtras();
      if (!NativeProtocol.isErrorResult(paramIntent)) {
        break label47;
      }
      onFailedAppCall(str1, str2, localBundle);
    }
    for (;;)
    {
      return;
      label47:
      onSuccessfulAppCall(str1, str2, localBundle);
    }
  }
  
  protected void onSuccessfulAppCall(String paramString1, String paramString2, Bundle paramBundle) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.FacebookBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */