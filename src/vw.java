import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.InAppNotificationState;

public final class vw
  implements Parcelable.Creator<UpdateDisplayState.DisplayState.InAppNotificationState>
{
  public UpdateDisplayState.DisplayState.InAppNotificationState a(Parcel paramParcel)
  {
    Bundle localBundle = new Bundle(UpdateDisplayState.DisplayState.InAppNotificationState.class.getClassLoader());
    localBundle.readFromParcel(paramParcel);
    return new UpdateDisplayState.DisplayState.InAppNotificationState(localBundle, null);
  }
  
  public UpdateDisplayState.DisplayState.InAppNotificationState[] a(int paramInt)
  {
    return new UpdateDisplayState.DisplayState.InAppNotificationState[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vw
 * JD-Core Version:    0.7.0.1
 */