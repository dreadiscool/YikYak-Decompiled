import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.InAppNotificationState;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.SurveyState;

public final class vv
  implements Parcelable.Creator<UpdateDisplayState.DisplayState>
{
  public UpdateDisplayState.DisplayState a(Parcel paramParcel)
  {
    Bundle localBundle1 = new Bundle(UpdateDisplayState.DisplayState.class.getClassLoader());
    localBundle1.readFromParcel(paramParcel);
    String str = localBundle1.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_TYPE_KEY");
    Bundle localBundle2 = localBundle1.getBundle("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_IMPL_KEY");
    if ("InAppNotificationState".equals(str)) {}
    for (Object localObject = new UpdateDisplayState.DisplayState.InAppNotificationState(localBundle2, null);; localObject = new UpdateDisplayState.DisplayState.SurveyState(localBundle2, null))
    {
      return localObject;
      if (!"SurveyState".equals(str)) {
        break;
      }
    }
    throw new RuntimeException("Unrecognized display state type " + str);
  }
  
  public UpdateDisplayState.DisplayState[] a(int paramInt)
  {
    return new UpdateDisplayState.DisplayState[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vv
 * JD-Core Version:    0.7.0.1
 */