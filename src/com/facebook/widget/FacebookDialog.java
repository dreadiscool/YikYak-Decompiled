package com.facebook.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.AppEventsLogger;
import com.facebook.FacebookException;
import com.facebook.NativeAppCallAttachmentStore;
import com.facebook.Settings;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.DialogFeatureConfig;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;

public class FacebookDialog
{
  public static final String COMPLETION_GESTURE_CANCEL = "cancel";
  private static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
  private static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
  private static final String EXTRA_DIALOG_COMPLETION_ID_KEY = "com.facebook.platform.extra.POST_ID";
  public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";
  public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";
  public static final String RESULT_ARGS_DIALOG_COMPLETION_ID_KEY = "postId";
  private static NativeAppCallAttachmentStore attachmentStore;
  private Activity activity;
  private FacebookDialog.PendingCall appCall;
  private Fragment fragment;
  private FacebookDialog.OnPresentCallback onPresentCallback;
  
  private FacebookDialog(Activity paramActivity, Fragment paramFragment, FacebookDialog.PendingCall paramPendingCall, FacebookDialog.OnPresentCallback paramOnPresentCallback)
  {
    this.activity = paramActivity;
    this.fragment = paramFragment;
    this.appCall = paramPendingCall;
    this.onPresentCallback = paramOnPresentCallback;
  }
  
  public static boolean canPresentMessageDialog(Context paramContext, FacebookDialog.MessageDialogFeature... paramVarArgs)
  {
    return handleCanPresent(paramContext, EnumSet.of(FacebookDialog.MessageDialogFeature.MESSAGE_DIALOG, paramVarArgs));
  }
  
  public static boolean canPresentOpenGraphActionDialog(Context paramContext, FacebookDialog.OpenGraphActionDialogFeature... paramVarArgs)
  {
    return handleCanPresent(paramContext, EnumSet.of(FacebookDialog.OpenGraphActionDialogFeature.OG_ACTION_DIALOG, paramVarArgs));
  }
  
  public static boolean canPresentOpenGraphMessageDialog(Context paramContext, FacebookDialog.OpenGraphMessageDialogFeature... paramVarArgs)
  {
    return handleCanPresent(paramContext, EnumSet.of(FacebookDialog.OpenGraphMessageDialogFeature.OG_MESSAGE_DIALOG, paramVarArgs));
  }
  
  public static boolean canPresentShareDialog(Context paramContext, FacebookDialog.ShareDialogFeature... paramVarArgs)
  {
    return handleCanPresent(paramContext, EnumSet.of(FacebookDialog.ShareDialogFeature.SHARE_DIALOG, paramVarArgs));
  }
  
  private static String getActionForFeatures(Iterable<? extends FacebookDialog.DialogFeature> paramIterable)
  {
    String str = null;
    Iterator localIterator = paramIterable.iterator();
    if (localIterator.hasNext()) {
      str = ((FacebookDialog.DialogFeature)localIterator.next()).getAction();
    }
    return str;
  }
  
  private static NativeAppCallAttachmentStore getAttachmentStore()
  {
    if (attachmentStore == null) {
      attachmentStore = new NativeAppCallAttachmentStore();
    }
    return attachmentStore;
  }
  
  private static String getEventName(Intent paramIntent)
  {
    boolean bool1 = true;
    String str1 = paramIntent.getStringExtra("com.facebook.platform.protocol.PROTOCOL_ACTION");
    boolean bool2 = paramIntent.hasExtra("com.facebook.platform.extra.PHOTOS");
    Bundle localBundle = paramIntent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
    boolean bool3;
    if (localBundle != null)
    {
      ArrayList localArrayList = localBundle.getStringArrayList("PHOTOS");
      String str2 = localBundle.getString("VIDEO");
      if ((localArrayList != null) && (!localArrayList.isEmpty())) {
        bool2 = bool1;
      }
      if ((str2 != null) && (!str2.isEmpty())) {
        bool3 = bool2;
      }
    }
    for (;;)
    {
      return getEventName(str1, bool3, bool1);
      bool1 = false;
      bool3 = bool2;
      continue;
      bool1 = false;
      bool3 = bool2;
    }
  }
  
  private static String getEventName(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if (paramString.equals("com.facebook.platform.action.request.FEED_DIALOG")) {
      if (paramBoolean2) {
        str = "fb_dialogs_present_share_video";
      }
    }
    for (;;)
    {
      return str;
      if (paramBoolean1)
      {
        str = "fb_dialogs_present_share_photo";
      }
      else
      {
        str = "fb_dialogs_present_share";
        continue;
        if (paramString.equals("com.facebook.platform.action.request.MESSAGE_DIALOG"))
        {
          if (paramBoolean1) {
            str = "fb_dialogs_present_message_photo";
          } else {
            str = "fb_dialogs_present_message";
          }
        }
        else if (paramString.equals("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG"))
        {
          str = "fb_dialogs_present_share_og";
        }
        else if (paramString.equals("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG"))
        {
          str = "fb_dialogs_present_message_og";
        }
        else
        {
          if (!paramString.equals("com.facebook.platform.action.request.LIKE_DIALOG")) {
            break;
          }
          str = "fb_dialogs_present_like";
        }
      }
    }
    throw new FacebookException("An unspecified action was presented");
  }
  
