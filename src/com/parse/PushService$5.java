package com.parse;

import java.util.Set;
import k;
import l;
import m;

class PushService$5
  implements l<Set<String>, Void>
{
  PushService$5(PushService paramPushService, k paramk, PushConnection paramPushConnection) {}
  
  public Void then(m<Set<String>> paramm)
  {
    Boolean localBoolean = (Boolean)this.val$forceEnabledCapture.a();
    boolean bool = ManifestInfo.getPushUsesBroadcastReceivers();
    Set localSet = (Set)paramm.e();
    String str;
    if (!bool)
    {
      if ((localSet == null) || (localSet.size() != 0)) {
        break label119;
      }
      str = "Not starting PushService because this device has no subscriptions";
    }
    for (;;)
    {
      if (str != null)
      {
        Parse.logI("com.parse.PushService", str);
        this.this$0.stopSelf();
      }
      for (;;)
      {
        return null;
        if (ParseInstallation.getCurrentInstallation().getObjectId() == null)
        {
          str = "Not starting PushService because this device is not registered for push notifications.";
          break;
        }
        if ((localBoolean == null) || (localBoolean.booleanValue())) {
          break label119;
        }
        str = "Not starting PushService because push has been manually disabled.";
        break;
        Parse.logD("com.parse.PushService", "Starting PushService.");
        this.val$conn.start();
      }
      label119:
      str = null;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushService.5
 * JD-Core Version:    0.7.0.1
 */