import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.SurveyState;

public final class vx
  implements Parcelable.Creator<UpdateDisplayState.DisplayState.SurveyState>
{
  public UpdateDisplayState.DisplayState.SurveyState a(Parcel paramParcel)
  {
    Bundle localBundle = new Bundle(UpdateDisplayState.DisplayState.SurveyState.class.getClassLoader());
    localBundle.readFromParcel(paramParcel);
    return new UpdateDisplayState.DisplayState.SurveyState(localBundle, null);
  }
  
  public UpdateDisplayState.DisplayState.SurveyState[] a(int paramInt)
  {
    return new UpdateDisplayState.DisplayState.SurveyState[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vx
 * JD-Core Version:    0.7.0.1
 */