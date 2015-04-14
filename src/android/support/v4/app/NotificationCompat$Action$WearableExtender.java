package android.support.v4.app;

import android.os.Bundle;

public final class NotificationCompat$Action$WearableExtender
  implements NotificationCompat.Action.Extender
{
  private static final int DEFAULT_FLAGS = 1;
  private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
  private static final int FLAG_AVAILABLE_OFFLINE = 1;
  private static final String KEY_CANCEL_LABEL = "cancelLabel";
  private static final String KEY_CONFIRM_LABEL = "confirmLabel";
  private static final String KEY_FLAGS = "flags";
  private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
  private CharSequence mCancelLabel;
  private CharSequence mConfirmLabel;
  private int mFlags = 1;
  private CharSequence mInProgressLabel;
  
  public NotificationCompat$Action$WearableExtender() {}
  
  public NotificationCompat$Action$WearableExtender(NotificationCompat.Action paramAction)
  {
    Bundle localBundle = paramAction.getExtras().getBundle("android.wearable.EXTENSIONS");
    if (localBundle != null)
    {
      this.mFlags = localBundle.getInt("flags", 1);
      this.mInProgressLabel = localBundle.getCharSequence("inProgressLabel");
      this.mConfirmLabel = localBundle.getCharSequence("confirmLabel");
      this.mCancelLabel = localBundle.getCharSequence("cancelLabel");
    }
  }
  
  private void setFlag(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.mFlags = (paramInt | this.mFlags);; this.mFlags &= (paramInt ^ 0xFFFFFFFF)) {
      return;
    }
  }
  
  public WearableExtender clone()
  {
    WearableExtender localWearableExtender = new WearableExtender();
    localWearableExtender.mFlags = this.mFlags;
    localWearableExtender.mInProgressLabel = this.mInProgressLabel;
    localWearableExtender.mConfirmLabel = this.mConfirmLabel;
    localWearableExtender.mCancelLabel = this.mCancelLabel;
    return localWearableExtender;
  }
  
  public NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder paramBuilder)
  {
    Bundle localBundle = new Bundle();
    if (this.mFlags != 1) {
      localBundle.putInt("flags", this.mFlags);
    }
    if (this.mInProgressLabel != null) {
      localBundle.putCharSequence("inProgressLabel", this.mInProgressLabel);
    }
    if (this.mConfirmLabel != null) {
      localBundle.putCharSequence("confirmLabel", this.mConfirmLabel);
    }
    if (this.mCancelLabel != null) {
      localBundle.putCharSequence("cancelLabel", this.mCancelLabel);
    }
    paramBuilder.getExtras().putBundle("android.wearable.EXTENSIONS", localBundle);
    return paramBuilder;
  }
  
  public CharSequence getCancelLabel()
  {
    return this.mCancelLabel;
  }
  
  public CharSequence getConfirmLabel()
  {
    return this.mConfirmLabel;
  }
  
  public CharSequence getInProgressLabel()
  {
    return this.mInProgressLabel;
  }
  
  public boolean isAvailableOffline()
  {
    if ((0x1 & this.mFlags) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public WearableExtender setAvailableOffline(boolean paramBoolean)
  {
    setFlag(1, paramBoolean);
    return this;
  }
  
  public WearableExtender setCancelLabel(CharSequence paramCharSequence)
  {
    this.mCancelLabel = paramCharSequence;
    return this;
  }
  
  public WearableExtender setConfirmLabel(CharSequence paramCharSequence)
  {
    this.mConfirmLabel = paramCharSequence;
    return this;
  }
  
  public WearableExtender setInProgressLabel(CharSequence paramCharSequence)
  {
    this.mInProgressLabel = paramCharSequence;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.Action.WearableExtender
 * JD-Core Version:    0.7.0.1
 */