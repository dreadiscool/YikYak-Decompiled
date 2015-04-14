import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mixpanel.android.mpmetrics.InAppNotification;

public final class uE
  implements Parcelable.Creator<InAppNotification>
{
  public InAppNotification a(Parcel paramParcel)
  {
    return new InAppNotification(paramParcel);
  }
  
  public InAppNotification[] a(int paramInt)
  {
    return new InAppNotification[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     uE
 * JD-Core Version:    0.7.0.1
 */