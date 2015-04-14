package com.mixpanel.android.mpmetrics;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import vw;

public final class UpdateDisplayState$DisplayState$InAppNotificationState
  extends UpdateDisplayState.DisplayState
{
  public static final Parcelable.Creator<InAppNotificationState> CREATOR = new vw();
  private static String c = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.INAPP_KEY";
  private static String d = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.HIGHLIGHT_KEY";
  private final InAppNotification a;
  private final int b;
  
  private UpdateDisplayState$DisplayState$InAppNotificationState(Bundle paramBundle)
  {
    super(null);
    this.a = ((InAppNotification)paramBundle.getParcelable(c));
    this.b = paramBundle.getInt(d);
  }
  
  public UpdateDisplayState$DisplayState$InAppNotificationState(InAppNotification paramInAppNotification, int paramInt)
  {
    super(null);
    this.a = paramInAppNotification;
    this.b = paramInt;
  }
  
  public String a()
  {
    return "InAppNotificationState";
  }
  
  public int b()
  {
    return this.b;
  }
  
  public InAppNotification c()
  {
    return this.a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable(c, this.a);
    localBundle.putInt(d, this.b);
    paramParcel.writeBundle(localBundle);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.InAppNotificationState
 * JD-Core Version:    0.7.0.1
 */