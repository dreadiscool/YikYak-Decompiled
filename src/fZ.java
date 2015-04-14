import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.analytics.internal.Command;

public final class fZ
  implements Parcelable.Creator<Command>
{
  public Command a(Parcel paramParcel)
  {
    return new Command(paramParcel);
  }
  
  public Command[] a(int paramInt)
  {
    return new Command[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fZ
 * JD-Core Version:    0.7.0.1
 */