  public static String getNativeDialogCompletionGesture(Bundle paramBundle)
  {
    if (paramBundle.containsKey("completionGesture")) {}
    for (String str = paramBundle.getString("completionGesture");; str = paramBundle.getString("com.facebook.platform.extra.COMPLETION_GESTURE")) {
      return str;
    }
  }
  
  public static boolean getNativeDialogDidComplete(Bundle paramBundle)
  {
    if (paramBundle.containsKey("didComplete")) {}
    for (boolean bool = paramBundle.getBoolean("didComplete");; bool = paramBundle.getBoolean("com.facebook.platform.extra.DID_COMPLETE", false)) {
      return bool;
    }
  }
  
  public static String getNativeDialogPostId(Bundle paramBundle)
  {
    if (paramBundle.containsKey("postId")) {}
    for (String str = paramBundle.getString("postId");; str = paramBundle.getString("com.facebook.platform.extra.POST_ID")) {
      return str;
    }
  }
  
  private static int getProtocolVersionForNativeDialog(Context paramContext, String paramString, int[] paramArrayOfInt)
  {
    return NativeProtocol.getLatestAvailableProtocolVersionForAction(paramContext, paramString, paramArrayOfInt);
  }
  
  private static int[] getVersionSpecForFeature(String paramString1, String paramString2, FacebookDialog.DialogFeature paramDialogFeature)
  {
    Utility.DialogFeatureConfig localDialogFeatureConfig = Utility.getDialogFeatureConfig(paramString1, paramString2, paramDialogFeature.name());
    int[] arrayOfInt;
    if (localDialogFeatureConfig != null) {
      arrayOfInt = localDialogFeatureConfig.getVersionSpec();
    }
    for (;;)
    {
      return arrayOfInt;
      arrayOfInt = new int[1];
      arrayOfInt[0] = paramDialogFeature.getMinVersion();
    }
  }
  
  private static int[] getVersionSpecForFeatures(String paramString1, String paramString2, Iterable<? extends FacebookDialog.DialogFeature> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    for (int[] arrayOfInt = null; localIterator.hasNext(); arrayOfInt = Utility.intersectRanges(arrayOfInt, getVersionSpecForFeature(paramString1, paramString2, (FacebookDialog.DialogFeature)localIterator.next()))) {}
    return arrayOfInt;
  }
  
  public static boolean handleActivityResult(Context paramContext, FacebookDialog.PendingCall paramPendingCall, int paramInt, Intent paramIntent, FacebookDialog.Callback paramCallback)
  {
    boolean bool;
    if (paramInt != paramPendingCall.getRequestCode())
    {
      bool = false;
      return bool;
    }
    if (attachmentStore != null) {
      attachmentStore.cleanupAttachmentsForCall(paramContext, paramPendingCall.getCallId());
    }
    if (paramCallback != null)
    {
      if (!NativeProtocol.isErrorResult(paramIntent)) {
        break label70;
      }
      Bundle localBundle = NativeProtocol.getErrorDataFromResultIntent(paramIntent);
      paramCallback.onError(paramPendingCall, NativeProtocol.getExceptionFromErrorData(localBundle), localBundle);
    }
    for (;;)
    {
      bool = true;
      break;
      label70:
      paramCallback.onComplete(paramPendingCall, NativeProtocol.getSuccessResultsFromIntent(paramIntent));
    }
  }
  
  private static boolean handleCanPresent(Context paramContext, Iterable<? extends FacebookDialog.DialogFeature> paramIterable)
  {
    String str1 = getActionForFeatures(paramIterable);
    String str2 = Settings.getApplicationId();
    if (Utility.isNullOrEmpty(str2)) {
      str2 = Utility.getMetadataApplicationId(paramContext);
    }
    if (getProtocolVersionForNativeDialog(paramContext, str1, getVersionSpecForFeatures(str2, str1, paramIterable)) != -1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static void logDialogActivity(Activity paramActivity, Fragment paramFragment, String paramString1, String paramString2)
  {
    if (paramFragment != null) {
      paramActivity = paramFragment.getActivity();
    }
    AppEventsLogger localAppEventsLogger = AppEventsLogger.newLogger(paramActivity);
    Bundle localBundle = new Bundle();
    localBundle.putString("fb_dialog_outcome", paramString2);
    localAppEventsLogger.logSdkEvent(paramString1, null, localBundle);
  }
  
  public FacebookDialog.PendingCall present()
  {
    logDialogActivity(this.activity, this.fragment, getEventName(this.appCall.getRequestIntent()), "Completed");
    if (this.onPresentCallback != null) {}
    for (;;)
    {
      try
      {
        this.onPresentCallback.onPresent(this.activity);
        if (this.fragment != null)
        {
          this.fragment.startActivityForResult(this.appCall.getRequestIntent(), this.appCall.getRequestCode());
          return this.appCall;
        }
      }
      catch (Exception localException)
      {
        throw new FacebookException(localException);
      }
      this.activity.startActivityForResult(this.appCall.getRequestIntent(), this.appCall.getRequestCode());
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.FacebookDialog
 * JD-Core Version:    0.7.0.1
 */