import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;

public final class vt
  implements Parcelable.Creator<UpdateDisplayState>
{
  public UpdateDisplayState a(Parcel paramParcel)
  {
    Bundle localBundle = new Bundle(UpdateDisplayState.class.getClassLoader());
    localBundle.readFromParcel(paramParcel);
    return new UpdateDisplayState(localBundle, null);
  }
  
  public UpdateDisplayState[] a(int paramInt)
  {
    return new UpdateDisplayState[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vt
 * JD-Core Version:    0.7.0.1
 */