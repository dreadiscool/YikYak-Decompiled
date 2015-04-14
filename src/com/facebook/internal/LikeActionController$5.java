package com.facebook.internal;

import android.os.Bundle;
import com.facebook.AppEventsLogger;
import com.facebook.LoggingBehavior;
import com.facebook.widget.FacebookDialog.Callback;
import com.facebook.widget.FacebookDialog.PendingCall;
import java.util.UUID;

class LikeActionController$5
  implements FacebookDialog.Callback
{
  LikeActionController$5(LikeActionController paramLikeActionController, Bundle paramBundle) {}
  
  public void onComplete(FacebookDialog.PendingCall paramPendingCall, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("object_is_liked"))) {
      return;
    }
    boolean bool = paramBundle.getBoolean("object_is_liked");
    Object localObject1 = LikeActionController.access$900(this.this$0);
    String str1 = LikeActionController.access$1000(this.this$0);
    if (paramBundle.containsKey("like_count_string"))
    {
      str1 = paramBundle.getString("like_count_string");
      localObject1 = str1;
    }
    Object localObject2 = LikeActionController.access$1100(this.this$0);
    String str2 = LikeActionController.access$1200(this.this$0);
    if (paramBundle.containsKey("social_sentence"))
    {
      str2 = paramBundle.getString("social_sentence");
      localObject2 = str2;
    }
    String str3;
    if (paramBundle.containsKey("object_is_liked"))
    {
      str3 = paramBundle.getString("unlike_token");
      label116:
      if (this.val$analyticsParameters != null) {
        break label194;
      }
    }
    label194:
    for (Bundle localBundle = new Bundle();; localBundle = this.val$analyticsParameters)
    {
      localBundle.putString("call_id", paramPendingCall.getCallId().toString());
      LikeActionController.access$1400(this.this$0).logSdkEvent("fb_like_control_dialog_did_succeed", null, localBundle);
      LikeActionController.access$1500(this.this$0, bool, (String)localObject1, str1, (String)localObject2, str2, str3);
      break;
      str3 = LikeActionController.access$1300(this.this$0);
      break label116;
    }
  }
  
  public void onError(FacebookDialog.PendingCall paramPendingCall, Exception paramException, Bundle paramBundle)
  {
    LoggingBehavior localLoggingBehavior = LoggingBehavior.REQUESTS;
    String str = LikeActionController.access$1600();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramException;
    Logger.log(localLoggingBehavior, str, "Like Dialog failed with error : %s", arrayOfObject);
    if (this.val$analyticsParameters == null) {}
    for (Bundle localBundle = new Bundle();; localBundle = this.val$analyticsParameters)
    {
      localBundle.putString("call_id", paramPendingCall.getCallId().toString());
      LikeActionController.access$1700(this.this$0, "present_dialog", localBundle);
      LikeActionController.access$1800(this.this$0, "com.facebook.sdk.LikeActionController.DID_ERROR", paramBundle);
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.5
 * JD-Core Version:    0.7.0.1
 */